
<script id="alertTpl" type="text/x-jsrender">
	<div class="alert alert-{{>tipo}}" role="alert">
 		{{>message}}
 	</div>
</script>


<script id="accordionTpl" type="text/x-jsrender">
<div id="collapseDivRichieste" class="collapse-div collapse-background-active">
	{{for dataToRender tmpl=templateName/}}
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
	<button type="button" class="btn btn-primary" onclick="{{>methodName}}({{>cur + 1}})">
		<svg class="icon icon-sm icon-white">
			<use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-arrow-right"></use>
		</svg>
	</button>
{{/if}}
</div>
</script>

<portlet:renderURL var="dettaglioRichiestaURL">
	<portlet:param name="mvcRenderCommandName" value="<%=ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA %>" />
</portlet:renderURL>

<script id="richiestaTpl" type="text/x-jsrender">

	<div class="collapse-header" id="heading{{>richiestaId }}">
		<button data-toggle="collapse" data-target="#collapse{{>richiestaId }}" aria-expanded="false" aria-controls="collapse{{>richiestaId }}">
			<div style="display:flex; justify-content:space-between">
				<span class="text-uppercase">
					{{>oggetto}}			         
				</span>
				<span class="text-uppercase">
					{{>stato.replace("_"," ")}}
				</span>
			</div>
		</button>
	</div>
	<div class="collapse-body" style="padding-bottom: 10px;  padding-top: 0; ">
		{{if dataProtocollo }}
		<div>
			{{localDate:dataProtocollo}}
		</div>
		{{/if}}
		<div id="collapse{{>richiestaId }}" class="collapse" role="region" aria-labelledby="heading{{>richiestaId }}">
			<p><liferay-ui:message key="protocollo"/>: {{>numeroProtocollo }}</p>
			<a class="btn btn-outline-primary" href="${dettaglioRichiestaURL}&<portlet:namespace/>id={{>richiestaId}}"><span class="t-primary underline"><liferay-ui:message key="dettaglio"/></span></a>  
			<a class="btn btn-outline-primary" href="#"><span class="t-primary underline"><liferay-ui:message key="vai-al-servizio"/></span></a>  
		</div>
	</div>
	
</script>

<script id="pagamentoTpl" type="text/x-jsrender">
<div class="collapse-header" id="heading{{>richiestaId }}">
		<button data-toggle="collapse" data-target="#collapse{{>richiestaId }}" aria-expanded="false" aria-controls="collapse{{>richiestaId }}">
			<div style="display:flex; justify-content:space-between">
				<span class="text-uppercase">
					{{>oggetto}}			         
				</span>
				<span class="text-uppercase">
					{{>stato.replace("_"," ")}}
				</span>
			</div>
		</button>
	</div>
	<div class="collapse-body" style="padding-bottom: 10px;  padding-top: 0; ">
		{{if dataProtocollo }}
		<div>
			{{localDate:dataProtocollo}}
		</div>
		{{/if}}
		<div id="collapse{{>richiestaId }}" class="collapse" role="region" aria-labelledby="heading{{>richiestaId }}">
			{{if note }}
				<p class="mb-3">{{>note}}</p>
			{{/if}}
			<p>Pratica: {{>richiestaId }}</p>
			<a href="${dettaglioRichiestaURL}&<portlet:namespace/>id={{>richiestaId}}"><span class="t-primary underline"><liferay-ui:message key="dettaglio"/></span></a>  
			<a href="#"><span class="t-primary underline"><liferay-ui:message key="vai-al-servizio"/></span></a>  
		</div>
	</div>
</script>

<script id="comunicazioneTpl" type="text/x-jsrender">
<div class="collapse-header" id="heading{{>comunicazioneId}}">
		<button data-toggle="collapse" data-target="#collapse{{>comunicazioneId }}" aria-expanded="false" aria-controls="collapse{{>comunicazioneId }}">
			<div style="display:flex; justify-content:space-between">
				<span class="text-uppercase">
					{{>titolo}}			         
				</span>
				<span class="text-uppercase">
					{{>tipologia ? tipologia.nome : ""}}				
				</span>
			</div>
		</button>
	</div>
	<div class="collapse-body" style="padding-bottom: 10px;  padding-top: 0; ">

		{{if dataInvio}}
			<div>
				{{localDate:dataInvio}}
			<div>
		{{/if}}

		<div id="collapse{{>comunicazioneId}}" class="collapse" role="region" aria-labelledby="heading{{>comunicazioneId}}">
			{{if descrizione }}
			<p class="mb-3">
				{{:descrizione}}
			</p>
			{{/if}}  	
			<a href="{{>uriServizio ? uriServizio : "#" }}"><span class="t-primary underline"><liferay-ui:message key="vai-al-servizio"/></span></a>  
		</div>
	</div>
</script>

<script id="prenotazioneTpl" type="text/x-jsrender">
</script>

<script type="text/javascript">
	var messages = {
			noResult:	"<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"
	}
	
	//registro template
 	$.templates("accordion", {
			markup: "#accordionTpl",
			templates: {
				richiesta: "#richiestaTpl",
 				pagamento: "#pagamentoTpl",
 				comunicazione: "#comunicazioneTpl",
				prenotazione: "#prenotazioneTpl",
			},
		}
	);
	
 	$.templates({
 		alert: "#alertTpl"	
 	}); 
	

	$.views.converters(
		{
			localDate: function(date){
				const options = { year: 'numeric', month: 'numeric', day: 'numeric'};
				var date = new Date(date);
				var formatted = date.toLocaleDateString(navigator.language, options);
				return formatted;			
			}
		}
	);

</script>