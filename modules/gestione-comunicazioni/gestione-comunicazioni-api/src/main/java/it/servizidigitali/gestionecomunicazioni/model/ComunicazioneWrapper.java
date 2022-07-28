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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Comunicazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Comunicazione
 * @generated
 */
public class ComunicazioneWrapper
	extends BaseModelWrapper<Comunicazione>
	implements Comunicazione, ModelWrapper<Comunicazione> {

	public ComunicazioneWrapper(Comunicazione comunicazione) {
		super(comunicazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("comunicazioneId", getComunicazioneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("titolo", getTitolo());
		attributes.put("descrizione", getDescrizione());
		attributes.put("dataInvio", getDataInvio());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("codiceServizio", getCodiceServizio());
		attributes.put("uriServizio", getUriServizio());
		attributes.put(
			"tipologiaComunicazioneId", getTipologiaComunicazioneId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("destinatarioUserId", getDestinatarioUserId());
		attributes.put(
			"destinatarioOrganizationId", getDestinatarioOrganizationId());
		attributes.put("calendarBookingId", getCalendarBookingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long comunicazioneId = (Long)attributes.get("comunicazioneId");

		if (comunicazioneId != null) {
			setComunicazioneId(comunicazioneId);
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

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		Date dataInvio = (Date)attributes.get("dataInvio");

		if (dataInvio != null) {
			setDataInvio(dataInvio);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		String codiceServizio = (String)attributes.get("codiceServizio");

		if (codiceServizio != null) {
			setCodiceServizio(codiceServizio);
		}

		String uriServizio = (String)attributes.get("uriServizio");

		if (uriServizio != null) {
			setUriServizio(uriServizio);
		}

		Long tipologiaComunicazioneId = (Long)attributes.get(
			"tipologiaComunicazioneId");

		if (tipologiaComunicazioneId != null) {
			setTipologiaComunicazioneId(tipologiaComunicazioneId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long destinatarioUserId = (Long)attributes.get("destinatarioUserId");

		if (destinatarioUserId != null) {
			setDestinatarioUserId(destinatarioUserId);
		}

		Long destinatarioOrganizationId = (Long)attributes.get(
			"destinatarioOrganizationId");

		if (destinatarioOrganizationId != null) {
			setDestinatarioOrganizationId(destinatarioOrganizationId);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
		}
	}

	@Override
	public Comunicazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the calendar booking ID of this comunicazione.
	 *
	 * @return the calendar booking ID of this comunicazione
	 */
	@Override
	public long getCalendarBookingId() {
		return model.getCalendarBookingId();
	}

	/**
	 * Returns the codice servizio of this comunicazione.
	 *
	 * @return the codice servizio of this comunicazione
	 */
	@Override
	public String getCodiceServizio() {
		return model.getCodiceServizio();
	}

	/**
	 * Returns the company ID of this comunicazione.
	 *
	 * @return the company ID of this comunicazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the comunicazione ID of this comunicazione.
	 *
	 * @return the comunicazione ID of this comunicazione
	 */
	@Override
	public long getComunicazioneId() {
		return model.getComunicazioneId();
	}

	/**
	 * Returns the create date of this comunicazione.
	 *
	 * @return the create date of this comunicazione
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this comunicazione.
	 *
	 * @return the data fine of this comunicazione
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this comunicazione.
	 *
	 * @return the data inizio of this comunicazione
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the data invio of this comunicazione.
	 *
	 * @return the data invio of this comunicazione
	 */
	@Override
	public Date getDataInvio() {
		return model.getDataInvio();
	}

	/**
	 * Returns the descrizione of this comunicazione.
	 *
	 * @return the descrizione of this comunicazione
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the destinatario organization ID of this comunicazione.
	 *
	 * @return the destinatario organization ID of this comunicazione
	 */
	@Override
	public long getDestinatarioOrganizationId() {
		return model.getDestinatarioOrganizationId();
	}

	@Override
	public com.liferay.portal.kernel.model.Organization
		getDestinatarioOrganizzazione() {

		return model.getDestinatarioOrganizzazione();
	}

	/**
	 * Returns the destinatario user ID of this comunicazione.
	 *
	 * @return the destinatario user ID of this comunicazione
	 */
	@Override
	public long getDestinatarioUserId() {
		return model.getDestinatarioUserId();
	}

	/**
	 * Returns the destinatario user uuid of this comunicazione.
	 *
	 * @return the destinatario user uuid of this comunicazione
	 */
	@Override
	public String getDestinatarioUserUuid() {
		return model.getDestinatarioUserUuid();
	}

	/**
	 * Returns the group ID of this comunicazione.
	 *
	 * @return the group ID of this comunicazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione
		getLettura() {

		return model.getLettura();
	}

	/**
	 * Returns the modified date of this comunicazione.
	 *
	 * @return the modified date of this comunicazione
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this comunicazione.
	 *
	 * @return the organization ID of this comunicazione
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this comunicazione.
	 *
	 * @return the primary key of this comunicazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione
		getTipologia() {

		return model.getTipologia();
	}

	/**
	 * Returns the tipologia comunicazione ID of this comunicazione.
	 *
	 * @return the tipologia comunicazione ID of this comunicazione
	 */
	@Override
	public long getTipologiaComunicazioneId() {
		return model.getTipologiaComunicazioneId();
	}

	/**
	 * Returns the titolo of this comunicazione.
	 *
	 * @return the titolo of this comunicazione
	 */
	@Override
	public String getTitolo() {
		return model.getTitolo();
	}

	/**
	 * Returns the uri servizio of this comunicazione.
	 *
	 * @return the uri servizio of this comunicazione
	 */
	@Override
	public String getUriServizio() {
		return model.getUriServizio();
	}

	/**
	 * Returns the user ID of this comunicazione.
	 *
	 * @return the user ID of this comunicazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this comunicazione.
	 *
	 * @return the user name of this comunicazione
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this comunicazione.
	 *
	 * @return the user uuid of this comunicazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this comunicazione.
	 *
	 * @return the uuid of this comunicazione
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
	 * Sets the calendar booking ID of this comunicazione.
	 *
	 * @param calendarBookingId the calendar booking ID of this comunicazione
	 */
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		model.setCalendarBookingId(calendarBookingId);
	}

	/**
	 * Sets the codice servizio of this comunicazione.
	 *
	 * @param codiceServizio the codice servizio of this comunicazione
	 */
	@Override
	public void setCodiceServizio(String codiceServizio) {
		model.setCodiceServizio(codiceServizio);
	}

	/**
	 * Sets the company ID of this comunicazione.
	 *
	 * @param companyId the company ID of this comunicazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the comunicazione ID of this comunicazione.
	 *
	 * @param comunicazioneId the comunicazione ID of this comunicazione
	 */
	@Override
	public void setComunicazioneId(long comunicazioneId) {
		model.setComunicazioneId(comunicazioneId);
	}

	/**
	 * Sets the create date of this comunicazione.
	 *
	 * @param createDate the create date of this comunicazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this comunicazione.
	 *
	 * @param dataFine the data fine of this comunicazione
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this comunicazione.
	 *
	 * @param dataInizio the data inizio of this comunicazione
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the data invio of this comunicazione.
	 *
	 * @param dataInvio the data invio of this comunicazione
	 */
	@Override
	public void setDataInvio(Date dataInvio) {
		model.setDataInvio(dataInvio);
	}

	/**
	 * Sets the descrizione of this comunicazione.
	 *
	 * @param descrizione the descrizione of this comunicazione
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the destinatario organization ID of this comunicazione.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID of this comunicazione
	 */
	@Override
	public void setDestinatarioOrganizationId(long destinatarioOrganizationId) {
		model.setDestinatarioOrganizationId(destinatarioOrganizationId);
	}

	/**
	 * Sets the destinatario user ID of this comunicazione.
	 *
	 * @param destinatarioUserId the destinatario user ID of this comunicazione
	 */
	@Override
	public void setDestinatarioUserId(long destinatarioUserId) {
		model.setDestinatarioUserId(destinatarioUserId);
	}

	/**
	 * Sets the destinatario user uuid of this comunicazione.
	 *
	 * @param destinatarioUserUuid the destinatario user uuid of this comunicazione
	 */
	@Override
	public void setDestinatarioUserUuid(String destinatarioUserUuid) {
		model.setDestinatarioUserUuid(destinatarioUserUuid);
	}

	/**
	 * Sets the group ID of this comunicazione.
	 *
	 * @param groupId the group ID of this comunicazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this comunicazione.
	 *
	 * @param modifiedDate the modified date of this comunicazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this comunicazione.
	 *
	 * @param organizationId the organization ID of this comunicazione
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this comunicazione.
	 *
	 * @param primaryKey the primary key of this comunicazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipologia comunicazione ID of this comunicazione.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID of this comunicazione
	 */
	@Override
	public void setTipologiaComunicazioneId(long tipologiaComunicazioneId) {
		model.setTipologiaComunicazioneId(tipologiaComunicazioneId);
	}

	/**
	 * Sets the titolo of this comunicazione.
	 *
	 * @param titolo the titolo of this comunicazione
	 */
	@Override
	public void setTitolo(String titolo) {
		model.setTitolo(titolo);
	}

	/**
	 * Sets the uri servizio of this comunicazione.
	 *
	 * @param uriServizio the uri servizio of this comunicazione
	 */
	@Override
	public void setUriServizio(String uriServizio) {
		model.setUriServizio(uriServizio);
	}

	/**
	 * Sets the user ID of this comunicazione.
	 *
	 * @param userId the user ID of this comunicazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this comunicazione.
	 *
	 * @param userName the user name of this comunicazione
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this comunicazione.
	 *
	 * @param userUuid the user uuid of this comunicazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this comunicazione.
	 *
	 * @param uuid the uuid of this comunicazione
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
	protected ComunicazioneWrapper wrap(Comunicazione comunicazione) {
		return new ComunicazioneWrapper(comunicazione);
	}

}