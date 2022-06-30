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

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SamlSpSession&quot; database table.
 *
 * @author Mika Koivisto
 * @see SamlSpSession
 * @generated
 */
public class SamlSpSessionTable extends BaseTable<SamlSpSessionTable> {

	public static final SamlSpSessionTable INSTANCE = new SamlSpSessionTable();

	public final Column<SamlSpSessionTable, Long> samlSpSessionId =
		createColumn(
			"samlSpSessionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SamlSpSessionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Long> samlPeerBindingId =
		createColumn(
			"samlPeerBindingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Clob> assertionXml = createColumn(
		"assertionXml", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, String> jSessionId = createColumn(
		"jSessionId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, String> samlSpSessionKey =
		createColumn(
			"samlSpSessionKey", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, String> sessionIndex = createColumn(
		"sessionIndex", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SamlSpSessionTable, Boolean> terminated = createColumn(
		"terminated_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private SamlSpSessionTable() {
		super("SamlSpSession", SamlSpSessionTable::new);
	}

}