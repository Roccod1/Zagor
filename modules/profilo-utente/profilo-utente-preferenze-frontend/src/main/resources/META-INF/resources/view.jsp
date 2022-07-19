<%@ include file="init.jsp" %>

<portlet:renderURL var="inserisciModificaURL">
	<portlet:param name="mvcRenderCommandName" value="<%=ProfiloUtentePreferenzePortletKeys.RENDER_INSERISCI_MODIFICA %>"/>
</portlet:renderURL>

<liferay-ui:tabs 
	names="<%=ProfiloUtentePreferenzePortletKeys.SEZIONE_PREFERENZE+','+ProfiloUtentePreferenzePortletKeys.SEZIONE_PRIVACY %>"
	type="tabs nav-tabs-default"
	param="tabs2" 
	refresh="false">
		<liferay-ui:section>
			<%@ include file="preferenze.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="privacy.jsp" %>
		</liferay-ui:section>
</liferay-ui:tabs>