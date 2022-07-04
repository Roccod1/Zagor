<%@ include file="init.jsp" %>

<%
	List<Servizio> listaServizi = (List<Servizio>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_SERVIZI);
	List<Tipologia> listaTipologie = (List<Tipologia>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE);
	String indirizzoPrecedente = PortalUtil.getCurrentURL(renderRequest);
%>

<h2><liferay-ui:message key="elenco-servizi"/></h2>

<liferay-ui:success key="salvataggio-successo" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:success key="edit-success" message="modifica-avvenuta-con-successo" />
<liferay-ui:error key="validazione-campi-obbligatori-fallita" message="compilare-tutti-i-campi-per-procedere"/>

<%@ include file="formRicerca.jsp" %>
<%@ include file="risultatiRicerca.jsp" %>



