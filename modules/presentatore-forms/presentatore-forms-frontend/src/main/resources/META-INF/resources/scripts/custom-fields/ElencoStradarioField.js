var elencoStradarioFieldContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="150"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var elencoStradarioFieldContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div class="row"> \
			<div class="col-md-10">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-2">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
		<div class="row"> \
			<div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div> \
			<div class="col-md-6">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div> \
		</div> \
    </div> \
</script>';
(function($) {

    var Alpaca = $.alpaca;
	
    var civiciPerIndirizzo = {};
    
    Alpaca.Fields.ElencoStradarioField = Alpaca.Fields.ObjectField.extend(
    /**
     * @lends Alpaca.Fields.ElencoStradarioField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.ObjectField#getFieldType
         */
        getFieldType: function() {
            return "elencoStradario";
        },

        /**
         * @private
         * @see Alpaca.Fields.ObjectField#setup
         */
        setup: function()
        {
            this.base();

            this.schema = {
            	    "title": "",
            	    "description": "",
            	    "type": "object",
            	    "required": false,
            	    "properties": {
            	        "searchStradario": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "searchButton": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectStradario": {
            	            "required": false,
            	            "properties": {}
            	        },
            	        "selectCivici": {
            	            "required": false,
            	            "properties": {}
            	        },
            	        "civico": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        },
            	        "esponente": {
            	            "type": "string",
            	            "required": false,
            	            "properties": {}
            	        }
            	    }

            	};
            
            Alpaca.merge(this.options, {
                "focus": false,
                "type": "object",
                "helpers": [],
                "helpersPosition": "below",
                "validate": true,
                "disabled": false,
                "showMessages": true,
                "showButtons": true,
                "collapsible": false,
                "legendStyle": "button",
                "label": "",
                "fields": {
                    "searchStradario": {
                        "type": "search",
                        "fieldClass": "paddingtop5 paddingright20",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "data": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {}
                    },
                    "searchButton": {
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
                        		self.domEl.css("pointer-events","none");
                        		self.domEl.find("div.btn").attr("disabled", true);
                        		var alpacaStradario = this.parent.childrenByPropertyId["searchStradario"];
                        		var currentVal = alpacaStradario.getValue();
                        		for (var curr in civiciPerIndirizzo) delete civiciPerIndirizzo[curr];
                        		alpacaStradario.options.helpers = ["Caricamento in corso..."];
                        		alpacaStradario.refresh();
                        		alpacaStradario.getControlEl().val(currentVal);
                        		var newData = [];
                        		$("select[name*='selectStradario']").empty();
                        		                 
                        		$.ajax({
		                            url: listaStradarioUrl+"&indirizzo=" + currentVal,
		                            dataType: 'json',
		                            delay: 250,
		                            timeout: 10000,
		                            error: function () {
		                        		self.domEl.css("pointer-events","auto");
		                        		self.domEl.find("div.btn").attr("disabled", false);
		                            	alpacaStradario.options.helpers =["Errore nel caricamento dei dati. Riprovare."];
		                        		alpacaStradario.refresh();
		                        		
		                            },
		                            success: function (data) {
		                            	
		                            	//for (var currEl in civiciPerIndirizzo) delete civiciPerIndirizzo[currEl];
		                        		data.forEach( function (element) {
		                        			newData.push({"id": element.identificativo, "text": element.denominazione + " - " + element.localita});
		                        			civiciPerIndirizzo[element.identificativo] = element.civici;
		                        		});  
		                        		
		                        		$("select[name*='selectStradario']").select2({
		                        			data: newData
		                        		});
		                        		
		                        		/*$("select[name*='selectStradario']").trigger("change");*/
		                        		var $search = $("select[name*='selectStradario']").data('select2').dropdown.$search;
		                        		$search.val(currentVal);
		                        		$search.trigger('keyup');

		                        		$("select[name*='selectStradario']").select2({
		                        		minimumResultsForSearch: -1 
		                        		});

		                        		$("select[name*='selectStradario']").select2("open");
		                        		$("select[name*='selectStradario']").val(null);
		                        		
		                        		self.domEl.css("pointer-events","auto");
		                        		self.domEl.find("div.btn").attr("disabled", false);
		                        		alpacaStradario.options.helpers = [];
		                        		alpacaStradario.refresh();
		                            }
                            
                        		});

                        	}
                        }
                    },
                    "selectStradario": {
                        "fieldClass": "select2ac1",
                        "type": "select",
                        "label": "Vie:",
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
                        "showMessages": true,
                        "renderButtons": true,
                        "useDataSourceAsEnum": false,
                        "multiselect": {
                            "disableIfEmpty": true
                        },
                        "noneLabel": "None",
                        "hideNone": true,
                        "fields": {},
                        "events":{
                        	"change": function(){
                    			    var civiciDisponibili = [{"value": "-1", "text": "-- Inserimento Manuale --"}];
                        			civiciPerIndirizzo[this.getValue()].forEach( function(element) {
                        			var numeroEsponente = element.numero;
                        			if (element.esponente !== null && element.esponente !== undefined) {
                        				numeroEsponente = numeroEsponente + " " + element.esponente;
                        			}
                        			    civiciDisponibili.push({"value": element.identificativo, "text": numeroEsponente});
                        			});

                        			var campoAlpacaCivici = $("select[name*='selectCivici']").alpaca("get");
                        			campoAlpacaCivici.options.dataSource = civiciDisponibili;

                        			campoAlpacaCivici.refresh();
                        			
                        	}
                        }
                    },
                    "selectCivici": {
                        "type": "select",
                        "label": "Civici:",
                        "helpers": [],
                        "hideInitValidationError": true,
                        "emptySelectFirst": true,
                        "validate": false,
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
                        	"change": function (){
                        		var campoCivico = this.parent.childrenByPropertyId["civico"];
                        		var campoEsponente = this.parent.childrenByPropertyId["esponente"];
                        		 if (this.getValue() == "-1") {
	                        		campoCivico.options.hidden = false;
	                        		campoEsponente.options.hidden = false;
                        		} else {
	                        		campoCivico.options.hidden = true;
	                        		campoEsponente.options.hidden = true;
                        		}
                        		 campoCivico.refresh();
	                        	 campoEsponente.refresh();
                        	}
                        } 
                        
                    },
                    "civico": {
                        "type": "text",
                        "label": "Civico:",
                        "hidden": true,
                        "helpers": [],
                        "validate": true,
                        "disabled": false,
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
                    "esponente": {
                        "type": "text",
                        "label": "Esponente:",
                        "hidden": true,
                        "helpers": [],
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
                        "fields": {}     
                    }
                },
                "view": "elencostradario-view"              
            });
        },
        
         /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {
        	console.log('After render control', model, callback);

        },

        /**
         * @see Alpaca.Fields.ObjectField#getTitle
         */
        getTitle: function() {
            return "Elenco Stradario";
        },

        /**
         * @see Alpaca.Fields.ObjectField#getDescription
         */
        getDescription: function() {
            return "Elenco di scelta da stradario con via e civico";
        }
    });

    Alpaca.registerView({
    	"id": "elencostradario-view",
    	"parent": "bootstrap-create",
    	"templates": {
    		"container": elencoStradarioFieldContainer,
    		"container-object": elencoStradarioFieldContainerObject
    	}
    });
    Alpaca.registerFieldClass("elencoStradario", Alpaca.Fields.ElencoStradarioField);
    

})(jQuery);
