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
 * This class is a wrapper for {@link AllegatoRichiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AllegatoRichiesta
 * @generated
 */
public class AllegatoRichiestaWrapper
	extends BaseModelWrapper<AllegatoRichiesta>
	implements AllegatoRichiesta, ModelWrapper<AllegatoRichiesta> {

	public AllegatoRichiestaWrapper(AllegatoRichiesta allegatoRichiesta) {
		super(allegatoRichiesta);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("richiestaId", getRichiestaId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("idDocumentale", getIdDocumentale());
		attributes.put("url", getUrl());
		attributes.put("principale", isPrincipale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String idDocumentale = (String)attributes.get("idDocumentale");

		if (idDocumentale != null) {
			setIdDocumentale(idDocumentale);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean principale = (Boolean)attributes.get("principale");

		if (principale != null) {
			setPrincipale(principale);
		}
	}

	@Override
	public AllegatoRichiesta cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this allegato richiesta.
	 *
	 * @return the company ID of this allegato richiesta
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allegato richiesta.
	 *
	 * @return the create date of this allegato richiesta
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file entry ID of this allegato richiesta.
	 *
	 * @return the file entry ID of this allegato richiesta
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the group ID of this allegato richiesta.
	 *
	 * @return the group ID of this allegato richiesta
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id documentale of this allegato richiesta.
	 *
	 * @return the id documentale of this allegato richiesta
	 */
	@Override
	public String getIdDocumentale() {
		return model.getIdDocumentale();
	}

	/**
	 * Returns the modified date of this allegato richiesta.
	 *
	 * @return the modified date of this allegato richiesta
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this allegato richiesta.
	 *
	 * @return the nome of this allegato richiesta
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this allegato richiesta.
	 *
	 * @return the primary key of this allegato richiesta
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.service.persistence.
		AllegatoRichiestaPK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the principale of this allegato richiesta.
	 *
	 * @return the principale of this allegato richiesta
	 */
	@Override
	public boolean getPrincipale() {
		return model.getPrincipale();
	}

	/**
	 * Returns the richiesta ID of this allegato richiesta.
	 *
	 * @return the richiesta ID of this allegato richiesta
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the url of this allegato richiesta.
	 *
	 * @return the url of this allegato richiesta
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this allegato richiesta.
	 *
	 * @return the user ID of this allegato richiesta
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allegato richiesta.
	 *
	 * @return the user name of this allegato richiesta
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allegato richiesta.
	 *
	 * @return the user uuid of this allegato richiesta
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this allegato richiesta.
	 *
	 * @return the uuid of this allegato richiesta
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this allegato richiesta is principale.
	 *
	 * @return <code>true</code> if this allegato richiesta is principale; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrincipale() {
		return model.isPrincipale();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this allegato richiesta.
	 *
	 * @param companyId the company ID of this allegato richiesta
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allegato richiesta.
	 *
	 * @param createDate the create date of this allegato richiesta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file entry ID of this allegato richiesta.
	 *
	 * @param fileEntryId the file entry ID of this allegato richiesta
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the group ID of this allegato richiesta.
	 *
	 * @param groupId the group ID of this allegato richiesta
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id documentale of this allegato richiesta.
	 *
	 * @param idDocumentale the id documentale of this allegato richiesta
	 */
	@Override
	public void setIdDocumentale(String idDocumentale) {
		model.setIdDocumentale(idDocumentale);
	}

	/**
	 * Sets the modified date of this allegato richiesta.
	 *
	 * @param modifiedDate the modified date of this allegato richiesta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this allegato richiesta.
	 *
	 * @param nome the nome of this allegato richiesta
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this allegato richiesta.
	 *
	 * @param primaryKey the primary key of this allegato richiesta
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			AllegatoRichiestaPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this allegato richiesta is principale.
	 *
	 * @param principale the principale of this allegato richiesta
	 */
	@Override
	public void setPrincipale(boolean principale) {
		model.setPrincipale(principale);
	}

	/**
	 * Sets the richiesta ID of this allegato richiesta.
	 *
	 * @param richiestaId the richiesta ID of this allegato richiesta
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the url of this allegato richiesta.
	 *
	 * @param url the url of this allegato richiesta
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this allegato richiesta.
	 *
	 * @param userId the user ID of this allegato richiesta
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allegato richiesta.
	 *
	 * @param userName the user name of this allegato richiesta
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allegato richiesta.
	 *
	 * @param userUuid the user uuid of this allegato richiesta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allegato richiesta.
	 *
	 * @param uuid the uuid of this allegato richiesta
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
	protected AllegatoRichiestaWrapper wrap(
		AllegatoRichiesta allegatoRichiesta) {

		return new AllegatoRichiestaWrapper(allegatoRichiesta);
	}

}