package it.servizidigitali.chatbot.frontend.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.petra.string.CharPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.URLStringEncoder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import it.servizidigitali.chatbot.frontend.configuration.ChatbotEnteConfiguration;
import it.servizidigitali.chatbot.frontend.constants.ChatbotFrontendPortletKeys;
import it.servizidigitali.chatbot.frontend.constants.CustomAttribute;
import it.servizidigitali.chatbot.frontend.constants.PortletConstants;
import it.servizidigitali.chatbot.frontend.model.ChatbotConfigurationModel;

/**
 * @author pindi
 */
@Component(
		configurationPid = "it.servizidigitali.chatbot.frontend.configuration.ChatbotEnteConfiguration",
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.servizidigitali",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=ChatbotFrontend",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + ChatbotFrontendPortletKeys.CHATBOTFRONTEND,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
		},
		service = Portlet.class
		)
public class ChatbotFrontendPortlet extends MVCPortlet {

	public static final String NODEJS_SERVER_PATH = "/node";

	private final static Log log = LogFactoryUtil.getLog(ChatbotFrontendPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);



		ChatbotEnteConfiguration _configuration;
		try {
			_configuration = _configurationProvider.getGroupConfiguration(ChatbotEnteConfiguration.class, themeDisplay.getScopeGroupId());
			
			String keyChatbotBtnLabel = _configuration.chatbotButtonLabelKey();
			String keyChatbotRecipientName = _configuration.chatbotRecipientNameKey();
			String keyChatbotWelcomeSummary = _configuration.chatbotWelcomeSummaryKey();
			String keyChatbotcalloutTitle = _configuration.chatbotCalloutTitleKey();
			String keyChatbotCalloutMessage = _configuration.chatbotCalloutMessageKey();
			String keyChatbotWelcomeTitle = _configuration.chatbotWelcomeTitleKey();


			String dialogflowAgentId = _configuration.dialogflowAgentId();
			
			log.debug("dialogflowAgentId " + dialogflowAgentId);

			ChatbotConfigurationModel chatbotConfigurationModel = new ChatbotConfigurationModel();

			String urlPortal = themeDisplay.getURLPortal();
			String portletUrl = urlPortal + renderRequest.getContextPath();

			boolean chatbotEnable = true;

			PortletConfig portletConfig = (PortletConfig)renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			ResourceBundle rb = portletConfig.getResourceBundle(themeDisplay.getLocale());
			

			String welcomeTitle = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotWelcomeTitle); // rb.getString("label.welcomeTitle"); 
			
