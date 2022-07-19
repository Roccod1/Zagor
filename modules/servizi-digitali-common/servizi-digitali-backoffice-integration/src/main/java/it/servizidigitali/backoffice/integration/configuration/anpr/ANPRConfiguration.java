package it.servizidigitali.backoffice.integration.configuration.anpr;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.backoffice.integration.configuration.anpr.ANPRConfiguration", name = "Configurazioni ANPR")
public interface ANPRConfiguration {

	@Meta.AD(deflt = "/opt/config/keystore/888191-CO-0000.p12", required = false, description = "Path keystor P12 contenente le credenziali di accesso al servizio ANPR")
	String pathKeystore();

	@Meta.AD(deflt = "4DA682FF", required = false, description = "Password del keystore P12")
	String passwordKeystore();

	@Meta.AD(deflt = "888191-CO-0000", required = false, description = "Alias certificato presente nel keystore P12")
	String aliasKeystore();

	@Meta.AD(deflt = "https://wsfree.anpr.interno.it", required = false, description = "URL WS ANPR")
	String wsUrl();

	@Meta.AD(deflt = "12345", required = false)
	String idApplicazione();

	@Meta.AD(deflt = "USERSFREETEST191", required = false)
	String idOperatore();

	@Meta.AD(deflt = "888191-CO-0000", required = false)
	String idPostazione();

	@Meta.AD(deflt = "888191", required = false)
	String idSede();

	@Meta.AD(required = false)
	String tipoInvio();

	@Meta.AD(deflt = "3", required = false, description = "Numero di tentativi di invio al sistema ANPR (default 3)")
	int numeroTentativiInvio();
}