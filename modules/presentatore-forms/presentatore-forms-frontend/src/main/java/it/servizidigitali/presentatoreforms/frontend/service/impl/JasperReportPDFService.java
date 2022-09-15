package it.servizidigitali.presentatoreforms.frontend.service.impl;

import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.presentatoreforms.frontend.exception.PDFServiceException;
import it.servizidigitali.presentatoreforms.frontend.service.PDFService;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

/**
 * @author pindi
 *
 */
@Component(name = "jasperReportPDFService", immediate = true, service = PDFService.class)
public class JasperReportPDFService implements PDFService {

	private static final String JR_PARAMETER_DESTINAZIONE_USO = "destinazioneUso";

	private static final String JR_PARAMETER_LOGO_COMUNE = "logoComune";
	private static final String JR_PARAMETER_COMUNE = "comune";
	private static final String JR_PARAMETER_COMUNI = "comuni";
	private static final String JR_PARAMETER_COMUNI_ESTERI = "comuniEsteri";
	private static final String JR_PARAMETER_PROVINCE = "province";
	private static final String JR_PARAMETER_STATI = "stati";

	private static final String JR_PARAMETER_TITOLI_STUDIO = "titoliStudio";
	private static final String JR_PARAMETER_STATI_CIVILI = "statiCivili";
	private static final String JR_PARAMETER_RELAZIONI_PARENTELA = "relazioniParentela";

	private static final String JR_PARAMETER_TITOLI_STUDIO_ASCOT = "titoliStudioASCOT";
	private static final String JR_PARAMETER_TIPI_REGISTRAZIONE_ASCOT = "tipiRegistrazioneASCOT";
	private static final String JR_PARAMETER_TIPI_VEICOLO_ASCOT = "tipiVeicoloASCOT";
	private static final String JR_PARAMETER_STATI_CIVILI_ASCOT = "statiCiviliASCOT";
	private static final String JR_PARAMETER_RELAZIONI_PARENTELA_ASCOT = "relazioniParentelaASCOT";
	private static final String JR_PARAMETER_POSIZIONI_PROFESSIONALI_ASCOT = "posizioniProfessionaliASCOT";
	private static final String JR_PARAMETER_ENTI_RILASCIO_PATENTE_ASCOT = "entiRilascioPatenteASCOT";
	private static final String JR_PARAMETER_CONDIZIONI_NON_PROFESSIONALI_ASCOT = "condizioniNonProfessionaliASCOT";
	private static final String JR_PARAMETER_ALTRI_MOTIVI_ISCRIZIONE_ASCOT = "altriMotiviIscrizioneASCOT";

	@Override
	public byte[] generaPDFCertificato(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			Long idDestinazioneUso, String numeroBollo, ThemeDisplay themeDisplay) throws PDFServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] generaPDFAlpacaForm(String codiceFiscaleRichiedente, String codiceFiscaleComponente, AlpacaJsonStructure alpacaStructure, Richiesta richiesta, String fileName,
			Long idDestinazioneUso, String numeroBollo, boolean isDelega, String dettagliRichiesta, ThemeDisplay themeDisplay) throws PDFServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
