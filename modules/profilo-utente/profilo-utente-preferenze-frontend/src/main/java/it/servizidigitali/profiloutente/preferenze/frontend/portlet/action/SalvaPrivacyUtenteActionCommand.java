package it.servizidigitali.profiloutente.preferenze.frontend.portlet.action;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoRow;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.headless.delivery.dto.v1_0.util.CustomFieldsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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

import java.util.List;

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
			
			//imposto valore custom field
			ExpandoBridge utenteCorrenteExpandoBridge = utenteCorrente.getExpandoBridge();
			
			ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(
					utenteCorrenteExpandoBridge.getCompanyId(),
					utenteCorrenteExpandoBridge.getClassName(),
					"CUSTOM_FIELDS");
						
			ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(
					expandoTable.getTableId(),
					ProfiloUtentePreferenzePortletKeys.UTENTE_EXPANDO_ACCETTA_PRIVACY);
			
			ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(
					expandoTable.getTableId(), 
					expandoColumn.getColumnId(), 
					utenteCorrenteExpandoBridge.getClassPK());
			
//			List<ExpandoValue> expValues = ExpandoValueLocalServiceUtil.getDefaultTableColumnValues(
//						expandoColumn.getColumnId(),
//						utenteCorrenteExpandoBridge.getClassName(),
//						ProfiloUtentePreferenzePortletKeys.UTENTE_EXPANDO_ACCETTA_PRIVACY,
//						QueryUtil.ALL_POS, QueryUtil.ALL_POS
//					);
			
			
			if(accettaPrivacy) {
				expandoValue.setBoolean(Boolean.TRUE);
			}else {
				expandoValue.setBoolean(Boolean.FALSE);
			}
			
			ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
			
		}catch(Exception e) {
			_log.error("Impossibile procedere al salvataggio", e);
			SessionErrors.add(actionRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_SALVATAGGIO);
		}
	}
}