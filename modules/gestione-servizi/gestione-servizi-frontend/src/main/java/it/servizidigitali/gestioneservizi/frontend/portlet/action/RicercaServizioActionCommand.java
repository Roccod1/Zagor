package it.servizidigitali.gestioneservizi.frontend.portlet.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;


@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GestioneServiziPortletKeys.GESTIONESERVIZI,
		"mvc.command.name=/cerca"
	},
	service = MVCActionCommand.class
)
public class RicercaServizioActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(RicercaServizioActionCommand.class);
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		soloServiziAttiviCheckBox
//		nome
//		codiceServizio
		
		String nome = ParamUtil.getString(actionRequest, "nome");
		String codiceServizio = ParamUtil.getString(actionRequest, "codiceServizio");
		Boolean soloServiziAttivi = ParamUtil.getBoolean(actionRequest, "soloServiziAttiviCheckBox", false);
		
		DynamicQuery query = servizioLocalService.dynamicQuery();
		
		if(Validator.isNotNull(nome)) {
			query.add(RestrictionsFactoryUtil.like("nome", "%" + nome + "%"));			
		}
		
		if(Validator.isNotNull(codiceServizio)){
			query.add(RestrictionsFactoryUtil.like("codice", "%" + codiceServizio + "%"));
		}
		
		if(soloServiziAttivi) {
			query.add(RestrictionsFactoryUtil.eq("attivo", true));
		}
		
		List<Servizio> listaServiziFiltrata = servizioLocalService.dynamicQuery(query);
		
		actionRequest.setAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI, listaServiziFiltrata);
		
	}
}