var calcolaEventoContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var calcolaEventoContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
   		<div class="row">\
		  <div class="col-md-12">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		 </div>\
		<div class="row">\
		  <div class="col-md-12">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
		  <div class="col-md-12">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
		<div class="row">\
		  <div class="col-md-6">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		  <div class="col-md-6">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
		</div>\
    </div> \
</script>';



(function($) {

    var Alpaca = $.alpaca;
    
    var internazionale = '';
    var nazionale = '';
    var regionale = '';
    var nc = '0';
    
    function calcolaInternazionale(step){
		/*  INTERNAZIONALE
			a. la presenza di almeno il 15% del numero totale di espositori, di espositori esteri diretti o rappresentanti,
			   provenienti da almeno 10 paesi esteri o alternativamente provenienti da almeno 5 paesi esteri extra U.E. sul totale degli espositori;
			b. l'affluenza di almeno l'8% del numero complessivo di visitatori, di visitatori esteri;
			c. l'affluenza di almeno il 4% del numero complessivo di visitatori, di visitatori esteri ed extra U.E.
		*/
		var isInternazionale = false;
		
		/* Punto a */
		var numeroEspositoriEuropei = $('.alpaca-form').alpaca('get').childrenByPropertyId['origineEspositoriPenultimo'].childrenByPropertyId['numeroEspositoriEuropei'].getValue();
		var numeroEspositoriExtraEu = $('.alpaca-form').alpaca('get').childrenByPropertyId['origineEspositoriPenultimo'].childrenByPropertyId['numeroEspositoriExtraUe'].getValue();
		var totaleEspositori = Number($("input[name=origineEspositori" + step + "_totale]").val());
		var totaleEspositoriEsteri = Number($("input[name=origineEspositori" + step + "_euroTotale]").val()) + Number($("input[name=origineEspositori" + step + "_extraUeTotale]").val());	
		
		if(numeroEspositoriEuropei >= 10 || numeroEspositoriExtraEu >= 5){ //prendere il numero di paesi non il totale degli espositori
			var percent = (totaleEspositori / 100) * 15; /* 15% */
			if(totaleEspositoriEsteri >= percent){
				isInternazionale = true;
			}
		}
		
		/* Punto b */
		if(!isInternazionale){
			var visitatoriTotali = Number($("input[name=origineVisitatori" + step + "_totaleVisitatori]").val());
			var visitatoriEu = Number($("input[name=origineVisitatori" + step + "_euTotaleVis]").val());
		
			var percent = (visitatoriTotali / 100) * 8; /* 8% */
			if((visitatoriEu >= percent) && !(percent === 0)){
				isInternazionale = true;
			} else{
				isInternazionale = false;
			}
		}
		
		/* Punto c */
		if(!isInternazionale){
			var tuttiVisitatoriExtraUe = Number($("input[name=origineVisitatori" + step + "_extraEuTotaleVis]").val());
			
			var percent = (visitatoriTotali / 100) * 4; /* 4% */
			if((tuttiVisitatoriExtraUe >= percent) && !(percent === 0)){
				isInternazionale = true;
			} else{
				isInternazionale = false;
			}
		}
		
		if(isInternazionale){
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(internazionale);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(internazionale);
			}
		}else {
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(nc);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(nc);
			}
		}
		
		return isInternazionale;
	}
	
	function calcolaNazionale(step){
		
		/*  NAZIONALE
			a. una partecipazione di espositori o visitatori provenienti da almeno 6 regioni diverse da quella in cui si svolge
				l’iniziativa, superiore alla metà degli espositori totali;
			b. una partecipazione di espositori esteri diretti o rappresentanti non inferiori al 10% del totale degli espositori;
			c. una presenza di visitatori di provenienza extra regionale non inferiore al 5% del totale dei visitatori.
		*/
		var isNazionale = false;
		
		/* Punto a */
		var numRegioni = Number($("input[name=origineEspositori" + step + "_numeroEspositoriNazionali]").val());
		var totaleEspositoriNaz = Number($("input[name=origineEspositori" + step + "_itaTotale]").val());	
		var totaleEspositoriPuglia = Number($("input[name=origineEspositori" + step + "_provincePuglia_totalePuglia]").val());
		var totaleEspositori = Number($("input[name=origineEspositori" + step + "_totale]").val());
		var espositori = false;
		
		if(!isNaN(totaleEspositoriPuglia)){
			if(totaleEspositoriPuglia > 0){
				numRegioni -= 1;
			}
		}
		
		if(numRegioni >= 6){
			if((totaleEspositoriNaz - totaleEspositoriPuglia) > (totaleEspositori/2)){
				espositori = true;
			}
		}
		
		var numRegioniVisitatori = Number($("input[name=origineVisitatori" + step + "_numeroRegioni]").val());
		var totaleVisitatoriNaz = Number($("input[name=origineVisitatori" + step + "_italianiTotaleVis]").val());
		var totaleVisitatoriPuglia = Number($("input[name=origineVisitatori" + step + "_numeroVisitatoriPuglia]").val());
		var totaleVisitatori = Number($("input[name=origineVisitatori" + step + "_totaleVisitatori]").val());
		
		var visitatori = false;
		
		if(!isNaN(totaleVisitatoriPuglia)){
			if(totaleVisitatoriPuglia > 0){
				numRegioniVisitatori -= 1;
				
			}
		}
		
		if(numRegioniVisitatori >= 6){
			if((totaleVisitatoriNaz - totaleVisitatoriPuglia) > (totaleVisitatori/2)){
				visitatori = true;
			}
		}
		
		isNazionale = espositori || visitatori;
		
		/* Punto b */
		if(!isNazionale){
			var totaleEspositoriEsteri = Number($("input[name=origineEspositori" + step + "_euroTotale]").val()) + Number($("input[name=origineEspositori" + step + "_extraUeTotale]").val());
			var percent = (totaleEspositori / 100) * 10;  /* 10% */
			if((totaleEspositoriEsteri >= percent) && !(percent === 0)){
				isNazionale = true;
			} else{
				isNazionale = false;
			}
		}
		
		/* Punto c */
		if(!isNazionale){
			var totaleVisitatori = Number($("input[name=origineVisitatori" + step + "_totaleVisitatori]").val());
			var totaleVisitatoriPuglia = Number($("input[name=origineVisitatori" + step + "_numeroVisitatoriPuglia]").val());
			var totaleVisitatoriNoPuglia = totaleVisitatori - totaleVisitatoriPuglia;
			
			var percent = (totaleVisitatori / 100) * 5; /* 5% */
			if((totaleVisitatoriNoPuglia >= percent) && !(percent === 0)){
				isNazionale = true;
			} else{
				isNazionale = false;
			}
		}
		
		if(isNazionale){
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(nazionale);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(nazionale);
			}
		} else {
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(nc);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(nc);
			}
		}
		
		return isNazionale;
	}
	
	function calcolaRegionale(step){
		
		/*  REGIONALE
			a. partecipazione di espositori nella precedente edizione provenienti dalle sei province pugliesi.
		*/
		
		/* Punto a */
		var lecce = Number($("input[name=origineEspositori" + step + "_provincePuglia_lecceTotale]").val());
		var brindisi = Number($("input[name=origineEspositori" + step + "_provincePuglia_brindisiTotale]").val());	
		var taranto = Number($("input[name=origineEspositori" + step + "_provincePuglia_tarantoTotale]").val());
		var bari = Number($("input[name=origineEspositori" + step + "_provincePuglia_bariTotale]").val());
		var bat = Number($("input[name=origineEspositori" + step + "_provincePuglia_batTotale]").val());
		var foggia = Number($("input[name=origineEspositori" + step + "_provincePuglia_foggiaTotale]").val());
		
		var isRegionale = lecce > 0 && brindisi > 0 && taranto > 0 && bari > 0 && bat > 0 && foggia > 0;
		
		if(isRegionale){
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(regionale);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(regionale);
			}
		} else {
			if(step === "Penultimo"){
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaPenultimo'].setValue(nc);
			} else {
				$('.alpaca-form').alpaca('get').childrenByPropertyId['calcolaQualifica'].childrenByPropertyId['qualificaUltimo'].setValue(nc);
			}
		}
		
		return isRegionale;
	}

    Alpaca.Fields.CalcolaTipoEvento = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.CalcolaTipoEvento.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "calcolaTipoEvento";
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
					"calcolaButton": {
        	            "type": "string",
        	            "required": false,
        	            "properties": {}
        	        },
			        "qualificaSelezionata": {
			            "properties": {}
			        },
			        "qualificaCalcolata": {
						"required": false,
			            "properties": {}
			        },
			        "qualificaPenultimo": {
			            "properties": {}
			        },
			        "qualificaUltimo": {
			            "properties": {}
			        }
				}
	       	};
	       	
	       	Alpaca.merge(this.options, {
            	"validate": false,
    			"showMessages": false,
		    	"label": "",
		        "fields": {
					"calcolaButton": {
						"validate": false,
                        "showMessages": false,
                        "fieldClass": "hideInPdf calcolaButton",
                        "type": "label",
                        "label": " <div class='paddingtop20'> <span class='btn btn-primary padding10'><icon class='fa fa-calculator paddingright10'></icon><b>Calcola Qualifica</b></span></div>",
                        "helpers": [],
                        "hidden": true,
                        "disabled": false,
                        "renderButtons": true,
                        "data": {},
                        "attributes": {},
                        "allowOptionalEmpty": true,
                        "autocomplete": false,
                        "disallowEmptySpaces": false,
                        "disallowOnlyEmptySpaces": false,
                        "fields": {},
			            "events": {
							"click": function(){
								this.parent.childrenByPropertyId["qualificaSelezionata"].setValue($("input[name='chkQualifica_qualificaRadioBtn']:checked").val());
								
								var visualizzaPenultimo = $("input[name='visualizzaPenultimo']:checked").val();
								/*var visualizzaUltimo = $("input[name='visualizzaUltimo']:checked").val();*/
								
								/*if(visualizzaPenultimo === "1" && visualizzaUltimo === "1"){*/
								if(visualizzaPenultimo === "1"){
									if(calcolaInternazionale("Ultimo") && calcolaInternazionale("Penultimo")){
										this.parent.childrenByPropertyId["qualificaCalcolata"].setValue(internazionale);
									}else if(calcolaNazionale("Ultimo") && calcolaNazionale("Penultimo")){
										this.parent.childrenByPropertyId["qualificaCalcolata"].setValue(nazionale);
									}else if(calcolaRegionale("Ultimo") && calcolaRegionale("Penultimo")){
										this.parent.childrenByPropertyId["qualificaCalcolata"].setValue(regionale);
									}else {
										this.parent.childrenByPropertyId["qualificaCalcolata"].setValue(nc);
									}
								}else {
									this.parent.childrenByPropertyId["qualificaCalcolata"].setValue(nc);
									this.parent.childrenByPropertyId["qualificaPenultimo"].setValue(nc);
									this.parent.childrenByPropertyId["qualificaUltimo"].setValue(nc);
								}
							}
                        }
                    },
			        "qualificaSelezionata": {
			            "type": "radio",
			            "fieldClass": "text-center",
			            "label": "Tipo di qualifica richiesta",
			            "vertical": false,
			            "hideNone": true,
			            "validate": false,
			            "showMessages": false,
			            "disabled": true,
			            "hidden": false,
			            "helpers": [],
			            "hideInitValidationError": true,
			            "focus": false,
			            "useDataSourceAsEnum": false,
			            "sort": false,
			            "readonly": false,
			            "renderButtons": true,
			            "emptySelectFirst": false,
			            "noneLabel": "None",
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
										if(data[i].descrizione.toLowerCase() === "internazionale"){
											internazionale = data[i].idTipologia
										} else if(data[i].descrizione.toLowerCase() === "nazionale"){
											nazionale = data[i].idTipologia
										} else if(data[i].descrizione.toLowerCase() === "regionale"){
											regionale = data[i].idTipologia
										}
										
										radioEnum.push({'text': data[i].descrizione, 'value': data[i].idTipologia});
					
									}
																	
									callback(radioEnum);
									
								}
							});
						}
			        },
			        "qualificaCalcolata": {
			            "type": "radio",
			            "fieldClass": "text-center",
			            "label": "Tipo qualifica calcolata",
			            "vertical": false,
			            "hideNone": true,
			            "validate": false,
			            "showMessages": false,
			            "disabled": true,
			            "hidden": false,
			            "helpers": [],
			            "hideInitValidationError": true,
			            "focus": false,
			            "useDataSourceAsEnum": false,
			            "sort": false,
			            "readonly": false,
			            "renderButtons": true,
			            "emptySelectFirst": false,
			            "noneLabel": "None",
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
									radioEnum.push({'text': 'Non Determinabile', 'value': 0});
									for(var i= 0; i < data.length; i++){
										radioEnum.push({'text': data[i].descrizione, 'value': data[i].idTipologia});
									}
																	
									callback(radioEnum);
									
								}
							});
						}
			        },
			        "qualificaPenultimo": {
			            "label": "",
			            "type": "number",
			            "disabled": true,
			            "helpers": [],
			            "validate": false,			            
			            "hidden": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}
			        },
			        "qualificaUltimo": {
			            "label": "",
			            "type": "number",
			            "disabled": true,
			            "helpers": [],
			            "validate": false,			            
			            "hidden": true,
			            "showMessages": false,
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
	                "view": "calcolaTipoEvento-view"
	            	
	            });
	            
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getTitle
			 */
	        getTitle: function() {
	            return "Calcolo Tipo Qualifica per fiere";
	        },
	
	        /**
			 * @see Alpaca.Fields.ObjectField#getDescription
			 */
	        getDescription: function() {
	            return "Calcolo Tipo Qualifica per fiere";
	        }
    });
   
    Alpaca.registerView({
	  	"id": "calcolaTipoEvento-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "invalidValueOfEnum": "Effettuare una scelta"
	    },
		"templates": {
			"container": calcolaEventoContainer,
			"container-object": calcolaEventoContainerObject
		}
    });
    Alpaca.registerFieldClass("calcolaTipoEvento", Alpaca.Fields.CalcolaTipoEvento); 
  
    
})(jQuery);