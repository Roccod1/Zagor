package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "presentatoreFormFrontendService", immediate = true, service = PresentatoreFormFrontendService.class)
public class PresentatoreFormFrontendService {

	private static final Log log = LogFactoryUtil.getLog(PresentatoreFormFrontendService.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	public ServizioEnte getServizioEnteByPage(ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);

		return servizioEnte;
	}

	public Procedura getCurrentProcedura(ThemeDisplay themeDisplay) throws PortalException {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);

		return proceduraLocalService.getProceduraByServizioIdGroupIdAttiva(servizioEnte.getServizioId(), servizioEnte.getGroupId(), true);
	}

	public Form getFormPrincipaleProcedura(long proceduraId) {
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
