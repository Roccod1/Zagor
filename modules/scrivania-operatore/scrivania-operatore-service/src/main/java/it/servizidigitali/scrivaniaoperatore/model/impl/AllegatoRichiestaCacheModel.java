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
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPK;

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

		if (allegatoRichiestaPK.equals(
				allegatoRichiestaCacheModel.allegatoRichiestaPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allegatoRichiestaPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
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
		sb.append(", idDocumentale=");
		sb.append(idDocumentale);
		sb.append(", url=");
		sb.append(url);
		sb.append(", principale=");
		sb.append(principale);
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

		allegatoRichiestaImpl.setRichiestaId(richiestaId);
		allegatoRichiestaImpl.setFileEntryId(fileEntryId);
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

		if (nome == null) {
			allegatoRichiestaImpl.setNome("");
		}
		else {
			allegatoRichiestaImpl.setNome(nome);
		}

		if (idDocumentale == null) {
			allegatoRichiestaImpl.setIdDocumentale("");
		}
		else {
			allegatoRichiestaImpl.setIdDocumentale(idDocumentale);
		}

		if (url == null) {
			allegatoRichiestaImpl.setUrl("");
		}
		else {
			allegatoRichiestaImpl.setUrl(url);
		}

		allegatoRichiestaImpl.setPrincipale(principale);

		allegatoRichiestaImpl.resetOriginalValues();

		return allegatoRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		richiestaId = objectInput.readLong();

		fileEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		idDocumentale = objectInput.readUTF();
		url = objectInput.readUTF();

		principale = objectInput.readBoolean();

		allegatoRichiestaPK = new AllegatoRichiestaPK(richiestaId, fileEntryId);
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

		objectOutput.writeLong(fileEntryId);

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

		if (idDocumentale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idDocumentale);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(principale);
	}

	public String uuid;
	public long richiestaId;
	public long fileEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String idDocumentale;
	public String url;
	public boolean principale;
	public transient AllegatoRichiestaPK allegatoRichiestaPK;

}