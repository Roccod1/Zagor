package it.servizidigitali.gestionepagamenti.mypay.client;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import javax.xml.namespace.QName;

import org.apache.axis.Handler;
import org.apache.axis.SimpleChain;
import org.apache.axis.SimpleTargetedChain;
import org.apache.axis.client.AxisClient;
import org.apache.axis.configuration.SimpleProvider;
import org.apache.axis.transport.http.HTTPSender;
import org.apache.axis.transport.http.HTTPTransport;
import org.apache.xmlbeans.XmlOptions;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.gov.agenziaentrate.x2014.marcaDaBollo.MarcaDaBolloDocument;
import it.gov.agenziaentrate.x2014.marcaDaBollo.MarcaDaBolloDocument.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.integration.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.exception.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.Dovuto;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.VerificaPagamentoRisposta;
import it.servizidigitali.gestionepagamenti.mypay.converter.MyPayConverter;
import it.servizidigitali.gestionepagamenti.mypay.handler.LogHandler;
import it.servizidigitali.gestionepagamenti.mypay.handler.PaaSILChiediPagatiConRicevutaHandler;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtAllegatoRicevuta;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDatiSingoloPagamentoPagatiConRicevuta;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDatiVersamentoPagatiConRicevuta;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDovuti;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtPagatiConRicevuta;
import it.veneto.regione.schemas.x2012.pagamenti.ente.PagatiConRicevutaDocument;
import it.veneto.regione.schemas.x2012.pagamenti.ente.StCodiceEsitoPagamento.Enum;
import it.veneto.regione.schemas.x2012.pagamenti.ente.StTipoAllegatoRicevuta;
import it.veneto.regione.www.pagamenti.ente.FaultBean;
import it.veneto.regione.www.pagamenti.ente.PaaSILChiediPagatiConRicevutaRisposta;
import it.veneto.regione.www.pagamenti.ente.PaaSILInviaDovuti;
import it.veneto.regione.www.pagamenti.ente.PaaSILInviaDovutiRisposta;
import it.veneto.regione.www.pagamenti.ente.PagamentiTelematiciDovutiPagati.PagamentiTelematiciDovutiPagati;
import it.veneto.regione.www.pagamenti.ente.PagamentiTelematiciDovutiPagati.PagamentiTelematiciDovutiPagatiServiceLocator;
import it.veneto.regione.www.pagamenti.ente.ppthead.IntestazionePPT;

/**
 * @author pindi
 *
 */
@Component(name = "myPayPagamentiClient", service = PagamentiClient.class, immediate = true)
public class MyPayPagamentiClient implements PagamentiClient {

	private static final Log log = LogFactoryUtil.getLog(MyPayPagamentiClient.class.getName());

	@Reference
	private MyPayConverter myPayConverter;

	@Override
	public PagamentoDovutoRisposta pagaDovuto(Dovuto dovuto, String username, String password, String wsdlUrl, String rispostaPagamentoUrl) throws PagamentiClientException {

		PagamentiTelematiciDovutiPagati pagamentiServicePort = null;
		try {
			pagamentiServicePort = getMyPayPort(wsdlUrl);
		}
		catch (Exception e) {
			log.error("Errore nella lettura del wsdl.", e);
			throw new PagamentiClientException("Errore nella lettura del wsdl.", e);
		}

		IntestazionePPT header = new IntestazionePPT();
		header.setCodIpaEnte(username);

		PaaSILInviaDovuti bodyrichiesta = new PaaSILInviaDovuti();
		bodyrichiesta.setPassword(password);
		bodyrichiesta.setEnteSILInviaRispostaPagamentoUrl(rispostaPagamentoUrl);

		try {
			CtDovuti dovuti = myPayConverter.generaCtDovuti(dovuto);
			XmlOptions opts = new XmlOptions();
			opts.setSavePrettyPrint();
			opts.setSaveSyntheticDocumentElement(new QName("http://www.regione.veneto.it/schemas/2012/Pagamenti/Ente/", "Dovuti"));
			String xmlText = dovuti.xmlText(opts);
			bodyrichiesta.setDovuti(xmlText.getBytes());
		}
		catch (Exception ex) {
			log.error("Errore nella serializzazione dei dovuti.", ex);
			throw new PagamentiClientException("Errore nella serializzazione dei dovuti.", ex);
		}

		PaaSILInviaDovutiRisposta paaSILInviaDovuti;
		try {
			paaSILInviaDovuti = pagamentiServicePort.paaSILInviaDovuti(bodyrichiesta, header);
		}
		catch (Exception e) {
			log.error("paaSILInviaDovuti :: " + e.getMessage(), e);
			throw new PagamentiClientException("paaSILInviaDovuti :: " + e.getMessage(), e);
		}

		if ((paaSILInviaDovuti.getEsito() != null) && paaSILInviaDovuti.getEsito().equalsIgnoreCase("OK")) {
			PagamentoDovutoRisposta invioPagamentoRisposta = new PagamentoDovutoRisposta();
			invioPagamentoRisposta.setIdSessione(paaSILInviaDovuti.getIdSession());
			invioPagamentoRisposta.setRedirectUrl(paaSILInviaDovuti.getUrl());
			return invioPagamentoRisposta;
		}
		else if (paaSILInviaDovuti.getFault() != null) {
			log.error(paaSILInviaDovuti.getFault().getFaultCode() + " " + paaSILInviaDovuti.getFault().getFaultString());
			throw new PagamentiClientException(paaSILInviaDovuti.getFault().getFaultCode(), paaSILInviaDovuti.getFault().getFaultString());
		}
		else {
			log.error("Errore durante la chiamata al WS per l'invio dei dovuti.");
			throw new PagamentiClientException("Errore durante la chiamata al WS per l'invio dei dovuti.");
		}
	}

