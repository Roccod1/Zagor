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
 * This class is a wrapper for {@link Servizio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @generated
 */
public class ServizioWrapper
	extends BaseModelWrapper<Servizio>
	implements ModelWrapper<Servizio>, Servizio {

	public ServizioWrapper(Servizio servizio) {
		super(servizio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("servizioId", getServizioId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneEstesa", getDescrizioneEstesa());
		attributes.put("codice", getCodice());
		attributes.put("uri", getUri());
		attributes.put("uriGuest", getUriGuest());
		attributes.put("uriScheda", getUriScheda());
		attributes.put("autenticazione", isAutenticazione());
		attributes.put("dataInizioAttivazione", getDataInizioAttivazione());
		attributes.put("dataFineAttivazione", getDataFineAttivazione());
		attributes.put("cittadino", isCittadino());
		attributes.put("azienda", isAzienda());
		attributes.put("delega", isDelega());
		attributes.put("chatbot", isChatbot());
		attributes.put("gestioneBackoffice", isGestioneBackoffice());
		attributes.put("prenotabile", isPrenotabile());
		attributes.put("codicePrestazioneINPS", getCodicePrestazioneINPS());
		attributes.put("privacyDelega", isPrivacyDelega());
		attributes.put("allegatoDelega", isAllegatoDelega());
		attributes.put("timbroCertificato", isTimbroCertificato());
		attributes.put("attivo", isAttivo());
		attributes.put("areaTematicaId", getAreaTematicaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
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

		String descrizioneEstesa = (String)attributes.get("descrizioneEstesa");

		if (descrizioneEstesa != null) {
			setDescrizioneEstesa(descrizioneEstesa);
		}

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		String uri = (String)attributes.get("uri");

		if (uri != null) {
			setUri(uri);
		}

		String uriGuest = (String)attributes.get("uriGuest");

		if (uriGuest != null) {
			setUriGuest(uriGuest);
		}

		String uriScheda = (String)attributes.get("uriScheda");

		if (uriScheda != null) {
			setUriScheda(uriScheda);
		}

		Boolean autenticazione = (Boolean)attributes.get("autenticazione");

		if (autenticazione != null) {
			setAutenticazione(autenticazione);
		}

		Date dataInizioAttivazione = (Date)attributes.get(
			"dataInizioAttivazione");

		if (dataInizioAttivazione != null) {
			setDataInizioAttivazione(dataInizioAttivazione);
		}

		Date dataFineAttivazione = (Date)attributes.get("dataFineAttivazione");

		if (dataFineAttivazione != null) {
			setDataFineAttivazione(dataFineAttivazione);
		}

		Boolean cittadino = (Boolean)attributes.get("cittadino");

		if (cittadino != null) {
			setCittadino(cittadino);
		}

		Boolean azienda = (Boolean)attributes.get("azienda");

		if (azienda != null) {
			setAzienda(azienda);
		}

		Boolean delega = (Boolean)attributes.get("delega");

		if (delega != null) {
			setDelega(delega);
		}

		Boolean chatbot = (Boolean)attributes.get("chatbot");

		if (chatbot != null) {
			setChatbot(chatbot);
		}

		Boolean gestioneBackoffice = (Boolean)attributes.get(
			"gestioneBackoffice");

		if (gestioneBackoffice != null) {
			setGestioneBackoffice(gestioneBackoffice);
		}

		Boolean prenotabile = (Boolean)attributes.get("prenotabile");

		if (prenotabile != null) {
			setPrenotabile(prenotabile);
		}

		String codicePrestazioneINPS = (String)attributes.get(
			"codicePrestazioneINPS");

		if (codicePrestazioneINPS != null) {
			setCodicePrestazioneINPS(codicePrestazioneINPS);
		}

		Boolean privacyDelega = (Boolean)attributes.get("privacyDelega");

		if (privacyDelega != null) {
			setPrivacyDelega(privacyDelega);
		}

		Boolean allegatoDelega = (Boolean)attributes.get("allegatoDelega");

		if (allegatoDelega != null) {
			setAllegatoDelega(allegatoDelega);
		}

		Boolean timbroCertificato = (Boolean)attributes.get(
			"timbroCertificato");

		if (timbroCertificato != null) {
			setTimbroCertificato(timbroCertificato);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}

		Long areaTematicaId = (Long)attributes.get("areaTematicaId");

		if (areaTematicaId != null) {
			setAreaTematicaId(areaTematicaId);
		}
	}

	@Override
	public Servizio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allegato delega of this servizio.
	 *
	 * @return the allegato delega of this servizio
	 */
	@Override
	public boolean getAllegatoDelega() {
		return model.getAllegatoDelega();
	}

	@Override
	public it.servizidigitali.gestioneservizi.model.AreaTematica
		getAreaTematica() {

		return model.getAreaTematica();
	}

	/**
	 * Returns the area tematica ID of this servizio.
	 *
	 * @return the area tematica ID of this servizio
	 */
	@Override
	public long getAreaTematicaId() {
		return model.getAreaTematicaId();
	}

	/**
	 * Returns the attivo of this servizio.
	 *
	 * @return the attivo of this servizio
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the autenticazione of this servizio.
	 *
	 * @return the autenticazione of this servizio
	 */
	@Override
	public boolean getAutenticazione() {
		return model.getAutenticazione();
	}

	/**
	 * Returns the azienda of this servizio.
	 *
	 * @return the azienda of this servizio
	 */
	@Override
	public boolean getAzienda() {
		return model.getAzienda();
	}

	/**
	 * Returns the chatbot of this servizio.
	 *
	 * @return the chatbot of this servizio
	 */
	@Override
	public boolean getChatbot() {
		return model.getChatbot();
	}

	/**
	 * Returns the cittadino of this servizio.
	 *
	 * @return the cittadino of this servizio
	 */
	@Override
	public boolean getCittadino() {
		return model.getCittadino();
	}

	/**
	 * Returns the codice of this servizio.
	 *
	 * @return the codice of this servizio
	 */
	@Override
	public String getCodice() {
		return model.getCodice();
	}

	/**
	 * Returns the codice prestazione inps of this servizio.
	 *
	 * @return the codice prestazione inps of this servizio
	 */
	@Override
	public String getCodicePrestazioneINPS() {
		return model.getCodicePrestazioneINPS();
	}

	/**
	 * Returns the company ID of this servizio.
	 *
	 * @return the company ID of this servizio
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this servizio.
	 *
	 * @return the create date of this servizio
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine attivazione of this servizio.
	 *
	 * @return the data fine attivazione of this servizio
	 */
	@Override
	public Date getDataFineAttivazione() {
		return model.getDataFineAttivazione();
	}

	/**
	 * Returns the data inizio attivazione of this servizio.
	 *
	 * @return the data inizio attivazione of this servizio
	 */
	@Override
	public Date getDataInizioAttivazione() {
		return model.getDataInizioAttivazione();
	}

	/**
	 * Returns the delega of this servizio.
	 *
	 * @return the delega of this servizio
	 */
	@Override
	public boolean getDelega() {
		return model.getDelega();
	}

	/**
	 * Returns the descrizione of this servizio.
	 *
	 * @return the descrizione of this servizio
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the descrizione estesa of this servizio.
	 *
	 * @return the descrizione estesa of this servizio
	 */
	@Override
	public String getDescrizioneEstesa() {
		return model.getDescrizioneEstesa();
	}

	/**
	 * Returns the gestione backoffice of this servizio.
	 *
	 * @return the gestione backoffice of this servizio
	 */
	@Override
	public boolean getGestioneBackoffice() {
		return model.getGestioneBackoffice();
	}

	/**
	 * Returns the group ID of this servizio.
	 *
	 * @return the group ID of this servizio
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	@Override
	public java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
		getListaTipologie() {

		return model.getListaTipologie();
	}

	/**
	 * Returns the modified date of this servizio.
	 *
	 * @return the modified date of this servizio
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this servizio.
	 *
	 * @return the nome of this servizio
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the prenotabile of this servizio.
	 *
	 * @return the prenotabile of this servizio
	 */
	@Override
	public boolean getPrenotabile() {
		return model.getPrenotabile();
	}

	/**
	 * Returns the primary key of this servizio.
	 *
	 * @return the primary key of this servizio
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the privacy delega of this servizio.
	 *
	 * @return the privacy delega of this servizio
	 */
	@Override
	public boolean getPrivacyDelega() {
		return model.getPrivacyDelega();
	}

	/**
	 * Returns the servizio ID of this servizio.
	 *
	 * @return the servizio ID of this servizio
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the timbro certificato of this servizio.
	 *
	 * @return the timbro certificato of this servizio
	 */
	@Override
	public boolean getTimbroCertificato() {
		return model.getTimbroCertificato();
	}

	/**
	 * Returns the uri of this servizio.
	 *
	 * @return the uri of this servizio
	 */
	@Override
	public String getUri() {
		return model.getUri();
	}

	/**
	 * Returns the uri guest of this servizio.
	 *
	 * @return the uri guest of this servizio
	 */
	@Override
	public String getUriGuest() {
		return model.getUriGuest();
	}

	/**
	 * Returns the uri scheda of this servizio.
	 *
	 * @return the uri scheda of this servizio
	 */
	@Override
	public String getUriScheda() {
		return model.getUriScheda();
	}

	/**
	 * Returns the user ID of this servizio.
	 *
	 * @return the user ID of this servizio
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this servizio.
	 *
	 * @return the user name of this servizio
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this servizio.
	 *
	 * @return the user uuid of this servizio
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this servizio.
	 *
	 * @return the uuid of this servizio
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this servizio is allegato delega.
	 *
	 * @return <code>true</code> if this servizio is allegato delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllegatoDelega() {
		return model.isAllegatoDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio is attivo.
	 *
	 * @return <code>true</code> if this servizio is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	/**
	 * Returns <code>true</code> if this servizio is autenticazione.
	 *
	 * @return <code>true</code> if this servizio is autenticazione; <code>false</code> otherwise
	 */
	@Override
	public boolean isAutenticazione() {
		return model.isAutenticazione();
	}

	/**
	 * Returns <code>true</code> if this servizio is azienda.
	 *
	 * @return <code>true</code> if this servizio is azienda; <code>false</code> otherwise
	 */
	@Override
	public boolean isAzienda() {
		return model.isAzienda();
	}

	/**
	 * Returns <code>true</code> if this servizio is chatbot.
	 *
	 * @return <code>true</code> if this servizio is chatbot; <code>false</code> otherwise
	 */
	@Override
	public boolean isChatbot() {
		return model.isChatbot();
	}

	/**
	 * Returns <code>true</code> if this servizio is cittadino.
	 *
	 * @return <code>true</code> if this servizio is cittadino; <code>false</code> otherwise
	 */
	@Override
	public boolean isCittadino() {
		return model.isCittadino();
	}

	/**
	 * Returns <code>true</code> if this servizio is delega.
	 *
	 * @return <code>true</code> if this servizio is delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isDelega() {
		return model.isDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio is gestione backoffice.
	 *
	 * @return <code>true</code> if this servizio is gestione backoffice; <code>false</code> otherwise
	 */
	@Override
	public boolean isGestioneBackoffice() {
		return model.isGestioneBackoffice();
	}

	/**
	 * Returns <code>true</code> if this servizio is prenotabile.
	 *
	 * @return <code>true</code> if this servizio is prenotabile; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrenotabile() {
		return model.isPrenotabile();
	}

	/**
	 * Returns <code>true</code> if this servizio is privacy delega.
	 *
	 * @return <code>true</code> if this servizio is privacy delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrivacyDelega() {
		return model.isPrivacyDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio is timbro certificato.
	 *
	 * @return <code>true</code> if this servizio is timbro certificato; <code>false</code> otherwise
	 */
	@Override
	public boolean isTimbroCertificato() {
		return model.isTimbroCertificato();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this servizio is allegato delega.
	 *
	 * @param allegatoDelega the allegato delega of this servizio
	 */
	@Override
	public void setAllegatoDelega(boolean allegatoDelega) {
		model.setAllegatoDelega(allegatoDelega);
	}

	@Override
	public void setAreaTematica(
		it.servizidigitali.gestioneservizi.model.AreaTematica areaTematica) {

		model.setAreaTematica(areaTematica);
	}

	/**
	 * Sets the area tematica ID of this servizio.
	 *
	 * @param areaTematicaId the area tematica ID of this servizio
	 */
	@Override
	public void setAreaTematicaId(long areaTematicaId) {
		model.setAreaTematicaId(areaTematicaId);
	}

	/**
	 * Sets whether this servizio is attivo.
	 *
	 * @param attivo the attivo of this servizio
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets whether this servizio is autenticazione.
	 *
	 * @param autenticazione the autenticazione of this servizio
	 */
	@Override
	public void setAutenticazione(boolean autenticazione) {
		model.setAutenticazione(autenticazione);
	}

	/**
	 * Sets whether this servizio is azienda.
	 *
	 * @param azienda the azienda of this servizio
	 */
	@Override
	public void setAzienda(boolean azienda) {
		model.setAzienda(azienda);
	}

	/**
	 * Sets whether this servizio is chatbot.
	 *
	 * @param chatbot the chatbot of this servizio
	 */
	@Override
	public void setChatbot(boolean chatbot) {
		model.setChatbot(chatbot);
	}

	/**
	 * Sets whether this servizio is cittadino.
	 *
	 * @param cittadino the cittadino of this servizio
	 */
	@Override
	public void setCittadino(boolean cittadino) {
		model.setCittadino(cittadino);
	}

	/**
	 * Sets the codice of this servizio.
	 *
	 * @param codice the codice of this servizio
	 */
	@Override
	public void setCodice(String codice) {
		model.setCodice(codice);
	}

	/**
	 * Sets the codice prestazione inps of this servizio.
	 *
	 * @param codicePrestazioneINPS the codice prestazione inps of this servizio
	 */
	@Override
	public void setCodicePrestazioneINPS(String codicePrestazioneINPS) {
		model.setCodicePrestazioneINPS(codicePrestazioneINPS);
	}

	/**
	 * Sets the company ID of this servizio.
	 *
	 * @param companyId the company ID of this servizio
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this servizio.
	 *
	 * @param createDate the create date of this servizio
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine attivazione of this servizio.
	 *
	 * @param dataFineAttivazione the data fine attivazione of this servizio
	 */
	@Override
	public void setDataFineAttivazione(Date dataFineAttivazione) {
		model.setDataFineAttivazione(dataFineAttivazione);
	}

	/**
	 * Sets the data inizio attivazione of this servizio.
	 *
	 * @param dataInizioAttivazione the data inizio attivazione of this servizio
	 */
	@Override
	public void setDataInizioAttivazione(Date dataInizioAttivazione) {
		model.setDataInizioAttivazione(dataInizioAttivazione);
	}

	/**
	 * Sets whether this servizio is delega.
	 *
	 * @param delega the delega of this servizio
	 */
	@Override
	public void setDelega(boolean delega) {
		model.setDelega(delega);
	}

	/**
	 * Sets the descrizione of this servizio.
	 *
	 * @param descrizione the descrizione of this servizio
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the descrizione estesa of this servizio.
	 *
	 * @param descrizioneEstesa the descrizione estesa of this servizio
	 */
	@Override
	public void setDescrizioneEstesa(String descrizioneEstesa) {
		model.setDescrizioneEstesa(descrizioneEstesa);
	}

	/**
	 * Sets whether this servizio is gestione backoffice.
	 *
	 * @param gestioneBackoffice the gestione backoffice of this servizio
	 */
	@Override
	public void setGestioneBackoffice(boolean gestioneBackoffice) {
		model.setGestioneBackoffice(gestioneBackoffice);
	}

	/**
	 * Sets the group ID of this servizio.
	 *
	 * @param groupId the group ID of this servizio
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	@Override
	public void setListaTipologie(
		java.util.List<it.servizidigitali.gestioneservizi.model.Tipologia>
			listaTipologie) {

		model.setListaTipologie(listaTipologie);
	}

	/**
	 * Sets the modified date of this servizio.
	 *
	 * @param modifiedDate the modified date of this servizio
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this servizio.
	 *
	 * @param nome the nome of this servizio
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets whether this servizio is prenotabile.
	 *
	 * @param prenotabile the prenotabile of this servizio
	 */
	@Override
	public void setPrenotabile(boolean prenotabile) {
		model.setPrenotabile(prenotabile);
	}

	/**
	 * Sets the primary key of this servizio.
	 *
	 * @param primaryKey the primary key of this servizio
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this servizio is privacy delega.
	 *
	 * @param privacyDelega the privacy delega of this servizio
	 */
	@Override
	public void setPrivacyDelega(boolean privacyDelega) {
		model.setPrivacyDelega(privacyDelega);
	}

	/**
	 * Sets the servizio ID of this servizio.
	 *
	 * @param servizioId the servizio ID of this servizio
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets whether this servizio is timbro certificato.
	 *
	 * @param timbroCertificato the timbro certificato of this servizio
	 */
	@Override
	public void setTimbroCertificato(boolean timbroCertificato) {
		model.setTimbroCertificato(timbroCertificato);
	}

	/**
	 * Sets the uri of this servizio.
	 *
	 * @param uri the uri of this servizio
	 */
	@Override
	public void setUri(String uri) {
		model.setUri(uri);
	}

	/**
	 * Sets the uri guest of this servizio.
	 *
	 * @param uriGuest the uri guest of this servizio
	 */
	@Override
	public void setUriGuest(String uriGuest) {
		model.setUriGuest(uriGuest);
	}

	/**
	 * Sets the uri scheda of this servizio.
	 *
	 * @param uriScheda the uri scheda of this servizio
	 */
	@Override
	public void setUriScheda(String uriScheda) {
		model.setUriScheda(uriScheda);
	}

	/**
	 * Sets the user ID of this servizio.
	 *
	 * @param userId the user ID of this servizio
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this servizio.
	 *
	 * @param userName the user name of this servizio
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this servizio.
	 *
	 * @param userUuid the user uuid of this servizio
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this servizio.
	 *
	 * @param uuid the uuid of this servizio
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
	protected ServizioWrapper wrap(Servizio servizio) {
		return new ServizioWrapper(servizio);
	}

}