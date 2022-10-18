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

package it.servizidigitali.chatbot.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RichiestaCertificato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificato
 * @generated
 */
public class RichiestaCertificatoWrapper
	extends BaseModelWrapper<RichiestaCertificato>
	implements ModelWrapper<RichiestaCertificato>, RichiestaCertificato {

	public RichiestaCertificatoWrapper(
		RichiestaCertificato richiestaCertificato) {

		super(richiestaCertificato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("richiestaCertificatoId", getRichiestaCertificatoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("stato", getStato());
		attributes.put("errore", getErrore());
		attributes.put("servizioId", getServizioId());
		attributes.put("destinazioneUsoId", getDestinazioneUsoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long richiestaCertificatoId = (Long)attributes.get(
			"richiestaCertificatoId");

		if (richiestaCertificatoId != null) {
			setRichiestaCertificatoId(richiestaCertificatoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String errore = (String)attributes.get("errore");

		if (errore != null) {
			setErrore(errore);
		}

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
		}

		Long destinazioneUsoId = (Long)attributes.get("destinazioneUsoId");

		if (destinazioneUsoId != null) {
			setDestinazioneUsoId(destinazioneUsoId);
		}
	}

	@Override
	public RichiestaCertificato cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice fiscale of this richiesta certificato.
	 *
	 * @return the codice fiscale of this richiesta certificato
	 */
	@Override
	public String getCodiceFiscale() {
		return model.getCodiceFiscale();
	}

	/**
	 * Returns the company ID of this richiesta certificato.
	 *
	 * @return the company ID of this richiesta certificato
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this richiesta certificato.
	 *
	 * @return the create date of this richiesta certificato
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the destinazione uso ID of this richiesta certificato.
	 *
	 * @return the destinazione uso ID of this richiesta certificato
	 */
	@Override
	public long getDestinazioneUsoId() {
		return model.getDestinazioneUsoId();
	}

	/**
	 * Returns the errore of this richiesta certificato.
	 *
	 * @return the errore of this richiesta certificato
	 */
	@Override
	public String getErrore() {
		return model.getErrore();
	}

	/**
	 * Returns the group ID of this richiesta certificato.
	 *
	 * @return the group ID of this richiesta certificato
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this richiesta certificato.
	 *
	 * @return the modified date of this richiesta certificato
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this richiesta certificato.
	 *
	 * @return the primary key of this richiesta certificato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the richiesta certificato ID of this richiesta certificato.
	 *
	 * @return the richiesta certificato ID of this richiesta certificato
	 */
	@Override
	public long getRichiestaCertificatoId() {
		return model.getRichiestaCertificatoId();
	}

	/**
	 * Returns the servizio ID of this richiesta certificato.
	 *
	 * @return the servizio ID of this richiesta certificato
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the stato of this richiesta certificato.
	 *
	 * @return the stato of this richiesta certificato
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the user ID of this richiesta certificato.
	 *
	 * @return the user ID of this richiesta certificato
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this richiesta certificato.
	 *
	 * @return the user name of this richiesta certificato
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this richiesta certificato.
	 *
	 * @return the user uuid of this richiesta certificato
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this richiesta certificato.
	 *
	 * @return the uuid of this richiesta certificato
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codice fiscale of this richiesta certificato.
	 *
	 * @param codiceFiscale the codice fiscale of this richiesta certificato
	 */
	@Override
	public void setCodiceFiscale(String codiceFiscale) {
		model.setCodiceFiscale(codiceFiscale);
	}

	/**
	 * Sets the company ID of this richiesta certificato.
	 *
	 * @param companyId the company ID of this richiesta certificato
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this richiesta certificato.
	 *
	 * @param createDate the create date of this richiesta certificato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the destinazione uso ID of this richiesta certificato.
	 *
	 * @param destinazioneUsoId the destinazione uso ID of this richiesta certificato
	 */
	@Override
	public void setDestinazioneUsoId(long destinazioneUsoId) {
		model.setDestinazioneUsoId(destinazioneUsoId);
	}

	/**
	 * Sets the errore of this richiesta certificato.
	 *
	 * @param errore the errore of this richiesta certificato
	 */
	@Override
	public void setErrore(String errore) {
		model.setErrore(errore);
	}

	/**
	 * Sets the group ID of this richiesta certificato.
	 *
	 * @param groupId the group ID of this richiesta certificato
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this richiesta certificato.
	 *
	 * @param modifiedDate the modified date of this richiesta certificato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this richiesta certificato.
	 *
	 * @param primaryKey the primary key of this richiesta certificato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the richiesta certificato ID of this richiesta certificato.
	 *
	 * @param richiestaCertificatoId the richiesta certificato ID of this richiesta certificato
	 */
	@Override
	public void setRichiestaCertificatoId(long richiestaCertificatoId) {
		model.setRichiestaCertificatoId(richiestaCertificatoId);
	}

	/**
	 * Sets the servizio ID of this richiesta certificato.
	 *
	 * @param servizioId the servizio ID of this richiesta certificato
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets the stato of this richiesta certificato.
	 *
	 * @param stato the stato of this richiesta certificato
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the user ID of this richiesta certificato.
	 *
	 * @param userId the user ID of this richiesta certificato
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this richiesta certificato.
	 *
	 * @param userName the user name of this richiesta certificato
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this richiesta certificato.
	 *
	 * @param userUuid the user uuid of this richiesta certificato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this richiesta certificato.
	 *
	 * @param uuid the uuid of this richiesta certificato
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected RichiestaCertificatoWrapper wrap(
		RichiestaCertificato richiestaCertificato) {

		return new RichiestaCertificatoWrapper(richiestaCertificato);
	}

}