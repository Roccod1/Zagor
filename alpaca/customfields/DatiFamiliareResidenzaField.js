var datiFamiliareResidenzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiFamiliareResidenzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;
    
    var isCheckBinded = false;
    
    var verifyFirma = function(self, isAllFieldsToVerify) {
    	
    	console.log('verifyFirma');
		var dateNascitaDaVerificare = [];
		
		if (isAllFieldsToVerify) {
			$("input[name^='datiFamiliare'][name$='datanascita']").each(
	                function(index, elem) {
	                	if (elem.value && elem.value.length > 0) {
	                		dateNascitaDaVerificare.push(elem.value);
	                	}
	         });
		
		} else {
    		$("input[name^='datiFamiliare'][name$='datanascita']").not(":hidden").each(
	                function(index, elem) {
	                	if (elem.value && elem.value.length > 0) {
	                		dateNascitaDaVerificare.push(elem.value);
	                	}
	         });			
		}
		if (cfLoggedUser !== $("input[name='anagrafeRichiedente_codicefiscale']").val() &&
				$("input[name='anagrafeRichiedente_datanascita']").val() &&
				$("input[name='anagrafeRichiedente_datanascita']").val().length > 0
		) {
			dateNascitaDaVerificare.push($("input[name='anagrafeRichiedente_datanascita']").val());
		}
		
		var i;
		var isTuttiMinorenni = true;
		for (i = 0; i < dateNascitaDaVerificare.length; i++) {
			
        	var splittedDataNascita = dateNascitaDaVerificare[i].split("/");
        	var dataParsata = new Date(splittedDataNascita[2], splittedDataNascita[1] - 1, splittedDataNascita[0]);
        	isTuttiMinorenni = isTuttiMinorenni && (new Date() - dataParsata < 567648000000);
		}
		
    	console.log("isTuttiMinorenni", isTuttiMinorenni);
		if (self.getContainerEl().closest("form").alpaca("get").childrenByPropertyId["isIstanzaDaFirmare"]) {
			self.getContainerEl().closest("form").alpaca("get").childrenByPropertyId["isIstanzaDaFirmare"].setValue(!isTuttiMinorenni);
		}
    	
    }
    
    
    Alpaca.Fields.DatiFamiliareField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DatiFamiliareField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiFamiliare";
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
    	                "labelFamiliare": {
    	                    "type": "string",
    	                    "required": false,
    	                    "properties": {}
    	                },
    	                "cognome": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "nome": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
                        "labelprovenienzanascita": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "provenienzaNascita": {
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
    			                            "required": false,
    			                            "default": "",
    			                            "properties": {}
    			                        },
    			                        "comune": {
    			                            "required": false,
    			                            "enum": [],
    			                            "properties": {}
    			                        }
    			                    }
    			                },
    			                "comuneEstero": {
    			                    "required": false,
    			                    "properties": {}
    			                }
    			            }
    			        },
    	                "datanascita": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "sesso": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "enum": [
    	                        "F",
    	                        "M"
    	                    ],
    	                    "properties": {}
    	                },
    	                "statoCivile": {
                            "readonly": false,
                            "required": true,
                            "properties": {}
                        },
    	                "cittadinanzaObject": {
    	                	"type": "object",
                            "properties": {
                                "stati": {
                                    "default": "Italia",
                                    "required": false,
                                    "properties": {}
                                }
                            }
                        },
    	                "codiceFiscale": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "type": "string",
    	                    "properties": {}
    	                },
    	                "relazioneParentela": {
    	                    "readonly": false,
    	                    "required": true,
    	                    "disallow": [],
    	                    "properties": {}
    	                },
                        "seioccupato": {
                            "readonly": false,
                            "required": true,
                            "disallow": [],
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "posizioneprofessione": {
                            "readonly": false,
                            "dependencies": "seioccupato",
                            "required": true,
                            "enum": [
                                "0",
                                "1",
                                "2",
                                "3",
                                "4",
                                "5"
                            ],
                            "properties": {}
                        },
                        "condizionenonprofessionale": {
                            "readonly": false,
                            "dependencies": "seioccupato",
                            "required": true,
                            "enum": [
                            	"0",
                                "1",
                                "2",
                                "3",
                                "4",
                                "5"
                            ],
                            "properties": {}
                        },
                        "titolostudio": {
                            "readonly": false,
                            "required": true,
                            "properties": {},
                            "enum": [
                                "1",
                                "2",
                                "3",
                                "4",
                                "5",
                                "6",
                                "7",
                                "8",
                                "9"
                            ]
                        },
                        "patenteSiNo": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "veicoliIntestati": {
                            "readonly": false,
                            "required": true,
                            "enum": [
                                "Si",
                                "No"
                            ],
                            "properties": {}
                        },
                        "labelResponsabilitaPenali": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "labelRecapiti": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "telefono": {
                            "type": "string",
                            "required": false,
                            "pattern": "^[0-9]*$",
                            "properties": {}
                        },
                        "fax": {
                            "type": "string",
                            "required": false,
                            "pattern": "^[0-9]*$",
                            "properties": {}
                        },
                        "cellulare": {
                            "type": "string",
                            "required": false,
                            "pattern": "^[0-9]*$",
                            "properties": {}
                        },
                        "email": {
                            "type": "string",
                            "required": false,
                            "pattern": {},
                            "properties": {}
                        },
                        "pec": {
                            "type": "string",
                            "required": false,
                            "pattern": {},
                            "properties": {}
                        },
                        "identificativo": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "identificativoFamiglia": {
                            "type": "string",
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
	                    "labelFamiliare": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Familiare",
	                        "helpers": [],
	                        "fieldClass": "text-center",
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [],
	                        "typeahead": {},
	                        "allowOptionalEmpty": true,
	                        "data": {},
	                        "autocomplete": "false",
	                        "disallowEmptySpaces": false,
	                        "disallowOnlyEmptySpaces": false,
	                        "fields": {}
	                    },
	                    "cognome": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "nome": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "labelprovenienzanascita": {
	                        "type": "label",
	                        "label": "Luogo di nascita",
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
	                    "provenienzaNascita": {
		                    "type": "nazioneProvinciaComune",
		                    "label": "",
		                    "helpers": [],
		                    "validate": true,
		                    "disabled": false,
		                    "showMessages": true,
		                    "collapsible": false,
		                    "legendStyle": "button",
		                    "focus": false,
		                    "helpersPosition": "below",
		                    "view": "nazioneprovinciacomune-view",
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
		                                    "type": "select",
		                                    "validate": false,
		                                    "disabled": false,
		                                    "showMessages": false,
		                                    "dataSource": "",
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
		                                    "events": {},
		                                    "fieldClass": "select2ac1",
		                                    "fields": {}
		                                }
		                            }
		                        },
		                        "provinciaComune": {
		                            "type": "provinciaComune",
		                            "label": "",
		                            "helpers": [],
		                            "validate": true,
		                            "disabled": false,
		                            "showMessages": true,
		                            "collapsible": false,
		                            "legendStyle": "button",
		                            "view": "provinciacomune-view",
		                            "fields": {
		                                "provincia": {
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
		                                    "dataSource": "",
		                                    "multiple": false,
		                                    "emptySelectFirst": true,
		                                    "multiselect": {
		                                        "disableIfEmpty": true
		                                    },
		                                    "sort": false,
		                                    "renderButtons": true,
		                                    "events": {},
		                                    "fields": {}
		                                },
		                                "comune": {
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
		                                    "removeDefaultNone": false,
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
		                            "validate": false,
		                            "disabled": false,
		                            "showMessages": true,
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
		                            "events": {},
		                            "useDataSourceAsEnum": true,
		                            "multiselect": {
		                                "disableIfEmpty": true
		                            },
		                            "fields": {}
		                        }
		                    }
		                },					
	                    "datanascita": {
	                        "type": "date",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Data nascita (dd/mm/yyyy):",
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
	                        "dateFormat": "DD/MM/YYYY",
	                        "readonly": false,
	                        "renderButtons": true,
	                        "attributes": {},
	                        "picker": {
	                            "useCurrent": false,
	                            "format": "DD/MM/YYYY",
	                            "locale": "it",
	                            "dayViewHeaderFormat": "MMMM YYYY",
	                            "extraFormats": []
	                        },
	                        "manualEntry": false,
	                        "fields": {},
	                        "events": {
	                        	"blur": function () {
	                        		this.getControlEl().closest('.alpaca-container').change();
	                        	}
	                        }
	                    },
	                    "sesso": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Sesso:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "F",
	                            "M"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "statoCivile": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Stato civile",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "dataSource": function(callback) {
	                        	if (statiCiviliJsonCF.length > 0) {
	                        		callback(statiCiviliJsonCF);
	                        	} else {
	                        		$.ajax({
					                	url: listaStatiCiviliUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
					                    	callback([]);
			                            },
			                            success: function (data) {
			                            	statiCiviliJsonCF = data;
			                            	callback(statiCiviliJsonCF);
			                            }
					                  });
	                        	}
	                        },
	                        "removeDefaultNone": false,
	                        "noneLabel": "--Seleziona--",
	                        "hideNone": false,
	                        "useDataSourceAsEnum": false,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "sort": false,
	                        "renderButtons": true,
	                        "readonly": false,
	                        "fieldClass": "select2ac1",
	                        "fields": {}
	                    },
	                    "cittadinanzaObject": {
	                    	"type": "statiSelectCittadinanza",
                            "label": "",
                            "helpers": [],
                            "validate": true,
                            "disabled": false,
                            "showMessages": true,
                            "collapsible": false,
                            "legendStyle": "button",
                            "view": "statiSelectCittadinanza-view",
                            "fields": {
                                "stati": {
                                	"label": "Cittadinanza:",
                                    "type": "select",
                                    "validate": false,
                                    "disabled": false,
                                    "showMessages": false,
                                    "dataSource": "",
                                    "removeDefaultNone": true,
                                    "noneLabel": "Nessuno",
                                    "hideNone": true,
                                    "useDataSourceAsEnum": false,
                                    "helpers": [],
                                    "renderButtons": true,
                                    "multiselect": {
                                        "disableIfEmpty": true
                                    },
                                    "fieldClass": "select2ac1",
                                    "fields": {}
                                }
                            }
	                    },
	                    "codiceFiscale": {
	                        "type": "text",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Codice fiscale",
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
	                        "sort": false,
	                        "renderButtons": true,
	                        "attributes": {},
	                        "readonly": false,
	                        "fields": {}
	                    },
	                    "relazioneParentela": {
	                        "type": "select",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Rapporto di parentela con il richiedente",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "dataSource": function(callback) {
	                        	if (relazioniParentelaJsonCF.length > 0) {
	                        		callback(relazioniParentelaJsonCF);
	                        	} else {
	                        		$.ajax({
					                	url: listaRelazioniParentelaUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 20000,
					                    error: function () {
					                    	console.log("error");
					                    	callback([]);
			                            },
			                            success: function (data) {
			                            	relazioniParentelaJsonCF = data;
			                            	callback(relazioniParentelaJsonCF);
			                            }
					                  });
	                        	}
	                        },
	                        "removeDefaultNone": false,
	            			"sort": false,
	                        "noneLabel": "--Seleziona--",
	                        "hideNone": false,
	                        "useDataSourceAsEnum": false,
	                        "multiple": false,
	                        "emptySelectFirst": false,
	                        "multiselect": {
	                            "disableIfEmpty": true
	                        },
	                        "renderButtons": true,
	                        "readonly": false,
	                        "fieldClass": "select2ac1",
	                        "fields": {}
	                    },
	                    "seioccupato": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Il soggetto svolge un'attività lavorativa?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "sort": false,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": false,
	                        "fields": {}
	                    },
	                    "posizioneprofessione": {
	                        "type": "radio",
	                        "dependencies": {
	                                "seioccupato": [
	                                    "Si"
	                                ]
	                        },
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Posizione nella professione:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Condizione non professionale o att. disoccupato",
	                            "Imprenditore/Libero professionista",
	                            "Dirigente/Impiegato",
	                            "Lavoratore in proprio",
	                            "Operaio e assimilati",
	                            "Coadiuvante"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "condizionenonprofessionale": {
	                        "type": "radio",
	                        "dependencies": {
	                                "seioccupato": [
	                                    "No"
	                                ]
	                        },            
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Condizione non professionale:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Nessuna condizione",
	                            "Casalinga",
	                            "Studente",
	                            "Disoccupato/in cerca di prima occupazione",
	                            "Pensionato/Ritirato dal lavoro",
	                            "Altra condizione non professionale"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "titolostudio": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Titolo di Studio:",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                        	"Nessun titolo",
	                            "Analfabeta",
	                            "Terza elementare",
	                            "Quinta elementare",
	                            "Licenza elementare",
	                            "Licenza avv. prof.",
	                            "Licenza media",
	                            "Diploma",
	                            "Laurea"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "None",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": false,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "patenteSiNo": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Titolare di patente?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "veicoliIntestati": {
	                        "type": "radio",
	                        "validate": true,
	                        "showMessages": false,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Il soggetto ha veicoli intestati personalmente?",
	                        "helpers": [],
	                        "hideInitValidationError": false,
	                        "focus": false,
	                        "optionLabels": [
	                            "Si",
	                            "No"
	                        ],
	                        "removeDefaultNone": true,
	                        "noneLabel": "Nessuno",
	                        "hideNone": true,
	                        "useDataSourceAsEnum": true,
	                        "emptySelectFirst": false,
	                        "vertical": true,
	                        "sort": false,
	                        "readonly": false,
	                        "renderButtons": true,
	                        "fields": {}
	                    },
	                    "labelResponsabilitaPenali": {
	                        "type": "label",
	                        "validate": false,
	                        "showMessages": true,
	                        "disabled": false,
	                        "hidden": false,
	                        "label": "Consapevole delle responsabilita' penali per le dichiarazioni mendaci ai sensi degli art. 75 e 76 DPR 445/2000 che prevedono la decadenza dai benefici e l'obbligo di denuncia all'autorita' competente",
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
	                        "renderButtons": true,
	                        "attributes": {},
	                        "fields": {}
	                    },
	                    "labelRecapiti": {
	                        "type": "label",
	                        "label": "Recapiti:",
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
	                    "telefono": {
	                        "label": "Telefono",
	                        "type": "text",
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
	                    "fax": {
	                        "label": "Fax",
	                        "type": "text",
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
	                    "cellulare": {
	                        "label": "Cellulare",
	                        "type": "text",
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
	                    "email": {
	                        "label": "Email",
	                        "type": "email",
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
	                    "pec": {
	                        "label": "PEC",
	                        "type": "email",
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
	                    "identificativo": {
	                        "label": "Identificativo",
	                        "type": "hidden",
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
	                    "identificativoFamiglia": {
	                        "label": "Identificativo",
	                        "type": "hidden",
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
	                    }
	                },
	                
	                
	                "events": {
	                	"ready": function() {
	                		var self = this;
	                		
	                		if (!isCheckBinded) {
	                			isCheckBinded = true;
		                		var dependencyCheck = self.parent.parent.childrenByPropertyId["checkFamTrasf"];
		                		if (dependencyCheck) {
		                			dependencyCheck.on("change", function() {
		                				verifyFirma(self, false);		                				
		                				});
		                		}
		                	}
	                		
	                		verifyFirma(self, true);
                    		
	                	},
	                	"remove": function (event) {
	                		$(event.target).alpaca("get").childrenByPropertyId["datanascita"].setValue(null);
	                		this.getContainerEl().change();
	                	},
	                	"change": function (event) {
	                		var self = this;
	                		verifyFirma(self, true);
	                	},
	                	
	                }	                
	                
            	},
            	"view": "familiare-view"
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati Familiare (Servizio Residenza)";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati Familiare (Servizio Residenza)";
        }
    });

    
    
    Alpaca.registerFieldClass("datiFamiliare", Alpaca.Fields.DatiFamiliareField); 
    
    Alpaca.registerView({
        "id": "familiare-view",
        "parent": "bootstrap-create",
        "messages": {
            "invalidEmail": "Inserire una email valida",
            "invalidPattern": "Inserire un valore numerico"
        },
        "templates": {
        	"container": datiFamiliareResidenzaContainer,
        	"container-object": datiFamiliareResidenzaContainerObject
        },
		"messages": {
	    	"stringTooShort" : "Questo campo deve contenere {0} caratteri."
	    }
    });

    Alpaca.registerMessages({
        "addItemButtonLabel": "Aggiungi Familiare"
    }, "familiare-view");
    
})(jQuery);