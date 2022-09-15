package it.servizidigitali.presentatoreforms.frontend.util.alpaca;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare;

/**
 *
 */
public class EnrichmentUtilService {

	private final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private final static DateFormat dateFormatSenzaGiorno = new SimpleDateFormat("MM/yyyy");
	private final static DateFormat dateFormatSenzaGiornoMese = new SimpleDateFormat("yyyy");
	private final static SimpleDateFormat sdfMese = new SimpleDateFormat("MMMM", Locale.ITALIAN);

	private static String caratteriUnita[] = { " ", "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove", "dieci", "undici", "dodici", "tredici", "quattordici", "quindici",
			"sedici", "diciassette", "diciotto", "diciannove" };
	private static String caratteriDecine[] = { "", " ", "venti", "trenta", "quaranta", "cinquanta", "sessanta", "settanta", "ottanta", "novanta" };

	/*
	 * Metodo utilizzato in certificati di nascita, in cui giorno mese e anno devono essere stampati
	 * in forma letterale
	 */
	public static String toCharactersForm(int value) {

		String result = "";

		int migliaia = (value / 1000) % 1000;
		int centinaia = (value / 100) % 10;
		int decine = (value / 10) % 10;
		int unita = value % 10;

		// migliaia
		if (migliaia > 0) {
			if (migliaia == 1) {
				result += "mille";
			}
			else {
				result += caratteriUnita[migliaia] + "mila";
			}
		}

		// centinaia
		if (centinaia > 0) {
			if (centinaia == 1) {
				result += "cento";
			}
			else {
				result += caratteriUnita[centinaia] + "cento";
			}
		}

		// verifico se le ultime due cifre rappresentano un numero da 1 a 19
		if ((value % 100) > 0 && (value % 100) < 20) {
			// i numeri da uno a 19 devono essere presi dal vettore caratteriUnita[]
			result += caratteriUnita[(value % 100)];
		}

		if ((value % 100) > 0 && (value % 100) >= 20) {
			if (unita == 1 || unita == 8) {
				// nel caso in cui abbiamo 21, 31, 41,... Oppure 28, 38, 48, ...
				result += caratteriDecine[decine].substring(0, caratteriDecine[decine].length() - 1) + caratteriUnita[unita];
			}
			else {

				result += caratteriDecine[decine] + caratteriUnita[unita];
			}
		}
		return result;
	}

	public static String getBornLabelByGenderDichiarante(ComponenteNucleoFamiliare dichiarante) {
		if (dichiarante.getSesso() != null) {
			if (dichiarante.getSesso().equals("F")) {
				return "nata ";
			}
			else {
				return "nato ";
			}
		}
		return "nato/a ";
	}

	public static String getDeathLabelByGenderDichiarante(ComponenteNucleoFamiliare dichiarante) {
		if (dichiarante.getSesso() != null) {
			if (dichiarante.getSesso().equals("F")) {
				return "deceduta ";
			}
			else {
				return "deceduto ";
			}
		}
		return "deceduto/a ";
	}

	/**
	 *
	 * @param componenteNucleoFamiliare
	 * @return
	 */
	public static String getDataNascitaComponente(ComponenteNucleoFamiliare componenteNucleoFamiliare) {
		String dataNascitaString = "";
		Date dataNascita = componenteNucleoFamiliare.getDataNascita();
		if (dataNascita != null) {
			if (componenteNucleoFamiliare.isDataNascitaSenzaGiorno()) {
				dataNascitaString = dateFormatSenzaGiorno.format(dataNascita);
			}
			else if (componenteNucleoFamiliare.isDataNascitaSenzaGiornoMese()) {
				dataNascitaString = dateFormatSenzaGiornoMese.format(dataNascita);
			}
			else {
				dataNascitaString = dateFormat.format(dataNascita);
			}
		}
		return dataNascitaString;
	}

	public static String[] getStringsDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int giornoInt = calendar.get(Calendar.DAY_OF_MONTH);
		int annoInt = calendar.get(Calendar.YEAR);
		String meseString = sdfMese.format(date.getTime()).toUpperCase();
		String giornoString = EnrichmentUtilService.toCharactersForm(giornoInt).toUpperCase();
		String annoString = EnrichmentUtilService.toCharactersForm(annoInt).toUpperCase();
		String[] dataString = { giornoString, meseString, annoString };
		return dataString;
	}
}
