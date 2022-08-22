<%@ include file="init.jsp" %>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<div class="row">
		<div class="col">
			<div class="chip chip-simple">
				<span class="chip-label">${servizio.areaTematica.nome }</span>
			</div>
			
			<c:choose>
				<c:when test="${not empty servizioEnte.catalogoServizioArticleId and servizioEnte.catalogoServizioArticleId gt 0 }">
				articleId: ${servizioEnte.catalogoServizioArticleId }
				groupId: ${themeDisplay.siteGroupId }
					<liferay-journal:journal-article articleId="${servizioEnte.catalogoServizioArticleId }" groupId="${themeDisplay.siteGroupId }" /> 				
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning" role="alert">
					  <liferay-ui:message key="non-e-presente-una-descrizione-specifica-per-il-servizio-selezionato"/>
					</div>
				</c:otherwise>
			</c:choose>
			
			<a class="mt-3" href="#" title="Vai al servizio"> 
				<strong>Vai</strong>
				<span class="fa fa-angle-double-right fa-lg marginleft5" aria-hidden="true"></span>
			</a>
		</div>
	</div>
</div>