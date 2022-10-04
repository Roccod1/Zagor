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

package it.servizidigitali.gestioneforms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DefinizioneAllegato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegato
 * @generated
 */
public class DefinizioneAllegatoWrapper
	extends BaseModelWrapper<DefinizioneAllegato>
	implements DefinizioneAllegato, ModelWrapper<DefinizioneAllegato> {

	public DefinizioneAllegatoWrapper(DefinizioneAllegato definizioneAllegato) {
		super(definizioneAllegato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("definizioneAllegatoId", getDefinizioneAllegatoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("denominazione", getDenominazione());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("filenameModello", getFilenameModello());
		attributes.put("tipiFileAmmessi", getTipiFileAmmessi());
		attributes.put(
			"codiciTipologiaDocumento", getCodiciTipologiaDocumento());
		attributes.put("obbligatorio", isObbligatorio());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("formId", getFormId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long definizioneAllegatoId = (Long)attributes.get(
			"definizioneAllegatoId");

		if (definizioneAllegatoId != null) {
			setDefinizioneAllegatoId(definizioneAllegatoId);
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

		String denominazione = (String)attributes.get("denominazione");

		if (denominazione != null) {
			setDenominazione(denominazione);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String filenameModello = (String)attributes.get("filenameModello");

		if (filenameModello != null) {
			setFilenameModello(filenameModello);
		}

		String tipiFileAmmessi = (String)attributes.get("tipiFileAmmessi");

		if (tipiFileAmmessi != null) {
			setTipiFileAmmessi(tipiFileAmmessi);
		}

		String codiciTipologiaDocumento = (String)attributes.get(
			"codiciTipologiaDocumento");

		if (codiciTipologiaDocumento != null) {
			setCodiciTipologiaDocumento(codiciTipologiaDocumento);
		}

		Boolean obbligatorio = (Boolean)attributes.get("obbligatorio");

		if (obbligatorio != null) {
			setObbligatorio(obbligatorio);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}
	}

	@Override
	public DefinizioneAllegato cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codici tipologia documento of this definizione allegato.
	 *
	 * @return the codici tipologia documento of this definizione allegato
	 */
	@Override
	public String getCodiciTipologiaDocumento() {
		return model.getCodiciTipologiaDocumento();
	}

	/**
	 * Returns the company ID of this definizione allegato.
	 *
	 * @return the company ID of this definizione allegato
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this definizione allegato.
	 *
	 * @return the create date of this definizione allegato
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the definizione allegato ID of this definizione allegato.
	 *
	 * @return the definizione allegato ID of this definizione allegato
	 */
	@Override
	public long getDefinizioneAllegatoId() {
		return model.getDefinizioneAllegatoId();
	}

	/**
	 * Returns the denominazione of this definizione allegato.
	 *
	 * @return the denominazione of this definizione allegato
	 */
	@Override
	public String getDenominazione() {
		return model.getDenominazione();
	}

	/**
	 * Returns the file entry ID of this definizione allegato.
	 *
	 * @return the file entry ID of this definizione allegato
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the filename modello of this definizione allegato.
	 *
	 * @return the filename modello of this definizione allegato
	 */
	@Override
	public String getFilenameModello() {
		return model.getFilenameModello();
	}

	/**
	 * Returns the form ID of this definizione allegato.
	 *
	 * @return the form ID of this definizione allegato
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the group ID of this definizione allegato.
	 *
	 * @return the group ID of this definizione allegato
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this definizione allegato.
	 *
	 * @return the modified date of this definizione allegato
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the obbligatorio of this definizione allegato.
	 *
	 * @return the obbligatorio of this definizione allegato
	 */
	@Override
	public boolean getObbligatorio() {
		return model.getObbligatorio();
	}

	/**
	 * Returns the organization ID of this definizione allegato.
	 *
	 * @return the organization ID of this definizione allegato
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this definizione allegato.
	 *
	 * @return the primary key of this definizione allegato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipi file ammessi of this definizione allegato.
	 *
	 * @return the tipi file ammessi of this definizione allegato
	 */
	@Override
	public String getTipiFileAmmessi() {
		return model.getTipiFileAmmessi();
	}

	/**
	 * Returns the user ID of this definizione allegato.
	 *
	 * @return the user ID of this definizione allegato
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this definizione allegato.
	 *
	 * @return the user name of this definizione allegato
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this definizione allegato.
	 *
	 * @return the user uuid of this definizione allegato
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this definizione allegato.
	 *
	 * @return the uuid of this definizione allegato
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this definizione allegato is obbligatorio.
	 *
	 * @return <code>true</code> if this definizione allegato is obbligatorio; <code>false</code> otherwise
	 */
	@Override
	public boolean isObbligatorio() {
		return model.isObbligatorio();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codici tipologia documento of this definizione allegato.
	 *
	 * @param codiciTipologiaDocumento the codici tipologia documento of this definizione allegato
	 */
	@Override
	public void setCodiciTipologiaDocumento(String codiciTipologiaDocumento) {
		model.setCodiciTipologiaDocumento(codiciTipologiaDocumento);
	}

	/**
	 * Sets the company ID of this definizione allegato.
	 *
	 * @param companyId the company ID of this definizione allegato
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this definizione allegato.
	 *
	 * @param createDate the create date of this definizione allegato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the definizione allegato ID of this definizione allegato.
	 *
	 * @param definizioneAllegatoId the definizione allegato ID of this definizione allegato
	 */
	@Override
	public void setDefinizioneAllegatoId(long definizioneAllegatoId) {
		model.setDefinizioneAllegatoId(definizioneAllegatoId);
	}

	/**
	 * Sets the denominazione of this definizione allegato.
	 *
	 * @param denominazione the denominazione of this definizione allegato
	 */
	@Override
	public void setDenominazione(String denominazione) {
		model.setDenominazione(denominazione);
	}

	/**
	 * Sets the file entry ID of this definizione allegato.
	 *
	 * @param fileEntryId the file entry ID of this definizione allegato
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the filename modello of this definizione allegato.
	 *
	 * @param filenameModello the filename modello of this definizione allegato
	 */
	@Override
	public void setFilenameModello(String filenameModello) {
		model.setFilenameModello(filenameModello);
	}

	/**
	 * Sets the form ID of this definizione allegato.
	 *
	 * @param formId the form ID of this definizione allegato
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the group ID of this definizione allegato.
	 *
	 * @param groupId the group ID of this definizione allegato
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this definizione allegato.
	 *
	 * @param modifiedDate the modified date of this definizione allegato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this definizione allegato is obbligatorio.
	 *
	 * @param obbligatorio the obbligatorio of this definizione allegato
	 */
	@Override
	public void setObbligatorio(boolean obbligatorio) {
		model.setObbligatorio(obbligatorio);
	}

	/**
	 * Sets the organization ID of this definizione allegato.
	 *
	 * @param organizationId the organization ID of this definizione allegato
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this definizione allegato.
	 *
	 * @param primaryKey the primary key of this definizione allegato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipi file ammessi of this definizione allegato.
	 *
	 * @param tipiFileAmmessi the tipi file ammessi of this definizione allegato
	 */
	@Override
	public void setTipiFileAmmessi(String tipiFileAmmessi) {
		model.setTipiFileAmmessi(tipiFileAmmessi);
	}

	/**
	 * Sets the user ID of this definizione allegato.
	 *
	 * @param userId the user ID of this definizione allegato
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this definizione allegato.
	 *
	 * @param userName the user name of this definizione allegato
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this definizione allegato.
	 *
	 * @param userUuid the user uuid of this definizione allegato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this definizione allegato.
	 *
	 * @param uuid the uuid of this definizione allegato
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
	protected DefinizioneAllegatoWrapper wrap(
		DefinizioneAllegato definizioneAllegato) {

		return new DefinizioneAllegatoWrapper(definizioneAllegato);
	}

}