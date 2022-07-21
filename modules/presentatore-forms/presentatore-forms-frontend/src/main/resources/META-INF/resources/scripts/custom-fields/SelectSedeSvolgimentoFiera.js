var sedeSvolgimentoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var sedeSvolgimentoContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		    <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.SelectSedeSvolgimento = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.SelectSedeSvolgimento.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "selectSedeSvolgimento";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
				"dependencies":{
					"altroEvento": "selectEvento"
				},
				"type": "object",
				"properties": {
					"selectEvento": {
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
		        "fields": {
					"selectEvento":{						
						"label": "Selezionare la sede di svolgimento dell'evento'",
						"type": "select",
						"hideInitValidationError": true,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": false,
                        "noneLabel": "-- Seleziona --",
                        "hideNone": false,
                        "fields": {},
						"dataSource": function(callback) {

							var sedi = [];

							/*ALTRIMENTI IL BUILDER S'INCAZZA */
							if(listaSediFiereUrl){						
										
								$.ajax({
									url: listaSediFiereUrl,
									dataType: 'json',
									timeout: 20000,
									error: function (error) {
										console.log("error", error);
										callback(sedi);
									}, 
									success: function(data){
																			
										for( var i = 0; i < data.length; i++){
										/*	var denominazione = '';
											if(data[i].luogo){
												denominazione = data[i].denominazione + ' - ' + data[i].luogo;
											}else{
												denominazione = data[i].denominazione;
											}
											sedi.push({"value": data[i].idEvento, "text": denominazione});*/
										}
										sedi.push({"value": "0", "text": "Nuovo Evento"});
										callback(sedi);
									},
								});
							}else{
								console.log("NO URL");
								callback(sedi);
							}
						}
					}
				},
	                "view": "selectSedeSvolgimento-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Select Per Sede Svolgimento Evento";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Select Per Sede Svolgimento Evento";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "selectSedeSvolgimento-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": sedeSvolgimentoContainer,
			"container-object": sedeSvolgimentoContainerObject
		}
    });
    Alpaca.registerFieldClass("selectSedeSvolgimento", Alpaca.Fields.SelectSedeSvolgimento); 
  
    
})(jQuery);