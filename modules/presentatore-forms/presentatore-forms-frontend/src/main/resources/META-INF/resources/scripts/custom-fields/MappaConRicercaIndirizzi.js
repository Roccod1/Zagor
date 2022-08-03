var mappaConRicercaIndirizziContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';


var mappaConRicercaIndirizziContainerObject = ' \
<script type="text/x-handlebars-template"> \
	<div id="defaultMapId" style="height: 500px; display: none;" class="marginright20 hideInPdf"></div> \
    <div data-disable-interaction-custom-field="true"> \
	<br> \
		<div class="row"> \
			<div class="col-md-4">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-10">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';

(function($) {

    var Alpaca = $.alpaca;
        
    Alpaca.Fields.MappaConRicercaIndirizzi = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.MappaConRicercaIndirizzi.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "mappaConRicercaIndirizzi";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
        	
            var mappaVar;
            var currentMarker;
            var listaMessaggi = [
            	" Caricamento...",
            	" Indirizzo trovato.",
            	" Si è verificato un errore. Riprovare.",
            	" Nessun indirizzo trovato.",
            	" Si è verificato un errore. Suggerimenti: Utilizzare la mappa per indicare la propria posizione o riprovare più tardi"
            ];
            var latLngComuneBari = [41.12552535,16.86715378741];
            var isMapOpened = false;
            
            this.base();

            this.schema = {
            		 "type": "object",
                     "properties": {
                    	 "apriMappaButton": {
             	            "type": "string",
             	            "required": false,
             	            "properties": {}
             	        },
                         "ricercaInput": {
                             "title": "Nome",
                             "type": "string",
                             "required": false,
                             "properties": {}
                         },
            	        "searchButton": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "indirizzoRegistrato": {
                            "title": "Nome",
                            "type": "string",
                            "required": true,
                            "properties": {}
                        },
            	        "latitudine": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "longitudine": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        }
                     }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
                "fields": {
                	"apriMappaButton": {
                    	"fieldClass": "hideInPdf",
                        "type": "label",
                        "label": "<div class='btn btn-primary padding10'><b>Apri Mappa</b></div>",
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
                        	"click": function() {
                        		
                        		if (isMapOpened) {
                        			$("div[id*='mapId']").hide();
                        			this.options.label = "<div class='btn btn-primary padding10'><b>Apri Mappa</b></div>";
                        		} else {
                        			$("div[id*='mapId']").show();
                        			this.options.label = "<div class='btn btn-primary padding10'><b>Chiudi Mappa</b></div>";
                        		}
                        		if (mappaVar) {
                        			mappaVar.invalidateSize();
                        		}
                        		isMapOpened = !isMapOpened;
                        		this.refresh();
                        	}
                        }
                	},
                    "ricercaInput": {
                    	"fieldClass": "hideInPdf",
                        "type": "text",
                        "disabled": false,
                        "showMessages": false,
                        "hideInitValidationError": true,
                        "focus": false,
                        "helpers": ["Cercare un indirizzo."],
                        "label": "Cerca un indirizzo:",
                        "renderButtons": true,
                        "events":{
                        	"ready": function() {
                        		console.log('in ready');
                        		var alpacaIndirizzoInput = this.parent.childrenByPropertyId["indirizzoRegistrato"];
                        		var latitudineHidden = this.parent.childrenByPropertyId["latitudine"]
                        		var longitudineHidden = this.parent.childrenByPropertyId["longitudine"]
                        		var self = this;
                        		console.log('mapVar', mappaVar);
                        		if (!mappaVar) {
                        			var newMapId = "mapId_" + this.id;
                        			$("#defaultMapId").attr("id", newMapId);
                        			mappaVar = L.map(newMapId).setView(latLngComuneBari, 13);
                        			
                            		var customAttrLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                                        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery© <a href="https://www.mapbox.com/">Mapbox</a>',
                                        maxZoom: 18
                                    }).addTo(mappaVar);
                            		
                                    currentMarker = new L.marker(latLngComuneBari, {draggable: true});
                                    
                                    currentMarker.addTo(mappaVar);
                                    
                                    
                                    currentMarker.on('dragend', function(e) {
                                    	
                                		var helperRicercaHtml = self.domEl.find(".help-block")[0];
                                		helperRicercaHtml.lastChild.data = listaMessaggi[0];

                                    	console.log(currentMarker.getLatLng(), e, "DRAGEND");
 
                                        $.ajax({
                                        	url: getAddressByCoordsUrl + "&lat=" + currentMarker.getLatLng().lat + "&lon=" + currentMarker.getLatLng().lng,
            		   	            	    cache: false,
            		   	            	    dataType: 'json',
	            		   	            	delay: 250,
	 					                    timeout: 20000,
            		   	            	    async: true,
            		   	            	    success: function(data){
            									console.log('success', data);
                                        		helperRicercaHtml.lastChild.data = listaMessaggi[1];
                                        		alpacaIndirizzoInput.getControlEl().val(data.display_name);
                                        		latitudineHidden.getControlEl().val(data.lat);
                                        		longitudineHidden.getControlEl().val(data.lon);

    		                        			self.getControlEl().val("");
            		   	            	    },
            		   	            	    error: function (exception) {
            		   	            	        console.log('ERRORE', exception);
                                        		helperRicercaHtml.lastChild.data = listaMessaggi[2];
                                        		alpacaIndirizzoInput.getControlEl().val("");
                                        		latitudineHidden.getControlEl().val("");
                                        		longitudineHidden.getControlEl().val("");
                                        		
    		                        			self.getControlEl().val("");
            		   	            	    },
            		   	            	    complete: function (){
            		   	            	    	console.log('complete');
            		   	            	    	alpacaIndirizzoInput.refreshValidationState();
            		   	            	    }
            		   	            	});
                                        
            		   	            });
                                    
                                    mappaVar.on('click', function(e) {
                                    	
                                    	if (!currentMarker) {
	                                    	currentMarker = new L.marker(e.latlng, {draggable: true});
	                                    	currentMarker.addTo(mappaVar);
                                    	} else {
                                    		currentMarker.setLatLng(e.latlng);
                                    	}
                                    	
                                    	var helperRicercaHtml = self.domEl.find(".help-block")[0];
                                		helperRicercaHtml.lastChild.data = listaMessaggi[0];

                                    	console.log(currentMarker.getLatLng(), e, "CLICK");
 
                                        $.ajax({
                                        	url: getAddressByCoordsUrl + "&lat=" + currentMarker.getLatLng().lat + "&lon=" + currentMarker.getLatLng().lng,
            		   	            	    cache: false,
            		   	            	    dataType: 'json',
	            		   	            	delay: 250,
	 					                    timeout: 20000,
            		   	            	    async: true,
            		   	            	    success: function(data){
            									console.log('success', data);
                                        		helperRicercaHtml.lastChild.data = listaMessaggi[1];
                                        		self.getControlEl().val("");
                                        		alpacaIndirizzoInput.getControlEl().val(data.display_name);
                                        		latitudineHidden.getControlEl().val(data.lat);
                                        		longitudineHidden.getControlEl().val(data.lon);
            		   	            	    },
            		   	            	    error: function (exception) {
            		   	            	        console.log('ERRORE', exception);
                                        		helperRicercaHtml.lastChild.data = listaMessaggi[2];
    		                        			self.getControlEl().val("");
                                        		alpacaIndirizzoInput.getControlEl().val("");
                                        		latitudineHidden.getControlEl().val("");
                                        		longitudineHidden.getControlEl().val("");

            		   	            	    },
            		   	            	    complete: function (){
            		   	            	    	console.log('complete');
            		   	            	    	alpacaIndirizzoInput.refreshValidationState();
            		   	            	    }
            		   	            	});
                        			});
                        		}	
                        	}
                        }
                    },
                    "searchButton": {
                    	"fieldClass": "hideInPdf",
                        "type": "label",
                        "label": " <div class='btn btn-primary padding10'><icon class='fa fa-search paddingright10'></icon><b> Cerca</b></div>",
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
                        		                        		
                        		var self = this;
                        		var alpacaRicercaInput = this.parent.childrenByPropertyId["ricercaInput"];
                        		var alpacaIndirizzoInput = this.parent.childrenByPropertyId["indirizzoRegistrato"];
                        		var latitudineHidden = this.parent.childrenByPropertyId["latitudine"]
                        		var longitudineHidden = this.parent.childrenByPropertyId["longitudine"]


                        		var helperRicercaHtml = alpacaRicercaInput.domEl.find(".help-block")[0];
                        		var currentValoreRicerca = alpacaRicercaInput.getValue();

                        		helperRicercaHtml.lastChild.data = listaMessaggi[0];
                        		
                        		var campoRicerca = self.domEl.closest("div.alpaca-field-object").find($("input[name*='ricercaInput']"));
                        		campoRicerca.attr("disabled", true);
                        		console.log("click domel", self.domEl);
                        		self.domEl.css("pointer-events","none");
                        		self.domEl.find("div.btn").attr("disabled", true);
                        		
                        		$.ajax({
                                	url: getCoordsByAddressUrl + currentValoreRicerca,
    		   	            	    cache: false,
    		   	            	    dataType: 'json',
        		   	            	delay: 250,
					                    timeout: 20000,
    		   	            	    async: true,
    		   	            	    success: function(data){
    		   	            	    	
    									console.log('success', data); 
    									
    									if (data.length == 0 || data == [] || data == undefined) {
    										console.log('chiamata success dati vuoti');
    										helperRicercaHtml.lastChild.data = listaMessaggi[3];
    										alpacaIndirizzoInput.getControlEl().val("");
    										latitudineHidden.getControlEl().val("");
                                    		longitudineHidden.getControlEl().val("");
    										
    										alpacaRicercaInput.getControlEl().val("");

    								        } else {
    								        		if (currentMarker) {
    								        			currentMarker.setLatLng([data[0].lat, data[0].lon]);
    								        		}
													mappaVar.setView([data[0].lat, data[0].lon], 15);
													alpacaRicercaInput.getControlEl().val("");
													alpacaIndirizzoInput.getControlEl().val(data[0].display_name);
													latitudineHidden.getControlEl().val(data.lat);
	                                        		longitudineHidden.getControlEl().val(data.lon);
	                                        		
													helperRicercaHtml.lastChild.data = listaMessaggi[1];

    								        
    								        }		

    		   	            	    },
    		   	            	    error: function (exception) {
    		   	            	    	
    		   	            	        console.log('ERRORE', exception);
    		   	            	        helperRicercaHtml.lastChild.data = listaMessaggi[4];
    		   	            	        alpacaRicercaInput.getControlEl().val("");
    		   	            	        alpacaIndirizzoInput.getControlEl().val("");
    		   	            	     latitudineHidden.getControlEl().val("");
                             		longitudineHidden.getControlEl().val("");
    		   	            	    },
    		   	            	    complete: function() {
    		   	            	    	
    	                        		campoRicerca.attr("disabled", false);
    	                        		self.domEl.find("div.btn").attr("disabled", false);
    	                        		self.domEl.css("pointer-events","auto");
    	                        		alpacaIndirizzoInput.refreshValidationState();
    		   	            	    	
    		   	            	    }
    		   	            	});
                        	}
                        }
                    },
                    "indirizzoRegistrato": {
                        "type": "text",
                        "disabled": true,
                        "showMessages": true,
                        "hideInitValidationError": true,
                        "focus": false,
                        "helpers": ["Indirizzo che sarà registrato."],
                        "label": "Indirizzo:",
                        "renderButtons": true
                    },
                	"latitudine": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "longitudine": {
                        "type": "hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    }
                },
                "view": "mappaConRicercaIndirizzi-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Mappa con ricerca indirizzo";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Mappa con marker interattivo e ricerca indirizzi interattiva";
        }
    });
   
    Alpaca.registerView({
	  	"id": "mappaConRicercaIndirizzi-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
            "notOptional": "Questo indirizzo è obbligatorio. Utilizzare mappa o ricerca per trovare un indirizzo valido."
        },
		"templates": {
			"container": mappaConRicercaIndirizziContainer,
			"container-object": mappaConRicercaIndirizziContainerObject
		}
    });
    Alpaca.registerFieldClass("mappaConRicercaIndirizzi", Alpaca.Fields.MappaConRicercaIndirizzi); 
  
    
})(jQuery);