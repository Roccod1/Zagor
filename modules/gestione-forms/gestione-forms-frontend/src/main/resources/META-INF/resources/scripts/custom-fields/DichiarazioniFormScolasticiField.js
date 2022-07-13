var dichiarazioniFormScolasticiContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var dichiarazioniFormScolasticiContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true" style="margin-bottom: -30px !important"> \
		<div class="row"> \
			<div class="col-md-1" style="margin-top: -5px">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-11">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
	</div> \
    </div> \
</script>';

var datiDichiarazioni = {};

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.DichiarazioniFormScolasticiField = Alpaca.Fields.ArrayField.extend(
    /**
     * @lends Alpaca.Fields.DichiarazioniFormScolasticiField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "dichiarazioniFormScolastici";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function() {
            this.base();

            this.schema = {
            	"items": {
    	            "title": "",
    	            "type": "object",
    	            "properties": {

    	                    	"checkDichiarazione": {
    	                            "type": "boolean",
    	                            "required": false,
    	                            "properties": {}
    	                        },
    	    	                "testoDichiarazione": {
    	    	                    "type": "string",
    	    	                    "required": false,
    	    	                    "properties": {}
    	    	                },
    	                         "hiddenIdDichiarazione": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         },
    	                         "hiddenAnnoScolastico": {
    	                             "type": "string",
    	                             "required": false,
    	                             "properties": {}
    	                         }
    	            }
    	        }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"items": {
            		"fieldClass": "noBorderContainers",
	                "fields": {

			                   	 "checkDichiarazione": {
			                         "type": "checkbox",
			                         "fields": {},
			                         "helpers": [],
			                         "multiple": false,
			                         "data": false,
			                         "disabled": false,
			                         "validate": true,
			                         "showMessages": true,
			                         "renderButtons": true,

	    	                         "events": {
	    	                             "ready": function(){
											 this.getControlEl().find("input")[0].id = "dichiarazioneCheckabile";  	                             	 					
	    	                             },
	    	                             "change": function(){
	    	                            	 var currentText = this.parent.childrenByPropertyId['testoDichiarazione']; 
	    	                            	 currentText.refreshValidationState();
	    	                             }
	    	                         }
			                     },
	    	                     "testoDichiarazione": {
	    	                         "type": "text",
	    	                         "validate": true,
	    	                         "showMessages": true,
	    	                         "disabled": false,
	    	                         "hidden": false,
	    	                         "helpers": ["Scelta Obbligatoria."],
	    	                         "hideInitValidationError": false,
	    	                         "focus": false,
	    	                         "optionLabels": [],
	    	                         "typeahead": {},
	    	                         "allowOptionalEmpty": true,
	    	                         "data": {},
	    	                         "autocomplete": "false",
	    	                         "disallowEmptySpaces": false,
	    	                         "disallowOnlyEmptySpaces": false,
	    	                         "fields": {},
	    	                         "view": "bootstrap-display",
			                         "validator": function(callback) {
										var currentCheck = this.parent.childrenByPropertyId['checkDichiarazione'];
										var currentValue = currentCheck.getValue();
    	                             	 var currentLastId = currentCheck.getControlEl().find("input")[0].id;
			                             var valueObb = datiDichiarazioni[currentLastId];
			                             if (valueObb && !currentValue) {
			                            	 this.domEl.find(".help-block").hide();
			                                 callback({
			                                     "status": false,
			                                     "message": "Scelta Obbligatoria."
			                                 });
			                             } else {
			                                 callback({
			                                     "status": true
			                                 });
			                             }
			                         }

	    	                     },
	    	                     "hiddenIdDichiarazione": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     },
	    	                     "hiddenAnnoScolastico": {
	    	                         "type": "hidden",
	    	                         "label": "New hidden",
	    	                         "helpers": [],
	    	                         "fieldClass": "annoScolasticoDichiarazioneCss",
	    	                         "validate": true,
	    	                         "disabled": false,
	    	                         "showMessages": true,
	    	                         "renderButtons": true,
	    	                         "fields": {}
	    	                     }
	                }

            	},
                "hidden": false,
                "animate": true,
                "helpers": [],
                "toolbar": {
                    "actions": [
                        {
                            "action": "add",
                            "enabled": false
                        }
                    ]
                },
                "disabled": false,
                "validate": true,
                "collapsed": false,
                "rubyrails": false,
                "collapsible": false,
                "hideToolbar": true,
                "lazyLoading": false,
                "legendStyle": "button",
                "optionLabels": [],
                "showMessages": true,
                "toolbarStyle": "button",
                "hideActionbar": true,
                "toolbarSticky": false,
                "actionbarStyle": "top",
                "hideInitValidationError": false,
                "hideToolbarWithChildren": true,
            	"view": "dichiarazioniformscolastici-view",
            	"events": {
                    "ready": function(){
                        var currentDichiarazioni = $("input[id='dichiarazioneCheckabile']");
                        var count = 0;
                        var annoScolasticoDichiarazioni = $($('.annoScolasticoDichiarazioneCss')[0]).alpaca("get").data;
    					$.ajax({
		                    url: listaDichiarazioniFormScolasticiUrl+ '&annoScolastico=' + annoScolasticoDichiarazioni,
		                    dataType: 'json',
		                    delay: 250,
		                    success: function (data) {
		                        currentDichiarazioni.each(
                                    function(element) {
                                        var idCurrentDichiarazione = "dichiarazioneCheckabile" + data[count].id;
                                 	    this.id = idCurrentDichiarazione;
                                 	    datiDichiarazioni[idCurrentDichiarazione] = data[count].obbligatorio;
                                 	    //add helper
                                 	    if (!datiDichiarazioni[idCurrentDichiarazione]) {
                                 	    $(this.closest(".row")).find(".help-block").hide();
                                 	    }
                                 	    count++;
                                    });

                                }
	                   });                        
                        
                        
                    }
            	}
            });
            
        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Dichiarazioni form scolastici";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Dichiarazioni form scolastici per elenco moduli";
        }
    });

    Alpaca.registerView({
    	"id": "dichiarazioniformscolastici-view",
    	"parent": "bootstrap-create",
    	 "messages": {
    	        "notOptional": " ",
    	        "disallowValue": " "

    	 },
    	"templates": {
    		"container": dichiarazioniFormScolasticiContainer,
    		"container-object": dichiarazioniFormScolasticiContainerObject
    	}
    });
    Alpaca.registerFieldClass("dichiarazioniFormScolastici", Alpaca.Fields.DichiarazioniFormScolasticiField);
    
})(jQuery);