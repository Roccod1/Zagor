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
 * This class is a wrapper for {@link IstanzaForm}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IstanzaForm
 * @generated
 */
public class IstanzaFormWrapper
	extends BaseModelWrapper<IstanzaForm>
	implements IstanzaForm, ModelWrapper<IstanzaForm> {

	public IstanzaFormWrapper(IstanzaForm istanzaForm) {
		super(istanzaForm);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("istanzaFormId", getIstanzaFormId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("json", getJson());
		attributes.put("formId", getFormId());
		attributes.put("richiestaId", getRichiestaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long istanzaFormId = (Long)attributes.get("istanzaFormId");

		if (istanzaFormId != null) {
			setIstanzaFormId(istanzaFormId);
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

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
		}
	}

	@Override
	public IstanzaForm cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this istanza form.
	 *
	 * @return the company ID of this istanza form
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this istanza form.
	 *
	 * @return the create date of this istanza form
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the form ID of this istanza form.
	 *
	 * @return the form ID of this istanza form
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the group ID of this istanza form.
	 *
	 * @return the group ID of this istanza form
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the istanza form ID of this istanza form.
	 *
	 * @return the istanza form ID of this istanza form
	 */
	@Override
	public long getIstanzaFormId() {
		return model.getIstanzaFormId();
	}

	/**
	 * Returns the json of this istanza form.
	 *
	 * @return the json of this istanza form
	 */
	@Override
	public String getJson() {
		return model.getJson();
	}

	/**
	 * Returns the modified date of this istanza form.
	 *
	 * @return the modified date of this istanza form
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this istanza form.
	 *
	 * @return the primary key of this istanza form
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the richiesta ID of this istanza form.
	 *
	 * @return the richiesta ID of this istanza form
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the user ID of this istanza form.
	 *
	 * @return the user ID of this istanza form
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this istanza form.
	 *
	 * @return the user name of this istanza form
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this istanza form.
	 *
	 * @return the user uuid of this istanza form
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this istanza form.
	 *
	 * @return the uuid of this istanza form
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
	 * Sets the company ID of this istanza form.
	 *
	 * @param companyId the company ID of this istanza form
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this istanza form.
	 *
	 * @param createDate the create date of this istanza form
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the form ID of this istanza form.
	 *
	 * @param formId the form ID of this istanza form
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the group ID of this istanza form.
	 *
	 * @param groupId the group ID of this istanza form
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the istanza form ID of this istanza form.
	 *
	 * @param istanzaFormId the istanza form ID of this istanza form
	 */
	@Override
	public void setIstanzaFormId(long istanzaFormId) {
		model.setIstanzaFormId(istanzaFormId);
	}

	/**
	 * Sets the json of this istanza form.
	 *
	 * @param json the json of this istanza form
	 */
	@Override
	public void setJson(String json) {
		model.setJson(json);
	}

	/**
	 * Sets the modified date of this istanza form.
	 *
	 * @param modifiedDate the modified date of this istanza form
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this istanza form.
	 *
	 * @param primaryKey the primary key of this istanza form
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the richiesta ID of this istanza form.
	 *
	 * @param richiestaId the richiesta ID of this istanza form
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the user ID of this istanza form.
	 *
	 * @param userId the user ID of this istanza form
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this istanza form.
	 *
	 * @param userName the user name of this istanza form
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this istanza form.
	 *
	 * @param userUuid the user uuid of this istanza form
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this istanza form.
	 *
	 * @param uuid the uuid of this istanza form
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
	protected IstanzaFormWrapper wrap(IstanzaForm istanzaForm) {
		return new IstanzaFormWrapper(istanzaForm);
	}

}