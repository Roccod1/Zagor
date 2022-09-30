package it.servizidigitali.gestioneforms.frontend.portlet;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		"com.liferay.portlet.header-portlet-css=/libs/leaflet/leaflet.css",
		"com.liferay.portlet.header-portlet-css=/libs/jquery.handsontable/jquery.handsontable.full.css",
		"com.liferay.portlet.footer-portlet-javascript=/libs/ace.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-ui-dist/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/handlebars/handlebars.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery.handsontable/jquery.handsontable.full.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/jquery-validation/jquery.validate.min.js",	
		"com.liferay.portlet.footer-portlet-javascript=/libs/alpaca-custom/alpaca.min.js",
		"com.liferay.portlet.header-portlet-css=/libs/alpaca-custom/alpaca.css",
		"com.liferay.portlet.footer-portlet-javascript=/dist/custom-fields.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/libs/leaflet/leaflet.js",
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
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		List<Form> listaForm = (List<Form>) renderRequest.getAttribute(GestioneFormsPortletKeys.LISTA_FORM);
		long siteGroupId = themeDisplay.getSiteGroupId();
		long organizationIdSitePrincipale = themeDisplay.getSiteGroup().getOrganizationId();
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,GestioneFormsPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,GestioneFormsPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
				
		String nome = ParamUtil.getString(renderRequest, GestioneFormsPortletKeys.NOME_RICERCA);
		String dataInserimentoDaString = ParamUtil.getString(renderRequest, GestioneFormsPortletKeys.DATA_INSERIMENTO_DA);
		String dataInserimentoAString = ParamUtil.getString(renderRequest, GestioneFormsPortletKeys.DATA_INSERIMENTO_A);
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;
		long totale = 0;
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		boolean direzione = false;

		if (orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "formId";
		}

		OrderByComparator<Form> comparator = OrderByComparatorFactoryUtil.create("Form", orderByCol, direzione);

		try {
			
			if(Validator.isNotNull(dataInserimentoDaString)) {
				dataInserimentoDa = simpleDateFormat.parse(dataInserimentoDaString);
			}
			
			if(Validator.isNotNull(dataInserimentoAString)) {
				dataInserimentoA = simpleDateFormat.parse(dataInserimentoAString);
			}
			
			listaForm = formLocalService.search(nome, dataInserimentoDa, dataInserimentoA, siteGroupId, inizio, fine, comparator);
			totale = formLocalService.count(nome, dataInserimentoDa, dataInserimentoA);
			
		}catch(Exception e) {
			_log.error("Impossibile recuperare la lista dei form!" + e.getMessage());
		}
		
		if(listaForm == null) {
			listaForm = new ArrayList<Form>();
		}
		
		renderRequest.setAttribute(GestioneFormsPortletKeys.LISTA_FORM, listaForm);	
		renderRequest.setAttribute(GestioneFormsPortletKeys.NOME_RICERCA, nome);
		renderRequest.setAttribute(GestioneFormsPortletKeys.DATA_INSERIMENTO_DA, dataInserimentoDaString);
		renderRequest.setAttribute(GestioneFormsPortletKeys.DATA_INSERIMENTO_A, dataInserimentoAString);
		renderRequest.setAttribute(GestioneFormsPortletKeys.SITE_GROUP_ID, siteGroupId);
		renderRequest.setAttribute(GestioneFormsPortletKeys.ORGANIZATION_ID_SITE_PRINCIPALE, organizationIdSitePrincipale);
		renderRequest.setAttribute("totaleElementi", totale);
		
		
		// Rimozione messaggi default
		
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	    

	    SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	    
	    super.render(renderRequest, renderResponse);
	}
}