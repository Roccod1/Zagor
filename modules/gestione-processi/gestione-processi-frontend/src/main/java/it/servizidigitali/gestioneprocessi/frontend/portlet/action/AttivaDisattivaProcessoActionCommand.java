package it.servizidigitali.gestioneprocessi.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocessi.frontend.constants.GestioneProcessiPortletKeys;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;

/**
 * @author COSTABILEE
 *
 */

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneProcessiPortletKeys.GESTIONEPROCESSI,
			"mvc.command.name=" + GestioneProcessiPortletKeys.ATTIVA_DISATTIVA_PROCESSO_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class AttivaDisattivaProcessoActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(AttivaDisattivaProcessoActionCommand.class);
	
	@Reference
	private ProcessoLocalService processoLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long idProcesso = ParamUtil.getLong(actionRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		
		Processo processo = null;
		
		if(Validator.isNotNull(idProcesso) && idProcesso > 0) {
			processo = processoLocalService.getProcesso(idProcesso);
			boolean statoProcesso = processo.getAttivo();
			
			if(statoProcesso) {
				processo.setAttivo(false);
			}else {
				processo.setAttivo(true);
			}
			
			processoLocalService.updateProcesso(processo);
		}else {
			SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_ATTIVA_DISATTIVA_PROCESSO);
			_log.error("Impossibile aggiornare lo stato del processo!");
			return;
		}
		
	}
}
