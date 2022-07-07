<%@ include file="init.jsp" %>

<%
	List<Servizio> listaServizi = (List<Servizio>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI);
	List<Tipologia> listaTipologie = (List<Tipologia>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE);
%>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<h2><liferay-ui:message key="elenco-servizi"/></h2>

<liferay-ui:success key="salvataggio-successo" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:error key="salvataggio-errore" message="errore-salvataggio"/>
<liferay-ui:error key="errore-impossibile-ottenere-servizio" message="impossibile-ottenere-servizio-specificato"/>
<liferay-ui:error key="validazione-campi-obbligatori-fallita" message="compilare-tutti-i-campi-per-procedere" />

<%@ include file="formRicerca.jsp" %>
<%@ include file="risultatiRicerca.jsp" %>



