var anniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anniContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.AnniSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.AnniSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "anniSelect";
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
                         "anni": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "anni": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "helpers": ["(yyyy)"],
                        "dataSource": listaYearsUrl,
                        "label": "Anno: ",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "fields": {}
                    }
                
                },
                "view": "anniSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Anni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Anni dal 1950 Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "anniSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": anniContainer,
			"container-object": anniContainerObject
		}
    });
    Alpaca.registerFieldClass("anniSelect", Alpaca.Fields.AnniSelect); 
  
    
})(jQuery);