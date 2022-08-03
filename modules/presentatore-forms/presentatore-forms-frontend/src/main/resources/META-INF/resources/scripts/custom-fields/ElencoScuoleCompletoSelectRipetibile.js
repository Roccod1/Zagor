var elencoScuoleCompletoSelectRipetibileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleCompletoSelectRipetibileContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
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
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleCompletoSelectRipetibile";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "dependencies": {
	                    "nomeScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "plessoScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "indirizzoScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "tipologiaScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "comuneProvinciaScuola": [
	                        "scuolaPrincipale"
	                    ]
            	    },
            	    "properties": {
            	        "scuolaPrincipale": {
            	            "required": true,
            	            "properties": {}
            	        },
            	        "nomeScuola": {
                            "title": "Nome Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "plessoScuola": {
                            "title": "Plesso Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "tipologiaScuola": {
                            "title": "Grado Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "indirizzoScuola": {
                            "title": "Indirizzo Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "comuneProvinciaScuola": {
                            "title": "Luogo Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "labelScuoleAlternative": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
            	        "scuoleAlternative": {
            	            "readonly": false,
            	            "required": false,
            	            "type": "array",
            	            "items": {
            	                "type": "object",
            	                "dependencies": {
            	                    "nomeScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "plessoScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "indirizzoScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "tipologiaScuolaAlt": [
            	                        "scuolaAlt"
            	                    ],
            	                    "comuneProvinciaScuolaAlt": [
            	                        "scuolaAlt"
            	                    ]
            	                },
            	                "properties": {
            	                    "scuolaAlt": {
            	                        "required": false,
            	                        "properties": {}
            	                    },
                        	        "nomeScuolaAlt": {
                                        "title": "Nome Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "plessoScuolaAlt": {
                                        "title": "Plesso Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "tipologiaScuolaAlt": {
                                        "title": "Grado",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "indirizzoScuolaAlt": {
                                        "title": "Indirizzo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    },
                                    "comuneProvinciaScuolaAlt": {
                                        "title": "Luogo Scuola",
                                        "type": "string",
                                        "required": false,
            	                        "dependency": "scuolaAlt",
                                        "properties": {}
                                    }

            	                },
            	                "required": false
            	            },
            	            "uniqueItems": false
            	        }
            	    }
            };
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "scuolaPrincipale": {
                        "dataSource": listaScuoleByComuneUrl,
                        "type": "select",
                        "label": "Scuola Principale:",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "fieldClass": "select2ac1",
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
                            "click": function(){
                                var self = this;
                                var allOptions = $("option", self.getControlEl());
                                allOptions.attr("disabled", false);
                                allOptions.css("color", "black"); 
                                var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                allSelectButThis.each(function() {
									var idScuola = this.value;
									var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
									optionToDisable.attr("disabled", true);
									optionToDisable.css("color", "lightgrey");
	                            });
                            },
                        	"ready": function(){
                        		var self = this;
	                        	$.ajax({
				                    url: numeroMaxScuoleAlternativeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoLabelAlternative = self.parent.childrenByPropertyId['labelScuoleAlternative'];
				                    	var campoScuoleAlternative = self.parent.childrenByPropertyId['scuoleAlternative'];
				                    	campoLabelAlternative.options.helpers = ["Sono consentite al massimo " + data + " scelte alternative."],
				                    	campoScuoleAlternative.schema.maxItems = data;
				                    	campoLabelAlternative.refresh();
				                    	campoScuoleAlternative.refresh();
				                    }
	                            });
                             },                       	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();		                        
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);	                   
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    },
                    "labelScuoleAlternative": {
                        "type": "label",
                        "label": "Scuole alternative: ",
                        "helpersPosition": "below",
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
                        "fields": {}
                    },
                    "scuoleAlternative": {
                        "fieldClass": "text-left",
                        "type": "array",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "readonly": false,
                        "actionbarStyle": "bottom",
                        "hideToolbarWithChildren": false,
                        "toolbarSticky": true,
                        "hideActionbar": false,
                        "hideToolbar": false,
                        "toolbar": {
                            "actions": [
                                {
                                    "action": "add",
                                    "enabled": true,
                                    "label": "Aggiungi Scuola"
                                }
                            ]
                        },
                        "actionbar": {
                            "showLabels": true,
                            "actions": [
                                {
                                    "action": "add",
                                    "enabled": false
                                },
                                {
                                    "action": "remove",
                                    "label": "Rimuovi Scuola"
                                },
                                {
                                    "action": "up",
                                    "label": " "
                                },
                                {
                                    "action": "down",
                                    "label": " "
                                }
                            ]
                        },
                        "hidden": false,
                        "hideInitValidationError": true,
                        "focus": false,
                        "lazyLoading": false,
                        "collapsible": false,
                        "collapsed": false,
                        "legendStyle": "button",
                        "animate": true,
                        "sort": false,
                        "items": {
                            "fields": {
                                "scuolaAlt": {
                                    "dataSource": listaScuoleByComuneUrl,
                                    "type": "select",
                                    "label": "Scuola Alternativa:",
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
                                        "click": function(){
                                            var self = this;
                                            var allOptions = $("option", self.getControlEl());
                                            allOptions.attr("disabled", false);
                                            allOptions.css("color", "black"); 
                        	                   var allSelectButThis= $("select[name*='scuola']").not(this.getControlEl());
                                                 allSelectButThis.each(
                                                     function() {
                                                        var idScuola = this.value;
                                                        var optionToDisable = $("option[value='" + idScuola + "']", self.getControlEl());
                                                         optionToDisable.attr("disabled", true);
                                                         optionToDisable.css("color", "lightgrey");

                                                     }
                                                );
                                        },
            	                        "change": function() {
            	                        	var self = this;
            	                        	var idScuola = this.getValue();
            	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
            	                        	$.ajax({
            				                    url: infoScuolaDependentUrl,
            				                    dataType: 'json',
            				                    delay: 250,
            				                    success: function (dataAlt) {
            				                    	var campoNomeScuolaAlt = self.parent.childrenByPropertyId['nomeScuolaAlt'];
            				                    	campoNomeScuolaAlt.getControlEl().val(dataAlt.denominazione);
            				                    	var campoPlessoScuolaAlt = self.parent.childrenByPropertyId['plessoScuolaAlt'];
            				                    	campoPlessoScuolaAlt.getControlEl().val(dataAlt.plesso);
            				                    	var campoIndirizzoScuolaAlt = self.parent.childrenByPropertyId['indirizzoScuolaAlt'];
            				                    	campoIndirizzoScuolaAlt.getControlEl().val(dataAlt.indirizzo);
            				                    	var campoTipologiaScuolaAlt = self.parent.childrenByPropertyId['tipologiaScuolaAlt'];
            				                    	campoTipologiaScuolaAlt.getControlEl().val(dataAlt.grado);
            				                    	var campoComuneProvinciaScuolaAlt = self.parent.childrenByPropertyId['comuneProvinciaScuolaAlt'];
            				                    	campoComuneProvinciaScuolaAlt.getControlEl().val(dataAlt.nomeComuneProv);
            				                   
            				                    }
            																									
            	                            });
            	                        }
                                    
                                    }
                                },
                                "nomeScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Scuola: ",
                                    "renderButtons": true
                                },
                                "plessoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Plesso: ",
                                    "renderButtons": true
                                },
                                "tipologiaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Grado: ",
                                    "renderButtons": true
                                },
                                "indirizzoScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Indirizzo: ",
                                    "renderButtons": true
                                },
                                "comuneProvinciaScuolaAlt": {
                                    "type": "text",
                                    "disabled": true,
                                    "label": "Comune: ",
                                    "renderButtons": true
                                }

                            },
                            "type": "object",
                            "validate": true,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button"
                        },
                        "rubyrails": false
                    }
                },
                "view": "elencoScuoleCompletoSelectRipetibile-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Custom";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale e alternative";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleCompletoSelectRipetibile-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Non è possibile selezionare più volte la stessa scuola."
	
	    },
		"templates": {
			"container": elencoScuoleCompletoSelectRipetibileContainer,
			"container-object": elencoScuoleCompletoSelectRipetibileContainerObject
		},
		"fields": {
	        "/scuoleAlternative": {
	            "parent": "bootstrap-edit",
	            "messages": {
	                "disallowValue": "Non è possibile selezionare più volte la stessa scuola."
	
	            },
	            "templates": {
	                "container": "<div>{{#container}}{{/container}}</div>",
	                "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div></div></div>"
	            }
	        }
	    }
    });
    Alpaca.registerFieldClass("elencoScuoleCompletoSelectRipetibile", Alpaca.Fields.ElencoScuoleCompletoSelectRipetibile); 
  
    
})(jQuery);