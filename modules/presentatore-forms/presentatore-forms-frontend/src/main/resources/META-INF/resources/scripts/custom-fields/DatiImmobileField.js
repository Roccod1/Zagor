var datiImmobileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiImmobileContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiImmobileField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiImmobileField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiImmobile";
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
    	            	"new1496306342825": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "==",
    	                        "NCT"
    	                    ],
    	                    "properties": {}
    	                },
    	                "new1496306349435": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "type": "number",
    	                    "exclusiveMinimum": false,
    	                    "exclusiveMaximum": false,
    	                    "properties": {}
    	                },
    	                "new1496306351452": {
    	                	"readonly": false,
    	                    "required": true,
    	                    "type": "number",
    	                    "exclusiveMinimum": false,
    	                    "exclusiveMaximum": false,
    	                    "properties": {}
    	                },
    	                "new1496306353079": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1496306357934": {
    	                    "type": "string",
    	                    "required": true,
    	                    "properties": {}
    	                },
    	                "new1496306361930": {
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
	                	"new1496306342825": {
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
	                    "new1496306349435": {
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
	                    "new1496306351452": {
	                    	"label": "Mappale",
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
	                    "new1496306353079": {
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
	                    "new1496306357934": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Categoria",
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
	                    "new1496306361930": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Classe",
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
            	"view": "immobile-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Immobile";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Immobile";
        }
    });

    
    
    Alpaca.registerFieldClass("datiImmobile", Alpaca.Fields.DatiImmobileField); 
    
    Alpaca.registerView({
        "id": "immobile-view",
        "parent": "bootstrap-create",
        "messages": {
            "notOptional": "Campo obbligatorio",
            "invalidValueOfEnum": "Selezionare una delle opzioni",
            "disallowValue": "Non è possibile effettuare questa scelta.",
            "stringNotANumber": "Inserire un valore numerico."
        },
        "templates": {
        	"container": datiImmobileContainer,
        	"container-object": datiImmobileContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Immobile"
    }, "immobile-view");
    
})(jQuery);