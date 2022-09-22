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

<div class="modal fade" tabindex="-1" id="<portlet:namespace />aggiungiAllegatoModal">
	<portlet:actionURL var="aggiungiAllegatoURL" name="/action/aggiungiAllegato">
	</portlet:actionURL>
	
	<aui:form action="${aggiungiAllegatoURL}">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"><liferay-ui:message key="aggiungi-modifica-allegato" /></h5>
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><liferay-ui:message key="titolo-documento" /></label>
						<input class="form-control" name="<portlet:namespace />titoloDocumento">
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"><liferay-ui:message key="visibile-al-cittadino" /></label>
						<input type="checkbox" class="form-check-input" name="<portlet:namespace />visibileAlCittadino">
					</div>
					
					<div class="row">
						<div class="col-12">
							<label><liferay-ui:message key="seleziona-file" /></label>
							<input type="file"
							       id="<portlet:namespace />allegato">
						</div>
					</div>
					
					<div class="row">
						<div class="col-12">
							<button type="button" class="btn btn-secondary" id="<portlet:namespace />btnRimuovi">
								<liferay-ui:message key="rimuovi" />
							</button>
							<button type="button" class="btn btn-secondary" id="<portlet:namespace />btnCarica">
								<liferay-ui:message key="carica" />
							</button>
							<button type="button" class="btn btn-primary" id="<portlet:namespace />btnSfoglia">
								<liferay-ui:message key="sfoglia" />...
							</button>
						</div>
					</div>
				</div>
				<div class="modal-footer d-flex justify-content-end">		
					<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="annulla" /></button>
					
					<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
					<aui:input type="hidden" name="fileId" />
					
					<button id="<portlet:namespace />btnSalva" type="button" class="btn btn-primary ml-1">
						<liferay-ui:message key="salva-allegato" />
						<i class="fas fa-upload"></i>
					</button>
				</div>
			</div>
		</div>
	</aui:form>
</div>

<portlet:resourceURL var="uploadAllegatoURL" id="/resource/uploadAllegato">
</portlet:resourceURL>

<script>
	var allegatoNode = $("#<portlet:namespace />allegato");
	var fileNode = $("#<portlet:namespace />fileId");
	
	$("#<portlet:namespace />btnSalva").on("click", function() {
		console.log(1);
		if (fileNode.val() == "") {
			alert("carica-un-file");
		} else {
			$(this).parents("form").submit();
		}
	});
	
	$("#<portlet:namespace />btnRimuovi").on("click", function() {
		fileNode.val("");
		allegatoNode.val("");
	});
	$("#<portlet:namespace />btnSfoglia").on("click", function() {
		fileNode.val("");
		allegatoNode.click();
	});
	$("#<portlet:namespace />btnCarica").on("click", function() {
		if (allegatoNode.val() == "") {
			alert("seleziona-file-da-caricare");
		} else if (fileNode.val() != "") {
			alert("file-gia-caricato");
		} else {
			var fd = new FormData();
			var file = allegatoNode[0].files[0];
			
			fd.append('<portlet:namespace />allegato', file); 	
		
			$.ajax({
				url: '${uploadAllegatoURL}',
				type: 'POST',
				data: fd,
				processData: false,
				contentType: false,
				success: function (response) {
					var data = JSON.parse(response);
					
					console.log(2);
					if (data.error != undefined) {
						alert("errore-upload");
					} else {
						fileNode.val(data.fileId);
					}
				}
			});
		}
	});
</script>