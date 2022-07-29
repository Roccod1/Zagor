
(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.AnagrafeFiglioServizioPrescuolaField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.AnagrafeFiglioServizioPrescuolaField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeFiglioServizioPrescuola";
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
    	                "figlio": {
    	                    "type": "object",
    	                    "required": false,
    	                    "properties": {
    	                    	"figlio-nominativo": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-codicefiscale": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-luogonascita": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-datanascita": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-scuola": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-classe": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "figlio-sezione": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                }
    	                    }
    	                }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
	                     "figlio": {
	                         "type": "object",
	                         "fields": {
	                        	 "figlio-nominativo": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "label": "Nome e Cognome",
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
	    	                     "figlio-codicefiscale": {
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
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "fields": {}
	    	                     },
	    	                     "figlio-luogonascita": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "label": "Nato/a a",
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
	    	                         "sort": false,
	    	                         "fields": {}
	    	                     },
	    	                     "figlio-datanascita": {
	    	                         "type": "date",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "label": "Il",
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
	    	                     "figlio-scuola": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "label": "Scuola",
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
	    	                     "figlio-classe": {
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
	    	                     },
	    	                     "figlio-sezione": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "label": "Sezione",
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
	                     }
	                }   
            	},
            	"view": "prescuola-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati anagrafici figlio (Servizio Prescuola)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati anagrafici figlio (Servizio Prescuola)";
        }
    });

    
    
    Alpaca.registerFieldClass("anagrafeFiglioServizioPrescuola", Alpaca.Fields.AnagrafeFiglioServizioPrescuolaField); 
    
    Alpaca.registerView({
        "id": "prescuola-view",
        "parent": "bootstrap-create",
        "templates": {}
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Figlio"
    }, "prescuola-view");
    
})(jQuery);