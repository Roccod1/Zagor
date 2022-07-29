var datiVariazioneOccupantiTariContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiVariazioneOccupantiTariContainerObject = ' \
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
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiVariazioneOccupanteField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiVariazioneOccupanteField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiVariazioneOccupanteTari";
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
    	                "new1499087525820": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
                        "residenti-cognome": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "residenti-nome": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "residenti-datanascita": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "residenti-codfiscale": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "datioccupanti-tipovariazione": {
                            "readonly": false,
                            "required": false,
                            "disallow": [],
                            "enum": [
                                "Aggiunta",
                                "Modifica",
                                "Rimozione"
                            ],
                            "properties": {}
                        }

 
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
	                    "new1499087525820": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Occupante",
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
	                    "residenti-cognome": {
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
	                    "residenti-nome": {
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
	                    "residenti-datanascita": {
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
	                    "residenti-codfiscale": {
	                        "type": "text",
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
	                        "autocomplete": "false",
	                        "disallowEmptySpaces": false,
	                        "disallowOnlyEmptySpaces": false,
	                        "fields": {}
	                    },
	                    "datioccupanti-tipovariazione": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Tipo di variazione",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Aggiunta",
	                            "Modifica",
	                            "Rimozione"
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
	                        "fields": {},
	                        "readonly": false
	                    }

	                }   
            	},
            	"view": "variazioneoccupante-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati variazione occupanti tari";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati variazione occupanti tari";
        }
    });

    
    
    Alpaca.registerFieldClass("datiVariazioneOccupanteTari", Alpaca.Fields.DatiVariazioneOccupanteField); 
    
    Alpaca.registerView({
        "id": "variazioneoccupante-view",
        "parent": "bootstrap-create",
        "templates": {
        	"container": datiVariazioneOccupantiTariContainer,
        	"container-object": datiVariazioneOccupantiTariContainerObject
        }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiunta/Variazione Occupante"
    }, "variazioneoccupante-view");
    
})(jQuery);