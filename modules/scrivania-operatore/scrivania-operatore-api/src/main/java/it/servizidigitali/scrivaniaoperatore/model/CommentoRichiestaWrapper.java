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
 * This class is a wrapper for {@link CommentoRichiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiesta
 * @generated
 */
public class CommentoRichiestaWrapper
	extends BaseModelWrapper<CommentoRichiesta>
	implements CommentoRichiesta, ModelWrapper<CommentoRichiesta> {

	public CommentoRichiestaWrapper(CommentoRichiesta commentoRichiesta) {
		super(commentoRichiesta);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commentoRichiestaId", getCommentoRichiestaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("testo", getTesto());
		attributes.put("taskId", getTaskId());
		attributes.put("visibile", isVisibile());
		attributes.put("richiestaId", getRichiestaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commentoRichiestaId = (Long)attributes.get("commentoRichiestaId");

		if (commentoRichiestaId != null) {
			setCommentoRichiestaId(commentoRichiestaId);
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

		String testo = (String)attributes.get("testo");

		if (testo != null) {
			setTesto(testo);
		}

		String taskId = (String)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Boolean visibile = (Boolean)attributes.get("visibile");

		if (visibile != null) {
			setVisibile(visibile);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
		}
	}

	@Override
	public CommentoRichiesta cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the commento richiesta ID of this commento richiesta.
	 *
	 * @return the commento richiesta ID of this commento richiesta
	 */
	@Override
	public long getCommentoRichiestaId() {
		return model.getCommentoRichiestaId();
	}

	/**
	 * Returns the company ID of this commento richiesta.
	 *
	 * @return the company ID of this commento richiesta
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this commento richiesta.
	 *
	 * @return the create date of this commento richiesta
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this commento richiesta.
	 *
	 * @return the group ID of this commento richiesta
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this commento richiesta.
	 *
	 * @return the modified date of this commento richiesta
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this commento richiesta.
	 *
	 * @return the primary key of this commento richiesta
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the richiesta ID of this commento richiesta.
	 *
	 * @return the richiesta ID of this commento richiesta
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the task ID of this commento richiesta.
	 *
	 * @return the task ID of this commento richiesta
	 */
	@Override
	public String getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the testo of this commento richiesta.
	 *
	 * @return the testo of this commento richiesta
	 */
	@Override
	public String getTesto() {
		return model.getTesto();
	}

	/**
	 * Returns the user ID of this commento richiesta.
	 *
	 * @return the user ID of this commento richiesta
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this commento richiesta.
	 *
	 * @return the user name of this commento richiesta
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this commento richiesta.
	 *
	 * @return the user uuid of this commento richiesta
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this commento richiesta.
	 *
	 * @return the uuid of this commento richiesta
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visibile of this commento richiesta.
	 *
	 * @return the visibile of this commento richiesta
	 */
	@Override
	public boolean getVisibile() {
		return model.getVisibile();
	}

	/**
	 * Returns <code>true</code> if this commento richiesta is visibile.
	 *
	 * @return <code>true</code> if this commento richiesta is visibile; <code>false</code> otherwise
	 */
	@Override
	public boolean isVisibile() {
		return model.isVisibile();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the commento richiesta ID of this commento richiesta.
	 *
	 * @param commentoRichiestaId the commento richiesta ID of this commento richiesta
	 */
	@Override
	public void setCommentoRichiestaId(long commentoRichiestaId) {
		model.setCommentoRichiestaId(commentoRichiestaId);
	}

	/**
	 * Sets the company ID of this commento richiesta.
	 *
	 * @param companyId the company ID of this commento richiesta
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this commento richiesta.
	 *
	 * @param createDate the create date of this commento richiesta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this commento richiesta.
	 *
	 * @param groupId the group ID of this commento richiesta
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this commento richiesta.
	 *
	 * @param modifiedDate the modified date of this commento richiesta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this commento richiesta.
	 *
	 * @param primaryKey the primary key of this commento richiesta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the richiesta ID of this commento richiesta.
	 *
	 * @param richiestaId the richiesta ID of this commento richiesta
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the task ID of this commento richiesta.
	 *
	 * @param taskId the task ID of this commento richiesta
	 */
	@Override
	public void setTaskId(String taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the testo of this commento richiesta.
	 *
	 * @param testo the testo of this commento richiesta
	 */
	@Override
	public void setTesto(String testo) {
		model.setTesto(testo);
	}

	/**
	 * Sets the user ID of this commento richiesta.
	 *
	 * @param userId the user ID of this commento richiesta
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this commento richiesta.
	 *
	 * @param userName the user name of this commento richiesta
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this commento richiesta.
	 *
	 * @param userUuid the user uuid of this commento richiesta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this commento richiesta.
	 *
	 * @param uuid the uuid of this commento richiesta
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this commento richiesta is visibile.
	 *
	 * @param visibile the visibile of this commento richiesta
	 */
	@Override
	public void setVisibile(boolean visibile) {
		model.setVisibile(visibile);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CommentoRichiestaWrapper wrap(
		CommentoRichiesta commentoRichiesta) {

		return new CommentoRichiestaWrapper(commentoRichiesta);
	}

}