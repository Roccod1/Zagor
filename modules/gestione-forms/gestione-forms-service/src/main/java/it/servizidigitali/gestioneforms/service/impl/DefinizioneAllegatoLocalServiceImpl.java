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

package it.servizidigitali.gestioneforms.service.impl;

import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.base.DefinizioneAllegatoLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneforms.model.DefinizioneAllegato", service = AopService.class)
public class DefinizioneAllegatoLocalServiceImpl extends DefinizioneAllegatoLocalServiceBaseImpl {

	@Reference
	private DLFolderLocalService dlFolderLocalService;

	@Reference
	private DLAppLocalService dlAppLocalService;

	public static final Log _log = LogFactoryUtil.getLog(DefinizioneAllegatoLocalServiceImpl.class);

	@Override
	public List<DefinizioneAllegato> getListaDefinizioneAllegatoByFormId(long formId) {
		List<DefinizioneAllegato> listaDefinizioneAllegati = new ArrayList<>();
		if (formId > 0) {
			listaDefinizioneAllegati = definizioneAllegatoPersistence.findByFormId(formId);
		}

		return listaDefinizioneAllegati;
	}

	@Override
	public void deleteAllegati(List<Long> ids) {
		for (Long id : ids) {
			try {
				definizioneAllegatoLocalService.deleteDefinizioneAllegato(id);
			}
			catch (PortalException e) {
				_log.error("deleteAllegati :: " + e.getMessage(), e);
			}
		}
	}
}