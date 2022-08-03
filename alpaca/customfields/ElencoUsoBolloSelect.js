var usoBolloContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var usoBolloContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.UsoBolloSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.UsoBolloSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "usoBolloSelect";
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
                         "usoBollo": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "usoBollo": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "dataSource": listaUsoBolloUrl,
                        "label": "",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "helpers": [],
                        "renderButtons": true,
                        "fields": {}
                    }
                
                },
                "view": "usoBolloSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Uso Bollo Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Uso Bollo Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "usoBolloSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": usoBolloContainer,
			"container-object": usoBolloContainerObject
		}
    });
    Alpaca.registerFieldClass("usoBolloSelect", Alpaca.Fields.UsoBolloSelect); 
  
    
})(jQuery);