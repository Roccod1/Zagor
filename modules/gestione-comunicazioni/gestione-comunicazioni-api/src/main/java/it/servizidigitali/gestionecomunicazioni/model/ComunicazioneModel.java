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

package it.servizidigitali.gestionecomunicazioni.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Comunicazione service. Represents a row in the &quot;comunicazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Comunicazione
 * @generated
 */
@ProviderType
public interface ComunicazioneModel
	extends BaseModel<Comunicazione>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comunicazione model instance should use the {@link Comunicazione} interface instead.
	 */

	/**
	 * Returns the primary key of this comunicazione.
	 *
	 * @return the primary key of this comunicazione
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this comunicazione.
	 *
	 * @param primaryKey the primary key of this comunicazione
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this comunicazione.
	 *
	 * @return the uuid of this comunicazione
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this comunicazione.
	 *
	 * @param uuid the uuid of this comunicazione
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the comunicazione ID of this comunicazione.
	 *
	 * @return the comunicazione ID of this comunicazione
	 */
	public long getComunicazioneId();

	/**
	 * Sets the comunicazione ID of this comunicazione.
	 *
	 * @param comunicazioneId the comunicazione ID of this comunicazione
	 */
	public void setComunicazioneId(long comunicazioneId);

	/**
	 * Returns the group ID of this comunicazione.
	 *
	 * @return the group ID of this comunicazione
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this comunicazione.
	 *
	 * @param groupId the group ID of this comunicazione
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this comunicazione.
	 *
	 * @return the company ID of this comunicazione
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this comunicazione.
	 *
	 * @param companyId the company ID of this comunicazione
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this comunicazione.
	 *
	 * @return the user ID of this comunicazione
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this comunicazione.
	 *
	 * @param userId the user ID of this comunicazione
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this comunicazione.
	 *
	 * @return the user uuid of this comunicazione
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this comunicazione.
	 *
	 * @param userUuid the user uuid of this comunicazione
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this comunicazione.
	 *
	 * @return the user name of this comunicazione
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this comunicazione.
	 *
	 * @param userName the user name of this comunicazione
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this comunicazione.
	 *
	 * @return the create date of this comunicazione
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this comunicazione.
	 *
	 * @param createDate the create date of this comunicazione
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this comunicazione.
	 *
	 * @return the modified date of this comunicazione
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this comunicazione.
	 *
	 * @param modifiedDate the modified date of this comunicazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the titolo of this comunicazione.
	 *
	 * @return the titolo of this comunicazione
	 */
	@AutoEscape
	public String getTitolo();

	/**
	 * Sets the titolo of this comunicazione.
	 *
	 * @param titolo the titolo of this comunicazione
	 */
	public void setTitolo(String titolo);

	/**
	 * Returns the descrizione of this comunicazione.
	 *
	 * @return the descrizione of this comunicazione
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this comunicazione.
	 *
	 * @param descrizione the descrizione of this comunicazione
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the data invio of this comunicazione.
	 *
	 * @return the data invio of this comunicazione
	 */
	public Date getDataInvio();

	/**
	 * Sets the data invio of this comunicazione.
	 *
	 * @param dataInvio the data invio of this comunicazione
	 */
	public void setDataInvio(Date dataInvio);

	/**
	 * Returns the data inizio of this comunicazione.
	 *
	 * @return the data inizio of this comunicazione
	 */
	public Date getDataInizio();

	/**
	 * Sets the data inizio of this comunicazione.
	 *
	 * @param dataInizio the data inizio of this comunicazione
	 */
	public void setDataInizio(Date dataInizio);

	/**
	 * Returns the data fine of this comunicazione.
	 *
	 * @return the data fine of this comunicazione
	 */
	public Date getDataFine();

	/**
	 * Sets the data fine of this comunicazione.
	 *
	 * @param dataFine the data fine of this comunicazione
	 */
	public void setDataFine(Date dataFine);

	/**
	 * Returns the codice servizio of this comunicazione.
	 *
	 * @return the codice servizio of this comunicazione
	 */
	@AutoEscape
	public String getCodiceServizio();

	/**
	 * Sets the codice servizio of this comunicazione.
	 *
	 * @param codiceServizio the codice servizio of this comunicazione
	 */
	public void setCodiceServizio(String codiceServizio);

	/**
	 * Returns the uri servizio of this comunicazione.
	 *
	 * @return the uri servizio of this comunicazione
	 */
	@AutoEscape
	public String getUriServizio();

	/**
	 * Sets the uri servizio of this comunicazione.
	 *
	 * @param uriServizio the uri servizio of this comunicazione
	 */
	public void setUriServizio(String uriServizio);

	/**
	 * Returns the tipologia comunicazione ID of this comunicazione.
	 *
	 * @return the tipologia comunicazione ID of this comunicazione
	 */
	public long getTipologiaComunicazioneId();

	/**
	 * Sets the tipologia comunicazione ID of this comunicazione.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID of this comunicazione
	 */
	public void setTipologiaComunicazioneId(long tipologiaComunicazioneId);

	/**
	 * Returns the organization ID of this comunicazione.
	 *
	 * @return the organization ID of this comunicazione
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this comunicazione.
	 *
	 * @param organizationId the organization ID of this comunicazione
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the destinatario user ID of this comunicazione.
	 *
	 * @return the destinatario user ID of this comunicazione
	 */
	public Long getDestinatarioUserId();

	/**
	 * Sets the destinatario user ID of this comunicazione.
	 *
	 * @param destinatarioUserId the destinatario user ID of this comunicazione
	 */
	public void setDestinatarioUserId(Long destinatarioUserId);

	/**
	 * Returns the destinatario organization ID of this comunicazione.
	 *
	 * @return the destinatario organization ID of this comunicazione
	 */
	public long getDestinatarioOrganizationId();

	/**
	 * Sets the destinatario organization ID of this comunicazione.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID of this comunicazione
	 */
	public void setDestinatarioOrganizationId(long destinatarioOrganizationId);

	/**
	 * Returns the calendar booking ID of this comunicazione.
	 *
	 * @return the calendar booking ID of this comunicazione
	 */
	public long getCalendarBookingId();

	/**
	 * Sets the calendar booking ID of this comunicazione.
	 *
	 * @param calendarBookingId the calendar booking ID of this comunicazione
	 */
	public void setCalendarBookingId(long calendarBookingId);

	@Override
	public Comunicazione cloneWithOriginalValues();

}