package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiElettorali.PosizioneElettorale;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.service.integration.enumeration.BackofficeServiceExceptionLanguageCode;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "datiCertificatoIscrizioneListeElettoraliJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class DatiCertificatoIscrizioneListeElettoraliJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(DatiCertificatoIscrizioneListeElettoraliJsonEnrich.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;


	private final DateFormat dfdash = new SimpleDateFormat("dd-MM-yyyy");

	private final String fieldNameDataContainerKey = "certificatoIscrizioneListeElettorali";
	public static String luogoRes = "";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {
		T datiAnagrafici = enrichmentModel.getSourceObject();
		if (datiAnagrafici instanceof DatiAnagrafici) {

			Organization organization;
			try {
				organization = organizationLocalService.getOrganization(enrichmentModel.getOrganizationId());
			}
			catch (PortalException e) {
				log.error("enrich :: " + e.getMessage(), e);
				throw new BackofficeServiceException("Errore durante il caricamento dell'organizzazione " + enrichmentModel.getOrganizationId(), e);
			}
			Comune comuneByCodice = comuneLocalService
					.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			UserPreferences userPreferences = enrichmentModel.getUserPreferences();
			if (userPreferences.getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);
				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainerKey);
				if (fieldDataContainer != null) {

					// Condizioni scaricamento certificato
					if (componente.getDataMorte() != null) {
						throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.SOGGETTO_DECEDUTO_CERTIFICATO_NON_DISPONIBILE);
					}

					// Nome e cognome //
					fieldDataContainer.addProperty("nomeCognome", componente.getNome() + " " + componente.getCognome());

					// CF //
					fieldDataContainer.addProperty("rigaCodiceFiscale", "Cod. Fisc. " + componente.getCodiceFiscale());

					// Data e luogo nascita //

					String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "il ";
					rigaNascita = rigaNascita + EnrichmentUtilService.getDataNascitaComponente(componente) + " a ";

					// TODO va controllata la cittadinanza e mostrato il comune italiano o
					// estero a
					// seconda dei casi o si dà per scontata cittadinanza italiana?
					String nomeComuneNascita = "";
					String siglaProvinciaNascita = "";

					String codiceIstat = componente.getCodiceIstatComuneNascita();
					if (codiceIstat != null) {
						Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
						if (comune != null) {
							nomeComuneNascita = comune.getDenominazione();
							rigaNascita = rigaNascita + nomeComuneNascita;
							Provincia provincia = comune.getProvincia();
							if (provincia != null) {
								siglaProvinciaNascita = provincia.getSigla();
								rigaNascita = rigaNascita + " (" + siglaProvinciaNascita + ")";
							}
						}
						else {
							try {
								ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
								rigaNascita = rigaNascita + comuneEstero.getDenominazione();
							}
							catch (Exception e) {
								rigaNascita = "";
							}
						}
					}
					else {

						if (componente.getDescrizioneComuneEsteroNascita() != null) {
							nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
							rigaNascita = rigaNascita + nomeComuneNascita;
							if (componente.getCodiceStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
								rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
							}
						}
						else if (componente.getCodiceStatoEsteroNascita() != null) {
							StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
							rigaNascita = rigaNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
						}
					}
					fieldDataContainer.addProperty("rigaNascita", rigaNascita);

					// luogo residenza//
					String luogoResidenza = "residente a ";

					String comuneResidenza = "-";
					String provinciaResidenza = "-";

					Comune comune = comuneLocalService.getComuneByCodiceISTAT(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString());

					if (comune != null) {
						comuneResidenza = comune.getDenominazione();

						if (comune.getProvincia() != null) {
							provinciaResidenza = comune.getProvincia().getSigla();
						}
					}
					luogoResidenza = luogoResidenza + comuneResidenza + " (" + provinciaResidenza + ")";
					luogoRes = comuneResidenza + " (" + provinciaResidenza + ")";
					fieldDataContainer.addProperty("rigaLuogoResidenza", luogoResidenza);

					// indirizzo //
					String indirizzo = ((DatiAnagrafici) datiAnagrafici).getDescrizioneVia();
					if (indirizzo != null) {

						if (((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() != null) {
							indirizzo = ((DatiAnagrafici) datiAnagrafici).getToponimoIndirizzo() + " " + indirizzo;
						}

						indirizzo = indirizzo + " ";

						// numero civico //
						String numeroCivico = ((DatiAnagrafici) datiAnagrafici).getNumeroCivico();
						if (numeroCivico != null) {
							numeroCivico = " n. " + numeroCivico;
						}
						else {
							numeroCivico = "";
						}

						// esponente del civico //
						String esponente = ((DatiAnagrafici) datiAnagrafici).getEsponente();
						if (esponente != null) {
							esponente = " " + esponente;
						}
						else {
							esponente = "";
						}

						// scala //
						String scala = ((DatiAnagrafici) datiAnagrafici).getScala();
						if (scala != null) {
							scala = " scala " + scala;
						}
						else {
							scala = "";
						}

						// piano //
						String piano = ((DatiAnagrafici) datiAnagrafici).getPiano();
						if (piano != null) {
							piano = " piano " + piano;
						}
						else {
							piano = "";
						}

						// interno //
						String interno = ((DatiAnagrafici) datiAnagrafici).getInterno();
						if (interno != null) {
							interno = " interno " + interno;
						}
						else {
							interno = "";
						}

						fieldDataContainer.addProperty("rigaIndirizzo", "in " + indirizzo + numeroCivico + esponente + scala + piano + interno);
					}

					// luogo e data del certificato //

					String comuneFirma = organization.getName().toUpperCase();

					Date dataEmissione = new Date();
					String infoVarie = "<h4><br>" + comuneFirma + ", " + dfdash.format(dataEmissione) + "</h4>";
					fieldDataContainer.addProperty("infoVarie", infoVarie);

					alpacaJsonData.add(fieldNameDataContainerKey, fieldDataContainer);
					enrichmentModel.setAlpacaJsonData(alpacaJsonData);
				}
			}
		}

		// parte dati elettorali

		if (datiAnagrafici instanceof DatiElettorali) {

			JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

			JsonObject fieldDataContainer = alpacaJsonData.getAsJsonObject(fieldNameDataContainerKey);
			if (fieldDataContainer != null) {
				List<PosizioneElettorale> posizioniElettorali = ((DatiElettorali) datiAnagrafici).getPosizioniElettorali();

				String rigaListaGeneraleESezionale = "<br><h5>RISULTA ISCRITTO NELLE LISTE ELETTORALI DEL COMUNE DI --</h5>";
				if (posizioniElettorali != null) {

					if (fieldDataContainer != null) {

						// controllo scaricamento certificato
						if (datiAnagrafici == null || posizioniElettorali == null || posizioniElettorali.isEmpty()) {
							throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.POSIZIONI_ELETTORALI_VUOTE);

						}
						rigaListaGeneraleESezionale = "<br><h5>RISULTA ISCRITTO NELLE LISTE ELETTORALI DEL COMUNE DI " + luogoRes + "</h5><h5>LISTA GENERALE N°. ";

						PosizioneElettorale ps = posizioniElettorali.get(0);
						if (ps.getNumeroListaGenerale() != null) {
							rigaListaGeneraleESezionale = rigaListaGeneraleESezionale + ps.getNumeroListaGenerale() + "</h5>";
						}
						else {
							rigaListaGeneraleESezionale += "</h5>";
						}

						rigaListaGeneraleESezionale += "<h5>LISTA SEZIONALE N°. ";
						if (ps.getNumeroListaSezionale() != null) {
							rigaListaGeneraleESezionale += ps.getNumeroListaSezionale() + "</h5>";
						}
						else {
							rigaListaGeneraleESezionale += "</h5>";
						}

					}
				}
				fieldDataContainer.addProperty("certificazione", rigaListaGeneraleESezionale);

				// Salvo
				alpacaJsonData.add(fieldNameDataContainerKey, fieldDataContainer);
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);

			}
		}
	}
}
