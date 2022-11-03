package it.servizidigitali.presentatoreforms.common.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoFirmaDigitale;
import it.servizidigitali.file.utility.exception.SignatureVerificationException;
import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.signature.SignatureVerification;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.presentatoreforms.common.model.DatiFileAllegato;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;

@Component(name = "allegatiRichiestaService", immediate = true, service = AllegatoRichiestaService.class)
public class AllegatoRichiestaService {

	private static final Log log = LogFactoryUtil.getLog(AllegatoRichiestaService.class.getName());

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private DLAppService dlAppService;

	@Reference
	private SignatureVerification signatureVerification;

	/**
	 *
	 * @param allegato
	 * @param nomeFile
	 * @param servizio
	 * @param richiestaId
	 * @param definizioneAllegatoId
	 * @param userName
	 * @param userId
	 * @param groupId
	 * @throws Exception
	 */
	public void salvaAllegatoRichiesta(byte[] allegato, String nomeFile, Servizio servizio, long richiestaId, Long definizioneAllegatoId, String userName, long userId, long groupId) throws Exception {

		try {
			if (Validator.isNotNull(allegato)) {
				InputStream stream = new ByteArrayInputStream(allegato);
				if (Validator.isNotNull(allegato)) {
					String descrizione = null;
					if (definizioneAllegatoId != null && !definizioneAllegatoId.equals(0L)) {
						try {
							DefinizioneAllegato definizioneAllegato = definizioneAllegatoLocalService.getDefinizioneAllegato(definizioneAllegatoId);
							descrizione = "Allegato '" + definizioneAllegato.getDenominazione() + "'";
						}
						catch (PortalException e) {
							log.error("salvaAllegatiRichiesta :: " + e.getMessage(), e);
						}
					}

					String mimeType = MimeTypesUtil.getContentType(stream, nomeFile);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, stream, mimeType, userId,
							groupId);
					creaAllegatoRichiesta(idDocumentale, nomeFile, nomeFile, descrizione, servizio.getNome(), richiestaId, definizioneAllegatoId, false, true, userId, userName, groupId, userId);
				}
			}
		}
		catch (Exception e) {
			log.error("Errore durante il caricamento del file : " + e.getMessage(), e);
			throw e;
		}

	}

	/**
	 *
	 * @param idDocumentale
	 * @param nomeFile
	 * @param titolo
	 * @param descrizione
	 * @param nomeServizio
	 * @param richiestaId
	 * @param definizioneAllegatoId
	 * @param principale
	 * @param visibile
	 * @param userId
	 * @param userName
	 * @param groupId
	 * @param companyId
	 */
	public void creaAllegatoRichiesta(String idDocumentale, String nomeFile, String titolo, String descrizione, String nomeServizio, long richiestaId, Long definizioneAllegatoId, boolean principale,
			boolean visibile, long userId, String userName, long groupId, long companyId) {
		AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());

		if (Validator.isNotNull(idDocumentale)) {
			allegatoRichiesta.setGroupId(groupId);
			allegatoRichiesta.setCompanyId(companyId);
			allegatoRichiesta.setUserId(userId);
			allegatoRichiesta.setUserName(userName);
			allegatoRichiesta.setRichiestaId(richiestaId);
			allegatoRichiesta.setIdDocumentale(idDocumentale);
			allegatoRichiesta.setDefinizioneAllegatoId(definizioneAllegatoId);
			allegatoRichiesta.setPrincipale(principale);
			allegatoRichiesta.setNome(nomeFile);
			allegatoRichiesta.setTitolo(titolo);
			allegatoRichiesta.setDescrizione(descrizione);
			allegatoRichiesta.setVisibile(visibile);

			allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);
		}
	}

	/**
	 *
	 * @param allegato
	 * @param servizio
	 * @param richiestaId
	 * @param userName
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @throws Exception
	 */
	public void salvaDocumentoPrincipaleRichiesta(byte[] allegato, Servizio servizio, long richiestaId, String userName, long userId, long groupId, long companyId) throws Exception {
		try {
			if (Validator.isNotNull(allegato)) {
				InputStream stream = new ByteArrayInputStream(allegato);
				String nomeFile = "richiesta-" + richiestaId + ".pdf";
				String descrizione = "Richiesta servizio '" + servizio.getNome() + "' - ID: " + richiestaId;
				if (Validator.isNotNull(allegato)) {
					String mimeType = MimeTypesUtil.getContentType(stream, nomeFile);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, stream, mimeType, userId,
							groupId);

					if (Validator.isNotNull(idDocumentale)) {
						creaAllegatoRichiesta(idDocumentale, nomeFile, nomeFile, descrizione, servizio.getNome(), richiestaId, null, true, true, userId, userName, groupId, companyId);
					}
				}
			}
		}
		catch (Exception e) {
			log.error("Errore durante il caricamento del file firmato : " + e.getMessage(), e);
			throw e;
		}
	}

	/**
	 *
	 * @param certificato
	 * @param servizio
	 * @param richiestaId
	 * @param userName
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public String salvaCertificato(byte[] certificato, Servizio servizio, long richiestaId, String userName, long userId, long groupId, long companyId) throws Exception {

		String idDocumentale = null;

		try {

			if (Validator.isNotNull(certificato)) {
				InputStream is = new ByteArrayInputStream(certificato);
				String nomeFile = "richiesta-" + richiestaId + ".pdf";
				String descrizione = "Richiesta servizio '" + servizio.getNome() + "' - ID: " + richiestaId;

				if (Validator.isNotNull(is)) {
					String mimeType = MimeTypesUtil.getContentType(is, nomeFile);
					idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, is, mimeType, userId, groupId);

					if (Validator.isNotNull(idDocumentale)) {
						creaAllegatoRichiesta(idDocumentale, nomeFile, nomeFile, descrizione, servizio.getNome(), richiestaId, null, true, true, userId, userName, groupId, companyId);
					}
				}

			}

		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}

		return idDocumentale;
	}

	/**
	 *
	 * @param idDocumentale
	 * @return
	 * @throws Exception
	 */
	public byte[] getCertificato(String idDocumentale) throws Exception {
		byte[] certificato = null;

		try {
			if (Validator.isNotNull(idDocumentale)) {
				FileEntry certificatoFileEntry = dlAppService.getFileEntry(Long.valueOf(idDocumentale));

				if (Validator.isNotNull(certificatoFileEntry)) {
					InputStream is = certificatoFileEntry.getContentStream();

					if (Validator.isNotNull(is)) {
						certificato = is.readAllBytes();
					}
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}

		return certificato;
	}

	/**
	 *
	 * @param definizioneAllegatoId
	 * @return
	 */
	public DatiFileAllegato getModelloAllegato(long definizioneAllegatoId) {
		DatiFileAllegato modello = null;
		DefinizioneAllegato allegato = null;

		try {
			if (definizioneAllegatoId > 0) {
				allegato = definizioneAllegatoLocalService.getDefinizioneAllegato(definizioneAllegatoId);

				if (allegato.getFileEntryId() > 0) {
					FileEntry templateFileEntry = dlAppService.getFileEntry(allegato.getFileEntryId());

					if (Validator.isNotNull(templateFileEntry)) {
						modello = new DatiFileAllegato();
						modello.setFileName(allegato.getFilenameModello());

						InputStream isTemplate = templateFileEntry.getContentStream();

						if (Validator.isNotNull(isTemplate)) {
							modello.setContenuto(isTemplate.readAllBytes());
						}
						else {
							log.error("AllegatoRichiestaService :: getModelloAllegato :: Input stream modello NULL!");
						}
					}
					else {
						log.error("AllegatoRichiestaService :: getModelloAllegato :: fileEntry dell'allegato con ID : " + definizioneAllegatoId + " NULL");
					}
				}
			}

		}
		catch (Exception e) {
			log.error("Errore durante il recupero dell'allegato con id definizione : " + definizioneAllegatoId + e.getMessage(), e);
		}

		return modello;
	}

	/**
	 *
	 * @param allegatoBytes
	 * @param erroriListaAllegati
	 * @param listaFormatiFirma
	 * @param richiestaId
	 * @return
	 */
	public List<String> checkFirmaDigitaleDocumentoPrincipale(byte[] byteArray, List<String> erroriListaAllegati, List<String> listaFormatiFirma, long richiestaId) {

		String listaFormati = String.join(",", listaFormatiFirma);

		if (Validator.isNotNull(byteArray)) {
			try {

				Boolean isFirmaValida = signatureVerification.checkPkcs7Signature(byteArray, null, null);

				if (isFirmaValida) {
					int i = 0;
					Boolean isPdfFirmaDigitale = false;
					while (i < listaFormatiFirma.size() && isPdfFirmaDigitale == false) {

						if (listaFormatiFirma.get(i).equalsIgnoreCase(TipoFirmaDigitale.PADES.name())) {
							isPdfFirmaDigitale = signatureVerification.isPades(byteArray); // signature
						}

						if (listaFormatiFirma.get(i).equalsIgnoreCase(TipoFirmaDigitale.CADES.name())) {
							isPdfFirmaDigitale = signatureVerification.isCades(byteArray); // signature
						}

						i++;
					}

					if (!isPdfFirmaDigitale) {
						log.error(":::: checkFirmaDigitaleDocumentoPrincipale ::: PDF della richiesta con ID : " + richiestaId + " non è firmato nei formati accettati ( " + listaFormati + " )");
						erroriListaAllegati.add(0, "PDF non è firmato nei formati accettati ( " + listaFormati + " )");
					}

				}
				else {
					erroriListaAllegati.add(0, "PDF firmato con firma digitale non valida");
					log.error(":::: checkFirmaDigitaleDocumentoPrincipale :: PDF della richiesta con ID " + richiestaId + " presente con firma digitale non valida");
				}
			}
			catch (SignatureVerificationException e) {
				log.error(":::: checkFirmaDigitaleDocumentoPrincipale :: ERRORE :: PDF firmato della richiesta con ID : " + richiestaId
						+ "non contiene una firma digitale con uno dei formati ammessi : " + listaFormati);
				log.error(e.getMessage());
				erroriListaAllegati.add(0, "PDF firmato non contiene una firma digitale con uno dei formati ammessi : " + listaFormati);
			}
		}
		else {
			log.error("PDF Firmato non presente!");
		}

		return erroriListaAllegati;
	}
}
