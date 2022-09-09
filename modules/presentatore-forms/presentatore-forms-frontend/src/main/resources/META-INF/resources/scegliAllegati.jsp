<%@ include file="./init.jsp"%>


<portlet:resourceURL id="<%=PresentatoreFormsPortletKeys.UPLOAD_ALLEGATO_RESOURCE_COMMAND %>" var="uploadFileUrl">
	<portlet:param name="idServizio" value="${idServizio}" />
</portlet:resourceURL>

<portlet:actionURL var="salvaUrl">
	<portlet:param name="action" value="action-salva" />
	<portlet:param name="idServizio" value="${idServizio}" />
</portlet:actionURL>

<portlet:renderURL var="homeScrivaniaUrl">
	<portlet:param name="portletAction" value="renderizzaFormJson" />
	<portlet:param name="idServizio" value="${idServizio}" />
	<portlet:param name="caricaBozza" value="true" />
	<portlet:param name="idRichiestaServizio" value="${idRichiesta}" />
</portlet:renderURL>

<script>
console.log("dentro scegli allegati");
</script>
<c:choose>
	<c:when test="${richiestaStatus == bozzaStatus }">
		<div class="row-fluid">
			<div class="page-header">
				<h2 class="noMargin">${titoloPortletServizio}</h2>
			</div>
			
			<%-- TODO 
			<c:if test="${not empty concorsoAttivo}">
				<div class="row-fluid">
					<div class="span12 text-right">
						<liferay-ui:message key="label.concorso.validita" />:&nbsp;
						<liferay-ui:message key="label.concorso.validita.da" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataApertura}" pattern="dd/MM/yyyy HH:mm"/>&nbsp;
						<liferay-ui:message key="label.concorso.validita.a" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataChiusura}" pattern="dd/MM/yyyy HH:mm"/>
					</div>
				</div>
			</c:if>
			--%>
			<div class="formpresenter-portlet allegati">
				<div class="alpaca-wizard">
				    <div class="alpaca-wizard-nav">
			            <nav class="navbar navbar-default" role="navigation">
			                <div class="container-fluid alpaca-wizard-back">
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
			                                <div class="title"><liferay-ui:message key="label.step.ultimoStep" /></div>
			                                <c:choose>
			                                	<c:when test="${!invioIstanza}">
					                                <div class="description">Download</div>
			                                	</c:when>
			                                	<c:when test="${firmaDocumentoAbilitata}">
					                                <div class="description">Download</div>
			                                	</c:when>
			                                	<c:otherwise>
					                                <div class="description">Invio istanza</div>
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
               			 <div class="progress-bar" role="progressbar" style="width: 100%;" aria-valuemax="10" aria-valuenow="10" aria-valuemin="10"></div>
           			  </div>
        		</div>
        		
				<aui:form action="${salvaUrl}" name="salva-form" enctype="multipart/form-data">
				
					<div class="row-fluid">
						<div class="span12">
							<div class="control-group">
				        		<c:choose>
				        			<c:when test="${firmaDocumentoAbilitata}">
						       			<label class= "text-center">
						       				<liferay-ui:message key="pdf.firmato.istanza" />
						     			</label>
										<liferay-ui:success key="save-success" message="success.salvataggioIstanza" />
										<liferay-ui:error key="save-error" message="error.salvataggioIstanza" />
										
										<%-- FIXME <liferay-journal:journal-article articleId="${scegliAllegatiDescription}" languageId="<%=themeDisplay.getLanguageId()%>" groupId="<%=themeDisplay.getScopeGroup().getGroupId()%>"/> --%>
										
										<div class="form-actions text-center">
											<portlet:resourceURL id="downloadIstanza" var="downloadIstanzaUrl">
												<portlet:param name="idServizio" value="${idServizio}" />
												<portlet:param name="idIstanzaForm" value="${idRichiesta}" />
											</portlet:resourceURL>
											<button class="btn btn-primary" type="button" onclick="location.href='${downloadIstanzaUrl}'">
												<i class="fa fa-download marginright10" aria-hidden="true"></i>
												<liferay-ui:message key="download.istanza.dafirmare" />
											</button>
										</div>
										
										<label class="control-label" for="uploadFileFirmato"><liferay-ui:message key="upload.documento.firmato" /> (<liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione" arguments="${uploadFileMaxSizeLabel}"/>): </label>
										<div class="controls">
											<input type="hidden" class="allegato" name="${nomeFileFirmato}"	value="${empty pdfFirmato ? '' : pdfFirmato.fileName }">
											
											<div id="div-uploadFileFirmato" <c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>>					
												<div class="control-group">
											  	  	<div class="" style="margin-left:0px; display: inline-block">
														<aui:input type="file" id="uploadFileFirmato" name="" required="true">
															<aui:validator name="acceptFiles">".pdf,.p7m"</aui:validator>
															<aui:validator name="custom" errorMessage="La dimensione del file non deve superare ${uploadFileMaxSizeLabel}">
																function(val,node,junction){
																return node._node.files[0].size <= ${uploadFileMaxSize};
																}
																</aui:validator>
														</aui:input>
												    </div>
												    <button class="btn btn-secondary save-attachment-uploadFileFirmato" type="button" style="vertical-align: top">
														<liferay-ui:message key="label-conferma"/>
												    </button>
											    </div>
											    <div id="alertUplaodAllegato-uploadFileFirmato" class="portlet-msg-alert hidden">
													<liferay-ui:message key="errore-durante-il-caricamento-dell-allegato"/>
												</div>
												<div id="successUplaodAllegato-uploadFileFirmato" class="portlet-msg-success hidden">
													<liferay-ui:message key="conferma-caricamento-dell-allegato"/>
												</div>			
											</div>	
														
											<c:if test="${not empty pdfFirmato}">
												<div id="allegatodocumentale-container-${nomeFileFirmato}"
													class="alert alert-info">
													<liferay-ui:message key="file.gia.archiviato.1" />
													<portlet:resourceURL id="downloadFile" var="downloadFilePrincipaleUrl">
														<portlet:param name="idServizio" value="${idServizio}" />
														<portlet:param name="idDocumentale" value="${pdfFirmato.idDocumentale}" />
														<portlet:param name="filename" value="${pdfFirmato.fileName}" />
													</portlet:resourceURL>
													(<a target="_BLANK" class="" href="${downloadFilePrincipaleUrl}" title='<liferay-ui:message key="label.download" />'>
														<c:out value="${pdfFirmato.fileName}"/> 
													</a>).
													<liferay-ui:message key="file.gia.archiviato.2" />.
													<input type="hidden" name="allegatodocumentale-${nomeFileFirmato}" value="${pdfFirmato.idDocumentale}">
												</div>
											</c:if>
										</div>
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
				        			</c:when>
				        			<c:otherwise>
				        				<c:choose>
						     				<c:when test="${!invioIstanza}">
								     			<label class="text-center">
						       						<liferay-ui:message key="pdf.firmato.no.invio.download.title" />
						     					</label>
						     				</c:when>
						     				<c:otherwise>
								     			<label class="text-center">
						       						<liferay-ui:message key="pdf.firmato.istanza.download" />
						     					</label>
						     				</c:otherwise>
						     			</c:choose>
				        				
						     			<c:choose>
						     				<c:when test="${!invioIstanza}">
						       					<div class="margintop10"><liferay-ui:message key="pdf.firmato.no.invio.istanza.download.descrizione"/></div>
						     				</c:when>
						     				<c:when test="${not empty allegati}">
								     			<div class="margintop10"><liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.descrizione"/></div>
								     			<div class="margintop10"><liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione.toppagina" arguments="${uploadFileMaxSizeLabel}"/></div>
						     				</c:when>
						     				<c:otherwise>
								     			<div class="margintop10"><liferay-ui:message key="pdf.firmato.istanza.download.descrizione"/></div>
						     				</c:otherwise>
						     			</c:choose>
				        			</c:otherwise>
				        		</c:choose>
							</div>
						</div>
					</div>

					<!-- Allegati -->
					<c:if test="${not empty allegati}">
						<div class="row-fluid">
							<div class="span12">
								<fieldset>
									<legend>
										<liferay-ui:message key="label.allegati" />
									</legend>
	
									<c:forEach items="${allegati}" var="allegato" varStatus="loop">
										<div class="control-group margintop10 alpaca-field-object">
											<label class="control-label" for="allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}">${allegato.definizione.denominazione}<c:if test="${allegato.definizione.obbligatorio}">*</c:if> (<liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione" arguments="${uploadFileMaxSizeLabel}"/>):</label>
											<c:if test="${not empty allegato.datiFile}">
												<div id="allegatodocumentale-container-${loop.index}-${allegato.definizione.definizioneAllegatoId}" class="alert alert-info">
													<liferay-ui:message key="file.gia.archiviato.1" arguments="${allegato.definizione.denominazione}" />
													<portlet:resourceURL id="downloadFile" var="downloadFileUrl">
														<portlet:param name="idDocumentale" value="${allegato.datiFile.idDocumentale}" />
														<portlet:param name="filename" value="${allegato.datiFile.fileName}" />
														<portlet:param name="idServizio" value="${idServizio}" />
													</portlet:resourceURL>
													(<a target="_BLANK" class="" href="${downloadFileUrl}" title='<liferay-ui:message key="label.download" />'>
														<c:out value="${allegato.datiFile.fileName}"/>
													</a>).
													<input type="hidden" name="allegatodocumentale-${loop.index}-${allegato.definizione.definizioneAllegatoId}" value="${allegato.datiFile.idDocumentale}">
												</div>
											</c:if>
											
											<c:if test="${not empty allegato.definizione.filenameModello }">
												<span class="help-block"> 
													<spring:message	code="documento.precompilato.info" />
												</span>
												<div class="margintop10 marginbottom10">
													<portlet:resourceURL id="downloadModello" var="downloadModelloUrl">
														<portlet:param name="id" value="${allegato.definizione.definizioneAllegatoId}" />
														<portlet:param name="fileName" value="${allegato.definizione.filenameModello}" />
														<portlet:param name="idServizio" value="${idServizio}" />
													</portlet:resourceURL>
													<a class="btn btn-custom" href="${downloadModelloUrl}" title='<liferay-ui:message key="label.download" />'>
														<liferay-ui:message key="download.modello" />
													</a>
												</div>
											</c:if>
	
											<div class="controls">
											<input type="hidden" class="allegato" name="allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" value="${empty allegato.datiFile ? '' : allegato.datiFile.fileName }">
												<div class="row-fluid">
													<div class="span8">
														<c:choose>
															<c:when test="${not empty allegato.datiFile}">
																<div>
																	<liferay-ui:message key="file.gia.archiviato.2" />
																	<c:choose>
																		<c:when test="${not empty allegato.documentiPersonali}">
																			<liferay-ui:message key="file.gia.archiviato.3" />:
																		</c:when>
																		<c:otherwise>
																			<liferay-ui:message key="file.gia.archiviato.4" />
																		</c:otherwise>
																	</c:choose>
																</div>
															</c:when>
															<c:otherwise>
																<c:if test="${not empty allegato.documentiPersonali}">
																	<div><liferay-ui:message key="file.da.documenti.personali.1" />:</div>
																</c:if>
															</c:otherwise>
														</c:choose>
														<!-- Scelta documenti personali, se presenti -->
														<c:if test="${not empty allegato.documentiPersonali}">
															<div id="allegati-documenti-personali">
																<c:forEach items="${allegato.documentiPersonali}" var="documentoPersonale">
																	<label for="allegato-personale-${documentoPersonale.idRepository}" class="radio">
																		<input type="radio" class="allegato allegato-personale-class" id="allegato-personale-${documentoPersonale.idRepository}" 
																			name="allegatodocumentale-personale-${loop.index}-${allegato.definizione.definizioneAllegatoId}" 
																			value="${documentoPersonale.codice}">
																		<c:out value="${documentoPersonale.titolo}"/> 
																		<portlet:resourceURL id="downloadDocumentoPersonale" var="downloadDocumentoPersonaleUrl">
																			<portlet:param name="codice" value="${documentoPersonale.codice}" />
																			<portlet:param name="idServizio" value="${idServizio}" />
																		</portlet:resourceURL>
																		(<a target="_BLANK" class="" href="${downloadDocumentoPersonaleUrl}">
																			<c:out value="${documentoPersonale.nomeFile}"/> 
																		</a>)
																		&nbsp;
																		<c:choose>
																			<c:when test="${documentoPersonale.inScadenza}">
																				<span style="color: orange;"><liferay-ui:message key="label.documentiPersonali.stato.in.scadenza" /></span>
																			</c:when>
																			<c:when test="${documentoPersonale.scaduto}">
																				<span style="color: red;"><liferay-ui:message key="label.documentiPersonali.stato.scaduto" /></span>
																			</c:when>
																		</c:choose>
																	</label>
																</c:forEach>
															</div>
														</c:if>
														<c:if test="${not empty allegato.documentiPersonali}">
															<div>
																<liferay-ui:message key="file.da.documenti.personali.2" />
																<a class="toggleUploadFileLink" data-param1="${loop.index}-${allegato.definizione.definizioneAllegatoId}" href="#"><liferay-ui:message key="file.da.documenti.personali.3" /></a>.
															</div>
														</c:if>
														
														<%-- +++ MODIFICATO --%>
														<div id="div-allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" <c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>>					
												
															<div class="control-group">
														  	  	<div class="span8" style="margin-left:0px; display: inline-block">
																	<aui:input type="file" id="allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" name="" required="${allegato.definizione.obbligatorio}">
																		<aui:validator name="acceptFiles">"${allegato.definizione.tipiFileAmmessi}"</aui:validator>
																		<aui:validator name="custom" errorMessage="La dimensione del file non deve superare ${uploadFileMaxSizeLabel}">
																			function(val,node,junction){
																			return node._node.files[0].size <= ${uploadFileMaxSize};
																			}
																			</aui:validator>
																	</aui:input>
															    </div>
															    <button class="btn btn-secondary save-attachment-${loop.index}-${allegato.definizione.definizioneAllegatoId}" type="button"  style="vertical-align: top">
																	<liferay-ui:message key="label-conferma"/>
															    </button>
														    </div>
														    <div id="alertUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" class="portlet-msg-alert hidden">
																<liferay-ui:message key="errore-durante-il-caricamento-dell-allegato"/>
															</div>
															<div id="successUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" class="portlet-msg-success hidden">
																<liferay-ui:message key="conferma-caricamento-dell-allegato"/>
															</div>
														
														</div>
														
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</fieldset>
							</div>
						</div>
					</c:if>
					<input type="hidden" name="idIstanzaForm" value="${idRichiesta}">
					<input type="hidden" name="inBozza" value="true" id="in-bozza">
					
				</aui:form>
				<div class="form-actions">
					<a class="btn btn-sm btn-secondary" href="${homeScrivaniaUrl}"><liferay-ui:message key="label.indietro" /></a>
					<c:choose>
	        			<c:when test="${firmaDocumentoAbilitata && invioIstanza}">
							<button class="btn btn-sm btn-primary pull-right" id="salva-e-invia">
								<liferay-ui:message key="salva.einvia" />
							</button>
	        			</c:when>
	        			<c:otherwise>
	        				<portlet:resourceURL id="downloadIstanza" var="downloadIstanzaUrl">
								<portlet:param name="idServizio" value="${idServizio}" />
								<portlet:param name="idIstanzaForm" value="${idRichiesta}" />
							</portlet:resourceURL>
							<a class="btn btn-sm btn-secondary" href="${downloadIstanzaUrl}"><liferay-ui:message key="download.istanza" /></a>
							<c:choose>
								<c:when test="${invioIstanza}">
		        					<button class="btn btn-sm btn-primary pull-right" id="salva-e-invia">
										<liferay-ui:message key="invia.solo" />
									</button>
	        					</c:when>
	        					<c:when test="${evaluationServiceEnable && !invioIstanza}">
	        						<%@ include file="./pulsanteValutaServizio.jsp"%>
	        					</c:when>
	        					<c:otherwise>
	        					</c:otherwise>
	        				</c:choose>
	        			</c:otherwise>
        			</c:choose>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>

		<!-- Modale salva e invia -->
		<div class="modal fade" id="salva-invia-modal" tabindex="-1" style="display: none;"
			role="dialog" aria-labelledby="salvaInviaModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="salvaInviaModal">
							<liferay-ui:message key="conferma.invio.richiesta" />
						</h4>
					</div>
					<div class="modal-body">
						<liferay-ui:message key="conferma.invio.richiesta.dettaglio" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<liferay-ui:message key="label.annulla" />
						</button>
						<button type="button" class="btn btn-primary"
							id="salva-invia-modal-button">
							<liferay-ui:message key="label.procedi" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modale download istanza -->
		<div class="modal fade" id="download-modal" tabindex="-1" style="display: none;"
			role="dialog" aria-labelledby="downloadModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="downloadModal">
							<liferay-ui:message key="attendere.download.pdf" />
						</h4>
					</div>
					<div class="modal-body">
						<div class="progress progress-striped active">
							<div class="progress-bar" role="progressbar" aria-valuenow="100"
								aria-valuemin="0" aria-valuemax="100" style="width: 100%">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default dismiss-download-pdf"
							data-dismiss="modal" disabled="disabled">
							<liferay-ui:message key="label.ok" />
						</button>
					</div>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
			<div  class="row-fluid">
				La richiesta non si trova in stato bozza, controlla le tue richieste
				nella tua <a href="${pathScrivaniaVirtuale}">Scrivania Virtuale</a>
			</div>
		</c:otherwise>
	
</c:choose>
<aui:script use="liferay-form">
console.log("aui script");
</aui:script>

<script>

	var isDebugEnabled = ${isDebugEnabled};
	
	$(function(){
		//Salva in bozza handler
		$('#salva-in-bozza').click(function(){
			var $bottone = $(this);
			$bottone.prop("disabled", true);
			$("#salva-e-invia").prop("disabled", true);
			$("#in-bozza").val("true");
			
			//Submit del form
			$("#<portlet:namespace />salva-form").submit();
		});
		
		//Apre il modal
		$('#salva-e-invia').click(function(e){
			console.log("salva e invia");
			e.preventDefault();
			
			// QUI CONTROLLO ALLEGATI: se manca un allegato e non è stato checkato il relativo allegato documentale personale, segnalo all'utente
			var confirmSubmit = true;
			$("input[type='file']").each(function(){
				if (!this.value && this.id) {
							var allDocName = "allegatodocumentale-personale" + this.id.split("_allegato")[1];						if (!$("[name='"+allDocName+"']").is(":checked")) {
							alert("ATTENZIONE: alcuni allegati non risultano caricati correttamente. Si prega di correggere e riprovare. ")
							confirmSubmit = false;
							return false;
						}
				}
			});
			if (confirmSubmit) {
				$('#salva-invia-modal').modal('show');
			}
		});

		$('.toggleUploadFileLink').click(function(e){
			e.preventDefault();
			var param1 = this.dataset['param1'];
			$("input[name='allegatodocumentale-personale-" + param1 + "']").prop('checked', false);
			$('#div-allegato-' + param1).toggle();
		});
		
		//Lancia la richiesta
		$('#salva-invia-modal-button').click(function(){
			var $bottone = $(this);
			$bottone.prop("disabled", true);
			$("#salva-e-invia").prop("disabled", true);
			$("#in-bozza").val("false");
			
			//Submit del form
			$("#<portlet:namespace />salva-form").submit();
		});
					
		<%-- GESTIONE UPLOAD FILE FIRMATO--%>	
	$('.save-attachment-uploadFileFirmato').on('click', function(){	
			var nomeAllegato = $('#<portlet:namespace />uploadFileFirmato').val();
	    	var attachmentFileNameValue = nomeAllegato.replace('C:\\fakepath\\', ' ');
			var idAllegatoTemporaneoValue = '';
			
			var formData = new FormData();
			formData.append('<portlet:namespace />' + 'attachmentFile', $('#<portlet:namespace />uploadFileFirmato')[0].files[0]);
			formData.append('<portlet:namespace />' + 'idDefinizioneAllegato', 0;
			formData.append('<portlet:namespace />' + 'idIstanzaForm', ${idRichiesta});
			
			if(nomeAllegato) {
				
				$.ajax({
		    		url: "${uploadFileUrl}",
		    		type: 'POST',
		    		data: formData,
		    		processData: false,
		    		contentType: false,
		    		success: function(data){	
		    			if(data.status==='ok'){
		    				console.log("Successo in upload del file!");
		    				$("#allegatodocumentale-container-${nomeFileFirmato}").remove();
		    				$("input[name='${nomeFileFirmato}']").val(data.fileName);
		    	        	$("input[name='allegatodocumentale-${nomeFileFirmato}']").val('');
		    	        	
		    				$('#alertUplaodAllegato-uploadFileFirmato').addClass('hidden');
		    				$('#successUplaodAllegato-uploadFileFirmato').removeClass('hidden');
	 	    				idAllegatoTemporaneoValue = data.idAllegatoTemporaneo;
	 	    				
		    			}else if(data.status==='error'){
		    	        	$("input[name='${nomeFileFirmato}']").val('');
		    	        	$("input[name='allegatodocumentale-${nomeFileFirmato}']").val('');
		    	        	$("#allegatodocumentale-container-${nomeFileFirmato}").remove();
		    	    
		    				$('#alertUplaodAllegato-uploadFileFirmato').removeClass('hidden');
		    				$('#successUplaodAllegato-uploadFileFirmato').addClass('hidden');
		    				console.log("Errore durante l'upload del file!");
		    			}
		    		}, error: function(xhr){
	    				console.log("Errore durante CHIAMATA l'upload del file!");
	
		    		}
		    	});
			}
		
	});
		
		<%-- GESTIONE UPLOAD ALTRI ALLEGATI --%>
		<c:forEach items="${allegati}" var="allegato" varStatus="loop">
		
		$('.save-attachment-${loop.index}-${allegato.definizione.definizioneAllegatoId}').on('click', function(){
			
			
			var nomeAllegato = $('#<portlet:namespace />allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').val();
	    	var attachmentFileNameValue = nomeAllegato.replace('C:\\fakepath\\', ' ');
			var idAllegatoTemporaneoValue = '';
			
			var formData = new FormData();
			formData.append('<portlet:namespace />' + 'attachmentFile', $('#<portlet:namespace />allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}')[0].files[0]);
			formData.append('<portlet:namespace />' + 'idDefinizioneAllegato', ${allegato.definizione.definizioneAllegatoId});
			formData.append('<portlet:namespace />' + 'idIstanzaForm', ${idRichiesta});
			
			if(nomeAllegato){
				
				$.ajax({
		    		url: "${uploadFileUrl}",
		    		type: 'POST',
		    		data: formData,
		    		processData: false,
		    		contentType: false,
		    		success: function(data){	
		    			if(data.status==='ok'){
		    				console.log("Successo in upload del file!");
		    				$("#allegatodocumentale-container-${loop.index}-${allegato.definizione.definizioneAllegatoId}").remove();
		    				$("input[name='allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").val(data.fileName);
		    	        	$("input[name='allegatodocumentale-personale-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").prop('checked', false);
		    	        	
		    				$('#alertUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').addClass('hidden');
		    				$('#successUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').removeClass('hidden');
		    				idAllegatoTemporaneoValue = data.idAllegatoTemporaneo;
		    			}else if(data.status==='error'){
		    	        	$("input[name='allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").val('');
		    	        	$("input[name='allegatodocumentale-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").val('');
		    	        	$("#allegatodocumentale-container-${loop.index}-${allegato.definizione.definizioneAllegatoId}").remove();
		    	    	
		    				$('#alertUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').removeClass('hidden');
		    				$('#successUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').addClass('hidden');

		    				console.log("Errore durante l'upload del file!");
		    			}
		    		}, error: function(xhr){
	    				console.log("Errore durante CHIAMATA l'upload del file!");

		    		}
		    	});
			}
		
    });
			
	</c:forEach>	
		
		//Download istanza da firmare
		$("#form-download-istanza").submit(function(e){
			var $downloadModal = $('#download-modal');
			$('.dismiss-download-pdf').prop('disabled', true);
			$downloadModal.modal('show');
	        
			$.fileDownload($(this).prop('action'), {
		        httpMethod: "POST",
		        data: $(this).serialize(),
		        successCallback: function (url) {
		        	if (isDebugEnabled) {
		        		console.log('successCallback');
		        	}
	                $downloadModal.modal('hide');
	            },
	            failCallback: function (responseHtml, url) {
	            	if (isDebugEnabled) {
	            		console.log('failCallback');
	            	}
	            	$('.modal-body', $downloadModal).html('<div class="alert alert-danger" role="alert"><liferay-ui:message key="errore.download.pdf" /></div>');
	            	$('.dismiss-download-pdf').prop('disabled', false);
	            }
		    });
		    e.preventDefault(); //otherwise a normal form submit would occur
		});
	});
	
</script>