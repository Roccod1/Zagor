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

package it.servizidigitali.gestioneprocedure.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProceduraFormPK
	implements Comparable<ProceduraFormPK>, Serializable {

	public long proceduraId;
	public long formId;

	public ProceduraFormPK() {
	}

	public ProceduraFormPK(long proceduraId, long formId) {
		this.proceduraId = proceduraId;
		this.formId = formId;
	}

	public long getProceduraId() {
		return proceduraId;
	}

	public void setProceduraId(long proceduraId) {
		this.proceduraId = proceduraId;
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	@Override
	public int compareTo(ProceduraFormPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (proceduraId < pk.proceduraId) {
			value = -1;
		}
		else if (proceduraId > pk.proceduraId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (formId < pk.formId) {
			value = -1;
		}
		else if (formId > pk.formId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProceduraFormPK)) {
			return false;
		}

		ProceduraFormPK pk = (ProceduraFormPK)object;

		if ((proceduraId == pk.proceduraId) && (formId == pk.formId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, proceduraId);
		hashCode = HashUtil.hash(hashCode, formId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("proceduraId=");

		sb.append(proceduraId);
		sb.append(", formId=");

		sb.append(formId);

		sb.append("}");

		return sb.toString();
	}

}