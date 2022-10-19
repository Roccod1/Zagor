/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package it.servizidigitali.gestionepagamenti.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.base.PagamentoLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestionepagamenti.model.Pagamento", service = AopService.class)
public class PagamentoLocalServiceImpl extends PagamentoLocalServiceBaseImpl {
	
	@Override
	public List<Pagamento> search(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, long servizioId, String stato, String gateway, String canale,
			String codiceFiscale, String codiceIuv, long idPagamento, int inizio, int fine, String orderByCol,
			String orderByType) {

		boolean direzione = true;

		if ("desc".equalsIgnoreCase(orderByType)) {
			direzione = false;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "pagamentoId";
		}

		OrderByComparator<Pagamento> comparator = OrderByComparatorFactoryUtil.create("Pagamento", orderByCol,
				direzione);

		return this.pagamentoFinder.findByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, groupId, servizioId, stato, gateway, canale, codiceFiscale, codiceIuv, idPagamento,
				inizio, fine, comparator);
	}

	@Override
	public long countByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, long servizioId, String stato, String gateway, String canale,
			String codiceFiscale, String codiceIuv, long idPagamento) {

		return this.pagamentoFinder.countByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, groupId, servizioId, stato, gateway, canale, codiceFiscale, codiceIuv, idPagamento);
	}

	@Override
	public List<Pagamento> getPagamentiByStato(String stato) {
		return pagamentoPersistence.findByStato(stato);
	}

	@Override
	public Pagamento create(long groupId, long userId, String userName, String idCredito, String idFiscaleCliente,
			String denominazioneCliente, String emailQuietanza, String causale, long servizioId, String nomeServizio,
			BigDecimal importo, BigDecimal commissioni, String canale, String gateway, String iud, String iuv,
			String idSessione, String pathAvviso, boolean emailInviata, String stato, long richiestaId) {
		
		Pagamento pagamento = pagamentoPersistence.create(counterLocalService.increment());

		pagamento.setGroupId(groupId);
		pagamento.setUserId(userId);
		pagamento.setUserName(userName);
		pagamento.setIdCredito(idCredito);
		pagamento.setIdFiscaleCliente(idFiscaleCliente);
		pagamento.setDenominazioneCliente(denominazioneCliente);
		pagamento.setEmailQuietanza(emailQuietanza);
		pagamento.setCausale(causale);
		pagamento.setServizioId(servizioId);
		pagamento.setNomeServizio(nomeServizio);
		pagamento.setImporto(importo);
		pagamento.setCommissioni(commissioni);
		pagamento.setCanale(canale);
		pagamento.setGateway(gateway);
		pagamento.setIud(iud);
		pagamento.setIuv(iuv);
		pagamento.setIdSessione(idSessione);
		pagamento.setPathAvviso(pathAvviso);
		pagamento.setEmailInviata(emailInviata);
		pagamento.setStato(stato);
		pagamento.setRichiestaId(richiestaId);

		return pagamentoPersistence.update(pagamento);
	}
}