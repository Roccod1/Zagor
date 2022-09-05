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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Richiesta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Richiesta
 * @generated
 */
public class RichiestaWrapper
	extends BaseModelWrapper<Richiesta>
	implements ModelWrapper<Richiesta>, Richiesta {

	public RichiestaWrapper(Richiesta richiesta) {
		super(richiesta);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("richiestaId", getRichiestaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("partitaIva", getPartitaIva());
		attributes.put("email", getEmail());
		attributes.put("codiceFiscaleDelegato", getCodiceFiscaleDelegato());
		attributes.put("stato", getStato());
		attributes.put("numeroProtocollo", getNumeroProtocollo());
		attributes.put("dataProtocollo", getDataProtocollo());
		attributes.put("numeroProtocolloEsterno", getNumeroProtocolloEsterno());
		attributes.put("dataProtocolloEsterno", getDataProtocolloEsterno());
		attributes.put("oggetto", getOggetto());
		attributes.put("note", getNote());
		attributes.put("invioGuest", isInvioGuest());
		attributes.put("tokenVisualizzazione", getTokenVisualizzazione());
		attributes.put(
			"chiaveAssociazioneBackoffice", getChiaveAssociazioneBackoffice());
		attributes.put("delegaId", getDelegaId());
		attributes.put("proceduraId", getProceduraId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
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

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String partitaIva = (String)attributes.get("partitaIva");

		if (partitaIva != null) {
			setPartitaIva(partitaIva);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String codiceFiscaleDelegato = (String)attributes.get(
			"codiceFiscaleDelegato");

		if (codiceFiscaleDelegato != null) {
			setCodiceFiscaleDelegato(codiceFiscaleDelegato);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String numeroProtocollo = (String)attributes.get("numeroProtocollo");

		if (numeroProtocollo != null) {
			setNumeroProtocollo(numeroProtocollo);
		}

		Date dataProtocollo = (Date)attributes.get("dataProtocollo");

		if (dataProtocollo != null) {
			setDataProtocollo(dataProtocollo);
		}

		String numeroProtocolloEsterno = (String)attributes.get(
			"numeroProtocolloEsterno");

		if (numeroProtocolloEsterno != null) {
			setNumeroProtocolloEsterno(numeroProtocolloEsterno);
		}

		Date dataProtocolloEsterno = (Date)attributes.get(
			"dataProtocolloEsterno");

		if (dataProtocolloEsterno != null) {
			setDataProtocolloEsterno(dataProtocolloEsterno);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean invioGuest = (Boolean)attributes.get("invioGuest");

		if (invioGuest != null) {
			setInvioGuest(invioGuest);
		}

		String tokenVisualizzazione = (String)attributes.get(
			"tokenVisualizzazione");

		if (tokenVisualizzazione != null) {
			setTokenVisualizzazione(tokenVisualizzazione);
		}

		String chiaveAssociazioneBackoffice = (String)attributes.get(
			"chiaveAssociazioneBackoffice");

		if (chiaveAssociazioneBackoffice != null) {
			setChiaveAssociazioneBackoffice(chiaveAssociazioneBackoffice);
		}

		Long delegaId = (Long)attributes.get("delegaId");

		if (delegaId != null) {
			setDelegaId(delegaId);
		}

		Long proceduraId = (Long)attributes.get("proceduraId");

		if (proceduraId != null) {
			setProceduraId(proceduraId);
		}
	}

	@Override
	public Richiesta cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the chiave associazione backoffice of this richiesta.
	 *
	 * @return the chiave associazione backoffice of this richiesta
	 */
	@Override
	public String getChiaveAssociazioneBackoffice() {
		return model.getChiaveAssociazioneBackoffice();
	}

	/**
	 * Returns the codice fiscale of this richiesta.
	 *
	 * @return the codice fiscale of this richiesta
	 */
	@Override
	public String getCodiceFiscale() {
		return model.getCodiceFiscale();
	}

	/**
	 * Returns the codice fiscale delegato of this richiesta.
	 *
	 * @return the codice fiscale delegato of this richiesta
	 */
	@Override
	public String getCodiceFiscaleDelegato() {
		return model.getCodiceFiscaleDelegato();
	}

	/**
	 * Returns the company ID of this richiesta.
	 *
	 * @return the company ID of this richiesta
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this richiesta.
	 *
	 * @return the create date of this richiesta
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data protocollo of this richiesta.
	 *
	 * @return the data protocollo of this richiesta
	 */
	@Override
	public Date getDataProtocollo() {
		return model.getDataProtocollo();
	}

	/**
	 * Returns the data protocollo esterno of this richiesta.
	 *
	 * @return the data protocollo esterno of this richiesta
	 */
	@Override
	public Date getDataProtocolloEsterno() {
		return model.getDataProtocolloEsterno();
	}

	/**
	 * Returns the delega ID of this richiesta.
	 *
	 * @return the delega ID of this richiesta
	 */
	@Override
	public Long getDelegaId() {
		return model.getDelegaId();
	}

	/**
	 * Returns the email of this richiesta.
	 *
	 * @return the email of this richiesta
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this richiesta.
	 *
	 * @return the group ID of this richiesta
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the invio guest of this richiesta.
	 *
	 * @return the invio guest of this richiesta
	 */
	@Override
	public boolean getInvioGuest() {
		return model.getInvioGuest();
	}

	/**
	 * Returns the modified date of this richiesta.
	 *
	 * @return the modified date of this richiesta
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this richiesta.
	 *
	 * @return the note of this richiesta
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the numero protocollo of this richiesta.
	 *
	 * @return the numero protocollo of this richiesta
	 */
	@Override
	public String getNumeroProtocollo() {
		return model.getNumeroProtocollo();
	}

	/**
	 * Returns the numero protocollo esterno of this richiesta.
	 *
	 * @return the numero protocollo esterno of this richiesta
	 */
	@Override
	public String getNumeroProtocolloEsterno() {
		return model.getNumeroProtocolloEsterno();
	}

	/**
	 * Returns the oggetto of this richiesta.
	 *
	 * @return the oggetto of this richiesta
	 */
	@Override
	public String getOggetto() {
		return model.getOggetto();
	}

	/**
	 * Returns the partita iva of this richiesta.
	 *
	 * @return the partita iva of this richiesta
	 */
	@Override
	public String getPartitaIva() {
		return model.getPartitaIva();
	}

	/**
	 * Returns the primary key of this richiesta.
	 *
	 * @return the primary key of this richiesta
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedura ID of this richiesta.
	 *
	 * @return the procedura ID of this richiesta
	 */
	@Override
	public long getProceduraId() {
		return model.getProceduraId();
	}

	/**
	 * Returns the richiesta ID of this richiesta.
	 *
	 * @return the richiesta ID of this richiesta
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the stato of this richiesta.
	 *
	 * @return the stato of this richiesta
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the token visualizzazione of this richiesta.
	 *
	 * @return the token visualizzazione of this richiesta
	 */
	@Override
	public String getTokenVisualizzazione() {
		return model.getTokenVisualizzazione();
	}

	/**
	 * Returns the user ID of this richiesta.
	 *
	 * @return the user ID of this richiesta
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this richiesta.
	 *
	 * @return the user name of this richiesta
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this richiesta.
	 *
	 * @return the user uuid of this richiesta
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this richiesta.
	 *
	 * @return the uuid of this richiesta
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this richiesta is invio guest.
	 *
	 * @return <code>true</code> if this richiesta is invio guest; <code>false</code> otherwise
	 */
	@Override
	public boolean isInvioGuest() {
		return model.isInvioGuest();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the chiave associazione backoffice of this richiesta.
	 *
	 * @param chiaveAssociazioneBackoffice the chiave associazione backoffice of this richiesta
	 */
	@Override
	public void setChiaveAssociazioneBackoffice(
		String chiaveAssociazioneBackoffice) {

		model.setChiaveAssociazioneBackoffice(chiaveAssociazioneBackoffice);
	}

	/**
	 * Sets the codice fiscale of this richiesta.
	 *
	 * @param codiceFiscale the codice fiscale of this richiesta
	 */
	@Override
	public void setCodiceFiscale(String codiceFiscale) {
		model.setCodiceFiscale(codiceFiscale);
	}

	/**
	 * Sets the codice fiscale delegato of this richiesta.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato of this richiesta
	 */
	@Override
	public void setCodiceFiscaleDelegato(String codiceFiscaleDelegato) {
		model.setCodiceFiscaleDelegato(codiceFiscaleDelegato);
	}

	/**
	 * Sets the company ID of this richiesta.
	 *
	 * @param companyId the company ID of this richiesta
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this richiesta.
	 *
	 * @param createDate the create date of this richiesta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data protocollo of this richiesta.
	 *
	 * @param dataProtocollo the data protocollo of this richiesta
	 */
	@Override
	public void setDataProtocollo(Date dataProtocollo) {
		model.setDataProtocollo(dataProtocollo);
	}

	/**
	 * Sets the data protocollo esterno of this richiesta.
	 *
	 * @param dataProtocolloEsterno the data protocollo esterno of this richiesta
	 */
	@Override
	public void setDataProtocolloEsterno(Date dataProtocolloEsterno) {
		model.setDataProtocolloEsterno(dataProtocolloEsterno);
	}

	/**
	 * Sets the delega ID of this richiesta.
	 *
	 * @param delegaId the delega ID of this richiesta
	 */
	@Override
	public void setDelegaId(Long delegaId) {
		model.setDelegaId(delegaId);
	}

	/**
	 * Sets the email of this richiesta.
	 *
	 * @param email the email of this richiesta
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this richiesta.
	 *
	 * @param groupId the group ID of this richiesta
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this richiesta is invio guest.
	 *
	 * @param invioGuest the invio guest of this richiesta
	 */
	@Override
	public void setInvioGuest(boolean invioGuest) {
		model.setInvioGuest(invioGuest);
	}

	/**
	 * Sets the modified date of this richiesta.
	 *
	 * @param modifiedDate the modified date of this richiesta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this richiesta.
	 *
	 * @param note the note of this richiesta
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the numero protocollo of this richiesta.
	 *
	 * @param numeroProtocollo the numero protocollo of this richiesta
	 */
	@Override
	public void setNumeroProtocollo(String numeroProtocollo) {
		model.setNumeroProtocollo(numeroProtocollo);
	}

	/**
	 * Sets the numero protocollo esterno of this richiesta.
	 *
	 * @param numeroProtocolloEsterno the numero protocollo esterno of this richiesta
	 */
	@Override
	public void setNumeroProtocolloEsterno(String numeroProtocolloEsterno) {
		model.setNumeroProtocolloEsterno(numeroProtocolloEsterno);
	}

	/**
	 * Sets the oggetto of this richiesta.
	 *
	 * @param oggetto the oggetto of this richiesta
	 */
	@Override
	public void setOggetto(String oggetto) {
		model.setOggetto(oggetto);
	}

	/**
	 * Sets the partita iva of this richiesta.
	 *
	 * @param partitaIva the partita iva of this richiesta
	 */
	@Override
	public void setPartitaIva(String partitaIva) {
		model.setPartitaIva(partitaIva);
	}

	/**
	 * Sets the primary key of this richiesta.
	 *
	 * @param primaryKey the primary key of this richiesta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedura ID of this richiesta.
	 *
	 * @param proceduraId the procedura ID of this richiesta
	 */
	@Override
	public void setProceduraId(long proceduraId) {
		model.setProceduraId(proceduraId);
	}

	/**
	 * Sets the richiesta ID of this richiesta.
	 *
	 * @param richiestaId the richiesta ID of this richiesta
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the stato of this richiesta.
	 *
	 * @param stato the stato of this richiesta
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the token visualizzazione of this richiesta.
	 *
	 * @param tokenVisualizzazione the token visualizzazione of this richiesta
	 */
	@Override
	public void setTokenVisualizzazione(String tokenVisualizzazione) {
		model.setTokenVisualizzazione(tokenVisualizzazione);
	}

	/**
	 * Sets the user ID of this richiesta.
	 *
	 * @param userId the user ID of this richiesta
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this richiesta.
	 *
	 * @param userName the user name of this richiesta
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this richiesta.
	 *
	 * @param userUuid the user uuid of this richiesta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this richiesta.
	 *
	 * @param uuid the uuid of this richiesta
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
	protected RichiestaWrapper wrap(Richiesta richiesta) {
		return new RichiestaWrapper(richiesta);
	}

}