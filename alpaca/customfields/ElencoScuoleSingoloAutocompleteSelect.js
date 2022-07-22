var elencoScuoleSingoloAutocompleteSelectContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var elencoScuoleSingoloAutocompleteSelectContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
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
		<div class="row"> \
			<div class="col-md-12">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "elencoScuoleSingoloAutocompleteSelect";
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
	                    "nomeScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "plessoScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "indirizzoScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "tipologiaScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "comuneProvinciaScuola": [
	                        "scuolaPrincipale"
	                    ],
	                    "bacinoAppartenenzaScuola": [
	                        "scuolaPrincipale"
	                    ]
            	    },
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
                        },
                        "bacinoAppartenenzaScuola": {
                            "title": "Bacino Appartenenza Scuola",
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
                    	"fieldClass": "select2ac1",
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
                        		
                        		this.getControlEl().select2({
					                  theme: "classic",
					                  language: "it",
					                  minimumInputLength: 3,
					                  width: "100%",
					                  ajax: {
					                    url: listaScuoleByComuneUrl,
					                    dataType: 'json',
					                    delay: 250,
					                    timeout: 3000,
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
				                    	var campoBacinoScuola = self.parent.childrenByPropertyId['bacinoAppartenenzaScuola'];
				                    	campoBacinoScuola.getControlEl().val(data.nomeComuneProv);
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
                    },
                    "bacinoAppartenenzaScuola": {
                        "type": "text",
                        "disabled": true,
                        "label": "Bacino di appartenenza: ",
                        "renderButtons": true
                    }
                },
                "view": "elencoScuoleSingoloAutocompleteSelect-view"
            	
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
	  	"id": "elencoScuoleSingoloAutocompleteSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio",
	        "invalidValueOfEnum": "Selezionare una delle opzioni.",
	        "disallowValue": "Attenzione: bisogna confermare per proseguire."
	
	    },
		"templates": {
			"container": elencoScuoleSingoloAutocompleteSelectContainer,
			"container-object": elencoScuoleSingoloAutocompleteSelectContainerObject
		}
    });
    Alpaca.registerFieldClass("elencoScuoleSingoloAutocompleteSelect", Alpaca.Fields.ElencoScuoleSingoloAutocompleteSelect); 
  
    
})(jQuery);