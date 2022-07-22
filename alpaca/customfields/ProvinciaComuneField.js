var comuneProvinciaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var comuneProvinciaContainerObject = ' \
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
    
	var getQsUnifier = function(url) {
		if (url.lastIndexOf('?') >= 0) {
			return '&';
		}
		return '?';
	};
	
    Alpaca.Fields.ProvinciaComuneField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ProvinciaComuneField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "provinciaComune";
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
                        "required": false,
                        "default": "",
                        "properties": {}
                    },
                    "comune": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {                   
                    "provincia": {
                    	"fieldClass" : "select2ac1 notSelect2",
                    	"type": "provincia",
                        "validate": false,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Provincia",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "focus": false,
                        "optionLabels": [], 
                        "removeDefaultNone": false,
                        "noneLabel": "Nessuna",
                        "hideNone": false,
                        "useDataSourceAsEnum": false,
                        "dataSource": function(callback) {
                        	if (provinceJsonCF.length > 0) {
                        		callback(provinceJsonCF);
                        	} else {
                        		$.ajax({
				                	  url: listaProvinceUrl,
				                    dataType: 'json',
				                    delay: 0,
				                    timeout: 20000,
				                    error: function () {
				                    	console.log("error");
				                    	callback([]);
		                            },
		                            success: function (data) {
		                            	provinceJsonCF = data;
		                            	callback(provinceJsonCF);
		                            }
				                  });
                        	}
                        },
                        "multiple": false, 
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                                var provincia = this.getValue();
								var comune = this.parent.childrenByPropertyId['comune'];
								if (comune != null && comune !== 'undefined') {
									var dataSource = listaComuniUrl;
	                                if(!provincia){
	 									comune.options.optionLabels = [];
										comune.schema.enum = [];
										comune.getControlEl().val('');
										comune.getControlEl().prop('disabled', true);
	                                }
	                                else {
	                                	dataSource += getQsUnifier(dataSource) + 'sigla=' + provincia;
	                                	comune.options.dataSource = dataSource;
										comune.getControlEl().val('');
	                                    comune.refresh();
										comune.getControlEl().val('');
	                                }
								}
                            },
                            "ready": function(){
                            	var provincia = this.getValue();
                            	console.log('valore provincia ', provincia);
								var comune = this.parent.childrenByPropertyId['comune'];
								if (comune != null && comune !== 'undefined') {
									var dataSource = listaComuniUrl;
	                                if(!provincia){
										comune.options.optionLabels = [];
										comune.schema.enum = [];
	                                	
										comune.getControlEl().val('');
										comune.getControlEl().prop('disabled', true);
	                                } else {
	                                	dataSource += getQsUnifier(dataSource) + 'sigla=' + provincia;
	                                	comune.options.dataSource = dataSource;
	                                	var currentData = comune.data;
	                                    comune.refresh();
	                                    if (currentData) {
	                                    	comune.data = currentData;
	                                    	comune.setValue(currentData);
	                                    }
	                                }
								}
                            }
                        }
                    },
                    "comune": {
                    	"fieldClass" : "select2ac1 notSelect2",
                    	"type": "comune",
                        "validate": false,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Comune",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "focus": false,
                        "optionLabels": [],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": false,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                            "change": function() {
                                //console.log(this.name + ": change to -> " + this.getValue());
                            },
                            "ready": function(){
                            	/*var provincia = this.parent.childrenByPropertyId['provincia'];
                            	//console.log('Comune ready! Provincia', provincia.getValue());
                                if(!provincia.getValue()){
                                	this.hide();
                                }*/
                            }
                        }
                    }
                },
                "view": "provinciacomune-view"
            });
        },
        
        /*
        postRender: function(control) {
        	console.log('control', control, arguments);
            var nazione = control.childrenByPropertyId["nazione"];
            var provincia = control.childrenByPropertyId["provincia"];
            console.log('Questa è la nazione', nazione);
            nazione.on("change", function() {
                //Qui dobbiamo caricare le province in base allo stato
            	console.log('La nazione è cambiata');
            });
        },
         */
        
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);
        	/*
            var self = this;

            var field = this.getControlEl();

            this.base(model, function() {
            	//$(field).parent().find( "label" ).css( "color", "red" );
                $(field).remove();

                callback();

            });
            */
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Provincia Comune";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Provincia Comune";
        }
    });

    Alpaca.registerView({
    	"id": "provinciacomune-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": comuneProvinciaContainer,
    		"container-object": comuneProvinciaContainerObject
    	}
    });
    Alpaca.registerFieldClass("provinciaComune", Alpaca.Fields.ProvinciaComuneField);
    

})(jQuery);
