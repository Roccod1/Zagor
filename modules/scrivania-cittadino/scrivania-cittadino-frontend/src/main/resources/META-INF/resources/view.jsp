<%@page import="it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys"%>
<%@ include file="init.jsp" %>

<div>
	<h5>${themeDisplay.realUser.fullName}</h5>
	<small>CF: CODICE FISCALE</small>
</div>

<liferay-ui:tabs 
	names="<%=ScrivaniaCittadinoPortletKeys.SEZIONE_SCRIVANIA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_ATTIVITA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_MESSAGGI+','+ScrivaniaCittadinoPortletKeys.SEZIONE_SERVIZI %>"
	type="tabs nav-tabs-default"
	param="tabs" 
	refresh="false"
	>
		<liferay-ui:section>
			<%@ include file="scrivania.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="attivita.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="messaggi.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="servizi.jsp" %>
		</liferay-ui:section>
</liferay-ui:tabs>