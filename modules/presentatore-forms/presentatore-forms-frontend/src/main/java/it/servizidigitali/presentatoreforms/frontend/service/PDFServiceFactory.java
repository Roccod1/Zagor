package it.servizidigitali.presentatoreforms.frontend.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;

/**
 * @author pindi
 *
 */
@Component(name = "pdfServiceFactory", immediate = true, service = PDFServiceFactory.class)
public class PDFServiceFactory {

	@Reference(target = "(component.name=alpacaPDFService)")
	private PDFService alpacaPDFService;

	@Reference(target = "(component.name=jasperReportPDFService)")
	private PDFService jasperReportPDFService;

	/**
	 *
	 * @param tipoGenerazionePDF
	 * @return
	 */
	public PDFService getPDFService(TipoGenerazionePDF tipoGenerazionePDF) {
		switch (tipoGenerazionePDF) {
		case NATIVA:
			return alpacaPDFService;
		case JASPER_REPORT:
			return jasperReportPDFService;
		default:
			return null;
		}
	}

}
