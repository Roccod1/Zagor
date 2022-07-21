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

package it.servizidigitali.gestioneprocedure.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProceduraForm}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduraForm
 * @generated
 */
public class ProceduraFormWrapper
	extends BaseModelWrapper<ProceduraForm>
	implements ModelWrapper<ProceduraForm>, ProceduraForm {

	public ProceduraFormWrapper(ProceduraForm proceduraForm) {
		super(proceduraForm);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("proceduraId", getProceduraId());
		attributes.put("formId", getFormId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long proceduraId = (Long)attributes.get("proceduraId");

		if (proceduraId != null) {
			setProceduraId(proceduraId);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public ProceduraForm cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this procedura form.
	 *
	 * @return the company ID of this procedura form
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the form ID of this procedura form.
	 *
	 * @return the form ID of this procedura form
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the primary key of this procedura form.
	 *
	 * @return the primary key of this procedura form
	 */
	@Override
	public
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedura ID of this procedura form.
	 *
	 * @return the procedura ID of this procedura form
	 */
	@Override
	public long getProceduraId() {
		return model.getProceduraId();
	}

	/**
	 * Returns the uuid of this procedura form.
	 *
	 * @return the uuid of this procedura form
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
	 * Sets the company ID of this procedura form.
	 *
	 * @param companyId the company ID of this procedura form
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the form ID of this procedura form.
	 *
	 * @param formId the form ID of this procedura form
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the primary key of this procedura form.
	 *
	 * @param primaryKey the primary key of this procedura form
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedura ID of this procedura form.
	 *
	 * @param proceduraId the procedura ID of this procedura form
	 */
	@Override
	public void setProceduraId(long proceduraId) {
		model.setProceduraId(proceduraId);
	}

	/**
	 * Sets the uuid of this procedura form.
	 *
	 * @param uuid the uuid of this procedura form
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ProceduraFormWrapper wrap(ProceduraForm proceduraForm) {
		return new ProceduraFormWrapper(proceduraForm);
	}

}