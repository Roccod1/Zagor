package it.servizidigitali.communication.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.communication.configuration.CommunicationConfiguration", name = "Configurazioni modulo comunicazioni")
public interface CommunicationConfiguration {

	@Meta.AD(deflt = "http://localhost:8081", required = false, description = "Base path servizi REST Communication Engine")
	String communicationEngineBasePath();

}