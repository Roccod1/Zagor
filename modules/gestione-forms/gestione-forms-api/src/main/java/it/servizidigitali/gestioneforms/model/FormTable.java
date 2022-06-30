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

package it.servizidigitali.gestioneforms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;form&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Form
 * @generated
 */
public class FormTable extends BaseTable<FormTable> {

	public static final FormTable INSTANCE = new FormTable();

	public final Column<FormTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> formId = createColumn(
		"formId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FormTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> json = createColumn(
		"json", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Boolean> principale = createColumn(
		"principale", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FormTable, Boolean> multiutente = createColumn(
		"multiutente", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FormTable() {
		super("form", FormTable::new);
	}

}