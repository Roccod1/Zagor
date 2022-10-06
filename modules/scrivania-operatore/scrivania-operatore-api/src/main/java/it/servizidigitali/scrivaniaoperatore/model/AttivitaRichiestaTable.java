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
 * The table class for the &quot;attivita_richiesta&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AttivitaRichiesta
 * @generated
 */
public class AttivitaRichiestaTable extends BaseTable<AttivitaRichiestaTable> {

	public static final AttivitaRichiestaTable INSTANCE =
		new AttivitaRichiestaTable();

	public final Column<AttivitaRichiestaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Long> attivitaRichiestaId =
		createColumn(
			"attivitaRichiestaId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AttivitaRichiestaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttivitaRichiestaTable, Long> richiestaId =
		createColumn(
			"richiestaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AttivitaRichiestaTable() {
		super("attivita_richiesta", AttivitaRichiestaTable::new);
	}

}