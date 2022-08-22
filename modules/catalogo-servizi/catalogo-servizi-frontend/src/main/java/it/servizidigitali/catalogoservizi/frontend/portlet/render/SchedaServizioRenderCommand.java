package it.servizidigitali.catalogoservizi.frontend.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
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
	
	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long servizioId = ParamUtil.getLong(renderRequest, CatalogoServiziPortletKeys.SERVIZIO_ID);
		Servizio servizio = null;
		ServizioEnte servizioEnte = null;
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		if(Validator.isNotNull(servizioId)) {
			try {
				serviceContext = ServiceContextFactory.getInstance(renderRequest);
				themeDisplay = serviceContext.getThemeDisplay();
				servizio = servizioLocalService.getServizioById(servizioId);
				
				long organizationId = themeDisplay.getSiteGroup().getOrganizationId();
				
				ServizioEntePK servizioEntePK = new ServizioEntePK();
				servizioEntePK.setOrganizationId(organizationId);
				servizioEntePK.setServizioId(servizioId);
				servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);
				renderRequest.setAttribute(CatalogoServiziPortletKeys.SERVIZIO, servizio);
				renderRequest.setAttribute(CatalogoServiziPortletKeys.SERVIZIO_ENTE, servizioEnte);
				return CatalogoServiziPortletKeys.JSP_SCHEDA_SERVIZIO;
			}catch(Exception e) {
				_log.error("Impossibile recuperare lista servizi e/o organizzazioni ::> " + e.getMessage(), e );
			}			
		}else {
			_log.error("organizationId e' null");
		}
		SessionErrors.add(renderRequest, CatalogoServiziPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI);
		return CatalogoServiziPortletKeys.JSP_HOME;
	}

}