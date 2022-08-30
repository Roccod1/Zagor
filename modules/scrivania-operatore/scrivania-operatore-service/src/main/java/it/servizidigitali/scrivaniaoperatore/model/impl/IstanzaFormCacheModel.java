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

import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IstanzaForm in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IstanzaFormCacheModel
	implements CacheModel<IstanzaForm>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IstanzaFormCacheModel)) {
			return false;
		}

		IstanzaFormCacheModel istanzaFormCacheModel =
			(IstanzaFormCacheModel)object;

		if (istanzaFormId == istanzaFormCacheModel.istanzaFormId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, istanzaFormId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", istanzaFormId=");
		sb.append(istanzaFormId);
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
		sb.append(", json=");
		sb.append(json);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IstanzaForm toEntityModel() {
		IstanzaFormImpl istanzaFormImpl = new IstanzaFormImpl();

		if (uuid == null) {
			istanzaFormImpl.setUuid("");
		}
		else {
			istanzaFormImpl.setUuid(uuid);
		}

		istanzaFormImpl.setIstanzaFormId(istanzaFormId);
		istanzaFormImpl.setGroupId(groupId);
		istanzaFormImpl.setCompanyId(companyId);
		istanzaFormImpl.setUserId(userId);

		if (userName == null) {
			istanzaFormImpl.setUserName("");
		}
		else {
			istanzaFormImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			istanzaFormImpl.setCreateDate(null);
		}
		else {
			istanzaFormImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			istanzaFormImpl.setModifiedDate(null);
		}
		else {
			istanzaFormImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (json == null) {
			istanzaFormImpl.setJson("");
		}
		else {
			istanzaFormImpl.setJson(json);
		}

		istanzaFormImpl.setFormId(formId);
		istanzaFormImpl.setRichiestaId(richiestaId);

		istanzaFormImpl.resetOriginalValues();

		return istanzaFormImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		istanzaFormId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		json = objectInput.readUTF();

		formId = objectInput.readLong();

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

		objectOutput.writeLong(istanzaFormId);

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

		if (json == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json);
		}

		objectOutput.writeLong(formId);

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long istanzaFormId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String json;
	public long formId;
	public long richiestaId;

}