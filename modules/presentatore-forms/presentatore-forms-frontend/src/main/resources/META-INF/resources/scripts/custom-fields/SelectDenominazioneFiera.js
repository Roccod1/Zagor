var myViewContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var myViewContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		    <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
		    <div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
		    <div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.SelectDenominazione = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.SelectDenominazione.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "selectDenominazione";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
				"dependencies": {
					"nuovoEventoTxt" : "selectEvento",
				 },
				"type": "object",
				"properties": {
					"selectEvento": {
						"type": "string",
						"required": true,
						"properties": {}
					},
					/*"nuovoEvento": {
						"type": "string",
						"required": false,
						"properties": {}
					},*/
					"nuovoEventoTxt": {
						"type": "string",
						"required": true,
						"properties": {}
					}					
				}
			};
			
			Alpaca.merge(this.options, {
				"validate": false,
				"showMessages": false,
		    	"label": "",
		        "fields": {
					"selectEvento":{						
						"label": "Selezionare un Evento dall'elenco",
						"fieldClass" : "select2ac1 notSelect2",
						"type": "select",
						"validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": true,
                        "focus": false,
                        "optionLabels": [], 
                        "removeDefaultNone": false,
                        "noneLabel": "-- Seleziona --",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
						"dataSource": function(callback) {

							var eventi = [];

							/*ALTRIMENTI IL BUILDER S'INCAZZA */
							if(listaEventiFiereUrl){						
										
								$.ajax({
									url: listaEventiFiereUrl,
									dataType: 'json',
									timeout: 20000,
									error: function (error) {
										console.log("error", error);
										callback(eventi);
									}, 
									success: function(data){
																			
										for( var i = 0; i < data.length; i++){
											var denominazione = '';
											if(data[i].denominazioneComune){
												denominazione = data[i].denominazione + ' - ' + data[i].denominazioneComune;
											}else{
												denominazione = data[i].denominazione;
											}
											eventi.push({"value": data[i].idEvento, "text": denominazione});
										}
										eventi.push({"value": "0", "text": "Nuovo Evento"});
										callback(eventi);
									},
								});
							}else{
								console.log("NO URL");
								callback(eventi);
							}
						},
						"events":{
							"change": function(){
								
								/*if(this.getValue() === "0"){
									
									if(listAllEventiFiereUrl){	
												
										curJQ.blockUI({ 
				   	                 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF; opacity: 1 !important'>Attendere...</div>",
					   	                 	baseZ:2000,
						   	                 css: { 
					   	                         border: 'none', 
					   	                         fontFamily: "'Titillium Web',sans-serif",
					   	                         opacity: 0.7, 
					   	                         color: '#ae1d3f',
					   	                  	},
					   	                  	overlayCSS: { 
					   	                	  backgroundColor: 'black',
					   	                	  opacity: 0.6,
					   	                	  cursor:'wait'
					   	                	}
					   	               	});	
					   	               			
										var eventi = [];
										var nuovoEvento = this.parent.childrenByPropertyId["nuovoEvento"];
										
										$.ajax({
											url: listAllEventiFiereUrl,
											dataType: 'json',
											timeout: 20000,
											error: function (error) {
												console.log("error", error);
												nuovoEvento.options.dataSource = eventi;
												nuovoEvento.refresh();
												curJQ.unblockUI();
											}, 
											success: function(data){
																					
												for(var i = 0; i < data.length; i++){
													var denominazione = '';
													if(data[i].luogo){
														denominazione = data[i].denominazione + ' - ' + data[i].luogo;
													}else{
														denominazione = data[i].denominazione;
													}
													eventi.push({"value": data[i].idEvento, "text": denominazione});
												}
												nuovoEvento.options.dataSource = eventi;
												nuovoEvento.refresh();
												curJQ.unblockUI();
											},
										});
									}
									
								}else{}*/								
								/* popolo step successivi */
								if(this.getValue() && $('select[name='+ this.name +']').find('option:selected')[0].label){
									$('input[name=schedaRilevazionePenultimo_nomeManifestazione]').val($('select[name='+ this.name +']').find('option:selected')[0].label);
									$('input[name=schedaRilevazioneUltimo_nomeManifestazione]').val($('select[name='+ this.name +']').find('option:selected')[0].label);
								}
							},
							"ready": function(){
								
								var nuovoEventoTxt = this.parent.childrenByPropertyId['nuovoEventoTxt'];
								
								/* tolgo la possibilità di cambiare step dal wizard, altrimenti
									lo skip dei passaggi non necessari è inutile */
								$(".alpaca-wizard-nav").css("pointer-events", "none");
								
								/* se è bozza, altrimenti non scatta la select */
								if(isCaricaBozza && this.getValue() === "0"){
									
									var txt = nuovoEventoTxt.getValue();
									
									this.getFieldEl().change();
									nuovoEventoTxt.setValue(txt);
									nuovoEventoTxt.getFieldEl().change();
								} else if(isCaricaBozza){
									this.getFieldEl().change();
								}
								
								/* BIND JQUERY PER GESTIRE LA LOGICA SUL SALTO DEGLI STEP NON OBBLIGATORI*/
								var isSkipped1 = false;
								var skipBack1 = true;
								var jmpSteps = false;
								
								if(isCaricaBozza){
									if($('input[name=visualizzaPenultimo]:checked').val() != 1){
										$('input[name=visualizzaPenultimo]:checked').prop("checked", false);
									} 
																	
								}
								/*
								var isSkipped2 = false;
								var skipBack2 = true;
								*/
		
								/* SKIP NEXT */
								
								$('input[name=visualizzaPenultimo]').on("click", function(){
									$(".calcolaButton").click();
									if(this.value == 2){
										isCaricaBozza = false;
										isSkipped1  = false;
										jmpSteps = true;
									}else{
										isSkipped1  = true;
										jmpSteps = false;
									}
								});
								
							/*	$('input[name=visualizzaUltimo]').on("click", function(){
									if(this.value == 3 || this.value == 2){
										 isCaricaBozza = false;
										isSkipped2  = false;
									}else{
										isSkipped2  = true;
									}
								});
							*/
							
								$('button[data-alpaca-wizard-button-key="next"]').on("click", function(){
									
									if (jmpSteps && !isSkipped1 && !isCaricaBozza && $('.active.visited')[0].innerHTML.toLowerCase().search("scheda rilevazione penultimo") !== -1) {
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										isSkipped1 = true;
										skipBack1 = false;
									}
								});
							
								/*	
								$('button[data-alpaca-wizard-button-key="next"]').on("click", function(){
									if($('.active.visited')[0].innerHTML.toLowerCase().search("dichiarante e richiesta") !== -1) { // altrimenti se torno allo step 2, andando avanti fa 4 click 
										$('input[name=visualizzaPenultimo]:checked').prop('checked', false);
										isSkipped2 = true;
									}
												
									if ($('input[name=visualizzaUltimo]:checked') && ($('input[name=visualizzaUltimo]:checked').val() == 3 || $('input[name=visualizzaUltimo]:checked').val() == 2) && !isSkipped2  && !isCaricaBozza) {
										this.click();
										this.click();
										this.click();	
										isSkipped2 = true;
										skipBack2 = false;
										$(".calcolaButton").click();
									}
								});
								*/
								/* SKIP BACK */
								$('button[data-alpaca-wizard-button-key="previous"]').on("click", function(){	
									
									/* non è la soluzione migliore utilizzare lo step che potrebbe cambiare nel tempo,
										ma se l'utente utilizza il wizard per tornare indietro l'evento viene triggerato. 
										Dunque:
										- devo tornare indietro di 8 step se è selezionata il secondo radio in visualizza penultimo;
										- se sono entro i primi 3 questo evento non deve triggerarsi;
									*/
										
										/*prima cambia lo step, quindi il current step non è 11 ma 10 */					
									if (jmpSteps && !skipBack1 && $('.active.visited')[0].innerHTML.toLowerCase().search("aspetti economici ultimo") !== -1) {
										
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										this.click();
										skipBack1 = true;
										isSkipped1 = false;
										
										$('input[name=visualizzaPenultimo]:checked').prop("checked", false);
									}
									
								});
							/*	
								$('button[data-alpaca-wizard-button-key="previous"]').on("click", function(){
									if ($('.active.visited')[0].innerHTML.toLowerCase().search("aspetti economici ultimo evento") !== -1 && !skipBack2) {
										this.click();
										this.click();
										this.click();	
										skipBack2 = true;
										isSkipped2 = false;
									}
								});
							*/
							}
						}
					},
				/*	"nuovoEvento":{
			            "label": "Denominazione Evento",
			            "fieldClass" : "select2ac1 eventoNonCensito",
			            "type": "select",
						"validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": true,
                        "focus": false,
                        "optionLabels": [], 
                        "removeDefaultNone": false,
                        "noneLabel": "-- Seleziona --",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "sort": function(a, b) {
						    if (a.text > b.text) {
						        return 1;
						    } else if (a.text < b.text) {
						        return -1;
						    }
						    return 0;
						},
			            "events":{
							"change": function(){
								var nuovoEventoTxt =  this.parent.childrenByPropertyId['nuovoEventoTxt'];
								if(this.getValue()){
									$('input[name=schedaRilevazionePenultimo_nomeManifestazione]').val(this.getControlEl().find('option:selected')[0].label);
									$('input[name=schedaRilevazioneUltimo_nomeManifestazione]').val(this.getControlEl().find('option:selected')[0].label);
									nuovoEventoTxt.options.hidden = true;
									nuovoEventoTxt.refresh();
								} else {
									nuovoEventoTxt.options.hidden = false;
									nuovoEventoTxt.refresh();
								}
							}
						}
					},*/
					"nuovoEventoTxt": {
						"dependencies": {
							"selectEvento" : "0"
						},
	                    "type": "text",
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "label": "Inserire la denominazione dell'evento:",
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "sort": false,
	                    "helpers": [],
	                    "readonly": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events":{
							"change": function(){
								$('input[name=schedaRilevazionePenultimo_nomeManifestazione]').val(this.getValue());
								$('input[name=schedaRilevazioneUltimo_nomeManifestazione]').val(this.getValue());
							}
						}
                    }
				},
	                "view": "selectDenominazione-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Select Per Denominazione Evento";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Select Per Denominazione Evento + salto degli step non necessari";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "selectDenominazione-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": myViewContainer,
			"container-object": myViewContainerObject
		}
    });
    Alpaca.registerFieldClass("selectDenominazione", Alpaca.Fields.SelectDenominazione); 
  
    
})(jQuery);