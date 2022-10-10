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

import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AllegatoRichiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AllegatoRichiestaCacheModel
	implements CacheModel<AllegatoRichiesta>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AllegatoRichiestaCacheModel)) {
			return false;
		}

		AllegatoRichiestaCacheModel allegatoRichiestaCacheModel =
			(AllegatoRichiestaCacheModel)object;

		if (allegatoRichiestaId ==
				allegatoRichiestaCacheModel.allegatoRichiestaId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allegatoRichiestaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allegatoRichiestaId=");
		sb.append(allegatoRichiestaId);
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
		sb.append(", idDocumentale=");
		sb.append(idDocumentale);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", url=");
		sb.append(url);
		sb.append(", principale=");
		sb.append(principale);
		sb.append(", interno=");
		sb.append(interno);
		sb.append(", visibile=");
		sb.append(visibile);
		sb.append(", definizioneAllegatoId=");
		sb.append(definizioneAllegatoId);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AllegatoRichiesta toEntityModel() {
		AllegatoRichiestaImpl allegatoRichiestaImpl =
			new AllegatoRichiestaImpl();

		if (uuid == null) {
			allegatoRichiestaImpl.setUuid("");
		}
		else {
			allegatoRichiestaImpl.setUuid(uuid);
		}

		allegatoRichiestaImpl.setAllegatoRichiestaId(allegatoRichiestaId);
		allegatoRichiestaImpl.setGroupId(groupId);
		allegatoRichiestaImpl.setCompanyId(companyId);
		allegatoRichiestaImpl.setUserId(userId);

		if (userName == null) {
			allegatoRichiestaImpl.setUserName("");
		}
		else {
			allegatoRichiestaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			allegatoRichiestaImpl.setCreateDate(null);
		}
		else {
			allegatoRichiestaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allegatoRichiestaImpl.setModifiedDate(null);
		}
		else {
			allegatoRichiestaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (idDocumentale == null) {
			allegatoRichiestaImpl.setIdDocumentale("");
		}
		else {
			allegatoRichiestaImpl.setIdDocumentale(idDocumentale);
		}

		if (nome == null) {
			allegatoRichiestaImpl.setNome("");
		}
		else {
			allegatoRichiestaImpl.setNome(nome);
		}

		if (titolo == null) {
			allegatoRichiestaImpl.setTitolo("");
		}
		else {
			allegatoRichiestaImpl.setTitolo(titolo);
		}

		if (descrizione == null) {
			allegatoRichiestaImpl.setDescrizione("");
		}
		else {
			allegatoRichiestaImpl.setDescrizione(descrizione);
		}

		if (url == null) {
			allegatoRichiestaImpl.setUrl("");
		}
		else {
			allegatoRichiestaImpl.setUrl(url);
		}

		allegatoRichiestaImpl.setPrincipale(principale);
		allegatoRichiestaImpl.setInterno(interno);
		allegatoRichiestaImpl.setVisibile(visibile);
		allegatoRichiestaImpl.setDefinizioneAllegatoId(definizioneAllegatoId);
		allegatoRichiestaImpl.setRichiestaId(richiestaId);

		allegatoRichiestaImpl.resetOriginalValues();

		return allegatoRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allegatoRichiestaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		idDocumentale = objectInput.readUTF();
		nome = objectInput.readUTF();
		titolo = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		url = objectInput.readUTF();

		principale = objectInput.readBoolean();

		interno = objectInput.readBoolean();

		visibile = objectInput.readBoolean();

		definizioneAllegatoId = objectInput.readLong();

		richiestaId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(allegatoRichiestaId);

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

		if (idDocumentale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idDocumentale);
		}

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(principale);

		objectOutput.writeBoolean(interno);

		objectOutput.writeBoolean(visibile);

		objectOutput.writeLong(definizioneAllegatoId);

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long allegatoRichiestaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String idDocumentale;
	public String nome;
	public String titolo;
	public String descrizione;
	public String url;
	public boolean principale;
	public boolean interno;
	public boolean visibile;
	public long definizioneAllegatoId;
	public long richiestaId;

}