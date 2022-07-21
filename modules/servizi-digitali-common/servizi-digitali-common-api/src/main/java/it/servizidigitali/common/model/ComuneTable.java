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
 * The table class for the &quot;comune&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Comune
 * @generated
 */
public class ComuneTable extends BaseTable<ComuneTable> {

	public static final ComuneTable INSTANCE = new ComuneTable();

	public final Column<ComuneTable, Long> comuneId = createColumn(
		"comuneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ComuneTable, String> codiceIstatAN = createColumn(
		"codiceIstatAN", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> codiceIstat1 = createColumn(
		"codiceIstat1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> codiceIstat103 = createColumn(
		"codiceIstat103", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> codicestat107 = createColumn(
		"codicestat107", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> denominazione = createColumn(
		"denominazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, Boolean> capoluogo = createColumn(
		"capoluogo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> zonaAltimetrica = createColumn(
		"zonaAltimetrica", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> altitudine = createColumn(
		"altitudine", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, Boolean> comuneLitoraneo = createColumn(
		"comuneLitoraneo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> comuneMontano = createColumn(
		"comuneMontano", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> codiceSistemaLocaleLavoro =
		createColumn(
			"codiceSistemaLocaleLavoro", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> denominazioneSistemaLocaleLavoro =
		createColumn(
			"denominazioneSistemaLocaleLavoro", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> superficie = createColumn(
		"superficie", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> popolazioneLegale = createColumn(
		"popolazioneLegale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> popolazioneResidente1 =
		createColumn(
			"popolazioneResidente1", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> popolazioneResidente2 =
		createColumn(
			"popolazioneResidente2", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> popolazioneResidente3 =
		createColumn(
			"popolazioneResidente3", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ComuneTable, Integer> codiceComune = createColumn(
		"codiceComune", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, String> codiceCatastale = createColumn(
		"codiceCatastale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, Long> idRegione = createColumn(
		"idRegione", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ComuneTable, Long> idProvincia = createColumn(
		"idProvincia", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ComuneTable() {
		super("comune", ComuneTable::new);
	}

}