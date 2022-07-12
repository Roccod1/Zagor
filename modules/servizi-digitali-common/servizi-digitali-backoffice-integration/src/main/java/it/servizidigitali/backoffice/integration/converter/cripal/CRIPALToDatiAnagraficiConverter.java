package it.servizidigitali.backoffice.integration.converter.cripal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.backoffice.integration.enums.StatoCivile;
import it.servizidigitali.backoffice.integration.enums.TipoCessazioneMatrimonio;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare.Pensione;
import it.servizidigitali.backoffice.integration.util.DateUtils;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.DatiAnagrafici.ComponentiNucleoFamiliare;
import it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.DatiAnagrafici.ComponentiNucleoFamiliare.PensioniList;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.StatoEsteroLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = CRIPALToDatiAnagraficiConverter.class)
public class CRIPALToDatiAnagraficiConverter {

	private static final Log log = LogFactoryUtil.getLog(CRIPALToDatiAnagraficiConverter.class.getName());

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	/**
	 *
	 * @param datiAnagraficiCripal
	 * @return
	 */
	public DatiAnagrafici convert(it.servizidigitali.backoffice.integration.xsd.cripal.anagrafe.output.DatiAnagrafici datiAnagraficiCripal, String codiceISTATComune) {

		DatiAnagrafici datiAnagrafici = null;
		if (datiAnagraficiCripal != null) {
			datiAnagrafici = new DatiAnagrafici();
			datiAnagrafici.setCap(datiAnagraficiCripal.getCap());
			datiAnagrafici.setCodiceIstatComune(codiceISTATComune);
			datiAnagrafici.setDescrizioneVia(datiAnagraficiCripal.getDescrizioneVia());
			datiAnagrafici.setCodiceVia(datiAnagraficiCripal.getCodiceVia());
			datiAnagrafici.setEsponente(datiAnagraficiCripal.getEsponente());
			datiAnagrafici.setInterno(datiAnagraficiCripal.getInterno());
			datiAnagrafici.setNumeroCivico(datiAnagraficiCripal.getNumeroCivico());
			datiAnagrafici.setCodiceCivico(datiAnagraficiCripal.getCodiceCivico());
			datiAnagrafici.setPiano(datiAnagraficiCripal.getPiano());
			datiAnagrafici.setScala(datiAnagraficiCripal.getScala());
			datiAnagrafici.setTelefono(null);
			datiAnagrafici.setToponimoIndirizzo(datiAnagraficiCripal.getToponimoIndirizzo());

			// Nucleo familiare
			List<ComponentiNucleoFamiliare> componentiNucleoCripal = datiAnagraficiCripal.getComponentiNucleoFamiliare();

			if (componentiNucleoCripal != null) {
				List<DatiAnagrafici.ComponenteNucleoFamiliare> componentiNucleoFamiliare = new ArrayList<>();

				for (ComponentiNucleoFamiliare componenteNucleoFamiliareCripal : componentiNucleoCripal) {

					datiAnagrafici.setIdentificativoNucleoFamiliare(String.valueOf(componenteNucleoFamiliareCripal.getIdentificativoNucleoFamiliare()));
					DatiAnagrafici.ComponenteNucleoFamiliare componenteNucleoFamiliare = new DatiAnagrafici.ComponenteNucleoFamiliare();

					// Atto nascita
					boolean attoNascitaTrascitto = componenteNucleoFamiliareCripal.getNumeroAttoNascitaTrascritto() != null
							&& !componenteNucleoFamiliareCripal.getNumeroAttoNascitaTrascritto().equals(0);
					componenteNucleoFamiliare.setAttoNascitaTrascitto(attoNascitaTrascitto);
					if (!attoNascitaTrascitto) {
						componenteNucleoFamiliare
								.setNumeroAttoNascita(componenteNucleoFamiliareCripal.getNumeroAttoNascita() != null ? componenteNucleoFamiliareCripal.getNumeroAttoNascita().toString() : null);
						componenteNucleoFamiliare
								.setAnnoAttoNascita(componenteNucleoFamiliareCripal.getAnnoAttoNascita() != null ? componenteNucleoFamiliareCripal.getAnnoAttoNascita().toString() : null);
						componenteNucleoFamiliare.setParteAttoNascita(componenteNucleoFamiliareCripal.getParteNascita());
						componenteNucleoFamiliare.setSerieAttoNascita(componenteNucleoFamiliareCripal.getSerieNascita());
						componenteNucleoFamiliare.setUfficioAttoNascita(componenteNucleoFamiliareCripal.getUfficioNascita());
						componenteNucleoFamiliare.setCodiceIstatComuneAttoNascita(componenteNucleoFamiliareCripal.getCodiceIstatComuneNascita());

						componenteNucleoFamiliare.setDenominazioneComuneAttoNascita(componenteNucleoFamiliareCripal.getDenominazioneComuneAttoNascita());
						componenteNucleoFamiliare.setVolumeAttoNascita(componenteNucleoFamiliareCripal.getVolumeAttoNascita());
						componenteNucleoFamiliare.setAnnoStringaAttoNascita(componenteNucleoFamiliareCripal.getAnnoStringaAttoNascita());
						componenteNucleoFamiliare.setMeseStringaAttoNascita(componenteNucleoFamiliareCripal.getMeseStringaAttoNascita());
						componenteNucleoFamiliare.setGiornoStringaAttoNascita(componenteNucleoFamiliareCripal.getGiornoStringaAttoNascita());
						componenteNucleoFamiliare.setCognomeNomeAttoNascita(componenteNucleoFamiliareCripal.getCognomeNomeAttoNascita());
					}
					else {
						componenteNucleoFamiliare.setNumeroAttoNascita(
								componenteNucleoFamiliareCripal.getNumeroAttoNascitaTrascritto() != null ? componenteNucleoFamiliareCripal.getNumeroAttoNascitaTrascritto().toString() : null);
						componenteNucleoFamiliare
								.setAnnoAttoNascita(componenteNucleoFamiliareCripal.getAnnoNascitaTrascritto() != null ? componenteNucleoFamiliareCripal.getAnnoNascitaTrascritto().toString() : null);
						componenteNucleoFamiliare.setParteAttoNascita(componenteNucleoFamiliareCripal.getParteNascitaTrascritto());
						componenteNucleoFamiliare.setSerieAttoNascita(componenteNucleoFamiliareCripal.getSerieNascitaTrascritto());
						componenteNucleoFamiliare.setUfficioAttoNascita(componenteNucleoFamiliareCripal.getUfficioNascita());
						componenteNucleoFamiliare.setCodiceIstatComuneAttoNascita(componenteNucleoFamiliareCripal.getCodiceIstatComuneNascitaTrascritto());
						componenteNucleoFamiliare.setCognomeNomeAttoNascita(componenteNucleoFamiliareCripal.getCognomeNomeAttoNascita());
					}
					// Atto matrimonio
					boolean attoMatrimonioTrascitto = componenteNucleoFamiliareCripal.getNumeroAttoMatrimonioTrascritto() != null
							&& !componenteNucleoFamiliareCripal.getNumeroAttoMatrimonioTrascritto().equals(0);
					componenteNucleoFamiliare.setAttoMatrimonioTrascitto(attoMatrimonioTrascitto);
					componenteNucleoFamiliare.setLuogoMatrimonio(componenteNucleoFamiliareCripal.getLuogoMatrimonio());
					componenteNucleoFamiliare.setDataMatrimonio(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataMatrimonio()));
					componenteNucleoFamiliare
							.setAnnoAttoMatrimonio(componenteNucleoFamiliareCripal.getAnnoMatrimonio() != null ? componenteNucleoFamiliareCripal.getAnnoMatrimonio().toString() : null);
					componenteNucleoFamiliare.setCodiceIstatComuneAttoMatrimonio(componenteNucleoFamiliareCripal.getCodiceIstatComuneMatrimonio());
					componenteNucleoFamiliare
							.setNumeroAttoMatrimonio(componenteNucleoFamiliareCripal.getNumeroAttoMatrimonio() != null && !componenteNucleoFamiliareCripal.getNumeroAttoMatrimonio().equals(0)
									? componenteNucleoFamiliareCripal.getNumeroAttoMatrimonio().toString()
									: null);
					componenteNucleoFamiliare.setParteAttoMatrimonio(componenteNucleoFamiliareCripal.getParteMatrimonio());
					componenteNucleoFamiliare.setSerieAttoMatrimonio(componenteNucleoFamiliareCripal.getSerieMatrimonio());
					componenteNucleoFamiliare.setUfficioAttoMatrimonio(componenteNucleoFamiliareCripal.getUfficioMatrimonio());

					componenteNucleoFamiliare.setVolumeAttoMartrimonio(componenteNucleoFamiliareCripal.getVolumeAttoMatrimonio());
					componenteNucleoFamiliare.setDenominazioneComuneAttoMatrimonio(componenteNucleoFamiliareCripal.getDenominazioneComuneAttoMatrimonio());
					componenteNucleoFamiliare.setAnnoStringaAttoMatrimonio(componenteNucleoFamiliareCripal.getAnnoStringaAttoMatrimonio());
					componenteNucleoFamiliare.setMeseStringaAttoMatrimonio(componenteNucleoFamiliareCripal.getMeseStringaAttoMatrimonio());
					componenteNucleoFamiliare.setGiornoStringaAttoMatrimonio(componenteNucleoFamiliareCripal.getGiornoStringaAttoMatrimonio());
					componenteNucleoFamiliare.setCognomeNomeAttoMatrimonio(componenteNucleoFamiliareCripal.getCognomeNomeAttoMatrimonio());
					componenteNucleoFamiliare.setDataNascitaAttoMatrimonio(componenteNucleoFamiliareCripal.getDataNascitaAttoMatrimonio() != null
							? DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaAttoMatrimonio())
							: null);
					componenteNucleoFamiliare.setComuneNascitaAttoMatrimonio(componenteNucleoFamiliareCripal.getComuneNascitaAttoMatrimonio());
					componenteNucleoFamiliare.setCognomeNomeConiugeAttoMatrimonio(componenteNucleoFamiliareCripal.getCognomeNomeConiugeAttoMatrimonio());
					componenteNucleoFamiliare.setDataNascitaConiugeAttoMatrimonio(componenteNucleoFamiliareCripal.getDataNascitaConiugeAttoMatrimonio() != null
							? DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaConiugeAttoMatrimonio())
							: null);
					componenteNucleoFamiliare.setComuneNascitaConiugeAttoMatrimonio(componenteNucleoFamiliareCripal.getComuneNascitaConiugeAttoMatrimonio());

					// Annullamento Matrimonio
					boolean attoAnnullamentoMatrimonioTrascitto = componenteNucleoFamiliareCripal.getNumeroAttoDivorzioTrascritto() != null
							&& !componenteNucleoFamiliareCripal.getNumeroAttoDivorzioTrascritto().equals(0);
					componenteNucleoFamiliare.setAttoAnnullamentoMatrimonioTrascitto(attoAnnullamentoMatrimonioTrascitto);
					componenteNucleoFamiliare.setDataDecorrenzaAnnullamentoMatrimonio(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataDecorrenzaDivorzio()));
					componenteNucleoFamiliare.setNumeroSentenzaAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getNumeroSentenzaDivorzio());

					String tipoDivorzio = componenteNucleoFamiliareCripal.getTipoDivorzio();
					if (tipoDivorzio != null) {
						try {
							componenteNucleoFamiliare.setTipoCessazioneMatrimonio(TipoCessazioneMatrimonio.valueOf(tipoDivorzio));
						}
						catch (Exception e) {
							log.warn("convert :: " + e.getMessage());
							componenteNucleoFamiliare.setTipoCessazioneMatrimonio(EnumerationConverter.convertToTipoCessazioneMatrimonio(tipoDivorzio));
						}
					}
					if (!attoAnnullamentoMatrimonioTrascitto) {
						componenteNucleoFamiliare.setCodiceIstatComuneAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getCodiceIstatComuneTribunaleDivorzio());

						Calendar dataAttoDivorzio = componenteNucleoFamiliareCripal.getDataAttoDivorzio();
						if (dataAttoDivorzio != null) {
							componenteNucleoFamiliare.setDataAttoAnnullamentoMatrimonio(DateUtils.getUniversalDateFromCalendar(dataAttoDivorzio));
							componenteNucleoFamiliare.setAnnoAttoAnnullamentoMatrimonio(String.valueOf(dataAttoDivorzio.get(Calendar.YEAR)));
						}

						componenteNucleoFamiliare.setNumeroAttoAnnullamentoMatrimonio(
								componenteNucleoFamiliareCripal.getNumeroAttoDivorzio() != null && !componenteNucleoFamiliareCripal.getNumeroAttoDivorzio().equals(0)
										? componenteNucleoFamiliareCripal.getNumeroAttoDivorzio().toString()
										: null);
						componenteNucleoFamiliare.setParteAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getParteDivorzio());
						componenteNucleoFamiliare.setSerieAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getSerieDivorzio());
						componenteNucleoFamiliare.setVolumeAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getVolumeDivorzio());
						componenteNucleoFamiliare.setUfficioAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getUfficioDivorzio());
					}
					else {
						componenteNucleoFamiliare.setCodiceIstatComuneAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getCodiceIstatComuneTribunaleDivorzio());
						Calendar dataAttoDivorzioTrascritto = componenteNucleoFamiliareCripal.getDataAttoDivorzioTrascritto();
						if (dataAttoDivorzioTrascritto != null) {
							componenteNucleoFamiliare.setDataAttoAnnullamentoMatrimonio(DateUtils.getUniversalDateFromCalendar(dataAttoDivorzioTrascritto));
							componenteNucleoFamiliare.setAnnoAttoAnnullamentoMatrimonio(String.valueOf(dataAttoDivorzioTrascritto.get(Calendar.YEAR)));
						}
						componenteNucleoFamiliare.setNumeroAttoAnnullamentoMatrimonio(
								componenteNucleoFamiliareCripal.getNumeroAttoDivorzioTrascritto() != null && !componenteNucleoFamiliareCripal.getNumeroAttoDivorzioTrascritto().equals(0)
										? componenteNucleoFamiliareCripal.getNumeroAttoDivorzioTrascritto().toString()
										: null);
						componenteNucleoFamiliare.setParteAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getParteDivorzioTrascritto());
						componenteNucleoFamiliare.setSerieAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getSerieDivorzioTrascritto());
						componenteNucleoFamiliare.setVolumeAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getVolumeDivorzioTrascritto());
						componenteNucleoFamiliare.setUfficioAttoAnnullamentoMatrimonio(componenteNucleoFamiliareCripal.getUfficioDivorzioTrascritto());
					}

					// TODO controllare se Anno Morte Coniuge Trascritto si riferisce ad atto di
					// morte trascritto o atto di divorzio trascritto!!!

					// Atto morte
					boolean attoMorteTrascritto = componenteNucleoFamiliareCripal.getAnnoMorteConiugeTrascritto() != null && !componenteNucleoFamiliareCripal.getAnnoMorteConiugeTrascritto().equals(0);
					componenteNucleoFamiliare.setAttoMorteTrascitto(attoMorteTrascritto);
					if (!attoMorteTrascritto) {
						componenteNucleoFamiliare
								.setNumeroAttoMorte(componenteNucleoFamiliareCripal.getNumeroAttoMorte() != null ? componenteNucleoFamiliareCripal.getNumeroAttoMorte().toString() : null);
						componenteNucleoFamiliare.setParteAttoMorte(componenteNucleoFamiliareCripal.getParteMorte());
						componenteNucleoFamiliare.setSerieAttoMorte(componenteNucleoFamiliareCripal.getSerieMorte());
						componenteNucleoFamiliare.setUfficioAttoMorte(componenteNucleoFamiliareCripal.getUfficioMorte());
						componenteNucleoFamiliare.setAnnoAttoMorte(componenteNucleoFamiliareCripal.getAnnoMorte() != null ? componenteNucleoFamiliareCripal.getAnnoMorte().toString() : null);
						componenteNucleoFamiliare.setCodiceIstatComuneAttoMorte(componenteNucleoFamiliareCripal.getCodiceIstatComuneMorte());
						componenteNucleoFamiliare.setCognomeNomeAttoMorte(componenteNucleoFamiliareCripal.getCognomeNomeAttoMorte());

						componenteNucleoFamiliare.setDenominazioneComuneAttoMorte(componenteNucleoFamiliareCripal.getDenominazioneComuneAttoMorte());
						componenteNucleoFamiliare.setVolumeAttoMorte(componenteNucleoFamiliareCripal.getVolumeAttoMorte());
						componenteNucleoFamiliare.setAnnoStringaAttoMorte(componenteNucleoFamiliareCripal.getAnnoStringaAttoMorte());
						componenteNucleoFamiliare.setMeseStringaAttoMorte(componenteNucleoFamiliareCripal.getMeseStringaAttoMorte());
						componenteNucleoFamiliare.setGiornoStringaAttoMorte(componenteNucleoFamiliareCripal.getGiornoStringaAttoMorte());
						componenteNucleoFamiliare.setComuneNascitaAttoMorte(componenteNucleoFamiliareCripal.getComuneNascitaAttoMorte());
						componenteNucleoFamiliare.setDataNascitaAttoMorte(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaAttoMorte()));
					}
					else {
						// TODO coniuge?!?
						componenteNucleoFamiliare.setNumeroAttoMorte(
								componenteNucleoFamiliareCripal.getNumeroAttoMorteConiugeTrascritto() != null ? componenteNucleoFamiliareCripal.getNumeroAttoMorteConiugeTrascritto().toString()
										: null);
						componenteNucleoFamiliare.setParteAttoMorte(componenteNucleoFamiliareCripal.getParteMorteConiugeTrascritto());
						componenteNucleoFamiliare.setSerieAttoMorte(componenteNucleoFamiliareCripal.getSerieMorteConiugeTrascritto());
						// componenteNucleoFamiliare.setUfficioAttoMorte(componenteNucleoFamiliareCripal.getConiugeTrascritto());
						componenteNucleoFamiliare.setAnnoAttoMorte(
								componenteNucleoFamiliareCripal.getAnnoMorteConiugeTrascritto() != null ? componenteNucleoFamiliareCripal.getAnnoMorteConiugeTrascritto().toString() : null);
						componenteNucleoFamiliare.setCodiceIstatComuneAttoMorte(componenteNucleoFamiliareCripal.getCodiceIstatComuneMorteConiugeTrascritto());
						componenteNucleoFamiliare.setCognomeNomeAttoMorte(componenteNucleoFamiliareCripal.getCognomeNomeAttoMorte());
						componenteNucleoFamiliare.setComuneNascitaAttoMorte(componenteNucleoFamiliareCripal.getComuneNascitaAttoMorte());
						componenteNucleoFamiliare.setDataNascitaAttoMorte(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaAttoMorte()));
					}

					// Unione civile
					Integer numeroAttoUnioneCivile = componenteNucleoFamiliareCripal.getNumeroAttoUnioneCivile();
					componenteNucleoFamiliare.setNumeroAttoUnioneCivile(numeroAttoUnioneCivile != null ? numeroAttoUnioneCivile.toString() : null);
					componenteNucleoFamiliare.setParteAttoUnioneCivile(componenteNucleoFamiliareCripal.getParteAttoUnioneCivile());
					componenteNucleoFamiliare.setSerieAttoUnioneCivile(componenteNucleoFamiliareCripal.getSerieAttoUnioneCivile());
					componenteNucleoFamiliare
							.setAnnoAttoUnioneCivile(componenteNucleoFamiliareCripal.getAnnoAttoUnioneCivile() != null ? componenteNucleoFamiliareCripal.getAnnoAttoUnioneCivile().toString() : null);
					componenteNucleoFamiliare.setUfficioAttoUnioneCivile(componenteNucleoFamiliareCripal.getUfficioAttoUnioneCivile());
					componenteNucleoFamiliare.setCodiceIstatComuneAttoUnioneCivile(componenteNucleoFamiliareCripal.getCodiceIstatComuneAttoUnioneCivile());
					componenteNucleoFamiliare.setDenominazioneComuneAttoUnioneCivile(componenteNucleoFamiliareCripal.getDenominazioneComuneAttoUnioneCivile());
					Calendar dataAttoUnioneCivile = componenteNucleoFamiliareCripal.getDataAttoUnioneCivile();
					if (dataAttoUnioneCivile != null) {
						componenteNucleoFamiliare.setDataAttoUnioneCivile(DateUtils.getUniversalDateFromCalendar(dataAttoUnioneCivile));
					}
					componenteNucleoFamiliare.setVolumeAttoUnioneCivile(componenteNucleoFamiliareCripal.getVolumeAttoUnioneCivile());
					componenteNucleoFamiliare.setRegimePatrimonialeAttoUnioneCivile(componenteNucleoFamiliareCripal.getRegimePatrimonialeAttoUnioneCivile());
					componenteNucleoFamiliare.setCognomeAttoUnioneCivile(componenteNucleoFamiliareCripal.getCognomeAttoUnioneCivile());
					componenteNucleoFamiliare.setNomeAttoUnioneCivile(componenteNucleoFamiliareCripal.getNomeAttoUnioneCivile());
					componenteNucleoFamiliare.setDataNascitaAttoUnioneCivile(componenteNucleoFamiliareCripal.getDataNascitaAttoUnioneCivile() != null
							? DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaAttoUnioneCivile())
							: null);
					componenteNucleoFamiliare.setEtaAttoUnioneCivile(componenteNucleoFamiliareCripal.getEtaAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneNascitaAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneNascitaAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneResidenzaAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneResidenzaAttoUnioneCivile());
					componenteNucleoFamiliare.setAttoNascitaAttoUnioneCivile(componenteNucleoFamiliareCripal.getAttoNascitaAttoUnioneCivile());
					componenteNucleoFamiliare.setAttoNascitaTrascrittoAttoUnioneCivile(componenteNucleoFamiliareCripal.getAttoNascitaTrascrittoAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneAttoNascitaTrascrittoAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneAttoNascitaTrascrittoAttoUnioneCivile());
					componenteNucleoFamiliare.setCognomeUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getCognomeUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setNomeUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getNomeUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setDenominazioneUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getDenominazioneUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setDataNascitaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getDataNascitaUnitoAttoUnioneCivile() != null
							? DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascitaUnitoAttoUnioneCivile())
							: null);
					componenteNucleoFamiliare.setEtaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getEtaUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneNascitaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneNascitaUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneResidenzaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneResidenzaUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setAttoNascitaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getAttoNascitaUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneAttoNascitaUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneAttoNascitaUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setAttoNascitaTrascrittoUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getAttoNascitaTrascrittoUnitoAttoUnioneCivile());
					componenteNucleoFamiliare.setComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneAttoNascitaTrascrittoUnitoAttoUnioneCivile());

					componenteNucleoFamiliare.setCognomeTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getCognomeTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setNomeTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getNomeTestimone1AttoUnioneCivile());
					Calendar dataNascitaTestimone1AttoUnioneCivile = componenteNucleoFamiliareCripal.getDataNascitaTestimone1AttoUnioneCivile();
					componenteNucleoFamiliare.setDataNascitaTestimone1AttoUnioneCivile(
							dataNascitaTestimone1AttoUnioneCivile != null ? DateUtils.getUniversalDateFromCalendar(dataNascitaTestimone1AttoUnioneCivile) : null);
					componenteNucleoFamiliare.setComuneNascitaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneNascitaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setProvinciaNascitaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getProvinciaNascitaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setStatoEsteroNascitaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getStatoEsteroNascitaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setComuneResidenzaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneResidenzaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setProvinciaResidenzaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getProvinciaResidenzaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setStatoEsteroResidenzaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getStatoEsteroResidenzaTestimone1AttoUnioneCivile());
					componenteNucleoFamiliare.setCittadinanzaTestimone1AttoUnioneCivile(componenteNucleoFamiliareCripal.getCittadinanzaTestimone1AttoUnioneCivile());

					componenteNucleoFamiliare.setCognomeTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getCognomeTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setNomeTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getNomeTestimone2AttoUnioneCivile());
					Calendar dataNascitaTestimone2AttoUnioneCivile = componenteNucleoFamiliareCripal.getDataNascitaTestimone2AttoUnioneCivile();
					componenteNucleoFamiliare.setDataNascitaTestimone2AttoUnioneCivile(
							dataNascitaTestimone2AttoUnioneCivile != null ? DateUtils.getUniversalDateFromCalendar(dataNascitaTestimone2AttoUnioneCivile) : null);
					componenteNucleoFamiliare.setComuneNascitaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneNascitaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setProvinciaNascitaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getProvinciaNascitaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setStatoEsteroNascitaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getStatoEsteroNascitaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setComuneResidenzaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getComuneResidenzaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setProvinciaResidenzaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getProvinciaResidenzaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setStatoEsteroResidenzaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getStatoEsteroResidenzaTestimone2AttoUnioneCivile());
					componenteNucleoFamiliare.setCittadinanzaTestimone2AttoUnioneCivile(componenteNucleoFamiliareCripal.getCittadinanzaTestimone2AttoUnioneCivile());

					// Vedovanza
					boolean attoVedovanzaTrascitto = false;
					componenteNucleoFamiliare.setAttoVedovanzaTrascitto(attoVedovanzaTrascitto);
					componenteNucleoFamiliare.setDataAttoVedovanza(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataAttoVedovanza()));
					componenteNucleoFamiliare
							.setNumeroAttoVedovanza(componenteNucleoFamiliareCripal.getNumeroAttoVedovanza() != null && !componenteNucleoFamiliareCripal.getNumeroAttoVedovanza().equals(0)
									? componenteNucleoFamiliareCripal.getNumeroAttoVedovanza().toString()
									: null);
					componenteNucleoFamiliare.setParteAttoVedovanza(componenteNucleoFamiliareCripal.getParteVedovanza());
					componenteNucleoFamiliare.setSerieAttoVedovanza(componenteNucleoFamiliareCripal.getSerieVedovanza());
					componenteNucleoFamiliare.setUfficioAttoVedovanza(componenteNucleoFamiliareCripal.getUfficioVedovanza());
					componenteNucleoFamiliare.setVolumeAttoVedovanza(componenteNucleoFamiliareCripal.getVolumeVedovanza());

					componenteNucleoFamiliare.setCap(datiAnagraficiCripal.getCap());
					componenteNucleoFamiliare.setCellulare(null);
					componenteNucleoFamiliare.setCittadinanzaItaliana(componenteNucleoFamiliareCripal.isCittadinanzaItaliana());
					componenteNucleoFamiliare.setCodiceFiscale(componenteNucleoFamiliareCripal.getCodiceFiscale());
					componenteNucleoFamiliare.setCodiceIstatComuneNascita(componenteNucleoFamiliareCripal.getCodiceIstatComuneNascita());
					componenteNucleoFamiliare.setCodiceIstatComuneResidenza(codiceISTATComune);

					if (componenteNucleoFamiliareCripal.getStatoEsteroNascita() != null && !componenteNucleoFamiliareCripal.getStatoEsteroNascita().isEmpty()) {
						StatoEstero statoEsteroByDenominazione = statoEsteroLocalService.getStatoEsteroByDenominazione(componenteNucleoFamiliareCripal.getStatoEsteroNascita());
						if (statoEsteroByDenominazione != null) {
							componenteNucleoFamiliare.setCodiceStatoEsteroNascita(statoEsteroByDenominazione.getCodiceStato());
							componenteNucleoFamiliare.setDescrizioneStatoEsteroNascita(statoEsteroByDenominazione.getDenominazione());
						}
						else {
							componenteNucleoFamiliare.setDescrizioneStatoEsteroNascita(componenteNucleoFamiliareCripal.getStatoEsteroNascita());
						}
					}

					componenteNucleoFamiliare.setCognome(componenteNucleoFamiliareCripal.getCognome());
					componenteNucleoFamiliare.setCodiceFiscaleConiuge(null);
					componenteNucleoFamiliare.setCognomeNomeConiuge(componenteNucleoFamiliareCripal.getCognomeNomeConiuge());

					componenteNucleoFamiliare.setDataMorte(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataMorte()));
					componenteNucleoFamiliare.setDataNascita(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataNascita()));
					componenteNucleoFamiliare.setDataRilascioCartaIdentita(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataCartaIdentita()));
					componenteNucleoFamiliare.setDataSentenzaAnnullamentoMatrimonio(DateUtils.getUniversalDateFromCalendar(componenteNucleoFamiliareCripal.getDataSentenzaDivorzio()));
					componenteNucleoFamiliare.setDescrizioneComuneEsteroNascita(componenteNucleoFamiliareCripal.getDescrizioneComuneEsteroNascita());
					componenteNucleoFamiliare.setDescrizioneVia(datiAnagrafici.getDescrizioneVia());
					componenteNucleoFamiliare.setEsponente(datiAnagrafici.getEsponente());
					componenteNucleoFamiliare.setIdentificativo(componenteNucleoFamiliareCripal.getIdentificativo());
					componenteNucleoFamiliare.setInterno(datiAnagrafici.getInterno());
					componenteNucleoFamiliare.setNome(componenteNucleoFamiliareCripal.getNome());

					componenteNucleoFamiliare.setNumeroCartaIdentita(componenteNucleoFamiliareCripal.getNumeroCartaIdentita());
					componenteNucleoFamiliare.setNumeroCivico(datiAnagrafici.getNumeroCivico());

					List<PensioniList> pensioniList = componenteNucleoFamiliareCripal.getPensioniList();
					if (pensioniList != null) {
						List<Pensione> pensioni = new ArrayList<>();
						for (PensioniList pensioniList2 : pensioniList) {
							Pensione pensione = new Pensione();
							pensione.setCodicePensione(pensioniList2.getCodicePensione());
							pensione.setNumeroPensione(pensioniList2.getNumeroPensione());
							pensioni.add(pensione);
						}
						componenteNucleoFamiliare.setPensioni(pensioni);
					}
					componenteNucleoFamiliare.setPiano(datiAnagrafici.getPiano());
					componenteNucleoFamiliare.setProfessione(componenteNucleoFamiliareCripal.getProfessione());

					// Realazione parentela
					String relazioneParentela = componenteNucleoFamiliareCripal.getRelazioneParentela();
					if (relazioneParentela != null) {
						try {
							componenteNucleoFamiliare.setRelazioneParentela(RelazioneParentela.valueOf(relazioneParentela));
						}
						catch (Exception e) {
							log.warn("convert :: " + e.getMessage());
							componenteNucleoFamiliare.setRelazioneParentela(EnumerationConverter.convertToRelazioneParentela(relazioneParentela));
						}
					}
					componenteNucleoFamiliare.setScala(datiAnagrafici.getScala());
					componenteNucleoFamiliare.setSesso(componenteNucleoFamiliareCripal.getSesso());

					// Stato civile
					String statoCivile = componenteNucleoFamiliareCripal.getStatoCivile();
					if (statoCivile != null) {
						try {
							componenteNucleoFamiliare.setStatoCivile(StatoCivile.valueOf(statoCivile));
						}
						catch (Exception e) {
							log.warn("convert :: " + e.getMessage());
							componenteNucleoFamiliare.setStatoCivile(EnumerationConverter.convertToStatoCivile(statoCivile));
						}
					}
					componenteNucleoFamiliare.setTelefono(null);
					componenteNucleoFamiliare.setTitoloStudio(componenteNucleoFamiliareCripal.getTitoloStudio());
					componenteNucleoFamiliare.setToponimoIndirizzo(datiAnagrafici.getToponimoIndirizzo());

					componentiNucleoFamiliare.add(componenteNucleoFamiliare);
					datiAnagrafici.setComponentiNucleoFamiliare(componentiNucleoFamiliare);
				}
			}
		}

		return datiAnagrafici;
	}
}