	@Override
	public VerificaPagamentoRisposta verificaPagamento(String idSessione, String iuv, String iud, String username, String password, String wsdlUrl) throws PagamentiClientException {

		PagamentiTelematiciDovutiPagati pagamentiServicePort = null;

		try {
			pagamentiServicePort = getPaaSILChiediPagatiConRicevutaMyPayPort(wsdlUrl);
		}
		catch (Exception e) {
			log.error("Errore nella lettura del wsdl.", e);
			throw new PagamentiClientException("Errore nella lettura del wsdl.", e);
		}

		VerificaPagamentoRisposta verificaPagamentoRisposta = new VerificaPagamentoRisposta();

		if (idSessione != null) {
			iuv = null;
			iud = null;
		}

		PaaSILChiediPagatiConRicevutaRisposta chiediPagatiResp = null;
		try {
			chiediPagatiResp = pagamentiServicePort.paaSILChiediPagatiConRicevuta(username, password, idSessione, iuv, iud);
		}
		catch (Exception ex) {
			throw new PagamentiClientException("Errore durate la chiamata al servizio " + "per richiedere lo stato dei pagati", ex);
		}

		FaultBean fault = chiediPagatiResp.getFault();
		if (fault != null) {
			verificaPagamentoRisposta.setCodiceErrore(fault.getFaultCode());
			verificaPagamentoRisposta.setDescrizioneErrore(fault.getFaultString());
			StatoPagamento statoPagamento;
			if (fault.getFaultCode().equals("PAA_PAGAMENTO_ANNULLATO")) {
				statoPagamento = StatoPagamento.ANNULLATO;
			}
			else if (fault.getFaultCode().equals("PAA_PAGAMENTO_SCADUTO")) {
				statoPagamento = StatoPagamento.SCADUTO;
			}
			else if (fault.getFaultCode().equals("PAA_PAGAMENTO_IN_CORSO")) {
				statoPagamento = StatoPagamento.IN_CORSO;
			}
			else if (fault.getFaultCode().equals("PAA_PAGAMENTO_NON_INIZIATO")) {
				statoPagamento = StatoPagamento.NON_INIZIATO;
			}
			else {
				statoPagamento = StatoPagamento.ERRORE;
			}
			verificaPagamentoRisposta.setStatoPagamento(statoPagamento);
		}
		else {

			InputStream rtInputStream = null;
			if (chiediPagatiResp.getRt() == null) {
				log.warn("Errore durante la lettura della RT per iuv " + iuv + " : rt e' null");
			}
			else {
				rtInputStream = new ByteArrayInputStream(chiediPagatiResp.getRt());
				verificaPagamentoRisposta.setRicevutaPagamento(rtInputStream);
			}

			byte[] pagatiBytes = chiediPagatiResp.getPagati();
			if (pagatiBytes != null) {
				ByteArrayInputStream pagatiInputStream = null;
				try {
					byte[] pagati = Base64.getDecoder().decode(pagatiBytes);
					if (pagati != null) {
						pagatiInputStream = new ByteArrayInputStream(pagati);
						if (pagatiInputStream != null) {
							PagatiConRicevutaDocument pagatiConRicevutaDocument = PagatiConRicevutaDocument.Factory.parse(pagatiInputStream);
							CtPagatiConRicevuta pagatiConRicevuta = pagatiConRicevutaDocument.getPagatiConRicevuta();
							CtDatiVersamentoPagatiConRicevuta datiPagamento = pagatiConRicevuta.getDatiPagamento();
							if (datiPagamento != null) {
								verificaPagamentoRisposta.setCodiceIuv(datiPagamento.getIdentificativoUnivocoVersamento());
							}
							verificaPagamentoRisposta.setIdRichiesta(pagatiConRicevuta.getRiferimentoMessaggioRichiesta());
							Enum codiceEsitoPagamento = datiPagamento.getCodiceEsitoPagamento();
							StatoPagamento statoPagamento;
							if (codiceEsitoPagamento.toString().equals("0")) {
								statoPagamento = StatoPagamento.COMPLETATO;
							}
							else {
								statoPagamento = StatoPagamento.ERRORE;
							}
							verificaPagamentoRisposta.setStatoPagamento(statoPagamento);
							verificaPagamentoRisposta.setImportoCommissioni(null);

							CtDatiSingoloPagamentoPagatiConRicevuta[] datiSingoloPagamentoArray = datiPagamento.getDatiSingoloPagamentoArray();
							if (datiSingoloPagamentoArray != null) {
								for (CtDatiSingoloPagamentoPagatiConRicevuta ctDatiSingoloPagamentoPagatiConRicevuta : datiSingoloPagamentoArray) {
									CtAllegatoRicevuta allegatoRicevuta = ctDatiSingoloPagamentoPagatiConRicevuta.getAllegatoRicevuta();
									if (allegatoRicevuta != null) {
										it.veneto.regione.schemas.x2012.pagamenti.ente.StTipoAllegatoRicevuta.Enum tipoAllegatoRicevuta = allegatoRicevuta.getTipoAllegatoRicevuta();
										if (tipoAllegatoRicevuta.equals(StTipoAllegatoRicevuta.BD)) {
											byte[] testoAllegato = allegatoRicevuta.getTestoAllegato();
											MarcaDaBolloDocument marcaDaBolloDocument = MarcaDaBolloDocument.Factory.parse(new ByteArrayInputStream(testoAllegato));
											if (marcaDaBolloDocument != null) {
												MarcaDaBollo marcaDaBollo = marcaDaBolloDocument.getMarcaDaBollo();
												if (marcaDaBollo != null) {
													// TODO cosa fare?
												}
											}
										}
									}
								}
							}
						}
					}
				}
				catch (Exception e) {
					log.warn("Errore durante la lettura della lista pagati per iuv " + iuv + " : pagati e' null");
				}
			}

		}

		return verificaPagamentoRisposta;
	}

