<liferay-ui:success key="eseguito-correttamente" message="operazione-eseguita-correttamente"/>
<liferay-ui:error key="errore-salvataggio" message="compilare-tutti-i-campi-obbligatori" />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="codice" value="${codice}"/>
	<portlet:param name="dataInserimentoDa" value="${dataInserimentoDa}"/>
	<portlet:param name="dataInserimentoA" value="${dataInserimentoA}"/>
	<portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>



<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessun-form"
			total="<%=listaForm.size() %>"
			iteratorURL="${iteratorURL}"
			>
			
			
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaForm, searchContainer.getStart(), searchContainer.getEnd()) %>" />
		
		
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneforms.model.Form" modelVar="form">
			
			
				
				<liferay-ui:search-container-column-text property="codice" name="codice" orderable="true" orderableProperty="codice"/>
				<liferay-ui:search-container-column-text property="descrizione" name="descrizione" orderable="true" orderableProperty="descrizione"/>
				
				<fmt:formatDate value="${form.createDate}" var="createDate" pattern="dd/MM/yyyy HH:mm:ss"/>
				
				<liferay-ui:search-container-column-text value="${createDate}" name="data-creazione" orderable="true" orderableProperty="createDate"/>
				
				<c:choose>
					<c:when test="${form.multiutente eq true}">
						<liferay-ui:search-container-column-text align="center" name="multiente" value="<i class='icon-ok'></i>"/>
					</c:when>
					<c:when test="${form.multiutente eq false}">
						<liferay-ui:search-container-column-text  align="center" name="multiente" value="<i class='icon-remove'></i>"/>
					</c:when>
				</c:choose>
				
				<c:choose>
					<c:when test="${form.principale eq true}">
						<liferay-ui:search-container-column-text  align="center" name="principale" value="<i class='icon-ok'></i>"/>
					</c:when>
					<c:when test="${form.principale eq false}">
						<liferay-ui:search-container-column-text  align="center" name="principale" value="<i class='icon-remove'></i>"/>
					</c:when>
				</c:choose>
				
				
				<portlet:renderURL var="dettaglioNuovoURL">
					<portlet:param name="mvcRenderCommandName" value="/dettaglioNuovo" />
					<portlet:param name="idForm" value="${form.formId}" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="azioni" align="center" value="<i class='icon-edit'></i><i class='fa fa-trash'></i>" href="${dettaglioNuovoURL}"/>
			
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>