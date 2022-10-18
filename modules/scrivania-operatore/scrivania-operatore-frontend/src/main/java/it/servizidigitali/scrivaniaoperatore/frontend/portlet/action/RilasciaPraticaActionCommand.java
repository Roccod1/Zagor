package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		service = MVCActionCommand.class, //
		property = { //
				"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, //
				"mvc.command.name=/action/rilasciaPratica"//
		}//
)
public class RilasciaPraticaActionCommand extends BaseMVCActionCommand {

	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		String dettaglioTab = ParamUtil.getString(request, "dettaglioTab");

		try {
			ServiceContext context = ServiceContextFactory.getInstance(request);
			Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);

			Map<String, Task> tasks = scrivaniaOperatoreFrontendService.getUserTasks(context);
			String taskId = tasks.get(richiesta.getProcessInstanceId()).getId();

			_log.debug("Task Id: " + taskId);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			scrivaniaOperatoreFrontendService.rilasciaTask(themeDisplay.getUser().getScreenName(), taskId);
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, "errore-generico");
		}

		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", dettaglioTab);
		renderParameters.setValue("isMain", String.valueOf(false));
	}

	private static final Log _log = LogFactoryUtil.getLog(RilasciaPraticaActionCommand.class);
}
