<%@ include file="/init.jsp" %>

<liferay-ui:success key="<%=GestionePagamentiFrontendPortletKeys.SESSION_MESSAGE_RICERCA_ESEGUITA_CORRETTAMENTE %>" message="message.ricerca-eseguita-correttamente"/>

<aui:container>
	<aui:row>
		<aui:col md="12">
			<%@ include file="formRicerca.jsp" %>
			<%@ include file="listaPagamenti.jsp" %>
		</aui:col>
	</aui:row>
</aui:container>