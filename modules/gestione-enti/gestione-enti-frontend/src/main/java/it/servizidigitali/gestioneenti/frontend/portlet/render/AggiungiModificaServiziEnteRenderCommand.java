package it.servizidigitali.gestioneenti.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;

/**
 * @author pindi
 */

@Component(immediate = true, //
		property = { "javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, "mvc.command.name=/aggiungiModifica" }, //
		service = MVCRenderCommand.class//
) //
public class AggiungiModificaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServiziEnteRenderCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long organizationId = ParamUtil.getLong(renderRequest, "organizationId");

		if (organizationId != 0l) {
			try {
				Organization organization = organizationLocalService.getOrganization(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE, organization);

				List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnte(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.SERVIZI_ENTE, serviziEnte);
			}
			catch (PortalException e) {
				_log.error("Errore durante il caricamento dell'ente_servizio : " + e.getMessage(), e);
				throw new PortletException(e);
			}
		}

		return GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA;
	}

}