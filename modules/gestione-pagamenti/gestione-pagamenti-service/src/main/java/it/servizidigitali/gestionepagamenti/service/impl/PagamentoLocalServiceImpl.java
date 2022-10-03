/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.servizidigitali.gestionepagamenti.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.base.PagamentoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestionepagamenti.model.Pagamento", service = AopService.class)
public class PagamentoLocalServiceImpl extends PagamentoLocalServiceBaseImpl {
	
	private static final DateFormat DATE_FORMAT_ITALY_WITH_TIME = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy HH:mm");

	@Override
	public List<Pagamento> search(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, String categoria, String stato, String gateway, String canale,
			String codiceFiscale, String identificativoPagamento, String codiceIuv, long idPagamento, int inizio, int fine, String orderByCol, String orderByType) {
		
		boolean direzione = true;

		if ("desc".equalsIgnoreCase(orderByType)) {
			direzione = false;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "pagamentoId";
		}

		OrderByComparator<Pagamento> comparator = OrderByComparatorFactoryUtil.create("Pagamento", orderByCol, direzione);
		
		List<Pagamento> pagamenti = this.pagamentoFinder.findByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, groupId, categoria, stato, gateway, canale, codiceFiscale,
				identificativoPagamento, codiceIuv, idPagamento, inizio, fine, comparator);
		
		pagamenti.forEach(pagamento -> initAdditionalData(pagamento));
		
		return pagamenti;
	}
	
	@Override
	public long countByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, long groupId, String categoria, String stato, String gateway, String canale,
			String codiceFiscale, String identificativoPagamento, String codiceIuv, long idPagamento) {
		
		return this.pagamentoFinder.countByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, groupId, categoria, stato, gateway, canale, codiceFiscale,
				identificativoPagamento, codiceIuv, idPagamento);
	}
	
	private void initAdditionalData(Pagamento pagamento) {
		Date createDate = pagamento.getCreateDate();
		if(Validator.isNotNull(createDate)) {
			pagamento.setDataInserimentoFormatted(DATE_FORMAT_ITALY_WITH_TIME.format(createDate));
		}
		
		String stato = pagamento.getStato();
		
		if (Validator.isNotNull(stato)) {
			StatoPagamento statoPagamento = StatoPagamento.valueOf(stato);
			pagamento.setStatoFormatted(statoPagamento.getDescrizione());
		}
	}
}