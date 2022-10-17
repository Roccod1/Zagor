package it.servizidigitali.gestionepagamenti.mypay.client;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlOptions;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.Dovuto;
import it.servizidigitali.gestionepagamenti.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.common.client.model.VerificaPagamentoRisposta;
import it.servizidigitali.gestionepagamenti.common.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.mypay.converter.MyPayConverter;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDovuti;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtPagatiConRicevuta;
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
			pagamentiServicePort = getMyPayPort(wsdlUrl);
		}
		catch (Exception e) {
			log.error("Errore nella lettura del wsdl.", e);
			throw new PagamentiClientException("Errore nella lettura del wsdl.", e);
		}

		VerificaPagamentoRisposta verificaPagamentoRisposta = new VerificaPagamentoRisposta();

		CtPagatiConRicevuta ctPagati = null;

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

		if (chiediPagatiResp.getFault() != null) {
			verificaPagamentoRisposta.setCodiceErrore(chiediPagatiResp.getFault().getFaultCode());
			verificaPagamentoRisposta.setDescrizioneErrore(chiediPagatiResp.getFault().getFaultString());
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

			if (chiediPagatiResp.getPagati() != null) {
				ByteArrayInputStream pagatiInputStream = null;
				try {
					byte[] pagati = Base64.getDecoder().decode(chiediPagatiResp.getPagati());
					if (pagati == null) {
						pagatiInputStream = new ByteArrayInputStream(pagati);
						if (pagatiInputStream != null) {
							ctPagati = CtPagatiConRicevuta.Factory.parse(pagatiInputStream);
							if (ctPagati.getDatiPagamento() != null) {
								verificaPagamentoRisposta.setCodiceIuv(ctPagati.getDatiPagamento().getIdentificativoUnivocoVersamento());
							}
							verificaPagamentoRisposta.setIdRichiesta(ctPagati.getRiferimentoMessaggioRichiesta());
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
		PagamentiTelematiciDovutiPagatiServiceLocator pagamentiTelematiciDovutiPagatiServiceLocator = new PagamentiTelematiciDovutiPagatiServiceLocator();
		PagamentiTelematiciDovutiPagati pagamentiTelematiciDovutiPagatiPort = pagamentiTelematiciDovutiPagatiServiceLocator.getPagamentiTelematiciDovutiPagatiPort(url);
		return pagamentiTelematiciDovutiPagatiPort;
	}

	@Override
	public TipoPagamentiClient getTipoPagamentiClient() {
		return TipoPagamentiClient.MYPAY;
	}

}
