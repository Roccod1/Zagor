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

package it.servizidigitali.gestioneforms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;tipo_documento&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumento
 * @generated
 */
public class TipoDocumentoTable extends BaseTable<TipoDocumentoTable> {

	public static final TipoDocumentoTable INSTANCE = new TipoDocumentoTable();

	public final Column<TipoDocumentoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> tipoDocumentoId =
		createColumn(
			"tipoDocumentoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TipoDocumentoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> codice = createColumn(
		"codice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> categoria = createColumn(
		"categoria", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> estensioniFile =
		createColumn(
			"estensioni_file", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> numeroRequired = createColumn(
		"numero_required", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> dataScadenzaRequired =
		createColumn(
			"data_scadenza_required", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TipoDocumentoTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TipoDocumentoTable() {
		super("tipo_documento", TipoDocumentoTable::new);
	}

}