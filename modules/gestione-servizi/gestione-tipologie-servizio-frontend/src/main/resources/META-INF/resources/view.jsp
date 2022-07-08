<%@ include file="init.jsp" %>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=GestioneTipologieServizioPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
	<portlet:param name="<%=GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
</portlet:renderURL>

<% List<Tipologia> listaTipologie = (List<Tipologia>) renderRequest.getAttribute(GestioneTipologieServizioPortletKeys.LISTA_TIPOLOGIE); %>

<h2><liferay-ui:message key="elenco-tipologie"/></h2>

<liferay-ui:success key="salvataggio-successo" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:error key="errore-impossibile-ottenere-tipologia" message="impossibile-ottenere-tipologia-specificata"/>
<liferay-ui:error key="salvataggio-errore" message="errore-salvataggio"/>
<liferay-ui:error key="validazione-campi-obbligatori-fallita" message="compilare-tutti-i-campi-per-procedere"/>

<aui:button-row cssClass="text-right">
	<aui:button type="submit" value="cerca" />
	<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
</aui:button-row>

<%@ include file="elencoTipologie.jsp" %>