package it.servizidigitali.file.utility.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.configuration.AlfrescoCMISConfiguration;
import it.servizidigitali.file.utility.exception.FileServiceException;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.file.utility.service.FileService;

/**
 * @author pindi
 *
 */
@Component(name = "alfrescoFileServiceImpl", immediate = true, service = FileService.class, configurationPid = "it.servizidigitali.file.utility.configuration.AlfrescoCMISConfiguration")
public class AlfrescoFileServiceImpl implements FileService {

	private static final String ALFRESCO_CMIS_ATOM_REPOSITORY_ROOT_PATH_FORMAT = "/Siti/%s/documentLibrary";

	private static final Log log = LogFactoryUtil.getLog(AlfrescoFileServiceImpl.class.getName());

	private volatile AlfrescoCMISConfiguration alfrescoCMISConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		alfrescoCMISConfiguration = ConfigurableUtil.createConfigurable(AlfrescoCMISConfiguration.class, props);

		parameters = new HashMap<String, String>();

		// ECM user credentials
		parameters.put(SessionParameter.USER, alfrescoCMISConfiguration.alfrescoCmisAtomUser());
		parameters.put(SessionParameter.PASSWORD, alfrescoCMISConfiguration.alfrescoCmisAtomPassword());

		parameters.put(SessionParameter.ATOMPUB_URL, alfrescoCMISConfiguration.alfrescoCmisAtomUrl());
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(SessionParameter.COMPRESSION, "true");
		parameters.put(SessionParameter.CACHE_TTL_OBJECTS, "0");
	}

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private UserLocalService userLocalService;

	private Map<String, String> parameters;

	@Override
	public String saveRequestFile(String nomeFile, String titolo, String descrizione, String codiceServizio, long richiestaId, InputStream inputStream, String mimeType, long userId, long groupId)
			throws FileServiceException {
		try {
			Session session = SessionFactoryImpl.newInstance().getRepositories(parameters).get(0).createSession();

			Organization organization = organizationLocalService.getOrganization(groupLocalService.getGroup(groupId).getOrganizationId());

			User user = userLocalService.getUser(userId);

			Folder rootFolder = getRootFolder(organization, session);
			// get/creazione folder utente
			Folder userFolder = getOrCreateFolder(user.getScreenName(), rootFolder, session);

			// get/creazione folder "public"
			Folder publicUserFolder = getOrCreateFolder(PUBLIC_FOLDER_NAME, userFolder, session);

			// get/creazione folder "codiceServizio"
			Folder codiceServizioFolder = getOrCreateFolder(codiceServizio, publicUserFolder, session);

			Folder richiestaIdFolder = getOrCreateFolder(String.valueOf(richiestaId), codiceServizioFolder, session);

			// Salvataggio documento in folder
			byte[] bytes = inputStream.readAllBytes();
			ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
			ContentStream contentStream = session.getObjectFactory().createContentStream(nomeFile, bytes.length, mimeType, stream);

			// Update
			Document document = null;
			try {
				document = (Document) session.getObjectByPath(richiestaIdFolder.getPath() + "/" + nomeFile);
			}
			catch (CmisObjectNotFoundException e) {
				log.warn("saveRequestFile :: " + e.getMessage());
			}
			if (document != null) {
				document.setContentStream(contentStream, true);
			}
			// Create
			else {
				// properties
				Map<String, Object> properties = new HashMap<String, Object>();
				properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
				properties.put(PropertyIds.NAME, nomeFile);
				document = richiestaIdFolder.createDocument(properties, contentStream, VersioningState.NONE);

			}
			log.debug("saveRequestFile :: file '" + document.getName() + "' creato correttamente ");
			return document.getId();
		}
		catch (Exception e) {
			log.error("saveRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}
	}

	@Override
	public InputStream getRequestFileContent(String fileId, long groupId) throws FileServiceException {
		try {
			Session session = SessionFactoryImpl.newInstance().getRepositories(parameters).get(0).createSession();
			Document document = (Document) session.getObject(fileId);
			InputStream stream = document.getContentStream().getStream();
			return stream;
		}
		catch (Exception e) {
			log.error("getRequestFileContent :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}
	}

	@Override
	public void deleteRequestFile(String fileId, long groupId) throws FileServiceException {
		try {
			Session session = SessionFactoryImpl.newInstance().getRepositories(parameters).get(0).createSession();
			Document document = (Document) session.getObject(fileId);
			document.delete();
		}
		catch (Exception e) {
			log.error("deleteRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}

	}

	@Override
	public File getRequestFile(String fileId, long groupId) throws FileServiceException {
		try {
			Session session = SessionFactoryImpl.newInstance().getRepositories(parameters).get(0).createSession();
			Document document = (Document) session.getObject(fileId);
			return getFile(document);
		}
		catch (Exception e) {
			log.error("getRequestFile :: " + e.getMessage(), e);
			throw new FileServiceException(e);
		}
	}

	@Override
	public List<File> getUserFolderFiles(long userId, long groupId) throws FileServiceException {

		try {
			Session session = SessionFactoryImpl.newInstance().getRepositories(parameters).get(0).createSession();

			Organization organization = organizationLocalService.getOrganization(groupLocalService.getGroup(groupId).getOrganizationId());

			Folder rootFolder = getRootFolder(organization, session);

			User user = userLocalService.getUser(userId);

			// get/creazione folder utente
			Folder userFolder = getFolder(user.getScreenName(), rootFolder, session);
			if (userFolder == null) {
				return null;
			}

			// get/creazione folder "public"
			Folder privateUserFolder = getOrCreateFolder(PRIVATE_FOLDER_NAME, userFolder, session);

			if (privateUserFolder == null) {
				return null;
			}

			// get/creazione folder "private"
			List<File> result = new ArrayList<File>();
			for (CmisObject child : privateUserFolder.getChildren()) {
				if (child instanceof Document) {
					Document childDoument = (Document) child;
					File file = getFile(childDoument);
					result.add(file);
				}

			}
			return result;
		}
		catch (Exception e) {
			log.error("getUserFolderFiles :: " + e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @param document
	 * @return
	 */
	private File getFile(Document document) {
		File file = new File();
		file.setId(document.getId());
		ContentStream contentStream = document.getContentStream();
		InputStream stream = contentStream.getStream();
		file.setInputStream(stream);
		file.setNome(contentStream.getFileName());
		file.setMimeType(contentStream.getMimeType());
		return file;
	}

	private Folder getRootFolder(Organization organization, Session session) throws Exception {
		String nomeOrganizzazione = organization.getName().toLowerCase();
		nomeOrganizzazione = nomeOrganizzazione.replace(StringPool.SPACE, StringPool.DASH);
		String alfrescoCmisAtomRepositoryRootPath = String.format(ALFRESCO_CMIS_ATOM_REPOSITORY_ROOT_PATH_FORMAT, nomeOrganizzazione);
		return (Folder) session.getObjectByPath(alfrescoCmisAtomRepositoryRootPath);
	}

	private Folder getFolder(String folderName, Folder rootFolder, Session session) throws Exception {

		Folder folder = null;
		String folderPath = null;
		if (rootFolder.isRootFolder()) {
			folderPath = rootFolder.getPath() + folderName;
		}
		else {
			folderPath = rootFolder.getPath() + "/" + folderName;
		}
		try {
			folder = (Folder) session.getObjectByPath(folderPath);
		}
		catch (CmisObjectNotFoundException e) {
			log.warn("la cartella '" + folderPath + "' non esiste :: " + e.getMessage());
		}
		return folder;
	}

	private Folder getOrCreateFolder(String folderName, Folder rootFolder, Session session) throws Exception {

		Folder folder = null;
		String folderPath = null;
		if (rootFolder.isRootFolder()) {
			folderPath = rootFolder.getPath() + folderName;
		}
		else {
			folderPath = rootFolder.getPath() + "/" + folderName;
		}
		try {
			folder = (Folder) session.getObjectByPath(folderPath);
		}
		catch (CmisObjectNotFoundException e) {
			log.warn("la cartella '" + folderPath + "' non esiste :: " + e.getMessage());
			Map<String, Object> props = new HashMap<>();
			props.put("cmis:objectTypeId", "cmis:folder");
			props.put("cmis:name", folderName);
			log.info("creazione cartella '" + folderPath + "'");
			folder = rootFolder.createFolder(props);
		}
		return folder;
	}

}
