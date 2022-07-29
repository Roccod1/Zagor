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
 * The table class for the &quot;area_tematica&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematica
 * @generated
 */
public class AreaTematicaTable extends BaseTable<AreaTematicaTable> {

	public static final AreaTematicaTable INSTANCE = new AreaTematicaTable();

	public final Column<AreaTematicaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Long> areaTematicaId = createColumn(
		"areaTematicaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AreaTematicaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> sportello = createColumn(
		"sportello", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> uriVocabolario =
		createColumn(
			"uriVocabolario", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, String> denominazioneVocabolario =
		createColumn(
			"denominazioneVocabolario", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Integer> ordine = createColumn(
		"ordine", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Boolean> visibile = createColumn(
		"visibile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AreaTematicaTable, Boolean> attiva = createColumn(
		"attiva", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AreaTematicaTable() {
		super("area_tematica", AreaTematicaTable::new);
	}

}