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
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiVariazioniDomicilio.VariazioneDomicilio;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.implementation.backoffice.DatiAnagraficiJsonEnrich;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.EnrichmentModel;
import it.servizidigitali.presentatoreforms.common.util.EnrichmentUtilService;

/**
 * @author ZONNOG
 *
 */
@Component(name = "certificatoVariazioniDomiciliari", immediate = true, service = DatiAnagraficiJsonEnrich.class)
public class CertificatoVariazioniDomiciliari implements DatiAnagraficiJsonEnrich {

	private static final Log log = LogFactoryUtil.getLog(CertificatoVariazioniDomiciliari.class.getName());

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	private final String certificatoVariazioniDomiciliariKey = "certificatoVariazioniDomiciliari";

	@Override
	public <T> void enrich(EnrichmentModel<T> enrichmentModel) {

		T sourceObject = enrichmentModel.getSourceObject();
		JsonObject alpacaJsonData = enrichmentModel.getAlpacaJsonData();
		if (sourceObject instanceof DatiAnagrafici) {

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
			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleo = ((DatiAnagrafici) sourceObject).getComponentiNucleoFamiliare();

			List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiList = null;
			if (enrichmentModel.getUserPreferences().getCodiceFiscaleComponente() != null) {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleComponente())).collect(Collectors.toList());
			}
			else {
				componentiList = componentiNucleo.stream().filter(p -> p.getCodiceFiscale().equals(enrichmentModel.getUserPreferences().getCodiceFiscaleRichiedente())).collect(Collectors.toList());
			}
			if (componentiList.size() == 1) {
				DatiAnagrafici.ComponenteNucleoFamiliare componente = componentiList.get(0);

				JsonObject certificatoVariazioniDomiciliariContainer = alpacaJsonData.getAsJsonObject(certificatoVariazioniDomiciliariKey);
				if (certificatoVariazioniDomiciliariContainer != null) {

					// Nome e Cognome
					String nome = componente.getNome();
					String cognome = componente.getCognome();
					String nomeCognome = nome + ' ' + cognome;
					certificatoVariazioniDomiciliariContainer.addProperty("nomeCognome", nomeCognome);

					// Codice Fiscale
					String codiceFiscale = "Cod. Fisc " + componente.getCodiceFiscale();
					certificatoVariazioniDomiciliariContainer.addProperty("codiceFiscale", codiceFiscale);

					// Data e luogo nascita //
					String rigaNascita = EnrichmentUtilService.getBornLabelByGenderDichiarante(componente) + "il ";
					rigaNascita += EnrichmentUtilService.getDataNascitaComponente(componente) + " a ";

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
							rigaNascita += nomeComuneNascita;
							Provincia provincia = comune.getProvincia();
							if (provincia != null) {
								siglaProvinciaNascita = provincia.getSigla();
								rigaNascita += " (" + siglaProvinciaNascita + ")";
							}
						}
						else {
							try {
								ComuneEstero comuneEstero = comuneEsteroLocalService.getComuneEsteroByCodice(Integer.parseInt(codiceIstat));
								rigaNascita += comuneEstero.getDenominazione();
							}
							catch (Exception e) {
								rigaNascita = "";
							}
						}
					}
					else {

						if (componente.getDescrizioneComuneEsteroNascita() != null) {
							nomeComuneNascita = componente.getDescrizioneComuneEsteroNascita();
							rigaNascita += nomeComuneNascita;
							if (componente.getCodiceStatoEsteroNascita() != null) {
								StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
								nomeComuneNascita = nomeComuneNascita + " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
								rigaNascita += " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
							}
						}
						else if (componente.getCodiceStatoEsteroNascita() != null) {
							StatoEstero statoEsteroByCodiceStato = statoEsteroLocalService.getStatoEsteroByCodiceStato(componente.getCodiceStatoEsteroNascita());
							rigaNascita += " (" + statoEsteroByCodiceStato.getDenominazione() + ")";
						}
					}
					certificatoVariazioniDomiciliariContainer.addProperty("dataComuneNascita", rigaNascita);

					// cittaEmissione + Data odierna

					String citta = organization.getName().toUpperCase();

					Date today = new Date();
					String dftoday = df.format(today);
					String cittaEmissione = citta + ", " + dftoday;
					certificatoVariazioniDomiciliariContainer.addProperty("cittaEmissione", cittaEmissione);

					// Salvo
					alpacaJsonData.add(certificatoVariazioniDomiciliariKey, certificatoVariazioniDomiciliariContainer);
					enrichmentModel.setAlpacaJsonData(alpacaJsonData);
				}
			}
		}

		if (sourceObject instanceof DatiVariazioniDomicilio) {
			DatiVariazioniDomicilio datiIndirizzo = (DatiVariazioniDomicilio) sourceObject;
			JsonObject certificatoVariazioniDomiciliariContainer = alpacaJsonData.getAsJsonObject(certificatoVariazioniDomiciliariKey);
			if (certificatoVariazioniDomiciliariContainer != null) {
				// Variazione Domicilio

				List<VariazioneDomicilio> listaDatiInridizzo = datiIndirizzo.getVariazioniDomicilio();
				for (VariazioneDomicilio vd : listaDatiInridizzo) {

					Date datVar = vd.getDataInizioDomicilio();
					String dataVariazione = "dal " + df.format(datVar);

					String via = " in " + vd.getIndirizzo();
					String civico = " n. " + vd.getNumeroCivico();
					String scala = " scala " + vd.getScala();
					String piano = " piano " + vd.getPiano();
					Comune comuneByCodiceISTAT = comuneLocalService.getComuneByCodiceISTAT(vd.getCodiceIstatComune());
					String com = "";
					if (comuneByCodiceISTAT != null) {
						com = " a " + comuneByCodiceISTAT.getDenominazione();
					}

					String variazioniResidenza = dataVariazione + via + civico + scala + piano + com;

					certificatoVariazioniDomiciliariContainer.addProperty("variazioniResidenza", variazioniResidenza);
				}
				// Salvo
				alpacaJsonData.add(certificatoVariazioniDomiciliariKey, certificatoVariazioniDomiciliariContainer);
				enrichmentModel.setAlpacaJsonData(alpacaJsonData);
			}
		}
	}
}
