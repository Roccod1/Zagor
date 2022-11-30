package it.servizidigitali.accreditamentoenti.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.accreditamentoenti.frontend.constants.AccreditamentoEntiFrontendPortletKeys;
import it.servizidigitali.accreditamentoenti.model.Ente;
import it.servizidigitali.accreditamentoenti.service.EnteLocalService;

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
		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE, indirizzoPrecedente);

		return AccreditamentoEntiFrontendPortletKeys.JSP_INSERIMENTO_MODIFICA_ENTE;
	}

}
