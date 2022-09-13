package it.servizidigitali.scrivaniacittadino.frontend.service;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(name = "scrivaniaCittadinoMiddlewareService", immediate = true, service = ScrivaniaCittadinoMiddlewareService.class)
public class ScrivaniaCittadinoMiddlewareService {

	private static final Log _log = LogFactoryUtil.getLog(ScrivaniaCittadinoMiddlewareService.class);

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;

	
	public List<Richiesta> getPagamentiUtente(String codiceFiscale, long companyId, long organizationId, long groupId, boolean attivo, int cur, int delta) throws Exception {

		try {
			
			List<Long> listaIdServizi = new ArrayList<Long>();
			Set<Long> setIdProcedura = new HashSet<Long>();

//			List<Tipologia> listaTipologieServizio = tipologiaLocalService.getTipologias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//			List<Tipologia> listaServiziPagamento = listaTipologieServizio.stream().filter(x -> TipoServizio.PAGAMENTO.toString().equalsIgnoreCase(x.getNome())).collect(Collectors.toList());
			
//			List<Servizi> test = tipologiaLocalService.get
			
			List<Object> listaServiziAttiviEnte = servizioEnteLocalService.getListaServiziByCompanyOrganizationAttivo(companyId, organizationId, attivo);

			List<Servizio> listaServizi = servizioLocalService.getServiziUtilizzabili(listaServiziAttiviEnte, "", 0, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS, "", "");

			listaServizi.stream().forEach(servizio -> listaIdServizi.add(servizio.getServizioId()));

			List<Procedura> listaProcedure = proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(listaIdServizi, groupId, attivo);

			listaProcedure.stream().forEach(procedura -> setIdProcedura.add(procedura.getProceduraId()));

			RichiestaFilters richiestaFilter = new RichiestaFilters();
			richiestaFilter.setProcedureIds(setIdProcedura);
			richiestaFilter.setCodiceFiscale(codiceFiscale);
			richiestaFilter.setCompanyId(companyId);
			richiestaFilter.setGroupId(groupId);
			richiestaFilter.setTipo(TipoServizio.PAGAMENTO.toString());
			
			
			int startEnd[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
			int start = startEnd[0];
			int end = startEnd[1];
			if (startEnd[0] <= 0 || startEnd[1] <= 0) {
				start = QueryUtil.ALL_POS;
				end = QueryUtil.ALL_POS;
			}

			return richiestaLocalService.search(richiestaFilter, start, end);

		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}

enum TipoServizio {

	DICHIARAZIONE, AUTO_DICHIARAZIONE, CERTIFICATO, VISURA, PAGAMENTO, CONCORSO;

}
