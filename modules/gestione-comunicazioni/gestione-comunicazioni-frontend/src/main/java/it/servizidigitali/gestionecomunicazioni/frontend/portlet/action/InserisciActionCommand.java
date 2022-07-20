package it.servizidigitali.gestionecomunicazioni.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;

@Component(
		immediate = true,
		service = MVCActionCommand.class,
		property = {
				"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI,
				"mvc.command.name=/action/inserisci"
		}
)
public class InserisciActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		String titolo = ParamUtil.getString(request, "titolo");
		String tipologia = ParamUtil.getString(request, "tipologia");
		String descrizione = ParamUtil.getString(request, "descrizione");
		String dataInizio = ParamUtil.getString(request, "dataInizio");
		String dataFine = ParamUtil.getString(request, "dataFine");
		String procedura = ParamUtil.getString(request, "procedura");
		String cittadini = ParamUtil.getString(request, "cittadini");
		
		
	}

	private static final Log _log = LogFactoryUtil.getLog(InserisciActionCommand.class);
}
