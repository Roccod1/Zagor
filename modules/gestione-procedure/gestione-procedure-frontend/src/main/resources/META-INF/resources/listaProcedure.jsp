<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="<%=GestioneProcedurePortletKeys.NOME_RICERCA %>" value="${nomeRicerca}"/>
	<portlet:param name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA %>" value="${dataInserimentoDa}"/>
	<portlet:param name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_A %>" value="${dataInserimentoA}"/>
	<portlet:param name="mvcPath" value="<%=GestioneProcedurePortletKeys.JSP_HOME %>"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessuna-procedura"
			total="<%=listaProcedure.size() %>"
			iteratorURL="${iteratorURL}"
			>
			
			
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaProcedure, searchContainer.getStart(), searchContainer.getEnd()) %>" />
		
		
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneprocedure.model.Procedura" modelVar="procedura">
			
			
				
				<liferay-ui:search-container-column-text property="<%=GestioneProcedurePortletKeys.NOME %>" name="<%=GestioneProcedurePortletKeys.NOME %>" orderable="true" orderableProperty="nome"/>
				
				<fmt:formatDate value="${processo.createDate}" var="createDate" pattern="dd/MM/yyyy HH:mm:ss"/>
				
				<liferay-ui:search-container-column-text value="${createDate}" name="<%=GestioneProcedurePortletKeys.DATA_CREAZIONE %>" orderable="true" orderableProperty="createDate"/>
				
				<portlet:renderURL var="dettaglioNuovoURL">
					<portlet:param name="mvcRenderCommandName" value="/dettaglioNuovo" />
					<portlet:param name="idProcedura" value="${procedura.proceduraId}" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text property="<%=GestioneProcedurePortletKeys.STATO %>" name="<%=GestioneProcedurePortletKeys.STATO %>" orderable="true" orderableProperty="stato"/>
				


			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>