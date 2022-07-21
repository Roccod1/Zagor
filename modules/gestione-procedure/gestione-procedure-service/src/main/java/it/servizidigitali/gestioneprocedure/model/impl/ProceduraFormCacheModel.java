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

import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProceduraForm in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProceduraFormCacheModel
	implements CacheModel<ProceduraForm>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProceduraFormCacheModel)) {
			return false;
		}

		ProceduraFormCacheModel proceduraFormCacheModel =
			(ProceduraFormCacheModel)object;

		if (proceduraFormPK.equals(proceduraFormCacheModel.proceduraFormPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proceduraFormPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", proceduraId=");
		sb.append(proceduraId);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProceduraForm toEntityModel() {
		ProceduraFormImpl proceduraFormImpl = new ProceduraFormImpl();

		if (uuid == null) {
			proceduraFormImpl.setUuid("");
		}
		else {
			proceduraFormImpl.setUuid(uuid);
		}

		proceduraFormImpl.setProceduraId(proceduraId);
		proceduraFormImpl.setFormId(formId);
		proceduraFormImpl.setCompanyId(companyId);

		proceduraFormImpl.resetOriginalValues();

		return proceduraFormImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		proceduraId = objectInput.readLong();

		formId = objectInput.readLong();

		companyId = objectInput.readLong();

		proceduraFormPK = new ProceduraFormPK(proceduraId, formId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(proceduraId);

		objectOutput.writeLong(formId);

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public long proceduraId;
	public long formId;
	public long companyId;
	public transient ProceduraFormPK proceduraFormPK;

}