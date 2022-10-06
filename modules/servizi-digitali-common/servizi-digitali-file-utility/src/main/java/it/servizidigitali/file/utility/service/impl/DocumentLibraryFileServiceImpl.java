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
	private static final String DL_SITE_PRIVATE_USER_MAIN_FOLDER_NAME = "FILE_PRIVATI_UTENTE";

	@Reference
	private DLAppService dlAppService;

	@Reference
	private UserLocalService userLocalService;

	@Override
	public String saveRequestFile(String nomeFile, String titolo, String descrizione, String codiceServizio, long richiestaId, InputStream inputStream, String mimeType, long userId, long groupId)
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

					Folder richiestaIdFolder = null;
					try {
						richiestaIdFolder = dlAppService.getFolder(defaultRepoId, codiceFiscaleFolder.getFolderId(), String.valueOf(richiestaId));
					}
					catch (NoSuchFolderException e) {
						log.warn("saveRequestFile :: folder richiesta id non esistente: " + e.getMessage() + ". Creazione folder: " + richiestaId);
						richiestaIdFolder = dlAppService.addFolder(defaultRepoId, codiceFiscaleFolder.getFolderId(), String.valueOf(richiestaId), null, serviceContext);
					}

					if (richiestaIdFolder != null) {
						FileEntry addFileEntry = dlAppService.addFileEntry(null, defaultRepoId, richiestaIdFolder.getFolderId(), nomeFile, mimeType, titolo, null, descrizione, null, inputStream,
								inputStream.available(), null, null, serviceContext);
						return String.valueOf(addFileEntry.getFileEntryId());
					}

				}
			}
		}
		catch (Exception e) {
			log.error("saveRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException("saveRequestFile :: errore durante il salvataggio del file '" + nomeFile + "' : " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public InputStream getRequestFileContent(String fileId, long groupId) throws FileServiceException {
		try {
			FileEntry fileEntry = dlAppService.getFileEntry(Long.parseLong(fileId));
			return fileEntry.getContentStream();
		}
		catch (PortalException e) {
			log.error("getRequestFileContent :: " + e.getMessage(), e);
			throw new FileServiceException("getRequestFileContent :: errore durante il caricamento del file '" + fileId + "' : " + e.getMessage(), e);
		}
	}

	@Override
	public void deleteRequestFile(String fileId, long groupId) throws FileServiceException {
		try {
			dlAppService.deleteFileEntry(Long.parseLong(fileId));
		}
		catch (PortalException e) {
			log.error("deleteRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}
	}

	@Override
	public List<File> getUserFolderFiles(long userId, long groupId) throws FileServiceException {
		try {
			long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			serviceContext.setAddGroupPermissions(true);

			User user = userLocalService.getUser(userId);

			Folder filePrivatiUtenteFolder = dlAppService.getFolder(defaultRepoId, 0L, DL_SITE_PRIVATE_USER_MAIN_FOLDER_NAME);

			Folder codiceFiscaleFolder = null;
			try {
				codiceFiscaleFolder = dlAppService.getFolder(defaultRepoId, filePrivatiUtenteFolder.getFolderId(), user.getScreenName().toUpperCase());
			}
			catch (NoSuchFolderException e) {
				log.warn("getUserFolderFiles :: folder CF non esistente: " + e.getMessage());
			}
			if (codiceFiscaleFolder == null) {
				return null;
			}

			List<FileEntry> fileEntries = dlAppService.getFileEntries(groupId, codiceFiscaleFolder.getFolderId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			if (fileEntries != null && !fileEntries.isEmpty()) {
				List<File> files = new ArrayList<File>();
				for (FileEntry fileEntry : fileEntries) {
					File file = getFile(fileEntry);
					files.add(file);
				}
				return files;
			}
		}
		catch (PortalException e) {
			log.error("getUserFolderFiles :: " + e.getMessage(), e);
			throw new FileServiceException("getUserFolderFiles :: errore durante il caricamento dei file privati per l'utente '" + userId + ", groupId: " + groupId + " :: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public File getRequestFile(String fileId, long groupId) throws FileServiceException {
		try {
			FileEntry fileEntry = dlAppService.getFileEntry(Long.parseLong(fileId));
			return getFile(fileEntry);
		}
		catch (PortalException e) {
			log.error("getRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException("getRequestFile :: errore durante il caricamento del file '" + fileId + "' : " + e.getMessage(), e);
		}
	}

	/**
	 * @param fileEntry
	 * @return
	 * @throws PortalException
	 */
	private File getFile(FileEntry fileEntry) throws PortalException {
		File file = new File();
		file.setId(String.valueOf(fileEntry.getFileEntryId()));
		file.setNome(fileEntry.getFileName());
		file.setTitolo(fileEntry.getTitle());
		file.setInputStream(fileEntry.getContentStream());
		file.setDescrizione(fileEntry.getDescription());
		file.setEstensione(fileEntry.getExtension());
		file.setMimeType(fileEntry.getMimeType());
		return file;
	}
}