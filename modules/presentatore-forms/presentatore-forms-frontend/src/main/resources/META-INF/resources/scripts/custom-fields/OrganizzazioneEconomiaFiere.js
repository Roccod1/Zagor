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
			<div class="col-md-12 paddingleft20">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center"></div>\
				<div class="col-md-2 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12 paddingleft20">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<!-- ATTIVITA CONVEGNISTICA -->\
		<div class="row">\
			<div class="col-md-12 paddingleft20">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center"></div>\
				<div class="col-md-2 text-center">{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[30]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[31]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[32]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[33]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[34]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[35]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[36]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12">\
				<div class="col-md-4 text-center">{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[37]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[38]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[39]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		</div>\
		<!-- ASPETTI ECONOMICI -->\
		<div class="row">\
			<div class="col-md-12 paddingleft20">{{#with items.[40]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12 paddingleft20">{{#with items.[41]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[42]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-3 paddingleft20">{{#with items.[43]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[44]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-3 paddingleft20">{{#with items.[45]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-12 paddingleft20">{{#with items.[46]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[47]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-3 paddingleft20">{{#with items.[48]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[49]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-3 paddingleft20">{{#with items.[50]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<!-- TABELLA RICAVI -->\
		<div class="row">\
			<div class="col-md-6 paddingleft20">{{#with items.[51]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[52]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[53]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[54]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[55]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[56]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[57]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[58]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[59]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[60]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<!-- TABELLA COSTI -->\
		<div class="row">\
			<div class="col-md-6 paddingleft20">{{#with items.[61]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[62]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[63]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[64]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[65]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[66]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[67]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[68]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[69]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[70]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[71]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
		<div class="row">\
			<div class="col-md-3 paddingleft20">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-2 paddingleft20">{{#with items.[72]}}{{#item}}{{/item}}{{/with}}</div>\
			<div class="col-md-1 paddingleft20">€</div>\
		</div>\
    </div> \
</script>';

function calcolaPartecipanti(element){
	
	var visItalia = Number(element.parent.childrenByPropertyId["visitatoriItalia"].getValue());
	var visEstero = Number(element.parent.childrenByPropertyId["visitatoriEstero"].getValue());
	
	var staffItalia = Number(element.parent.childrenByPropertyId["staffItalia"].getValue());
	var staffEstero = Number(element.parent.childrenByPropertyId["staffEstero"].getValue());
	
	var stampaItalia = Number(element.parent.childrenByPropertyId["addettiStampaItalia"].getValue());
	var stampaEstero = Number(element.parent.childrenByPropertyId["addettiStampaEstero"].getValue());
	
	var relatoriItalia = Number(element.parent.childrenByPropertyId["relatoriItalia"].getValue());
	var relatoriEstero = Number(element.parent.childrenByPropertyId["relatoriEstero"].getValue());
	
	if(!isNaN(visItalia) && !isNaN(visEstero) && !isNaN(staffItalia) && !isNaN(staffEstero) && !isNaN(stampaItalia) && !isNaN(stampaItalia) && !isNaN(relatoriItalia) && !isNaN(relatoriEstero)){
		element.parent.childrenByPropertyId["visitatoriTotale"].setValue(visItalia + visEstero);
		element.parent.childrenByPropertyId["staffTotale"].setValue(staffItalia + staffEstero);	
		element.parent.childrenByPropertyId["addettiStampaTotale"].setValue(stampaItalia + stampaEstero);
		element.parent.childrenByPropertyId["relatoriTotale"].setValue(relatoriItalia + relatoriEstero);
		element.parent.childrenByPropertyId["totPartecipantiItalia"].setValue(visItalia + staffItalia + stampaItalia + relatoriItalia);
		element.parent.childrenByPropertyId["totPartecipantiEstero"].setValue(visEstero + staffEstero + stampaEstero + relatoriEstero);
		element.parent.childrenByPropertyId["totalePartecipanti"].setValue(visItalia + staffItalia + stampaItalia + relatoriItalia + visEstero + staffEstero + stampaEstero + relatoriEstero);
	}
}

function calcolaTotEvento(element){
	var conferenzeDirette = Number(element.parent.childrenByPropertyId["conferenzeDirette"].getValue());
	var conferenzeTerzi = Number(element.parent.childrenByPropertyId["conferenzeTerzi"].getValue());
	
	var seminariDirette = Number(element.parent.childrenByPropertyId["seminariDirette"].getValue());
	var seminariTerzi = Number(element.parent.childrenByPropertyId["seminariTerzi"].getValue());
	
	if(!isNaN(conferenzeDirette) && !isNaN(conferenzeTerzi) && !isNaN(seminariDirette) && !isNaN(seminariTerzi)){
		element.parent.childrenByPropertyId["conferenzetotale"].setValue(conferenzeDirette + conferenzeTerzi);
		element.parent.childrenByPropertyId["seminaritotale"].setValue(seminariDirette + seminariTerzi);
		element.parent.childrenByPropertyId["totaleDiretti"].setValue(seminariDirette + conferenzeDirette);
		element.parent.childrenByPropertyId["totaleTerzi"].setValue(conferenzeTerzi + seminariTerzi);
		element.parent.childrenByPropertyId["totaleEventi"].setValue(conferenzeTerzi + seminariTerzi + seminariDirette + conferenzeDirette);
	}
}

function calcolaRicavoEvento(element){
	
	var tot = Number(element.parent.childrenByPropertyId["locazioneRicavo"].getValue()) +
				Number(element.parent.childrenByPropertyId["ingressiRicavo"].getValue()) + 
				Number(element.parent.childrenByPropertyId["contributiRicavo"].getValue()) +
				Number(element.parent.childrenByPropertyId["altroRicavo"].getValue());
	
	if(!isNaN(tot)){
		element.parent.childrenByPropertyId["totaleRicavo"].setValue(tot);
	}
}

function calcolaCostoEvento(element){
	
	var tot = Number(element.parent.childrenByPropertyId["promozioneCosto"].getValue()) +
				Number(element.parent.childrenByPropertyId["affittoCosto"].getValue()) + 
				Number(element.parent.childrenByPropertyId["personaleCosto"].getValue()) +
				Number(element.parent.childrenByPropertyId["consulenzeCosto"].getValue())+
				Number(element.parent.childrenByPropertyId["altroCosto"].getValue());
	
	if(!isNaN(tot)){
		element.parent.childrenByPropertyId["totaleCosto"].setValue(tot);
	}
}


(function($) {

    var Alpaca = $.alpaca;
    
    Alpaca.Fields.EconomiaOrganizzazioneFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.EconomiaOrganizzazioneFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "economiaOrganizzazioneFiere";
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
			        "partecipantiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "italianiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "esteriLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "totaleLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "visitatoriLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "visitatoriItalia": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "visitatoriEstero": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "visitatoriTotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "staffLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "staffItalia": {
			            "type": "string",
			            "required": true,
	                    "pattern": "^\\d+$",
			            "properties": {}
			        },
			        "staffEstero": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "staffTotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "addettiStampaLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "addettiStampaItalia": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "addettiStampaEstero": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "addettiStampaTotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "relatoriLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "relatoriItalia": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "relatoriEstero": {
			            "type": "string",
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "relatoriTotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "totPartecipantiLabel": {
			            "type": "string",
			            "properties": {}
			        },
			        "totPartecipantiItalia": {
			            "type": "string",
			            "properties": {}
			        },
			        "totPartecipantiEstero": {
			            "type": "string",
			            "properties": {}
			        },
			        "totalePartecipanti": {
			            "type": "string",
			            "properties": {}
			        },
			        "notaLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "convegnisticaLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "orgDirettiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "orgTerziLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "orgTotaleLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "conferenzeLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "conferenzeDirette": {
			            "type": "string",
			            "required": true,
	                    "pattern": "^\\d+$",
			            "properties": {}
			        },
			        "conferenzeTerzi": {
			            "type": "string",
			            "required": true,
	                    "pattern": "^\\d+$",
			            "properties": {}
			        },
			        "conferenzetotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "seminariLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "seminariDirette": {
			            "type": "string",
			            "required": true,
	                    "pattern": "^\\d+$",
			            "properties": {}
			        },
			        "seminariTerzi": {
			            "type": "string",
			            "required": true,
	                    "pattern": "^\\d+$",
			            "properties": {}
			        },
			        "seminaritotale": {
			            "type": "string",
			            "properties": {}
			        },
			        "totaleDiretti": {
			            "type": "string",
			            "properties": {}
			        },
			        "totaleTerzi": {
			            "type": "string",
			            "properties": {}
			        },
			        "totaleEventi": {
			            "type": "string",
			            "properties": {}
			        },
			        "aspettiEcoLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "tariffeMedieLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "areaCopertaLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "areaCoperta": {
			            "type": "string",
	                    "pattern": "^(\\d+(?:[\\.\\,]\\d)?\\d?)$",
			            "required": true,
			            "properties": {}
			        },
			        "areaScopertaLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "areaScoperta": {
			            "type": "string",
	                    "pattern": "^(\\d+(?:[\\.\\,]\\d)?\\d?)$",
			            "required": true,
			            "properties": {}
			        },
			        "prezzoBigliettoLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "bigliettoVisitatoreLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "bigliettoVisitatore": {
			            "type": "string",			            
	                    "pattern": "^(\\d+(?:[\\.\\,]\\d)?\\d?)$",
			            "required": true,
			            "properties": {}
			        },
			        "bigliettoSpecialeLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "bigliettoSpeciale": {
			            "type": "string",			            
	                    "pattern": "^(\\d+(?:[\\.\\,]\\d)?\\d?)$",
			            "required": true,
			            "properties": {}
			        },
			        "tabRicaviLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "locazioneLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "locazioneRicavo": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "ingressiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "ingressiRicavo": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "contributiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "contributiRicavo": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "altriRicaviLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "altroRicavo": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "totaleRicavo": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "tabCostiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "promozioneLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "promozioneCosto": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "affittoLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "affittoCosto": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "personaleLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "personaleCosto": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "consulenzeLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "consulenzeCosto": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "altriCostiLabel": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        },
			        "altroCosto": {
			            "type": "string",			            
	                    "pattern": "^\\d+$",
			            "required": true,
			            "properties": {}
			        },
			        "totaleCosto": {
			            "type": "string",
			            "required": true,
			            "properties": {}
			        }
		        }
	       	};
	       	
	       	Alpaca.merge(this.options, {
		    	"validate": false,
		    	"showMessages": false,
		        "fields": {
					"partecipantiLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			        "italianiLabel": {
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
			        "esteriLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
			        "totaleLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
			        "visitatoriLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
	                "visitatoriItalia": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "visitatoriEstero": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "visitatoriTotale": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
	                },
			        "staffLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
	                "staffItalia": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "staffEstero": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "staffTotale": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                },
			        "addettiStampaLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
	                "addettiStampaItalia": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "addettiStampaEstero": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "addettiStampaTotale": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
	                },
			        "relatoriLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
	                "relatoriItalia": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "relatoriEstero": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaPartecipanti(this);
							}
						}
	                },
	                "relatoriTotale": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                },
			        "totPartecipantiLabel": {
			            "data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
	                "totPartecipantiItalia": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totPartecipantiEstero": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "totalePartecipanti": {
	                    "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
	                },
	                "notaLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			        "convegnisticaLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			        "orgDirettiLabel": {
						"data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
			        "orgTerziLabel": {
						"data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "orgTotaleLabel": {
						"data": {},
			            "fieldClass": "text-center",
			            "type": "text",
			            "helpers": [],
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
			        "conferenzeLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "conferenzeDirette": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaTotEvento(this);
							}
						}
			        },
			        "conferenzeTerzi": {
			           "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaTotEvento(this);
							}
						}
			        },
			        "conferenzetotale": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			            "fields": {}
			        },
			        "seminariLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "seminariDirette": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaTotEvento(this);
							}
						}
			        },
			        "seminariTerzi": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico intero"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    },
	                    "events":{
							"change": function() {
								calcolaTotEvento(this);
							}
						}
			        },
			        "seminaritotale": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			            "fields": {}
			        },
			        "totaleDiretti": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			            "fields": {}
			        },
			        "totaleTerzi": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			            "fields": {}
			        },
			        "totaleEventi": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
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
			            "fields": {}
			        },
			        "aspettiEcoLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "tariffeMedieLabel": {
			            "data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "areaCopertaLabel": {
						"data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "areaCoperta": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
			            "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico con max 2 cifre decimali"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    }
			        },
			        "areaScopertaLabel": {
						"data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "areaScoperta": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
			            "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico con max 2 cifre decimali"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    }
			        },
			        "prezzoBigliettoLabel": {"data": {},
			            "fieldClass": "",
			            "type": "text",
			            "helpers": [],
			            "disabled": false,
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
			        "bigliettoVisitatoreLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "bigliettoVisitatore": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
			            "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico con max 2 cifre decimali"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    }
			        },
			        "bigliettoSpecialeLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "bigliettoSpeciale": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
			            "view": {
	                        "messages": {
	                            "notOptional": "Campo Obbligatorio",
	                            "invalidPattern": "Questo valore deve essere numerico con max 2 cifre decimali"
	                        },
	                        "parent": "bootstrap-edit",
	                        "templates": {}
	                    }
			        },
			        "tabRicaviLabel": {
						"type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "locazioneLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "locazioneRicavo": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaRicavoEvento(this);
							}
						}
			        },
			        "ingressiLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "ingressiRicavo": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaRicavoEvento(this);
							}
						}
			        },
			        "contributiLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "contributiRicavo": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaRicavoEvento(this);
							}
						}
			        },
			        "altriRicaviLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "altroRicavo": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaRicavoEvento(this);
							}
						}
			        },
			        "totaleRicavo": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
			        },
			        "tabCostiLabel": {
						"type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
					"promozioneLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "promozioneCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaCostoEvento(this);
							}
						}
			        },
			        "affittoLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "affittoCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaCostoEvento(this);
							}
						}
			        },
			        "personaleLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "personaleCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaCostoEvento(this);
							}
						}
			        },
			        "consulenzeLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "consulenzeCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaCostoEvento(this);
							}
						}
			        },
			        "altriCostiLabel": {
			            "type": "text",
	                    "disabled": false,
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
	                    "fieldClass": "",
			            "view": "bootstrap-display",
	                    "fields": {}
			        },
			        "altroCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {},
	                    "events":{
							"change": function() {
								calcolaCostoEvento(this);
							}
						}
			        },
			        "totaleCosto": {
			            "type": "text",
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
	                    "fieldClass": "",
	                    "fields": {}
			        }
				},
	                "view": "economiaOrganizzazioneFiere-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Economia e Organizzazione Fiere";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Tabelle per Economia e Organizzazione Fiere";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "economiaOrganizzazioneFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta",
	        "invalidPattern": "Inserire un valore numerico intero"
	    },
		"templates": {
			"container": myViewContainer,
			"container-object": myViewContainerObject
		}
    });
    Alpaca.registerFieldClass("economiaOrganizzazioneFiere", Alpaca.Fields.EconomiaOrganizzazioneFiere); 
  
    
})(jQuery);