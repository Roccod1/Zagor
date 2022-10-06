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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AttivitaRichiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttivitaRichiesta
 * @generated
 */
public class AttivitaRichiestaWrapper
	extends BaseModelWrapper<AttivitaRichiesta>
	implements AttivitaRichiesta, ModelWrapper<AttivitaRichiesta> {

	public AttivitaRichiestaWrapper(AttivitaRichiesta attivitaRichiesta) {
		super(attivitaRichiesta);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("attivitaRichiestaId", getAttivitaRichiestaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("note", getNote());
		attributes.put("stato", getStato());
		attributes.put("richiestaId", getRichiestaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long attivitaRichiestaId = (Long)attributes.get("attivitaRichiestaId");

		if (attivitaRichiestaId != null) {
			setAttivitaRichiestaId(attivitaRichiestaId);
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

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
		}
	}

	@Override
	public AttivitaRichiesta cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivita richiesta ID of this attivita richiesta.
	 *
	 * @return the attivita richiesta ID of this attivita richiesta
	 */
	@Override
	public long getAttivitaRichiestaId() {
		return model.getAttivitaRichiestaId();
	}

	/**
	 * Returns the company ID of this attivita richiesta.
	 *
	 * @return the company ID of this attivita richiesta
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this attivita richiesta.
	 *
	 * @return the create date of this attivita richiesta
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this attivita richiesta.
	 *
	 * @return the group ID of this attivita richiesta
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this attivita richiesta.
	 *
	 * @return the modified date of this attivita richiesta
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this attivita richiesta.
	 *
	 * @return the note of this attivita richiesta
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this attivita richiesta.
	 *
	 * @return the primary key of this attivita richiesta
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the richiesta ID of this attivita richiesta.
	 *
	 * @return the richiesta ID of this attivita richiesta
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the stato of this attivita richiesta.
	 *
	 * @return the stato of this attivita richiesta
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the user ID of this attivita richiesta.
	 *
	 * @return the user ID of this attivita richiesta
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this attivita richiesta.
	 *
	 * @return the user name of this attivita richiesta
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this attivita richiesta.
	 *
	 * @return the user uuid of this attivita richiesta
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this attivita richiesta.
	 *
	 * @return the uuid of this attivita richiesta
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
	 * Sets the attivita richiesta ID of this attivita richiesta.
	 *
	 * @param attivitaRichiestaId the attivita richiesta ID of this attivita richiesta
	 */
	@Override
	public void setAttivitaRichiestaId(long attivitaRichiestaId) {
		model.setAttivitaRichiestaId(attivitaRichiestaId);
	}

	/**
	 * Sets the company ID of this attivita richiesta.
	 *
	 * @param companyId the company ID of this attivita richiesta
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this attivita richiesta.
	 *
	 * @param createDate the create date of this attivita richiesta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this attivita richiesta.
	 *
	 * @param groupId the group ID of this attivita richiesta
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this attivita richiesta.
	 *
	 * @param modifiedDate the modified date of this attivita richiesta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this attivita richiesta.
	 *
	 * @param note the note of this attivita richiesta
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this attivita richiesta.
	 *
	 * @param primaryKey the primary key of this attivita richiesta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the richiesta ID of this attivita richiesta.
	 *
	 * @param richiestaId the richiesta ID of this attivita richiesta
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the stato of this attivita richiesta.
	 *
	 * @param stato the stato of this attivita richiesta
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the user ID of this attivita richiesta.
	 *
	 * @param userId the user ID of this attivita richiesta
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this attivita richiesta.
	 *
	 * @param userName the user name of this attivita richiesta
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this attivita richiesta.
	 *
	 * @param userUuid the user uuid of this attivita richiesta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this attivita richiesta.
	 *
	 * @param uuid the uuid of this attivita richiesta
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
	protected AttivitaRichiestaWrapper wrap(
		AttivitaRichiesta attivitaRichiesta) {

		return new AttivitaRichiestaWrapper(attivitaRichiesta);
	}

}