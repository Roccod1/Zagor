var settoreMerceologicoFiereContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var settoreMerceologicoFiereContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
		<div>\
		  <div class="row">\
		    <div class="col-md-12 paddingleft20">\
		      <span>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</span>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-4 paddingleft20">\
		      <span>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</span>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-4">\
		      <p>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</p>\
		    </div>\
		    <div class="col-md-4">\
		      <p>{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</p>\
		    </div>\
		    <div class="col-md-4">\
		      <p>{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</p>\
		      <p>{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</p>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-4">\
				<p>{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</p>\
			</div>\
		  </div>\
		</div>\
	</div>\
</script>';

(function($) {

    var Alpaca = $.alpaca;

var totalCheck = 27;
var counter = 0; /*per il validatore*/

function chkSettore(element){
	var counterhidden = element.parent.childrenByPropertyId["counterHidden"];

	if(element.getValue()){
		if(counterhidden.getValue() < 5){
			counterhidden.setValue(counterhidden.getValue() + 1);
			counter = Number(counterhidden.getValue());
		}
	}else{
		counterhidden.setValue(counterhidden.getValue() - 1);
		counter = Number(counterhidden.getValue());
	}
	
	if(Number(counterhidden.getValue()) >= 5){
		disableElement(element);
	}else{
		enableElement(element);
	}
};

function disableElement(element){
	for(i = 1; i <= totalCheck; i++){
		var name = "chk".concat(i);
		var toDisable = element.parent.childrenByPropertyId[name];
		if(!toDisable.getValue()){
			//toDisable.getControlEl().attr("disabled", true);
			toDisable.options.disabled = true;
			toDisable.disable();
		}
	}
};

function enableElement(element){
	
	for(i = 1; i <= totalCheck; i++){
		
		var name = "chk".concat(i);
		var toEnable = element.parent.childrenByPropertyId[name];
		if(toEnable.options.fieldClass.search('settorePrincipale') === -1){
			toEnable.options.disabled = false;
			toEnable.enable();
		}		
	}

};

function removeFlagPrincipale(element){
	
	for(i = 1; i <= totalCheck; i++){
		
		var name = "chk".concat(i);
		var toRemovePrincipale = element.parent.childrenByPropertyId[name];
		if(toRemovePrincipale.options.fieldClass.search('settorePrincipale') !== -1){
			toRemovePrincipale.options.fieldClass = toRemovePrincipale.options.fieldClass.replace(' settorePrincipale', '');
			toRemovePrincipale.getFieldEl().removeClass("settorePrincipale");
		}
	}

};

    
    Alpaca.Fields.SettoreMerceologicoFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.SettoreMerceologicoFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "settoreMerceologicoFiere";
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
                    "settoreLabel": {
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "settorePrincipale": {
	                    "readonly": false,
	                    "required": true,
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "chk1": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk2": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk3": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk4": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk5": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk6": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk7": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk8": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk9": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk10": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk11": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk12": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk13": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk14": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk15": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk16": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk17": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk18": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk19": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk20": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk21": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk22": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk23": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk24": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk25": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk26": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
	                "chk27": {
	                    "disallow": [
	                        false
	                    ],
	                    "readonly": false,
	                    "required": false,
	                    "type": "boolean",
	                    "properties": {}
	                },
                     "counterHidden": {
                         "type": "number",
                         "required": false,
                         "properties": {}
                     }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"validator": function(callback) {
		            if (counter === 0 || counter > 5) {
			
		                callback({
		                    "status": false,
		                    "message": "Selezionare da un minimo di 1 ad un massimo di 5 scelte per il settore merceologico."
		                });
		            } else {
		                callback({
		                    "status": true
		                });
		            }
		        },
                "fields": {
                    "settoreLabel": {
						"label": "Settore Merceologico",
	                    "type": "text",
		            	"validate": false,
		    			"showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 1,
	                    "fieldClass": "paddingtop20",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "settorePrincipale": {
	                    "type": "text",
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "hidden": false,
	                    "label": "Settore Principale (indica il numero):",
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "sort": false,
	                    "helpers": [],
	                    "readonly": false,
	                    "order":2,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "events": {
							"ready": function(){
								counter = Number(this.parent.childrenByPropertyId["counterHidden"].getValue());
							},
							"change": function (){
								
								/*if(this.getValue().indexOf(',') !== -1 || this.getValue().indexOf('.') !== -1){
									this.setValue();
									this.options.helpers = ["Inserire un valore numerico intero!"];
									this.refresh();
								} else*/
								if(Number(this.getValue()) > 0 && Number(this.getValue()) <= totalCheck){
									var name = "chk" + this.getValue();
									var counterHidden = this.parent.childrenByPropertyId["counterHidden"];
									var checkBox = this.parent.childrenByPropertyId[name];
							
									
									if(Number(counterHidden.getValue()) >= 5 && !checkBox.getValue()){
										this.setValue();
										this.displayMessage();
										this.displayMessage("Inserire uno dei settori selezionati!");
									}else{	
										removeFlagPrincipale(this);
										enableElement(this);
										
										if(this.parent.getContainerEl().find('.help-block')){
											this.parent.getContainerEl().find('.help-block').remove();
										}
										
										/*
										var settoreVal = this.getValue();
										this.options.helpers = [];
										this.refresh();
										this.setValue(settoreVal);
										
										/*solo se sono al primo step*/
										if(this.name.search("settoreMerceologico") !== -1){								
											var settore = $(".alpaca-form").alpaca('get').childrenByPropertyId['settoreMerceologico'].childrenByPropertyId[name];
											
											if(!$('input[name=settoreMerceologico_'+ name + ']').is(':checked')){
												$('input[name=settoreMerceologico_'+ name + ']').click();
	
												settore.options.disabled = true;
												settore.disable();
												settore.options.fieldClass += " settorePrincipale";
												settore.getFieldEl().addClass("settorePrincipale");												
											} else {
												/* is checked */
												settore.options.disabled = true;
												settore.disable();
												settore.options.fieldClass += " settorePrincipale";
												settore.getFieldEl().addClass("settorePrincipale");												

											}
											
											$('input[name=settoreMerciPenultimo_settorePrincipale]').val(this.getValue());
											$('input[name=settoreMerciUltimo_settorePrincipale').val(this.getValue());
											
											/* per bilanciare l'evento click senza aggiungere ulteriore logica
												senza troppa logica così i vari step sono allineati */
											$('input[name=settoreMerciUltimo_'+ name + ']').click();
											$('input[name=settoreMerciPenultimo_'+ name + ']').click();
											
											$('input[name=settoreMerciPenultimo_settorePrincipale]').change();
											$('input[name=settoreMerciUltimo_settorePrincipale').change();
											
										} else if(this.name.search("settoreMerciPenultimo") !== -1){
											
											if(!$('input[name=settoreMerciPenultimo_'+ name + ']').is(':checked')){
												$('input[name=settoreMerciPenultimo_'+ name + ']').click();
											}
											var settore = $(".alpaca-form").alpaca('get').childrenByPropertyId['settoreMerciPenultimo'].childrenByPropertyId[name];
												
											settore.options.disabled = true;
											settore.disable();
											settore.options.fieldClass += " settorePrincipale";
											settore.getFieldEl().addClass("settorePrincipale");												

											
											
										}else if (this.name.search("settoreMerciUltimo") !== -1){
											
											if(!$('input[name=settoreMerciUltimo_'+ name + ']').is(':checked')){
												$('input[name=settoreMerciUltimo_'+ name + ']').click();
											}
											
											var settore = $(".alpaca-form").alpaca('get').childrenByPropertyId['settoreMerciUltimo'].childrenByPropertyId[name];
	
											settore.options.disabled = true;
											settore.disable();
											settore.options.fieldClass += " settorePrincipale";
											settore.getFieldEl().addClass("settorePrincipale");												

											
											
										}
										
									}
									
									if(Number(counterHidden.getValue()) >= 5){
										disableElement(this);
									}
								} else {
									this.setValue();
									this.displayMessage();
									this.displayMessage("Inserire un valore intero tra 1 e " + totalCheck + "!");
								}
							}
						}
	                },
	                "chk1": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "1. Agricoltura, Silvicoltura, Zootecnica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 3,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk1]').click();
									$('input[name=settoreMerciUltimo_chk1]').click();
								}
							}
						}
	                },
	                "chk2": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "2. Food, Bevande, Ospitalit&agrave;",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 4,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk2]').click();
									$('input[name=settoreMerciUltimo_chk2]').click();
								}
							}
						}
	                },
	                "chk3": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "3. Sport, Hobby, Intrattenimento, Arte",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 5,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk3]').click();
									$('input[name=settoreMerciUltimo_chk3]').click();
								}
							}
						}
	                },
	                "chk4": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "4. Servizi Business, Commercio",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 6,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk4]').click();
									$('input[name=settoreMerciUltimo_chk4]').click();
								}
							}
						}
	                },
	                "chk5": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "5. Costruzioni, Infrastrutture",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 7,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk5]').click();
									$('input[name=settoreMerciUltimo_chk5]').click();
								}
							}
						}
	                },
	                "chk6": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "6. Viaggi, Trasporti",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 8,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk6]').click();
									$('input[name=settoreMerciUltimo_chk6]').click();
								}
							}
						}
	                },
	                "chk7": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "7. Sicurezza, Antincendio, Difesa",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 9,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk7]').click();
									$('input[name=settoreMerciUltimo_chk7]').click();
								}
							}
						}
	                },
	                "chk8": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "8. Formazione, Educazione",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 10,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk8]').click();
									$('input[name=settoreMerciUltimo_chk8]').click();
								}
							}
						}
	                },
	                "chk9": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "9. Energia, Combustibile, Gas",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 11,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk9]').click();
									$('input[name=settoreMerciUltimo_chk9]').click();
								}
							}
						}
	                },
	                "chk10": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "10. Protezione dell'ambiente",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 12,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk10]').click();
									$('input[name=settoreMerciUltimo_chk10]').click();
								}
							}
						}
	                },
	                "chk11": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "11. Stampa, Packaging, Imballaggi",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 13,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk11]').click();
									$('input[name=settoreMerciUltimo_chk11]').click();
								}
							}
						}
	                },
	                "chk12": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "12. Arredamento, Design d'interni",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 14,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk12]').click();
									$('input[name=settoreMerciUltimo_chk12]').click();
								}
							}
						}
	                },
	                "chk13": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "13. Casalinghi, Giochi, Realistica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 15,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk13]').click();
									$('input[name=settoreMerciUltimo_chk13]').click();
								}
							}
						}
	                },
	                "chk14": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "14. Bellezza, Cosmetica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 16,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk14]').click();
									$('input[name=settoreMerciUltimo_chk14]').click();
								}
							}
						}
	                },
	                "chk15": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "15. Real Estate Immobiliare",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 17,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk15]').click();
									$('input[name=settoreMerciUltimo_chk15]').click();
								}
							}
						}
	                },
	                "chk16": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "16. Automobili, Motocicli",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 18,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk16]').click();
									$('input[name=settoreMerciUltimo_chk16]').click();
								}
							}
						}
	                },
	                "chk17": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "17. Chimica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 19,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk17]').click();
									$('input[name=settoreMerciUltimo_chk17]').click();
								}
							}
						}
	                },
	                "chk18": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "18. Elettronica, Componenti",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 20,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk18]').click();
									$('input[name=settoreMerciUltimo_chk18]').click();
								}
							}
						}
	                },
	                "chk19": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "19. Industria, Tecnologia, Meccanica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 21,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk19]').click();
									$('input[name=settoreMerciUltimo_chk19]').click();
								}
							}
						}
	                },
	                "chk20": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "20. Aviazione, Aerospaziale",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 22,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk20]').click();
									$('input[name=settoreMerciUltimo_chk20]').click();
								}
							}
						}
	                },
	                "chk21": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "21. IT e Telecomunicazioni",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 23,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk21]').click();
									$('input[name=settoreMerciUltimo_chk21]').click();
								}
							}
						}
	                },
	                "chk22": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "22. Salute, Attrezzature Ospedaliere",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 24,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk22]').click();
									$('input[name=settoreMerciUltimo_chk22]').click();
								}
							}
						}
	                },
	                "chk23": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "23. Ottica",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 25,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk23]').click();
									$('input[name=settoreMerciUltimo_chk23]').click();
								}
							}
						}
	                },
	                "chk24": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "24. Gioielli, Orologi, Accessori",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 26,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk24]').click();
									$('input[name=settoreMerciUltimo_chk24]').click();
								}
							}
						}
	                },
	                "chk25": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "25. Tessile, Abbigliamento, Moda",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 27,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk25]').click();
									$('input[name=settoreMerciUltimo_chk25]').click();
								}
							}
						}
	                },
	                "chk26": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "26. Trasporti, Logistica, Navigazione",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 28,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk26]').click();
									$('input[name=settoreMerciUltimo_chk26]').click();
								}
							}
						}
	                },
	                "chk27": {
	                    "type": "checkbox",
	                    "fieldClass": "paddingtop20",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": true,
	                    "focus": false,
	                    "rightLabel": "27. Campionarie Generali",
	                    "useDataSourceAsEnum": false,
	                    "sort": false,
	                    "readonly": false,
	                    "renderButtons": true,
	                    "order": 29,
	                    "fields": {},
	                    "events": {
							"change": function () {
								chkSettore(this);
								if(this.name.toLowerCase().search("ultimo") === -1){
									$('input[name=settoreMerciPenultimo_chk27]').click();
									$('input[name=settoreMerciUltimo_chk27]').click();
								}
							}
						}
	                },
                    "counterHidden": {
                        "type": "number",
                        "label": "New hidden",
                        "hidden": true,
                        "helpers": [],
                        "validate": false,
                        "disabled": true,
                        "showMessages": false,
                        "renderButtons": false,
                        "order": 30,
                        "fields": {},
                        "events": {
							"ready": function () {
								if(!isCaricaBozza){
									this.setValue(0);
								}
							}
						}
                    }
                },
                "view": "settoreMerceologicoFiere-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Check Settore Merceologico Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "Check Settore Merceologico Fiere, limite 5 check e indicazione settore principale";
        }
    });
   
    Alpaca.registerView({
	  	"id": "settoreMerceologicoFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "stringNotANumber": "Inserire un valore numerico",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}",
	        "invalidPattern": "Inserire un valore numerico intero"
	    },
		"templates": {
			"container": settoreMerceologicoFiereContainer,
			"container-object": settoreMerceologicoFiereContainerObject
		}
    });
    Alpaca.registerFieldClass("settoreMerceologicoFiere", Alpaca.Fields.SettoreMerceologicoFiere); 
  
    
})(jQuery);