package it.servizidigitali.scrivaniaoperatore.frontend.portlet;

import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Scrivania Operatore",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ScrivaniaOperatorePortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		String queryTab = ParamUtil.getString(request, "queryTab", ScrivaniaOperatorePortletKeys.TAB_ARRIVO);
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, 10);
		String queryNome = ParamUtil.getString(request, "queryNome");
		String queryCf = ParamUtil.getString(request, "queryCf");
		String queryRichiestaId = ParamUtil.getString(request, "queryRichiestaId");
		String queryNumProt = ParamUtil.getString(request, "queryNumProt");
		String queryDataRichDa = ParamUtil.getString(request, "queryDataRichDa");
		String queryDataRichA = ParamUtil.getString(request, "queryDataRichA");
		String queryAut = ParamUtil.getString(request, "queryAut");
		String queryStato = ParamUtil.getString(request, "queryStato");
		
		request.setAttribute("totale", 10000);
		request.setAttribute("lista", Arrays.asList(
				new Object(), new Object(), new Object(), 
				new Object(), new Object(), new Object(), 
				new Object(), new Object(), new Object(), 
				new Object()
		));

		request.setAttribute("stati", StatoRichiesta.values());
		request.setAttribute("queryTab", queryTab);
		request.setAttribute("queryNome", queryNome);
		request.setAttribute("queryCf", queryCf);
		request.setAttribute("queryRichiestaId", queryRichiestaId);
		request.setAttribute("queryNumProt", queryNumProt);
		request.setAttribute("queryDataRichDa", queryDataRichDa);
		request.setAttribute("queryDataRichA", queryDataRichA);
		request.setAttribute("queryAut", queryAut);
		request.setAttribute("queryStato", queryStato);
		
		super.render(request, response);
	}
	
}