
(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.DatiResidentiTariField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.DatiResidentiTariField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "datiResidentiTari";
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
            			"datioccupante": ["residenti-occupazioneimmobile"],
            			"new1499088726373": ["richiestariduzioni"]
                    },
                    "required": false,
                    "properties": {
                    	"new1493905700660": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "new1499090182979": {
                            "readonly": false,
                            "required": false,
                            "type": "boolean",
                            "disallow": [],
                            "enum": [
                                "dichiaro che il box/garage/cantina è di pertinenza dell'abitazione"
                            ],
                            "properties": {}
                        },
                        "residenti-totalecomponenti": {
                            "readonly": false,
                            "required": true,
                            "type": "string",
                            "properties": {}
                        },
                        "residenti-occupazioneimmobile": {
                            "type": "boolean"
                        },
                        "datioccupante": {
                            "items": {
                                "title": "",
                                "type": "object",
                                "properties": {
                                    "new1499087525820": {
                                        "type": "string",
                                        "required": false,
                                        "properties": {}
                                    },
                                    "residenti-cognome": {
                                        "type": "string",
                                        "required": false,
                                        "properties": {}
                                    },
                                    "residenti-nome": {
                                        "type": "string",
                                        "required": false,
                                        "properties": {}
                                    },
                                    "residenti-datanascita": {
                                        "type": "string",
                                        "required": false,
                                        "properties": {}
                                    },
                                    "residenti-codfiscale": {
                                        "type": "string",
                                        "required": false,
                                        "properties": {}
                                    }
                                }
                            },
                            "type": "array",
                            "properties": {},
                            "required": false
                        },
                        "richiestariduzioni": {
                            "type": "boolean"
                        },
                        "new1499088726373": {
                            "readonly": false,
                            "required": false,
                            "type": "array",
                            "disallow": [],
                            "enum": [
                                "Esclusione per immobili non utilizzati, privi di mobili, suppellettili e sprovvisti di contratti attivi di fornitura dei servizi pubblici a rete",
                                "Fabbricato rurale ad uso abitativo",
                                "Riduzione per acquisto e utilizzo del computer",
                                "Riduzione per distanza superiore a 500 mt dal più vicino punto di raccolta",
                                "Riduzione per immobili non utilizzati, ma ammobiliati e/o con utenze",
                                "Riduzione per residenza/dimora all'estero per più di sei mesi nell'anno solare",
                                "Riduzione per unico occupante",
                                "Riduzione per uso stagionale, inferiore a 183 giorni nell'anno solare"
                            ],
                            "properties": {}
                        }
                        
                        
                    }
                };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "new1493905700660": {
                        "type": "label",
                        "validate": false,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "label": "PER I RESIDENTI",
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
                    "new1499090182979": {
                        "type": "checkbox",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "dichiaro che il box/garage/cantina è di pertinenza dell'abitazione"
                        ],
                        "multiple": true,
                        "useDataSourceAsEnum": true,
                        "fields": {},
                        "readonly": false,
                        "renderButtons": true
                    },
                    "residenti-totalecomponenti": {
                        "type": "text",
                        "validate": true,
                        "showMessages": false,
                        "disabled": false,
                        "hidden": false,
                        "label": "Totale componenti nucleo familiare (compreso dichiarante):",
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
                    "residenti-occupazioneimmobile": {
                        "rightLabel": "dichiaro di tenere/occupare l'immobile con"
                    },
                    "datioccupante": {
                        "type": "datiOccupanteTari",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [],
                        "view": "occupante-view",
                        "lazyLoading": false,
                        "collapsible": false,
                        "collapsed": false,
                        "legendStyle": "button",
                        "animate": true,
                        "toolbarSticky": true,
                        "toolbarStyle": "button",
                        "actionbarStyle": "top",
                        "toolbar": {
                            "showLabels": true,
                            "actions": []
                        },
                        "actionbar": {
                            "showLabels": false,
                            "actions": []
                        },
                        "hideToolbarWithChildren": true,
                        "fields": {},
                        "label": "",
                        "items": {
                            "fields": {
                                "new1499087525820": {
                                    "type": "label",
                                    "validate": false,
                                    "showMessages": true,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Occupante",
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
                                    "fields": {},
                                    "renderButtons": true,
                                    "attributes": {}
                                },
                                "residenti-cognome": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Cognome",
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
                                "residenti-nome": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Nome",
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
                                "residenti-datanascita": {
                                    "type": "date",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Data nascita",
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
                                    "fields": {}
                                },
                                "residenti-codfiscale": {
                                    "type": "text",
                                    "validate": true,
                                    "showMessages": true,
                                    "disabled": false,
                                    "hidden": false,
                                    "label": "Cod. Fiscale",
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
                                    "fields": {}
                                }
                            }
                        },
                        "rubyrails": false
                    },
                    "richiestariduzioni": {
                        "rightLabel": "CHIEDO l'applicazione delle seguenti riduzioni/esclusioni"
                    },
                    "new1499088726373": {
                        "type": "checkbox",
                        "validate": true,
                        "showMessages": true,
                        "disabled": false,
                        "hidden": false,
                        "helpers": [],
                        "hideInitValidationError": false,
                        "focus": false,
                        "optionLabels": [
                            "Esclusione per immobili non utilizzati, privi di mobili, suppellettili e sprovvisti di contratti attivi di fornitura dei servizi pubblici a rete",
                            "Fabbricato rurale ad uso abitativo",
                            "Riduzione per acquisto e utilizzo del computer",
                            "Riduzione per distanza superiore a 500 mt dal più vicino punto di raccolta",
                            "Riduzione per immobili non utilizzati, ma ammobiliati e/o con utenze",
                            "Riduzione per residenza/dimora all'estero per più di sei mesi nell'anno solare",
                            "Riduzione per unico occupante",
                            "Riduzione per uso stagionale, inferiore a 183 giorni nell'anno solare"
                        ],
                        "multiple": true,
                        "useDataSourceAsEnum": true,
                        "readonly": false,
                        "renderButtons": true,
                        "fields": {}
                    }
                    
                    
                },

            });

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dati residenti tari";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dati residenti tari";
        }
    });


    Alpaca.registerFieldClass("datiResidentiTari", Alpaca.Fields.DatiResidentiTariField);
    

})(jQuery);