<%@ include file="./init.jsp"%>


<portlet:resourceURL id="<%=PresentatoreFormsPortletKeys.UPLOAD_ALLEGATO_RESOURCE_COMMAND %>" var="uploadFileUrl">
	<portlet:param name="idServizio" value="${idServizio}" />
</portlet:resourceURL>

<portlet:actionURL var="salvaUrl" name="<%=PresentatoreFormsPortletKeys.SALVA_INVIA_RICHIESTA_ACTION_COMMAND %>">
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


<c:if test="${not empty errori}">
	<div class="alert alert-danger">
		${errori}
	</div>
</c:if>

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
			                            <div class="holder"><c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>
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
											<portlet:resourceURL id="/downloadIstanza" var="downloadIstanzaUrl"/>
											<a href="${downloadIstanzaUrl }" >Download</a>
<%-- 											<button class="btn btn-primary" type="button" href="${downloadIstanzaUrl}"> --%>
<!-- 												<i class="fa fa-download marginright10" aria-hidden="true"></i> -->
<%-- 												<liferay-ui:message key="download.istanza.dafirmare" /> --%>
<!-- 											</button> -->
										</div>
										
										<label class="control-label" for="uploadFileFirmato"><liferay-ui:message key="upload.documento.firmato" /> (<liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione" arguments="${uploadFileMaxSizeLabel}"/>): </label>
										<div class="controls">
											<input type="hidden" class="allegato" name="${nomeFileFirmato}"	value="${empty pdfFirmato ? '' : pdfFirmato.fileName }">
											
											<div id="div-uploadFileFirmato" <c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>>					
												<div class="control-group">
											  	  	<div class="" style="margin-left:0px; display: inline-block">
														<aui:input type="file" id="uploadFileFirmato" name="uploadFileFirmato" required="true">
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
						       					<div class="mt-3"><liferay-ui:message key="pdf.firmato.no.invio.istanza.download.descrizione"/></div>
						     				</c:when>
						     				<c:when test="${not empty allegati}">
								     			<div class="mt-3"><liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.descrizione"/></div>
								     			<div class="mt-3"><liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione.toppagina" arguments="${uploadFileMaxSizeLabel}"/></div>
						     				</c:when>
						     				<c:otherwise>
								     			<div class="mt-3"><liferay-ui:message key="pdf.firmato.istanza.download.descrizione"/></div>
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
										<div class="control-group mt-3 alpaca-field-object">
											<label class="control-label" for="allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}">${allegato.definizione.denominazione}<c:if test="${allegato.definizione.obbligatorio}">*</c:if> (<liferay-ui:message key="pdf.firmato.istanza.download.con.allegati.alert.dimensione" arguments="${uploadFileMaxSizeLabel}"/>):</label>
											
											<c:if test="${not empty allegato.definizione.filenameModello }">
												<span class="help-block"> 
													<spring:message	code="documento.precompilato.info" />
												</span>
												<div class="mt-3 mb-3">
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
														
														<%-- +++ MODIFICATO --%>
														<div id="div-allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}" <c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>>					
												
															<div class="control-group">
														  	  	<div class="span8" style="margin-left:0px; display: inline-block">
																	<aui:input type="file" id="allegato-${allegato.definizione.definizioneAllegatoId}" name="allegato-${allegato.definizione.definizioneAllegatoId}" required="${allegato.definizione.obbligatorio}">
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
				
				<div class="mt-3"></div>
				
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
			
			// QUI CONTROLLO ALLEGATI: se manca un allegato segnalo all'utente
			var confirmSubmit = true;
			$("input[type='file']").each(function(){
				if (!this.value && this.id) {
					alert("ATTENZIONE: alcuni allegati non risultano caricati correttamente. Si prega di correggere e riprovare. ")
					confirmSubmit = false;
						
				}
			});
			if (confirmSubmit) {
				$('#salva-invia-modal').modal('show');
			}
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
	
		
		<%-- GESTIONE UPLOAD FILE FIRMATO --%>	
	$('.save-attachment-uploadFileFirmato').on('click', function(){	
			var nomeAllegato = $('#<portlet:namespace />uploadFileFirmato').val();
	    	var attachmentFileNameValue = nomeAllegato.replace('C:\\fakepath\\', ' ');
			var idAllegatoTemporaneoValue = '';
			
			var formData = new FormData();
			formData.append('<portlet:namespace />' + 'attachmentFile', $('#<portlet:namespace />uploadFileFirmato')[0].files[0]);
			formData.append('<portlet:namespace />' + 'idDefinizioneAllegato', 0);
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
		    				$("input[name='${nomeFileFirmato}']").val(data.fileName);
		    	        	
		    				$('#alertUplaodAllegato-uploadFileFirmato').addClass('hidden');
		    				$('#successUplaodAllegato-uploadFileFirmato').removeClass('hidden');
	 	    				idAllegatoTemporaneoValue = data.idAllegatoTemporaneo;
	 	    				
		    			}else if(data.status==='error'){
		    	        	$("input[name='${nomeFileFirmato}']").val('');
		    	    
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
		    				$("input[name='allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").val(data.fileName);
		    	        	
		    				$('#alertUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').addClass('hidden');
		    				$('#successUplaodAllegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}').removeClass('hidden');
		    				idAllegatoTemporaneoValue = data.idAllegatoTemporaneo;
		    			}else if(data.status==='error'){
		    	        	$("input[name='allegato-${loop.index}-${allegato.definizione.definizioneAllegatoId}']").val('');
		    	    	
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
		
		
	});
	
</script>