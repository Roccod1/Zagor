<%@ include file="init.jsp" %>

<c:if test="${inCarico}">
	<div class="row mt-2 mb-2">
		<c:if test="${hasAssegnaAltroResponsabile}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="assegna-altro-responsabile" />
			</button>
		</c:if>
		
		<c:if test="${hasAssegnaResponsabile}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="assegna-responsabile" />
			</button>
		</c:if>
				
		<c:if test="${hasEsitoPositivo}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="chiudi-esito-positivo" />
			</button>
		</c:if>
		
		<c:if test="${hasEsitoNegativo}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="chiudi-esito-negativo" />
			</button>
		</c:if>
		
		<c:if test="${hasRichiediModificheRichiedente}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="richiedi-modifiche-integrazioni-richiedente" />
			</button>
		</c:if>
		
		<c:if test="${hasRilascia}">
			<button class="btn btn-outline-primary mr-1 mt-1">
				<liferay-ui:message key="rilascia" />
			</button>
		</c:if>
	</div>
</c:if>