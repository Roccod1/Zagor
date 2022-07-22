var qualificaContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var qualificaContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		    <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.QualificaFiera = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.QualificaFiera.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "qualificaFiera";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
				"type": "object",
				"properties": {
					"qualificaRadioBtn": {
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
					"qualificaRadioBtn":{						
						"type": "radio",
			            "label": "Tipo di qualifica richiesta",
			            "validate": true,
			            "showMessages": true,
			            "disabled": false,
			            "hidden": false,
			            "helpers": [],
			            "vertical": false,
			            "hideInitValidationError": true,
			            "focus": false,
			            "useDataSourceAsEnum": false,
			            "sort": false,
			            "readonly": false,
			            "renderButtons": true,
			            "emptySelectFirst": false,
			            "noneLabel": "None",
			            "hideNone": true,
			            "fields": {},
			            "dataSource": function(callback){
				
							var radioEnum = [];
							
							$.ajax({
								url: getQualificheUrl,
								dataType: 'json',
								timeout: 20000,
								error: function (error) {
									console.log("error", error);
									callback([]);
								}, 
								success: function(data){
									
									for(var i= 0; i < data.length; i++){
										radioEnum.push({'text': data[i].descrizione, 'value': data[i].idTipologia});
									}
																	
									callback(radioEnum);
									
								}
							});
						}
					}
				},
	                "view": "qualificaFiera-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Qualifica Evento";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Qualifica Evento";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "qualificaFiera-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": qualificaContainer,
			"container-object": qualificaContainerObject
		}
    });
    Alpaca.registerFieldClass("qualificaFiera", Alpaca.Fields.QualificaFiera); 
  
    
})(jQuery);