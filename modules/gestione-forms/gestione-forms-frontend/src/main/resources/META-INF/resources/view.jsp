<%@ include file="init.jsp" %>
<%@page import="it.servizidigitali.gestioneforms.model.Form"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>



<%

	List<Form> listaForm = (List<Form>) renderRequest.getAttribute("listaForm");
%>

<div class="page-header">
				<h2><liferay-ui:message key="elenco-form"/></h2>
</div>


<div class="container mb-4 pl-0 pr-0">
	<aui:form action="" id="form" name="fm">
	<div class="row">
	
			<div class="col-6">
				<div class="form-group">
					<aui:input label="nome" id="nome" name="nome" type="text"/>	
				</div>
			</div>
			

			<div class="col-3">
				<div class="form-group ">
					<aui:input label="data-inserimento-da" id="dataInserimentoDa" name="dataInserimentoDa" type="date"/>			
				</div>	
			</div>
				

			<div class="col-3">
				<div class="form-group ">
					<aui:input label="data-inserimento-a" id="dataInserimentoA" name="dataInserimentoA" type="date"/>	
				</div>
			</div>
			

	</div>
	

		<aui:button-row cssClass="text-right">
			<aui:button type="reset" value="annulla" id="annulla"/>
			<aui:button type="submit" value="cerca" id="cerca"/>
			<aui:button value="nuova" id="nuova"/>
		</aui:button-row>

	</aui:form>	
</div>


		






	<liferay-ui:search-container
			delta="10"
			emptyResultsMessage="non-e-presente-nessun-form"
			total="<%=listaForm.size() %>"
			>
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaForm, searchContainer.getStart(), searchContainer.getEnd()) %>" />
			
			<liferay-ui:search-container-row className="it.servizidigitali.gestioneforms.model.Form" modelVar="form">
				
				<liferay-ui:search-container-column-text property="nome" name="identificativo" />
				<liferay-ui:search-container-column-text property="descrizione" name="denominazione" />
				<liferay-ui:search-container-column-text property="modifiedDate" name="data-aggiornamento" />
				
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
				
				<portlet:renderURL var="dettaglioURL">
					<portlet:param name="mvcRenderCommandName" value="/dettaglio" />
					<portlet:param name="idForm" value="${form.formId}" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="Azioni" align="center" value="<i class='icon-edit'></i>" href="${dettaglioURL}"/>
			
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
		

	</liferay-ui:search-container>




