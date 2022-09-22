package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPK;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/aggiungiAllegato"
})
public class AggiungiAllegatoActionCommand extends BaseMVCActionCommand {

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;
	@Reference
	private DLAppService dlAppService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		long fileEntryId = ParamUtil.getLong(request, "fileId");
		String titoloDocumento = ParamUtil.getString(request, "titoloDocumento");
		boolean visibileAlCittadino = ParamUtil.getBoolean(request, "visibileAlCittadino");

		ServiceContext context = ServiceContextFactory.getInstance(request);
		
		AllegatoRichiestaPK pk = new AllegatoRichiestaPK(richiestaId, fileEntryId);
		AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(pk);
		allegatoRichiesta.setGroupId(context.getScopeGroupId());
		allegatoRichiesta.setCompanyId(context.getCompanyId());
		allegatoRichiesta.setUserId(context.getUserId());
		//allegatoRichiesta.setUserName(context.getUs);
		allegatoRichiesta.setCreateDate(new Date());
		allegatoRichiesta.setModifiedDate(new Date());
		allegatoRichiesta.setNome(null);
		allegatoRichiesta.setVisibile(visibileAlCittadino);
		allegatoRichiesta.setInterno(true);
		
		allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);
		
		FileEntry originalFileEntry = dlAppService.getFileEntry(fileEntryId);
		
		//TODO spostare in service
		dlAppService.updateFileEntry(
				fileEntryId, 
				originalFileEntry.getFileName(), 
				originalFileEntry.getMimeType(), 
				originalFileEntry.getTitle(),
				null, 
				titoloDocumento, 
				null, 
				DLVersionNumberIncrease.NONE, 
				(byte[]) null, 
				null, 
				null, 
				context);
		
		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_ALLEGATI);
	}

}
