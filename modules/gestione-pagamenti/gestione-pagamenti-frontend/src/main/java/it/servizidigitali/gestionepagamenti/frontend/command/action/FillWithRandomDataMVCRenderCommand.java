package it.servizidigitali.gestionepagamenti.frontend.command.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + GestionePagamentiFrontendPortletKeys.GESTIONEPAGAMENTIFRONTEND,
"mvc.command.name=/persona/fillWithRandomData" }, service = { MVCRenderCommand.class })
public class FillWithRandomDataMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Pagamento pagamento = PagamentoLocalServiceUtil.createPagamento(0);

		pagamento.setCreateDate(randomDate());
		pagamento.setModifiedDate(randomDate());

		pagamento.setIdCredito(randomString(10));
		pagamento.setIdFiscaleCliente(randomString(16));
		pagamento.setDenominazioneCliente(randomString(10));
		pagamento.setEmailQuietanza(randomString(10));
		pagamento.setCausale(randomString(10));
		pagamento.setDescrizioneServizio(randomString(10));
		pagamento.setImporto(randomBigDecimal());
		pagamento.setCommissioni(randomBigDecimal());
		pagamento.setCanale(randomString(10));
		pagamento.setIud(randomString(10));
		pagamento.setIuv(randomString(10));
		pagamento.setIdSessione(randomString(10));
		pagamento.setPathAvviso(randomString(10));
		pagamento.setEmailInviata(randomBoolean());
		pagamento.setStato(randomString(10));
		pagamento.setRichiestaId(randomLong());
		
		PagamentoLocalServiceUtil.updatePagamento(pagamento);

		return "/view.jsp";
	}
	
	private Date randomDate() {

		try {
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");

			Date startInclusive = dateFormat.parse("2000-01-01");
			Date endExclusive = dateFormat.parse("2026-01-01");

			long startMillis = startInclusive.getTime();
			long endMillis = endExclusive.getTime();

			long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);

			return new Date(randomMillisSinceEpoch);
		} catch (Exception e) {
			e.printStackTrace();
			return Date.from(Instant.now());
		}
	}
	
	private String randomString(int length) {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(length)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    return generatedString;
	}
	
	private boolean randomBoolean() {
		return new Random().nextBoolean();
	}

	private long randomLong() {
		return new Random().nextLong();
	}
	
	private BigDecimal randomBigDecimal() {
		return BigDecimal.valueOf(Math.random());
	}
}
