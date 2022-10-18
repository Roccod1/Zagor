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

package it.servizidigitali.chatbot.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;richiesta_certificato&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificato
 * @generated
 */
public class RichiestaCertificatoTable
	extends BaseTable<RichiestaCertificatoTable> {

	public static final RichiestaCertificatoTable INSTANCE =
		new RichiestaCertificatoTable();

	public final Column<RichiestaCertificatoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Long>
		richiestaCertificatoId = createColumn(
			"richiestaCertificatoId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RichiestaCertificatoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, String> codiceFiscale =
		createColumn(
			"codiceFiscale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, String> errore =
		createColumn(
			"errore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Long> servizioId =
		createColumn(
			"servizioId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RichiestaCertificatoTable, Long> destinazioneUsoId =
		createColumn(
			"destinazioneUsoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RichiestaCertificatoTable() {
		super("richiesta_certificato", RichiestaCertificatoTable::new);
	}

}