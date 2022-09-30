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

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface ProceduraFinder {

	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		findByFilters(
			String denominazione, String attiva,
			java.util.Date dataInserimentoDa, java.util.Date dataInserimentoA,
			long siteGroupId, int inizio, int fine,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.servizidigitali.gestioneprocedure.model.Procedura> ordine);

	public java.util.List<it.servizidigitali.gestioneprocedure.model.Procedura>
		findByServiziIdsGroupIdAttiva(
			java.util.List<Long> serviziIds, long groupId, Boolean attiva);

}