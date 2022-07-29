var myViewContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var myViewContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		 <div class="row">\
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-4">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-4">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    
    Alpaca.Fields.DurataTemporale = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.DurataTemporale.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "durataTemporale";
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
					"label": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "dataInizio": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "dataFine": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "labelHelp": {
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                }
				}
	       	};
	       	
	       	Alpaca.merge(this.options, {
            	"validate": false,
    			"showMessages": true,
		    	"label": "",
		        "fields": {
					"label": {
	                    "label": "Periodo di svolgimento",
	                    "fieldClass": "paddingtop20 paddingleft20",
	                    "type": "text",
	                    "helpers": [],
	                    "order": 1,
	                    "disabled": true,
	                    "hidden": false,
	                    "validate": false,
	                    "attributes": {},
	                    "autocomplete": false,
	                    "showMessages": false,
	                    "renderButtons": true,
	                    "allowOptionalEmpty": true,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "view": "bootstrap-display",
	                    "fields": {}
	                },
	                "dataInizio": {
	                    "type": "date",
	                    "order": 2,
	                    "label": "Dal",
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
	                    "disabled": false,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
				            "blur": function(){
				                var anno = this.getValue();
				                anno = Number(anno.substring(6,10));
				                
				                if(anno.toString().length !== 4){
				                    this.setValue();
				                }
				            }
				        },
						"validator": function(callback){
							var dataFine = this.parent.childrenByPropertyId["dataFine"].getValue();
							var dataInizio = this.getValue();
															
							var ggInizio = dataInizio.substring(0,2);
							var mmInizio = dataInizio.substring(3,5);
							var aaaaInizio = dataInizio.substring(6,10);
																				
							var ggFine = dataFine.substring(0,2);
							var mmFine = dataFine.substring(3,5);
							var aaaaFine = dataFine.substring(6,10);
							
							
							var newDataInizio = new Date(mmInizio + '/' + ggInizio + '/' + aaaaInizio);
							var newDataFine = new Date(mmFine + '/' + ggFine + '/' + aaaaFine);
							
							if(Date.parse(newDataInizio) > Date.parse(newDataFine)){
								callback({
				                    "status": false,
				                    "message": "La data di fine deve essere successiva o uguale a quella d'inizio"
				                });
							} else {
				                callback({
				                    "status": true
				                });
				            }
						}
	                },
	                "dataFine": {
	                    "type": "date",
	                    "order": 3,
	                    "label": "Al",
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
	                    "disabled": false,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
				            "blur": function(){
				                var anno = this.getValue();
				                anno = Number(anno.substring(6,10));
				                
				                if(anno.toString().length !== 4){
				                    this.setValue();
				                }
				            }
				        },	                    
						"validator": function(callback){
							
							var dataInizio = this.parent.childrenByPropertyId["dataInizio"].getValue();
							var dataFine = this.getValue();
															
							var ggInizio = dataInizio.substring(0,2);
							var mmInizio = dataInizio.substring(3,5);
							var aaaaInizio = dataInizio.substring(6,10);
														
							var ggFine = dataFine.substring(0,2);
							var mmFine = dataFine.substring(3,5);
							var aaaaFine = dataFine.substring(6,10);
							
							
							var newDataInizio = new Date(mmInizio + '/' + ggInizio + '/' + aaaaInizio);
							var newDataFine = new Date(mmFine + '/' + ggFine + '/' + aaaaFine);
							
							if(Date.parse(newDataFine) < Date.parse(newDataInizio)){
								callback({
				                    "status": false,
				                    "message": "La data di fine deve essere successiva o uguale a quella d'inizio"
				                });
							} else {
				                callback({
				                    "status": true
				                });
				            }
						}
	                },
	                "labelHelp": {
	                    "label": "<span style='color: #737373;'><i class='glyphicon glyphicon-info-sign'></i> Inserire le date nel formato GG/MM/AAAA</span>",
	                    "fieldClass": "hideLabelInPdf",
	                    "type": "text",
	                    "helpers": [],
	                    "order": 4,
	                    "disabled": true,
	                    "hidden": false,
	                    "validate": false,
	                    "attributes": {},
	                    "autocomplete": false,
	                    "showMessages": false,
	                    "renderButtons": true,
	                    "allowOptionalEmpty": true,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "view": "bootstrap-display",
	                    "fields": {}
	                },
				},
	                "view": "durataTemporale-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Data di Inizio e Fine";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Check per verificare che la data di fine sia maggiore di quella d'inizio";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "durataTemporale-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio"
	    },
		"templates": {
			"container": myViewContainer,
			"container-object": myViewContainerObject
		}
    });
    Alpaca.registerFieldClass("durataTemporale", Alpaca.Fields.DurataTemporale); 
  
    
})(jQuery);