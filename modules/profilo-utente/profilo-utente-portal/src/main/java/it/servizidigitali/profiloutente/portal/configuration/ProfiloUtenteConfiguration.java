package it.servizidigitali.profiloutente.portal.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration", name = "Configurazioni profilo utente")
public interface ProfiloUtenteConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita il fitro per il check privacy")
	boolean redirectCkeckPrivacyAbilitato();

	@Meta.AD(deflt = "/profilo-utente", required = false, description = "Path pagina check privacy sulla quale effettuare il redirect")
	String redirectCkeckPrivacyPath();

}