package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;

@Component(name = "allegatiRichiestaService", immediate = true, service = AllegatoRichiestaService.class)
public class AllegatoRichiestaService {
	
	private static final Log log = LogFactoryUtil.getLog(AllegatoRichiestaService.class.getName());
	
	@Reference
	FileServiceFactory fileServiceFactory;
	
	@Reference
	AllegatoRichiestaLocalService allegatoRichiestaLocalService;
	
	@Reference
	CounterLocalService counterLocalService;
	
	public void salvaAllegatiRichiesta(File allegato, String codiceServizio, long richiestaId, String userName, long userId, long groupId) {
		
		try {
			
			if(Validator.isNotNull(allegato)) {
				InputStream stream = new FileInputStream(allegato);

				if(Validator.isNotNull(allegato)) {
					String mimeType = MimeTypesUtil.getContentType(allegato);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(allegato.getName(), allegato.getName(), allegato.getName(), codiceServizio, stream, mimeType, userId, groupId);
					creaAllegatoRichiesta(idDocumentale, richiestaId, userName, groupId, userId);
				}

			}

		}catch(Exception e) {
			log.error("Errore durante il caricamento del file : " + e.getMessage(), e); 
		}
		
	}
	
	public void creaAllegatoRichiesta (String idDocumentale, long richiestaId, String userName, long groupId, long userId) {
		AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());
		
		if(Validator.isNotNull(idDocumentale)) {
			allegatoRichiesta.setGroupId(groupId);
			allegatoRichiesta.setUserId(userId);
			allegatoRichiesta.setUserName(userName);
			allegatoRichiesta.setRichiestaId(richiestaId);
			allegatoRichiesta.setIdDocumentale(idDocumentale);
			
			allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);
		}
	}
	
	public void salvaAllegatoFirmato(File allegato, String codiceServizio, long richiestaId, String userName, long userId, long groupId) {
		// TODO: Implementare eventualmente la verifica della firma digitale
		
		try {
			
			if(Validator.isNotNull(allegato)) {
				InputStream stream = new FileInputStream(allegato);
				
				if(Validator.isNotNull(allegato)) {
					String mimeType = MimeTypesUtil.getContentType(allegato);
					String idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(allegato.getName(), allegato.getName(), allegato.getName(), codiceServizio, stream, mimeType, userId, groupId);

					if(Validator.isNotNull(idDocumentale)) {
						creaAllegatoRichiesta(idDocumentale, richiestaId, userName, groupId, userId);
					}
			
				}

			}

		}catch(Exception e) {
			log.error("Errore durante il caricamento del file firmato : " + e.getMessage(), e); 
		}
	}
}
