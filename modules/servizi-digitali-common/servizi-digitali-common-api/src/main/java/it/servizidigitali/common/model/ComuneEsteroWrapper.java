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
 * This class is a wrapper for {@link ComuneEstero}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEstero
 * @generated
 */
public class ComuneEsteroWrapper
	extends BaseModelWrapper<ComuneEstero>
	implements ComuneEstero, ModelWrapper<ComuneEstero> {

	public ComuneEsteroWrapper(ComuneEstero comuneEstero) {
		super(comuneEstero);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("comuneEsteroId", getComuneEsteroId());
		attributes.put("codice", getCodice());
		attributes.put("denominazione", getDenominazione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long comuneEsteroId = (Long)attributes.get("comuneEsteroId");

		if (comuneEsteroId != null) {
			setComuneEsteroId(comuneEsteroId);
		}

		Integer codice = (Integer)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		String denominazione = (String)attributes.get("denominazione");

		if (denominazione != null) {
			setDenominazione(denominazione);
		}
	}

	@Override
	public ComuneEstero cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice of this comune estero.
	 *
	 * @return the codice of this comune estero
	 */
	@Override
	public int getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the comune estero ID of this comune estero.
	 *
	 * @return the comune estero ID of this comune estero
	 */
	@Override
	public long getComuneEsteroId() {
		return model.getComuneEsteroId();
	}

	/**
	 * Returns the denominazione of this comune estero.
	 *
	 * @return the denominazione of this comune estero
	 */
	@Override
	public String getDenominazione() {
		return model.getDenominazione();
	}

	/**
	 * Returns the primary key of this comune estero.
	 *
	 * @return the primary key of this comune estero
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codice of this comune estero.
	 *
	 * @param codice the codice of this comune estero
	 */
	@Override
	public void setCodice(int codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the comune estero ID of this comune estero.
	 *
	 * @param comuneEsteroId the comune estero ID of this comune estero
	 */
	@Override
	public void setComuneEsteroId(long comuneEsteroId) {
		model.setComuneEsteroId(comuneEsteroId);
	}

	/**
	 * Sets the denominazione of this comune estero.
	 *
	 * @param denominazione the denominazione of this comune estero
	 */
	@Override
	public void setDenominazione(String denominazione) {
		model.setDenominazione(denominazione);
	}

	/**
	 * Sets the primary key of this comune estero.
	 *
	 * @param primaryKey the primary key of this comune estero
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ComuneEsteroWrapper wrap(ComuneEstero comuneEstero) {
		return new ComuneEsteroWrapper(comuneEstero);
	}

}