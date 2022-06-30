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
 * The table class for the &quot;SamlIdpSpSession&quot; database table.
 *
 * @author Mika Koivisto
 * @see SamlIdpSpSession
 * @generated
 */
public class SamlIdpSpSessionTable extends BaseTable<SamlIdpSpSessionTable> {

	public static final SamlIdpSpSessionTable INSTANCE =
		new SamlIdpSpSessionTable();

	public final Column<SamlIdpSpSessionTable, Long> samlIdpSpSessionId =
		createColumn(
			"samlIdpSpSessionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SamlIdpSpSessionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, Long> samlIdpSsoSessionId =
		createColumn(
			"samlIdpSsoSessionId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SamlIdpSpSessionTable, Long> samlPeerBindingId =
		createColumn(
			"samlPeerBindingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SamlIdpSpSessionTable() {
		super("SamlIdpSpSession", SamlIdpSpSessionTable::new);
	}

}