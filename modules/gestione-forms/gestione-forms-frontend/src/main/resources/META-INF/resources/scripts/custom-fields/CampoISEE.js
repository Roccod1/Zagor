var campoISEEContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var campoISEEContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-1">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';



(function($) {

	
    var Alpaca = $.alpaca;
    
    var importoIseeConfronto = 0;
    
    var iseeValueFromINPS = null;
    var iseeXmlFromINPS = null;
    
    var removeIseeFromINPS = function (campoImporto) {
		campoImporto.parent.childrenByPropertyId['dataIseeINPSHidden'].setValue("");
		campoImporto.parent.childrenByPropertyId['xmlIseeINPSHidden'].setValue("");
		campoImporto.setValue("");
		campoImporto.getControlEl().attr("disabled", false);
		campoImporto.domEl.find(".help-block")[0].innerHTML ="<i class='glyphicon glyphicon-info-sign'></i>&nbsp;Inserire l\'importo nella forma: 12123,01";
		if ($("div.isee").find("input").length > 0) {
   	 		$("div.isee").find("input")[0].checked = true;
		}

    }
    
    var getIseeFromINPS = function (campoImporto) {
    
    // var isIseeCallDisabled = typeof forceEnableIseeCall === "undefined" && !("RSSMRA70A01H501S" === cfLoggedUser);	
    	
    // inpsIseeUrl += "&annoIsee=" + (new Date().getFullYear() - 1);
    console.log("inps isee url is: ", inpsIseeUrl);
    
    	campoImporto.getControlEl().val("Caricamento...");
    	campoImporto.getControlEl().attr("disabled", true);
    	$.ajax({
    		  url: inpsIseeUrl,
    		  beforeSend: function(request) {
                  request.setRequestHeader("User-Token", userToken);
              }
    		})
    		.success(function(data) {
	    		console.log("success", data);
	    		campoImporto.getControlEl().val("");
	        	campoImporto.getControlEl().attr("disabled", false);
	        	
	    		campoImporto.parent.childrenByPropertyId['dataIseeINPSHidden'].setValue(data.iseeExpirationDate);
	    		campoImporto.parent.childrenByPropertyId['xmlIseeINPSHidden'].setValue(data.iseeXmlCert);
	    		
	    		console.log("data.iseeMinore e data.iseeValue (ordinario) sono: ", data.iseeMinore, data.iseeValue, " ...viene preso il primo se not null, altrimenti il secondo.");
	    		campoImporto.setValue(data.iseeMinore ? data.iseeMinore : data.iseeValue);
	    		campoImporto.domEl.find(".help-block")[0].innerHTML = "<img src='"+ logoInpsInnerUrl +"' style='height: 30px; margin:5px;'/> <span style='color:#0e84b7'> Dato caricato con successo dal sistema INPS!</span>";
	    		campoImporto.getControlEl().attr("disabled", true);
	    		
	    		if ($("div.isee").find("input").length > 0) {
	       	 		$("div.isee").find("input")[0].checked = false;
	    		}
	    		campoImporto.parent.childrenByPropertyId['removeButton'].options.hidden = false;
	    		campoImporto.parent.childrenByPropertyId['removeButton'].refresh();
    		})
    		.error(function(error) {
    			campoImporto.getControlEl().val("");
	        	campoImporto.getControlEl().attr("disabled", false);
    			console.log("error retrieving ISEE from remote. User allowed to manually insert value.", error);
    			if (error.status === 422) {
    	    		campoImporto.domEl.find(".help-block")[0].innerHTML = "<i class='glyphicon glyphicon-info-sign'></i>&nbsp;Nessun dato trovato da INPS.<br>Inserire l'importo nella forma: 12123,01</span>";
    			} else {
    	    		campoImporto.domEl.find(".help-block")[0].innerHTML = "<i class='glyphicon glyphicon-info-sign'></i>&nbsp;Errore di sistema INPS.<br>Inserire l'importo nella forma: 12123,01</span>";
    			}
    		});
    	
    }    
    
    Alpaca.Fields.CampoISEE = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CampoISEE.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "campoISEE";
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
                         "importoIsee": {
                             "type": "string",
                             "required": true,
                             "properties": {},
                             "pattern": "^(?!0+$)(\\d)*(\\,[0-9]{2})$"

                         },
                         "removeButton": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
                        "dataIseeINPSHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
                         "xmlIseeINPSHidden": {
                             "type": "string",
                             "required": false,
                             "properties": {}
                         }
                     }
                     
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                    "importoIsee": {
                        "label": "ISEE (in \u20AC)",
                        "type": "text",
                        "helpers": ["Inserire l'importo nella forma: 12123,01"],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "numericEntry": true,
                        "fields": {},
                        "events": {
                        	"ready": function(){
                                var campoImporto = this;
                                
                        		$.ajax({
				                    url: sogliaIseeUrl,
				                    dataType: 'text',
				                    delay: 250,
				                    success: function (data) {
				                    	importoIseeConfronto = parseFloat(data);
				                    	console.log("float soglia ", importoIseeConfronto);
				                    	var isCurrentIseeFromInps = !!campoImporto.parent.childrenByPropertyId['xmlIseeINPSHidden'].getValue();
				                    	if (!isCaricaBozza || isCurrentIseeFromInps) {
				                    		getIseeFromINPS(campoImporto);
				                    	}
				                    },
				                    error: function() {

		                                    campoImporto.options.helpers = ["Si è verificato un problema - IMPOSSIBILE PROSEGUIRE"];  	
		                                 	campoImporto.getControlEl().val('Si è verificato un problema - IMPOSSIBILE PROSEGUIRE');
		                                 	campoImporto.getControlEl().attr("disabled", true);
				                    }
																	
	                            });
                        		
                        	},
                            "change": function() {
                            	
                                var campoImporto = this;
                                var importoString = this.getValue().replace(".","").replace(",",".")
                                var importo = parseFloat(importoString);
								
                                var checkAllegato = $("div.isee").find("input");
                                 if (checkAllegato.length == 0) {
                                    campoImporto.options.disabled = true;
                                    campoImporto.options.helpers = ["Si è verificato un problema con gli allegati - IMPOSSIBILE PROSEGUIRE"];
                                 	campoImporto.refresh();
                                 	campoImporto.getControlEl().val('Problema con gli allegati - IMPOSSIBILE PROSEGUIRE');

                                 } else {
                                
		                             if(importo < importoIseeConfronto){
		                            	 checkAllegato[0].checked = true;
		                             } else {
		                            	 checkAllegato[0].checked = false;
		                             }
                                 }
                             }
                         }
                    },
                    "removeButton": {
                    	"fieldClass": "hideInPdf",
                        "type": "label",
                        "hidden": true,
                        "label": " <div class='btn btn-primary padding5 margintop20'><icon class='fa fa-remove fa-2x' title='cancella valore'></icon></div>",
                        "helpers": [],
                        "validate": false,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {},
                        "events": {
                        	"click": function (){
                        		var campoImporto = this.parent.childrenByPropertyId['importoIsee'];
                        		var isConfirmed = confirm("Sei sicuro di voler cancellare il valore indicato da INPS? Verrà richiesto di inserire manualmente il valore");
                        		if (isConfirmed) {
                        			removeIseeFromINPS(campoImporto);
                        			this.domEl.css("pointer-events","none");
                            		this.domEl.find("div.btn").attr("disabled", true);
                        		}
                        	}
                        }
                    },
                    "dataIseeINPSHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    },
                    "xmlIseeINPSHidden": {
                        "type": "hidden",
                        "label": "New hidden",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "fields": {}
                    }
                
                },
                "view": "campoISEE-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Campo ISEE";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Campo di inserimento ISEE che rende allegato obbligatorio per importi minori della soglia";
        }
    });
   
    Alpaca.registerView({
	  	"id": "campoISEE-view",
	  	"parent": "bootstrap-create",
	    "messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidPattern": "Formato importo NON valido."
	    },
		"templates": {
			"container": campoISEEContainer,
			"container-object": campoISEEContainerObject
		}
    });
    Alpaca.registerFieldClass("campoISEE", Alpaca.Fields.CampoISEE); 
  
    
})(jQuery);