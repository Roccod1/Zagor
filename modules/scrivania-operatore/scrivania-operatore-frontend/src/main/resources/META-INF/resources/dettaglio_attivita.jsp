<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<liferay-ui:search-container total="${attivitaCount}"
                             emptyResultsMessage="nessuna-attivita"
                             delta="10">
	<liferay-ui:search-container-results results="${attivitaList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AttivitaDTO" 
	                                 modelVar="elem">
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
