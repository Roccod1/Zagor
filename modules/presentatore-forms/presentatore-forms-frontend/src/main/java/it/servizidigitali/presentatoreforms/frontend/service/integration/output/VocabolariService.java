package it.servizidigitali.presentatoreforms.frontend.service.integration.output;

import java.util.Map;
import java.util.TreeMap;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.presentatoreforms.frontend.comparator.VocabolarioComparator;

@Component(name = "vocabolariService", immediate = true, service = VocabolariService.class)
public class VocabolariService {

	// Vocabolario Tipo Registrazione
	public Map<String, String> getVocabolarioTipoRegistrazione() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("1", "provengono dallo stesso nucleo familiare e, quindi, avevano già la stessa residenza (presentare una sola dichiarazione);");
		vocabolario.put("2",
				"provengono da nuclei familiari diversi e, quindi, avevano residenze diverse (presentare una dichiarazione per ogni diversa provenienza).In tal caso nella dichiarazione di colui/colei che non è l´intestatario/a della scheda di famiglia, deve essere necessariamente compilata la sezione relativa alla coabitazione.");

		return vocabolario;
	}

	// Vocabolario Altri Motivi Iscrizione
	public Map<String, String> getVocabolarioAltriMotiviIscrizione() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("3", "Ricomparsa da irreperibilita’");
		vocabolario.put("6", "Ricomparsa per mancato rinnovo permesso di soggiorno");

		return vocabolario;
	}

	// Vocabolario Tipi Veicolo
	public Map<String, String> getVocabolarioTipiVeicolo() {

		Map<String, String> vocabolario = new TreeMap<String, String>();
		vocabolario.put("A", "Autoveicolo");
		vocabolario.put("C", "Ciclomotore");
		vocabolario.put("M", "Motoveicolo");
		vocabolario.put("R", "Rimorchio");

		return vocabolario;
	}

	// Vocabolario Enti Rilascio Patente
	public Map<String, String> getVocabolarioEntiRilascioPatente() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("1", "Prefettura");
		vocabolario.put("2", "Motorizzazione");

		return vocabolario;
	}

	// Vocabolario Posizioni Professionali
	public Map<String, String> getVocabolarioPosizioniProfessionali() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("0", "Condizione non professionale o att. disoccupato");
		vocabolario.put("1", "Imprenditore/Libero professionista");
		vocabolario.put("2", "Dirigente/Impiegato");
		vocabolario.put("3", "Lavoratore in proprio");
		vocabolario.put("4", "Operaio e assimilati");
		vocabolario.put("5", "Coadiuvante");

		return vocabolario;
	}

	// Vocabolario Condizioni Non Professionali
	public Map<String, String> getVocabolarioCondizioniNonProfessionali() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("0", "Nessuna condizione");
		vocabolario.put("1", "Casalinga");
		vocabolario.put("2", "Studente");
		vocabolario.put("3", "Disoccupato/in cerca di prima occupazione");
		vocabolario.put("4", "Pensionato/Ritirato dal lavoro");
		vocabolario.put("5", "Altra condizione non professionale");

		return vocabolario;
	}

	// Vocabolario Stati Civili
	public Map<String, String> getVocabolarioStatiCivili() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("1", "Celibe/nubile");
		vocabolario.put("2", "Coniugato/coniugata");
		vocabolario.put("3", "Vedovo/vedova");
		vocabolario.put("4", "Divorziato/divorziata");
		vocabolario.put("9", "Ignoto");

		return vocabolario;
	}

	// Vocabolario Titoli Di Studio
	public Map<String, String> getVocabolarioTitoliDiStudio() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("1", "Nessun titolo");
		vocabolario.put("2", "Analfabeta");
		vocabolario.put("3", "Terza elementare");
		vocabolario.put("4", "Quinta elementare");
		vocabolario.put("5", "Licenza elementare");
		vocabolario.put("6", "Licenza avv. prof.");
		vocabolario.put("7", "Licenza media");
		vocabolario.put("8", "Diploma");
		vocabolario.put("9", "Laurea");

		return vocabolario;
	}

	// Vocabolario Relazioni Di Parentela
	public Map<String, String> getVocabolarioRelazioniDiParentela() {

		Map<String, String> vocabolario = new TreeMap<String, String>(new VocabolarioComparator());
		vocabolario.put("1", "Intestatario scheda");
		vocabolario.put("2", "Marito/moglie");
		vocabolario.put("3", "Figlio/figlia");
		vocabolario.put("4", "Nipote (figlio/a di figlio/a)");
		vocabolario.put("5", "Pronipote");
		vocabolario.put("6", "Padre/madre");
		vocabolario.put("7", "Nonno/nonna");
		vocabolario.put("8", "Bisnonno/bisnonna");
		vocabolario.put("9", "Fratello/sorella");
		vocabolario.put("10", "Nipote (figlio/a di fratello/sorella)");
		vocabolario.put("11", "Zio/zia");
		vocabolario.put("12", "Cugino/cugina");
		vocabolario.put("13", "Altro/a parente (fino al 6^grado)");
		vocabolario.put("14", "Figliastro/figliastra");
		vocabolario.put("15", "Patrigno/matrigna");
		vocabolario.put("16", "Genero/nuora");
		vocabolario.put("17", "Suocero/suocera");
		vocabolario.put("18", "Cognato/cognata");
		vocabolario.put("19", "Fratellastro/sorellastra");
		vocabolario.put("20", "Nipote (figlio/a di cognato/a)");
		vocabolario.put("21", "Zio/zia (marito/moglie di zio/a)");
		vocabolario.put("22", "Altro/a affine (fino al 6^ grado)");
		vocabolario.put("23", "Convivente in famiglia");
		vocabolario.put("30", "Responsabile di convivenza");
		vocabolario.put("31", "Membro di convivenza");
		return vocabolario;
	}

	public String getKeyFromMap(Map<String, String> vocabolarioRelazioniDiParentela, String substring) {
		if (vocabolarioRelazioniDiParentela != null) {
			for (Map.Entry<String, String> entry : vocabolarioRelazioniDiParentela.entrySet()) {
				if (entry.getValue().trim().toLowerCase().contains(substring.trim().toLowerCase())) {
					return entry.getKey();
				}
			}
		}
		return null;
	}

}
