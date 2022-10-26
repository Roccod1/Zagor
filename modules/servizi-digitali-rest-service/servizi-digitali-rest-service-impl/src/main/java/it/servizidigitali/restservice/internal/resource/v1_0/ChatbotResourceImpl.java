package it.servizidigitali.restservice.internal.resource.v1_0;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
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
	private static final Log log = LogFactoryUtil.getLog(ChatbotResourceImpl.class);
	
	@Reference
	private ServizioLocalService servizioLocalService;
	@Reference
	private EntityToSchemaModelConverter entityToSchemaModelConverter;
	@Reference
	private OrganizationLocalService organizationLocalService;
	@Reference
	private ExpandoValueLocalService expandoValueLocalService;
	@Reference
	private ServizioEnteLocalService serviceEnteLocalService;
	
	@Override
	public ChatbotAnswer getChatbotMessaggioServizio(@NotNull String codiceFiscale, @NotNull String codiceServizio,
			String amministrazione, String nomeComune) throws Exception {
		MessageUtil messageUtil = new MessageUtil(ServiziDigitaliRestConstants.BUNDLE_SYMBOLIC_NAME, null);		
		
		if ((Validator.isNull(nomeComune) && Validator.isNull(amministrazione)) || (!Validator.isNull(nomeComune) && !Validator.isNull(amministrazione))) {
			throw new BadRequestException("E' obbligatorio compilare solo uno tra i due campi nomeComune e amministrazione");
		}
		
		List<Organization> organizations;
		if (Validator.isNotNull(nomeComune)) {
			DynamicQuery query = organizationLocalService.dynamicQuery();
			query.add(RestrictionsFactoryUtil.eq("name", nomeComune));
			
			organizations = organizationLocalService.dynamicQuery(query);
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			
			DynamicQuery expandoColumn = DynamicQueryFactoryUtil.forClass(ExpandoColumn.class, classLoader);
			expandoColumn.add(RestrictionsFactoryUtil.eq("name", "codiceIPA"));
			expandoColumn.setProjection(ProjectionFactoryUtil.property("columnId"));

			DynamicQuery expandoValue = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, classLoader);
			expandoValue.add(RestrictionsFactoryUtil.eq("data", amministrazione));
			expandoValue.add(PropertyFactoryUtil.forName("columnId").in(expandoColumn));
			expandoValue.setProjection(ProjectionFactoryUtil.property("classPK"));

			DynamicQuery query = organizationLocalService.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("organizationId").in(expandoValue));

			organizations = organizationLocalService.dynamicQuery(query);
		} 
		
		Organization organization;
		if (organizations.size() == 1) {
			organization = organizations.get(0);
		} else if (organizations.isEmpty()) {
			throw new NotFoundException("Ente non trovato");
		} else {
			throw new InternalServerErrorException("Enti multipli per filtro nomeComune o amministrazione");
		}
		
		Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
		if (servizio == null) {
			throw new NotFoundException("Servizio non trovato");
		}
		
		ServizioEnte servizioEnte = serviceEnteLocalService.getServizioEnte(new ServizioEntePK(servizio.getServizioId(), organization.getOrganizationId()));
		
		String basePath = entityToSchemaModelConverter.getPathServizio(servizioEnte, organization);
		String path = appendParam(basePath, "codiceFiscaleComponenteNucleoFamiliare", codiceFiscale); 
		
		String messaggio = messageUtil.getMessage("chatbotMessage", servizio.getNome(), basePath);
		
		ChatbotAnswer answer = new ChatbotAnswer();
		answer.setMessaggio(messaggio);
		answer.setPathServizio(path);
		return answer;
	}


	private String appendParam(String base, String key, String value) throws URISyntaxException {
		URI uri = new URI(base);
		
		String newQuery = uri.getQuery();
		if (newQuery == null) {
			newQuery = key + "=" + value;
		} else {
			newQuery += "&" + key + "=" + value;
		}
		
		return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment()).toString();
	}


	@Override
	public ChatbotSession addChatbotSession(@NotNull String userToken, ChatbotDatiSessione chatbotDatiSessione)
			throws Exception {
		// TODO Auto-generated method stub
		return super.addChatbotSession(userToken, chatbotDatiSessione);
	}

}