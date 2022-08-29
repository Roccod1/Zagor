<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="<%=GestioneProcessiPortletKeys.NOME_RICERCA %>" value="${nomeRicerca}"/>
	<portlet:param name="<%=GestioneProcessiPortletKeys.DATA_INSERIMENTO_DA %>" value="${dataInserimentoDa}"/>
	<portlet:param name="<%=GestioneProcessiPortletKeys.DATA_INSERIMENTO_A %>" value="${dataInserimentoA}"/>
	<portlet:param name="mvcPath" value="<%=GestioneProcessiPortletKeys.JSP_HOME %>"/>
</liferay-portlet:renderURL>

				

<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessun-processo"
			total="<%=listaProcessi.size() %>"
			iteratorURL="${iteratorURL}"
			>
			
			
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaProcessi, searchContainer.getStart(), searchContainer.getEnd()) %>" />
		
		
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneprocessi.model.Processo" modelVar="processo">
			
			
				
				<liferay-ui:search-container-column-text property="<%=GestioneProcessiPortletKeys.CODICE %>" name="<%=GestioneProcessiPortletKeys.CODICE %>" orderable="true" orderableProperty="codice"/>
				<liferay-ui:search-container-column-text property="<%=GestioneProcessiPortletKeys.NOME %>" name="<%=GestioneProcessiPortletKeys.NOME %>" orderable="true" orderableProperty="nome"/>
				
				<fmt:formatDate value="${processo.createDate}" var="createDate" pattern="dd/MM/yyyy HH:mm:ss"/>
				
				<liferay-ui:search-container-column-text value="${createDate}" name="<%=GestioneProcessiPortletKeys.DATA_CREAZIONE %>" orderable="true" orderableProperty="createDate"/>
				
				<liferay-ui:search-container-column-text property="<%=GestioneProcessiPortletKeys.NOME_ENTE %>" name="nomeEnte"/>
				
				
				<portlet:renderURL var="dettaglioNuovoURL">
					<portlet:param name="mvcRenderCommandName" value="/dettaglioNuovo" />
					<portlet:param name="idProcesso" value="${processo.processoId}" />
				</portlet:renderURL>
				
				<portlet:actionURL name="<%=GestioneProcessiPortletKeys.ATTIVA_DISATTIVA_PROCESSO_ACTION_COMMAND %>" var="attivaDisattivaProcessoURL" >
					<portlet:param name="idProcesso" value="${processo.processoId}"/>
				</portlet:actionURL>
				
				<c:choose>
					<c:when test="${processo.groupId == groupIdUtente && processo.attivo eq true}">
						<liferay-ui:search-container-column-text name="<%=GestioneProcessiPortletKeys.AZIONI %>" align="center" value="<a href='${dettaglioNuovoURL}'><i class='icon-edit'></i></a><a href='${attivaDisattivaProcessoURL}'><i class='icon-eye-close'></i></a>"/>
					</c:when>
					<c:when test="${processo.groupId == groupIdUtente && processo.attivo eq false}">
						<liferay-ui:search-container-column-text name="<%=GestioneProcessiPortletKeys.AZIONI %>" align="center" value="<a href='${dettaglioNuovoURL}'><i class='icon-edit'></i></a><a href='${attivaDisattivaProcessoURL}'><i class='icon-eye-open'></i></a>"/>					
					</c:when>
					<c:when test="${organizationIdSitePrincipale == 0 && processo.attivo eq true}">
						<liferay-ui:search-container-column-text name="<%=GestioneProcessiPortletKeys.AZIONI %>" align="center" value="<a href='${dettaglioNuovoURL}'><i class='icon-edit'></i></a><a href='${attivaDisattivaProcessoURL}'><i class='icon-eye-close'></i></a>"/>
					</c:when>
					<c:when test="${organizationIdSitePrincipale == 0 && processo.attivo eq false}">
						<liferay-ui:search-container-column-text name="<%=GestioneProcessiPortletKeys.AZIONI %>" align="center" value="<a href='${dettaglioNuovoURL}'><i class='icon-edit'></i></a><a href='${attivaDisattivaProcessoURL}'><i class='icon-eye-open'></i></a>"/>					
					</c:when>
					<c:when test="${processo.groupId != groupIdUtente}">
						<liferay-ui:search-container-column-text name="<%=GestioneProcessiPortletKeys.AZIONI %>" align="center" value=""/>
					</c:when>
				</c:choose>

			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>