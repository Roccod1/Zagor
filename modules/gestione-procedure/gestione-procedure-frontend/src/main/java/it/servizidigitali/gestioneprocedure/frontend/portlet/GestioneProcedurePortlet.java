package it.servizidigitali.gestioneprocedure.frontend.portlet;

import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.frontend.service.GestioneProcedureMiddlewareService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

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
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneProcedure",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneProcedurePortlet extends MVCPortlet {
	public static final Log _log = LogFactoryUtil.getLog(GestioneProcedurePortlet.class);
	
	@Reference
	private ProceduraLocalService proceduraLocalService;
	
	@Reference
	private GestioneProcedureMiddlewareService gestioneProcedureMiddlewareService;
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		List<Procedura> listaProcedure = (List<Procedura>) renderRequest.getAttribute(GestioneProcedurePortletKeys.LISTA_PROCEDURE);
		
		Procedura procedura = gestioneProcedureMiddlewareService.getProcedura(themeDisplay.getSiteGroupId(), 45101, true);
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,GestioneProcedurePortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,GestioneProcedurePortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		String nome = ParamUtil.getString(renderRequest, GestioneProcedurePortletKeys.NOME_RICERCA);
		String attiva = ParamUtil.getString(renderRequest, GestioneProcedurePortletKeys.STATO_RICERCA);
		String dataInserimentoDaString = ParamUtil.getString(renderRequest, GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA);
		String dataInserimentoAString = ParamUtil.getString(renderRequest, GestioneProcedurePortletKeys.DATA_INSERIMENTO_A);
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		boolean direzione = false;

		if (orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "proceduraId";
		}

		OrderByComparator<Procedura> comparator = OrderByComparatorFactoryUtil.create("Procedura", orderByCol, direzione);
		
		
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
		

		listaProcedure = proceduraLocalService.search(nome, attiva, dataInserimentoDa, dataInserimentoA, themeDisplay.getSiteGroupId(), inizio, fine, comparator);
		long totale = proceduraLocalService.count(nome, attiva, dataInserimentoDa, dataInserimentoA, themeDisplay.getSiteGroupId());

		renderRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_PROCEDURE, listaProcedure);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.NOME_RICERCA, nome);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.STATO_RICERCA, attiva);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA, dataInserimentoDaString);
		renderRequest.setAttribute(GestioneProcedurePortletKeys.DATA_INSERIMENTO_A, dataInserimentoAString);
		renderRequest.setAttribute("totaleElementi", totale);
		
		// Rimozione messaggi default
		
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(renderRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		super.render(renderRequest, renderResponse);
	}

}