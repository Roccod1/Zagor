var datiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var datiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row">\
			<div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<!-- decommentare nel caso serva nuovamente il check delegato per ente pubblico\
		<div class="row">\
			<div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		-->\
    </div>\
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.EntePubblicoSelect = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.EntePubblicoSelect.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "entePubblicoSelect";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
			this.base();

            this.schema = {
        		"type": "object",
                "properties": {/*
					"isDelegato": {
			            "readonly": false,
			            "type": "boolean",
			            "required": false,
			            "properties": {}
			        },*/
					"selectEnte": {
						"type": "string",
						"required": true,
						"properties": {}
					}
				}
            };
            
            Alpaca.merge(this.options, {
            	"validate": false,
    			"showMessages": false,
            	"label": "",
            	"fieldClass": "entePubblicoClass",
                "fields": {/*
					"isDelegato": {
			            "type": "checkbox",
			            "validate": false,
			            "showMessages": false,
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
			            "fields": {}
			        },*/
					"selectEnte":{
						"label": "Seleziona un Ente dall'elenco",
						"type": "select",
						"fieldClass" : "select2ac1 notSelect2",
						"hideInitValidationError": true,
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
						"dataSource": function(callback) {

							var enti = [];

							/*ALTRIMENTI IL BUILDER S'INCAZZA */
							if(getOrganizzatoriFieraUrl){							
								
								$.ajax({
									url: getOrganizzatoriFieraUrl + "?tipologia=pubblica_amministrazione",
									dataType: 'json',
									timeout: 20000,
									error: function (error) {
										console.log("error", error);
										callback([]);
									}, 
									success: function(data){
																	
										for( var i = 0; i < data.length; i++){
											enti.push({"value": data[i].idSoggetto, "text": data[i].denominazione});
										}
										
										callback(enti);
									},
								});
							}else{
								console.log("NO URL");
								callback(enti);
							}
						}
					}
				},
				"view": "entePubblicoSelect-view"
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Select Ente Pubblico Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Select per gli enti pubblici che partecipano alle fiere";
        }
    });
   
    Alpaca.registerView({
	  	"id": "entePubblicoSelect-view",
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
			"container": datiContainer,
			"container-object": datiContainerObject
		}
    });
    Alpaca.registerFieldClass("entePubblicoSelect", Alpaca.Fields.EntePubblicoSelect); 
    
})(jQuery);