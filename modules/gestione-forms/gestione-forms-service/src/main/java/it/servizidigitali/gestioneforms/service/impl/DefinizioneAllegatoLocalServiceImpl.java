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

package it.servizidigitali.gestioneforms.service.impl;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.base.DefinizioneAllegatoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneforms.model.DefinizioneAllegato",
	service = AopService.class
)
public class DefinizioneAllegatoLocalServiceImpl
	extends DefinizioneAllegatoLocalServiceBaseImpl {
	
	public static final Log _log = LogFactoryUtil.getLog(DefinizioneAllegatoLocalServiceImpl.class);
	
	public List<DefinizioneAllegato> getListaDefinizioneAllegatoByFormId(long formId){
		List<DefinizioneAllegato> listaDefinizioneAllegati = new ArrayList<>();
		if(formId>0) {
			listaDefinizioneAllegati = definizioneAllegatoPersistence.findByformIdAndEliminato(formId,false);
		}
		
		return listaDefinizioneAllegati;
	}
	
	public FileEntry uploadAllegato(File allegato, ThemeDisplay themeDisplay, String fileName, long formId, String mimeType, ServiceContext serviceContext) throws Exception{
		
		long groupId = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Guest").getGroupId();
		Folder cartellaAllegatiForm = null;

		FileEntry fileEntry = null;
		byte[] fileByteArray = FileUtil.getBytes(allegato);

		DLFolder folderConfigurazionePiattaforma = DLFolderLocalServiceUtil.getFolder(groupId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				"Configurazione Piattaforma");
		
		DLFolder folderForm = DLFolderLocalServiceUtil.getFolder(groupId, folderConfigurazionePiattaforma.getFolderId(),
				"Form");
		
		DLFolder folderTemplate = DLFolderLocalServiceUtil.getFolder(groupId, folderForm.getFolderId(),"Template");
		
		try {
			DLFolder cartellaForm = DLFolderLocalServiceUtil.getFolder(groupId, folderTemplate.getFolderId(),String.valueOf(formId));		
			fileEntry = DLAppLocalServiceUtil.addFileEntry(null, themeDisplay.getUserId(), cartellaForm.getRepositoryId(), cartellaForm.getFolderId(), fileName, mimeType, fileByteArray, null, null, serviceContext);
		}catch(NoSuchFolderException e) {
			_log.info("Cartella allegati per form con ID " + formId + " non presente a sistema,creazione");
			cartellaAllegatiForm = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),
					folderTemplate.getRepositoryId(), folderTemplate.getFolderId(), String.valueOf(formId),
					String.valueOf(formId), serviceContext);
			fileEntry = DLAppLocalServiceUtil.addFileEntry(null, themeDisplay.getUserId(), cartellaAllegatiForm.getRepositoryId(), cartellaAllegatiForm.getFolderId(), fileName, mimeType, fileByteArray, null, null, serviceContext);
		}

		return fileEntry;
	}
	
	public DefinizioneAllegato cancellaAllegati(String[] allegatiDaEliminare) {
		DefinizioneAllegato allegato = null;
		for(String allegatoId : allegatiDaEliminare) {
			allegato = definizioneAllegatoPersistence.fetchByPrimaryKey(Long.valueOf(allegatoId));
			if(Validator.isNotNull(allegato)) {
				allegato.setEliminato(true);
				definizioneAllegatoLocalService.updateDefinizioneAllegato(allegato);
			}else {
				_log.error("Impossibile recuperare l'allegato per poter effettuare l'eliminazione!");
			}
		}
		
		return allegato;
	}

}