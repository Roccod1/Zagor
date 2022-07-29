var anagrafeTariDomesticaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeTariDomesticaContainerObject = ' \
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
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeTariDomestica = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeTariDomestica.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeTariDomestica";
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
                    "new1505144578146": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
					"new1497618134104": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
    	            },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "new1499070234076": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "new1499070243049": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "indirizzo": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "civico": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "cap": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "piva": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
            			"dependencies": "tipocontribuente",
                        "properties": {}
                    },
                    "telefono": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "properties": {}
                    },
                    "fax": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "numerorea": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
            			"dependencies": "tipocontribuente",
                        "properties": {}
                    },
                    "provinciarea": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
            			"dependencies": "tipocontribuente",
                        "properties": {}
                    },
                    "estremidocumento": {
                        "readonly": false,
                        "required": false,
                        "type": "string",
                        "properties": {}
                    },
                    "new1493714866834": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "new1493714951473": {
                        "readonly": false,
                        "required": false,
                        "enum": [
                            "Residenza e/o sede legale",
                            "Altro"
                        ],
                        "properties": {}
                    },
                    "comunicazioni-via": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1493714951473",
                        "properties": {}
                    },
                    "comunicazioni-num": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1493714951473",
                        "properties": {}
                    },
                    "comunicazioni-esp": {
                        "type": "string",
                        "required": false,
                        "dependencies": "new1493714951473",
                        "properties": {}
                    },
                    "comunicazioni-cap": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1493714951473",
                        "properties": {}
                    },
                    "new1499070433294": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1493714951473",
                        "properties": {}
                    },
                    "new1499070441619": {
                        "readonly": false,
                        "required": true,
                        "type": "string",
                        "dependencies": "new1493714951473",
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
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
	                "new1497618134104": {
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
                    "new1499070234076": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia residenza",
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
                    "new1499070243049": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Comune residenza",
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
                    "indirizzo": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Indirizzo",
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
                    "civico": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Civico",
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
                    "cap": {
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
                    "piva": {
                        "type": "text",
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
            			"dependencies": {
                                "tipocontribuente": [
                                    "Giuridico"
                                ]
                        },
                        "fields": {}
                    },
                    "telefono": {
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
                    "fax": {
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
                    "numerorea": {
                        "type": "text",
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
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
            			"dependencies": {
                            "tipocontribuente": [
                                "Giuridico"
                            ]
                        },
                        "fields": {}
                    },
                    "provinciarea": {
                        "type": "text",
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
            			"dependencies": {
                                "tipocontribuente": [
                                    "Giuridico"
                                ]
                        },
                        "fields": {}
                    },
                    "estremidocumento": {
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
                    "new1493714866834": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Invio cartelle e/o comunicazioni c/o:",
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
                    "new1493714951473": {
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
                    "comunicazioni-via": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "via",
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
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-num": {
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
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-esp": {
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
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "comunicazioni-cap": {
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
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "new1499070433294": {
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
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "dependencies": {
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    },
                    "new1499070441619": {
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
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "dependencies": {
                            "new1493714951473": [
                                "Altro"
                            ]
                        },
                        "fields": {}
                    }
                },
                "view": "anagrafeTariDomestica-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe Tari domestica";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe Tari domestica";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeTariDomestica-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeTariDomesticaContainer,
    		"container-object": anagrafeTariDomesticaContainerObject
    	}
    });
    Alpaca.registerFieldClass("anagrafeTariDomestica", Alpaca.Fields.anagrafeTariDomestica);
    

})(jQuery);