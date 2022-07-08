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

package com.liferay.saml.persistence.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SamlSpMessage&quot; database table.
 *
 * @author Mika Koivisto
 * @see SamlSpMessage
 * @generated
 */
public class SamlSpMessageTable extends BaseTable<SamlSpMessageTable> {

	public static final SamlSpMessageTable INSTANCE = new SamlSpMessageTable();

	public final Column<SamlSpMessageTable, Long> samlSpMessageId =
		createColumn(
			"samlSpMessageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SamlSpMessageTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlSpMessageTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlSpMessageTable, String> samlIdpEntityId =
		createColumn(
			"samlIdpEntityId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SamlSpMessageTable, String> samlIdpResponseKey =
		createColumn(
			"samlIdpResponseKey", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SamlSpMessageTable, Date> expirationDate = createColumn(
		"expirationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SamlSpMessageTable() {
		super("SamlSpMessage", SamlSpMessageTable::new);
	}

}