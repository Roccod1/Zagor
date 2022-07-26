package it.servizidigitali.file.utility.service;

import java.io.File;
import java.util.List;

import it.servizidigitali.file.utility.exception.FileServiceException;

/**
 * @author pindi
 *
 */
public interface FileService {

	/**
	 *
	 * @param fileName
	 * @param bytes
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	String savePrivateFile(String fileName, byte[] bytes, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileName
	 * @param bytes
	 * @param parentFolder
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	String savePrivateFile(String fileName, byte[] bytes, String parentFolder, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	byte[] getPrivateFileContent(String fileId, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @throws FileServiceException
	 */
	void deletePrivateFile(String fileId, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param parentFolder
	 * @param bytes
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	String saveRequestFile(String fileId, String parentFolder, byte[] bytes, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param parentFolder
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	byte[] getRequestFileContent(String fileId, String parentFolder, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param fileId
	 * @param parentFolder
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @throws FileServiceException
	 */
	void deleteRequestFile(String fileId, String parentFolder, long userId, long groupId, long companyId) throws FileServiceException;

	/**
	 *
	 * @param parentFolder
	 * @param username
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws FileServiceException
	 */
	List<File> getFolderFiles(String parentFolder, String username, long userId, long groupId, long companyId) throws FileServiceException;
}
