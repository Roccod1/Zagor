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

package it.servizidigitali.gestionepagamenti.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface PagamentoFinder {

	public java.util.List<it.servizidigitali.gestionepagamenti.model.Pagamento>
		findByFilters(
			java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
			java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
			long groupId, String categoria, String stato, String gateway,
			String canale, String codiceFiscale, String identificativoPagamento,
			String codiceIuv, long idPagamento, int inizio, int fine,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestionepagamenti.model.Pagamento> ordine);

	public long countByFilters(
		java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
		java.util.Date dataOperazioneDa, java.util.Date dataOperazioneA,
		long groupId, String categoria, String stato, String gateway,
		String canale, String codiceFiscale, String identificativoPagamento,
		String codiceIuv, long idPagamento);

}