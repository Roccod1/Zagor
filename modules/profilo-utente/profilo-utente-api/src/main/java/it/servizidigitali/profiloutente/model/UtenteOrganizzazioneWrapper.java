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
 * This class is a wrapper for {@link UtenteOrganizzazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazione
 * @generated
 */
public class UtenteOrganizzazioneWrapper
	extends BaseModelWrapper<UtenteOrganizzazione>
	implements ModelWrapper<UtenteOrganizzazione>, UtenteOrganizzazione {

	public UtenteOrganizzazioneWrapper(
		UtenteOrganizzazione utenteOrganizzazione) {

		super(utenteOrganizzazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("utenteId", getUtenteId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("preferito", isPreferito());

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

		Boolean preferito = (Boolean)attributes.get("preferito");

		if (preferito != null) {
			setPreferito(preferito);
		}
	}

	@Override
	public UtenteOrganizzazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this utente organizzazione.
	 *
	 * @return the company ID of this utente organizzazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this utente organizzazione.
	 *
	 * @return the create date of this utente organizzazione
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this utente organizzazione.
	 *
	 * @return the group ID of this utente organizzazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this utente organizzazione.
	 *
	 * @return the modified date of this utente organizzazione
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this utente organizzazione.
	 *
	 * @return the organization ID of this utente organizzazione
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the preferito of this utente organizzazione.
	 *
	 * @return the preferito of this utente organizzazione
	 */
	@Override
	public boolean getPreferito() {
		return model.getPreferito();
	}

	/**
	 * Returns the primary key of this utente organizzazione.
	 *
	 * @return the primary key of this utente organizzazione
	 */
	@Override
	public
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this utente organizzazione.
	 *
	 * @return the user ID of this utente organizzazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this utente organizzazione.
	 *
	 * @return the user name of this utente organizzazione
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this utente organizzazione.
	 *
	 * @return the user uuid of this utente organizzazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utente ID of this utente organizzazione.
	 *
	 * @return the utente ID of this utente organizzazione
	 */
	@Override
	public long getUtenteId() {
		return model.getUtenteId();
	}

	/**
	 * Returns the uuid of this utente organizzazione.
	 *
	 * @return the uuid of this utente organizzazione
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this utente organizzazione is preferito.
	 *
	 * @return <code>true</code> if this utente organizzazione is preferito; <code>false</code> otherwise
	 */
	@Override
	public boolean isPreferito() {
		return model.isPreferito();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this utente organizzazione.
	 *
	 * @param companyId the company ID of this utente organizzazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this utente organizzazione.
	 *
	 * @param createDate the create date of this utente organizzazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this utente organizzazione.
	 *
	 * @param groupId the group ID of this utente organizzazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this utente organizzazione.
	 *
	 * @param modifiedDate the modified date of this utente organizzazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this utente organizzazione.
	 *
	 * @param organizationId the organization ID of this utente organizzazione
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets whether this utente organizzazione is preferito.
	 *
	 * @param preferito the preferito of this utente organizzazione
	 */
	@Override
	public void setPreferito(boolean preferito) {
		model.setPreferito(preferito);
	}

	/**
	 * Sets the primary key of this utente organizzazione.
	 *
	 * @param primaryKey the primary key of this utente organizzazione
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.profiloutente.service.persistence.
			UtenteOrganizzazionePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this utente organizzazione.
	 *
	 * @param userId the user ID of this utente organizzazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this utente organizzazione.
	 *
	 * @param userName the user name of this utente organizzazione
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this utente organizzazione.
	 *
	 * @param userUuid the user uuid of this utente organizzazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente ID of this utente organizzazione.
	 *
	 * @param utenteId the utente ID of this utente organizzazione
	 */
	@Override
	public void setUtenteId(long utenteId) {
		model.setUtenteId(utenteId);
	}

	/**
	 * Sets the uuid of this utente organizzazione.
	 *
	 * @param uuid the uuid of this utente organizzazione
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
	protected UtenteOrganizzazioneWrapper wrap(
		UtenteOrganizzazione utenteOrganizzazione) {

		return new UtenteOrganizzazioneWrapper(utenteOrganizzazione);
	}

}