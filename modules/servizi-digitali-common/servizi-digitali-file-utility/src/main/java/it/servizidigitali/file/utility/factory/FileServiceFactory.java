package it.servizidigitali.file.utility.factory;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import it.servizidigitali.file.utility.configuration.AlfrescoCMISConfiguration;
import it.servizidigitali.file.utility.service.FileService;

/**
 * @author pindi
 *
 */
@Component(name = "fileServiceFactory", immediate = true, service = FileServiceFactory.class, configurationPid = "it.servizidigitali.file.utility.configuration.AlfrescoCMISConfiguration")
public class FileServiceFactory {

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	private volatile List<FileService> fileServices;

	private volatile AlfrescoCMISConfiguration alfrescoCMISConfiguration;

	@Reference(target = "(component.name=documentLibraryFileServiceImpl)")
	private FileService documentLibraryFileServiceImpl;

	@Reference(target = "(component.name=alfrescoFileServiceImpl)")
	private FileService alfrescoFileServiceImpl;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		alfrescoCMISConfiguration = ConfigurableUtil.createConfigurable(AlfrescoCMISConfiguration.class, props);
	}

	/**
	 *
	 * @return
	 */
	public FileService getActiveFileService() {
		if (alfrescoCMISConfiguration.alfrescoCmisIntegrationEnabled()) {
			return alfrescoFileServiceImpl;
		}
		return documentLibraryFileServiceImpl;
	}

}
