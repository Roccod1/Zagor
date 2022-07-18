<%@ include file="init.jsp" %>

 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/init.js"></script> 
 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/main.js"></script> 



<portlet:actionURL name="<%=GestioneFormsPortletKeys.SALVA_AGGIUNGI_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>



<div class="page-header">
				<h2><liferay-ui:message key="form"/></h2>
</div>

<aui:form action="${salvaModificaURL}" id="formPrincipale" name="formPrincipale">

	<div class="container mb-4 pl-0 pr-0">
	
		<div class="row">
		
		<aui:input id="idform" name="idform" type="hidden" value="${form.formId}"/>
	
			<div class="col-6">
				<div class="form-group">
					<c:choose>
						<c:when test="${form.formId > 0}">
							<aui:input label="codice" name="<%=GestioneFormsPortletKeys.CODICE %>" type="text" value="${form.codice}" readonly="true">
							<aui:validator name="required"/>
							</aui:input>	 
						</c:when>
						<c:otherwise>
							<aui:input label="codice" name="<%=GestioneFormsPortletKeys.CODICE %>" type="text" value="${form.codice}">
							<aui:validator name="required"/>
							</aui:input>
						</c:otherwise>
					</c:choose>
					
					
				</div>
			</div>
			

			<div class="col-6">
				<div class="form-group ">
					<aui:input label="nome" name="<%=GestioneFormsPortletKeys.NOME %>" value="${form.nome}" type="text">
					<aui:validator name="required"/>
					</aui:input>			
				</div>	
			</div>
				
		</div>
		
		<div class ="row">
		
			<div class="col-6">			
				<div class="form-group form-check">	
					<c:choose>
						<c:when test="${form.principale eq true }">
							<aui:input label="principale" type="checkbox" name="<%=GestioneFormsPortletKeys.PRINCIPALE %>"/>					
						</c:when>
						<c:otherwise>
							<aui:input label="principale" type="checkbox" name="<%=GestioneFormsPortletKeys.PRINCIPALE %>"/>
						</c:otherwise>
					</c:choose>									
				</div>
			</div>
			
			<div class="col-6">			
				<div class="form-group form-check">	
					<c:choose>
						<c:when test="${form.multiutente eq true}">
							<aui:input label="multiente" type="checkbox" name="<%=GestioneFormsPortletKeys.MULTIENTE %>" checked="true"/>	
						</c:when>						
						<c:otherwise>
							<aui:input label="multiente" type="checkbox" name="<%=GestioneFormsPortletKeys.MULTIENTE %>" />	
						</c:otherwise>
					</c:choose>						
				</div>
			</div>
			
			<aui:input label="modelloForm" type="hidden" id="modelloForm" name="modelloForm" value="${form.json}"/>
		
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button value="annulla" id="annulla" href="${homeURL}"/>
			<aui:button type="submit" value="salva" id="salva"/>
		</aui:button-row>
	
	
</div>

