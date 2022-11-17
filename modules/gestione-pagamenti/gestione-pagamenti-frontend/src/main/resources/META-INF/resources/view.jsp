<%@ include file="init.jsp" %>

<div class="page-header">
	<h2><liferay-ui:message key="elenco-pagamenti"/></h2>
</div>

<aui:container>
	<aui:row>
		<aui:col md="12">
			<%@ include file="formRicerca.jsp" %>
			<%@ include file="listaPagamenti.jsp" %>
		</aui:col>
	</aui:row>
</aui:container>