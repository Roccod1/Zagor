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

package it.servizidigitali.profiloutente.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UtenteOrganizzazioneCanaleComunicazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneCanaleComunicazione
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneWrapper
	extends BaseModelWrapper<UtenteOrganizzazioneCanaleComunicazione>
	implements ModelWrapper<UtenteOrganizzazioneCanaleComunicazione>,
			   UtenteOrganizzazioneCanaleComunicazione {

	public UtenteOrganizzazioneCanaleComunicazioneWrapper(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		super(utenteOrganizzazioneCanaleComunicazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("utenteId", getUtenteId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("canaleComunicazioneId", getCanaleComunicazioneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long utenteId = (Long)attributes.get("utenteId");

		if (utenteId != null) {
			setUtenteId(utenteId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long canaleComunicazioneId = (Long)attributes.get(
			"canaleComunicazioneId");

		if (canaleComunicazioneId != null) {
			setCanaleComunicazioneId(canaleComunicazioneId);
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
	}

	@Override
	public UtenteOrganizzazioneCanaleComunicazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the canale comunicazione ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the canale comunicazione ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getCanaleComunicazioneId() {
		return model.getCanaleComunicazioneId();
	}

	/**
	 * Returns the company ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the company ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this utente organizzazione canale comunicazione.
	 *
	 * @return the create date of this utente organizzazione canale comunicazione
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the group ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this utente organizzazione canale comunicazione.
	 *
	 * @return the modified date of this utente organizzazione canale comunicazione
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the organization ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this utente organizzazione canale comunicazione.
	 *
	 * @return the primary key of this utente organizzazione canale comunicazione
	 */
	@Override
	public it.servizidigitali.profiloutente.service.persistence.
		UtenteOrganizzazioneCanaleComunicazionePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the user ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this utente organizzazione canale comunicazione.
	 *
	 * @return the user name of this utente organizzazione canale comunicazione
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this utente organizzazione canale comunicazione.
	 *
	 * @return the user uuid of this utente organizzazione canale comunicazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utente ID of this utente organizzazione canale comunicazione.
	 *
	 * @return the utente ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public long getUtenteId() {
		return model.getUtenteId();
	}

	/**
	 * Returns the uuid of this utente organizzazione canale comunicazione.
	 *
	 * @return the uuid of this utente organizzazione canale comunicazione
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
	 * Sets the canale comunicazione ID of this utente organizzazione canale comunicazione.
	 *
	 * @param canaleComunicazioneId the canale comunicazione ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setCanaleComunicazioneId(long canaleComunicazioneId) {
		model.setCanaleComunicazioneId(canaleComunicazioneId);
	}

	/**
	 * Sets the company ID of this utente organizzazione canale comunicazione.
	 *
	 * @param companyId the company ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this utente organizzazione canale comunicazione.
	 *
	 * @param createDate the create date of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this utente organizzazione canale comunicazione.
	 *
	 * @param groupId the group ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this utente organizzazione canale comunicazione.
	 *
	 * @param modifiedDate the modified date of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this utente organizzazione canale comunicazione.
	 *
	 * @param organizationId the organization ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this utente organizzazione canale comunicazione.
	 *
	 * @param primaryKey the primary key of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazioneCanaleComunicazionePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this utente organizzazione canale comunicazione.
	 *
	 * @param userId the user ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this utente organizzazione canale comunicazione.
	 *
	 * @param userName the user name of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this utente organizzazione canale comunicazione.
	 *
	 * @param userUuid the user uuid of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente ID of this utente organizzazione canale comunicazione.
	 *
	 * @param utenteId the utente ID of this utente organizzazione canale comunicazione
	 */
	@Override
	public void setUtenteId(long utenteId) {
		model.setUtenteId(utenteId);
	}

	/**
	 * Sets the uuid of this utente organizzazione canale comunicazione.
	 *
	 * @param uuid the uuid of this utente organizzazione canale comunicazione
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
	protected UtenteOrganizzazioneCanaleComunicazioneWrapper wrap(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		return new UtenteOrganizzazioneCanaleComunicazioneWrapper(
			utenteOrganizzazioneCanaleComunicazione);
	}

}