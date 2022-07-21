var durataPassiCarrabiliContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var durataPassiCarrabiliContainerObject = ' \
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

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DurataPassiCarrabili = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DurataPassiCarrabili.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "durataPassiCarrabili";
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
	                        "0"
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
                "view": "durataPassiCarrabili-view",
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
							"click": function() {
								conosle.log("change");
					        	this.parent.childrenByPropertyId["mesi"].setValue();
					        	this.parent.childrenByPropertyId["giorni"].setValue();
								
					        	this.parent.childrenByPropertyId["mesi"].getControlEl().attr("disabled", false);
					        	this.parent.childrenByPropertyId["giorni"].getControlEl().attr("disabled", false);
					        	
								this.parent.childrenByPropertyId["anni"].setValue();
					        	this.parent.childrenByPropertyId["mesi"].setValue();
					        	this.parent.childrenByPropertyId["giorni"].setValue();
					        	
					        /*	this.parent.childrenByPropertyId["mesi"].refresh();
					        	this.parent.childrenByPropertyId["giorni"].refresh();
					        	*/

								if(this.getValue() === "1"){
									this.parent.childrenByPropertyId["anni"].schema.maximum = 1;
									this.parent.childrenByPropertyId["anni"].schema.minimum = 0;
								/*	this.parent.childrenByPropertyId["anni"].refresh();*/
								}else if( this.getValue() === "Permanente"){
									this.parent.childrenByPropertyId["anni"].schema.maximum = 29;
									this.parent.childrenByPropertyId["anni"].schema.minimum = 2;
									/*this.parent.childrenByPropertyId["anni"].refresh();*/
								}
							},
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
								if (this.getValue() === 0 && this.parent.childrenByPropertyId["mesi"].getValue() === 0 && this.parent.childrenByPropertyId["giorni"].getValue() === 0) {
									this.setValue(null);
									this.parent.childrenByPropertyId["mesi"].setValue(null);
									this.parent.childrenByPropertyId["giorni"].setValue(null);
								}
								
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
                    			
                    			this.getControlEl().attr("disabled", true);
	                    		
	                    		console.log("anni value", this, this.getValue());
	                    		if (!this.getValue() || this.getValue() === "") {
									console.log("Anni non Valorizzata, abilito");
	                    			this.getControlEl().attr("disabled", false);
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
								if (this.getValue() === 0 && this.parent.childrenByPropertyId["anni"].getValue() === 0 && this.parent.childrenByPropertyId["giorni"].getValue() === 0) {
									this.setValue(null);
									this.parent.childrenByPropertyId["anni"].setValue(null);
									this.parent.childrenByPropertyId["giorni"].setValue(null);
								}
							},
	                    	"ready": function () {
	                    		
	                    		this.getControlEl().attr("disabled", true);
	                    		
	                    		console.log("mesi value", this, this.getValue());
	                    		if (!this.getValue() || this.getValue() === "") {
									console.log("Mesi non Valorizzata, abilito");
	                    			this.getControlEl().attr("disabled", false);
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
								if (this.getValue() === 0 && this.parent.childrenByPropertyId["anni"].getValue() === 0 && this.parent.childrenByPropertyId["mesi"].getValue() === 0) {
									this.setValue(null);
									this.parent.childrenByPropertyId["anni"].setValue(null);
									this.parent.childrenByPropertyId["mesi"].setValue(null);
								}
							},
	                    	"ready": function () {
	                    		
	                    		this.getControlEl().attr("disabled", true);
	                    		
	                    		console.log("giorni value", this, this.getValue());
	                    		if (!this.getValue() || this.getValue() === "") {
									console.log("Giorni non Valorizzata, abilito");
	                    			this.getControlEl().attr("disabled", false);
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
            return "Durata Passi Carrabili";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Custom per la durata dei passi carrabili in base alla concessione Temporanea/Permanente";
        }
    });

    Alpaca.registerView({
    	"id": "durataPassiCarrabili-view",
    	"parent": "bootstrap-create",
    	"messages": {
			"notOptional": "Campo obbligatorio",
	        "stringNotANumber": "Inserire un valore numerico",
	        "invalidValueOfEnum": "Selezionare un valore",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}",
	    },
    	"templates": {
    		"container": durataPassiCarrabiliContainer,
    		"container-object": durataPassiCarrabiliContainerObject
    	}
    });
    Alpaca.registerFieldClass("durataPassiCarrabili", Alpaca.Fields.DurataPassiCarrabili);
    

})(jQuery);