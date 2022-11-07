package it.servizidigitali.presentatoreforms.frontend.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.presentatoreforms.frontend.configuration.PresentatoreFormsEnteConfiguration", name = "Configurazioni Presentatore Forms Ente")
public interface PresentatoreFormsEnteConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita il filtro di sicurezza per l'accesso ai servizi esposti dal presentatore forms")
	boolean securityFilterEnabled();

	@Meta.AD(deflt = "3145728", required = false, name = "Dimensione massima upload file richieste (default 3 Mbyte)")
	public Long maxUploadRichiesteFileSize();
}