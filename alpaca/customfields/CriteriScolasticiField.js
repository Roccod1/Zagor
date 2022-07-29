var criteriScolasticiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var criteriScolasticiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-1" style="margin-top: -5px">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-8">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-3">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-1">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-1">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
    	</div> \
    </div> \
</script>';

var esclusioniCriteri = {};
var disabledCounter = {};

(function($) {

    var Alpaca = $.alpaca;
    
    var loadCriteri = function(isCittadinoResidenteInComuneRichiesta) {
    	var currentCriteri = $("input[id='criterio']");
        var countLoadData = 0;
        var countTriggerCrit = 0;
        var annoScolasticoCriterioCodice = $($('.annoScolasticoCriterioCss')[0]).alpaca("get").data;
		$.ajax({
            url: listaCriteriScolasticiUrl + '&annoScolastico=' + annoScolasticoCriterioCodice,
            dataType: 'json',
            delay: 250,
            success: function (data) {
                currentCriteri.each(
                    function() {
                        var idCurrentCriterio = "criterio" + data[countLoadData].id;
                 	    this.id = idCurrentCriterio;
                 	    esclusioniCriteri[idCurrentCriterio] = data[countLoadData].esclusioni;
                 	    disabledCounter[idCurrentCriterio] = 0;
                 	   
                 	   countLoadData++;
                });
                currentCriteri.each(
                        function() {
                     	   if (data[countTriggerCrit].caricamentoDatiResidenti && isCittadinoResidenteInComuneRichiesta) {
                    	    	this.checked = true;
                    	    }
                     	    if (this.checked) {
                     	    	$(this).change();
                     	    }
                     	   if (data[countTriggerCrit].caricamentoDatiResidenti) {
                    	    	this.disabled = data[countTriggerCrit].caricamentoDatiResidenti;
                        	    $(this).closest("div.row").css("color", "grey");
                    	    }
                     	   countTriggerCrit++;
                    });
                
          	   
            }
       });
    }
    
    Alpaca.Fields.CriteriScolasticiField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.CriteriScolasticiField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "criteriScolastici";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function() {
            this.base();

            this.schema = {
            	"items": {
    	            "title": "",
    	            "type": "object",
    	            "properties": {
    	                    	"checkCriterio": {
    	                            "type": "boolean",
    	                            "required": false,
    	                            "properties": {}
    	                        },
    	    	                "testoCriterio": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "punteggioCriterio": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	    	                "nRichiesto": {
    	    	                    "type": "integer",
    	    	                    "required": true,
    	    	                    "minimum": 1,
    	    	                    "properties": {}
    	    	                },
    	                         "hiddenIdCriterio": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         },
    	                         "hiddenAnnoScolastico": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         },
    	                         "hiddenCampoNumericoRichiesto": {
    	                             "type": "boolean",
    	                             "required": false,
    	                             "properties": {}
    	                         }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
	                "fields": {
			                   	 "checkCriterio": {
			                         "type": "checkbox",
			                         "fields": {},
			                         "helpers": [],
			                         "multiple": false,
			                         "data": false,
			                         "disabled": false,
			                         "renderButtons": true,
			                         "events": {
			                        	 "change": function() {
		    	                            	 var isChecked = this.getValue();
		    	                            	 var storedValue
		    	                            	 if (isChecked && this.parent.childrenByPropertyId['hiddenCampoNumericoRichiesto'].getValue()) {
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].options.disabled = false;
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].options.hidden = false;
		    	                            		 var storedValue = this.parent.childrenByPropertyId['nRichiesto'].getValue();
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].refresh();
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].setValue(!!storedValue ? storedValue : null);
		    	                            	 } else {
		    	                            		 
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].options.disabled = true;
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].options.hidden = true;
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].refresh();
		    	                            		 this.parent.childrenByPropertyId['nRichiesto'].setValue();
		    	                            	 }
	    	                            		 
		    	                            	 
		    	                            	 var currentId = this.getControlEl().find("input")[0].id;
		    	                            	 var esclusioniString = esclusioniCriteri[currentId];
		    	                            	 if (esclusioniString != null) {
			    	                            	 var esclusioniJson = JSON.parse(esclusioniString);
			    	                            	 esclusioniJson["idCriteriEsclusi"].forEach(
				    	                            	     function (element){
				    	                            	         var criterioToDisable = $("input[id=criterio" + element + "]");
				    	                            	         var currentParent = $(criterioToDisable.closest('div')).alpaca("get").parent;
				    	                            	         currentParent.childrenByPropertyId['nRichiesto'].setValue(0);
				    	                            	         currentParent.childrenByPropertyId['nRichiesto'].options.disabled = true;
				    	                            	         currentParent.childrenByPropertyId['nRichiesto'].options.hidden = true;
						    	                            	 if (isChecked) {
					    	                            	         disabledCounter["criterio" + element]++;
						    	                            		 criterioToDisable[0].checked = false;
					    	                            	         criterioToDisable[0].disabled = true;
					    	                            	         criterioToDisable.closest("div.row").css("color", "grey");
						    	                            	 } else {
						    	                            		 disabledCounter["criterio" + element]--;
						    	                            		 if (disabledCounter["criterio" + element] === 0) {
						    	                            	         criterioToDisable[0].disabled = false;   	                            		 
						    	                            	         criterioToDisable.closest("div.row").css("color", "black");
						    	                            		 }
						    	                            	 }
				    	                            	     }
			    	                            	 );
		    	                            	 }
			                        	 }
			                         }
			                     },
	    	                     "testoCriterio": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "helpers": [],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "fields": {},
	    	                         "view": "bootstrap-display",
	    	                         "events": {
	    	                             "ready": function(){
	    	                             	 //Equivalente a this.parent.children[0] è this.parent.childrenByPropertyId("checkCriterio")
	    	                             	 
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].dataset.checkboxValue = this.getValue();
											 this.parent.children[0].getControlEl().find("input")[0].id = "criterio";
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].name = this.getValue();
	    	                             	 this.parent.children[0].getControlEl().find("input")[0].textContent = this.getValue();
	    	                             	 
	    	 								
	    	                             }

	    	                         }
	    	                     },
	    	                     "punteggioCriterio": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "fieldClass": "text-center",
	    	                         "helpers": [],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "view": "bootstrap-display",
	    	                         "fields": {}
	    	                         
	    	                     },
	    	                     "nRichiesto": {
	    	                    	 "hidden": true,
	    	                         "type": "integer",
	    	                         "label": "N. Minori:",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "attributes": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "autocomplete": false,
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "numericEntry": false,
	    	                         "data": {},
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenIdCriterio": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenAnnoScolastico": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "fieldClass": "annoScolasticoCriterioCss",
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenCampoNumericoRichiesto": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     }
	                }

            	},
                "hidden": false,
                "animate": true,
                "helpers": [],
                "toolbar": {
                    "actions": [
                        {
                            "action": "add",
                            "enabled": false
                        }
                    ]
                },
                "disabled": false,
                "validate": false,
                "collapsed": false,
                "rubyrails": false,
                "collapsible": false,
                "hideToolbar": true,
                "lazyLoading": false,
                "legendStyle": "button",
                "optionLabels": [],
                "showMessages": true,
                "toolbarStyle": "button",
                "hideActionbar": true,
                "toolbarSticky": false,
                "actionbarStyle": "top",
                "hideInitValidationError": false,
                "hideToolbarWithChildren": true,
            	"view": "criteriscolastici-view",
            	"events": {
                    "ready": function(){
                    	
                    	$.ajax({
		                    url: checkResidenteUrl,
		                    dataType: 'json',
		                    delay: 0,
		                    beforeSend: function(request) {
		                        request.setRequestHeader("User-Token", userToken);
	                        },
		                    success: function (data) {
		                    	var isCittadinoResidenteInComuneRichiesta = data.checkResponse;
		                    	loadCriteri(isCittadinoResidenteInComuneRichiesta);
		                    	
		                    },
		                    error: function () {	
		                    	console.log("error");
                            }
                		});
                                                
                        
                        
                    }
            	}
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Criteri scolastici";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Criteri scolastici per elenco moduli";
        }
    });

    Alpaca.registerView({
    	"id": "criteriscolastici-view",
    	"parent": "bootstrap-create",
    	"messages": {
    		"stringNotANumber": "Inserire un valore numerico",
    		"notOptional": "Campo obbligatorio",
    		"stringValueTooSmall": "Valore minimo: 1",
    	},
    	"templates": {
    		"container": criteriScolasticiContainer,
    		"container-object": criteriScolasticiContainerObject
    	}
    });
    Alpaca.registerFieldClass("criteriScolastici", Alpaca.Fields.CriteriScolasticiField);
    
})(jQuery);