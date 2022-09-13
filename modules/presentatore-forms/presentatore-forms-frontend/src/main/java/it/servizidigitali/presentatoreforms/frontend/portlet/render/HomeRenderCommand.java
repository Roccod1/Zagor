package it.servizidigitali.presentatoreforms.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.AlpacaService;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS,
		"mvc.command.name=" + PresentatoreFormsPortletKeys.HOME_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class HomeRenderCommand implements MVCRenderCommand {

	public static final Log _log = LogFactoryUtil.getLog(HomeRenderCommand.class);

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;

	@Reference
	private AlpacaService alpacaService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Procedura procedura = null;
		AlpacaJsonStructure alpacaStructure = null;

		List<String> lstDestinazioniUso = getListaDestinazioniUso();

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			alpacaStructure = getAlpacaJsonStructure(procedura);

			String step2TipoServizio = procedura.getStep2TipoServizio();

			TipoServizio tipoServizio = TipoServizio.valueOf(step2TipoServizio);

			if (Validator.isNotNull(alpacaStructure)) {
				renderRequest.setAttribute("alpacaStructure", alpacaStructure);
			}

			if (tipoServizio.equals(TipoServizio.CERTIFICATO)) {
				return PresentatoreFormsPortletKeys.JSP_SCEGLI_DESTINAZIONE_USO;
			}
			else {
				return PresentatoreFormsPortletKeys.JSP_COMPILA_FORM;
			}
		}
		catch (Exception e) {
			_log.error("");
		}

		renderRequest.setAttribute("destinazioniUso", lstDestinazioniUso);

		return PresentatoreFormsPortletKeys.JSP_HOME;

	}

	private AlpacaJsonStructure getAlpacaJsonStructure(Procedura procedura) {

		Form form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());

		FormData formData = AlpacaUtil.loadFormData(form, null, true);
		AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

		return alpacaStructure;

	}

	private List<String> getListaDestinazioniUso() {
		List<String> lstDestinazioniUso = new ArrayList<String>();
		lstDestinazioniUso.add("Bollo");
		lstDestinazioniUso.add("Esenzione");

		return lstDestinazioniUso;
	}

}