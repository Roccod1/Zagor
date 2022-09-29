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

package it.servizidigitali.gestioneprocedure.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;template_pdf&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdf
 * @generated
 */
public class TemplatePdfTable extends BaseTable<TemplatePdfTable> {

	public static final TemplatePdfTable INSTANCE = new TemplatePdfTable();

	public final Column<TemplatePdfTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> templatePdfId = createColumn(
		"templatePdfId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TemplatePdfTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> proceduraId = createColumn(
		"proceduraId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplatePdfTable, Long> templatePdfParentId =
		createColumn(
			"templatePdfParentId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private TemplatePdfTable() {
		super("template_pdf", TemplatePdfTable::new);
	}

}