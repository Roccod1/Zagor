var datiimmobiledomesticavariazionefissoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiimmobiledomesticavariazionefissoContainerObject = ' \
	<script type="text/x-handlebars-template"> \
    <div> \
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
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.datiimmobiledomesticavariazionefisso = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.datiimmobiledomesticavariazionefisso.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiimmobiledomesticavariazionefisso";
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
	                "new1499098105340": {
	                    "type": "string",
	                    "required": false,
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
	                "new1499096043092": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "string",
	                    "properties": {}
	                },
	                "immobile-civico": {
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
	                "immobile-cat": {
	                    "readonly": false,
	                    "required": true,
	                    "disallow": [],
	                    "enum": [
	                        "A/1",
	                        "A/10",
	                        "A/2",
	                        "A/3",
	                        "A/4",
	                        "A/5",
	                        "A/6",
	                        "A/7",
	                        "A/8",
	                        "A/9",
	                        "C/1",
	                        "C/2",
	                        "C/3",
	                        "C/4",
	                        "C/5",
	                        "C/6",
	                        "C/7"
	                    ],
	                    "properties": {}
	                },
	                "immobile-uso": {
	                    "readonly": false,
	                    "required": true,
	                    "disallow": [],
	                    "enum": [
                            "abitativo",
                            "immobile tenuto a disposizione",
                            "uso commerciale",
                            "locali adibiti a box",
                            "altri usi"
	                    ],
	                    "properties": {}
	                },
	                "immobile-mq": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "string",
	                    "properties": {}
	                },
	                "immobile-nuovamq": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "string",
	                    "properties": {}
	                }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
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
                    "new1499096043092": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Indirizzo immobile",
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
                    "immobile-civico": {
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
                    "immobile-cat": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "cat",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "A/1",
                            "A/10",
                            "A/2",
                            "A/3",
                            "A/4",
                            "A/5",
                            "A/6",
                            "A/7",
                            "A/8",
                            "A/9",
                            "C/1",
                            "C/2",
                            "C/3",
                            "C/4",
                            "C/5",
                            "C/6",
                            "C/7"
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
                    "immobile-uso": {
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Uso",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "abitativo",
                            "immobile tenuto a disposizione",
                            "uso commerciale",
                            "locali adibiti a box",
                            "altri usi"
                        ],
                        "sort": false,
                        "removeDefaultNone": true,
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
                    "immobile-mq": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Superficie attuale (Mq.)",
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
                    "immobile-nuovamq": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Nuova Superficie (Mq.)",
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
                    }
                },
                "view": "datiimmobiledomesticavariazionefisso-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati immobile tari variazione (domestica) Fisso";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati immobile tari variazione (domestica) Fisso";
        }
    });

    Alpaca.registerView({
    	"id": "datiimmobiledomesticavariazionefisso-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": datiimmobiledomesticavariazionefissoContainer,
    		"container-object": datiimmobiledomesticavariazionefissoContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiimmobiledomesticavariazionefisso", Alpaca.Fields.datiimmobiledomesticavariazionefisso);
    

})(jQuery);