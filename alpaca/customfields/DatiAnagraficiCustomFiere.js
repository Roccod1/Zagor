var datiAnagraficifiereContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficifiereContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row">\
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div>\
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficifiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiFiere";
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
                     "nome": {
                         "type": "string",
                         "required": false,
                         "properties": {}
                     },
                     "cognome": {
                         "type": "string",
                         "properties": {}
                     },
                     "codiceFiscale": {
                         "type": "string",
                         "required": false,
                         "properties": {}
                     },
                     "dataNascita": {
                         "type": "string",
                         "properties": {},
                         "required": true
                     },
                     "luogoNascita": {
                         "type": "string",
                         "properties": {},
                         "required": true
                   	},
                    "via": {
						"type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "civico": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"validate": false,
    			"showMessages": false,
                "fields": {
                    "nome": {
						"validate": false,
					    "showMessages": false,
                        "type": "text",
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {	
						"validate": false,
					    "showMessages": false,
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "codiceFiscale": {
						"validate": false,
					    "showMessages": false,
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data di nascita",
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
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		console.log("data di nascita value", this, this.getValue());
                        		if (!this.getValue() || this.getValue === "") {
                        			this.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    },
                    "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "disabled": true,
                        "renderButtons": true,
                        "events": {
                        	"ready": function () {
                        		console.log("luogo di nascita value", this, this.getValue());
                        		if (!this.getValue() || this.getValue === "") {
                        			this.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    },
                    "via": {
                        "type": "text",
                        "label": "Via",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		console.log("via value", this, this.getValue());
                        		if (!this.getValue() || this.getValue === "") {
                        			this.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    },
                    "civico": {
                        "type": "text",
                        "label": "Civico",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		console.log("civico value", this, this.getValue());
                        		if (!this.getValue() || this.getValue === "") {
                        			civicoResInput.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    }
                },
                "view": "datiAngraficiFiere-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Custom per Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici con civico separato dalla via";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAngraficiFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio",
	        "stringNotANumber": "Inserire un valore numerico",
	        "invalidValueOfEnum": "Selezionare un valore",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}"
	    },
		"templates": {
			"container": datiAnagraficifiereContainer,
			"container-object": datiAnagraficifiereContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAnagraficiFiere", Alpaca.Fields.DatiAnagraficiFiere); 
  
    
})(jQuery);