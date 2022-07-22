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
		  <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		 </div>\
		<div class="row">\
		  <div class="col-md-12 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.EnteFiera = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.EnteFiera.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "enteFiera";
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
			        "enteLabel": {
			            "type": "string",
			            "required": false,
			            "properties": {}
			        },
			        "ente": {
			            "required": true,
			            "enum": [
			                "pubblico",
			                "privato"
			            ],
			            "properties": {}
			        }
				}
	       	};
	       	
	       	Alpaca.merge(this.options, {
            	"validate": false,
    			"showMessages": false,
		    	"label": "",
		        "fields": {
					"enteLabel": {
			            "label": "Selezionare la tipologia di soggetto organizzatore",
		            	"validate": false,
		    			"showMessages": false,
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": true,
			            "hidden": false,
			            "attributes": {},
			            "autocomplete": false,
			            "renderButtons": true,
			            "allowOptionalEmpty": true,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "view": "bootstrap-display",
			            "fields": {}
			        },
			        "ente": {
			            "type": "radio",
			            "fieldClass": "text-center enteRadioClass",
			            "vertical": false,
			            "hideNone": true,
			            "validate": true,
			            "showMessages": true,
			            "disabled": false,
			            "hidden": false,
			            "helpers": [],
			            "hideInitValidationError": true,
			            "focus": false,
			            "useDataSourceAsEnum": false,
			            "sort": false,
			            "readonly": false,
			            "renderButtons": true,
			            "optionLabels": [
			                "Pubblico",
			                "Privato"
			            ],
			            "emptySelectFirst": false,
			            "noneLabel": "None",
			            "fields": {},
			            "events":{
							"click": function(){
								if(this.getValue()){
									this.parent.parent.childrenByPropertyId["enteDependenciesHandler"].setValue(this.getValue());
									this.parent.parent.childrenByPropertyId["enteDependenciesHandler"].getControlEl().change();
									
									if(this.getValue().toUpperCase() === "PRIVATO"){
										$(".entePrivatoClass").show();
										$(".entePubblicoClass").hide();
									}else{
										$(".entePubblicoClass").show();
										$(".entePrivatoClass").hide();
									}
									/*Allegato delega obbligatorio*/
									var checkAllegato = $("div.dlg").find("input");
									
									var checkAllegato = $("div.dlg").find("input");
									if (checkAllegato.length == 0) {
	                                	this.options.disabled = true;
	                                	this.setValue(null);
	                                	this.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
	                                	this.refresh();
	                                	this.getControlEl().val('');
	                             	}else{
		
										 if(this.getValue().toUpperCase() === "PUBBLICO"){
		                            	 	checkAllegato[0].checked = true;
			                             } else {
			                            	 checkAllegato[0].checked = false;
			                             }
									}
								}
							}
						}
			        }
				},
	                "view": "enteFiera-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Tipo Ente per fiere";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Tipo Ente Radio Button per fiere";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "enteFiera-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": myViewContainer,
			"container-object": myViewContainerObject
		}
    });
    Alpaca.registerFieldClass("enteFiera", Alpaca.Fields.EnteFiera); 
  
    
})(jQuery);