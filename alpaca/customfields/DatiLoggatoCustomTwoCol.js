var datiLoggatoCustomTwoColContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiLoggatoCustomTwoColContainerObject = ' \
	<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiLoggatoCustomTwoCol = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiLoggatoCustomTwoCol.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiLoggatoCustomTwoCol";
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
                         "codiceFiscale": {
                             "title": "Cod.Fiscale",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "dataNascita": {
                             "title": "Data di nascita",
                             "type": "string",
                             "properties": {},
                             "required": true
                         },
                         "luogoNascita": {
                             "title": "Luogo di nascita",
                             "type": "string",
                             "properties": {},
                             "required": true
                       },
                         "indirizzoResidenza":{
                        	 "title": "Indirizzo Residenza",
                             "type": "string",
                             "properties": {}
                         },
                         "viaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "civicoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "esponenteHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "scalaHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "pianoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "internoHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "capHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "provinciaResHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "comuneResHidden": {
                             "type": "string",
                             "required": false,
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
                         },
                         "isDelegato": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
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
                    "codiceFiscale": {
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
                        "disabled": false,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		this.getControlEl().attr("disabled", true);
                        		var isDelegatoField = this.parent.childrenByPropertyId["isDelegato"];
                        		if (isDelegatoField && isDelegatoField.getValue() === "true") {
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
                        		var isDelegatoField = this.parent.childrenByPropertyId["isDelegato"];
                        		if (isDelegatoField && isDelegatoField.getValue() === "true") {
                        			this.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo di residenza",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "viaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		var indirizzoResInput = this.parent.childrenByPropertyId["indirizzoResidenza"];
                        		console.log("via hidden value", this, this.getValue());
                        		console.log("indirizzo input", indirizzoResInput);
                        		if (!this.getValue() || this.getValue === "") {
                        			indirizzoResInput.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
                    },
                    "civicoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "esponenteHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "scalaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "pianoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "internoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "capHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "provinciaResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "comuneResHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
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
                    },
                    "isDelegato": {
                        "label": "delegato",
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
                "view": "datiLoggatoCustomTwoCol-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati utente loggato Custom (Due Colonne)";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati utente loggato Custom con layout a due colonne";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiLoggatoCustomTwoCol-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	    },
		"templates": {
			"container": datiLoggatoCustomTwoColContainer,
			"container-object": datiLoggatoCustomTwoColContainerObject
		}
    });
    Alpaca.registerFieldClass("datiLoggatoCustomTwoCol", Alpaca.Fields.DatiLoggatoCustomTwoCol); 
  
    
})(jQuery);