package it.servizidigitali.scrivaniaoperatore.frontend.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.UtenteUtility;
import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.common.utility.model.IndirizzoResidenza;
import it.servizidigitali.file.utility.FileUtility;
import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.file.utility.service.FileService;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AttivitaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.CommentoDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.ServizioDTO;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(immediate = true, service = MapUtil.class)
public class MapUtil {

	private static final Log log = LogFactoryUtil.getLog(MapUtil.class.getName());

	@Reference
	private UtenteUtility utenteUtility;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private FileUtility fileUtility;

	public RichiestaDTO mapRichiesta(long companyId, Richiesta richiesta) {
		RichiestaDTO dto = new RichiestaDTO();
		dto.setId(richiesta.getRichiestaId());

		dto.setNumeroProtocollo(richiesta.getNumeroProtocollo());
		dto.setDataProtocollo(richiesta.getDataProtocollo());
		dto.setNumeroProtocolloEsterno(richiesta.getNumeroProtocolloEsterno());
		dto.setDataProtocolloEsterno(richiesta.getDataProtocolloEsterno());

		dto.setDataUltimoAggiornamento(richiesta.getModifiedDate());

		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, richiesta.getCodiceFiscale());
		dto.setRichiedente(user.getFullName());

		String pec = (String) user.getExpandoBridge().getAttribute(UserCustomAttributes.PEC.getNomeAttributo());
		dto.setPec(pec);

		String telefono = (String) user.getExpandoBridge().getAttribute(UserCustomAttributes.TELEFONO.getNomeAttributo());
		dto.setTelefono(telefono);

		IndirizzoResidenza indirizzoResidenza = utenteUtility.getIndirizzoRedidenza(companyId, user.getScreenName());
		if (indirizzoResidenza != null) {
			dto.setIndirizzoResidenza(indirizzoResidenza.getTipologia() + " " + indirizzoResidenza.getIndirizzo());
			dto.setCivicoResidenza(indirizzoResidenza.getCivico());
			dto.setComuneResidenza(indirizzoResidenza.getLuogo());
		}

		dto.setStato(richiesta.getStato());
		dto.setCf(richiesta.getCodiceFiscale().toUpperCase());
		dto.setAccesso(!richiesta.getInvioGuest());
		dto.setDataInserimento(richiesta.getCreateDate());
		dto.setOggetto(richiesta.getOggetto());
		dto.setNote(richiesta.getNote());
		dto.setParIVA(richiesta.getPartitaIva());
		dto.setEmail(user.getEmailAddress());

		Procedura procedura = proceduraLocalService.fetchProcedura(richiesta.getProceduraId());
		Servizio servizio = servizioLocalService.fetchServizio(procedura.getServizioId());
		dto.setServizio(servizio.getNome());
		dto.setProcessInstanceId(richiesta.getProcessInstanceId());

		return dto;
	}

	public ServizioDTO mapServizio(ServizioEnte se) {
		Servizio servizio = servizioLocalService.fetchServizio(se.getServizioId());

		ServizioDTO dto = new ServizioDTO();
		dto.setId(servizio.getServizioId());
		dto.setNome(servizio.getNome());
		return dto;
	}

	public AllegatoDTO mapAllegato(ServiceContext context, AllegatoRichiesta allegatoRichiesta) throws RuntimeException {
		AllegatoDTO allegato;
		try {
			String idDocumentale = allegatoRichiesta.getIdDocumentale();
			long groupId = allegatoRichiesta.getGroupId();

			FileService fileService = fileServiceFactory.getActiveFileService();
			File requestFile = fileService.getRequestFile(idDocumentale, groupId);

			allegato = new AllegatoDTO();
			allegato.setId(allegatoRichiesta.getAllegatoRichiestaId());
			allegato.setNomeFile(requestFile.getNome());
			allegato.setDescrizione(requestFile.getDescrizione());
			allegato.setTitolo(requestFile.getTitolo());
			allegato.setDimensione(fileUtility.getHumanReadableSize(requestFile.getInputStream().available()));
			allegato.setVisibileAlCittadino(allegatoRichiesta.getVisibile());
			allegato.setNomeOperatore(userLocalService.fetchUser(allegatoRichiesta.getUserId()).getFullName());
			allegato.setContenuto(requestFile.getInputStream().readAllBytes());
			allegato.setIdDocumentale(requestFile.getId());
		}
		catch (Exception e) {
			log.error("mapAllegato :: " + e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return allegato;
	}

	public CommentoDTO mapCommento(CommentoRichiesta cr) {
		CommentoDTO commento = new CommentoDTO();
		commento.setData(cr.getCreateDate());
		commento.setOperatore(cr.getUserName());
		commento.setTesto(cr.getTesto());
		commento.setVisibileAlCittadino(cr.isVisibile());
		return commento;
	}

	public AttivitaDTO mapAttivita(AttivitaRichiesta ar) {
		AttivitaDTO attivita = new AttivitaDTO();
		attivita.setData(ar.getCreateDate());
		attivita.setNote(ar.getNote());
		attivita.setStato(ar.getStato());
		return attivita;
	}
}
