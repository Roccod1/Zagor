var statiEsteriContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiEsteriContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiEsteriSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiEsteriSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiEsteriSelect";
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
                         "statiEsteri": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "statiEsteri": {
                        "type": "select",
                        "validate": false,
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
                        "label": "Stato estero: ",
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuno",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "helpers": [],
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "fields": {}
                    },
                
                },
                "view": "statiEsteriSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Stati Esteri Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Stati Esteri Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiEsteriSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiEsteriContainer,
			"container-object": statiEsteriContainerObject
		}
    });
    Alpaca.registerFieldClass("statiEsteriSelect", Alpaca.Fields.StatiEsteriSelect); 
  
    
})(jQuery);