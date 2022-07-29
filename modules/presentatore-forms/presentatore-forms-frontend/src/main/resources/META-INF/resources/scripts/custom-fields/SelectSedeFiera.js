var sedeEventoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var sedeEventoContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		    <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.SelectSedeFiera = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.SelectSedeFiera.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "selectSedeFiera";
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
					"selectEvento": {
						"type": "string",
						"required": true,
						"properties": {}
					}				
				}
			};
			
			Alpaca.merge(this.options, {
				"validate": false,
				"showMessages": false,
		    	"label": "",
		        "fields": {
					"selectEvento":{						
						"label": "Selezionare il comune sede dell&apos;evento",
						"fieldClass" : "select2ac1 notSelect2",
						"type": "select",
						"validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": true,
                        "focus": false,
                        "optionLabels": [], 
                        "removeDefaultNone": false,
                        "noneLabel": "-- Seleziona --",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
						"dataSource": function(callback) {
							$.ajax({
			                	url: getAllComuniFiereUrl + "?denominazione=puglia",
			                    dataType: 'json',
			                    delay: 0,
			                    timeout: 20000,
			                    error: function (err) {
			                    	console.log("error", err);
			                    	callback([]);
	                            },
	                            success: function (data) {
	                            	callback(data);
	                            }
			                });
                        },
                        "sort": function(a, b) {
						    if (a.text > b.text) {
						        return 1;
						    } else if (a.text < b.text) {
						        return -1;
						    }
						    return 0;
						}
						                /*,
						"events":{
							"ready": function(){
								$(".eventoNonCensito").hide();
							}
						}*/
					}
				},
	                "view": "selectSedeFiera-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Select Per Sede Evento";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Select Sede Evento";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "selectSedeFiera-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": sedeEventoContainer,
			"container-object": sedeEventoContainerObject
		}
    });
    Alpaca.registerFieldClass("selectSedeFiera", Alpaca.Fields.SelectSedeFiera); 
  
    
})(jQuery);