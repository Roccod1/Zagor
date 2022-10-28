package it.servizidigitali.presentatoreforms.common.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.CertificatoService;
import it.servizidigitali.presentatoreforms.common.service.PDFService;
import it.servizidigitali.presentatoreforms.common.service.PDFServiceFactory;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "certificatoService", immediate = true, service = CertificatoService.class)
public class CertificatoServiceImpl implements CertificatoService {

	private static final Log log = LogFactoryUtil.getLog(CertificatoServiceImpl.class.getName());

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;

	@Reference
	private PDFServiceFactory pdfServiceFactory;

	@Reference
	private LayoutUtility layoutUtility;

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, long richiestaId, long destinazioneUsoId, String numeroBollo) throws PortalException {

		try {
			Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);
			Procedura procedura = proceduraLocalService.getProcedura(richiesta.getProceduraId());
			long companyId = procedura.getCompanyId();
			User user = userLocalService.getUserByScreenName(companyId, codiceFiscaleRichiedente);
			Form form = getFormPrincipaleProcedura(procedura.getProceduraId());

			IstanzaForm istanzaForm = istanzaFormLocalService.getIstanzaFormByRichiestaIdFormId(richiestaId, form.getFormId());

			String sitePath = layoutUtility.getSitePath(procedura.getGroupId(), procedura.getCompanyId());

			FormData formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true, sitePath);
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();
			JsonParser jsonParser = new JsonParser();

			Gson gson = new Gson();
			alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
			alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, sitePath));
			alpacaStructure.setData(jsonParser.parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

			PDFService pdfService = pdfServiceFactory.getPDFService(TipoGenerazionePDF.valueOf(procedura.getTipoGenerazionePDF()));

			byte[] pdfCertificato = pdfService.generaPDFCertificato(user.getScreenName(), codiceFiscaleComponente, alpacaStructure, richiesta, destinazioneUsoId, numeroBollo);
			return pdfCertificato;
		}
		catch (Exception e) {
			log.error("generaCertificato :: " + e.getMessage(), e);
			throw new PortalException("Errore durante la generazione del PDF certificato per la richiesta con ID: " + richiestaId + " :: " + e.getMessage(), e);
		}
	}

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, long richiestaId, long destinazioneUsoId,
			String numeroBollo) throws PortalException {

		try {
			Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);
			Procedura procedura = proceduraLocalService.getProcedura(richiesta.getProceduraId());
			long companyId = procedura.getCompanyId();
			User user = userLocalService.getUserByScreenName(companyId, codiceFiscaleRichiedente);

			PDFService pdfService = pdfServiceFactory.getPDFService(TipoGenerazionePDF.valueOf(procedura.getTipoGenerazionePDF()));

			byte[] pdfCertificato = pdfService.generaPDFCertificato(user.getScreenName(), codiceFiscaleComponente, alpacaStructure, richiesta, destinazioneUsoId, numeroBollo);
			return pdfCertificato;
		}
		catch (Exception e) {
			log.error("generaCertificato :: " + e.getMessage(), e);
			throw new PortalException("Errore durante la generazione del PDF certificato per la richiesta con ID: " + richiestaId + " :: " + e.getMessage(), e);
		}
	}

	private Form getFormPrincipaleProcedura(long proceduraId) {
		try {
			List<ProceduraForm> listaProceduraFormProcedura = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);

			if (listaProceduraFormProcedura != null) {
				for (ProceduraForm proceduraForm : listaProceduraFormProcedura) {
					Form form = formLocalService.getForm(proceduraForm.getFormId());
					if (form.isPrincipale()) {
						form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId()));
						return form;
					}
				}
			}
		}
		catch (PortalException e) {
			log.warn("getFormPrincipaleProcedura :: " + e.getMessage());
		}
		return null;
	}

}
