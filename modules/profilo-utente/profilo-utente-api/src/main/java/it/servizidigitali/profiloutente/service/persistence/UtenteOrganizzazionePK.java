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

package it.servizidigitali.profiloutente.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UtenteOrganizzazionePK
	implements Comparable<UtenteOrganizzazionePK>, Serializable {

	public long utenteId;
	public long organizationId;

	public UtenteOrganizzazionePK() {
	}

	public UtenteOrganizzazionePK(long utenteId, long organizationId) {
		this.utenteId = utenteId;
		this.organizationId = organizationId;
	}

	public long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(long utenteId) {
		this.utenteId = utenteId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public int compareTo(UtenteOrganizzazionePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (utenteId < pk.utenteId) {
			value = -1;
		}
		else if (utenteId > pk.utenteId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (organizationId < pk.organizationId) {
			value = -1;
		}
		else if (organizationId > pk.organizationId) {
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

		if (!(object instanceof UtenteOrganizzazionePK)) {
			return false;
		}

		UtenteOrganizzazionePK pk = (UtenteOrganizzazionePK)object;

		if ((utenteId == pk.utenteId) &&
			(organizationId == pk.organizationId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, utenteId);
		hashCode = HashUtil.hash(hashCode, organizationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("utenteId=");

		sb.append(utenteId);
		sb.append(", organizationId=");

		sb.append(organizationId);

		sb.append("}");

		return sb.toString();
	}

}