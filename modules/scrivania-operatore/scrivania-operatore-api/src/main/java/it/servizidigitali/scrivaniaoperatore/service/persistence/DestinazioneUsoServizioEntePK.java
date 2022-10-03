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

package it.servizidigitali.scrivaniaoperatore.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DestinazioneUsoServizioEntePK
	implements Comparable<DestinazioneUsoServizioEntePK>, Serializable {

	public long destinazioneUsoId;
	public long servizioId;
	public long organizationId;

	public DestinazioneUsoServizioEntePK() {
	}

	public DestinazioneUsoServizioEntePK(
		long destinazioneUsoId, long servizioId, long organizationId) {

		this.destinazioneUsoId = destinazioneUsoId;
		this.servizioId = servizioId;
		this.organizationId = organizationId;
	}

	public long getDestinazioneUsoId() {
		return destinazioneUsoId;
	}

	public void setDestinazioneUsoId(long destinazioneUsoId) {
		this.destinazioneUsoId = destinazioneUsoId;
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
	public int compareTo(DestinazioneUsoServizioEntePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (destinazioneUsoId < pk.destinazioneUsoId) {
			value = -1;
		}
		else if (destinazioneUsoId > pk.destinazioneUsoId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		if (!(object instanceof DestinazioneUsoServizioEntePK)) {
			return false;
		}

		DestinazioneUsoServizioEntePK pk =
			(DestinazioneUsoServizioEntePK)object;

		if ((destinazioneUsoId == pk.destinazioneUsoId) &&
			(servizioId == pk.servizioId) &&
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

		hashCode = HashUtil.hash(hashCode, destinazioneUsoId);
		hashCode = HashUtil.hash(hashCode, servizioId);
		hashCode = HashUtil.hash(hashCode, organizationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(8);

		sb.append("{");

		sb.append("destinazioneUsoId=");

		sb.append(destinazioneUsoId);
		sb.append(", servizioId=");

		sb.append(servizioId);
		sb.append(", organizationId=");

		sb.append(organizationId);

		sb.append("}");

		return sb.toString();
	}

}