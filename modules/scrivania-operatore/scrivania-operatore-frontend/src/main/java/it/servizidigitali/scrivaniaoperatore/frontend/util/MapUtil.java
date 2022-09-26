package it.servizidigitali.scrivaniaoperatore.frontend.util;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.servizidigitali.common.utility.UtenteUtility;
import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.common.utility.model.IndirizzoResidenza;
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
	
	@Reference
	private UtenteUtility utenteUtility;
	@Reference
	private ProceduraLocalService proceduraLocalService;
	@Reference
	private ServizioLocalService servizioLocalService;
	@Reference
	private DLFileEntryLocalService dlFileEntryLocalService;
	@Reference
	private FileService fileService;
	@Reference
	private UserLocalService userLocalService;
	
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
	
	public AllegatoDTO mapAllegato(ServiceContext context, AllegatoRichiesta ar) {
		long fileEntryId = ar.getFileEntryId();
		DLFileEntry fileEntry;
		try {
			fileEntry = dlFileEntryLocalService.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		
		AllegatoDTO allegato = new AllegatoDTO();
		allegato.setNomeFile(fileEntry.getFileName());
		allegato.setDescrizione(fileEntry.getDescription());
		allegato.setDimensione(fileService.getHumanReadableSize(fileEntry.getSize()));
		allegato.setVisibileAlCittadino(ar.getVisibile());
		allegato.setNomeOperatore(userLocalService.fetchUser(ar.getUserId()).getFullName());
		
		//TODO usare service o spostare in un nostro service?
		String url = "/documents/" + fileEntry.getRepositoryId() + 
				"/" + fileEntry.getFolderId() + 
				"/" + fileEntry.getFileName() + 
				"/" + fileEntry.getUuid() + 
				"?download=true";
		allegato.setUrl(url);
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
