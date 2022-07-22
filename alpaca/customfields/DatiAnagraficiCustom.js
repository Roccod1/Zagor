
(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAngraficiCustom";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            		 "type": "object",
                     "properties": {
                         "codiceFiscale": {
                             "title": "Cod.Fiscale",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "nome": {
                             "title": "Nome",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "cognome": {
                             "title": "Cognome",
                             "type": "string",
                             "properties": {}
                         },
                         "dataNascita": {
                             "title": "Data di nascita",
                             "type": "string",
                             "properties": {}
                         },
                         "comuneNascita": {
                             "title": "Residenza",
                             "type": "string",
                             "properties": {}
                       },
                       	"indirizzoResidenza":{
                        	 "title": "Indirizzo Residenza",
                             "type": "string",
                             "properties": {}
                         },
                         "identificativo": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "identificativoFamiglia": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         }
                     }
            };
            
            Alpaca.merge(this.options, {
            	"type":"object",
            	"label": "",
                "fields": {
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "nome": {
                        "type": "text",
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data  Nascita",
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
                
                    "comuneNascita": {
                        "type": "text",
                        "label": "Comune nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo Residenza",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "identificativo": {
                        "label": "Identificativo",
                        "type": "hidden",
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
                    "identificativoFamiglia": {
                        "label": "Identificativo",
                        "type": "hidden",
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
                "view": "datiAngraficiCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Custom";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici Custom";
        }
    });

    
    
    Alpaca.registerFieldClass("datiAngraficiCustom", Alpaca.Fields.DatiAnagraficiCustom); 
    
    Alpaca.registerView({
    	"parent": "bootstrap-display-horizontal",
    	"id": "datiAngraficiCustom-view",
    	"templates": {}
    });

    
    
})(jQuery);