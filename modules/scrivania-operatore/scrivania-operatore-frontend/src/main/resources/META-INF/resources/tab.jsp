<%@ include file="init.jsp" %>

<portlet:renderURL var="searchURL">
</portlet:renderURL>

<portlet:renderURL var="resetURL">
	<portlet:param name="queryTab" value="${queryTab}" />
</portlet:renderURL>

<aui:form action="${searchURL}">
	<aui:input type="hidden" name="queryTab" value="${queryTab}" />
	<div class="row">
		<div class="col-6">
			<aui:input name="queryNome" label="nome-cognome-richiedente" value="${queryNome}" />
		</div>
		<div class="col-6">
			<aui:input name="queryCf" label="codice-fiscale-richiedente" value="${queryCf}" />
		</div>
	</div>
	<div class="row">
		<div class="col-6">
			<aui:input name="queryRichiestaId" label="id-richiesta" value="${queryRichiestaId}" />
		</div>
		<div class="col-6">
			<aui:input name="queryNumProt" label="numero-protocollo" value="${queryNumProt}" />
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<aui:input name="queryDataRichDa" label="data-richiesta-da" value="${queryDataRichDa}" />
		</div>
		<div class="col-3">
			<aui:input name="queryDataRichA" label="data-richiesta-a" value="${queryDataRichA}" />
		</div>
		<div class="col-3">
			<aui:select name="queryAut" label="tipo-autenticazione" value="${queryAut}">
				<aui:option value="0"><liferay-ui:message key="tutti" /></aui:option>
				<aui:option value="1"><liferay-ui:message key="utente-autenticato" /></aui:option>
				<aui:option value="2"><liferay-ui:message key="utente-guest" /></aui:option>
			</aui:select>
		</div>
		<div class="col-3">
			<aui:select name="queryStato" label="stato-richiesta" value="${queryStato}">
				<aui:option value=""><liferay-ui:message key="tutti" /></aui:option>
				<c:forEach items="${stati}" var="stato">
					<aui:option value="${stato}"><liferay-ui:message key="stato-richiesta-${stato}"/></aui:option>
				</c:forEach>
			</aui:select>
		</div>
	</div>
	<div class="d-flex justify-content-end">
		<a href="${resetURL}" class="btn btn-secondary mr-1"><liferay-ui:message key="annulla" /></a>
		<aui:button type="submit" value="cerca" />
	</div>
</aui:form>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="queryTab" value="${queryTab}" />
	<portlet:param name="queryNome" value="${queryNome}" />
	<portlet:param name="queryCf" value="${queryCf}" />
	<portlet:param name="queryRichiestaId" value="${queryRichiestaId}" />
	<portlet:param name="queryNumProt" value="${queryNumProt}" />
	<portlet:param name="queryDataRichDa" value="${queryDataRichDa}" />
	<portlet:param name="queryDataRichA" value="${queryDataRichA}" />
	<portlet:param name="queryAut" value="${queryAut}" />
	<portlet:param name="queryStato" value="${queryStato}" />
</liferay-portlet:renderURL>

<liferay-ui:search-container total="${totale}"
                             iteratorURL="${iteratorURL}"
                             emptyResultsMessage=""
                             delta="10">
	<liferay-ui:search-container-results results="${lista}" />
	
	<liferay-ui:search-container-row className="a" modelVar="elem">
		<liferay-ui:search-container-column-text name="id" value="1" />
		<liferay-ui:search-container-column-text name="n-protocollo" value="1" />
		<liferay-ui:search-container-column-text name="richiedente" value="1" />
		<liferay-ui:search-container-column-text name="cf-piva" value="1" />
		<liferay-ui:search-container-column-text name="data-ultimo-aggiornamento" value="1" />
		<liferay-ui:search-container-column-text name="accesso" value="1" />
		<liferay-ui:search-container-column-text name="stato" value="1" />
		<liferay-ui:search-container-column-jsp name="azioni" path="/azioni.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
