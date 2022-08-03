var dativeicoloContainer = ' \
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
    	                "tipoVeicolo": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "enum": [
	                            "A",
	                            "C",
	                            "M",
	                            "R"
    	                    ],
    	                    "properties": {}
    	                },
    	                "targaVeicolo": {
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
	                    "tipoVeicolo": {
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
	                            "Autoveicolo",
	                            "Ciclomotore",
	                            "Motoveicolo",
	                            "Rimorchio"
	                        ],
	                        "removeDefaultNone": false,
	                        "noneLabel": "--Seleziona--",
	                        "hideNone": false,
	                        "useDataSourceAsEnum": true,
	                        "multiple": false,
	                        "sort": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fieldClass": "select2ac1",
	                        "fields": {}
	                    },
	                    "targaVeicolo": {
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
    
})(jQuery);