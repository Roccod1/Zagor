var datiAnagraficiSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
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
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DatiAnagraficiSelectCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiSelectCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiSelectCustom";
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
            	        "componentiFam": {
            	            "required": false,
            	            "properties": {}
            	        },
                        "nome": {
                            "title": "Nome",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "cognome": {
                            "title": "Cognome",
                            "type": "string",
                            "properties": {}
                        },
                        "codiceFiscale": {
                            "title": "Cod.Fiscale",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "dataNascita": {
                            "title": "Data di nascita",
                            "type": "string",
                            "properties": {}
                        },
                        "luogoNascita": {
                            "title": "Luogo di nascita",
                            "type": "string",
                            "properties": {}
                      },
                        "indirizzoResidenza":{
                       	 "title": "Indirizzo Residenza",
                            "type": "string",
                            "properties": {}
                        },
                        "viaHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "civicoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "scalaHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "pianoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "internoHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "capHidden": {
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },

                        "comuneResHidden": {
                            "type": "string",
                            "required": false,
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
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
            	"fields": {
                    "componentiFam": {
                    	"fieldClass": "text-center hideInPdf",
                    	"hideInitValidationError": true,
                    	"dataSource": function(callback) {
                    		$.ajax({
			                    url: listaNucleoFamigliareUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
			                      },
			                    success: function (data) {
			                    	callback(data);
			                    },
			                     error: function(){
			                    	console.log("ERRORE su lista nucleo");
			                    }
                    		});
                        },
                        "type": "select",
                        "label": "<p style='text-align: center'>Selezionare componente nucleo familiare:</p>",
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
                        "fields": {},
                        "events": {
                        	"ready": function() {
                        		if (delegaPresente || true) {
	                        		var opt = document.createElement('option');
	                        	    opt.value = "InsManuale";
	                        	    opt.innerHTML = "--Inserimento Manuale--";
	                        	    this.getControlEl()[0].appendChild(opt); 
                        		}
                        	},
	                        "change": function() {
	                        	var self = this;
	                        	
	                        	var campoNome = self.parent.childrenByPropertyId['nome'];
	                        	var campoCognome = self.parent.childrenByPropertyId['cognome'];
	                        	var campoCodFisc = self.parent.childrenByPropertyId['codiceFiscale'];
	                        	var campoDataNascita = self.parent.childrenByPropertyId['dataNascita'];
	                        	var campoLuogoNascita = self.parent.childrenByPropertyId['luogoNascita'];
	                        	var campoIndirizzo = self.parent.childrenByPropertyId['indirizzoResidenza'];
	                        	var campoComuneRes = self.parent.childrenByPropertyId['comuneResHidden'];
	                        	var campoVia = self.parent.childrenByPropertyId['viaHidden'];
	                        	var campoCap = self.parent.childrenByPropertyId['capHidden'];
	                        	var campoCivico = self.parent.childrenByPropertyId['civicoHidden'];
	                        	var campoPiano = self.parent.childrenByPropertyId['pianoHidden'];
	                        	var campoScala = self.parent.childrenByPropertyId['scalaHidden'];
	                        	var campoInterno = self.parent.childrenByPropertyId['internoHidden'];
		                    	
	                        	var idComponente = this.getValue();
	                        	
	                        	if (idComponente === "InsManuale") {
	                        		
	                        		campoNome.options.disabled = false;
			                    	campoCognome.options.disabled = false;
			                    	campoCodFisc.options.disabled = false;
			                    	campoDataNascita.options.disabled = false;
			                    	campoLuogoNascita.options.disabled = false;
			                    	campoIndirizzo.options.disabled = false;  
			                    	
			                    	campoCodFisc.schema.required = true;
			                    	campoNome.schema.required = true;
			                    	campoCognome.schema.required = true;

	                        		campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh();
			                    	campoIndirizzo.refresh(); 
			                    	campoComuneRes.refresh(); 
			                    	campoVia.refresh(); 
			                    	campoCap.refresh(); 
			                    	campoCivico.refresh(); 
			                    	campoPiano.refresh(); 
			                    	campoScala.refresh(); 
			                    	campoInterno.refresh(); 
			                    	
	                        	} else {
		                        	
	                        		campoNome.options.disabled = true;
			                    	campoCognome.options.disabled = true;
			                    	campoCodFisc.options.disabled = true;
			                    	campoDataNascita.options.disabled = true;
			                    	campoLuogoNascita.options.disabled = true;
			                    	campoIndirizzo.options.disabled = true;
	                        		
			                    	campoCodFisc.schema.required = false;
			                    	campoNome.schema.required = false;
			                    	campoCognome.schema.required = false;
			                    	
	                        		campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh();
			                    	campoIndirizzo.refresh(); 
			                    	campoComuneRes.refresh(); 
			                    	campoVia.refresh(); 
			                    	campoCap.refresh(); 
			                    	campoCivico.refresh(); 
			                    	campoPiano.refresh(); 
			                    	campoScala.refresh(); 
			                    	campoInterno.refresh();  
		                        	
		                        	var	infoComponenteDependentUrl = componenteNucleoFamigliareUrl + idComponente;
		                        	$.ajax({
					                    url: infoComponenteDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
					                    },
					                    success: function (data) {
					                    	
					                    	campoNome.getControlEl().val(data.nome);
					                    	campoCognome.getControlEl().val(data.cognome);
					                    	campoCodFisc.getControlEl().val(data.codiceFiscale);
					                    	campoDataNascita.getControlEl().val(data.dataNascitaString);
					                    	campoLuogoNascita.getControlEl().val(data.nomeComuneNascitaFrontEnd);
					                    	
					                    	if (data.indirizzoResidenzaCompletoFrontEnd != null) {
					                    		campoIndirizzo.getControlEl().val(data.indirizzoResidenzaCompletoFrontEnd);
					                    	}
					                    	
					                    	if (data.nomeComuneResidenza != null) {
						                    	campoComuneRes.getControlEl().val(data.nomeComuneResidenza);
					                    	}
					                    	
					                    	if (data.indirizzoResidenza != null) {
						                    	campoVia.getControlEl().val(data.indirizzoResidenza);    
					                    	}
					                    	
					                    	if (data.civicoResidenza != null) {				                    	
						                    	campoCivico.getControlEl().val(data.civicoResidenza);
					                    	}
					                    	
					                    	if (data.capResidenza != null) {				                    	
						                    	campoCap.getControlEl().val(data.capResidenza);     
					                    	}
					                    	
					                    	if (data.pianoResidenza != null) {
						                    	campoPiano.getControlEl().val(data.pianoResidenza);  
					                    	}
					                    	
					                    	if (data.scalaResidenza != null) {
						                    	campoScala.getControlEl().val(data.scalaResidenza);
					                    	}
					                    	
					                    	if (data.internoResidenza != null) {
						                    	campoInterno.getControlEl().val(data.internoResidenza);
					                    	}
					                    }
		                            });
	                        	}
	                        }
                        }
                    },
                    "nome": {
                        "type": "text",
                        "disabled": true,
                        "label": "Nome",
                        "renderButtons": true
                    },
                    "cognome": {
                        "type": "text",
                        "label": "Cognome",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "codiceFiscale": {
                        "type": "text",
                        "disabled": true,
                        "label": "Cod.Fiscale",
                        "renderButtons": true,
                        "attributes": {},
                        "fields": {}
                    },
                    "dataNascita": {
                        "type": "date",
                        "label": "Data di nascita",
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
                
                    "luogoNascita": {
                        "type": "text",
                        "label": "Luogo di nascita",
                        "disabled": true,
                        "renderButtons": true
                    },
                    "indirizzoResidenza":{
                    	"type": "text",
                        "label": "Indirizzo di residenza",
                        "disabled": true,
                        "renderButtons": true,
                        "events": {
                        	"change": function() {
                        		var self = this;
                        		if ($("select[name*='componentiFam']").val() === "InsManuale") {
                        			var campoVia = self.parent.childrenByPropertyId['viaHidden'];
                        			campoVia.getControlEl().val(this.getValue());
                        		}
                        	}
                        }
                    },
                    "viaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "civicoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "scalaHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "pianoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "internoHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "capHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "comuneResHidden": {
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
                "view": "datiAnagraficiSelectCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici con selezione membro famiglia";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici compilati tramite scelta select del membro nucleo familiare";
        }
    });
   
    Alpaca.registerView({
  	"id": "datiAnagraficiSelectCustom-view",
  	"parent": "bootstrap-create",
    "messages": {
        "notOptional": "Campo obbligatorio"
    },
	"templates": {
		"container": datiAnagraficiSelectContainer,
		"container-object": datiAnagraficiSelectContainerObject
	}
    });
    Alpaca.registerFieldClass("datiAnagraficiSelectCustom", Alpaca.Fields.DatiAnagraficiSelectCustom); 
  
    
})(jQuery);