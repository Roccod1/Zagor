package it.servizidigitali.gestioneservizi.frontend.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author filierim
 * */

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"mvc.command.name=/cerca"
	},
	service = MVCActionCommand.class
)
public class RicercaServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(RicercaServizioActionCommand.class);
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		int cur = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM, GestioneServiziPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM, GestioneServiziPortletKeys.DEFAULT_DELTA);
		String nomeOrdinamento = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String direzioneOrdinamento = ParamUtil.getString(actionRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		String nome = ParamUtil.getString(actionRequest, GestioneServiziPortletKeys.NOME_RICERCA);
		String codice = ParamUtil.getString(actionRequest, GestioneServiziPortletKeys.CODICE_RICERCA);
		Boolean soloServiziAttivi = ParamUtil.getBoolean(actionRequest, GestioneServiziPortletKeys.SOLO_SERVIZI_ATTIVI_RICERCA, false);
		
		long totaleElementi = 0;
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];

		if (Validator.isNull(nomeOrdinamento)) {
			_log.debug("Nessun ordinamento impostato. Uso di default servizioId");
			nomeOrdinamento = "servizioId";
		}

		boolean direzione = "desc".equals(direzioneOrdinamento.toLowerCase()) ? false : true;

		OrderByComparator<Servizio> ordine = OrderByComparatorFactoryUtil.create("Servizio", nomeOrdinamento, direzione);
		
		List<Servizio> listaServiziFiltrata = servizioLocalService.searchServizio(nome, codice, soloServiziAttivi, inizio, fine, ordine);
		totaleElementi = servizioLocalService.count(nome,codice,soloServiziAttivi);
		actionRequest.setAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI, listaServiziFiltrata);
		actionRequest.setAttribute("totaleElementi", totaleElementi);
		
		//imposto nuovamente i parametri ricevuti in ingresso per l'integrazione tra formRicerca e searchContainer
		actionRequest.setAttribute(GestioneServiziPortletKeys.NOME_RICERCA, nome);
		actionRequest.setAttribute(GestioneServiziPortletKeys.CODICE_RICERCA,codice);
		actionRequest.setAttribute(GestioneServiziPortletKeys.SOLO_SERVIZI_ATTIVI_RICERCA, soloServiziAttivi);

	}
}