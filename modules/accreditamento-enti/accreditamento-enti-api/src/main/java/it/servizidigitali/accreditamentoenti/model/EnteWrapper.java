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
 * This class is a wrapper for {@link Ente}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ente
 * @generated
 */
public class EnteWrapper
	extends BaseModelWrapper<Ente> implements Ente, ModelWrapper<Ente> {

	public EnteWrapper(Ente ente) {
		super(ente);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enteId", getEnteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("denominazione", getDenominazione());
		attributes.put("strutturaRiferimento", getStrutturaRiferimento());
		attributes.put("sitoWeb", getSitoWeb());
		attributes.put("tipo", getTipo());
		attributes.put("codiceIPA", getCodiceIPA());
		attributes.put("pec", getPec());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long enteId = (Long)attributes.get("enteId");

		if (enteId != null) {
			setEnteId(enteId);
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

		String denominazione = (String)attributes.get("denominazione");

		if (denominazione != null) {
			setDenominazione(denominazione);
		}

		String strutturaRiferimento = (String)attributes.get(
			"strutturaRiferimento");

		if (strutturaRiferimento != null) {
			setStrutturaRiferimento(strutturaRiferimento);
		}

		String sitoWeb = (String)attributes.get("sitoWeb");

		if (sitoWeb != null) {
			setSitoWeb(sitoWeb);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String codiceIPA = (String)attributes.get("codiceIPA");

		if (codiceIPA != null) {
			setCodiceIPA(codiceIPA);
		}

		String pec = (String)attributes.get("pec");

		if (pec != null) {
			setPec(pec);
		}
	}

	@Override
	public Ente cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice ipa of this ente.
	 *
	 * @return the codice ipa of this ente
	 */
	@Override
	public String getCodiceIPA() {
		return model.getCodiceIPA();
	}

	/**
	 * Returns the company ID of this ente.
	 *
	 * @return the company ID of this ente
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ente.
	 *
	 * @return the create date of this ente
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the denominazione of this ente.
	 *
	 * @return the denominazione of this ente
	 */
	@Override
	public String getDenominazione() {
		return model.getDenominazione();
	}

	/**
	 * Returns the ente ID of this ente.
	 *
	 * @return the ente ID of this ente
	 */
	@Override
	public long getEnteId() {
		return model.getEnteId();
	}

	/**
	 * Returns the group ID of this ente.
	 *
	 * @return the group ID of this ente
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ente.
	 *
	 * @return the modified date of this ente
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pec of this ente.
	 *
	 * @return the pec of this ente
	 */
	@Override
	public String getPec() {
		return model.getPec();
	}

	/**
	 * Returns the primary key of this ente.
	 *
	 * @return the primary key of this ente
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sito web of this ente.
	 *
	 * @return the sito web of this ente
	 */
	@Override
	public String getSitoWeb() {
		return model.getSitoWeb();
	}

	/**
	 * Returns the struttura riferimento of this ente.
	 *
	 * @return the struttura riferimento of this ente
	 */
	@Override
	public String getStrutturaRiferimento() {
		return model.getStrutturaRiferimento();
	}

	/**
	 * Returns the tipo of this ente.
	 *
	 * @return the tipo of this ente
	 */
	@Override
	public String getTipo() {
		return model.getTipo();
	}

	/**
	 * Returns the user ID of this ente.
	 *
	 * @return the user ID of this ente
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ente.
	 *
	 * @return the user name of this ente
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ente.
	 *
	 * @return the user uuid of this ente
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ente.
	 *
	 * @return the uuid of this ente
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
	 * Sets the codice ipa of this ente.
	 *
	 * @param codiceIPA the codice ipa of this ente
	 */
	@Override
	public void setCodiceIPA(String codiceIPA) {
		model.setCodiceIPA(codiceIPA);
	}

	/**
	 * Sets the company ID of this ente.
	 *
	 * @param companyId the company ID of this ente
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ente.
	 *
	 * @param createDate the create date of this ente
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the denominazione of this ente.
	 *
	 * @param denominazione the denominazione of this ente
	 */
	@Override
	public void setDenominazione(String denominazione) {
		model.setDenominazione(denominazione);
	}

	/**
	 * Sets the ente ID of this ente.
	 *
	 * @param enteId the ente ID of this ente
	 */
	@Override
	public void setEnteId(long enteId) {
		model.setEnteId(enteId);
	}

	/**
	 * Sets the group ID of this ente.
	 *
	 * @param groupId the group ID of this ente
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ente.
	 *
	 * @param modifiedDate the modified date of this ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pec of this ente.
	 *
	 * @param pec the pec of this ente
	 */
	@Override
	public void setPec(String pec) {
		model.setPec(pec);
	}

	/**
	 * Sets the primary key of this ente.
	 *
	 * @param primaryKey the primary key of this ente
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sito web of this ente.
	 *
	 * @param sitoWeb the sito web of this ente
	 */
	@Override
	public void setSitoWeb(String sitoWeb) {
		model.setSitoWeb(sitoWeb);
	}

	/**
	 * Sets the struttura riferimento of this ente.
	 *
	 * @param strutturaRiferimento the struttura riferimento of this ente
	 */
	@Override
	public void setStrutturaRiferimento(String strutturaRiferimento) {
		model.setStrutturaRiferimento(strutturaRiferimento);
	}

	/**
	 * Sets the tipo of this ente.
	 *
	 * @param tipo the tipo of this ente
	 */
	@Override
	public void setTipo(String tipo) {
		model.setTipo(tipo);
	}

	/**
	 * Sets the user ID of this ente.
	 *
	 * @param userId the user ID of this ente
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ente.
	 *
	 * @param userName the user name of this ente
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ente.
	 *
	 * @param userUuid the user uuid of this ente
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ente.
	 *
	 * @param uuid the uuid of this ente
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
	protected EnteWrapper wrap(Ente ente) {
		return new EnteWrapper(ente);
	}

}