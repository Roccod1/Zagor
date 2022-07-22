var espositoriContainer = ' \
<script type="text/x-handlebars-template"> \
    <div data-custom-field="true" data-custom-field-height="250"> \
        {{#container}}{{/container}} \
    </div> \
</script>';

var espositoriContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
    	<div>\
		  <div class="row">\
		    <div class="col-md-12 paddingleft20">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center"></div>\
		      <div class="col-md-3 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <!-- NAZIONALI -->\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row paddingtop20">\
		    <div class="col-md-3 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row paddingtop20">\
		    <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div>\
		    <div class="col-md-3 text-center">{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <!-- ESPOSITORI PUGLIA -->\
		  <div class="row paddingtop20">\
		    <div class="col-md-12">{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <!-- FINE ESPOSITORI PUGLIA -->\
		  \
		  <!-- ESPOSITORI UE -->\
		  <div class="row paddingtop20">\
		    <div class="col-md-12">{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[30]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <!-- FINE ESPOSITORI UE -->\
		  \
		  <!-- ESPOSITORI EXTRA UE -->\
		  <div class="row paddingtop20">\
		    <div class="col-md-12">{{#with items.[31]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row paddingtop20">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[32]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[33]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[34]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[35]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[36]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[37]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <!-- FINE ESPOSITORI EXTRA UE -->\
		  <!-- CONTATORI HIDDEN -->\
		  <div class="row">\
			<div class="col-md-12">\
				<div class="col-md-2 text-center">{{#with items.[38]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[39]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[40]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[41]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[42]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[43]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[44]}}{{#item}}{{/item}}{{/with}}</div>\
				<div class="col-md-2 text-center">{{#with items.[45]}}{{#item}}{{/item}}{{/with}}</div>\
			</div>\
		  </div>\
		  \
	  </div>\
	</div>\
</script>';

/*
var espositoriContainerObject = ' \
<script type="text/x-handlebars-template"> \
    <div data-disable-interaction-custom-field="true"> \
    	<div>\
		  <div class="row">\
		    <div class="col-md-12 paddingleft20">{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center"></div>\
		      <div class="col-md-3 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <!-- NAZIONALI -->\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <!-- INTESTAZIONI NON CLASSIFICATI -->\
		  <!-- div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-2 text-center"></div>\
		      <div class="col-md-2 text-center">{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-2 text-center">{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-2 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div -->\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  \
		  <!-- ESPOSITORI PUGLIA -->\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		<!-- FINE ESPOSITORI PUGLIA -->\
		\
		<!-- ESPOSITORI UE -->\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[30]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[31]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[32]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[33]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[34]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[35]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[36]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		<!-- FINE ESPOSITORI EXTRA UE -->\
		\
		<!-- ESPOSITORI UE -->\
		  <div class="row">\
		    <div class="col-md-12">{{#with items.[37]}}{{#item}}{{/item}}{{/with}}</div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[38]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[39]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[40]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		  <div class="row">\
		    <div class="col-md-12">\
		      <div class="col-md-3 text-center">{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[41]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[42]}}{{#item}}{{/item}}{{/with}}</div>\
		      <div class="col-md-3 text-center">{{#with items.[43]}}{{#item}}{{/item}}{{/with}}</div>\
		    </div>\
		  </div>\
		<!-- FINE ESPOSITORI EXTRA UE -->\
	  </div>\
	</div>\
</script>';
*/

(function($) {

    var Alpaca = $.alpaca;
  /*  
    var arrayNaz = null;
    var arrayEuro = null;
    var arrayExtra = null;
    */
    /*var totaleDirettiItalia = 0;
	var totaleIndirettiItalia = 0;*/
	var totaleDirettiUe = 0;
	var totaleIndirettiUe = 0;
	var totaleDirettiExtraUe = 0;
	var totaleIndirettiExtraUe = 0;
	
	function arrayNazionaliChange(element){
		
		var nazionali = [];
		var array = element;
		var size = array.getValue().length;
		
		var isPuglia = false;
		var totaleDirettiArray = 0;
		var totaleIndirettiArray = 0;
		var selectRegione = '';
		element.parent.childrenByPropertyId["numeroEspositoriNazionali"].setValue(nazionali.length);
		
		for(var i = 0; i < size; i++){
			
			var regione = null;
			var nDiretti = null;
			var nIndiretti = null;
			var totaleRegione = 0;	
			
			if(array.getValue()[i]){
				
				if(array.getValue()[i].regione){
					regione = array.getValue()[i].regione;
					
					selectRegione = $('select[name=' + element.name + '_'+ i +'_regione]').find('option:selected')[0].label;					
					
					if(selectRegione && selectRegione.toUpperCase() === "PUGLIA"){
						isPuglia = true;
					}
					
				}
				
				if(array.getValue()[i].nDiretti){
					nDiretti = array.getValue()[i].nDiretti;
					if(!isNaN(nDiretti)){
						totaleDirettiArray += Number(nDiretti);
					}
				}
				
				if(array.getValue()[i].nIndiretti){
					nIndiretti = array.getValue()[i].nIndiretti;
					if(!isNaN(nIndiretti)){
						totaleIndirettiArray += Number(nIndiretti); 
					}
				}
				
				if(!isNaN(nDiretti) && !isNaN(nIndiretti)){
					totaleRegione = Number(nDiretti) + Number(nIndiretti);
				}
					
			}
			
			nazionali.push({"regione" : regione, "nDiretti": nDiretti, "nIndiretti": nIndiretti, "totaleRegione": totaleRegione});
			element.parent.childrenByPropertyId["numeroEspositoriNazionali"].setValue(nazionali.length);			
			
		}
		
		if(isPuglia){
			/*element.parent.getContainerEl().find(".provincePuglia").show();
		} else {
			element.parent.getContainerEl().find(".provincePuglia").hide();*/
			
			element.parent.childrenByPropertyId["pugliaDependenciesHandler"].setValue(true);
			element.parent.childrenByPropertyId["pugliaDependenciesHandler"].getFieldEl().change();
		}else {
			element.parent.childrenByPropertyId["pugliaDependenciesHandler"].setValue(false);
			element.parent.childrenByPropertyId["pugliaDependenciesHandler"].getFieldEl().change();
		}
		
		array.setValue(nazionali);
		
		element.parent.childrenByPropertyId["totaleDirettiNazionali"].setValue(totaleDirettiArray);
		element.parent.childrenByPropertyId["totaleIndirettiNazionali"].setValue(totaleIndirettiArray);
		
		/*
		totaleDirettiItalia = totaleDirettiArray;
		totaleIndirettiItalia = totaleIndirettiArray;
		*/
		
		element.parent.childrenByPropertyId["itaDiretti"].setValue(totaleDirettiArray);
		element.parent.childrenByPropertyId["itaIndiretti"].setValue(totaleIndirettiArray);
		element.parent.childrenByPropertyId["itaTotale"].setValue(Number(totaleDirettiArray) + Number(totaleIndirettiArray));
		
		calcolaNcNazionali(element);
		/*
		calcolaTotaliEspositori(element);
		*/
	}
	
	function calcolaTotaliEspositori(element){
		
		var itaDiretti = Number(element.parent.childrenByPropertyId["itaDiretti"].getValue());
		var itaIndiretti = Number(element.parent.childrenByPropertyId["itaIndiretti"].getValue());
		var itaTotale = Number(element.parent.childrenByPropertyId["itaTotale"].getValue());
		
		var euroDiretti = Number(element.parent.childrenByPropertyId["euroDiretti"].getValue());
		var euroIndiretti = Number(element.parent.childrenByPropertyId["euroIndiretti"].getValue());
		var euroTotale = Number(element.parent.childrenByPropertyId["euroTotale"].getValue());
		
		var extraUeDiretti = Number(element.parent.childrenByPropertyId["extraUeDiretti"].getValue());
		var extraUeIndiretti = Number(element.parent.childrenByPropertyId["extraUeIndiretti"].getValue());
		var extraUeTotale = Number(element.parent.childrenByPropertyId["extraUeTotale"].getValue());
		
		element.parent.childrenByPropertyId["totaleDiretti"].setValue(itaDiretti + euroDiretti + extraUeDiretti);
		element.parent.childrenByPropertyId["totaleIndiretti"].setValue(itaIndiretti + euroIndiretti + extraUeIndiretti);
		element.parent.childrenByPropertyId["totale"].setValue(itaTotale + euroTotale + extraUeTotale);
		
	}
	
	function calcolaNcNazionali(element){
		
		/* ALTRO */
		var ncNazDiretti = Number(element.parent.childrenByPropertyId["ncNazDiretti"].getValue());
		var ncNazIndiretti = Number(element.parent.childrenByPropertyId["ncNazIndiretti"].getValue());
		var ncNazTotale = element.parent.childrenByPropertyId["ncNazTotale"];
		
		/* calcolo totale di altro */
		if(!isNaN(ncNazDiretti) && !isNaN(ncNazIndiretti)){
			ncNazTotale.setValue(ncNazDiretti + ncNazIndiretti);
		}
		
		/* aggiorno la tabella di riepilogo */
		var itaDiretti = element.parent.childrenByPropertyId["itaDiretti"];
		var itaIndiretti = element.parent.childrenByPropertyId["itaIndiretti"];
		var itaTotale = element.parent.childrenByPropertyId["itaTotale"];
		
		/* calcolati dall'array */
		var totaleDirettiArray = Number(element.parent.childrenByPropertyId["totaleDirettiNazionali"].getValue());
		var totaleIndirettiArray = Number(element.parent.childrenByPropertyId["totaleIndirettiNazionali"].getValue());		
		
		/* aggiorno riga con i totali dell'array nazionali + altro */
		var totNazDiretti = element.parent.childrenByPropertyId["totNazDiretti"];
		var totNazIndiretti = element.parent.childrenByPropertyId["totNazIndiretti"];
		
		if(!isNaN(ncNazDiretti)){
			totNazDiretti.setValue(totaleDirettiArray + ncNazDiretti);
			itaDiretti.setValue(totaleDirettiArray + ncNazDiretti);
		}
		
		if(!isNaN(ncNazIndiretti)){
			totNazIndiretti.setValue(totaleIndirettiArray + ncNazIndiretti);
			itaIndiretti.setValue(totaleIndirettiArray + ncNazIndiretti);
		}
		
		if(!isNaN(ncNazDiretti) && !isNaN(ncNazIndiretti)){
			itaTotale.setValue(Number(itaDiretti.getValue()) + Number(itaIndiretti.getValue()));
			element.parent.childrenByPropertyId["totNaz"].setValue(Number(totNazDiretti.getValue()) + Number(totNazIndiretti.getValue()));
		}
		
		/* aggiorno i totali della tabella riepilogo */
		calcolaTotaliEspositori(element);
			
	}

	function calcolaTotaleRegione(element){
		
		var lecceDiretti = Number(element.parent.childrenByPropertyId["lecceDiretti"].getValue());
		var lecceIndiretti = Number(element.parent.childrenByPropertyId["lecceIndiretti"].getValue());
		var lecceTotale = element.parent.childrenByPropertyId["lecceTotale"];
		
		var brindisiDiretti = Number(element.parent.childrenByPropertyId["brindisiDiretti"].getValue());
		var brindisiIndiretti = Number(element.parent.childrenByPropertyId["brindisiIndiretti"].getValue());
		var brindisiTotale = element.parent.childrenByPropertyId["brindisiTotale"];
		
		var tarantoDiretti = Number(element.parent.childrenByPropertyId["tarantoDiretti"].getValue());
		var tarantoIndiretti = Number(element.parent.childrenByPropertyId["tarantoIndiretti"].getValue());
		var tarantoTotale = element.parent.childrenByPropertyId["tarantoTotale"];
		
		var bariDiretti = Number(element.parent.childrenByPropertyId["bariDiretti"].getValue());
		var bariIndiretti = Number(element.parent.childrenByPropertyId["bariIndiretti"].getValue());
		var bariTotale = element.parent.childrenByPropertyId["bariTotale"];
		
		var batDiretti = Number(element.parent.childrenByPropertyId["batDiretti"].getValue());
		var batIndiretti = Number(element.parent.childrenByPropertyId["batIndiretti"].getValue());
		var batTotale = element.parent.childrenByPropertyId["batTotale"];
		
		var foggiaDiretti = Number(element.parent.childrenByPropertyId["foggiaDiretti"].getValue());
		var foggiaIndiretti = Number(element.parent.childrenByPropertyId["foggiaIndiretti"].getValue());
		var foggiaTotale = element.parent.childrenByPropertyId["foggiaTotale"];
		
		var totDiretti = element.parent.childrenByPropertyId["totDiretti"];
		var totIndiretti = element.parent.childrenByPropertyId["totIndiretti"];
		var totalePuglia = element.parent.childrenByPropertyId["totalePuglia"];
		
		if(!isNaN(lecceDiretti) && !isNaN(lecceDiretti)){
			lecceTotale.setValue(lecceDiretti + lecceIndiretti);
		}
		if(!isNaN(brindisiDiretti) && !isNaN(brindisiIndiretti)){
			brindisiTotale.setValue(brindisiDiretti + brindisiIndiretti);
		}
		if(!isNaN(tarantoDiretti) && !isNaN(tarantoIndiretti)){
			tarantoTotale.setValue(tarantoDiretti + tarantoIndiretti);
		}
		if(!isNaN(bariDiretti) && !isNaN(bariIndiretti)){
			bariTotale.setValue(bariDiretti + bariIndiretti);
		}
		if(!isNaN(batDiretti) && !isNaN(batIndiretti)){
			batTotale.setValue(batDiretti + batIndiretti);
		}
		if(!isNaN(foggiaDiretti) && !isNaN(foggiaIndiretti)){
			foggiaTotale.setValue(foggiaDiretti + foggiaIndiretti);
		}
		if(!isNaN(lecceDiretti) && !isNaN(brindisiDiretti) && !isNaN(tarantoDiretti) && !isNaN(bariDiretti) && !isNaN(batDiretti) && !isNaN(foggiaDiretti)){
			totDiretti.setValue(lecceDiretti + brindisiDiretti + tarantoDiretti + bariDiretti + batDiretti + foggiaDiretti);
		}
		if(!isNaN(lecceIndiretti) && !isNaN(brindisiIndiretti) && !isNaN(tarantoIndiretti) && !isNaN(bariIndiretti) && !isNaN(batIndiretti) && !isNaN(foggiaIndiretti)){
			totIndiretti.setValue(lecceIndiretti + brindisiIndiretti + tarantoIndiretti + bariIndiretti + batIndiretti + foggiaIndiretti);
		}
		totalePuglia.setValue(Number(totDiretti.getValue()) + Number(totIndiretti.getValue()));
		
	}
	
	function arrayUEChange(element){
		
		var europei = [];
		
		var array = element;
		var size = array.getValue().length;
		element.parent.childrenByPropertyId["numeroEspositoriEuropei"].setValue(europei.length);
		
		var totaleDirettiArray = 0;
		var totaleIndirettiArray = 0;
		
		for(var i = 0; i < size; i++){
			var nazione = '';
			var nDiretti = '';
			var nIndiretti = '';
			var totaleNazione = 0;	
			
			if(array.getValue()[i]){
				
				if(array.getValue()[i].nazione){
					nazione = array.getValue()[i].nazione;
				}
				
				if(array.getValue()[i].nDiretti){
					nDiretti = array.getValue()[i].nDiretti;
					if(!isNaN(nDiretti)){
						totaleDirettiArray  += Number(nDiretti);	
					}
				}
				
				if(array.getValue()[i].nIndiretti){
					nIndiretti = array.getValue()[i].nIndiretti;
					if(!isNaN(nIndiretti)){
						totaleIndirettiArray  += Number(nIndiretti);	
					}
				}
				
				if(!isNaN(nDiretti) && !isNaN(nIndiretti)){
					totaleNazione = Number(nDiretti) + Number(nIndiretti);
				}
					
			}
			
			europei.push({"nazione" : nazione, "nDiretti": nDiretti, "nIndiretti": nIndiretti, "totaleNazione": totaleNazione});
			element.parent.childrenByPropertyId["numeroEspositoriEuropei"].setValue(europei.length);
		}
		
		array.setValue(europei);
		
		
		totaleDirettiUe = Number(totaleDirettiArray);
		totaleIndirettiUe = Number(totaleIndirettiArray);
		/*
		calcolaNcUE(element);
		*/
		
		element.parent.childrenByPropertyId["euroDiretti"].setValue(totaleDirettiArray);
		element.parent.childrenByPropertyId["euroIndiretti"].setValue(totaleIndirettiArray);
		element.parent.childrenByPropertyId["euroTotale"].setValue(Number(totaleDirettiArray) + Number(totaleIndirettiArray));
		calcolaTotaliEspositori(element);
		calcolaNcExtraUE(element);
		
	}
	/*
	function calcolaNcUE(element){
		var euroDiretti = element.parent.childrenByPropertyId["euroDiretti"];
		var euroIndiretti = element.parent.childrenByPropertyId["euroIndiretti"];
		var ncUeDiretti = Number(element.parent.childrenByPropertyId["ncUeDiretti"].getValue());
		var ncUeIndiretti = Number(element.parent.childrenByPropertyId["ncUeIndiretti"].getValue());
		
		var totUeDiretti = element.parent.childrenByPropertyId["totUeDiretti"];
		var totUeIndiretti = element.parent.childrenByPropertyId["totUeIndiretti"];
		if(!isNaN(ncUeDiretti) && !isNaN(ncUeIndiretti)){
			element.parent.childrenByPropertyId["ncUeTotale"].setValue(ncUeDiretti + ncUeIndiretti);
		}
		if(!isNaN(totaleDirettiUe) && !isNaN(ncUeDiretti)){
			totUeDiretti.setValue(totaleDirettiUe + ncUeDiretti);
		}
		if(!isNaN(totaleIndirettiUe) && !isNaN(ncUeIndiretti)){
			totUeIndiretti.setValue(totaleIndirettiUe + ncUeIndiretti);
		}
		if(!isNaN(totUeDiretti.getValue()) && !isNaN(totUeIndiretti.getValue())){
			element.parent.childrenByPropertyId["totUe"].setValue(Number(totUeDiretti.getValue()) + Number(totUeIndiretti.getValue()));
		}
		
		euroDiretti.setValue(totUeDiretti.getValue());
		euroIndiretti.setValue(totUeDiretti.getValue());
		element.parent.childrenByPropertyId["euroTotale"].setValue(Number(totUeDiretti.getValue()) + Number(totUeIndiretti.getValue()));
		
		calcolaTotaliEspositori(element);
	}*/
	
	function arrayExtraUEChange(element){
		
		var extraEuropei = [];
		
		var array = element;
		var size = array.getValue().length;
		
		var totaleDirettiArray = 0;
		var totaleIndirettiArray = 0;
		element.parent.childrenByPropertyId["numeroEspositoriExtraUe"].setValue(extraEuropei.length);
		
		for(var i = 0; i < size; i++){
			var nazione = '';
			var nDiretti = '';
			var nIndiretti = '';
			var totaleNazione = 0;	
			
			if(array.getValue()[i]){
				
				if(array.getValue()[i].nazione){
					nazione = array.getValue()[i].nazione;
				}
				
				if(array.getValue()[i].nDiretti){
					nDiretti = array.getValue()[i].nDiretti;
					if(!isNaN(nDiretti)){
						totaleDirettiArray  += Number(nDiretti);	
					}
				}
				
				if(array.getValue()[i].nIndiretti){
					nIndiretti = array.getValue()[i].nIndiretti;
					if(!isNaN(nIndiretti)){
						totaleIndirettiArray  += Number(nIndiretti);	
					}
				}
				
				if(!isNaN(nDiretti) && !isNaN(nIndiretti)){
					totaleNazione = Number(nDiretti) + Number(nIndiretti);
				}
					
			}
			
			extraEuropei.push({"nazione" : nazione, "nDiretti": nDiretti, "nIndiretti": nIndiretti, "totaleNazione": totaleNazione});
			element.parent.childrenByPropertyId["numeroEspositoriExtraUe"].setValue(extraEuropei.length);
			
		}
		
		/* li utilizzo nel calcolo dei non classificati */
		element.parent.childrenByPropertyId["totaleDirettiExtraUe"].setValue(Number(totaleDirettiArray));
		element.parent.childrenByPropertyId["totaleIndirettiExtraUe"].setValue(Number(totaleIndirettiArray));
		
		array.setValue(extraEuropei);
		
		element.parent.childrenByPropertyId["extraUeDiretti"].setValue(totaleDirettiArray);
		element.parent.childrenByPropertyId["extraUeIndiretti"].setValue(totaleIndirettiArray);
		element.parent.childrenByPropertyId["extraUeTotale"].setValue(Number(totaleDirettiArray) + Number(totaleIndirettiArray));
		
		calcolaTotaliEspositori(element);
		
		calcolaNcExtraUE(element);
		
	}
	
	function calcolaNcExtraUE(element){
		
		/* ALTRO */
		var ncExtraUEDiretti = Number(element.parent.childrenByPropertyId["ncExtraUEDiretti"].getValue());
		var ncExtraUEIndiretti = Number(element.parent.childrenByPropertyId["ncExtraUEIndiretti"].getValue());
	
		var extraUeDiretti = element.parent.childrenByPropertyId["extraUeDiretti"];
		var extraUeIndiretti = element.parent.childrenByPropertyId["extraUeIndiretti"];
				
		if(!isNaN(ncExtraUEDiretti)){
			extraUeDiretti.setValue(Number(element.parent.childrenByPropertyId["totaleDirettiExtraUe"].getValue()) + ncExtraUEDiretti);
		}
		if(!isNaN(ncExtraUEIndiretti)){
			extraUeIndiretti.setValue(Number(element.parent.childrenByPropertyId["totaleIndirettiExtraUe"].getValue()) + ncExtraUEIndiretti);
		}
		
		if(!isNaN(ncExtraUEDiretti) && !isNaN(ncExtraUEIndiretti)){
			element.parent.childrenByPropertyId["extraUeTotale"].setValue(Number(extraUeDiretti.getValue()) + Number(extraUeIndiretti.getValue()));
		}
		
		calcolaTotaliEspositori(element);
		/* fine calcolo 'altro' con aggiornamento degli espositori */
		
		/* totale esteri */
		
		var euroDiretti = Number(element.parent.childrenByPropertyId["euroDiretti"].getValue());
		var euroIndiretti = Number(element.parent.childrenByPropertyId["euroIndiretti"].getValue());
		
		var totNcExtraUEDiretti = element.parent.childrenByPropertyId["totNcExtraUEDiretti"];
		var totNcExtraUEIndiretti = element.parent.childrenByPropertyId["totNcExtraUEIndiretti"];
		
		if(!isNaN(ncExtraUEDiretti)){
			totNcExtraUEDiretti.setValue(euroDiretti + Number(element.parent.childrenByPropertyId["totaleDirettiExtraUe"].getValue()) + ncExtraUEDiretti);
		}
		
		if(!isNaN(ncExtraUEIndiretti)){
			totNcExtraUEIndiretti.setValue(euroIndiretti + Number(element.parent.childrenByPropertyId["totaleIndirettiExtraUe"].getValue()) + ncExtraUEIndiretti);
		}
		
		if(!isNaN(ncExtraUEDiretti) && !isNaN(ncExtraUEIndiretti)){
			element.parent.childrenByPropertyId["ncExtraUETotale"].setValue(ncExtraUEDiretti + ncExtraUEIndiretti);
		}
		
		element.parent.childrenByPropertyId["totExtraUE"].setValue(Number(totNcExtraUEDiretti.getValue()) + Number(totNcExtraUEIndiretti.getValue()));		
		
	}
   
    Alpaca.Fields.NumeroEspositoriFiere = Alpaca.Fields.ObjectField.extend(
    /**
	 * @lends Alpaca.Fields.NumeroEspositoriFiere.prototype
	 */
    {
        /**
		 * @see Alpaca.Fields.ObjectField#getFieldType
		 */
        getFieldType: function() {
            return "numeroEspositoriFiere";
        },

        /**
		 * @private
		 * @see Alpaca.Fields.ObjectField#setup
		 */
        setup: function() {
            this.base();

            this.schema = {
        		 "type": "object",
        		 "dependencies": {
					"provincePuglia" : "pugliaDependenciesHandler",
				 },
                 "properties": {
					"espositoriLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "direttiLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "indirettiLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totaleLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "italianiLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "itaDiretti": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "itaIndiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "itaTotale": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "euroLabel": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "euroDiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "euroIndiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "euroTotale": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "extraUeLabel": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "extraUeDiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "extraUeIndiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "extraUeTotale": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "totaleDiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "totaleIndiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "totale": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "espositoriNazionaliLabel": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "espositoriNaz": {
	                    "readonly": false,
	                    "required": false,
	                    "type": "array",
	                    "minItems": 0,
	                    "items": {
	                        "type": "object",
	                        "properties": {
	                            "regione": {
	                                "title": "Regione",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nDiretti": {
	                                "title": "N&#176; Diretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nIndiretti": {
	                                "title": "N&#176; Indiretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "totaleRegione": {
	                                "title": "Totale",
	                                "pattern": "^\\d+$",
	                                "type": "string"
	                            }
	                        },
	                        "required": false
	                    },
	                    "uniqueItems": false,
	                    "properties": {}
	                },
	                "ncLabel": {
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "ncNazDiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "ncNazIndiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "ncNazTotale": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "properties": {}
	                },
	                "totNazDiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "totNazIndiretti": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "totNaz": {
	                    "type": "string",
	                    "pattern": "^\\d+$",
	                    "properties": {}
	                },
	                "provincePuglia": {
			            "type": "object",
			            "required": false,
			            "properties": {
			                "provinciaLabel": {
                                "type": "string",
			                    "required": false,
			                    "properties": {}
                            },
                            "direttiLabel": {
                                "type": "string",
	                    		"pattern": "^\\d+$",
			                    "required": true,
			                    "properties": {}
                            },
                            "indirettiLabel": {
                                "type": "string",
	                    		"pattern": "^\\d+$",
			                    "required": true,
			                    "properties": {}
                            },
                            "totaleLabel": {
                                "type": "string",
			                    "required": false,
			                    "properties": {}
                            },
                            "lecceLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "lecceDiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "lecceIndiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "lecceTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "brindisiLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "brindisiDiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "brindisiIndiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "brindisiTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "tarantoLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "tarantoDiretti": {
                                "type": "string",
	                    		"pattern": "^\\d+$",
			                    "required": true,
			                    "properties": {}
                            },
                            "tarantoIndiretti": {
                                "type": "string",
	                    		"pattern": "^\\d+$",
			                    "required": true,
			                    "properties": {}
                            },
                            "tarantoTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "bariLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "bariDiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "bariIndiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "bariTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "batLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "batDiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "batIndiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "batTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "foggiaLabel": {
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "foggiaDiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "foggiaIndiretti": {
                                "pattern": "^\\d+$",
                                "type": "string",
			                    "required": true,
			                    "properties": {}
                            },
                            "foggiaTotale": {
                                "type": "string",
			                    "properties": {}
                            },
                            "totDiretti": {
                                "type": "string",
			                    "properties": {}
                            },
                            "totIndiretti": {
                                "type": "string",
			                    "properties": {}
                            },
                            "totalePuglia": {
                                "type": "string",
			                    "properties": {}
                            },
                            "espositoriRegionaliLabel": {
			                    "type": "string",
			                    "required": true,
			                    "properties": {}
			                }                        
			             }
			         },
			         "espositoriUELabel": {
	                    "type": "string",
	                    "required":false,
	                    "properties": {}
	                },
	                "espositoriUE": {
	                    "readonly": false,
	                    "required": false,
	                    "type": "array",
	                    "minItems": 0,
	                    "items": {
	                        "type": "object",
	                        "properties": {
	                            "nazione": {
	                                "title": "Nazione",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nDiretti": {
	                                "title": "N&#176; Diretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nIndiretti": {
	                                "title": "N&#176; Indiretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "totaleNazione": {
	                                "title": "Totale",
	                                "type": "string"
	                            }
	                        },
	                        "required": false
	                    },
	                    "uniqueItems": false,
	                    "properties": {}
	                },/*
	                "ncUeDiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "ncUeIndiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": true,
	                    "properties": {}
	                },
	                "ncUeTotale": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totUeDiretti": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totUeIndiretti": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totUe": {
	                    "type": "string",
	                    "properties": {}
	                },*/
	                "espositoriExtraUE": {
	                    "readonly": false,
	                    "required": false,
	                    "type": "array",
	                    "minItems": 0,
	                    "items": {
	                        "type": "object",
	                        "properties": {
	                            "nazione": {
	                                "title": "Nazione",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nDiretti": {
	                                "title": "N&#176; Diretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "nIndiretti": {
	                                "title": "N&#176; Indiretti",
	                                "pattern": "^\\d+$",
	                                "type": "string",
	                                "required": true
	                            },
	                            "totaleNazione": {
	                                "title": "Totale",
	                                "type": "string"
	                            }
	                        },
	                        "required": false
	                    },
	                    "uniqueItems": false,
	                    "properties": {}
	                },
	                "ncExtraUEDiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "ncExtraUEIndiretti": {
	                    "pattern": "^\\d+$",
	                    "type": "string",
	                    "required": false,
	                    "properties": {}
	                },
	                "ncExtraUETotale": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totNcExtraUEDiretti": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totNcExtraUEIndiretti": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totExtraUE": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "numeroEspositoriNazionali": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "numeroEspositoriEuropei": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "numeroEspositoriExtraUe": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "pugliaDependenciesHandler": {
			            "properties": {}
			        },
	                "totaleDirettiExtraUe": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totaleIndirettiExtraUe": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totaleDirettiNazionali": {
	                    "type": "string",
	                    "properties": {}
	                },
	                "totaleIndirettiNazionali": {
	                    "type": "string",
	                    "properties": {}
	                }
                 }
            };
            
            Alpaca.merge(this.options, {
            	"validate": false,
	            "showMessages": false,
                "fields": {
                    "espositoriLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "direttiLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "indirettiLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "totaleLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "italianiLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "itaDiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "itaIndiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "itaTotale": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "euroLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "euroDiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "euroIndiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "euroTotale": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "extraUeLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": true,
	                    "hidden": false,
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
	                "extraUeDiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "extraUeIndiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "extraUeTotale": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "totaleDiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "totaleIndiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "totale": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}/*,
			            "events":{
							"ready":  function(){
								this.setValue(0);
							}
						}*/
	                },
	                "espositoriNazionaliLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
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
	                "espositoriNaz": {
	                    "type": "array",
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "readonly": false,
	                    "actionbarStyle": "bottom",
	                    "hideToolbarWithChildren": false,
	                    "toolbarSticky": true,
	                    "hideActionbar": false,
	                    "hideToolbar": false,
	                    "toolbar": {
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": true,
	                                "label": "Aggiungi"
	                            }
	                        ]
	                    },
	                    "actionbar": {
	                        "showLabels": true,
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": false
	                            },
	                            {
	                                "action": "remove",
	                                "label": "Rimuovi",
	                                "click": function(key, action, itemIndex) {
										var selfArr = this;
					                    this.handleActionBarRemoveItemClick(itemIndex, function() {
										
					                        arrayNazionaliChange(selfArr); //triggero il change. Altrimenti con 0 elementi non triggera.
					                        $(".calcolaButton").click();		
					                         
				                    	})
                					}
	                            },
	                            {
	                                "action": "up",
	                                "label": " "
	                            },
	                            {
	                                "action": "down",
	                                "label": " "
	                            }
	                        ]
	                    },
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "lazyLoading": false,
	                    "collapsible": false,
	                    "collapsed": false,
	                    "legendStyle": "button",
	                    "animate": true,
	                    "sort": false,
	                    "view":{
							"messages": {
						        "notOptional": "Campo obbligatorio.",
						        "stringNotANumber": "Inserire un valore numerico intero",
						        "invalidPattern": "Inserire un valore numerico intero",
						        "notEnoughItems": "Inserire almeno una regione"
						    },
							"templates": {
				                "container": "<div class='noPadding'><div><b>{{options.label}}</b>{{#container}}{{/container}}</div></div>",
				                "container-object": "<div><div class='row'>{{#each items}}<div class='col-md-3'>{{#item}}{{/item}}</div>{{/each}}</div></div>"
				            }
						},
	                    "items": {
							"events":{
								"change": function(){
									arrayNazionaliChange(this.parent);
									$(".calcolaButton").click();		
								}
							},
	                        "fields": {
								"regione": {
									"fieldClass" : "select2ac1 notSelect2",
									"type": "select",
									"validate": true,
			                        "showMessages": true,
			                        "disabled": false,
			                        "hidden": false,
			                        "helpers": [],
			                        "hideInitValidationError": true,
			                        "focus": false,
			                        "optionLabels": [], 
			                        "removeDefaultNone": false,
			                        "noneLabel": "-- Seleziona --",
			                        "hideNone": false,
			                        "useDataSourceAsEnum": false,
			                        "multiple": false, 
			                        "multiselect": {
			                            "disableIfEmpty": true
			                        },
			                        "sort": false,
			                        "renderButtons": true,
			                        "fields": {},
									"dataSource": function(callback) {
										$.ajax({
						                	url: getAllRegioniFiereUrl,
						                    dataType: 'json',
						                    delay: 0,
						                    timeout: 20000,
						                    error: function (err) {
						                    	console.log("error", err);
						                    	callback([]);
				                            },
				                            success: function (data) {
				                            	callback(data);
				                            }
						                });
			                        }
	                            },
	                            "nDiretti": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "nIndiretti": {"type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "totaleRegione": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": false,
			                        "showMessages": false,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": true
	                            }
	                    	},
		                    "rubyrails": false,
		                    "toolbarStyle": "button"
	                    
						},
	                    
	                },
	                "ncLabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
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
	                "ncNazDiretti": {
	                    "label": "",
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcNazionali(this);
								$(".calcolaButton").click();
							}
						}
	                },
	                "ncNazIndiretti": {
	                    "label": "",
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcNazionali(this);5
								$(".calcolaButton").click();
							}
						}
	                },
	                "ncNazTotale": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totNazDiretti": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totNazIndiretti": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totNaz": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "provincePuglia": {
						"dependencies": {
			                "pugliaDependenciesHandler": "true"
			            },
						"fieldClass": "provincePuglia",
			            "type": "object",
			            "helpers": [],
			            "validate": false,
			            "disabled": false,
			            "showMessages": false,
			            "collapsible": false,
			            "legendStyle": "button",
			            "view":{
							"messages": {
						        "notOptional": "Campo obbligatorio.",
						        "stringNotANumber": "Inserire un valore numerico intero",
						        "invalidPattern": "Inserire un valore numerico intero"
						    },
							"templates": {
				                "container": "<div class='noPadding'>{{#container}}{{/container}}</div>",
				                "container-object": "<div>\
													  <div class='row'>\
													    <div class='col-md-12 paddingleft20'>{{#with items.[31]}}{{#item}}{{/item}}{{/with}}</div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div>\
														  <div class='col-md-3 text-center'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div>\
														  <div class='col-md-3 text-center'>{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[9]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[10]}}{{#item}}{{/item}}{{/with}}</div>\
														  <div class='col-md-3 text-center'>{{#with items.[11]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[12]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[13]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[14]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[15]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[16]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[17]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[18]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[19]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[20]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[21]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[22]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[23]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													  <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[24]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[25]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[26]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[27]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													   <div class='row'>\
													    <div class='col-md-12'>\
													      <div class='col-md-3 text-center'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[28]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[29]}}{{#item}}{{/item}}{{/with}}</div>\
													      <div class='col-md-3 text-center'>{{#with items.[30]}}{{#item}}{{/item}}{{/with}}</div>\
													    </div>\
													  </div>\
													<div>"
				            }
						},
			            "fields": {
			                "provinciaLabel": {
							    "type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 1
							},
							"direttiLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 2,
								"fields": {}
							},
							"indirettiLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 3,
								"fields": {}
							},
							"totaleLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 4,
								"fields": {}
							},
							"lecceLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 5,
								"fields": {}
							},
							"lecceDiretti": {
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
								"order": 6,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"lecceIndiretti": {
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
								"order": 7,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"lecceTotale": {
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
								"order": 8,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"brindisiLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 9,
								"fields": {}
							},
							"brindisiDiretti": {
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
								"order": 10,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"brindisiIndiretti": {
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
								"order": 11,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"brindisiTotale": {
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
								"order": 12,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"tarantoLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 13,
								"fields": {}
							},
							"tarantoDiretti": {
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
								"order": 14,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"tarantoIndiretti": {
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
								"order": 15,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {},
							},
							"tarantoTotale": {
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
								"order": 16,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"bariLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": true,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 17,
								"fields": {}
							},
							"bariDiretti": {
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
								"order": 18,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"bariIndiretti": {
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
								"order": 19,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"bariTotale": {
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
								"order": 20,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"batLabel": {
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 21,
								"fields": {}
							},
							"batDiretti": {
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
								"order": 22,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
									}
								},
								"fields": {}
							},
							"batIndiretti": {
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
								"order": 23,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"batTotale": {
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
								"order": 24,
								"fieldClass": "",
								"fields": {}
							},
							"foggiaLabel": {
								"type": "text",
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
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
			                    "view": "bootstrap-display",
								"order": 25,
								"fields": {}
							},
							"foggiaDiretti": {
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
								"order": 26,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"foggiaIndiretti": {
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
								"order": 27,
								"fieldClass": "",
								"events": {
									"change": function(){
										calcolaTotaleRegione(this);
										$(".calcolaButton").click();
									}
								},
								"fields": {}
							},
							"foggiaTotale": {
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
								"order": 28,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"totDiretti": {
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
								"order": 29,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"totIndiretti": {
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
								"order": 30,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"totalePuglia": {
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
								"order": 31,
								"fieldClass": "",
								"events": {},
								"fields": {}
							},
							"espositoriRegionaliLabel": {
			                    "type": "text",
			                    "order": 31,
			                    "validate": false,
			                    "showMessages": false,
			                    "disabled": false,
			                    "hidden": false,
			                    "order": 32,
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
			            }
			        },
			        "espositoriUELabel": {
	                    "type": "text",
	                    "validate": false,
	                    "showMessages": false,
	                    "disabled": false,
	                    "hidden": false,
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
	                "espositoriUE": {
	                    "type": "array",
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "readonly": false,
	                    "actionbarStyle": "bottom",
	                    "hideToolbarWithChildren": false,
	                    "toolbarSticky": true,
	                    "hideActionbar": false,
	                    "hideToolbar": false,
	                    "toolbar": {
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": true,
	                                "label": "Aggiungi"
	                            }
	                        ]
	                    },
	                    "actionbar": {
	                        "showLabels": true,
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": false
	                            },
	                            {
	                                "action": "remove",
	                                "label": "Rimuovi",
	                                "click": function(key, action, itemIndex) {
										var selfArr = this;
					                    this.handleActionBarRemoveItemClick(itemIndex, function() {
										
					                        arrayUEChange(selfArr); //triggero il change. Altrimenti con 0 elementi non triggera.
											$(".calcolaButton").click();
					                         
				                    	})
                					}
	                            },
	                            {
	                                "action": "up",
	                                "label": " "
	                            },
	                            {
	                                "action": "down",
	                                "label": " "
	                            }
	                        ]
	                    },
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "lazyLoading": false,
	                    "collapsible": false,
	                    "collapsed": false,
	                    "legendStyle": "button",
	                    "animate": true,
	                    "sort": false,
	                    "view":{
							"messages": {
						        "notOptional": "Campo obbligatorio.",
						        "stringNotANumber": "Inserire un valore numerico intero",
						        "invalidPattern": "Inserire un valore numerico intero",
						        "notEnoughItems": "Inserire almeno una nazione"
						    },
							"templates": {
				                "container": "<div class='noPadding'><div><b>{{options.label}}</b>{{#container}}{{/container}}</div></div>",
				                "container-object": "<div><div class='row'>{{#each items}}<div class='col-md-3'>{{#item}}{{/item}}</div>{{/each}}</div></div>"
				            }
						},
	                    "items": {
		                    "events":{
								"change": function(){
									arrayUEChange(this.parent);
									$(".calcolaButton").click();								
								}
							},
	                        "fields": {
	                        	"nazione": {
									"fieldClass" : "select2ac1 notSelect2",
									"type": "select",
									"validate": true,
			                        "showMessages": true,
			                        "disabled": false,
			                        "hidden": false,
			                        "helpers": [],
			                        "hideInitValidationError": true,
			                        "focus": false,
			                        "optionLabels": [], 
			                        "removeDefaultNone": false,
			                        "noneLabel": "-- Seleziona --",
			                        "hideNone": false,
			                        "useDataSourceAsEnum": false,
			                        "multiple": false, 
			                        "multiselect": {
			                            "disableIfEmpty": true
			                        },
			                        "sort": false,
			                        "renderButtons": true,
			                        "fields": {},
									"dataSource": function(callback) {
										$.ajax({
						                	url: getAllNazioniFiereUrl + "?area=EU",
						                    dataType: 'json',
						                    delay: 0,
						                    timeout: 20000,
						                    error: function (err) {
						                    	console.log("error", err);
						                    	callback([]);
				                            },
				                            success: function (data) {
				                            	callback(data);
				                            }
						                });
			                        }
	                            },
	                            "nDiretti": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "nIndiretti": {"type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "totaleNazione": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": false,
			                        "showMessages": false,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": true
	                            }
	                    	},
		                    "rubyrails": false,
		                    "toolbarStyle": "button"
						}
					},/*
	                "ncUeDiretti": {
	                    "label": "",
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcUE(this);
							}
						}
	                },
	                "ncUeIndiretti": {
	                    "label": "",
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcUE(this);
							}
						}
	                },
	                "ncUeTotale": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totUeDiretti": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totUeIndiretti": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totUe": {
	                    "label": "",
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}
	                },*/
	                "espositoriExtraUE": {
	                    "type": "array",
	                    "validate": true,
	                    "showMessages": true,
	                    "disabled": false,
	                    "readonly": false,
	                    "actionbarStyle": "bottom",
	                    "hideToolbarWithChildren": false,
	                    "toolbarSticky": true,
	                    "hideActionbar": false,
	                    "hideToolbar": false,
	                    "toolbar": {
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": true,
	                                "label": "Aggiungi"
	                            }
	                        ]
	                    },
	                    "actionbar": {
	                        "showLabels": true,
	                        "actions": [
	                            {
	                                "action": "add",
	                                "enabled": false
	                            },
	                            {
	                                "action": "remove",
	                                "label": "Rimuovi",
	                                "click": function(key, action, itemIndex) {
										var selfArr = this;
					                    this.handleActionBarRemoveItemClick(itemIndex, function() {
										
					                        arrayExtraUEChange(selfArr); //triggero il change. Altrimenti con 0 elementi non triggera.
											$(".calcolaButton").click();
					                         
				                    	})
                					}
	                            },
	                            {
	                                "action": "up",
	                                "label": " "
	                            },
	                            {
	                                "action": "down",
	                                "label": " "
	                            }
	                        ]
	                    },
	                    "hidden": false,
	                    "helpers": [],
	                    "hideInitValidationError": false,
	                    "focus": false,
	                    "optionLabels": [],
	                    "lazyLoading": false,
	                    "collapsible": false,
	                    "collapsed": false,
	                    "legendStyle": "button",
	                    "animate": true,
	                    "sort": false,
	                    "view":{
							"messages": {
						        "notOptional": "Campo obbligatorio.",
						        "stringNotANumber": "Inserire un valore numerico intero",
						        "invalidPattern": "Inserire un valore numerico intero",
						        "notEnoughItems": "Inserire almeno una nazione"
						    },
							"templates": {
				                "container": "<div class='noPadding'><div><b>{{options.label}}</b>{{#container}}{{/container}}</div></div>",
				                "container-object": "<div><div class='row'>{{#each items}}<div class='col-md-3'>{{#item}}{{/item}}</div>{{/each}}</div></div>"
				            }
						},
	                    "items": {
							"events":{
								"change": function(){
									arrayExtraUEChange(this.parent);
									$(".calcolaButton").click();								
								}
							},
	                        "fields": {
		                        "nazione": {
									"fieldClass" : "select2ac1 notSelect2",
									"type": "select",
									"validate": true,
			                        "showMessages": true,
			                        "disabled": false,
			                        "hidden": false,
			                        "helpers": [],
			                        "hideInitValidationError": true,
			                        "focus": false,
			                        "optionLabels": [], 
			                        "removeDefaultNone": false,
			                        "noneLabel": "-- Seleziona --",
			                        "hideNone": false,
			                        "useDataSourceAsEnum": false,
			                        "multiple": false, 
			                        "multiselect": {
			                            "disableIfEmpty": true
			                        },
			                        "sort": false,
			                        "renderButtons": true,
			                        "fields": {},
									"dataSource": function(callback) {
										$.ajax({
						                	url: getAllNazioniFiereUrl + "?area=EXTRA_EU",
						                    dataType: 'json',
						                    delay: 0,
						                    timeout: 20000,
						                    error: function (err) {
						                    	console.log("error", err);
						                    	callback([]);
				                            },
				                            success: function (data) {
				                            	callback(data);
				                            }
						                });
			                        }
	                            },
	                            "nDiretti": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "nIndiretti": {"type": "text",
			                        "helpers": [],
			                        "validate": true,
			                        "showMessages": true,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": false
	                            },
	                            "totaleNazione": {
	                                "type": "text",
			                        "helpers": [],
			                        "validate": false,
			                        "showMessages": false,
			                        "collapsible": false,
			                        "legendStyle": "button",
			                        "disabled": true
	                            }
		                    },
		                    "rubyrails": false,
		                    "toolbarStyle": "button"
						}						
	                },
	                "ncExtraUEDiretti": {
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcExtraUE(this);  
								$(".calcolaButton").click();
							}
						}
	                },
	                "ncExtraUEIndiretti": {
			            "type": "text",
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
			            "fields": {},
			            "events": {
							"change": function() {
								calcolaNcExtraUE(this);  
								$(".calcolaButton").click();
							}
						}
	                },
	                "ncExtraUETotale": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totNcExtraUEDiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totNcExtraUEIndiretti": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "totExtraUE": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "disabled": true,
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
	                "numeroEspositoriNazionali": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "hidden": true,
			            "showMessages": false,
			            "renderButtons": true,
			            "data": {},
			            "attributes": {},
			            "disabled": true,
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}
	                },
	                "numeroEspositoriEuropei": {
			            "type": "text",
			            "helpers": [],
			            "validate": false,
			            "hidden": true,
			            "showMessages": false,
			            "renderButtons": true,			            
			            "disabled": true,
			            "data": {},
			            "attributes": {},
			            "allowOptionalEmpty": true,
			            "autocomplete": false,
			            "disallowEmptySpaces": false,
			            "disallowOnlyEmptySpaces": false,
			            "fields": {}
	                },
	                "numeroEspositoriExtraUe": {
			            "type": "text",
			            "helpers": [],
			            "disabled": true,
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
	                "pugliaDependenciesHandler": {
						"type": "checkbox",
			            "disabled": true,
			            "fieldClass": "hideInPdf noShow"
			        },
	                "totaleDirettiExtraUe": {
	                    "type": "text",
			            "helpers": [],
			            "disabled": true,
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
	                "totaleIndirettiExtraUe": {
	                    "type": "text",
			            "helpers": [],
			            "disabled": true,
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
	                "totaleDirettiNazionali": {
	                    "type": "text",
			            "helpers": [],
			            "disabled": true,
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
	                "totaleIndirettiNazionali": {
	                    "type": "text",
			            "helpers": [],
			            "disabled": true,
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
                "view": "numeroEspositoriFiere-view"
            	
            });
            
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getTitle
		 */
        getTitle: function() {
            return "Numero Espositori per Scheda Fiere";
        },

        /**
		 * @see Alpaca.Fields.ObjectField#getDescription
		 */
        getDescription: function() {
            return "I totali sono calcolati automaticamente";
        }
    });
   
    Alpaca.registerView({
	  	"id": "numeroEspositoriFiere-view",
	  	"parent": "bootstrap-create",
	  	"messages": {
	        "notOptional": "Campo obbligatorio.",
	        "stringNotANumber": "Inserire un valore numerico intero",
	        "invalidPattern": "Inserire un valore numerico intero"
	    },
		"templates": {
			"container": espositoriContainer,
			"container-object": espositoriContainerObject
		}
    });
    Alpaca.registerFieldClass("numeroEspositoriFiere", Alpaca.Fields.NumeroEspositoriFiere); 
  
    
})(jQuery);