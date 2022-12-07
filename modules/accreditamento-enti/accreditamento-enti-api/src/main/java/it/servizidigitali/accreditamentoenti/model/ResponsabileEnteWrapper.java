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

package it.servizidigitali.accreditamentoenti.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ResponsabileEnte}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnte
 * @generated
 */
public class ResponsabileEnteWrapper
	extends BaseModelWrapper<ResponsabileEnte>
	implements ModelWrapper<ResponsabileEnte>, ResponsabileEnte {

	public ResponsabileEnteWrapper(ResponsabileEnte responsabileEnte) {
		super(responsabileEnte);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("responsabileEnteId", getResponsabileEnteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("responsabileUserId", getResponsabileUserId());
		attributes.put("enteId", getEnteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long responsabileEnteId = (Long)attributes.get("responsabileEnteId");

		if (responsabileEnteId != null) {
			setResponsabileEnteId(responsabileEnteId);
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

		Long responsabileUserId = (Long)attributes.get("responsabileUserId");

		if (responsabileUserId != null) {
			setResponsabileUserId(responsabileUserId);
		}

		Long enteId = (Long)attributes.get("enteId");

		if (enteId != null) {
			setEnteId(enteId);
		}
	}

	@Override
	public ResponsabileEnte cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this responsabile ente.
	 *
	 * @return the company ID of this responsabile ente
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this responsabile ente.
	 *
	 * @return the create date of this responsabile ente
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the ente ID of this responsabile ente.
	 *
	 * @return the ente ID of this responsabile ente
	 */
	@Override
	public long getEnteId() {
		return model.getEnteId();
	}

	/**
	 * Returns the group ID of this responsabile ente.
	 *
	 * @return the group ID of this responsabile ente
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this responsabile ente.
	 *
	 * @return the modified date of this responsabile ente
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this responsabile ente.
	 *
	 * @return the primary key of this responsabile ente
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the responsabile ente ID of this responsabile ente.
	 *
	 * @return the responsabile ente ID of this responsabile ente
	 */
	@Override
	public long getResponsabileEnteId() {
		return model.getResponsabileEnteId();
	}

	/**
	 * Returns the responsabile user ID of this responsabile ente.
	 *
	 * @return the responsabile user ID of this responsabile ente
	 */
	@Override
	public long getResponsabileUserId() {
		return model.getResponsabileUserId();
	}

	/**
	 * Returns the responsabile user uuid of this responsabile ente.
	 *
	 * @return the responsabile user uuid of this responsabile ente
	 */
	@Override
	public String getResponsabileUserUuid() {
		return model.getResponsabileUserUuid();
	}

	/**
	 * Returns the user ID of this responsabile ente.
	 *
	 * @return the user ID of this responsabile ente
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this responsabile ente.
	 *
	 * @return the user name of this responsabile ente
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this responsabile ente.
	 *
	 * @return the user uuid of this responsabile ente
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this responsabile ente.
	 *
	 * @return the uuid of this responsabile ente
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
	 * Sets the company ID of this responsabile ente.
	 *
	 * @param companyId the company ID of this responsabile ente
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this responsabile ente.
	 *
	 * @param createDate the create date of this responsabile ente
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the ente ID of this responsabile ente.
	 *
	 * @param enteId the ente ID of this responsabile ente
	 */
	@Override
	public void setEnteId(long enteId) {
		model.setEnteId(enteId);
	}

	/**
	 * Sets the group ID of this responsabile ente.
	 *
	 * @param groupId the group ID of this responsabile ente
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this responsabile ente.
	 *
	 * @param modifiedDate the modified date of this responsabile ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this responsabile ente.
	 *
	 * @param primaryKey the primary key of this responsabile ente
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the responsabile ente ID of this responsabile ente.
	 *
	 * @param responsabileEnteId the responsabile ente ID of this responsabile ente
	 */
	@Override
	public void setResponsabileEnteId(long responsabileEnteId) {
		model.setResponsabileEnteId(responsabileEnteId);
	}

	/**
	 * Sets the responsabile user ID of this responsabile ente.
	 *
	 * @param responsabileUserId the responsabile user ID of this responsabile ente
	 */
	@Override
	public void setResponsabileUserId(long responsabileUserId) {
		model.setResponsabileUserId(responsabileUserId);
	}

	/**
	 * Sets the responsabile user uuid of this responsabile ente.
	 *
	 * @param responsabileUserUuid the responsabile user uuid of this responsabile ente
	 */
	@Override
	public void setResponsabileUserUuid(String responsabileUserUuid) {
		model.setResponsabileUserUuid(responsabileUserUuid);
	}

	/**
	 * Sets the user ID of this responsabile ente.
	 *
	 * @param userId the user ID of this responsabile ente
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this responsabile ente.
	 *
	 * @param userName the user name of this responsabile ente
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this responsabile ente.
	 *
	 * @param userUuid the user uuid of this responsabile ente
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this responsabile ente.
	 *
	 * @param uuid the uuid of this responsabile ente
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
	protected ResponsabileEnteWrapper wrap(ResponsabileEnte responsabileEnte) {
		return new ResponsabileEnteWrapper(responsabileEnte);
	}

}