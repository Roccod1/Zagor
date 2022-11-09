<%@ include file="./init.jsp" %>

<portlet:renderURL var="generaCertificatoUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=PresentatoreFormsPortletKeys.GENERA_CERTIFICATO_RENDER_COMMAND %>" />
	<portlet:param name="codiceFiscaleComponente" value="${selectComponentiNucleoFamiliare}" />
</portlet:renderURL>

<portlet:renderURL var="homeURL"></portlet:renderURL>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/pdf.js" /></script>

<liferay-ui:error key="<%=PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA %>" message="error.generico" />

<div class="page-header">
	<b>${titoloPortletServizio}</b>
</div>
<aui:row>
	<div class="content">
		<div class="alpaca-wizard">
			<div class="alpaca-wizard-nav">
				<nav class="navbar navbar-default" role="navigation">
					<div class="alpaca-wizard-back">
						<ul class="nav navbar-nav">
							<li data-alpaca-wizard-step-index="0" class="disabled">
								<div class="holder">
									<div class="title">...</div>
									<div class="description"></div>
								</div>
								<div class="chevron"></div>
							</li>
							<li class="active visited" data-alpaca-wizard-step-index="1">
								<div class="holder">
									<div class="title">
										<liferay-ui:message key="label.step.ultimoStep"/>
									</div>
									<c:choose>
										<c:when test="${daPagare}">
											<div class="description">
												<liferay-ui:message key="label.step.ultimoStep.pagamento.description"/>
											</div>
										</c:when>
										<c:otherwise>
											<div class="description">Download</div>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="chevron"></div>
							</li>
						</ul>
					</div>
				</nav>			
			</div>
		</div>
		
		<div class="alpaca-wizard-progress-bar">
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: 100%;"
					aria-valuemax="10" aria-valuenow="10" aria-valuemin="10"></div>
			</div>
		</div>
		
		<aui:row>
			<aui:col span="12">
				<c:choose>
					<c:when test="${daPagare}">
						<label class="text-center"> 
							<liferay-ui:message key="label.certificato.ultimoStep.titolo.sceltaPagamento"/>
						</label>
						<div class="mt-3">
							<c:choose>
								<c:when test="${empty delega}">
									<liferay-ui:message key="label.certificato.ultimoStep.descrizione.sceltaPagamento"/>
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="label.certificato.ultimoStep.descrizione.sceltaPagamento.delega"/>
								</c:otherwise>
							</c:choose>
							<c:if test="${certificatiPdfPreviewEnabled}">
								<div class="mt-3">
									<div class="row-fluid bg_white">
										<liferay-ui:message key="label.certificato.ultimoStep.preview"/>
										<div class="span8 text-center offset2" id="certificatoPdfViewer"> </div>
									</div>
								</div>
							</c:if>
						</div>
					</c:when>
					<c:when test="${richiestaStatus != bozzaStatus && downloadCertificato}">
						<label class="text-center"> 
							<liferay-ui:message key="label.certificato.ultimoStep.titolo.downloadCertificato"/>
						</label>
						<div class="mt-3">
							<c:choose>
								<c:when test="${empty delega}">
									<liferay-ui:message key="label.certificato.ultimoStep.descrizione.downloadCertificato"/>
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="label.certificato.ultimoStep.descrizione.downloadCertificato.delega"/>
								</c:otherwise>
							</c:choose>
						</div>
					</c:when>
					<c:otherwise>
						<label class="text-center">
							<liferay-ui:message key="label.certificato.ultimoStep.titolo.generazioneCertificato"/>
						</label>
						
						<c:if test="${certificatiPdfPreviewEnabled}">
							<div class="mt-3">
								<div class="row-fluid bg_white">
									<liferay-ui:message key="label.certificato.ultimoStep.preview"/>
									<div class="span8 text-center offset2" id="certificatoPdfViewer"> </div>
								</div>
							</div>
						</c:if>
						
						<div class="mt-3">
							<liferay-ui:message key="label.certificato.ultimoStep.descrizione.generazioneCertificato"/>
						</div>
					</c:otherwise>
				</c:choose>
			</aui:col>
		
		</aui:row>
		
		<c:choose>
			<c:when test="${richiestaStatus == bozzaStatus}">
				<aui:button-row>
					<aui:button value="label.annulla" id="indietro" href="${homeURL}"/>
					<aui:button value="label.procedi" id="salva-e-invia"/>
				</aui:button-row>

				<!-- Modale salva e invia -->
				<div class="modal fade" id="salva-invia-modal" tabindex="-1" role="dialog" aria-labelledby="salvaInviaModal">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="salvaInviaModal">
									<c:choose>
										<c:when test="${daPagare}">
											<liferay-ui:message key="modal.conferma.invio.reindirizzamento.pagoPa.titolo"/>

										</c:when>
										<c:otherwise>
											<liferay-ui:message key="modal.conferma.invio.pagamento.titolo"/>
										</c:otherwise>
									</c:choose>
								</h4>
							</div>
							<div class="modal-body">
								<c:choose>
									<c:when test="${daPagare}">
										<div class="modal-body-generaCertificato">
											<liferay-ui:message key="modal.conferma.invio.pagamento.generazione.body"/>
										</div>
										<div class="modal-body-pagaBollo" style="display: none;">
											<liferay-ui:message key="modal.conferma.invio.pagamento.body"/>
										</div>
									</c:when>
									<c:otherwise>
										<div class="modal-body-generaCertificato">
											<liferay-ui:message key="modal.conferma.invio.generazione.nobollo.body"/>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="modal-footer">
								<aui:button-row>
									<aui:button value="label.annulla" data-dismiss="modal"/>
									<a id="salva-invia-modal-button" class="btn btn-primary" href="${generaCertificatoUrl}&<portlet:namespace />destinazioneUsoId=${destinazioneUsoId}">Procedi</a>
								</aui:button-row>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:when test="${richiestaStatus != bozzaStatus && downloadCertificato}">
				<c:choose>
					<c:when test="${empty pdfFirmato}">
						<liferay-ui:message key="label.certificato.errore.recupero.file"/>
					</c:when>
					<c:otherwise>
						<portlet:resourceURL id="downloadFile" var="downloadFileUrl">
							<portlet:param name="idDocumentale"
								value="${pdfFirmato.idDocumentale}" />
							<portlet:param name="filename" value="${pdfFirmato.fileName}" />
							<portlet:param name="idServizio" value="${idServizio}" />
							<portlet:param name="idIstanzaForm" value="${idRichiesta}" />
						</portlet:resourceURL>
						<a class="btn btn-custom" href="${downloadFileUrl}">
							<liferay-ui:message key="download.certificato"/>
						</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${evaluationServiceEnable && !invioIstanza}">
						<%@ include file="./pulsanteValutaServizio.jsp"%>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<div class="clearfix"></div>
			</c:when>
		</c:choose>
	</div>
