package it.servizidigitali.scrivaniaoperatore.frontend.util;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

public class MapUtil {

	public static RichiestaDTO mapRichiesta(long companyId, Richiesta richiesta) {
		RichiestaDTO dto = new RichiestaDTO();
		dto.setId(richiesta.getRichiestaId());
		dto.setNumeroProtocollo(richiesta.getNumeroProtocollo());
		dto.setDataUltimoAggiornamento(richiesta.getModifiedDate());
		
		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, richiesta.getCodiceFiscale());
		dto.setRichiedente(user.getFullName());
		
		dto.setStato(richiesta.getStato());
		dto.setCf(richiesta.getCodiceFiscale().toUpperCase());
		dto.setAccesso(!richiesta.getInvioGuest());
		dto.setDataInserimento(richiesta.getCreateDate());
		dto.setOggetto(richiesta.getOggetto());
		dto.setNote(richiesta.getNote());
		return dto;
	}
}
