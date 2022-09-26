package it.servizidigitali.presentatoreforms.frontend.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.presentatoreforms.frontend.configuration.FreemarkerTemplateEnteConfiguration", name = "Configurazione Templates Freemarker", description = "Configurazione Template Freemarker per generazione PDF")
public interface FreemarkerTemplateEnteConfiguration {

	@Meta.AD(deflt = "", required = false, name = "Template di default")
	public String defaultAlpacaTemplate();

	@Meta.AD(deflt = "", required = false, name = "Template certificati")
	public String certificatiAlpacaTemplate();
	
	@Meta.AD(deflt = "", required = false, name = "Template autodichiarazioni")
	public String autoDichiarazioniAlpacaTemplate();

}