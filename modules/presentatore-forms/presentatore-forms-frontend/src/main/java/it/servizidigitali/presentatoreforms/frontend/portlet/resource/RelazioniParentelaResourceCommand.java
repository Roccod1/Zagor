package it.servizidigitali.presentatoreforms.frontend.portlet.resource;

import com.google.gson.Gson;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.enums.RelazioneParentela;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaDatasource;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
		"mvc.command.name=" + PresentatoreFormsPortletKeys.RELAZIONI_PARENTELA_RESOURCE_COMMAND //
}, service = { MVCResourceCommand.class })
public class RelazioniParentelaResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		RelazioneParentela[] relazioniParentela = RelazioneParentela.values();
		
		List<AlpacaDatasource> lst = new ArrayList<AlpacaDatasource>();
		
		for(RelazioneParentela relazioneParentela : relazioniParentela) {
			AlpacaDatasource alpacaDatasource = new AlpacaDatasource();
			alpacaDatasource.setText(relazioneParentela.getDescrizione());
			alpacaDatasource.setValue(String.valueOf(relazioneParentela.getCodice()));
			lst.add(alpacaDatasource);
		}
		
		Gson gson = new Gson();
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		String jsonstring = gson.toJson(lst);
		resourceResponse.getWriter().write(jsonstring);
		
	}

}