</aui:row>

<script>
	//Apre il modal
	$('#<portlet:namespace />salva-e-invia').click(function(e) {
		e.preventDefault();
		$('#salva-invia-modal').modal('show');
	});
	
	$('#salva-invia-modal-button').click(function(e) {
		$(this).addClass('disabled');
	});
	
	var certificatiPdfPreviewEnabled = '${certificatiPdfPreviewEnabled}';
	
	if (certificatiPdfPreviewEnabled === 'true') {
		var basePdf = "${base64PDFCertificato}"; 
	 	var pdfBase64StringAtob = atob(basePdf); 
		viewPdf(pdfBase64StringAtob, 'certificatoPdfViewer');
	}
	
	function viewPdf(pdfBase64String, idToRender){
		
		/* Loaded via <script> tag, create shortcut to access PDF.js exports.*/
		var pdfjsLib = window['pdfjs-dist/build/pdf'];

		/* The workerSrc property shall be specified.*/
		pdfjsLib.GlobalWorkerOptions.workerSrc = '<%=request.getContextPath()%>/scripts/pdf.worker.js';

		/*Using DocumentInitParameters object to load binary data.*/
		var loadingTask = pdfjsLib.getDocument({data: pdfBase64String});
		loadingTask.promise.then(function(pdf) {
		  console.log('PDF loaded');
		  viewer = document.getElementById(idToRender);
		  
		  for(page = 1; page <= pdf.numPages; page++) {
	          canvas = document.createElement("canvas");    
	          canvas.className = 'certificatoPdfContainer';  
	          canvas.style = 'margin-top: 20px; margin-bottom: 20px; outline: black 2px solid;';
	          viewer.appendChild(canvas);  
	          renderPage(page, canvas, pdf);
	        }

		}, function (reason) {
			/* PDF loading error */
		  console.error(reason);
		});
		
	}

	function renderPage(pageNumber, canvas, pdf){
		 pdf.getPage(pageNumber).then(function(page) {
		    console.log('Page loaded');
		    var scale = 1;
		    var viewport = page.getViewport({scale: scale});

		    /* Prepare canvas using PDF page dimensions*/
		    var context = canvas.getContext('2d');
		    canvas.height = viewport.height;
		    canvas.width = viewport.width;

		    /* Render PDF page into canvas context */
		    var renderContext = {
		      canvasContext: context,
		      viewport: viewport
		    };
		    var renderTask = page.render(renderContext);
		    renderTask.promise.then(function () {
		      console.log('Page rendered');
		    });
		  });
	}
</script>