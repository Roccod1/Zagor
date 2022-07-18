var anagrafeRichiedenteCambioResidenzaStessoComuneContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="50"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeRichiedenteCambioResidenzaStessoComuneContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeRichiedenteCambioResidenzaStessoComune = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeRichiedenteCambioResidenzaStessoComune.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeRichiedenteCambioResidenzaStessoComune";
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
                "dependencies": {
        			"new1501169626889": ["new1501153050368"],
                },
                "properties": {
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
                    "provenienza": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "datanascita": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "sesso": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1501143253415": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "properties": {}
                    },
                    "cittadinanzaObject": {
                    	"type": "object",
                        "properties": {
                            "stati": {
                                "default": "Italia",
                                "required": false,
                                "properties": {}
                            }
                        }
                    },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "seioccupato": {
                        "readonly": false,
                        "required": true,
                        "disallow": [],
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "posizioneprofessione": {
                        "readonly": false,
                        "dependencies": "seioccupato",
                        "required": true,
                        "enum": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "properties": {}
                    },
                    "condizionenonprofessionale": {
                        "readonly": false,
                        "dependencies": "seioccupato",
                        "required": true,
                        "enum": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "properties": {}
                    },
                    "titolostudio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "properties": {}
                    },
                    "new1501151800359": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501152489552": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "altropatente": {
                        "type": "string",
                        "required": true,
                        "dependencies": "new1501152489552",
                        "properties": {}
                    },
                    "numero": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "datarilascio": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "organorilascio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501152959579": {
                        "readonly": false,
                        "required": true,
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501153050368": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501159856161": {
                        "type": "string",
                        "required": false,
                        "dependencies": "new1501153050368",
                        "properties": {}
                    },
                    "new1501169626889": {
                        "items": {
                            "title": "",
                            "type": "object",
                            "properties": {
                                "new1501162597354": {
                                    "readonly": false,
                                    "required": true,
                                    "disallow": [],
                                    "enum": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "properties": {}
                                },
                                "new1501162600973": {
                                    "readonly": false,
                                    "required": true,
                                    "type": "string",
                                    "properties": {}
                                }
                            }
                        },
                        "type": "array",
                        "properties": {},
                        "required": false
                    },
                    "new1494931736686": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
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
                    "provenienza": {
                        "type": "text",
                        "label": "Luogo di nascita",
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
                        "label": "Data nascita (dd/mm/yyyy)",
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
                    "new1501143253415": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Stato civile",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "fields": {}
                    },
                    "cittadinanzaObject": {
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
                                "validate": false,
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
                    "seioccupato": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Svolgi unâ€™attivitÃ  lavorativa?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "sort": false,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": false,
                        "fields": {}
                    },
                    "posizioneprofessione": {
                        "type": "radio",
                        "dependencies": {
                                "seioccupato": [
                                    "Si"
                                ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Posizione nella professione:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "condizionenonprofessionale": {
                        "type": "radio",
                        "dependencies": {
                                "seioccupato": [
                                    "No"
                                ]
                        },            
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Condizione non professionale:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "titolostudio": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolo di Studio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501151800359": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolare di patente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501152489552": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Patente tipo",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "altropatente": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "specifica altro",
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
                            "new1501152489552": [
                            	"Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "numero": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero:",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "datarilascio": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Data di rilascio:",
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
                        "sort": false,
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
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "organorilascio": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Organo di rilascio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501152959579": {
                        "type": "provincia",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia di",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501153050368": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Hai veicoli intestati personalmente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501159856161": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Targhe veicoli immatricolati in Italia in qualitÃ  di proprietario/comproprietario, usufruttuario/Locatario",
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
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501169626889": {
                        "type": "dativeicolo",
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },                        
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "toolbarStyle": "button",
                        "toolbarSticky": true,
                        "actionbarStyle": "top",
                        "items": {
                            "fields": {
                                "new1501162597354": {
                                    "type": "select",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Tipo veicolo",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "removeDefaultNone": true,
                                    "noneLabel": "None",
                                    "hideNone": true,
                                    "useDataSourceAsEnum": true,
                                    "multiple": false,
                                    "sort": false,
                                    "emptySelectFirst": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "readonly": false,
                                    "renderButtons": true,
                                    "fields": {}
                                },
                                "new1501162600973": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Targa",
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
                                    "fields": {},
                                    "readonly": false
                                }
                            }
                        },
                        "rubyrails": false,
                        "hideToolbarWithChildren": true,
                        "view": "dativeicolo-view",
                        "fields": {}
                    },
                    "new1494931736686": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Consapevole delle responsabilita' penali per le dichiarazioni mendaci ai sensi degli art. 75 e 76 DPR 445/2000 che prevedono la decadenza dai benefici e l'obbligo di denuncia all'autorita' competente",
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
                    }
                },
                "view": "anagrafeRichiedenteCambioResidenzaStessoComune-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe richiedente cambio residenza stesso comune";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe richiedente cambio residenza stesso comune";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeRichiedenteCambioResidenzaStessoComune-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeRichiedenteCambioResidenzaStessoComuneContainer,
    		"container-object": anagrafeRichiedenteCambioResidenzaStessoComuneContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeRichiedenteCambioResidenzaStessoComune", Alpaca.Fields.anagrafeRichiedenteCambioResidenzaStessoComune);
    

})(jQuery);;var anagrafeRichiedenteIscrizioneAltroMotivoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="50"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeRichiedenteIscrizioneAltroMotivoContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeRichiedenteIscrizioneAltroMotivo = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeRichiedenteIscrizioneAltroMotivo.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeRichiedenteIscrizioneAltroMotivo";
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
                "dependencies": {
        			"new1501169626889": ["new1501153050368"],
                },
                "properties": {
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
                    "provenienza": {
                        "type": "string",
                        "required": true,
                        "properties": {}
			        },
                    "datanascita": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "sesso": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1501143253415": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "properties": {}
                    },
                    "cittadinanzaObject": {
                    	"type": "object",
                        "properties": {
                            "stati": {
                                "default": "Italia",
                                "required": false,
                                "properties": {}
                            }
                        }
                    },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "stailavorando": {
                        "readonly": false,
                        "required": true,
                        "disallow": [],
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "posizioneprofessione": {
                        "readonly": false,
                        "dependencies": "stailavorando",
                        "required": true,
                        "enum": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "properties": {}
                    },
                    "condizionenonprofessionale": {
                        "readonly": false,
                        "dependencies": "stailavorando",
                        "required": true,
                        "enum": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "properties": {}
                    },
                    "titolostudio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "properties": {}
                    },
                    "new1501151800359": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501152489552": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "altropatente": {
                        "type": "string",
                        "required": true,
                        "dependencies": "new1501152489552",
                        "properties": {}
                    },
                    "numero": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "datarilascio": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "organorilascio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501152959579": {
                        "readonly": false,
                        "required": true,
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501153050368": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501159856161": {
                        "type": "string",
                        "required": false,
                        "dependencies": "new1501153050368",
                        "properties": {}
                    },
                    "new1501169626889": {
                        "items": {
                            "title": "",
                            "type": "object",
                            "properties": {
                                "new1501162597354": {
                                    "readonly": false,
                                    "required": true,
                                    "disallow": [],
                                    "enum": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "properties": {}
                                },
                                "new1501162600973": {
                                    "readonly": false,
                                    "required": true,
                                    "type": "string",
                                    "properties": {}
                                }
                            }
                        },
                        "type": "array",
                        "properties": {},
                        "required": false
                    },
                    "new1494931736686": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
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
                    "provenienza": {
                        "type": "text",
                        "label": "Luogo di nascita",
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
                        "label": "Data nascita (dd/mm/yyyy)",
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
                    "new1501143253415": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Stato civile",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "fields": {}
                    },
                    "cittadinanzaObject": {
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
                                "validate": false,
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
                    "stailavorando": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Svolgi unâ€™attivitÃ  lavorativa?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "sort": false,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": false,
                        "fields": {}
                    },
                    "posizioneprofessione": {
                        "type": "radio",
                        "dependencies": {
                                "stailavorando": [
                                    "Si"
                                ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Posizione nella professione:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "condizionenonprofessionale": {
                        "type": "radio",
                        "dependencies": {
                                "stailavorando": [
                                    "No"
                                ]
                        },            
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Condizione non professionale:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "titolostudio": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolo di Studio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501151800359": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolare di patente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501152489552": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Patente tipo",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "altropatente": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "specifica altro",
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
                            "new1501152489552": [
                            	"Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "numero": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero:",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "datarilascio": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Data di rilascio:",
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
                        "sort": false,
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
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "organorilascio": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Organo di rilascio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501152959579": {
                        "type": "provincia",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia di",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501153050368": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Hai veicoli intestati personalmente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501159856161": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Targhe veicoli immatricolati in Italia in qualitÃ  di proprietario/comproprietario, usufruttuario/Locatario",
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
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501169626889": {
                        "type": "dativeicolo",
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },                        
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "toolbarStyle": "button",
                        "toolbarSticky": true,
                        "actionbarStyle": "top",
                        "items": {
                            "fields": {
                                "new1501162597354": {
                                    "type": "select",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Tipo veicolo",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "removeDefaultNone": true,
                                    "noneLabel": "None",
                                    "hideNone": true,
                                    "useDataSourceAsEnum": true,
                                    "multiple": false,
                                    "sort": false,
                                    "emptySelectFirst": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "readonly": false,
                                    "renderButtons": true,
                                    "fields": {}
                                },
                                "new1501162600973": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Targa",
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
                                    "fields": {},
                                    "readonly": false
                                }
                            }
                        },
                        "rubyrails": false,
                        "hideToolbarWithChildren": true,
                        "view": "dativeicolo-view",
                        "fields": {}
                    },
                    "new1494931736686": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Consapevole delle responsabilita' penali per le dichiarazioni mendaci ai sensi degli art. 75 e 76 DPR 445/2000 che prevedono la decadenza dai benefici e l'obbligo di denuncia all'autorita' competente",
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
                    }
                },
                "view": "anagrafeRichiedenteIscrizioneAltroMotivo-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe richiedente iscrizione altro motivo";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe richiedente iscrizione altro motivo";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeRichiedenteIscrizioneAltroMotivo-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeRichiedenteIscrizioneAltroMotivoContainer,
    		"container-object": anagrafeRichiedenteIscrizioneAltroMotivoContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeRichiedenteIscrizioneAltroMotivo", Alpaca.Fields.anagrafeRichiedenteIscrizioneAltroMotivo);
    

})(jQuery);;var anagrafeRichiedenteResidenzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="50"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeRichiedenteResidenzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeRichiedenteResidenza = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeRichiedenteResidenza.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeRichiedenteResidenza";
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
                "dependencies": {
        			"new1501169626889": ["new1501153050368"],
                },
                "properties": {
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
					"provenienza": {
						"type": "string",
                        "required": true,
                        "properties": {}
			        },
                    "datanascita": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "sesso": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1501143253415": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "properties": {}
                    },
                    "cittadinanzaObject": {
                    	"type": "object",
                        "properties": {
                            "stati": {
                                "default": "Italia",
                                "required": false,
                                "properties": {}
                            }
                        }
                    },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "seioccupato": {
                        "readonly": false,
                        "required": true,
                        "disallow": [],
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "posizioneprofessione": {
                        "readonly": false,
                        "dependencies": "seioccupato",
                        "required": true,
                        "enum": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "properties": {}
                    },
                    "condizionenonprofessionale": {
                        "readonly": false,
                        "dependencies": "seioccupato",
                        "required": true,
                        "enum": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "properties": {}
                    },
                    "titolostudio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "properties": {}
                    },
                    "new1501151800359": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501152489552": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "altropatente": {
                        "type": "string",
                        "required": true,
                        "dependencies": "new1501152489552",
                        "properties": {}
                    },
                    "numero": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "datarilascio": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "organorilascio": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501152959579": {
                        "readonly": false,
                        "required": true,
                        "dependencies": "new1501151800359",
                        "properties": {}
                    },
                    "new1501153050368": {
                        "readonly": false,
                        "required": true,
                        "enum": [
                            "Si",
                            "No"
                        ],
                        "properties": {}
                    },
                    "new1501159856161": {
                        "type": "string",
                        "required": false,
                        "dependencies": "new1501153050368",
                        "properties": {}
                    },
                    "new1501169626889": {
                        "items": {
                            "title": "",
                            "type": "object",
                            "properties": {
                                "new1501162597354": {
                                    "readonly": false,
                                    "required": true,
                                    "disallow": [],
                                    "enum": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "properties": {}
                                },
                                "new1501162600973": {
                                    "readonly": false,
                                    "required": true,
                                    "type": "string",
                                    "properties": {}
                                }
                            }
                        },
                        "type": "array",
                        "properties": {},
                        "required": false
                    },
                    "new1494931736686": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
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
	                "provenienza": {
                        "type": "text",
                        "label": "Luogo di nascita",
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
                        "label": "Data nascita (dd/mm/yyyy)",
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
                    "new1501143253415": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Stato civile",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "celibe/nubile",
                            "coniugato/a",
                            "vedovo/a",
                            "unito/a civilmente",
                            "divorziato/a"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "fields": {}
                    },
                    "cittadinanzaObject": {
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
                                "validate": false,
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
                    "seioccupato": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Svolgi unâ€™attivitÃ  lavorativa?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "sort": false,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": false,
                        "fields": {}
                    },
                    "posizioneprofessione": {
                        "type": "radio",
                        "dependencies": {
                                "seioccupato": [
                                    "Si"
                                ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Posizione nella professione:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Imprenditore/Libero professionista",
                            "Dirigente/Impiegato",
                            "Lavoratore in proprio",
                            "Operaio e assimilati",
                            "Coadiuvante"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "condizionenonprofessionale": {
                        "type": "radio",
                        "dependencies": {
                                "seioccupato": [
                                    "No"
                                ]
                        },            
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Condizione non professionale:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Casalinga",
                            "Studente",
                            "Disoccupato/in cerca di prima occupazione",
                            "Pensionato/Ritirato dal lavoro",
                            "Altra condizione non professionale",
                            "Nessuna condizione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "titolostudio": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolo di Studio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Nessun titolo",
                            "Analfabeta",
                            "Terza elementare",
                            "Quinta elementare",
                            "Licenza elementare",
                            "Licenza avv. prof. ",
                            "Licenza media",
                            "Diploma",
                            "Laurea triennale",
                            "Laurea",
                            "Dottorato"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501151800359": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolare di patente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501152489552": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Patente tipo",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "A",
                            "A1",
                            "A2",
                            "AM",
                            "Altro",
                            "B",
                            "B1",
                            "BE",
                            "C",
                            "C1",
                            "C1E",
                            "CE",
                            "CQC Merci",
                            "CQC Persone",
                            "D",
                            "D1",
                            "D1E",
                            "DE",
                            "KA",
                            "KB",
                            "Altro"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "altropatente": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "specifica altro",
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
                            "new1501152489552": [
                            	"Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "numero": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero:",
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
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "datarilascio": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Data di rilascio:",
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
                        "sort": false,
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
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "organorilascio": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Organo di rilascio:",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                        	"Seleziona",
                            "Prefettura",
                            "Motorizzazione"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501152959579": {
                        "type": "provincia",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia di",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "readonly": false,
                        "dependencies": {
                            "new1501151800359": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501153050368": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Hai veicoli intestati personalmente?",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Si",
                            "No"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "new1501159856161": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Targhe veicoli immatricolati in Italia in qualitÃ  di proprietario/comproprietario, usufruttuario/Locatario",
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
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501169626889": {
                        "type": "dativeicolo",
                        "dependencies": {
                            "new1501153050368": [
                                "Si"
                            ]
                        },                        
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "toolbarStyle": "button",
                        "toolbarSticky": true,
                        "actionbarStyle": "top",
                        "items": {
                            "fields": {
                                "new1501162597354": {
                                    "type": "select",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Tipo veicolo",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [
                                    	"Seleziona",
                                        "Autoveicoli",
                                        "Rimorchi",
                                        "Motoveicoli",
                                        "Ciclomotori"
                                    ],
                                    "removeDefaultNone": true,
                                    "noneLabel": "None",
                                    "hideNone": true,
                                    "useDataSourceAsEnum": true,
                                    "multiple": false,
                                    "sort": false,
                                    "emptySelectFirst": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "readonly": false,
                                    "renderButtons": true,
                                    "fields": {}
                                },
                                "new1501162600973": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": false,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Targa",
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
                                    "fields": {},
                                    "readonly": false
                                }
                            }
                        },
                        "rubyrails": false,
                        "hideToolbarWithChildren": true,
                        "view": "dativeicolo-view",
                        "fields": {}
                    },
                    "new1494931736686": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Consapevole delle responsabilita' penali per le dichiarazioni mendaci ai sensi degli art. 75 e 76 DPR 445/2000 che prevedono la decadenza dai benefici e l'obbligo di denuncia all'autorita' competente",
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
                    }
                },
                "view": "anagrafeRichiedenteResidenza-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe richiedente residenza";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe richiedente residenza";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeRichiedenteResidenza-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeRichiedenteResidenzaContainer,
    		"container-object": anagrafeRichiedenteResidenzaContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeRichiedenteResidenza", Alpaca.Fields.anagrafeRichiedenteResidenza);
    

})(jQuery);;var anagrafeUtenteContainer = ' \
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
                        "required": true,
                        "enum": [],
                        "properties": {}
                    },
                    "labelprovenienzanascita": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
					"provenienzanascita": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
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
                        "type": "nazione",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Cittadinanza",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "dataSource": "@@customFieldDataSource/nazioni/nazioni.json",
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {}
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
	                    "type": "provenienza",
	                    "validate": true,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "label": "Luogo di nascita",
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
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Residente a",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "dataSource": "@@customFieldDataSource/comuni/comuni.json",
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
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
    

})(jQuery);;var campoISEEContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var campoISEEContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    var importoIseeConfronto = 0;
    
    
    Alpaca.Fields.CampoISEE = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CampoISEE.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "campoISEE";
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
                         "importoIsee": {
                             "type": "number",
                             "required": true,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "importoIsee": {
                        "label": "ISEE",
                        "type": "number",
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
                        "numericEntry": false,
                        "fields": {},
                        "events": {
                        	"ready": function(){
                                var campoImporto = this;
                                
                        		$.ajax({
				                    url: sogliaIseeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	importoIseeConfronto = parseFloat(data);
				                    	console.log("float soglia ", importoIseeConfronto);
				                    },
				                    error: function() {

		                                    campoImporto.options.helpers = ["Si Ã¨ verificato un problema - IMPOSSIBILE PROSEGUIRE"];  	
		                                 	campoImporto.getControlEl().val('Si Ã¨ verificato un problema - IMPOSSIBILE PROSEGUIRE');
		                                 	campoImporto.getControlEl().attr("disabled", true);
				                    }
																	
	                            });
                        		
                        	},
                            "change": function() {
                                var campoImporto = this;
                                var importo = this.getValue();
								
                                var checkAllegato = $("div.isee").find("input");
                                 if (checkAllegato.length == 0) {
                                    campoImporto.options.disabled = true;
                                    campoImporto.options.helpers = ["Si Ã¨ verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                 	campoImporto.refresh();
                                 	campoImporto.getControlEl().val('Problema con gli allegati - IMPOSSIBILE PROSEGUIRE');

                                 } else {
                                
		                             if(importo < importoIseeConfronto){
		                            	 $("div.isee").find("input")[0].checked = true;
		                             } else {
		                            	 $("div.isee").find("input")[0].checked = false;
		                             }
                                 }
                             }
                         }
                    }
                
                },
                "view": "campoISEE-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Campo ISEE";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Campo di inserimento ISEE che rende allegato obbligatorio per importi minori della soglia";
        }
    });
   
    Alpaca.registerView({
	  	"id": "campoISEE-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio.",
	        "stringNotANumber": "Inserire un valore numerico. Utilizzare un punto per separare i centesimi, p.e. 150.00"
	    },
		"templates": {
			"container": campoISEEContainer,
			"container-object": campoISEEContainerObject
		}
    });
    Alpaca.registerFieldClass("campoISEE", Alpaca.Fields.CampoISEE); 
  
    
})(jQuery);;(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.ComuneField = Alpaca.Fields.SelectField.extend(
    /**
     * @lends Alpaca.Fields.SelectField.prototype
     */
    { 	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "comune";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Comune field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Comune Field.";
        }
        
    });

    Alpaca.registerFieldClass("comune", Alpaca.Fields.ComuneField);

})(jQuery);;var criteriScolasticiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var criteriScolasticiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-1" style="margin-top: -5px">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-8">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-1">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-1">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
    	</div> \
    </div> \
