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

package it.servizidigitali.gestioneenti.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ente_servizio&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizio
 * @generated
 */
public class EnteServizioTable extends BaseTable<EnteServizioTable> {

	public static final EnteServizioTable INSTANCE = new EnteServizioTable();

	public final Column<EnteServizioTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EnteServizioTable, Long> servizioId = createColumn(
		"servizioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EnteServizioTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, String> uri = createColumn(
		"uri", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, String> uriGuest = createColumn(
		"uriGuest", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, String> uriScheda = createColumn(
		"uriScheda", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> autenticazione =
		createColumn(
			"autenticazione", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Date> dataInizioAttivazione =
		createColumn(
			"dataInizioAttivazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Date> dataFineAttivazione =
		createColumn(
			"dataFineAttivazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> cittadino = createColumn(
		"cittadino", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> azienda = createColumn(
		"azienda", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> delega = createColumn(
		"delega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> chatbot = createColumn(
		"chatbot", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> prenotabile = createColumn(
		"prenotabile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> privacyDelega =
		createColumn(
			"privacyDelega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> allegatoDelega =
		createColumn(
			"allegatoDelega", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> timbroCertificato =
		createColumn(
			"timbroCertificato", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> iseeInps = createColumn(
		"iseeInps", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EnteServizioTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private EnteServizioTable() {
		super("ente_servizio", EnteServizioTable::new);
	}

}