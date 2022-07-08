<%@ include file="init.jsp" %>

<% List<AreaTematica> listaAreeTematiche = (List<AreaTematica>) renderRequest.getAttribute(GestioneAreeTematichePortletKeys.LISTA_AREE_TEMATICHE); %>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=GestioneAreeTematichePortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_PATH %>" />
	<portlet:param name="<%=GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
</portlet:renderURL>

<h2><liferay-ui:message key="elenco-aree-tematiche"/></h2>

<liferay-ui:success key="<%=GestioneAreeTematichePortletKeys.SALVATAGGIO_SUCCESSO %>" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:error key="<%=GestioneAreeTematichePortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_AREA_TEMATICA %>" message="impossibile-ottenere-area-tematica-specificata"/>
<liferay-ui:error key="<%=GestioneAreeTematichePortletKeys.ERRORE_SALVATAGGIO %>" message="errore-salvataggio"/>
<liferay-ui:error key="<%=GestioneAreeTematichePortletKeys.ERRORE_CAMPI_OBBLIGATORI %>" message="compilare-tutti-i-campi-per-procedere"/>

<aui:button-row cssClass="text-right">
	<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
</aui:button-row>

<%@ include file="elencoAreeTematiche.jsp" %>