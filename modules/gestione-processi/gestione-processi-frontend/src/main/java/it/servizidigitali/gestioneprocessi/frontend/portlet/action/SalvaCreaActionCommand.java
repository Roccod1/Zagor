package it.servizidigitali.gestioneprocessi.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
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

@Component(immediate = true, //
		property = { //
				"javax.portlet.name=" + GestioneProcessiPortletKeys.GESTIONEPROCESSI, //
				"mvc.command.name=" + GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND //
		}, //
		service = { MVCActionCommand.class } //
)
public class SalvaCreaActionCommand extends BaseMVCActionCommand {

	public static final Log _log = LogFactoryUtil.getLog(SalvaCreaActionCommand.class);

	@Reference
	private ProcessoLocalService processoLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private CamundaClient camundaClient;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long idProcesso = ParamUtil.getLong(actionRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		String codice = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.CODICE);
		String nome = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.NOME);
		String modelloXml = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.MODELLOXML);

		Processo processo = null;

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		String tenantId = null;
		if (organizationId > 0) {
			tenantId = String.valueOf(organizationId);
		}
		if (idProcesso > 0) {

			processo = processoLocalService.getProcesso(idProcesso);
			tenantId = String.valueOf(groupLocalService.getGroup(processo.getGroupId()).getOrganizationId());

			if (Validator.isNull(codice)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}

			if (Validator.isNull(nome)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}

			if (Validator.isNotNull(modelloXml)) {
				try {
					String deploymentId = camundaClient.insertOrUpdateProcessDefinitions(tenantId, codice, modelloXml.getBytes());

					if (Validator.isNotNull(deploymentId)) {
						processo.setDeploymentId(deploymentId);
					}

				}
				catch (Exception e) {
					SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_CAMUNDA);
					actionRequest.setAttribute(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
					actionResponse.getRenderParameters().setValue(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
					return;
				}
			}

			processo.setCodice(codice);
			processo.setNome(nome);
			processo.setAttivo(true);
			processo.setUserId(themeDisplay.getUserId());
			processo.setUserName(themeDisplay.getUser().getFullName());
		}
		else {
			try {
				processo = processoLocalService.getProcessoByCodice(codice);
				_log.error("Processo già esistente con codice: " + codice);
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_PROCESSO_CODICE_ESISTENTE);
				actionRequest.setAttribute(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
				actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaProcesso.jsp");
				return;
			}
			catch (NoSuchProcessoException e) {

				processo = processoLocalService.createProcesso(counterLocalService.increment());

				if (Validator.isNull(codice)) {
					SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					return;
				}

				if (Validator.isNull(nome)) {
					SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
					return;
				}

				if (Validator.isNotNull(modelloXml)) {
					try {
						String deploymentId = camundaClient.insertOrUpdateProcessDefinitions(tenantId, codice, modelloXml.getBytes());

						if (Validator.isNotNull(deploymentId)) {
							processo.setDeploymentId(deploymentId);
						}

					}
					catch (Exception exception) {
						SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_CAMUNDA);
						actionRequest.setAttribute(GestioneProcessiPortletKeys.MODELLOXML, modelloXml);
						actionResponse.getRenderParameters().setValue("jspPage", "/aggiungiModificaProcesso.jsp");
						return;
					}
				}

				processo.setCodice(codice);
				processo.setNome(nome);
				processo.setAttivo(true);
				processo.setUserId(themeDisplay.getUserId());
				processo.setGroupId(themeDisplay.getSiteGroupId());
				processo.setUserName(themeDisplay.getUser().getFullName());

			}
		}

		SessionMessages.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		processoLocalService.updateProcesso(processo);
	}
}
