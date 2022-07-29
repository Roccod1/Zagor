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

package it.servizidigitali.common.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StatoEstero}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoEstero
 * @generated
 */
public class StatoEsteroWrapper
	extends BaseModelWrapper<StatoEstero>
	implements ModelWrapper<StatoEstero>, StatoEstero {

	public StatoEsteroWrapper(StatoEstero statoEstero) {
		super(statoEstero);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statoEsteroId", getStatoEsteroId());
		attributes.put("continente", getContinente());
		attributes.put("codiceArea", getCodiceArea());
		attributes.put("codiceStato", getCodiceStato());
		attributes.put("denominazione", getDenominazione());
		attributes.put("denominazioneEng", getDenominazioneEng());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long statoEsteroId = (Long)attributes.get("statoEsteroId");

		if (statoEsteroId != null) {
			setStatoEsteroId(statoEsteroId);
		}

		Integer continente = (Integer)attributes.get("continente");

		if (continente != null) {
			setContinente(continente);
		}

		Integer codiceArea = (Integer)attributes.get("codiceArea");

		if (codiceArea != null) {
			setCodiceArea(codiceArea);
		}

		Integer codiceStato = (Integer)attributes.get("codiceStato");

		if (codiceStato != null) {
			setCodiceStato(codiceStato);
		}

		String denominazione = (String)attributes.get("denominazione");

		if (denominazione != null) {
			setDenominazione(denominazione);
		}

		String denominazioneEng = (String)attributes.get("denominazioneEng");

		if (denominazioneEng != null) {
			setDenominazioneEng(denominazioneEng);
		}
	}

	@Override
	public StatoEstero cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice area of this stato estero.
	 *
	 * @return the codice area of this stato estero
	 */
	@Override
	public int getCodiceArea() {
		return model.getCodiceArea();
	}

	/**
	 * Returns the codice stato of this stato estero.
	 *
	 * @return the codice stato of this stato estero
	 */
	@Override
	public int getCodiceStato() {
		return model.getCodiceStato();
	}

	/**
	 * Returns the continente of this stato estero.
	 *
	 * @return the continente of this stato estero
	 */
	@Override
	public int getContinente() {
		return model.getContinente();
	}

	/**
	 * Returns the denominazione of this stato estero.
	 *
	 * @return the denominazione of this stato estero
	 */
	@Override
	public String getDenominazione() {
		return model.getDenominazione();
	}

	/**
	 * Returns the denominazione eng of this stato estero.
	 *
	 * @return the denominazione eng of this stato estero
	 */
	@Override
	public String getDenominazioneEng() {
		return model.getDenominazioneEng();
	}

	/**
	 * Returns the primary key of this stato estero.
	 *
	 * @return the primary key of this stato estero
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato estero ID of this stato estero.
	 *
	 * @return the stato estero ID of this stato estero
	 */
	@Override
	public long getStatoEsteroId() {
		return model.getStatoEsteroId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codice area of this stato estero.
	 *
	 * @param codiceArea the codice area of this stato estero
	 */
	@Override
	public void setCodiceArea(int codiceArea) {
		model.setCodiceArea(codiceArea);
	}

	/**
	 * Sets the codice stato of this stato estero.
	 *
	 * @param codiceStato the codice stato of this stato estero
	 */
	@Override
	public void setCodiceStato(int codiceStato) {
		model.setCodiceStato(codiceStato);
	}

	/**
	 * Sets the continente of this stato estero.
	 *
	 * @param continente the continente of this stato estero
	 */
	@Override
	public void setContinente(int continente) {
		model.setContinente(continente);
	}

	/**
	 * Sets the denominazione of this stato estero.
	 *
	 * @param denominazione the denominazione of this stato estero
	 */
	@Override
	public void setDenominazione(String denominazione) {
		model.setDenominazione(denominazione);
	}

	/**
	 * Sets the denominazione eng of this stato estero.
	 *
	 * @param denominazioneEng the denominazione eng of this stato estero
	 */
	@Override
	public void setDenominazioneEng(String denominazioneEng) {
		model.setDenominazioneEng(denominazioneEng);
	}

	/**
	 * Sets the primary key of this stato estero.
	 *
	 * @param primaryKey the primary key of this stato estero
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato estero ID of this stato estero.
	 *
	 * @param statoEsteroId the stato estero ID of this stato estero
	 */
	@Override
	public void setStatoEsteroId(long statoEsteroId) {
		model.setStatoEsteroId(statoEsteroId);
	}

	@Override
	protected StatoEsteroWrapper wrap(StatoEstero statoEstero) {
		return new StatoEsteroWrapper(statoEstero);
	}

}