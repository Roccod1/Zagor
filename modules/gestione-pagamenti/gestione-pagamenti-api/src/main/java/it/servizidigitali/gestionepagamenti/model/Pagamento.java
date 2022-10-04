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

package it.servizidigitali.gestionepagamenti.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Pagamento service. Represents a row in the &quot;pagamento&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PagamentoModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.gestionepagamenti.model.impl.PagamentoImpl"
)
@ProviderType
public interface Pagamento extends PagamentoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Pagamento, Long> PAGAMENTO_ID_ACCESSOR =
		new Accessor<Pagamento, Long>() {

			@Override
			public Long get(Pagamento pagamento) {
				return pagamento.getPagamentoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Pagamento> getTypeClass() {
				return Pagamento.class;
			}

		};

	public
		it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento
			getStatoEnum();

	public void setStatoEnum(
		it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento
			statoEnum);

	public String getNomeOrganizzazione();

	public void setNomeOrganizzazione(String nomeOrganizzazione);

}