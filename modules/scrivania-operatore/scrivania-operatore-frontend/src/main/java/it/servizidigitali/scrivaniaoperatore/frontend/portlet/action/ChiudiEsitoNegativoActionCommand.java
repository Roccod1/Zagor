package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/chiudiEsitoNegativo"
})
public class ChiudiEsitoNegativoActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		String dettaglioTab = ParamUtil.getString(request, "dettaglioTab");
		String commento = ParamUtil.getString(request, "commento");
		long[] selezionati = ParamUtil.getLongValues(request, "selezionati");
		
		try {
			//TODO aggancia service
			throw new RuntimeException();
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

	private static final Log _log = LogFactoryUtil.getLog(ChiudiEsitoNegativoActionCommand.class);
}
