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

package it.servizidigitali.common.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;stato_estero&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see StatoEstero
 * @generated
 */
public class StatoEsteroTable extends BaseTable<StatoEsteroTable> {

	public static final StatoEsteroTable INSTANCE = new StatoEsteroTable();

	public final Column<StatoEsteroTable, Long> statoEsteroId = createColumn(
		"statoEsteroId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StatoEsteroTable, Integer> continente = createColumn(
		"continente", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<StatoEsteroTable, Integer> codiceArea = createColumn(
		"codiceArea", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<StatoEsteroTable, Integer> codiceStato = createColumn(
		"codiceStato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<StatoEsteroTable, String> denominazione = createColumn(
		"denominazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StatoEsteroTable, String> denominazioneEng =
		createColumn(
			"denominazioneEng", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private StatoEsteroTable() {
		super("stato_estero", StatoEsteroTable::new);
	}

}