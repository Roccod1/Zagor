package it.servizidigitali.pagamento.ebollo.frontend.constants;

/**
 * @author pindi
 */
public class PagamentoEbolloFrontendPortletKeys {

	public static final String PAGAMENTOEBOLLOFRONTEND =
		"pagamento_ebollo_frontend_PagamentoEbolloFrontendPortlet";
	
	public static final String UPLOAD_FILE_ACTION_COMMAND = "/uploadFile";
	
	public static final String ESITO_PAGAMENTO_RENDER_COMMAND = "/esitoPagamento";
	public static final String ESITO_PAGAMENTO_RENDER_VIEW = "/esitoPagamento.jsp";
	public static final String ESITO_PAGAMENTO_CALLBACK_ATTRIBUTE = "esitoPagamento";
	public static final String PAGAMENTO_ANNULLATO_CALLBACK_ATTRIBUTE = "pagamentoAnnullato";
	
	public static final String FILE_TO_UPLOAD_ATTRIBUTE = "fileToUpload";
	
	public static final String REDIRECT_PAGAMENTO_BOLLO_URL = "redirectPagamentoBolloUrl";
	public static final String ERROR_OCCURRED_ON_PAGA_BOLLO = "errorOccurredOnPagaBollo";
	public static final String ERROR_MESSAGE_ON_PAGA_BOLLO = "errorMessageOnPagaBollo";
}