package it.servizidigitali.gestioneforms.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;

@Component(name = "gestioneFormsMiddlewareService", immediate = true, service = GestioneFormsMiddlewareService.class)
public class GestioneFormsMiddlewareService {

	@Reference
	private TemplateAllegatoFileService templateAllegatoFileService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private UserLocalService userLocalService;

	public long salvaAllegatoTemplate(long definizioneAllegatoId, String denominazione, String[] tipiFileAmmessi, String[] codiciTipologiaDocumento, String fileNameModello, boolean obbligatorio,
			File fileCaricato, long formId, long userId, long groupId) throws Exception {

		DefinizioneAllegato allegato = definizioneAllegatoLocalService.createDefinizioneAllegato(0);
		long idAllegatoCaricato = 0;
		InputStream inputStream = null;

		boolean fileExists = fileCaricato.exists();

		if (fileExists) {
			inputStream = new DataInputStream(new FileInputStream(fileCaricato));
		}

		if (definizioneAllegatoId > 0) {
			allegato = definizioneAllegatoLocalService.getDefinizioneAllegato(definizioneAllegatoId);
		}
		else {
			allegato.setDefinizioneAllegatoId(counterLocalService.increment());
		}

		if (Validator.isNotNull(fileNameModello)) {
			fileNameModello = fileNameModello + "_" + String.valueOf(allegato.getDefinizioneAllegatoId()) + "_" + nowToString();
		}

		if (fileExists) {
			idAllegatoCaricato = templateAllegatoFileService.saveTemplateAllegato(fileNameModello, denominazione, null, formId, inputStream, null, userId, groupId);
		}

		if (Validator.isNotNull(denominazione)) {
			allegato.setDenominazione(denominazione);
		}

		if (Validator.isNotNull(tipiFileAmmessi)) {
			allegato.setTipiFileAmmessi(String.join(",", tipiFileAmmessi));
		}

		if (Validator.isNotNull(codiciTipologiaDocumento)) {
			allegato.setCodiciTipologiaDocumento(String.join(",", codiciTipologiaDocumento));
		}

		allegato.setFilenameModello(fileNameModello);

		allegato.setObbligatorio(obbligatorio);
		allegato.setFormId(formId);

		if (idAllegatoCaricato > 0) {
			allegato.setFileEntryId(idAllegatoCaricato);
		}

		User user = userLocalService.getUser(userId);

		allegato.setUserId(userId);
		allegato.setUserName(user.getFullName());

		allegato.setGroupId(groupId);
		allegato.setOrganizationId(groupLocalService.getGroup(groupId).getOrganizationId());

		definizioneAllegatoLocalService.updateDefinizioneAllegato(allegato);

		return allegato.getDefinizioneAllegatoId();
	}

	public static String nowToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return sdf.format(new Date());
	}

	/**
	 *
	 * @param ids
	 * @throws PortalException
	 */
	public void eliminaAllegati(String[] allegatiDaEliminare) throws PortalException {

		if (allegatiDaEliminare != null && allegatiDaEliminare.length > 0) {
			List<Long> ids = Arrays.asList(allegatiDaEliminare).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());

			for (Long id : ids) {
				DefinizioneAllegato definizioneAllegato = definizioneAllegatoLocalService.getDefinizioneAllegato(id);
				if (definizioneAllegato != null && definizioneAllegato.getFileEntryId() != 0) {
					templateAllegatoFileService.deleteTemplateAllegato(definizioneAllegato.getFileEntryId());
				}
			}
			definizioneAllegatoLocalService.deleteAllegati(ids);
		}
	}
}
