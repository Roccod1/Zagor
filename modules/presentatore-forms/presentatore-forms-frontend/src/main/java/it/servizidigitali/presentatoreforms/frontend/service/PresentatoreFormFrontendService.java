package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "presentatoreFormFrontendService", immediate = true, service = PresentatoreFormFrontendService.class)
public class PresentatoreFormFrontendService {

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	public ServizioEnte getServizioEnteByPage(ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByGroupIdLayoutId(groupId, layoutId);

		return servizioEnte;
	}

	public Procedura getCurrentProcedura(ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByGroupIdLayoutId(groupId, layoutId);
		// TODO caricare procedura da servizio e groupId
		return null;
	}

}
