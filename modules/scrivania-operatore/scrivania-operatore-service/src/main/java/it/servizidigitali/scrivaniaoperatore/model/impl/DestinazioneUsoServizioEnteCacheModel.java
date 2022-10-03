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

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoServizioEntePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DestinazioneUsoServizioEnte in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DestinazioneUsoServizioEnteCacheModel
	implements CacheModel<DestinazioneUsoServizioEnte>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DestinazioneUsoServizioEnteCacheModel)) {
			return false;
		}

		DestinazioneUsoServizioEnteCacheModel
			destinazioneUsoServizioEnteCacheModel =
				(DestinazioneUsoServizioEnteCacheModel)object;

		if (destinazioneUsoServizioEntePK.equals(
				destinazioneUsoServizioEnteCacheModel.
					destinazioneUsoServizioEntePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, destinazioneUsoServizioEntePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", destinazioneUsoId=");
		sb.append(destinazioneUsoId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DestinazioneUsoServizioEnte toEntityModel() {
		DestinazioneUsoServizioEnteImpl destinazioneUsoServizioEnteImpl =
			new DestinazioneUsoServizioEnteImpl();

		if (uuid == null) {
			destinazioneUsoServizioEnteImpl.setUuid("");
		}
		else {
			destinazioneUsoServizioEnteImpl.setUuid(uuid);
		}

		destinazioneUsoServizioEnteImpl.setDestinazioneUsoId(destinazioneUsoId);
		destinazioneUsoServizioEnteImpl.setServizioId(servizioId);
		destinazioneUsoServizioEnteImpl.setOrganizationId(organizationId);
		destinazioneUsoServizioEnteImpl.setGroupId(groupId);
		destinazioneUsoServizioEnteImpl.setCompanyId(companyId);
		destinazioneUsoServizioEnteImpl.setUserId(userId);

		if (userName == null) {
			destinazioneUsoServizioEnteImpl.setUserName("");
		}
		else {
			destinazioneUsoServizioEnteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			destinazioneUsoServizioEnteImpl.setCreateDate(null);
		}
		else {
			destinazioneUsoServizioEnteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			destinazioneUsoServizioEnteImpl.setModifiedDate(null);
		}
		else {
			destinazioneUsoServizioEnteImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		destinazioneUsoServizioEnteImpl.resetOriginalValues();

		return destinazioneUsoServizioEnteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		destinazioneUsoId = objectInput.readLong();

		servizioId = objectInput.readLong();

		organizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		destinazioneUsoServizioEntePK = new DestinazioneUsoServizioEntePK(
			destinazioneUsoId, servizioId, organizationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(destinazioneUsoId);

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
	}

	public String uuid;
	public long destinazioneUsoId;
	public long servizioId;
	public long organizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public transient DestinazioneUsoServizioEntePK
		destinazioneUsoServizioEntePK;

}