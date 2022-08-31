package it.servizidigitali.gestioneprocedure.frontend.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
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

import it.servizidigitali.gestioneprocedure.frontend.constants.GestioneProcedurePortletKeys;
import it.servizidigitali.gestioneprocedure.frontend.portlet.GestioneProcedurePortlet;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneProcedurePortletKeys.GESTIONEPROCEDURE,
			"mvc.command.name=" + GestioneProcedurePortletKeys.RICERCA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class RicercaActionCommand extends BaseMVCActionCommand{
	
	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		String nome = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.NOME_RICERCA);
		String attiva = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.STATO_RICERCA);
		
		String dataInserimentoDaString = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA);
		String dataInserimentoAString = ParamUtil.getString(actionRequest, GestioneProcedurePortletKeys.DATA_INSERIMENTO_A);
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;
		
		if(Validator.isNotNull(dataInserimentoDaString)) {
			dataInserimentoDa = GestioneProcedurePortlet.simpleDateFormat.parse(dataInserimentoDaString);
		}
			
		if(Validator.isNotNull(dataInserimentoAString)) {
			dataInserimentoA = GestioneProcedurePortlet.simpleDateFormat.parse(dataInserimentoAString);
		}
		
		int cur = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneProcedurePortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneProcedurePortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		List<Procedura> listaProcedure = proceduraLocalService.search(nome, attiva, dataInserimentoDa, dataInserimentoA, themeDisplay.getSiteGroupId(), delta, cur, orderByCol, orderByType);
		
		actionRequest.setAttribute(GestioneProcedurePortletKeys.LISTA_PROCEDURE, listaProcedure);
		actionRequest.setAttribute(GestioneProcedurePortletKeys.NOME_RICERCA, nome);
		actionRequest.setAttribute(GestioneProcedurePortletKeys.STATO_RICERCA, attiva);
		actionRequest.setAttribute(GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA, dataInserimentoDaString);
		actionRequest.setAttribute(GestioneProcedurePortletKeys.DATA_INSERIMENTO_A, dataInserimentoAString);
		
	}
	
}
