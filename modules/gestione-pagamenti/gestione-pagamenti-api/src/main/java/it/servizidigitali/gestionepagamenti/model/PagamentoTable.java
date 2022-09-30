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

package it.servizidigitali.gestionepagamenti.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;pagamento&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Pagamento
 * @generated
 */
public class PagamentoTable extends BaseTable<PagamentoTable> {

	public static final PagamentoTable INSTANCE = new PagamentoTable();

	public final Column<PagamentoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Long> pagamentoId = createColumn(
		"pagamentoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PagamentoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> idCredito = createColumn(
		"idCredito", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> idFiscaleCliente = createColumn(
		"idFiscaleCliente", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> denominazioneCliente =
		createColumn(
			"denominazioneCliente", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> emailQuietanza = createColumn(
		"emailQuietanza", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> causale = createColumn(
		"causale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> descrizioneServizio =
		createColumn(
			"descrizioneServizio", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, BigDecimal> importo = createColumn(
		"importo", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, BigDecimal> commissioni = createColumn(
		"commissioni", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> canale = createColumn(
		"canale", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> iud = createColumn(
		"iud", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> iuv = createColumn(
		"iuv", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> idSessione = createColumn(
		"idSessione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> pathAvviso = createColumn(
		"pathAvviso", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Boolean> emailInviata = createColumn(
		"emailInviata", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, String> stato = createColumn(
		"stato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PagamentoTable, Long> richiestaId = createColumn(
		"richiestaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PagamentoTable() {
		super("pagamento", PagamentoTable::new);
	}

}