package it.servizidigitali.scrivaniaoperatore.frontend.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.model.File;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;

@Component(immediate = true, property = { //
		"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, //
		"mvc.command.name=/downloadFileModelloCompilato" }, //
		service = { MVCResourceCommand.class }//
) //
public class DownloadFileModelloCompilatoResourceCommand extends BaseMVCResourceCommand {

	public static final Log log = LogFactoryUtil.getLog(DownloadFileModelloCompilatoResourceCommand.class);

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long richiestaId = ParamUtil.getLong(resourceRequest, "richiestaId");

		AllegatoRichiesta allegatoRichiestaByRichiestaIdPrincipale = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdPrincipale(richiestaId, true).get(0);

		File requestFile = fileServiceFactory.getActiveFileService().getRequestFile(allegatoRichiestaByRichiestaIdPrincipale.getIdDocumentale(), themeDisplay.getScopeGroupId());

		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, requestFile.getNome(), requestFile.getInputStream().readAllBytes(), requestFile.getMimeType());

	}

}