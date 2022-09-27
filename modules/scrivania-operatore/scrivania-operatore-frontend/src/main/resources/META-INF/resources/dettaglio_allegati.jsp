<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<%@ include file="dettaglio_azioni_carico.jsp" %>

<h3><liferay-ui:message key="allegati-richiedente" /></h3>

<liferay-ui:search-container total="${allegatiRichiedenteCount}"
                             emptyResultsMessage="nessun-allegato"
                             delta="10">
	<liferay-ui:search-container-results results="${allegatiRichiedenteList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO" 
	                                 modelVar="elem"
	                                 indexVar="i">
    	<liferay-ui:search-container-column-text name="#" value="${i + 1}" />
    	<liferay-ui:search-container-column-text name="descrizione" value="${elem.descrizione}" />
    	<liferay-ui:search-container-column-text name="nome-file" value="${elem.nomeFile}" />
    	<liferay-ui:search-container-column-text name="dimensione" value="${elem.dimensione}" />
    	<liferay-ui:search-container-column-jsp name="azioni" path="/dettaglio_allegati_azioni.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<h3><liferay-ui:message key="allegati-operatore" /></h3>

<liferay-ui:search-container total="${allegatiOperatoreCount}"
							 emptyResultsMessage="nessun-allegato"
                             delta="10">
	<liferay-ui:search-container-results results="${allegatiOperatoreList}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO" 
	                                 modelVar="elem"
	                                 indexVar="i">
    	<liferay-ui:search-container-column-text name="#" value="${i + 1}" />
    	<liferay-ui:search-container-column-text name="descrizione" value="${elem.descrizione}" />
    	<liferay-ui:search-container-column-text name="nome-file" value="${elem.nomeFile}" />
    	<liferay-ui:search-container-column-text name="inserito-da" value="${elem.nomeOperatore}" />
    	<liferay-ui:search-container-column-text name="vis-richied" value="${elem.visibileAlCittadino}" translate="true" />
    	<liferay-ui:search-container-column-text name="dimensione" value="${elem.dimensione}" />
    	<liferay-ui:search-container-column-jsp name="azioni" path="/dettaglio_allegati_azioni.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<div class="row">
	<div class="col-12 d-flex justify-content-end">
		<button class="btn btn-primary" data-toggle="modal" data-target="#<portlet:namespace />aggiungiAllegatoModal">
			<i class="fas fa-upload"></i>
			<liferay-ui:message key="aggiungi-allegato" />
		</button>
	</div>
</div>

<%@ include file="dettaglio_azioni_carico.jsp" %>

<script>
	$("#<portlet:namespace />aggiungiAllegatoModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
</script>