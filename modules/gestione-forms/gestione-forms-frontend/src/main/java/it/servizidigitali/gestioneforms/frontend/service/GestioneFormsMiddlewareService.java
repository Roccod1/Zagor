package it.servizidigitali.gestioneforms.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.service.FileService;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;

@Component(name = "gestioneFormsMiddlewareService", immediate = true, service = GestioneFormsMiddlewareService.class)
public class GestioneFormsMiddlewareService {
	
	private static final Log _log = LogFactoryUtil.getLog(GestioneFormsMiddlewareService.class);

	@Reference
	private FileService fileService;
	
	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	public long salvaAllegatoTemplate (long definizioneAllegatoId, String denominazione, String[] tipiFileAmmessi, String[] codiciTipologiaDocumento,
										String fileNameModello, boolean obbligatorio, File fileCaricato, long formId, long userId, long groupId) throws Exception {
		
		DefinizioneAllegato allegato = definizioneAllegatoLocalService.createDefinizioneAllegato(0);
		long idAllegatoCaricato = 0;
		InputStream inputStream = null;
		
		if(Validator.isNotNull(fileCaricato)) {
			inputStream = new DataInputStream(new FileInputStream(fileCaricato));
		}
		
		if(definizioneAllegatoId > 0) {
			allegato = definizioneAllegatoLocalService.getDefinizioneAllegato(definizioneAllegatoId);
		}else {
			allegato.setDefinizioneAllegatoId(counterLocalService.increment());
		}
		
		fileNameModello = fileNameModello + "_" + String.valueOf(allegato.getDefinizioneAllegatoId()) + "_" + nowToString();
		
		if(Validator.isNotNull(fileCaricato)) {
			idAllegatoCaricato = fileService.saveTemplateAllegato(inputStream, fileNameModello, formId, userId, groupId);
		}
		
		if(Validator.isNotNull(denominazione)) {
			allegato.setDenominazione(denominazione);
		}
		
		if(Validator.isNotNull(tipiFileAmmessi)) {
			allegato.setTipiFileAmmessi(String.join(",", tipiFileAmmessi));
		}
		
		
		
		if(Validator.isNotNull(codiciTipologiaDocumento)) {
			allegato.setCodiciTipologiaDocumento(String.join(",", codiciTipologiaDocumento));
		}
		
		allegato.setFilenameModello(fileNameModello);

		allegato.setObbligatorio(obbligatorio);
		allegato.setFormId(formId);
		
		if(idAllegatoCaricato>0) {
			allegato.setFileEntryId(idAllegatoCaricato);
		}
		
		definizioneAllegatoLocalService.updateDefinizioneAllegato(allegato);
		
		return allegato.getDefinizioneAllegatoId();
	}
	
	public static String nowToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return sdf.format(new Date());
	}
}
