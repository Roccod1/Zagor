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

package it.servizidigitali.gestioneprocessi.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;processo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Processo
 * @generated
 */
public class ProcessoTable extends BaseTable<ProcessoTable> {

	public static final ProcessoTable INSTANCE = new ProcessoTable();

	public final Column<ProcessoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Long> processoId = createColumn(
		"processoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProcessoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Boolean> multiente = createColumn(
		"multiente", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, String> deploymentId = createColumn(
		"deploymentId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcessoTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ProcessoTable() {
		super("processo", ProcessoTable::new);
	}

}