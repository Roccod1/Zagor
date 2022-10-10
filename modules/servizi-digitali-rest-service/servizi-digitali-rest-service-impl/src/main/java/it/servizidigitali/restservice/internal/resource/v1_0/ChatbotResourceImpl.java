package it.servizidigitali.restservice.internal.resource.v1_0;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.restservice.dto.v1_0.ChatbotAnswer;
import it.servizidigitali.restservice.dto.v1_0.ChatbotDatiSessione;
import it.servizidigitali.restservice.dto.v1_0.ChatbotSession;
import it.servizidigitali.restservice.internal.constant.ServiziDigitaliRestConstants;
import it.servizidigitali.restservice.internal.converter.EntityToSchemaModelConverter;
import it.servizidigitali.restservice.internal.util.MessageUtil;
import it.servizidigitali.restservice.resource.v1_0.ChatbotResource;

/**
 * @author pindi
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/chatbot.properties",
		scope = ServiceScope.PROTOTYPE, service = ChatbotResource.class
		)
public class ChatbotResourceImpl extends BaseChatbotResourceImpl {

	@Reference
	private ServizioLocalService servizioLocalService;
	@Reference
	private UserLocalService userLocalService;
	@Reference
	private EntityToSchemaModelConverter entityToSchemaModelConverter;
	@Context
	private User loggedUser;
	
	@Override
	public ChatbotAnswer getChatbotMessaggioServizio(@NotNull String codiceFiscale, @NotNull String codiceServizio,
			String amministrazione, String nomeComune) throws Exception {
		MessageUtil messageUtil = new MessageUtil(ServiziDigitaliRestConstants.BUNDLE_SYMBOLIC_NAME, null);		
		
		if ((Validator.isNull(nomeComune) && Validator.isNull(amministrazione)) || (!Validator.isNull(nomeComune) && !Validator.isNull(amministrazione))) {

			throw new BadRequestException("E' obbligatorio compilare solo uno tra i due campi nomeComune e amministrazione");

		}
		
		User user = userLocalService.getUserByScreenName(loggedUser.getCompanyId(), nomeComune);
		Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
		String path = entityToSchemaModelConverter.getSchedaServizioPath(servizio.getServizioId(), user.getOrganizationIds()[0], user.getCompanyId());

		String messaggio = messageUtil.getMessage("chatbotMessage", servizio.getNome(), path);
		
		ChatbotAnswer answer = new ChatbotAnswer();
		answer.setMessaggio(messaggio);
		answer.setPathServizio(path);
		return answer;
	}


	@Override
	public ChatbotSession addChatbotSession(@NotNull String userToken, ChatbotDatiSessione chatbotDatiSessione)
			throws Exception {
		// TODO Auto-generated method stub
		return super.addChatbotSession(userToken, chatbotDatiSessione);
	}

}