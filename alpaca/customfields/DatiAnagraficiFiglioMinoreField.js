var datiAnagrafeFiglioContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagrafeFiglioContainerObject = ' \
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
		<div class="row"> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
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
            return "datiAnagrafeFiglio";
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
    	                "new1496744267692": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744269610": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744302234": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744271717": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744278756": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744284858": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "new1496744289858": {
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
	                    "new1496744267692": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
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
	                        "showMessages": true,
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
	                    "new1496744302234": {
	                        "type": "date",
	                        "validate": true,
	                        "showMessages": true,
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
	                    },
	                    "new1496744271717": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Tipologia di Scuola",
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
	                    "new1496744278756": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Nome Istituto",
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
	                    "new1496744284858": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Luogo Istituto",
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
	                    "new1496744289858": {
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
	                        "autocomplete": "false",
	                        "disallowEmptySpaces": false,
	                        "disallowOnlyEmptySpaces": false,
	                        "fields": {}
	                    }
	                }   
            	},
            	"view": "datianagrafefiglio-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Anagrafe Figlio";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Anagrafe Figlio";
        }
    });

    
    
    Alpaca.registerFieldClass("datiAnagrafeFiglio", Alpaca.Fields.DatiAnagrafeFiglioField); 
    
    Alpaca.registerView({
        "id": "datianagrafefiglio-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": datiAnagrafeFiglioContainer,
        	"container-object": datiAnagrafeFiglioContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Figlio"
    }, "datianagrafefiglio-view");
    
})(jQuery);