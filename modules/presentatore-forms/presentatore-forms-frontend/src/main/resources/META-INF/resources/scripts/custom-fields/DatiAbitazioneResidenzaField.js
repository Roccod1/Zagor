
(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.DatiAbitazioneResidenzaField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.DatiAbitazioneResidenzaField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiAbitazioneResidenza";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
            	    "type": "object",
            	     "dependencies": {
            	    	 "sezione": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "foglio": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "particella": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "subalterno": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "provenienzaNascitaIntContr": [
            	             "ConditionalFieldDatiAbitazione"
            	         ],
            	         "provenienzaNascitaContr": [
            	             "new1501248550182"
            	         ],
            	         "provenienzaNascitaFam": [
            	             "new1501248550182"
            	         ],
            	         "provenienzaNascitaComLoc": [
            	             "new1501248877873"
            	         ],
            	         "provComuneAgenziaEntrate": [
                	         "ConditionalFieldDatiAbitazione"
                	     ],
            	         "provComuneResidenteUno": [
                	         "ConditionalFieldDatiAbitazione"
                	     ],
            	         "provComuneResidenteDue": [
                	         "new1501248550182"
                	     ],
            	         "provComuneResidenteTre": [
                	         "new1501248877873"
                	     ]
            
            	     },            	    
            	    "required": false,
            	    "properties": {
            	        "labeldatirelativiabitazione": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "new1505134902315": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "ConditionalFieldDatiAbitazione": {
            	            "readonly": false,
            	            "required": true,
            	            "enum": [
            	                "1. Di essere proprietario",
            	                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
            	                "3. Di essere intestatario di contratto di locazione relativo a immobile di Edilizia Residenziale Pubblica (allegare copia del contratto o del verbale di consegna dell'immobile)",
            	                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito",
            	                "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto",
            	                "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto",
            	                "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
            	            ],
            	            "properties": {}
            	        },
            	        "sezione": {
            	            "readonly": false,
            	            "default": "nct",
            	            "required": true,
            	            "enum": [
            	                "nct",
            	                "--"
            	            ],
            	            "properties": {}
            	        },
            	        "foglio": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "pattern": "^[0-9]*$",
            	            "properties": {}
            	        },
            	        "particella": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "pattern": "^[0-9]*$",
            	            "properties": {}
            	        },
            	        "subalterno": {
            	            "readonly": false,
            	            "required": true,
            	            "type": "string",
            	            "pattern": "^[0-9]*$",
            	            "properties": {}
            	        },
            	        "labelAgenziaEntrate": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "provComuneAgenziaEntrate": {
            	            "dependencies": "ConditionalFieldDatiAbitazione",
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
            	        "datiabitazione-data": {
            	            "type": "string",
            	            "required": true,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
            	        "datiabitazione-numero": {
            	            "type": "string",
            	            "required": true,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
            	        "new1501248400387": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        },
            	        "testoTitoloOccupazione": {
            	            "type": "string",
            	            "required": true,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "properties": {}
            	        },
            	        "new1501248550182": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "disallow": [],
            	            "enum": [
                                "Dichiarazione di assenso del proprietario",
                                "Autorizzazione all'ampliamento del nucleo familiare rilasciata da Arca Puglia nel caso si tratti di immobili di edilizia residenziale pubblica"
                            ],
            	            "properties": {}
            	        },
            	        "new1501250098476": {
            	            "readonly": false,
            	            "dependencies": "ConditionalFieldDatiAbitazione",
            	            "required": true,
            	            "type": "string",
            	            "properties": {}
            	        }
            	    }
                };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "labeldatirelativiabitazione": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Dati relativi all'abitazione",
                        "helpers": [],
                        "fieldClass": "text-center",
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
                    "new1505134902315": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Dichiaro di occupare legittimamente l'abitazione contraddistinta dagli estremi catastali riportati di seguito, in base al titolo di seguito descritto, consapevole che, ai sensi dell'art. 5 del D.L. 28.3.2014 n. 47 (convertito nella Legge 23.5.2014 n. 80), in caso di dichiarazione mendace l'iscrizione anagrafica sarà nulla, per espressa previsione di legge, con decorrenza dalla data della dichiarazione stessa",
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
                    "ConditionalFieldDatiAbitazione": {
                        "type": "radio",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helper": "Selezionare una delle opzioni precedenti.", 
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "1. Di essere proprietario",
                            "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                            "3. Di essere intestatario di contratto di locazione relativo a immobile di Edilizia Residenziale Pubblica (allegare copia del contratto o del verbale di consegna dell'immobile)",
                            "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito",
                            "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto",
                            "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto",
                            "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {},
                        "events": {
                        	"mouseover": function () {
                                var campoRadio = this;

                                console.log("in mouseover radio");
                                var checkAllegatoUno = $("div.dli").find("input");
                                var checkAllegatoDue = $("div.tcu").find("input");
                                var checkAllegatoTre = $("div.aop").find("input");
                                var checkAllegatoQuattro = $("div.anf").find("input");
                             
                                if (checkAllegatoUno.length == 0 ||
                                		checkAllegatoDue.length == 0 ||
                                		checkAllegatoTre.length == 0 ||
                                		checkAllegatoQuattro.length == 0) {
                            	campoRadio.options.disabled = true;
                            	campoRadio.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                            	$(campoRadio.field.context).unbind("mouseover");
                            	campoRadio.refresh();
                            	campoRadio.getControlEl().find("input")[0].checked = false;
                                }
                                $(campoRadio.field.context).unbind("mouseover");
                        	},
                            "click": function() {
                                console.log("in click radio");
                                
                                var sceltaRadio = this.getValue();
								
                                var checkAllegatoUno = $("div.dli").find("input");
                                var checkAllegatoDue = $("div.tcu").find("input");
                                var checkAllegatoTre = $("div.aop").find("input");
                                var checkAllegatoQuattro = $("div.anf").find("input");
                            
                                switch (sceltaRadio) {
	                                case "3. Di essere intestatario di contratto di locazione relativo a immobile di Edilizia Residenziale Pubblica (allegare copia del contratto o del verbale di consegna dell'immobile)":
	                                	checkAllegatoUno[0].checked = true;
	                                    checkAllegatoDue[0].checked = false;
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = false;
	                                  break;
	                                case "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto":
	                                	checkAllegatoUno[0].checked = false;
	                                    checkAllegatoDue[0].checked = true;
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = false;
	                                  break;
	                                case "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto":
	                                	checkAllegatoUno[0].checked = false;
	                                    checkAllegatoDue[0].checked = false;
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = false;
	                                  break;
	                                default:
	                                	checkAllegatoUno[0].checked = false;
	                                    checkAllegatoDue[0].checked = false;
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = false;
                                }
                            }
                         }
                    }, 
                    "sezione": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                            	"1. Di essere proprietario"                            ]
                        }, 
                        "type": "select",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Sezione",
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "nct",
                            "--"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "Nessuno",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "multiple": false,
                        "emptySelectFirst": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "foglio": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                            	"1. Di essere proprietario"                            ]
                        },
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Foglio",
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
                        "numericEntry": false,
                        "sort": false,
                        "readonly": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "particella": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                            	"1. Di essere proprietario"                            ]
                        },
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Particella o mappale",
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
                        "numericEntry": false,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "fields": {}
                    },
                    "subalterno": {
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                            	"1. Di essere proprietario"                            ]
                        },
                        "type": "text",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "Subalterno",
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
                        "numericEntry": false,
                        "sort": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "labelAgenziaEntrate": {
                        "type": "label",
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },                         
                        "label": "All'Agenzia delle Entrate di:",
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
                    "provComuneAgenziaEntrate": {
                    	"type": "provinciaComuneRequired",
                    	"dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        }, 
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
                    "datiabitazione-data": {
                        "type": "date",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "in data",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },
                    "datiabitazione-numero": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "al numero",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "2. Di essere intestatario del contratto di locazione regolarmente registrato presso l'Agenzia delle Entrante nella data e numero riportato di seguito",
                                "4. Di essere comodatario con contratto di comodato d'uso gratuito regolarmente registrato presso l'Agenzia delle Entrate ina data e al numero riportato di seguito"
                            ]
                        },
                        "fields": {}
                    },

                    "new1501248400387": {
                        "type": "textarea",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Titolo costitutivo",
                        "helpers": [
                            "Indicare dati utili a consentire verifica da parte dell'Ufficio Anagrafe"
                        ],
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
                        "renderButtons": true,
                        "attributes": {},
                        "readonly": false,
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "5. Di essere usufruttario, in forza del titolo costitutivo di seguito descritto"
                            ]
                        },
                        "fields": {}
                    },
                    "testoTitoloOccupazione": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Di occupare legittimamente l'abitazione in base al titolo di seguito descritto:",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto"
                            ]
                        },
                        "fields": {}
                    },
                    "new1501248550182": {
                    	"label": "",
                        "type": "radio",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [
                            "Questo campo non è opzionale, effettuare una scelta per proseguire."
                        ],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Dichiarazione di assenso del proprietario",
                            "Autorizzazione all'ampliamento del nucleo familiare rilasciata da Arca Puglia nel caso si tratti di immobili di edilizia residenziale pubblica"
                        ],
                        "removeDefaultNone": true,
                        "noneLabel": "None",
                        "hideNone": true,
                        "useDataSourceAsEnum": true,
                        "emptySelectFirst": false,
                        "vertical": true,
                        "readonly": false,
                        "renderButtons": true,
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "6. Di occupare legittimamente l'abitazione in base al titolo di seguito descritto"
                            ]
                        },
                        "fields": {},
                        "events": {
                        	"click": function() {
                                console.log("in click secondo radio");
                                
                                var sceltaRadio = this.getValue();
                                var checkAllegatoTre = $("div.aop").find("input");
                                var checkAllegatoQuattro = $("div.anf").find("input");
                            
                                switch (sceltaRadio) {
	                                case "Dichiarazione di assenso del proprietario":
	                                    checkAllegatoTre[0].checked = true;
	                                    checkAllegatoQuattro[0].checked = false;
	                                  break;
	                                case "Autorizzazione all'ampliamento del nucleo familiare rilasciata da Arca Puglia nel caso si tratti di immobili di edilizia residenziale pubblica":
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = true;
	                                  break;
	                                default:
	                                    checkAllegatoTre[0].checked = false;
	                                    checkAllegatoQuattro[0].checked = false;
                                }
                            }
                        }  
                    },
                    "new1501250098476": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Specifica altro",
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
                        "dependencies": {
                            "ConditionalFieldDatiAbitazione": [
                                "7. Altro (specificare e allegare ogni titolo idoneo alla verifica da parte dell'ufficiale d'anagrafe)"
                            ]
                        },
                        "readonly": false,
                        "fields": {}
                    }
                },
                "view": "datiAbitazioneResidenza-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati abitazione residenza";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati abitazione residenza";
        }
    });

    Alpaca.registerView({
    	"id": "datiAbitazioneResidenza-view",
    	"parent": "bootstrap-create",
    	"messages": {
            "stringNotAnInteger": "Inserire un valore numerico",
            "invalidPattern": "Inserire un valore numerico"
        }
    });
    Alpaca.registerFieldClass("datiAbitazioneResidenza", Alpaca.Fields.DatiAbitazioneResidenzaField);
    

})(jQuery);