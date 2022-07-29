var responsabileMinoreInQualitaDiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var responsabileMinoreInQualitaDiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    
    Alpaca.Fields.ResponsabileMinoreInQualitaDiSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.ResponsabileMinoreInQualitaDiSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "responsabileMinoreInQualitaDiSelect";
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
             			"specificareAltroText": ["sceltaQualitaDi"]
                     },
                     "properties": {
                         "sceltaQualitaDi": {
                             "required": true,
                             "enum": ["Genitore", "Tutore", "Affidatario", "Altro"],
                             "properties": {}
                         },
                         "specificareAltroText": {
                             "title": "Nome",
                             "type": "string",
                             "required": true,
                             "properties": {}
                         }
                     }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "sceltaQualitaDi": {
                        "label": "Ruolo ",
                        "type": "select",
                        "validate": true,
                        "sort": false,
                        "disabled": false,
                        "helpers": ["Per scelte diverse da 'Genitore' sarà obbligatorio allegare certificazione"],
                        "showMessages": true,
                        "removeDefaultNone": false,
                        "hideInitValidationError": true,
                        "useDataSourceAsEnum": true,
                        "renderButtons": true,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "hideNone": false,
                        "noneLabel": "--Seleziona Ruolo--",
                        "fields": {},
                        "events": {
                            "change": function() {
                                console.log("in change");
                                
                                var campoQualitaDi = this;
                                var tipoQualita = this.getValue();
								
                                var checkAllegato = $("div.cqt").find("input");
                                 if (checkAllegato.length == 0) {
                                	 campoQualitaDi.options.disabled = true;
                                	 campoQualitaDi.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                	 campoQualitaDi.refresh();
                                	 campoQualitaDi.getControlEl().val('');

                                 } else {
                                
		                             if(tipoQualita !== "Genitore"){
		                            	 checkAllegato[0].checked = true;
		                             } else {
		                            	 checkAllegato[0].checked = false;
		                             }
                                 }
                             }
                         }
                    },
                    "specificareAltroText": {
                        "type": "text",
                        "disabled": false,
                        "label": "",
                        "renderButtons": true,
                        "dependencies": {
                            "sceltaQualitaDi": ["Altro"]
                        }
                    }
                },
                "view": "responsabileMinoreInQualitaDiSelect-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Select scelta responsabile minore in qualità di";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Select di scelta del titolo in qualità del quale si effettua richiesta per un minore, rende obbligatorio il relativo allegato";
        }
    });
   
    Alpaca.registerView({
	  	"id": "responsabileMinoreInQualitaDiSelect-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Selezionare una delle opzioni."
	    },
		"templates": {
			"container": responsabileMinoreInQualitaDiContainer,
			"container-object": responsabileMinoreInQualitaDiContainerObject
		}
    });
    Alpaca.registerFieldClass("responsabileMinoreInQualitaDiSelect", Alpaca.Fields.ResponsabileMinoreInQualitaDiSelect); 
  
    
})(jQuery);