var checkPartitaIvaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var checkPartitaIvaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		  <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		 </div>\
		<div class="row">\
		  <div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		  <div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

function checkPIva(element){
	
	var cf = $('input[name=datiOperatoreSoggettoOrganizzatore_codiceFiscale]').val();
	var pIva = element.parent.childrenByPropertyId["pIva"];
	var cfAzienda = element.parent.childrenByPropertyId["cfAzienda"];
	var organizzatore = element.parent.childrenByPropertyId["denominazioneSoggettoOrganizzatore"];
	var provincia = element.parent.childrenByPropertyId["provincia"];
	var comune = element.parent.childrenByPropertyId["comune"];
	var viaSede = element.parent.childrenByPropertyId["viaSedeLegale"];
	var civicoSede = element.parent.childrenByPropertyId["civicoSedeLegale"];
	var pec = element.parent.childrenByPropertyId["pec"];
	var cap = element.parent.childrenByPropertyId["cap"];
	
	var abilitato = false;
	
	curJQ.blockUI({ 
 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF; opacity: 1 !important'>Attendere...</div>",
     	baseZ:2000,
         css: { 
             border: 'none', 
             fontFamily: "'Titillium Web',sans-serif",
             opacity: 0.7, 
             color: '#ae1d3f',
      	},
      	overlayCSS: { 
    	  backgroundColor: 'black',
    	  opacity: 0.6,
    	  cursor:'wait'
    	}
   	});	
	
	if(pIva.getValue()){
		$.ajax({
			url: checkIvaUrl + "?pIvaCf=" + pIva.getValue(),
			dataType: 'json',
			timeout: 20000,
			error: function () {
				console.log("error");
				curJQ.unblockUI();
			},
			success: function(data){
				
				if(data.listaCfTitolari){
					for(i = 0; i < data.listaCfTitolari.length; i++){
						if(data.listaCfTitolari[i].toUpperCase() === cf.toUpperCase()){
							abilitato = true;
							break;
						}
					}
				}
				
				if(abilitato){
					
					organizzatore.refresh();
					organizzatore.setValue(data.denominazione);
					
					provincia.refresh();
					provincia.setValue(data.provincia);
					
					comune.refresh();
					comune.setValue(data.comune);
					
					viaSede.refresh();
					viaSede.setValue(data.via);
					
					civicoSede.refresh();
					civicoSede.setValue(data.civico);
					
					pec.refresh();
					pec.setValue(data.pec.toLowerCase());
					
					cfAzienda.refresh();
					cfAzienda.setValue(data.codiceFiscale);
					
					cap.refresh();
					cap.setValue(data.cap);
		
					curJQ.unblockUI();	
						
				} else if(cfAzienda.getValue() && (cf.toUpperCase() === cfAzienda.getValue().toUpperCase())) {
					$.ajax({
						url: checkIvaUrl + "?pIvaCf=" + cfAzienda.getValue().toUpperCase(),
						dataType: 'json',
						timeout: 20000,
						error: function () {
							console.log("error");
							curJQ.unblockUI();
						},
						success: function(data){
							
							if(data.listaCfTitolari){
								for(i = 0; i < data.listaCfTitolari.length; i++){
									if(data.listaCfTitolari[i].toUpperCase() === cf.toUpperCase()){
										abilitato = true;
										break;
									}
								}
							}
							
							if(abilitato){
								
								organizzatore.refresh();
								organizzatore.setValue(data.denominazione);
								
								provincia.refresh();
								provincia.setValue(data.provincia);
								
								comune.refresh();
								comune.setValue(data.comune);
								
								viaSede.refresh();
								viaSede.setValue(data.via);
								
								civicoSede.refresh();
								civicoSede.setValue(data.civico);
								
								pec.refresh();
								pec.setValue(data.pec.toLowerCase());
								
								pIva.refresh();
								pIva.setValue(data.partitaIva);
								
								cap.refresh();
								cap.setValue(data.cap);
					
								curJQ.unblockUI();		
							} else {
								
								organizzatore.refresh();
								organizzatore.setValue();
								
								provincia.refresh();
								provincia.setValue();
								
								comune.refresh();
								comune.setValue();
								
								viaSede.refresh();
								viaSede.setValue();
								
								civicoSede.refresh();
								civicoSede.setValue();
								
								pec.refresh();
								pec.setValue();
								
								cfAzienda.refresh();
								cfAzienda.setValue();
								
								cap.refresh();
								cap.setValue();
					
								curJQ.unblockUI();	
								alert("UTENTE NON ABILITATO PER LA PARTITA IVA E/O IL CODICE FISCALE INSERITI!");
								
							}
						}
					});
				} else {
					
					organizzatore.refresh();
					organizzatore.setValue();
					
					provincia.refresh();
					provincia.setValue();
					
					comune.refresh();
					comune.setValue();
					
					viaSede.refresh();
					viaSede.setValue();
					
					civicoSede.refresh();
					civicoSede.setValue();
					
					pec.refresh();
					pec.setValue();
					
					cfAzienda.refresh();
					cfAzienda.setValue();
					
					cap.refresh();
					cap.setValue();
		
					curJQ.unblockUI();	
					alert("UTENTE NON ABILITATO PER LA PARTITA IVA INSERITA!");
				}
			}
		});  
	} else if (cfAzienda.getValue() && (cf.toUpperCase() === cfAzienda.getValue().toUpperCase())) {
		$.ajax({
			url: checkIvaUrl + "?pIvaCf=" + cfAzienda.getValue().toUpperCase(),
			dataType: 'json',
			timeout: 20000,
			error: function () {
				console.log("error");
				curJQ.unblockUI();
			},
			success: function(data){
				
				if(data.listaCfTitolari){
					for(i = 0; i < data.listaCfTitolari.length; i++){
						if(data.listaCfTitolari[i].toUpperCase() === cf.toUpperCase()){
							abilitato = true;
							break;
						}
					}
				}
				
				if(abilitato){
					organizzatore.refresh();
					organizzatore.setValue(data.denominazione);
					
					provincia.refresh();
					provincia.setValue(data.provincia);
					
					comune.refresh();
					comune.setValue(data.comune);
					
					viaSede.refresh();
					viaSede.setValue(data.via);
					
					civicoSede.refresh();
					civicoSede.setValue(data.civico);
					
					pec.refresh();
					pec.setValue(data.pec.toLowerCase());
					
					pIva.refresh();
					pIva.setValue(data.partitaIva);
					
					cap.refresh();
					cap.setValue(data.cap);
				
					curJQ.unblockUI();
				} else {
					curJQ.unblockUI();
					alert("UTENTE NON ABILITATO PER IL CODICE FISCALE INSERITO!");
				}		
			},
		});
	} else {
		
		organizzatore.refresh();
		organizzatore.setValue();
		
		provincia.refresh();
		provincia.setValue();
		
		comune.refresh();
		comune.setValue();
		
		viaSede.refresh();
		viaSede.setValue();
		
		civicoSede.refresh();
		civicoSede.setValue();
		
		pec.refresh();
		pec.setValue();
		
		cfAzienda.refresh();
		cfAzienda.setValue();
		
		cap.refresh();
		cap.setValue();

		curJQ.unblockUI();	
		alert("UTENTE NON ABILITATO PER LA PARTITA IVA E/O CODICE FISCALE INSERITI!");
	}		 
}

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.CheckPartitaIva = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CheckPartitaIva.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "checkPartitaIva";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
    		 	"type": "object",
			    "dependencies": {
			        "privatoDelegato": [
			            "isDelegato"
			        ],
			        "privato": [
			            "isDelegato"
			        ]
			    },
             	"properties": {
					"isDelegato": {
			            "readonly": false,
			            "type": "boolean",
			            "required": false,
			            "properties": {}
			        },
                    "privato": {
						"type": "object",
						"properties": {
							"pIva": {
		                         "type": "string",			                    
	                   			 "pattern": "^\\d+$",
		                         "required": true,
		                         "maxLength": 11,
		                         "minLength": 11,
		                         "properties": {}
		                     },
		                     "cfAzienda": {
		                         "type": "string",
		                         "required": false,
		                         "maxLength": 16,
		                         "minLength": 11,
		                         "properties": {}
		                     },
		                     "chkButton": {
		        	            "type": "string",
		        	            "required": false,
		        	            "properties": {}
		        	        },
		        	        "inQualitaLabel": {
			                    "type": "string",
			                    "required": false,
			                    "properties": {}
			                },
			                "denominazioneSoggettoOrganizzatore": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "labelSedeLegale": {
			                    "type": "string",
			                    "required": false,
			                    "properties": {}
			                },
			                "provincia": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "comune": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "cap": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "viaSedeLegale": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "civicoSedeLegale": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "pec": {
			                    "readonly": false,
			                    "required": true,
			                    "type": "string",
			                    "properties": {}
			                },
			                "telefono": {
			                    "readonly": false,
			                    "required": false,
			                    "type": "string",
			                    "pattern": "^\\d+$",
			                    "properties": {}
			                },
			                "url": {
			                    "readonly": false,
			                    "required": false,
			                    "type": "string",
			                    "properties": {}
			                }
						}
					},
					"privatoDelegato": {
			            "type": "object",
			            "required": false,
			            "properties": {
			                "pIva": {
			                    "type": "string",			                    
	                   			"pattern": "^\\d+$",
			                    "required": true,
			                    "maxLength": 11,
		                        "minLength": 11,
			                    "properties": {}
			                },
			                "cfAzienda": {
			                    "type": "string",
			                    "required": true,
			                    "maxLength": 16,
		                        "minLength": 11,
			                    "properties": {}
			                },
			                "inQualitaLabel": {
			                    "type": "string",
			                    "required": false,
			                    "properties": {}
			                },
			                "denominazioneSoggettoOrganizzatore": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "labelSedeLegale": {
			                    "type": "string",
			                    "required": false,
			                    "properties": {}
			                },
			                "provincia": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "comune": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "cap": {
			                    "type": "string",
			                    "required": true,
			                    "pattern": "^\\d+$",
	                            "maxLength": 5,
	                            "minLength": 5,
			                    "properties": {}
			                },
			                "viaSedeLegale": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "civicoSedeLegale": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                },
			                "pec": {
			                    "readonly": false,
			                    "required": true,
			                    "type": "string",
			                    "properties": {}
			                },
			                "telefono": {
			                    "readonly": false,
			                    "required": false,
			                    "type": "string",
			                    "pattern": "^\\d+$",
			                    "properties": {}
			                },
			                "url": {
			                    "readonly": false,
			                    "required": false,
			                    "type": "string",
			                    "properties": {}
			                }
			            }
			        }  
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"validate": false,
    			"showMessages": false,
            	"fieldClass": "entePrivatoClass",
                "fields": {
                    "isDelegato": {
			            "type": "checkbox",
			            "disabled": false,
			            "hidden": false,
			            "helpers": [],
			            "hideInitValidationError": true,
			            "focus": false,
			            "rightLabel": "Soggetto Delegato",
			            "useDataSourceAsEnum": false,
			            "sort": false,
			            "readonly": false,
			            "renderButtons": true,
			            "fields": {},
			            "events":{
							"change": function(){
								//Allegato delega obbligatorio
								var checkAllegato = $("div.dlg").find("input");
								
								var checkAllegato = $("div.dlg").find("input");
								if (checkAllegato.length == 0) {
                                	this.options.disabled = true;
                                	this.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                	this.refresh();
                                	this.getControlEl().val('');
                             	}else{
									 if(this.getValue() === true){
	                            	 	checkAllegato[0].checked = true;
		                             } else {
		                            	 checkAllegato[0].checked = false;
		                             }
								}
							}
						}
			        },
                    "privato": {
		            	"validate": false,
		    			"showMessages": false,
			            "type": "object",
			            "helpers": [],
			            "disabled": false,
			            "collapsible": false,
			            "legendStyle": "button",
			            "dependencies": {
			                "isDelegato": false
			            },
			            "view": {
							"messages": {
						        "notOptional": "Campo obbligatorio",
						        "stringNotANumber": "Inserire un valore numerico",
						        "invalidValueOfEnum": "Selezionare un valore",
						        "stringTooLong": "Valore massimo consentito {0}",
						        "stringTooShort": "Valore minimo consentito {0}",
						        "invalidPattern": "Inserire un valore numerico"
						    },
							"templates": {
								"container": "<div>{{#container}}{{/container}}</div>",
								"container-object": "<div class='row'>\
									  <div class='col-md-5'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-5'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-2'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-12'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-12'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-2'>{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-4'>{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-4'>{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-2'>{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
										<div class='col-md-4'>{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
										<div class='col-md-2'>{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
									 	<div class='col-md-6'>{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-6'>{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-6'>{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>"
								}
						},
			            "fields":{
		                    "pIva": {
			                    "type": "text",
			                    "disabled": false,
			                    "label": "P. IVA",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
		                    },
		                    "cfAzienda": {
		                        "type": "text",
			                    "disabled": false,
			                    "label": "C.F.",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
		                    },
		                    "chkButton": {
								"validate": false,
	                            "showMessages": false,
		                        "fieldClass": "hideInPdf",
		                        "type": "label",
		                        "label": " <div class='paddingtop20'> <span class='btn btn-primary padding10'><icon class='fa fa-check paddingright10'></icon><b>Check</b></span></div>",
		                        "helpers": [],
		                        "disabled": false,
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
										checkPIva(this);
									}
		                        }
		                    },
		                    "inQualitaLabel": {
								"validate": false,
	                            "showMessages": false,
			                    "label": "In qualit&agrave; di Legale rappresentante del soggetto organizzatore",
			                    "fieldClass": "",
			                    "type": "text",
			                    "helpers": [],
			                    "disabled": true,
			                    "hidden": false,
			                    "attributes": {},
			                    "autocomplete": false,
			                    "renderButtons": true,
			                    "allowOptionalEmpty": true,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "view": "bootstrap-display",
			                    "fields": {}
			                },
			                "denominazioneSoggettoOrganizzatore": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "Denominazione dell'Ente Organizzatore dell'iniziativa:",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "labelSedeLegale": {
								"validate": true,
	                            "showMessages": true,
			                    "label": "Con Sede Legale in",
			                    "fieldClass": "text-center, paddingtop20",
			                    "type": "text",
			                    "helpers": [],
			                    "disabled": false,
			                    "hidden": false,
			                    "attributes": {},
			                    "autocomplete": false,
			                    "renderButtons": true,
			                    "allowOptionalEmpty": true,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "view": "bootstrap-display",
			                    "fields": {}
			                },
			                "provincia": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "Provincia",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "comune": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "Comune",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "cap": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "C.A.P.",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "viaSedeLegale": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "Via",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "civicoSedeLegale": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": true,
			                    "label": "N&#176;",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "pec": {
			                    "type": "text",
								"validate": true,
	                            "showMessages": true,
			                    "disabled": true,
			                    "hidden": false,
			                    "label": "PEC",
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
			                    "readonly": false,
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "telefono": {
								"validate": false,
	                            "showMessages": false,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Telefono",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "url": {
								"validate": false,
	                            "showMessages": false,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Sito Web",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                }
		                }
	                },
                    "privatoDelegato": {
		            	"validate": false,
		    			"showMessages": false,
			            "type": "object",
			            "helpers": [],
			            "disabled": false,
			            "collapsible": false,
			            "legendStyle": "button",
			            "dependencies": {
			                "isDelegato": true
			            },
			            "view": {
							"messages": {
						        "notOptional": "Campo obbligatorio",
						        "stringNotANumber": "Inserire un valore numerico",
						        "invalidValueOfEnum": "Selezionare un valore",
						        "stringTooLong": "Valore massimo consentito {0}",
						        "stringTooShort": "Valore minimo consentito {0}",
						        "invalidPattern": "Inserire un valore numerico",
	        					"invalidEmail": "Inserire la mail nel formato info@cloudcms.com",
						    },
							"templates":{
								"container": "<div>{{#container}}{{/container}}</div>",
								"container-object": "<div class='row'>\
									  <div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-12'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-12'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-2'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-4'>{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-4'>{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-2'>{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-4'>{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-2'>{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-6'>{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>\
									<div class='row'>\
									  <div class='col-md-6'>{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
									  <div class='col-md-6'>{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
									</div>"
							}
						},
			            "fields": {
							"pIva": {
			                    "type": "text",
			                    "disabled": false,
			                    "label": "P. IVA",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "cfAzienda": {
			                    "type": "text",
			                    "disabled": false,
			                    "label": "C.F.",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "inQualitaLabel": {
								"validate": false,
	                            "showMessages": false,
			                    "label": "In qualit&agrave; di Legale rappresentante del soggetto organizzatore",
			                    "fieldClass": "",
			                    "type": "text",
			                    "helpers": [],
			                    "disabled": true,
			                    "hidden": false,
			                    "attributes": {},
			                    "autocomplete": false,
			                    "renderButtons": true,
			                    "allowOptionalEmpty": true,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "view": "bootstrap-display",
			                    "fields": {}
			                },
			                "denominazioneSoggettoOrganizzatore": {				
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Denominazione dell'Ente Organizzatore dell'iniziativa:",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "labelSedeLegale": {
								"validate": false,
	                            "showMessages": false,
			                    "label": "Con Sede Legale in",
			                    "fieldClass": "text-center, paddingtop20",
			                    "type": "text",
			                    "helpers": [],
			                    "disabled": false,
			                    "hidden": false,
			                    "attributes": {},
			                    "autocomplete": false,
			                    "renderButtons": true,
			                    "allowOptionalEmpty": true,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "view": "bootstrap-display",
			                    "fields": {}
			                },
			                "provincia": {
			                    "label": "Provincia",
			                    "fieldClass" : "select2ac1 notSelect2",
								"type": "select",
								"validate": true,
		                        "showMessages": true,
		                        "disabled": false,
		                        "hidden": false,
		                        "helpers": [],
		                        "hideInitValidationError": true,
		                        "focus": false,
		                        "optionLabels": [], 
		                        "removeDefaultNone": false,
		                        "noneLabel": "-- Seleziona --",
		                        "hideNone": false,
		                        "useDataSourceAsEnum": false,
		                        "multiple": false, 
		                        "multiselect": {
		                            "disableIfEmpty": true
		                        },
		                        "sort": false,
		                        "renderButtons": true,
		                        "fields": {},
		                        "emptySelectFirst": true,
			                    "dataSource": function(callback) {
									$.ajax({
					                	url: getAllProvinceUrl,
					                    dataType: 'json',
					                    delay: 0,
					                    timeout: 20000,
					                    error: function (err) {
					                    	console.log("error", err);
					                    	callback([]);
			                            },
			                            success: function (data) {
			                            	callback(data);
			                            }
					                });
		                        },
		                        "events": {
		                            "ready": function(){
		                                
		                                var provincia = this.getValue();
										var comune = this.parent.childrenByPropertyId['comune'];
										if (comune != null && comune !== 'undefined') {
			                                if(!provincia){
												comune.options.optionLabels = [];
			                                	
												comune.getControlEl().val('');
												comune.getControlEl().prop('disabled', true);
			                                } else {
			                                	comune.options.dataSource = getComuniFiereUrl + "?provincia=" + provincia;;
			                                	var currentData = comune.data;
			                                    comune.refresh();
			                                    if (currentData) {
			                                    	comune.data = currentData;
			                                    	comune.setValue(currentData);
			                                    }
			                                }
										}
		                            },
									"change": function(){
										
										var provincia = this.getValue();
										var comune = this.parent.childrenByPropertyId['comune'];
										if (comune != null && comune !== 'undefined') {
			                                if(!provincia){
			 									comune.options.optionLabels = [];
												comune.getControlEl().val('');
												comune.getControlEl().prop('disabled', true);
			                                }
			                                else {
												comune.getControlEl().val('');
			                                	comune.options.dataSource = getComuniFiereUrl + "?provincia=" + provincia;
			                                    comune.refresh();
			                                }
										}
									}
								}
			                },
			                "comune": {
			                    "label": "Comune",
			                    "fieldClass" : "select2ac1 notSelect2",
								"type": "select",
								"validate": true,
		                        "showMessages": true,
		                        "disabled": false,
		                        "hidden": false,
		                        "helpers": [],
		                        "hideInitValidationError": true,
		                        "focus": false,
		                        "optionLabels": [], 
		                        "removeDefaultNone": false,
		                        "noneLabel": "-- Seleziona --",
		                        "hideNone": false,
		                        "emptySelectFirst": true,
		                        "useDataSourceAsEnum": false,
		                        "multiple": false, 
		                        "multiselect": {
		                            "disableIfEmpty": true
		                        },
		                        "sort": false,
		                        "renderButtons": true,
		                        "fields": {}
			                },
			                "cap": {
			                    "type": "text",
			                    "disabled": false,
			                    "label": "C.A.P.",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "viaSedeLegale": {
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Via",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "validate": true,
			                    "showMessages": true,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "civicoSedeLegale": {
								"validate": true,
	                            "showMessages": true,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "N&#176;",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "pec": {
			                    "type": "email",
			                    "validate": true,
			                    "showMessages": true,
			                    "disabled": false,
			                    "hidden": false,
			                    "label": "PEC",
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
			                    "readonly": false,
			                    "renderButtons": true,
			                    "attributes": {},
			                    "fields": {}
			                },
			                "telefono": {				
								"validate": false,
	                            "showMessages": false,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Telefono",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "readonly": false,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                },
			                "url": {
								"validate": false,
	                            "showMessages": false,
			                    "type": "text",
			                    "disabled": false,
			                    "label": "Sito Web",
			                    "renderButtons": true,
			                    "attributes": {},
			                    "helpers": [],
			                    "readonly": false,
			                    "data": {},
			                    "allowOptionalEmpty": true,
			                    "autocomplete": false,
			                    "disallowEmptySpaces": false,
			                    "disallowOnlyEmptySpaces": false,
			                    "fields": {}
			                }
						}
					}
                },
                "view": "checkPartitaIva-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Ente Privato per fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Ente Privato per fiere con check partita iva inserita";
        }
    });
   
    Alpaca.registerView({
	  	"id": "checkPartitaIva-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidPattern": "Formato non valido.",
	        "stringNotANumber": "Inserire un valore numerico",
	        "invalidValueOfEnum": "Selezionare un valore",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}"
	    },
		"templates": {
			"container": checkPartitaIvaContainer,
			"container-object": checkPartitaIvaContainerObject
		}
    });
    Alpaca.registerFieldClass("checkPartitaIva", Alpaca.Fields.CheckPartitaIva); 
  
    
})(jQuery);