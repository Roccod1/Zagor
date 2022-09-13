package it.servizidigitali.restservice.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author pindi
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/servizi-digitali-rest-service",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=ServiziDigitaliRestService"
	},
	service = Application.class
)
@Generated("")
public class ServiziDigitaliRestServiceApplication extends Application {
}