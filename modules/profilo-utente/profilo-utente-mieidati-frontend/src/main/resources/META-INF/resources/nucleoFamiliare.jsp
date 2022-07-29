<%@ include file="init.jsp" %>

<%
	List<DatiAnagrafici.ComponenteNucleoFamiliare> listaComponentiNucleoFamiliare = (List<DatiAnagrafici.ComponenteNucleoFamiliare>) renderRequest.getAttribute(ProfiloUtenteMieiDatiPortletKeys.COMPONENTI_NUCLEO_FAMILIARE);
%>

<c:set value="<%=SessionErrors.contains(renderRequest, ProfiloUtenteMieiDatiPortletKeys.ERRORE_BACKOFFICE) %>" var="backofficeError" />

<c:choose>
	<c:when test="${backofficeError eq true }">
		<div class="alert alert-danger" role="alert">
		  <liferay-ui:message key="errore-backoffice"/>
		</div>
	</c:when>
	
	<c:otherwise>
		<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="mvcPath" value="/view.jsp" />
			<portlet:param name="<%=ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA %>" value="<%=ProfiloUtenteMieiDatiPortletKeys.SEZIONE_NUCLEO_FAMILIARE %>"/>
		</liferay-portlet:renderURL>
	
		<div class="container pl-0 pr-0 mb-4 mt-4">
			<liferay-ui:search-container delta="10" emptyResultsMessage="non-ci-sono-dati-da-visualizzare" total="<%=listaComponentiNucleoFamiliare.size()%>"  iteratorURL="${iteratorURL}" >
				<liferay-ui:search-container-results results="<%=ListUtil.subList(listaComponentiNucleoFamiliare, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
				<liferay-ui:search-container-row className="it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici.ComponenteNucleoFamiliare" modelVar="componente" >
					<liferay-ui:search-container-column-text property="codiceFiscale" name="codice-fiscale"/>
					<liferay-ui:search-container-column-text property="cognome" name="cognome"/>
					<liferay-ui:search-container-column-text property="nome" name="nome"/>
					
					<fmt:formatDate type="date" value="${componente.dataNascita}" dateStyle="long" var="dataNascitaNucleoFamiliareFromattato"/>
					<liferay-ui:search-container-column-text value="${dataNascitaNucleoFamiliareFromattato }" name="data-di-nascita"/>
					
					<liferay-ui:search-container-column-text property="relazioneParentela.descrizione" name="relazione-parentela"/>
					<portlet:renderURL var="dettaglioComponenteFamiliareURL">
						<portlet:param name="mvcRenderCommandName" value="<%=ProfiloUtenteMieiDatiPortletKeys.DETTAGLIO_COMPONENTE_NUCLEO_FAMILIARE_RENDER_COMMAND_NAME %>" />
						<portlet:param name="<%=ProfiloUtenteMieiDatiPortletKeys.CODICE_FISCALE %>" value="${componente.codiceFiscale}"/>
					</portlet:renderURL>
					<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${dettaglioComponenteFamiliareURL}'><i class='icon-info-sign'></i></a>"/>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</c:otherwise>
</c:choose>