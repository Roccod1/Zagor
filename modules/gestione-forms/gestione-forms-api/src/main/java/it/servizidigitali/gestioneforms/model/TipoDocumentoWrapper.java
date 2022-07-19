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

package it.servizidigitali.gestioneforms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TipoDocumento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumento
 * @generated
 */
public class TipoDocumentoWrapper
	extends BaseModelWrapper<TipoDocumento>
	implements ModelWrapper<TipoDocumento>, TipoDocumento {

	public TipoDocumentoWrapper(TipoDocumento tipoDocumento) {
		super(tipoDocumento);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tipoDocumentoId", getTipoDocumentoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codice", getCodice());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("categoria", getCategoria());
		attributes.put("estensioniFile", getEstensioniFile());
		attributes.put("stato", getStato());
		attributes.put("numeroRequired", getNumeroRequired());
		attributes.put("dataScadenzaRequired", getDataScadenzaRequired());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tipoDocumentoId = (Long)attributes.get("tipoDocumentoId");

		if (tipoDocumentoId != null) {
			setTipoDocumentoId(tipoDocumentoId);
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

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String categoria = (String)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}

		String estensioniFile = (String)attributes.get("estensioniFile");

		if (estensioniFile != null) {
			setEstensioniFile(estensioniFile);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Long numeroRequired = (Long)attributes.get("numeroRequired");

		if (numeroRequired != null) {
			setNumeroRequired(numeroRequired);
		}

		Long dataScadenzaRequired = (Long)attributes.get(
			"dataScadenzaRequired");

		if (dataScadenzaRequired != null) {
			setDataScadenzaRequired(dataScadenzaRequired);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	@Override
	public TipoDocumento cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the categoria of this tipo documento.
	 *
	 * @return the categoria of this tipo documento
	 */
	@Override
	public String getCategoria() {
		return model.getCategoria();
	}

	/**
	 * Returns the codice of this tipo documento.
	 *
	 * @return the codice of this tipo documento
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the company ID of this tipo documento.
	 *
	 * @return the company ID of this tipo documento
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this tipo documento.
	 *
	 * @return the create date of this tipo documento
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data scadenza required of this tipo documento.
	 *
	 * @return the data scadenza required of this tipo documento
	 */
	@Override
	public long getDataScadenzaRequired() {
		return model.getDataScadenzaRequired();
	}

	/**
	 * Returns the descrizione of this tipo documento.
	 *
	 * @return the descrizione of this tipo documento
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the estensioni file of this tipo documento.
	 *
	 * @return the estensioni file of this tipo documento
	 */
	@Override
	public String getEstensioniFile() {
		return model.getEstensioniFile();
	}

	/**
	 * Returns the group ID of this tipo documento.
	 *
	 * @return the group ID of this tipo documento
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this tipo documento.
	 *
	 * @return the modified date of this tipo documento
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this tipo documento.
	 *
	 * @return the nome of this tipo documento
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the numero required of this tipo documento.
	 *
	 * @return the numero required of this tipo documento
	 */
	@Override
	public long getNumeroRequired() {
		return model.getNumeroRequired();
	}

	/**
	 * Returns the organization ID of this tipo documento.
	 *
	 * @return the organization ID of this tipo documento
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this tipo documento.
	 *
	 * @return the primary key of this tipo documento
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato of this tipo documento.
	 *
	 * @return the stato of this tipo documento
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the tipo documento ID of this tipo documento.
	 *
	 * @return the tipo documento ID of this tipo documento
	 */
	@Override
	public long getTipoDocumentoId() {
		return model.getTipoDocumentoId();
	}

	/**
	 * Returns the user ID of this tipo documento.
	 *
	 * @return the user ID of this tipo documento
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this tipo documento.
	 *
	 * @return the user name of this tipo documento
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this tipo documento.
	 *
	 * @return the user uuid of this tipo documento
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this tipo documento.
	 *
	 * @return the uuid of this tipo documento
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
	 * Sets the categoria of this tipo documento.
	 *
	 * @param categoria the categoria of this tipo documento
	 */
	@Override
	public void setCategoria(String categoria) {
		model.setCategoria(categoria);
	}

	/**
	 * Sets the codice of this tipo documento.
	 *
	 * @param codice the codice of this tipo documento
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the company ID of this tipo documento.
	 *
	 * @param companyId the company ID of this tipo documento
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tipo documento.
	 *
	 * @param createDate the create date of this tipo documento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data scadenza required of this tipo documento.
	 *
	 * @param dataScadenzaRequired the data scadenza required of this tipo documento
	 */
	@Override
	public void setDataScadenzaRequired(long dataScadenzaRequired) {
		model.setDataScadenzaRequired(dataScadenzaRequired);
	}

	/**
	 * Sets the descrizione of this tipo documento.
	 *
	 * @param descrizione the descrizione of this tipo documento
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the estensioni file of this tipo documento.
	 *
	 * @param estensioniFile the estensioni file of this tipo documento
	 */
	@Override
	public void setEstensioniFile(String estensioniFile) {
		model.setEstensioniFile(estensioniFile);
	}

	/**
	 * Sets the group ID of this tipo documento.
	 *
	 * @param groupId the group ID of this tipo documento
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this tipo documento.
	 *
	 * @param modifiedDate the modified date of this tipo documento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this tipo documento.
	 *
	 * @param nome the nome of this tipo documento
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the numero required of this tipo documento.
	 *
	 * @param numeroRequired the numero required of this tipo documento
	 */
	@Override
	public void setNumeroRequired(long numeroRequired) {
		model.setNumeroRequired(numeroRequired);
	}

	/**
	 * Sets the organization ID of this tipo documento.
	 *
	 * @param organizationId the organization ID of this tipo documento
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this tipo documento.
	 *
	 * @param primaryKey the primary key of this tipo documento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato of this tipo documento.
	 *
	 * @param stato the stato of this tipo documento
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the tipo documento ID of this tipo documento.
	 *
	 * @param tipoDocumentoId the tipo documento ID of this tipo documento
	 */
	@Override
	public void setTipoDocumentoId(long tipoDocumentoId) {
		model.setTipoDocumentoId(tipoDocumentoId);
	}

	/**
	 * Sets the user ID of this tipo documento.
	 *
	 * @param userId the user ID of this tipo documento
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this tipo documento.
	 *
	 * @param userName the user name of this tipo documento
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tipo documento.
	 *
	 * @param userUuid the user uuid of this tipo documento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this tipo documento.
	 *
	 * @param uuid the uuid of this tipo documento
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
	protected TipoDocumentoWrapper wrap(TipoDocumento tipoDocumento) {
		return new TipoDocumentoWrapper(tipoDocumento);
	}

}