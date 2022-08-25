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

package it.servizidigitali.gestionecomunicazioni.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;lettura_comunicazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazione
 * @generated
 */
public class LetturaComunicazioneTable
	extends BaseTable<LetturaComunicazioneTable> {

	public static final LetturaComunicazioneTable INSTANCE =
		new LetturaComunicazioneTable();

	public final Column<LetturaComunicazioneTable, Long> comunicazioneId =
		createColumn(
			"comunicazioneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LetturaComunicazioneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LetturaComunicazioneTable, Date> dataLettura =
		createColumn(
			"dataLettura", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private LetturaComunicazioneTable() {
		super("lettura_comunicazione", LetturaComunicazioneTable::new);
	}

}