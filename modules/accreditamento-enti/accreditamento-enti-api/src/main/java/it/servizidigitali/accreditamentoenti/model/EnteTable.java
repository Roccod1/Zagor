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

package it.servizidigitali.accreditamentoenti.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ente&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Ente
 * @generated
 */
public class EnteTable extends BaseTable<EnteTable> {

	public static final EnteTable INSTANCE = new EnteTable();

	public final Column<EnteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, Long> enteId = createColumn(
		"enteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EnteTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EnteTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> denominazione = createColumn(
		"denominazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> strutturaRiferimento = createColumn(
		"strutturaRiferimento", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> sitoWeb = createColumn(
		"sitoWeb", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> codiceIPA = createColumn(
		"codiceIPA", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteTable, String> pec = createColumn(
		"pec", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EnteTable() {
		super("ente", EnteTable::new);
	}

}