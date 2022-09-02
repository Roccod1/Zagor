<h3>Comunicazioni</h3>
<c:choose>
	<c:when test="${not empty listaComunicazioni }">
		<div id="collapseDiv" class="collapse-div collapse-background-active">
			<c:forEach items="${listaComunicazioni }" var="comunicazione">
			  <div class="collapse-header" id="heading${comunicazione.comunicazioneId }">
			    <button data-toggle="collapse" data-target="#collapse${comunicazione.comunicazioneId }" aria-expanded="false" aria-controls="collapse${comunicazione.comunicazioneId }">
			       <div class="button-wrapper">
			       	 <span class="text-uppercase">
						${comunicazione.titolo}			   		 
			       	 </span>
				     <div class="icon-wrapper">
				         <span>${comunicazione.tipologia.nome}</span>
				     </div>
			    </button>
			  </div>
			  <div class="collapse-body">
			  	<fmt:formatDate type="date" dateStyle="short" value="${comunicazione.dataInvio }" var="dataInvioComunicazioneFormattata"/>
			  	<div>
			  		${dataInvioComunicazioneFormattata }
			  	</div>
			  
			    <div id="collapse${comunicazione.comunicazioneId }" class="collapse" role="region" aria-labelledby="heading${comunicazione.comunicazioneId }">
				    <c:if test="${not empty comunicazione.descrizione }">
			             <p class="mb-3">${comunicazione.descrizione}</p>
				   	</c:if>
				   	
			       <p><liferay-ui:message key="codice-servizio"/>: ${not empty comunicazione.codiceServizio ? comunicazione.codiceServizio : "-"}</p>
			       <a href="${not empty comunicazione.uriServizio ? comunicazione.uriServizio : "#" }"><span class="t-primary underline"><liferay-ui:message key="scheda-servizio" /></span></a>  
			    </div>
			  </div>
			</c:forEach>
		</div>		
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-secondary" role="alert">
			<liferay-ui:message key="nessun-risultato-da-visualizzare"/>
		</div>
	</c:otherwise>
</c:choose>

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