<%@ include file="init.jsp" %>

<portlet:renderURL var="homeURL">
	<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.TAB_ATTIVA %>" value="<%=ScrivaniaCittadinoPortletKeys.SEZIONE_ATTIVITA %>" />
</portlet:renderURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
<!-- 	justify-content-between -->
	<div class="row">
		<div class="col">
			<h3 class="uppercase"><liferay-ui:message key="dati-della-richiesta"></liferay-ui:message></h3>
		</div>
	</div>

		
	<div class="row">
		<div class="col">
			<div class="form-group">
				<label><liferay-ui:message key="id-richiesta"/></label>
				<span class="form-control">
					<c:out value="${richiesta.richiestaId}"/>
				</span>
			</div>
		</div>
		
		
		<div class="col">
			<div class="form-group">
				<label><liferay-ui:message key="stato"/></label>
				<span class="form-control">
					<c:out value="${richiesta.stato.replace(\"_\",\" \")}"/>
				</span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<div class="form-group">
				<label><liferay-ui:message key="protocollo"/></label>
				<span class="form-control">
					<c:out value="${richiesta.numeroProtocollo}"/>
				</span>
			</div>
		</div>
		

		<fmt:formatDate value="${richiesta.modifiedDate}" pattern="dd/MM/yyyy HH:mm" var="richiestaModifiedDate" />		
		<div class="col">
			<div class="form-group">
				<label><liferay-ui:message key="data-ultima-modifica"/></label>
				<span class="form-control">
					<c:out value="${richiestaModifiedDate}"/>
				</span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<div class="form-group">
				<label><liferay-ui:message key="oggetto"/></label>
				<span class="form-control">
					<c:out value="${richiesta.oggetto}"/>
				</span>
	      	</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<div class="form-group">
		        <aui:input name="note" label="note"  type="textarea" autoSize="true" resizable="false" value="${richiesta.note}" readonly="true" cssClass="readonly-text"/>
			</div>
		</div>
	</div>
	
	<c:if test="${not empty pdfRichiesta  }">
		<div class="row">
			<div class="col-12">
				<h3 class="uppercase"><liferay-ui:message key="pdf-richiesta"></liferay-ui:message></h3>
			</div>
			<div class="col">
				<div class="form-group">
					<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_DOWNLOAD_FILE %>" var="pdfRichiestaURL">
						<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_FILE_ID %>" value="${pdfRichiesta.idDocumentale}"/>
					</portlet:resourceURL>
					<aui:button name="allegatoRichiesta${allegatoRichiesta.allegatoRichiestaId}" type="cancel" target="_blank" href="${pdfRichiestaURL }" cssClass="btn btn-secondary" icon="icon-file-alt" value="${allegatoRichiesta.nome }">
					</aui:button>
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty allegatiRichiesta  }">
		<div class="row">
			<div class="col-12">
				<h3 class="uppercase"><liferay-ui:message key="allegati"></liferay-ui:message></h3>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:button-row>
						<c:forEach items="${allegatiRichiesta }" var="allegatoRichiesta">
							<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_DOWNLOAD_FILE %>" var="downloadAllegatoURL">
								<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_FILE_ID %>" value="${allegatoRichiesta.idDocumentale}"/>
							</portlet:resourceURL>
							<aui:button name="allegatoRichiesta${allegatoRichiesta.allegatoRichiestaId}" type="cancel" target="_blank" href="${downloadAllegatoURL }" cssClass="btn btn-secondary" icon="icon-file-alt" value="${allegatoRichiesta.nome }">
							</aui:button>
						</c:forEach>
					</aui:button-row>
				</div>
			</div>
		</div>
	</c:if>
	
	<div class="row">
		<div class="col-12">
			<h3 class="uppercase" id="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_ATTIVITA%>"><liferay-ui:message key="attivita"></liferay-ui:message></h3>
		</div>
		<div class="col">
		
			<liferay-portlet:renderURL varImpl="iteratorAttivitaURL">
				<portlet:param name="mvcRenderCommandName" value="<%=ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA %>" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_ID %>" value="${richiesta.richiestaId }" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME %>" value="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_ATTIVITA %>"/>
			</liferay-portlet:renderURL>
		
			<liferay-ui:search-container 
						total="${attivitaRichiestaCount}"
		                   emptyResultsMessage="nessun-elemento"
		                   delta="<%=ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA %>"
		                   iteratorURL="${iteratorAttivitaURL }"
		                   curParam="<%=ScrivaniaCittadinoPortletKeys.CUR_ATTIVITA %>">
				<liferay-ui:search-container-results results="${attivitaRichiesta}" />
				
				<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta" modelVar="elem">
					<fmt:formatDate value="${elem.modifiedDate}" pattern="dd/MM/yyyy HH:mm" var="elemData" />
					<liferay-ui:search-container-column-text name="data" value="${elemData}" />
					<liferay-ui:search-container-column-text name="stato" value="${elem.stato.replace(\"_\",\" \")}" />
					<liferay-ui:search-container-column-text name="note" value="${elem.note}" />
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>		
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3 class="uppercase" id="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_COMMENTI%>"><liferay-ui:message key="commenti"></liferay-ui:message></h3>
		</div>
		<div class="col">
			<liferay-portlet:renderURL varImpl="iteratorCommentiURL">
				<portlet:param name="mvcRenderCommandName" value="<%=ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA %>" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_ID %>" value="${richiesta.richiestaId }" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME %>" value="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_COMMENTI %>"/>
			</liferay-portlet:renderURL>
			<liferay-ui:search-container 
						total="${commentiRichiestaCount}"
		                   emptyResultsMessage="nessun-elemento"
		                   delta="<%=ScrivaniaCittadinoPortletKeys.DEFAULT_DELTA %>"
		                   iteratorURL="${iteratorCommentiURL }"
		                   curParam="<%=ScrivaniaCittadinoPortletKeys.CUR_COMMENTI %>"
		                   >
				<liferay-ui:search-container-results results="${commentiRichiesta}" />
				
				<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta" modelVar="elem">
					<fmt:formatDate value="${elem.modifiedDate}" pattern="dd/MM/yyyy HH:mm" var="elemData" />
					<liferay-ui:search-container-column-text name="data"  value="${elemData}"/>
					<liferay-ui:search-container-column-text name="testo" property="testo" />
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>			
		</div>
	</div>
		
	<aui:button-row cssClass="text-right">
		<aui:button type="cancel" value="chiudi" href="${homeURL}"/>
	</aui:button-row>

</div>

<script type="text/javascript">
	var anchorName = "${searchContainerName}"

	$(function(){
		if(anchorName && anchorName.length > 0){
			var jqueryAnchorObject = $("#"+anchorName);
			if(jqueryAnchorObject != 'undefined'){
				$(jqueryAnchorObject).get(0).scrollIntoView({ behavior: 'smooth' }); 			
			}
		}
	});
</script>