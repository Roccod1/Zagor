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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TipoDocumento service. Represents a row in the &quot;tipo_documento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneforms.model.impl.TipoDocumentoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoDocumento
 * @generated
 */
@ProviderType
public interface TipoDocumentoModel
	extends BaseModel<TipoDocumento>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tipo documento model instance should use the {@link TipoDocumento} interface instead.
	 */

	/**
	 * Returns the primary key of this tipo documento.
	 *
	 * @return the primary key of this tipo documento
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tipo documento.
	 *
	 * @param primaryKey the primary key of this tipo documento
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this tipo documento.
	 *
	 * @return the uuid of this tipo documento
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this tipo documento.
	 *
	 * @param uuid the uuid of this tipo documento
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the tipo documento ID of this tipo documento.
	 *
	 * @return the tipo documento ID of this tipo documento
	 */
	public long getTipoDocumentoId();

	/**
	 * Sets the tipo documento ID of this tipo documento.
	 *
	 * @param tipoDocumentoId the tipo documento ID of this tipo documento
	 */
	public void setTipoDocumentoId(long tipoDocumentoId);

	/**
	 * Returns the group ID of this tipo documento.
	 *
	 * @return the group ID of this tipo documento
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tipo documento.
	 *
	 * @param groupId the group ID of this tipo documento
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tipo documento.
	 *
	 * @return the company ID of this tipo documento
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tipo documento.
	 *
	 * @param companyId the company ID of this tipo documento
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tipo documento.
	 *
	 * @return the user ID of this tipo documento
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tipo documento.
	 *
	 * @param userId the user ID of this tipo documento
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tipo documento.
	 *
	 * @return the user uuid of this tipo documento
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this tipo documento.
	 *
	 * @param userUuid the user uuid of this tipo documento
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tipo documento.
	 *
	 * @return the user name of this tipo documento
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tipo documento.
	 *
	 * @param userName the user name of this tipo documento
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tipo documento.
	 *
	 * @return the create date of this tipo documento
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tipo documento.
	 *
	 * @param createDate the create date of this tipo documento
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tipo documento.
	 *
	 * @return the modified date of this tipo documento
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tipo documento.
	 *
	 * @param modifiedDate the modified date of this tipo documento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the codice of this tipo documento.
	 *
	 * @return the codice of this tipo documento
	 */
	@AutoEscape
	public String getCodice();

	/**
	 * Sets the codice of this tipo documento.
	 *
	 * @param codice the codice of this tipo documento
	 */
	public void setCodice(String codice);

	/**
	 * Returns the nome of this tipo documento.
	 *
	 * @return the nome of this tipo documento
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this tipo documento.
	 *
	 * @param nome the nome of this tipo documento
	 */
	public void setNome(String nome);

	/**
	 * Returns the descrizione of this tipo documento.
	 *
	 * @return the descrizione of this tipo documento
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this tipo documento.
	 *
	 * @param descrizione the descrizione of this tipo documento
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the categoria of this tipo documento.
	 *
	 * @return the categoria of this tipo documento
	 */
	@AutoEscape
	public String getCategoria();

	/**
	 * Sets the categoria of this tipo documento.
	 *
	 * @param categoria the categoria of this tipo documento
	 */
	public void setCategoria(String categoria);

	/**
	 * Returns the estensioni file of this tipo documento.
	 *
	 * @return the estensioni file of this tipo documento
	 */
	@AutoEscape
	public String getEstensioniFile();

	/**
	 * Sets the estensioni file of this tipo documento.
	 *
	 * @param estensioniFile the estensioni file of this tipo documento
	 */
	public void setEstensioniFile(String estensioniFile);

	/**
	 * Returns the stato of this tipo documento.
	 *
	 * @return the stato of this tipo documento
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this tipo documento.
	 *
	 * @param stato the stato of this tipo documento
	 */
	public void setStato(String stato);

	/**
	 * Returns the numero required of this tipo documento.
	 *
	 * @return the numero required of this tipo documento
	 */
	public long getNumeroRequired();

	/**
	 * Sets the numero required of this tipo documento.
	 *
	 * @param numeroRequired the numero required of this tipo documento
	 */
	public void setNumeroRequired(long numeroRequired);

	/**
	 * Returns the data scadenza required of this tipo documento.
	 *
	 * @return the data scadenza required of this tipo documento
	 */
	public long getDataScadenzaRequired();

	/**
	 * Sets the data scadenza required of this tipo documento.
	 *
	 * @param dataScadenzaRequired the data scadenza required of this tipo documento
	 */
	public void setDataScadenzaRequired(long dataScadenzaRequired);

	/**
	 * Returns the organization ID of this tipo documento.
	 *
	 * @return the organization ID of this tipo documento
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this tipo documento.
	 *
	 * @param organizationId the organization ID of this tipo documento
	 */
	public void setOrganizationId(long organizationId);

	@Override
	public TipoDocumento cloneWithOriginalValues();

}