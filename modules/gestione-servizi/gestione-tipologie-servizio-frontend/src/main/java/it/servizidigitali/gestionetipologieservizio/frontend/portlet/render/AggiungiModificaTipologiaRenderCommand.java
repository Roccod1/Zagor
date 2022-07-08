package it.servizidigitali.gestionetipologieservizio.frontend.portlet.render;

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

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.gestionetipologieservizio.frontend.constants.GestioneTipologieServizioPortletKeys;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneTipologieServizioPortletKeys.GESTIONETIPOLOGIESERVIZIO,
		"mvc.command.name=" + GestioneTipologieServizioPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME
	},
	service = MVCRenderCommand.class
)
public class AggiungiModificaTipologiaRenderCommand implements MVCRenderCommand{
	
	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaTipologiaRenderCommand.class);
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Long tipologiaId = ParamUtil.getLong(renderRequest, GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID);
		String indirizzoPrecedente = ParamUtil.getString(renderRequest, GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE);
		
		Tipologia tipologia= null;
		
		if(Validator.isNotNull(tipologiaId)) {
			try {
				tipologia = tipologiaLocalService.getTipologia(tipologiaId);
			}catch(Exception e) {
				_log.error("Impossibile ottenere la tipologia con ID: " + tipologiaId);
				SessionErrors.add(renderRequest, GestioneTipologieServizioPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_TIPOLOGIA);
				return GestioneTipologieServizioPortletKeys.JSP_HOME;
			}
		}
		
		renderRequest.setAttribute(GestioneTipologieServizioPortletKeys.TIPOLOGIA, tipologia);
		renderRequest.setAttribute(GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE, indirizzoPrecedente);
		
		return GestioneTipologieServizioPortletKeys.JSP_INSERIMENTO_MODIFICA_TIPOLOGIA;
	}

}
