<%@page import="it.servizidigitali.gestioneservizi.frontend.constants.GestioneServiziPortletKeys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.servizidigitali.gestioneservizi.model.Servizio"%>
<%@ include file="init.jsp" %>

<%
	List<Servizio> listaServizi = (List<Servizio>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI);
%>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
</portlet:renderURL>

<h2><liferay-ui:message key="elenco-servizi"/></h2>

<liferay-ui:success key="save-success" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:success key="edit-success" message="modifica-avvenuta-con-successo" />

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form id="ricercaServiziForm" action="" method="post" modelAttribute="">
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="soloServiziAttiviCheckBox" class="form-check-input" label="solo-servizi-attivi"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="nome" label="nome"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="codiceServizio" label="codice-servizio"></aui:input>
				</div>
			</div>
		</div>	
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="cerca" />
			<aui:button type="reset" value="annulla" />
			<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
		</aui:button-row>
	</aui:form>
</div>


<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaServizi.size()%>">
	<liferay-ui:search-container-results results="<%=listaServizi %>" />
	<liferay-ui:search-container-row className="it.servizidigitali.gestioneservizi.model.Servizio" modelVar="servizio">
		<liferay-ui:search-container-column-text property="codice" name="codice-servizio" />
		<liferay-ui:search-container-column-text property="nome" name="nome" />
		<liferay-ui:search-container-column-text property="descrizione" name="descrizione" />
		<c:choose>
			<c:when test="${servizio.attivo eq true}">
				<liferay-ui:search-container-column-text name="attivo" align="center" value="<i class='icon-ok'></i>"/>
			</c:when>
			<c:when test="${servizio.attivo eq false}">
				<liferay-ui:search-container-column-text name="attivo" align="center" value="<i class='icon-remove'></i>"/>
			</c:when>
			<c:otherwise>
				<liferay-ui:search-container-column-text name="attivo" align="center" value=""/>
			</c:otherwise>
		</c:choose>
		
		<liferay-ui:search-container-column-text name="azioni" align="center" value="<i class='icon-edit'></i>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

