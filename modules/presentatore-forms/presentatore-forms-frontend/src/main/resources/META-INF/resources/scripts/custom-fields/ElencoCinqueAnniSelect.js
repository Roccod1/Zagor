var cinqueAnniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var cinqueAnniContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.CinqueAnniSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CinqueAnniSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "cinqueAnniSelect";
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
                         "cinqueAnni": {
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "cinqueAnni": {
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "helpers": ["(yyyy)"],
                        "dataSource": listaFiveYearsUrl,
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
                "view": "cinqueAnniSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Ultimi Cinque Anni Select";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Ultimi 5 anni Select lista custom";
        }
    });
   
    Alpaca.registerView({
	  	"id": "cinqueAnniSelect-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": cinqueAnniContainer,
			"container-object": cinqueAnniContainerObject
		}
    });
    Alpaca.registerFieldClass("cinqueAnniSelect", Alpaca.Fields.CinqueAnniSelect); 
  
    
})(jQuery);