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

package it.servizidigitali.gestioneprocedure.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TemplatePdf in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TemplatePdfCacheModel
	implements CacheModel<TemplatePdf>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TemplatePdfCacheModel)) {
			return false;
		}

		TemplatePdfCacheModel templatePdfCacheModel =
			(TemplatePdfCacheModel)object;

		if (templatePdfId == templatePdfCacheModel.templatePdfId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, templatePdfId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", templatePdfId=");
		sb.append(templatePdfId);
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
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append(", proceduraId=");
		sb.append(proceduraId);
		sb.append(", templatePdfParentId=");
		sb.append(templatePdfParentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TemplatePdf toEntityModel() {
		TemplatePdfImpl templatePdfImpl = new TemplatePdfImpl();

		if (uuid == null) {
			templatePdfImpl.setUuid("");
		}
		else {
			templatePdfImpl.setUuid(uuid);
		}

		templatePdfImpl.setTemplatePdfId(templatePdfId);
		templatePdfImpl.setCompanyId(companyId);
		templatePdfImpl.setUserId(userId);

		if (userName == null) {
			templatePdfImpl.setUserName("");
		}
		else {
			templatePdfImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			templatePdfImpl.setCreateDate(null);
		}
		else {
			templatePdfImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			templatePdfImpl.setModifiedDate(null);
		}
		else {
			templatePdfImpl.setModifiedDate(new Date(modifiedDate));
		}

		templatePdfImpl.setFileEntryId(fileEntryId);
		templatePdfImpl.setAttivo(attivo);
		templatePdfImpl.setProceduraId(proceduraId);
		templatePdfImpl.setTemplatePdfParentId(templatePdfParentId);

		templatePdfImpl.resetOriginalValues();

		return templatePdfImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		templatePdfId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fileEntryId = objectInput.readLong();

		attivo = objectInput.readBoolean();

		proceduraId = objectInput.readLong();

		templatePdfParentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(templatePdfId);

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

		objectOutput.writeLong(fileEntryId);

		objectOutput.writeBoolean(attivo);

		objectOutput.writeLong(proceduraId);

		objectOutput.writeLong(templatePdfParentId);
	}

	public String uuid;
	public long templatePdfId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fileEntryId;
	public boolean attivo;
	public long proceduraId;
	public long templatePdfParentId;

}