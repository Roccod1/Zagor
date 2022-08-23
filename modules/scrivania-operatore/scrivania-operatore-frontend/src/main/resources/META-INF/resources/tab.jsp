<aui:form action="#">
	<div class="row">
		<div class="col-6">
			<aui:input name="queryNome" label="nome-cognome-richiedente" />
		</div>
		<div class="col-6">
			<aui:input name="queryCf" label="codice-fiscale-richiedente" />
		</div>
	</div>
	<div class="row">
		<div class="col-6">
			<aui:input name="queryRichiestaId" label="id-richiesta" />
		</div>
		<div class="col-6">
			<aui:input name="queryNumProt" label="numero-protocollo" />
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<aui:input name="queryDataRichDa" label="data-richiesta-da" />
		</div>
		<div class="col-3">
			<aui:input name="queryDataRichA" label="data-richiesta-a" />
		</div>
		<div class="col-3">
			<aui:select name="queryAut" label="tipo-autenticazione">
			</aui:select>
		</div>
		<div class="col-3">
			<aui:select name="queryStato" label="stato-richiesta">
			</aui:select>
		</div>
	</div>
	<div class="d-flex justify-content-end">
		<a href="#" class="btn btn-secondary mr-1"><liferay-ui:message key="annulla" /></a>
		<aui:button type="submit" value="cerca" />
	</div>
</aui:form>

<liferay-portlet:renderURL varImpl="iteratorURL">
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
