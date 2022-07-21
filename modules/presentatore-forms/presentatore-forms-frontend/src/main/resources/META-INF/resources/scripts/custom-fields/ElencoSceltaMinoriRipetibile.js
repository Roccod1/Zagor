var elencoSceltaMinoriRipetibileContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoSceltaMinoriRipetibileContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoSceltaMinoriRipetibile = Alpaca.Fields.ArrayField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoSceltaMinoriRipetibile.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ArrayField#getFieldType
		 */
        getFieldType: function() {
            return "elencoSceltaMinoriRipetibile";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ArrayField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
	            "readonly": false,
	            "required": true,
	            "type": "array",
	            "items": {
	                "type": "object",
                	"dependencies": {
                		"labelStradarioNew": [
	                        "checkDomicilio"
	                    ],
	                    "customStradarioNew": [
	                        "checkDomicilio"
	                    ]
	                },
	                "properties": {
	                	"customMinore": {
	                        "title": "",
	                        "description": "",
	                        "type": "object",
	                        "required": false,
	                        "properties": {
	                        	"labelDatiMinore": {
	    	                        "type": "string",
	    	                        "required": false,
	    	                        "properties": {}
	    	                    },
	                            "minoriFam": {
	                                "required": false,
	                                "properties": {}
	                            },
	                            "nomeMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "cognomeMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "codFiscMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "dataNascitaMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            },
	                            "provComuneRequiredMinore": {
	                                "readonly": false,
	                                "required": true,
	                                "type": "string",
	                                "properties": {}
	                            }
	                        }
	                    },
	                    "checkDomicilio": {
	                        "type": "boolean",
	                        "required": false,
	                        "properties": {}
	                    },
	                    "labelStradarioNew": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },            
                        "customStradarioNew": {
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
                                    "required": false,
                                    "properties": {}
                                },
                                "civico": {
                                    "type": "string",
                                    "required": false,
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
                    	        }
                            }
                        },
	                    "labelScegliScuola": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },
	                    "customScuolaFuoriBacino": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "dependencies": {
        	                    "istitutoComprensivo": [
        	                        "scuolaFuoriBacino"
        	                    ], 
                    			"labelDescIstitutoComprensivo": [
        	                        "scuolaFuoriBacino"
        	                    ]
        	                },
                            "properties": {
                                "scuolaFuoriBacino": {
                                    "required": false,
                                    "properties": {}
                                },
                                "istitutoComprensivo": {
                                    "required": true,
                                    "enum": [
                                        "SI",
                                        "NO"
                                    ],
                                    "properties": {}
                                },
        	                    "labelDescIstitutoComprensivo": {
        	                        "type": "string",
        	                        "required": false,
        	                        "properties": {}
        	                    }
                            }
                        },
                        "customScuolaBacRegolare": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "scuolaBacinoRegolare": {
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
                        "customScuolaBacinoPeg": {
                            "title": "",
                            "description": "",
                            "type": "object",
                            "required": false,
                            "properties": {
                                "scuolaBacinoPeg": {
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
	                    "labelScuolaScelta": {
	                        "type": "string",
	                        "required": false,
	                        "properties": {}
	                    },
                        "nomeScuola": {
                            "title": "Nome Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "plessoScuola": {
                            "title": "Plesso Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "tipologiaScuola": {
                            "title": "Grado Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "indirizzoScuola": {
                            "title": "Indirizzo Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "comuneProvinciaScuola": {
                            "title": "Luogo Scuola",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
                        "tempoPieno": {
                            "required": true,
                            "enum": [
                                "SI",
                                "NO"
                            ],
                            "properties": {}
                        },
                        "annotazioni": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "codiceScuola": {
                            "type": "string",
                            "required": true,
                            "properties": {}
                        }
	                },
	                "required": false
	            },
	            "uniqueItems": false
	        };
            
            Alpaca.merge(this.options, {
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
                            "label": "Aggiungi Minore"
                        }
                    ]
                },
                "actionbar": {
                    "showLabels": true,
                    "actions": [
                        {
                            "action": "add",
                            "label": "Aggiungi Minore"
                        },
                        {
                            "action": "remove",
                            "label": "Rimuovi Minore"
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
                    	"customMinore": {
                            "type": "datiAnagraficiMinoreSelectCustom",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "view": "datiAnagraficiMinoreSelectCustom-view",
                            "fields": {
                            	"labelDatiMinore": {
                                    "type": "label",
                                    "hidden": true,
                                    "fieldClass": "text-center showInPdf",
                                    "label": "Dati Minore:",
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
                                    "fields": {}
                                },
                                "minoriFam": {
                                    "fieldClass": "text-center hideInPdf",
                                    "hideInitValidationError": true,
                                    "dataSource": "",
                                    "type": "select",
                                    "label": "<p style='text-align: center'>Selezionare minore:</p>",
                                    "helpers": [],
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
                                    "events": {},
                                    "fields": {}
                                },
                                "nomeMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Nome:",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "cognomeMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Cognome:",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "codFiscMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Codice Fiscale: ",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "dataNascitaMinore": {
                                    "type": "date",
                                    "label": " Data nascita (dd/mm/yyyy):",
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "dateFormat": "DD/MM/YYYY",
                                    "picker": {
                                        "useCurrent": false,
                                        "format": "DD/MM/YYYY",
                                        "locale": "it",
                                        "dayViewHeaderFormat": "MMMM YYYY",
                                        "extraFormats": []
                                    },
                                    "manualEntry": false,
                                    "disabled": true,
                                    "helpers": [],
                                    "validate": true,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                },
                                "provComuneRequiredMinore": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": true,
                                    "hidden": false,
                                    "label": "Luogo di nascita: ",
                                    "helpers": [],
                                    "hideInitValidationError": false,
                                    "focus": false,
                                    "optionLabels": [],
                                    "typeahead": {},
                                    "allowOptionalEmpty": true,
                                    "data": {},
                                    "autocomplete": false,
                                    "disallowEmptySpaces": false,
                                    "disallowOnlyEmptySpaces": false,
                                    "rows": 5,
                                    "cols": 40,
                                    "sort": false,
                                    "renderButtons": true,
                                    "attributes": {},
                                    "readonly": false,
                                    "fields": {}
                                }
                            }
                        },
                        "checkDomicilio": {
                        	"fieldClass": "hideInPdf",
                            "type": "checkbox",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "renderButtons": true,
                            "rightLabel": "Domicilio differente dalla residenza",
                            "fields": {},
							"events" : {
								"change" : function() {
									var self = this;
									var isCheckedDomicilio = this.getValue();
									console.log("cambio check domicilio");
									if (!isCheckedDomicilio) {
										console.log("dececk check domicilio");
										var customStradarioNew = self.parent.childrenByPropertyId['customStradarioNew'];
										
										console.log("pulisco selectCivici");
										var relatedSelectStradario = this.domEl.closest("div.alpaca-field-object").find($("select[name*='selectCivici']"));
		                        		relatedSelectStradario.empty();
									
		                        		var selectCivici =  customStradarioNew.childrenByPropertyId['selectCivici'].id;
										if( selectCivici ) {
				                    		$('#' + selectCivici).val("").trigger('change');
				                    	}
										
										console.log("pulisco civico");
										var civico =  customStradarioNew.childrenByPropertyId['civico'];
										relatedSelectStradario.empty();
										civico.getControlEl().val("");
										
										console.log("pulisco esponente");
										var esponente =  customStradarioNew.childrenByPropertyId['esponente'];
										esponente.getControlEl().val("");
										
										console.log("pulisco selectStradarioNew");
										var selectStradarioNew =  customStradarioNew.childrenByPropertyId['selectStradarioNew'].id;
										if( selectStradarioNew ) {
				                    		/* $('#' + selectStradarioNew).val("").trigger('change'); 
											$("#" + selectStradarioNew).select2("val", "");*/
				                    	}
										
										var relatedSelectStradario = this.domEl.closest("div.alpaca-field-object").find($("select[name*='selectStradarioNew']"));
		                        		relatedSelectStradario.attr("disabled", false);
		                        		relatedSelectStradario.empty();
										
										console.log("pulisco searchStradarioNew");
										var searchStradarioNew =  customStradarioNew.childrenByPropertyId['searchStradarioNew'];
										searchStradarioNew.getControlEl().val("");
										
										var selectStradarioNewValue =  customStradarioNew.childrenByPropertyId['selectStradarioNewValue'];
										selectStradarioNewValue.getControlEl().val("");
									} 
								}
							}
                        },
                        "labelStradarioNew": {
                            "type": "label",
                            "label": "Indirizzo di prelievo diverso dalla residenza:",
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
                            "fields": {}
                        },
                        "customStradarioNew": {
                            "type": "elencoStradarioNew",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "focus": false,
                            "helpersPosition": "below",
                            "showButtons": true,
                            "view": "elencostradarionew-view",
                            "fields": {
                                "searchStradarioNew": {
                                    "type": "search",
                                    "fieldClass": "paddingtop5 paddingright20",
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
                                    "attributes": {
                                        "results": 5
                                    },
                                    "fields": {}
                                },
                                "searchButton": {
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
                                    "events": {},
                                    "fields": {}
                                },
                                "selectStradarioNew": {
                                    "fieldClass": "select2ac1",
                                    "type": "select",
                                    "label": "Vie:",
                                    "helpers": [],
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "noneLabel": "None",
                                    "hideNone": true,
                                    "events": {},
                                    "fields": {}
                                },
                                "selectCivici": {
                                    "type": "select",
                                    "label": "Civici:",
                                    "helpers": [],
                                    "hideInitValidationError": true,
                                    "emptySelectFirst": true,
                                    "validate": false,
                                    "disabled": false,
                                    "showMessages": true,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": false,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "noneLabel": "-- Seleziona --",
                                    "hideNone": false,
                                    "events": {},
                                    "fields": {}
                                },
                                "civico": {
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
                                }
                            }
                        },
                        "labelScegliScuola": {
                        	"fieldClass": "hideInPdf",
                            "type": "label",
                            "label": "<p style='text-align: center'>Seleziona scuola del bacino di appartenenza:</p>",
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
                            "fields": {}
                        },
                        "customScuolaFuoriBacino": {
                            "type": "elencoScuoleFuoriBacAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleFuoriBacAutoCompleteSelect-view",
                            "fields": {
                                "scuolaFuoriBacino": {
                                    "fieldClass": "hideInPdf select2ac1 scuolaBacinoSelect scuolaFuoriBacinoSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Fuori Bacino:",
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
                                    "events": {},
                                    "fields": {}
                                },
                                "istitutoComprensivo": {
                                    "type": "radio",
                                    "label": "Istituto Comprensivo:",
                                    "helpers": [],
                                    "fieldClass": "text-left",
                                    "validate": true,
                                    "disabled": false,
                                    "showMessages": true,
                                    "hideInitValidationError": false,
                                    "renderButtons": true,
                                    "useDataSourceAsEnum": true,
                                    "emptySelectFirst": false,
                                    "vertical": false,
                                    "removeDefaultNone": true,
                                    "hideNone": true,
                                    "sort": false,
                                    "optionLabels": [
                                        "SI",
                                        "NO"
                                    ],
                                    "fields": {}
                                },
                                "labelDescIstitutoComprensivo": {
                                    "type": "label",
                                    "label": "<p style='text-align: left'ISTITUTO COMPRENSIVO: indicare se la scuola da frequentare per l'a.s. indicato appartiene allo stesso Istituto Comprensivo frequentato negli anni scolastici precedenti. La dichiarazione sarà sottoposta a verifica presso le scuole indicate. In tal caso, saranno applicate le tariffe relative agli utenti appartenenti al bacino.</p>",
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
                                    "fields": {}
                                }
                            }
                        },
                        "customScuolaBacRegolare": {
                        	"fieldClass": "hideInPdf",
                            "type": "elencoScuoleBacRegAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleBacRegAutoCompleteSelect-view",
                            "fields": {
                                "scuolaBacinoRegolare": {
                                    "fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoRegolareSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Bacino Regolare:",
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
                                    "events": {},
                                    "fields": {}
                                }
                            }
                        },
                        "customScuolaBacinoPeg": {
                        	"fieldClass": "hideInPdf",
                            "type": "elencoScuoleBacPegAutoCompleteSelect",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "hidden":false,
                            "focus": false,
                            "view": "elencoScuoleBacPegAutoCompleteSelect-view",
                            "fields": {
                                "scuolaBacinoPeg": {
                                    "fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoPegSelect",
                                    "url": "",
                                    "type": "select",
                                    "label": "Scuola Bacino Regolare e Inferiore:",
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
                                    "events": {},
                                    "fields": {}
                                }
                            }
                        },
                        "labelScuolaScelta": {
                            "type": "label",
                            "label": "<p style='text-align: center'>Scuola Selezionata:</p>",
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
                            "fields": {}
                        },
                        "nomeScuola": {
                            "type": "text",
                            "disabled": true,
                            "label": "Scuola: ",
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        },
                        "plessoScuola": {
                            "type": "text",
                            "disabled": true,
                            "label": "Plesso: ",
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        },
                        "tipologiaScuola": {
                            "type": "text",
                            "disabled": true,
                            "label": "Grado: ",
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        },
                        "indirizzoScuola": {
                            "type": "text",
                            "disabled": true,
                            "label": "Indirizzo: ",
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        },
                        "comuneProvinciaScuola": {
                            "type": "text",
                            "disabled": true,
                            "label": "Comune: ",
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": true,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        },
                        "tempoPieno": {
                            "type": "radio",
                            "label": "Tempo Pieno:",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "hideInitValidationError": false,
                            "renderButtons": true,
                            "useDataSourceAsEnum": true,
                            "emptySelectFirst": false,
                            "vertical": false,
                            "noneLabel": "NO",
                            "removeDefaultNone": true,
                            "hideNone": true,
                            "sort": false,
                            "optionLabels": [
                                "SI",
                                "NO"
                            ],
                            "fields": {}
                        },
                        "annotazioni": {
                            "type": "textarea",
                            "label": "Annotazioni",
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
                            "rows": 5,
                            "cols": 40,
                            "fields": {}
                        },
                        "codiceScuola": {
                            "type": "text",
                            "disabled": true,
                            "hidden": true,
                            "renderButtons": true,
                            "helpers": [],
                            "validate": true,
                            "showMessages": false,
                            "data": {},
                            "attributes": {},
                            "allowOptionalEmpty": true,
                            "autocomplete": false,
                            "disallowEmptySpaces": false,
                            "disallowOnlyEmptySpaces": false,
                            "fields": {}
                        }
                    },
                    "events": {
                    	"ready": function(){
                    		var self = this;
                    		var selectBPeg = self.childrenByPropertyId['customScuolaBacinoPeg'];
                    		if( delegaPresente && opPeg){
                    			console.log("MOSTRO bacino PEG");
                    			if( selectBPeg ) {
		                    		selectBPeg.options.hidden = false;
		                    	}
                    		} else {
                    			if( selectBPeg ) {
                    				console.log("NASCONDO bacino PEG");
		                    		selectBPeg.options.hidden = true;
		                    	}
                    		}
                    		selectBPeg.refresh();
                    		
                    		$.ajax({
			                    url: checkResidenteUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
		                        },
			                    success: function (data) {
			                    	console.log("eseguita checkResidenteUrl, valore check:" + data.checkResponse);
			                    	
			                    	var selectBR = self.childrenByPropertyId['customScuolaBacRegolare'];
			                    	
			                    	if(data.checkResponse == false){
			                    		console.log("NASCONDO bacino regolare");
			                    		if( selectBR ) {
			                    			selectBR.options.hidden = true;
				                    	}
			                    		if( selectBPeg ) {
		                    				console.log("NASCONDO bacino PEG");
				                    		selectBPeg.options.hidden = true;
				                    	}
			                    	} else if(data.checkResponse == true){
			                    		console.log("MOSTRO bacino regolare");
			                    		if( selectBR ) {
			                    			selectBR.options.hidden = false;
				                    	}
			                    	}
			                    	selectBR.refresh();
			                    	selectBPeg.refresh();
			                    },
			                    error: function () {	
			                    	console.log("error");
	                            }
                    		});
                         }                    
                    },
                    "type": "object",
                    "validate": true,
                    "showMessages": true,
                    "collapsible": false,
                    "legendStyle": "button",
                    "fieldClass": "breakPagePdf"
                },
                "rubyrails": false,
                "view": "elencoSceltaMinoriRipetibile-view"
            });
            
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scelta Minori Ripetibile";
        },

        /**
		 * @see Alpaca.Fields.ArrayField#getDescription
		 */
        getDescription: function() {
            return "Scelta minori da iscrivere a servizio trasporti con elenco scuole dei bacini";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoSceltaMinoriRipetibile-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Scelta non consentita."
	
	    },
		"templates": {
			"container": elencoSceltaMinoriRipetibileContainer,
			"container-object": elencoSceltaMinoriRipetibileContainerObject
		},
		"fields": {}
    });
    Alpaca.registerFieldClass("elencoSceltaMinoriRipetibile", Alpaca.Fields.ElencoSceltaMinoriRipetibile); 
  
    
})(jQuery);