<%@ include file="init.jsp" %>

<%-- <liferay-ui:error key="<%=ProfiloUtenteMieiDatiPortletKeys.ERRORE_GENERICO %>" message="errore-generico"/> --%>

<liferay-ui:tabs 
	names="<%=ProfiloUtenteMieiDatiPortletKeys.SEZIONE_DATI_ANAGRAFICI + ','
		+ ProfiloUtenteMieiDatiPortletKeys.SEZIONE_CONTATTI + ','
		+ ProfiloUtenteMieiDatiPortletKeys.SEZIONE_NUCLEO_FAMILIARE%>"
	type="tabs nav-tabs-default"
	param="tabs2" 
	refresh="false"
	tabsValues="<%=ProfiloUtenteMieiDatiPortletKeys.SEZIONE_DATI_ANAGRAFICI + ','
		+ ProfiloUtenteMieiDatiPortletKeys.SEZIONE_CONTATTI + ','
		+ ProfiloUtenteMieiDatiPortletKeys.SEZIONE_NUCLEO_FAMILIARE%>"
		
	value="${tabAttiva}"
	>
		<liferay-ui:section>
			<%@ include file="datiAnagrafici.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="contatti.jsp" %>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<%@ include file="nucleoFamiliare.jsp" %>
		</liferay-ui:section>
</liferay-ui:tabs>