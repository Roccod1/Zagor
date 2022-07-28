package it.servizidigitali.profiloutente.preferenze.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE,
		"mvc.command.name=" + ProfiloUtentePreferenzePortletKeys.ACTION_SALVA_PRIVACY
	},
	service = MVCActionCommand.class
)
public class SalvaPrivacyUtenteActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(SalvaPrivacyUtenteActionCommand.class);
	
	@Reference
	private UserLocalService userLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		boolean accettaPrivacy = ParamUtil.getBoolean(actionRequest, ProfiloUtentePreferenzePortletKeys.UTENTE_ACCETTA_PRIVACY, false);
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		
		long utenteCorrenteId = 0;
		
		try {
			
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			
			utenteCorrenteId = themeDisplay.getUserId();
			
			if(utenteCorrenteId <= 0) {
				_log.error("Impossibile ottere l'utente loggato dal ThemeDisplay");
				throw new Exception();
			}
			
			User utenteCorrente = userLocalService.getUserById(utenteCorrenteId);
			
			utenteCorrente.getExpandoBridge().setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_EXPANDO_ACCETTA_PRIVACY, accettaPrivacy);
			
		}catch(Exception e) {
			_log.error("Impossibile procedere al salvataggio :: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_SALVATAGGIO);
		}
	}
}