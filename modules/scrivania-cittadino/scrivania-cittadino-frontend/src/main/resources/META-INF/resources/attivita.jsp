<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_RICHIESTE %>" var="getRichiesteUtenteResourceCommandUrl">
</portlet:resourceURL>

<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_PAGAMENTI %>" var="getPagamentiUtenteResourceCommandUrl">
</portlet:resourceURL>


<h3><liferay-ui:message key="richieste"/></h3>
<div id="<portlet:namespace/>accordionContainerRichieste"></div>

<h3><liferay-ui:message key="pagamenti"/></h3>
<div id="<portlet:namespace/>accordionContainerPagamenti"></div>

<script id="accordionRichieste" type="text/x-jsrender">
<div id="collapseDivRichieste" class="collapse-div collapse-background-active">
	{{props listaRichieste}}
	<div class="collapse-header" id="heading{{>prop.richiestaId }}">
		<button data-toggle="collapse" data-target="#collapse{{>prop.richiestaId }}" aria-expanded="false" aria-controls="collapse{{>prop.richiestaId }}">
			<div class="button-wrapper">
				<span class="text-uppercase">
					{{>prop.oggetto}}			         
			    </span>
				<div class="icon-wrapper">
				<svg class="icon icon-xs me-1 icon-primary">
					<use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-check"></use>
					<span>{{>prop.stato}}</span>
				</svg>
			</div>
		</button>
	</div>
	<div class="collapse-body">
		{{if prop.dataProtocollo }}
		<div>
			{{localDate:prop.dataProtocollo}}
		</div>
		{{/if}}
		<div id="collapse{{>prop.richiestaId }}" class="collapse" role="region" aria-labelledby="heading{{>prop.richiestaId }}">
			{{if prop.note }}">
				<p class="mb-3">{{>prop.note}}</p>
			{{/if}}
			<p>Pratica: {{>prop.richiestaId }}</p>
			<a href="#"><span class="t-primary underline"><liferay-ui:message key="scheda-servizio"/></span></a>  
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

<script id="accordionPagamenti" type="text/x-jsrender">
<div id="collapseDivRichieste" class="collapse-div collapse-background-active">
	{{props listaPagamenti}}
	<div class="collapse-header" id="heading{{>prop.richiestaId }}">
		<button data-toggle="collapse" data-target="#collapse{{>prop.richiestaId }}" aria-expanded="false" aria-controls="collapse{{>prop.richiestaId }}">
			<div class="button-wrapper">
				<span class="text-uppercase">
					{{>prop.oggetto}}			         
			    </span>
				<div class="icon-wrapper">
				<svg class="icon icon-xs me-1 icon-primary">
					<use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-check"></use>
					<span>{{>prop.stato}}</span>
				</svg>
			</div>
		</button>
	</div>
	<div class="collapse-body">
		{{if prop.dataProtocollo }}
		<div>
			{{localDate:prop.dataProtocollo}}
		</div>
		{{/if}}
		<div id="collapse{{>prop.richiestaId }}" class="collapse" role="region" aria-labelledby="heading{{>prop.richiestaId }}">
			{{if prop.note }}">
				<p class="mb-3">{{>prop.note}}</p>
			{{/if}}
			<p>Pratica: {{>prop.richiestaId }}</p>
			<a href="#"><span class="t-primary underline"><liferay-ui:message key="scheda-servizio"/></span></a>  
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

<script type="text/javascript">
	
// 	on documentReady
	$(function(){
		getPagamentiUtente(1);
		getRichiesteUtente(1);
	});
	
	//registro template per questa pagina
	$.templates({
			accordionRichieste: "#accordionRichieste",
			accordionPagamenti: "#accordionPagamenti",
		}
	);
	
	function getRichiesteUtente(cur){
		
		var params = {};
		params.cur = cur;
 		params.orderByCol = '';
		params.orderByType = '';
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerRichieste";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getRichiesteUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaRichieste) && result.listaRichieste.length > 0){
					html = $.render.accordionRichieste(result);
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
	
	function getPagamentiUtente(cur){
		
		var params = {};
		params.cur = cur;
 		params.orderByCol = '';
		params.orderByType = '';
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerPagamenti";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getPagamentiUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaPagamenti) && result.listaPagamenti.length > 0){
					html = $.render.accordionPagamenti(result);
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

</script>

