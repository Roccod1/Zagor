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
 * This class is a wrapper for {@link AreaTematica}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematica
 * @generated
 */
public class AreaTematicaWrapper
	extends BaseModelWrapper<AreaTematica>
	implements AreaTematica, ModelWrapper<AreaTematica> {

	public AreaTematicaWrapper(AreaTematica areaTematica) {
		super(areaTematica);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("areaTematicaId", getAreaTematicaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codice", getCodice());
		attributes.put("sportello", getSportello());
		attributes.put("uriVocabolario", getUriVocabolario());
		attributes.put(
			"denominazioneVocabolario", getDenominazioneVocabolario());
		attributes.put("ordine", getOrdine());
		attributes.put("visibile", isVisibile());
		attributes.put("attiva", isAttiva());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long areaTematicaId = (Long)attributes.get("areaTematicaId");

		if (areaTematicaId != null) {
			setAreaTematicaId(areaTematicaId);
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

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		String sportello = (String)attributes.get("sportello");

		if (sportello != null) {
			setSportello(sportello);
		}

		String uriVocabolario = (String)attributes.get("uriVocabolario");

		if (uriVocabolario != null) {
			setUriVocabolario(uriVocabolario);
		}

		String denominazioneVocabolario = (String)attributes.get(
			"denominazioneVocabolario");

		if (denominazioneVocabolario != null) {
			setDenominazioneVocabolario(denominazioneVocabolario);
		}

		Integer ordine = (Integer)attributes.get("ordine");

		if (ordine != null) {
			setOrdine(ordine);
		}

		Boolean visibile = (Boolean)attributes.get("visibile");

		if (visibile != null) {
			setVisibile(visibile);
		}

		Boolean attiva = (Boolean)attributes.get("attiva");

		if (attiva != null) {
			setAttiva(attiva);
		}
	}

	@Override
	public AreaTematica cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area tematica ID of this area tematica.
	 *
	 * @return the area tematica ID of this area tematica
	 */
	@Override
	public long getAreaTematicaId() {
		return model.getAreaTematicaId();
	}

	/**
	 * Returns the attiva of this area tematica.
	 *
	 * @return the attiva of this area tematica
	 */
	@Override
	public boolean getAttiva() {
		return model.getAttiva();
	}

	/**
	 * Returns the codice of this area tematica.
	 *
	 * @return the codice of this area tematica
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the company ID of this area tematica.
	 *
	 * @return the company ID of this area tematica
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this area tematica.
	 *
	 * @return the create date of this area tematica
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the denominazione vocabolario of this area tematica.
	 *
	 * @return the denominazione vocabolario of this area tematica
	 */
	@Override
	public String getDenominazioneVocabolario() {
		return model.getDenominazioneVocabolario();
	}

	/**
	 * Returns the descrizione of this area tematica.
	 *
	 * @return the descrizione of this area tematica
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the group ID of this area tematica.
	 *
	 * @return the group ID of this area tematica
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this area tematica.
	 *
	 * @return the modified date of this area tematica
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this area tematica.
	 *
	 * @return the nome of this area tematica
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the ordine of this area tematica.
	 *
	 * @return the ordine of this area tematica
	 */
	@Override
	public int getOrdine() {
		return model.getOrdine();
	}

	/**
	 * Returns the primary key of this area tematica.
	 *
	 * @return the primary key of this area tematica
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sportello of this area tematica.
	 *
	 * @return the sportello of this area tematica
	 */
	@Override
	public String getSportello() {
		return model.getSportello();
	}

	/**
	 * Returns the uri vocabolario of this area tematica.
	 *
	 * @return the uri vocabolario of this area tematica
	 */
	@Override
	public String getUriVocabolario() {
		return model.getUriVocabolario();
	}

	/**
	 * Returns the user ID of this area tematica.
	 *
	 * @return the user ID of this area tematica
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this area tematica.
	 *
	 * @return the user name of this area tematica
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this area tematica.
	 *
	 * @return the user uuid of this area tematica
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this area tematica.
	 *
	 * @return the uuid of this area tematica
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visibile of this area tematica.
	 *
	 * @return the visibile of this area tematica
	 */
	@Override
	public boolean getVisibile() {
		return model.getVisibile();
	}

	/**
	 * Returns <code>true</code> if this area tematica is attiva.
	 *
	 * @return <code>true</code> if this area tematica is attiva; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttiva() {
		return model.isAttiva();
	}

	/**
	 * Returns <code>true</code> if this area tematica is visibile.
	 *
	 * @return <code>true</code> if this area tematica is visibile; <code>false</code> otherwise
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
	 * Sets the area tematica ID of this area tematica.
	 *
	 * @param areaTematicaId the area tematica ID of this area tematica
	 */
	@Override
	public void setAreaTematicaId(long areaTematicaId) {
		model.setAreaTematicaId(areaTematicaId);
	}

	/**
	 * Sets whether this area tematica is attiva.
	 *
	 * @param attiva the attiva of this area tematica
	 */
	@Override
	public void setAttiva(boolean attiva) {
		model.setAttiva(attiva);
	}

	/**
	 * Sets the codice of this area tematica.
	 *
	 * @param codice the codice of this area tematica
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the company ID of this area tematica.
	 *
	 * @param companyId the company ID of this area tematica
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this area tematica.
	 *
	 * @param createDate the create date of this area tematica
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the denominazione vocabolario of this area tematica.
	 *
	 * @param denominazioneVocabolario the denominazione vocabolario of this area tematica
	 */
	@Override
	public void setDenominazioneVocabolario(String denominazioneVocabolario) {
		model.setDenominazioneVocabolario(denominazioneVocabolario);
	}

	/**
	 * Sets the descrizione of this area tematica.
	 *
	 * @param descrizione the descrizione of this area tematica
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the group ID of this area tematica.
	 *
	 * @param groupId the group ID of this area tematica
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this area tematica.
	 *
	 * @param modifiedDate the modified date of this area tematica
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this area tematica.
	 *
	 * @param nome the nome of this area tematica
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the ordine of this area tematica.
	 *
	 * @param ordine the ordine of this area tematica
	 */
	@Override
	public void setOrdine(int ordine) {
		model.setOrdine(ordine);
	}

	/**
	 * Sets the primary key of this area tematica.
	 *
	 * @param primaryKey the primary key of this area tematica
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sportello of this area tematica.
	 *
	 * @param sportello the sportello of this area tematica
	 */
	@Override
	public void setSportello(String sportello) {
		model.setSportello(sportello);
	}

	/**
	 * Sets the uri vocabolario of this area tematica.
	 *
	 * @param uriVocabolario the uri vocabolario of this area tematica
	 */
	@Override
	public void setUriVocabolario(String uriVocabolario) {
		model.setUriVocabolario(uriVocabolario);
	}

	/**
	 * Sets the user ID of this area tematica.
	 *
	 * @param userId the user ID of this area tematica
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this area tematica.
	 *
	 * @param userName the user name of this area tematica
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this area tematica.
	 *
	 * @param userUuid the user uuid of this area tematica
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this area tematica.
	 *
	 * @param uuid the uuid of this area tematica
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this area tematica is visibile.
	 *
	 * @param visibile the visibile of this area tematica
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
	protected AreaTematicaWrapper wrap(AreaTematica areaTematica) {
		return new AreaTematicaWrapper(areaTematica);
	}

}