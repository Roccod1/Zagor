package it.servizidigitali.restservice.internal.resource.v1_0;

import it.servizidigitali.restservice.resource.v1_0.CertificatiResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author pindi
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/certificati.properties",
	scope = ServiceScope.PROTOTYPE, service = CertificatiResource.class
)
public class CertificatiResourceImpl extends BaseCertificatiResourceImpl {
}