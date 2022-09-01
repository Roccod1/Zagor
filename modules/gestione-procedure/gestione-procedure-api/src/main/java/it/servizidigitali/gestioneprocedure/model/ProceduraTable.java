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

package it.servizidigitali.gestioneprocedure.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;procedura&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Procedura
 * @generated
 */
public class ProceduraTable extends BaseTable<ProceduraTable> {

	public static final ProceduraTable INSTANCE = new ProceduraTable();

	public final Column<ProceduraTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Long> proceduraId = createColumn(
		"proceduraId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProceduraTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String> pecDestinazione = createColumn(
		"pecDestinazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Boolean> step1Attivo = createColumn(
		"step1Attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String>
		step1TipoComponentiNucleoFamiliare = createColumn(
			"step1TipoComponentiNucleoFamiliare", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String> step2TipoServizio =
		createColumn(
			"step2TipoServizio", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String>
		step2TipiIntegrazioneBackoffice = createColumn(
			"step2TipiIntegrazioneBackoffice", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Boolean>
		abilitaCacheIntegrazioneBackoffice = createColumn(
			"abilitaCacheIntegrazioneBackoffice", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, String> tipoGenerazionePDF =
		createColumn(
			"tipoGenerazionePDF", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Boolean> attiva = createColumn(
		"attiva", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Long> servizioId = createColumn(
		"servizioId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProceduraTable, Long> processoId = createColumn(
		"processoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProceduraTable() {
		super("procedura", ProceduraTable::new);
	}

}