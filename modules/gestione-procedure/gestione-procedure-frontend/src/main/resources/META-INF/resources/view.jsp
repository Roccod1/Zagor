<%@ include file="/init.jsp" %>

<%
	List<Procedura> listaProcedure = (List<Procedura>) renderRequest.getAttribute(GestioneProcedurePortletKeys.LISTA_PROCEDURE);
%>


<div class="page-header">
	<h2><liferay-ui:message key="elenco-procedure"/></h2>
</div>

<div class="row">
	<div class="col-12">
		<%@ include file="formRicerca.jsp" %>
		<%@ include file="listaProcedure.jsp" %>
	</div>	
</div>