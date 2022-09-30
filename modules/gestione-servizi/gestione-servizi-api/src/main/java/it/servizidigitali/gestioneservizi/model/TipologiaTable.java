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
 * The table class for the &quot;tipologia&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Tipologia
 * @generated
 */
public class TipologiaTable extends BaseTable<TipologiaTable> {

	public static final TipologiaTable INSTANCE = new TipologiaTable();

	public final Column<TipologiaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Long> tipologiaId = createColumn(
		"tipologiaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TipologiaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Boolean> visibile = createColumn(
		"visibile", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, Boolean> invioEmailCittadino =
		createColumn(
			"invioEmailCittadino", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, String> chatbotInlineIntent =
		createColumn(
			"chatbotInlineIntent", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TipologiaTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TipologiaTable() {
		super("tipologia", TipologiaTable::new);
	}

}