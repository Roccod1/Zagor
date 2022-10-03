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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;destinazione_uso&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUso
 * @generated
 */
public class DestinazioneUsoTable extends BaseTable<DestinazioneUsoTable> {

	public static final DestinazioneUsoTable INSTANCE =
		new DestinazioneUsoTable();

	public final Column<DestinazioneUsoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Long> destinazioneUsoId =
		createColumn(
			"destinazioneUsoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DestinazioneUsoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, String> descrizione =
		createColumn(
			"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, Boolean> pagamentoBollo =
		createColumn(
			"pagamentoBollo", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<DestinazioneUsoTable, BigDecimal> importo =
		createColumn(
			"importo", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);

	private DestinazioneUsoTable() {
		super("destinazione_uso", DestinazioneUsoTable::new);
	}

}