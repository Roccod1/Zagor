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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TipologiaComunicazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComunicazione
 * @generated
 */
public class TipologiaComunicazioneWrapper
	extends BaseModelWrapper<TipologiaComunicazione>
	implements ModelWrapper<TipologiaComunicazione>, TipologiaComunicazione {

	public TipologiaComunicazioneWrapper(
		TipologiaComunicazione tipologiaComunicazione) {

		super(tipologiaComunicazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"tipologiaComunicazioneId", getTipologiaComunicazioneId());
		attributes.put("nome", getNome());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tipologiaComunicazioneId = (Long)attributes.get(
			"tipologiaComunicazioneId");

		if (tipologiaComunicazioneId != null) {
			setTipologiaComunicazioneId(tipologiaComunicazioneId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}
	}

	@Override
	public TipologiaComunicazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the nome of this tipologia comunicazione.
	 *
	 * @return the nome of this tipologia comunicazione
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this tipologia comunicazione.
	 *
	 * @return the primary key of this tipologia comunicazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipologia comunicazione ID of this tipologia comunicazione.
	 *
	 * @return the tipologia comunicazione ID of this tipologia comunicazione
	 */
	@Override
	public long getTipologiaComunicazioneId() {
		return model.getTipologiaComunicazioneId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the nome of this tipologia comunicazione.
	 *
	 * @param nome the nome of this tipologia comunicazione
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this tipologia comunicazione.
	 *
	 * @param primaryKey the primary key of this tipologia comunicazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipologia comunicazione ID of this tipologia comunicazione.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID of this tipologia comunicazione
	 */
	@Override
	public void setTipologiaComunicazioneId(long tipologiaComunicazioneId) {
		model.setTipologiaComunicazioneId(tipologiaComunicazioneId);
	}

	@Override
	protected TipologiaComunicazioneWrapper wrap(
		TipologiaComunicazione tipologiaComunicazione) {

		return new TipologiaComunicazioneWrapper(tipologiaComunicazione);
	}

}