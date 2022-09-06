package it.servizidigitali.scrivaniaoperatore.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.scrivaniaoperatore.scheduler.configuration.AvvioIstanzaProcessoSchedulerConfiguration", name = "Configurazioni scheduler avvio istanza processi")
public interface AvvioIstanzaProcessoSchedulerConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di avvio istanza processi")
	boolean avvioIstanzaProcessoSchedulerEnabled();

	@Meta.AD(deflt = "*/60 * * * * ?", required = false, description = "Espressione CRON per lo scheduler di avvio istanza processi (ogni minuto di default)")
	String avvioIstanzaProcessoSchedulerCronExpression();

}