<div>

				<div>
	                <ul class="nav nav-tabs">
	                    <li><a href="#source" data-toggle="tab" class="nav-item nav-link tab-item tab-item-source">Source</a></li>
	                    <li><a href="#designer" data-toggle="tab" class="nav-item nav-link active tab-item tab-item-designer">Designer</a></li>
	                    <li><a href="#view" data-toggle="tab" class="nav-item nav-link tab-item tab-item-view">View</a></li>
	                    <li><a href="#code" data-toggle="tab" class="nav-item nav-link tab-item tab-item-code">Code</a></li>
	                    <li><a href="#attachments" data-toggle="tab" class="nav-item nav-link tab-item tab-item-attachments">Attachments</a></li>
	                    <li class="hidden"><a href="#loadsave" data-toggle="tab" class="nav-item nav-link tab-item tab-item-loadsave">Load / Save</a></li>
	                </ul>
	            </div>
	            <div class="tab-content">
	                <div class="tab-pane" id="source">
	                    <div class="row">
	                        <div class="col-md-6">
	                            <div>
	                                <ul class="nav nav-tabs">
	                                    <li><a href="#schema" data-toggle="tab" class="nav-item nav-link active tab-source-schema">Schema</a></li>
	                                    <li><a href="#options" data-toggle="tab" class="nav-item nav-link tab-source-options">Options</a></li>
	                                    <li><a href="#source-view" data-toggle="tab" class="nav-item nav-link tab-source-view">View</a></li>
	                                    <li><a href="#data" data-toggle="tab" class="nav-item nav-link tab-source-data">Data</a></li>
	                                </ul>
	                            </div>
	                            <div class="tab-content">
	                                <div class="tab-pane active" id="schema">
	                                </div>
	                                <div class="tab-pane" id="options">
	                                </div>
	                                <div class="tab-pane" id="source-view">
	                                </div>
	                                <div class="tab-pane" id="data">
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-6">
	                            <div>
	                                <ul class="nav nav-tabs">
	                                    <li><a href="#preview" class="nav-item nav-link active" data-toggle="tab">Preview</a></li>
	                                </ul>
	                            </div>
	                            <div class="tab-content">
	                                <div class="tab-pane active" id="preview">
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div id="previewDiv"></div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane active" id="designer">
	                    <div class="row">
	                        <div class="col-md-8">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <div id="designerDiv"></div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <div>
	                                        <ul class="nav nav-tabs">
	                                            <li><a href="#types" class="nav-item nav-link active" data-toggle="tab">Types</a></li>
	                                            <li><a href="#basic" class="nav-item nav-link" data-toggle="tab">Basic</a></li>
	                                            <li><a href="#advanced" class="nav-item nav-link" data-toggle="tab">Advanced</a></li>
	                                            <li><a href="#layouts" class="nav-item nav-link" data-toggle="tab">Layouts</a></li>
	                                        </ul>
	                                    </div>
	                                    <div class="tab-content" id="alpaca-right-menu">
	                                        <div class="tab-pane active" id="types"></div>
	                                        <div class="tab-pane" id="basic"></div>
	                                        <div class="tab-pane" id="advanced"></div>
	                                        <div class="tab-pane" id="layouts"></div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="view">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="viewDiv"></div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="code">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="codeDiv"></div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="loadsave">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <button class="btn btn-custom load-button">Load Form</button>
	                            <button class="btn btn-custom save-button">Save Form</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="attachments">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="attachmentsDiv">
	                            	<div class="table-responsive attachment-table">
	                            		<table class="table table-hover">
	                            			<thead>
	                            				<tr>
	                            					<th>ID</th>
	                            					<th>Denominazione</th>
	                            					<th>Obbligatorio</th>
	                            					<th>Tipi file ammessi</th>
	                            					<th>Tipologia documento</th>
	                            					<th>File</th>
	                            					<th>Azioni</th>
	                            				</tr>
	                            			</thead>
	                            			<tbody class="attachment-tbody">
	                            				<c:forEach items="${form.listaDefinizioneAllegato}" var="allegato">
	                            					<tr>
	                            						<td class="definizioneAllegatoId">${ allegato.definizioneAllegatoId }</td>
	                            						<td>${ allegato.denominazione }</td>
	                            						<td>${ allegato.obbligatorio }</td>
	                            						<td>${ allegato.tipiFileAmmessi }</td>
	                            						<td>${ allegato.codiciTipologiaDocumento }</td>
	                            						<td>${ allegato.filenameModello}</td>
	                            						<td>
	                            							<button class="btn btn-custom btn-inverted delete-attachment" type="button" aria-label="Elimina">
	                            								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
	                            							</button>
	                            							
	                            							<button class="btn btn-custom edit-attachment" type="button" aria-label="Modifica">
	                            								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	                            							</button>
	                            						</td>
	                            					</tr>
												    ${item}
												</c:forEach>
	                            			</tbody>
	                            		</table>
	                            		
	                            	</div>
	                            	
	                            	<aui:input type="hidden" name="dimensioneListaDefinizioneAllegato" />                           	
	                            	<select id="listaAllegatiDaEliminare" name="<portlet:namespace />listaAllegatiDaEliminare" hidden multiple="multiple"></select>
	                            	
	                            	
	                            	<button class="btn btn-custom add-attachment"><liferay-ui:message key="nuovo"/></button>
	                            	
	                            	<div id="formAggiungiAllegato" class="form-horizontal hidden attachment-form">
	                            		<input type="hidden" name="attachment-id" id="attachment-id" class="form-control" required="required">
	                            	
		                            	<div class="control-group">
										    <label class="control-label" for="attachment-name">
										    	<liferay-ui:message key="denominazione"/>
										    </label>
										    <div class="controls">
										   		<input type="text" name="attachment-name" id="attachment-name" class="form-control" required="required">
										   	</div>
									    </div>
									    <div class="control-group">
									    	<div class="controls">
									    		<label class="checkbox" for="attachment-mandatory">
									    			<input type="checkbox" id="attachment-mandatory" name="attachment-mandatory">
									    			<liferay-ui:message key="obbligatorio"/>
									    		</label>
									    	</div>
									    </div>
									    <div class="control-group">
										    <label class="control-label" for="attachment-filetype">
										    	<liferay-ui:message key="file-ammessi"/>
										    </label>
										    <div class="controls">
										    	<select id="attachment-filetype" name="attachment-filetype" multiple="multiple" class="form-control" required="required" size="7">
										    		<c:forEach items="${formatiAllegati}" var="formatoAllegato">
										    			<option value="${formatoAllegato.key}">${formatoAllegato.value}</option>
										    		</c:forEach>
										    	</select>
										   	</div>
									    </div>

									    <div class="control-group">
										    <label class="control-label" for="attachment-codetype">
										    	<liferay-ui:message key="tipologia-documento"/>
										    </label>
										    <div class="controls">
										    	<select id="attachment-codetype" name="attachment-codetype" multiple="multiple" class="form-control">
