package it.servizidigitali.scrivaniacittadino.frontend.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;
import it.servizidigitali.gestionecomunicazioni.service.TipologiaComunicazioneLocalService;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;

/**
 * @author pindi
 */
@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=ScrivaniaCittadino", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class ScrivaniaCittadinoPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ScrivaniaCittadinoPortlet.class);

	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;

	@Reference
	private TipologiaComunicazioneLocalService tipologiaComunicazioneLocalService;

	@Reference
	private TipologiaLocalService tipologiaLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String tabAttivaValue = ParamUtil.getString(renderRequest, ScrivaniaCittadinoPortletKeys.TAB_ATTIVA);
		List<TipologiaComunicazione> listaTipologiaComunicazione = new ArrayList<TipologiaComunicazione>();
		List<Tipologia> listaTipologiaServizi = new ArrayList<Tipologia>();
		try {
			listaTipologiaComunicazione = tipologiaComunicazioneLocalService.getTipologiaComunicaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			listaTipologiaServizi = tipologiaLocalService.getTipologias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			_log.error("render :: " + e.getMessage(), e);
		}

		renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.LISTA_TIPOLOGIA_COMUNICAZIONE, listaTipologiaComunicazione);
		renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.LISTA_STATO, Arrays.asList(StatoRichiesta.values()));
		renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.LISTA_TIPOLOGIA_RICHIESTA, listaTipologiaServizi);
		renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.TAB_ATTIVA, tabAttivaValue);
		super.render(renderRequest, renderResponse);
	}

}