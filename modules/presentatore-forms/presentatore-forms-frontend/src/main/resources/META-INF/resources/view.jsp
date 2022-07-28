<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="presentatoreforms.caption"/></b>
</p>


<div class="row-fluid">
	<div class="span12 formpresenter-portlet nuova-istanza">
				<div id="formIscrizione"></div>
	</div>
</div>

<script type="text/javascript">

console.log("starting the jsp script");

var logoInpsInnerUrl = '${pageContext.request.contextPath}' + '/images/INPS_logo.svg';
var cfLoggedUser='${sessionScope.userPreferences.codiceFiscaleServizio}';
var userToken = '${userToken}';
var listaProvinceUrl = '${getProvinceUrl}';
var listaComuniUrl = '${getComuniByProvinciaUrl}';
var listaYearsUrl = '${getYearsUrl}';
var listaFiveYearsUrl = '${getFiveYearsUrl}';
var listaTitoliStudioUrl = '${getTitoliStudioUrl}';
var listaRelazioniParentelaUrl = '${getRelazioniParentelaUrl}';
var listaStatiCiviliUrl = '${getStatiCiviliUrl}';
var listaStatiEsteriUrl = '${getStatiEsteriUrl}';
var listaUsoBolloUrl = '${getUsoBolloUrl}';
var listaComuniEsteriUrl = '${searchListaComuniEsteriSelUrl}';
var listaStradarioUrl = '${searchStradarioUrl}';

var listaScuoleByComuneUrl = '${COMPLETEAPIALPACAPATH}' + '/getListaScuoleByCodiceIpaAndCodiceServizioAndAnnoScolastico?codiceIpa=${codiceIpaEnte}&codiceServizio=${codiceServizio}';
var infoScuolaByIdUrl = '${COMPLETEAPIALPACAPATH}' + '/getScuolaById?id=';
var infoScuolaBacinoByIdUrl = '${COMPLETEAPIALPACAPATH}' + '/getScuolaBacinoById?codiceIpa=${codiceIpaEnte}&id=';

var numeroMaxScuoleAlternativeUrl = '${COMPLETEAPIALPACAPATH}' + '/getConfigurazioneMaxScuoleAlternativeByCodiceIpaAndCodiceServizio?codiceIpa=' + '${codiceIpaEnte}&codiceServizio=' + '${codiceServizio}';

var listaDichiarazioniFormScolasticiUrl = '${COMPLETEAPIALPACAPATH}' + '/dichiarazioni?&attivo=1&codiceIpa=' + '${codiceIpaEnte}&codiceServizio=' + '${codiceServizio}';
var listaCriteriScolasticiUrl = '${COMPLETEAPIALPACAPATH}' + '/criteri?&attivo=1&codiceIpa=${codiceIpaEnte}&codiceServizio=${codiceServizio}';
var listaNucleoFamigliareUrl = '${COMPLETEAPIALPACAPATH}' + '/getComponentiNucleoFamiliare?codiceFiscale=' + '${sessionScope.userPreferences.codiceFiscaleServizio}&codiceIpa=' + '${codiceIpaEnte}&codiceServizio=' + '${codiceServizio}'
var componenteNucleoFamigliareUrl = '${COMPLETEAPIALPACAPATH}' + '/getComponenteNucleoFamiliare?cfRichiedente=' + '${sessionScope.userPreferences.codiceFiscaleServizio}&codiceIpa='+ '${codiceIpaEnte}' + '&codiceFiscale=';
var elencoMinoriUrl = '${COMPLETEAPIALPACAPATH}' + '/getMinoriIscrivibiliServizio' + '?cfRichiedente=${sessionScope.userPreferences.codiceFiscaleServizio}&codiceIpa=${codiceIpaEnte}&codiceServizio=${codiceServizio}';
var sogliaIseeUrl = '${COMPLETEAPIALPACAPATH}' + '/getConfigurazioneSogliaIsee?codiceIpa=' + '${codiceIpaEnte}&codiceServizio=${codiceServizio}';
var inpsIseeUrl = '${COMPLETEAPIALPACAPATH}' + '/getIseeFromInps?codiceIpa=' + '${codiceIpaEnte}&codiceServizio=${codiceServizio}&cfRichiedente=' + cfLoggedUser;
var checkResidenteUrl = '${COMPLETEAPIALPACAPATH}' + '/getCheckResidente?cfRichiedente=' + '${sessionScope.userPreferences.codiceFiscaleServizio}&codiceIpa=' + '${codiceIpaEnte}&codiceServizio=' + '${codiceServizio}';
var sendMailCodiceViaMancanteUrl = '${COMPLETEAPIALPACAPATH}' + '/sendMailCodiceViaMancante?cfRichiedente=' + '${sessionScope.userPreferences.codiceFiscaleServizio}&codiceIpa=' + '${codiceIpaEnte}';
var listaScuoleBRgByComuneUrl = '${COMPLETEAPIALPACAPATH}' + '/getListaScuoleBRgByCodiceIpaAndCodiceServizio?codiceIpa=' + '${codiceIpaEnte}' + '&codiceServizio=' + '${codiceServizio}' + '&cfRichiedente=${sessionScope.userPreferences.codiceFiscaleServizio}';
var listaScuoleFBcByComuneUrl = '${COMPLETEAPIALPACAPATH}' + '/getListaScuoleFBcByCodiceIpaAndCodiceServizio?codiceIpa=' + '${codiceIpaEnte}' + '&codiceServizio=' + '${codiceServizio}' + '&cfRichiedente=${sessionScope.userPreferences.codiceFiscaleServizio}';
var listaScuolePegComuneUrl = '${COMPLETEAPIALPACAPATH}' + '/getListaScuolePegByCodiceIpaAndCodiceServizio?codiceIpa=' + '${codiceIpaEnte}' + '&codiceServizio=' + '${codiceServizio}' + '&cfRichiedente=${sessionScope.userPreferences.codiceFiscaleServizio}';
var checkAttivazioneBaciniUrl = '${COMPLETEAPIALPACAPATH}' + '/getCheckAttivazioneBacini?codiceIpa=' + '${codiceIpaEnte}&codiceServizio=' + '${codiceServizio}';

/* Custom Fields JSON vars */
var statiEsteriJsonCF = [];
var provinceJsonCF = [];
var statiCiviliJsonCF = [];
var relazioniParentelaJsonCF = [];

/* NOMINATIM OPENSTREETMAP*/
var getAddressByCoordsUrl = 'https://nominatim.openstreetmap.org/reverse.php?format=json&zoom=16';
var getCoordsByAddressUrl = 'https://nominatim.openstreetmap.org/search.php?format=json&limit=1&bounded=1&q=';
setTimeout(mainScript, 3000);

