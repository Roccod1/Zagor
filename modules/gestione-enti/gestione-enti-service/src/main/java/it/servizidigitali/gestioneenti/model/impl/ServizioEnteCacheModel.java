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

package it.servizidigitali.gestioneenti.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServizioEnte in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServizioEnteCacheModel
	implements CacheModel<ServizioEnte>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServizioEnteCacheModel)) {
			return false;
		}

		ServizioEnteCacheModel servizioEnteCacheModel =
			(ServizioEnteCacheModel)object;

		if (servizioEntePK.equals(servizioEnteCacheModel.servizioEntePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, servizioEntePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", servizioId=");
		sb.append(servizioId);
		sb.append(", organizationId=");
		sb.append(organizationId);
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
		sb.append(", prenotabile=");
		sb.append(prenotabile);
		sb.append(", privacyDelega=");
		sb.append(privacyDelega);
		sb.append(", allegatoDelega=");
		sb.append(allegatoDelega);
		sb.append(", timbroCertificato=");
		sb.append(timbroCertificato);
		sb.append(", iseeInps=");
		sb.append(iseeInps);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServizioEnte toEntityModel() {
		ServizioEnteImpl servizioEnteImpl = new ServizioEnteImpl();

		if (uuid == null) {
			servizioEnteImpl.setUuid("");
		}
		else {
			servizioEnteImpl.setUuid(uuid);
		}

		servizioEnteImpl.setServizioId(servizioId);
		servizioEnteImpl.setOrganizationId(organizationId);
		servizioEnteImpl.setGroupId(groupId);
		servizioEnteImpl.setCompanyId(companyId);
		servizioEnteImpl.setUserId(userId);

		if (userName == null) {
			servizioEnteImpl.setUserName("");
		}
		else {
			servizioEnteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			servizioEnteImpl.setCreateDate(null);
		}
		else {
			servizioEnteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			servizioEnteImpl.setModifiedDate(null);
		}
		else {
			servizioEnteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uri == null) {
			servizioEnteImpl.setUri("");
		}
		else {
			servizioEnteImpl.setUri(uri);
		}

		if (uriGuest == null) {
			servizioEnteImpl.setUriGuest("");
		}
		else {
			servizioEnteImpl.setUriGuest(uriGuest);
		}

		if (uriScheda == null) {
			servizioEnteImpl.setUriScheda("");
		}
		else {
			servizioEnteImpl.setUriScheda(uriScheda);
		}

		servizioEnteImpl.setAutenticazione(autenticazione);

		if (dataInizioAttivazione == Long.MIN_VALUE) {
			servizioEnteImpl.setDataInizioAttivazione(null);
		}
		else {
			servizioEnteImpl.setDataInizioAttivazione(
				new Date(dataInizioAttivazione));
		}

		if (dataFineAttivazione == Long.MIN_VALUE) {
			servizioEnteImpl.setDataFineAttivazione(null);
		}
		else {
			servizioEnteImpl.setDataFineAttivazione(
				new Date(dataFineAttivazione));
		}

		servizioEnteImpl.setCittadino(cittadino);
		servizioEnteImpl.setAzienda(azienda);
		servizioEnteImpl.setDelega(delega);
		servizioEnteImpl.setChatbot(chatbot);
		servizioEnteImpl.setPrenotabile(prenotabile);
		servizioEnteImpl.setPrivacyDelega(privacyDelega);
		servizioEnteImpl.setAllegatoDelega(allegatoDelega);
		servizioEnteImpl.setTimbroCertificato(timbroCertificato);
		servizioEnteImpl.setIseeInps(iseeInps);
		servizioEnteImpl.setAttivo(attivo);

		servizioEnteImpl.resetOriginalValues();

		return servizioEnteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		servizioId = objectInput.readLong();

		organizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		prenotabile = objectInput.readBoolean();

		privacyDelega = objectInput.readBoolean();

		allegatoDelega = objectInput.readBoolean();

		timbroCertificato = objectInput.readBoolean();

		iseeInps = objectInput.readBoolean();

		attivo = objectInput.readBoolean();

		servizioEntePK = new ServizioEntePK(servizioId, organizationId);
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

		objectOutput.writeLong(organizationId);

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

		objectOutput.writeBoolean(prenotabile);

		objectOutput.writeBoolean(privacyDelega);

		objectOutput.writeBoolean(allegatoDelega);

		objectOutput.writeBoolean(timbroCertificato);

		objectOutput.writeBoolean(iseeInps);

		objectOutput.writeBoolean(attivo);
	}

	public String uuid;
	public long servizioId;
	public long organizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
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
	public boolean prenotabile;
	public boolean privacyDelega;
	public boolean allegatoDelega;
	public boolean timbroCertificato;
	public boolean iseeInps;
	public boolean attivo;
	public transient ServizioEntePK servizioEntePK;

}