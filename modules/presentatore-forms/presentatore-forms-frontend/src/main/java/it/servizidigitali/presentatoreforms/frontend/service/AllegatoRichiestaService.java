package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.presentatoreforms.frontend.util.model.DatiFileAllegato;
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

	public void salvaAllegatiRichiesta(File allegato, String nomeFile, Servizio servizio, long richiestaId, Long definizioneAllegatoId, String userName, long userId, long groupId) throws Exception {

		try {
			if (Validator.isNotNull(allegato)) {
				InputStream stream = new FileInputStream(allegato);
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

					String mimeType = MimeTypesUtil.getContentType(allegato);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, stream, mimeType, userId,
							groupId);
					creaAllegatoRichiesta(idDocumentale, nomeFile, servizio.getNome(), richiestaId, definizioneAllegatoId, false, userName, groupId, userId);
				}
			}
		}
		catch (Exception e) {
			log.error("Errore durante il caricamento del file : " + e.getMessage(), e);
			throw e;
		}

	}

	public void creaAllegatoRichiesta(String idDocumentale, String nomeFile, String nomeServizio, long richiestaId, Long definizioneAllegatoId, boolean principale, String userName, long groupId,
			long userId) {
		AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());

		if (Validator.isNotNull(idDocumentale)) {
			allegatoRichiesta.setGroupId(groupId);
			allegatoRichiesta.setUserId(userId);
			allegatoRichiesta.setUserName(userName);
			allegatoRichiesta.setRichiestaId(richiestaId);
			allegatoRichiesta.setIdDocumentale(idDocumentale);
			allegatoRichiesta.setDefinizioneAllegatoId(definizioneAllegatoId);
			allegatoRichiesta.setPrincipale(principale);
			allegatoRichiesta.setNome(nomeFile);
			
			if(!principale) {
				allegatoRichiesta.setVisibile(true);
			}
			
			allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);
		}
	}

	public void salvaAllegatoFirmato(File allegato, Servizio servizio, long richiestaId, String userName, long userId, long groupId) throws Exception {
		// TODO: Implementare eventualmente la verifica della firma digitale
		try {
			if (Validator.isNotNull(allegato)) {
				InputStream stream = new FileInputStream(allegato);
				String nomeFile = "richiesta-" + richiestaId + ".pdf";
				String descrizione = "Richiesta servizio '" + servizio.getNome() + "' - ID: " + richiestaId;
				if (Validator.isNotNull(allegato)) {
					String mimeType = MimeTypesUtil.getContentType(allegato);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, stream, mimeType, userId,
							groupId);

					if (Validator.isNotNull(idDocumentale)) {
						creaAllegatoRichiesta(idDocumentale, nomeFile, servizio.getNome(), richiestaId, null, true, userName, groupId, userId);
					}
				}
			}
		}
		catch (Exception e) {
			log.error("Errore durante il caricamento del file firmato : " + e.getMessage(), e);
			throw e;
		}
	}
	
	public void salvaCertificato(byte[] certificato, Servizio servizio, long richiestaId, String userName, long userId, long groupId) throws Exception{
		try {
			
			if(Validator.isNotNull(certificato)) {
			    InputStream is = new ByteArrayInputStream(certificato);
				String nomeFile = "richiesta-" + richiestaId + ".pdf";
				String descrizione = "Richiesta servizio '" + servizio.getNome() + "' - ID: " + richiestaId;

			    if(Validator.isNotNull(is)) {
			    	String mimeType = MimeTypesUtil.getContentType(is, nomeFile);
			    	String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, nomeFile, descrizione, servizio.getCodice(), richiestaId, is, mimeType, userId,
							groupId);
			    	
			    	if (Validator.isNotNull(idDocumentale)) {
						creaAllegatoRichiesta(idDocumentale, nomeFile, servizio.getNome(), richiestaId, null, true, userName, groupId, userId);
					}
			    }
			    
			}
			
		}catch(Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		}
	}

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
}
