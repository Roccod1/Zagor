var superficieContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var superficieContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
    <div>\
  <div class="row">\
    <div class="col-md-12 paddingleft20">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
  </div>\
  <div class="row">\
    <div class="col-md-12">\
      <div class="col-md-2 text-center"></div>\
      <div class="col-md-4 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-4 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
    </div>\
  </div>\
  <div class="row">\
    <div class="col-md-12">\
      <div class="col-md-2"></div>\
      <div class="col-md-2 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center"></div>\
    </div>\
  </div>\
  <div class="row">\
    <div class="col-md-12">\
      <div class="col-md-2 text-center">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
    </div>\
  </div>\
  <div class="row">\
    <div class="col-md-12">\
      <div class="col-md-2 text-center">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div>\
    </div>\
  </div>\
  <div class="row">\
    <div class="col-md-12">\
      <div class="col-md-2 text-center">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div>\
      <div class="col-md-2 text-center">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div>\
    </div>\
  </div>\
  <div class="row">\
    <div class="col-md-12 paddingleft20">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div>\
  </div>\
  <div>\
	</div>\
</script>';

function totLordaCopertaItalia(element){
	var totCoperta = element.parent.childrenByPropertyId["totLordaCopertaItalia"];
	var lorda = element.parent.childrenByPropertyId["supEspAffCopertaItalia"].getValue();
	var netta = element.parent.childrenByPropertyId["supEspNettaCopertaItalia"].getValue();
	
	var totale = Number(lorda) + Number(netta);
	if(!isNaN(totale)){
		totCoperta.setValue(0);
		totCoperta.setValue(totale);
	}	
}

function totLordaScopertaItalia(element){
	var totScoperta = element.parent.childrenByPropertyId["totLordaScopertaItalia"];
	var lorda = element.parent.childrenByPropertyId["supEspAffScopertaItalia"].getValue();
	var netta = element.parent.childrenByPropertyId["supEspNettaScopertaItalia"].getValue();
	
	var totale = Number(lorda) + Number(netta);
	if(!isNaN(totale)){
		totScoperta.setValue(0);
		totScoperta.setValue(totale);
	}	
}

function totLordaScopertaEstero(element){
	var totScoperta = element.parent.childrenByPropertyId["totLordaCopertaEstero"];
	var lorda = element.parent.childrenByPropertyId["supEspAffCopertaEstero"].getValue();
	var netta = element.parent.childrenByPropertyId["supEspNettaCopertaEstero"].getValue();
	
	var totale = Number(lorda) + Number(netta);
	if(!isNaN(totale)){
		totScoperta.setValue(0);
		totScoperta.setValue(totale);
	}
}

function totLordaCopertaEstero(element){
	var totCoperta = element.parent.childrenByPropertyId["totLordaScopertaEstero"];
	var lorda = element.parent.childrenByPropertyId["supEspAffScopertaEstero"].getValue();
	var netta = element.parent.childrenByPropertyId["supEspNettaScopertaEstero"].getValue();
	
	var totale = Number(lorda) + Number(netta);
	if(!isNaN(totale)){
		totCoperta.setValue(0);
		totCoperta.setValue(totale);
	}
}

function affittataTotale(element){
	var totAffittata = element.parent.childrenByPropertyId["affittataTotale"];
	var lordaItalia = element.parent.childrenByPropertyId["supEspAffScopertaItalia"].getValue();
	var nettaItalia = element.parent.childrenByPropertyId["supEspAffCopertaItalia"].getValue();
	var lordaEstero = element.parent.childrenByPropertyId["supEspAffScopertaEstero"].getValue();
	var nettaEstero = element.parent.childrenByPropertyId["supEspAffCopertaEstero"].getValue();
	
	var totale = Number(lordaItalia) + Number(nettaItalia) + Number(lordaEstero) + Number(nettaEstero);
	if(!isNaN(totale)){
		totAffittata.setValue(0);
		totAffittata.setValue(totale);
	}
}

function espNettaOccupata(element){
	var espNettaOccupata = element.parent.childrenByPropertyId["espNettaOccupata"];
	var lordaItalia = element.parent.childrenByPropertyId["supEspNettaCopertaItalia"].getValue();
	var nettaItalia = element.parent.childrenByPropertyId["supEspNettaScopertaItalia"].getValue();
	var lordaEstero = element.parent.childrenByPropertyId["supEspNettaCopertaEstero"].getValue();
	var nettaEstero = element.parent.childrenByPropertyId["supEspNettaScopertaEstero"].getValue();
	
	var totale = Number(lordaItalia) + Number(nettaItalia) + Number(lordaEstero) + Number(nettaEstero);
	if(!isNaN(totale)){
		espNettaOccupata.setValue(0);
		espNettaOccupata.setValue(totale);
	}
}

