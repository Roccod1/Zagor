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

import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommentoRichiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommentoRichiestaCacheModel
	implements CacheModel<CommentoRichiesta>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommentoRichiestaCacheModel)) {
			return false;
		}

		CommentoRichiestaCacheModel commentoRichiestaCacheModel =
			(CommentoRichiestaCacheModel)object;

		if (commentoRichiestaId ==
				commentoRichiestaCacheModel.commentoRichiestaId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commentoRichiestaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", commentoRichiestaId=");
		sb.append(commentoRichiestaId);
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
		sb.append(", testo=");
		sb.append(testo);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", visibile=");
		sb.append(visibile);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommentoRichiesta toEntityModel() {
		CommentoRichiestaImpl commentoRichiestaImpl =
			new CommentoRichiestaImpl();

		if (uuid == null) {
			commentoRichiestaImpl.setUuid("");
		}
		else {
			commentoRichiestaImpl.setUuid(uuid);
		}

		commentoRichiestaImpl.setCommentoRichiestaId(commentoRichiestaId);
		commentoRichiestaImpl.setGroupId(groupId);
		commentoRichiestaImpl.setCompanyId(companyId);
		commentoRichiestaImpl.setUserId(userId);

		if (userName == null) {
			commentoRichiestaImpl.setUserName("");
		}
		else {
			commentoRichiestaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commentoRichiestaImpl.setCreateDate(null);
		}
		else {
			commentoRichiestaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commentoRichiestaImpl.setModifiedDate(null);
		}
		else {
			commentoRichiestaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (testo == null) {
			commentoRichiestaImpl.setTesto("");
		}
		else {
			commentoRichiestaImpl.setTesto(testo);
		}

		if (taskId == null) {
			commentoRichiestaImpl.setTaskId("");
		}
		else {
			commentoRichiestaImpl.setTaskId(taskId);
		}

		commentoRichiestaImpl.setVisibile(visibile);
		commentoRichiestaImpl.setRichiestaId(richiestaId);

		commentoRichiestaImpl.resetOriginalValues();

		return commentoRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		commentoRichiestaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		testo = objectInput.readUTF();
		taskId = objectInput.readUTF();

		visibile = objectInput.readBoolean();

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

		objectOutput.writeLong(commentoRichiestaId);

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

		if (testo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testo);
		}

		if (taskId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskId);
		}

		objectOutput.writeBoolean(visibile);

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long commentoRichiestaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String testo;
	public String taskId;
	public boolean visibile;
	public long richiestaId;

}