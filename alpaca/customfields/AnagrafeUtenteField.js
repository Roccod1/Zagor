var anagrafeUtenteContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="650"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeUtenteContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.AnagrafeUtenteField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.AnagrafeUtenteField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeutente";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
                "type":"object",
                "properties": {
                    "nome": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "cognome": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "sesso": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "cittadinanza": {
                        "type": "object",
                        "properties": {
                            "stati": {
                                "default": "100",
                                "required": true,
                                "properties": {}
                            }
                        }
                    },
                    "labelprovenienzanascita": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
					"provenienzanascita": {
						"title": "",
                        "description": "",
                        "type": "object",
                        "required": false,
                        "properties": {
                            "nazioni": {
                                "type": "object",
                                "properties": {
                                    "stati": {
                                        "default": "100",
                                        "required": false,
                                        "properties": {}
                                    }
                                }
                            },
                            "provinciaComune": {
                                "type": "object",
                                "properties": {
                                    "provincia": {
                                        "required": false,
                                        "default": "",
                                        "properties": {}
                                    },
                                    "comune": {
                                        "required": false,
                                        "enum": [],
                                        "properties": {}
                                    }
                                }
                            },
                            "comuneEstero": {
                                "required": false,
                                "properties": {}
                            }
                        }
                    },
                    "datanascita": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "residenza": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "via": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "ncivico": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
            		"scala": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "piano": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "interno": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "telefono": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "pattern": "^\\d+$",
                        "properties": {}
                    },
                    "email": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "identificativo": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "identificativoFamiglia": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "nome": {
                        "type": "text",
                        "label": "Nome",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "codicefiscale": {
                        "type": "text",
                        "label": "Codice Fiscale",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "sesso": {
                        "type": "text",
                        "label": "Sesso",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "cittadinanza": {
                        "type": "statiSelectCittadinanza",
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "view": "statiSelectCittadinanza-view",
                        "fields": {
                            "stati": {
                                "label": "Cittadinanza:",
                                "type": "select",
                                "validate": true,
                                "disabled": false,
                                "showMessages": false,
                                "dataSource": "",
                                "removeDefaultNone": true,
                                "noneLabel": "Nessuno",
                                "hideNone": true,
                                "useDataSourceAsEnum": false,
                                "helpers": [],
                                "renderButtons": true,
                                "multiselect": {
                                    "disableIfEmpty": true
                                },
                                "fields": {}
                            }
                        }
                    },
                    "labelprovenienzanascita": {
                        "type": "label",
                        "label": "Luogo di nascita",
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
                    "provenienzanascita": {
                        "type": "nazioneProvinciaComune",
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "focus": false,
                        "helpersPosition": "below",
                        "view": "nazioneprovinciacomune-view",
                        "fields": {
                            "nazioni": {
                                "type": "statiSelect",
                                "label": "",
                                "helpers": [],
                                "validate": true,
                                "disabled": false,
                                "showMessages": true,
                                "collapsible": false,
                                "legendStyle": "button",
                                "view": "statiSelect-view",
                                "fields": {
                                    "stati": {
                                        "type": "select",
                                        "validate": false,
                                        "disabled": false,
                                        "showMessages": false,
                                        "dataSource": "",
                                        "label": "Stato: ",
                                        "removeDefaultNone": true,
                                        "noneLabel": "Nessuno",
                                        "hideNone": true,
                                        "useDataSourceAsEnum": false,
                                        "helpers": [],
                                        "renderButtons": true,
                                        "multiselect": {
                                            "disableIfEmpty": true
                                        },
                                        "events": {},
                                        "fieldClass": "select2ac1",
                                        "fields": {}
                                    }
                                }
                            },
                            "provinciaComune": {
                                "type": "provinciaComune",
                                "label": "",
                                "helpers": [],
                                "validate": true,
                                "disabled": false,
                                "showMessages": true,
                                "collapsible": false,
                                "legendStyle": "button",
                                "view": "provinciacomune-view",
                                "fields": {
                                    "provincia": {
                                        "type": "provincia",
                                        "validate": false,
                                        "showMessages": false,
                                        "disabled": false,
                                        "hidden": false,
                                        "label": "Provincia",
                                        "helpers": [],
                                        "hideInitValidationError": true,
                                        "focus": false,
                                        "optionLabels": [],
                                        "removeDefaultNone": false,
                                        "noneLabel": "Nessuna",
                                        "hideNone": false,
                                        "useDataSourceAsEnum": false,
                                        "dataSource": "",
                                        "multiple": false,
                                        "emptySelectFirst": true,
                                        "multiselect": {
                                            "disableIfEmpty": true
                                        },
                                        "sort": false,
                                        "renderButtons": true,
                                        "events": {},
                                        "fields": {}
                                    },
                                    "comune": {
                                        "type": "comune",
                                        "validate": false,
                                        "showMessages": false,
                                        "disabled": false,
                                        "hidden": false,
                                        "label": "Comune",
                                        "helpers": [],
                                        "hideInitValidationError": true,
                                        "focus": false,
                                        "optionLabels": [],
                                        "removeDefaultNone": false,
                                        "noneLabel": "Nessuno",
                                        "hideNone": false,
                                        "useDataSourceAsEnum": true,
                                        "multiple": false,
                                        "emptySelectFirst": true,
                                        "multiselect": {
                                            "disableIfEmpty": true
                                        },
                                        "sort": false,
                                        "renderButtons": true,
                                        "events": {},
                                        "fields": {}
                                    }
                                }
                            },
                            "comuneEstero": {
                                "label": "Comune Estero: ",
                                "type": "select",
                                "helpers": [],
                                "fieldClass": "select2ac1",
                                "validate": false,
                                "disabled": false,
                                "showMessages": true,
                                "renderButtons": true,
                                "removeDefaultNone": true,
                                "noneLabel": "Nessuno",
                                "hideNone": true,
                                "data": {},
                                "attributes": {},
                                "allowOptionalEmpty": true,
                                "autocomplete": false,
                                "disallowEmptySpaces": false,
                                "disallowOnlyEmptySpaces": false,
                                "events": {},
                                "useDataSourceAsEnum": true,
                                "multiselect": {
                                    "disableIfEmpty": true
                                },
                                "fields": {}
                            }
                        }
                    },					
                    "datanascita": {
                        "type": "date",
                        "label": "Nato il",
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
                        "showMessages": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "residenza": {                        
                        "type": "text",
                        "label": "Residente a",
                        "focus": false,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "via": {
                        "type": "text",
                        "label": "in Via",
                        "focus": false,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "ncivico": {
                        "type": "text",
                        "label": "N. civico",
                        "focus": false,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "scala": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Scala",
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
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "piano": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Piano",
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
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "interno": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Interno",
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
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },                    
                    "telefono": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Telefono",
                        "helpers": [
                            "Questo valore deve essere numerico"
                        ],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "typeahead": {},
                        "allowOptionalEmpty": true,
                        "data": {},
                        "autocomplete": "false",
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "sort": false,
                        "fields": {}
                    },
                    "email": {
                        "type": "text",
                        "label": "E-mail/ E-mail PEC",
                        "focus": false,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "identificativo": {
                        "label": "Identificativo",
                        "type": "hidden",
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
                    },
                    "identificativoFamiglia": {
                        "label": "Identificativo",
                        "type": "hidden",
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
                },
                "view": "anagrafeutente-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe utente";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe utente";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeutente-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeUtenteContainer,
    		"container-object": anagrafeUtenteContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeutente", Alpaca.Fields.AnagrafeUtenteField);
    

})(jQuery);