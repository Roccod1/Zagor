<%@ include file="/init.jsp" %>

<portlet:actionURL var="inserisciURL" name="/action/inserisci">
</portlet:actionURL>

<aui:form action="${inserisciURL}">
	<aui:input name="titolo" />
	<aui:select name="tipologia">
		<c:forEach items="${tipologie}" var="tipologia">
			<aui:option value="${tipologia.id}">${tipologia.nome}</aui:option>
		</c:forEach>
	</aui:select>
	
	<liferay-editor:editor name="descrizione"
	                       placeholder="descrizione"
	                       editorName="ckeditor" />
	
	<label><liferay-ui:message key="data-inizio" /></label>
	<input type="datetime-local" name="<portlet:namespace/>dataInizio">
	
	<label><liferay-ui:message key="data-fine" /></label>
	<input type="datetime-local" name="<portlet:namespace/>dataFine">
	
	<aui:select name="procedura">
		<aui:option value="-"><liferay-ui:message key="nessuna" /></aui:option>
	</aui:select>
	
	<aui:select name="organizzazione">
		<c:forEach items="${organizzazioni}" var="organizzazione">
			<aui:option value="${organizzazione.id}">${organizzazione.nome}</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:select name="utente">
		<c:forEach items="${utenti}" var="utente">
			<aui:option value="${utente.id}">${utente.nome}</aui:option>
		</c:forEach>
	</aui:select>

	<aui:button type="cancel" value="annulla" />
	<aui:button type="submit" value="inserisci" />
</aui:form>