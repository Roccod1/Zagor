package it.servizidigitali.chatbot.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.chatbot.scheduler.configuration.InvioCertificatiSchedulerConfiguration", name = "Configurazioni scheduler invio certificati")
public interface InvioCertificatiSchedulerConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di invio certificati")
	boolean invioCertificatiSchedulerEnabled();

	@Meta.AD(deflt = "0 0/1 * * * ?", required = false, description = "Espressione CRON per lo scheduler di invio certificati (ogni minuto di default)")
	String invioCertificatiSchedulerCronExpression();

}