package it.servizidigitali.file.utility.service.impl;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.exception.FileServiceException;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.file.utility.service.FileService;

/**
 * @author pindi
 *
 */
@Component(name = "documentLibraryFileServiceImpl", immediate = true, service = FileService.class)
public class DocumentLibraryFileServiceImpl implements FileService {

	private static final Log log = LogFactoryUtil.getLog(DocumentLibraryFileServiceImpl.class.getName());

	private static final String DL_SITE_REQUEST_MAIN_FOLDER_NAME = "RICHIESTE_SERVIZIO";

	@Reference
	private DLAppService dlAppService;

	@Reference
	private UserLocalService userLocalService;

	@Override
	public long saveRequestFile(String nomeFile, String titolo, String descrizione, String codiceServizio, InputStream inputStream, String mimeType, long userId, long groupId)
			throws FileServiceException {

		try {
			long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			serviceContext.setAddGroupPermissions(true);

			User user = userLocalService.getUser(userId);

			Folder richiesteServizioFolder = dlAppService.getFolder(defaultRepoId, 0L, DL_SITE_REQUEST_MAIN_FOLDER_NAME);
			// Creazione folder utente se non esiste
			Folder codiceFiscaleFolder = null;
			try {
				codiceFiscaleFolder = dlAppService.getFolder(defaultRepoId, richiesteServizioFolder.getFolderId(), user.getScreenName().toUpperCase());
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder CF non esistente: " + e.getMessage() + ". Creazione folder: " + user.getScreenName().toUpperCase());
				codiceFiscaleFolder = dlAppService.addFolder(defaultRepoId, richiesteServizioFolder.getFolderId(), user.getScreenName().toUpperCase(), null, serviceContext);
			}

			if (codiceFiscaleFolder != null) {
				// Creazione folder servizio se non esiste
				Folder codiceServizioFolder = null;
				try {
					codiceServizioFolder = dlAppService.getFolder(defaultRepoId, codiceFiscaleFolder.getFolderId(), codiceServizio.toUpperCase());
				}
				catch (NoSuchFolderException e) {
					log.warn("saveRequestFile :: folder codice servizio non esistente: " + e.getMessage() + ". Creazione folder: " + codiceServizio.toUpperCase());
					codiceServizioFolder = dlAppService.addFolder(defaultRepoId, codiceFiscaleFolder.getFolderId(), codiceServizio.toUpperCase(), null, serviceContext);
				}

				if (codiceServizioFolder != null) {
					FileEntry addFileEntry = dlAppService.addFileEntry(null, defaultRepoId, codiceServizioFolder.getFolderId(), nomeFile, mimeType, titolo, null, descrizione, null, inputStream,
							inputStream.available(), null, null, serviceContext);
					return addFileEntry.getFileEntryId();
				}
			}
		}
		catch (Exception e) {
			log.error("saveRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException("saveRequestFile :: errore durante il salvataggio del file '" + nomeFile + "' : " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
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

	@Override
	public InputStream getRequestFileContent(String nomeFile, long folderId, long groupId) throws FileServiceException {
		try {
			FileEntry fileEntry = dlAppService.getFileEntry(groupId, folderId, nomeFile);
			return fileEntry.getContentStream();
		}
		catch (PortalException e) {
			log.error("getRequestFileContent :: " + e.getMessage(), e);
			throw new FileServiceException("getRequestFileContent :: errore durante il caricamento del file '" + nomeFile + "' : " + e.getMessage(), e);
		}
	}

	@Override
	public void deleteRequestFile(long fileEntryId) throws FileServiceException {
		try {
			dlAppService.deleteFileEntry(fileEntryId);
		}
		catch (PortalException e) {
			log.error("deleteRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}
	}

	@Override
	public List<File> getFolderFiles(long folderId, long groupId) throws FileServiceException {
		try {
			List<FileEntry> fileEntries = dlAppService.getFileEntries(groupId, folderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			if (fileEntries != null && !fileEntries.isEmpty()) {
				List<File> files = new ArrayList<File>();
				for (FileEntry fileEntry : fileEntries) {

					File file = new File();
					file.setNome(fileEntry.getFileName());
					file.setInputStream(fileEntry.getContentStream());
					file.setDescrizione(fileEntry.getDescription());
					file.setEstensione(fileEntry.getExtension());
					file.setMimeType(fileEntry.getMimeType());
					files.add(file);
				}
				return files;
			}
		}
		catch (PortalException e) {
			log.error("getFolderFiles :: " + e.getMessage(), e);
			throw new FileServiceException("getFolderFiles :: errore durante il caricamento dei file della folder '" + folderId + "' : " + e.getMessage(), e);
		}
		return null;
	}
}
