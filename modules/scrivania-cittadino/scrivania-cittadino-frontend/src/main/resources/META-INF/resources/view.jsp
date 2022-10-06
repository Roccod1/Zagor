<%@ include file="init.jsp" %>

<liferay-ui:error key="<%=ScrivaniaCittadinoPortletKeys.ERROR_IMPOSSIBILE_OTTENERE_DETTAGLIO %>" message="non-e-stato-possibile-ottenere-il-dettaglio-della-richiesta-selezionata"/>

<div>
	<h5>${themeDisplay.realUser.fullName}</h5>
	<small class="text-uppercase"><liferay-ui:message key="cf"/>: ${themeDisplay.user.screenName }</small>
</div>

<liferay-ui:tabs 
	names="<%=ScrivaniaCittadinoPortletKeys.SEZIONE_SCRIVANIA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_ATTIVITA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_MESSAGGI+','+ScrivaniaCittadinoPortletKeys.SEZIONE_SERVIZI %>"
	type="tabs nav-tabs-default"
	param="tabs" 
	refresh="false"
	tabsValues="<%=ScrivaniaCittadinoPortletKeys.SEZIONE_SCRIVANIA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_ATTIVITA+','+ScrivaniaCittadinoPortletKeys.SEZIONE_MESSAGGI+','+ScrivaniaCittadinoPortletKeys.SEZIONE_SERVIZI %>"
	value="${tabAttiva }"
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