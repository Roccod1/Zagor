<%@ include file="/init.jsp" %>

<%
	List<Processo> listaProcessi = (List<Processo>) renderRequest.getAttribute(GestioneProcessiPortletKeys.LISTA_PROCESSI);
%>

<liferay-ui:success key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE %>" message="operazione-eseguita-correttamente"/>
<liferay-ui:error key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO %>" message="compilare-tutti-i-campi-obbligatori" />
<liferay-ui:error key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_ATTIVA_DISATTIVA_PROCESSO %>" message="impossibile-cambiare-lo-stato-del-processo" />

<liferay-ui:error key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_PROCESSO_CODICE_ESISTENTE %>" message="esiste-gia-un-processo-con-codice-specificato" />

<div class="page-header">
	<h2><liferay-ui:message key="elenco-processi"/></h2>
</div>


<div class="row">
	<div class="col-12">
		<%@ include file="formRicerca.jsp" %>
		<%@ include file="listaProcessi.jsp" %>
	</div>	
</div>