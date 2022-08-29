package it.servizidigitali.gestioneprocessi.frontend.portlet.action;

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

import it.servizidigitali.gestioneprocessi.frontend.constants.GestioneProcessiPortletKeys;
import it.servizidigitali.gestioneprocessi.frontend.portlet.GestioneProcessiPortlet;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;

/**
 * @author COSTABILEE
 *
 */

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneProcessiPortletKeys.GESTIONEPROCESSI,
			"mvc.command.name=" + GestioneProcessiPortletKeys.RICERCA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class RicercaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(RicercaActionCommand.class);
	
	@Reference
	private ProcessoLocalService processoLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String nome = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.NOME_RICERCA);
		
		String dataInserimentoDaString = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.DATA_INSERIMENTO_DA);
		String dataInserimentoAString = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.DATA_INSERIMENTO_A);
		
		Date dataInserimentoDa = null;
		Date dataInserimentoA = null;
		
		if(Validator.isNotNull(dataInserimentoDaString)) {
			dataInserimentoDa = GestioneProcessiPortlet.simpleDateFormat.parse(dataInserimentoDaString);
		}
			
		if(Validator.isNotNull(dataInserimentoAString)) {
			dataInserimentoA = GestioneProcessiPortlet.simpleDateFormat.parse(dataInserimentoAString);
		}
		
		int cur = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneProcessiPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneProcessiPortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		List<Processo> listaProcessi = processoLocalService.search(nome, dataInserimentoDa, dataInserimentoA, delta, cur, orderByCol, orderByType);
		
		actionRequest.setAttribute(GestioneProcessiPortletKeys.LISTA_PROCESSI, listaProcessi);
		
		actionRequest.setAttribute(GestioneProcessiPortletKeys.NOME_RICERCA, nome);
		actionRequest.setAttribute(GestioneProcessiPortletKeys.DATA_INSERIMENTO_DA, dataInserimentoDaString);
		actionRequest.setAttribute(GestioneProcessiPortletKeys.DATA_INSERIMENTO_A, dataInserimentoAString);
		
	}

}