function mainScript() {
	console.log("timeout over in the jsp script");

	<!--***TODO aggiornare i seguenti valori una volta che avremo il model completo da backend***-->
	
	var alpacaStructure = {
		    "schema": {
		        "type": "object",
		        "title": "",
		        "required": false,
		        "description": "",
		        "properties": {
		            "titolo": {
		                "type": "string",
		                "required": false,
		                "properties": {}
		            },
		            "sottoscrittoPdf": {
		                "type": "string",
		                "title": "",
		                "required": false,
		                "properties": {}
		            },
		            "riepilogo": {
		                "type": "object",
		                "properties": {
		                    "nome": {
		                        "title": "Nome",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "cognome": {
		                        "title": "Cognome",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "codiceFiscale": {
		                        "title": "Cod.Fiscale",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "dataNascita": {
		                        "title": "Data di nascita",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "luogoNascita": {
		                        "title": "Luogo di nascita",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "indirizzoResidenza": {
		                        "title": "Indirizzo Residenza",
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "viaHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "civicoHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "esponenteHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "scalaHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "pianoHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "internoHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "capHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "provinciaResHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "comuneResHidden": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "identificativo": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "identificativoFamiglia": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    }
		                },
		                "required": false
		            },
		            "objectDocumento": {
		                "type": "object",
		                "required": false,
		                "properties": {
		                    "tipo": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "numero": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "rilasciatoDa": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "dataRilascio": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "dataScadenza": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    }
		                }
		            },
		            "dichiarazionePdf": {
		                "type": "string",
		                "readonly": false,
		                "required": false,
		                "properties": {}
		            },
		            "objectDelegato": {
		                "type": "object",
		                "required": false,
		                "properties": {
		                    "cognome": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "nome": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "labelNatoA": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "provenienzaNascita": {
		                        "title": "",
		                        "description": "",
		                        "type": "object",
		                        "required": false,
		                        "properties": {
		                            "nazioni": {
		                                "type": "object",
		                                "properties": {
		                                    "stati": {
		                                        "default": "100",
		                                        "required": false,
		                                        "properties": {}
		                                    }
		                                }
		                            },
		                            "provinciaComune": {
		                                "type": "object",
		                                "properties": {
		                                    "provincia": {
		                                        "required": true,
		                                        "default": "",
		                                        "properties": {}
		                                    },
		                                    "comune": {
		                                        "required": true,
		                                        "enum": [],
		                                        "properties": {}
		                                    }
		                                }
		                            },
		                            "comuneEstero": {
		                                "required": true,
		                                "properties": {}
		                            }
		                        }
		                    },
		                    "datanascita": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "codicefiscale": {
		                        "type": "string",
		                        "minLength": 16,
		                        "maxLength": 16,
		                        "required": true,
		                        "properties": {}
		                    },
		                    "labelResidenza": {
		                        "type": "string",
		                        "required": false,
		                        "properties": {}
		                    },
		                    "luogoResidenza": {
		                        "type": "object",
		                        "properties": {
		                            "provincia": {
		                                "required": true,
		                                "default": "",
		                                "properties": {}
		                            },
		                            "comune": {
		                                "required": true,
		                                "enum": [],
		                                "properties": {}
		                            }
		                        },
		                        "required": false
		                    },
		                    "indirizzoCompleto": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    }
		                }
		            },
		            "objectDocumentoDelegato": {
		                "type": "object",
		                "required": false,
		                "properties": {
		                    "tipo": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "numero": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "rilasciatoDa": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "dataRilascio": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    },
		                    "dataScadenza": {
		                        "type": "string",
		                        "required": true,
		                        "properties": {}
		                    }
		                }
		            },
		            "dichiarazioneFinale": {
		                "type": "string",
		                "required": false,
		                "properties": {}
		            },
		            "radioPrivacy": {
		                "required": true,
		                "enum": [
		                    "PRESTA_CONSENSO",
		                    "NEGA_CONSENSO"
		                ],
		                "disallow": [
		                    "NEGA_CONSENSO"
		                ],
		                "properties": {}
		            },
		            "fineDichiarazione": {
		                "type": "string",
		                "required": false,
		                "properties": {}
		            }
		        }
		    },
		    "options": {
		        "type": "object",
		        "focus": false,
		        "label": "",
		        "hideInitValidationError": true,
		        "helpers": [],
		        "disabled": false,
		        "validate": true,
		        "collapsible": false,
		        "legendStyle": "button",
		        "showMessages": true,
		        "helpersPosition": "below",
		        "fields": {
		            "titolo": {
		                "type": "label",
		                "validate": false,
		                "showMessages": true,
		                "disabled": false,
		                "hidden": false,
		                "label": "MODULO DI DELEGA PER IL RITIRO DI ATTREZZATURE PORTA A PORTA",
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
		                "sort": false,
		                "renderButtons": true,
		                "attributes": {},
		                "fields": {}
		            },
		            "sottoscrittoPdf": {
		                "data": {},
		                "type": "text",
		                "label": "",
		                "helpers": [],
		                "disabled": true,
		                "hidden": false,
		                "validate": true,
		                "attributes": {},
		                "autocomplete": false,
		                "showMessages": true,
		                "renderButtons": true,
		                "allowOptionalEmpty": true,
		                "disallowEmptySpaces": false,
		                "disallowOnlyEmptySpaces": false,
		                "view": "bootstrap-display",
		                "order": 2,
		                "fields": {}
		            },
		            "riepilogo": {
		                "type": "datiAngraficiCustomTwoCol",
		                "view": "datiAngraficiCustomTwoCol-view",
		                "label": "",
		                "order": 3,
		                "helpers": [],
		                "disabled": false,
		                "validate": true,
		                "collapsible": false,
		                "legendStyle": "button",
		                "showMessages": true,
		                "fields": {
		                    "nome": {
		                        "data": {},
		                        "type": "text",
		                        "label": "Nome",
		                        "helpers": [],
		                        "disabled": true,
		                        "validate": true,
		                        "attributes": {},
		                        "autocomplete": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {}
		                    },
		                    "cognome": {
		                        "data": {},
		                        "type": "text",
		                        "label": "Cognome",
		                        "helpers": [],
		                        "disabled": true,
		                        "validate": true,
		                        "attributes": {},
		                        "autocomplete": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {}
		                    },
		                    "codiceFiscale": {
		                        "data": {},
		                        "type": "text",
		                        "label": "Cod.Fiscale",
		                        "helpers": [],
		                        "disabled": true,
		                        "validate": true,
		                        "attributes": {},
		                        "autocomplete": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {}
		                    },
		                    "dataNascita": {
		                        "data": {},
		                        "type": "date",
		                        "focus": false,
		                        "label": "Data di nascita",
		                        "picker": {
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "useCurrent": false,
		                            "extraFormats": [],
		                            "dayViewHeaderFormat": "MMMM YYYY"
		                        },
		                        "helpers": [],
		                        "disabled": false,
		                        "validate": true,
		                        "typeahead": {},
		                        "attributes": {},
		                        "dateFormat": "DD/MM/YYYY",
		                        "manualEntry": false,
		                        "autocomplete": false,
		                        "optionLabels": [],
		                        "showMessages": false,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {},
		                        "events": {}
		                    },
		                    "luogoNascita": {
		                        "data": {},
		                        "type": "text",
		                        "label": "Luogo di nascita",
		                        "helpers": [],
		                        "disabled": true,
		                        "validate": true,
		                        "attributes": {},
		                        "autocomplete": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {},
		                        "events": {}
		                    },
		                    "indirizzoResidenza": {
		                        "data": {},
		                        "type": "text",
		                        "label": "Indirizzo di residenza",
		                        "helpers": [],
		                        "disabled": true,
		                        "validate": true,
		                        "attributes": {},
		                        "autocomplete": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "allowOptionalEmpty": true,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {}
		                    },
		                    "viaHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {},
		                        "events": {}
		                    },
		                    "civicoHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "esponenteHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "scalaHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "pianoHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "internoHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "capHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "provinciaResHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "comuneResHidden": {
		                        "type": "hidden",
		                        "label": "New hidden",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "fields": {}
		                    },
		                    "identificativo": {
		                        "label": "Identificativo",
		                        "type": "hidden",
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
		                    },
		                    "identificativoFamiglia": {
		                        "label": "Identificativo",
		                        "type": "hidden",
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
		                    },
		                    "isDelegato": {
		                        "label": "delegato",
		                        "type": "hidden",
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
		                }
		            },
		            "objectDocumento": {
		                "order": 4,
		                "type": "object",
		                "helpers": [],
		                "validate": true,
		                "disabled": false,
		                "showMessages": true,
		                "collapsible": false,
		                "legendStyle": "button",
		                "view": {
		                    "messages": {
		                        "notOptional": "Campo obbligatorio",
		                        "invalidValueOfEnum": "Selezionare una delle opzioni"
		                    },
		                    "templates": {
		                        "container": "<div>{{#container}}{{/container}}</div>",
		                        "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-6'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div></div></div>"
		                    },
		                    "id": "view-alpaca136",
		                    "parent": "bootstrap-edit"
		                },
		                "fields": {
		                    "tipo": {
		                        "label": "Tipologia documento:",
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
		                        "fields": {}
		                    },
		                    "numero": {
		                        "label": "Documento di riconoscimento n.:",
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
		                        "fields": {}
		                    },
		                    "rilasciatoDa": {
		                        "label": "Rilasciato da:",
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
		                        "fields": {}
		                    },
		                    "dataRilascio": {
		                        "data": {},
		                        "type": "date",
		                        "focus": false,
		                        "label": "Il:",
		                        "picker": {
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "useCurrent": false,
		                            "extraFormats": [],
		                            "dayViewHeaderFormat": "MMMM YYYY"
		                        },
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "attributes": {},
		                        "allowOptionalEmpty": true,
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "dateFormat": "DD/MM/YYYY",
		                        "manualEntry": false,
		                        "fields": {}
		                    },
		                    "dataScadenza": {
		                        "data": {},
		                        "type": "date",
		                        "focus": false,
		                        "label": "Scadenza il:",
		                        "picker": {
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "useCurrent": false,
		                            "extraFormats": [],
		                            "dayViewHeaderFormat": "MMMM YYYY"
		                        },
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "attributes": {},
		                        "allowOptionalEmpty": true,
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "dateFormat": "DD/MM/YYYY",
		                        "manualEntry": false,
		                        "fields": {}
		                    }
		                }
		            },
		            "dichiarazionePdf": {
		                "cols": 40,
		                "data": {},
		                "rows": 5,
		                "sort": false,
		                "type": "textarea",
		                "focus": false,
		                "order": 7,
		                "hidden": false,
		                "helpers": [],
		                "disabled": false,
		                "readonly": false,
		                "validate": true,
		                "typeahead": {},
		                "attributes": {},
		                "autocomplete": false,
		                "optionLabels": [],
		                "showMessages": true,
		                "renderButtons": true,
		                "allowOptionalEmpty": true,
		                "disallowEmptySpaces": false,
		                "disallowOnlyEmptySpaces": false,
		                "hideInitValidationError": false,
		                "view": "bootstrap-display",
		                "fields": {}
		            },
		            "objectDelegato": {
		                "order": 8,
		                "type": "object",
		                "helpers": [],
		                "validate": true,
		                "disabled": false,
		                "showMessages": true,
		                "collapsible": false,
		                "legendStyle": "button",
		                "view": {
		                    "messages": {
		                        "notOptional": "Campo obbligatorio",
		                        "invalidValueOfEnum": "Selezionare una delle opzioni"
		                    },
		                    "templates": {
		                        "container": "<div>{{#container}}{{/container}}</div>",
		                        "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-12'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-12'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[5]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-12'>{{#with items.[6]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-12'>{{#with items.[7]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-12'>{{#with items.[8]}}{{#item}}{{/item}}{{/with}}</div></div>"
		                    },
		                    "id": "view-alpaca144",
		                    "parent": "bootstrap-edit"
		                },
		                "fields": {
		                    "cognome": {
		                        "type": "text",
		                        "label": "Cognome",
		                        "focus": false,
		                        "disabled": false,
		                        "helpers": [],
		                        "validate": true,
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
		                    "nome": {
		                        "type": "text",
		                        "label": "Nome",
		                        "focus": false,
		                        "disabled": false,
		                        "helpers": [],
		                        "validate": true,
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
		                    "labelNatoA": {
		                        "type": "label",
		                        "label": "Nato/a a:",
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
		                        "fields": {}
		                    },
		                    "provenienzaNascita": {
		                        "type": "object",
		                        "label": "",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "collapsible": false,
		                        "legendStyle": "button",
		                        "focus": false,
		                        "helpersPosition": "below",
		                        "view": "nazioneprovinciacomune-view",
		                        "fields": {
		                            "nazioni": {
		                                "type": "statiSelect",
		                                "label": "",
		                                "helpers": [],
		                                "validate": true,
		                                "disabled": false,
		                                "showMessages": true,
		                                "collapsible": false,
		                                "legendStyle": "button",
		                                "view": "statiSelect-view",
		                                "fields": {
		                                    "stati": {
		                                        "type": "select",
		                                        "validate": false,
		                                        "disabled": false,
		                                        "showMessages": false,
		                                        "label": "Stato: ",
		                                        "removeDefaultNone": true,
		                                        "noneLabel": "Nessuno",
		                                        "hideNone": true,
		                                        "useDataSourceAsEnum": false,
		                                        "helpers": [],
		                                        "renderButtons": true,
		                                        "multiselect": {
		                                            "disableIfEmpty": true
		                                        },
		                                        "events": {},
		                                        "fieldClass": "select2ac1",
		                                        "fields": {}
		                                    }
		                                }
		                            },
		                            "provinciaComune": {
		                                "type": "provinciaComuneRequired",
		                                "label": "",
		                                "helpers": [],
		                                "validate": true,
		                                "disabled": false,
		                                "showMessages": true,
		                                "collapsible": false,
		                                "legendStyle": "button",
		                                "view": "provinciacomunerequired-view",
		                                "fields": {
		                                    "provincia": {
		                                        "type": "provincia",
		                                        "validate": true,
		                                        "showMessages": true,
		                                        "disabled": false,
		                                        "hidden": false,
		                                        "label": "Provincia",
		                                        "helpers": [],
		                                        "hideInitValidationError": true,
		                                        "focus": false,
		                                        "optionLabels": [],
		                                        "removeDefaultNone": false,
		                                        "noneLabel": "--Seleziona--",
		                                        "hideNone": false,
		                                        "useDataSourceAsEnum": false,
		                                        "multiple": false,
		                                        "emptySelectFirst": true,
		                                        "multiselect": {
		                                            "disableIfEmpty": true
		                                        },
		                                        "sort": false,
		                                        "renderButtons": true,
		                                        "events": {},
		                                        "fields": {},
		                                        "fieldClass": "select2ac1 notSelect2"
		                                    },
		                                    "comune": {
		                                        "type": "comune",
		                                        "validate": false,
		                                        "showMessages": false,
		                                        "disabled": false,
		                                        "hidden": false,
		                                        "label": "Comune",
		                                        "helpers": [],
		                                        "hideInitValidationError": true,
		                                        "focus": false,
		                                        "optionLabels": [],
		                                        "removeDefaultNone": false,
		                                        "noneLabel": "--Seleziona--",
		                                        "hideNone": true,
		                                        "useDataSourceAsEnum": false,
		                                        "multiple": false,
		                                        "emptySelectFirst": false,
		                                        "multiselect": {
		                                            "disableIfEmpty": true
		                                        },
		                                        "sort": false,
		                                        "renderButtons": true,
		                                        "events": {},
		                                        "fields": {},
		                                        "fieldClass": "select2ac1 notSelect2"
		                                    }
		                                }
		                            },
		                            "comuneEstero": {
		                                "label": "Comune Estero: ",
		                                "type": "select",
		                                "helpers": [],
		                                "fieldClass": "select2ac1",
		                                "validate": true,
		                                "disabled": false,
		                                "showMessages": false,
		                                "renderButtons": true,
		                                "removeDefaultNone": true,
		                                "noneLabel": "Nessuno",
		                                "hideNone": true,
		                                "data": {},
		                                "attributes": {},
		                                "allowOptionalEmpty": true,
		                                "autocomplete": false,
		                                "disallowEmptySpaces": false,
		                                "disallowOnlyEmptySpaces": false,
		                                "events": {},
		                                "useDataSourceAsEnum": true,
		                                "multiselect": {
		                                    "disableIfEmpty": true
		                                },
		                                "fields": {}
		                            }
		                        }
		                    },
		                    "datanascita": {
		                        "type": "date",
		                        "label": "il:",
		                        "focus": false,
		                        "optionLabels": [],
		                        "typeahead": {},
		                        "allowOptionalEmpty": true,
		                        "data": {},
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "dateFormat": "DD/MM/YYYY",
		                        "picker": {
		                            "useCurrent": false,
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "dayViewHeaderFormat": "MMMM YYYY",
		                            "extraFormats": []
		                        },
		                        "manualEntry": false,
		                        "disabled": false,
		                        "helpers": [],
		                        "validate": true,
		                        "showMessages": false,
		                        "renderButtons": true,
		                        "attributes": {},
		                        "fields": {}
		                    },
		                    "codicefiscale": {
		                        "type": "text",
		                        "label": "Codice Fiscale",
		                        "focus": false,
		                        "disabled": false,
		                        "helpers": [],
		                        "validate": true,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "data": {},
		                        "attributes": {},
		                        "allowOptionalEmpty": true,
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "fields": {},
		                        "view": {
		                            "messages": {
		                                "notOptional": "Campo Obbligatorio.",
		                                "stringTooShort": "Il codice fiscale deve contenere 16 caratteri",
		                                "stringTooLong": "Il codice fiscale deve contenere 16 caratteri"
		                            },
		                            "id": "view-alpaca471",
		                            "parent": "bootstrap-edit",
		                            "templates": {}
		                        }
		                    },
		                    "labelResidenza": {
		                        "type": "label",
		                        "label": "Residente a:",
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
		                        "fields": {}
		                    },
		                    "luogoResidenza": {
		                        "type": "provinciaComuneRequired",
		                        "label": "",
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "collapsible": false,
		                        "legendStyle": "button",
		                        "view": "provinciacomunerequired-view",
		                        "fields": {
		                            "provincia": {
		                                "type": "provincia",
		                                "validate": true,
		                                "showMessages": true,
		                                "disabled": false,
		                                "hidden": false,
		                                "label": "Provincia",
		                                "helpers": [],
		                                "hideInitValidationError": true,
		                                "focus": false,
		                                "optionLabels": [],
		                                "removeDefaultNone": false,
		                                "noneLabel": "--Seleziona--",
		                                "hideNone": false,
		                                "useDataSourceAsEnum": false,
		                                "multiple": false,
		                                "multiselect": {
		                                    "disableIfEmpty": true
		                                },
		                                "sort": false,
		                                "renderButtons": true,
		                                "events": {},
		                                "fields": {},
		                                "fieldClass": "select2ac1 notSelect2"
		                            },
		                            "comune": {
		                                "type": "comune",
		                                "validate": false,
		                                "showMessages": false,
		                                "disabled": false,
		                                "hidden": false,
		                                "label": "Comune",
		                                "helpers": [],
		                                "hideInitValidationError": true,
		                                "focus": false,
		                                "optionLabels": [],
		                                "removeDefaultNone": false,
		                                "noneLabel": "--Seleziona--",
		                                "hideNone": true,
		                                "useDataSourceAsEnum": false,
		                                "multiple": false,
		                                "emptySelectFirst": false,
		                                "multiselect": {
		                                    "disableIfEmpty": true
		                                },
		                                "sort": false,
		                                "renderButtons": true,
		                                "events": {},
		                                "fields": {},
		                                "fieldClass": "select2ac1 notSelect2"
		                            }
		                        }
		                    },
		                    "indirizzoCompleto": {
		                        "type": "text",
		                        "label": "All'indirizzo:",
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
		                    }
		                }
		            },
		            "objectDocumentoDelegato": {
		                "order": 9,
		                "type": "object",
		                "helpers": [],
		                "validate": true,
		                "disabled": false,
		                "showMessages": true,
		                "collapsible": false,
		                "legendStyle": "button",
		                "view": {
		                    "messages": {
		                        "notOptional": "Campo obbligatorio",
		                        "invalidValueOfEnum": "Selezionare una delle opzioni"
		                    },
		                    "templates": {
		                        "container": "<div>{{#container}}{{/container}}</div>",
		                        "container-object": "<div><div class='row'><div class='col-md-6'>{{#with items.[0]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[1]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-6'>{{#with items.[2]}}{{#item}}{{/item}}{{/with}}</div><div class='col-md-6'>{{#with items.[3]}}{{#item}}{{/item}}{{/with}}</div></div><div class='row'><div class='col-md-6'>{{#with items.[4]}}{{#item}}{{/item}}{{/with}}</div></div></div>"
		                    },
		                    "id": "view-alpaca163",
		                    "parent": "bootstrap-edit"
		                },
		                "fields": {
		                    "tipo": {
		                        "label": "Tipologia documento:",
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
		                        "fields": {}
		                    },
		                    "numero": {
		                        "label": "Documento di riconoscimento n.:",
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
		                        "fields": {}
		                    },
		                    "rilasciatoDa": {
		                        "label": "Rilasciato da:",
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
		                        "fields": {}
		                    },
		                    "dataRilascio": {
		                        "data": {},
		                        "type": "date",
		                        "focus": false,
		                        "label": "Il:",
		                        "picker": {
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "useCurrent": false,
		                            "extraFormats": [],
		                            "dayViewHeaderFormat": "MMMM YYYY"
		                        },
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "attributes": {},
		                        "allowOptionalEmpty": true,
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "dateFormat": "DD/MM/YYYY",
		                        "manualEntry": false,
		                        "fields": {}
		                    },
		                    "dataScadenza": {
		                        "data": {},
		                        "type": "date",
		                        "focus": false,
		                        "label": "Scadenza il:",
		                        "picker": {
		                            "format": "DD/MM/YYYY",
		                            "locale": "it",
		                            "useCurrent": false,
		                            "extraFormats": [],
		                            "dayViewHeaderFormat": "MMMM YYYY"
		                        },
		                        "helpers": [],
		                        "validate": true,
		                        "disabled": false,
		                        "showMessages": true,
		                        "renderButtons": true,
		                        "attributes": {},
		                        "allowOptionalEmpty": true,
		                        "autocomplete": false,
		                        "disallowEmptySpaces": false,
		                        "disallowOnlyEmptySpaces": false,
		                        "dateFormat": "DD/MM/YYYY",
		                        "manualEntry": false,
		                        "fields": {}
		                    }
		                }
		            },
		            "dichiarazioneFinale": {
		                "data": {},
		                "type": "text",
		                "helpers": [],
		                "disabled": true,
		                "hidden": false,
		                "validate": true,
		                "attributes": {},
		                "autocomplete": false,
		                "showMessages": true,
		                "renderButtons": true,
		                "allowOptionalEmpty": true,
		                "disallowEmptySpaces": false,
		                "disallowOnlyEmptySpaces": false,
		                "view": "bootstrap-display",
		                "order": 10,
		                "fields": {}
		            },
		            "radioPrivacy": {
		                "order": 11,
		                "sort": false,
		                "type": "radio",
		                "optionLabels": [
		                    "Presta il consenso",
		                    "Nega il consenso"
		                ],
		                "helpers": [],
		                "validate": true,
		                "disabled": false,
		                "showMessages": true,
		                "renderButtons": true,
		                "useDataSourceAsEnum": true,
		                "emptySelectFirst": false,
		                "vertical": false,
		                "noneLabel": "--",
		                "hideNone": true,
		                "fields": {}
		            },
		            "fineDichiarazione": {
		                "data": {},
		                "type": "text",
		                "helpers": [],
		                "disabled": true,
		                "hidden": false,
		                "validate": true,
		                "attributes": {},
		                "autocomplete": false,
		                "showMessages": true,
		                "renderButtons": true,
		                "allowOptionalEmpty": true,
		                "disallowEmptySpaces": false,
		                "disallowOnlyEmptySpaces": false,
		                "view": "bootstrap-display",
		                "order": 12,
		                "fields": {}
		            }
		        }
		    },
		    "data": {
		        "sottoscrittoPdf": "La/Il Sottoscritta/o (Delegante)",
		        "riepilogo": {},
		        "objectDocumento": {},
		        "dichiarazionePdf": "<h4 style='text-align: center'><b>DELEGA</b></h4>Il/LaSignore/a (delegato)",
		        "objectDelegato": {
		            "provenienzaNascita": {
		                "nazioni": {},
		                "provinciaComune": {}
		            },
		            "luogoResidenza": {}
		        },
		        "objectDocumentoDelegato": {},
		        "dichiarazioneFinale": "AL RITIRO DELLE ATTREZZATURE PER IL SERVIZIO DI RACCOLTA DIFFERENZIATA PORTA A PORTA.<br><br><b>Trattamento dati personali</b><br>L'utente, vista l'informativa ex Art.13 Reg. UE 679/2013 affissa nei locali e disponibile sul sito www.amiupuglia.it nella sezione 'Privacy',",
		        "fineDichiarazione": "per l'invio di informazioni sui servizi di igiene urbana, raccolte differenziate, stazioni ecologiche, Tari tramite i dati di contatto spontaneamente indicati nel presente modulo (es. email, telefono). Può esercitare i suoi diritti di cui agli artt. dal 15 al 22 del Reg E 679/2016 rivolgendosi al Responsabile anche scrivendo a rpd@amiupuglia.it o al Titolare del trattamento."
		    },
		    "view": {
		        "layout": {
		            "template": "<div><div id='step1' data-alpaca-wizard-role='step' data-alpaca-wizard-step-title='Step 1' data-alpaca-wizard-step-description='Dichiarante'><div data-alpaca-layout-binding='titolo' class='col-md-12'></div><div data-alpaca-layout-binding='sottoscrittoPdf' class='col-md-12'></div><div data-alpaca-layout-binding='riepilogo' class='col-md-12'></div><div data-alpaca-layout-binding='objectDocumento' class='col-md-12'></div></div><div id='step2' data-alpaca-wizard-role='step' data-alpaca-wizard-step-title='Step 2' data-alpaca-wizard-step-description='Richiesta'><div class='row'><div data-alpaca-layout-binding='dichiarazionePdf' class='col-md-12'></div></div><div class='row'><div data-alpaca-layout-binding='objectDelegato' class='col-md-12'></div></div><div class='row'><div data-alpaca-layout-binding='objectDocumentoDelegato' class='col-md-12'></div></div><div class='row'><div data-alpaca-layout-binding='dichiarazioneFinale' class='col-md-12'></div></div><div class='row'><div data-alpaca-layout-binding='radioPrivacy' class='col-md-12'></div></div><div class='row'><div data-alpaca-layout-binding='fineDichiarazione' class='col-md-12'></div></div></div> <div data-alpaca-wizard-role='step' data-alpaca-wizard-step-title='StepAllegati'></div></div>"
		        },
		        "parent": "bootstrap-edit",
		        "wizard": {
		            "steps": [
		                {
		                    "title": "Step 1",
		                    "description": "Richiedente"
		                },
		                {
		                    "title": "Step 2",
		                    "description": "Richiesta"
		                },
		                {
		                    "title": "Step 3",
		                    "description": "Allegati richiesti"
		                }
		            ],
		            "title": "",
		            "labels": {
		                "nextButton": "Avanti",
		                "submitButton": "Conferma",
		                "previousButton": "Indietro"
		            },
		            "bindings": {
		                "titolo": "step1",
		                "sottoscrittoPdf": "step1",
		                "riepilogo": "step1",
		                "objectDocumento": "step1",
		                "dichiarazionePdf": "step2",
		                "objectDelegato": "step2",
		                "objectDocumentoDelegato": "step2",
		                "dichiarazioneFinale": "step2",
		                "radioPrivacy": "step2",
		                "fineDichiarazione": "step2"
		            },
		            "description": "",
		            "hideSubmitButton": true
		        },
		        "messages": {
		            "notOptional": "Campo obbligatorio",
		            "invalidValueOfEnum": "Selezionare una delle opzioni.",
		            "disallowValue": "Scelta non consentita"
		        },
		        "id": "view-alpaca120",
		        "templates": {}
		    }
		};		
	
	var isDebugEnabled = true;
	var isCaricaBozza = false;
	
	var datiAnagrafici = "";
	var invioFormIscrizioneUrl = '';
	var submitFormUrl = '';
	
	<!--submitFormUrl+= '&caricaBozza=${caricaBozza}&idRichiestaServizio=${idRichiestaServizio}';-->
	
	var idRichiestaServizio = '';
	
	var optJson = alpacaStructure.options;
	var dataJson = alpacaStructure.data;
	
	var configurazioneTipoServizioStep2 = 'AUTODICHIARAZIONE';
	
	var delegaPresente = ${delega != null};

	var proseguiButtonTitle;
	var showButtons = true;
	var enableSubmitFormButton = false;
	var step3Url;
	var step3DaPagareUrl;
	var downloadFile = false;
	var showServiceEvaluationPage = false;
	var destinazioneUsoId=null;
	var nomeFile=null;
	var idRichiesta=null;
	<!--***TODO fin qui***-->
	<!-- *** -->	
	
	switch(configurazioneTipoServizioStep2) {
	case '${DICHIARAZIONE}':
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
  		break;
	case '${PAGAMENTO}':
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
		step3Url = 'TODO';
  		break;
	case '${CERTIFICATO}':
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
		enableSubmitFormButton = true;
		step3Url = '${scegliModalitaPagamentoUrl}';
		step3DaPagareUrl = '${scegliModalitaPagamentoUrl}';
		downloadFile = false;
		showServiceEvaluationPage = false;
  		break;
	case '${VISURA}':
		proseguiButtonTitle = '';
		showButtons = false;
		showServiceEvaluationPage = true;
  		break;
	case '${AUTODICHIARAZIONE}':
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
  		break;
	case '${CONCORSO}':
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
		step3Url = '${scegliAllegatiUrl}';
  		break;
	default:
		proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
}
	proseguiButtonTitle = '<spring:message code="button.salva.bozza.prosegui" />';
	step3Url = '${scegliAllegatiUrl}';

	
	var updated = false;
	
	var optForm = {
		"form":{
	   	    "attributes":{
	   	    	"action":submitFormUrl,
	   	        "method":"post"
	   	    },
	   	 	"buttons":{}
	    }
    };
	if (showButtons) {
		optForm = {
			"form": {
		   	   "attributes":{
		   	    	"action":submitFormUrl,
		   	        "method":"post"
		 	   },
		 	   "toggleSubmitValidState": false,
		   	    "buttons":{
		   	    	"indietro":{
			            "title": '<spring:message code="label.annulla" />',
			            "id": "indietroButton",
			            "click": function() {
			            	window.location.href = '';
			            }
		   	     	},
		   	        "salvaBozzaSubmit":{
		   	            "title": 'Salva Bozza',
		   	            "id": "salvaBozzaFormButton",
		   	            "click": function(e) {
		   	            	var userData = this.getValue();
			   	         	
		   	            	$('.select2ac1').each(function(index) {
		   	            		var selectName = $(this).find("select").attr("name");
		   	            		var value = $(this).find('select').val();
		   	            		var text = $(this).find('select').find(":selected").text();
		   	            		userData[selectName + "Value"] = value;
		   	            		userData[selectName + "Text"] = text;
		   	            	});
		   	            	
		   	            	var dataTosend = {"dataForm": 
		   	            		JSON.stringify({"schema": alpacaStructure.schema, "options": alpacaStructure.options, "data": userData, "view": alpacaStructure.view})
		   	            	};
		   	            	if (isDebugEnabled) {
		   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
		   	            	}
		   	            	$.blockUI({ 
	   	                 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
		   	                 	baseZ:2000,
		   	                  	css: { 
		   	                         border: 'none', 
		   	                         fontFamily: "'Titillium Web',sans-serif",
		   	                         opacity: .7, 
		   	                         color: '#ae1d3f',
		   	                     } 
		   	               	});
		   	            	$.ajax({
		   	            	    url: submitFormUrl,
		   	            	    cache: false,
		   	            	    dataType: 'json',
		   	            	    data: dataTosend,
		   	            	    method: 'POST',
		   	            	    async: true,
		   	            	    success: function(data){
		   	            	    	updated = true;
	   	            	        	submitFormUrl = '';
		   	            	        console.log('submitFormUrl: dopo = ' + submitFormUrl);
		   	            	     	$.unblockUI();
		   	            	     	
			   	            	    $.blockUI({ 
			                               message: "<div style='padding:20px 20px; color: #ae1d3f; background-color: #FFF '>La bozza della tua istanza è stata salvata e potrà essere successivamente completata. Potrai in qualsiasi momento recuperarla anche nella pagina 'La mia Scrivania' nella sezione 'Le mie Pratiche'</div><button class='btn btn-primary' type='button' onclick='$.unblockUI()'><b>OK</b></button><br><br>",
			                               baseZ:2000,
			                               css: { 
			                                    border: 'none', 
			                                    fontFamily: "'Titillium Web',sans-serif",
			                                    opacity: .7, 
			                                    color: '#ae1d3f',
			                               } 
			                       });
		   	            	     
		   	            	    },
		   	            	    error: function (jqXHR, exception) {
		   	            	    	if (isDebugEnabled) {
		   	            	        	console.log('ERRORE: salvaBozzaSubmit = ' + exception);
		   	            	    	}
		   	            	    }
		   	            	}).always(function() {
		   	            		/*In ogni caso deve essere nascosto il loader*/
		   	            		$.unblockUI();
		   	            	});
		   	            }
		   	        },
			   	    "submitButton":{
			   	            "title": proseguiButtonTitle,
			   	            "id": "submitFormButton",
			   	         	"styles": "btn btn-primary",
			   	         	"click": function(e) {

			   	         		var userData = this.getValue();
	
			   	         		/* Gestione presenza eventuali allegati ripetibili */
			   	         		$("[data-alpaca-field-path$='allegatiExtra']").each(function (index, elem) {
									var allegatoData = $(elem).alpaca("get").data;
									if (allegatoData.isRequired) {
										userData["allegato-checkbox-" + allegatoData.descrizione + "-" + allegatoData.codiceFiscale] = true;
									}
								});		
			   	         		
			   	            	$('.select2ac1').each(function(index) {
			   	            		var selectName = $(this).find("select").attr("name");
			   	            		var value = $(this).find('select').val();
			   	            		var text = $(this).find('select').find(":selected").text();
			   	            		userData[selectName + "Value"] = value;
			   	            		userData[selectName + "Text"] = text;
			   	            	});
			   	            	
			   	            	var dataTosend = {"dataForm": 
			   	            		JSON.stringify({"schema": alpacaStructure.schema, "options": alpacaStructure.options, "data": userData, "view": alpacaStructure.view})
			   	            	};
			   	            	if (isDebugEnabled) {
			   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
			   	            	}
			   	            	/*register alpaca validation*/
								var form = this;
								form.validate(true);
								/* draw the validation state (top control + all children)*/
								form.refreshValidationState(true);
								if (!form.isValid(true)) {
									form.focus();
									e.stopPropagation();
									return false;
								} else {
									/*console.log("validation: OK!");*/
								}
			   	            	
			   	            	$.blockUI({
			   	             		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
			   	                 	baseZ:2000,
			   	                  	css: {
			   	                         border: 'none', 
			   	                         fontFamily: "'Titillium Web',sans-serif",
			   	                         opacity: .7, 
			   	                         color: '#ae1d3f',
			   	                     } 
			   	           		});
			   	            	
			   	            	var submitForm = true;
			   	            	
			   	            	if(submitForm){
			   	            		var submitFormUrlNew = submitFormUrl;
			   	            		if (destinazioneUsoId != null) {
			   	            			submitFormUrlNew = submitFormUrl + destinazioneUsoId;
			   	            		}
			   	            		$.ajax({
				   	            	    url: submitFormUrlNew,
				   	            	    cache: false,
				   	            	    dataType: 'json',
				   	            	    data: dataTosend,
				   	            	    method: 'POST',
				   	            	    async: true,
				   	            	    success: function(data){
					   	     				if (downloadFile && data.status === "ok" && (data.daPagare == null || data.daPagare == false)) {
												/*se non c'è da pagare, lascio tutto come sta, abilito il pulsante per la generazione (da creare)
	 				   	     					if(submitFormUrl.indexOf("idServizio") == -1){
	 				   	     						submitFormUrl += '&idServizio=${idServizio}';
	 				   	     					}*/
					   	     					
	 				   	     				/*
	 				   	     					nomeFile = data.nomeFile;
					   	     					$("button[data-key='scaricaCertificatoButton']").show();
					   	     					$("button[data-key='pagaButton']").hide();
					   	     					$("button[data-key='submitButton']").attr('disabled', 'disabled');
					   	     				*/
												/*window.location.href = step3Url + '&nomeFile=' + data.nomeFile + '&idServizio=${idServizio}';*/
												
												
												/*se non c'è da pagare, porto sulla pagina di dowload del certificato*/
												$("button[data-key='scaricaCertificatoButton']").hide();
												$("button[data-key='pagaButton']").html("Genera Certificato");
												$("button[data-key='pagaButton']").hide();
												
							   	            	var dataTosend = {"dataForm": 
							   	            		JSON.stringify({"schema": alpacaStructure.schema, "options": alpacaStructure.options, "data": userData, "view": alpacaStructure.view})
							   	            	};
							   	            	if (isDebugEnabled) {
							   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
							   	            	}
							   	            	$.blockUI({ 
						   	                 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
							   	                 	baseZ:2000,
							   	                  	css: { 
							   	                         border: 'none', 
							   	                         fontFamily: "'Titillium Web',sans-serif",
							   	                         opacity: .7, 
							   	                         color: '#ae1d3f',
							   	                     } 
							   	               	});
							   	            	idRichiesta = data.richiesta.id;
					     						window.location.href = step3DaPagareUrl + '&idRichiesta=' + idRichiesta + '&success=ok&idServizio=${idServizio}' + destinazioneUsoId;
												
												
					   	     				} else if (downloadFile && data.status === "ok" && data.daPagare == true){
					   	     					/*se c'è da pagare, abilito un pulsante paga che fa qualcosa*/
						   	     				$("button[data-key='scaricaCertificatoButton']").hide();
					   	     					$("button[data-key='pagaButton']").show();
					   	     					$("button[data-key='submitButton']").attr('disabled', 'disabled');
					   	     					idRichiesta = data.richiesta.id;
					   	     				} else {
					   	     					if(data.status === "ok"){
					   	     						$("button[data-key='pagaButton']").hide();
					   	     						$("button[data-key='scaricaCertificatoButton']").hide();
					   	     						idRichiesta = data.richiesta.id;
						   	     					urlRedirect = step3Url + '&idRichiesta=' + idRichiesta + '&success=ok&idServizio=${idServizio}';
					   	     						if (destinazioneUsoId != null) {
					   	     							urlRedirect = urlRedirect + destinazioneUsoId;
							   	            		}
					   	     						window.location.href = urlRedirect;
					   	     					}
					   	     				}
					   	     				if (isDebugEnabled) {
					   	     					console.log('response data', data);
					   	     				}
				   	            	    },
				   	            	    error: function (jqXHR, exception) {
				   	            	    	if (isDebugEnabled) {
				   	            	    		console.log('ERRORE submit: ' + exception);
				   	            	    	}
				   	            	    }
				   	            	}).always(function() {
				   	            		/*In ogni caso deve essere nascosto il loader*/
				   	            		$.unblockUI();
				   	            	});
			   	            	}

			   	         	}
			   	    },
		   	        "scaricaCertificatoButton":{
		   	            "title": 'Scarica Certificato',
		   	            "id": "downloadCertificatoButton",
		   	            "click": function(e) {
		   	            	var userData = this.getValue();
		   	            	
		   	            	
		   	            	var dataTosend = {"dataForm": 
		   	            		JSON.stringify({"schema": alpacaStructure.schema, "options": alpacaStructure.options, "data": userData, "view": alpacaStructure.view})
		   	            	};
		   	            	if (isDebugEnabled) {
		   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
		   	            	}
		   	            	$.blockUI({ 
	   	                 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
		   	                 	baseZ:2000,
		   	                  	css: { 
		   	                         border: 'none', 
		   	                         fontFamily: "'Titillium Web',sans-serif",
		   	                         opacity: .7, 
		   	                         color: '#ae1d3f',
		   	                     } 
		   	               	});
		   	            	
		   	            	window.location.href = step3Url + '&nomeFile=' + nomeFile + '&idServizio=${idServizio}';
		   	            	$.unblockUI();
		   	            	$("button[data-key='submitButton']").removeAttr('disabled');
		   	            	
		   	            }
		   	        },
		   	        "pagaButton":{
		   	            "title": 'Scegli Modalità Pagamento',
		   	            "id": "pagaButton",
		   	            "click": function(e) {
		   	            	var userData = this.getValue();
 
		   	            	var dataTosend = {"dataForm": 
		   	            		JSON.stringify({"schema": alpacaStructure.schema, "options": alpacaStructure.options, "data": userData, "view": alpacaStructure.view})
		   	            	};
		   	            	if (isDebugEnabled) {
		   	            		console.log("dataTosend: ", JSON.parse(dataTosend.dataForm));
		   	            	}
		   	            	$.blockUI({ 
	   	                 		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
		   	                 	baseZ:2000,
		   	                  	css: { 
		   	                         border: 'none', 
		   	                         fontFamily: "'Titillium Web',sans-serif",
		   	                         opacity: .7, 
		   	                         color: '#ae1d3f',
		   	                     } 
		   	               	});
     						window.location.href = step3DaPagareUrl + '&idRichiesta=' + idRichiesta + '&success=ok&idServizio=${idServizio}' + destinazioneUsoId;
		   	            	/*
     						$.ajax({
		   	            	    url: submitFormUrl,
		   	            	    cache: false,
		   	            	    dataType: 'json',
		   	            	    data: dataTosend,
		   	            	    method: 'POST',
		   	            	    async: true,
		   	            	    success: function(data){
		   	            	    	
									console.log('salva bozza response data= ', data); 
		   	            	    },
		   	            	    error: function (jqXHR, exception) {
		   	            	    	
		   	            	        console.log('ERRORE: salvaBozzaSubmit = ' + exception);
		   	            	    }
		   	            	}).always(function() {
		   	            		//In ogni caso deve essere nascosto il loader
		   	            		$.unblockUI();
		   	            	});
		   	            	*/
		   	            }
		   	        }
		   	    }
		   	}
	   	};
		
		/* console.log('optForm: ' + optForm['form.buttons']); */
	}
	if (showServiceEvaluationPage && true) {
		var showServiceEvaluationButton =  {
            "title": '<spring:message code="button.valutaServizio" />',
            "id": "showServiceEvaluationButton",
            "click": function(e) {
            	e.preventDefault();
            	$.ajax({
            	    url: '${serviceEvaluationUrl}',
            	    method: 'POST',
            	    success: function(data){
            	    	window.open(data, '_blank');
            	    },
            	    error: function (jqXHR, exception) {
            	    	if (isDebugEnabled) {
            	        	console.log('ERRORE: ' + exception);
            	    	}
            	    }
	            });
            }
        };
		optForm.form.buttons["showServiceEvaluationButton"] = showServiceEvaluationButton;
	}
	var opt = $.extend(optJson, optForm);
	$.blockUI({ 
        message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '>Caricamento del Modulo...</div>",
        baseZ:2000,
         css: { 
                border: 'none', 
                fontFamily: "'Titillium Web',sans-serif",
                opacity: .7, 
                color: '#ae1d3f',
            } 
    });
	
	function __alpacaSearchField(obj, name) {
		for (var key in obj) {
			if (key == name) {
				return obj[key];
			} else if (key == "fields") {
				return __alpacaSearchField(obj[key], name);
			}
		}
		return null;
	}
	
	$(document).ready(function() {
		/*console.log('test', JSON.stringify(${alpacaStructure.schema}), JSON.stringify(${alpacaStructure.options}), JSON.stringify(${alpacaStructure.view}));*/
	    $("#formIscrizione").alpaca({
	   	    "schema": alpacaStructure.schema, 
	   	    "options": opt,
	   	    "data": alpacaStructure.data,
	   	    "view": alpacaStructure.view,
            "postRender": function(control) {
           		if( configurazioneTipoServizioStep2 == '${CERTIFICATO}') {
           			if (isDebugEnabled) {
           				console.log('configurazioneTipoServizioStep2 = CERTIFICATO, nascondo il salvaBozzaFormButton'); 
           			}
           			$("button[data-key='salvaBozzaSubmit']").hide(); 
           		} 
           		if( configurazioneTipoServizioStep2 == '${AUTODICHIARAZIONE}') {
           			if (isDebugEnabled) {
           				console.log('configurazioneTipoServizioStep2 = AUTODICHIARAZIONE'); 
           			}
           			if($("button[data-alpaca-wizard-button-key='submit']").length > 0){ 
           				$("button[data-alpaca-wizard-button-key='submit']").text(proseguiButtonTitle);
           			}
           		} 
           		
				if( configurazioneTipoServizioStep2 == '${VISURA}') {
					if (isDebugEnabled) {
						console.log('configurazioneTipoServizioStep2 = VISURA');
					}
					$.expr[':'].notext = function(el) {
   	     	    		return $.trim(el.innerHTML.replace(/<!--.*(?!-->)/, '')).length === 0
   	     	    	}

   	     	    	$("div.alpaca-control:notext, p.alpaca-control:notext").each(function() {
    	    				$("div[data-alpaca-field-name=" + this.attributes.name.nodeValue + "]").css({ 
    	    					display : "none",
    	    					visibility : "hidden"
    	    				});  
  	     	    		});   
   	     	    } else {
					/*console.log('configurazioneTipoServizioStep2 = NOT VISURA'); */
					if (isDebugEnabled) {
						console.log('control', control);
					}
					$(".select2ac1:not('.notSelect2')").each(function(index) {
						var selectName = $(this).find("select").attr("name");
						console.log("selectName", selectName);
						var s2Value = control.data[selectName + "Value"];
						var s2Text = control.data[selectName + "Text"];
						/*console.log('s2Value', s2Value);*/
						/*console.log('s2Text', s2Text);*/
						/*var select2 = __alpacaSearchField(control.options.fields, selectName);*/
						/*console.log("select2", select2);*/
						var s2DataSource = "";
							 
						  if (s2Value != null && typeof s2Value !== 'undefined' && s2Text != null && typeof s2Text !== 'undefined') {
							var newOption = new Option(s2Text, s2Value, true, true);
							$(this).find("select").append(newOption).trigger('change');
						  } 
					});
            	} 
				
				
				$("button[data-key='pagaButton']").hide();
				$("button[data-key='scaricaCertificatoButton']").hide();
				
				$.unblockUI();
            	if (enableSubmitFormButton) {
            		if (isDebugEnabled) {
            			console.log("sto riabilitando il bottone")
            		}
            		if ( $("button[data-key='submitButton']") != null && $("button[data-key='submitButton']").length > 0 ){
            			$("button[data-key='submitButton']").removeAttr('disabled');
            		}
        	    }

            	/*register alpaca validation*/           	
            	var formValidation = function(form, time) {
                	setTimeout(function() {
                    	var nextBtn = $('button[data-alpaca-wizard-button-key="next"]');
                        if ( form.isValid(true) &&
                        		((nextBtn.length > 0 && nextBtn.is(":hidden")) || nextBtn.length <= 0) ) {
                        	if (isDebugEnabled) {
                        		console.log("validation: OK!");
                        	}
                        	$("button[data-key='submitButton']").removeAttr('disabled');
                        } else {
                        	if (isDebugEnabled) {
                        		console.log("validation: KO!");
                        	}
                        	$("button[data-key='submitButton']").attr('disabled', 'disabled');
                        }
                    }, time);
                };
                var form = control.form;
                if (form) {
                	formValidation(form, 10);
    				$(control.form.form).find('input, select, textarea').on('focus blur', function(e) {
    					formValidation(form, 100);
    				});
    				$(control.form.form).on('click', function(e) {
    					formValidation(form, 100);
    				});

    				if ($('button[data-alpaca-wizard-button-key="next"]').length > 0) {
        				const targetNode = $('button[data-alpaca-wizard-button-key="next"]')[0];
        				const config = { attributes: true, attributeFilter: ["style"] };
        				const mutationCallback = function(mutationsList, observer) {
        				    for(let mutation of mutationsList) {
        				        if (mutation.type === 'attributes') {
        				        	formValidation(form, 100);
        				        }
        				    }
        				};
        				const observer = new MutationObserver(mutationCallback);
        				observer.observe(targetNode, config);
        				/*observer.disconnect();*/
        			}
                    
                    form.registerSubmitHandler(function(e, form) {
                        /* validate the entire form (top control + all children)*/
                        form.validate(true);
                        /* draw the validation state (top control + all children)*/
                        form.refreshValidationState(true);
                        /* now display something*/
                        if (form.isFormValid()) {
                            /*var value = form.getValue();*/
                            /*console.log("validation: OK!");*/
                        	$("button[data-key='submitButton']").removeAttr('disabled');
                        } else {
                            /*console.log("validation: KO!");*/
                        	$("button[data-key='submitButton']").attr('disabled', 'disabled');
                        }
                        e.stopPropagation();
                        return false;
                    });
                }
			}
	}); 
	    
    $("#destinazioneUsoSelect").change(function() {
    	if($("#destinazioneUsoError").length == 1){
				$("destinazioneUsoError").remove();
		}
    	
    	if($("#destinazioneUsoSelect").val() != ""){
    		destinazioneUsoId = '&destinazioneUsoId=' + $("#destinazioneUsoSelect").val();	
    	} else {
    		destinazioneUsoId = '&destinazioneUsoId=' + null;
    	}
    	$("button[data-key='scaricaCertificatoButton']").hide();
		$("button[data-key='pagaButton']").hide();
		$("button[data-key='submitButton']").removeAttr('disabled');
    });
    
});
	
}
</script>