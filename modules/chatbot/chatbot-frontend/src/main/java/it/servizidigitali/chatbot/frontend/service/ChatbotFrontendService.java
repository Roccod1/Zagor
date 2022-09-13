package it.servizidigitali.chatbot.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "chatbotFrontendService", immediate = true, service = ChatbotFrontendService.class)
public class ChatbotFrontendService {

	private static final Log log = LogFactoryUtil.getLog(ChatbotFrontendService.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	/**
	 *
	 * @param themeDisplay
	 * @return
	 */
	public ServizioEnte getServizioEnteByPage(ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByGroupIdLayoutId(groupId, layoutId);

		return servizioEnte;
	}

	/**
	 *
	 * @param servizioEnte
	 * @return
	 */
	public boolean isChatbotaAttivo(ServizioEnte servizioEnte) {

		if (servizioEnte != null) {
			try {
				Servizio servizio = servizioLocalService.getServizio(servizioEnte.getServizioId());
				if (servizio == null || !servizio.isAttivo()) {
					return false;
				}

				if (!servizio.isChatbot()) {
					return false;
				}

				return servizioEnte.isChatbot();

			}
			catch (PortalException e) {
				log.warn("isChatbotaAttivo :: " + e.getMessage());
			}
		}

		return false;
	}

}
