var statiEsteriRequiredContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiEsteriRequiredContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiEsteriRequiredSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiEsteriRequiredSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiEsteriRequiredSelect";
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
                         "statiEsteriRequired": {
                             "required": true,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "statiEsteriRequired": {
                        "type": "select",
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "dataSource": function(callback) {
                        	if (statiEsteriJsonCF.length > 0) {
                        		callback(statiEsteriJsonCF);
                        	} else {
                        		$.ajax({
				                	  url: listaStatiEsteriUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    timeout: 20000,
				                    error: function () {
				                    	console.log("error");
				                    	callback([]);
		                            },
		                            success: function (data) {
		                            	statiEsteriJsonCF = data;
		                            	callback(statiEsteriJsonCF);
		                            }
				                  });
                        	}
                        },
                        "label": "Stato: ",
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuno",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "helpers": [],
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fieldClass": "select2ac1",
                        "fields": {}
                    },
                
                },
                "view": "statiEsteriRequiredSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Stati Esteri Required Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Stati Esteri Required Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiEsteriRequiredSelect-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
            "notOptional": "Campo obbligatorio.",
            "invalidValueOfEnum": "Scelta non consentita."
        },
		"templates": {
			"container": statiEsteriRequiredContainer,
			"container-object": statiEsteriRequiredContainerObject
		}
    });
    Alpaca.registerFieldClass("statiEsteriRequiredSelect", Alpaca.Fields.StatiEsteriRequiredSelect); 
  
    
})(jQuery);