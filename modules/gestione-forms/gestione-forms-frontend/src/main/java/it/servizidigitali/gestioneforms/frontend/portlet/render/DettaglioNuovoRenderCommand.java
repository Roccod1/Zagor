package it.servizidigitali.gestioneforms.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalServiceUtil;


/**
 * @author COSTABILEE
 *
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/dettaglioNuovo"
		},
		service = MVCRenderCommand.class
	)
public class DettaglioNuovoRenderCommand implements MVCRenderCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(DettaglioNuovoRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Long idForm = ParamUtil.getLong(renderRequest, "idForm");
		String urlTornaIndietro = (String) ParamUtil.getString(renderRequest, "urlTornaIndietro");
		
		renderRequest.setAttribute("urlTornaIndietro", urlTornaIndietro);
		
		Form form = null;
		
		if(idForm>0) {
			try {
				form = FormLocalServiceUtil.getForm(idForm);
			} catch (PortalException e) {
				_log.error("Impossibile recuperare il form!" + e.getMessage());
			}
			
			renderRequest.setAttribute("form", form);
		}
		
		return GestioneFormsPortletKeys.JSP_AGGIUNGI_MODIFICA_FORM;
	}

}
