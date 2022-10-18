package it.servizidigitali.gestioneprocedure.frontend.service;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;

/**
 * @author pindi
 *
 */
@Component(name = "templatePdfFileService", immediate = true, service = TemplatePdfFileService.class)
public class TemplatePdfFileService {

	private static final String CONFIGURAZIONI_FOLDER = "Configurazioni Sito";
	private static final String CONFIGURAZIONE_PROCEDURA_MAIN_FOLDER = "Gestione procedure";

	private static final Log log = LogFactoryUtil.getLog(TemplatePdfFileService.class.getName());

	@Reference
	private DLAppService dlAppService;

	/**
	 *
	 * @param nomeFile
	 * @param titolo
	 * @param descrizione
	 * @param proceduraId
	 * @param inputStream
	 * @param mimeType
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public long saveTemplate(String nomeFile, String titolo, String descrizione, long proceduraId, InputStream inputStream, String mimeType, long userId, long groupId) throws Exception {

		try {
			long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			Folder configurazioniSitoFolder = null;
			Folder gestioneProcedureFolder = null;
			Folder proceduraFolder = null;

			try {
				configurazioniSitoFolder = dlAppService.getFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CONFIGURAZIONI_FOLDER);
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder non esistente: " + e.getMessage() + ". Creazione folder: " + CONFIGURAZIONI_FOLDER);
				configurazioniSitoFolder = dlAppService.addFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CONFIGURAZIONI_FOLDER, null, serviceContext);
			}

			try {
				gestioneProcedureFolder = dlAppService.getFolder(defaultRepoId, configurazioniSitoFolder.getFolderId(), CONFIGURAZIONE_PROCEDURA_MAIN_FOLDER);
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder non esistente: " + e.getMessage() + ". Creazione folder: " + CONFIGURAZIONE_PROCEDURA_MAIN_FOLDER);
				gestioneProcedureFolder = dlAppService.addFolder(defaultRepoId, configurazioniSitoFolder.getFolderId(), CONFIGURAZIONE_PROCEDURA_MAIN_FOLDER, null, serviceContext);
			}

			try {
				proceduraFolder = dlAppService.getFolder(defaultRepoId, gestioneProcedureFolder.getFolderId(), String.valueOf(proceduraId));
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder per la Procedura con ID " + proceduraId + " non esistente: " + e.getMessage() + ". Creazione folder");
				proceduraFolder = dlAppService.addFolder(defaultRepoId, gestioneProcedureFolder.getFolderId(), String.valueOf(proceduraId), null, serviceContext);
			}

			if (Validator.isNotNull(inputStream)) {
				FileEntry addFileEntry = dlAppService.addFileEntry(null, defaultRepoId, proceduraFolder.getFolderId(), nomeFile, mimeType, titolo, null, descrizione, null, inputStream,
						inputStream.available(), null, null, serviceContext);
				return addFileEntry.getFileEntryId();
			}

		}
		catch (Exception e) {
			log.error("saveRequestFile :: " + e.getMessage(), e);
			throw new Exception("saveJasperReport :: errore durante il salvataggio del file '" + nomeFile + "' : " + e.getMessage(), e);
		}
		return 0;
	}

	/**
	 *
	 * @param file
	 * @param fileNuovo
	 * @param fileName
	 * @param groupId
	 * @param userId
	 * @return
	 */
	public long updateFileEntry(FileEntry file, byte[] fileNuovo, String fileName, long groupId, long userId) {

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);

		try {
			if (Validator.isNotNull(file) && Validator.isNotNull(fileNuovo)) {
				file = dlAppService.updateFileEntry(file.getFileEntryId(), fileName, null, fileName, null, fileName, null, null, fileNuovo, null, null, serviceContext);
				return file.getFileEntryId();
			}
		}
		catch (Exception e) {
			log.error("updateFileEntry :: errore durante l'aggiornamento del file : " + fileName + " : " + e.getMessage());
		}

		return 0;
	}

	/**
	 *
	 * @param templatePdfs
	 * @return
	 * @throws Exception
	 */
	public Map<Long, FileEntry> getTemplatePdfFileEntriesMap(List<TemplatePdf> templatePdfs) throws Exception {

		try {
			Map<Long, FileEntry> map = new HashMap<Long, FileEntry>();
			for (TemplatePdf pdf : templatePdfs) {

				if (Validator.isNotNull(pdf)) {
					FileEntry file = dlAppService.getFileEntry(pdf.getFileEntryId());
					map.put(pdf.getTemplatePdfId(), file);
				}
			}
			return map;
		}
		catch (Exception e) {
			log.error("getTemplatePdfFileEntriesMap :: " + e.getMessage(), e);
			throw new Exception("getTemplatePdfFileEntriesMap :: " + e.getMessage(), e);
		}
	}

	/**
	 *
	 * @param templatePdf
	 * @return
	 * @throws Exception
	 */
	public FileEntry getTemplatePdfFileEntry(TemplatePdf templatePdf) throws Exception {
		FileEntry file = null;

		try {
			file = dlAppService.getFileEntry(templatePdf.getFileEntryId());
		}
		catch (Exception e) {
			log.error("Errore durante il recupero del file: " + e.getMessage());
			throw new Exception("Errore durante il recupero del file: " + e.getMessage());
		}

		return file;
	}

	/**
	 *
	 * @param templatePdf
	 * @throws Exception
	 */
	public void deleteTemplatePdfFileEntry(TemplatePdf templatePdf) throws Exception {

		try {
			dlAppService.deleteFileEntry(templatePdf.getFileEntryId());
		}
		catch (Exception e) {
			log.error("Errore durante l'eliminazione del file: " + e.getMessage());
			throw new Exception("Errore durante l'eliminazione del file: " + e.getMessage());
		}
	}
}
