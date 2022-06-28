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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Servizio service. Represents a row in the &quot;servizio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneservizi.model.impl.ServizioImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @generated
 */
@ProviderType
public interface ServizioModel
	extends BaseModel<Servizio>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a servizio model instance should use the {@link Servizio} interface instead.
	 */

	/**
	 * Returns the primary key of this servizio.
	 *
	 * @return the primary key of this servizio
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this servizio.
	 *
	 * @param primaryKey the primary key of this servizio
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this servizio.
	 *
	 * @return the uuid of this servizio
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this servizio.
	 *
	 * @param uuid the uuid of this servizio
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the servizio ID of this servizio.
	 *
	 * @return the servizio ID of this servizio
	 */
	public long getServizioId();

	/**
	 * Sets the servizio ID of this servizio.
	 *
	 * @param servizioId the servizio ID of this servizio
	 */
	public void setServizioId(long servizioId);

	/**
	 * Returns the group ID of this servizio.
	 *
	 * @return the group ID of this servizio
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this servizio.
	 *
	 * @param groupId the group ID of this servizio
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this servizio.
	 *
	 * @return the company ID of this servizio
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this servizio.
	 *
	 * @param companyId the company ID of this servizio
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this servizio.
	 *
	 * @return the user ID of this servizio
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this servizio.
	 *
	 * @param userId the user ID of this servizio
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this servizio.
	 *
	 * @return the user uuid of this servizio
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this servizio.
	 *
	 * @param userUuid the user uuid of this servizio
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this servizio.
	 *
	 * @return the user name of this servizio
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this servizio.
	 *
	 * @param userName the user name of this servizio
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this servizio.
	 *
	 * @return the create date of this servizio
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this servizio.
	 *
	 * @param createDate the create date of this servizio
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this servizio.
	 *
	 * @return the modified date of this servizio
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this servizio.
	 *
	 * @param modifiedDate the modified date of this servizio
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this servizio.
	 *
	 * @return the nome of this servizio
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this servizio.
	 *
	 * @param nome the nome of this servizio
	 */
	public void setNome(String nome);

	/**
	 * Returns the descrizione of this servizio.
	 *
	 * @return the descrizione of this servizio
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this servizio.
	 *
	 * @param descrizione the descrizione of this servizio
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the descrizione estesa of this servizio.
	 *
	 * @return the descrizione estesa of this servizio
	 */
	@AutoEscape
	public String getDescrizioneEstesa();

	/**
	 * Sets the descrizione estesa of this servizio.
	 *
	 * @param descrizioneEstesa the descrizione estesa of this servizio
	 */
	public void setDescrizioneEstesa(String descrizioneEstesa);

	/**
	 * Returns the codice of this servizio.
	 *
	 * @return the codice of this servizio
	 */
	@AutoEscape
	public String getCodice();

	/**
	 * Sets the codice of this servizio.
	 *
	 * @param codice the codice of this servizio
	 */
	public void setCodice(String codice);

	/**
	 * Returns the uri of this servizio.
	 *
	 * @return the uri of this servizio
	 */
	@AutoEscape
	public String getUri();

	/**
	 * Sets the uri of this servizio.
	 *
	 * @param uri the uri of this servizio
	 */
	public void setUri(String uri);

	/**
	 * Returns the uri guest of this servizio.
	 *
	 * @return the uri guest of this servizio
	 */
	@AutoEscape
	public String getUriGuest();

	/**
	 * Sets the uri guest of this servizio.
	 *
	 * @param uriGuest the uri guest of this servizio
	 */
	public void setUriGuest(String uriGuest);

	/**
	 * Returns the uri scheda of this servizio.
	 *
	 * @return the uri scheda of this servizio
	 */
	@AutoEscape
	public String getUriScheda();

	/**
	 * Sets the uri scheda of this servizio.
	 *
	 * @param uriScheda the uri scheda of this servizio
	 */
	public void setUriScheda(String uriScheda);

	/**
	 * Returns the autenticazione of this servizio.
	 *
	 * @return the autenticazione of this servizio
	 */
	public boolean getAutenticazione();

	/**
	 * Returns <code>true</code> if this servizio is autenticazione.
	 *
	 * @return <code>true</code> if this servizio is autenticazione; <code>false</code> otherwise
	 */
	public boolean isAutenticazione();

	/**
	 * Sets whether this servizio is autenticazione.
	 *
	 * @param autenticazione the autenticazione of this servizio
	 */
	public void setAutenticazione(boolean autenticazione);

	/**
	 * Returns the data inizio attivazione of this servizio.
	 *
	 * @return the data inizio attivazione of this servizio
	 */
	public Date getDataInizioAttivazione();

	/**
	 * Sets the data inizio attivazione of this servizio.
	 *
	 * @param dataInizioAttivazione the data inizio attivazione of this servizio
	 */
	public void setDataInizioAttivazione(Date dataInizioAttivazione);

	/**
	 * Returns the data fine attivazione of this servizio.
	 *
	 * @return the data fine attivazione of this servizio
	 */
	public Date getDataFineAttivazione();

	/**
	 * Sets the data fine attivazione of this servizio.
	 *
	 * @param dataFineAttivazione the data fine attivazione of this servizio
	 */
	public void setDataFineAttivazione(Date dataFineAttivazione);

	/**
	 * Returns the cittadino of this servizio.
	 *
	 * @return the cittadino of this servizio
	 */
	public boolean getCittadino();

	/**
	 * Returns <code>true</code> if this servizio is cittadino.
	 *
	 * @return <code>true</code> if this servizio is cittadino; <code>false</code> otherwise
	 */
	public boolean isCittadino();

	/**
	 * Sets whether this servizio is cittadino.
	 *
	 * @param cittadino the cittadino of this servizio
	 */
	public void setCittadino(boolean cittadino);

	/**
	 * Returns the azienda of this servizio.
	 *
	 * @return the azienda of this servizio
	 */
	public boolean getAzienda();

	/**
	 * Returns <code>true</code> if this servizio is azienda.
	 *
	 * @return <code>true</code> if this servizio is azienda; <code>false</code> otherwise
	 */
	public boolean isAzienda();

	/**
	 * Sets whether this servizio is azienda.
	 *
	 * @param azienda the azienda of this servizio
	 */
	public void setAzienda(boolean azienda);

	/**
	 * Returns the delega of this servizio.
	 *
	 * @return the delega of this servizio
	 */
	public boolean getDelega();

	/**
	 * Returns <code>true</code> if this servizio is delega.
	 *
	 * @return <code>true</code> if this servizio is delega; <code>false</code> otherwise
	 */
	public boolean isDelega();

	/**
	 * Sets whether this servizio is delega.
	 *
	 * @param delega the delega of this servizio
	 */
	public void setDelega(boolean delega);

	/**
	 * Returns the chatbot of this servizio.
	 *
	 * @return the chatbot of this servizio
	 */
	public boolean getChatbot();

	/**
	 * Returns <code>true</code> if this servizio is chatbot.
	 *
	 * @return <code>true</code> if this servizio is chatbot; <code>false</code> otherwise
	 */
	public boolean isChatbot();

	/**
	 * Sets whether this servizio is chatbot.
	 *
	 * @param chatbot the chatbot of this servizio
	 */
	public void setChatbot(boolean chatbot);

	/**
	 * Returns the gestione backoffice of this servizio.
	 *
	 * @return the gestione backoffice of this servizio
	 */
	public boolean getGestioneBackoffice();

	/**
	 * Returns <code>true</code> if this servizio is gestione backoffice.
	 *
	 * @return <code>true</code> if this servizio is gestione backoffice; <code>false</code> otherwise
	 */
	public boolean isGestioneBackoffice();

	/**
	 * Sets whether this servizio is gestione backoffice.
	 *
	 * @param gestioneBackoffice the gestione backoffice of this servizio
	 */
	public void setGestioneBackoffice(boolean gestioneBackoffice);

	/**
	 * Returns the prenotabile of this servizio.
	 *
	 * @return the prenotabile of this servizio
	 */
	public boolean getPrenotabile();

	/**
	 * Returns <code>true</code> if this servizio is prenotabile.
	 *
	 * @return <code>true</code> if this servizio is prenotabile; <code>false</code> otherwise
	 */
	public boolean isPrenotabile();

	/**
	 * Sets whether this servizio is prenotabile.
	 *
	 * @param prenotabile the prenotabile of this servizio
	 */
	public void setPrenotabile(boolean prenotabile);

	/**
	 * Returns the codice prestazione inps of this servizio.
	 *
	 * @return the codice prestazione inps of this servizio
	 */
	@AutoEscape
	public String getCodicePrestazioneINPS();

	/**
	 * Sets the codice prestazione inps of this servizio.
	 *
	 * @param codicePrestazioneINPS the codice prestazione inps of this servizio
	 */
	public void setCodicePrestazioneINPS(String codicePrestazioneINPS);

	/**
	 * Returns the privacy delega of this servizio.
	 *
	 * @return the privacy delega of this servizio
	 */
	public boolean getPrivacyDelega();

	/**
	 * Returns <code>true</code> if this servizio is privacy delega.
	 *
	 * @return <code>true</code> if this servizio is privacy delega; <code>false</code> otherwise
	 */
	public boolean isPrivacyDelega();

	/**
	 * Sets whether this servizio is privacy delega.
	 *
	 * @param privacyDelega the privacy delega of this servizio
	 */
	public void setPrivacyDelega(boolean privacyDelega);

	/**
	 * Returns the allegato delega of this servizio.
	 *
	 * @return the allegato delega of this servizio
	 */
	public boolean getAllegatoDelega();

	/**
	 * Returns <code>true</code> if this servizio is allegato delega.
	 *
	 * @return <code>true</code> if this servizio is allegato delega; <code>false</code> otherwise
	 */
	public boolean isAllegatoDelega();

	/**
	 * Sets whether this servizio is allegato delega.
	 *
	 * @param allegatoDelega the allegato delega of this servizio
	 */
	public void setAllegatoDelega(boolean allegatoDelega);

	/**
	 * Returns the timbro certificato of this servizio.
	 *
	 * @return the timbro certificato of this servizio
	 */
	public boolean getTimbroCertificato();

	/**
	 * Returns <code>true</code> if this servizio is timbro certificato.
	 *
	 * @return <code>true</code> if this servizio is timbro certificato; <code>false</code> otherwise
	 */
	public boolean isTimbroCertificato();

	/**
	 * Sets whether this servizio is timbro certificato.
	 *
	 * @param timbroCertificato the timbro certificato of this servizio
	 */
	public void setTimbroCertificato(boolean timbroCertificato);

	/**
	 * Returns the attivo of this servizio.
	 *
	 * @return the attivo of this servizio
	 */
	public boolean getAttivo();

	/**
	 * Returns <code>true</code> if this servizio is attivo.
	 *
	 * @return <code>true</code> if this servizio is attivo; <code>false</code> otherwise
	 */
	public boolean isAttivo();

	/**
	 * Sets whether this servizio is attivo.
	 *
	 * @param attivo the attivo of this servizio
	 */
	public void setAttivo(boolean attivo);

	@Override
	public Servizio cloneWithOriginalValues();

}