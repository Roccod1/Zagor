var datiAnagraficiMinoreFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiMinoreFieldContainerObject = ' \
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
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiMinoreField = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiMinoreField.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiMinoreField";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            		"title": "",
            	    "description": "",
            		"type": "object",
                    "required": false,
                    "properties": {
                        "nomeMinore": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "cognomeMinore": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "codFiscMinore": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "dataNascitaMinore": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "provComuneRequiredMinore": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        }, 
                        "inseritoManualmente": {
                            "readonly": true,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        }
                    }
            };
            
            Alpaca.merge(this.options, {
            	"type": "object",
                "helpers": [],
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
                    "nomeMinore": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": true,
                        "hidden": false,
                        "label": "Nome:",
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
                        "rows": 5,
                        "cols": 40,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "cognomeMinore": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": true,
                        "hidden": false,
                        "label": "Cognome:",
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
                        "rows": 5,
                        "cols": 40,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "codFiscMinore": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": true,
                        "hidden": false,
                        "label": "Codice Fiscale: ",
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
                        "rows": 5,
                        "cols": 40,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "dataNascitaMinore": {
                        "type": "date",
                        "label": " Data nascita (dd/mm/yyyy):",
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
                        "showMessages": true,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "provComuneRequiredMinore": {
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": true,
                        "hidden": false,
                        "label": "Luogo di nascita: ",
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
                        "rows": 5,
                        "cols": 40,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "inseritoManualmente": {
                    	"type": "text",
                        "disabled": true,
                        "hidden": true,
                        "label": "",
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
                        "rows": 5,
                        "cols": 40,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    }
                },
                "events": {
                	"ready": function(){
                		console.log("CF - delegaPresente " + delegaPresente);
                		console.log("CF - codiceFiscaleSelezioneManuale " + codiceFiscaleSelezioneManuale);
                		console.log("CF - codiceFiscaleComponente " + codiceFiscaleComponente);
                		var self = this;
                		var nomeMinoreField = self.childrenByPropertyId['nomeMinore'];
                		var cognomeMinoreField = self.childrenByPropertyId['cognomeMinore'];
                		var codFiscMinoreField = self.childrenByPropertyId['codFiscMinore'];
                		var dataNascitaMinoreField = self.childrenByPropertyId['dataNascitaMinore'];
                		var provComuneRequiredMinoreField = self.childrenByPropertyId['provComuneRequiredMinore'];
                		
                		if(delegaPresente == true && codiceFiscaleSelezioneManuale == "true"){
                			console.log("Delega presente e codice fiscale manuale");
                			
                    		nomeMinoreField.options.disabled = false;
                    		nomeMinoreField.refresh();
                    		cognomeMinoreField.options.disabled = false;
                    		cognomeMinoreField.refresh();
                    		codFiscMinoreField.options.disabled = false;
                    		codFiscMinoreField.refresh();
                    		if(codiceFiscaleComponente){
                    			codFiscMinoreField.getControlEl().val(codiceFiscaleComponente);
                    		}
                    		dataNascitaMinoreField.options.disabled = false;
                    		dataNascitaMinoreField.refresh();
                    		
                    		provComuneRequiredMinoreField.options.disabled = false;
                    		provComuneRequiredMinoreField.refresh();
                    		
                    		inseritoManualmenteField.getControlEl().val(true);
                    		
                		} else {
                			console.log("Delega non presente o selezione non manuale");
                		}
                     }                    
                },
                "view": "datiAnagraficiMinoreField-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici Minore";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici Minore con layout a due colonne";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAnagraficiMinoreField-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	    },
		"templates": {
			"container": datiAnagraficiMinoreFieldContainer,
			"container-object": datiAnagraficiMinoreFieldContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAnagraficiMinoreField", Alpaca.Fields.DatiAnagraficiMinoreField); 
  
    
})(jQuery);