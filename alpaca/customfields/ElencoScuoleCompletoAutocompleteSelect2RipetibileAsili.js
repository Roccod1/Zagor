var elencoScuoleCompletoAutocompleteSelect2RipetibileAsiliContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleCompletoAutocompleteSelect2RipetibileAsiliContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
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
    
	var isBozzaLoading = false;
	
    var possibileScuolaAbbinata = {};
    var numScuoleAltern = 0;
    
    Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2RipetibileAsili = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2RipetibileAsili.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleCompletoAutocompleteSelect2RipetibileAsili";
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
                    	"fieldClass": "select2ac1 text-center paddingleft20",
                        "type": "select",
                        "label": "Scuola Principale:",
                        "helpers": [],
                        "hideInitValidationError": true,
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
                        	"ready": function(){
                        		isBozzaLoading = isCaricaBozza;
                        		
                        		var self = this;
	                        	$.ajax({
				                    url: numeroMaxScuoleAlternativeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoLabelAlternative = self.parent.childrenByPropertyId['labelScuoleAlternative'];
				                    	campoLabelAlternative.options.helpers = ["Sono consentite al massimo " + data + " scelte alternative di tipo Montessori laddove presenti."],
				                    	numScuoleAltern = data;
				                    	campoLabelAlternative.refresh();
				                    }
	                            });
	                        	
	                        	
                        		try{
                        			var codiceAnnoScolastico = this.parent.parent.childrenByPropertyId['annoScolasticoCorrenteObject'].childrenByPropertyId['annoScolasticoCorrente'].getControlEl().val();
                        			console.log("codiceAnnoScolastico=" + codiceAnnoScolastico);
                        			listaScuoleByComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;
                        			
                        		}catch(err) {
                        			  console.log("Errore nel recupero anno scolastico" + err.message);
                        		}
                        		
                        		
                        		var currentUrl = listaScuoleByComuneUrl;
                        		
                        		// Asili principali solo NON montessori
                        		currentUrl += "&montessori=0";
                        			
                        		var thisSelect = this.getControlEl();
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 0,
					                  width: "100%",
					                  ajax: {
					                    url: currentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 3000,
					                    data: function (params) {
					                      return {
					                        q: params.term, // search term
					                        page: params.page
					                      };
					                    },
					                    error: function () {	
					                    	console.log("error");
			                            },
			                            success: function (data) {
					                    	console.log("success");
			                            },
			                            complete: function () {
					                    	console.log("complete");
			                            },
					                    processResults: function (data) {
					                    	var items = $.map(data, function (obj) {
					                        	var allSelectButThis= $("select[name*='scuola']").not(thisSelect);	
					                        	var trovato = 0;
					                        	allSelectButThis.each(
			                                         function() {
			                                            var idScuola = this.value;
			                                            if(idScuola == obj.value){
			                                            	trovato = 1;
			                                            	return false;
			                                            }
			                                         });
					                        	if(trovato == 0){
					                        		obj.id = obj.value;
    					                        	obj.text = obj.text;
    					                        	return obj;
					                        	}
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
	                        	
	                        	
                             },                       	
                        	"change": function() {
                        		console.log('change princip ', this);
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
				                    	
				                    	var campoScuoleAlternative = self.parent.childrenByPropertyId['scuoleAlternative'];
				                    	
				                    	var scuolaAbbinataFound = false;
				                    	if (data.scuolaAbbinataDto && data.scuolaAbbinataDto.id) {
				                    		var dataNascitaMinoreString = $("input[name$='dataNascitaMinore']").val();
					                    	var dataNascitaMinore = moment(dataNascitaMinoreString, "DD/MM/YYYY");
					                    	var youngest = moment().subtract(data.scuolaAbbinataDto.fasciaMesiMin, 'month');
					                    	var oldest = moment().subtract(data.scuolaAbbinataDto.fasciaMesiMax, 'month');
					                    	
				                    		if (
				                    				dataNascitaMinore.isBetween(oldest, youngest, 'day') ||	
				                    				dataNascitaMinore.isSame(youngest, 'day') ||
				                    				dataNascitaMinore.isSame(oldest, 'day')
				                    				
				                    		) {
    				                    	possibileScuolaAbbinata = data.scuolaAbbinataDto;
    				                    	console.log('possibile scuola abbinata popolata ', possibileScuolaAbbinata);
    				                    	campoScuoleAlternative.schema.maxItems = numScuoleAltern;
    				                    	campoScuoleAlternative.options.toolbar.actions[0].enabled = true;
    				                    	scuolaAbbinataFound = true;
					                    	}
					                    }
				                    	
				                    	if (!scuolaAbbinataFound) {
				                    		console.log('nessuna scuola abbinata possibile');
				                    		campoScuoleAlternative.schema.maxItems = 0;
    				                    	campoScuoleAlternative.options.toolbar.actions[0].enabled = false;
				                    	}
				                    	campoScuoleAlternative.refresh();
				                    }
																									
	                            });
	                        	
	                        	var numeroScuoleAlt = $(".scuoleAlternativeArray [data-alpaca-array-actionbar-action='remove']").length;
	                        	if (!(isBozzaLoading && numeroScuoleAlt != 0)) {
		                        	if(numeroScuoleAlt != 0){
		                        		var n;
		                        		for (n = 0; n < numeroScuoleAlt; n++) {
		                        			$(".scuoleAlternativeArray [data-alpaca-array-actionbar-action='remove']").click();
		                        		}
		                        	}
	                        	} else {
	                        		isBozzaLoading = false;

	                        	}
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                    	"fieldClass": "paddingleft20",
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                    	"fieldClass": "paddingleft20",
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                    	"fieldClass": "paddingleft20",
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                    	"fieldClass": "paddingleft20",
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                    	"fieldClass": "paddingleft20",
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
                        "fieldClass": "text-left scuoleAlternativeArray",
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
                                    "enabled": false,
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
                                	"fieldClass": "select2ac1 text-center",
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
                                    	"ready": function(){
            	                        	var self = this;
                                    		var thisSelect = this.getControlEl();
                                    		var descrizioneScuolaAbb =
                                    			possibileScuolaAbbinata.plesso && possibileScuolaAbbinata.indirizzo
                                    			?
                                    			possibileScuolaAbbinata.denominazione + ", " + possibileScuolaAbbinata.plesso + ", " + possibileScuolaAbbinata.indirizzo
                                    			:
                                    			possibileScuolaAbbinata.denominazione;
                                    		
                                    		
                                    		var selectNameA = this.name;
                                    		var s2ValueA = $(thisSelect[0].form).alpaca("get").data[selectNameA + "Value"];
                    						var s2TextA = $(thisSelect[0].form).alpaca("get").data[selectNameA + "Text"];

                                    		if (this.data && s2ValueA && s2TextA && this.data === s2ValueA) {
                                    			thisSelect.append($('<option>', {
                                        		    value: s2ValueA,
                                        		    text: s2TextA,
                                        		    selected: true
                                        		}));
                                    			
                                    		}
                                    		
                                    		this.getControlEl().select2({
          					                  language: "it",
          					                  minimumInputLength: 0,
          					                  width: "100%",
          					                  data: [{id: possibileScuolaAbbinata.id, text: descrizioneScuolaAbb, selected: true}],
          					                  disabled: true
                                    		});
                                    		var campoNomeScuolaAlt = self.parent.childrenByPropertyId['nomeScuolaAlt'];
    				                    	campoNomeScuolaAlt.getControlEl().val(possibileScuolaAbbinata.denominazione);
    				                    	var campoPlessoScuolaAlt = self.parent.childrenByPropertyId['plessoScuolaAlt'];
    				                    	campoPlessoScuolaAlt.getControlEl().val(possibileScuolaAbbinata.plesso);
    				                    	var campoIndirizzoScuolaAlt = self.parent.childrenByPropertyId['indirizzoScuolaAlt'];
    				                    	campoIndirizzoScuolaAlt.getControlEl().val(possibileScuolaAbbinata.indirizzo);
    				                    	var campoTipologiaScuolaAlt = self.parent.childrenByPropertyId['tipologiaScuolaAlt'];
    				                    	campoTipologiaScuolaAlt.getControlEl().val(possibileScuolaAbbinata.grado);
    				                    	var campoComuneProvinciaScuolaAlt = self.parent.childrenByPropertyId['comuneProvinciaScuolaAlt'];
    				                    	campoComuneProvinciaScuolaAlt.getControlEl().val(possibileScuolaAbbinata.nomeComuneProv);
    				                    	
    				                    	
    				                    	
    				                    	
                                    		/* this.getControlEl().select2({
            					                  theme: "classic",
            					                  language: "it",
            					                  minimumInputLength: 3,
            					                  width: "100%",
            					                  ajax: {
            					                    url: listaScuoleByComuneUrl,
            					                    dataType: 'json',
            					                    delay: 250,
            					                    timeout: 3000,
            					                    data: function (params) {
            					                      return {
            					                        q: params.term, // search term
            					                        page: params.page,
            					                        idScuolaPrimaScelta: $("select[name='elencoScuole_scuolaPrincipale']").val()
            					                      };
            					                    },
            					                    error: function () {	
            					                    	console.log("error");
            			                            },
            			                            success: function (data) {
            					                    	console.log("success");
            			                            },
            			                            complete: function () {
            					                    	console.log("complete");
            			                            },
            					                    processResults: function (data) {
            					                        var items = $.map(data, function (obj) {
            					                        	var allSelectButThis= $("select[name*='scuola']").not(thisSelect);	
            					                        	var trovato = 0;
            					                        	allSelectButThis.each(
        				                                         function() {
        				                                            var idScuola = this.value;
        				                                            if(idScuola == obj.value){
        				                                            	trovato = 1;
        				                                            	return false;
        				                                            }
        				                                         });
            					                        	if(trovato == 0){
            					                        		obj.id = obj.value;
                					                        	obj.text = obj.text;
                					                        	return obj;
            					                        	}
            					                        });
            					                        
            					                        return {
            					                            results: items
            					                        };
            					                    },
            					                    cache: true
            					                  }
            					          });
                                    	  */
                                    		
                                    	}
                                    /*
                                    ,
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
            	                        } */
                                    
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
                "view": "elencoScuoleCompletoAutocompleteSelect2RipetibileAsili-view"
            	
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
            return "Scelta scuola principale e alternative con select2 con autocomplete";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleCompletoAutocompleteSelect2RipetibileAsili-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Non è possibile selezionare più volte la stessa scuola."
	
	    },
		"templates": {
			"container": elencoScuoleCompletoAutocompleteSelect2RipetibileAsiliContainer,
			"container-object": elencoScuoleCompletoAutocompleteSelect2RipetibileAsiliContainerObject
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
    Alpaca.registerFieldClass("elencoScuoleCompletoAutocompleteSelect2RipetibileAsili", Alpaca.Fields.ElencoScuoleCompletoAutocompleteSelect2RipetibileAsili); 
  
    
})(jQuery);