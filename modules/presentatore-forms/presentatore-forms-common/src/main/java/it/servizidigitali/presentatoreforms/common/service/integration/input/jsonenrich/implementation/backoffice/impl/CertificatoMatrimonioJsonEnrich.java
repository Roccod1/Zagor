package it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.impl;

import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare;
import it.servizidigitali.presentatoreforms.common.service.integration.enumeration.BackofficeServiceExceptionLanguageCode;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "certificatoMatrimonioJsonEnrich", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class CertificatoMatrimonioJsonEnrich implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(CertificatoMatrimonioJsonEnrich.class.getName());

	@Reference
	private OrganizationLocalService organizationLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public final String certificatoMatrimonioKey = "certificatoMatrimonio";
	public final String autorizzazioneKey = "autorizzazione";

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
			
			// Nucleo familiare
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) datiAnagrafici).getComponentiNucleoFamiliare();

			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			if (enrichmentModel.getUserPreferences().getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equalsIgnoreCase(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);

				JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();

				JsonObject certificatoMatrimonioContainer = alpacaJsonData.getAsJsonObject(certificatoMatrimonioKey);
				if (certificatoMatrimonioContainer != null) {

					// Controllo se il certificato può essere scaricato
					if (componente.getAnnoAttoMatrimonio() == null) {
						throw new BackofficeServiceException(BackofficeServiceExceptionLanguageCode.ATTO_NON_PRESENTE);
					}

					// Nome e Cognome (cognome nome)
					String cognomeNome = "";
					
					// il dato specifico per l'atto vince sul dato generico del componente.
					if (!Validator.isBlank(componente.getCognomeNomeAttoMatrimonio())) {
						cognomeNome = componente.getCognomeNomeAttoMatrimonio();
					}
					certificatoMatrimonioContainer.addProperty("nomeCognome", "<b>" + cognomeNome.toUpperCase()  + "</b>");

					// Data nascita //
					String dataNascita = "";
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (componente.getDataNascitaAttoMatrimonio() != null) {
						dataNascita = "IL " + df.format(componente.getDataNascitaAttoMatrimonio());
					}
					certificatoMatrimonioContainer.addProperty("dataNascita", dataNascita);

					// luogo nascita
					String luogoNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "IN ";
					
					// il dato specifico per l'atto vince sul dato generico del componente
					if (!Validator.isBlank(componente.getComuneNascitaAttoMatrimonio())) {
						luogoNascita += componente.getComuneNascitaAttoMatrimonio().toUpperCase();
					}
					certificatoMatrimonioContainer.addProperty("luogoNascita", luogoNascita.toUpperCase());

					// NomeConiuge 
					String nomeConiuge = componente.getCognomeNomeConiugeAttoMatrimonio();
					if (nomeConiuge != null) {
						nomeConiuge = "<b>" + nomeConiuge + "</b>";
						certificatoMatrimonioContainer.addProperty("nomeCognomeConiuge", nomeConiuge.toUpperCase());
					}
					
					// luogo nascita coniuge
					//FIXME manca dato sesso coniuge
					String luogoNascitaConiuge =  EnrichmentUtilService.getBornLabelByGenderDichiarante(new ComponenteNucleoFamiliare()) + "IN ";
					luogoNascitaConiuge =
							componente.getComuneNascitaConiugeAttoMatrimonio() != null ?
									luogoNascitaConiuge + componente.getComuneNascitaConiugeAttoMatrimonio() : "";
					
					if (!Validator.isBlank(luogoNascitaConiuge)) {
						certificatoMatrimonioContainer.addProperty("luogoNascitaConiuge", luogoNascitaConiuge.toUpperCase());
					}
		
					// Data nascita //
					String dataNascitaConiuge = "IL ";
					dataNascitaConiuge =
							componente.getDataNascitaConiugeAttoMatrimonio() != null ?
									dataNascitaConiuge + df.format(componente.getDataNascitaConiugeAttoMatrimonio()) : "";
					
					if (!Validator.isBlank(dataNascitaConiuge)) {
						certificatoMatrimonioContainer.addProperty("dataNascitaConiuge", dataNascitaConiuge);
					}
			
					// dataMatrimonio
					String giornoMatrimonio = "";
					String meseMatrimonio = "";
					String annoMatrimonio = "";
					String rigaGiornoMeseMatrimonio = "";
					String rigaAnnoMatrimonio = "";
					
					giornoMatrimonio = componente.getGiornoStringaAttoMatrimonio() != null ? componente.getGiornoStringaAttoMatrimonio() : "";
					
					meseMatrimonio = componente.getMeseStringaAttoMatrimonio() != null ? componente.getMeseStringaAttoMatrimonio() : "";
					
					annoMatrimonio = componente.getAnnoStringaAttoMatrimonio() != null ? componente.getAnnoStringaAttoMatrimonio() : "";
					
					rigaGiornoMeseMatrimonio += !Validator.isBlank(giornoMatrimonio) ? "il giorno " + giornoMatrimonio : "";
					rigaGiornoMeseMatrimonio += !Validator.isBlank(rigaGiornoMeseMatrimonio) ? " del mese di " : "nel mese di ";
					rigaGiornoMeseMatrimonio = !Validator.isBlank(meseMatrimonio) ? rigaGiornoMeseMatrimonio + meseMatrimonio : "";
														
					rigaAnnoMatrimonio += !Validator.isBlank(rigaGiornoMeseMatrimonio) ? " dell'anno " : "nell'anno ";
					rigaAnnoMatrimonio = !Validator.isBlank(annoMatrimonio) ? rigaAnnoMatrimonio + annoMatrimonio : "";
					
					String dataMatrString =
							(!Validator.isBlank(rigaGiornoMeseMatrimonio) && !Validator.isBlank(rigaAnnoMatrimonio)) ?
							rigaGiornoMeseMatrimonio + "<br>" + rigaAnnoMatrimonio : rigaGiornoMeseMatrimonio + rigaAnnoMatrimonio;
					
					certificatoMatrimonioContainer.addProperty("dataMatrimonio","<p>" + dataMatrString.toUpperCase() + "</p>");

					// luogo matrimonio //		
					
					/* OLD
					String codiceIstatMatrimonio = componente.getCodiceIstatComuneAttoMatrimonio();
					Comune comuneMatrimonio = comuneService.getComuneByCodiceISTAT(codiceIstatMatrimonio);
					if (comuneMatrimonio != null) {
						String luogoMatrimonio = comuneMatrimonio.getDenominazione();
						Provincia provinciaMatrimonio = comuneMatrimonio.getProvincia();
						if (provinciaMatrimonio != null) {
							luogoMatrimonio += " (" + provinciaMatrimonio.getSigla() + ")";
						}
						certificatoMatrimonioContainer.addProperty("luogoMatrimonio","<p>" + "IN " + luogoMatrimonio.toUpperCase() + "</p>");
					}
					*/

					// NEW
					String luogoMatrimonio = componente.getDenominazioneComuneAttoMatrimonio();
					if (!Validator.isBlank(luogoMatrimonio)) {
						certificatoMatrimonioContainer.addProperty("luogoMatrimonio","<p>" + "IN " + luogoMatrimonio.toUpperCase() + "</p>");
					}
					
					// attoMatrimonio
					String numeroAttoMatrimonio = componente.getNumeroAttoMatrimonio();
					String parteMatrimonio = componente.getParteAttoMatrimonio();
					String serieMatrimonio = componente.getSerieAttoMatrimonio();
					String annoAttoMatrimonio = componente.getAnnoAttoMatrimonio();
					String volumeAttoMatrimonio = componente.getVolumeAttoMartrimonio();
					String ufficioAttoMatrimonio = componente.getUfficioAttoMatrimonio() != null ? componente.getUfficioAttoMatrimonio().toUpperCase() : "";
					
					String attoMatrimonio = "";
					
					attoMatrimonio += !Validator.isBlank(annoAttoMatrimonio) ? "ANNO " + annoAttoMatrimonio : "";
					attoMatrimonio += !Validator.isBlank(parteMatrimonio) ? " PARTE " + parteMatrimonio : "";
					attoMatrimonio += !Validator.isBlank(serieMatrimonio) ? " SERIE " + serieMatrimonio : "";
					attoMatrimonio += !Validator.isBlank(numeroAttoMatrimonio) ? " N. " + numeroAttoMatrimonio : "";
					attoMatrimonio += !Validator.isBlank(volumeAttoMatrimonio) ? "<br>volume " + volumeAttoMatrimonio : "";
					
					attoMatrimonio = attoMatrimonio.toUpperCase();
					
					if (!Validator.isBlank(ufficioAttoMatrimonio)) {
						attoMatrimonio +=
								!Validator.isBlank(volumeAttoMatrimonio) ?
										"&emsp;&emsp;&emsp;" + ufficioAttoMatrimonio :
										"<br> " + ufficioAttoMatrimonio;
					}

					certificatoMatrimonioContainer.addProperty("attoMatrimonio", "<p>" + attoMatrimonio + "</p>");
		
					// cittaEmissione + Data odierna
					String citta = organization.getName().toUpperCase();
					Date today = new Date();
					String dftoday = df.format(today);
					String cittaEmissione = citta + ", " + dftoday;
					certificatoMatrimonioContainer.addProperty("cittaEmissione", "<p><br> "+ cittaEmissione.toUpperCase() + "</p>");
		
					alpacaJsonData.add(certificatoMatrimonioKey, certificatoMatrimonioContainer);
					enrichmentModel.setAlpacaJsonData(alpacaJsonData);
				}
			
			}
		}
	}
}
