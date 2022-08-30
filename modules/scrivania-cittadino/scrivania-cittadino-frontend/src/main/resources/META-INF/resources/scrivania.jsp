<h3>Comunicazioni per me</h3>
<c:choose>
	<c:when test="${not empty listaComunicazioni}">
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