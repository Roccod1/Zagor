package it.servizidigitali.backoffice.integration.configuration.scheduler;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.backoffice.integration.configuration.scheduler.UserCacheSchedulerConfiguration", name = "Configurazioni Scheduler Memoria Cache Utente")
public interface UserCacheSchedulerConfiguration {

	@Meta.AD(deflt = "true", required = false, description = "Abilita lo scheduler per la pulizia della Memory Cache utente")
	boolean userCacheCleanerSchedulerEnabled();

	@Meta.AD(deflt = "*/30 0 * * * ?", required = false, description = "Espressione CRON per lo scheduler pulizia della Memory Cache utente (ogni 30 min di default)")
	String userCacheCleanerSchedulerCronExpression();
}