	private PagamentiTelematiciDovutiPagati getMyPayPort(final String wsMyPayEndpoint) throws Exception {

		URL url = new URL(wsMyPayEndpoint);

		SimpleProvider clientConfig = new SimpleProvider();

		SimpleChain requestHandler = new SimpleChain();
		SimpleChain responsepHandler = new SimpleChain();

		if (log.isDebugEnabled()) {
			LogHandler logHandler = new LogHandler();
			requestHandler.addHandler(logHandler);
			responsepHandler.addHandler(logHandler);
		}

		Handler pivot = new HTTPSender();
		Handler transport = new SimpleTargetedChain(requestHandler, pivot, responsepHandler);
		clientConfig.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME, transport);

		PagamentiTelematiciDovutiPagatiServiceLocator pagamentiTelematiciDovutiPagatiServiceLocator = new PagamentiTelematiciDovutiPagatiServiceLocator(clientConfig);
		pagamentiTelematiciDovutiPagatiServiceLocator.setEngine(new AxisClient(clientConfig));

		PagamentiTelematiciDovutiPagati pagamentiTelematiciDovutiPagatiPort = pagamentiTelematiciDovutiPagatiServiceLocator.getPagamentiTelematiciDovutiPagatiPort(url);
		return pagamentiTelematiciDovutiPagatiPort;
	}

	private PagamentiTelematiciDovutiPagati getPaaSILChiediPagatiConRicevutaMyPayPort(final String wsMyPayEndpoint) throws Exception {

		URL url = new URL(wsMyPayEndpoint);

		SimpleProvider clientConfig = new SimpleProvider();

		SimpleChain requestHandler = new SimpleChain();
		SimpleChain responsepHandler = new SimpleChain();

		PaaSILChiediPagatiConRicevutaHandler paaSILChiediPagatiConRicevutaHandler = new PaaSILChiediPagatiConRicevutaHandler();
		requestHandler.addHandler(paaSILChiediPagatiConRicevutaHandler);

		if (log.isDebugEnabled()) {
			LogHandler logHandler = new LogHandler();
			requestHandler.addHandler(logHandler);
			responsepHandler.addHandler(logHandler);
		}

		Handler pivot = new HTTPSender();
		Handler transport = new SimpleTargetedChain(requestHandler, pivot, responsepHandler);
		clientConfig.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME, transport);

		PagamentiTelematiciDovutiPagatiServiceLocator pagamentiTelematiciDovutiPagatiServiceLocator = new PagamentiTelematiciDovutiPagatiServiceLocator(clientConfig);
		pagamentiTelematiciDovutiPagatiServiceLocator.setEngine(new AxisClient(clientConfig));

		PagamentiTelematiciDovutiPagati pagamentiTelematiciDovutiPagatiPort = pagamentiTelematiciDovutiPagatiServiceLocator.getPagamentiTelematiciDovutiPagatiPort(url);
		return pagamentiTelematiciDovutiPagatiPort;
	}

	@Override
	public TipoPagamentiClient getTipoPagamentiClient() {
		return TipoPagamentiClient.MYPAY;
	}

}
