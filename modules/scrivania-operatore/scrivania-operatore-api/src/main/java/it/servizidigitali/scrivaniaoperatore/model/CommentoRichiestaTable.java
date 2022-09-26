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
 * The table class for the &quot;commento_richiesta&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiesta
 * @generated
 */
public class CommentoRichiestaTable extends BaseTable<CommentoRichiestaTable> {

	public static final CommentoRichiestaTable INSTANCE =
		new CommentoRichiestaTable();

	public final Column<CommentoRichiestaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Long> commentoRichiestaId =
		createColumn(
			"commentoRichiestaId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CommentoRichiestaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, String> testo = createColumn(
		"testo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, String> taskId = createColumn(
		"taskId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Boolean> visibile =
		createColumn(
			"visibile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CommentoRichiestaTable, Long> richiestaId =
		createColumn(
			"richiestaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CommentoRichiestaTable() {
		super("commento_richiesta", CommentoRichiestaTable::new);
	}

}