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

<aui:script use="liferay-form">
	//Chiudi modali nel submit
	var modals = $(".modal");
	modals.find("form").on("submit", function(e) {
		var formId = $(this).attr('id');
	
		var formValidator = Liferay.Form.get(formId).formValidator;
		if (!formValidator.hasErrors()) {
			modals.modal('hide');
		}
	});
</aui:script>

<aui:script use="liferay-form">
	var form = Liferay.Form.get('<portlet:namespace />aggiungiCommentoForm');
	
	var oldRules = form.get('fieldRules');
	var newRules = [
	{
		validatorName: 'required',
		fieldName: '<portlet:namespace />testo'
	}
	];
	
	form.set('fieldRules', oldRules.concat(newRules));
</aui:script>

<aui:script use="liferay-form">
	var form = Liferay.Form.get('<portlet:namespace />aggiungiAllegatoForm');
	
	var oldRules = form.get('fieldRules');
	var newRules = [
	{
		validatorName: 'required',
		fieldName: '<portlet:namespace />titoloDocumento'
	},
	{
		validatorName: 'required',
		fieldName: '<portlet:namespace />allegato'
	}
	];
	
	form.set('fieldRules', oldRules.concat(newRules));
</aui:script>

<c:if test="${inCarico}">
	<c:forEach items="${azioni}" var="azione">
		<c:choose>
			<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_RESPONSABILE'}">
				<aui:script use="liferay-form">
					var form = Liferay.Form.get('<portlet:namespace />assegnaResponsabileForm');
					
					var oldRules = form.get('fieldRules');
					var newRules = [
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />responsabile'
					},
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />commento'
					}
					];
					
					form.set('fieldRules', oldRules.concat(newRules));
				</aui:script>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_ALTRO_RESPONSABILE'}">
				<aui:script use="liferay-form">
					var form = Liferay.Form.get('<portlet:namespace />assegnaAltroResponsabileForm');
					
					var oldRules = form.get('fieldRules');
					var newRules = [
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />responsabile'
					},
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />commento'
					}
					];
					
					form.set('fieldRules', oldRules.concat(newRules));
				</aui:script>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_POSITIVO'}">
				<aui:script use="liferay-form">
					var form = Liferay.Form.get('<portlet:namespace />chiudiEsitoPositivoForm');
					
					var oldRules = form.get('fieldRules');
					var newRules = [
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />commento'
					}
					];
					
					form.set('fieldRules', oldRules.concat(newRules));
				</aui:script>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_NEGATIVO'}">
				<aui:script use="liferay-form">
					var form = Liferay.Form.get('<portlet:namespace />chiudiEsitoNegativoForm');
					
					var oldRules = form.get('fieldRules');
					var newRules = [
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />commento'
					}
					];
					
					form.set('fieldRules', oldRules.concat(newRules));
				</aui:script>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'RIMANDA_REFERENTE'}">
				<aui:script use="liferay-form">
					var form = Liferay.Form.get('<portlet:namespace />rimandaAlReferenteForm');
					
					var oldRules = form.get('fieldRules');
					var newRules = [
					{
						validatorName: 'required',
						fieldName: '<portlet:namespace />commento'
					}
					];
					
					form.set('fieldRules', oldRules.concat(newRules));
				</aui:script>
			</c:when>
			
		</c:choose>
	</c:forEach>
</c:if>