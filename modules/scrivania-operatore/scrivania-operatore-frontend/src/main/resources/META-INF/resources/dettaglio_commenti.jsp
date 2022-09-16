<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<liferay-ui:search-container total="${commentiCount}"
                             emptyResultsMessage="nessun-commento"
                             delta="10">
	<liferay-ui:search-container-results results="${commentiList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.CommentoDTO" 
	                                 modelVar="elem">
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
