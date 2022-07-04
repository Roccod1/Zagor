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

import it.servizidigitali.gestioneenti.model.EnteServizio;
import it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EnteServizio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EnteServizioCacheModel
	implements CacheModel<EnteServizio>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EnteServizioCacheModel)) {
			return false;
		}

		EnteServizioCacheModel enteServizioCacheModel =
			(EnteServizioCacheModel)object;

		if (enteServizioPK.equals(enteServizioCacheModel.enteServizioPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, enteServizioPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", organizationId=");
		sb.append(organizationId);
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
	public EnteServizio toEntityModel() {
		EnteServizioImpl enteServizioImpl = new EnteServizioImpl();

		if (uuid == null) {
			enteServizioImpl.setUuid("");
		}
		else {
			enteServizioImpl.setUuid(uuid);
		}

		enteServizioImpl.setOrganizationId(organizationId);
		enteServizioImpl.setServizioId(servizioId);
		enteServizioImpl.setGroupId(groupId);
		enteServizioImpl.setCompanyId(companyId);
		enteServizioImpl.setUserId(userId);

		if (userName == null) {
			enteServizioImpl.setUserName("");
		}
		else {
			enteServizioImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			enteServizioImpl.setCreateDate(null);
		}
		else {
			enteServizioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enteServizioImpl.setModifiedDate(null);
		}
		else {
			enteServizioImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uri == null) {
			enteServizioImpl.setUri("");
		}
		else {
			enteServizioImpl.setUri(uri);
		}

		if (uriGuest == null) {
			enteServizioImpl.setUriGuest("");
		}
		else {
			enteServizioImpl.setUriGuest(uriGuest);
		}

		if (uriScheda == null) {
			enteServizioImpl.setUriScheda("");
		}
		else {
			enteServizioImpl.setUriScheda(uriScheda);
		}

		enteServizioImpl.setAutenticazione(autenticazione);

		if (dataInizioAttivazione == Long.MIN_VALUE) {
			enteServizioImpl.setDataInizioAttivazione(null);
		}
		else {
			enteServizioImpl.setDataInizioAttivazione(
				new Date(dataInizioAttivazione));
		}

		if (dataFineAttivazione == Long.MIN_VALUE) {
			enteServizioImpl.setDataFineAttivazione(null);
		}
		else {
			enteServizioImpl.setDataFineAttivazione(
				new Date(dataFineAttivazione));
		}

		enteServizioImpl.setCittadino(cittadino);
		enteServizioImpl.setAzienda(azienda);
		enteServizioImpl.setDelega(delega);
		enteServizioImpl.setChatbot(chatbot);
		enteServizioImpl.setPrenotabile(prenotabile);
		enteServizioImpl.setPrivacyDelega(privacyDelega);
		enteServizioImpl.setAllegatoDelega(allegatoDelega);
		enteServizioImpl.setTimbroCertificato(timbroCertificato);
		enteServizioImpl.setIseeInps(iseeInps);
		enteServizioImpl.setAttivo(attivo);

		enteServizioImpl.resetOriginalValues();

		return enteServizioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		organizationId = objectInput.readLong();

		servizioId = objectInput.readLong();

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

		enteServizioPK = new EnteServizioPK(organizationId, servizioId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(organizationId);

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
	public long organizationId;
	public long servizioId;
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
	public transient EnteServizioPK enteServizioPK;

}