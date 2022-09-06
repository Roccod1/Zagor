package it.servizidigitali.scrivaniaoperatore.frontend.util;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.UserAttributes;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.UtenteUtility;
import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.common.utility.model.IndirizzoResidenza;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

@Component(immediate = true, service = MapUtil.class)
public class MapUtil {
	
	@Reference
	private UtenteUtility utenteUtility;

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
		
		IndirizzoResidenza indirizzoResidenza = utenteUtility.getIndirizzoRedidenza(companyId, user.getScreenName());
		dto.setIndirizzoResidenza(indirizzoResidenza.getTipologia() + " " + indirizzoResidenza.getIndirizzo());
		dto.setCivicoResidenza(indirizzoResidenza.getCivico());
		dto.setComuneResidenza(indirizzoResidenza.getLuogo());
		
		dto.setStato(richiesta.getStato());
		dto.setCf(richiesta.getCodiceFiscale().toUpperCase());
		dto.setAccesso(!richiesta.getInvioGuest());
		dto.setDataInserimento(richiesta.getCreateDate());
		dto.setOggetto(richiesta.getOggetto());
		dto.setNote(richiesta.getNote());
		dto.setParIVA(richiesta.getPartitaIva());
		dto.setEmail(user.getEmailAddress());
		
		return dto;
	}
}
