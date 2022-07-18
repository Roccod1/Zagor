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
 * This class is a wrapper for {@link Form}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Form
 * @generated
 */
public class FormWrapper
	extends BaseModelWrapper<Form> implements Form, ModelWrapper<Form> {

	public FormWrapper(Form form) {
		super(form);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("formId", getFormId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codice", getCodice());
		attributes.put("json", getJson());
		attributes.put("principale", isPrincipale());
		attributes.put("multiutente", isMultiutente());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
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

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}

		Boolean principale = (Boolean)attributes.get("principale");

		if (principale != null) {
			setPrincipale(principale);
		}

		Boolean multiutente = (Boolean)attributes.get("multiutente");

		if (multiutente != null) {
			setMultiutente(multiutente);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	@Override
	public Form cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice of this form.
	 *
	 * @return the codice of this form
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the company ID of this form.
	 *
	 * @return the company ID of this form
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this form.
	 *
	 * @return the create date of this form
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the descrizione of this form.
	 *
	 * @return the descrizione of this form
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the form ID of this form.
	 *
	 * @return the form ID of this form
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the group ID of this form.
	 *
	 * @return the group ID of this form
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the json of this form.
	 *
	 * @return the json of this form
	 */
	@Override
	public String getJson() {
		return model.getJson();
	}

	@Override
	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getListaDefinizioneAllegato() {

		return model.getListaDefinizioneAllegato();
	}

	/**
	 * Returns the modified date of this form.
	 *
	 * @return the modified date of this form
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the multiutente of this form.
	 *
	 * @return the multiutente of this form
	 */
	@Override
	public boolean getMultiutente() {
		return model.getMultiutente();
	}

	/**
	 * Returns the nome of this form.
	 *
	 * @return the nome of this form
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the organization ID of this form.
	 *
	 * @return the organization ID of this form
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this form.
	 *
	 * @return the primary key of this form
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the principale of this form.
	 *
	 * @return the principale of this form
	 */
	@Override
	public boolean getPrincipale() {
		return model.getPrincipale();
	}

	/**
	 * Returns the user ID of this form.
	 *
	 * @return the user ID of this form
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this form.
	 *
	 * @return the user name of this form
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this form.
	 *
	 * @return the user uuid of this form
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this form.
	 *
	 * @return the uuid of this form
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this form is multiutente.
	 *
	 * @return <code>true</code> if this form is multiutente; <code>false</code> otherwise
	 */
	@Override
	public boolean isMultiutente() {
		return model.isMultiutente();
	}

	/**
	 * Returns <code>true</code> if this form is principale.
	 *
	 * @return <code>true</code> if this form is principale; <code>false</code> otherwise
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
	 * Sets the codice of this form.
	 *
	 * @param codice the codice of this form
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the company ID of this form.
	 *
	 * @param companyId the company ID of this form
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this form.
	 *
	 * @param createDate the create date of this form
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the descrizione of this form.
	 *
	 * @param descrizione the descrizione of this form
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the form ID of this form.
	 *
	 * @param formId the form ID of this form
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the group ID of this form.
	 *
	 * @param groupId the group ID of this form
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the json of this form.
	 *
	 * @param json the json of this form
	 */
	@Override
	public void setJson(String json) {
		model.setJson(json);
	}

	@Override
	public void setListaDefinizioneAllegato(
		java.util.List
			<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
				listaDefinizioneAllegato) {

		model.setListaDefinizioneAllegato(listaDefinizioneAllegato);
	}

	/**
	 * Sets the modified date of this form.
	 *
	 * @param modifiedDate the modified date of this form
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this form is multiutente.
	 *
	 * @param multiutente the multiutente of this form
	 */
	@Override
	public void setMultiutente(boolean multiutente) {
		model.setMultiutente(multiutente);
	}

	/**
	 * Sets the nome of this form.
	 *
	 * @param nome the nome of this form
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the organization ID of this form.
	 *
	 * @param organizationId the organization ID of this form
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this form.
	 *
	 * @param primaryKey the primary key of this form
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this form is principale.
	 *
	 * @param principale the principale of this form
	 */
	@Override
	public void setPrincipale(boolean principale) {
		model.setPrincipale(principale);
	}

	/**
	 * Sets the user ID of this form.
	 *
	 * @param userId the user ID of this form
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this form.
	 *
	 * @param userName the user name of this form
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this form.
	 *
	 * @param userUuid the user uuid of this form
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this form.
	 *
	 * @param uuid the uuid of this form
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
	protected FormWrapper wrap(Form form) {
		return new FormWrapper(form);
	}

}