function totaleLorda(element){
	var totaleLorda = element.parent.childrenByPropertyId["totaleLorda"];
	var affittataTotale = element.parent.childrenByPropertyId["affittataTotale"].getValue();
	var espNettaOccupata = element.parent.childrenByPropertyId["espNettaOccupata"].getValue();
	
	var totale = Number(affittataTotale) + Number(espNettaOccupata);
	if(!isNaN(totale)){
		totaleLorda.setValue(0);
		totaleLorda.setValue(totale);
	}
}

(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.SuperficieEspositivaFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.SuperficieEspositivaFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "superficieEspositivaFiere";
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
                    "superficieLabel": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "italiaLabel": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "esteroLabel": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "totaleLabel": {
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "copertaLabel": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "scopertaLabel": {
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "espositivaAff": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "espositivaNetta": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "espositivaTotaleLorda": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "supEspAffCopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspAffScopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspAffCopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspAffScopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "affittataTotale": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "supEspNettaCopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspNettaScopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspNettaCopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "supEspNettaScopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": true,
	                    "properties": {}
	                },
	                "espNettaOccupata": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "totLordaCopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "totLordaScopertaItalia": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "totLordaCopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "totLordaScopertaEstero": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "totaleLorda": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "required": false,
	                    "properties": {}
	                },
	                "testoPiePagina": {
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                }
                }
            };
            
            Alpaca.merge(this.options, {
            	"label": "",
            	"validate": false,
	            "showMessages": false,
                "fields": {
                    "superficieLabel": {
	                    "type": "text",
	                    "validate": false,
	            		"showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 1,
	                    "helpers": [],
	                    "fieldClass": "",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "italiaLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 2,
	                    "helpers": [],
	                    "fieldClass": "text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "esteroLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 3,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "totaleLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 4,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "copertaLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 5,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "scopertaLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 6,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "espositivaAff": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 7,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "espositivaNetta": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 8,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "espositivaTotaleLorda": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
	                    "order": 9,
	                    "helpers": [],
	                    "fieldClass": " text-center",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                },
	                "supEspAffCopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 10,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspAffScopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 11,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspAffCopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 12,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspAffScopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 13,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "affittataTotale": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 14,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "supEspNettaCopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 15,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspNettaScopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 16,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspNettaCopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 17,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "supEspNettaScopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": false,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": true,
	                    "showMessages": true,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 18,
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function () {
								totLordaCopertaItalia(this);
								totLordaScopertaItalia(this);
								totLordaScopertaEstero(this);
								totLordaCopertaEstero(this);
								affittataTotale(this);
								espNettaOccupata(this);
								totaleLorda(this);
							}
						}
	                },
	                "espNettaOccupata": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 19,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totLordaCopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 20,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totLordaScopertaItalia": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 21,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totLordaCopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 22,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totLordaScopertaEstero": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 23,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totaleLorda": {
	                    "type": "text",
	                    "label": "",
	                    "disabled": true,
	                    "renderButtons": true,
	                    "helpers": [],
	                    "validate": false,
	                    "showMessages": false,
	                    "data": {},
	                    "attributes": {},
	                    "allowOptionalEmpty": true,
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "order": 24,
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "testoPiePagina": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
	                    "order": 25,
	                    "helpers": [],
	                    "fieldClass": "",
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "typeahead": {},
	                    "allowOptionalEmpty": true,
	                    "data": {},
	                    "autocomplete": false,
	                    "disallowEmptySpaces": false,
	                    "disallowOnlyEmptySpaces": false,
	                    "renderButtons": true,
	                    "attributes": {},
	                    "fields": {},
	                    "view": "bootstrap-display"
	                }
                },
                "view": "superficieEspositivaFiere-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "SuperficieEspositiva per Scheda Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "I totali sono calcolati automaticamente";
        }
    });
   
    Alpaca.registerView({
	  	"id": "superficieEspositivaFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "stringNotANumber": "Inserire un valore numerico intero",
	        "stringValueTooLarge": "Valore massimo consentito {0}",
	        "stringValueTooSmall": "Valore minimo consentito {0}",
	        "invalidPattern": "Inserire un valore numerico intero"
	    },
		"templates": {
			"container": superficieContainer,
			"container-object": superficieContainerObject
		}
    });
    Alpaca.registerFieldClass("superficieEspositivaFiere", Alpaca.Fields.SuperficieEspositivaFiere); 
  
    
})(jQuery);