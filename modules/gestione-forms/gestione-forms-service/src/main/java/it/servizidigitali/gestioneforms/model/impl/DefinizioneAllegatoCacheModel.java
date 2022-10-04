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

package it.servizidigitali.gestioneforms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DefinizioneAllegato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DefinizioneAllegatoCacheModel
	implements CacheModel<DefinizioneAllegato>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DefinizioneAllegatoCacheModel)) {
			return false;
		}

		DefinizioneAllegatoCacheModel definizioneAllegatoCacheModel =
			(DefinizioneAllegatoCacheModel)object;

		if (definizioneAllegatoId ==
				definizioneAllegatoCacheModel.definizioneAllegatoId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, definizioneAllegatoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", definizioneAllegatoId=");
		sb.append(definizioneAllegatoId);
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
		sb.append(", denominazione=");
		sb.append(denominazione);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", filenameModello=");
		sb.append(filenameModello);
		sb.append(", tipiFileAmmessi=");
		sb.append(tipiFileAmmessi);
		sb.append(", codiciTipologiaDocumento=");
		sb.append(codiciTipologiaDocumento);
		sb.append(", obbligatorio=");
		sb.append(obbligatorio);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", formId=");
		sb.append(formId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DefinizioneAllegato toEntityModel() {
		DefinizioneAllegatoImpl definizioneAllegatoImpl =
			new DefinizioneAllegatoImpl();

		if (uuid == null) {
			definizioneAllegatoImpl.setUuid("");
		}
		else {
			definizioneAllegatoImpl.setUuid(uuid);
		}

		definizioneAllegatoImpl.setDefinizioneAllegatoId(definizioneAllegatoId);
		definizioneAllegatoImpl.setGroupId(groupId);
		definizioneAllegatoImpl.setCompanyId(companyId);
		definizioneAllegatoImpl.setUserId(userId);

		if (userName == null) {
			definizioneAllegatoImpl.setUserName("");
		}
		else {
			definizioneAllegatoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			definizioneAllegatoImpl.setCreateDate(null);
		}
		else {
			definizioneAllegatoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			definizioneAllegatoImpl.setModifiedDate(null);
		}
		else {
			definizioneAllegatoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (denominazione == null) {
			definizioneAllegatoImpl.setDenominazione("");
		}
		else {
			definizioneAllegatoImpl.setDenominazione(denominazione);
		}

		definizioneAllegatoImpl.setFileEntryId(fileEntryId);

		if (filenameModello == null) {
			definizioneAllegatoImpl.setFilenameModello("");
		}
		else {
			definizioneAllegatoImpl.setFilenameModello(filenameModello);
		}

		if (tipiFileAmmessi == null) {
			definizioneAllegatoImpl.setTipiFileAmmessi("");
		}
		else {
			definizioneAllegatoImpl.setTipiFileAmmessi(tipiFileAmmessi);
		}

		if (codiciTipologiaDocumento == null) {
			definizioneAllegatoImpl.setCodiciTipologiaDocumento("");
		}
		else {
			definizioneAllegatoImpl.setCodiciTipologiaDocumento(
				codiciTipologiaDocumento);
		}

		definizioneAllegatoImpl.setObbligatorio(obbligatorio);
		definizioneAllegatoImpl.setOrganizationId(organizationId);
		definizioneAllegatoImpl.setFormId(formId);

		definizioneAllegatoImpl.resetOriginalValues();

		return definizioneAllegatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		definizioneAllegatoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		denominazione = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
		filenameModello = objectInput.readUTF();
		tipiFileAmmessi = objectInput.readUTF();
		codiciTipologiaDocumento = objectInput.readUTF();

		obbligatorio = objectInput.readBoolean();

		organizationId = objectInput.readLong();

		formId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(definizioneAllegatoId);

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

		if (denominazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazione);
		}

		objectOutput.writeLong(fileEntryId);

		if (filenameModello == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filenameModello);
		}

		if (tipiFileAmmessi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipiFileAmmessi);
		}

		if (codiciTipologiaDocumento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiciTipologiaDocumento);
		}

		objectOutput.writeBoolean(obbligatorio);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(formId);
	}

	public String uuid;
	public long definizioneAllegatoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String denominazione;
	public long fileEntryId;
	public String filenameModello;
	public String tipiFileAmmessi;
	public String codiciTipologiaDocumento;
	public boolean obbligatorio;
	public long organizationId;
	public long formId;

}