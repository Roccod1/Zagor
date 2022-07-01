package it.servizidigitali.gestioneforms.frontend.portlet.action;

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
		// TODO Auto-generated method stub
		String nome = ParamUtil.getString(actionRequest, "nome");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInserimentoDa = ParamUtil.getDate(actionRequest, "dataInserimentoDa", sdf);
		Date dataInserimentoA = ParamUtil.getDate(actionRequest, "dataInserimentoA",sdf);
		DynamicQuery dynamicQuery = formLocalService.dynamicQuery();
		
		if(!Validator.isNull(nome)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("descrizione", nome));
		}
		
		if(!Validator.isNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.between("createDate", dataInserimentoDa, dataInserimentoA));
		}
		
		List<Form> listaForm = formLocalService.dynamicQuery(dynamicQuery);
		
		actionRequest.setAttribute("listaForm", listaForm);
	}

}
