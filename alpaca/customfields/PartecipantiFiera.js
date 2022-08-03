var partecipantiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var partecipantiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div> <div class="row"> <div class="col-md-12 paddingleft20">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center"></div> <div class="col-md-2 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12"> <div class="col-md-3 text-center">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> <div class="col-md-2 text-center">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div> </div> </div> <div class="row"> <div class="col-md-12">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div> </div> </div>\
	</div>\
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.PartecipantiFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.PartecipantiFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "partecipantiFiere";
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
						"partecipantiLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiItaliani": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiEsteri": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiTotaliLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "visitatoriLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "visTotaleItaliani": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "visTotaleEsteri": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "visTotali": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "totaleStaffEspositoriLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "staffTotaleItaliani": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "staffTotaleEsteri": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "staffTotali": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "totaleAddettiStampaLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "stampaTotaleItaliani": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "stampaTotaleEsteri": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "stampaTotali": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "totaleRelatori": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "relatoriTotaleItaliani": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "relatoriTotaleEsteri": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "relatoriTotali": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "numeroPartecipantiLabel": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiTotaleItaliani": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiTotaleEsteri": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "partecipantiTotali": {
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "required": true,
		                    "properties": {}
		                },
		                "piePagina": {
		                    "type": "string",
		                    "required": true,
		                    "properties": {}
		                }
				  }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
					"partecipantiLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 1,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "partecipantiItaliani": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 2,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "partecipantiEsteri": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 3,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "partecipantiTotaliLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 4,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "visitatoriLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 5,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "visTotaleItaliani": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 6,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "visTotaleEsteri": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 6,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "visTotali": {
	                    "type": "text",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 7,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totaleStaffEspositoriLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 8,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "staffTotaleItaliani": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 9,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "staffTotaleEsteri": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 10,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "staffTotali": {
	                    "type": "text",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 11,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totaleAddettiStampaLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 12,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "stampaTotaleItaliani": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 13,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "stampaTotaleEsteri": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 14,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "stampaTotali": {
	                    "type": "text",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 15,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totaleRelatori": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 16,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "relatoriTotaleItaliani": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 17,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "relatoriTotaleEsteri": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 18,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "relatoriTotali": {
	                    "type": "text",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 19,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "numeroPartecipantiLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 20,
	                    "helpers": [],
	                    "fieldClass": "",
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
	                    "view": "bootstrap-display"
	                },
	                "partecipantiTotaleItaliani": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 21,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "partecipantiTotaleEsteri": {
	                    "type": "text",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 22,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "partecipantiTotali": {
	                    "type": "text",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 23,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "piePagina": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 24,
	                    "helpers": [],
	                    "fieldClass": " paddingleft10",
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
	                    "view": "bootstrap-display"
	                }
                },
                "view": "partecipanti-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Partecipanti per Scheda Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "I totali sono calcolati automaticamente";
        }
    });
   
    Alpaca.registerView({
	  	"id": "partecipanti-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "stringNotANumber": "Inserire un valore numerico",
	        "invalidPattern": "Inserire un valore numerico"
	    },
		"templates": {
			"container": partecipantiContainer,
			"container-object": partecipantiContainerObject
		}
    });
    Alpaca.registerFieldClass("partecipantiFiere", Alpaca.Fields.PartecipantiFiere); 
  
    
})(jQuery);