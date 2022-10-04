package it.servizidigitali.gestionepagamenti.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.persistence.PagamentoFinder;

@Component(service = PagamentoFinder.class)
public class PagamentoFinderImpl extends PagamentoFinderBaseImpl implements PagamentoFinder {

	@Override
	public List<Pagamento> findByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, String categoria, String stato, String gateway, String canale,
			String codiceFiscale, String identificativoPagamento, String codiceIuv, long idPagamento, int inizio, int fine, OrderByComparator<Pagamento> ordine) {
		
		DynamicQuery dynamicQuery = this.buildDynamicQueryByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa, dataOperazioneA, groupId, categoria, stato, gateway, canale, codiceFiscale, identificativoPagamento, codiceIuv, idPagamento);
		
		return this.pagamentoPersistence.findWithDynamicQuery(dynamicQuery, inizio, fine, ordine);
	}
	
	@Override
	public long countByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, String categoria, String stato, String gateway, String canale,
			String codiceFiscale, String identificativoPagamento, String codiceIuv, long idPagamento) {
		
		DynamicQuery dynamicQuery = this.buildDynamicQueryByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa, dataOperazioneA, groupId, categoria, stato, gateway, canale, codiceFiscale, identificativoPagamento, codiceIuv, idPagamento);
		
		return this.pagamentoPersistence.countWithDynamicQuery(dynamicQuery);
	}
	
	private DynamicQuery buildDynamicQueryByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, String categoria, String stato, String gateway, String canale,
			String codiceFiscale, String identificativoPagamento, String codiceIuv, long idPagamento) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Pagamento.class, this.getClassLoader());
		
		if (Validator.isNotNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.gt("createDate", dataInserimentoDa));
		}
		if (Validator.isNotNull(dataInserimentoA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.lt("createDate", dataInserimentoA));
		}
		if (Validator.isNotNull(dataOperazioneDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.gt("modifiedDate", dataOperazioneDa));
		}
		if (Validator.isNotNull(dataOperazioneA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.lt("modifiedDate", dataOperazioneA));
		}
		if (groupId != 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		}
		/*if (Validator.isNotNull(categoria)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("", categoria));
		}*/
		if (Validator.isNotNull(stato)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("stato", stato));
		}
		if (Validator.isNotNull(gateway)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("gateway", gateway));
		}
		if (Validator.isNotNull(canale)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("canale", canale));
		}
		if (Validator.isNotNull(codiceFiscale)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("idFiscaleCliente", codiceFiscale));
		}
		/*if (Validator.isNotNull(identificativoPagamento)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("", identificativoPagamento));
		}*/
		if (Validator.isNotNull(codiceIuv)) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("iuv", codiceIuv));
		}
		if (idPagamento != 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("pagamentoId", idPagamento));
		}
		
		return dynamicQuery;
	}

}
