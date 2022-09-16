<%@ include file="init.jsp" %>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="${richiesta.id}" />
	<portlet:param name="isMain" value="false" />
</portlet:renderURL>

<liferay-ui:tabs names="dati-identificativi,allegati,commenti,attivita"
                 tabsValues="dati-identificativi,allegati,commenti,attivita"
                 param="dettaglioTab"
                 value="${dettaglioTab}"
                 url="${dettaglioURL}">
	<liferay-ui:section>
		<%@ include file="dettaglio_dati_identificativi.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="dettaglio_allegati.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="dettaglio_commenti.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="dettaglio_attivita.jsp" %>
	</liferay-ui:section>
	
</liferay-ui:tabs>