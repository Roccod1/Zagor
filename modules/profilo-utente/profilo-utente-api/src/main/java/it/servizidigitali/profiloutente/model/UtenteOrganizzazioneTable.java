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
 * The table class for the &quot;utente_organizzazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazione
 * @generated
 */
public class UtenteOrganizzazioneTable
	extends BaseTable<UtenteOrganizzazioneTable> {

	public static final UtenteOrganizzazioneTable INSTANCE =
		new UtenteOrganizzazioneTable();

	public final Column<UtenteOrganizzazioneTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Long> utenteId =
		createColumn("utenteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteOrganizzazioneTable, Long> organizationId =
		createColumn(
			"organizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteOrganizzazioneTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UtenteOrganizzazioneTable, Boolean> preferito =
		createColumn(
			"preferito", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private UtenteOrganizzazioneTable() {
		super("utente_organizzazione", UtenteOrganizzazioneTable::new);
	}

}