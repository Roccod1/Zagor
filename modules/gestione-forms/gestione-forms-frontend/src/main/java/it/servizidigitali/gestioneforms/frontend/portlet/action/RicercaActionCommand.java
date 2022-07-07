package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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
			"mvc.command.name=/ricerca" 
		}, 
service = { MVCActionCommand.class }
)
public class RicercaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(RicercaActionCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		String codice = ParamUtil.getString(actionRequest, "codice");

		String dataInserimentoDaString = ParamUtil.getString(actionRequest, "dataInserimentoDa");
		String dataInserimentoAString = ParamUtil.getString(actionRequest, "dataInserimentoA");
		
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
		
		List<Form> listaForm = formLocalService.search(codice, dataInserimentoDa, dataInserimentoA, delta, cur, orderByCol, orderByType);
		
		actionRequest.setAttribute("listaForm", listaForm);
		
		
		actionRequest.setAttribute("codice", codice);
		actionRequest.setAttribute("dataInserimentoDa", dataInserimentoDaString);
		actionRequest.setAttribute("dataInserimentoA", dataInserimentoAString);
		
	}

}