<%-- 										    		<c:forEach items="${tipoDocumentoList}" var="tipoDocumento"> --%>
<%-- 											    		<option value="${tipoDocumento.codice}">${tipoDocumento.nome}</option> --%>
<%-- 										    		</c:forEach> --%>
														<option>Test</option>
														<option>Test2</option>
										    	</select>
										   	</div>
									    </div>
									    
									    <div class="control-group">
									  		<label class="control-label" for="attachment-file"><liferay-ui:message key="file"/></label>
									  	  	<div class="controls">
												<input type="hidden" class="allegato" name="fileName">
												<input type="file" class="file-loading" id="attachment-file" name="file" class="form-control">
												<div id="kv-error-uploadFileModello" style="display: none;"></div>
										    	<div id="modello-container" class="alert alert-info hidden">
										    		<liferay-ui:message key="file-archiviato"/>
									    		</div>
											</div>
										</div>
									    
									    <div class="control-group">
										    <div class="controls">
										    	<button class="btn btn-custom save-attachment" type="button">
										    		<liferay-ui:message key="salva"/>
										    	</button>
										    </div>
									    </div>
									</div>								
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	</div>
</aui:form>
	
	<div class="modal fade form-builder-modal" role="dialog" style="display: none;">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"><liferay-ui:message key="chiudi"/></span></button>
	                <h4 class="modal-title"></h4>
	            </div>
	            <div class="modal-body">
	            </div>
	            <div class="modal-footer">
	            </div>
	        </div>
	    </div>
	</div>



 <script> 

 	var modelloForm = $("#<portlet:namespace />modelloForm");
 	var attachmentIndex = -1;
 	var index = 0;
 	
 	var isCaricaBozza = false;
	var cfLoggedUser='';
	var logoInpsInnerUrl = '';
	var userToken = '';
	var listaProvinceUrl = '';
	var listaComuniUrl = '';
	var listaYearsUrl = '';
	var listaFiveYearsUrl = '';
	var listaTitoliStudioUrl = '';
	var listaStatiCiviliUrl = '';
	var listaRelazioniParentelaUrl = '';
	var listaStatiEsteriUrl = '';
	var listaUsoBolloUrl = '';
	var listaComuniEsteriUrl = '';
	var listaStradarioUrl = '';	
	var checkIvaUrl = '';
	var listaEventiFiereUrl = '';
	var listAllEventiFiereUrl = '';
	var getOrganizzatoriFieraUrl = '';
	var getAllComuniFiereUrl = '';
	var getAllRegioniFiereUrl = '';
	var getAllNazioniFiereUrl = '';
	var getQualificheUrl = '';
	var getAllProvinceUrl = '';
	var getComuniFiereUrl = '';
	
	var listaScuoleByComuneUrl = '';
	var infoScuolaByIdUrl = '';
	var infoScuolaBacinoByIdUrl = '';
	var numeroMaxScuoleAlternativeUrl = '';
	
	var listaDichiarazioniFormScolasticiUrl = "";
	var listaCriteriScolasticiUrl = "";
	
	var maxAltComune = '';

	var listaNucleoFamigliareUrl = '';
	var componenteNucleoFamigliareUrl = '';
	var elencoMinoriUrl = '';
	var sogliaIseeUrl = "";
	var inpsIseeUrl = '';
	var checkResidenteUrl = '';
	var listaScuoleBRgByComuneUrl = '';
	var listaScuoleFBcByComuneUrl = '';
	var listaScuolePegComuneUrl = '';
	var opPeg = true;
	
	/* Custom Fields JSON vars */
	var statiEsteriJsonCF = [];
	var provinceJsonCF = [];
	var statiCiviliJsonCF = [];
	var relazioniParentelaJsonCF = [];
	
	//NOMINATIM OPENSTREETMAP
	var getAddressByCoordsUrl = 'https://nominatim.openstreetmap.org/reverse.php?format=json&zoom=16';
	var getCoordsByAddressUrl = 'https://nominatim.openstreetmap.org/search.php?format=json&limit=1&bounded=1&q=';
	
	/*Gestisci upload file */
	$("#attachment-file").fileinput({
		language: "it",
		showPreview: false,
		uploadAsync: true,
		required: true,
		elErrorContainer: '#kv-error-uploadFileModello',
		uploadUrl: "${uploadFileUrl}"
    }).on('fileuploaded', function(event, data, previewId, index) {
    	var response = data.response;
    	$("input[name='fileName']").val(response.fileName);
	}).on('fileclear', function(event) {
		
    	/*Resetta il valore di fileName */
    	$("input[name='fileName']").val('');
    	$("#modello-container").addClass('hidden');
	});
 	
    
     
	//On form submit (add/edit)
	$('.save-attachment').on('click', function(event){
    	event.preventDefault();
    	
    	//Validate the data
    	var attachmentId = '<input type="text" class="nostylereadonly definizioneAllegatoId" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].definizioneAllegatoId" readonly value='+ $('#attachment-id').val() +'>';
    	var attachmentName = '<input type="text" class="nostylereadonly" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].denominazione" value='+ $('#attachment-name').val() +' readonly>';
    	var attachmentMandatory = '<input type="text" class="nostylereadonly" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].obbligatorio" value='+ $('#attachment-mandatory').is(':checked') +' onclick="return false;" readonly checked>';
    	var attachmentFiletype = '<input type="text" class="nostylereadonly" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].tipiFileAmmessi" value='+ $('#attachment-filetype').val() +' readonly>';
    	var attachmentCodetypes = '<input type="text" class="nostylereadonly" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].codiciTipologiaDocumento" value='+ $('#attachment-codetype').val() +' readonly>';
    	var attachmentFileName = '<input type="text" class="nostylereadonly" name="<portlet:namespace />listaDefinizioneAllegato['+ index +'].filenameModello" value='+ $('[name="fileName"]').val() +' readonly>';
    	
    	console.log('attachmentIndex', attachmentIndex);
    	console.log('attachmentCodetypes', attachmentCodetypes);
    	
    	var $trToAdd = $('<tr>')
	    	.append($('<td>'+ attachmentId)
// 	    		.text(attachmentId)
	    	)
	        .append($('<td>' + attachmentName)
// 	        	.text(attachmentName)
	        )
	        .append($('<td>' + attachmentMandatory)
// 	        	.text(attachmentMandatory)
	        )
	        .append($('<td>' + attachmentFiletype)
// 	        	.text(attachmentFiletype)
	        )
	        .append($('<td>'+ attachmentCodetypes)
// 	        		.text(attachmentCodetypes)
	        )
	        .append($('<td>' + attachmentFileName)
	        	//.data('attachmentFileName', attachmentFileName)
// 	        	.text(attachmentFileName)
	        )
	        .append($('<td>')
	        	.append($('<button>')
	        			.addClass('btn btn-default delete-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Elimina')
	        			.append($('<span>')
	    					.addClass('glyphicon glyphicon-remove')
	            			.attr('aria-hidden', 'true')
	            		)
	        	)
	        	.append($('<button>')
	        			.addClass('btn btn-default edit-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Modifica')
	        			.append($('<span>')
	    					.addClass('glyphicon glyphicon-edit')
	            			.attr('aria-hidden', 'true')
	            		)
	        	)
	        );
    	
    	if(attachmentIndex != -1){
    		$tr = $('.attachment-tbody tr').eq(attachmentIndex);
    		var nextAll = $tr.nextAll();
    		$tr.remove();
    		
    		var trs = $('.attachment-tbody tr');
    		
    		//Check if there are attachments after the edited one
        	if(nextAll.length > 0){
        		var $trs = $('.attachment-tbody tr');
        		$tr = $trs.eq(attachmentIndex);
        		$tr.before($trToAdd);
        	} else {
        		$('.attachment-tbody')
    				.append($trToAdd);
        	}
    	} else {
    		$('.attachment-tbody')
    			.append($trToAdd);
    	}
    	
    	resetAttachmentForm();
    	hideAttachmentForm();
    	attachmentIndex = -1;
    	
    	index = index + 1;
    	
    	$('#<portlet:namespace />dimensioneListaDefinizioneAllegato').val(index);
    });
	
	
	
	//Delete attachment event
    
	$('.attachment-tbody').on('click', '.delete-attachment', function(){
    	var $this = $(this);
    	var definizioneAllegatoId = $this.parent().parent().find(".definizioneAllegatoId").html();
    	
    	$('#listaAllegatiDaEliminare').append('<option value='+ definizioneAllegatoId +' selected="selected"></option>');

    	$this.parent().parent().remove();
    });
	
	$("#<portlet:namespace />salva").on("click",function(e){
		e.preventDefault();
	    $("#formAggiungiAllegato").remove();    
	    $("#<portlet:namespace />formPrincipale").submit(); 
	});
 </script> 