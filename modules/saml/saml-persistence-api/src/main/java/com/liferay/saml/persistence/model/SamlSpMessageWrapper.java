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

package com.liferay.saml.persistence.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SamlSpMessage}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlSpMessage
 * @generated
 */
public class SamlSpMessageWrapper
	extends BaseModelWrapper<SamlSpMessage>
	implements ModelWrapper<SamlSpMessage>, SamlSpMessage {

	public SamlSpMessageWrapper(SamlSpMessage samlSpMessage) {
		super(samlSpMessage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlSpMessageId", getSamlSpMessageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("samlIdpEntityId", getSamlIdpEntityId());
		attributes.put("samlIdpResponseKey", getSamlIdpResponseKey());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlSpMessageId = (Long)attributes.get("samlSpMessageId");

		if (samlSpMessageId != null) {
			setSamlSpMessageId(samlSpMessageId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String samlIdpEntityId = (String)attributes.get("samlIdpEntityId");

		if (samlIdpEntityId != null) {
			setSamlIdpEntityId(samlIdpEntityId);
		}

		String samlIdpResponseKey = (String)attributes.get(
			"samlIdpResponseKey");

		if (samlIdpResponseKey != null) {
			setSamlIdpResponseKey(samlIdpResponseKey);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	@Override
	public SamlSpMessage cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this saml sp message.
	 *
	 * @return the company ID of this saml sp message
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this saml sp message.
	 *
	 * @return the create date of this saml sp message
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expiration date of this saml sp message.
	 *
	 * @return the expiration date of this saml sp message
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the primary key of this saml sp message.
	 *
	 * @return the primary key of this saml sp message
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the saml idp entity ID of this saml sp message.
	 *
	 * @return the saml idp entity ID of this saml sp message
	 */
	@Override
	public String getSamlIdpEntityId() {
		return model.getSamlIdpEntityId();
	}

	/**
	 * Returns the saml idp response key of this saml sp message.
	 *
	 * @return the saml idp response key of this saml sp message
	 */
	@Override
	public String getSamlIdpResponseKey() {
		return model.getSamlIdpResponseKey();
	}

	/**
	 * Returns the saml sp message ID of this saml sp message.
	 *
	 * @return the saml sp message ID of this saml sp message
	 */
	@Override
	public long getSamlSpMessageId() {
		return model.getSamlSpMessageId();
	}

	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this saml sp message.
	 *
	 * @param companyId the company ID of this saml sp message
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this saml sp message.
	 *
	 * @param createDate the create date of this saml sp message
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expiration date of this saml sp message.
	 *
	 * @param expirationDate the expiration date of this saml sp message
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the primary key of this saml sp message.
	 *
	 * @param primaryKey the primary key of this saml sp message
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the saml idp entity ID of this saml sp message.
	 *
	 * @param samlIdpEntityId the saml idp entity ID of this saml sp message
	 */
	@Override
	public void setSamlIdpEntityId(String samlIdpEntityId) {
		model.setSamlIdpEntityId(samlIdpEntityId);
	}

	/**
	 * Sets the saml idp response key of this saml sp message.
	 *
	 * @param samlIdpResponseKey the saml idp response key of this saml sp message
	 */
	@Override
	public void setSamlIdpResponseKey(String samlIdpResponseKey) {
		model.setSamlIdpResponseKey(samlIdpResponseKey);
	}

	/**
	 * Sets the saml sp message ID of this saml sp message.
	 *
	 * @param samlSpMessageId the saml sp message ID of this saml sp message
	 */
	@Override
	public void setSamlSpMessageId(long samlSpMessageId) {
		model.setSamlSpMessageId(samlSpMessageId);
	}

	@Override
	protected SamlSpMessageWrapper wrap(SamlSpMessage samlSpMessage) {
		return new SamlSpMessageWrapper(samlSpMessage);
	}

}