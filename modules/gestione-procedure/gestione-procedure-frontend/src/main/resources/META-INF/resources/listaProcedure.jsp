<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="<%=GestioneProcedurePortletKeys.NOME_RICERCA %>" value="${nomeRicerca}"/>
	<portlet:param name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA %>" value="${dataInserimentoDa}"/>
	<portlet:param name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_A %>" value="${dataInserimentoA}"/>
	<portlet:param name="mvcPath" value="<%=GestioneProcedurePortletKeys.JSP_HOME %>"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessuna-procedura"
			total="${totaleElementi}"
			iteratorURL="${iteratorURL}"
			>
			
			
		
		<liferay-ui:search-container-results results="<%=listaProcedure%>" />
		
		
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneprocedure.model.Procedura" modelVar="procedura">
			
			
				
				<liferay-ui:search-container-column-text property="<%=GestioneProcedurePortletKeys.NOME %>" name="<%=GestioneProcedurePortletKeys.NOME %>" orderable="true" orderableProperty="nome"/>
				
				<fmt:formatDate value="${procedura.createDate}" var="createDate" pattern="dd/MM/yyyy HH:mm:ss"/>
				
				<liferay-ui:search-container-column-text value="${createDate}" name="<%=GestioneProcedurePortletKeys.DATA_CREAZIONE %>" orderable="true" orderableProperty="createDate"/>
				
				<portlet:renderURL var="dettaglioNuovoURL">
					<portlet:param name="mvcRenderCommandName" value="/dettaglioNuovo" />
					<portlet:param name="idProcedura" value="${procedura.proceduraId}" />
				</portlet:renderURL>
				
				<c:choose>
					<c:when test="${procedura.attiva eq true}">
						<liferay-ui:search-container-column-text align="center" name="<%=GestioneProcedurePortletKeys.STATO %>" value="<i class='icon-ok text-success'></i>"/>
					</c:when>
					<c:when test="${procedura.attiva eq false}">
						<liferay-ui:search-container-column-text  align="center" name="<%=GestioneProcedurePortletKeys.STATO %>" value="<i class='icon-remove text-danger'></i>"/>
					</c:when>
				</c:choose>

				
				<liferay-ui:search-container-column-text name="<%=GestioneProcedurePortletKeys.AZIONI %>" align="center" value="<a href='${dettaglioNuovoURL}'><i class='icon-edit'></i></a>"/>
				

			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>