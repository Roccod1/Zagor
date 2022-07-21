package it.servizidigitali.file.converter.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.file.converter.configuration.FileConverterConfiguration", name = "Configurazioni conversioni file")
public interface FileConverterConfiguration {

	@Meta.AD(deflt = "wkhtmltopdf", required = false, description = "Path eseguibile wkhtmltopdf")
	String wkhtmltopdfCommandPath();

	@Meta.AD(deflt = "--window-status=ready_to_print", required = false, description = "Parametri (chiave=valore) da aggiungere all'esecuzione del comando 'wkhtmltopdf'")
	String[] wkhtmltopdfKeyValueParams();

}