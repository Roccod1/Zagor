var elencoScuoleBacPegAutoCompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleBacPegAutoCompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleBacPegAutoCompleteSelect";
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
            	        "scuolaBacinoPeg": {
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
                    "scuolaBacinoPeg": {
                    	"fieldClass": "select2ac1 scuolaBacinoSelect scuolaBacinoPegSelect",
                        "type": "select",
                        "label": "Scuola Bacino Inferiore:",
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
                        			if( listaScuolePegComuneUrl.indexOf('codiceAnnoScolastico') == -1 ){
                        				var codiceAnnoScolastico = this.parent.parent.parent.parent.childrenByPropertyId['annoScolasticoCorrenteObject'].childrenByPropertyId['annoScolasticoCorrente'].getControlEl().val();
                            			/* console.log("PEG codiceAnnoScolastico=" + codiceAnnoScolastico); */
                            			listaScuolePegComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;	
                        			}
                        			
                        		}catch(err) {
                        			  console.log("PEG Errore nel recupero anno scolastico" + err.message);
                        		}
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumResultsForSearch: -1,
					                  width: "100%",
					                  placeholder: "-- Seleziona --",
					                  ajax: {
					                    url: listaScuolePegComuneUrl,
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
                        		
                        	},
                        	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	if(idScuola){
	                        		var	infoScuolaDependentUrl = infoScuolaBacinoByIdUrl + idScuola + "&bacino=BCI";
		                        	$.ajax({
					                    url: infoScuolaDependentUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    success: function (data) {
					                    	
					                    	var selectBRId = self.parent.parent.childrenByPropertyId['customScuolaBacRegolare'].childrenByPropertyId['scuolaBacinoRegolare'].id;
					                    	if( selectBRId ) {
					                    		$('#' + selectBRId).val(null).trigger('change');
					                    	}
					                    	var selectFBId = self.parent.parent.childrenByPropertyId['customScuolaFuoriBacino'].childrenByPropertyId['scuolaFuoriBacino'].id;
					                    	if( selectFBId ) {
					                    		$('#' + selectFBId).val(null).trigger('change');
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
					                    	labelBacinoDiAppartenenza.options.label = "<p style='text-align: center'>Scuola selezionata del bacino inferiore</p>";
					                    	labelBacinoDiAppartenenza.refresh();
					                    	
					                    	var campoCodiceScuola = self.parent.parent.childrenByPropertyId['codiceScuola'];
					                    	campoCodiceScuola.getControlEl().val(data.codice);
					                    }
		                            });	
	                        	}
	                        	
	                        }
                        
                        }
                    }
                },
                "view": "elencoScuoleBacPegAutoCompleteSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Bacino Inferiore con Autocomplete";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola Bacino Inferiore di appartenenza con autocomplete in ricerca. Riservato Operatore Peg";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleBacPegAutoCompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleBacPegAutoCompleteSelectContainer,
			"container-object": elencoScuoleBacPegAutoCompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleBacPegAutoCompleteSelect", Alpaca.Fields.ElencoScuoleBacPegAutoCompleteSelect); 
  
    
})(jQuery);