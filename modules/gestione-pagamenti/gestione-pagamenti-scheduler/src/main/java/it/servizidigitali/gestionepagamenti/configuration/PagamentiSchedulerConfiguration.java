package it.servizidigitali.gestionepagamenti.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@Meta.OCD(id = "it.servizidigitali.gestionepagamenti.configuration.PagamentiSchedulerConfiguration", name = "Configurazioni scheduler pagamenti")
public interface PagamentiSchedulerConfiguration {

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di verifica pagamenti")
	boolean verificaPagamentiSchedulerEnabled();

	@Meta.AD(deflt = "*/5 0 * * * ?", required = false, description = "Espressione CRON per lo scheduler di verifica pagamenti (ogni 5 min di default)")
	String verificaPagamentiSchedulerCronExpression();

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita lo scheduler di verifica avvisi di pagamento")
	boolean verificaAvvisiPagamentoSchedulerEnabled();

	@Meta.AD(deflt = "*/5 0 * * * ?", required = false, description = "Espressione CRON per lo scheduler di verifica avvisi di pagamento (ogni 5 min di default)")
	String verificaAvvisiPagamentoSchedulerCronExpression();

}