package it.servizidigitali.file.utility.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.file.utility.configuration.AlfrescoCMISConfiguration", name = "Configurazioni Alfresco")
public interface AlfrescoCMISConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita l'integrazione del sistema con Alfresco tramite CMIS")
	boolean alfrescoCmisIntegrationEnabled();

	@Meta.AD(deflt = "http://localhost:8080/alfresco/api/-default-/public/cmis/versions/1.1/atom", required = false, description = "CMIS Atom URL")
	String alfrescoCmisAtomUrl();

	@Meta.AD(deflt = "admin", required = false, description = "CMIS Atom user")
	String alfrescoCmisAtomUser();

	@Meta.AD(deflt = "admin", required = false, description = "CMIS Atom password")
	String alfrescoCmisAtomPassword();
}