<%@ include file="init.jsp" %>

<liferay-ui:error key="errore-generico" message="errore-generico" />

<portlet:renderURL var="tabURL">
</portlet:renderURL>

<liferay-ui:tabs names="in-arrivo,in-carico,in-itinere-chiusi"
				 tabsValues="in-arrivo,in-carico,in-itinere-chiusi"
                 param="queryTab"
                 value="${queryTab}"
                 url="${tabURL}">
	<liferay-ui:section>
		<%@ include file="tab.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="tab.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="tab.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>