			String welcomeMessage =  "";
			if(Validator.isNotNull(keyChatbotWelcomeSummary) && Validator.isNotNull(LanguageUtil.get(themeDisplay.getLocale(), keyChatbotWelcomeSummary))) {
				welcomeMessage = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotWelcomeSummary);
			}
			
			String welcomeImage = portletUrl + "/images/bot-big.png";
			
			String logoPath = portletUrl + "/images/logo.png";
			if(Validator.isNotNull(_configuration.chatbotLogoUrl())) {
				logoPath = _configuration.chatbotLogoUrl();
			}
			
			String launchJsPath = portletUrl + "/widget/launch.js";
			
			String senderUrlImage = portletUrl + "/images/bot-small.png";
			if(Validator.isNotNull(_configuration.senderImageUrl())) {
				senderUrlImage = _configuration.senderImageUrl();
			}
			
			
			String userToken = null;

			boolean showPopup = _configuration.showPopup();
			
			
			Integer popupIdleTimeout = _configuration.popupIdleTimeout();
			

			String calloutTitle =  LanguageUtil.get(themeDisplay.getLocale(), keyChatbotcalloutTitle); // rb.getString("label.calloutTitle"); 
			String calloutMsg = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotCalloutMessage); // rb.getString("label.calloutMsg"); 

			chatbotConfigurationModel.setAgentId(dialogflowAgentId);

			LinkedHashMap<String, Object> customAttributes = new LinkedHashMap<>();
			customAttributes.put(CustomAttribute.AGENT.getValue(), dialogflowAgentId);

			String projectId = _configuration.projectId();
			String widgetTitle = _configuration.widgetTitle();
			String userId = _configuration.userId();

			// Verifica tipologia bot da visualizzare in base alla pagina in cui siamo
			

			boolean privateLayout = themeDisplay.getLayout().isPrivateLayout();
			// Pagine private
			if (privateLayout) {
				
				String currentUrl = themeDisplay.getURLCurrent();
				log.debug("queryParams " + StringUtil.extractLast(currentUrl, CharPool.QUESTION) );
				
				
				// Verifica pagina servizio abilitata all'utilizzo del chatbot

//							MultiValueMap<String, String> parameters = UriComponentsBuilder.fromUriString(currentUrl).build().getQueryParams();
//							String parameterKey = null;
//							if (parameters != null) {
//								Set<String> keySet = parameters.keySet();
//								for (String key : keySet) {
//									if (key.contains("_" + PortletConstants.PARAMETRO_ID_SERVIZIO)) {
//										parameterKey = key;
//										break;
//									}
//								}
//							}

				//			if (parameters.containsKey(PortletConstants.PARAMETRO_ID_SERVIZIO) || parameters.containsKey(parameterKey)) {
				//				String idServizio = parameters.getFirst(PortletConstants.PARAMETRO_ID_SERVIZIO);
				//				if (idServizio == null) {
				//					idServizio = parameters.getFirst(parameterKey);
				//				}
				//				String str = "?" + PortletConstants.PARAMETRO_ID_SERVIZIO + "=" + idServizio;
				//				currentUrl = currentUrl.substring(0, currentUrl.indexOf("?"));
				//				currentUrl += str;
				//			}

				//			Servizio servizioByUri = servizioService.getServizioByUri(currentUrl);
				//
				//			if (servizioByUri != null && servizioByUri.isAttivo()) {
				//				UserPreferences userPreferences = helper.getUserPreferences(portletRequest);
				//				Long idComuneIsa = userPreferences.getIdComuneIsa();
				//				if (idComuneIsa != null) {
				//					List<ComuneISAServizio> comuni = servizioByUri.getComuni();
				//					ComuneISAServizio comuneISAServizioSelected = null;
				//					if (comuni != null) {
				//						for (ComuneISAServizio comuneISAServizio : comuni) {
				//							if (comuneISAServizio.getComuneISA().getId().equals(idComuneIsa)) {
				//								comuneISAServizioSelected = comuneISAServizio;
				//								break;
				//							}
				//						}
				//					}
				//					if (comuneISAServizioSelected != null && comuneISAServizioSelected.getComuneISA() != null && comuneISAServizioSelected.isAttivo()
				//							&& comuneISAServizioSelected.getComuneISA().getAttivo()) {
				//						chatbotEnable = comuneISAServizioSelected.isChatbot();
				//						if (chatbotEnable) {
				//							String configurazioneChatbotJsonString = comuneISAServizioSelected.getConfigurazioneChatbot();
				//							if (configurazioneChatbotJsonString != null && !configurazioneChatbotJsonString.isEmpty()) {
				//								ConfigurazioneChatbot configurazioneChatbot = configurazioneChatbotConverter.convertToEntityAttribute(configurazioneChatbotJsonString);
				//								if (configurazioneChatbot != null) {
				//									// Aggiunta/sovrascrittura customAttributes
				//									if (configurazioneChatbot.getCustomAttributes() != null && !configurazioneChatbot.getCustomAttributes().isEmpty()) {
				//										customAttributes.putAll(configurazioneChatbot.getCustomAttributes());
				//										if (configurazioneChatbot.getCustomAttributes().containsKey(CustomAttribute.AGENT.getValue())) {
				//											chatbotConfigurationModel.setAgentId((String) configurazioneChatbot.getCustomAttributes().get(CustomAttribute.AGENT.getValue()));
				//										}
				//									}
				//
				//									// Aggiunta/sovrascrittura altri parametri
				//									if (configurazioneChatbot.getProjectid() != null) {
				//										projectId = configurazioneChatbot.getProjectid();
				//									}
				//									if (configurazioneChatbot.getUserId() != null) {
				//										userId = configurazioneChatbot.getUserId();
				//									}
				//									if (configurazioneChatbot.getWelcomeTitle() != null) {
				//										welcomeTitle = configurazioneChatbot.getWelcomeTitle();
				//									}
				//									if (configurazioneChatbot.getWelcomeMessage() != null) {
				//										welcomeMessage = configurazioneChatbot.getWelcomeMessage();
				//									}
				//									if (configurazioneChatbot.getWidgetTitle() != null) {
				//										widgetTitle = configurazioneChatbot.getWidgetTitle();
				//									}
				//									if (configurazioneChatbot.getLogoChat() != null) {
				//										logoPath = configurazioneChatbot.getLogoChat();
				//									}
				//									if (configurazioneChatbot.getLaunchJsPath() != null) {
				//										launchJsPath = configurazioneChatbot.getLaunchJsPath();
				//									}
				//									if (configurazioneChatbot.getSenderUrlImage() != null) {
				//										senderUrlImage = configurazioneChatbot.getSenderUrlImage();
				//									}
				//									if (configurazioneChatbot.getShowPopup() != null) {
				//										showPopup = configurazioneChatbot.getShowPopup();
				//									}
				//									if (configurazioneChatbot.getPopupIdleTimeout() != null) {
				//										popupIdleTimeout = configurazioneChatbot.getPopupIdleTimeout();
				//									}
				//								}
				//							}
				//						}
				//					}
				//				}
				//				else {
				//					chatbotEnable = servizioByUri.isChatbot();
				//				}
				//			}
			}

			// Calcolo e setting User-Token come custom attributes
			if (themeDisplay.isSignedIn()) {
				//			PortletSession portletSession = renderRequest.getPortletSession();
				//			if (portletSession.getAttribute(USER_TOKEN_SESSION_ATTRIBUTE_NAME) != null) {
				//				userToken = (String) portletSession.getAttribute(USER_TOKEN_SESSION_ATTRIBUTE_NAME);
				//			}
				//
				//			if (jwtTokenUtil.isTokenExpired(userToken)) {
				//				try {
				//					List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				//					User userForJwtAccessToken = new User(themeDisplay.getUser().getScreenName(), "", showPopup, showPopup, showPopup, showPopup, authorities);
				//					// Aggiunta User-Token
				//					userToken = jwtTokenUtil.generateToken(userForJwtAccessToken);
				//					portletSession.setAttribute(USER_TOKEN_SESSION_ATTRIBUTE_NAME, userToken);
				//				}
				//				catch (Exception e) {
				//					log.error("getChatbotConfigurationModel :: " + e.getMessage(), e);
				//				}
				//			}
			}

			chatbotConfigurationModel.setActive(chatbotEnable);
			Map<String, String> payloadMap = new LinkedHashMap<>();
			payloadMap.put(CustomAttribute.USERTOKEN.getValue(), userToken);
			customAttributes.put(CustomAttribute.PAYLOAD.getValue(), payloadMap);
			
			// urlPortal = "https://web18.linksmt.it";
			String nodeJsBasePath = _configuration.nodeJsBasePath();
			
			String buttonLabel = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotBtnLabel); // rb.getString("label.customAttributes." + CustomAttribute.BUTTON_LABEL.name())
			String recipientName = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotRecipientName); // rb.getString("label.customAttributes." + CustomAttribute.RECIPIENT_FULLNAME.name())
			String welcomeSummary = LanguageUtil.get(themeDisplay.getLocale(), keyChatbotWelcomeSummary); //rb.getString("label.customAttributes." + CustomAttribute.WELCOME_SUMMARY.name()) 
			
			customAttributes.put(CustomAttribute.URL_AUDIOREPO.getValue(), nodeJsBasePath + NODEJS_SERVER_PATH);
			customAttributes.put(CustomAttribute.PROXY_URL.getValue(), nodeJsBasePath + NODEJS_SERVER_PATH + "/proxy");
			
			customAttributes.put(CustomAttribute.RECIPIENT_FULLNAME.getValue(),  recipientName );
			
			customAttributes.put(CustomAttribute.BUTTON_LABEL.getValue(), 
					buttonLabel);
			customAttributes.put(CustomAttribute.WELCOME_IMAGE.getValue(), welcomeImage);
			customAttributes.put(CustomAttribute.WELCOME_SUMMARY.getValue(), 
					welcomeSummary);
			
			customAttributes.put(CustomAttribute.START_HIDDEN_MESSAGE.getValue(), "__start");

			chatbotConfigurationModel.setProjectId(projectId);
			chatbotConfigurationModel.setCustomAttributes(customAttributes);

			if (customAttributes != null) {
				try {
					chatbotConfigurationModel.setCustomAttributesString(new ObjectMapper().writeValueAsString(customAttributes));
				}
				catch (JsonGenerationException e) {
					log.error("getChatbotConfigurationModel :: " + e.getMessage(), e);
				}
				catch (JsonMappingException e) {
					log.error("getChatbotConfigurationModel :: " + e.getMessage(), e);
				}
				catch (IOException e) {
					log.error("getChatbotConfigurationModel :: " + e.getMessage(), e);
				}
			}
			chatbotConfigurationModel.setUserId(userId);
			chatbotConfigurationModel.setWelcomeMsg(HtmlUtil.escapeJS(welcomeMessage));
			chatbotConfigurationModel.setWelcomeTitle(HtmlUtil.escapeJS(welcomeTitle));
			chatbotConfigurationModel.setCalloutTitle(HtmlUtil.escapeJS(calloutTitle));
			chatbotConfigurationModel.setCalloutMsg(HtmlUtil.escapeJS(calloutMsg));
			chatbotConfigurationModel.setWidgetTitle(HtmlUtil.escapeJS(widgetTitle));
			chatbotConfigurationModel.setLogoPath(logoPath);
			chatbotConfigurationModel.setLaunchJsPath(launchJsPath);
			chatbotConfigurationModel.setSenderUrlImage(senderUrlImage);
			chatbotConfigurationModel.setShowPopup(showPopup);
			chatbotConfigurationModel.setPopupIdleTimeout(popupIdleTimeout);
			
			renderRequest.setAttribute("chatbotConfigurationModel", chatbotConfigurationModel);
			
		} catch (ConfigurationException e1) {
			// TODO Auto-generated catch block
			log.error(e1);
		}

		super.render(renderRequest, renderResponse);
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	private ConfigurationProvider _configurationProvider;


}