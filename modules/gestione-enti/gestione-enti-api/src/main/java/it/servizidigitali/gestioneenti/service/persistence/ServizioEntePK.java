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

package it.servizidigitali.gestioneenti.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServizioEntePK
	implements Comparable<ServizioEntePK>, Serializable {

	public long servizioId;
	public long organizationId;

	public ServizioEntePK() {
	}

	public ServizioEntePK(long servizioId, long organizationId) {
		this.servizioId = servizioId;
		this.organizationId = organizationId;
	}

	public long getServizioId() {
		return servizioId;
	}

	public void setServizioId(long servizioId) {
		this.servizioId = servizioId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public int compareTo(ServizioEntePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (servizioId < pk.servizioId) {
			value = -1;
		}
		else if (servizioId > pk.servizioId) {
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

		if (!(object instanceof ServizioEntePK)) {
			return false;
		}

		ServizioEntePK pk = (ServizioEntePK)object;

		if ((servizioId == pk.servizioId) &&
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

		hashCode = HashUtil.hash(hashCode, servizioId);
		hashCode = HashUtil.hash(hashCode, organizationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("servizioId=");

		sb.append(servizioId);
		sb.append(", organizationId=");

		sb.append(organizationId);

		sb.append("}");

		return sb.toString();
	}

}