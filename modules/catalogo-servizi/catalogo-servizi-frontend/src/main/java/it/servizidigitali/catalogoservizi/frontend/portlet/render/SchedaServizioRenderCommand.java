package it.servizidigitali.catalogoservizi.frontend.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author filierim
 */

@Component(immediate = true, 
	property = { 
		"javax.portlet.name=" + CatalogoServiziPortletKeys.CATALOGOSERVIZI, 
		"mvc.command.name=" + CatalogoServiziPortletKeys.RENDER_SCHEDA_SERVIZIO_NAME 
	}, 
	service = MVCRenderCommand.class
) 
public class SchedaServizioRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(SchedaServizioRenderCommand.class);

	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long servizioId = ParamUtil.getLong(renderRequest, CatalogoServiziPortletKeys.SERVIZIO_ID);
		Servizio servizio = null;
		if(Validator.isNotNull(servizioId)) {
			try {
				servizio = servizioLocalService.getServizioById(servizioId);
				renderRequest.setAttribute(CatalogoServiziPortletKeys.SERVIZIO, servizio);
				return CatalogoServiziPortletKeys.JSP_SCHEDA_SERVIZIO;
			}catch(Exception e) {
				_log.error("Impossibile recuperare lista servizi e/o organizzazioni", e);
			}			
		}else {
			_log.error("organizationId e' null");
		}
		SessionErrors.add(renderRequest, CatalogoServiziPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI);
		return CatalogoServiziPortletKeys.JSP_HOME;
	}

}