<%@ include file="init.jsp" %>

 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/init.js"></script> 
 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/main.js"></script> 


<portlet:actionURL name="<%=GestioneFormsPortletKeys.SALVA_AGGIUNGI_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:resourceURL id="<%=GestioneFormsPortletKeys.UPLOAD_ALLEGATO_RESOURCE_COMMAND %>" var="uploadFileUrl">
</portlet:resourceURL>

<liferay-ui:error key="<%=GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO %>" message="compilare-tutti-i-campi-obbligatori" />



<div class="page-header">
				<h2><liferay-ui:message key="form"/></h2>
</div>

<aui:form action="${salvaModificaURL}" id="formPrincipale" name="formPrincipale" enctype="multipart/form-data">

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
					<aui:input label="principale" type="checkbox" name="<%=GestioneFormsPortletKeys.PRINCIPALE %>" value="${form.principale}"/>
				</div>
			</div>
			
			<aui:input label="modelloForm" type="hidden" id="modelloForm" name="modelloForm" value="${form.json}"/>
		
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button value="annulla" id="annulla" href="${homeURL}"/>
			<button id="salva" class="btn btn-primary"><liferay-ui:message key="salva"/></button>
			<aui:button type="submit" id="submitFormPrincipale" hidden="true" />
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
	                            	
	                            	<div id="variabiliutilita">
	                            		<aui:input type="hidden" name="dimensioneListaDefinizioneAllegato" />                           	
	                            		<select id="listaAllegatiDaEliminare" name="<portlet:namespace />listaAllegatiDaEliminare" hidden="true" multiple="multiple"></select>
	                            	</div>
	                            	
	                            	
	                            	<div id="alertFormDefinizioneAllegato" class="portlet-msg-alert hidden">
											<liferay-ui:message key="compilare-tutti-i-campi-obbligatori"/>
									</div>
	                            	
	                            	<button id="nuovoAllegato" class="btn btn-light add-attachment"><liferay-ui:message key="nuovo"/></button>
	                            	
	                            	<div id="formAggiungiAllegato" class="form-horizontal hidden attachment-form">
	                            		<input type="hidden" name="attachment-id" id="attachment-id" class="form-control" required="required">
	                            	
		                            	<div class="control-group">
										    <label class="control-label" for="attachment-name">
										    	<liferay-ui:message key="denominazione"/>
										    </label>
										    <div class="controls">
										   		<input type="text" class="form-control" name="attachment-name" required="required" id="attachment-name" >
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
										    	<select id="attachment-filetype" class="form-control" name="attachment-filetype" multiple="multiple" required="required" size="7">
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
 										    		<c:forEach items="${listaTipoDocumento}" var="tipoDocumento"> 
 											    		<option value="${tipoDocumento.codice}">${tipoDocumento.nome}</option> 
 										    		</c:forEach> 
										    	</select>
										   	</div>
									    </div>
									    
									    <div class="control-group">
									  	  	<div class="controls">
												<aui:input type="file" id="attachment-file" name="file" />
											</div>
										</div>
										
										<div id="alertUplaodAllegato" class="portlet-msg-alert hidden">
											<liferay-ui:message key="errore-durante-il-caricamento-dell-allegato"/>
										</div>
									    
									    <div class="control-group">
										    <div class="controls">
										    	<button class="btn btn-secondary save-attachment" type="button">
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
	 
	//On form submit (add/edit)
	
	$(document).ready(function(){
		$('.save-attachment').on('click', function(){
			
			var validazioneForm = validaFormDefinizioneAllegato();
			
			if(validazioneForm){
				var nomeAllegato = $('#<portlet:namespace />attachment-file').val();
		    	

		    	var attachmentIdValue = $('#attachment-id').val();
		    	var attachmentNameValue = $('#attachment-name').val();
		    	var attachmentMandatoryValue = $('#attachment-mandatory').is(':checked');
		    	var attachmentFiletypeValue = $('#attachment-filetype').val();
		    	var attachmentCodetypesValue = $('#attachment-codetype').val();
		    	var attachmentFileNameValue = nomeAllegato.replace('C:\\fakepath\\', ' ');
				
				var $trToAdd = "";
				var formData = new FormData();
				formData.append('<portlet:namespace />' + 'attachmentFile', $('#<portlet:namespace />attachment-file')[0].files[0]);
				
	 			index = aggiungiRigaTabella(attachmentIdValue,attachmentNameValue,attachmentMandatoryValue,attachmentFiletypeValue,attachmentCodetypesValue,attachmentFileNameValue);

			}

	    });

	})
	
	function aggiungiRigaTabella(attachmentIdValue, attachmentNameValue,
				attachmentMandatoryValue, attachmentFiletypeValue, attachmentCodetypesValue,
				attachmentFileNameValue) {
		
			
			
			var attachmentId = '<input type="text" class="nostylereadonly definizioneAllegatoId" id="definizioneAllegatoId'+ index +'" name="<portlet:namespace />definizioneAllegatoId'+ index +'" readonly value="'+ attachmentIdValue +'">';
	    	var attachmentName = '<input type="text" class="nostylereadonly" id="denominazione'+ index +'" name="<portlet:namespace />denominazione'+ index +'" value="'+ attachmentNameValue +'" readonly>';
	    	var attachmentMandatory = '<input type="text" class="nostylereadonly" id="obbligatorio'+ index +'" name="<portlet:namespace />obbligatorio'+ index +'" value="'+ attachmentMandatoryValue +'" onclick="return false;" readonly checked>';
	    	var attachmentFiletype = '<input type="text" class="nostylereadonly" id="tipiFileAmmessi'+ index +'" name="<portlet:namespace />tipiFileAmmessi'+ index +'" value="'+ attachmentFiletypeValue +'" readonly>';
	    	var attachmentCodetypes = '<input type="text" class="nostylereadonly" id="codiciTipologiaDocumento'+ index +'" name="<portlet:namespace />codiciTipologiaDocumento'+ index +'" value="'+ attachmentCodetypesValue +'" readonly>';
	    	var attachmentFileName = '<input type="text" class="nostylereadonly" id="filenameModello'+ index +'" name="<portlet:namespace />filenameModello'+ index +'" value=\'' +  attachmentFileNameValue + '\' size="50"  readonly>';
			var fileInput = '<input type="file" id="fileInput'+ index +'" name="<portlet:namespace />fileInput'+ index +'">';
			
			
	    	var $trToAdd = $('<tr>')
	    	.append($('<td>'+ attachmentId))
	        .append($('<td>' + attachmentName))
	        .append($('<td>' + attachmentMandatory))
	        .append($('<td>' + attachmentFiletype))
	        .append($('<td>'+ attachmentCodetypes))
	        .append($('<td>' + attachmentFileName))
	        .append($('<td>' + fileInput))
	        .append($('<td>')
	        	.append($('<button>')
	        			.addClass('btn btn-default delete-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Elimina')
	        			.attr('id','eliminaButton'+ index)
	        			.append($('<span>')
	    					.addClass('glyphicon glyphicon-remove')
	            			.attr('aria-hidden', 'true')
	            		)
	        	)
	        	.append($('<button>')
	        			.addClass('btn btn-default edit-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Modifica')
	        			.attr('id','modificaAllegato'+ index)
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
	    		
				if($("#<portlet:namespace />attachment-file")){
				  $('#fileInput' + index)[0].files = $("#<portlet:namespace />attachment-file")[0].files;
				}

	    	}
	    	

			$('#alertFormDefinizioneAllegato').addClass('hidden');
	    	resetAttachmentForm();
	    	hideAttachmentForm();
	    	attachmentIndex = -1;
	    	
	    	index = index + 1;
	    	
	    	$('#<portlet:namespace />dimensioneListaDefinizioneAllegato').val(index);
			
			
	    	return index;
		}
	
	
	//Load attachments tab content
    $('.add-attachment').on('click', function(){
    	resetAttachmentForm();
    	showAttachmentForm();
    	attachmentIndex = -1;
    });
    
  //Edit attachment event
    $('.attachment-tbody').on('click', '.edit-attachment', function(){
    	var $this = $(this);
    	
    	var $tr = $this.closest('tr');
    	
    	// Controllo se l'allegato è stato aggiunto in questa istanza
    	if($this.attr('id')){

    		var indiceRiga = parseInt($(this).attr('id').replace(/[^\d]/g, ''), 10);
    		$('#attachment-id').val($('#definizioneAllegatoId' + indiceRiga).val());
    		$('#attachment-name').val($('#denominazione' + indiceRiga).val());
    		
    		if($('#obbligatorio' + indiceRiga).val()=="true"){
        		$('#attachment-mandatory').prop('checked', true);
        	}else{
        		$('#attachment-mandatory').prop('checked', false);
        	}
    		
    		$('#attachment-filetype').val($('#tipiFileAmmessi' + indiceRiga).val());
    		$('#attachment-codetype').val($('#codiciTipologiaDocumento' + indiceRiga).val());
    		$('[name="fileName"]').val($('#filenameModello' + indiceRiga).val());

    	}else{
   		
    		//Populate the fields with the content of the table
        	var $tds = $tr.find('td');
        	
        	$('#attachment-id').val($tds.eq(0).text());
        	$('#attachment-name').val($tds.eq(1).text());
        	if($tds.eq(2).text()=="true"){
        		$('#attachment-mandatory').prop('checked', true);
        	}else{
        		$('#attachment-mandatory').prop('checked', false);
        	}
        	
        	var fileTypes = $tds.eq(3).text();
        	$('#attachment-filetype').val(fileTypes.split(','));
        	var documentTypes = $tds.eq(4).text();
        	$('#attachment-codetype').val(documentTypes.split(','));
        	var fileName = $tds.eq(5).text();
        	$('[name="fileName"]').val(fileName);

    	}

    	attachmentIndex = $('.attachment-tbody tr').index($tr);
    	showAttachmentForm();
    });
  
  
  	
		

		/**
		 * Reset the attachment form.
		 */
		var resetAttachmentForm = function() {
			$('#attachment-name').val('');
		    $('#attachment-mandatory').val('');
		    $('#attachment-filetype').val('');
		    $('#attachment-codetype').val('');

			$('#attachment-id').val('');
			$('#<portlet:namespace />attachment-file').val('');
		};

		//Delete attachment event

		$('.attachment-tbody').on('click','.delete-attachment',function() {
			var $this = $(this);
			$this.parent().parent().remove();
			var definizioneAllegatoId = $this.parent().parent().find(".definizioneAllegatoId").html();
			$('#listaAllegatiDaEliminare').append('<option value='+ definizioneAllegatoId +' selected="selected"></option>');

			var indiceRiga = parseInt($(this).attr('id').replace(/[^\d]/g, ''), 10);

			let i = indiceRiga + 1;
			let nuovoIndex = i - 1;

			while (i < index) {
				$('#definizioneAllegatoId' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].definizioneAllegatoId');
				$('#definizioneAllegatoId' + i).attr('id','definizioneAllegatoId' + nuovoIndex);$('#denominazione' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].denominazione');
				$('#denominazione' + i).attr('id','denominazione' + nuovoIndex);

				$('#obbligatorio' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].obbligatorio');
				$('#obbligatorio' + i).attr('id','obbligatorio' + nuovoIndex);

				$('#tipiFileAmmessi' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].tipiFileAmmessi');
				$('#tipiFileAmmessi' + i).attr('id','tipiFileAmmessi' + nuovoIndex);

				$('#codiciTipologiaDocumento' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].codiciTipologiaDocumento');
				$('#codiciTipologiaDocumento' + i).attr('id','codiciTipologiaDocumento'+ nuovoIndex);

				$('#filenameModello' + i).attr('name','<portlet:namespace />listaDefinizioneAllegato['+ nuovoIndex+ '].filenameModello');
				$('#filenameModello' + i).attr('id','filenameModello' + nuovoIndex);

				$('#modificaAllegato' + i).attr('id','modificaAllegato' + nuovoIndex);
				$('#modificaAllegato' + i).attr('id','modificaAllegato' + nuovoIndex);

				i++;
			}

			index--;

			$('#<portlet:namespace />dimensioneListaDefinizioneAllegato').val(nuovoIndex);
		});

		$('#salva').on('click', function() {
			$('#formAggiungiAllegato').remove();
			$('#<portlet:namespace />submitFormPrincipale').click();
		});

		// Validazione form definizione allegato

		var validaFormDefinizioneAllegato = function() {
			var inputDenominazione = $('#attachment-name').val();

			if (inputDenominazione == "") {
				$('#alertFormDefinizioneAllegato').removeClass('hidden');
				return false;
			}

			return true;
		};
	</script> 