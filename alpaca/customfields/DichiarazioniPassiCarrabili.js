var dichiarazioniContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var dichiarazioniContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div><div class="row"><div class="col-md-12"><p>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</p>\
         <p>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</p></div></div><div class="row">\
         <div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
         <div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
         </div><div class="row"><div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
         </div><div class="row"><div class="col-md-4">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
         <div class="col-md-4">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div></div><div class="row">\
         <div class="col-md-4">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div></div><div class="row">\
         <div class="col-md-4">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
         <div class="col-md-4">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
         <div class="col-md-4">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
         </div><div class="col-md-12">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
		<div class="col-md-12">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
		<div class="col-md-12">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

function chkDisabled(parent){
	if(parent.childrenByPropertyId["chkDichiarazione1"].getValue() 
		|| parent.childrenByPropertyId["chkDichiarazione2"].getValue() 
			|| parent.childrenByPropertyId["chkDichiarazione3"].getValue()){
	
			parent.childrenByPropertyId["accessoMq"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["numVeicoli"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["chkAccesso"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["titoloAutorizzativo"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["altroTitolo"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["riferimento"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["distanza"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["lunghezza"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["profondita"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["ruoloRichiedente"].getControlEl().attr("disabled", false);
			parent.childrenByPropertyId["utilizzoLocali"].getControlEl().attr("disabled", false);	
	}else{
		parent.childrenByPropertyId["accessoMq"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["numVeicoli"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["chkAccesso"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["titoloAutorizzativo"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["altroTitolo"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["riferimento"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["distanza"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["lunghezza"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["profondita"].getControlEl().attr("disabled", true);	
		parent.childrenByPropertyId["ruoloRichiedente"].getControlEl().attr("disabled", true);
		parent.childrenByPropertyId["utilizzoLocali"].getControlEl().attr("disabled", true);	
	}
};

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DichiarazioniPassiCarrabili = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DichiarazioniPassiCarrabili.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "dichiarazioniPassiCarrabili";
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
	        	    "dependencies": {
		                "altroTitolo": [
		                    "titoloAutorizzativo"
		                ]
		            },
	        	    "properties": {
						"chkRegolamento": {
		                    "disallow": [
		                        false
		                    ],
		                    "readonly": false,
		                    "required": true,
		                    "type": "boolean",
		                    "properties": {}
		                },
		                "chkConoscenza": {
		                    "disallow": [
		                        false
		                    ],
		                    "readonly": false,
		                    "required": true,
		                    "type": "boolean",
		                    "properties": {}
		                },
		                "accessoMq": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "number",
		                    "minimum": 25,
		                    "properties": {}
		                },
		                "numVeicoli": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "properties": {}
		                },
		                "chkAccesso": {
		                    "disallow": [
		                        false
		                    ],
		                    "readonly": false,
		                    "required": true,
		                    "type": "boolean",
		                    "properties": {}
		                },
		                "titoloAutorizzativo": {
		                    "type": "select",
		                    "readonly": false,
		                    "required": true,
		                    "default": "",
		                    "enum": [
		                        "1",
		                        "2",
		                        "3",
		                        "4",
		                        "5"
		                    ],
		                    "properties": {}
		                },
		                "altroTitolo": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "string",
		                    "properties": {}
		                },
		                "riferimento": {
		                    "readonly": false,
		                    "required": false,
		                    "type": "string",
		                    "properties": {}
		                },
		                "distanza": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "properties": {}
		                },
		                "lunghezza": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "properties": {}
		                },
		                "profondita": {
		                    "readonly": false,
		                    "required": true,
		                    "type": "string",
		                    "pattern": "^\\d+$",
		                    "properties": {}
		                },
				        "chkDichiarazione1": {
				            "readonly": false,
				            "required": true,
				            "type": "boolean",
				            "properties": {}
				        },
				        "chkDichiarazione2": {
				            "readonly": false,
				            "required": true,
				            "type": "boolean",
				            "properties": {}
				        },
				        "chkDichiarazione3": {
				            "readonly": false,
				            "required": true,
				            "type": "boolean",
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
	                "view": "dichiarazioniPassiCarrabili-view",
	                "fields": {	
		                "chkRegolamento": {
		                    "type": "checkbox",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": false,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "rightLabel": "Dichiaro di essere a conoscenza del regolamento comunale per l’occupazione di suolo pubblico che disciplina l’apertura di passi carrabili)",
		                    "useDataSourceAsEnum": false,
		                    "sort": false,
		                    "readonly": false,
		                    "order": 1,
		                    "renderButtons": true,
		                    "fields": {}
		                },
		                "chkConoscenza": {
		                    "type": "checkbox",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": false,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "rightLabel": "Dichiaro di essere a conoscenza che la realizzazione del passo carrabile è a propria cura e spese)",
		                    "useDataSourceAsEnum": false,
		                    "sort": false,
		                    "readonly": false,
		                    "order": 2,
		                    "renderButtons": true,
		                    "fields": {}
		                },
		                "accessoMq": {
		                    "type": "number",
		                    "label": "Il passo carrabile da accesso a locale/area di mq (almeno 25mq):",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 3,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "numVeicoli": {
		                    "type": "text",
		                    "label": "Capienza minima di numero veicoli:",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 4,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "chkAccesso": {
		                    "type": "checkbox",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "rightLabel": "Il passo carrabile da accesso a locale/area vincolata o non vincolata al parcheggio ",
		                    "useDataSourceAsEnum": false,
		                    "sort": false,
		                    "readonly": false,
		                    "order": 5,
		                    "renderButtons": true,
		                    "fields": {}
		                },
		                "titoloAutorizzativo": {
		                    "label": "Titolo Autorizzativo",
		                    "type": "select",
		                    "removeDefaultNone": false,
		                    "noneLabel": "Nessuno",
		                    "hideNone": false,
		                    "useDataSourceAsEnum": false,
		                    "multiple": false,
		                    "multiselect": {
		                        "disableIfEmpty": true
		                    },
		                    "sort": false,
		                    "renderButtons": true,
		                    "order": 6,
		                    "readonly": false,
		                    "helpers": [],
		                    "validate": true,
		                    "disabled": true,
		                    "showMessages": true,
		                    "optionLabels": [
		                        "Licenza di costruire",
		                        "Permesso di costruire",
		                        "Concessione edilizia",
		                        "SCIA",
		                        "Altro (specificare)"
		                    ]
		                },
		                "altroTitolo": {
							"dependencies": {
		                        "titoloAutorizzativo": "5"
		                    },
		                    "type": "text",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": false,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 7,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "riferimento": {
		                    "type": "text",
		                    "label": "Riferimento",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 8,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "distanza": {
		                    "type": "text",
		                    "label": "Distanza",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 9,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "lunghezza": {
		                    "type": "text",
		                    "label": "Lunghezza",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 10,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "profondita": {
		                    "type": "text",
		                    "label": "Profondità",
		                    "validate": true,
		                    "showMessages": true,
		                    "disabled": true,
		                    "hidden": false,
		                    "helpers": [],
		                    "hideInitValidationError": true,
		                    "focus": false,
		                    "optionLabels": [],
		                    "typeahead": {},
		                    "allowOptionalEmpty": true,
		                    "data": {},
		                    "autocomplete": false,
		                    "disallowEmptySpaces": true,
		                    "disallowOnlyEmptySpaces": true,
		                    "sort": false,
		                    "order": 11,
		                    "readonly": false,
		                    "renderButtons": true,
		                    "attributes": {},
		                    "fields": {}
		                },
		                "chkDichiarazione1": {
				            "type": "checkbox",
				            "validate": true,
				            "showMessages": true,
				            "disabled": false,
				            "hidden": false,
				            "helpers": [],
				            "hideInitValidationError": true,
				            "focus": false,
				            "rightLabel": "Dichiaro che non siano intercorse modifiche dello stato dei luoghi;",
				            "useDataSourceAsEnum": false,
				            "sort": false,
				            "readonly": false,
				            "order": 12,
				            "renderButtons": true,
				            "fields": {},
				            "events":{
								"change": function(){
									chkDisabled(this.parent);
								}
							}
				        },
		                "chkDichiarazione2": {
				            "type": "checkbox",
				            "validate": true,
				            "showMessages": true,
				            "disabled": false,
				            "hidden": false,
				            "helpers": [],
				            "hideInitValidationError": true,
				            "focus": false,
				            "rightLabel": "Dichiaro che non siano intercorse modifiche nella destinazione d'uso;",
				            "useDataSourceAsEnum": false,
				            "sort": false,
				            "readonly": false,
				            "order": 13,
				            "renderButtons": true,
				            "fields": {},
				            "events":{
								"change": function(){
									chkDisabled(this.parent);
								}
							}
				        },
		                "chkDichiarazione3": {
				            "type": "checkbox",
				            "validate": true,
				            "showMessages": true,
				            "disabled": false,
				            "hidden": false,
				            "helpers": [],
				            "hideInitValidationError": true,
				            "focus": false,
				            "rightLabel": "Dichiaro che non sia tecnicamente possibile procedere alla regolarizzazione del passo carrabile ai sensi dell'art. 46 D.P.R.495/1992;",
				            "useDataSourceAsEnum": false,
				            "sort": false,
				            "readonly": false,
				            "order": 14,
				            "renderButtons": true,
				            "fields": {},
				            "events":{
								"change": function(){
									chkDisabled(this.parent);
								}
							}
				        }
		            }
			});
        },
        
        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dichiarazioni cambio titolarità Passi Carrabili";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Custom per la gestione delle dichiarazioni nel trasferimento di titolarità del passo carrabile";
        }
    });

    Alpaca.registerView({
    	"id": "dichiarazioniPassiCarrabili-view",
    	"parent": "bootstrap-create",
    	"messages": {
			"notOptional": "Campo obbligatorio",
	        "invalidEmail": "Inserire mail valida, p.e. info@cloudcms.com",
	        "disallowValue": "Non è possibile effettuare questa scelta.",
	        "invalidValueOfEnum": "Non è possibile effettuare questa scelta.",
	        "invalidPattern": "Inserire un valore numerico",
        	"stringValueTooSmall": "Valore minimo consentito {0}"
	    },
    	"templates": {
    		"container": dichiarazioniContainer,
    		"container-object": dichiarazioniContainerObject
    	}
    });
    Alpaca.registerFieldClass("dichiarazioniPassiCarrabili", Alpaca.Fields.DichiarazioniPassiCarrabili);
    

})(jQuery);