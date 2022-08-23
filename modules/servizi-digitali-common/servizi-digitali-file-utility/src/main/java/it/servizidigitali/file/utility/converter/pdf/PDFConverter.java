package it.servizidigitali.file.utility.converter.pdf;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.servizidigitali.file.utility.configuration.FileConverterConfiguration;
import it.servizidigitali.file.utility.exception.FileConverterException;

/**
 * @author pindi
 *
 */
@Component(name = "PDFConverter", immediate = true, service = PDFConverter.class, configurationPid = "it.servizidigitali.file.utility.configuration.FileConverterConfiguration")
public class PDFConverter {

	private static final Log log = LogFactoryUtil.getLog(PDFConverter.class.getName());

	private volatile FileConverterConfiguration fileConverterConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		fileConverterConfiguration = ConfigurableUtil.createConfigurable(FileConverterConfiguration.class, props);
		wkhtmltopdfKeyValueParams = fileConverterConfiguration.wkhtmltopdfKeyValueParams();
	}

	private String[] wkhtmltopdfKeyValueParams;

	public byte[] generatePDF(String htmlContent) throws FileConverterException {
		try {

			Pdf pdf = new Pdf(new WrapperConfig(fileConverterConfiguration.wkhtmltopdfCommandPath()));

			if (wkhtmltopdfKeyValueParams != null) {
				for (String params : wkhtmltopdfKeyValueParams) {
					String[] split = params.split("=");
					String key = split[0];
					String value = split[1];
					Param param = new Param(key, value);
					pdf.addParam(param);
				}
			}

			pdf.setAllowMissingAssets();
			pdf.addPageFromString(htmlContent);

			return pdf.getPDF();
		}
		catch (Exception e) {
			log.error("Unable to generate PDF :: " + e.getMessage(), e);
			throw new FileConverterException("Unable to generate PDF :: " + e.getMessage(), e);
		}
	}

}
