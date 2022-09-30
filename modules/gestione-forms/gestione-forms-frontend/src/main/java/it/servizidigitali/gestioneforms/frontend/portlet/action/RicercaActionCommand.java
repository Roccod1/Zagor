package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.frontend.portlet.GestioneFormsPortlet;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

/**
 * @author COSTABILEE
 *
 */
@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=" + GestioneFormsPortletKeys.RICERCA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class RicercaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(RicercaActionCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String nome = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.NOME_RICERCA);

		String dataInserimentoDaString = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.DATA_INSERIMENTO_DA);
		String dataInserimentoAString = ParamUtil.getString(actionRequest, GestioneFormsPortletKeys.DATA_INSERIMENTO_A);
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;
		
		if(Validator.isNotNull(dataInserimentoDaString)) {
			dataInserimentoDa = GestioneFormsPortlet.simpleDateFormat.parse(dataInserimentoDaString);
		}
			
		if(Validator.isNotNull(dataInserimentoAString)) {
			dataInserimentoA = GestioneFormsPortlet.simpleDateFormat.parse(dataInserimentoAString);
		}
		
		int cur = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneFormsPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneFormsPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		List<Form> listaForm = formLocalService.search(nome, dataInserimentoDa, dataInserimentoA, themeDisplay.getSiteGroupId(), inizio, fine, orderByCol, orderByType);
		long totale = formLocalService.count(nome, dataInserimentoDa, dataInserimentoA);
		
		actionRequest.setAttribute(GestioneFormsPortletKeys.LISTA_FORM, listaForm);
		
		actionRequest.setAttribute(GestioneFormsPortletKeys.NOME_RICERCA, nome);
		actionRequest.setAttribute(GestioneFormsPortletKeys.DATA_INSERIMENTO_DA, dataInserimentoDaString);
		actionRequest.setAttribute(GestioneFormsPortletKeys.DATA_INSERIMENTO_A, dataInserimentoAString);
		actionRequest.setAttribute("totaleElementi", totale);
		
	}
}
