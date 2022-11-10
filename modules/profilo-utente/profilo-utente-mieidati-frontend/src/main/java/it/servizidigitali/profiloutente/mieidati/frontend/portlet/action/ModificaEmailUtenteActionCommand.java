package it.servizidigitali.profiloutente.mieidati.frontend.portlet.action;

import com.liferay.expando.kernel.model.ExpandoBridge;
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

import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.profiloutente.mieidati.frontend.constants.ProfiloUtenteMieiDatiPortletKeys;

/**
 * @author filierim
 */

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + ProfiloUtenteMieiDatiPortletKeys.PROFILOUTENTEMIEIDATI, //
				"mvc.command.name=" + ProfiloUtenteMieiDatiPortletKeys.SALVA_EMAIL_ACTION_COMMAND_NAME //
		}, //
		service = MVCActionCommand.class//
) //
public class ModificaEmailUtenteActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(ModificaEmailUtenteActionCommand.class);

	@Reference
	private UserLocalService userLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String emailPrincipale = ParamUtil.getString(actionRequest, ProfiloUtenteMieiDatiPortletKeys.EMAIL_PRINCIPALE);
		String emailSecondaria = ParamUtil.getString(actionRequest, ProfiloUtenteMieiDatiPortletKeys.EMAIL_SECONDARIA);

		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		User utenteCorrente = null;
		try {
			_log.debug("Email principale: " + emailPrincipale);
			_log.debug("Email secondaria: " + emailSecondaria);

			serviceContext = ServiceContextFactory.getInstance(actionRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			utenteCorrente = themeDisplay.getUser();

			ExpandoBridge expandoBridge = utenteCorrente.getExpandoBridge();
			boolean loginSenzaEmail = false;
			Serializable loginSenzaEmailString = expandoBridge.getAttribute(UserCustomAttributes.LOGIN_SENZA_EMAIL.getNomeAttributo());
			if (loginSenzaEmailString != null) {
				loginSenzaEmail = Boolean.parseBoolean(loginSenzaEmailString.toString());
			}

			if (loginSenzaEmail) {
				// Aggiornamento email
				try {
					utenteCorrente.setEmailAddress(emailPrincipale);
					userLocalService.updateUser(utenteCorrente);
					expandoBridge.setAttribute(ProfiloUtenteMieiDatiPortletKeys.LOGIN_SENZA_EMAIL, false);
				}
				catch (Exception e) {
					_log.error("doProcessAction :: " + e.getMessage(), e);
					SessionErrors.add(actionRequest, e.getClass().getName(), e);
					actionResponse.getRenderParameters().setValue(ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA, ProfiloUtenteMieiDatiPortletKeys.SEZIONE_CONTATTI);
					return;
				}
			}
			else {
				expandoBridge.setAttribute(ProfiloUtenteMieiDatiPortletKeys.EXPANDO_USER_EMAIL_AGGIUNTIVA, emailSecondaria);
			}
		}
		catch (Exception e) {
			_log.error("Impossibile salvare/aggiornare le informazioni dell'utente con ID: " + utenteCorrente.getUserId() + " > " + e.getMessage(), e);
		}
	}
}