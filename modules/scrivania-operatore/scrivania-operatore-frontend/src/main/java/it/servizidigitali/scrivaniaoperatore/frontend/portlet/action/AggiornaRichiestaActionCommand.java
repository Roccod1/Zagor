package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/aggiornaRichiesta"
})
public class AggiornaRichiestaActionCommand extends BaseMVCActionCommand {

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long id = ParamUtil.getLong(request, "id");
		
		try {
			String numProtocollo = ParamUtil.getString(request, "numProtocolloEsito");
			String dataProtocollo = ParamUtil.getString(request, "dataProtocolloEsito");
			
			Richiesta richiesta = richiestaLocalService.fetchRichiesta(id);
			richiesta.setNumeroProtocolloEsterno(numProtocollo);
			richiesta.setDataProtocolloEsterno(dataProtocollo.isBlank() ? null : FORMATTER.parse(dataProtocollo));
			richiestaLocalService.updateRichiesta(richiesta);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, "errore-generico");
		}
		
		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(id));
		renderParameters.setValue("isMain", String.valueOf(false));
	}

	private static final Log _log = LogFactoryUtil.getLog(AggiornaRichiestaActionCommand.class);
}
