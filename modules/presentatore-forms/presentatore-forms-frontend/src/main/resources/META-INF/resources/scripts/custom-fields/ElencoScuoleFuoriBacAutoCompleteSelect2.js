var elencoScuoleFuoriBacAutoCompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleFuoriBacAutoCompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleFuoriBacAutoCompleteSelect";
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
                    "scuolaFuoriBacino": {
                    	"fieldClass": "select2ac1 scuolaBacinoSelect scuolaFuoriBacinoSelect hideInPdf",
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
                        "fields": {},
                        "events": {
                        	"ready": function(){
                        		try{
                        			if( listaScuoleFBcByComuneUrl.indexOf('codiceAnnoScolastico') == -1 ){
                        				var codiceAnnoScolastico = this.parent.parent.parent.parent.childrenByPropertyId['annoScolasticoCorrenteObject'].childrenByPropertyId['annoScolasticoCorrente'].getControlEl().val();
                            			console.log("codiceAnnoScolastico=" + codiceAnnoScolastico);
                            			listaScuoleFBcByComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;
                        			}
                        			
                        		}catch(err) {
                        			  console.log("FBC Errore nel recupero anno scolastico" + err.message);
                        		}
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  placeholder: "-- Seleziona --",
					                  ajax: {
					                    url: listaScuoleFBcByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    beforeSend: function(request) {
					                        request.setRequestHeader("User-Token", userToken);
				                        },
					                    timeout: 30000,
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
					                          obj.id = obj.value;
	                                          obj.text = obj.text;
					                          return obj;
					                        });
					                        
					                        return {
					                            results: items
					                        };
					                    },
					                    cache: true
					                  }
					          });
                        		
	                    		this.getControlEl().on('select2:clear', function (e) {
	                    			var self = this;
	                    			var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
			                    	campoNomeScuola.getControlEl().val("");
			                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
			                    	campoPlessoScuola.getControlEl().val("");
			                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
			                    	campoIndirizzoScuola.getControlEl().val("");
			                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
			                    	campoTipologiaScuola.getControlEl().val("");
			                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
			                    	campoComuneProvinciaScuola.getControlEl().val("");
			                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
			                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata:</p>";
			                    	labelBacinoDiAppartenenza.refresh();
	                    		});
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	if(idScuola){
	                        		var	infoScuolaDependentUrl = infoScuolaBacinoByIdUrl + idScuola + "&bacino=BCS";
		                        	$.ajax({
					                    url: infoScuolaDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    success: function (data) {
					                    	
					                    	var selectBRId = self.parent.parent.childrenByPropertyId['customScuolaBacRegolare'].childrenByPropertyId['scuolaBacinoRegolare'].id;
					                    	if( selectBRId ) {
					                    		$('#' + selectBRId).val(null).trigger('change');
					                    	}
					                    	var selectBPegId = self.parent.parent.childrenByPropertyId['customScuolaBacinoPeg'].childrenByPropertyId['scuolaBacinoPeg'].id;
					                    	if( selectBPegId ) {
					                    		$('#' + selectBPegId).val(null).trigger('change');
					                    	}
					                    	
					                    	
					                    	var campoNomeScuola = self.parent.parent.childrenByPropertyId['nomeScuola'];
					                    	campoNomeScuola.getControlEl().val(data.denominazione);
					                    	var campoPlessoScuola = self.parent.parent.childrenByPropertyId['plessoScuola'];
					                    	campoPlessoScuola.getControlEl().val(data.plesso);
					                    	var campoIndirizzoScuola = self.parent.parent.childrenByPropertyId['indirizzoScuola'];
					                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
					                    	var campoTipologiaScuola = self.parent.parent.childrenByPropertyId['tipologiaScuola'];
					                    	campoTipologiaScuola.getControlEl().val(data.grado);
					                    	var campoComuneProvinciaScuola = self.parent.parent.childrenByPropertyId['comuneProvinciaScuola'];
					                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
					                    	var labelBacinoDiAppartenenza = self.parent.parent.childrenByPropertyId['labelScuolaScelta'];
					                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata fuori bacino di appartenenza</p>";
					                    	labelBacinoDiAppartenenza.refresh();
					                    	
					                    	var campoCodiceScuola = self.parent.parent.childrenByPropertyId['codiceScuola'];
					                    	campoCodiceScuola.getControlEl().val(data.codice);
					                    	
					                    }
		                            });
	                        	}
	                        	
	                        }
                        
                        }
                    },
                    "istitutoComprensivo": {
                        "type": "radio",
                        "label": "Stesso Istituto Comprensivo:",
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
                    	"fieldClass": "hideInPdf",
                        "type": "label",
                        "label": "ISTITUTO COMPRENSIVO: se la scuola da frequentare appartiene allo stesso Istituto Comprensivo frequentato negli anni scolastici precedenti, la dichiarazione sarà sottoposta a verifica presso le scuole indicate. In tal caso, saranno applicate le tariffe relative agli utenti appartenenti al bacino",
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
                },
                "view": "elencoScuoleFuoriBacAutoCompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Fuori Bacino con Autocomplete";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola Fuori Bacino di appartenenza con autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleFuoriBacAutoCompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleFuoriBacAutoCompleteSelectContainer,
			"container-object": elencoScuoleFuoriBacAutoCompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleFuoriBacAutoCompleteSelect", Alpaca.Fields.ElencoScuoleFuoriBacAutoCompleteSelect); 
  
    
})(jQuery);