</script>';

var esclusioniCriteri = {};
var disabledCounter = {};

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.CriteriScolasticiField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.CriteriScolasticiField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "criteriScolastici";
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

    	                    	"checkCriterio": {
    	                            "type": "boolean",
    	                            "required": false,
    	                            "properties": {}
    	                        },
    	    	                "testoCriterio": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "punteggioCriterio": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	                         "hiddenIdCriterio": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         },
    	                         "hiddenAnnoScolastico": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {

			                   	 "checkCriterio": {
			                         "type": "checkbox",
			                         "fields": {},
			                         "helpers": [],
			                         "multiple": false,
			                         "data": false,
			                         "disabled": false,
			                         "renderButtons": true,
			                         "events": {
			                        	 "change": function() {
		    	                            	 var isChecked = this.getValue();
		    	                            	 var currentId = this.getControlEl().find("input")[0].id;
		    	                            	 var esclusioniString = esclusioniCriteri[currentId];
		    	                            	 if (esclusioniString != null) {
			    	                            	 var esclusioniJson = JSON.parse(esclusioniString);
			    	                            	 esclusioniJson["idCriteriEsclusi"].forEach(
				    	                            	     function (element){
				    	                            	         var criterioToDisable = $("input[id=criterio" + element + "]");
						    	                            	 if (isChecked) {
					    	                            	         disabledCounter["criterio" + element]++;
						    	                            		 criterioToDisable[0].checked = false;
					    	                            	         criterioToDisable[0].disabled = true;
					    	                            	         criterioToDisable.closest("div.row").css("color", "grey");
						    	                            	 } else {
						    	                            		 disabledCounter["criterio" + element]--;
						    	                            		 if (disabledCounter["criterio" + element] === 0) {
						    	                            	         criterioToDisable[0].disabled = false;   	                            		 
						    	                            	         criterioToDisable.closest("div.row").css("color", "black");
						    	                            		 }
						    	                            	 }
				    	                            	     }
			    	                            	 );
		    	                            	 }
			                        	 }
			                         }
			                     },
	    	                     "testoCriterio": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "helpers": [],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "fields": {},
	    	                         "view": "bootstrap-display",
	    	                         "events": {
	    	                             "ready": function(){
	    	                             	 //Equivalente a this.parent.children[0] Ã¨ this.parent.childrenByPropertyId("checkCriterio")
	    	                             	 
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].dataset.checkboxValue = this.getValue();
											 this.parent.children[0].getControlEl().find("input")[0].id = "criterio";
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].name = this.getValue();
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].textContent = this.getValue();
	    	                             	 
	    	 								
	    	                             }

	    	                         }
	    	                     },
	    	                     "punteggioCriterio": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "fieldClass": "text-center",
	    	                         "helpers": [],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "view": "bootstrap-display",
	    	                         "fields": {}
	    	                         
	    	                     },
	    	                     "hiddenIdCriterio": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenAnnoScolastico": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "fieldClass": "annoScolasticoCriterioCss",
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     }
	                }

            	},
                "hidden": false,
                "animate": true,
                "helpers": [],
                "toolbar": {
                    "actions": [
                        {
                            "action": "add",
                            "enabled": false
                        }
                    ]
                },
                "disabled": false,
                "validate": false,
                "collapsed": false,
                "rubyrails": false,
                "collapsible": false,
                "hideToolbar": true,
                "lazyLoading": false,
                "legendStyle": "button",
                "optionLabels": [],
                "showMessages": true,
                "toolbarStyle": "button",
                "hideActionbar": true,
                "toolbarSticky": false,
                "actionbarStyle": "top",
                "hideInitValidationError": false,
                "hideToolbarWithChildren": true,
            	"view": "criteriscolastici-view",
            	"events": {
                    "ready": function(){
                        var currentCriteri = $("input[id='criterio']");
                        var count = 0;
                        var annoScolasticoCriterioCodice = $($('.annoScolasticoCriterioCss')[0]).alpaca("get").data;
    					$.ajax({
		                    url: listaCriteriScolasticiUrl + '&annoScolastico=' + annoScolasticoCriterioCodice,
		                    dataType: 'json',
		                    delay: 250,
		                    success: function (data) {
		                        currentCriteri.each(
                                    function() {
                                        var idCurrentCriterio = "criterio" + data[count].id;
                                 	    this.id = idCurrentCriterio;
                                 	    esclusioniCriteri[idCurrentCriterio] = data[count].esclusioni;
                                 	    disabledCounter[idCurrentCriterio] = 0;
                                 	    count++;
                                });

                                }
	                   });                        
                        
                        
                    }
            	}
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Criteri scolastici";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Criteri scolastici per elenco moduli";
        }
    });

    Alpaca.registerView({
    	"id": "criteriscolastici-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": criteriScolasticiContainer,
    		"container-object": criteriScolasticiContainerObject
    	}
    });
    Alpaca.registerFieldClass("criteriScolastici", Alpaca.Fields.CriteriScolasticiField);
    
})(jQuery);;
(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.DatiAbitazioneResidenzaField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.DatiAbitazioneResidenzaField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiAbitazioneResidenza";
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
            	     "dependencies": {
            	         "provenienzaNascitaIntContr": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "provenienzaNascitaContr": [
            	             "new1501248550182"
            	         ],
            	         "provenienzaNascitaFam": [
            	             "new1501248550182"
            	         ],
            	         "provenienzaNascitaComLoc": [
            	             "new1501248877873"
            	         ],
            	         "provComuneAgenziaEntrate": [
                	         "ConditionalFieldDatiAbitazione"
                	     ],
            	         "provComuneResidenteUno": [
                	         "ConditionalFieldDatiAbitazione"
                	     ],
            	         "provComuneResidenteDue": [
                	         "new1501248550182"
                	     ],
            	         "provComuneResidenteTre": [
                	         "new1501248877873"
                	     ]
            	     },            	    
            	    "required": false,
            	    "properties": {
            	        "labeldatirelativiabitazione": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "new1505134902315": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "sezione": {
            	            "readonly": false,
            	            "default": "nct",
            	            "required": true,
            	            "enum": [
            	                "nct",
            	                "--"
            	            ],
            	            "properties": {}
            	        },
            	        "foglio": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "number",
            	            "exclusiveMinimum": false,
            	            "exclusiveMaximum": false,
            	            "properties": {}
            	        },
            	        "particella": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "number",
            	            "exclusiveMinimum": false,
            	            "exclusiveMaximum": false,
            	            "properties": {}
            	        },
            	        "subalterno": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "number",
            	            "exclusiveMinimum": false,
            	            "exclusiveMaximum": false,
            	            "properties": {}
            	        },
            	        "ConditionalFieldDatiAbitazione": {
            	            "readonly": false,
            	            "required": false,
            	            "enum": [
            	                "1. Di essere proprietario",
            	                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
            	                "3. Di essere intestatario di contratto di locazione relativo a immobile di Edilizia Residenziale Pubblica (allegare copia del contratto o del verbale di consegna dell'immobile)",
            	                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito",
            	                "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto",
            	                "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto",
            	                "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
            	            ],
            	            "default": "1. Di essere proprietario",
            	            "properties": {}
            	        },
            	        "labelAgenziaEntrate": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "provComuneAgenziaEntrate": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
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
            	        "datiabitazione-data": {
            	            "type": "string",
            	            "required": true,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
            	        "datiabitazione-numero": {
            	            "type": "string",
            	            "required": true,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
            	        "new1501248168458": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
                        "labelprovenienzanascitaintcontr": {
                            "type": "string",
                            "dependencies": "ConditionalFieldDatiAbitazione",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaNascitaIntContr": {
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },            	        
            	        "new1501248231032": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "labelResidenteUno": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "provComuneResidenteUno": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
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
            	        "new1501248339304": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1501248400387": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1501248550182": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "disallow": [],
            	            "enum": [
            	                "Contratto di comodato d'uso gratuito verbale",
            	                "Contratto di locazione in fase di registrazione",
            	                "Di aggregarsi alla famiglia"
            	            ],
            	            "properties": {}
            	        },
            	        "new1501248686419": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
                        "labelprovenienzanascitacontr": {
                            "type": "string",
                            "dependencies": "new1501248550182",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaNascitaContr": {
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },
            	        "new1501248724037": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "labelResidenteDue": {
            	            "dependencies": "new1501248550182",
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "provComuneResidenteDue": {
            	            "dependencies": "new1501248550182",
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
            	        "new1501248761504": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1501248798619": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
                        "labelprovenienzanascitafam": {
                            "type": "string",
                            "dependencies": "new1501248550182",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaNascitaFam": {
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },           	        
            	        "new1501248853315": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1501248863251": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "disallow": [],
            	            "enum": [
            	                "Altro (vincoli affettivi, parentela, ecc.)",
            	                "Rapporto di lavoro subordinato (es. badanti)"
            	            ],
            	            "properties": {}
            	        },
            	        "new1501248877873": {
            	            "readonly": false,
            	            "dependencies": "new1501248550182",
            	            "required": true,
            	            "disallow": [],
            	            "enum": [
            	                "Comodatario dell'abitazione di proprietÃ ",
            	                "Locatario dell'abitazione di proprietÃ ",
            	                "Proprietario dell'abitazione"
            	            ],
            	            "properties": {}
            	        },
            	        "new1501249306120": {
            	            "readonly": false,
            	            "dependencies": "new1501248877873",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
                        "labelprovenienzanascitacomloc": {
                            "type": "string",
                            "dependencies": "new1501248877873",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaNascitaComLoc": {
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },  
            	        "new1501249366180": {
            	            "readonly": false,
            	            "dependencies": "new1501248877873",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "labelResidenteTre": {
            	            "dependencies": "new1501248877873",
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "provComuneResidenteTre": {
            	            "dependencies": "new1501248877873",
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
            	        "new1501249377528": {
            	            "readonly": false,
            	            "dependencies": "new1501248877873",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "new1501250098476": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        }
            	    }
                };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "labeldatirelativiabitazione": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Dati relativi all'abitazione",
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
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1505134902315": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Dichiaro di occupare legittimamente l'abitazione contraddistinta dagli estremi catastali riportati di seguito, in base al titolo di seguito descritto, consapevole che, ai sensi dell'art. 5 del D.L. 28.3.2014 n. 47 (convertito nella Legge 23.5.2014 n. 80), in caso di dichiarazione mendace l'iscrizione anagrafica sarÃ  nulla, per espressa previsione di legge, con decorrenza dalla data della dichiarazione stessa",
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
                    "sezione": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Sezione",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "nct",
                            "--"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "foglio": {
                        "type": "number",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Foglio",
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
                        "numericEntry": false,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "particella": {
                        "type": "number",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Particella o mappale",
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
                        "numericEntry": false,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "subalterno": {
                        "type": "number",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Subalterno",
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
                        "numericEntry": false,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "ConditionalFieldDatiAbitazione": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helper": "Selezionare una delle opzioni precedenti.", 
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "1. Di essere proprietario",
                            "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                            "3. Di essere intestatario di contratto di locazione relativo a immobile di Edilizia Residenziale Pubblica (allegare copia del contratto o del verbale di consegna dell'immobile)",
                            "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito",
                            "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto",
                            "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto",
                            "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
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
                    "labelAgenziaEntrate": {
                        "type": "label",
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },                         
                        "label": "All'Agenzia delle Entrate di:",
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
                    "provComuneAgenziaEntrate": {
                    	"type": "provinciaComuneRequired",
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        }, 
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
                                "fields": {}
                            }
                        }
                    },
                    "datiabitazione-data": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "in data",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "datiabitazione-numero": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "al numero",
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
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501248168458": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "stipulato con il Signor",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "labelprovenienzanascitaintcontr": {
                        "type": "label",
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },                         
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
                    "provenienzaNascitaIntContr": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
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
	                                    "fieldClass": "select2ac1",
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
	                        "statoEsteroSelezionato": {
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
                    "new1501248231032": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "il",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "labelResidenteUno": {
                        "type": "label",
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },                          
                        "label": "Residente a:",
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
                    "provComuneResidenteUno": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        }, 
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
                                "fields": {}
                            }
                        }
                    },
                    "new1501248339304": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "all'indirizzo",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501248400387": {
                        "type": "textarea",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolo costitutivo",
                        "helpers": [
                            "Indicare dati utili a consentire verifica da parte dell'Ufficio Anagrafe"
                        ],
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
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501248550182": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [
                            "Questo campo non Ã¨ opzionale, effettuare una scelta per proseguire."
                        ],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Contratto di comodato d'uso gratuito verbale",
                            "Contratto di locazione in fase di registrazione",
                            "Di aggregarsi alla famiglia"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501248686419": {
                        "type": "text",
                        "dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "con il Signor",
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
                    "labelprovenienzanascitacontr": {
                        "type": "label",
                        "dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },                       
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
                    "provenienzaNascitaContr": {
                    	"dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },
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
	                                    "fieldClass": "select2ac1",
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
	                        "statoEsteroSelezionato": {
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
                    "new1501248724037": {
                        "type": "date",
                        "dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "il",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "labelResidenteDue": {
                        "type": "label",
                        "dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },                           
                        "label": "Residente a:",
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
                    "provComuneResidenteDue": {
                    	"dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },  
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
                                "fields": {}
                            }
                        }
                    },
                    "new1501248761504": {
                        "type": "text",
                        "dependencies": {
                            "new1501248550182": [
                                "Contratto di comodato d'uso gratuito verbale",
                                "Contratto di locazione in fase di registrazione"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "all'indirizzo",
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
                    "new1501248798619": {
                        "type": "text",
                        "dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "del Signor",
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
                    "labelprovenienzanascitafam": {
                        "type": "label",
                        "dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        },                        
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
                    "provenienzaNascitaFam": {
                    	"dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        }, 
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
	                                    "fieldClass": "select2ac1",
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
	                        "statoEsteroSelezionato": {
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
                    "new1501248853315": {
                        "type": "date",
                        "dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "il",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "new1501248863251": {
                        "type": "radio",
                        "dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "per",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Altro (vincoli affettivi, parentela, ecc.)",
                            "Rapporto di lavoro subordinato (es. badanti)"
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
                    "new1501248877873": {
                        "type": "radio",
                        "dependencies": {
                            "new1501248550182": [
                                "Di aggregarsi alla famiglia"
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "che Ã¨",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Comodatario dell'abitazione di proprietÃ ",
                            "Locatario dell'abitazione di proprietÃ ",
                            "Proprietario dell'abitazione"
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
                    "new1501249306120": {
                        "type": "text",
                        "dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "del Signor",
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
                    "labelprovenienzanascitacomloc": {
                        "type": "label",
                        "dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },                         
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
                    "provenienzaNascitaComLoc": {
                    	"dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        }, 
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
	                                    "fieldClass": "select2ac1",
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
	                        "statoEsteroSelezionato": {
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
                    "new1501249366180": {
                        "type": "date",
                        "dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "il",
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
                        "readonly": false,
                        "fields": {}
                    },
                    "labelResidenteTre": {
                        "type": "label",
                        "dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },                          
                        "label": "Residente a:",
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
                    "provComuneResidenteTre": {
                    	"dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },  
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
                                "fields": {}
                            }
                        }
                    },
                    "new1501249377528": {
                        "type": "text",
                        "dependencies": {
                            "new1501248877873": [
                                "Comodatario dell'abitazione di proprietÃ ",
                                "Locatario dell'abitazione di proprietÃ "
                            ]
                        },
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "all'indirizzo",
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
                    "new1501250098476": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Specifica altro",
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
                            "ConditionalFieldDatiAbitazione": [
                                "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
                            ]
                        },
                        "readonly": false,
                        "fields": {}
                    }
                },

            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati abitazione residenza";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati abitazione residenza";
        }
    });


    Alpaca.registerFieldClass("datiAbitazioneResidenza", Alpaca.Fields.DatiAbitazioneResidenzaField);
    

})(jQuery);;
(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAngraficiCustom";
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
                         "codiceFiscale": {
                             "title": "Cod.Fiscale",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "nome": {
                             "title": "Nome",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "cognome": {
                             "title": "Cognome",
                             "type": "string",
                             "properties": {}
                         },
                         "dataNascita": {
                             "title": "Data di nascita",
                             "type": "string",
                             "properties": {}
                         },
                         "comuneNascita": {
                             "title": "Residenza",
                             "type": "string",
                             "properties": {}
                       },
                         "indirizzoResidenza":{
                        	 "title": "Indirizzo Residenza",
                             "type": "string",
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"type":"object",
            	"label": "",
                "fields": {
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "nome": {
                        "type": "text",
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data  Nascita",
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
                
                    "comuneNascita": {
                        "type": "text",
                        "label": "Comune nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo Residenza",
                        "disabled": true,
                        "renderButtons": true
                    }
                
                },
                "view": "datiAngraficiCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Custom";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici Custom";
        }
    });

    
    
    Alpaca.registerFieldClass("datiAngraficiCustom", Alpaca.Fields.DatiAnagraficiCustom); 
    
    Alpaca.registerView({
    	"parent": "bootstrap-display-horizontal",
    	"id": "datiAngraficiCustom-view",
    	"templates": {}
    });

    
    
})(jQuery);;var datiAnagraficiCustomTwoColContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiCustomTwoColContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
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
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiCustomTwoCol = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiCustomTwoCol.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAngraficiCustomTwoCol";
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
                         "nome": {
                             "title": "Nome",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "cognome": {
                             "title": "Cognome",
                             "type": "string",
                             "properties": {}
                         },
                         "codiceFiscale": {
                             "title": "Cod.Fiscale",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "dataNascita": {
                             "title": "Data di nascita",
                             "type": "string",
                             "properties": {}
                         },
                         "luogoNascita": {
                             "title": "Luogo di nascita",
                             "type": "string",
                             "properties": {}
                       },
                         "indirizzoResidenza":{
                        	 "title": "Indirizzo Residenza",
                             "type": "string",
                             "properties": {}
                         },
                         "viaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "civicoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "esponenteHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "scalaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "pianoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "internoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "capHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "provinciaResHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "comuneResHidden": {
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
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data di nascita",
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
                
                    "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo di residenza",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "viaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "civicoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "esponenteHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "scalaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "pianoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "internoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "capHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "provinciaResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "comuneResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    }
                
                },
                "view": "datiAngraficiCustomTwoCol-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Custom (Due Colonne)";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici Custom con layout a due colonne";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAngraficiCustomTwoCol-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": datiAnagraficiCustomTwoColContainer,
			"container-object": datiAnagraficiCustomTwoColContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAngraficiCustomTwoCol", Alpaca.Fields.DatiAnagraficiCustomTwoCol); 
  
    
})(jQuery);;var datiAnagraficiMinoreFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiMinoreFieldContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiMinoreField = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiMinoreField.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiMinoreField";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            		"title": "",
            	    "description": "",
            		"type": "object",
                    "required": false,
                    "properties": {
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
                        }, 
                        "inseritoManualmente": {
                            "readonly": true,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        }
                    }
            };
            
            Alpaca.merge(this.options, {
            	"type": "object",
                "helpers": [],
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
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
                    },
                    "inseritoManualmente": {
                    	"type": "text",
                        "disabled": true,
                        "hidden": true,
                        "label": "",
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
                },
                "events": {
                	"ready": function(){
                		console.log("CF - delegaPresente " + delegaPresente);
                		console.log("CF - codiceFiscaleSelezioneManuale " + codiceFiscaleSelezioneManuale);
                		var self = this;
                		var inseritoManualmenteField = self.childrenByPropertyId['inseritoManualmente'];
                		var nomeMinoreField = self.childrenByPropertyId['nomeMinore'];
                		var cognomeMinoreField = self.childrenByPropertyId['cognomeMinore'];
                		var codFiscMinoreField = self.childrenByPropertyId['codFiscMinore'];
                		var dataNascitaMinoreField = self.childrenByPropertyId['dataNascitaMinore'];
                		var provComuneRequiredMinoreField = self.childrenByPropertyId['provComuneRequiredMinore'];
                		
                		if(delegaPresente == true && codiceFiscaleSelezioneManuale == "true"
                			&& (inseritoManualmenteField.getControlEl().val() == true 
            						|| inseritoManualmenteField.getControlEl().val() == "true")){
                			console.log("Delega presente e codice fiscale manuale");
                			
                    		nomeMinoreField.options.disabled = false;
                    		nomeMinoreField.refresh();
                    		cognomeMinoreField.options.disabled = false;
                    		cognomeMinoreField.refresh();
                    		codFiscMinoreField.options.disabled = false;
                    		codFiscMinoreField.refresh();
                    		if(codiceFiscaleComponente){
                    			codFiscMinoreField.getControlEl().val(codiceFiscaleComponente);
                    		}
                    		dataNascitaMinoreField.options.disabled = false;
                    		dataNascitaMinoreField.refresh();
                    		
                    		provComuneRequiredMinoreField.options.disabled = false;
                    		provComuneRequiredMinoreField.refresh();
                    		
                    		inseritoManualmenteField.getControlEl().val(true);
                    		
                		} else if(delegaPresente == true 
                				&& (inseritoManualmenteField.getControlEl().val() == true 
                						|| inseritoManualmenteField.getControlEl().val() == "true")){
                			console.log("Delega presente e dati inseriti manualmente");
                			
                    		var nomeMinore = nomeMinoreField.getControlEl().val();
                    		var cognomeMinore = cognomeMinoreField.getControlEl().val();
                    		var codFiscMinore = codFiscMinoreField.getControlEl().val();
                    		var dataNascitaMinore = dataNascitaMinoreField.getControlEl().val();
                    		var provComuneRequiredMinore = provComuneRequiredMinoreField.getControlEl().val();
                    		
                    		nomeMinoreField.options.disabled = false;
                    		nomeMinoreField.refresh();
                    		cognomeMinoreField.options.disabled = false;
                    		cognomeMinoreField.refresh();
                    		codFiscMinoreField.options.disabled = false;
                    		codFiscMinoreField.refresh();
                    		dataNascitaMinoreField.options.disabled = false;
                    		dataNascitaMinoreField.refresh();
                    		provComuneRequiredMinoreField.options.disabled = false;
                    		provComuneRequiredMinoreField.refresh();
                    		
                    		nomeMinoreField.getControlEl().val(nomeMinore);
                    		cognomeMinoreField.getControlEl().val(cognomeMinore);
                    		codFiscMinoreField.getControlEl().val(codFiscMinore);
                    		dataNascitaMinoreField.getControlEl().val(dataNascitaMinore);
                    		provComuneRequiredMinoreField.getControlEl().val(provComuneRequiredMinore);
                    		
                    		
                			
                		}else {
                			console.log("Delega non presente o selezione non manuale");
                		}
                     }                    
                },
                "view": "datiAnagraficiMinoreField-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Minore";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici Minore con layout a due colonne";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAnagraficiMinoreField-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	    },
		"templates": {
			"container": datiAnagraficiMinoreFieldContainer,
			"container-object": datiAnagraficiMinoreFieldContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAnagraficiMinoreField", Alpaca.Fields.DatiAnagraficiMinoreField); 
  
    
})(jQuery);;var datiAnagraficiMinoreSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiMinoreSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
	    <div class="row"> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
        
    Alpaca.Fields.DatiAnagraficiMinoreSelectCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiMinoreSelectCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiMinoreSelectCustom";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "minoriFam": {
                    	"fieldClass": "text-center",
                    	"hideInitValidationError": true,
                        "dataSource": function(callback) {
                    		$.ajax({
			                    url: elencoMinoriUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
			                      },
			                    success: function (data) {
			                    	callback(data);
			                    }, 
			                    error: function(){
			                    	console.log("ERRORE su informazioni minore");
			                    }
                    		});
                        },
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		if (delegaPresente) {
	                        		var opt = document.createElement('option');
	                        	    opt.value = "-1";
	                        	    opt.innerHTML = "--Inserimento Manuale--";
	                        	    this.getControlEl()[0].appendChild(opt);
                        		}
                        	},
                        	"click": function(){
                                var self = this;
                                var allOptions = $("option", self.getControlEl());
                                allOptions.attr("disabled", false);
                                allOptions.css("color", "black"); 
            	                   var allSelectButThis= $("select[name*='minoriFam']").not(this.getControlEl());
                                     allSelectButThis.each(
                                         function() {
                                            var cfMinore = this.value;
                                            if (cfMinore !== "-1") {
	                                            var optionToDisable = $("option[value='" + cfMinore + "']", self.getControlEl());
	                                            optionToDisable.attr("disabled", true);
	                                            optionToDisable.css("color", "lightgrey");
                                            }
                                         }
                                    );
                            },
	                        "change": function() {
	                        	var self = this;
	                        	
	                        	var campoNome = self.parent.childrenByPropertyId['nomeMinore'];
		                    	var campoCognome = self.parent.childrenByPropertyId['cognomeMinore'];
		                    	var campoCodFisc = self.parent.childrenByPropertyId['codFiscMinore'];
		                    	var campoDataNascita = self.parent.childrenByPropertyId['dataNascitaMinore'];
		                    	var campoLuogoNascita = self.parent.childrenByPropertyId['provComuneRequiredMinore'];
		                    	
		                    	var idComponente = this.getValue();
	                        	
	                        	if (idComponente === "-1") {

	                        		campoNome.options.disabled = false;
	                        		campoCognome.options.disabled = false;
	                        		campoCodFisc.options.disabled = false;
	                        		campoDataNascita.options.disabled = false;
	                        		campoLuogoNascita.options.disabled = false;
	                        		

			                    	campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh(); 
	                        		
	                        	} else {
	                        		
	                        		campoNome.options.disabled = true;
	                        		campoCognome.options.disabled = true;
	                        		campoCodFisc.options.disabled = true;
	                        		campoDataNascita.options.disabled = true;
	                        		campoLuogoNascita.options.disabled = true;
	                        		
			                    	campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh(); 
	                        		
		                        	var	infoComponenteDependentUrl = componenteNucleoFamigliareUrl + idComponente;
		                        	$.ajax({
					                    url: infoComponenteDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
					                      },
					                    success: function (data) {
					                    	campoNome.getControlEl().val(data.nome);
					                    	campoCognome.getControlEl().val(data.cognome);
					                    	campoCodFisc.getControlEl().val(data.codiceFiscale);
					                    	campoDataNascita.getControlEl().val(data.dataNascitaString);
					                    	campoLuogoNascita.getControlEl().val(data.nomeComuneNascitaFrontEnd);
					                    },
					                    error: function(){
					                    	console.log("ERRORE su informazioni minore");
					                    }
																										
		                            });
	                        	}
	                        }
                        
                        }
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
                },
                "view": "datiAnagraficiMinoreSelectCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici con selezione minore";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici compilati tramite scelta select del minore";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAnagraficiMinoreSelectCustom-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio"
	    },
		"templates": {
			"container": datiAnagraficiMinoreSelectContainer,
			"container-object": datiAnagraficiMinoreSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAnagraficiMinoreSelectCustom", Alpaca.Fields.DatiAnagraficiMinoreSelectCustom); 
  
    
})(jQuery);;var datiAnagraficiSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
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
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiSelectCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiSelectCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiSelectCustom";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();
            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,

            	    "properties": {
            	        "componentiFam": {
            	            "required": false,
            	            "properties": {}
            	        },
                        "nome": {
                            "title": "Nome",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "cognome": {
                            "title": "Cognome",
                            "type": "string",
                            "properties": {}
                        },
                        "codiceFiscale": {
                            "title": "Cod.Fiscale",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "dataNascita": {
                            "title": "Data di nascita",
                            "type": "string",
                            "properties": {}
                        },
                        "luogoNascita": {
                            "title": "Luogo di nascita",
                            "type": "string",
                            "properties": {}
                      },
                        "indirizzoResidenza":{
                       	 "title": "Indirizzo Residenza",
                            "type": "string",
                            "properties": {}
                        },
                        "viaHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "civicoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "scalaHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "pianoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "internoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "capHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },

                        "comuneResHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "componentiFam": {
                    	"fieldClass": "text-center",
                    	"hideInitValidationError": true,
                    	"dataSource": function(callback) {
                    		$.ajax({
			                    url: listaNucleoFamigliareUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
			                      },
			                    success: function (data) {
			                    	callback(data);
			                    },
			                     error: function(){
			                    	console.log("ERRORE su informazioni minore");
			                    }
                    		});
                        },
                        "type": "select",
                        "label": "<p style='text-align: center'>Selezionare componente nucleo familiare:</p>",
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
                        "fields": {},
                        "events": {
                        	"ready": function() {
                        		if (delegaPresente) {
	                        		var opt = document.createElement('option');
	                        	    opt.value = "InsManuale";
	                        	    opt.innerHTML = "--Inserimento Manuale--";
	                        	    this.getControlEl()[0].appendChild(opt); 
                        		}
                        	},
	                        "change": function() {
	                        	var self = this;
	                        	
	                        	var campoNome = self.parent.childrenByPropertyId['nome'];
	                        	var campoCognome = self.parent.childrenByPropertyId['cognome'];
	                        	var campoCodFisc = self.parent.childrenByPropertyId['codiceFiscale'];
	                        	var campoDataNascita = self.parent.childrenByPropertyId['dataNascita'];
	                        	var campoLuogoNascita = self.parent.childrenByPropertyId['luogoNascita'];
	                        	var campoIndirizzo = self.parent.childrenByPropertyId['indirizzoResidenza'];
	                        	var campoComuneRes = self.parent.childrenByPropertyId['comuneResHidden'];
	                        	var campoVia = self.parent.childrenByPropertyId['viaHidden'];
	                        	var campoCap = self.parent.childrenByPropertyId['capHidden'];
	                        	var campoCivico = self.parent.childrenByPropertyId['civicoHidden'];
	                        	var campoPiano = self.parent.childrenByPropertyId['pianoHidden'];
	                        	var campoScala = self.parent.childrenByPropertyId['scalaHidden'];
	                        	var campoInterno = self.parent.childrenByPropertyId['internoHidden'];
		                    	
	                        	var idComponente = this.getValue();
	                        	
	                        	if (idComponente === "InsManuale") {
	                        		
	                        		campoNome.options.disabled = false;
			                    	campoCognome.options.disabled = false;
			                    	campoCodFisc.options.disabled = false;
			                    	campoDataNascita.options.disabled = false;
			                    	campoLuogoNascita.options.disabled = false;
			                    	campoIndirizzo.options.disabled = false;  
			                    	
	                        		campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh();
			                    	campoIndirizzo.refresh(); 
			                    	campoComuneRes.refresh(); 
			                    	campoVia.refresh(); 
			                    	campoCap.refresh(); 
			                    	campoCivico.refresh(); 
			                    	campoPiano.refresh(); 
			                    	campoScala.refresh(); 
			                    	campoInterno.refresh(); 
			                    	
	                        	} else {
		                        	
	                        		campoNome.options.disabled = true;
			                    	campoCognome.options.disabled = true;
			                    	campoCodFisc.options.disabled = true;
			                    	campoDataNascita.options.disabled = true;
			                    	campoLuogoNascita.options.disabled = true;
			                    	campoIndirizzo.options.disabled = true;
	                        		
	                        		campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh();
			                    	campoIndirizzo.refresh(); 
			                    	campoComuneRes.refresh(); 
			                    	campoVia.refresh(); 
			                    	campoCap.refresh(); 
			                    	campoCivico.refresh(); 
			                    	campoPiano.refresh(); 
			                    	campoScala.refresh(); 
			                    	campoInterno.refresh();  
		                        	
		                        	var	infoComponenteDependentUrl = componenteNucleoFamigliareUrl + idComponente;
		                        	$.ajax({
					                    url: infoComponenteDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
					                    },
					                    success: function (data) {
					                    	
					                    	campoNome.getControlEl().val(data.nome);
					                    	campoCognome.getControlEl().val(data.cognome);
					                    	campoCodFisc.getControlEl().val(data.codiceFiscale);
					                    	campoDataNascita.getControlEl().val(data.dataNascitaString);
					                    	campoLuogoNascita.getControlEl().val(data.nomeComuneNascitaFrontEnd);
					                    	
					                    	if (data.indirizzoResidenzaCompletoFrontEnd != null) {
					                    		campoIndirizzo.getControlEl().val(data.indirizzoResidenzaCompletoFrontEnd);
					                    	}
					                    	
					                    	if (data.nomeComuneResidenza != null) {
						                    	campoComuneRes.getControlEl().val(data.nomeComuneResidenza);
					                    	}
					                    	
					                    	if (data.indirizzoResidenza != null) {
						                    	campoVia.getControlEl().val(data.indirizzoResidenza);    
					                    	}
					                    	
					                    	if (data.civicoResidenza != null) {				                    	
						                    	campoCivico.getControlEl().val(data.civicoResidenza);
					                    	}
					                    	
					                    	if (data.capResidenza != null) {				                    	
						                    	campoCap.getControlEl().val(data.capResidenza);     
					                    	}
					                    	
					                    	if (data.pianoResidenza != null) {
						                    	campoPiano.getControlEl().val(data.pianoResidenza);  
					                    	}
					                    	
					                    	if (data.scalaResidenza != null) {
						                    	campoScala.getControlEl().val(data.scalaResidenza);
					                    	}
					                    	
					                    	if (data.internoResidenza != null) {
						                    	campoInterno.getControlEl().val(data.internoResidenza);
					                    	}
					                    }
		                            });
	                        	}
	                        }
                        }
                    },
                    "nome": {
                        "type": "text",
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data di nascita",
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
                
                    "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo di residenza",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "viaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "civicoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "scalaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "pianoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "internoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "capHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "comuneResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    }          
                },
                "view": "datiAnagraficiSelectCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici con selezione membro famiglia";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici compilati tramite scelta select del membro nucleo familiare";
        }
    });
   
    Alpaca.registerView({
  	"id": "datiAnagraficiSelectCustom-view",
  	"parent": "bootstrap-create",
	"templates": {
		"container": datiAnagraficiSelectContainer,
		"container-object": datiAnagraficiSelectContainerObject
	}
    });
    Alpaca.registerFieldClass("datiAnagraficiSelectCustom", Alpaca.Fields.DatiAnagraficiSelectCustom); 
  
    
})(jQuery);;var datiFamiliareResidenzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiFamiliareResidenzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
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
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiFamiliareField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiFamiliareField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiFamiliare";
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
                    "dependencies": {
            			"new1501169626889": ["new1501153050368"],
                    },
    	            "properties": {
    	                "new1501257778693": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "cognome": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "nome": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
                        "labelprovenienzanascita": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },
    	                "datanascita": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "sesso": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "F",
    	                        "M"
    	                    ],
    	                    "properties": {}
    	                },
    	                "new1501143253415": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                    	"Seleziona",
    	                        "celibe/nubile",
    	                        "coniugato/a",
    	                        "vedovo/a",
    	                        "unito/a civilmente",
    	                        "divorziato/a"
    	                    ],
    	                    "properties": {}
    	                },
    	                "cittadinanzaObject": {
    	                	"type": "object",
                            "properties": {
                                "stati": {
                                    "default": "Italia",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
    	                "new1501144110381": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1501254836085": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "enum": [
    	                    		"Seleziona",
    	                            "Marito/moglie",
    	        					"Figlio/figlia",
    	        					"Nipote (figlio/a di figlio/a)",
    	        					"Pronipote",
    	        					"Padre/madre",
    	        					"Nonno/nonna",
    	        					"Bisnonno/bisnonna",
    	        					"Fratello/sorella",
    	        					"Nipote (figlio/a di fratello/sorella)",
    	        					"Zio/zia",
    	        					"Cugino/cugina",
    	        					"Altro/a parente (fino al 6^grado)",
    	        					"Figliastro/figliastra",
    	        					"Patrigno/matrigna",
    	        					"Genero/nuora",
    	        					"Suocero/suocera",
    	        					"Cognato/cognata",
    	        					"Fratellastro/sorellastra",
    	        					"Nipote (figlio/a di cognato/a)",
    	        					"Zio/zia (marito/moglie di zio/a)",
    	        					"Altro/a affine (fino al 6^ grado)",
    	        					"Convivente in famiglia",
    	        					"Responsabile di convivenza",
    	        					"Membro di convivenza",
    	        					"Convivente"
    	                    ],
    	                    "properties": {}
    	                },
                        "seioccupato": {
                            "readonly": false,
                            "required": true,
                            "disallow": [],
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "posizioneprofessione": {
                            "readonly": false,
                            "dependencies": "seioccupato",
                            "required": true,
                            "enum": [
                                "Imprenditore/Libero professionista",
                                "Dirigente/Impiegato",
                                "Lavoratore in proprio",
                                "Operaio e assimilati",
                                "Coadiuvante"
                            ],
                            "properties": {}
                        },
                        "condizionenonprofessionale": {
                            "readonly": false,
                            "dependencies": "seioccupato",
                            "required": true,
                            "enum": [
                                "Casalinga",
                                "Studente",
                                "Disoccupato/in cerca di prima occupazione",
                                "Pensionato/Ritirato dal lavoro",
                                "Altra condizione non professionale",
                                "Nessuna condizione"
                            ],
                            "properties": {}
                        },
    	                "titolostudio": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "Nessun titolo",
    	                        "Analfabeta",
    	                        "Terza elementare",
    	                        "Quinta elementare",
    	                        "Licenza elementare",
    	                        "Licenza avv. prof. ",
    	                        "Licenza media",
    	                        "Diploma",
    	                        "Laurea triennale",
    	                        "Laurea",
    	                        "Dottorato"
    	                    ],
    	                    "properties": {}
    	                },
    	                "new1501151800359": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "Si",
    	                        "No"
    	                    ],
    	                    "properties": {}
    	                },
                        "new1501151800359": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "new1501152489552": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                            	"Seleziona",
                                "A",
                                "A1",
                                "A2",
                                "AM",
                                "Altro",
                                "B",
                                "B1",
                                "BE",
                                "C",
                                "C1",
                                "C1E",
                                "CE",
                                "CQC Merci",
                                "CQC Persone",
                                "D",
                                "D1",
                                "D1E",
                                "DE",
                                "KA",
                                "KB",
                                "Altro"
                            ],
                            "dependencies": "new1501151800359",
                            "properties": {}
                        },
                        "altropatente": {
                            "type": "string",
                            "required": true,
                            "dependencies": "new1501152489552",
                            "properties": {}
                        },
                        "numero": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "dependencies": "new1501151800359",
                            "properties": {}
                        },
                        "datarilascio": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "dependencies": "new1501151800359",
                            "properties": {}
                        },
                        "organorilascio": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                            	"Seleziona",
                                "Prefettura",
                                "Motorizzazione"
                            ],
                            "dependencies": "new1501151800359",
                            "properties": {}
                        },
                        "new1501152959579": {
                            "type": "string",
                            "required": true,
                            "dependencies": "new1501151800359",
                            "properties": {}
                        },
                        "new1501153050368": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "new1501159856161": {
                            "type": "string",
                            "required": false,
                            "dependencies": "new1501153050368",
                            "properties": {}
                        },
                        "new1501169626889": {
                            "items": {
                                "title": "",
                                "type": "object",
                                "properties": {
                                    "new1501162597354": {
                                        "readonly": false,
                                        "required": true,
                                        "disallow": [],
                                        "enum": [
                                        	"Seleziona",
                                            "Autoveicoli",
                                            "Rimorchi",
                                            "Motoveicoli",
                                            "Ciclomotori"
                                        ],
                                        "properties": {}
                                    },
                                    "new1501162600973": {
                                        "readonly": false,
                                        "required": true,
                                        "type": "string",
                                        "properties": {}
                                    }
                                }
                            },
                            "type": "array",
                            "properties": {},
                            "required": false
                        }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
	                    "new1501257778693": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Familiare",
	                        "helpers": [],
	                        "fieldClass": "text-center",
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [],
	                        "typeahead": {},
	                        "allowOptionalEmpty": true,
	                        "data": {},
	                        "autocomplete": "false",
	                        "disallowEmptySpaces": false,
	                        "disallowOnlyEmptySpaces": false,
	                        "fields": {}
	                    },
	                    "cognome": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "nome": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "readonly": false,
	                        "fields": {}
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
		                                    "fieldClass": "select2ac1",
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
		                        "statoEsteroSelezionato": {
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
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Data nascita (dd/mm/yyyy):",
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
	                    "sesso": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Sesso:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "F",
	                            "M"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "new1501143253415": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Stato civile",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Seleziona",
	                            "celibe/nubile",
	                            "coniugato/a",
	                            "vedovo/a",
	                            "unito/a civilmente",
	                            "divorziato/a"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "sort": false,
	                        "renderButtons": true,
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "cittadinanzaObject": {
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
                                    "validate": false,
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
	                    "new1501144110381": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Codice fiscale",
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
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "new1501254836085": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Rapporto di parentela con il richiedente",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        		"Seleziona",
	                                "Marito/moglie",
	            					"Figlio/figlia",
	            					"Nipote (figlio/a di figlio/a)",
	            					"Pronipote",
	            					"Padre/madre",
	            					"Nonno/nonna",
	            					"Bisnonno/bisnonna",
	            					"Fratello/sorella",
	            					"Nipote (figlio/a di fratello/sorella)",
	            					"Zio/zia",
	            					"Cugino/cugina",
	            					"Altro/a parente (fino al 6^grado)",
	            					"Figliastro/figliastra",
	            					"Patrigno/matrigna",
	            					"Genero/nuora",
	            					"Suocero/suocera",
	            					"Cognato/cognata",
	            					"Fratellastro/sorellastra",
	            					"Nipote (figlio/a di cognato/a)",
	            					"Zio/zia (marito/moglie di zio/a)",
	            					"Altro/a affine (fino al 6^ grado)",
	            					"Convivente in famiglia",
	            					"Responsabile di convivenza",
	            					"Membro di convivenza",
	            					"Convivente"
	                        ],
	                        "removeDefaultNone": true,
	            			"sort": false,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "renderButtons": true,
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "seioccupato": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Svolgi unâ€™attivitÃ  lavorativa?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "sort": false,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": false,
	                        "fields": {}
	                    },
	                    "posizioneprofessione": {
	                        "type": "radio",
	                        "dependencies": {
	                                "seioccupato": [
	                                    "Si"
	                                ]
	                        },
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Posizione nella professione:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Imprenditore/Libero professionista",
	                            "Dirigente/Impiegato",
	                            "Lavoratore in proprio",
	                            "Operaio e assimilati",
	                            "Coadiuvante"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "condizionenonprofessionale": {
	                        "type": "radio",
	                        "dependencies": {
	                                "seioccupato": [
	                                    "No"
	                                ]
	                        },            
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Condizione non professionale:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Casalinga",
	                            "Studente",
	                            "Disoccupato/in cerca di prima occupazione",
	                            "Pensionato/Ritirato dal lavoro",
	                            "Altra condizione non professionale",
	                            "Nessuna condizione"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "titolostudio": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Titolo di Studio:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Nessun titolo",
	                            "Analfabeta",
	                            "Terza elementare",
	                            "Quinta elementare",
	                            "Licenza elementare",
	                            "Licenza avv. prof. ",
	                            "Licenza media",
	                            "Diploma",
	                            "Laurea triennale",
	                            "Laurea",
	                            "Dottorato"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "new1501151800359": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Titolare di patente?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "new1501152489552": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Patente tipo",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Seleziona",
	                            "A",
	                            "A1",
	                            "A2",
	                            "AM",
	                            "Altro",
	                            "B",
	                            "B1",
	                            "BE",
	                            "C",
	                            "C1",
	                            "C1E",
	                            "CE",
	                            "CQC Merci",
	                            "CQC Persone",
	                            "D",
	                            "D1",
	                            "D1E",
	                            "DE",
	                            "KA",
	                            "KB",
	                            "Altro"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "dependencies": {
	                            "new1501151800359": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "altropatente": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "specifica altro",
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
	                            "new1501152489552": [
	                            	"Altro"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "numero": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Numero:",
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
	                        "readonly": false,
	                        "renderButtons": true,
	                        "attributes": {},
	                        "dependencies": {
	                            "new1501151800359": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "datarilascio": {
	                        "type": "date",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Data di rilascio:",
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
	                        "sort": false,
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
	                        "dependencies": {
	                            "new1501151800359": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "organorilascio": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Organo di rilascio:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Seleziona",
	                            "Prefettura",
	                            "Motorizzazione"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "dependencies": {
	                            "new1501151800359": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "new1501152959579": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Provincia di",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "dataSource": "@@customFieldDataSource/province/province.json",
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "sort": false,
	                        "renderButtons": true,
	                        "dependencies": {
	                            "new1501151800359": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "new1501153050368": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Hai veicoli intestati personalmente?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "new1501159856161": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Targhe veicoli immatricolati in Italia in qualitÃ  di proprietario/comproprietario, usufruttuario/Locatario",
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
	                        "dependencies": {
	                            "new1501153050368": [
	                                "Si"
	                            ]
	                        },
	                        "fields": {}
	                    },
	                    "new1501169626889": {
	                        "type": "dativeicolo",
	                        "dependencies": {
	                            "new1501153050368": [
	                                "Si"
	                            ]
	                        },                        
	                        "label": "",
	                        "helpers": [],
	                        "validate": true,
	                        "disabled": false,
	                        "showMessages": true,
	                        "collapsible": false,
	                        "legendStyle": "button",
	                        "toolbarStyle": "button",
	                        "toolbarSticky": true,
	                        "actionbarStyle": "top",
	                        "items": {
	                            "fields": {
	                                "new1501162597354": {
	                                    "type": "select",
	                                    "validate": true,
	                                    "showMessages": false,
	                                    "disabled": false,
	                                    "hidden": false,
	                                    "label": "Tipo veicolo",
	                                    "helpers": [],
	                                    "hideInitValidationError": false,
	                                    "focus": false,
	                                    "optionLabels": [
	                                    	"Seleziona",
	                                        "Autoveicoli",
	                                        "Rimorchi",
	                                        "Motoveicoli",
	                                        "Ciclomotori"
	                                    ],
	                                    "removeDefaultNone": true,
	                                    "noneLabel": "None",
	                                    "hideNone": true,
	                                    "useDataSourceAsEnum": true,
	                                    "multiple": false,
	                                    "sort": false,
	                                    "emptySelectFirst": false,
	                                    "multiselect": {
	                                        "disableIfEmpty": true
	                                    },
	                                    "readonly": false,
	                                    "renderButtons": true,
	                                    "fields": {}
	                                },
	                                "new1501162600973": {
	                                    "type": "text",
	                                    "validate": true,
	                                    "showMessages": false,
	                                    "disabled": false,
	                                    "hidden": false,
	                                    "label": "Targa",
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
	                                    "fields": {},
	                                    "readonly": false
	                                }
	                            }
	                        },
	                        "rubyrails": false,
	                        "hideToolbarWithChildren": true,
	                        "view": "dativeicolo-view",
	                        "fields": {}
	                    },
	                    "new1494931736686": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Consapevole delle responsabilita' penali per le dichiarazioni mendaci ai sensi degli art. 75 e 76 DPR 445/2000 che prevedono la decadenza dai benefici e l'obbligo di denuncia all'autorita' competente",
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
	                    }

	                }   
            	},
            	"view": "familiare-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Familiare (Servizio Residenza)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Familiare (Servizio Residenza)";
        }
    });

    
    
    Alpaca.registerFieldClass("datiFamiliare", Alpaca.Fields.DatiFamiliareField); 
    
    Alpaca.registerView({
        "id": "familiare-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": datiFamiliareResidenzaContainer,
        	"container-object": datiFamiliareResidenzaContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Familiare"
    }, "familiare-view");
    
})(jQuery);;var datiLoggatoCustomTwoColContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiLoggatoCustomTwoColContainerObject = ' \
	<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
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
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiLoggatoCustomTwoCol = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiLoggatoCustomTwoCol.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiLoggatoCustomTwoCol";
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
                         "nome": {
                             "title": "Nome",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "cognome": {
                             "title": "Cognome",
                             "type": "string",
                             "properties": {}
                         },
                         "codiceFiscale": {
                             "title": "Cod.Fiscale",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "dataNascita": {
                             "title": "Data di nascita",
                             "type": "string",
                             "properties": {}
                         },
                         "luogoNascita": {
                             "title": "Luogo di nascita",
                             "type": "string",
                             "properties": {}
                       },
                         "indirizzoResidenza":{
                        	 "title": "Indirizzo Residenza",
                             "type": "string",
                             "properties": {}
                         },
                         "viaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "civicoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "esponenteHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "scalaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "pianoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "internoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "capHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "provinciaResHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "comuneResHidden": {
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
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data di nascita",
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
                
                    "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo di residenza",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "viaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "civicoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "esponenteHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "scalaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "pianoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "internoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "capHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "provinciaResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "comuneResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    }             
                },
                "view": "datiLoggatoCustomTwoCol-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati utente loggato Custom (Due Colonne)";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati utente loggato Custom con layout a due colonne";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiLoggatoCustomTwoCol-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": datiLoggatoCustomTwoColContainer,
			"container-object": datiLoggatoCustomTwoColContainerObject
		}
    });
    Alpaca.registerFieldClass("datiLoggatoCustomTwoCol", Alpaca.Fields.DatiLoggatoCustomTwoCol); 
  
    
})(jQuery);;var datiNuovaResidenzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiNuovaResidenzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.datiNuovaResidenza = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.datiNuovaResidenza.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiNuovaResidenza";
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
                    "new1498745444389": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "new1501238454974": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1501238419606": {
                        "type": "number",
                        "required": true,
                        "properties": {}
                    },
                    "new1501238427880": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "nuovaresidenza-corte": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "nuovaresidenza-piano": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "nuovaresidenza-scala": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "nuovaresidenza-int": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "new1498745444389": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Dati nuova residenza",
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
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1501238454974": {
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
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1501238419606": {
                        "type": "number",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero civico",
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
                        "numericEntry": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1501238427880": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Esponente",
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
                    "nuovaresidenza-corte": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "corte",
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
                    "nuovaresidenza-piano": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "piano",
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
                    "nuovaresidenza-scala": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "scala",
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
                    "nuovaresidenza-int": {
                        "type": "text",
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
                    }
                },
                "view": "datiNuovaResidenza-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati nuova residenza";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati nuova residenza";
        }
    });

    Alpaca.registerView({
    	"id": "datiNuovaResidenza-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": datiNuovaResidenzaContainer,
    		"container-object": datiNuovaResidenzaContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiNuovaResidenza", Alpaca.Fields.datiNuovaResidenza);
    

})(jQuery);;var datiRecapitiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiRecapitiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.datiRecapiti = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.datiRecapiti.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiRecapiti";
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
                    "new1498817069821": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "provComune": {
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
                    "new1498816296553": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1498816377807": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1498816298791": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "new1498816307526": {
                        "type": "number",
                        "required": true,
                        "properties": {}
                    },
                    "new1498816314286": {
                        "type": "number",
                        "required": false,
                        "properties": {}
                    },
                    "new1498816319373": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "new1498816323502": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "new1498817069821": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Recapiti",
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
                    "provComune": {
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
                                "fields": {}
                            }
                        }
                    },
                    "new1498816296553": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Via/Piazza",
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
                    "new1498816377807": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Numero civico",
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
                    "new1498816298791": {
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
                        "fields": {}
                    },
                    "new1498816307526": {
                        "type": "number",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Telefono/Cellulare",
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
                        "numericEntry": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1498816314286": {
                        "type": "number",
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
                        "numericEntry": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "new1498816319373": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "E-mail",
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
                    "new1498816323502": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
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
                        "fields": {},
                        "renderButtons": true,
                        "attributes": {}
                    }
                },
                "view": "datiRecapiti-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati recapiti";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati recapiti";
        }
    });

    Alpaca.registerView({
    	"id": "datiRecapiti-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": datiRecapitiContainer,
    		"container-object": datiRecapitiContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiRecapiti", Alpaca.Fields.datiRecapiti);
    

})(jQuery);;var datiResidenteIscrittoContainer = ' \
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
    			                "statoEsteroSelezionato": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },                        
                        "select": {
                            "readonly": false,
                            "required": false,
                            "disallow": [],
                            "enum": [
                                "Non sussistono rapporti di coniugio, parentela, affinitÃ , adozione, tutela o vincoli affettivi con i componenti della famiglia giÃ  residente.",
                                "Sussiste il seguente vincolo rispetto al su indicato componente della famiglia giÃ  residente"
                            ],
                            "properties": {}
                        },
                        "vincolo": {
                            "readonly": false,
                            "required": false,
                            "disallow": [],
            				"dependencies": "select",
                            "enum": [
                                "Seleziona",
                                "Marito/moglie",
                                "Figlio/figlia",
                                "Nipote (figlio/a di figlio/a)",
                                "Pronipote",
                                "Padre/madre",
                                "Nonno/nonna",
                                "Bisnonno/bisnonna",
                                "Fratello/sorella",
                                "Nipote (figlio/a di fratello/sorella)",
                                "Zio/zia",
                                "Cugino/cugina",
                                "Altro/a parente (fino al 6^grado)",
                                "Figliastro/figliastra",
                                "Patrigno/matrigna",
                                "Genero/nuora",
                                "Suocero/suocera",
                                "Cognato/cognata",
                                "Fratellastro/sorellastra",
                                "Nipote (figlio/a di cognato/a)",
                                "Zio/zia (marito/moglie di zio/a)",
                                "Altro/a affine (fino al 6^ grado)",
                                "Convivente in famiglia",
                                "Responsabile di convivenza",
                                "Membro di convivenza",
                                "Convivente"
                            ],
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
                        "label": "Residente giÃ  iscritto",
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
                        "rightLabel": "Nell'abitazione sono giÃ  iscritte le seguenti persone (Ã¨ sufficiente specificare le generalitÃ  di un componente della famiglia) "
                    },
    				"new1548676046129": {
    					"type": "label",
    					"validate": false,
    					"showMessages": true,
    					"disabled": false,
    					"hidden": false,
    					"helpers": [
    						"ATTENZIONE: anche l'intestatario della scheda di famiglia a cui si aggrega/si aggregano deve firmare la richiesta e allegare il proprio documento di riconoscimento"
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
	                                    "fieldClass": "select2ac1",
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
	                        "statoEsteroSelezionato": {
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
                            "Non sussistono rapporti di coniugio, parentela, affinitÃ , adozione, tutela o vincoli affettivi con i componenti della famiglia giÃ  residente.",
                            "Sussiste il seguente vincolo rispetto al suindicato componente della famiglia giÃ  residente"
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
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Seleziona",
                            "Marito/moglie",
                            "Figlio/figlia",
                            "Nipote (figlio/a di figlio/a)",
                            "Pronipote",
                            "Padre/madre",
                            "Nonno/nonna",
                            "Bisnonno/bisnonna",
                            "Fratello/sorella",
                            "Nipote (figlio/a di fratello/sorella)",
                            "Zio/zia",
                            "Cugino/cugina",
                            "Altro/a parente (fino al 6^grado)",
                            "Figliastro/figliastra",
                            "Patrigno/matrigna",
                            "Genero/nuora",
                            "Suocero/suocera",
                            "Cognato/cognata",
                            "Fratellastro/sorellastra",
                            "Nipote (figlio/a di cognato/a)",
                            "Zio/zia (marito/moglie di zio/a)",
                            "Altro/a affine (fino al 6^ grado)",
                            "Convivente in famiglia",
                            "Responsabile di convivenza",
                            "Membro di convivenza",
                            "Convivente"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
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
                                "Sussiste il seguente vincolo rispetto al su indicato componente della famiglia giÃ  residente"
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
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": datiResidenteIscrittoContainer,
    		"container-object": datiResidenteIscrittoContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiResidenteIscritto", Alpaca.Fields.datiResidenteIscritto);
    

})(jQuery);;var dativeicoloContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var dativeicoloContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
	<div class="row"> \
		<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
	</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DativeicoloField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DativeicoloField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "dativeicolo";
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
    	                "new1501162597354": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "enum": [
    	                    	"Seleziona",
	                            "Autoveicoli",
	                            "Rimorchi",
	                            "Motoveicoli",
	                            "Ciclomotori"
    	                    ],
    	                    "properties": {}
    	                },
    	                "new1501162600973": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
	                    "new1501162597354": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Tipo veicolo",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Seleziona",
	                            "Autoveicoli",
	                            "Rimorchi",
	                            "Motoveicoli",
	                            "Ciclomotori"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "sort": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "new1501162600973": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Targa",
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
	                        "fields": {},
	                        "readonly": false
	                    }
	                }   
            	},
            	"view": "dativeicolo-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati veicolo";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati veicolo";
        }
    });

    
    
    Alpaca.registerFieldClass("dativeicolo", Alpaca.Fields.DativeicoloField); 
    
    Alpaca.registerView({
        "id": "dativeicolo-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": dativeicoloContainer,
        	"container-object": dativeicoloContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi veicolo"
    }, "dativeicolo-view");
    
})(jQuery);;var dichiarazioniFormScolasticiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var dichiarazioniFormScolasticiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-1" style="margin-top: -5px">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-11">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	</div> \
    </div> \
