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

package it.servizidigitali.gestioneprocessi.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Processo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Processo
 * @generated
 */
public class ProcessoWrapper
	extends BaseModelWrapper<Processo>
	implements ModelWrapper<Processo>, Processo {

	public ProcessoWrapper(Processo processo) {
		super(processo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("processoId", getProcessoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codice", getCodice());
		attributes.put("nome", getNome());
		attributes.put("stato", getStato());
		attributes.put("deploymentId", getDeploymentId());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long processoId = (Long)attributes.get("processoId");

		if (processoId != null) {
			setProcessoId(processoId);
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

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String deploymentId = (String)attributes.get("deploymentId");

		if (deploymentId != null) {
			setDeploymentId(deploymentId);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public Processo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivo of this processo.
	 *
	 * @return the attivo of this processo
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the codice of this processo.
	 *
	 * @return the codice of this processo
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the company ID of this processo.
	 *
	 * @return the company ID of this processo
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this processo.
	 *
	 * @return the create date of this processo
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deployment ID of this processo.
	 *
	 * @return the deployment ID of this processo
	 */
	@Override
	public String getDeploymentId() {
		return model.getDeploymentId();
	}

	/**
	 * Returns the group ID of this processo.
	 *
	 * @return the group ID of this processo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this processo.
	 *
	 * @return the modified date of this processo
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this processo.
	 *
	 * @return the nome of this processo
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this processo.
	 *
	 * @return the primary key of this processo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the processo ID of this processo.
	 *
	 * @return the processo ID of this processo
	 */
	@Override
	public long getProcessoId() {
		return model.getProcessoId();
	}

	/**
	 * Returns the stato of this processo.
	 *
	 * @return the stato of this processo
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the user ID of this processo.
	 *
	 * @return the user ID of this processo
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this processo.
	 *
	 * @return the user name of this processo
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this processo.
	 *
	 * @return the user uuid of this processo
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this processo.
	 *
	 * @return the uuid of this processo
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this processo is attivo.
	 *
	 * @return <code>true</code> if this processo is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this processo is attivo.
	 *
	 * @param attivo the attivo of this processo
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets the codice of this processo.
	 *
	 * @param codice the codice of this processo
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the company ID of this processo.
	 *
	 * @param companyId the company ID of this processo
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this processo.
	 *
	 * @param createDate the create date of this processo
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deployment ID of this processo.
	 *
	 * @param deploymentId the deployment ID of this processo
	 */
	@Override
	public void setDeploymentId(String deploymentId) {
		model.setDeploymentId(deploymentId);
	}

	/**
	 * Sets the group ID of this processo.
	 *
	 * @param groupId the group ID of this processo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this processo.
	 *
	 * @param modifiedDate the modified date of this processo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this processo.
	 *
	 * @param nome the nome of this processo
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this processo.
	 *
	 * @param primaryKey the primary key of this processo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the processo ID of this processo.
	 *
	 * @param processoId the processo ID of this processo
	 */
	@Override
	public void setProcessoId(long processoId) {
		model.setProcessoId(processoId);
	}

	/**
	 * Sets the stato of this processo.
	 *
	 * @param stato the stato of this processo
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the user ID of this processo.
	 *
	 * @param userId the user ID of this processo
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this processo.
	 *
	 * @param userName the user name of this processo
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this processo.
	 *
	 * @param userUuid the user uuid of this processo
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this processo.
	 *
	 * @param uuid the uuid of this processo
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
	protected ProcessoWrapper wrap(Processo processo) {
		return new ProcessoWrapper(processo);
	}

}