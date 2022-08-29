package it.servizidigitali.gestioneprocessi.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
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
			"mvc.command.name=" + GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaCreaActionCommand extends BaseMVCActionCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(SalvaCreaActionCommand.class);
	
	@Reference
	private ProcessoLocalService processoLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private CamundaClient camundaClient;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long idProcesso = ParamUtil.getLong(actionRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		String codice = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.CODICE);
		String nome = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.NOME);
		String modelloXml = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.MODELLOXML);
		
		Processo processo = null;
		
		if(idProcesso>0) {
			
			processo = processoLocalService.getProcesso(idProcesso);
			
			if(Validator.isNull(codice)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNull(nome)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNotNull(modelloXml)) {
				String deploymentId = camundaClient.insertOrUpdateProcessDefinitions(String.valueOf(themeDisplay.getScopeGroupId()), codice, modelloXml.getBytes());
				
				if(Validator.isNotNull(deploymentId)) {
					processo.setDeploymentId(deploymentId);
				}
			}
			
			processo.setCodice(codice);
			processo.setNome(nome);
			processo.setAttivo(true);
			processo.setUserId(themeDisplay.getUserId());
			processo.setUserName(themeDisplay.getUser().getScreenName());
		}else {
			try {
				processo = processoLocalService.getProcessoByCodice(codice);
				_log.error("Processo già esistente con codice: " + codice);
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_PROCESSO_CODICE_ESISTENTE);
				return;
			}catch(NoSuchProcessoException e) {
				
				processo = processoLocalService.createProcesso(counterLocalService.increment());
				
				if(Validator.isNull(codice)) {
					SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					return;
				}
				
				if(Validator.isNull(nome)) {
					SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					return;
				}
				
				if(Validator.isNotNull(modelloXml)) {
					String deploymentId = camundaClient.insertOrUpdateProcessDefinitions(String.valueOf(themeDisplay.getScopeGroupId()), codice, modelloXml.getBytes());
					
					if(Validator.isNotNull(deploymentId)) {
						processo.setDeploymentId(deploymentId);
					}
				}
				
				processo.setCodice(codice);
				processo.setNome(nome);
				processo.setAttivo(true);
				processo.setUserId(themeDisplay.getUserId());
				processo.setGroupId(themeDisplay.getScopeGroupId());
				processo.setUserName(themeDisplay.getUser().getScreenName());
						
			}	
		}
		
		processoLocalService.updateProcesso(processo);
		
	}

}
