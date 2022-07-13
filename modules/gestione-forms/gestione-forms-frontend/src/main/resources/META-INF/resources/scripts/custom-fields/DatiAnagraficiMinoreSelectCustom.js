var datiAnagraficiMinoreSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiAnagraficiMinoreSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
	    <div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
        
    Alpaca.Fields.DatiAnagraficiMinoreSelectCustom = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DatiAnagraficiMinoreSelectCustom.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "datiAnagraficiMinoreSelectCustom";
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
            };
            
            Alpaca.merge(this.options, {
            	"fieldClass": "breakPagePdf",
                "focus": false,
                "type": "object",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
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
                        "dataSource": function(callback) {
                    		$.ajax({
			                    url: elencoMinoriUrl,
			                    dataType: 'json',
			                    delay: 250,
			                    beforeSend: function(request) {
			                        request.setRequestHeader("User-Token", userToken);
			                      },
			                    success: function (data) {
			                    	callback(data);
			                    }, 
			                    error: function(){
			                    	console.log("ERRORE su informazioni minore");
			                    }
                    		});
                        },
                        "type": "select",
                        "label": "Selezionare minore:",
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
                        	"ready": function(){
                        		if (delegaPresente) {
	                        		var opt = document.createElement('option');
	                        	    opt.value = "-1";
	                        	    opt.innerHTML = "--Inserimento Manuale--";
	                        	    this.getControlEl()[0].appendChild(opt);
                        		}
                        	},
                        	"click": function(){
                                var self = this;
                                var allOptions = $("option", self.getControlEl());
                                allOptions.attr("disabled", false);
                                allOptions.css("color", "black"); 
            	                   var allSelectButThis= $("select[name*='minoriFam']").not(this.getControlEl());
                                     allSelectButThis.each(
                                         function() {
                                            var cfMinore = this.value;
                                            if (cfMinore !== "-1") {
	                                            var optionToDisable = $("option[value='" + cfMinore + "']", self.getControlEl());
	                                            optionToDisable.attr("disabled", true);
	                                            optionToDisable.css("color", "lightgrey");
                                            }
                                         }
                                    );
                            },
	                        "change": function() {
	                        	var self = this;
	                        	
	                        	var campoNome = self.parent.childrenByPropertyId['nomeMinore'];
		                    	var campoCognome = self.parent.childrenByPropertyId['cognomeMinore'];
		                    	var campoCodFisc = self.parent.childrenByPropertyId['codFiscMinore'];
		                    	var campoDataNascita = self.parent.childrenByPropertyId['dataNascitaMinore'];
		                    	var campoLuogoNascita = self.parent.childrenByPropertyId['provComuneRequiredMinore'];
		                    	
		                    	var idComponente = this.getValue();
	                        	
	                        	if (idComponente === "-1") {

	                        		campoNome.options.disabled = false;
	                        		campoCognome.options.disabled = false;
	                        		campoCodFisc.options.disabled = false;
	                        		campoDataNascita.options.disabled = false;
	                        		campoLuogoNascita.options.disabled = false;
	                        		

			                    	campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh(); 
	                        		
	                        	} else {
	                        		
	                        		campoNome.options.disabled = true;
	                        		campoCognome.options.disabled = true;
	                        		campoCodFisc.options.disabled = true;
	                        		campoDataNascita.options.disabled = true;
	                        		campoLuogoNascita.options.disabled = true;
	                        		
			                    	campoNome.refresh();
			                    	campoCognome.refresh();
			                    	campoCodFisc.refresh();
			                    	campoDataNascita.getControlEl().val("");
			                    	campoDataNascita.refresh();
			                    	campoLuogoNascita.refresh(); 
	                        		
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
					                    },
					                    error: function(){
					                    	console.log("ERRORE su informazioni minore");
					                    }
																										
		                            });
	                        	}
	                        }
                        
                        }
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
                },
                "view": "datiAnagraficiMinoreSelectCustom-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Dati anagrafici con selezione minore";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Dati anagrafici compilati tramite scelta select del minore";
        }
    });
   
    Alpaca.registerView({
	  	"id": "datiAnagraficiMinoreSelectCustom-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio"
	    },
		"templates": {
			"container": datiAnagraficiMinoreSelectContainer,
			"container-object": datiAnagraficiMinoreSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("datiAnagraficiMinoreSelectCustom", Alpaca.Fields.DatiAnagraficiMinoreSelectCustom); 
  
    
})(jQuery);