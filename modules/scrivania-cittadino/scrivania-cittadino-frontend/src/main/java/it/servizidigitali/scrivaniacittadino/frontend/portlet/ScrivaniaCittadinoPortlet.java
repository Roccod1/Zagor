package it.servizidigitali.scrivaniacittadino.frontend.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;

/**
 * @author pindi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servizidigitali",
//		"com.liferay.portlet.header-portlet-css=/bootstrap/css/main.css",
		"com.liferay.portlet.header-portlet-css=/bootstrap/css/bootstrap-italia.min.css",
		"com.liferay.portlet.header-portlet-javascript=/bootstrap/js/bootstrap-italia.bundle.min.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ScrivaniaCittadino",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ScrivaniaCittadinoPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		List<MockEntity> listaPratiche = new ArrayList<MockEntity>();
		List<MockEntity> listaPagamenti = new ArrayList<MockEntity>();
		String[] statoArray = {"Concluso", "In attesa", "Necessario intervento"};
		MockEntity obj = null;
		MockEntity obj1 = null;
		for(int i = 0; i < 10; i++) {
			obj = new MockEntity();
			obj.setNome("Pratica" + randomNumber(null));
			obj.setData(new Date());
			obj.setStato(statoArray[randomNumber(3)]);
			obj.setProtocollo(StringUtil.randomString());

			listaPratiche.add(obj);
			
			obj1 = new MockEntity();
			obj1.setNome("Pagamento" + randomNumber(null));
			obj1.setData(new Date());
			obj1.setStato(statoArray[randomNumber(3)]);
			obj1.setProtocollo(StringUtil.randomString());
			listaPagamenti.add(obj1);
		}
		
//		for(int i = 0; i < 10; i++) {
//			obj1 = new MockEntity();
//			obj1.nome = "Pagamento" + randomNumber(null);
//			obj1.data = new Date();
//			obj1.stato = statoArray[randomNumber(3)];
//			
//			listaPagamenti.add(obj1);
//		}
		
		renderRequest.setAttribute("listaPratiche", listaPratiche);
		renderRequest.setAttribute("listaPagamenti", listaPagamenti);

		super.render(renderRequest, renderResponse);
	}
	
	private int randomNumber (Integer max) {
		Random random = new Random();
		return max != null ? random.nextInt(max) : random.nextInt();
	}
}