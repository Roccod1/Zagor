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

package it.servizidigitali.gestioneservizi.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tipologia}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tipologia
 * @generated
 */
public class TipologiaWrapper
	extends BaseModelWrapper<Tipologia>
	implements ModelWrapper<Tipologia>, Tipologia {

	public TipologiaWrapper(Tipologia tipologia) {
		super(tipologia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tipologiaId", getTipologiaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("visibile", isVisibile());
		attributes.put("invioEmailCittadino", isInvioEmailCittadino());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tipologiaId = (Long)attributes.get("tipologiaId");

		if (tipologiaId != null) {
			setTipologiaId(tipologiaId);
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

		Boolean visibile = (Boolean)attributes.get("visibile");

		if (visibile != null) {
			setVisibile(visibile);
		}

		Boolean invioEmailCittadino = (Boolean)attributes.get(
			"invioEmailCittadino");

		if (invioEmailCittadino != null) {
			setInvioEmailCittadino(invioEmailCittadino);
		}
	}

	@Override
	public Tipologia cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this tipologia.
	 *
	 * @return the company ID of this tipologia
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this tipologia.
	 *
	 * @return the create date of this tipologia
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the descrizione of this tipologia.
	 *
	 * @return the descrizione of this tipologia
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the group ID of this tipologia.
	 *
	 * @return the group ID of this tipologia
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the invio email cittadino of this tipologia.
	 *
	 * @return the invio email cittadino of this tipologia
	 */
	@Override
	public boolean getInvioEmailCittadino() {
		return model.getInvioEmailCittadino();
	}

	/**
	 * Returns the modified date of this tipologia.
	 *
	 * @return the modified date of this tipologia
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this tipologia.
	 *
	 * @return the nome of this tipologia
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this tipologia.
	 *
	 * @return the primary key of this tipologia
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipologia ID of this tipologia.
	 *
	 * @return the tipologia ID of this tipologia
	 */
	@Override
	public long getTipologiaId() {
		return model.getTipologiaId();
	}

	/**
	 * Returns the user ID of this tipologia.
	 *
	 * @return the user ID of this tipologia
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this tipologia.
	 *
	 * @return the user name of this tipologia
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this tipologia.
	 *
	 * @return the user uuid of this tipologia
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this tipologia.
	 *
	 * @return the uuid of this tipologia
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visibile of this tipologia.
	 *
	 * @return the visibile of this tipologia
	 */
	@Override
	public boolean getVisibile() {
		return model.getVisibile();
	}

	/**
	 * Returns <code>true</code> if this tipologia is invio email cittadino.
	 *
	 * @return <code>true</code> if this tipologia is invio email cittadino; <code>false</code> otherwise
	 */
	@Override
	public boolean isInvioEmailCittadino() {
		return model.isInvioEmailCittadino();
	}

	/**
	 * Returns <code>true</code> if this tipologia is visibile.
	 *
	 * @return <code>true</code> if this tipologia is visibile; <code>false</code> otherwise
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
	 * Sets the company ID of this tipologia.
	 *
	 * @param companyId the company ID of this tipologia
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tipologia.
	 *
	 * @param createDate the create date of this tipologia
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the descrizione of this tipologia.
	 *
	 * @param descrizione the descrizione of this tipologia
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the group ID of this tipologia.
	 *
	 * @param groupId the group ID of this tipologia
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this tipologia is invio email cittadino.
	 *
	 * @param invioEmailCittadino the invio email cittadino of this tipologia
	 */
	@Override
	public void setInvioEmailCittadino(boolean invioEmailCittadino) {
		model.setInvioEmailCittadino(invioEmailCittadino);
	}

	/**
	 * Sets the modified date of this tipologia.
	 *
	 * @param modifiedDate the modified date of this tipologia
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this tipologia.
	 *
	 * @param nome the nome of this tipologia
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this tipologia.
	 *
	 * @param primaryKey the primary key of this tipologia
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipologia ID of this tipologia.
	 *
	 * @param tipologiaId the tipologia ID of this tipologia
	 */
	@Override
	public void setTipologiaId(long tipologiaId) {
		model.setTipologiaId(tipologiaId);
	}

	/**
	 * Sets the user ID of this tipologia.
	 *
	 * @param userId the user ID of this tipologia
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this tipologia.
	 *
	 * @param userName the user name of this tipologia
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tipologia.
	 *
	 * @param userUuid the user uuid of this tipologia
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this tipologia.
	 *
	 * @param uuid the uuid of this tipologia
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this tipologia is visibile.
	 *
	 * @param visibile the visibile of this tipologia
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
	protected TipologiaWrapper wrap(Tipologia tipologia) {
		return new TipologiaWrapper(tipologia);
	}

}