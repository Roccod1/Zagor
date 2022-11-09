package it.servizidigitali.pagamento.ebollo.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestionepagamenti.common.service.GestionePagamentiService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = PagamentoEBolloService.class)
public class PagamentoEBolloService {

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private GestionePagamentiService gestionePagamentiService;

	/**
	 *
	 * @param file
	 * @param fileName
	 * @param servizioId
	 * @param organizationId
	 * @param userId
	 * @param groupId
	 * @param companyId
	 * @param callbackUrl
	 * @return
	 * @throws Exception
	 */
	public String pagaBollo(byte[] file, String fileName, long servizioId, long organizationId, long userId, long groupId, long companyId, String callbackUrl) throws Exception {
		return gestionePagamentiService.pagaBollo(file, fileName, 0, 0, servizioId, organizationId, userId, groupId, companyId, callbackUrl);
	}

	/**
	 * Carica il servizio corrente in base alla pagina in cui è in esecuzione la portlet.
	 *
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	public Servizio getCurrentServizio(ThemeDisplay themeDisplay) throws PortalException {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);
		if (servizioEnte != null) {
			return servizioLocalService.getServizio(servizioEnte.getServizioId());
		}

		return null;
	}
}
