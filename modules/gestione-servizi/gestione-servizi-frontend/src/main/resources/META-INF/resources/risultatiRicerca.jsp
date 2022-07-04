<%@ include file="init.jsp" %>




<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaServizi.size()%>">
	<liferay-ui:search-container-results results="<%=ListUtil.subList(listaServizi, searchContainer.getStart(), searchContainer.getEnd()) %>" />
	<liferay-ui:search-container-row className="it.servizidigitali.gestioneservizi.model.Servizio" modelVar="servizio">
		<liferay-ui:search-container-column-text property="codice" name="codice-servizio" orderable="true" orderableProperty="codice"/>
		<liferay-ui:search-container-column-text property="nome" name="nome" orderable="true" orderableProperty="nome"/>
		<liferay-ui:search-container-column-text property="descrizione" name="descrizione" orderable="true" orderableProperty="descrizione"/>
		<c:choose>
			<c:when test="${servizio.attivo eq true}">
				<liferay-ui:search-container-column-text name="attivo" align="center" value="<i class='icon-ok'></i>" orderable="true" orderableProperty="attivo"/>
			</c:when>
			<c:when test="${servizio.attivo eq false}">
				<liferay-ui:search-container-column-text name="attivo" align="center" value="<i class='icon-remove'></i>" orderable="true" orderableProperty="attivo"/>
			</c:when>
			<c:otherwise>
				<liferay-ui:search-container-column-text name="attivo" align="center" value="" orderable="true" orderableProperty="attivo"/>
			</c:otherwise>
		</c:choose>

		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
			<portlet:param name="servizioId" value="${servizio.servizioId }"/>
			<portlet:param name="indirizzoPrecedente" value="<%=indirizzoPrecedente %>"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>