package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

/**
 * @author COSTABILEE
 *
 */
@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/salvaModifica" 
		}, 
service = { MVCActionCommand.class }
)
public class SalvaModificaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(SalvaModificaActionCommand.class);
	
	
	
	@Reference
	private FormLocalService formLocalService;
	
	@Reference
    private CounterLocalService counterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		
		long idForm = ParamUtil.getLong(actionRequest, "idform");
		String codiceIdentificativo = ParamUtil.getString(actionRequest, "codice-identificativo");
		String nome = ParamUtil.getString(actionRequest, "descrizione");
		boolean principale = ParamUtil.getBoolean(actionRequest, "principale");
		
		Form form = null;
		
		if(Validator.isNull(nome)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE);
			return;
		}
		
		if(Validator.isNull(codiceIdentificativo)) {
			SessionErrors.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE);
			return;
		}
		
		
		if(Validator.isNotNull(idForm) && idForm>0) {
			form = formLocalService.getForm(idForm);
			SessionMessages.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		}else {
			form = formLocalService.createForm(counterLocalService.increment());	
			SessionMessages.add(actionRequest, GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
		}
		
		form.setCodice(codiceIdentificativo);
		form.setDescrizione(nome);
		form.setPrincipale(principale);
		form.setUserId(serviceContext.getThemeDisplay().getUserId());
		form.setGroupId(serviceContext.getThemeDisplay().getScopeGroupId());
		form.setUserName(serviceContext.getThemeDisplay().getUser().getScreenName());
		
		formLocalService.updateForm(form);
	}
}
