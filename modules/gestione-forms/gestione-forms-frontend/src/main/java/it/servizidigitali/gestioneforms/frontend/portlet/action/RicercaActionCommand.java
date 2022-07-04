package it.servizidigitali.gestioneforms.frontend.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneFormsPortletKeys.GESTIONEFORMS,
			"mvc.command.name=/ricerca" 
		}, 
service = { MVCActionCommand.class }
)
public class RicercaActionCommand extends BaseMVCActionCommand{
	public static final Log _log = LogFactoryUtil.getLog(RicercaActionCommand.class);
	
	@Reference
	private FormLocalService formLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String descrizione = ParamUtil.getString(actionRequest, "nome");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataInserimentoDaString = ParamUtil.getString(actionRequest, "dataInserimentoDa");
		String dataInserimentoAString = ParamUtil.getString(actionRequest, "dataInserimentoA");
		DynamicQuery dynamicQuery = formLocalService.dynamicQuery();
		
		if(Validator.isNotNull(descrizione)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("descrizione", StringPool.PERCENT + descrizione + StringPool.PERCENT));
		}
		
		if(Validator.isNotNull(dataInserimentoDaString)) {
			Date dataInserimentoDa = sdf.parse(dataInserimentoDaString);
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", dataInserimentoDa));
		}
		
		if(Validator.isNotNull(dataInserimentoAString)) {
			Date dataInserimentoA = sdf.parse(dataInserimentoAString);
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", dataInserimentoA));
		}
		
		List<Form> listaForm = formLocalService.dynamicQuery(dynamicQuery);
		
		actionRequest.setAttribute("listaForm", listaForm);
	}

}
