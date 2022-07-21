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

package it.servizidigitali.scrivaniaoperatore.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Richiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiestaCacheModel
	implements CacheModel<Richiesta>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RichiestaCacheModel)) {
			return false;
		}

		RichiestaCacheModel richiestaCacheModel = (RichiestaCacheModel)object;

		if (richiestaId == richiestaCacheModel.richiestaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, richiestaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
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
		sb.append(", codiceFiscale=");
		sb.append(codiceFiscale);
		sb.append(", partitaIva=");
		sb.append(partitaIva);
		sb.append(", email=");
		sb.append(email);
		sb.append(", codiceFiscaleDelegato=");
		sb.append(codiceFiscaleDelegato);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", numeroProtocollo=");
		sb.append(numeroProtocollo);
		sb.append(", dataProtocollo=");
		sb.append(dataProtocollo);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append(", note=");
		sb.append(note);
		sb.append(", invioGuest=");
		sb.append(invioGuest);
		sb.append(", tokenVisualizzazione=");
		sb.append(tokenVisualizzazione);
		sb.append(", chiaveAssociazioneBackoffice=");
		sb.append(chiaveAssociazioneBackoffice);
		sb.append(", delegaId=");
		sb.append(delegaId);
		sb.append(", proceduraId=");
		sb.append(proceduraId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Richiesta toEntityModel() {
		RichiestaImpl richiestaImpl = new RichiestaImpl();

		if (uuid == null) {
			richiestaImpl.setUuid("");
		}
		else {
			richiestaImpl.setUuid(uuid);
		}

		richiestaImpl.setRichiestaId(richiestaId);
		richiestaImpl.setGroupId(groupId);
		richiestaImpl.setCompanyId(companyId);
		richiestaImpl.setUserId(userId);

		if (userName == null) {
			richiestaImpl.setUserName("");
		}
		else {
			richiestaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			richiestaImpl.setCreateDate(null);
		}
		else {
			richiestaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			richiestaImpl.setModifiedDate(null);
		}
		else {
			richiestaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (codiceFiscale == null) {
			richiestaImpl.setCodiceFiscale("");
		}
		else {
			richiestaImpl.setCodiceFiscale(codiceFiscale);
		}

		if (partitaIva == null) {
			richiestaImpl.setPartitaIva("");
		}
		else {
			richiestaImpl.setPartitaIva(partitaIva);
		}

		if (email == null) {
			richiestaImpl.setEmail("");
		}
		else {
			richiestaImpl.setEmail(email);
		}

		if (codiceFiscaleDelegato == null) {
			richiestaImpl.setCodiceFiscaleDelegato("");
		}
		else {
			richiestaImpl.setCodiceFiscaleDelegato(codiceFiscaleDelegato);
		}

		if (stato == null) {
			richiestaImpl.setStato("");
		}
		else {
			richiestaImpl.setStato(stato);
		}

		if (numeroProtocollo == null) {
			richiestaImpl.setNumeroProtocollo("");
		}
		else {
			richiestaImpl.setNumeroProtocollo(numeroProtocollo);
		}

		if (dataProtocollo == Long.MIN_VALUE) {
			richiestaImpl.setDataProtocollo(null);
		}
		else {
			richiestaImpl.setDataProtocollo(new Date(dataProtocollo));
		}

		if (oggetto == null) {
			richiestaImpl.setOggetto("");
		}
		else {
			richiestaImpl.setOggetto(oggetto);
		}

		if (note == null) {
			richiestaImpl.setNote("");
		}
		else {
			richiestaImpl.setNote(note);
		}

		richiestaImpl.setInvioGuest(invioGuest);

		if (tokenVisualizzazione == null) {
			richiestaImpl.setTokenVisualizzazione("");
		}
		else {
			richiestaImpl.setTokenVisualizzazione(tokenVisualizzazione);
		}

		if (chiaveAssociazioneBackoffice == null) {
			richiestaImpl.setChiaveAssociazioneBackoffice("");
		}
		else {
			richiestaImpl.setChiaveAssociazioneBackoffice(
				chiaveAssociazioneBackoffice);
		}

		richiestaImpl.setDelegaId(delegaId);
		richiestaImpl.setProceduraId(proceduraId);

		richiestaImpl.resetOriginalValues();

		return richiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		richiestaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		codiceFiscale = objectInput.readUTF();
		partitaIva = objectInput.readUTF();
		email = objectInput.readUTF();
		codiceFiscaleDelegato = objectInput.readUTF();
		stato = objectInput.readUTF();
		numeroProtocollo = objectInput.readUTF();
		dataProtocollo = objectInput.readLong();
		oggetto = objectInput.readUTF();
		note = objectInput.readUTF();

		invioGuest = objectInput.readBoolean();
		tokenVisualizzazione = objectInput.readUTF();
		chiaveAssociazioneBackoffice = objectInput.readUTF();

		delegaId = objectInput.readLong();

		proceduraId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(richiestaId);

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

		if (codiceFiscale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceFiscale);
		}

		if (partitaIva == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(partitaIva);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (codiceFiscaleDelegato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceFiscaleDelegato);
		}

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		if (numeroProtocollo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numeroProtocollo);
		}

		objectOutput.writeLong(dataProtocollo);

		if (oggetto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oggetto);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeBoolean(invioGuest);

		if (tokenVisualizzazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tokenVisualizzazione);
		}

		if (chiaveAssociazioneBackoffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chiaveAssociazioneBackoffice);
		}

		objectOutput.writeLong(delegaId);

		objectOutput.writeLong(proceduraId);
	}

	public String uuid;
	public long richiestaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String codiceFiscale;
	public String partitaIva;
	public String email;
	public String codiceFiscaleDelegato;
	public String stato;
	public String numeroProtocollo;
	public long dataProtocollo;
	public String oggetto;
	public String note;
	public boolean invioGuest;
	public String tokenVisualizzazione;
	public String chiaveAssociazioneBackoffice;
	public long delegaId;
	public long proceduraId;

}