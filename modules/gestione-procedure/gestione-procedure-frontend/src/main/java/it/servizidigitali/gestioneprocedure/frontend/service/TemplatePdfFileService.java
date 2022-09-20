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
	public long saveJasperReport(String nomeFile, String titolo, String descrizione, long proceduraId, InputStream inputStream, String mimeType, long userId, long groupId) throws Exception {

		try {
			long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			serviceContext.setAddGroupPermissions(true);

			Folder configurazioneProceduraFolder = null;
			Folder procedure = null;
			Folder procedura = null;

			try {
				configurazioneProceduraFolder = dlAppService.getFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Configurazione Procedura");
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder Configurazione Procedura non esistente: " + e.getMessage() + ". Creazione folder: " + "Configurazione Procedura");
				configurazioneProceduraFolder = dlAppService.addFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Configurazione Procedura", null, serviceContext);
			}

			try {
				procedure = dlAppService.getFolder(defaultRepoId, configurazioneProceduraFolder.getFolderId(), "Procedure");
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder Configurazione Procedura non esistente: " + e.getMessage() + ". Creazione folder: " + "Procedure");
				procedure = dlAppService.addFolder(defaultRepoId, configurazioneProceduraFolder.getFolderId(), "Procedure", null, serviceContext);
			}

			try {
				procedura = dlAppService.getFolder(defaultRepoId, procedure.getFolderId(), String.valueOf(proceduraId));
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder per la Procedura con ID " + proceduraId + "non esistente: " + e.getMessage() + ". Creazione folder");
				procedura = dlAppService.addFolder(defaultRepoId, procedure.getFolderId(), String.valueOf(proceduraId), null, serviceContext);
			}

			if (Validator.isNotNull(inputStream)) {
				FileEntry addFileEntry = dlAppService.addFileEntry(null, defaultRepoId, procedura.getFolderId(), nomeFile, mimeType, titolo, null, descrizione, null, inputStream,
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
	 * @param fileCaricato
	 * @param fileNameModello
	 * @param formId
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public long saveTemplateAllegato(InputStream fileCaricato, String fileNameModello, long formId, long userId, long groupId) throws Exception {

		long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		Folder cartellaAllegatiForm = null;
		long idAllegatoCaricato = 0;
		long folderTemplateId = 0;
		long folderTemplateRepositoryId = 0;

		Folder folderConfigurazionePiattaforma = null;
		Folder folderForm = null;
		Folder folderTemplate = null;

		Folder folderTemplateNuova = null;

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);
		serviceContext.setAddGroupPermissions(true);

		if (Validator.isNotNull(fileCaricato)) {

			try {
				folderConfigurazionePiattaforma = dlAppService.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Configurazione Piattaforma");

				folderForm = dlAppService.getFolder(defaultRepoId, folderConfigurazionePiattaforma.getFolderId(), "Form");

				folderTemplate = dlAppService.getFolder(defaultRepoId, folderForm.getFolderId(), "Template");

			}
			catch (NoSuchFolderException e) {
				log.info("Cartella di configurazione form non presente, creazione!");

				Folder folderConfigurazionePiattaformaNuova = dlAppService.addFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Configurazione Piattaforma",
						"Configurazione Piattaforma", serviceContext);

				Folder folderFormNuova = dlAppService.addFolder(defaultRepoId, folderConfigurazionePiattaformaNuova.getFolderId(), "Form", "Form", serviceContext);

				folderTemplateNuova = dlAppService.addFolder(defaultRepoId, folderFormNuova.getFolderId(), "Template", "Template", serviceContext);
			}

			if (Validator.isNull(folderTemplate)) {
				folderTemplateId = folderTemplateNuova.getFolderId();
				folderTemplateRepositoryId = folderTemplateNuova.getRepositoryId();
			}
			else {
				folderTemplateId = folderTemplate.getFolderId();
				folderTemplateRepositoryId = folderTemplate.getRepositoryId();
			}

			try {
				Folder cartellaForm = dlAppService.getFolder(defaultRepoId, folderTemplateId, String.valueOf(formId));
				FileEntry allegatoCaricato = dlAppService.addFileEntry(null, defaultRepoId, cartellaForm.getFolderId(), fileNameModello, null, fileNameModello, null, String.valueOf(formId), null,
						fileCaricato, fileCaricato.available(), null, null, serviceContext);
				idAllegatoCaricato = allegatoCaricato.getFileEntryId();
			}
			catch (NoSuchFolderException e) {
				log.info("Cartella allegati per form con ID " + formId + " non presente a sistema,creazione");
				cartellaAllegatiForm = dlAppService.addFolder(folderTemplateRepositoryId, folderTemplateId, String.valueOf(formId), String.valueOf(formId), serviceContext);
				FileEntry allegatoCaricato = dlAppService.addFileEntry(null, groupId, cartellaAllegatiForm.getFolderId(), fileNameModello, null, fileNameModello, null, String.valueOf(formId), null,
						fileCaricato, fileCaricato.available(), null, null, serviceContext);
				idAllegatoCaricato = allegatoCaricato.getFileEntryId();
			}

		}

		return idAllegatoCaricato;
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
