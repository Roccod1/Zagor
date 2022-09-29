<%@ include file="init.jsp" %>

<c:if test="${inCarico}">
	<div class="row mt-2 mb-2">
		<div class="col-12">
			<c:if test="${hasAssegnaAltroResponsabile}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />assegnaAltroResponsabileModal">
					<liferay-ui:message key="assegna-altro-responsabile" />
				</button>
			</c:if>
			
			<c:if test="${hasAssegnaResponsabile}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />assegnaResponsabileModal">
					<liferay-ui:message key="assegna-responsabile" />
				</button>
			</c:if>
					
			<c:if test="${hasEsitoPositivo}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />chiudiEsitoPositivoModal">
					<liferay-ui:message key="chiudi-esito-positivo" />
				</button>
			</c:if>
			
			<c:if test="${hasEsitoNegativo}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />chiudiEsitoNegativoModal">
					<liferay-ui:message key="chiudi-esito-negativo" />
				</button>
			</c:if>
			
			<c:if test="${hasRichiediModificheRichiedente}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />richiediModificheModal">
					<liferay-ui:message key="richiedi-modifiche-integrazioni-richiedente" />
				</button>
			</c:if>
			
			<c:if test="${hasRilascia}">
				<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />rilasciaModal">
					<liferay-ui:message key="rilascia" />
				</button>
			</c:if>
		</div>
	</div>
</c:if>
