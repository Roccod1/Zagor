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

import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttivitaRichiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttivitaRichiestaCacheModel
	implements CacheModel<AttivitaRichiesta>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttivitaRichiestaCacheModel)) {
			return false;
		}

		AttivitaRichiestaCacheModel attivitaRichiestaCacheModel =
			(AttivitaRichiestaCacheModel)object;

		if (attivitaRichiestaId ==
				attivitaRichiestaCacheModel.attivitaRichiestaId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attivitaRichiestaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", attivitaRichiestaId=");
		sb.append(attivitaRichiestaId);
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
		sb.append(", note=");
		sb.append(note);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttivitaRichiesta toEntityModel() {
		AttivitaRichiestaImpl attivitaRichiestaImpl =
			new AttivitaRichiestaImpl();

		if (uuid == null) {
			attivitaRichiestaImpl.setUuid("");
		}
		else {
			attivitaRichiestaImpl.setUuid(uuid);
		}

		attivitaRichiestaImpl.setAttivitaRichiestaId(attivitaRichiestaId);
		attivitaRichiestaImpl.setGroupId(groupId);
		attivitaRichiestaImpl.setCompanyId(companyId);
		attivitaRichiestaImpl.setUserId(userId);

		if (userName == null) {
			attivitaRichiestaImpl.setUserName("");
		}
		else {
			attivitaRichiestaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			attivitaRichiestaImpl.setCreateDate(null);
		}
		else {
			attivitaRichiestaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			attivitaRichiestaImpl.setModifiedDate(null);
		}
		else {
			attivitaRichiestaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (note == null) {
			attivitaRichiestaImpl.setNote("");
		}
		else {
			attivitaRichiestaImpl.setNote(note);
		}

		if (stato == null) {
			attivitaRichiestaImpl.setStato("");
		}
		else {
			attivitaRichiestaImpl.setStato(stato);
		}

		attivitaRichiestaImpl.setRichiestaId(richiestaId);

		attivitaRichiestaImpl.resetOriginalValues();

		return attivitaRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		attivitaRichiestaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		note = objectInput.readUTF();
		stato = objectInput.readUTF();

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

		objectOutput.writeLong(attivitaRichiestaId);

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

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long attivitaRichiestaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String note;
	public String stato;
	public long richiestaId;

}