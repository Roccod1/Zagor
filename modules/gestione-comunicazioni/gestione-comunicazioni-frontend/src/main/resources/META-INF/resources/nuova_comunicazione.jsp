<%@ include file="/init.jsp" %>

<portlet:actionURL var="inserisciURL" name="/action/inserisci">
</portlet:actionURL>

<portlet:resourceURL var="ricercaUtentiURL" id="/resource/ricercaUtenti">
</portlet:resourceURL>

<portlet:renderURL var="indietroURL">
</portlet:renderURL>

<liferay-ui:error key="errore-generico" message="errore-generico" />
<liferay-ui:error key="errore-titolo" message="errore-titolo" />
<liferay-ui:error key="errore-descrizione" message="errore-descrizione" />
<liferay-ui:error key="errore-organizzazione" message="errore-organizzazione" />
<liferay-ui:error key="errore-data-fine" message="errore-data-fine" />

<aui:form action="${inserisciURL}">
	<aui:input name="titolo" label="titolo-obbl"/>
	<aui:select name="tipologia">
		<c:forEach items="${tipologie}" var="tipologia">
			<aui:option value="${tipologia.id}">${tipologia.nome}</aui:option>
		</c:forEach>
	</aui:select>
	
	<liferay-editor:editor name="descrizione"
	                       placeholder="descrizione-obbl"
	                       editorName="ckeditor" />
	
	<label><liferay-ui:message key="data-inizio" /></label>
	<input type="datetime-local"
		   id="<portlet:namespace/>dataInizio"
		   name="<portlet:namespace/>dataInizio">
	
	<label><liferay-ui:message key="data-fine" /></label>
	<input type="datetime-local" 
		   id="<portlet:namespace/>dataFine"
	       name="<portlet:namespace/>dataFine">
	
	<aui:select name="procedura">
		<aui:option value="-"><liferay-ui:message key="nessuna" /></aui:option>
	</aui:select>
	
	<aui:select name="organizzazione" label="organizzazione-obbl">
		<aui:option value="0"><liferay-ui:message key="seleziona-una-organizzazione" /></aui:option>
		<c:forEach items="${organizzazioni}" var="organizzazione">
			<aui:option value="${organizzazione.id}">${organizzazione.nome}</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:input name="utenteQuery" label="utente" />
	<aui:input type="hidden" name="utente" />

	<a href="${indietroURL}" class="btn btn-secondary"><liferay-ui:message key="annulla" /></a>
	<aui:button type="submit" value="inserisci" />
</aui:form>

<script>
	
	var pickerInizio = $("#<portlet:namespace/>dataInizio");
	var pickerFine = $("#<portlet:namespace/>dataFine");
	
	pickerInizio.on('change', function(e) {
		var newValue = e.target.value;
		
		if (newValue == '') {
			pickerFine.removeAttr('min');
		} else {
			pickerFine.attr('min', newValue);
		}
	});
	pickerFine.on('change', function(e) {
		var newValue = e.target.value;
	
		if (newValue == '') {
			pickerInizio.removeAttr('max');
		} else {
			pickerInizio.attr('max', newValue);
		}
	});
	
	$("#<portlet:namespace/>organizzazione").on('change', function(e) {
		$("#<portlet:namespace/>utenteQuery").val('<liferay-ui:message key="seleziona-tutti" />');
		$("#<portlet:namespace/>utente").val("");
	});
	
	var acLimit = 10;
	AUI().use('autocomplete-list', 'datasource-io', function(A) {
		var datasource = new A.DataSource.IO({
			source: '${ricercaUtentiURL}'
		});
		var autoComplete = new A.AutoCompleteList({
			allowBrowserAutocomplete: false,
			activateFirstItem: true,
			inputNode: '#<portlet:namespace/>utenteQuery',
			on: {
				query: function(event) {
					//$("#" + cfg.loading).show();
				},
				select: function(event) {
					var result = event.result.raw;
					$("#<portlet:namespace/>utente").val(result.id);
				},
				results: function(event) {
					//$("#" + cfg.loading).hide();
				},
				clear: function(event) {
					//$("#" + cfg.output).val('');
					//$("#" + cfg.loading).hide();
				}
			},
			render: true,
			source: datasource,
			minQueryLength: 4,
			requestTemplate: function(query) {
				var organizzazione = $("#<portlet:namespace/>organizzazione").val();
				
				var template = '&<portlet:namespace/>query=' + query;
				template += '&<portlet:namespace/>organizzazione=' + organizzazione;
				template += '&<portlet:namespace/>limit=' + acLimit;
				
				return template;
			},
			resultListLocator: function (response) {
				var responseData = JSON.parse(response[0].responseText);
				var allObj = {
					id: 0,
					cf: null,
					nome: null
				};
				responseData.splice(0, 0, allObj);
				return responseData;
			},
			resultTextLocator: function (result) {
				if (result.id == 0) {
					return '<liferay-ui:message key="seleziona-tutti" />';
				} else {
					return result.cf + ' - ' + result.nome;
				}
			},
			width: 400,
			maxResults: acLimit
		});
	});
</script>