var statiCittadinanzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiCittadinanzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiSelectCittadinanza = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiSelectCittadinanza.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiSelectCittadinanza";
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
                         "stati": {
                        	 "default": "100",
                             "required": true,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "stati": {
                    	"label": "Cittadinanza:",
                        "type": "select",
                        "fieldClass": "select2ac1",
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
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
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": false,
                        "helpers": [],
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fields": {}
                    },
                
                },
                "view": "statiSelectCittadinanza-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Nazioni Select Cittadinanza";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Nazioni Select lista custom Cittadinanza";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiSelectCittadinanza-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiCittadinanzaContainer,
			"container-object": statiCittadinanzaContainerObject
		}
    });
    Alpaca.registerFieldClass("statiSelectCittadinanza", Alpaca.Fields.StatiSelectCittadinanza); 
  
    
})(jQuery);