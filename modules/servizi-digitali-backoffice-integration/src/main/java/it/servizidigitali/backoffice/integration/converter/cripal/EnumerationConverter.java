/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.servizidigitali.backoffice.integration.converter.cripal;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TipoCessazioneMatrimonio;
import it.servizidigitali.backoffice.integration.util.EnumerationUtils;

/**
 * Classe per la conversione delle enumeration.
 *
 * @author Gianluca Pindinelli
 *
 */
public class EnumerationConverter {

	public static RelazioneParentela convertToRelazioneParentela(String relazioneParentela) {

		if (relazioneParentela == null) {
			return null;
		}

		RelazioneParentela relazioneParentelaEnum = null;

		if (relazioneParentela.toLowerCase().contains("Capo famiglia".toLowerCase())) {
			relazioneParentelaEnum = RelazioneParentela.INTESTATARIO_SCHEDA;
		}
		else {
			relazioneParentelaEnum = EnumerationUtils.searchEnum(RelazioneParentela.class, relazioneParentela);
		}

		return relazioneParentelaEnum;

	}

	public static StatoCivile convertToStatoCivile(String statoCivile) {

		if (statoCivile == null) {
			return null;
		}
		StatoCivile statoCivileEnum = null;

		if (statoCivile.toLowerCase().contains("Coniugat".toLowerCase())) {
			statoCivileEnum = StatoCivile.CONIUGATO_CONIUGATA;
		}
		else {
			statoCivileEnum = EnumerationUtils.searchEnum(StatoCivile.class, statoCivile);
		}

		return statoCivileEnum;

	}

	public static TipoCessazioneMatrimonio convertToTipoCessazioneMatrimonio(String tipoCessazioneMatrimonio) {

		if (tipoCessazioneMatrimonio == null) {
			return null;
		}

		TipoCessazioneMatrimonio tipoCessazioneMatrimonioEnum = EnumerationUtils.searchEnum(TipoCessazioneMatrimonio.class, tipoCessazioneMatrimonio);

		return tipoCessazioneMatrimonioEnum;

	}

}
