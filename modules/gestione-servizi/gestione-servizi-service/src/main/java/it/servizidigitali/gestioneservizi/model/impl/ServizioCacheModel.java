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

package it.servizidigitali.gestioneservizi.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneservizi.model.Servizio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Servizio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServizioCacheModel
	implements CacheModel<Servizio>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServizioCacheModel)) {
			return false;
		}

		ServizioCacheModel servizioCacheModel = (ServizioCacheModel)object;

		if (servizioId == servizioCacheModel.servizioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, servizioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", servizioId=");
		sb.append(servizioId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", descrizioneEstesa=");
		sb.append(descrizioneEstesa);
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", uri=");
		sb.append(uri);
		sb.append(", uriGuest=");
		sb.append(uriGuest);
		sb.append(", uriScheda=");
		sb.append(uriScheda);
		sb.append(", autenticazione=");
		sb.append(autenticazione);
		sb.append(", dataInizioAttivazione=");
		sb.append(dataInizioAttivazione);
		sb.append(", dataFineAttivazione=");
		sb.append(dataFineAttivazione);
		sb.append(", cittadino=");
		sb.append(cittadino);
		sb.append(", azienda=");
		sb.append(azienda);
		sb.append(", delega=");
		sb.append(delega);
		sb.append(", chatbot=");
		sb.append(chatbot);
		sb.append(", gestioneBackoffice=");
		sb.append(gestioneBackoffice);
		sb.append(", prenotabile=");
		sb.append(prenotabile);
		sb.append(", codicePrestazioneINPS=");
		sb.append(codicePrestazioneINPS);
		sb.append(", privacyDelega=");
		sb.append(privacyDelega);
		sb.append(", allegatoDelega=");
		sb.append(allegatoDelega);
		sb.append(", timbroCertificato=");
		sb.append(timbroCertificato);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append(", areaTematicaId=");
		sb.append(areaTematicaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Servizio toEntityModel() {
		ServizioImpl servizioImpl = new ServizioImpl();

		if (uuid == null) {
			servizioImpl.setUuid("");
		}
		else {
			servizioImpl.setUuid(uuid);
		}

		servizioImpl.setServizioId(servizioId);
		servizioImpl.setGroupId(groupId);
		servizioImpl.setCompanyId(companyId);
		servizioImpl.setUserId(userId);

		if (userName == null) {
			servizioImpl.setUserName("");
		}
		else {
			servizioImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			servizioImpl.setCreateDate(null);
		}
		else {
			servizioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			servizioImpl.setModifiedDate(null);
		}
		else {
			servizioImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			servizioImpl.setNome("");
		}
		else {
			servizioImpl.setNome(nome);
		}

		if (descrizione == null) {
			servizioImpl.setDescrizione("");
		}
		else {
			servizioImpl.setDescrizione(descrizione);
		}

		if (descrizioneEstesa == null) {
			servizioImpl.setDescrizioneEstesa("");
		}
		else {
			servizioImpl.setDescrizioneEstesa(descrizioneEstesa);
		}

		if (codice == null) {
			servizioImpl.setCodice("");
		}
		else {
			servizioImpl.setCodice(codice);
		}

		if (uri == null) {
			servizioImpl.setUri("");
		}
		else {
			servizioImpl.setUri(uri);
		}

		if (uriGuest == null) {
			servizioImpl.setUriGuest("");
		}
		else {
			servizioImpl.setUriGuest(uriGuest);
		}

		if (uriScheda == null) {
			servizioImpl.setUriScheda("");
		}
		else {
			servizioImpl.setUriScheda(uriScheda);
		}

		servizioImpl.setAutenticazione(autenticazione);

		if (dataInizioAttivazione == Long.MIN_VALUE) {
			servizioImpl.setDataInizioAttivazione(null);
		}
		else {
			servizioImpl.setDataInizioAttivazione(
				new Date(dataInizioAttivazione));
		}

		if (dataFineAttivazione == Long.MIN_VALUE) {
			servizioImpl.setDataFineAttivazione(null);
		}
		else {
			servizioImpl.setDataFineAttivazione(new Date(dataFineAttivazione));
		}

		servizioImpl.setCittadino(cittadino);
		servizioImpl.setAzienda(azienda);
		servizioImpl.setDelega(delega);
		servizioImpl.setChatbot(chatbot);
		servizioImpl.setGestioneBackoffice(gestioneBackoffice);
		servizioImpl.setPrenotabile(prenotabile);

		if (codicePrestazioneINPS == null) {
			servizioImpl.setCodicePrestazioneINPS("");
		}
		else {
			servizioImpl.setCodicePrestazioneINPS(codicePrestazioneINPS);
		}

		servizioImpl.setPrivacyDelega(privacyDelega);
		servizioImpl.setAllegatoDelega(allegatoDelega);
		servizioImpl.setTimbroCertificato(timbroCertificato);
		servizioImpl.setAttivo(attivo);
		servizioImpl.setAreaTematicaId(areaTematicaId);

		servizioImpl.resetOriginalValues();

		return servizioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		servizioId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		descrizioneEstesa = objectInput.readUTF();
		codice = objectInput.readUTF();
		uri = objectInput.readUTF();
		uriGuest = objectInput.readUTF();
		uriScheda = objectInput.readUTF();

		autenticazione = objectInput.readBoolean();
		dataInizioAttivazione = objectInput.readLong();
		dataFineAttivazione = objectInput.readLong();

		cittadino = objectInput.readBoolean();

		azienda = objectInput.readBoolean();

		delega = objectInput.readBoolean();

		chatbot = objectInput.readBoolean();

		gestioneBackoffice = objectInput.readBoolean();

		prenotabile = objectInput.readBoolean();
		codicePrestazioneINPS = objectInput.readUTF();

		privacyDelega = objectInput.readBoolean();

		allegatoDelega = objectInput.readBoolean();

		timbroCertificato = objectInput.readBoolean();

		attivo = objectInput.readBoolean();

		areaTematicaId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(servizioId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (descrizioneEstesa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizioneEstesa);
		}

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}

		if (uri == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uri);
		}

		if (uriGuest == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uriGuest);
		}

		if (uriScheda == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uriScheda);
		}

		objectOutput.writeBoolean(autenticazione);
		objectOutput.writeLong(dataInizioAttivazione);
		objectOutput.writeLong(dataFineAttivazione);

		objectOutput.writeBoolean(cittadino);

		objectOutput.writeBoolean(azienda);

		objectOutput.writeBoolean(delega);

		objectOutput.writeBoolean(chatbot);

		objectOutput.writeBoolean(gestioneBackoffice);

		objectOutput.writeBoolean(prenotabile);

		if (codicePrestazioneINPS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codicePrestazioneINPS);
		}

		objectOutput.writeBoolean(privacyDelega);

		objectOutput.writeBoolean(allegatoDelega);

		objectOutput.writeBoolean(timbroCertificato);

		objectOutput.writeBoolean(attivo);

		objectOutput.writeLong(areaTematicaId);
	}

	public String uuid;
	public long servizioId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descrizione;
	public String descrizioneEstesa;
	public String codice;
	public String uri;
	public String uriGuest;
	public String uriScheda;
	public boolean autenticazione;
	public long dataInizioAttivazione;
	public long dataFineAttivazione;
	public boolean cittadino;
	public boolean azienda;
	public boolean delega;
	public boolean chatbot;
	public boolean gestioneBackoffice;
	public boolean prenotabile;
	public String codicePrestazioneINPS;
	public boolean privacyDelega;
	public boolean allegatoDelega;
	public boolean timbroCertificato;
	public boolean attivo;
	public long areaTematicaId;

}