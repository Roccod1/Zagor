package it.servizidigitali.accreditamentoenti.frontend.portlet.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.accreditamentoenti.frontend.constants.AccreditamentoEntiFrontendPortletKeys;

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + AccreditamentoEntiFrontendPortletKeys.ACCREDITAMENTOENTIFRONTEND, //
				"mvc.command.name=" + AccreditamentoEntiFrontendPortletKeys.GET_USER_BY_CF_RESOURCE_COMMAND_NAME//
		}, //
		service = MVCResourceCommand.class//
) //
public class GetUserByCFResourceCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetUserByCFResourceCommand.class);

	@Reference
	private UserLocalService userLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		String cf = ParamUtil.getString(resourceRequest, AccreditamentoEntiFrontendPortletKeys.CODICE_FISCALE_GET_USER);

		try {
			User user = userLocalService.getUserByScreenName(CompanyThreadLocal.getCompanyId(), cf);
			if (user == null) {
				throw new Exception("User " + cf + " not found");
			}

			Map<String, String> result = new HashMap<>();
			result.put(AccreditamentoEntiFrontendPortletKeys.NOME_GET_USER, user.getFirstName());
			result.put(AccreditamentoEntiFrontendPortletKeys.COGNOME_GET_USER, user.getLastName());
			
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerializeDeep(result));

		} catch (PortalException ex) {
			_log.error("Error retrieving user: " + cf, ex);
			throw new Exception("NOT_FOUND");
		}

	}

}
