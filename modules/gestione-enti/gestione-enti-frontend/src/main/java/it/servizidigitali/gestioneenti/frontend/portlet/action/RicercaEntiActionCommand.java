package it.servizidigitali.gestioneenti.frontend.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;

/**
 * @author pindi
 */

@Component(immediate = true,
		property = {
			"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, 
			"mvc.command.name=" + GestioneEntiPortletKeys.CERCA_ACTION_COMMAND_NAME 
		},
		service = MVCActionCommand.class
)
public class RicercaEntiActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(RicercaEntiActionCommand.class);

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		int cur = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);

		String codiceIpa = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_CODICE_IPA_RICERCA);
		String nome = ParamUtil.getString(actionRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_NOME_RICERCA);
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		if (Validator.isNull(orderByCol)) {
			_log.debug("Nessun ordinamento impostato. Uso di default organizationId");
			orderByCol = "organizationId";
		}

		List<Organization> listaOrganization = servizioEnteLocalService.search(nome, codiceIpa, inizio, fine, orderByCol, orderByType);
		actionRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI, listaOrganization);

	}
}