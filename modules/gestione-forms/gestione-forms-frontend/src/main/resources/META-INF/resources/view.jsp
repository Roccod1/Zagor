<%@ include file="init.jsp" %>
<%@page import="it.servizidigitali.gestioneforms.model.Form"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.servizidigitali.gestioneforms.frontend.constants.GestioneFormsPortletKeys"%>

<%
	List<Form> listaForm = (List<Form>) renderRequest.getAttribute(GestioneFormsPortletKeys.LISTA_FORM);
%>

<div class="page-header">
		<h2><liferay-ui:message key="elenco-form"/></h2>
</div>


<div class="row">
	<div class="col-12">
		<%@ include file="formRicerca.jsp" %>
		<%@ include file="listaForm.jsp" %>
	</div>

</div>


		






	




