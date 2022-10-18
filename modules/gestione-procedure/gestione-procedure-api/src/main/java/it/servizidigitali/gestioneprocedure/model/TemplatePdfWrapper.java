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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TemplatePdf}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdf
 * @generated
 */
public class TemplatePdfWrapper
	extends BaseModelWrapper<TemplatePdf>
	implements ModelWrapper<TemplatePdf>, TemplatePdf {

	public TemplatePdfWrapper(TemplatePdf templatePdf) {
		super(templatePdf);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("templatePdfId", getTemplatePdfId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("proceduraId", getProceduraId());
		attributes.put("templatePdfParentId", getTemplatePdfParentId());
		attributes.put("tipoTemplate", getTipoTemplate());
		attributes.put("tipoTemplateNativo", getTipoTemplateNativo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long templatePdfId = (Long)attributes.get("templatePdfId");

		if (templatePdfId != null) {
			setTemplatePdfId(templatePdfId);
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

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long proceduraId = (Long)attributes.get("proceduraId");

		if (proceduraId != null) {
			setProceduraId(proceduraId);
		}

		Long templatePdfParentId = (Long)attributes.get("templatePdfParentId");

		if (templatePdfParentId != null) {
			setTemplatePdfParentId(templatePdfParentId);
		}

		String tipoTemplate = (String)attributes.get("tipoTemplate");

		if (tipoTemplate != null) {
			setTipoTemplate(tipoTemplate);
		}

		String tipoTemplateNativo = (String)attributes.get(
			"tipoTemplateNativo");

		if (tipoTemplateNativo != null) {
			setTipoTemplateNativo(tipoTemplateNativo);
		}
	}

	@Override
	public TemplatePdf cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this template pdf.
	 *
	 * @return the company ID of this template pdf
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this template pdf.
	 *
	 * @return the create date of this template pdf
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file entry ID of this template pdf.
	 *
	 * @return the file entry ID of this template pdf
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the group ID of this template pdf.
	 *
	 * @return the group ID of this template pdf
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this template pdf.
	 *
	 * @return the modified date of this template pdf
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	@Override
	public String getNomeFile() {
		return model.getNomeFile();
	}

	/**
	 * Returns the primary key of this template pdf.
	 *
	 * @return the primary key of this template pdf
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedura ID of this template pdf.
	 *
	 * @return the procedura ID of this template pdf
	 */
	@Override
	public long getProceduraId() {
		return model.getProceduraId();
	}

	/**
	 * Returns the template pdf ID of this template pdf.
	 *
	 * @return the template pdf ID of this template pdf
	 */
	@Override
	public long getTemplatePdfId() {
		return model.getTemplatePdfId();
	}

	/**
	 * Returns the template pdf parent ID of this template pdf.
	 *
	 * @return the template pdf parent ID of this template pdf
	 */
	@Override
	public long getTemplatePdfParentId() {
		return model.getTemplatePdfParentId();
	}

	/**
	 * Returns the tipo template of this template pdf.
	 *
	 * @return the tipo template of this template pdf
	 */
	@Override
	public String getTipoTemplate() {
		return model.getTipoTemplate();
	}

	/**
	 * Returns the tipo template nativo of this template pdf.
	 *
	 * @return the tipo template nativo of this template pdf
	 */
	@Override
	public String getTipoTemplateNativo() {
		return model.getTipoTemplateNativo();
	}

	/**
	 * Returns the user ID of this template pdf.
	 *
	 * @return the user ID of this template pdf
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this template pdf.
	 *
	 * @return the user name of this template pdf
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this template pdf.
	 *
	 * @return the user uuid of this template pdf
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this template pdf.
	 *
	 * @return the uuid of this template pdf
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
	 * Sets the company ID of this template pdf.
	 *
	 * @param companyId the company ID of this template pdf
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this template pdf.
	 *
	 * @param createDate the create date of this template pdf
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file entry ID of this template pdf.
	 *
	 * @param fileEntryId the file entry ID of this template pdf
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the group ID of this template pdf.
	 *
	 * @param groupId the group ID of this template pdf
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this template pdf.
	 *
	 * @param modifiedDate the modified date of this template pdf
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNomeFile(String nomeFile) {
		model.setNomeFile(nomeFile);
	}

	/**
	 * Sets the primary key of this template pdf.
	 *
	 * @param primaryKey the primary key of this template pdf
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedura ID of this template pdf.
	 *
	 * @param proceduraId the procedura ID of this template pdf
	 */
	@Override
	public void setProceduraId(long proceduraId) {
		model.setProceduraId(proceduraId);
	}

	/**
	 * Sets the template pdf ID of this template pdf.
	 *
	 * @param templatePdfId the template pdf ID of this template pdf
	 */
	@Override
	public void setTemplatePdfId(long templatePdfId) {
		model.setTemplatePdfId(templatePdfId);
	}

	/**
	 * Sets the template pdf parent ID of this template pdf.
	 *
	 * @param templatePdfParentId the template pdf parent ID of this template pdf
	 */
	@Override
	public void setTemplatePdfParentId(long templatePdfParentId) {
		model.setTemplatePdfParentId(templatePdfParentId);
	}

	/**
	 * Sets the tipo template of this template pdf.
	 *
	 * @param tipoTemplate the tipo template of this template pdf
	 */
	@Override
	public void setTipoTemplate(String tipoTemplate) {
		model.setTipoTemplate(tipoTemplate);
	}

	/**
	 * Sets the tipo template nativo of this template pdf.
	 *
	 * @param tipoTemplateNativo the tipo template nativo of this template pdf
	 */
	@Override
	public void setTipoTemplateNativo(String tipoTemplateNativo) {
		model.setTipoTemplateNativo(tipoTemplateNativo);
	}

	/**
	 * Sets the user ID of this template pdf.
	 *
	 * @param userId the user ID of this template pdf
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this template pdf.
	 *
	 * @param userName the user name of this template pdf
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this template pdf.
	 *
	 * @param userUuid the user uuid of this template pdf
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this template pdf.
	 *
	 * @param uuid the uuid of this template pdf
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
	protected TemplatePdfWrapper wrap(TemplatePdf templatePdf) {
		return new TemplatePdfWrapper(templatePdf);
	}

}