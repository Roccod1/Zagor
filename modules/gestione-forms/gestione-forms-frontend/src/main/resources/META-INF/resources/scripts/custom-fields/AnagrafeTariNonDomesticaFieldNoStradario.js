var anagrafeTariNonDomesticaNoStradarioContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeTariNonDomesticaNoStradarioContainerObject = ' \
	<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-8">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[30]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[31]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[32]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[33]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[34]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[35]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[36]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[37]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[38]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    	</div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeTariNonDomesticaNoStradario = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeTariNonDomesticaNoStradario.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeTariNonDomesticaNoStradario";
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
            	    "required": false,
            	    "properties": {
            	    	"new1499069324893": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "tipocontribuente": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                                "Fisico",
                                "Giuridico"
                            ],
                            "properties": {}
                        },
                        "sesso": {
                            "type": "string",
                            "required": true,
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
                        "datanascita": {
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "codicefiscale": {
            	            "type": "string",
            	            "required": true,
            	            "properties": {}
            	        },
                        //label luogo nascita
                        "new1505144578146": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        //8
                        "provenienzaNascita": {
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
                        "labelResidenza": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "luogoResidenza": {
                            "type": "object",
                            "properties": {
                                "provincia": {
                                    "required": true,
                                    "default": "",
                                    "properties": {}
                                },
                                "comune": {
                                    "required": true,
                                    "enum": [],
                                    "properties": {}
                                }
                            }
                        },
                        "labelIndirizzoResidenza": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "indirizzoResidenza": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
            	        "capnondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "inqualitadinondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-nome-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "pivanondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-sedelegale-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-via-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-n-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-esp-nondomestica": {
            	            "type": "string",
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "societa-sc-nondomestica": {
            	            "type": "string",
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "societa-p-nondomestica": {
            	            "type": "string",
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "societa-int-nondomestica": {
            	            "type": "string",
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "societa-cap-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "societa-pec-nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "telefononondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "faxnondomestica": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "numeroreanondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1499073533377nondomestica": {
            	            "readonly": false,
            	            "dependencies": "tipocontribuentenondomestica",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "estremidocumentonondomestica": {
            	            "readonly": false,
            	            "required": false,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1493714866834nondomestica": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "new1493714951473nondomestica": {
            	            "readonly": false,
            	            "required": false,
            	            "enum": [
                                "Residenza e/o sede legale",
                                "Altro"
            	            ],
            	            "properties": {}
            	        },
            	        "comunicazioni-via-nondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        },
            	        "comunicazioni-num-nondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        },
            	        "comunicazioni-esp-nondomestica": {
            	            "type": "string",
            	            "required": false,
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        },
            	        "comunicazioni-cap-nondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        },
            	        "new1499073284397nondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        },
            	        "new1499073303934nondomestica": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "new1493714951473nondomestica",
            	            "properties": {}
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "fields": {
                	"new1499069324893": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "a decorrere dal",
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
                        "readonly": false,
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
                    "tipocontribuente": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Tipo contribuente",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Fisico",
                            "Giuridico"
                        ],
                        "removeDefaultNone": false,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": false,
                        "readonly": false,
                        "renderButtons": true,
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
                    "provenienzaNascita": {
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
                    "labelResidenza": {
                        "type": "label",
                        "label": "Luogo di Residenza",
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
                    "luogoResidenza": {
                        "type": "provinciaComuneRequired",
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "view": "provinciacomunerequired-view",
                        "fields": {
                            "provincia": {
                                "type": "provincia",
                                "validate": true,
                                "showMessages": true,
                                "disabled": false,
                                "hidden": false,
                                "label": "Provincia",
                                "helpers": [],
                                "hideInitValidationError": true,
                                "fieldClass": "select2ac1",
                                "focus": false,
                                "optionLabels": [],
                                "removeDefaultNone": false,
                                "noneLabel": "--Seleziona--",
                                "hideNone": false,
                                "useDataSourceAsEnum": false,
                                "dataSource": "",
                                "multiple": false,
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
                                "removeDefaultNone": true,
                                "noneLabel": "--Seleziona--",
                                "hideNone": true,
                                "useDataSourceAsEnum": false,
                                "multiple": false,
                                "emptySelectFirst": true,
                                "multiselect": {
                                    "disableIfEmpty": true
                                },
                                "sort": false,
                                "renderButtons": true,
                                "events": {},
                                "fieldClass": "select2ac1",
                                "fields": {}
                            }
                        }
                    },
                    "labelIndirizzoResidenza": {
                        "type": "label",
                        "label": "Indirizzo di Residenza",
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
                    "indirizzoResidenza": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Indirizzo Residenza",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "capnondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "CAP",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "inqualitadinondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "In qualità di",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "societa-nome-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "della soc.",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "pivanondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "p.IVA",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "societa-sedelegale-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "con sede legale in",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "societa-via-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "alla via",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "societa-n-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "n.",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "societa-esp-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "esp.",
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
                    "societa-sc-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "sc",
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
                    "societa-p-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "p.",
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
                    "societa-int-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "int.",
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
                    "societa-cap-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "CAP",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "societa-pec-nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "PEC",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "telefononondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Telefono",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "faxnondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Fax",
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
                    "numeroreanondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero REA",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1499073533377nondomestica": {
                        "type": "text",
            			"dependencies": {
                            "tipocontribuentenondomestica": [
                                "Giuridico"
                            ]
                        },                        
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia REA",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "estremidocumentonondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Estremi del documento",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1493714866834nondomestica": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Invio cartelle e/o comunicazioni c/o",
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
                    "new1493714951473nondomestica": {
                        "type": "select",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Residenza e/o sede legale",
                            "Altro"
                        ],
                        "removeDefaultNone": true,
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "readonly": false,
                        "renderButtons": true,
                        "noneLabel": "None",
                        "sort": false,
                        "fields": {}
                    },
                    "comunicazioni-via-nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Via",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-num-nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Num.",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-esp-nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "esp.",
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
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-cap-nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "CAP",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "new1499073284397nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Comune",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "new1499073303934nondomestica": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia",
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
                        "dependencies": {
                            "new1493714951473nondomestica": [
                                "Altro"
                            ]
                        },
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    }
                },
                "view": "anagrafeTariNonDomesticaNoStradario-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe Tari non domestica";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe Tari non domestica";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeTariNonDomesticaNoStradario-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeTariNonDomesticaNoStradarioContainer,
    		"container-object": anagrafeTariNonDomesticaNoStradarioContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeTariNonDomesticaNoStradario", Alpaca.Fields.anagrafeTariNonDomesticaNoStradario);
    

})(jQuery);