var elencoStradarioPCFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var elencoStradarioPCFieldContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-10">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
	
    var civiciPerIndirizzo = {};
    
    Alpaca.Fields.ElencoStradarioPCField = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoStradarioPCField.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoStradarioPC";
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
            	        "searchStradarioNew": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "searchButton": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectStradarioNew": {
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectCivici": {
            	            "required": true,
            	            "properties": {}
            	        },
            	        "civico": {
            	            "type": "string",
            	            "required": true,
            	            "properties": {}
            	        },
            	        "esponente": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectStradarioNewValue": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "codiceIndirizzoHidden": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "localitaHidden": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "latitudineHidden": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "longitudineHidden": {
            	            "type": "string",
            	            "required": false,
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
                "showButtons": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
                    "searchStradarioNew": {
                        "type": "search",
                        "placeholder": "Inserisci qui la via da ricercare",
                        "fieldClass": "paddingtop5 paddingright20 hideInPdf",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "searchButton": {
                    	"fieldClass": "hideInPdf",
                        "type": "label",
                        "label": " <div class='btn btn-primary padding10'><icon class='fa fa-search paddingright10'></icon><b> Cerca</b></div>",
                        "helpers": [],
                        "validate": false,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {},
                        "events": {
                        	"click": function (){
	
								//reset latitudie e longitudine in caso di cambio via
								this.parent.childrenByPropertyId["latitudineHidden"].getControlEl().val(null);
	                    		this.parent.childrenByPropertyId["longitudineHidden"].getControlEl().val(null);
	                    		
                        		var relatedSelectStradario = this.domEl.closest("div.alpaca-container").find($("select[name*='selectStradarioNew']"));
                        		relatedSelectStradario.attr("disabled", false);
                        		relatedSelectStradario.empty();
                        		this.domEl.css("pointer-events","none");
                        		this.domEl.find("div.btn").attr("disabled", true);
                        		
                        		var alpacaStradarioNew = this.parent.childrenByPropertyId["searchStradarioNew"];
                        		var currentVal = alpacaStradarioNew.getValue();
               		
                        		for (var curr in civiciPerIndirizzo) delete civiciPerIndirizzo[curr];
                        		
                        		var $search = relatedSelectStradario.data('select2').dropdown.$search;
                                $search.val(currentVal);                                
                                $search.trigger('input');
                                $("input.select2-search__field").hide(); 		
                        	}
                        }
                    },
                    
                    "selectStradarioNew": {
                    	"fieldClass": "select2ac1",
                        "type": "select",
                        "validate": false,
                        "disabled": false,
                        "showMessages": false,
                        "label": "Via: ",
                        "removeDefaultNone": true,
                        "useDataSourceAsEnum": false,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": true,
                        "noneLabel": "Nessuno",
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		var selfControlEl = this.getControlEl();
                        		selfControlEl.attr("disabled", true);
                        		var searchBtn = this.parent.childrenByPropertyId['searchButton'];
	                    		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  width: "100%",
					                  minimumInputLength: 1,
					                  minimumResultsForSearch: -1,
					                  ajax: {
					                	  url: function (params) {
					                	      return listaStradarioUrl + "&indirizzo=" + params.term;
					                	    },
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
			                            },
			                            success: function (data) {
			                            	selfControlEl.attr("disabled", false);
			                        		data.forEach( function (element) {
			                        			civiciPerIndirizzo[element.identificativo + '-' + element.localita] = element.civici;
			                        		});  
			                            },
			                            complete: function () {
					                    	searchBtn.domEl.css("pointer-events","auto");
					                    	searchBtn.domEl.find("div.btn").attr("disabled", false);
			                            },
					                    processResults: function (data) {
					                        var items = $.map(data, function (obj) {
					                          obj.id = obj.identificativo + '-' + obj.localita;
	                                          obj.text = obj.denominazione + " - " + obj.localita;
					                          return obj;
					                        });
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          	});
                        		this.getControlEl().on('select2:open', function (e) {
                        			$("input.select2-search__field").hide();
                        		});
                        	},
                        	"change": function(){
                    			/*var civiciDisponibili = [{"value": "-1", "text": "-- Inserimento Manuale --"}];*/
								var civiciDisponibili = [];
                        		var valoreSelectCiviciFromBozza;
								var valoreLocalitaHiddenFromBozza;
								
								//reset latitudie e longitudine in caso di cambio via
								this.parent.childrenByPropertyId["latitudineHidden"].getControlEl().val(null);
	                    		this.parent.childrenByPropertyId["longitudineHidden"].getControlEl().val(null);
								
                    			if (typeof civiciPerIndirizzo != "undefined" && civiciPerIndirizzo != null && typeof civiciPerIndirizzo[this.getValue()] != "undefined"){
                    				civiciPerIndirizzo[this.getValue()].forEach( function(element) {
                            			var numeroEsponente = element.numero;
                            			if (element.esponente !== null && element.esponente !== undefined) {
                            				numeroEsponente = numeroEsponente + " " + element.esponente;
                            			}
                        			    civiciDisponibili.push({"value": element.identificativo, "text": numeroEsponente});
                        			});
                    			}
								else {
									var campoLocalitaHidden =  this.parent.childrenByPropertyId['localitaHidden'];
									var campoSelectCivici = this.parent.childrenByPropertyId["selectCivici"];
									var campoCivico = this.parent.childrenByPropertyId["civico"];
	                        		var campoEsponente = this.parent.childrenByPropertyId["esponente"];
									var valoreLocalitaHidden = campoLocalitaHidden['data'];
									var valoreSelectCivici = campoSelectCivici['data'];
									var valoreCivico = campoCivico.getControlEl().val();
									var valoreEsponente = campoEsponente.getControlEl().val();
									if (valoreEsponente !== null && valoreEsponente !== undefined) {
										valoreCivico = valoreCivico + " " + valoreEsponente;
									}
									civiciDisponibili.push({"value": valoreSelectCivici, "text": valoreCivico});
									valoreSelectCiviciFromBozza = valoreSelectCivici;
									valoreLocalitaHiddenFromBozza = valoreLocalitaHidden;
								}
                    			var campoAlpacaCivici = this.domEl.closest("div.alpaca-container").find($("select[name*='selectCivici']")).alpaca("get");
                    			campoAlpacaCivici.options.dataSource = civiciDisponibili;
                    			campoAlpacaCivici.refresh();

								if (valoreSelectCiviciFromBozza != "undefined") {
									this.domEl.closest("div.alpaca-container").find($("select[name*='selectCivici']")).val(valoreSelectCiviciFromBozza);
								}
                    			
                    			var indirizzoScelto= this.getControlEl().select2('data');
                    			if(indirizzoScelto != undefined && indirizzoScelto != null){
									var indirizzoSceltoSplitArray = indirizzoScelto[0].id.split('-');
                        			var campoSelectStradarioNewValue =  this.parent.childrenByPropertyId['selectStradarioNewValue'];
                        			var campoCodiceIndirizzoHidden =  this.parent.childrenByPropertyId['codiceIndirizzoHidden'];
                        			var campoLocalitaHidden2 =  this.parent.childrenByPropertyId['localitaHidden'];
                        			campoSelectStradarioNewValue.getControlEl().val(indirizzoScelto[0].text);
                        			campoCodiceIndirizzoHidden.getControlEl().val(indirizzoSceltoSplitArray[0]);
                        			campoLocalitaHidden2.getControlEl().val(indirizzoScelto[0].localita);
                        			
                    			}

								if (valoreLocalitaHiddenFromBozza != "undefined" && valoreLocalitaHiddenFromBozza != null) {
									this.domEl.closest("div.alpaca-container").find($("input:hidden[name*='localitaHidden']")).val(valoreLocalitaHiddenFromBozza);
								}
                        	}
                        }
                    },

                    "selectCivici": {
                    	"fieldClass": "hideInPdf",
                        "type": "select",
                        "label": "Civico:",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "emptySelectFirst": true,
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "noneLabel": "-- Seleziona --",
                        "hideNone": false,
                        "fields": {},
                        "events": {
                        	"change": function (){
                        		var campoCivico = this.parent.childrenByPropertyId["civico"];
                        		var campoEsponente = this.parent.childrenByPropertyId["esponente"];
                        		var campoCodiceIndirizzoHidden = this.parent.childrenByPropertyId["codiceIndirizzoHidden"];
                        		var localitaHidden = this.parent.childrenByPropertyId["localitaHidden"];
								var valoreCivico = campoCivico['data'];
								var valoreEsponente = campoEsponente['data'];
								
								var latitudineHidden = this.parent.childrenByPropertyId["latitudineHidden"];
								var longitudineHidden = this.parent.childrenByPropertyId["longitudineHidden"];
								
								latitudineHidden.getControlEl().val(null);
	                    		longitudineHidden.getControlEl().val(null);
								
								var selectedValue = this.getValue();
                        		 if (this.getValue() == "-1") {
	                        		campoCivico.options.hidden = false;
	                        		campoEsponente.options.hidden = false;
	                        		campoCivico.refresh();
		                        	campoEsponente.refresh();
                        		} 
								else {
	                        		campoCivico.options.hidden = true;
	                        		campoEsponente.options.hidden = true;
	                        		campoCivico.refresh();
		                        	campoEsponente.refresh();
		                        	if (typeof civiciPerIndirizzo != "undefined" && civiciPerIndirizzo != null && typeof civiciPerIndirizzo[campoCodiceIndirizzoHidden.getValue() + '-' + localitaHidden.getValue()] != "undefined"){
	                    				civiciPerIndirizzo[campoCodiceIndirizzoHidden.getValue() + '-' + localitaHidden.getValue()].forEach( function(element) {
											if (element.identificativo === selectedValue) {
	                    						campoCivico.getControlEl().val(element.numero);
	                    						latitudineHidden.getControlEl().val(element.latitudine);
	                    						longitudineHidden.getControlEl().val(element.longitudine);
	                    						campoEsponente.refresh();
		                            			if (element.esponente !== null && element.esponente !== undefined) {
		                            				campoEsponente.getControlEl().val(element.esponente);
		                            			}
	                    					}
	                            		});
	                        		}
									else {
										campoCivico.getControlEl().val(valoreCivico);
										campoEsponente.getControlEl().val(valoreEsponente);
									}
                        		}
                        	}
                        } 
                    },
                    "civico": {
                    	"fieldClass": "showInPdf",
                        "type": "text",
                        "label": "Civico:",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "esponente": {
                    	"fieldClass": "showInPdf",
                        "type": "text",
                        "label": "Esponente:",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}     
                    },
                    "selectStradarioNewValue": {
                    	"fieldClass": "showInPdf",
                        "type": "text",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "codiceIndirizzoHidden": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "localitaHidden": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "latitudineHidden": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "longitudineHidden": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    }
                },
                "view": "elencostradarioPassoCarrabile-view"              
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
            return "Elenco Stradario Passo Carrabile";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Elenco di scelta da stradario con via, civico, latitudine e longitudine";
        }
    });

    Alpaca.registerView({
    	"id": "elencostradarioPassoCarrabile-view",
    	"parent": "bootstrap-create",
    	"messages": {
	        "notOptional": "Campo obbligatorio.",
	    },
    	"templates": {
    		"container": elencoStradarioPCFieldContainer,
    		"container-object": elencoStradarioPCFieldContainerObject
    	}
    });
    Alpaca.registerFieldClass("elencoStradarioPC", Alpaca.Fields.ElencoStradarioPCField);
    

})(jQuery);
