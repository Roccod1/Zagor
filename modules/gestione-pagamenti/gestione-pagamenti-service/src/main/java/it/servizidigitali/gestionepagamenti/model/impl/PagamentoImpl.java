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

package it.servizidigitali.gestionepagamenti.model.impl;

/**
 * @author Brian Wing Shun Chan
 */
public class PagamentoImpl extends PagamentoBaseImpl {
	
	private String dataInserimentoFormatted;
	
	private String statoFormatted;
	
	private String nomeOrganizzazione;

	public String getDataInserimentoFormatted() {
		return dataInserimentoFormatted;
	}

	public void setDataInserimentoFormatted(String dataInserimentoFormatted) {
		this.dataInserimentoFormatted = dataInserimentoFormatted;
	}

	public String getStatoFormatted() {
		return statoFormatted;
	}

	public void setStatoFormatted(String statoFormatted) {
		this.statoFormatted = statoFormatted;
	}

	public String getNomeOrganizzazione() {
		return nomeOrganizzazione;
	}

	public void setNomeOrganizzazione(String nomeOrganizzazione) {
		this.nomeOrganizzazione = nomeOrganizzazione;
	}
}