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
 * The table class for the &quot;servizio_ente&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnte
 * @generated
 */
public class ServizioEnteTable extends BaseTable<ServizioEnteTable> {

	public static final ServizioEnteTable INSTANCE = new ServizioEnteTable();

	public final Column<ServizioEnteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Long> servizioId = createColumn(
		"servizioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ServizioEnteTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ServizioEnteTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, String> uri = createColumn(
		"uri", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, String> uriGuest = createColumn(
		"uriGuest", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Long> catalogoServizioArticleId =
		createColumn(
			"catalogoServizioArticleId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> autenticazione =
		createColumn(
			"autenticazione", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Integer> livelloAutenticazione =
		createColumn(
			"livelloAutenticazione", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Date> dataInizioAttivazione =
		createColumn(
			"dataInizioAttivazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Date> dataFineAttivazione =
		createColumn(
			"dataFineAttivazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> cittadino = createColumn(
		"cittadino", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> azienda = createColumn(
		"azienda", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> delega = createColumn(
		"delega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> chatbot = createColumn(
		"chatbot", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> prenotabile = createColumn(
		"prenotabile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> privacyDelega =
		createColumn(
			"privacyDelega", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> allegatoDelega =
		createColumn(
			"allegatoDelega", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> timbroCertificato =
		createColumn(
			"timbroCertificato", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> iseeInps = createColumn(
		"iseeInps", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ServizioEnteTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ServizioEnteTable() {
		super("servizio_ente", ServizioEnteTable::new);
	}

}