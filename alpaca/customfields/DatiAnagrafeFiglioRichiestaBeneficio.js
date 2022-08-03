var datiAnagrafeFiglioRichiestaBeneficioContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagrafeFiglioRichiestaBeneficioContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagrafeFiglioField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiAnagrafeFiglioField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiAnagrafeFiglioRichiestaBeneficio";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function() {
            this.base();

            this.schema = {
            	"items": {
    	            "title": "",
    	            "type": "object",
    	            "properties": {
    	                "new1496934225870": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
    	                },
    	                "new1496744267692": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
    	                },
    	                "new1496744269610": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
    	                },
    					"new1505144578146": {
    						"type": "string",
    						"required": true,
    						"properties": {}
    					},
    					"provenienza": {
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
    	                "new1496744302234": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
    	                }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
	                    "new1496934225870": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "N.",
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
	                        "fields": {},
	                        "renderButtons": true,
	                        "attributes": {}
	                    },
	                    "new1496744267692": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Cognome",
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "fields": {}
	                    },
	                    "new1496744269610": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Nome",
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "fields": {}
	                    },
	                    "new1505144578146": {
	                        "type": "label",
	                        "label": "Luogo di nascita",
	                        "helpers": [],
	                        "validate": false,
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
		                "provenienza": {
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
	                    "new1496744302234": {
	                        "type": "date",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Data nascita",
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
	                        "dateFormat": "DD/MM/YYYY",
	                        "renderButtons": true,
	                        "attributes": {},
	                        "picker": {
	                            "useCurrent": false,
	                            "format": "DD/MM/YYYY",
	                            "locale": "it",
	                            "dayViewHeaderFormat": "MMMM YYYY",
	                            "extraFormats": []
	                        },
	                        "manualEntry": false,
	                        "fields": {}
	                    }
	                }   
            	},
            	"view": "datianagrafefigliorichiestabeneficio-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Anagrafe Figlio (Richiesta Beneficio)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Anagrafe Figlio (Richiesta Beneficio)";
        }
    });

    
    
    Alpaca.registerFieldClass("datiAnagrafeFiglioRichiestaBeneficio", Alpaca.Fields.DatiAnagrafeFiglioField); 
    
    Alpaca.registerView({
        "id": "datianagrafefigliorichiestabeneficio-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": datiAnagrafeFiglioRichiestaBeneficioContainer,
        	"container-object": datiAnagrafeFiglioRichiestaBeneficioContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Figlio"
    }, "datianagrafefigliorichiestabeneficio-view");
    
})(jQuery);