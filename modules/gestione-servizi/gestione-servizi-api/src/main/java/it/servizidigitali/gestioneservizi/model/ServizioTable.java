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

package it.servizidigitali.gestioneservizi.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;servizio&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @generated
 */
public class ServizioTable extends BaseTable<ServizioTable> {

	public static final ServizioTable INSTANCE = new ServizioTable();

	public final Column<ServizioTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Long> servizioId = createColumn(
		"servizioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ServizioTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> descrizioneEstesa = createColumn(
		"descrizioneEstesa", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> uri = createColumn(
		"uri", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> uriGuest = createColumn(
		"uriGuest", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> uriScheda = createColumn(
		"uriScheda", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> autenticazione = createColumn(
		"autenticazione", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Date> dataInizioAttivazione =
		createColumn(
			"dataInizioAttivazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Date> dataFineAttivazione = createColumn(
		"dataFineAttivazione", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> cittadino = createColumn(
		"cittadino", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> azienda = createColumn(
		"azienda", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> delega = createColumn(
		"delega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> chatbot = createColumn(
		"chatbot", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> gestioneBackoffice =
		createColumn(
			"gestioneBackoffice", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> prenotabile = createColumn(
		"prenotabile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, String> codicePrestazioneINPS =
		createColumn(
			"codicePrestazioneINPS", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> privacyDelega = createColumn(
		"privacyDelega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> allegatoDelega = createColumn(
		"allegatoDelega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> timbroCertificato =
		createColumn(
			"timbroCertificato", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioTable, Long> areaTematicaId = createColumn(
		"areaTematicaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ServizioTable() {
		super("servizio", ServizioTable::new);
	}

}