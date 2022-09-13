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
 * This class is a wrapper for {@link Procedura}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Procedura
 * @generated
 */
public class ProceduraWrapper
	extends BaseModelWrapper<Procedura>
	implements ModelWrapper<Procedura>, Procedura {

	public ProceduraWrapper(Procedura procedura) {
		super(procedura);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("proceduraId", getProceduraId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("pecDestinazione", getPecDestinazione());
		attributes.put("step1Attivo", isStep1Attivo());
		attributes.put(
			"step1TipoComponentiNucleoFamiliare",
			getStep1TipoComponentiNucleoFamiliare());
		attributes.put("step2TipoServizio", getStep2TipoServizio());
		attributes.put(
			"step2TipiIntegrazioneBackoffice",
			getStep2TipiIntegrazioneBackoffice());
		attributes.put(
			"abilitaCacheIntegrazioneBackoffice",
			isAbilitaCacheIntegrazioneBackoffice());
		attributes.put("tipoGenerazionePDF", getTipoGenerazionePDF());
		attributes.put("attiva", isAttiva());
		attributes.put("servizioId", getServizioId());
		attributes.put("processoId", getProcessoId());

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

		String pecDestinazione = (String)attributes.get("pecDestinazione");

		if (pecDestinazione != null) {
			setPecDestinazione(pecDestinazione);
		}

		Boolean step1Attivo = (Boolean)attributes.get("step1Attivo");

		if (step1Attivo != null) {
			setStep1Attivo(step1Attivo);
		}

		String step1TipoComponentiNucleoFamiliare = (String)attributes.get(
			"step1TipoComponentiNucleoFamiliare");

		if (step1TipoComponentiNucleoFamiliare != null) {
			setStep1TipoComponentiNucleoFamiliare(
				step1TipoComponentiNucleoFamiliare);
		}

		String step2TipoServizio = (String)attributes.get("step2TipoServizio");

		if (step2TipoServizio != null) {
			setStep2TipoServizio(step2TipoServizio);
		}

		String step2TipiIntegrazioneBackoffice = (String)attributes.get(
			"step2TipiIntegrazioneBackoffice");

		if (step2TipiIntegrazioneBackoffice != null) {
			setStep2TipiIntegrazioneBackoffice(step2TipiIntegrazioneBackoffice);
		}

		Boolean abilitaCacheIntegrazioneBackoffice = (Boolean)attributes.get(
			"abilitaCacheIntegrazioneBackoffice");

		if (abilitaCacheIntegrazioneBackoffice != null) {
			setAbilitaCacheIntegrazioneBackoffice(
				abilitaCacheIntegrazioneBackoffice);
		}

		String tipoGenerazionePDF = (String)attributes.get(
			"tipoGenerazionePDF");

		if (tipoGenerazionePDF != null) {
			setTipoGenerazionePDF(tipoGenerazionePDF);
		}

		Boolean attiva = (Boolean)attributes.get("attiva");

		if (attiva != null) {
			setAttiva(attiva);
		}

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
		}

		Long processoId = (Long)attributes.get("processoId");

		if (processoId != null) {
			setProcessoId(processoId);
		}
	}

	@Override
	public Procedura cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the abilita cache integrazione backoffice of this procedura.
	 *
	 * @return the abilita cache integrazione backoffice of this procedura
	 */
	@Override
	public boolean getAbilitaCacheIntegrazioneBackoffice() {
		return model.getAbilitaCacheIntegrazioneBackoffice();
	}

	/**
	 * Returns the attiva of this procedura.
	 *
	 * @return the attiva of this procedura
	 */
	@Override
	public boolean getAttiva() {
		return model.getAttiva();
	}

	/**
	 * Returns the company ID of this procedura.
	 *
	 * @return the company ID of this procedura
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this procedura.
	 *
	 * @return the create date of this procedura
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this procedura.
	 *
	 * @return the group ID of this procedura
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this procedura.
	 *
	 * @return the modified date of this procedura
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this procedura.
	 *
	 * @return the nome of this procedura
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the pec destinazione of this procedura.
	 *
	 * @return the pec destinazione of this procedura
	 */
	@Override
	public String getPecDestinazione() {
		return model.getPecDestinazione();
	}

	/**
	 * Returns the primary key of this procedura.
	 *
	 * @return the primary key of this procedura
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedura ID of this procedura.
	 *
	 * @return the procedura ID of this procedura
	 */
	@Override
	public long getProceduraId() {
		return model.getProceduraId();
	}

	/**
	 * Returns the processo ID of this procedura.
	 *
	 * @return the processo ID of this procedura
	 */
	@Override
	public long getProcessoId() {
		return model.getProcessoId();
	}

	/**
	 * Returns the servizio ID of this procedura.
	 *
	 * @return the servizio ID of this procedura
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the step1 attivo of this procedura.
	 *
	 * @return the step1 attivo of this procedura
	 */
	@Override
	public boolean getStep1Attivo() {
		return model.getStep1Attivo();
	}

	/**
	 * Returns the step1 tipo componenti nucleo familiare of this procedura.
	 *
	 * @return the step1 tipo componenti nucleo familiare of this procedura
	 */
	@Override
	public String getStep1TipoComponentiNucleoFamiliare() {
		return model.getStep1TipoComponentiNucleoFamiliare();
	}

	/**
	 * Returns the step2 tipi integrazione backoffice of this procedura.
	 *
	 * @return the step2 tipi integrazione backoffice of this procedura
	 */
	@Override
	public String getStep2TipiIntegrazioneBackoffice() {
		return model.getStep2TipiIntegrazioneBackoffice();
	}

	/**
	 * Returns the step2 tipo servizio of this procedura.
	 *
	 * @return the step2 tipo servizio of this procedura
	 */
	@Override
	public String getStep2TipoServizio() {
		return model.getStep2TipoServizio();
	}

	/**
	 * Returns the tipo generazione pdf of this procedura.
	 *
	 * @return the tipo generazione pdf of this procedura
	 */
	@Override
	public String getTipoGenerazionePDF() {
		return model.getTipoGenerazionePDF();
	}

	/**
	 * Returns the user ID of this procedura.
	 *
	 * @return the user ID of this procedura
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this procedura.
	 *
	 * @return the user name of this procedura
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this procedura.
	 *
	 * @return the user uuid of this procedura
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this procedura.
	 *
	 * @return the uuid of this procedura
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this procedura is abilita cache integrazione backoffice.
	 *
	 * @return <code>true</code> if this procedura is abilita cache integrazione backoffice; <code>false</code> otherwise
	 */
	@Override
	public boolean isAbilitaCacheIntegrazioneBackoffice() {
		return model.isAbilitaCacheIntegrazioneBackoffice();
	}

	/**
	 * Returns <code>true</code> if this procedura is attiva.
	 *
	 * @return <code>true</code> if this procedura is attiva; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttiva() {
		return model.isAttiva();
	}

	/**
	 * Returns <code>true</code> if this procedura is step1 attivo.
	 *
	 * @return <code>true</code> if this procedura is step1 attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isStep1Attivo() {
		return model.isStep1Attivo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this procedura is abilita cache integrazione backoffice.
	 *
	 * @param abilitaCacheIntegrazioneBackoffice the abilita cache integrazione backoffice of this procedura
	 */
	@Override
	public void setAbilitaCacheIntegrazioneBackoffice(
		boolean abilitaCacheIntegrazioneBackoffice) {

		model.setAbilitaCacheIntegrazioneBackoffice(
			abilitaCacheIntegrazioneBackoffice);
	}

	/**
	 * Sets whether this procedura is attiva.
	 *
	 * @param attiva the attiva of this procedura
	 */
	@Override
	public void setAttiva(boolean attiva) {
		model.setAttiva(attiva);
	}

	/**
	 * Sets the company ID of this procedura.
	 *
	 * @param companyId the company ID of this procedura
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this procedura.
	 *
	 * @param createDate the create date of this procedura
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this procedura.
	 *
	 * @param groupId the group ID of this procedura
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this procedura.
	 *
	 * @param modifiedDate the modified date of this procedura
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this procedura.
	 *
	 * @param nome the nome of this procedura
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the pec destinazione of this procedura.
	 *
	 * @param pecDestinazione the pec destinazione of this procedura
	 */
	@Override
	public void setPecDestinazione(String pecDestinazione) {
		model.setPecDestinazione(pecDestinazione);
	}

	/**
	 * Sets the primary key of this procedura.
	 *
	 * @param primaryKey the primary key of this procedura
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedura ID of this procedura.
	 *
	 * @param proceduraId the procedura ID of this procedura
	 */
	@Override
	public void setProceduraId(long proceduraId) {
		model.setProceduraId(proceduraId);
	}

	/**
	 * Sets the processo ID of this procedura.
	 *
	 * @param processoId the processo ID of this procedura
	 */
	@Override
	public void setProcessoId(long processoId) {
		model.setProcessoId(processoId);
	}

	/**
	 * Sets the servizio ID of this procedura.
	 *
	 * @param servizioId the servizio ID of this procedura
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets whether this procedura is step1 attivo.
	 *
	 * @param step1Attivo the step1 attivo of this procedura
	 */
	@Override
	public void setStep1Attivo(boolean step1Attivo) {
		model.setStep1Attivo(step1Attivo);
	}

	/**
	 * Sets the step1 tipo componenti nucleo familiare of this procedura.
	 *
	 * @param step1TipoComponentiNucleoFamiliare the step1 tipo componenti nucleo familiare of this procedura
	 */
	@Override
	public void setStep1TipoComponentiNucleoFamiliare(
		String step1TipoComponentiNucleoFamiliare) {

		model.setStep1TipoComponentiNucleoFamiliare(
			step1TipoComponentiNucleoFamiliare);
	}

	/**
	 * Sets the step2 tipi integrazione backoffice of this procedura.
	 *
	 * @param step2TipiIntegrazioneBackoffice the step2 tipi integrazione backoffice of this procedura
	 */
	@Override
	public void setStep2TipiIntegrazioneBackoffice(
		String step2TipiIntegrazioneBackoffice) {

		model.setStep2TipiIntegrazioneBackoffice(
			step2TipiIntegrazioneBackoffice);
	}

	/**
	 * Sets the step2 tipo servizio of this procedura.
	 *
	 * @param step2TipoServizio the step2 tipo servizio of this procedura
	 */
	@Override
	public void setStep2TipoServizio(String step2TipoServizio) {
		model.setStep2TipoServizio(step2TipoServizio);
	}

	/**
	 * Sets the tipo generazione pdf of this procedura.
	 *
	 * @param tipoGenerazionePDF the tipo generazione pdf of this procedura
	 */
	@Override
	public void setTipoGenerazionePDF(String tipoGenerazionePDF) {
		model.setTipoGenerazionePDF(tipoGenerazionePDF);
	}

	/**
	 * Sets the user ID of this procedura.
	 *
	 * @param userId the user ID of this procedura
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this procedura.
	 *
	 * @param userName the user name of this procedura
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this procedura.
	 *
	 * @param userUuid the user uuid of this procedura
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this procedura.
	 *
	 * @param uuid the uuid of this procedura
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
	protected ProceduraWrapper wrap(Procedura procedura) {
		return new ProceduraWrapper(procedura);
	}

}