var datiResidenteIscrittoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiResidenteIscrittoContainerObject = ' \
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
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.datiResidenteIscritto = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.datiResidenteIscritto.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiResidenteIscritto";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
                    "type": "object",
                    "properties": {
                        "new1498820093204": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "check": {
                            "type": "boolean"
                        },
        				"new1548676046129": {
        					"type": "string",
        					"required": false,
        					"properties": {}
        				},                        
            			"cognome": {
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "nome": {
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "codicefiscale": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "datanascita": {
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "new1505144578146": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaResidenteIscritto": {
    			            "title": "",
    			            "description": "",
    			            "type": "object",
    			            "required": false,
    			            "properties": {
    			                "nazioni": {
    			                    "type": "object",
    			                    "properties": {
    			                        "stati": {
    			                            "default": "Italia",
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
                        "select": {
                            "readonly": false,
                            "required": true,
                            "disallow": [],
                            "enum": [
                                "Non sussistono rapporti di coniugio, parentela, affinità, adozione, tutela o vincoli affettivi con i componenti della famiglia già residente.",
                                "Sussiste il seguente vincolo rispetto al su indicato componente della famiglia già residente"
                            ],
                            "properties": {}
                        },
                        "vincolo": {
                            "readonly": false,
                            "required": true,
            				"dependencies": "select",
                            "properties": {}
                        }
                    },
                    "dependencies": {
            			"cognome": ["check"],
                        "nome": ["check"],
                        "codicefiscale": ["check"],
                        "datanascita": ["check"],
                        "new1505144578146": ["check"],
                        "provenienzaResidenteIscritto": ["check"],
                        "select": ["check"],
                        "new1548676046129": ["check"]
                    }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "new1498820093204": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Residente già iscritto",
                        "helpers": [],
                        "fieldClass": "text-center",
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
                    "check": {
                        "rightLabel": "Nell'abitazione sono già iscritte le seguenti persone (è sufficiente specificare le generalità di un componente della famiglia) "
                    },
    				"new1548676046129": {
    					"type": "label",
    					"validate": false,
    					"showMessages": true,
    					"disabled": false,
    					"hidden": false,
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
        			"cognome": {
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
                    "nome": {
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
                    "codicefiscale": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Codice Fiscale",
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
                    "datanascita": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Data di nascita (dd/mm/yyyy)",
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
                    },
                    "new1505144578146": {
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
                    "provenienzaResidenteIscritto": {
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
                    "select": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Non sussistono rapporti di coniugio, parentela, affinità, adozione, tutela o vincoli affettivi con i componenti della famiglia già residente.",
                            "Sussiste il seguente vincolo rispetto al suindicato componente della famiglia già residente"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "vincolo": {
                        "type": "select",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "sort": false,
                        "dataSource": function(callback) {
                        	if (relazioniParentelaJsonCF.length > 0) {
                        		callback(relazioniParentelaJsonCF);
                        	} else {
                        		$.ajax({
				                	  url: listaRelazioniParentelaUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    timeout: 20000,
				                    error: function () {
				                    	console.log("error");
				                    	callback([]);
		                            },
		                            success: function (data) {
		                            	relazioniParentelaJsonCF = data;
		                            	callback(relazioniParentelaJsonCF);
		                            }
				                  });
                        	}
                        },
                        "fieldClass": "select2ac1",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "removeDefaultNone": false,
                        "noneLabel": "--Seleziona--",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fields": {},
                        "readonly": false,
                        "renderButtons": true,
        				"dependencies": {
                            "select": [
                                "Sussiste il seguente vincolo rispetto al su indicato componente della famiglia già residente"
                            ]
                        }
                    }
                },
                "view": "datiResidenteIscritto-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati residente iscritto";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati residente iscritto";
        }
    });

    Alpaca.registerView({
    	"id": "datiResidenteIscritto-view",
    	"messages": {
            "notOptional": "Campo obbligatorio",
            "invalidValueOfEnum": "Selezionare una delle opzioni",
            "disallowValue": "Non è possibile effettuare questa scelta."
        },
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": datiResidenteIscrittoContainer,
    		"container-object": datiResidenteIscrittoContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiResidenteIscritto", Alpaca.Fields.datiResidenteIscritto);
    

})(jQuery);