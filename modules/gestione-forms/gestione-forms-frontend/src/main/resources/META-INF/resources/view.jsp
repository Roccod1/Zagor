<%@ include file="init.jsp" %>

<%
	List<Form> listaForm = (List<Form>) renderRequest.getAttribute(GestioneFormsPortletKeys.LISTA_FORM);
%>

<liferay-ui:success key="<%=GestioneFormsPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE %>" message="operazione-eseguita-correttamente"/>
<liferay-ui:error key="<%=GestioneFormsPortletKeys.SESSION_MESSAGE_ERRORE_NON_AUTORIZZATO %>" message="non-hai-permessi-sufficienti-per-modificare-processo" />


<div class="page-header">
		<h2><liferay-ui:message key="elenco-form"/></h2>
</div>


<div class="row">
	<div class="col-12">
		<%@ include file="formRicerca.jsp" %>
		<%@ include file="listaForm.jsp" %>
	</div>

</div>


		






	




