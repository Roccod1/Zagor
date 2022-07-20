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

package it.servizidigitali.profiloutente.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazionePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UtenteOrganizzazioneCanaleComunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UtenteOrganizzazioneCanaleComunicazioneCacheModel
	implements CacheModel<UtenteOrganizzazioneCanaleComunicazione>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				UtenteOrganizzazioneCanaleComunicazioneCacheModel)) {

			return false;
		}

		UtenteOrganizzazioneCanaleComunicazioneCacheModel
			utenteOrganizzazioneCanaleComunicazioneCacheModel =
				(UtenteOrganizzazioneCanaleComunicazioneCacheModel)object;

		if (utenteOrganizzazioneCanaleComunicazionePK.equals(
				utenteOrganizzazioneCanaleComunicazioneCacheModel.
					utenteOrganizzazioneCanaleComunicazionePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, utenteOrganizzazioneCanaleComunicazionePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", utenteId=");
		sb.append(utenteId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", canaleComunicazioneId=");
		sb.append(canaleComunicazioneId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UtenteOrganizzazioneCanaleComunicazione toEntityModel() {
		UtenteOrganizzazioneCanaleComunicazioneImpl
			utenteOrganizzazioneCanaleComunicazioneImpl =
				new UtenteOrganizzazioneCanaleComunicazioneImpl();

		if (uuid == null) {
			utenteOrganizzazioneCanaleComunicazioneImpl.setUuid("");
		}
		else {
			utenteOrganizzazioneCanaleComunicazioneImpl.setUuid(uuid);
		}

		utenteOrganizzazioneCanaleComunicazioneImpl.setUtenteId(utenteId);
		utenteOrganizzazioneCanaleComunicazioneImpl.setOrganizationId(
			organizationId);
		utenteOrganizzazioneCanaleComunicazioneImpl.setCanaleComunicazioneId(
			canaleComunicazioneId);
		utenteOrganizzazioneCanaleComunicazioneImpl.setGroupId(groupId);
		utenteOrganizzazioneCanaleComunicazioneImpl.setCompanyId(companyId);
		utenteOrganizzazioneCanaleComunicazioneImpl.setUserId(userId);

		if (userName == null) {
			utenteOrganizzazioneCanaleComunicazioneImpl.setUserName("");
		}
		else {
			utenteOrganizzazioneCanaleComunicazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			utenteOrganizzazioneCanaleComunicazioneImpl.setCreateDate(null);
		}
		else {
			utenteOrganizzazioneCanaleComunicazioneImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			utenteOrganizzazioneCanaleComunicazioneImpl.setModifiedDate(null);
		}
		else {
			utenteOrganizzazioneCanaleComunicazioneImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		utenteOrganizzazioneCanaleComunicazioneImpl.resetOriginalValues();

		return utenteOrganizzazioneCanaleComunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		utenteId = objectInput.readLong();

		organizationId = objectInput.readLong();

		canaleComunicazioneId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		utenteOrganizzazioneCanaleComunicazionePK =
			new UtenteOrganizzazioneCanaleComunicazionePK(
				utenteId, organizationId, canaleComunicazioneId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(utenteId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(canaleComunicazioneId);

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
	}

	public String uuid;
	public long utenteId;
	public long organizationId;
	public long canaleComunicazioneId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public transient UtenteOrganizzazioneCanaleComunicazionePK
		utenteOrganizzazioneCanaleComunicazionePK;

}