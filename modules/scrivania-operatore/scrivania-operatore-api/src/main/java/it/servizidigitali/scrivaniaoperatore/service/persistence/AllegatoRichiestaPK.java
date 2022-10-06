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
public class AllegatoRichiestaPK
	implements Comparable<AllegatoRichiestaPK>, Serializable {

	public long richiestaId;
	public String fileEntryId;

	public AllegatoRichiestaPK() {
	}

	public AllegatoRichiestaPK(long richiestaId, String fileEntryId) {
		this.richiestaId = richiestaId;
		this.fileEntryId = fileEntryId;
	}

	public long getRichiestaId() {
		return richiestaId;
	}

	public void setRichiestaId(long richiestaId) {
		this.richiestaId = richiestaId;
	}

	public String getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	@Override
	public int compareTo(AllegatoRichiestaPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (richiestaId < pk.richiestaId) {
			value = -1;
		}
		else if (richiestaId > pk.richiestaId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = fileEntryId.compareTo(pk.fileEntryId);

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

		if (!(object instanceof AllegatoRichiestaPK)) {
			return false;
		}

		AllegatoRichiestaPK pk = (AllegatoRichiestaPK)object;

		if ((richiestaId == pk.richiestaId) &&
			fileEntryId.equals(pk.fileEntryId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, richiestaId);
		hashCode = HashUtil.hash(hashCode, fileEntryId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("richiestaId=");

		sb.append(richiestaId);
		sb.append(", fileEntryId=");

		sb.append(fileEntryId);

		sb.append("}");

		return sb.toString();
	}

}