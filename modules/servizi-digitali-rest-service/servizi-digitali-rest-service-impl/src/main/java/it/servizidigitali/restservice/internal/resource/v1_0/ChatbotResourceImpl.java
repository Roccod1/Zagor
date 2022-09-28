package it.servizidigitali.restservice.internal.resource.v1_0;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.util.Validator;

import it.servizidigitali.restservice.dto.v1_0.ChatbotAnswer;
import it.servizidigitali.restservice.dto.v1_0.ChatbotDatiSessione;
import it.servizidigitali.restservice.dto.v1_0.ChatbotSession;
import it.servizidigitali.restservice.resource.v1_0.ChatbotResource;

/**
 * @author pindi
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/chatbot.properties",
	scope = ServiceScope.PROTOTYPE, service = ChatbotResource.class
)
public class ChatbotResourceImpl extends BaseChatbotResourceImpl {
	
	
	@Override
	public ChatbotAnswer getRispostaChatbot(@NotNull String codiceFiscale, @NotNull String codiceServizio,
			String amministrazione, String nomeComune) throws Exception {

		if ((Validator.isNull(nomeComune) && Validator.isNull(amministrazione)) || (!Validator.isNull(nomeComune) && !Validator.isNull(amministrazione))) {
			
			throw new BadRequestException("E' obbligatorio compilare solo uno tra i due campi nomeComune e amministrazione");
			
		}
		
		
		return super.getRispostaChatbot(codiceFiscale, codiceServizio, amministrazione, nomeComune);
	}
	
	
	@Override
	public ChatbotSession addChatbotSession(@NotNull String userToken, ChatbotDatiSessione chatbotDatiSessione)
			throws Exception {
		// TODO Auto-generated method stub
		return super.addChatbotSession(userToken, chatbotDatiSessione);
	}
	
}