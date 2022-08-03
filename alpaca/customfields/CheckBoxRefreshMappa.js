var checkBoxRefreshMappaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var checkBoxRefreshMappaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.CheckBoxRefreshMappa = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CheckBoxRefreshMappa.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "checkBoxRefreshMappa";
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
                    	 "checkIndirizzoDifferente": {
                             "type": "boolean"
                         }
                     }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                	"checkIndirizzoDifferente": {
                        "rightLabel": "Indirizzo recupero rifiuti ingombranti differente da residenza",
                        "events": {
                        	"ready": function(){
	                        	var campoAlpacaMappa = this.parent.parent.childrenByPropertyId["customMappaIndirizzoDifferente"];
	                    		var labelAlpacaMappa = this.parent.parent.childrenByPropertyId["labelIndirizzoDifferente"];
	                    		if (campoAlpacaMappa) {
                    				campoAlpacaMappa.refresh();
                    			}
	                    		if(!this.getValue()) {
	                    			if (campoAlpacaMappa) {
	                    				campoAlpacaMappa.hide();
	                    			}
	                    			if (labelAlpacaMappa){
	                    				labelAlpacaMappa.hide();
	                    			}
                        		}
                        	},
                        	"change": function(){
                        		console.log("in change check");
                        		var campoAlpacaMappa = this.parent.parent.childrenByPropertyId["customMappaIndirizzoDifferente"];
                    			var labelAlpacaMappa = this.parent.parent.childrenByPropertyId["labelIndirizzoDifferente"];
                        		if (this.getValue()) {
                           			if (campoAlpacaMappa) {
                        				campoAlpacaMappa.refresh();
                        				campoAlpacaMappa.show();
                        			}
                        			if (labelAlpacaMappa){
                        				labelAlpacaMappa.show();
                        			}
                        		}
                        		else {
                        			if (campoAlpacaMappa) {
                        				campoAlpacaMappa.hide();
                        			}
                        			if (labelAlpacaMappa){
                        				labelAlpacaMappa.hide();
                        			}
                        		}
                        	}
                        }
                    }
                },
                "view": "checkBoxRefreshMappa-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Checkbox refresh Mappa ";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "checkbox con verifica presenza mappa e refresh";
        }
    });
   
    Alpaca.registerView({
	  	"id": "checkBoxRefreshMappa-view",
	  	"parent": "bootstrap-create",
		"templates": {
			"container": checkBoxRefreshMappaContainer,
			"container-object": checkBoxRefreshMappaContainerObject
		}
    });
    Alpaca.registerFieldClass("checkBoxRefreshMappa", Alpaca.Fields.CheckBoxRefreshMappa); 
  
    
})(jQuery);