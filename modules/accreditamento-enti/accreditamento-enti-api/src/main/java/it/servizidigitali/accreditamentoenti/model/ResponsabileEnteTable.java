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
 * The table class for the &quot;responsabile_ente&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnte
 * @generated
 */
public class ResponsabileEnteTable extends BaseTable<ResponsabileEnteTable> {

	public static final ResponsabileEnteTable INSTANCE =
		new ResponsabileEnteTable();

	public final Column<ResponsabileEnteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Long> responsabileEnteId =
		createColumn(
			"responsabileEnteId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ResponsabileEnteTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Long> responsabileUserId =
		createColumn(
			"responsabileUserId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ResponsabileEnteTable, Long> enteId = createColumn(
		"enteId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ResponsabileEnteTable() {
		super("responsabile_ente", ResponsabileEnteTable::new);
	}

}