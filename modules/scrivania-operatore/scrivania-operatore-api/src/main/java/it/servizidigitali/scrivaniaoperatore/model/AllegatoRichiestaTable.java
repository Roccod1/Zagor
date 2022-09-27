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
 * The table class for the &quot;allegato_richiesta&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiesta
 * @generated
 */
public class AllegatoRichiestaTable extends BaseTable<AllegatoRichiestaTable> {

	public static final AllegatoRichiestaTable INSTANCE =
		new AllegatoRichiestaTable();

	public final Column<AllegatoRichiestaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Long> allegatoRichiestaId =
		createColumn(
			"allegatoRichiestaId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AllegatoRichiestaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, String> idDocumentale =
		createColumn(
			"idDocumentale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Boolean> principale =
		createColumn(
			"principale", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Boolean> interno = createColumn(
		"interno", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Boolean> visibile =
		createColumn(
			"visibile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AllegatoRichiestaTable, Long> richiestaId =
		createColumn(
			"richiestaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AllegatoRichiestaTable() {
		super("allegato_richiesta", AllegatoRichiestaTable::new);
	}

}