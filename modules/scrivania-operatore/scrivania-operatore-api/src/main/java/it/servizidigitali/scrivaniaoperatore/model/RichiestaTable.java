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
 * The table class for the &quot;richiesta&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Richiesta
 * @generated
 */
public class RichiestaTable extends BaseTable<RichiestaTable> {

	public static final RichiestaTable INSTANCE = new RichiestaTable();

	public final Column<RichiestaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Long> richiestaId = createColumn(
		"richiestaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RichiestaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> codiceFiscale = createColumn(
		"codiceFiscale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> partitaIva = createColumn(
		"partitaIva", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> codiceFiscaleDelegato =
		createColumn(
			"codiceFiscaleDelegato", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> numeroProtocollo = createColumn(
		"numeroProtocollo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Date> dataProtocollo = createColumn(
		"dataProtocollo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> numeroProtocolloEsterno =
		createColumn(
			"numeroProtocolloEsterno", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Date> dataProtocolloEsterno =
		createColumn(
			"dataProtocolloEsterno", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> oggetto = createColumn(
		"oggetto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Boolean> invioGuest = createColumn(
		"invioGuest", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> tokenVisualizzazione =
		createColumn(
			"tokenVisualizzazione", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> chiaveAssociazioneBackoffice =
		createColumn(
			"chiaveAssociazioneBackoffice", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Long> delegaId = createColumn(
		"delegaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, String> processInstanceId =
		createColumn(
			"processInstanceId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RichiestaTable, Long> proceduraId = createColumn(
		"proceduraId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RichiestaTable() {
		super("richiesta", RichiestaTable::new);
	}

}