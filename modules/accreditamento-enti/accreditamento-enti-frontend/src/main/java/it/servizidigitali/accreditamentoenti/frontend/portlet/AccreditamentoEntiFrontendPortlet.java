package it.servizidigitali.accreditamentoenti.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.accreditamentoenti.frontend.constants.AccreditamentoEntiFrontendPortletKeys;
import it.servizidigitali.accreditamentoenti.model.Ente;
import it.servizidigitali.accreditamentoenti.service.EnteLocalService;

/**
 * @author pindi
 */
@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=AccreditamentoEntiFrontend", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + AccreditamentoEntiFrontendPortletKeys.ACCREDITAMENTOENTIFRONTEND, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class AccreditamentoEntiFrontendPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(AccreditamentoEntiFrontendPortlet.class);

	@Reference
	private EnteLocalService enteLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Ente> enti = Collections.emptyList();

		int tot = 0;
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				AccreditamentoEntiFrontendPortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				AccreditamentoEntiFrontendPortletKeys.DEFAULT_DELTA);
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

		try {
			enti = enteLocalService.getEntes(posizioni[0], posizioni[1]);
			tot = enteLocalService.getEntesCount();
		} catch (Exception e) {
			_log.error("Impossibile ottenere la lista dei servizi", e);
		}

		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.LISTA_ENTI, enti);
		renderRequest.setAttribute(AccreditamentoEntiFrontendPortletKeys.TOTALE_ENTI, tot);

		super.render(renderRequest, renderResponse);
	}
}