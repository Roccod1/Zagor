<%@ include file="./init.jsp" %>

<portlet:actionURL var="salvaBozzaUrl" name="<%=PresentatoreFormsPortletKeys.SALVA_RICHIESTA_BOZZA_ACTION_COMMAND %>">
</portlet:actionURL>

<portlet:renderURL var="scegliAllegatiUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND %>" />
	<portlet:param name="codiceFiscaleComponente" value="${selectComponentiNucleoFamiliare}" />
</portlet:renderURL>

<portlet:renderURL var="scegliModalitaPagamentoUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=PresentatoreFormsPortletKeys.SCEGLI_MODALITA_PAGAMENTO_RENDER_COMMAND %>" />
	<portlet:param name="codiceFiscaleComponente" value="${selectComponentiNucleoFamiliare}" />
</portlet:renderURL>

<portlet:renderURL var="homeURL"></portlet:renderURL>


	
<div class="row-fluid">
	<div class="span12 formpresenter-portlet nuova-istanza">
		<div class="page-header">
			<h2 class="noMargin">${titoloPortletServizio}</h2>
		</div>
		
		<div id="errorDestinazioneUso" class="hidden alert alert-danger">
			<liferay-ui:message key="error.destinazioneUso.required" />
		</div>
		<c:if test="${configurazioneTipoServizioStep2 == 'CERTIFICATO' && not empty destinazioniUso}">
			<div class="row-fluid">
				<div class="span12 text-center" id="destinazioneUsoContainer">
					<aui:select name="destinazioneUso" id="destinazioneUsoSelect" label="label.destinazioneUso">
					    <aui:option label="label.destinazioneUso.select.default" disabled="true" selected="true"/>
						<c:forEach items="${destinazioniUso}" var="destinazioneUso">
							<c:set var="denominazioneDestinazioneUso" value="${destinazioneUso.nome}"/>
							<c:choose>
								<c:when test="${fn:length(denominazioneDestinazioneUso) gt 100}">
									<c:set var="denominazioneDestinazioneUso" value="${fn:substring(denominazioneDestinazioneUso, 0, 100)}..."/>
								</c:when>
							</c:choose>
							<option value="${destinazioneUso.destinazioneUsoId}" title="${destinazioneUso.nome}">${denominazioneDestinazioneUso}</option>
						</c:forEach>
						<aui:validator name="required"/>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid text-center" id="destinazioneUsoMsg">
			</div>
		</c:if>
		<div id="formIscrizione"></div>
	</div>
</div>

<script>

$(document).ready(function() {
	$.blockUI({ 
	    message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '>Caricamento del Modulo...</div>",
	    baseZ:2000,
	     css: { 
	            border: 'none', 
	            fontFamily: "'Titillium Web',sans-serif",
	            opacity: .7, 
	            color: '#ae1d3f',
	        },
	     onBlock: function(){
	    	 mainScript();
	     }
	});
	
});

