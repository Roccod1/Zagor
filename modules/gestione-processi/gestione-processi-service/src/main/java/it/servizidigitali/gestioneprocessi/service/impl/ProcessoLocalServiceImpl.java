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

package it.servizidigitali.gestioneprocessi.service.impl;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.base.ProcessoLocalServiceBaseImpl;
import it.servizidigitali.gestioneprocessi.service.enumeration.NomiCartelleEnum;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneprocessi.model.Processo",
	service = AopService.class
)
public class ProcessoLocalServiceImpl extends ProcessoLocalServiceBaseImpl {
	
	public static final Log _log = LogFactoryUtil.getLog(ProcessoLocalServiceImpl.class);
	
	public List<Processo> cerca(String nome, Date dataInserimentoDa, Date dataInserimentoA, int delta, int cur, String orderByCol, String orderByType){
		boolean direzione = false;
		
		if(orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}
		
		if(Validator.isNull(orderByCol)) {
			orderByCol = "processoId";
		}
		
		OrderByComparator<Processo> comparator = OrderByComparatorFactoryUtil.create("Processo", orderByCol, direzione);	
		List<Processo> listaProcesso = processoFinder.findByFilters(nome, dataInserimentoDa, dataInserimentoA, cur, delta, comparator);
		
		return listaProcesso;
	}
	
	public Processo getProcessoByCodice(String codice) throws NoSuchProcessoException {
		Processo processo = processoPersistence.findByCodice(codice);
		return processo;
	}
	
	
	public String recuperaProcessoXml(long fileEntryId) throws Exception {
		FileEntry processoXml = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		String processoXmlString = null;
		
		if(Validator.isNotNull(processoXml)) {
			InputStream inputStream = processoXml.getContentStream();
			
			if(Validator.isNotNull(inputStream)) {
				processoXmlString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
			}
			
		}else {
			_log.error("Errore durante il recupero dell'xml dal document library!");
		}
		
		return processoXmlString;
	}
	
	
	public FileEntry uploadDocumentLibrary(String file, String nomeFile, String nomeCartella, Group group, long userId, ServiceContext serviceCtx) throws PortalException {
		FileEntry fileCaricato = null;
		long repositoryId = group.getGroupId();
		byte[] fileByteArray = file.getBytes();
		
		if(Validator.isNotNull(file)) {
			
			try {
				DLFolder cartellaConfigurazione = DLFolderLocalServiceUtil.getFolder(group.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,NomiCartelleEnum.CONFIGURAZIONI.getName());	
				DLFolder folderBpmn = DLFolderLocalServiceUtil.getFolder(group.getGroupId(),
						cartellaConfigurazione.getFolderId(),
						NomiCartelleEnum.BPMN.getName());
				DLFolder folderFiles = DLFolderLocalServiceUtil.getFolder(group.getGroupId(),
						folderBpmn.getFolderId(),
						NomiCartelleEnum.FILES.getName());
				fileCaricato = DLAppLocalServiceUtil.addFileEntry(null, userId, folderFiles.getRepositoryId(), folderFiles.getFolderId(), nomeFile, ContentTypes.TEXT_XML, fileByteArray, null, null, serviceCtx);

			}catch(NoSuchFolderException e) {
				_log.info("Cartella per file BPMN non presente a sistema,creazione");
				Folder cartellaConfigurazione = DLAppLocalServiceUtil.addFolder(userId,
						repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, NomiCartelleEnum.CONFIGURAZIONI.getName(),
						NomiCartelleEnum.CONFIGURAZIONI.getName(), serviceCtx);
				
				Folder folderBpmn = DLAppLocalServiceUtil.addFolder(userId,
						cartellaConfigurazione.getRepositoryId(), cartellaConfigurazione.getFolderId(), NomiCartelleEnum.BPMN.getName(),
						NomiCartelleEnum.BPMN.getName(), serviceCtx);
				
				Folder folderFiles = DLAppLocalServiceUtil.addFolder(userId,
						folderBpmn.getRepositoryId(), folderBpmn.getFolderId(), NomiCartelleEnum.FILES.getName(),
						NomiCartelleEnum.FILES.getName(), serviceCtx);
				
				fileCaricato = DLAppLocalServiceUtil.addFileEntry(null, userId, folderFiles.getRepositoryId(), folderFiles.getFolderId(), nomeFile, ContentTypes.TEXT_XML, fileByteArray, null, null, serviceCtx);

			}

		}else {
			_log.error("Impossibile recuperare il file da caricare!");
		}
		
		return fileCaricato;
	}
}