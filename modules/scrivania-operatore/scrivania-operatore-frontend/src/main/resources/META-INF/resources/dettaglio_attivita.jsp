<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<%@ include file="dettaglio_azioni_carico.jsp" %>

<h3><liferay-ui:message key="attivita" /></h3>

<liferay-ui:search-container total="${attivitaCount}"
                             emptyResultsMessage="nessuna-attivita"
                             delta="10">
	<liferay-ui:search-container-results results="${attivitaList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AttivitaDTO" 
	                                 modelVar="elem">
		<fmt:formatDate value="${elem.data}" pattern="dd/MM/yyyy HH:mm" var="elemData" />
		<liferay-ui:search-container-column-text name="data" value="${elemData}" />
		<liferay-ui:search-container-column-text name="stato" value="${elem.stato}" />
		<liferay-ui:search-container-column-text name="note" value="${elem.note}" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<%@ include file="dettaglio_azioni_carico.jsp" %>
