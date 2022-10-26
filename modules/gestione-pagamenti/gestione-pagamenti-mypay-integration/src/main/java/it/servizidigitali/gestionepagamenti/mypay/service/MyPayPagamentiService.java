package it.servizidigitali.gestionepagamenti.mypay.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.InputStream;
import java.math.BigDecimal;

import org.osgi.service.component.annotations.Component;

import it.gov.agenziaentrate.x2014.marcaDaBollo.MarcaDaBolloDocument;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.exception.PagamentiServiceException;
import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo.ImprontaDocumento;
import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo.PSP;
import it.servizidigitali.gestionepagamenti.integration.common.service.PagamentiService;

/**
 * @author pindi
 *
 */
@Component(name = "myPayPagamentiService", service = PagamentiService.class, immediate = true)
public class MyPayPagamentiService implements PagamentiService {

	private static final Log log = LogFactoryUtil.getLog(MyPayPagamentiService.class.getName());

	@Override
	public MarcaDaBollo unmarshal(InputStream inputStream) throws PagamentiServiceException {

		try {
			MarcaDaBolloDocument marcaDaBolloDocument = MarcaDaBolloDocument.Factory.parse(inputStream);
			it.gov.agenziaentrate.x2014.marcaDaBollo.MarcaDaBolloDocument.MarcaDaBollo marcaDaBollo = marcaDaBolloDocument.getMarcaDaBollo();
			MarcaDaBollo marcaDaBolloResponse = new MarcaDaBollo();

			marcaDaBolloResponse.setIubd(String.valueOf(marcaDaBollo.getIUBD()));
			marcaDaBolloResponse.setOraAcquisto(marcaDaBollo.getOraAcquisto().getTime());
			marcaDaBolloResponse.setImporto(new BigDecimal(marcaDaBollo.getImporto()));
			ImprontaDocumento improntaDocumento = marcaDaBolloResponse.new ImprontaDocumento();
			improntaDocumento.setAlgoritmo(marcaDaBollo.getImprontaDocumento().getDigestMethod().getAlgorithm());
			improntaDocumento.setValore(marcaDaBollo.getImprontaDocumento().getDigestValue());
			marcaDaBolloResponse.setImprontaDocumento(improntaDocumento);
			PSP psp = marcaDaBolloResponse.new PSP();
			psp.setCodiceFiscale(String.valueOf(marcaDaBollo.getPSP().getCodiceFiscale()));
			psp.setDenominazione(marcaDaBollo.getPSP().getDenominazione());
			marcaDaBolloResponse.setPsp(psp);
			return marcaDaBolloResponse;
		}
		catch (Exception e) {
			log.error("unmarshal :: " + e.getMessage(), e);
			throw new PagamentiServiceException(e);
		}
	}

	@Override
	public TipoPagamentiClient getTipoPagamentiClient() {
		return TipoPagamentiClient.MYPAY;
	}

}
