package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.common.service.CertificatoService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=PresentatoreForms", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.GENERA_CERTIFICATO_RENDER_COMMAND//
		}, //
		service = MVCRenderCommand.class//
) //
public class GeneraCertificatoRenderCommand implements MVCRenderCommand {

	public static final Log log = LogFactoryUtil.getLog(GeneraCertificatoRenderCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private AllegatoRichiestaService allegatoRichiestaService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CertificatoService certificatoService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		Procedura procedura = null;
		Richiesta richiesta = null;
		Servizio servizio = null;

		byte[] pdfCertificato = null;

		long destinazioneUsoId = ParamUtil.getLong(renderRequest, "destinazioneUsoId");
		String codiceFiscaleComponente = ParamUtil.getString(renderRequest, PresentatoreFormsPortletKeys.CODICE_FISCALE_COMPONENTE);

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			servizio = servizioLocalService.getServizio(procedura.getServizioId());
			richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());

			pdfCertificato = certificatoService.generaPDFCertificato(user.getScreenName(), codiceFiscaleComponente, richiesta.getRichiestaId(), destinazioneUsoId, null);

			if (Validator.isNotNull(pdfCertificato) && Validator.isNotNull(richiesta)) {
				richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.CHIUSA_POSITIVAMENTE.name());
				String idDocumentale = allegatoRichiestaService.salvaCertificato(pdfCertificato, servizio, richiesta.getRichiestaId(), user.getFullName(), user.getUserId(),
						themeDisplay.getSiteGroupId(), themeDisplay.getCompanyId());
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.RICHIESTA_ID, richiesta.getRichiestaId());
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE, codiceFiscaleComponente);
				renderRequest.setAttribute(PresentatoreFormsPortletKeys.ID_DOCUMENTALE, idDocumentale);
				return PresentatoreFormsPortletKeys.JSP_DOWNLOAD_CERTIFICATO;
			}

		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

}
