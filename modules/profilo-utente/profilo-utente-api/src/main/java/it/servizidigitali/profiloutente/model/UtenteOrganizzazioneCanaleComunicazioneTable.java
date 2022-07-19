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

package it.servizidigitali.profiloutente.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;utente_organizzazione_canalecomunicazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazione
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneTable
	extends BaseTable<UtenteOrganizzazioneCanaleComunicazioneTable> {

	public static final UtenteOrganizzazioneCanaleComunicazioneTable INSTANCE =
		new UtenteOrganizzazioneCanaleComunicazioneTable();

	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		utenteId = createColumn(
			"utenteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		organizationId = createColumn(
			"organizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		canaleComunicazioneId = createColumn(
			"canaleComunicazioneId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		groupId = createColumn(
			"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		companyId = createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Long>
		userId = createColumn(
			"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, String>
		userName = createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Date>
		createDate = createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Date>
		modifiedDate = createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneCanaleComunicazioneTable, Boolean>
		attivo = createColumn(
			"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private UtenteOrganizzazioneCanaleComunicazioneTable() {
		super(
			"utente_organizzazione_canalecomunicazione",
			UtenteOrganizzazioneCanaleComunicazioneTable::new);
	}

}