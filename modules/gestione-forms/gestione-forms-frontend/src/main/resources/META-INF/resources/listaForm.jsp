<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="<%=GestioneFormsPortletKeys.NOME_RICERCA %>" value="${nomeRicerca}"/>
	<portlet:param name="<%=GestioneFormsPortletKeys.DATA_INSERIMENTO_DA %>" value="${dataInserimentoDa}"/>
	<portlet:param name="<%=GestioneFormsPortletKeys.DATA_INSERIMENTO_A %>" value="${dataInserimentoA}"/>
	<portlet:param name="mvcPath" value="<%=GestioneFormsPortletKeys.JSP_VIEW %>"/>
</liferay-portlet:renderURL>



<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessun-form"
			total="<%=listaForm.size() %>"
			iteratorURL="${iteratorURL}"
			>
			
			
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaForm, searchContainer.getStart(), searchContainer.getEnd()) %>" />
		
		
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneforms.model.Form" modelVar="form">
			
			
				
				<liferay-ui:search-container-column-text property="<%=GestioneFormsPortletKeys.CODICE %>" name="<%=GestioneFormsPortletKeys.CODICE %>" orderable="true" orderableProperty="<%=GestioneFormsPortletKeys.CODICE %>"/>
				<liferay-ui:search-container-column-text property="<%=GestioneFormsPortletKeys.NOME %>" name="<%=GestioneFormsPortletKeys.NOME %>" orderable="true" orderableProperty="<%=GestioneFormsPortletKeys.NOME %>"/>
				
				<fmt:formatDate value="${form.createDate}" var="createDate" pattern="dd/MM/yyyy HH:mm:ss"/>
				
				<liferay-ui:search-container-column-text value="${createDate}" name="<%=GestioneFormsPortletKeys.DATA_CREAZIONE %>" orderable="true" orderableProperty="createDate"/>
				
				<c:choose>
					<c:when test="${form.multiutente eq true}">
						<liferay-ui:search-container-column-text align="center" name="<%=GestioneFormsPortletKeys.MULTIENTE %>" value="<i class='icon-ok text-success'></i>"/>
					</c:when>
					<c:when test="${form.multiutente eq false}">
						<liferay-ui:search-container-column-text  align="center" name="<%=GestioneFormsPortletKeys.MULTIENTE %>" value="<i class='icon-remove text-danger'></i>"/>
					</c:when>
				</c:choose>
				
				<c:choose>
					<c:when test="${form.principale eq true}">
						<liferay-ui:search-container-column-text  align="center" name="<%=GestioneFormsPortletKeys.PRINCIPALE %>" value="<i class='icon-ok text-success'></i>"/>
					</c:when>
					<c:when test="${form.principale eq false}">
						<liferay-ui:search-container-column-text  align="center" name="<%=GestioneFormsPortletKeys.PRINCIPALE %>" value="<i class='icon-remove text-danger'></i>"/>
					</c:when>
				</c:choose>
				
				
				<portlet:renderURL var="dettaglioNuovoURL">
					<portlet:param name="mvcRenderCommandName" value="<%=GestioneFormsPortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND %>" />
					<portlet:param name="<%=GestioneFormsPortletKeys.ID_FORM %>" value="${form.formId}" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="<%=GestioneFormsPortletKeys.AZIONI %>" align="center" value="<i class='icon-edit'></i>" href="${dettaglioNuovoURL}"/>
			
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>