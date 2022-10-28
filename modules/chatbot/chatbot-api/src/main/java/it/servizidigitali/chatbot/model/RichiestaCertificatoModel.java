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

package it.servizidigitali.chatbot.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the RichiestaCertificato service. Represents a row in the &quot;richiesta_certificato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificato
 * @generated
 */
@ProviderType
public interface RichiestaCertificatoModel
	extends BaseModel<RichiestaCertificato>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a richiesta certificato model instance should use the {@link RichiestaCertificato} interface instead.
	 */

	/**
	 * Returns the primary key of this richiesta certificato.
	 *
	 * @return the primary key of this richiesta certificato
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this richiesta certificato.
	 *
	 * @param primaryKey the primary key of this richiesta certificato
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this richiesta certificato.
	 *
	 * @return the uuid of this richiesta certificato
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this richiesta certificato.
	 *
	 * @param uuid the uuid of this richiesta certificato
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the richiesta certificato ID of this richiesta certificato.
	 *
	 * @return the richiesta certificato ID of this richiesta certificato
	 */
	public long getRichiestaCertificatoId();

	/**
	 * Sets the richiesta certificato ID of this richiesta certificato.
	 *
	 * @param richiestaCertificatoId the richiesta certificato ID of this richiesta certificato
	 */
	public void setRichiestaCertificatoId(long richiestaCertificatoId);

	/**
	 * Returns the group ID of this richiesta certificato.
	 *
	 * @return the group ID of this richiesta certificato
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this richiesta certificato.
	 *
	 * @param groupId the group ID of this richiesta certificato
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this richiesta certificato.
	 *
	 * @return the company ID of this richiesta certificato
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this richiesta certificato.
	 *
	 * @param companyId the company ID of this richiesta certificato
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this richiesta certificato.
	 *
	 * @return the user ID of this richiesta certificato
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this richiesta certificato.
	 *
	 * @param userId the user ID of this richiesta certificato
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this richiesta certificato.
	 *
	 * @return the user uuid of this richiesta certificato
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this richiesta certificato.
	 *
	 * @param userUuid the user uuid of this richiesta certificato
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this richiesta certificato.
	 *
	 * @return the user name of this richiesta certificato
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this richiesta certificato.
	 *
	 * @param userName the user name of this richiesta certificato
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this richiesta certificato.
	 *
	 * @return the create date of this richiesta certificato
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this richiesta certificato.
	 *
	 * @param createDate the create date of this richiesta certificato
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this richiesta certificato.
	 *
	 * @return the modified date of this richiesta certificato
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this richiesta certificato.
	 *
	 * @param modifiedDate the modified date of this richiesta certificato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the codice fiscale of this richiesta certificato.
	 *
	 * @return the codice fiscale of this richiesta certificato
	 */
	@AutoEscape
	public String getCodiceFiscale();

	/**
	 * Sets the codice fiscale of this richiesta certificato.
	 *
	 * @param codiceFiscale the codice fiscale of this richiesta certificato
	 */
	public void setCodiceFiscale(String codiceFiscale);

	/**
	 * Returns the stato of this richiesta certificato.
	 *
	 * @return the stato of this richiesta certificato
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this richiesta certificato.
	 *
	 * @param stato the stato of this richiesta certificato
	 */
	public void setStato(String stato);

	/**
	 * Returns the errore of this richiesta certificato.
	 *
	 * @return the errore of this richiesta certificato
	 */
	@AutoEscape
	public String getErrore();

	/**
	 * Sets the errore of this richiesta certificato.
	 *
	 * @param errore the errore of this richiesta certificato
	 */
	public void setErrore(String errore);

	/**
	 * Returns the servizio ID of this richiesta certificato.
	 *
	 * @return the servizio ID of this richiesta certificato
	 */
	public long getServizioId();

	/**
	 * Sets the servizio ID of this richiesta certificato.
	 *
	 * @param servizioId the servizio ID of this richiesta certificato
	 */
	public void setServizioId(long servizioId);

	/**
	 * Returns the destinazione uso ID of this richiesta certificato.
	 *
	 * @return the destinazione uso ID of this richiesta certificato
	 */
	public long getDestinazioneUsoId();

	/**
	 * Sets the destinazione uso ID of this richiesta certificato.
	 *
	 * @param destinazioneUsoId the destinazione uso ID of this richiesta certificato
	 */
	public void setDestinazioneUsoId(long destinazioneUsoId);

	/**
	 * Returns the richiesta ID of this richiesta certificato.
	 *
	 * @return the richiesta ID of this richiesta certificato
	 */
	public long getRichiestaId();

	/**
	 * Sets the richiesta ID of this richiesta certificato.
	 *
	 * @param richiestaId the richiesta ID of this richiesta certificato
	 */
	public void setRichiestaId(long richiestaId);

	@Override
	public RichiestaCertificato cloneWithOriginalValues();

}