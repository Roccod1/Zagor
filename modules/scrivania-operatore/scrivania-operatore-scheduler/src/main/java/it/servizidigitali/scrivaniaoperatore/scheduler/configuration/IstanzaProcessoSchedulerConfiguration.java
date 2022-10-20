package it.servizidigitali.scrivaniaoperatore.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.scrivaniaoperatore.scheduler.configuration.IstanzaProcessoSchedulerConfiguration", name = "Configurazioni scheduler istanze processi")
public interface IstanzaProcessoSchedulerConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di avvio istanze processi")
	boolean avvioIstanzaProcessoSchedulerEnabled();

	@Meta.AD(deflt = "0 0/1 * * * ?", required = false, description = "Espressione CRON per lo scheduler di avvio istanze processi (ogni minuto di default)")
	String avvioIstanzaProcessoSchedulerCronExpression();

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di richiesta integrazioni")
	boolean richiestaIntegrazioniSchedulerEnabled();

	@Meta.AD(deflt = "0 0/1 * * * ?", required = false, description = "Espressione CRON per lo scheduler di richiesta integrazioni (ogni minuto di default)")
	String richiestaIntegrazioniSchedulerCronExpression();

}