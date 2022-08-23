package it.servizidigitali.gestionecomunicazioni.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.gestionecomunicazioni.configuration.InvioComunicazioniSchedulerConfiguration", name = "Configurazioni scheduler invio comunicazioni")
public interface InvioComunicazioniSchedulerConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di invio comunicazioni")
	boolean invioComunicazioniSchedulerEnabled();

	@Meta.AD(deflt = "*/30 0 * * * ?", required = false, description = "Espressione CRON per lo scheduler di invio comunicazioni (ogni 30 min di default)")
	String invioComunicazioniSchedulerCronExpression();

}