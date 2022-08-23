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

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UtenteOrganizzazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UtenteOrganizzazioneCacheModel
	implements CacheModel<UtenteOrganizzazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UtenteOrganizzazioneCacheModel)) {
			return false;
		}

		UtenteOrganizzazioneCacheModel utenteOrganizzazioneCacheModel =
			(UtenteOrganizzazioneCacheModel)object;

		if (utenteOrganizzazionePK.equals(
				utenteOrganizzazioneCacheModel.utenteOrganizzazionePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, utenteOrganizzazionePK);
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
		sb.append(", preferito=");
		sb.append(preferito);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UtenteOrganizzazione toEntityModel() {
		UtenteOrganizzazioneImpl utenteOrganizzazioneImpl =
			new UtenteOrganizzazioneImpl();

		if (uuid == null) {
			utenteOrganizzazioneImpl.setUuid("");
		}
		else {
			utenteOrganizzazioneImpl.setUuid(uuid);
		}

		utenteOrganizzazioneImpl.setUtenteId(utenteId);
		utenteOrganizzazioneImpl.setOrganizationId(organizationId);
		utenteOrganizzazioneImpl.setGroupId(groupId);
		utenteOrganizzazioneImpl.setCompanyId(companyId);
		utenteOrganizzazioneImpl.setUserId(userId);

		if (userName == null) {
			utenteOrganizzazioneImpl.setUserName("");
		}
		else {
			utenteOrganizzazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			utenteOrganizzazioneImpl.setCreateDate(null);
		}
		else {
			utenteOrganizzazioneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			utenteOrganizzazioneImpl.setModifiedDate(null);
		}
		else {
			utenteOrganizzazioneImpl.setModifiedDate(new Date(modifiedDate));
		}

		utenteOrganizzazioneImpl.setPreferito(preferito);

		utenteOrganizzazioneImpl.resetOriginalValues();

		return utenteOrganizzazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		utenteId = objectInput.readLong();

		organizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		preferito = objectInput.readBoolean();

		utenteOrganizzazionePK = new UtenteOrganizzazionePK(
			utenteId, organizationId);
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

		objectOutput.writeBoolean(preferito);
	}

	public String uuid;
	public long utenteId;
	public long organizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean preferito;
	public transient UtenteOrganizzazionePK utenteOrganizzazionePK;

}