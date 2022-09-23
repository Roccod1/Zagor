package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.CommentoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/aggiungiCommento"
})
public class AggiungiCommentoActionCommand extends BaseMVCActionCommand {

	@Reference
	private CommentoRichiestaLocalService commentoRichiestaLocalService;
	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private UserLocalService userLocalService;
	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext context = ServiceContextFactory.getInstance(request);
		
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		String testo = ParamUtil.getString(request, "testo");
		boolean visibile = ParamUtil.getBoolean(request, "visibileAlCittadino");
		
		long id = counterLocalService.increment(CommentoRichiesta.class.getName());
		CommentoRichiesta commentoRichiesta = commentoRichiestaLocalService.createCommentoRichiesta(id);
		commentoRichiesta.setGroupId(context.getScopeGroupId());
		commentoRichiesta.setCompanyId(context.getCompanyId());
		commentoRichiesta.setUserId(context.getUserId());
		commentoRichiesta.setCreateDate(new Date());
		if (visibile) {
			commentoRichiesta.setModifiedDate(new Date());
		}
		commentoRichiesta.setTesto(testo);
		commentoRichiesta.setVisibile(visibile);
		commentoRichiesta.setRichiestaId(richiestaId);
		
		User user = userLocalService.fetchUser(context.getUserId());
		commentoRichiesta.setUserName(user.getFullName());
		
		Richiesta richiesta = richiestaLocalService.fetchRichiesta(richiestaId);
		commentoRichiesta.setTaskId(richiesta.getProcessInstanceId());
		
		commentoRichiestaLocalService.updateCommentoRichiesta(commentoRichiesta);
		
		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_COMMENTI);
	}

}
