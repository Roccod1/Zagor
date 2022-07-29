var statiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var statiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.StatiSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.StatiSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "statiSelect";
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
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "stati": {
                        "type": "select",
                        "fieldClass": "select2ac1",
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
                        "label": "Stato: ",
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
                "view": "statiSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Nazioni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Nazioni Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "statiSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": statiContainer,
			"container-object": statiContainerObject
		}
    });
    Alpaca.registerFieldClass("statiSelect", Alpaca.Fields.StatiSelect); 
  
    
})(jQuery);