var datiImmobileNonDomesticaTariNoStradarioContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiImmobileNonDomesticaTariNoStradarioContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
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
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
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
			<div class="col-md-4">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiImmobileNonDomesticaTariField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiImmobileNonDomesticaTariField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiImmobileNonDomesticaTariNoStradario";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function() {
            this.base();

            this.schema = {
                "minItems": 1,
                "maxItems": 5,
            	"items": {
    	            "title": "",
    	            "type": "object",
    	            "properties": {
    	                "new1499098105340": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-titolooccupazione": {
    	                    "readonly": false,
    	                    "required": false,
    	                    "enum": [
    	                        "altro diritto reale di godimento",
    	                        "locazione",
    	                        "locazione finanziaria",
    	                        "proprietà",
    	                        "uso gratuito",
    	                        "usufrutto"
    	                    ],
    	                    "properties": {}
    	                },
    	                "immobile-notaoccupazione": {
    	                    "type": "string",
    	                    "required": false,
    	    				"dependencies": "immobile-titolooccupazione",
    	                    "properties": {}
    	                },
    	                "immobile-proprietario": {
    	                    "type": "string",
    	                    "required": false,
    	    				"dependencies": "immobile-titolooccupazione",
    	                    "properties": {}
    	                },
    	                "immobile-codfiscale": {
    	                    "type": "string",
    	                    "required": false,
    	    				"dependencies": "immobile-titolooccupazione",
    	                    "properties": {}
    	                },
    	                "labelStradarioImmobile": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "indirizzoImmobile": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
    	                "immobile-cap": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "immobile-piano": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-sc": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-int": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-suf": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-sez": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "==",
    	                        "NCT"
    	                    ],
    	                    "properties": {}
    	                },
    	                "immobile-foglio": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "type": "number",
    	                    "exclusiveMinimum": false,
    	                    "exclusiveMaximum": false,
    	                    "properties": {}
    	                },
    	                "immobile-part": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "type": "number",
    	                    "exclusiveMinimum": false,
    	                    "exclusiveMaximum": false,
    	                    "properties": {}
    	                },
    	                "immobile-sub": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1499102174267": {
     	                	"readonly": false,
    	                    "required": true,
    	                    "type": "number",
    	                    "exclusiveMinimum": false,
    	                    "exclusiveMaximum": false,
    	                    "properties": {}
    	                },
    	                "immobile-utenzaconriduzione": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "enum": [
    	                        "No",
    	                        "Si"
    	                    ],
    	                    "properties": {}
    	                },
    	                "immobile-tipologiasuperficie": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "enum": [
    	                        "Coperta",
    	                        "Scoperta"
    	                    ],
    	                    "properties": {}
    	                },
    	                "immobile-suptotale": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "immobile-intassabileimpianti": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-intassabilealtresuperficie": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "immobile-supertassabile": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                }
    	                
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"validate": true,
                "showMessages": true,
                "disabled": false,
                "readonly": false,
                "rubyrails": false,
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
                            "label": "Aggiungi Immobile"
                        }
                    ]
                },
                "actionbar": {
                    "showLabels": true,
                    "actions": [
                        {
                            "action": "add",
                            "label": "Aggiungi Immobile"
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
	                    "new1499098105340": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Immobile",
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
	                    "immobile-titolooccupazione": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Titolo dell'occupazione",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "altro diritto reale di godimento",
	                            "locazione",
	                            "locazione finanziaria",
	                            "proprietà",
	                            "uso gratuito",
	                            "usufrutto"
	                        ],
	                        "removeDefaultNone": true,
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "noneLabel": "None",
	                        "fields": {}
	                    },
	                    "immobile-notaoccupazione": {
	                        "type": "text",
	        				"dependencies": {
	                            "immobile-titolooccupazione": [
	                            	 	"locazione",
	        							"uso gratuito"
	                            ]
	                        },
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Nota occupazione",
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
	                    "immobile-proprietario": {
	                        "type": "text",
	        				"dependencies": {
	                            "immobile-titolooccupazione": [
	                            	 	"locazione",
	        							"uso gratuito"
	                            ]
	                        },
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Proprietario",
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
	                    "immobile-codfiscale": {
	                        "type": "text",
	        				"dependencies": {
	                            "immobile-titolooccupazione": [
	                            	 	"locazione",
	        							"uso gratuito"
	                            ]
	                        },
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Cod. Fiscale",
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
	                    "labelStradarioImmobile": {
	                        "type": "label",
	                        "label": "Indirizzo immobile",
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
	                    "indirizzoImmobile": {
	                    	"type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Indirizzo Immobile",
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
	                    "immobile-cap": {
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
	                    "immobile-piano": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
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
	                    "immobile-sc": {
	                        "type": "text",
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
	                    "immobile-int": {
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
	                    },
	                    "immobile-suf": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "suf",
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
	                    "immobile-sez": {
	                		"type": "select",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Sezione",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "==",
	                            "NCT"
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
	                        "fields": {}
	                    },
	                    "immobile-foglio": {
	                    	"label": "Foglio",
	                        "type": "integer",
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
	                        "focus": false
	                    },
	                    "immobile-part": {
	                    	"label": "Particella",
	                        "type": "integer",
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
	                        "focus": false
	                    },
	                    "immobile-sub": {
	                        "type": "integer",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Subalterno",
	                        "helpers": [
	                            "In assenza di riferimento catastale inserire \"==\""
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
	                    "new1499102174267": {
	                    	"label": "Codice Ateco",
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
	                        "focus": false
	                        
	                    },
	                    "immobile-utenzaconriduzione": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Utenza con riduzione",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "No",
	                            "Si"
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
	                        "fields": {}
	                    },
	                    "immobile-tipologiasuperficie": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Tipologia superficie",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Coperta",
	                            "Scoperta"
	                        ],
	                        "removeDefaultNone": true,
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "renderButtons": true,
	                        "noneLabel": "None",
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "immobile-suptotale": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Sup. Totale",
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
	                    "immobile-intassabileimpianti": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Intassabile impianti",
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
	                    "immobile-intassabilealtresuperficie": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Intassabile altre superfici",
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
	                    "immobile-supertassabile": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Super tassabile",
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
            	"view": "immobilenondomesticatariNoStradario-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati immobile tari (non domestica)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati immobile tari (non domestica)";
        }
    });

    
    
    Alpaca.registerFieldClass("datiImmobileNonDomesticaTariNoStradario", Alpaca.Fields.DatiImmobileNonDomesticaTariField); 
    
    Alpaca.registerView({
        "id": "immobilenondomesticatariNoStradario-view",
        "parent": "bootstrap-create",
        "messages": {
            "notOptional": "Campo obbligatorio",
            "invalidValueOfEnum": "Selezionare una delle opzioni",
            "disallowValue": "Non è possibile effettuare questa scelta.",
            "stringNotANumber": "Inserire un valore numerico."
        },
        "templates": {
        	"container": datiImmobileNonDomesticaTariNoStradarioContainer,
        	"container-object": datiImmobileNonDomesticaTariNoStradarioContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Immobile"
    }, "immobilenondomesticatariNoStradario-view");
    
})(jQuery);