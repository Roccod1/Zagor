<%@ include file="/init.jsp" %>

<portlet:actionURL var="inserisciURL" name="/action/inserisci">
</portlet:actionURL>

<aui:form method="${inserisciURL}">
	<aui:input name="titolo" />
	<aui:select name="tipologia">
		<c:forEach items="${tipologie}" var="tipologia">
			<aui:option value="${tipologia.id}">${tipologia.nome}</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:input name="descrizione" />
	
	<aui:input name="dataInizio" />
	<aui:input name="dataFine" />
	
	<aui:select name="procedura">
		<aui:option value="-"><liferay-ui:message key="nessuna" /></aui:option>
	</aui:select>
	
	<aui:select name="cittadini" />
	
	<aui:button type="cancel" value="annulla" />
	<aui:button type="submit" value="inserisci" />
</aui:form>