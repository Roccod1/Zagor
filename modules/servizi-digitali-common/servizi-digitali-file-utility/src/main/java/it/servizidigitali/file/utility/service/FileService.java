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

	static final String PRIVATE_FOLDER_NAME = "private";
	static final String PUBLIC_FOLDER_NAME = "public";

	/**
	 *
	 * @param nomeFile
	 * @param titolo
	 * @param descrizione
	 * @param codiceServizio
	 * @param richiestaId
	 * @param inputStream
	 * @param mimeType
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	String saveRequestFile(String nomeFile, String titolo, String descrizione, String codiceServizio, long richiestaId, InputStream inputStream, String mimeType, long userId, long groupId)
			throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	InputStream getRequestFileContent(String fileId, long groupId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	File getRequestFile(String fileId, long groupId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param groupId
	 * @throws FileServiceException
	 */
	void deleteRequestFile(String fileId, long groupId) throws FileServiceException;

	/**
	 *
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws FileServiceException
	 */
	List<File> getUserFolderFiles(long userId, long groupId) throws FileServiceException;

}
