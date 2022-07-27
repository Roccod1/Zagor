package it.servizidigitali.catalogoservizi.frontend.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys;
import it.servizidigitali.catalogoservizi.frontend.dto.ServizioDTO;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CatalogoServizi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CatalogoServiziPortletKeys.CATALOGOSERVIZI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CatalogoServiziPortlet extends MVCPortlet {
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, 9);
		String queryNome = ParamUtil.getString(request, "queryNome");
		
		List<ServizioDTO> servizi;
		try {
			servizi = servizioLocalService.searchServizio(queryNome, null, true, cur, delta, "createDate", "desc")
					.stream()
					.map(ServizioDTO::new)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new PortletException(e);
		}
		int serviziCount = servizioLocalService.countSearchServizio(queryNome, null, true);
		
		request.setAttribute("queryNome", queryNome);
		request.setAttribute("servizi", servizi);
		request.setAttribute("serviziCount", serviziCount);
		
		super.render(request, response);
	}
	
}