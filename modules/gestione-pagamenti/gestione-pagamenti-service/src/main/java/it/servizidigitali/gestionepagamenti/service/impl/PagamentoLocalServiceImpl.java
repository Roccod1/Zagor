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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.base.PagamentoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestionepagamenti.model.Pagamento", service = AopService.class)
public class PagamentoLocalServiceImpl extends PagamentoLocalServiceBaseImpl {

	@Override
	public List<Pagamento> search(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, String organizzazione, String categoria, String stato, String gateway, String canale,
			String servizio, String cliente, String identificativoPagamento, String codiceIuv, long idPagamento, int inizio, int fine, String orderByCol, String orderByType) {
		
		boolean direzione = true;

		if ("desc".equalsIgnoreCase(orderByType)) {
			direzione = false;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "pagamentoId";
		}

		OrderByComparator<Pagamento> comparator = OrderByComparatorFactoryUtil.create("Pagamento", orderByCol, direzione);
		
		return this.pagamentoFinder.findByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, organizzazione, categoria, stato, gateway, canale, servizio, cliente,
				identificativoPagamento, codiceIuv, idPagamento, inizio, fine, comparator);
	}
	
	@Override
	public long countByFilters(Date dataInserimentoDa, Date dataInserimentoA, Date dataOperazioneDa,
			Date dataOperazioneA, String organizzazione, String categoria, String stato, String gateway, String canale,
			String servizio, String cliente, String identificativoPagamento, String codiceIuv, long idPagamento) {
		
		return this.pagamentoFinder.countByFilters(dataInserimentoDa, dataInserimentoA, dataOperazioneDa,
				dataOperazioneA, organizzazione, categoria, stato, gateway, canale, servizio, cliente,
				identificativoPagamento, codiceIuv, idPagamento);
	}
}