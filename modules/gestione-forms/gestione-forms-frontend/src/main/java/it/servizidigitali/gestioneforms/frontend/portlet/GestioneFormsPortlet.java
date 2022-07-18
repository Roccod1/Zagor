package it.servizidigitali.gestioneforms.frontend.portlet;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/scripts/leaflet/leaflet.css",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/leaflet/leaflet.js",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/jquery-ui/jquery-ui.js",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/jquery-validate/jquery.validate.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/handlebars/handlebars.min-v4.7.7.js",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/fileinput/fileinput.min.js",
		"com.liferay.portlet.header-portlet-css=/scripts/fileinput/fileinput.min.css",
		"com.liferay.portlet.header-portlet-css=/scripts/alpaca/alpaca.css",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/alpaca/alpaca.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/scripts/ace/ace.js",
		"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneForms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneFormsPortlet extends MVCPortlet {
	public static final Log _log = LogFactoryUtil.getLog(GestioneFormsPortlet.class);
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Reference
	private FormLocalService formLocalService;

	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		
		
		List<Form> listaForm = (List<Form>) renderRequest.getAttribute(GestioneFormsPortletKeys.LISTA_FORM);
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,GestioneFormsPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,GestioneFormsPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
				
		String nome = ParamUtil.getString(renderRequest, "nomeRicerca");
		String dataInserimentoDaString = ParamUtil.getString(renderRequest, "dataInserimentoDa");
		String dataInserimentoAString = ParamUtil.getString(renderRequest, "dataInserimentoA");
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;

		try {
			
			if(Validator.isNotNull(dataInserimentoDaString)) {
				dataInserimentoDa = simpleDateFormat.parse(dataInserimentoDaString);
			}
			
			if(Validator.isNotNull(dataInserimentoAString)) {
				dataInserimentoA = simpleDateFormat.parse(dataInserimentoAString);
			}
			
		}catch(ParseException e) {
			_log.error("Impossibile effettuare il parse delle date!");
		}
		
		
		
		listaForm = formLocalService.search(nome, dataInserimentoDa, dataInserimentoA, delta, cur,orderByCol, orderByType);
		
		renderRequest.setAttribute(GestioneFormsPortletKeys.LISTA_FORM, listaForm);	
		renderRequest.setAttribute("nomeRicerca", nome);
		renderRequest.setAttribute("dataInserimentoDa", dataInserimentoDaString);
		renderRequest.setAttribute("dataInserimentoA", dataInserimentoAString);
		
		
		// Rimozione messaggi default
		
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	    

	    SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	    
	    super.render(renderRequest, renderResponse);
	}
}