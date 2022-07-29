var comuneProvinciaFiereContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var comuneProvinciaFiereContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
	
    Alpaca.Fields.ComuneProvinciaFiere = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ComuneProvinciaFiere.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "comuneProvinciaFiere";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
                "type":"object",
                "properties": {                 
                    "provincia": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "comune": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {                   
                    "provincia": {
	                    "label": "Provincia",
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
                        "emptySelectFirst": true,
	                    "dataSource": function(callback) {
							$.ajax({
			                	url: getAllProvinceUrl,
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
                        "events": {
                            "ready": function(){
                                
                                var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
								if (comune != null && comune !== 'undefined') {
	                                if(!provincia){
										comune.options.optionLabels = [];
	                                	
										comune.getControlEl().val('');
										comune.getControlEl().prop('disabled', true);
	                                } else {
	                                	comune.options.dataSource = getComuniFiereUrl + "?provincia=" + provincia;;
	                                	var currentData = comune.data;
	                                    comune.refresh();
	                                    if (currentData) {
	                                    	comune.data = currentData;
	                                    	comune.setValue(currentData);
	                                    }
	                                }
								}
                            },
							"change": function(){
								
								var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
								if (comune != null && comune !== 'undefined') {
	                                if(!provincia){
	 									comune.options.optionLabels = [];
										comune.getControlEl().val('');
										comune.getControlEl().prop('disabled', true);
	                                }
	                                else {
										comune.getControlEl().val('');
	                                	comune.options.dataSource = getComuniFiereUrl + "?provincia=" + provincia;
	                                    comune.refresh();
	                                }
								}
							}
						}
	                },
	                "comune": {
	                    "label": "Comune",
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
                        "emptySelectFirst": true,
                        "useDataSourceAsEnum": false,
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {}
	                }
                },
                "view": "comuneProvinciaFiere-view"
            });
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Provincia Comune Per Fiere";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Provincia Comune Per Fiere";
        }
    });

    Alpaca.registerView({
    	"id": "comuneProvinciaFiere-view",
        "messages": {
            "notOptional": "Campo obbligatorio",
            "invalidValueOfEnum": "Selezionare prima la provincia"
        },
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": comuneProvinciaFiereContainer,
    		"container-object": comuneProvinciaFiereContainerObject
    	}
    });
    Alpaca.registerFieldClass("comuneProvinciaFiere", Alpaca.Fields.ComuneProvinciaFiere);
    

})(jQuery);
