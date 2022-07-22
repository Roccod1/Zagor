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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileOutputStream;
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
	
	public long uploadAllegatoTemporaneo(File allegato) throws Exception{
		File tempFile = null;
		String tmpDir = System.getProperty("java.io.tmpdir");
		long idTemporaneo = 0;

		if(Validator.isNotNull(allegato)) {
			byte[] allegatoCaricato = FileUtil.getBytes(allegato);
			idTemporaneo = counterLocalService.increment();
			String percorsoFile = tmpDir + File.separator + "allegato-" + idTemporaneo;
			
			tempFile = new File(percorsoFile);
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(allegatoCaricato);
			fos.close();
		}else {
			_log.error("DefinizioneAllegatoLocalServiceImpl :: uploadAllegatoTemporaneo :: Impossibile recuperare allegato caricato");
		}
		
		return idTemporaneo;
	}
	
	public FileEntry uploadAllegatoDocumentMediaRepository(String idAllegatoTemporaneo, String fileNameModello, long groupId, long formId, long userId, ServiceContext serviceContext) throws Exception{
		FileEntry allegatoCaricato = null;
		String tmpDir = System.getProperty("java.io.tmpdir");
		String percorsoFileTemporaneo = tmpDir + File.separator + "allegato-" + idAllegatoTemporaneo;
		Folder cartellaAllegatiForm = null;
		
		byte[] byteArrayAllegatoCaricato = null;
		
		File fileTemporaneo = new File(percorsoFileTemporaneo);
		
		if(Validator.isNotNull(fileTemporaneo)) {
			byteArrayAllegatoCaricato = FileUtil.getBytes(fileTemporaneo);
			
			DLFolder folderConfigurazionePiattaforma = DLFolderLocalServiceUtil.getFolder(groupId,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"Configurazione Piattaforma");
			
			DLFolder folderForm = DLFolderLocalServiceUtil.getFolder(groupId, folderConfigurazionePiattaforma.getFolderId(),
					"Form");
			
			DLFolder folderTemplate = DLFolderLocalServiceUtil.getFolder(groupId, folderForm.getFolderId(),"Template");
			
			try {
				DLFolder cartellaForm = DLFolderLocalServiceUtil.getFolder(groupId, folderTemplate.getFolderId(),String.valueOf(formId));		
				allegatoCaricato = DLAppLocalServiceUtil.addFileEntry(null, userId, cartellaForm.getRepositoryId(), cartellaForm.getFolderId(), fileNameModello, MimeTypesUtil.getContentType(fileTemporaneo), byteArrayAllegatoCaricato, null, null, serviceContext);
				fileTemporaneo.delete();
			}catch(NoSuchFolderException e) {
				_log.info("Cartella allegati per form con ID " + formId + " non presente a sistema,creazione");
				cartellaAllegatiForm = DLAppLocalServiceUtil.addFolder(userId,
						folderTemplate.getRepositoryId(), folderTemplate.getFolderId(), String.valueOf(formId),
						String.valueOf(formId), serviceContext);
				allegatoCaricato = DLAppLocalServiceUtil.addFileEntry(null, userId, cartellaAllegatiForm.getRepositoryId(), cartellaAllegatiForm.getFolderId(), fileNameModello, MimeTypesUtil.getContentType(fileTemporaneo), byteArrayAllegatoCaricato, null, null, serviceContext);
				fileTemporaneo.delete();
			}
		}
		
		
		
		return allegatoCaricato;
	}

}