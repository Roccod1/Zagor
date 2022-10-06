package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/rimandaAlReferente"
})
public class RimandaAlReferenteActionCommand extends BaseMVCActionCommand {

	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		String dettaglioTab = ParamUtil.getString(request, "dettaglioTab");
		String commento = ParamUtil.getString(request, "commento");
		String variabileSet = ParamUtil.getString(request, "variabileSet");
		String variabileVal = ParamUtil.getString(request, "variabileVal");
		
		try {
			ServiceContext context = ServiceContextFactory.getInstance(request);
			
			Richiesta richiesta = richiestaLocalService.fetchRichiesta(richiestaId);
			
			Map<String, Task> tasks = scrivaniaOperatoreFrontendService.getUserTasks(context);
			String taskId = tasks.get(richiesta.getProcessInstanceId()).getId();
			
			scrivaniaOperatoreFrontendService.rimandaReferente(
					richiestaId, 
					taskId, 
					variabileSet, 
					variabileVal, 
					commento, 
					context);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, "errore-generico");
		}
		
		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", dettaglioTab);
		renderParameters.setValue("isMain", String.valueOf(false));	
	}

	private static final Log _log = LogFactoryUtil.getLog(RimandaAlReferenteActionCommand.class);
}
