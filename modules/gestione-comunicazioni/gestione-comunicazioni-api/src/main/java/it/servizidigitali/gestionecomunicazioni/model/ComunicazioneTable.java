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

package it.servizidigitali.gestionecomunicazioni.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;comunicazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Comunicazione
 * @generated
 */
public class ComunicazioneTable extends BaseTable<ComunicazioneTable> {

	public static final ComunicazioneTable INSTANCE = new ComunicazioneTable();

	public final Column<ComunicazioneTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> comunicazioneId =
		createColumn(
			"comunicazioneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ComunicazioneTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, String> titolo = createColumn(
		"titolo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Date> dataInvio = createColumn(
		"dataInvio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, String> codiceServizio =
		createColumn(
			"codiceServizio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, String> uriServizio = createColumn(
		"uriServizio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> tipologiaComunicazioneId =
		createColumn(
			"tipologiaComunicazioneId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> destinatarioUserId =
		createColumn(
			"destinatarioUserId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> destinatarioOrganizationId =
		createColumn(
			"destinatarioOrganizationId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ComunicazioneTable, Long> calendarBookingId =
		createColumn(
			"calendarBookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ComunicazioneTable() {
		super("comunicazione", ComunicazioneTable::new);
	}

}