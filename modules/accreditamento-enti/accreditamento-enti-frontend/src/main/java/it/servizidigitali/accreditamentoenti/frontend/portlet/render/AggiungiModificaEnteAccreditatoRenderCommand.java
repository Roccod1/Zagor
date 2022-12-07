package it.servizidigitali.accreditamentoenti.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.accreditamentoenti.frontend.constants.AccreditamentoEntiFrontendPortletKeys;
import it.servizidigitali.accreditamentoenti.model.Ente;
import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;
import it.servizidigitali.accreditamentoenti.service.EnteLocalService;
import it.servizidigitali.accreditamentoenti.service.ResponsabileEnteLocalService;

/**
 * @author mancinig
 */

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + AccreditamentoEntiFrontendPortletKeys.ACCREDITAMENTOENTIFRONTEND, //
				"mvc.command.name=" + AccreditamentoEntiFrontendPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME//
		}, //
		service = MVCRenderCommand.class)
public class AggiungiModificaEnteAccreditatoRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaEnteAccreditatoRenderCommand.class);

	@Reference
	private EnteLocalService enteLocalService;

	@Reference
	private ResponsabileEnteLocalService responsabileEnteLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long enteId = ParamUtil.getLong(renderRequest, AccreditamentoEntiFrontendPortletKeys.ENTE_ID);
		String indirizzoPrecedente = ParamUtil.getString(renderRequest,
				AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE);

		Ente ente = null;

		if (Validator.isNotNull(enteId)) {
			try {
				ente = enteLocalService.getEnte(enteId);
			} catch (Exception e) {
				_log.error("Impossibile ottenere l'ente con ID: " + enteId);
				SessionErrors.add(renderRequest,
						AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE);
				return AccreditamentoEntiFrontendPortletKeys.JSP_HOME;
			}
		}

		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.ENTE, ente);
		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.RESPONSABILI, getResponsabili(enteId));
		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE, indirizzoPrecedente);

		return AccreditamentoEntiFrontendPortletKeys.JSP_INSERIMENTO_MODIFICA_ENTE;
	}

	private List<User> getResponsabili(long enteId) throws PortletException {
		List<ResponsabileEnte> responsabili = responsabileEnteLocalService.getResponsabileEnteByEnteId(enteId);
		List<User> users = new LinkedList<>();

		for (ResponsabileEnte responsabile : responsabili) {
			try {
				users.add(userLocalService.getUser(responsabile.getResponsabileUserId()));
			} catch (PortalException ex) {
				_log.error("Error retrieving user: " + responsabile.getResponsabileEnteId(), ex);
			}
		}

		return users;
	}

}
