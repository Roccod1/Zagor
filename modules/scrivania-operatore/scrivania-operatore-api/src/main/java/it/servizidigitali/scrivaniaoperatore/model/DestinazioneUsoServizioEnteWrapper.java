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
 * This class is a wrapper for {@link DestinazioneUsoServizioEnte}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoServizioEnte
 * @generated
 */
public class DestinazioneUsoServizioEnteWrapper
	extends BaseModelWrapper<DestinazioneUsoServizioEnte>
	implements DestinazioneUsoServizioEnte,
			   ModelWrapper<DestinazioneUsoServizioEnte> {

	public DestinazioneUsoServizioEnteWrapper(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		super(destinazioneUsoServizioEnte);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("destinazioneUsoId", getDestinazioneUsoId());
		attributes.put("servizioId", getServizioId());
		attributes.put("organizationId", getOrganizationId());
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

		Long destinazioneUsoId = (Long)attributes.get("destinazioneUsoId");

		if (destinazioneUsoId != null) {
			setDestinazioneUsoId(destinazioneUsoId);
		}

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
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
	}

	@Override
	public DestinazioneUsoServizioEnte cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this destinazione uso servizio ente.
	 *
	 * @return the company ID of this destinazione uso servizio ente
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this destinazione uso servizio ente.
	 *
	 * @return the create date of this destinazione uso servizio ente
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the destinazione uso ID of this destinazione uso servizio ente.
	 *
	 * @return the destinazione uso ID of this destinazione uso servizio ente
	 */
	@Override
	public long getDestinazioneUsoId() {
		return model.getDestinazioneUsoId();
	}

	/**
	 * Returns the group ID of this destinazione uso servizio ente.
	 *
	 * @return the group ID of this destinazione uso servizio ente
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this destinazione uso servizio ente.
	 *
	 * @return the modified date of this destinazione uso servizio ente
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this destinazione uso servizio ente.
	 *
	 * @return the organization ID of this destinazione uso servizio ente
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this destinazione uso servizio ente.
	 *
	 * @return the primary key of this destinazione uso servizio ente
	 */
	@Override
	public it.servizidigitali.scrivaniaoperatore.service.persistence.
		DestinazioneUsoServizioEntePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the servizio ID of this destinazione uso servizio ente.
	 *
	 * @return the servizio ID of this destinazione uso servizio ente
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the user ID of this destinazione uso servizio ente.
	 *
	 * @return the user ID of this destinazione uso servizio ente
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this destinazione uso servizio ente.
	 *
	 * @return the user name of this destinazione uso servizio ente
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this destinazione uso servizio ente.
	 *
	 * @return the user uuid of this destinazione uso servizio ente
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this destinazione uso servizio ente.
	 *
	 * @return the uuid of this destinazione uso servizio ente
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
	 * Sets the company ID of this destinazione uso servizio ente.
	 *
	 * @param companyId the company ID of this destinazione uso servizio ente
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this destinazione uso servizio ente.
	 *
	 * @param createDate the create date of this destinazione uso servizio ente
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the destinazione uso ID of this destinazione uso servizio ente.
	 *
	 * @param destinazioneUsoId the destinazione uso ID of this destinazione uso servizio ente
	 */
	@Override
	public void setDestinazioneUsoId(long destinazioneUsoId) {
		model.setDestinazioneUsoId(destinazioneUsoId);
	}

	/**
	 * Sets the group ID of this destinazione uso servizio ente.
	 *
	 * @param groupId the group ID of this destinazione uso servizio ente
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this destinazione uso servizio ente.
	 *
	 * @param modifiedDate the modified date of this destinazione uso servizio ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this destinazione uso servizio ente.
	 *
	 * @param organizationId the organization ID of this destinazione uso servizio ente
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this destinazione uso servizio ente.
	 *
	 * @param primaryKey the primary key of this destinazione uso servizio ente
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.scrivaniaoperatore.service.persistence.
			DestinazioneUsoServizioEntePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the servizio ID of this destinazione uso servizio ente.
	 *
	 * @param servizioId the servizio ID of this destinazione uso servizio ente
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets the user ID of this destinazione uso servizio ente.
	 *
	 * @param userId the user ID of this destinazione uso servizio ente
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this destinazione uso servizio ente.
	 *
	 * @param userName the user name of this destinazione uso servizio ente
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this destinazione uso servizio ente.
	 *
	 * @param userUuid the user uuid of this destinazione uso servizio ente
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this destinazione uso servizio ente.
	 *
	 * @param uuid the uuid of this destinazione uso servizio ente
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
	protected DestinazioneUsoServizioEnteWrapper wrap(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		return new DestinazioneUsoServizioEnteWrapper(
			destinazioneUsoServizioEnte);
	}

}