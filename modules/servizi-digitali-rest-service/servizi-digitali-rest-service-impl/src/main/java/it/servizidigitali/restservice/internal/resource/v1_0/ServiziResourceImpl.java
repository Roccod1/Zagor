package it.servizidigitali.restservice.internal.resource.v1_0;

import it.servizidigitali.restservice.resource.v1_0.ServiziResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author pindi
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/servizi.properties",
	scope = ServiceScope.PROTOTYPE, service = ServiziResource.class
)
public class ServiziResourceImpl extends BaseServiziResourceImpl {
}