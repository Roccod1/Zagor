var durataRinnovoPassiCarrabiliContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var durataRinnovoPassiCarrabiliContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

var parent;

function notZero(parent){
	console.log("NOT ZERO");
	if (parent.childrenByPropertyId["anni"].getValue() === 0 
			&& parent.childrenByPropertyId["mesi"].getValue() === 0 
				&& parent.childrenByPropertyId["giorni"].getValue() === 0) {
					
		parent.childrenByPropertyId["anni"].setValue(null);
		parent.childrenByPropertyId["mesi"].setValue(null);
		parent.childrenByPropertyId["giorni"].setValue(null);
	}
};

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DurataRinnovoPassiCarrabili = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DurataRinnovoPassiCarrabili.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "durataRinnovoPassiCarrabili";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function()
        {
            this.base();

            this.schema = {
				"title": "",
        	    "description": "",
        	    "type": "object",
        	    "required": false,
        	    "properties": {
        	        "concessione": {
        	            "readonly": false,
	                    "required": true,
	                    "enum": [
	                        "1",
	                        "2"
	                    ],
	                    "properties": {}
        	        },
	                "anni": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "number",
	                    "minimum": 0,
	                    "properties": {}
	                },
	                "mesi": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "number",
	                    "minimum": 0,
                		"maximum": 11,
	                    "properties": {}
	                },
	                "giorni": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "number",
	                    "minimum": 0,
                		"maximum": 31,
	                    "properties": {}
	                }
        	    }
        	};
        	
        	Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "showButtons": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "view": "durataRinnovoPassiCarrabili-view",
                "fields": {
					"concessione": {
	                    "type": "radio",
	                    "label": "Concessione",
	                    "vertical": false,
	                    "hideNone": true,
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 1,
	                    "optionLabels": [
	                        "Temporanea",
	                        "Permanente"
	                    ],
	                    "emptySelectFirst": false,
	                    "fields": {},
	                    "events": {
							/*"click": function() {
					        	this.parent.childrenByPropertyId["mesi"].setValue();
					        	this.parent.childrenByPropertyId["giorni"].setValue();
								
					        	this.parent.childrenByPropertyId["mesi"].getControlEl().attr("disabled", false);
					        	this.parent.childrenByPropertyId["giorni"].getControlEl().attr("disabled", false);
					        	
								this.parent.childrenByPropertyId["anni"].setValue();
					        	this.parent.childrenByPropertyId["mesi"].setValue();
					        	this.parent.childrenByPropertyId["giorni"].setValue();

								if(this.getValue() === "Temporanea"){
									this.parent.childrenByPropertyId["anni"].schema.maximum = 1;
									this.parent.childrenByPropertyId["anni"].schema.minimum = 0;
								}else if( this.getValue() === "Permanente"){
									this.parent.childrenByPropertyId["anni"].schema.maximum = 29;
									this.parent.childrenByPropertyId["anni"].schema.minimum = 2;
								}
							},*/
                        	"ready": function () {
								this.getControlEl().attr("disabled", true);
                        		console.log("concessione", this.getValue());
                        		if (!this.getValue() || this.getValue() === "") {
									console.log("Concessione non Valorizzata, abilito");
	                    			this.getControlEl().attr("disabled", false);
	                    		}
                        	}
						}
	                },
	                "anni": {
	                    "type": "number",
	                    "validate": true,
	                    "showMessages": true,
	                    "numericEntry": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "label": "Anno/i",
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": true,
	                    "disallowOnlyEmptySpaces": true,
	                    "sort": false,
	                    "order": 2,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
							"change": function() {
								
								notZero(this.parent);
								
								if (this.getValue() === this.schema.maximum) {
									this.parent.childrenByPropertyId["mesi"].setValue(0);
					        		this.parent.childrenByPropertyId["giorni"].setValue(0);
					        		this.parent.childrenByPropertyId["mesi"].getControlEl().attr("disabled", true);
					        		this.parent.childrenByPropertyId["giorni"].getControlEl().attr("disabled", true);
									
								} else {
					        		this.parent.childrenByPropertyId["mesi"].getControlEl().attr("disabled", false);
					        		this.parent.childrenByPropertyId["giorni"].getControlEl().attr("disabled", false);
								}
							},
	                    	"ready": function () {
								if(this.parent.childrenByPropertyId["concessione"].getValue() === "1"){
									this.getControlEl().attr("disabled", true);
									this.schema.maximum = 0;
									if(this.getValue() === 1){
										this.parent.childrenByPropertyId["mesi"].getControlEl().attr("disabled", true);
					        			this.parent.childrenByPropertyId["giorni"].getControlEl().attr("disabled", true);
									}
								}
	                    	}
						}
	                },
	                "mesi": {
	                    "type": "number",
	                    "validate": true,
	                    "numericEntry": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "label": "Mese/i",
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": true,
	                    "disallowOnlyEmptySpaces": true,
	                    "sort": false,
	                    "order": 3,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
	                    	"change": function(){
								notZero(this.parent);
							},
	                    	"ready": function () {
								if(this.parent.childrenByPropertyId["concessione"].getValue() === "1"){
		                    		var max = 11 - this.getValue();
									this.parent.childrenByPropertyId["mesi"].schema.maximum = max;
		                    	}
	                    	}
						}
	                },
	                "giorni": {
	                    "type": "number",
	                    "validate": true,
	                    "numericEntry": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "label": "Giorno/i",
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": true,
	                    "disallowOnlyEmptySpaces": true,
	                    "sort": false,
	                    "order": 4,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
	                    	"change": function(){
								notZero(this.parent);
							},
	                    	"ready": function () {	                    		
	                    		if(this.parent.childrenByPropertyId["concessione"].getValue() === "1"){
		                    		var max = 31 - this.getValue();
									this.parent.childrenByPropertyId["giorni"].schema.maximum = max;
		                    	}
		                    }
						}
	                }
				}
			});
        },
        
        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Durata Rinnovo Passi Carrabili";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Custom per la durata del rinnovo dei passi carrabili in base alla concessione Temporanea/Permanente";
        }
    });

    Alpaca.registerView({
    	"id": "durataRinnovoPassiCarrabili-view",
    	"parent": "bootstrap-create",
    	"messages": {
			"notOptional": "Campo obbligatorio",
	        "stringNotANumber": "Inserire un valore numerico",
	        "invalidValueOfEnum": "Selezionare un valore",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}",
	    },
    	"templates": {
    		"container": durataRinnovoPassiCarrabiliContainer,
    		"container-object": durataRinnovoPassiCarrabiliContainerObject
    	}
    });
    Alpaca.registerFieldClass("durataRinnovoPassiCarrabili", Alpaca.Fields.DurataRinnovoPassiCarrabili);
    

})(jQuery);