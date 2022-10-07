/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package it.servizidigitali.scrivaniaoperatore.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.base.CommentoRichiestaLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta", service = AopService.class)
public class CommentoRichiestaLocalServiceImpl extends CommentoRichiestaLocalServiceBaseImpl {

	@Override
	public List<CommentoRichiesta> getCommentiRichiestaByRichiestaId(long richiestaId) {
		return commentoRichiestaPersistence.findByRichiestaId(richiestaId);
	}

	@Override
	public List<CommentoRichiesta> getCommentiRichiestaByRichiestaIdVisibile(long richiestaId, boolean visibile) {
		return commentoRichiestaPersistence.findByRichiestaIdVisibile(richiestaId, visibile);
	}
	
	public List<CommentoRichiesta> getCommentiRichiestaByRichiestaIdVisibile(long richiestaId, boolean visibile, int start, int end) {
		return commentoRichiestaPersistence.findByRichiestaIdVisibile(richiestaId, visibile, start, end);
	}
	
	public int countCommentiRichiestaByRichiestaIdVisibile(long richiestaId, boolean visibile) {
		return commentoRichiestaPersistence.countByRichiestaIdVisibile(richiestaId, visibile);
	}

	public long createCommentoRichiesta(String testo, String taskId, boolean visibile, long richiestaId, long userId, String userName, long groupId, long companyId) {

		CommentoRichiesta commentoRichiesta = commentoRichiestaPersistence.create(counterLocalService.increment());
		commentoRichiesta.setTesto(testo);
		commentoRichiesta.setTaskId(taskId);
		commentoRichiesta.setVisibile(visibile);
		commentoRichiesta.setGroupId(groupId);
		commentoRichiesta.setCompanyId(companyId);
		commentoRichiesta.setUserId(userId);
		commentoRichiesta.setUserName(userName);
		commentoRichiesta.setRichiestaId(richiestaId);

		commentoRichiesta = commentoRichiestaPersistence.update(commentoRichiesta);

		return commentoRichiesta.getCommentoRichiestaId();
	}
}