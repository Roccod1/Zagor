<%@ include file="init.jsp" %>

<portlet:renderURL var="homeURL">
	<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.TAB_ATTIVA %>" value="<%=ScrivaniaCittadinoPortletKeys.SEZIONE_ATTIVITA %>" />
</portlet:renderURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<!-- justify-content-between -->
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
					<aui:button name="allegatoRichiesta${pdfRichiesta.allegatoRichiestaId}" type="cancel" target="_blank" href="${pdfRichiestaURL }" cssClass="btn btn-secondary" icon="icon-file-alt" value="${not empty pdfRichiesta.titolo ? pdfRichiesta.titolo : pdfRichiesta.nome }">
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
							<aui:button name="allegatoRichiesta${allegatoRichiesta.allegatoRichiestaId}" type="cancel" target="_blank" href="${downloadAllegatoURL }" cssClass="btn btn-secondary" icon="icon-file-alt" value="${not empty allegatoRichiesta.titolo ? allegatoRichiesta.titolo : provvedimento.nome }">
							</aui:button>
						</c:forEach>
					</aui:button-row>
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty allegatiProvvedimentiFinali  }">
		<div class="row">
			<div class="col-12">
				<h3 class="uppercase"><liferay-ui:message key="provvedimenti-finali"></liferay-ui:message></h3>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:button-row>
						<c:forEach items="${allegatiProvvedimentiFinali }" var="provvedimento">
							<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_DOWNLOAD_FILE %>" var="downloadAllegatoURL">
								<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_FILE_ID %>" value="${provvedimento.idDocumentale}"/>
							</portlet:resourceURL>
							<aui:button name="provvedimentoRichiesta${provvedimento.allegatoRichiestaId}" type="cancel" target="_blank" href="${downloadAllegatoURL }" cssClass="btn btn-secondary" icon="icon-file-alt" value="${not empty provvedimento.titolo ? provvedimento.titolo : provvedimento.nome }">
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
		<div class="col no-gutters">
		
			<liferay-portlet:renderURL varImpl="iteratorAttivitaURL">
				<portlet:param name="mvcRenderCommandName" value="<%=ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA %>" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_ID %>" value="${richiesta.richiestaId }" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME %>" value="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_ATTIVITA %>"/>
			</liferay-portlet:renderURL>
		
			<liferay-ui:search-container 
				total="${attivitaRichiestaCount}" emptyResultsMessage="nessun-elemento" 
				delta="5" iteratorURL="${iteratorAttivitaURL }" deltaConfigurable="false"
				curParam="<%=ScrivaniaCittadinoPortletKeys.CUR_ATTIVITA %>" deltaParam="<%=ScrivaniaCittadinoPortletKeys.DELTA_ATTIVITA %>">
				
				<liferay-ui:search-container-results results="${attivitaRichiesta}" />
				
				<liferay-ui:search-container-row 
					className="it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta" 
					modelVar="elem" escapedModel="<%=true %>">
					
					<fmt:formatDate value="${elem.modifiedDate}" pattern="dd/MM/yyyy HH:mm" var="elemData" />
					
					<div class="col-12 col-lg-12">
					    <!--start card-->
					    <div class="card-wrapper card-space">
					      <div class="card disable-after">
					        <div class="card-body">
					          <h5 class="card-title">${elemData} - ${elem.stato.replace("_"," ")}</h5>
					          <c:if test="${not empty elem.note }">
						          <p class="card-text">${elem.note}</p>
					          </c:if>
					        </div>
					      </div>
					    </div>
					    <!--end card-->
				  </div>
					
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>		
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3 class="uppercase" id="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_COMMENTI%>"><liferay-ui:message key="commenti"></liferay-ui:message></h3>
		</div>
		<div class="col no-gutters">

			<liferay-portlet:renderURL varImpl="iteratorCommentiURL">
				<portlet:param name="mvcRenderCommandName" value="<%=ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA %>" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.PARAM_ID %>" value="${richiesta.richiestaId }" />
				<portlet:param name="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME %>" value="<%=ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_COMMENTI %>"/>
			</liferay-portlet:renderURL>

			<liferay-ui:search-container 
				total="${commentiRichiestaCount}" emptyResultsMessage="nessun-elemento" 
				delta="5" iteratorURL="${iteratorCommentiURL }" deltaConfigurable="false"
				curParam="<%=ScrivaniaCittadinoPortletKeys.CUR_COMMENTI %>" deltaParam="<%=ScrivaniaCittadinoPortletKeys.DELTA_COMMENTI %>">
				 
				<liferay-ui:search-container-results results="${commentiRichiesta}" /> 
				
				<liferay-ui:search-container-row 
					className="it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta" 
					modelVar="elem" escapedModel="<%=true %>"> 
				
 					<fmt:formatDate value="${elem.getModifiedDate()}" pattern="dd/MM/yyyy HH:mm" var="elemData" /> 
					
					<div class="col-12 col-lg-12">
					    <!--start card-->
					    <div class="card-wrapper card-space">
					      <div class="card disable-after">
					        <div class="card-body">
					          <h5 class="card-title">${elemData}</h5>
					          <p class="card-text">${elem.testo}</p>
					        </div>
					      </div>
					    </div>
					    <!--end card-->
				  	</div>
					
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