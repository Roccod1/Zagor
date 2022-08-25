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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LetturaComunicazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazione
 * @generated
 */
public class LetturaComunicazioneWrapper
	extends BaseModelWrapper<LetturaComunicazione>
	implements LetturaComunicazione, ModelWrapper<LetturaComunicazione> {

	public LetturaComunicazioneWrapper(
		LetturaComunicazione letturaComunicazione) {

		super(letturaComunicazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("comunicazioneId", getComunicazioneId());
		attributes.put("userId", getUserId());
		attributes.put("dataLettura", getDataLettura());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long comunicazioneId = (Long)attributes.get("comunicazioneId");

		if (comunicazioneId != null) {
			setComunicazioneId(comunicazioneId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date dataLettura = (Date)attributes.get("dataLettura");

		if (dataLettura != null) {
			setDataLettura(dataLettura);
		}
	}

	@Override
	public LetturaComunicazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comunicazione ID of this lettura comunicazione.
	 *
	 * @return the comunicazione ID of this lettura comunicazione
	 */
	@Override
	public long getComunicazioneId() {
		return model.getComunicazioneId();
	}

	/**
	 * Returns the data lettura of this lettura comunicazione.
	 *
	 * @return the data lettura of this lettura comunicazione
	 */
	@Override
	public Date getDataLettura() {
		return model.getDataLettura();
	}

	/**
	 * Returns the primary key of this lettura comunicazione.
	 *
	 * @return the primary key of this lettura comunicazione
	 */
	@Override
	public it.servizidigitali.gestionecomunicazioni.service.persistence.
		LetturaComunicazionePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this lettura comunicazione.
	 *
	 * @return the user ID of this lettura comunicazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this lettura comunicazione.
	 *
	 * @return the user uuid of this lettura comunicazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comunicazione ID of this lettura comunicazione.
	 *
	 * @param comunicazioneId the comunicazione ID of this lettura comunicazione
	 */
	@Override
	public void setComunicazioneId(long comunicazioneId) {
		model.setComunicazioneId(comunicazioneId);
	}

	/**
	 * Sets the data lettura of this lettura comunicazione.
	 *
	 * @param dataLettura the data lettura of this lettura comunicazione
	 */
	@Override
	public void setDataLettura(Date dataLettura) {
		model.setDataLettura(dataLettura);
	}

	/**
	 * Sets the primary key of this lettura comunicazione.
	 *
	 * @param primaryKey the primary key of this lettura comunicazione
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this lettura comunicazione.
	 *
	 * @param userId the user ID of this lettura comunicazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this lettura comunicazione.
	 *
	 * @param userUuid the user uuid of this lettura comunicazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LetturaComunicazioneWrapper wrap(
		LetturaComunicazione letturaComunicazione) {

		return new LetturaComunicazioneWrapper(letturaComunicazione);
	}

}