package it.servizidigitali.scrivaniacittadino.frontend.service;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(name = "scrivaniaCittadinoMiddlewareService", immediate = true, service = ScrivaniaCittadinoMiddlewareService.class, configurationPid = {
		"it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration" })
public class ScrivaniaCittadinoMiddlewareService {

	private static final Log _log = LogFactoryUtil.getLog(ScrivaniaCittadinoMiddlewareService.class);

	private volatile ClientPagamentiEnteConfiguration accountClientPagamentiEnteConfiguration;
	private ConfigurationProvider configurationProvider;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

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

	@Reference
	private PagamentoLocalService pagamentoLocalService;

	public List<Richiesta> getPagamentiUtente(String codiceFiscale, String filterOggettoNote, String stato, long companyId, long organizationId, long groupId, boolean attivo, int cur, int delta,
			String orderByCol, String orderByType) throws Exception {

		try {

			List<Long> serviziIds = new ArrayList<Long>();
			Set<Long> procedureIds = new HashSet<Long>();

			Tipologia tipologia = tipologiaLocalService.getTipologiaByCodice(TipoServizio.PAGAMENTO.name());

			List<Servizio> listServiziByTipologia = servizioLocalService.getTipologiaServizios(tipologia.getTipologiaId());
			listServiziByTipologia.stream().forEach(servizio -> serviziIds.add(servizio.getServizioId()));
			List<Procedura> listaProcedure = proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(serviziIds, groupId, attivo);

			listaProcedure.stream().forEach(procedura -> procedureIds.add(procedura.getProceduraId()));

			RichiestaFilters richiestaFilter = new RichiestaFilters();
			richiestaFilter.setServiziIds(new HashSet<Long>(serviziIds));
			richiestaFilter.setCodiceFiscale(codiceFiscale);
			richiestaFilter.setCompanyId(companyId);
			richiestaFilter.setGroupId(groupId);

			if (Validator.isNotNull(filterOggettoNote)) {
				richiestaFilter.setOggettoNote(filterOggettoNote);
			}

			if (Validator.isNotNull(stato)) {
				richiestaFilter.setTipo(stato);
			}

			if (Validator.isNotNull(orderByCol)) {
				richiestaFilter.setOrderByCol(orderByCol);
			}

			if (Validator.isNotNull(orderByType)) {
				richiestaFilter.setOrderByType(orderByType);
			}

			int startEnd[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
			int start = startEnd[0];
			int end = startEnd[1];
			if (startEnd[0] <= 0 || startEnd[1] <= 0) {
				start = QueryUtil.ALL_POS;
				end = QueryUtil.ALL_POS;
			}

			return richiestaLocalService.search(richiestaFilter, start, end);

		}
		catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * @param richiestaId
	 * @param groupId
	 * @return
	 * @throws PortalException
	 */
	public String getRicevutaTelematicaPDFPagamentoUrl(long richiestaId, long groupId) throws PortalException {

		List<TipoServizio> tipiServizioByRichiesta = getTipiServizioByRichiesta(richiestaId);

		if (tipiServizioByRichiesta.contains(TipoServizio.PAGAMENTO)) {
			accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, groupId);
			String ricevutaPagamentoPrefixUrl = accountClientPagamentiEnteConfiguration.ricevutaPagamentoPrefixUrl();
			Pagamento pagamentoByRichistaId = pagamentoLocalService.getPagamentoByRichistaId(richiestaId);
			return ricevutaPagamentoPrefixUrl + pagamentoByRichistaId.getRiferimentoEsternoId();

		}
		return null;
	}

	/**
	 *
	 * @param richiestaId
	 * @return
	 * @throws Exception
	 */
	public List<TipoServizio> getTipiServizioByRichiesta(long richiestaId) throws PortalException {
		Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);
		long servizioId = richiesta.getServizioId();
		if (servizioId != 0) {
			Servizio servizio = servizioLocalService.getServizioById(servizioId);
			List<Tipologia> listaTipologie = servizio.getListaTipologie();
			if (listaTipologie != null) {
				List<TipoServizio> tipoServizios = new ArrayList<TipoServizio>();
				for (Tipologia tipologia : listaTipologie) {
					tipoServizios.add(TipoServizio.valueOf(tipologia.getCodice()));
				}
				return tipoServizios;
			}
		}
		return null;
	}
}