function mainScript(){
	var configurazioneTipoServizioStep2 = '${configurazioneTipoServizioStep2}';

	var optJson = ${alpacaStructure.options};
	var dataJson = ${alpacaStructure.data};
	var showButtons = true;

	var proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';

	var submitFormUrl = '${salvaBozzaUrl}';

	var step3Url;

	switch(configurazioneTipoServizioStep2) {
	case 'DICHIARAZIONE':
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
			break;
	case 'PAGAMENTO':
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
		step3Url = 'TODO';
			break;
	case 'CERTIFICATO':
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
		enableSubmitFormButton = true;
		step3Url = '${scegliModalitaPagamentoUrl}';
		step3DaPagareUrl = '${scegliModalitaPagamentoUrl}';
		downloadFile = false;
		showServiceEvaluationPage = false;
			break;
	case 'VISURA':
		proseguiButtonTitle = '';
		showButtons = false;
		showServiceEvaluationPage = true;
			break;
	case 'AUTO_DICHIARAZIONE':
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
			break;
	case 'CONCORSO':
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
			break;
	default:
		proseguiButtonTitle = '<liferay-ui:message key="button.salva.bozza.prosegui" />';
	}

	var optForm = {
			"form":{
		   	    "attributes":{
		   	    	"action":submitFormUrl,
		   	        "method":"post"
		   	    },
		   	 	"buttons":{}
		    }
	    };
	    
	if (showButtons) {
		optForm = {
			"form": {
		   	   "attributes":{
		   	    	"action":submitFormUrl,
		   	        "method":"post"
		 	   },
		 	   "toggleSubmitValidState": false,
		   	    "buttons":{
		   	    	"indietro":{
			            "title": '<liferay-ui:message key="label.annulla"/>',
			            "id": "indietroButton",
			            "styles": "btn btn-outline-primary",
			            "click": function() {
			            	window.location.href = '${homeURL}';
			            }
		   	     	},
			   	    "submitButton":{
			   	            "title": proseguiButtonTitle,
			   	            "id": "submitFormButton",
			   	         	"styles": "btn btn-primary",
			   	         	"click": function(e) {

			   	         		var userData = this.getValue();

			   	         		/* Gestione presenza eventuali allegati ripetibili */
			   	         		$("[data-alpaca-field-path$='allegatiExtra']").each(function (index, elem) {
									var allegatoData = $(elem).alpaca("get").data;
									if (allegatoData.isRequired) {
										userData["allegato-checkbox-" + allegatoData.descrizione + "-" + allegatoData.codiceFiscale] = true;
									}
								});		
			   	         		
			   	            	$('.select2ac1').each(function(index) {
			   	            		var selectName = $(this).find("select").attr("name");
			   	            		var value = $(this).find('select').val();
			   	            		var text = $(this).find('select').find(":selected").text();
			   	            		userData[selectName + "Value"] = value;
			   	            		userData[selectName + "Text"] = text;
			   	            	});
			   	            	
			   	            	var dataTosend = {"dataForm": 
			   	            		JSON.stringify({"schema": ${alpacaStructure.schema}, "options": ${alpacaStructure.options}, "data": userData, "view": ${alpacaStructure.view}})
			   	            	};
			   	            	if (isDebugEnabled) {
			   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
			   	            	}
			   	            	/*register alpaca validation*/
								var form = this;
								form.validate(true);
								/* draw the validation state (top control + all children)*/
								form.refreshValidationState(true);
								if (!form.isValid(true)) {
									form.focus();
									e.stopPropagation();
									return false;
								} else {
									/*console.log("validation: OK!");*/
								}

			   	            	var destinazioneUsoId = $('#<portlet:namespace />destinazioneUsoSelect').val();

			   	            	if(destinazioneUsoId>0){
			   	            		
			   	            		$.blockUI({
				   	             		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
				   	                 	baseZ:2000,
				   	                  	css: {
				   	                         border: 'none', 
				   	                         fontFamily: "'Titillium Web',sans-serif",
				   	                         opacity: .7, 
				   	                         color: '#ae1d3f',
				   	                     } 
				   	           		});
			   	            		
			   	            		$('#errorDestinazioneUso').addClass("hidden");
			   	            		
			   	            		$.ajax({
				   	            	    url: submitFormUrl,
				   	            	    data: {"<portlet:namespace />dataForm" : dataTosend.dataForm, "<portlet:namespace />destinazioneUsoId" : $('#<portlet:namespace />destinazioneUsoSelect').val()},
				   	            	    method: 'POST',
				   	            	    success: function(data){
				   	            	        console.log('submitFormUrl: dopo = ' + submitFormUrl);
				   	            	     	$.unblockUI();
				   	            	     	
					   	            	    $.blockUI({ 
					                               message: "<div style='padding:20px 20px; color: #ae1d3f; background-color: #FFF '>La bozza della tua istanza è stata salvata e potrà essere successivamente completata. Potrai in qualsiasi momento recuperarla anche nella pagina 'La mia Scrivania' nella sezione 'Le mie Pratiche'</div><button class='btn btn-primary' type='button' onclick='$.unblockUI()'><b>OK</b></button><br><br>",
					                               baseZ:2000,
					                               css: { 
					                                    border: 'none', 
					                                    fontFamily: "'Titillium Web',sans-serif",
					                                    opacity: .7, 
					                                    color: '#ae1d3f',
					                               } 
					                       });
					   	            	    
							   	          window.location.href = step3Url + '&<portlet:namespace />destinazioneUsoId=' + destinazioneUsoId;
					   	            	  
				   	            	    },
				   	            	    error: function (jqXHR, exception) {
				   	            	    	if (isDebugEnabled) {
				   	            	        	console.log('ERRORE: salvaBozzaSubmit = ' + exception);
				   	            	    	}
				   	            	    }
				   	            	}).always(function() {
				   	            		/*In ogni caso deve essere nascosto il loader*/
				   	            		$.unblockUI();
				   	            	});
			   	            	}else{
			   	            		$('#errorDestinazioneUso').removeClass("hidden");
			   	            	}

			   	         	}
			   	    }
		   	    }
		   	}
	   	};
		
	}
	    
	    
	var opt = $.extend(optJson, optForm);
	var isDebugEnabled = false;
	var enableSubmitFormButton = true;

	    $("#formIscrizione").alpaca({
	   	    "schema": ${alpacaStructure.schema}, 
	   	    "options": opt,
	   	    "data": ${alpacaStructure.data},
	   	    "view": ${alpacaStructure.view},
	        "postRender": function(control) {
	        	$.unblockUI();
	       		if( configurazioneTipoServizioStep2 == 'CERTIFICATO') {
	       			if (isDebugEnabled) {
	       				console.log('configurazioneTipoServizioStep2 = CERTIFICATO, nascondo il salvaBozzaFormButton'); 
	       			}
	       			$("button[data-key='salvaBozzaSubmit']").hide(); 
	       		} 
	       		if( configurazioneTipoServizioStep2 == 'AUTO_DICHIARAZIONE') {
	       			if (isDebugEnabled) {
	       				console.log('configurazioneTipoServizioStep2 = AUTO_DICHIARAZIONE'); 
	       			}
	       			if($("button[data-alpaca-wizard-button-key='submit']").length > 0){ 
	       				$("button[data-alpaca-wizard-button-key='submit']").text(proseguiButtonTitle);
	       			}
	       		} 
	       		
				if( configurazioneTipoServizioStep2 == 'VISURA') {
					if (isDebugEnabled) {
						console.log('configurazioneTipoServizioStep2 = VISURA');
					}
					$.expr[':'].notext = function(el) {
		     	    		return $.trim(el.innerHTML.replace(/<!--.*(?!-->)/, '')).length === 0
		     	    	}

		     	    	$("div.alpaca-control:notext, p.alpaca-control:notext").each(function() {
		    				$("div[data-alpaca-field-name=" + this.attributes.name.nodeValue + "]").css({ 
		    					display : "none",
		    					visibility : "hidden"
		    				});  
		     	    		});   
		     	    } else {
					/*console.log('configurazioneTipoServizioStep2 = NOT VISURA'); */
					if (isDebugEnabled) {
						console.log('control', control);
					}
					$(".select2ac1:not('.notSelect2')").each(function(index) {
						var selectName = $(this).find("select").attr("name");
						console.log("selectName", selectName);
						var s2Value = control.data[selectName + "Value"];
						var s2Text = control.data[selectName + "Text"];
						/*console.log('s2Value', s2Value);*/
						/*console.log('s2Text', s2Text);*/
						/*var select2 = __alpacaSearchField(control.options.fields, selectName);*/
						/*console.log("select2", select2);*/
						var s2DataSource = "";
							 
						  if (s2Value != null && typeof s2Value !== 'undefined' && s2Text != null && typeof s2Text !== 'undefined') {
							var newOption = new Option(s2Text, s2Value, true, true);
							$(this).find("select").append(newOption).trigger('change');
						  } 
					});
	        	} 
				
				
				$("button[data-key='pagaButton']").hide();
				$("button[data-key='scaricaCertificatoButton']").hide();
				
//	 			$.unblockUI();
	        	if (enableSubmitFormButton) {
	        		if (isDebugEnabled) {
	        			console.log("sto riabilitando il bottone")
	        		}
	        		if ( $("button[data-key='submitButton']") != null && $("button[data-key='submitButton']").length > 0 ){
	        			$("button[data-key='submitButton']").removeAttr('disabled');
	        		}
	    	    }

	        	/*register alpaca validation*/           	
	        	var formValidation = function(form, time) {
	            	setTimeout(function() {
	                	var nextBtn = $('button[data-alpaca-wizard-button-key="next"]');
	                    if ( form.isValid(true) &&
	                    		((nextBtn.length > 0 && nextBtn.is(":hidden")) || nextBtn.length <= 0) ) {
	                    	if (isDebugEnabled) {
	                    		console.log("validation: OK!");
	                    	}
	                    	$("button[data-key='submitButton']").removeAttr('disabled');
	                    } else {
	                    	if (isDebugEnabled) {
	                    		console.log("validation: KO!");
	                    	}
	                    	$("button[data-key='submitButton']").attr('disabled', 'disabled');
	                    }
	                }, time);
	            };
	            var form = control.form;
	            if (form) {
	            	formValidation(form, 10);
					$(control.form.form).find('input, select, textarea').on('focus blur', function(e) {
						formValidation(form, 100);
					});
					$(control.form.form).on('click', function(e) {
						formValidation(form, 100);
					});

					if ($('button[data-alpaca-wizard-button-key="next"]').length > 0) {
	    				const targetNode = $('button[data-alpaca-wizard-button-key="next"]')[0];
	    				const config = { attributes: true, attributeFilter: ["style"] };
	    				const mutationCallback = function(mutationsList, observer) {
	    				    for(let mutation of mutationsList) {
	    				        if (mutation.type === 'attributes') {
	    				        	formValidation(form, 100);
	    				        }
	    				    }
	    				};
	    				const observer = new MutationObserver(mutationCallback);
	    				observer.observe(targetNode, config);
	    				/*observer.disconnect();*/
	    			}
	                
	                form.registerSubmitHandler(function(e, form) {
	                    /* validate the entire form (top control + all children)*/
	                    form.validate(true);
	                    /* draw the validation state (top control + all children)*/
	                    form.refreshValidationState(true);
	                    /* now display something*/
	                    if (form.isFormValid()) {
	                        /*var value = form.getValue();*/
	                        /*console.log("validation: OK!");*/
	                    	$("button[data-key='submitButton']").removeAttr('disabled');
	                    } else {
	                        /*console.log("validation: KO!");*/
	                    	$("button[data-key='submitButton']").attr('disabled', 'disabled');
	                    }
	                    e.stopPropagation();
	                    return false;
	                });
	            }
			}
	}); 
	    
	$("#destinazioneUsoSelect").change(function() {
		if($("#destinazioneUsoError").length == 1){
				$("destinazioneUsoError").remove();
		}
		
		if($("#destinazioneUsoSelect").val() != ""){
			destinazioneUsoId = '&destinazioneUsoId=' + $("#destinazioneUsoSelect").val();	
		} else {
			destinazioneUsoId = '&destinazioneUsoId=' + null;
		}
		$("button[data-key='scaricaCertificatoButton']").hide();
		$("button[data-key='pagaButton']").hide();
		$("button[data-key='submitButton']").removeAttr('disabled');
	});

}




</script>