package it.servizidigitali.richieste.common.enumeration;

/**
 * Enumeration per la definizione dei possibili stati assegnabili ad una Richiesta.
 *
 * @author pindi
 *
 */
public enum StatoRichiesta {

	BOZZA, //
	NUOVA, //
	INVIATA, //
	PROTOCOLLATA, //
	CONSEGNATA, //
	IN_LAVORAZIONE, //
	ATTESA_INTEGRAZIONI, //
	INTEGRAZIONI_INSERITE, //
	ANNULLATA, //
	CHIUSA_POSITIVAMENTE, //
	CHIUSA_NEGATIVAMENTE, //
	RIFIUTATA, //
	STATO_NON_DISPONIBILE, //
	DA_AUTORIZZARE, //
	AUTORIZZATA, //
	AUTORIZZATA_MANUALMENTE, //
	ATTESA_PAGAMENTO, //
	ELIMINATA;
}