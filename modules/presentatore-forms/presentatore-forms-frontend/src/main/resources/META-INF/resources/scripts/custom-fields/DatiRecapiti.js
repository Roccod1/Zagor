var datiRecapitiContainer = ' \
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
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
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
                    "labelRecapiti": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "provComuneRecapito": {
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
                    "indirizzoRecapito": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "civicoRecapito": {
        	            "type": "string",
        	            "pattern": "^[0-9]*$",
                        "required": true,
                        "properties": {}
                    },
                    "esponenteRecapito": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "telefono": {
                        "type": "string",
                        "required": true,
                        "pattern": "^[0-9]*$",
                        "inputType" : "Sono ammessi solo caratteri numerici",
                        "properties": {}
                    },
                    "fax": {
                        "type": "string",
                        "required": false,
                        "pattern": "^[0-9]*$",
                        "properties": {}
                    },
                    "cellulare": {
                        "type": "string",
                        "required": false,
                        "pattern": "^[0-9]*$",
                        "properties": {}
                    },
                    "email": {
                        "type": "string",
                        "required": true,
                        "pattern": {},
                        "properties": {}
                    },
                    "pec": {
                        "type": "string",
                        "required": false,
                        "pattern": {},
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "labelRecapiti": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Recapito Attuale",
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
                    "provComuneRecapito": {
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
                    "indirizzoRecapito": {
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
                    "civicoRecapito": {
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
                    "esponenteRecapito": {
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
                    "telefono": {
                        "label": "Telefono",
                        "type": "text",
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
                    "fax": {
                        "label": "Fax",
                        "type": "text",
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
                    "cellulare": {
                        "label": "Cellulare",
                        "type": "text",
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
                    "email": {
                        "label": "Email",
                        "type": "email",
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
                    "pec": {
                        "label": "PEC",
                        "type": "email",
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
    	"messages": {
            "invalidEmail": "Inserire una email valida",
            "invalidPattern": "Inserire un valore numerico",
            "stringNotAnInteger": "Inserire un valore numerico",
            "notOptional": "Campo obbligatorio"
        },
    	"templates": {
    		"container": datiRecapitiContainer,
    		"container-object": datiRecapitiContainerObject
    	}
    });
    Alpaca.registerFieldClass("datiRecapiti", Alpaca.Fields.datiRecapiti);
    

})(jQuery);