/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.servizidigitali.gestioneforms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.base.DefinizioneAllegatoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneforms.model.DefinizioneAllegato",
	service = AopService.class
)
public class DefinizioneAllegatoLocalServiceImpl
	extends DefinizioneAllegatoLocalServiceBaseImpl {
	
	public static final Log _log = LogFactoryUtil.getLog(DefinizioneAllegatoLocalServiceImpl.class);
	
	public List<DefinizioneAllegato> getListaDefinizioneAllegatoByFormId(long formId){
		List<DefinizioneAllegato> listaDefinizioneAllegati = new ArrayList<>();
		if(formId>0) {
			listaDefinizioneAllegati = definizioneAllegatoPersistence.findByformIdAndEliminato(formId,false);
		}
		
		return listaDefinizioneAllegati;
	}
	
	public DefinizioneAllegato cancellaAllegati(String[] allegatiDaEliminare) {
		DefinizioneAllegato allegato = null;
		for(String allegatoId : allegatiDaEliminare) {
			allegato = definizioneAllegatoPersistence.fetchByPrimaryKey(Long.valueOf(allegatoId));
			if(Validator.isNotNull(allegato)) {
				allegato.setEliminato(true);
				definizioneAllegatoLocalService.updateDefinizioneAllegato(allegato);
			}else {
				_log.error("Impossibile recuperare l'allegato per poter effettuare l'eliminazione!");
			}
		}
		
		return allegato;
	}
	
	public long uploadAllegatoTemporaneo(File allegato) throws Exception{
		File tempFile = null;
		String tmpDir = System.getProperty("java.io.tmpdir");
		long idTemporaneo = 0;

		if(Validator.isNotNull(allegato)) {
			byte[] allegatoCaricato = FileUtil.getBytes(allegato);
			idTemporaneo = counterLocalService.increment();
			String percorsoFile = tmpDir + File.separator + "allegato-" + idTemporaneo;
			
			tempFile = new File(percorsoFile);
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(allegatoCaricato);
			fos.close();
		}else {
			_log.error("DefinizioneAllegatoLocalServiceImpl :: uploadAllegatoTemporaneo :: Impossibile recuperare allegato caricato");
		}
		
		return idTemporaneo;
	}
	
	public FileEntry uploadAllegatoDocumentMediaRepository(String idAllegatoTemporaneo) {
		FileEntry allegatoCaricato = null;
		String tmpDir = System.getProperty("java.io.tmpdir");
		String percorsoFileTemporaneo = tmpDir + File.separator + "allegato-" + idAllegatoTemporaneo;
		
		File fileTemporaneo = new File(percorsoFileTemporaneo);

		return allegatoCaricato;
	}

}