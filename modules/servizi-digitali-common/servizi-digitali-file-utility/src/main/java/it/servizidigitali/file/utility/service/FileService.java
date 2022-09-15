package it.servizidigitali.file.utility.service;

import java.io.InputStream;
import java.util.List;

import it.servizidigitali.file.utility.exception.FileServiceException;
import it.servizidigitali.file.utility.model.File;

/**
 * @author pindi
 *
 */
public interface FileService {

	/**
	 *
	 * @param nomeFile
	 * @param titolo
	 * @param descrizione
	 * @param codiceServizio
	 * @param inputStream
	 * @param mimeType
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	long saveRequestFile(String nomeFile, String titolo, String descrizione, String codiceServizio, InputStream inputStream, String mimeType, long userId, long groupId) throws FileServiceException;

	/**
	 *
	 * @param nomeFile
	 * @param folderId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	InputStream getRequestFileContent(String nomeFile, long folderId, long groupId) throws FileServiceException;

	/**
	 *
	 * @param fileEntryId
	 * @throws FileServiceException
	 */
	void deleteRequestFile(long fileEntryId) throws FileServiceException;

	/**
	 *
	 * @param folderId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	List<File> getFolderFiles(long folderId, long groupId) throws FileServiceException;


	long saveTemplateAllegato(InputStream fileCaricato, String fileNameModello, long formId, long userId, long groupId)
			throws Exception;
}
