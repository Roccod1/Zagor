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

package it.servizidigitali.accreditamentoenti.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.accreditamentoenti.model.ResponsabileEnte;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResponsabileEnte in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResponsabileEnteCacheModel
	implements CacheModel<ResponsabileEnte>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResponsabileEnteCacheModel)) {
			return false;
		}

		ResponsabileEnteCacheModel responsabileEnteCacheModel =
			(ResponsabileEnteCacheModel)object;

		if (responsabileEnteId ==
				responsabileEnteCacheModel.responsabileEnteId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, responsabileEnteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", responsabileEnteId=");
		sb.append(responsabileEnteId);
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
		sb.append(", responsabileUserId=");
		sb.append(responsabileUserId);
		sb.append(", enteId=");
		sb.append(enteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResponsabileEnte toEntityModel() {
		ResponsabileEnteImpl responsabileEnteImpl = new ResponsabileEnteImpl();

		if (uuid == null) {
			responsabileEnteImpl.setUuid("");
		}
		else {
			responsabileEnteImpl.setUuid(uuid);
		}

		responsabileEnteImpl.setResponsabileEnteId(responsabileEnteId);
		responsabileEnteImpl.setGroupId(groupId);
		responsabileEnteImpl.setCompanyId(companyId);
		responsabileEnteImpl.setUserId(userId);

		if (userName == null) {
			responsabileEnteImpl.setUserName("");
		}
		else {
			responsabileEnteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			responsabileEnteImpl.setCreateDate(null);
		}
		else {
			responsabileEnteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			responsabileEnteImpl.setModifiedDate(null);
		}
		else {
			responsabileEnteImpl.setModifiedDate(new Date(modifiedDate));
		}

		responsabileEnteImpl.setResponsabileUserId(responsabileUserId);
		responsabileEnteImpl.setEnteId(enteId);

		responsabileEnteImpl.resetOriginalValues();

		return responsabileEnteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		responsabileEnteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		responsabileUserId = objectInput.readLong();

		enteId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(responsabileEnteId);

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

		objectOutput.writeLong(responsabileUserId);

		objectOutput.writeLong(enteId);
	}

	public String uuid;
	public long responsabileEnteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long responsabileUserId;
	public long enteId;

}