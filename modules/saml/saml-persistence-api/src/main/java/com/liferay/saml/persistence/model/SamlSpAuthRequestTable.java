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
 * The table class for the &quot;SamlSpAuthRequest&quot; database table.
 *
 * @author Mika Koivisto
 * @see SamlSpAuthRequest
 * @generated
 */
public class SamlSpAuthRequestTable extends BaseTable<SamlSpAuthRequestTable> {

	public static final SamlSpAuthRequestTable INSTANCE =
		new SamlSpAuthRequestTable();

	public final Column<SamlSpAuthRequestTable, Long> samlSpAuthnRequestId =
		createColumn(
			"samlSpAuthnRequestId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SamlSpAuthRequestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlSpAuthRequestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlSpAuthRequestTable, String> samlIdpEntityId =
		createColumn(
			"samlIdpEntityId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SamlSpAuthRequestTable, String> samlSpAuthRequestKey =
		createColumn(
			"samlSpAuthRequestKey", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private SamlSpAuthRequestTable() {
		super("SamlSpAuthRequest", SamlSpAuthRequestTable::new);
	}

}