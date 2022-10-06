<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_COMUNICAZIONI %>" var="getComunicazioniUtenteResourceCommandUrl">
</portlet:resourceURL>

<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_PRENOTAZIONI %>" var="getPrenotazioniUtenteResourceCommandUrl">
</portlet:resourceURL>


<div class="container">
	<div class="row">
		<div class="col-11">
			<h3><liferay-ui:message key="comunicazioni"/></h3>						
		</div>	
		<div class="col-1">
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapse" aria-expanded="false"><liferay-ui:message key="filtri"/></button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapse">
		<div class="col">
			<aui:input type="text" name="filterOggettoComunicazione" label="titolo-o-descrizione"/>				
		</div>
		
		<div class="col">
			<aui:select name="filterTipoComunicazione" label="tipo-comunicazione">
				<aui:option value=""><liferay-ui:message key="seleziona-opzione"/></aui:option>
				<c:forEach items="${listaTipologiaComunicazione }" var="tipologiaComunicazione">
					<aui:option value="${tipologiaComunicazione.tipologiaComunicazioneId}">${tipologiaComunicazione.nome}</aui:option>
				</c:forEach>
			</aui:select>			
		</div>
		
		<div class="col-12">
			<button class="btn btn-primary" type="button" onclick="getComunicazioniUtente(1)"><liferay-ui:message key="cerca"/></button>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div id="<portlet:namespace/>accordionContainerComunicazioni"></div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-11">
			<h3><liferay-ui:message key="le-mie-prenotazioni"/></h3>						
		</div>
		<div class="col-1">
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapsePrenotazioni" aria-expanded="false"><liferay-ui:message key="filtri"/></button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapsePrenotazioni">
		<div class="col">
			<aui:input type="text" name="filterOggettoPrenotazioni" label="titolo-o-descrizione"/>				
		</div>
		<div class="col-12">
			<button class="btn btn-primary" type="button" onclick="getPrenotazioniUtente(1)"><liferay-ui:message key="cerca"/></button>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div id="<portlet:namespace/>accordionContainerPrenotazioni"></div>
		</div>
	</div>
</div>


<script id="accordionComunicazioni" type="text/x-jsrender">
<div id="collapseDivComunicazioni" class="collapse-div collapse-background-active">
	{{props listaComunicazioni}}
	<div class="collapse-header" id="heading{{>prop.comunicazioneId}}">
		<button data-toggle="collapse" data-target="#collapse{{>prop.comunicazioneId }}" aria-expanded="false" aria-controls="collapse{{>prop.comunicazioneId }}">
			<div style="display:flex; justify-content:space-between">
				<span class="text-uppercase">
					{{>prop.titolo}}			         
				</span>
				<span class="text-uppercase">
					{{>prop.tipologia ? prop.tipologia.nome : ""}}				
				</span>
			</div>
		</button>
	</div>
	<div class="collapse-body" style="padding-bottom: 10px;  padding-top: 0; ">
		<div>
			{{>prop.dataInvio ? prop.dataInvio : ""}}
		</div>	
		<div id="collapse{{>prop.comunicazioneId}}" class="collapse" role="region" aria-labelledby="heading{{>prop.comunicazioneId}}">
			{{if prop.descrizione }}
			<div class="mb-3">
				{{:prop.descrizione}}
			</div>
			{{/if}}  	
			<p><liferay-ui:message key="codice-servizio"/>: {{>prop.codiceServizio ? prop.codiceServizio : "-"}}</p>
			<a href="{{>prop.uriServizio ? prop.uriServizio : "#" }}"><span class="t-primary underline"><liferay-ui:message key="scheda-servizio"/></span></a>  
		</div>
	</div>
	{{/props}}
</div>
<div class="mt-5">
{{if cur > 1}}
	<button type="button" class="btn btn-primary" onclick="getComunicazioniUtente({{>cur - 1}})">
		<svg class="icon icon-sm icon-white">
			<use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-arrow-left"></use>
		</svg>
	</button>
{{/if}}
{{if hasNext}}
	<button type="button" class="btn btn-primary" onclick="getComunicazioniUtente({{>cur + 1}})">
		<svg class="icon icon-sm icon-white">
			<use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-arrow-right"></use>
		</svg>
	</button>
{{/if}}
</div>
</script>

<script id="accordionPrenotazioni" type="text/x-jsrender">

</script>

<script type="text/javascript">
	var defaultTimeoutMs = 1000;

// 	on documentReady
	$(function(){
		getComunicazioniUtente(1);
		getPrenotazioniUtente(1);
	});
	
	//registro template per questa pagina
	var tpl = $.templates({
			accordionComunicazioni: "#accordionComunicazioni",
			accordionPrenotazioni: "#accordionPrenotazioni",
		}
	);

	
	function getComunicazioniUtente(cur){
		
		var params = {
			'<portlet:namespace/>cur': cur,
			'<portlet:namespace/>orderByCol': '',
			'<portlet:namespace/>orderByType': '',
			'<portlet:namespace/>filterOggettoComunicazione': $("#<portlet:namespace/>filterOggettoComunicazione").val(),
			'<portlet:namespace/>filterTipoComunicazione': $("#<portlet:namespace/>filterTipoComunicazione").val(),
		};
// 		params.cur = cur;
//  	params.orderByCol = '';
// 		params.orderByType = '';
// 		params.filterOggettoComunicazione = $("#<portlet:namespace/>filterOggettoComunicazione").val();
// 		params.filterTipoComunicazione = $("#<portlet:namespace/>filterTipoComunicazione").val();
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerComunicazioni";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getComunicazioniUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaComunicazioni) && result.listaComunicazioni.length > 0){
					html = $.render.accordionComunicazioni(result);
				}else{
					html = $.render.alert({tipo: "secondary", message: "<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"});
				}
			},
			error: function(xhr, status, error){
				console.log("error: ", error);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				html = $.render.alert({tipo: "secondary", message: "<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"});
			},
			complete: function(xhr, status){
				$(accordionContainer).html(html);
			}
		});
	}
	
	function getPrenotazioniUtente(cur){
		
		var params = {
			'<portlet:namespace/>cur': cur,
			'<portlet:namespace/>orderByCol': '',
			'<portlet:namespace/>orderByType': '',
			'<portlet:namespace/>filterOggettoPrenotazioni': $("#<portlet:namespace/>filterOggettoPrenotazioni").val(),
		}
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerPrenotazioni";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getPrenotazioniUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaPrenotazioni) && result.listaPrenotazioni.length > 0){
					html = $.render.accordionPrenotazioni(result);
				}else{
					html = $.render.alert({tipo: "secondary", message: messages.noResult});
				}
			},
			error: function(xhr, status, error){
				console.log("error: ", error);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				html = $.render.alert({tipo: "secondary", message: messages.noResult});
			},
			complete: function(xhr, status){
				$(accordionContainer).html(html);
			}
		});
	}
</script>