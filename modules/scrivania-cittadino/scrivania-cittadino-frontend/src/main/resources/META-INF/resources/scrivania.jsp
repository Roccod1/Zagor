<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_RICHIESTE %>" var="getRichiesteUtenteResourceCommandUrl">
</portlet:resourceURL>

<h3>Comunicazioni</h3>

${getRichiesteUtenteResourceCommandUrl }

<%-- <c:choose> --%>
	<div id="#<portlet:namespace/>accordionContainer"></div>
	
<%-- 	<c:when test="${not empty listaComunicazioni }"> --%>
<%-- 	</c:when> --%>
	
<%-- 	<c:otherwise> --%>
<!-- 		<div class="alert alert-secondary" role="alert"> -->
<%-- 			<liferay-ui:message key="nessun-risultato-da-visualizzare"/> --%>
<!-- 		</div> -->
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>

<h3>Le mie prenotazioni</h3>
<c:choose>
	<c:when test="${not empty listaPrenotazioni}">
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-secondary" role="alert">
			<liferay-ui:message key="nessun-risultato-da-visualizzare"/>
		</div>
	</c:otherwise>
</c:choose>







<script id="accordion" type="text/x-jsrender">
<div id="collapseDivRichieste" class="collapse-div collapse-background-active">
	{{for comunicazioni}}
	<div class="collapse-header" id="heading{{>comunicazioneId}}">
		  <button data-toggle="collapse" data-target="#collapse{{>comunicazioneId}}" aria-expanded="false" aria-controls="collapse{{>comunicazioneId}}">
		     <div class="button-wrapper">
		     	 <span class="text-uppercase">
					{{>titolo}}			   		 
		     	 </span>
		    <div class="icon-wrapper">
		        <span>{{>tipologia.nome}}</span>
		    </div>
		  </button>
		</div>
		<div class="collapse-body">
			<div>
				{{>dataInvio}}
			</div>
		
		  <div id="collapse{{>comunicazioneId}}" class="collapse" role="region" aria-labelledby="heading{{>comunicazioneId}}">
		  {{if descrizione }}
		           <p class="mb-3">{{>descrizione}}</p>
		  {{/if}}
		  	
		     <p><liferay-ui:message key="codice-servizio"/>: {{codiceServizio ? >codiceServizio : "-"}}</p>
		     <a href="{{uriServizio ? >uriServizio : "#" }}"><span class="t-primary underline"><liferay-ui:message key="scheda-servizio" /></span></a>  
		  </div>
		</div>
	{{/for}}
</div>
</script>







<script type="text/javascript">
	var cur = 0;

// 	on documentReady
	$(function(){
		getRichiesteUtente();
	});
	
	function getRichiesteUtente(){
		
		var params = {};
		params.cur = cur;
 		params.orderByCol = '';
		params.orderByType = '';
		
		var accordionContainer = $("#<portlet:namespace/>accordionContainer");
		var url = '${getRichiesteUtenteResourceCommandUrl}';
		$.ajax({
			method: 'GET',
			url: url,
			data: '',
			async: false,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);				
				var tpl = $.templates('#accordion');
				var html = tpl.render({comunicazioni: result});
				$(accordionContainer).html(html);
				
			},
			error: function(xhr, status, error){
				console.log("error: ", error);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>