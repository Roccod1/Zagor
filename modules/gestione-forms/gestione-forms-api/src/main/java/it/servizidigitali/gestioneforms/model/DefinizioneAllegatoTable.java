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
 * The table class for the &quot;definizione_allegato&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegato
 * @generated
 */
public class DefinizioneAllegatoTable
	extends BaseTable<DefinizioneAllegatoTable> {

	public static final DefinizioneAllegatoTable INSTANCE =
		new DefinizioneAllegatoTable();

	public final Column<DefinizioneAllegatoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> definizioneAllegatoId =
		createColumn(
			"definizioneAllegatoId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DefinizioneAllegatoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, String> denominazione =
		createColumn(
			"denominazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> fileEntryId =
		createColumn(
			"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, String> filenameModello =
		createColumn(
			"filenameModello", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, String> tipiFileAmmessi =
		createColumn(
			"tipiFileAmmessi", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, String>
		codiciTipologiaDocumento = createColumn(
			"codiciTipologiaDocumento", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Boolean> obbligatorio =
		createColumn(
			"obbligatorio", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> organizationId =
		createColumn(
			"organizationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DefinizioneAllegatoTable, Long> formId = createColumn(
		"formId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DefinizioneAllegatoTable() {
		super("definizione_allegato", DefinizioneAllegatoTable::new);
	}

}