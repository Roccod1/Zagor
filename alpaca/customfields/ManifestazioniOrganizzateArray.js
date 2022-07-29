var arrayFiereContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var arrayFiereContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		    <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.ArrayFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ArrayFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "arrayFiere";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
				"type": "object",
				"properties": {
					 "fiereArray": {
			            "readonly": false,
			            "required": false,
			            "type": "array",
			            "minItems": 1,
			            "items": {
			                "type": "object",
			                "properties": {
			                    "denominazione": {
			                        "title": "Denominazione",
			                        "type": "string",
			                        "required": true
			                    },
			                    "periodoDal": {
			                        "title": "Dal",
			                        "type": "string",
			                        "required": true
			                    },
			                    "periodoAl": {
			                        "title": "Al",
			                        "type": "string",
			                        "required": true
			                    },
			                    "qualifica": {
			                        "title": "Qualifica Posseduta",
			                        "required": true
			                    },
			                    "datiCertificati": {
			                        "title": "Dati Certificati",
			                        "enum": [
			                            "SI",
			                            "NO"
			                        ],
			                        "required": true
			                    }
			                },
			                "required": false
			            },
			            "uniqueItems": false,
			            "properties": {}
			        }
				}
			};
			
			Alpaca.merge(this.options, {
				"validate": false,
				"showMessages": false,
		    	"label": "",
		        "fields": {
					"fiereArray": {
			            
			            "type": "array",
			            "validate": true,
			            "showMessages": true,
			            "disabled": false,
			            "readonly": false,
			            "actionbarStyle": "bottom",
			            "hideToolbarWithChildren": false,
			            "toolbarSticky": true,
			            "hideActionbar": false,
			            "hideToolbar": false,
			            "toolbar": {
			                "actions": [
			                    {
			                        "action": "add",
			                        "enabled": true,
			                        "label": "Aggiungi"
			                    }
			                ]
			            },
			            "actionbar": {
			                "showLabels": true,
			                "actions": [
			                    {
			                        "action": "add",
			                        "enabled": false
			                    },
			                    {
			                        "action": "remove",
			                        "label": "Rimuovi"
			                    },
			                    {
			                        "action": "up",
			                        "label": " "
			                    },
			                    {
			                        "action": "down",
			                        "label": " "
			                    }
			                ]
			            },
			            "hidden": false,
			            "helpers": [],
			            "hideInitValidationError": false,
			            "focus": false,
			            "optionLabels": [],
			            "lazyLoading": false,
			            "collapsible": false,
			            "collapsed": false,
			            "legendStyle": "button",
			            "animate": true,
			            "sort": false,
			            "view": {
			                "messages": {
			                    "notOptional": "Campo obbligatorio",
			                    "notEnoughItems": "Inserire un minimo di {0} elementi",
			                    "invalidValueOfEnum": "Selezionare un'opzione valida"
			                },
			                "templates": {
			                    "container": "<div class='noPadding'><div><b>{{options.label}}</b>{{#container}}{{/container}}</div></div>",
			                    "container-object": "<div> <div class='row'> <div class='col-md-12'> {{#with items.[0]}}{{#item}}{{/item}}{{/with}} </div> </div> <div class='row'> <div class='col-md-2'> {{#with items.[1]}}{{#item}}{{/item}}{{/with}} </div> <div class='col-md-2'> {{#with items.[2]}}{{#item}}{{/item}}{{/with}} </div> <div class='col-md-4'> {{#with items.[3]}}{{#item}}{{/item}}{{/with}} </div> <div class='col-md-3'> {{#with items.[4]}}{{#item}}{{/item}}{{/with}} </div> </div> </div>"
			                },
			                "parent": "bootstrap-edit"
			            },
			            "items": {
			                "fields": {
			                    "denominazione": {
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
													callback(eventi);
												},
											});
										}else{
											console.log("NO URL");
											callback(eventi);
										}
									}
			                    },
			                    "periodoDal": {
			                        "type": "date",
			                        "focus": false,
			                        "optionLabels": [],
			                        "typeahead": {},
			                        "allowOptionalEmpty": true,
			                        "data": {},
			                        "autocomplete": false,
			                        "disallowEmptySpaces": false,
			                        "disallowOnlyEmptySpaces": false,
			                        "dateFormat": "DD/MM/YYYY",
			                        "picker": {
			                            "useCurrent": false,
			                            "format": "DD/MM/YYYY",
			                            "locale": "it",
			                            "dayViewHeaderFormat": "MMMM YYYY",
			                            "extraFormats": []
			                        },
			                        "manualEntry": false,
			                        "disabled": false,
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "renderButtons": true,
			                        "attributes": {},
			                        "fields": {},
				                    "events": {
							            "blur": function(){
							                var anno = this.getValue();
							                anno = Number(anno.substring(6,10));
							                
							                if(anno.toString().length !== 4){
							                    this.setValue();
							                }
							            }
							        },
									"validator": function(callback){
										var dataFine = this.parent.childrenByPropertyId["periodoAl"].getValue();
										var dataInizio = this.getValue();
																		
										var ggInizio = dataInizio.substring(0,2);
										var mmInizio = dataInizio.substring(3,5);
										var aaaaInizio = dataInizio.substring(6,10);
																							
										var ggFine = dataFine.substring(0,2);
										var mmFine = dataFine.substring(3,5);
										var aaaaFine = dataFine.substring(6,10);
										
										
										var newDataInizio = new Date(mmInizio + '/' + ggInizio + '/' + aaaaInizio);
										var newDataFine = new Date(mmFine + '/' + ggFine + '/' + aaaaFine);
										
										if(Date.parse(newDataInizio) > Date.parse(newDataFine)){
											callback({
							                    "status": false,
							                    "message": "La data di fine deve essere successiva o uguale a quella d'inizio"
							                });
										} else {
							                callback({
							                    "status": true
							                });
							            }
									}
			                    },
			                    "periodoAl": {
			                        "type": "date",
			                        "focus": false,
			                        "optionLabels": [],
			                        "typeahead": {},
			                        "allowOptionalEmpty": true,
			                        "data": {},
			                        "autocomplete": false,
			                        "disallowEmptySpaces": false,
			                        "disallowOnlyEmptySpaces": false,
			                        "dateFormat": "DD/MM/YYYY",
			                        "picker": {
			                            "useCurrent": false,
			                            "format": "DD/MM/YYYY",
			                            "locale": "it",
			                            "dayViewHeaderFormat": "MMMM YYYY",
			                            "extraFormats": []
			                        },
			                        "manualEntry": false,
			                        "disabled": false,
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "renderButtons": true,
			                        "attributes": {},
			                        "fields": {},
			                        "events": {
							            "blur": function(){
							                var anno = this.getValue();
							                anno = Number(anno.substring(6,10));
							                
							                if(anno.toString().length !== 4){
							                    this.setValue();
							                }
							            }
							        },	                    
									"validator": function(callback){
										
										var dataInizio = this.parent.childrenByPropertyId["periodoDal"].getValue();
										var dataFine = this.getValue();
																		
										var ggInizio = dataInizio.substring(0,2);
										var mmInizio = dataInizio.substring(3,5);
										var aaaaInizio = dataInizio.substring(6,10);
																	
										var ggFine = dataFine.substring(0,2);
										var mmFine = dataFine.substring(3,5);
										var aaaaFine = dataFine.substring(6,10);
										
										
										var newDataInizio = new Date(mmInizio + '/' + ggInizio + '/' + aaaaInizio);
										var newDataFine = new Date(mmFine + '/' + ggFine + '/' + aaaaFine);
										
										if(Date.parse(newDataFine) < Date.parse(newDataInizio)){
											callback({
							                    "status": false,
							                    "message": "La data di fine deve essere successiva o uguale a quella d'inizio"
							                });
										} else {
							                callback({
							                    "status": true
							                });
							            }
									}
			                    },
			                    "qualifica": {
			                        "fieldClass": "select2ac1 notSelect2",
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
			                        "emptySelectFirst": true,
			                        "useDataSourceAsEnum": false,
			                        "multiple": false,
			                        "multiselect": {
			                            "disableIfEmpty": true
			                        },
			                        "sort": false,
			                        "renderButtons": true,
			                        "fields": {},
			                        "dataSource": function(callback){
				
										var radioEnum = [];
										
										$.ajax({
											url: getQualificheUrl,
											dataType: 'json',
											timeout: 20000,
											error: function (error) {
												console.log("error", error);
												callback([]);
											}, 
											success: function(data){
												
												for(var i= 0; i < data.length; i++){
													radioEnum.push({'text': data[i].descrizione, 'value': data[i].idTipologia});
												}
																				
												callback(radioEnum);
												
											}
										});
									}
			                    },
			                    "datiCertificati": {
			                        "type": "radio",
			                        "hideNone": true,
			                        "validate": true,
			                        "showMessages": true,
			                        "disabled": false,
			                        "hidden": false,
			                        "fieldClass": "",
			                        "helpers": [],
			                        "hideInitValidationError": true,
			                        "focus": false,
			                        "useDataSourceAsEnum": false,
			                        "sort": false,
			                        "readonly": false,
			                        "renderButtons": true,
			                        "vertical": false,
			                        "emptySelectFirst": false,
			                        "noneLabel": "None",
			                        "fields": {}
			                    }
			                },
			                "rubyrails": false,
			                "toolbarStyle": "button"
			            },
			            "toolbarStyle": "button",
			            "rubyrails": false
			        }
				},
	            "view": "arrayFiere-view"
	            	
	        });
	            
	    },
        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Array Manifestazioni Organizzate";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Array Manifestazioni Organizzate";
        }
    });
   
    Alpaca.registerView({
	  	"id": "arrayFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": arrayFiereContainer,
			"container-object": arrayFiereContainerObject
		}
    });
    Alpaca.registerFieldClass("arrayFiere", Alpaca.Fields.ArrayFiere); 
  
    
})(jQuery);
			