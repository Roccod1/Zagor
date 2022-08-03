var elencoScuoleSingoloAutocompleteSelect2Container = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleSingoloAutocompleteSelect2ContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-3"></div> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-3"></div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2 = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleSingoloAutocompleteSelect2";
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
            	        "scuolaPrincipale": {
            	            "required": true,
            	            "properties": {}
            	        },
            	        "nomeScuola": {
                            "title": "Nome Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "plessoScuola": {
                            "title": "Plesso Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "tipologiaScuola": {
                            "title": "Grado Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "indirizzoScuola": {
                            "title": "Indirizzo Scuola",
                            "type": "string",
                            "required": false,
                            "properties": {}
                        },
                        "comuneProvinciaScuola": {
                            "title": "Luogo Scuola",
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
                    "scuolaPrincipale": {
                    	"fieldClass": "select2ac1 text-center",
                        "type": "select",
                        "label": "Scuola:",
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
                        		
                        		if (!listaScuoleByComuneUrl.includes('&codiceAnnoScolastico=')) {
	                        		try{
	                        			var codiceAnnoScolastico = $('html').find("input[name='annoScolasticoCorrenteObject_annoScolasticoCorrente']").val();
	                        			console.log("codiceAnnoScolastico=" + codiceAnnoScolastico);
	                        			listaScuoleByComuneUrl += '&codiceAnnoScolastico=' + codiceAnnoScolastico;
	                        			
	                        		}catch(err) {
	                        			  console.log("Errore nel recupero anno scolastico" + err.message);
	                        		}
                        		}
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  width: "100%",
					                  minimumInputLength: 0,
					                  placeholder: "Comincia a scrivere per affinare la ricerca...",
					                  ajax: {
			                        		url: listaScuoleByComuneUrl,
						                    dataType: 'json',
						                    delay: 250,
						                    timeout: 20000,
						                    error: function () {
						                    	console.log("error");
				                            },
				                            success: function (data) {
				                            	console.log("success ", data);
				                    
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
						                    cache: true,
						                    transport: function (params, success, failure) {
				                                var $request = $.ajax(params);
				                                console.log('params',params);
				                                $request.then(success);
				                                $request.fail(failure);
				                                if (!params.data.term || params.data.term.length === 0 || params.data.term.length >= 3) {
				                                	return $request;
				                                } else {
				                                	return $request.abort();
				                                }
						                    }
					                  }
					          	});
                        	},           	
                        	"change": function() {
	                        	var self = this;
	                        	var idScuola = this.getValue();
	                        	var	infoScuolaDependentUrl = infoScuolaByIdUrl + idScuola;
	                        	$.ajax({
				                    url: infoScuolaDependentUrl,
				                    dataType: 'json',
				                    delay: 250,
				                    success: function (data) {
				                    	var campoNomeScuola = self.parent.childrenByPropertyId['nomeScuola'];
				                    	campoNomeScuola.getControlEl().val(data.denominazione);
				                    	var campoPlessoScuola = self.parent.childrenByPropertyId['plessoScuola'];
				                    	campoPlessoScuola.getControlEl().val(data.plesso);
				                    	var campoIndirizzoScuola = self.parent.childrenByPropertyId['indirizzoScuola'];
				                    	campoIndirizzoScuola.getControlEl().val(data.indirizzo);
				                    	var campoTipologiaScuola = self.parent.childrenByPropertyId['tipologiaScuola'];
				                    	campoTipologiaScuola.getControlEl().val(data.grado);
				                    	var campoComuneProvinciaScuola = self.parent.childrenByPropertyId['comuneProvinciaScuola'];
				                    	campoComuneProvinciaScuola.getControlEl().val(data.nomeComuneProv);
				                    }
																									
	                            });
	                        }
                        
                        }
                    },
                    "nomeScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Scuola: ",
                        "renderButtons": true
                    },
                    "plessoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Plesso: ",
                        "renderButtons": true
                    },
                    "tipologiaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Grado: ",
                        "renderButtons": true
                    },
                    "indirizzoScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Indirizzo: ",
                        "renderButtons": true
                    },
                    "comuneProvinciaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Comune: ",
                        "renderButtons": true
                    }
                },
                "view": "elencoScuoleSingoloAutocompleteSelect2-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Elenco Scuole Autocomplete e Info";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Scelta scuola principale di iscrizione con info relative e autocomplete in ricerca";
        }
    });
   
    Alpaca.registerView({
	  	"id": "elencoScuoleSingoloAutocompleteSelect2-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleSingoloAutocompleteSelect2Container,
			"container-object": elencoScuoleSingoloAutocompleteSelect2ContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleSingoloAutocompleteSelect2", Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect2); 
  
    
})(jQuery);