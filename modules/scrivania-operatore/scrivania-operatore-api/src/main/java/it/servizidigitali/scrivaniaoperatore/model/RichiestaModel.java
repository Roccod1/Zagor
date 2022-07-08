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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Richiesta service. Represents a row in the &quot;richiesta&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Richiesta
 * @generated
 */
@ProviderType
public interface RichiestaModel
	extends BaseModel<Richiesta>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a richiesta model instance should use the {@link Richiesta} interface instead.
	 */

	/**
	 * Returns the primary key of this richiesta.
	 *
	 * @return the primary key of this richiesta
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this richiesta.
	 *
	 * @param primaryKey the primary key of this richiesta
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this richiesta.
	 *
	 * @return the uuid of this richiesta
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this richiesta.
	 *
	 * @param uuid the uuid of this richiesta
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the richiesta ID of this richiesta.
	 *
	 * @return the richiesta ID of this richiesta
	 */
	public long getRichiestaId();

	/**
	 * Sets the richiesta ID of this richiesta.
	 *
	 * @param richiestaId the richiesta ID of this richiesta
	 */
	public void setRichiestaId(long richiestaId);

	/**
	 * Returns the group ID of this richiesta.
	 *
	 * @return the group ID of this richiesta
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this richiesta.
	 *
	 * @param groupId the group ID of this richiesta
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this richiesta.
	 *
	 * @return the company ID of this richiesta
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this richiesta.
	 *
	 * @param companyId the company ID of this richiesta
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this richiesta.
	 *
	 * @return the user ID of this richiesta
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this richiesta.
	 *
	 * @param userId the user ID of this richiesta
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this richiesta.
	 *
	 * @return the user uuid of this richiesta
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this richiesta.
	 *
	 * @param userUuid the user uuid of this richiesta
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this richiesta.
	 *
	 * @return the user name of this richiesta
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this richiesta.
	 *
	 * @param userName the user name of this richiesta
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this richiesta.
	 *
	 * @return the create date of this richiesta
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this richiesta.
	 *
	 * @param createDate the create date of this richiesta
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this richiesta.
	 *
	 * @return the modified date of this richiesta
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this richiesta.
	 *
	 * @param modifiedDate the modified date of this richiesta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the codice fiscale of this richiesta.
	 *
	 * @return the codice fiscale of this richiesta
	 */
	@AutoEscape
	public String getCodiceFiscale();

	/**
	 * Sets the codice fiscale of this richiesta.
	 *
	 * @param codiceFiscale the codice fiscale of this richiesta
	 */
	public void setCodiceFiscale(String codiceFiscale);

	/**
	 * Returns the partita iva of this richiesta.
	 *
	 * @return the partita iva of this richiesta
	 */
	@AutoEscape
	public String getPartitaIva();

	/**
	 * Sets the partita iva of this richiesta.
	 *
	 * @param partitaIva the partita iva of this richiesta
	 */
	public void setPartitaIva(String partitaIva);

	/**
	 * Returns the email of this richiesta.
	 *
	 * @return the email of this richiesta
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this richiesta.
	 *
	 * @param email the email of this richiesta
	 */
	public void setEmail(String email);

	/**
	 * Returns the codice fiscale delegato of this richiesta.
	 *
	 * @return the codice fiscale delegato of this richiesta
	 */
	@AutoEscape
	public String getCodiceFiscaleDelegato();

	/**
	 * Sets the codice fiscale delegato of this richiesta.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato of this richiesta
	 */
	public void setCodiceFiscaleDelegato(String codiceFiscaleDelegato);

	/**
	 * Returns the stato of this richiesta.
	 *
	 * @return the stato of this richiesta
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this richiesta.
	 *
	 * @param stato the stato of this richiesta
	 */
	public void setStato(String stato);

	/**
	 * Returns the numero protocollo of this richiesta.
	 *
	 * @return the numero protocollo of this richiesta
	 */
	@AutoEscape
	public String getNumeroProtocollo();

	/**
	 * Sets the numero protocollo of this richiesta.
	 *
	 * @param numeroProtocollo the numero protocollo of this richiesta
	 */
	public void setNumeroProtocollo(String numeroProtocollo);

	/**
	 * Returns the data protocollo of this richiesta.
	 *
	 * @return the data protocollo of this richiesta
	 */
	public Date getDataProtocollo();

	/**
	 * Sets the data protocollo of this richiesta.
	 *
	 * @param dataProtocollo the data protocollo of this richiesta
	 */
	public void setDataProtocollo(Date dataProtocollo);

	/**
	 * Returns the oggetto of this richiesta.
	 *
	 * @return the oggetto of this richiesta
	 */
	@AutoEscape
	public String getOggetto();

	/**
	 * Sets the oggetto of this richiesta.
	 *
	 * @param oggetto the oggetto of this richiesta
	 */
	public void setOggetto(String oggetto);

	/**
	 * Returns the note of this richiesta.
	 *
	 * @return the note of this richiesta
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this richiesta.
	 *
	 * @param note the note of this richiesta
	 */
	public void setNote(String note);

	/**
	 * Returns the invio guest of this richiesta.
	 *
	 * @return the invio guest of this richiesta
	 */
	public boolean getInvioGuest();

	/**
	 * Returns <code>true</code> if this richiesta is invio guest.
	 *
	 * @return <code>true</code> if this richiesta is invio guest; <code>false</code> otherwise
	 */
	public boolean isInvioGuest();

	/**
	 * Sets whether this richiesta is invio guest.
	 *
	 * @param invioGuest the invio guest of this richiesta
	 */
	public void setInvioGuest(boolean invioGuest);

	/**
	 * Returns the token visualizzazione of this richiesta.
	 *
	 * @return the token visualizzazione of this richiesta
	 */
	@AutoEscape
	public String getTokenVisualizzazione();

	/**
	 * Sets the token visualizzazione of this richiesta.
	 *
	 * @param tokenVisualizzazione the token visualizzazione of this richiesta
	 */
	public void setTokenVisualizzazione(String tokenVisualizzazione);

	/**
	 * Returns the chiave associazione backoffice of this richiesta.
	 *
	 * @return the chiave associazione backoffice of this richiesta
	 */
	@AutoEscape
	public String getChiaveAssociazioneBackoffice();

	/**
	 * Sets the chiave associazione backoffice of this richiesta.
	 *
	 * @param chiaveAssociazioneBackoffice the chiave associazione backoffice of this richiesta
	 */
	public void setChiaveAssociazioneBackoffice(
		String chiaveAssociazioneBackoffice);

	/**
	 * Returns the delega ID of this richiesta.
	 *
	 * @return the delega ID of this richiesta
	 */
	public Long getDelegaId();

	/**
	 * Sets the delega ID of this richiesta.
	 *
	 * @param delegaId the delega ID of this richiesta
	 */
	public void setDelegaId(Long delegaId);

	/**
	 * Returns the procedura ID of this richiesta.
	 *
	 * @return the procedura ID of this richiesta
	 */
	public long getProceduraId();

	/**
	 * Sets the procedura ID of this richiesta.
	 *
	 * @param proceduraId the procedura ID of this richiesta
	 */
	public void setProceduraId(long proceduraId);

	@Override
	public Richiesta cloneWithOriginalValues();

}