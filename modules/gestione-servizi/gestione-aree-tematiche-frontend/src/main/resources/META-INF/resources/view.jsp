<%@ include file="init.jsp" %>

<% List<AreaTematica> listaAreeTematiche = (List<AreaTematica>) renderRequest.getAttribute(GestioneAreeTematichePortletKeys.LISTA_AREE_TEMATICHE); %>

<h2><liferay-ui:message key="elenco-aree-tematiche"/></h2>

<liferay-ui:success key="salvataggio-successo" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:error key="errore-impossibile-ottenere-area-tematica" message="impossibile-ottenere-area-tematica-specificata"/>
<liferay-ui:error key="salvataggio-errore" message="errore-salvataggio"/>
<liferay-ui:error key="validazione-campi-obbligatori-fallita" message="compilare-tutti-i-campi-per-procedere"/>

<aui:button-row cssClass="text-right">
	<aui:button type="submit" value="cerca" />
	<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
</aui:button-row>

<%@ include file="elencoAreeTematiche.jsp" %>