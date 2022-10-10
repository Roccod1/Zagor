package it.servizidigitali.communication.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.communication.configuration.TemplateComunicazioniEnteConfiguration", name = "Configurazioni template comunicazioni Ente")
public interface TemplateComunicazioniEnteConfiguration {

	@Meta.AD(required = false, deflt = "${nome_ente}  - Notifica Cambiamento di stato richiesta ${richiesta_id}", name = "Template oggetto email cambio stato richiesta. Campi che possono essere valorizzati: ${nome_ente}, ${richiesta_id}")
	String cambioStatoRichiestaEmailSubjectTemplate();

	@Meta.AD(required = false, deflt = "Gentile ${user_full_name},<br/> La richiesta in oggetto, da lei inoltrata con descrizione: \"${oggetto_richiesta}\" ha subito un aggiornamento dallo stato <b>${vecchio_stato_richiesta}</b> allo stato <b>${nuovo_stato_richiesta}</b>.", name = "Template body email cambio stato richiesta. Campi che possono essere valorizzati: ${user_full_name}, ${oggetto_richiesta}, ${vecchio_stato_richiesta}, ${nuovo_stato_richiesta}")
	String cambioStatoRichiestaEmailBodyTemplate();
}