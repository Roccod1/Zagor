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

package it.servizidigitali.common.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;provincia&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Provincia
 * @generated
 */
public class ProvinciaTable extends BaseTable<ProvinciaTable> {

	public static final ProvinciaTable INSTANCE = new ProvinciaTable();

	public final Column<ProvinciaTable, Long> provinciaId = createColumn(
		"provinciaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProvinciaTable, Integer> codiceRipartizione =
		createColumn(
			"codiceRipartizione", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> codiceNUTS1 = createColumn(
		"codiceNUTS1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> ripartizioneGeograficaM =
		createColumn(
			"ripartizioneGeograficaM", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> ripartizioneGeografica =
		createColumn(
			"ripartizioneGeografica", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> denominazioneRegioneM =
		createColumn(
			"denominazioneRegioneM", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> denominazioneRegione =
		createColumn(
			"denominazioneRegione", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> denominazioneProvincia =
		createColumn(
			"denominazioneProvincia", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, Long> codiceRegione = createColumn(
		"codiceRegione", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> codiceNUTS2 = createColumn(
		"codiceNUTS2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> codiceNUTS3 = createColumn(
		"codiceNUTS3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProvinciaTable, String> sigla = createColumn(
		"sigla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProvinciaTable() {
		super("provincia", ProvinciaTable::new);
	}

}