package it.servizidigitali.gestioneforms.frontend.service;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author pindi
 *
 */
@Component(name = "templateAllegatoFileService", immediate = true, service = TemplateAllegatoFileService.class)
public class TemplateAllegatoFileService {

	private static final String CONFIGURAZIONI_FOLDER = "Configurazioni Sito";
	private static final String CONFIGURAZIONE_FORMS_MAIN_FOLDER = "Gestione forms";

	private static final Log log = LogFactoryUtil.getLog(TemplateAllegatoFileService.class.getName());

	@Reference
	private DLAppService dlAppService;

	/**
	 *
	 * @param nomeFile
	 * @param titolo
	 * @param descrizione
	 * @param formId
	 * @param inputStream
	 * @param mimeType
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	public long saveTemplateAllegato(String nomeFile, String titolo, String descrizione, long formId, InputStream inputStream, String mimeType, long userId, long groupId) throws Exception {

		try {
			long defaultRepoId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			serviceContext.setAddGroupPermissions(true);

			Folder configurazioniSitoFolder = null;
			Folder gestioneFormsFolder = null;
			Folder formFolder = null;

			try {
				configurazioniSitoFolder = dlAppService.getFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CONFIGURAZIONI_FOLDER);
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder non esistente: " + e.getMessage() + ". Creazione folder: " + CONFIGURAZIONI_FOLDER);
				configurazioniSitoFolder = dlAppService.addFolder(defaultRepoId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CONFIGURAZIONI_FOLDER, null, serviceContext);
			}

			try {
				gestioneFormsFolder = dlAppService.getFolder(defaultRepoId, configurazioniSitoFolder.getFolderId(), CONFIGURAZIONE_FORMS_MAIN_FOLDER);
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder non esistente: " + e.getMessage() + ". Creazione folder: " + CONFIGURAZIONE_FORMS_MAIN_FOLDER);
				gestioneFormsFolder = dlAppService.addFolder(defaultRepoId, configurazioniSitoFolder.getFolderId(), CONFIGURAZIONE_FORMS_MAIN_FOLDER, null, serviceContext);
			}

			try {
				formFolder = dlAppService.getFolder(defaultRepoId, gestioneFormsFolder.getFolderId(), String.valueOf(formId));
			}
			catch (NoSuchFolderException e) {
				log.warn("saveRequestFile :: folder per il Form con ID " + formId + " non esistente: " + e.getMessage() + ". Creazione folder");
				formFolder = dlAppService.addFolder(defaultRepoId, gestioneFormsFolder.getFolderId(), String.valueOf(formId), null, serviceContext);
			}

			if (Validator.isNotNull(inputStream)) {
				FileEntry addFileEntry = dlAppService.addFileEntry(null, defaultRepoId, formFolder.getFolderId(), nomeFile, mimeType, titolo, null, descrizione, null, inputStream,
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
	 * @param fileEntryId
	 * @throws PortalException
	 */
	public void deleteTemplateAllegato(long fileEntryId) throws PortalException {
		dlAppService.deleteFileEntry(fileEntryId);
	}

}
