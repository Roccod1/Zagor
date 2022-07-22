var elencoSceltaMinoriRipetibileMensaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoSceltaMinoriRipetibileMensaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
            
    Alpaca.Fields.ElencoSceltaMinoriRipetibileMensa = Alpaca.Fields.ArrayField.extend(
    /**
	 * @lends Alpaca.Fields.elencoSceltaMinoriRipetibileMensa.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ArrayField#getFieldType
		 */
        getFieldType: function() {
            return "elencoSceltaMinoriRipetibileMensa";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ArrayField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
	            "readonly": false,
	            "required": true,
	            "type": "array",
	            "items": {
	                "type": "object",
	                "properties": {
	                	"customMinore": {
	                        "title": "",
	                        "description": "",
	                        "type": "object",
	                        "required": false,
	                        "properties": {
	                        	"labelDatiMinore": {
	    	                        "type": "string",
	    	                        "required": false,
	    	                        "properties": {}
	    	                    },
	                            "minoriFam": {
	                                "required": false,
	                                "properties": {}
	                            },
	                            "nomeMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "cognomeMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "codFiscMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "dataNascitaMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "provComuneRequiredMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            }
	                        }
	                    },
                        "customScuola": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "scuolaPrincipale": {
                                    "required": true,
                                    "properties": {}
                                },
                                "nomeScuola": {
                                    "title": "Nome Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "plessoScuola": {
                                    "title": "Plesso Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "tipologiaScuola": {
                                    "title": "Grado Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "indirizzoScuola": {
                                    "title": "Indirizzo Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "comuneProvinciaScuola": {
                                    "title": "Luogo Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },                        
                        "sceltaDietaScuola": {
                        	"required": true,
                            "enum": [
                                "Etico-Religiosa",
                                "Normale",
                                "Speciale"
                            ],
                            "properties": {}
                        },
                        "allegatiExtra": {
                            "type": "string",
                            "required": false,
                            "properties": {
                            	"isRequired": {
                                    "type": "boolean",
                                    "required": false,
                                    "properties": {}
                                },
                                "nomeCognome": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "codiceFiscale": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "descrizione": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        }             
	                },
	                "required": false
	            },
	            "uniqueItems": false
	        };
            
            Alpaca.merge(this.options, {
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
                            "label": "Aggiungi Minore"
                        }
                    ]
                },
                "actionbar": {
                    "showLabels": true,
                    "actions": [
                        {
                            "action": "add",
                            "label": "Aggiungi Minore"
                        },
                        {
                            "action": "remove",
                            "label": "Rimuovi Minore"
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
                "hideInitValidationError": true,
                "focus": false,
                "lazyLoading": false,
                "collapsible": false,
                "collapsed": false,
                "legendStyle": "button",
                "animate": true,
                "sort": false,
                "items": {
                    "fields": {
                    	"customMinore": {
                            "type": "datiAnagraficiMinoreSelectCustom",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "view": "datiAnagraficiMinoreSelectCustom-view",
                            "fields": {
                            	"labelDatiMinore": {
                                    "type": "label",
                                    "hidden": true,
                                    "fieldClass": "text-center showInPdf",
                                    "label": "Dati Minore:",
                                    "helpers": [],
                                    "validate": false,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "minoriFam": {
                                    "fieldClass": "text-center hideInPdf",
                                    "hideInitValidationError": true,
                                    "dataSource": "",
                                    "type": "select",
                                    "label": "Selezionare minore:",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "noneLabel": "-- Seleziona --",
                                    "hideNone": false,
                                    "events": {},
                                    "fields": {}
                                },
                                "nomeMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Nome:",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "cognomeMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Cognome:",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "codFiscMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Codice Fiscale: ",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "dataNascitaMinore": {
                                    "type": "date",
                                    "label": " Data nascita (dd/mm/yyyy):",
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
                                    "disabled": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "provComuneRequiredMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Luogo di nascita: ",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                }
                            }
                        },
                        "customScuola": {
                            "type": "elencoScuoleSingoloAutocompleteSelect2",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "view": "elencoScuoleSingoloAutocompleteSelect2-view",
                            "fields": {
                                "scuolaPrincipale": {
                                    "fieldClass": "select2ac1 text-center",
                                    "type": "select",
                                    "label": "Scuola:",
                                    "helpers": [],
                                    "hideInitValidationError": true,
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "noneLabel": "-- Seleziona --",
                                    "hideNone": false,
                                    "events": {},
                                    "fields": {}
                                },
                                "nomeScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Scuola: ",
                                    "renderButtons": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "plessoScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Plesso: ",
                                    "renderButtons": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "tipologiaScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Grado: ",
                                    "renderButtons": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "indirizzoScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Indirizzo: ",
                                    "renderButtons": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "comuneProvinciaScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Comune: ",
                                    "renderButtons": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                }
                            }
                        },                                            
                        "sceltaDietaScuola": {
                        	"label": "Dieta: ",
                            "type": "select",
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "removeDefaultNone": false,
                            "hideInitValidationError": true,
                            "useDataSourceAsEnum": false,
                            "renderButtons": true,
                            "multiselect": {
                                "disableIfEmpty": true
                            },
                            "hideNone": false,
                            "noneLabel": "--Seleziona--",
                            "events": {},
                            "helpers": [],
                            "optionLabels": [],
                            "fields": {}
                        },
                        "allegatiExtra": {
                            "type": "object",
                            "hidden": true,
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "renderButtons": true,
                            "fields": {
                            	"isRequired": {
                                    "hidden": true,
                                    "label": "New boolean",
                                    "type": "checkbox",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "rightLabel": "",
                                    "fields": {}
                                },
                                "nomeCognome": {
                                    "type": "hidden",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "fields": {}
                                },
                                "codiceFiscale": {
                                    "type": "hidden",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "fields": {}
                                },
                                "descrizione": {
                                    "type": "hidden",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "fields": {}
                                }
                            }
                        }
                    },
                    "type": "object",
                    "validate": true,
                    "showMessages": true,
                    "collapsible": false,
                    "legendStyle": "button",
                	"events": {
                		"remove": function(event) {
                			this.childrenByPropertyId["sceltaDietaScuola"].setValue('');
	                		this.getContainerEl().change();
                		},
                		"change": function(event) {
                			                			
                			console.log('in change', event && event.target && event.target.selectedOptions ? event.target.selectedOptions[0].text : "no full event");
                    		var campoDieta = this.childrenByPropertyId["sceltaDietaScuola"];
                    		
                			console.log('dieta value', campoDieta.getValue());

                    		var customMinoreField = this.childrenByPropertyId["customMinore"];
                    		var minoriSelectField = customMinoreField.childrenByPropertyId["minoriFam"];
                    		console.log("select minore", minoriSelectField);
                    		
                    		var nomeCognomeValue = minoriSelectField.getControlEl()[0].selectedOptions[0].text;
                    		var codiceFiscaleValue = minoriSelectField.getControlEl()[0].selectedOptions[0].value;
                    		
                    		var allegatiExtra = this.childrenByPropertyId["allegatiExtra"];

                    		var isRequiredField = allegatiExtra.childrenByPropertyId["isRequired"];
                    		var codiceFiscaleField = allegatiExtra.childrenByPropertyId["codiceFiscale"];
                    		var nomeCognomeField = allegatiExtra.childrenByPropertyId["nomeCognome"];
                    		var descrizioneField = allegatiExtra.childrenByPropertyId["descrizione"];
                    		
                    		var checkAllegato = $("div.cmds, div.cmde").find("input");
                    		
                    		if (campoDieta.getValue() === 'Etico-Religiosa' || campoDieta.getValue() === 'Speciale') {
                    			isRequiredField.data = true;
                    			isRequiredField.setValue(true);
                    			
                    			if (campoDieta.getValue() === 'Speciale') {
                    				checkAllegato = $("div.cmds").find("input");
                    			} else {
                    				checkAllegato = $("div.cmde").find("input")
                    			}
                    			
                    		} else {
                    			isRequiredField.data = false;
                    			isRequiredField.setValue(false);
                    		}
                    		
                    		codiceFiscaleField.data = codiceFiscaleValue;
                    		codiceFiscaleField.setValue(codiceFiscaleValue);
                    		
                    		nomeCognomeField.data = nomeCognomeValue;
                    		nomeCognomeField.setValue(nomeCognomeValue);
                    		
                    		/* immagazzino l'id di definizione allegato corrispondente in descrizione dell'allegato extra, recuperandolo dal nome */
                    		descrizioneField.data = checkAllegato[0].name.split("-").pop();
                    		descrizioneField.setValue(checkAllegato[0].name.split("-").pop());
                    		
                    		allegatiExtra.refresh();
                    		
                			console.log('nuoviAllegatiExtra', allegatiExtra);
                			console.log('con valori ', isRequiredField.getValue(), codiceFiscaleField.getValue(), nomeCognomeField.getValue(), descrizioneField.getValue());

                			/* valuta obbligatorietà overall */
								
                              if (checkAllegato.length == 0) {
                             	 campoDieta.options.disabled = true;
                             	 campoDieta.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                             	 campoDieta.refresh();
                             	 campoDieta.getControlEl().val('');

                             } else {
                             
                          	   var isOneRequired = false;
                        	   var isOneSpecialeRequired = false;
                        	   var isOneEticoReligiosaRequired = false;
                            	  
                            	   $("select[name*='sceltaDietaScuola']").each(
                            			  function(index, elem) {
                            				  
                            				  if (elem.value === "Speciale") {
                            					  var isCurrentSpecialeRequired = true;
                            					  isOneSpecialeRequired = isOneSpecialeRequired || isCurrentSpecialeRequired;
                            				  }
                            				  if (elem.value === "Etico-Religiosa") {
                            					  var isCurrentEticoReligiosaRequired = true;
                            					  isOneEticoReligiosaRequired = isOneEticoReligiosaRequired || isCurrentEticoReligiosaRequired;
                            				  }
                            	   });
                            	   
                            	   $("div.cmds").find("input")[0].checked = isOneSpecialeRequired;
                            	   $("div.cmde").find("input")[0].checked = isOneEticoReligiosaRequired;
                            	   
                              }
                		}
                	}
                },
                "rubyrails": false,
                "view": "elencoSceltaMinoriRipetibileMensa-view"
            });
            
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scelta Minori Ripetibile Mensa";
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getDescription
		 */
        getDescription: function() {
            return "Scelta minori da iscrivere a servizio mensa con scelta dieta.";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoSceltaMinoriRipetibileMensa-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	
	    },
		"templates": {
			"container": elencoSceltaMinoriRipetibileMensaContainer,
			"container-object": elencoSceltaMinoriRipetibileMensaContainerObject
		},
		"fields": {}
    });
    Alpaca.registerFieldClass("elencoSceltaMinoriRipetibileMensa", Alpaca.Fields.ElencoSceltaMinoriRipetibileMensa); 
  
    
})(jQuery);