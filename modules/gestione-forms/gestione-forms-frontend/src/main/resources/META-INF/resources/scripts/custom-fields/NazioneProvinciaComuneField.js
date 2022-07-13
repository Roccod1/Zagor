var nazioneComuneProvinciaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var nazioneComuneProvinciaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
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
	
    Alpaca.Fields.NazioneProvinciaComuneField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.NazioneProvinciaComuneField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "nazioneProvinciaComune";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "properties": {
            	        "nazioni": {
            	            "type": "object",
            	            "properties": {
            	                "stati": {
            	                    "default": "100",
            	                    "required": false,
            	                    "properties": {}
            	                }
            	            }
            	        },
            	        "provinciaComune": {
            	            "type": "object",
            	            "properties": {
            	            	"provincia": {
            	                    "required": true,
            	                    "default": "",
            	                    "properties": {}
            	                },
            	                "comune": {
            	                    "required": true,
            	                    "enum": [],
            	                    "properties": {}
            	                }
            	            }
            	        },
            	        "comuneEstero": {
            	            "required": true,
            	            "properties": {}
            	        }
            	    }
            	};
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
                	"nazioni": {
                        "type": "statiSelect",
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "view": "statiSelect-view",
                        "fields": {
                            "stati": {
                            	"fieldClass": "select2ac1",
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
                                "fields": {},
                                "events": {
                                    "ready": function(){
                                    	console.log('in ready per stati');
                                        var selectedNation = this.getValue();
                                    	var parentStati = this.parent;
                                    	console.log(parentStati);

                                    	var comuneEstero = parentStati.parent.childrenByPropertyId['comuneEstero'];
                                    	console.log(comuneEstero);

                                    	var provinciaComune = parentStati.parent.childrenByPropertyId['provinciaComune'];
                                        if(selectedNation != "100"){
                                        	comuneEstero.show();
                                        	provinciaComune.hide();
                                        } else {
                                        	comuneEstero.hide();
                                        	provinciaComune.show();
                                          } 
                                    },
                                    "change": function() {
                                    	console.log('in change');
                                        var selectedNation = this.getValue();
                                    	console.log(selectedNation);

                                    	var parentStati = this.parent;
                                    	console.log(parentStati);

                                    	var comuneEstero = parentStati.parent.childrenByPropertyId['comuneEstero'];
                                    	console.log(comuneEstero);

                                    	var provinciaComune = parentStati.parent.childrenByPropertyId['provinciaComune'];
                                        provinciaComune.refresh();
                                        if(selectedNation != "100"){
                                        	comuneEstero.show();
                                        	provinciaComune.hide();
                                        } else {
                                        	comuneEstero.hide();
                                        	provinciaComune.show();
                                          } 	                                  	
                                     }                          
                                }
                            }
                        }
                    },
                    "provinciaComune": {
                    	"type": "provinciaComuneRequired",
                        "label": "",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "collapsible": false,
                        "legendStyle": "button",
                        "view": "provinciacomunerequired-view",
                        "fields": {
                            "provincia": {
                            	"fieldClass" : "select2ac1",
                                "type": "provincia",
                                "validate": true,
                                "showMessages": true,
                                "disabled": false,
                                "hidden": false,
                                "label": "Provincia",
                                "helpers": [],
                                "hideInitValidationError": true,
                                "focus": false,
                                "optionLabels": [],
                                "removeDefaultNone": false,
                                "noneLabel": "--Seleziona--",
                                "hideNone": false,
                                "useDataSourceAsEnum": false,
                                "dataSource": "",
                                "multiple": false,
                                "multiselect": {
                                    "disableIfEmpty": true
                                },
                                "sort": false,
                                "renderButtons": true,
                                "events": {},
                                "fields": {}
                            },
                            "comune": {
                            	"fieldClass" : "select2ac1",
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
                                "noneLabel": "--Seleziona--",
                                "hideNone": true,
                                "useDataSourceAsEnum": false,
                                "multiple": false,
                                "emptySelectFirst": true,
                                "multiselect": {
                                    "disableIfEmpty": true
                                },
                                "sort": false,
                                "renderButtons": true,
                                "events": {},
                                "fields": {}
                            }
                        }
                    },
                    "comuneEstero": {
                        "label": "Comune Estero: ",
                        "type": "select",
                        "helpers": [],
                        "fieldClass": "select2ac1",
                        "validate": true,
                        "disabled": false,
                        "showMessages": false,
                        "renderButtons": true,
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		console.log("in ready select comune estero");
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  width: "100%",
					                  minimumInputLength: 3,
					                  ajax: {
					                	  url: function (params) {
					                	      return listaComuniEsteriUrl + "&q=" + params.term;
					                	    },
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
					                    	callback([]);
			                            },
			                            success: function (data) {
			                            	console.log("success ", data);
			                    
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        	}
                        }
                    }
                },
                "view": "nazioneprovinciacomune-view"

            });
        },
              
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Nazione Provincia Comune";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Nazione Provincia Comune anche estero";
        }
    });

    Alpaca.registerView({
    	"id": "nazioneprovinciacomune-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": nazioneComuneProvinciaContainer,
    		"container-object": nazioneComuneProvinciaContainerObject
    	}
    });
    Alpaca.registerFieldClass("nazioneProvinciaComune", Alpaca.Fields.NazioneProvinciaComuneField);
    

})(jQuery);
