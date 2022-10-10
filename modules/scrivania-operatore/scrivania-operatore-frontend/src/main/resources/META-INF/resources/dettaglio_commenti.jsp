<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<%@ include file="dettaglio_azioni_carico.jsp" %>

<c:if test="${inCarico}">
	<div class="row">
		<div class="col-12">
			<button class="btn btn-primary" data-toggle="modal" data-target="#<portlet:namespace />aggiungiCommentoModal">
				<liferay-ui:message key="aggiungi-commento" />
			</button>
		</div>
	</div>
</c:if>

<liferay-ui:search-container total="${commentiCount}"
                             emptyResultsMessage="nessun-commento"
                             delta="10">
	<liferay-ui:search-container-results results="${commentiList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.CommentoDTO" 
	                                 modelVar="elem">
		<fmt:formatDate value="${elem.data}" pattern="dd/MM/yyyy HH:mm" var="elemData" />
    	<liferay-ui:search-container-column-text name="data-ora" value="${elemData}" />
    	<liferay-ui:search-container-column-text name="operatore" value="${elem.operatore}" />
    	<liferay-ui:search-container-column-text name="testo" value="${elem.testo}" />
    	<liferay-ui:search-container-column-text name="visibile-al-cittadino" value="${elem.visibileAlCittadino}" translate="true" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<%@ include file="dettaglio_azioni_carico.jsp" %>

