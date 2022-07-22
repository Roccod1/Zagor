var anagrafeRichiedenteResidenzaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="50"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var anagrafeRichiedenteResidenzaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div> \
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
		<div class="row"> \
			<div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	    <div class="row"> \
	        <div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div> \
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
    </div> \
</script>';


(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.anagrafeRichiedenteResidenza = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.anagrafeRichiedenteResidenza.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "anagrafeRichiedenteResidenza";
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
                    "cognome": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "nome": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
					"luogoNascita": {
						"type": "string",
                        "required": true,
                        "properties": {}
			        },
                    "datanascita": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "sesso": {
                        "type": "string",
                        "required": true,
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
                                "default": "100",
                                "required": false,
                                "properties": {}
                            }
                        }
                    },
                    "codicefiscale": {
                        "type": "string",
                        "required": true,
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
                    "titolarePatente": {
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
                    "new1494931736686": {
                        "type": "string",
                        "required": false,
                        "properties": {}
                    },
                    "codiceIstatComuneNascitaHidden": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "siglaProvinciaNascitaHidden": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "codiceStatoEsteroNascitaHidden": {
                        "type": "string",
                        "required": true,
                        "properties": {}
                    },
                    "codiceComuneEsteroNascitaHidden": {
                    	"type": "string",
                    	"required": true,
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
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "nome": {
                        "type": "text",
                        "label": "Nome",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
	                "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {},
                        "events": {
                        	"ready": function () {
                        		if (!this.getValue() || this.getValue === "") {
                        			this.getControlEl().attr("disabled", false);
                        		}
                        	}
                        }
	                },					
                    "datanascita": {
                        "type": "date",
                        "label": "Data nascita (dd/mm/yyyy)",
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
                        "showMessages": false,
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "sesso": {
                        "type": "text",
                        "label": "Sesso",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
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
                    "codicefiscale": {
                        "type": "text",
                        "label": "Codice Fiscale",
                        "focus": false,
                        "disabled": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
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
                    "titolarePatente": {
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
                    "new1494931736686": {
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
                    "codiceIstatComuneNascitaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "siglaProvinciaNascitaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "codiceStatoEsteroNascitaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "codiceComuneEsteroNascitaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
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
                    	console.log("ready anagrafe ", this.childrenByPropertyId["codicefiscale"].getValue());
                    	
                		if (cfLoggedUser !== this.childrenByPropertyId["codicefiscale"].getValue()) {
                			var dataNascita = this.childrenByPropertyId["datanascita"].getValue();
                			var splittedDataNascita = dataNascita.split("/");
                        	var dataParsata = new Date(splittedDataNascita[2], splittedDataNascita[1] - 1, splittedDataNascita[0]);
                        	var isMinorenne = (new Date() - dataParsata < 567648000000);
                        	if (this.parent.childrenByPropertyId["isIstanzaDaFirmare"]) {
                        		this.parent.childrenByPropertyId["isIstanzaDaFirmare"].setValue(!isMinorenne);
                    			console.log("is istanza da firmare set ", !isMinorenne);
                    		}

                		}                		
                    }
                },
                "view": "anagrafeRichiedenteResidenza-view"
            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Anagrafe richiedente residenza";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Anagrafe richiedente residenza";
        }
    });

    Alpaca.registerView({
    	"id": "anagrafeRichiedenteResidenza-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": anagrafeRichiedenteResidenzaContainer,
    		"container-object": anagrafeRichiedenteResidenzaContainerObject
    	},
		"messages": {
			"notOptional": "Campo obbligatorio.",
	    	"stringTooShort" : "Questo campo deve contenere {0} caratteri."
	    }
    });
    Alpaca.registerFieldClass("anagrafeRichiedenteResidenza", Alpaca.Fields.anagrafeRichiedenteResidenza);
    

})(jQuery);