</script>';

var datiDichiarazioni = {};

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DichiarazioniFormScolasticiField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DichiarazioniFormScolasticiField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "dichiarazioniFormScolastici";
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

    	                    	"checkDichiarazione": {
    	                            "type": "boolean",
    	                            "required": false,
    	                            "properties": {}
    	                        },
    	    	                "testoDichiarazione": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	                         "hiddenIdDichiarazione": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         },
    	                         "hiddenAnnoScolastico": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
            		"fieldClass": "noBorderContainers",
	                "fields": {

			                   	 "checkDichiarazione": {
			                         "type": "checkbox",
			                         "fields": {},
			                         "helpers": [],
			                         "multiple": false,
			                         "data": false,
			                         "disabled": false,
			                         "validate": true,
			                         "showMessages": true,
			                         "renderButtons": true,

	    	                         "events": {
	    	                             "ready": function(){
											 this.getControlEl().find("input")[0].id = "dichiarazioneCheckabile";  	                             	 					
	    	                             }


	    	                         }
			                     },
	    	                     "testoDichiarazione": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "helpers": [],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "fields": {},
	    	                         "view": "bootstrap-display",
			                         "validator": function(callback) {
										var currentCheck = this.parent.childrenByPropertyId['checkDichiarazione'];
										var currentValue = currentCheck.getValue();
    	                             	 var currentLastId = currentCheck.getControlEl().find("input")[0].id;
			                             var valueObb = datiDichiarazioni[currentLastId];
			                             if (valueObb && !currentValue) {
			                                 callback({
			                                     "status": false,
			                                     "message": "Scelta Obbligatoria."
			                                 });
			                             } else {
			                                 callback({
			                                     "status": true
			                                 });
			                             }
			                         }

	    	                     },
	    	                     "hiddenIdDichiarazione": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenAnnoScolastico": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "fieldClass": "annoScolasticoDichiarazioneCss",
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     }
	                }

            	},
                "hidden": false,
                "animate": true,
                "helpers": [],
                "toolbar": {
                    "actions": [
                        {
                            "action": "add",
                            "enabled": false
                        }
                    ]
                },
                "disabled": false,
                "validate": true,
                "collapsed": false,
                "rubyrails": false,
                "collapsible": false,
                "hideToolbar": true,
                "lazyLoading": false,
                "legendStyle": "button",
                "optionLabels": [],
                "showMessages": true,
                "toolbarStyle": "button",
                "hideActionbar": true,
                "toolbarSticky": false,
                "actionbarStyle": "top",
                "hideInitValidationError": false,
                "hideToolbarWithChildren": true,
            	"view": "dichiarazioniformscolastici-view",
            	"events": {
                    "ready": function(){
                        var currentDichiarazioni = $("input[id='dichiarazioneCheckabile']");
                        var count = 0;
                        var annoScolasticoDichiarazioni = $($('.annoScolasticoDichiarazioneCss')[0]).alpaca("get").data;
    					$.ajax({
		                    url: listaDichiarazioniFormScolasticiUrl+ '&annoScolastico=' + annoScolasticoDichiarazioni,
		                    dataType: 'json',
		                    delay: 250,
		                    success: function (data) {
		                        currentDichiarazioni.each(
                                    function(element) {
                                        var idCurrentDichiarazione = "dichiarazioneCheckabile" + data[count].id;
                                 	    this.id = idCurrentDichiarazione;
                                 	    datiDichiarazioni[idCurrentDichiarazione] = data[count].obbligatorio;
                                 	    count++;
                                    });

                                }
	                   });                        
                        
                        
                    }
            	}
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dichiarazioni form scolastici";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dichiarazioni form scolastici per elenco moduli";
        }
    });

    Alpaca.registerView({
    	"id": "dichiarazioniformscolastici-view",
    	"parent": "bootstrap-create",
    	 "messages": {
    	        "notOptional": " ",
    	        "disallowValue": " "

    	 },
    	"templates": {
    		"container": dichiarazioniFormScolasticiContainer,
    		"container-object": dichiarazioniFormScolasticiContainerObject
    	}
    });
    Alpaca.registerFieldClass("dichiarazioniFormScolastici", Alpaca.Fields.DichiarazioniFormScolasticiField);
    
})(jQuery);;var dietaScuolaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var dietaScuolaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    
    Alpaca.Fields.DietaScuolaSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DietaScuolaSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "dietaScuolaSelect";
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
                         "sceltaDieta": {
                             "required": true,
                             "enum": ["Normale", "Etico-Religiosa", "Speciale"],
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "sceltaDieta": {
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
                        "fields": {},
                        "events": {
                            "change": function() {
                                console.log("in change");
                                
                                var campoDieta = this;
                                var tipoDieta = this.getValue();
								
                                var checkAllegato = $("div.cmd").find("input");
                                 if (checkAllegato.length == 0) {
                                	 campoDieta.options.disabled = true;
                                	 campoDieta.options.helpers = ["Si Ã¨ verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                	 campoDieta.refresh();
                                	 campoDieta.getControlEl().val('');

                                 } else {
                                
		                             if(tipoDieta == "Speciale"){
		                            	 checkAllegato[0].checked = true;
		                             } else {
		                            	 checkAllegato[0].checked = false;
		                             }
                                 }
                             }
                         }
                    }
                
                },
                "view": "dietaScuolaSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Select scelta dieta";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Select di scelta Dieta che rende allegato obbligatorio per dieta speciale";
        }
    });
   
    Alpaca.registerView({
	  	"id": "dietaScuolaSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Selezionare una delle opzioni."
	    },
		"templates": {
			"container": dietaScuolaContainer,
			"container-object": dietaScuolaContainerObject
		}
    });
    Alpaca.registerFieldClass("dietaScuolaSelect", Alpaca.Fields.DietaScuolaSelect); 
  
    
})(jQuery);;var anniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anniContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.AnniSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.AnniSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "anniSelect";
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
                         "anni": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "anni": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "helpers": ["(yyyy)"],
                        "dataSource": listaYearsUrl,
                        "label": "Anno: ",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "fields": {}
                    }
                
                },
                "view": "anniSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Anni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Anni dal 1950 Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "anniSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": anniContainer,
			"container-object": anniContainerObject
		}
    });
    Alpaca.registerFieldClass("anniSelect", Alpaca.Fields.AnniSelect); 
  
    
})(jQuery);;var cinqueAnniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var cinqueAnniContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.CinqueAnniSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CinqueAnniSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "cinqueAnniSelect";
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
                         "cinqueAnni": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "cinqueAnni": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "helpers": ["(yyyy)"],
                        "dataSource": listaFiveYearsUrl,
                        "label": "Anno: ",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "fields": {}
                    }
                
                },
                "view": "cinqueAnniSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Ultimi Cinque Anni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Ultimi 5 anni Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "cinqueAnniSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": cinqueAnniContainer,
			"container-object": cinqueAnniContainerObject
		}
    });
    Alpaca.registerFieldClass("cinqueAnniSelect", Alpaca.Fields.CinqueAnniSelect); 
  
    
})(jQuery);;var elencoSceltaMinoriRipetibileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoSceltaMinoriRipetibileContainerObject = ' \
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
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoSceltaMinoriRipetibile = Alpaca.Fields.ArrayField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoSceltaMinoriRipetibile.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ArrayField#getFieldType
		 */
        getFieldType: function() {
            return "elencoSceltaMinoriRipetibile";
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
	                    "labelScegliScuola": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },
	                    "customScuolaFuoriBacino": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "dependencies": {
        	                    "istitutoComprensivo": [
        	                        "scuolaFuoriBacino"
        	                    ], 
                    			"labelDescIstitutoComprensivo": [
        	                        "scuolaFuoriBacino"
        	                    ]
        	                },
                            "properties": {
                                "scuolaFuoriBacino": {
                                    "required": false,
                                    "properties": {}
                                },
                                "istitutoComprensivo": {
                                    "required": true,
                                    "enum": [
                                        "SI",
                                        "NO"
                                    ],
                                    "properties": {}
                                },
        	                    "labelDescIstitutoComprensivo": {
        	                        "type": "string",
        	                        "required": false,
        	                        "properties": {}
        	                    }
                            }
                        },
                        "customScuolaBacRegolare": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "scuolaBacinoRegolare": {
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
                        "customScuolaBacinoPeg": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "scuolaBacinoPeg": {
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
	                    "labelScuolaScelta": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },
                        "nomeScuola": {
                            "title": "Nome Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "plessoScuola": {
                            "title": "Plesso Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "tipologiaScuola": {
                            "title": "Grado Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "indirizzoScuola": {
                            "title": "Indirizzo Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "comuneProvinciaScuola": {
                            "title": "Luogo Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "tempoPieno": {
                            "required": true,
                            "enum": [
                                "SI",
                                "NO"
                            ],
                            "disallow": [
                                "NO"
                            ],
                            "properties": {}
                        },
                        "annotazioni": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "idScuola": {
                            "type": "string",
                            "required": true,
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
                                    "fieldClass": "text-center",
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
                        "labelScegliScuola": {
                            "type": "label",
                            "label": "<p style='text-align: center'>Seleziona scuola del bacino di appartenenza:</p>",
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
                        "customScuolaFuoriBacino": {
                            "type": "elencoScuoleFuoriBacAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleFuoriBacAutoCompleteSelect-view",
                            "fields": {
                                "scuolaFuoriBacino": {
                                    "fieldClass": "select2ac1 scuolaBacinoSelect scuolaFuoriBacinoSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Fuori Bacino:",
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
                                "istitutoComprensivo": {
                                    "type": "radio",
                                    "label": "Istituto Comprensivo:",
                                    "helpers": [],
                                    "fieldClass": "text-left",
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "hideInitValidationError": false,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": true,
                                    "emptySelectFirst": false,
                                    "vertical": false,
                                    "removeDefaultNone": true,
                                    "hideNone": true,
                                    "sort": false,
                                    "optionLabels": [
                                        "SI",
                                        "NO"
                                    ],
                                    "fields": {}
                                },
                                "labelDescIstitutoComprensivo": {
                                    "type": "label",
                                    "label": "<p style='text-align: left'ISTITUTO COMPRENSIVO: indicare se la scuola da frequentare per l'a.s. indicato appartiene allo stesso Istituto Comprensivo frequentato negli anni scolastici precedenti. La dichiarazione sarÃ  sottoposta a verifica presso le scuole indicate. In tal caso, saranno applicate le tariffe relative agli utenti appartenenti al bacino.</p>",
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
                                }
                            }
                        },
                        "customScuolaBacRegolare": {
                            "type": "elencoScuoleBacRegAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleBacRegAutoCompleteSelect-view",
                            "fields": {
                                "scuolaBacinoRegolare": {
                                    "fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoRegolareSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Bacino Regolare:",
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
                                }
                            }
                        },
                        "customScuolaBacinoPeg": {
                            "type": "elencoScuoleBacPegAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleBacPegAutoCompleteSelect-view",
                            "fields": {
                                "scuolaBacinoPeg": {
                                    "fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoPegSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Bacino Regolare e Inferiore:",
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
                                }
                            }
                        },
                        "labelScuolaScelta": {
                            "type": "label",
                            "label": "<p style='text-align: center'>Scuola Selezionata:</p>",
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
                        },
                        "idScuola": {
                            "type": "text",
                            "disabled": true,
                            "hidden": true,
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": false,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        }
                    },
                    "events": {
                    	"ready": function(){
                    		var self = this;
                    		$.ajax({
			                    url: checkResidenteUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
		                        },
			                    success: function (data) {
			                    	console.log("eseguita checkResidenteUrl, valore check:" + data.checkResponse);
			                    	var selectBPeg = self.childrenByPropertyId['customScuolaBacinoPeg'];
			                    	var selectBR = self.childrenByPropertyId['customScuolaBacRegolare'];
			                    	
			                    	if(data.checkResponse == false){
			                    		if( selectBPeg ) {
				                    		selectBPeg.options.hidden = true;
				                    	}
			                    		if( selectBR ) {
			                    			selectBR.options.hidden = true;
				                    	}
			                    	} else {
			                    		if( selectBPeg && opPeg ) {
				                    		selectBPeg.options.hidden = false;
				                    	}
			                    		if( selectBR ) {
			                    			selectBR.options.hidden = false;
				                    	}
			                    	}
			                    	selectBR.refresh();
			                    	selectBPeg.refresh();
			                    },
			                    error: function () {	
			                    	console.log("error");
	                            }
                    		});
                         }                    
                    },
                    "type": "object",
                    "validate": true,
                    "showMessages": true,
                    "collapsible": false,
                    "legendStyle": "button"
                },
                "rubyrails": false,
                "view": "elencoSceltaMinoriRipetibile-view"
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
            return "Scelta minori da iscrivere a servizio trasporti con elenco scuole dei bacini";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoSceltaMinoriRipetibile-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	
	    },
		"templates": {
			"container": elencoSceltaMinoriRipetibileContainer,
			"container-object": elencoSceltaMinoriRipetibileContainerObject
		},
		"fields": {}
    });
    Alpaca.registerFieldClass("elencoSceltaMinoriRipetibile", Alpaca.Fields.ElencoSceltaMinoriRipetibile); 
  
    
})(jQuery);;var elencoSceltaMinoriRipetibileNoBaciniContainer = ' \
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
                            "disallow": [
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
                                    "fieldClass": "text-center",
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
  
    
})(jQuery);;var elencoScuoleBacPegAutoCompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleBacPegAutoCompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleBacPegAutoCompleteSelect";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "properties": {
            	        "scuolaBacinoPeg": {
            	            "required": false,
            	            "properties": {}
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaBacinoPeg": {
                    	"fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoPegSelect",
                        "type": "select",
                        "label": "Scuola Bacino Inferiore:",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  placeholder: "-- Seleziona --",
					                  ajax: {
					                    url: listaScuolePegComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
				                        },
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	if(idScuola){
	                        		var	infoScuolaDependentUrl = infoScuolaBacinoByIdUrl + idScuola;
		                        	$.ajax({
					                    url: infoScuolaDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    success: function (data) {
					                    	
					                    	var selectBRId = self.parent.parent.childrenByPropertyId['customScuolaBacRegolare'].childrenByPropertyId['scuolaBacinoRegolare'].id;
					                    	if( selectBRId ) {
					                    		$('#' + selectBRId).val(null).trigger('change');
					                    	}
					                    	var selectFBId = self.parent.parent.childrenByPropertyId['customScuolaFuoriBacino'].childrenByPropertyId['scuolaFuoriBacino'].id;
					                    	if( selectFBId ) {
					                    		$('#' + selectFBId).val(null).trigger('change');
					                    	}
					                    	
					                    	var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
					                    	campoNomeScuola.getControlEl().val(data.denominazione);
					                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
					                    	campoPlessoScuola.getControlEl().val(data.plesso);
					                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
					                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
					                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
					                    	campoTipologiaScuola.getControlEl().val(data.grado);
					                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
					                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
					                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
					                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata del bacino inferiore</p>";
					                    	labelBacinoDiAppartenenza.refresh();
					                    }
		                            });	
	                        	}
	                        	
	                        }
                        
                        }
                    }
                },
                "view": "elencoScuoleBacPegAutoCompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Bacino Inferiore con Autocomplete";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola Bacino Inferiore di appartenenza con autocomplete in ricerca. Riservato Operatore Peg";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleBacPegAutoCompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleBacPegAutoCompleteSelectContainer,
			"container-object": elencoScuoleBacPegAutoCompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleBacPegAutoCompleteSelect", Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect); 
  
    
})(jQuery);;var elencoScuoleBacRegAutoCompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleBacRegAutoCompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleBacRegAutoCompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleBacRegAutoCompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleBacRegAutoCompleteSelect";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "properties": {
            	        "scuolaBacinoRegolare": {
            	            "required": false,
            	            "properties": {}
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaBacinoRegolare": {
                    	"fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoRegolareSelect",
                        "type": "select",
                        "label": "Scuola Bacino Regolare:",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumResultsForSearch: -1,
					                  width: "100%",
					                  placeholder: "-- Seleziona --",
					                  ajax: {
					                    url: listaScuoleBRgByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
				                        },
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	if(idScuola){
		                        	var	infoScuolaDependentUrl = infoScuolaBacinoByIdUrl + idScuola;
		                        	$.ajax({
					                    url: infoScuolaDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    success: function (data) {
					                    	
					                    	var selectFBId = self.parent.parent.childrenByPropertyId['customScuolaFuoriBacino'].childrenByPropertyId['scuolaFuoriBacino'].id;
					                    	if( selectFBId ) {
					                    		$('#' + selectFBId).val(null).trigger('change');
					                    	}
					                    	var selectBPegId = self.parent.parent.childrenByPropertyId['customScuolaBacinoPeg'].childrenByPropertyId['scuolaBacinoPeg'].id;
					                    	if( selectBPegId ) {
					                    		$('#' + selectBPegId).val(null).trigger('change');
					                    	}
					                    	
					                    	var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
					                    	campoNomeScuola.getControlEl().val(data.denominazione);
					                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
					                    	campoPlessoScuola.getControlEl().val(data.plesso);
					                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
					                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
					                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
					                    	campoTipologiaScuola.getControlEl().val(data.grado);
					                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
					                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
					                    	var campoIdScuola = self.parent.parent.childrenByPropertyId['idScuola'];
					                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
					                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
					                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata del bacino di appartenenza</p>";
					                    	labelBacinoDiAppartenenza.refresh();
					                    }
		                            });
	                        	}

	                        }
                        }
                    }
                },
                "view": "elencoScuoleBacRegAutoCompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Bacino Regolare con Autocomplete";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola Bacino Regolare di appartenenza con autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleBacRegAutoCompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleBacRegAutoCompleteSelectContainer,
			"container-object": elencoScuoleBacRegAutoCompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleBacRegAutoCompleteSelect", Alpaca.Fields.ElencoScuoleBacRegAutoCompleteSelect); 
  
    
})(jQuery);;var elencoScuoleCompletoAutocompleteSelect2RipetibileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleCompletoAutocompleteSelect2RipetibileContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2Ripetibile = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2Ripetibile.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleCompletoAutocompleteSelect2Ripetibile";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
                        },
                        "labelScuoleAlternative": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
            	        "scuoleAlternative": {
            	            "readonly": false,
            	            "required": false,
            	            "type": "array",
            	            "items": {
            	                "type": "object",
            	                "properties": {
            	                    "scuolaAlt": {
            	                        "required": false,
            	                        "properties": {}
            	                    },
                        	        "nomeScuolaAlt": {
                                        "title": "Nome Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "plessoScuolaAlt": {
                                        "title": "Plesso Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "tipologiaScuolaAlt": {
                                        "title": "Grado",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "indirizzoScuolaAlt": {
                                        "title": "Indirizzo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "comuneProvinciaScuolaAlt": {
                                        "title": "Luogo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    }

            	                },
            	                "required": false
            	            },
            	            "uniqueItems": false
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaPrincipale": {
                    	"fieldClass": "select2ac1 text-center",
                        "type": "select",
                        "label": "Scuola Principale:",
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
                        "fields": {},
                        "events": {
                            "click": function(){
                                var self = this;
                                var allOptions = $("option", self.getControlEl());
                                allOptions.attr("disabled", false);
                                allOptions.css("color", "black"); 
                                var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                allSelectButThis.each(function() {
									var idScuola = this.value;
									var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
									optionToDisable.attr("disabled", true);
									optionToDisable.css("color", "lightgrey");
	                            });
                            },
                        	"ready": function(){
                        		var self = this;
	                        	$.ajax({
				                    url: numeroMaxScuoleAlternativeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoLabelAlternative = self.parent.childrenByPropertyId['labelScuoleAlternative'];
				                    	var campoScuoleAlternative = self.parent.childrenByPropertyId['scuoleAlternative'];
				                    	campoLabelAlternative.options.helpers = ["Sono consentite al massimo " + data + " scelte alternative."],
				                    	campoScuoleAlternative.schema.maxItems = data;
				                    	campoLabelAlternative.refresh();
				                    	campoScuoleAlternative.refresh();
				                    }
	                            });
	                        	
	                        	
                        		try{
                        			var codiceAnnoScolastico = this.parent.parent.childrenByPropertyId['annoScolasticoCorrenteObject'].childrenByPropertyId['annoScolasticoCorrente'].getControlEl().val();
                        			console.log("codiceAnnoScolastico=" + codiceAnnoScolastico);
                        			listaScuoleByComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;
                        			
                        		}catch(err) {
                        			  console.log("Errore nel recupero anno scolastico" + err.message);
                        		}
                        		
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  ajax: {
					                    url: listaScuoleByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
	                        	
	                        	
                             },                       	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();		                        
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);	                   
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    },
                    "labelScuoleAlternative": {
                        "type": "label",
                        "label": "Scuole alternative: ",
                        "helpersPosition": "below",
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
                    "scuoleAlternative": {
                        "fieldClass": "text-left",
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
                                    "label": "Aggiungi Scuola"
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
                                    "label": "Rimuovi Scuola"
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
                                "scuolaAlt": {
                                	"fieldClass": "select2ac1 text-center",
                                    "type": "select",
                                    "label": "Scuola Alternativa:",
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
                                    "fields": {},
                                    "events": {
                                    	"ready": function(){
                                    		
                                    		this.getControlEl().select2({
            					                  theme: "classic",
            					                  language: "it",
            					                  minimumInputLength: 3,
            					                  width: "100%",
            					                  ajax: {
            					                    url: listaScuoleByComuneUrl,
            					                    dataType: 'json',
            					                    delay: 250,
            					                    timeout: 3000,
            					                    data: function (params) {
            					                      return {
            					                        q: params.term, // search term
            					                        page: params.page
            					                      };
            					                    },
            					                    error: function () {	
            					                    	console.log("error");
            			                            },
            			                            success: function (data) {
            					                    	console.log("success");
            			                            },
            			                            complete: function () {
            					                    	console.log("complete");
            			                            },
            					                    processResults: function (data) {
            					                        var items = $.map(data, function (obj) {
            					                          obj.id = obj.value;
            	                                          obj.text = obj.text;
            					                          return obj;
            					                        });
            					                        
            					                        return {
            					                            results: items
            					                        };
            					                    },
            					                    cache: true
            					                  }
            					          });
                                    	},
                                        "click": function(){
                                            var self = this;
                                            var allOptions = $("option", self.getControlEl());
                                            allOptions.attr("disabled", false);
                                            allOptions.css("color", "black"); 
                        	                   var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                                 allSelectButThis.each(
                                                     function() {
                                                        var idScuola = this.value;
                                                        var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
                                                         optionToDisable.attr("disabled", true);
                                                         optionToDisable.css("color", "lightgrey");

                                                     }
                                                );
                                        },
            	                        "change": function() {
            	                        	var self = this;
            	                        	var idScuola = this.getValue();
            	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
            	                        	$.ajax({
            				                    url: infoScuolaDependentUrl,
            				                    dataType: 'json',
            				                    delay: 250,
            				                    success: function (dataAlt) {
            				                    	var campoNomeScuolaAlt = self.parent.childrenByPropertyId['nomeScuolaAlt'];
            				                    	campoNomeScuolaAlt.getControlEl().val(dataAlt.denominazione);
            				                    	var campoPlessoScuolaAlt = self.parent.childrenByPropertyId['plessoScuolaAlt'];
            				                    	campoPlessoScuolaAlt.getControlEl().val(dataAlt.plesso);
            				                    	var campoIndirizzoScuolaAlt = self.parent.childrenByPropertyId['indirizzoScuolaAlt'];
            				                    	campoIndirizzoScuolaAlt.getControlEl().val(dataAlt.indirizzo);
            				                    	var campoTipologiaScuolaAlt = self.parent.childrenByPropertyId['tipologiaScuolaAlt'];
            				                    	campoTipologiaScuolaAlt.getControlEl().val(dataAlt.grado);
            				                    	var campoComuneProvinciaScuolaAlt = self.parent.childrenByPropertyId['comuneProvinciaScuolaAlt'];
            				                    	campoComuneProvinciaScuolaAlt.getControlEl().val(dataAlt.nomeComuneProv);
            				                   
            				                    }
            																									
            	                            });
            	                        }
                                    
                                    }
                                },
                                "nomeScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Scuola: ",
                                    "renderButtons": true
                                },
                                "plessoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Plesso: ",
                                    "renderButtons": true
                                },
                                "tipologiaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Grado: ",
                                    "renderButtons": true
                                },
                                "indirizzoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Indirizzo: ",
                                    "renderButtons": true
                                },
                                "comuneProvinciaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Comune: ",
                                    "renderButtons": true
                                }

                            },
                            "type": "object",
                            "validate": true,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button"
                        },
                        "rubyrails": false
                    }
                },
                "view": "elencoScuoleCompletoAutocompleteSelect2Ripetibile-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Custom";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale e alternative con select2 con autocomplete";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleCompletoAutocompleteSelect2Ripetibile-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Non Ã¨ possibile selezionare piÃ¹ volte la stessa scuola."
	
	    },
		"templates": {
			"container": elencoScuoleCompletoAutocompleteSelect2RipetibileContainer,
			"container-object": elencoScuoleCompletoAutocompleteSelect2RipetibileContainerObject
		},
		"fields": {
	        "/scuoleAlternative": {
	            "parent": "bootstrap-edit",
	            "messages": {
	                "disallowValue": "Non Ã¨ possibile selezionare piÃ¹ volte la stessa scuola."
	
	            },
	            "templates": {
	                "container": "<div>{{#container}}{{/container}}</div>",
	                "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div></div></div>"
	            }
	        }
	    }
    });
    Alpaca.registerFieldClass("elencoScuoleCompletoAutocompleteSelect2Ripetibile", Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2Ripetibile); 
  
    
})(jQuery);;var elencoScuoleCompletoSelectRipetibileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleCompletoSelectRipetibileContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleCompletoSelectRipetibile";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
                        "labelScuoleAlternative": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
            	        "scuoleAlternative": {
            	            "readonly": false,
            	            "required": false,
            	            "type": "array",
            	            "items": {
            	                "type": "object",
            	                "dependencies": {
            	                    "nomeScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "plessoScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "indirizzoScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "tipologiaScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "comuneProvinciaScuolaAlt": [
            	                        "scuolaAlt"
            	                    ]
            	                },
            	                "properties": {
            	                    "scuolaAlt": {
            	                        "required": false,
            	                        "properties": {}
            	                    },
                        	        "nomeScuolaAlt": {
                                        "title": "Nome Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "plessoScuolaAlt": {
                                        "title": "Plesso Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "tipologiaScuolaAlt": {
                                        "title": "Grado",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "indirizzoScuolaAlt": {
                                        "title": "Indirizzo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "comuneProvinciaScuolaAlt": {
                                        "title": "Luogo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    }

            	                },
            	                "required": false
            	            },
            	            "uniqueItems": false
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaPrincipale": {
                        "dataSource": listaScuoleByComuneUrl,
                        "type": "select",
                        "label": "Scuola Principale:",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "fieldClass": "select2ac1",
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
                        "fields": {},
                        "events": {
                            "click": function(){
                                var self = this;
                                var allOptions = $("option", self.getControlEl());
                                allOptions.attr("disabled", false);
                                allOptions.css("color", "black"); 
                                var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                allSelectButThis.each(function() {
									var idScuola = this.value;
									var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
									optionToDisable.attr("disabled", true);
									optionToDisable.css("color", "lightgrey");
	                            });
                            },
                        	"ready": function(){
                        		var self = this;
	                        	$.ajax({
				                    url: numeroMaxScuoleAlternativeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoLabelAlternative = self.parent.childrenByPropertyId['labelScuoleAlternative'];
				                    	var campoScuoleAlternative = self.parent.childrenByPropertyId['scuoleAlternative'];
				                    	campoLabelAlternative.options.helpers = ["Sono consentite al massimo " + data + " scelte alternative."],
				                    	campoScuoleAlternative.schema.maxItems = data;
				                    	campoLabelAlternative.refresh();
				                    	campoScuoleAlternative.refresh();
				                    }
	                            });
                             },                       	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();		                        
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);	                   
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    },
                    "labelScuoleAlternative": {
                        "type": "label",
                        "label": "Scuole alternative: ",
                        "helpersPosition": "below",
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
                    "scuoleAlternative": {
                        "fieldClass": "text-left",
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
                                    "label": "Aggiungi Scuola"
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
                                    "label": "Rimuovi Scuola"
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
                                "scuolaAlt": {
                                    "dataSource": listaScuoleByComuneUrl,
                                    "type": "select",
                                    "label": "Scuola Alternativa:",
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
                                    "fields": {},
                                    "events": {
                                        "click": function(){
                                            var self = this;
                                            var allOptions = $("option", self.getControlEl());
                                            allOptions.attr("disabled", false);
                                            allOptions.css("color", "black"); 
                        	                   var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                                 allSelectButThis.each(
                                                     function() {
                                                        var idScuola = this.value;
                                                        var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
                                                         optionToDisable.attr("disabled", true);
                                                         optionToDisable.css("color", "lightgrey");

                                                     }
                                                );
                                        },
            	                        "change": function() {
            	                        	var self = this;
            	                        	var idScuola = this.getValue();
            	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
            	                        	$.ajax({
            				                    url: infoScuolaDependentUrl,
            				                    dataType: 'json',
            				                    delay: 250,
            				                    success: function (dataAlt) {
            				                    	var campoNomeScuolaAlt = self.parent.childrenByPropertyId['nomeScuolaAlt'];
            				                    	campoNomeScuolaAlt.getControlEl().val(dataAlt.denominazione);
            				                    	var campoPlessoScuolaAlt = self.parent.childrenByPropertyId['plessoScuolaAlt'];
            				                    	campoPlessoScuolaAlt.getControlEl().val(dataAlt.plesso);
            				                    	var campoIndirizzoScuolaAlt = self.parent.childrenByPropertyId['indirizzoScuolaAlt'];
            				                    	campoIndirizzoScuolaAlt.getControlEl().val(dataAlt.indirizzo);
            				                    	var campoTipologiaScuolaAlt = self.parent.childrenByPropertyId['tipologiaScuolaAlt'];
            				                    	campoTipologiaScuolaAlt.getControlEl().val(dataAlt.grado);
            				                    	var campoComuneProvinciaScuolaAlt = self.parent.childrenByPropertyId['comuneProvinciaScuolaAlt'];
            				                    	campoComuneProvinciaScuolaAlt.getControlEl().val(dataAlt.nomeComuneProv);
            				                   
            				                    }
            																									
            	                            });
            	                        }
                                    
                                    }
                                },
                                "nomeScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Scuola: ",
                                    "renderButtons": true
                                },
                                "plessoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Plesso: ",
                                    "renderButtons": true
                                },
                                "tipologiaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Grado: ",
                                    "renderButtons": true
                                },
                                "indirizzoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Indirizzo: ",
                                    "renderButtons": true
                                },
                                "comuneProvinciaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Comune: ",
                                    "renderButtons": true
                                }

                            },
                            "type": "object",
                            "validate": true,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button"
                        },
                        "rubyrails": false
                    }
                },
                "view": "elencoScuoleCompletoSelectRipetibile-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Custom";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale e alternative";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleCompletoSelectRipetibile-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Non Ã¨ possibile selezionare piÃ¹ volte la stessa scuola."
	
	    },
		"templates": {
			"container": elencoScuoleCompletoSelectRipetibileContainer,
			"container-object": elencoScuoleCompletoSelectRipetibileContainerObject
		},
		"fields": {
	        "/scuoleAlternative": {
	            "parent": "bootstrap-edit",
	            "messages": {
	                "disallowValue": "Non Ã¨ possibile selezionare piÃ¹ volte la stessa scuola."
	
	            },
	            "templates": {
	                "container": "<div>{{#container}}{{/container}}</div>",
	                "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div></div></div>"
	            }
	        }
	    }
    });
    Alpaca.registerFieldClass("elencoScuoleCompletoSelectRipetibile", Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile); 
  
    
})(jQuery);;var elencoScuoleCompletoSelectSingoloContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleCompletoSelectSingoloContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleCompletoSelectSingolo = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleCompletoSelectSingolo.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleCompletoSelectSingolo";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
                        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaPrincipale": {
                        "dataSource": listaScuoleByComuneUrl,
                        "type": "select",
                        "label": "Scuola:",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "fieldClass": "select2ac1",
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
                        "fields": {},
                        "events": {                      	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);	                   
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    }
                },
                "view": "elencoScuoleCompletoSelectSingolo-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole e Info";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale di iscrizione con info relative";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleCompletoSelectSingolo-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni."
	
	    },
		"templates": {
			"container": elencoScuoleCompletoSelectSingoloContainer,
			"container-object": elencoScuoleCompletoSelectSingoloContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleCompletoSelectSingolo", Alpaca.Fields.ElencoScuoleCompletoSelectSingolo); 
  
    
})(jQuery);;var elencoScuoleFuoriBacAutoCompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleFuoriBacAutoCompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleFuoriBacAutoCompleteSelect";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "dependencies": {
	                    "istitutoComprensivo": [
	                        "scuolaFuoriBacino"
	                    ], 
            			"labelDescIstitutoComprensivo": [
	                        "scuolaFuoriBacino"
	                    ]
	                },
            	    "properties": {
            	        "scuolaFuoriBacino": {
            	            "required": false,
            	            "properties": {}
            	        },
                        "istitutoComprensivo": {
                            "required": true,
                            "enum": [
                                "SI",
                                "NO"
                            ],
                            "properties": {}
                        },
	                    "labelDescIstitutoComprensivo": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaFuoriBacino": {
                    	"fieldClass": "select2ac1 scuolaBacinoSelect scuolaFuoriBacinoSelect",
                        "type": "select",
                        "label": "Scuola Fuori Bacino:",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  placeholder: "-- Seleziona --",
					                  ajax: {
					                    url: listaScuoleFBcByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
				                        },
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
	                    		this.getControlEl().on('select2:clear', function (e) {
	                    			var self = this;
	                    			var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
			                    	campoNomeScuola.getControlEl().val("");
			                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
			                    	campoPlessoScuola.getControlEl().val("");
			                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
			                    	campoIndirizzoScuola.getControlEl().val("");
			                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
			                    	campoTipologiaScuola.getControlEl().val("");
			                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
			                    	campoComuneProvinciaScuola.getControlEl().val("");
			                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
			                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata:</p>";
			                    	labelBacinoDiAppartenenza.refresh();
	                    		});
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	if(idScuola){
	                        		var	infoScuolaDependentUrl = infoScuolaBacinoByIdUrl + idScuola;
		                        	$.ajax({
					                    url: infoScuolaDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    success: function (data) {
					                    	
					                    	var selectBRId = self.parent.parent.childrenByPropertyId['customScuolaBacRegolare'].childrenByPropertyId['scuolaBacinoRegolare'].id;
					                    	if( selectBRId ) {
					                    		$('#' + selectBRId).val(null).trigger('change');
					                    	}
					                    	var selectBPegId = self.parent.parent.childrenByPropertyId['customScuolaBacinoPeg'].childrenByPropertyId['scuolaBacinoPeg'].id;
					                    	if( selectBPegId ) {
					                    		$('#' + selectBPegId).val(null).trigger('change');
					                    	}
					                    	
					                    	
					                    	var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
					                    	campoNomeScuola.getControlEl().val(data.denominazione);
					                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
					                    	campoPlessoScuola.getControlEl().val(data.plesso);
					                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
					                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
					                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
					                    	campoTipologiaScuola.getControlEl().val(data.grado);
					                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
					                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
					                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
					                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata fuori bacino di appartenenza</p>";
					                    	labelBacinoDiAppartenenza.refresh();
					                    }
		                            });
	                        	}
	                        	
	                        }
                        
                        }
                    },
                    "istitutoComprensivo": {
                        "type": "radio",
                        "label": "Istituto Comprensivo:",
                        "helpers": [],
                        "fieldClass": "text-left",
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "hideInitValidationError": false,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": false,
                        "removeDefaultNone": true,
                        "hideNone": true,
                        "sort": false,
                        "optionLabels": [
                            "SI",
                            "NO"
                        ],
                        "fields": {}
                    },
                    "labelDescIstitutoComprensivo": {
                        "type": "label",
                        "label": "ISTITUTO COMPRENSIVO: indicare se la scuola da frequentare per l'a.s. indicato appartiene allo stesso Istituto Comprensivo frequentato negli anni scolastici precedenti. La dichiarazione sarÃ  sottoposta a verifica presso le scuole indicate. In tal caso, saranno applicate le tariffe relative agli utenti appartenenti al bacino",
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
                    }
                },
                "view": "elencoScuoleFuoriBacAutoCompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Fuori Bacino con Autocomplete";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola Fuori Bacino di appartenenza con autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleFuoriBacAutoCompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleFuoriBacAutoCompleteSelectContainer,
			"container-object": elencoScuoleFuoriBacAutoCompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleFuoriBacAutoCompleteSelect", Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect); 
  
    
})(jQuery);;var elencoScuoleSingoloAutocompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleSingoloAutocompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleSingoloAutocompleteSelect";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaPrincipale": {
                    	"fieldClass": "select2ac1",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  ajax: {
					                    url: listaScuoleByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
				                    	var campoBacinoScuola = self.parent.childrenByPropertyId['bacinoAppartenenzaScuola'];
				                    	campoBacinoScuola.getControlEl().val(data.nomeComuneProv);
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    },
                    "bacinoAppartenenzaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Bacino di appartenenza: ",
                        "renderButtons": true
                    }
                },
                "view": "elencoScuoleSingoloAutocompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Autocomplete e Info";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale di iscrizione con info relative e autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleSingoloAutocompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleSingoloAutocompleteSelectContainer,
			"container-object": elencoScuoleSingoloAutocompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleSingoloAutocompleteSelect", Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect); 
  
    
})(jQuery);;var elencoScuoleSingoloAutocompleteSelect2Container = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleSingoloAutocompleteSelect2ContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2 = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleSingoloAutocompleteSelect2";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
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
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		try{
                        			var codiceAnnoScolastico = this.parent.parent.childrenByPropertyId['annoScolasticoCorrenteObject'].childrenByPropertyId['annoScolasticoCorrente'].getControlEl().val();
                        			console.log("codiceAnnoScolastico=" + codiceAnnoScolastico);
                        			listaScuoleByComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;
                        			
                        		}catch(err) {
                        			  console.log("Errore nel recupero anno scolastico" + err.message);
                        		}
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  ajax: {
					                    url: listaScuoleByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    }
                },
                "view": "elencoScuoleSingoloAutocompleteSelect2-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Autocomplete e Info";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale di iscrizione con info relative e autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleSingoloAutocompleteSelect2-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleSingoloAutocompleteSelect2Container,
			"container-object": elencoScuoleSingoloAutocompleteSelect2ContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleSingoloAutocompleteSelect2", Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2); 
  
    
})(jQuery);;var statiEsteriRequiredContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiEsteriRequiredContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiEsteriRequiredSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiEsteriRequiredSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiEsteriRequiredSelect";
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
                         "statiEsteriRequired": {
                             "required": true,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "statiEsteriRequired": {
                        "type": "select",
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaStatiEsteriUrl,
                        "label": "Stato: ",
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuno",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "helpers": [],
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fields": {}
                    },
                
                },
                "view": "statiEsteriRequiredSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Stati Esteri Required Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Stati Esteri Required Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiEsteriRequiredSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiEsteriRequiredContainer,
			"container-object": statiEsteriRequiredContainerObject
		}
    });
    Alpaca.registerFieldClass("statiEsteriRequiredSelect", Alpaca.Fields.StatiEsteriRequiredSelect); 
  
    
})(jQuery);;var statiEsteriContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiEsteriContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiEsteriSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiEsteriSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiEsteriSelect";
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
                         "statiEsteri": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "statiEsteri": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaStatiEsteriUrl,
                        "label": "Stato estero: ",
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuno",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "helpers": [],
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fields": {}
                    },
                
                },
                "view": "statiEsteriSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Stati Esteri Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Stati Esteri Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiEsteriSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiEsteriContainer,
			"container-object": statiEsteriContainerObject
		}
    });
    Alpaca.registerFieldClass("statiEsteriSelect", Alpaca.Fields.StatiEsteriSelect); 
  
    
})(jQuery);;var statiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiSelect";
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
                         "stati": {
                        	 "default": "Italia",
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "stati": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaStatiEsteriUrl,
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
                        "fields": {}
                    },
                
                },
                "view": "statiSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Nazioni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Nazioni Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiContainer,
			"container-object": statiContainerObject
		}
    });
    Alpaca.registerFieldClass("statiSelect", Alpaca.Fields.StatiSelect); 
  
    
})(jQuery);;var statiCittadinanzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiCittadinanzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiSelectCittadinanza = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiSelectCittadinanza.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiSelectCittadinanza";
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
                         "stati": {
                        	 "default": "Italia",
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "stati": {
                    	"label": "Cittadinanza:",
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaStatiEsteriUrl,
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
                    },
                
                },
                "view": "statiSelectCittadinanza-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Nazioni Select Cittadinanza";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Nazioni Select lista custom Cittadinanza";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiSelectCittadinanza-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiCittadinanzaContainer,
			"container-object": statiCittadinanzaContainerObject
		}
    });
    Alpaca.registerFieldClass("statiSelectCittadinanza", Alpaca.Fields.StatiSelectCittadinanza); 
  
    
})(jQuery);;var elencoStradarioNewFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var elencoStradarioNewFieldContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-10">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
	
    var civiciPerIndirizzo = {};
    
    Alpaca.Fields.ElencoStradarioNewField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ElencoStradarioNewField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "elencoStradarioNew";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
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

            	};
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "showButtons": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
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
                        "fields": {},
                        "events": {
                        	"click": function (){
                        		
                        		var relatedSelectStradario = this.domEl.closest("div.alpaca-field-object").find($("select[name*='selectStradarioNew']"));
                        		relatedSelectStradario.attr("disabled", false);
                        		console.log("click domel", this.domEl);
                        		relatedSelectStradario.empty();
                        		this.domEl.css("pointer-events","none");
                        		this.domEl.find("div.btn").attr("disabled", true);
                        		
                        		var alpacaStradarioNew = this.parent.childrenByPropertyId["searchStradarioNew"];
                        		var currentVal = alpacaStradarioNew.getValue();
               		
                        		for (var curr in civiciPerIndirizzo) delete civiciPerIndirizzo[curr];
                        		
                        		//$("select[name*='selectStradarioNew']").select2("open");
                        		var $search = relatedSelectStradario.data('select2').dropdown.$search;
                                $search.val(currentVal);                                
                                $search.trigger('input');
                        		//$("li.select2-results__option").remove();
                                $("input.select2-search__field").hide(); 		
                        	}
                        }
                    },
                    
                    "selectStradarioNew": {
                    	"fieldClass": "select2ac1",
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "label": "Vie: ",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		var selfControlEl = this.getControlEl();
                        		console.log("in ready select stradario new");
                        		this.getControlEl().attr("disabled", true);
                        		var searchBtn = this.parent.childrenByPropertyId['searchButton'];
                        		console.log("ready domel", searchBtn.domEl);
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  width: "100%",
					                  minimumInputLength: 1,
					                  minimumResultsForSearch: -1,
					                  ajax: {
					                	  url: function (params) {
					                	      return listaStradarioUrl + "&indirizzo=" + params.term;
					                	    },
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
			                            },
			                            success: function (data) {
			                            	selfControlEl.attr("disabled", false);
			                            	console.log("success");
			                        		data.forEach( function (element) {
			                        			civiciPerIndirizzo[element.identificativo] = element.civici;
			                        		});  
			                        		
			                            },
			                            complete: function () {
			                            	console.log("complete");
					                    	searchBtn.domEl.css("pointer-events","auto");
					                    	searchBtn.domEl.find("div.btn").attr("disabled", false);
			                        		
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.identificativo;
	                                          obj.text = obj.denominazione + " - " + obj.localita;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
                        		this.getControlEl().on('select2:open', function (e) {
                        			$("input.select2-search__field").hide();
                        			});
                        	},
                        	"change": function(){
                    			var civiciDisponibili = [{"value": "-1", "text": "-- Inserimento Manuale --"}];
                    			civiciPerIndirizzo[this.getValue()].forEach( function(element) {
                    			var numeroEsponente = element.numero;
                    			if (element.esponente !== null && element.esponente !== undefined) {
                    				numeroEsponente = numeroEsponente + " " + element.esponente;
                    			}
                    			    civiciDisponibili.push({"value": element.identificativo, "text": numeroEsponente});
                    			});

                    			var campoAlpacaCivici = this.domEl.closest("div.alpaca-field-object").find($("select[name*='selectCivici']")).alpaca("get");
                    			campoAlpacaCivici.options.dataSource = civiciDisponibili;

                    			campoAlpacaCivici.refresh();
                    			
                        	}
                        }
                        
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
                        "fields": {},
                        "events": {
                        	"change": function (){
                        		var campoCivico = this.parent.childrenByPropertyId["civico"];
                        		var campoEsponente = this.parent.childrenByPropertyId["esponente"];
                        		 if (this.getValue() == "-1") {
	                        		campoCivico.options.hidden = false;
	                        		campoEsponente.options.hidden = false;
                        		} else {
	                        		campoCivico.options.hidden = true;
	                        		campoEsponente.options.hidden = true;
                        		}
                        		 campoCivico.refresh();
	                        	 campoEsponente.refresh();
                        	}
                        } 
                        
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
                },
                "view": "elencostradarionew-view"              
            });
        },
        
         /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Elenco StradarioNew";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Elenco di scelta da stradario con via e civico";
        }
    });

    Alpaca.registerView({
    	"id": "elencostradarionew-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": elencoStradarioNewFieldContainer,
    		"container-object": elencoStradarioNewFieldContainerObject
    	}
    });
    Alpaca.registerFieldClass("elencoStradarioNew", Alpaca.Fields.ElencoStradarioNewField);
    

})(jQuery);
;var elencoStradarioFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var elencoStradarioFieldContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-10">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
	
    var civiciPerIndirizzo = {};
    
    Alpaca.Fields.ElencoStradarioField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ElencoStradarioField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "elencoStradario";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "properties": {
            	        "searchStradario": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "searchButton": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectStradario": {
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

            	};
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "showButtons": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
                    "searchStradario": {
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
                        "fields": {},
                        "events": {
                        	"click": function (){
                        		var self = this;
                        		self.domEl.css("pointer-events","none");
                        		self.domEl.find("div.btn").attr("disabled", true);
                        		var alpacaStradario = this.parent.childrenByPropertyId["searchStradario"];
                        		var currentVal = alpacaStradario.getValue();
                        		for (var curr in civiciPerIndirizzo) delete civiciPerIndirizzo[curr];
                        		alpacaStradario.options.helpers = ["Caricamento in corso..."];
                        		alpacaStradario.refresh();
                        		alpacaStradario.getControlEl().val(currentVal);
                        		var newData = [];
                        		$("select[name*='selectStradario']").empty();
                        		                 
                        		$.ajax({
		                            url: listaStradarioUrl+"&indirizzo=" + currentVal,
		                            dataType: 'json',
		                            delay: 250,
		                            timeout: 10000,
		                            error: function () {
		                        		self.domEl.css("pointer-events","auto");
		                        		self.domEl.find("div.btn").attr("disabled", false);
		                            	alpacaStradario.options.helpers =["Errore nel caricamento dei dati. Riprovare."];
		                        		alpacaStradario.refresh();
		                        		
		                            },
		                            success: function (data) {
		                            	
		                            	//for (var currEl in civiciPerIndirizzo) delete civiciPerIndirizzo[currEl];
		                        		data.forEach( function (element) {
		                        			newData.push({"id": element.identificativo, "text": element.denominazione + " - " + element.localita});
		                        			civiciPerIndirizzo[element.identificativo] = element.civici;
		                        		});  
		                        		
		                        		$("select[name*='selectStradario']").select2({
		                        			data: newData
		                        		});
		                        		
		                        		/*$("select[name*='selectStradario']").trigger("change");*/
		                        		var $search = $("select[name*='selectStradario']").data('select2').dropdown.$search;
		                        		$search.val(currentVal);
		                        		$search.trigger('keyup');

		                        		$("select[name*='selectStradario']").select2({
		                        		minimumResultsForSearch: -1 
		                        		});

		                        		$("select[name*='selectStradario']").select2("open");
		                        		$("select[name*='selectStradario']").val(null);
		                        		
		                        		self.domEl.css("pointer-events","auto");
		                        		self.domEl.find("div.btn").attr("disabled", false);
		                        		alpacaStradario.options.helpers = [];
		                        		alpacaStradario.refresh();
		                            }
                            
                        		});

                        	}
                        }
                    },
                    "selectStradario": {
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
                        "fields": {},
                        "events":{
                        	"change": function(){
                        			var civiciDisponibili = [{"value": "-1", "text": "-- Inserimento Manuale --"}];
                        			civiciPerIndirizzo[this.getValue()].forEach( function(element) {
                        			var numeroEsponente = element.numero;
                        			if (element.esponente !== null && element.esponente !== undefined) {
                        				numeroEsponente = numeroEsponente + " " + element.esponente;
                        			}
                        			    civiciDisponibili.push({"value": element.identificativo, "text": numeroEsponente});
                        			});

                        			var campoAlpacaCivici = $("select[name*='selectCivici']").alpaca("get");
                        			campoAlpacaCivici.options.dataSource = civiciDisponibili;

                        			campoAlpacaCivici.refresh();
                        			
                        	}
                        }
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
                        "fields": {},
                        "events": {
                        	"change": function (){
                        		var campoCivico = this.parent.childrenByPropertyId["civico"];
                        		var campoEsponente = this.parent.childrenByPropertyId["esponente"];
                        		 if (this.getValue() == "-1") {
	                        		campoCivico.options.hidden = false;
	                        		campoEsponente.options.hidden = false;
                        		} else {
	                        		campoCivico.options.hidden = true;
	                        		campoEsponente.options.hidden = true;
                        		}
                        		 campoCivico.refresh();
	                        	 campoEsponente.refresh();
                        	}
                        } 
                        
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
                },
                "view": "elencostradario-view"              
            });
        },
        
         /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Elenco Stradario";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Elenco di scelta da stradario con via e civico";
        }
    });

    Alpaca.registerView({
    	"id": "elencostradario-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": elencoStradarioFieldContainer,
    		"container-object": elencoStradarioFieldContainerObject
    	}
    });
    Alpaca.registerFieldClass("elencoStradario", Alpaca.Fields.ElencoStradarioField);
    

})(jQuery);
;var usoBolloContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var usoBolloContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.UsoBolloSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.UsoBolloSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "usoBolloSelect";
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
                         "usoBollo": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "usoBollo": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaUsoBolloUrl,
                        "label": "",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "helpers": [],
                        "renderButtons": true,
                        "fields": {}
                    }
                
                },
                "view": "usoBolloSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Uso Bollo Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Uso Bollo Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "usoBolloSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": usoBolloContainer,
			"container-object": usoBolloContainerObject
		}
    });
    Alpaca.registerFieldClass("usoBolloSelect", Alpaca.Fields.UsoBolloSelect); 
  
    
})(jQuery);;(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.LabelField = Alpaca.Fields.TextField.extend(
    /**
     * @lends Alpaca.Fields.LabelField.prototype
     */
    {
    	/**
         * @see Alpaca.Fields.TextField#setup
         */
    	setup: function() {
    		this.base();
    		this.options.validate = false;
    	},
    	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "label";
        },
        
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {

            var self = this;

            var field = this.getControlEl();

            this.base(model, function() {
            	//$(field).parent().find( "label" ).css( "color", "red" );
                $(field).remove();

                callback();

            });
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Label Field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Label Field.";
        }
        
    });

    Alpaca.registerFieldClass("label", Alpaca.Fields.LabelField);

})(jQuery);;var nazioneComuneProvinciaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var nazioneComuneProvinciaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
       
	var getQsUnifier = function(url) {
		if (url.lastIndexOf('?') >= 0) {
			return '&';
		}
		return '?';
	};
	
    Alpaca.Fields.NazioneProvinciaComuneField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.NazioneProvinciaComuneField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "nazioneProvinciaComune";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
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
            	        "statoEsteroSelezionato": {
            	            "required": false,
            	            "properties": {}
            	        }
            	    }
            	};
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
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
                                "dataSource": listaStatiEsteriUrl,
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
                                "fields": {},
                                "events": {
                                    "ready": function(){
                                    	console.log('in ready per stati');
                                        var selectedNation = this.getValue();
                                    	var parentStati = this.parent;
                                    	console.log(parentStati);

                                    	var statoEsteroSelezionato = parentStati.parent.childrenByPropertyId['statoEsteroSelezionato'];
                                    	console.log(statoEsteroSelezionato);

                                    	var provinciaComune = parentStati.parent.childrenByPropertyId['provinciaComune'];
                                        if(selectedNation != "Italia"){
                                        	statoEsteroSelezionato.show();
                                        	provinciaComune.hide();
                                        } else {
                                        	statoEsteroSelezionato.hide();
                                        	provinciaComune.show();
                                          } 
                                    },
                                    "change": function() {
                                    	console.log('in change');
                                        var selectedNation = this.getValue();
                                    	console.log(selectedNation);

                                    	var parentStati = this.parent;
                                    	console.log(parentStati);

                                    	var statoEsteroSelezionato = parentStati.parent.childrenByPropertyId['statoEsteroSelezionato'];
                                    	console.log(statoEsteroSelezionato);

                                    	var provinciaComune = parentStati.parent.childrenByPropertyId['provinciaComune'];
                                        provinciaComune.refresh();
                                        if(selectedNation != "Italia"){
                                        	statoEsteroSelezionato.show();
                                        	provinciaComune.hide();
                                        } else {
                                        	statoEsteroSelezionato.hide();
                                        	provinciaComune.show();
                                          } 	                                  	
                                     }                          
                                }
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
                                "dataSource": listaProvinceUrl,
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
                    "statoEsteroSelezionato": {
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		console.log("in ready select comune estero");
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  width: "100%",
					                  minimumInputLength: 3,
					                  ajax: {
					                	  url: function (params) {
					                	      return listaComuniEsteriUrl + "&q=" + params.term;
					                	    },
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
			                            },
			                            success: function (data) {
			                            	console.log("success ", data);
			                    
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        	}
                        }
                    }
                },
                "view": "nazioneprovinciacomune-view"

            });
        },
              
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Nazione Provincia Comune";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Nazione Provincia Comune anche estero";
        }
    });

    Alpaca.registerView({
    	"id": "nazioneprovinciacomune-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": nazioneComuneProvinciaContainer,
    		"container-object": nazioneComuneProvinciaContainerObject
    	}
    });
    Alpaca.registerFieldClass("nazioneProvinciaComune", Alpaca.Fields.NazioneProvinciaComuneField);
    

})(jQuery);
;(function($) {

	var Alpaca = $.alpaca;

	Alpaca.Fields.NonRipetibilitaServizioPerAnnoScolasticoField = Alpaca.Fields.ObjectField
			.extend(
			/**
			 * @lends Alpaca.Fields.NonRipetibilitaServizioPerAnnoScolasticoField.prototype
			 */
			{
				/**
				 * @see Alpaca.Fields.TextField#setup
				 */
				setup : function() {
					this.base();
					this.options.validate = false;

					this.schema = {
						"title" : "",
						"description" : "",
						"type" : "object",
						"required" : false
					};

					Alpaca
							.merge(
									this.options,
									{
										"focus": false,
						                "validate": true,
						                "disabled": false,
						                "showMessages": true,
						                "collapsible": false,
						                "legendStyle": "button",
						                "label": "",
										"helpers" : [],
										"fieldClass" : "noBorderContainers",
										"hidden" : true,
										"order" : 100,
										"fields" : {}
									});
				},

				/**
				 * @see Alpaca.Fields.TextField#getFieldType
				 */
				getFieldType : function() {
					return "nonRipetibilitaServizioPerAnnoScolasticoField";
				},

				/**
				 * @see Alpaca.Fields.TextField#getTitle
				 */
				getTitle : function() {
					return "Non Ripetibilita Servizio per Anno Scolastico Field";
				},

				/**
				 * @see Alpaca.Fields.TextField#getDescription
				 */
				getDescription : function() {
					return "Custom Field per il controllo dell'unicitÃ  della domanda "
							+ "di iscrizione per l'anno scolastico corrente.";
				}

			});

	Alpaca.registerFieldClass("nonRipetibilitaServizioPerAnnoScolasticoField",
			Alpaca.Fields.NonRipetibilitaServizioPerAnnoScolasticoField);

})(jQuery);;var comuneProvinciaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var comuneProvinciaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
    
	var getQsUnifier = function(url) {
		if (url.lastIndexOf('?') >= 0) {
			return '&';
		}
		return '?';
	};
	
    Alpaca.Fields.ProvinciaComuneField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ProvinciaComuneField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "provinciaComune";
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
                    "provincia": {
                        "type": "string",
                        "required": false,
                        "default": "",
                        "properties": {}
                    },
                    "comune": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
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
                        "fieldClass": "select2ac1",
                        "focus": false,
                        "optionLabels": [], 
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuna",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "dataSource": listaProvinceUrl,
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                                //console.log(this.name + ": change to -> " + this.getValue(), this);
                                var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
								
 								var dataSource = listaComuniUrl;
                                 if(!provincia){
 									comune.options.optionLabels = [];
									comune.schema.enum = [];
                                	 
                                	//comune.hide();
									comune.getControlEl().val('');
									comune.getControlEl().prop('disabled', true);
                                } else {
                                	dataSource += getQsUnifier(dataSource) + 'idProvincia=' + provincia;
                                	comune.options.dataSource = dataSource;
									comune.getControlEl().val('');
                                    comune.refresh();
									comune.getControlEl().val('');
                                }
                            },
                            "ready": function(){
								/* this.getControlEl().val('');
								this.setValue(''); */
								
                            	var provincia = this.getValue();
                            	console.log('valore provincia ', provincia);
								var comune = this.parent.childrenByPropertyId['comune'];
 								var dataSource = listaComuniUrl;
								/* provincia = (provincia != undefined && provincia != "") ? provincia : 1;
								console.log('test', this, this.getValue()); */
								
                                if(!provincia){
									comune.options.optionLabels = [];
									comune.schema.enum = [];
                                	
                                	//comune.hide();
									comune.getControlEl().val('');
									comune.getControlEl().prop('disabled', true);
                                } else {
                                	dataSource += getQsUnifier(dataSource) + 'idProvincia=' + provincia;
                                	comune.options.dataSource = dataSource;
                                    comune.refresh();
                                }
                            }
                        }
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
                        //"dataSource": listaComuniUrl,
                        "multiple": false,
                        "emptySelectFirst": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                                //console.log(this.name + ": change to -> " + this.getValue());
                            },
                            "ready": function(){
                            	/*var provincia = this.parent.childrenByPropertyId['provincia'];
                            	//console.log('Comune ready! Provincia', provincia.getValue());
                                if(!provincia.getValue()){
                                	this.hide();
                                }*/
                            }
                        }
                    }
                },
                "view": "provinciacomune-view"
            });
        },
        
        /*
        postRender: function(control) {
        	console.log('control', control, arguments);
            var nazione = control.childrenByPropertyId["nazione"];
            var provincia = control.childrenByPropertyId["provincia"];
            console.log('Questa Ã¨ la nazione', nazione);
            nazione.on("change", function() {
                //Qui dobbiamo caricare le province in base allo stato
            	console.log('La nazione Ã¨ cambiata');
            });
        },
         */
        
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);
        	/*
            var self = this;

            var field = this.getControlEl();

            this.base(model, function() {
            	//$(field).parent().find( "label" ).css( "color", "red" );
                $(field).remove();

                callback();

            });
            */
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Provincia Comune";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Provincia Comune";
        }
    });

    Alpaca.registerView({
    	"id": "provinciacomune-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": comuneProvinciaContainer,
    		"container-object": comuneProvinciaContainerObject
    	}
    });
    Alpaca.registerFieldClass("provinciaComune", Alpaca.Fields.ProvinciaComuneField);
    

})(jQuery);
;var comuneProvinciaRequiredContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var comuneProvinciaRequiredContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
    
    var isFieldValidated = false;
    
	var getQsUnifier = function(url) {
		if (url.lastIndexOf('?') >= 0) {
			return '&';
		}
		return '?';
	};
	
    Alpaca.Fields.ProvinciaComuneRequiredField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ProvinciaComuneRequiredField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "provinciaComuneRequired";
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
                    "provincia": {
                        "type": "string",
                        "required": true,
						"default": "",
                        "properties": {}
                    },
                    "comune": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
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
                        "dataSource": listaProvinceUrl,
                        "multiple": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                                //console.log(this.name + ": change to -> " + this.getValue(), this);
                                var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
								
 								var dataSource = listaComuniUrl;
                                 if(!provincia){
 									comune.options.optionLabels = [];
									comune.schema.enum = [];
                                	 
                                	/* comune.hide(); */
									comune.getControlEl().val('');
									comune.getControlEl().prop('disabled', true);
                                } else {
                                	dataSource += getQsUnifier(dataSource) + 'idProvincia=' + provincia;
                                	comune.options.dataSource = dataSource;
									comune.getControlEl().val('');
                                    comune.refresh();
									comune.getControlEl().val('');

                                }
                            },
                            "ready": function(){
								/* this.getControlEl().val('');
								this.setValue(''); */
								
                            	var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
 								var dataSource = listaComuniUrl;
 								/*
								//provincia = (provincia != undefined && provincia != "") ? provincia : 1;
								//console.log('test', this, this.getValue());
								*/
                                if(!provincia){
									comune.options.optionLabels = [];
									comune.schema.enum = [];
                                	
                                	/* comune.hide(); */
									comune.getControlEl().val('');
									comune.getControlEl().prop('disabled', true);
                                } else {
                                	dataSource += getQsUnifier(dataSource) + 'idProvincia=' + provincia;
                                	comune.options.dataSource = dataSource;
                                    comune.refresh();
                                }
                            }
                        }
                    },
                    "comune": {
                    	"type": "comune",
                        "validate": isFieldValidated,
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
                        /* "dataSource": listaComuniUrl, */
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                            },
                            "ready": function(){
                            	console.log("comune is ready");
                            	this.options.emptySelectFirst = true;

                            	/* this.schema.required = false;*/
                            	/*this.options.validate = false; */

                            }
                        }
                    }
                },
                "view": "provinciacomunerequired-view"
            });
        },
        
        /*
        postRender: function(control) {
        	console.log('control', control, arguments);
            var nazione = control.childrenByPropertyId["nazione"];
            var provincia = control.childrenByPropertyId["provincia"];
            console.log('Questa Ã¨ la nazione', nazione);
            nazione.on("change", function() {
                //Qui dobbiamo caricare le province in base allo stato
            	console.log('La nazione Ã¨ cambiata');
            });
        },
        */
        
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);
        	/*
            var self = this;

            var field = this.getControlEl();

            this.base(model, function() {
            	//$(field).parent().find( "label" ).css( "color", "red" );
                $(field).remove();

                callback();

            });
            */
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Provincia Comune Obbligatori";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Provincia Comune Obbligatori";
        }
    });

    Alpaca.registerView({
    	"id": "provinciacomunerequired-view",
        "messages": {
            "notOptional": "Campo obbligatorio",
            "invalidValueOfEnum": "Selezionare prima la provincia"
        },
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": comuneProvinciaRequiredContainer,
    		"container-object": comuneProvinciaRequiredContainerObject
    	}
    });
    Alpaca.registerFieldClass("provinciaComuneRequired", Alpaca.Fields.ProvinciaComuneRequiredField);
    

})(jQuery);
;(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.ProvinciaField = Alpaca.Fields.SelectField.extend(
    /**
     * @lends Alpaca.Fields.SelectField.prototype
     */
    {    	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "provincia";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Provincia field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Provincia Field.";
        }
        
    });

    Alpaca.registerFieldClass("provincia", Alpaca.Fields.ProvinciaField);

})(jQuery);;(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.UrlDocumentoField = Alpaca.Fields.URLField.extend(
    /**
     * @lends Alpaca.Fields.UrlDocumentoField.prototype
     */
    {
    	/**
         * @see Alpaca.Fields.TextField#setup
         */
    	setup: function() {
    		this.base();
    		this.options.validate = false;
    	},
    	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "urldocumentofield";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "URL Documento Field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "URL Documento Field.";
        }
        
    });

    Alpaca.registerFieldClass("urldocumentofield", Alpaca.Fields.UrlDocumentoField);

})(jQuery);;(function($) {

	var Alpaca = $.alpaca;

	Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliTrasportoField = Alpaca.Fields.ObjectField
			.extend(
			/**
			 * @lends Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliTrasportoField.prototype
			 */
			{
				/**
				 * @see Alpaca.Fields.TextField#setup
				 */
				setup : function() {
					this.base();
					this.options.validate = false;

					this.schema = {
						"title" : "",
						"description" : "",
						"type" : "object",
						"required" : false
					};

					Alpaca
							.merge(
									this.options,
									{
										"focus": false,
						                "validate": true,
						                "disabled": false,
						                "showMessages": true,
						                "collapsible": false,
						                "legendStyle": "button",
						                "label": "",
										"helpers" : [],
										"fieldClass" : "noBorderContainers",
										"hidden" : true,
										"order" : 100,
										"fields" : {}
									});
				},

				/**
				 * @see Alpaca.Fields.TextField#getFieldType
				 */
				getFieldType : function() {
					return "verificaPresenzaMinoriIscrivibiliTrasportoField";
				},

				/**
				 * @see Alpaca.Fields.TextField#getTitle
				 */
				getTitle : function() {
					return "Verifica presenza di minori iscrivibili al trasporto";
				},

				/**
				 * @see Alpaca.Fields.TextField#getDescription
				 */
				getDescription : function() {
					return "Custom Field per il controllo dell'esistenza nel proprio nucleo famigliare"
							+ "di minori iscrivibili al trasporto scolastico";
				}

			});

	Alpaca.registerFieldClass("verificaPresenzaMinoriIscrivibiliTrasportoField",
			Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliTrasportoField);

})(jQuery);