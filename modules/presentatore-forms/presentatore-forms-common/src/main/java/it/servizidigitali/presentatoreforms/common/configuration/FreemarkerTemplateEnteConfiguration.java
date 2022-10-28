package it.servizidigitali.presentatoreforms.common.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.presentatoreforms.frontend.configuration.FreemarkerTemplateEnteConfiguration", name = "Configurazioni Templates Freemarker", description = "Configurazioni Template Freemarker per generazione PDF")
public interface FreemarkerTemplateEnteConfiguration {

	@Meta.AD(deflt = "", required = false, name = "Template di default")
	public String defaultAlpacaTemplate();

	@Meta.AD(deflt = "", required = false, name = "Template certificati")
	public String certificatiAlpacaTemplate();

	@Meta.AD(deflt = "", required = false, name = "Template autodichiarazioni")
	public String autoDichiarazioniAlpacaTemplate();

	@Meta.AD(deflt = "/o/it.servizidigitali.presentatoreforms.frontend", required = false, name = "Path modulo presentatore forms")
	public String presentatoreFormsBasePath();

	@Meta.AD(deflt = "/o/portale-istituzionale-theme", required = false, name = "Path modulo tema")
	public String themeBasePath();

}