<h3>Richieste</h3>
<c:choose>
	<c:when test="${not empty listaRichieste }">
		<div id="collapseDiv" class="collapse-div collapse-background-active">
			<c:forEach items="${listaRichieste }" var="richiesta">
			  <div class="collapse-header" id="heading${richiesta.richiestaId }">
			    <button data-toggle="collapse" data-target="#collapse${richiesta.richiestaId }" aria-expanded="false" aria-controls="collapse${richiesta.richiestaId }">
			       <div class="button-wrapper">
			         <span class="text-uppercase">
				   		 ${richiesta.oggetto}			         
			         </span>
				     <div class="icon-wrapper">
				       <svg class="icon icon-xs me-1 icon-primary">
				         <use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-check"></use>
				         <span>${richiesta.stato}</span>
				       </svg>
				     </div>
			    </button>
			  </div>
			  <div class="collapse-body">
			  	<fmt:formatDate type="date" dateStyle="short" value="${richiesta.dataProtocollo }" var="dataProtocolloFormattata"/>
			  	<div>
			  		${dataProtocolloFormattata }
			  	</div>
			  
			    <div id="collapse${richiesta.richiestaId }" class="collapse" role="region" aria-labelledby="heading${richiesta.richiestaId }">
				    <c:if test="${richiesta.note }">
			             <p class="mb-3">${richiesta.note}</p>
				   	</c:if>
			       <p>Pratica: ${richiesta.richiestaId }</p>
			       <a href="#"><span class="t-primary underline">Scheda servizio</span></a>  
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




<h3>Pagamenti</h3>
<c:choose>
	<c:when test="${not empty listaPagamenti}">
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-secondary" role="alert">
			<liferay-ui:message key="nessun-risultato-da-visualizzare"/>
		</div>
	</c:otherwise>
</c:choose>



