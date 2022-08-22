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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;istanza_form&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaForm
 * @generated
 */
public class IstanzaFormTable extends BaseTable<IstanzaFormTable> {

	public static final IstanzaFormTable INSTANCE = new IstanzaFormTable();

	public final Column<IstanzaFormTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Long> istanzaFormId = createColumn(
		"istanzaFormId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<IstanzaFormTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, String> json = createColumn(
		"json", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Long> formId = createColumn(
		"formId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IstanzaFormTable, Long> richiestaId = createColumn(
		"richiestaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private IstanzaFormTable() {
		super("istanza_form", IstanzaFormTable::new);
	}

}