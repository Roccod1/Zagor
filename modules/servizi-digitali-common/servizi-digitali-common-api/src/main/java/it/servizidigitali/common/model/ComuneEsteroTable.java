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
 * The table class for the &quot;comune_estero&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEstero
 * @generated
 */
public class ComuneEsteroTable extends BaseTable<ComuneEsteroTable> {

	public static final ComuneEsteroTable INSTANCE = new ComuneEsteroTable();

	public final Column<ComuneEsteroTable, Long> comuneEsteroId = createColumn(
		"comuneEsteroId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ComuneEsteroTable, Integer> codice = createColumn(
		"codice", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComuneEsteroTable, String> denominazione = createColumn(
		"denominazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ComuneEsteroTable() {
		super("comune_estero", ComuneEsteroTable::new);
	}

}