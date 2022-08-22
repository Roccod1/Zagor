<%@ include file="/init.jsp" %>

<portlet:renderURL var="nuovaURL">
	<portlet:param name="mvcRenderCommandName" value="/render/nuova" />
</portlet:renderURL>

<portlet:renderURL var="cercaURL">
</portlet:renderURL>

<aui:form action="${cercaURL}">
	<div class="row">
		<div class="col-4">
			<aui:select name="queryOrganizzazione" label="ente" value="${queryOrganizzazione}">
				<aui:option value="0"><liferay-ui:message key="tutte" /></aui:option>
				<c:forEach items="${organizzazioni}" var="organizzazione">
					<aui:option value="${organizzazione.id}">${organizzazione.nome}</aui:option>
				</c:forEach>
			</aui:select>
		</div>
		<div class="col-4">
			<aui:input name="queryUsername" label="username" value="${queryUsername}" />
		</div>
		<div class="col-4">
			<aui:select name="queryTipologia" label="tipologia" value="${queryTipologia}">
				<aui:option value="0"><liferay-ui:message key="tutte" /></aui:option>
				<c:forEach items="${tipologie}" var="tipologia">
					<aui:option value="${tipologia.id}">${tipologia.nome}</aui:option>
				</c:forEach>
			</aui:select>
		</div>
	</div>
	
	<a href="${cercaURL}" class="btn btn-secondary"><liferay-ui:message key="annulla" /></a>
	<aui:button type="submit" value="cerca" />
</aui:form>

<a href="${nuovaURL}" class="btn btn-primary"><liferay-ui:message key="invia-comunicazione" /></a>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="queryOrganizzazione" value="${queryOrganizzazione}" />
	<portlet:param name="queryUsername" value="${queryUsername}" />
	<portlet:param name="queryTipologia" value="${queryTipologia}" />
</liferay-portlet:renderURL>

<liferay-ui:search-container total="${comunicazioniCount}"
						     iteratorURL="${iteratorURL}"
						     emptyResultsMessage="nessuna-comunicazione"
                             delta="10">
	<liferay-ui:search-container-results results="${comunicazioni}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.gestionecomunicazioni.frontend.dto.ComunicazioneDTO" modelVar="comunicazione">
		<c:choose>
			<c:when test="${comunicazione.dataInvio != null}">
				<fmt:formatDate value="${comunicazione.dataInvio}" pattern="dd/MM/yyyy" var="comunicazioneDataInvio" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataInvio" value="-"/>
			</c:otherwise>
		</c:choose>
		
		<liferay-ui:search-container-column-text name="dataInvio" value="${comunicazioneDataInvio}" />
		<liferay-ui:search-container-column-text name="titolo" value="${comunicazione.titolo}" />
		<liferay-ui:search-container-column-text name="tipologia" value="${comunicazione.tipologia}" />
		<liferay-ui:search-container-column-text name="stato" value="${comunicazione.stato}" translate="true" />
		<liferay-ui:search-container-column-text name="ente" value="${comunicazione.ente}" />
		<liferay-ui:search-container-column-jsp name="azioni" path="/azioni.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>