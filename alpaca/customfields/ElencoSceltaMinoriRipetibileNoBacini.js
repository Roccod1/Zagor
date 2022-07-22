var elencoSceltaMinoriRipetibileNoBaciniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoSceltaMinoriRipetibileNoBaciniContainerObject = ' \
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
		<div class="row"> \
			<div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoSceltaMinoriRipetibileNoBaciniNoBacini = Alpaca.Fields.ArrayField.extend(
    /**
	 * @lends Alpaca.Fields.elencoSceltaMinoriRipetibileNoBacini.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ArrayField#getFieldType
		 */
        getFieldType: function() {
            return "elencoSceltaMinoriRipetibileNoBacini";
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
                	"dependencies": {
                		"labelStradarioNew": [
	                        "checkDomicilio"
	                    ],
	                    "customStradarioNew": [
	                        "checkDomicilio"
	                    ]
	                    
	                },
	                "properties": {
	                	"customMinore": {
	                        "title": "",
	                        "description": "",
	                        "type": "object",
	                        "required": false,
	                        "properties": {
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
	                    "checkDomicilio": {
	                        "type": "boolean",
	                        "required": false,
	                        "properties": {}
	                    },
	                    "labelStradarioNew": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },            
                        "customStradarioNew": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "searchStradarioNew": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "searchButton": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "selectStradarioNew": {
                                    "required": false,
                                    "properties": {}
                                },
                                "selectCivici": {
                                    "required": false,
                                    "properties": {}
                                },
                                "civico": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                },
                                "esponente": {
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
                        "customScuola": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "dependencies": {
                                "nomeScuola": [
                                    "scuolaPrincipale"
                                ],
                                "plessoScuola": [
                                    "scuolaPrincipale"
                                ],
                                "indirizzoScuola": [
                                    "scuolaPrincipale"
                                ],
                                "tipologiaScuola": [
                                    "scuolaPrincipale"
                                ],
                                "comuneProvinciaScuola": [
                                    "scuolaPrincipale"
                                ],
                                "bacinoAppartenenzaScuola": [
                                    "scuolaPrincipale"
                                ]
                            },
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
                                },
                                "bacinoAppartenenzaScuola": {
                                    "title": "Bacino Appartenenza Scuola",
                                    "type": "string",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
                        "tempoPieno": {
                            "required": true,
                            "enum": [
                                "SI",
                                "NO"
                            ],
                            "properties": {}
                        },
                        "annotazioni": {
                            "type": "string",
                            "required": false,
                            "properties": {}
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
                                "minoriFam": {
                                    "fieldClass": "text-center hideInPdf",
                                    "hideInitValidationError": true,
                                    "dataSource": "",
                                    "type": "select",
                                    "label": "<p style='text-align: center'>Selezionare minore:</p>",
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
                        "checkDomicilio": {
                            "type": "checkbox",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "renderButtons": true,
                            "rightLabel": "Domicilio differente da residenza",
                            "fields": {}
                        },
                        "labelStradarioNew": {
                            "type": "label",
                            "label": "Inserire indirizzo di domicilio:",
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
                        "customStradarioNew": {
                            "type": "elencoStradarioNew",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "helpersPosition": "below",
                            "showButtons": true,
                            "view": "elencostradarionew-view",
                            "fields": {
                                "searchStradarioNew": {
                                    "type": "search",
                                    "fieldClass": "paddingtop5 paddingright20",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "data": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "attributes": {
                                        "results": 5
                                    },
                                    "fields": {}
                                },
                                "searchButton": {
                                    "type": "label",
                                    "label": " <div class='btn btn-primary padding10'><icon class='fa fa-search paddingright10'></icon><b> Cerca</b></div>",
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
                                    "events": {},
                                    "fields": {}
                                },
                                "selectStradarioNew": {
                                    "fieldClass": "select2ac1",
                                    "type": "select",
                                    "label": "Vie:",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "noneLabel": "None",
                                    "hideNone": true,
                                    "events": {},
                                    "fields": {}
                                },
                                "selectCivici": {
                                    "type": "select",
                                    "label": "Civici:",
                                    "helpers": [],
                                    "hideInitValidationError": true,
                                    "emptySelectFirst": true,
                                    "validate": false,
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
                                "civico": {
                                    "type": "text",
                                    "label": "Civico:",
                                    "hidden": true,
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": true,
                                    "data": {},
                                    "attributes": {},
                                    "allowOptionalEmpty": true,
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "fields": {}
                                },
                                "esponente": {
                                    "type": "text",
                                    "label": "Esponente:",
                                    "hidden": true,
                                    "helpers": [],
                                    "validate": true,
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
                                }
                            }
                        },
                        "customScuola": {
                            "type": "elencoScuoleSingoloAutocompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "view": "elencoScuoleSingoloAutocompleteSelect-view",
                            "fields": {
                                "scuolaPrincipale": {
                                    "fieldClass": "select2ac1",
                                    "url": "",
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
                                },
                                "bacinoAppartenenzaScuola": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Bacino di appartenenza: ",
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
                        "tempoPieno": {
                            "type": "radio",
                            "label": "Tempo Pieno:",
                            "helpers": [],
                            "fieldClass": "text-center",
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "hideInitValidationError": false,
                            "renderButtons": true,
                            "useDataSourceAsEnum": true,
                            "emptySelectFirst": false,
                            "vertical": false,
                            "noneLabel": "NO",
                            "removeDefaultNone": true,
                            "hideNone": true,
                            "sort": false,
                            "optionLabels": [
                                "SI",
                                "NO"
                            ],
                            "fields": {}
                        },
                        "annotazioni": {
                            "type": "textarea",
                            "label": "Annotazioni",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "renderButtons": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "rows": 5,
                            "cols": 40,
                            "fields": {}
                        }
                    },
                    "type": "object",
                    "validate": true,
                    "showMessages": true,
                    "collapsible": false,
                    "legendStyle": "button"
                },
                "rubyrails": false,
                "view": "elencoSceltaMinoriRipetibileNoBacini-view"
            });
            
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scelta Minori Ripetibile";
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getDescription
		 */
        getDescription: function() {
            return "Scelta minori da iscrivere a servizio trasporti con scelta della scuola del bacino di appartenenza.";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoSceltaMinoriRipetibileNoBacini-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	
	    },
		"templates": {
			"container": elencoSceltaMinoriRipetibileNoBaciniContainer,
			"container-object": elencoSceltaMinoriRipetibileNoBaciniContainerObject
		},
		"fields": {}
    });
    Alpaca.registerFieldClass("elencoSceltaMinoriRipetibileNoBacini", Alpaca.Fields.ElencoSceltaMinoriRipetibileNoBaciniNoBacini); 
  
    
})(jQuery);