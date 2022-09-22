package it.servizidigitali.communication.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.communication.configuration.CommunicationConfiguration", name = "Configurazioni modulo comunicazioni")
public interface CommunicationConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita l'invio dei messagi tramite Communication Engine")
	boolean communicationEngineSendEnabled();

	@Meta.AD(deflt = "http://localhost:8082", required = false, description = "Base path servizi REST Communication Engine")
	String communicationEngineBasePath();

}