var datiLocaliAreeRimborsoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiLocaliAreeRimborsoContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiImmobileLocaliAreeRimborsoField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiImmobileLocaliAreeRimborsoField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiLocaliAreeRimborso";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function() {
            this.base();

            this.schema = {
            	"minItems": 1,
            	"items": {
    	            "title": "",
    	            "type": "object",
    	            "properties": {
    	                "new1497339853276": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1497339855589": {
    	                    "readonly": false,
    	                    "required": false,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1497339857977": {
    	                    "readonly": false,
    	                    "required": false,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "new1497359997296": {
    	                    "readonly": false,
    	                    "required": false,
    	                    "type": "string",
    	                    "properties": {}
    	                }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "hideToolbarWithChildren": false,
            	"items": {
	                "fields": {
	                    "new1497339853276": {
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
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "attributes": {},
	                        "fields": {}
	                    },
	                    "new1497339855589": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Superficie",
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
	                    "new1497339857977": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Imp. dovuto",
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
	                    "new1497359997296": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Imp. versato",
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
	                        "fields": {},
	                        "readonly": false
	                    }
	                }   
            	},
            	"view": "localiareerimborso-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Locali/Aree (rimborso)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Locali/Aree (rimborso)";
        }
    });

    
    
    Alpaca.registerFieldClass("datiLocaliAreeRimborso", Alpaca.Fields.DatiImmobileLocaliAreeRimborsoField); 
    
    Alpaca.registerView({
        "id": "localiareerimborso-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": datiLocaliAreeRimborsoContainer,
        	"container-object": datiLocaliAreeRimborsoContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Locali/Aree"
    }, "localiareerimborso-view");
    
})(jQuery);