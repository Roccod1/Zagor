package it.servizidigitali.camunda.integration.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.camunda.integration.configuration.CamundaConfiguration", name = "Configurazioni Camunda")
public interface CamundaConfiguration {

	@Meta.AD(deflt = "http://servizi-digitali-dev:8082", required = false, description = "Path API Camunda")
	String camundaApiBasePath();

}