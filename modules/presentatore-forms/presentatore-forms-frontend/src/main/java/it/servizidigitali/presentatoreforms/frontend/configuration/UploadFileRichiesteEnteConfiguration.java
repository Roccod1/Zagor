package it.servizidigitali.presentatoreforms.frontend.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.presentatoreforms.frontend.configuration.UploadFileRichiesteEnteConfiguration", name = "Configurazioni Upload File")
public interface UploadFileRichiesteEnteConfiguration {

	@Meta.AD(deflt = "3145728", required = false, name = "Dimensione massima upload file richieste (default 3 Mbyte)")
	public Long maxUploadRichiesteFileSize();
}