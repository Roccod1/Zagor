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

<div class="modal fade" tabindex="-1" id="<portlet:namespace />aggiungiCommentoModal">
	<portlet:actionURL var="aggiungiCommentoURL" name="/action/aggiungiCommento">
	</portlet:actionURL>
	
	<aui:form action="${aggiungiCommentoURL}">
		<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
				
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"><liferay-ui:message key="inserisci-modifica-commento" /></h5>
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><liferay-ui:message key="testo" /></label>
						<textarea class="form-control" name="<portlet:namespace />testo">
						</textarea>
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"><liferay-ui:message key="visibile-al-cittadino" /></label>
						<input type="checkbox" class="form-check-input" name="<portlet:namespace />visibileAlCittadino">
					</div>
				</div>
				<div class="modal-footer d-flex justify-content-end">		
					<button type="submit" class="btn btn-primary mr-1">
						<liferay-ui:message key="salva-commento" />
					</button>
					
					<button type="button" class="btn btn-secondary" data-dismiss="modal">
						<liferay-ui:message key="annulla" />
					</button>
				</div>
			</div>
		</div>
	</aui:form>
</div>