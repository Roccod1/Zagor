<%@ include file="init.jsp" %>

<liferay-ui:error key="errore-generico" message="errore-generico" />

<%@ include file="dettaglio_modali.jsp" %>

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

<script>
	$("#<portlet:namespace />chiudiEsitoNegativoModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
	$("#<portlet:namespace />chiudiEsitoPositivoModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
	$("#<portlet:namespace />assegnaResponsabileModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
	$("#<portlet:namespace />assegnaAltroResponsabileModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
	$("#<portlet:namespace />rilasciaModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
	$("#<portlet:namespace />rimandaAlReferenteModal").find(".submit").on("click", function() {
		$(this).parents("form").submit();
	});
	
</script>
