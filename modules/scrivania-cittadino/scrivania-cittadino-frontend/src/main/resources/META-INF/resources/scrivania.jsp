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
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapse" aria-expanded="false">Filtri</button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapse">
		<div class="col-5">
			<aui:input type="text" name="filterOggettoComunicazione"/>				
		</div>
		
		<div class="col">
			<aui:select name="filterTipoComunicazione">
				<aui:option value="Stato1" label="Stato1"/>
				<aui:option value="Stato2" label="Stato2"/>
				<aui:option value="Stato3" label="Stato3"/>
			</aui:select>			
		</div>
		
		<div class="col">
			<aui:select name="filterComunicazione">
				<aui:option value="Stato1" label="Stato1"/>
				<aui:option value="Stato2" label="Stato2"/>
				<aui:option value="Stato3" label="Stato3"/>
			</aui:select>	
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
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapsePrenotazioni" aria-expanded="false">Filtri</button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapsePrenotazioni">
		<div class="col">
			<div class="d-inline-flex">
				<select name="listaFiltro4">
					<option>Stato1</option>
					<option>Stato2</option>
					<option>Stato3</option>
				</select>

				<select name="listaFiltro5">
					<option>Stato1</option>
					<option>Stato2</option>
					<option>Stato3</option>
				</select>
				
				<select name="listaFiltro6">
					<option>Stato1</option>
					<option>Stato2</option>
					<option>Stato3</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div id="<portlet:namespace/>accordionContainerPrenotazioni"></div>
		</div>
	</div>
</div>








<!-- <h3><liferay-ui:message key="le-mie-prenotazioni"/></h3> -->
<%-- <div id="<portlet:namespace/>accordionContainerPrenotazioni"></div> --%>

<script id="accordionComunicazioni" type="text/x-jsrender">
<div id="collapseDivComunicazioni" class="collapse-div collapse-background-active">
	{{props listaComunicazioni}}
	<div class="collapse-header" id="heading{{>prop.comunicazioneId}}">
		<button data-toggle="collapse" data-target="#collapse{{>prop.comunicazioneId}}" aria-expanded="false" aria-controls="collapse{{>prop.comunicazioneId}}">
			<div class="button-wrapper">
			<span class="text-uppercase">
				{{>prop.titolo}}			   		 
			</span>
		    <div class="icon-wrapper">
				<span>{{>prop.tipologia ? prop.tipologia.nome : ""}}</span>
		    </div>
		</button>
	</div>
	<div class="collapse-body">
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
		
		var params = {};
		params.cur = cur;
 		params.orderByCol = '';
		params.orderByType = '';
		
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
		
		var params = {};
		params.cur = cur;
 		params.orderByCol = '';
		params.orderByType = '';
		
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