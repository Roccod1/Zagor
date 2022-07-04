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

package it.servizidigitali.gestioneservizi.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;_servizio_tipologia&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @see Tipologia
 * @generated
 */
public class _servizio_tipologiaTable
	extends BaseTable<_servizio_tipologiaTable> {

	public static final _servizio_tipologiaTable INSTANCE =
		new _servizio_tipologiaTable();

	public final Column<_servizio_tipologiaTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<_servizio_tipologiaTable, Long> servizioId =
		createColumn(
			"servizioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<_servizio_tipologiaTable, Long> tipologiaId =
		createColumn(
			"tipologiaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private _servizio_tipologiaTable() {
		super("_servizio_tipologia", _servizio_tipologiaTable::new);
	}

}