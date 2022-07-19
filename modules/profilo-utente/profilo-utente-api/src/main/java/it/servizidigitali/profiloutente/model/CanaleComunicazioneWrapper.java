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

package it.servizidigitali.profiloutente.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CanaleComunicazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanaleComunicazione
 * @generated
 */
public class CanaleComunicazioneWrapper
	extends BaseModelWrapper<CanaleComunicazione>
	implements CanaleComunicazione, ModelWrapper<CanaleComunicazione> {

	public CanaleComunicazioneWrapper(CanaleComunicazione canaleComunicazione) {
		super(canaleComunicazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("canaleComunicazioneId", getCanaleComunicazioneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("nome", getNome());
		attributes.put("codice", getCodice());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long canaleComunicazioneId = (Long)attributes.get(
			"canaleComunicazioneId");

		if (canaleComunicazioneId != null) {
			setCanaleComunicazioneId(canaleComunicazioneId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public CanaleComunicazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivo of this canale comunicazione.
	 *
	 * @return the attivo of this canale comunicazione
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the canale comunicazione ID of this canale comunicazione.
	 *
	 * @return the canale comunicazione ID of this canale comunicazione
	 */
	@Override
	public long getCanaleComunicazioneId() {
		return model.getCanaleComunicazioneId();
	}

	/**
	 * Returns the codice of this canale comunicazione.
	 *
	 * @return the codice of this canale comunicazione
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the company ID of this canale comunicazione.
	 *
	 * @return the company ID of this canale comunicazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this canale comunicazione.
	 *
	 * @return the group ID of this canale comunicazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the nome of this canale comunicazione.
	 *
	 * @return the nome of this canale comunicazione
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this canale comunicazione.
	 *
	 * @return the primary key of this canale comunicazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this canale comunicazione is attivo.
	 *
	 * @return <code>true</code> if this canale comunicazione is attivo; <code>false</code> otherwise
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
	 * Sets whether this canale comunicazione is attivo.
	 *
	 * @param attivo the attivo of this canale comunicazione
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets the canale comunicazione ID of this canale comunicazione.
	 *
	 * @param canaleComunicazioneId the canale comunicazione ID of this canale comunicazione
	 */
	@Override
	public void setCanaleComunicazioneId(long canaleComunicazioneId) {
		model.setCanaleComunicazioneId(canaleComunicazioneId);
	}

	/**
	 * Sets the codice of this canale comunicazione.
	 *
	 * @param codice the codice of this canale comunicazione
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the company ID of this canale comunicazione.
	 *
	 * @param companyId the company ID of this canale comunicazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this canale comunicazione.
	 *
	 * @param groupId the group ID of this canale comunicazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the nome of this canale comunicazione.
	 *
	 * @param nome the nome of this canale comunicazione
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this canale comunicazione.
	 *
	 * @param primaryKey the primary key of this canale comunicazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CanaleComunicazioneWrapper wrap(
		CanaleComunicazione canaleComunicazione) {

		return new CanaleComunicazioneWrapper(canaleComunicazione);
	}

}