var dietaScuolaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var dietaScuolaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    
    Alpaca.Fields.DietaScuolaSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DietaScuolaSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "dietaScuolaSelect";
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
                         "sceltaDieta": {
                             "required": true,
                             "enum": ["Normale", "Etico-Religiosa", "Speciale"],
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "sceltaDieta": {
                        "label": "Dieta: ",
                        "type": "select",
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "removeDefaultNone": false,
                        "hideInitValidationError": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": false,
                        "noneLabel": "--Seleziona--",
                        "fields": {},
                        "events": {
                            "change": function() {
                                console.log("in change");
                                
                                var campoDieta = this;
                                var tipoDieta = this.getValue();
								
                                var checkAllegato = $("div.cmd").find("input");
                                 if (checkAllegato.length == 0) {
                                	 campoDieta.options.disabled = true;
                                	 campoDieta.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                	 campoDieta.refresh();
                                	 campoDieta.getControlEl().val('');

                                 } else {
                                
		                             if(tipoDieta === "Speciale" || tipoDieta === "Etico-Religiosa"){
		                            	 checkAllegato[0].checked = true;
		                             } else {
		                            	 checkAllegato[0].checked = false;
		                             }
                                 }
                             }
                         }
                    }
                
                },
                "view": "dietaScuolaSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Select scelta dieta";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Select di scelta Dieta che rende allegato obbligatorio per dieta speciale e etico-religiosa";
        }
    });
   
    Alpaca.registerView({
	  	"id": "dietaScuolaSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Selezionare una delle opzioni."
	    },
		"templates": {
			"container": dietaScuolaContainer,
			"container-object": dietaScuolaContainerObject
		}
    });
    Alpaca.registerFieldClass("dietaScuolaSelect", Alpaca.Fields.DietaScuolaSelect); 
  
    
})(jQuery);