package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPK;

@Component(immediate = true, service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE,
		"mvc.command.name=/action/aggiungiAllegato"
})
public class AggiungiAllegatoActionCommand extends BaseMVCActionCommand {
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("-yyyy-MM-dd-HH-mm-ss");
	
	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;
	@Reference
	private DLAppService dlAppService;
	@Reference
	private Portal portal;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext context = ServiceContextFactory.getInstance(request);
		UploadPortletRequest upr = portal.getUploadPortletRequest(request);
		
		long richiestaId = ParamUtil.getLong(request, "richiestaId");
		String titoloDocumento = ParamUtil.getString(request, "titoloDocumento");
		boolean visibileAlCittadino = ParamUtil.getBoolean(request, "visibileAlCittadino");
		
		File file = upr.getFile("allegato");
		String fileName = generateFilename(upr.getFileName("allegato"));
		String contentType = upr.getContentType("allegato");
		
		FileEntry fileEntry = dlAppService.addFileEntry(
				"", 
				context.getScopeGroupId(),  
				0, 
				fileName, 
				contentType, 
				fileName, 
				null, 
				titoloDocumento, 
				null, 
				file, 
				null, 
				null, 
				context);
		
		AllegatoRichiestaPK pk = new AllegatoRichiestaPK(richiestaId, fileEntry.getFileEntryId());
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
				
		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_ALLEGATI);
		renderParameters.setValue("isMain", String.valueOf(false));
	}

	private String generateFilename(String fileName) {
		Date now = new Date();
		String datePart = FORMATTER.format(now);
		int pos = fileName.lastIndexOf('.');
		
		if (pos < 0) {
			return fileName + datePart;
		} else {
			String extension = fileName.substring(pos + 1);
			String name = fileName.substring(0, pos);
			return name + datePart + "." + extension;
		}
	}

}
