<%@ include file="init.jsp" %>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
	<portlet:param name="indirizzoPrecedente" value="${homeURL}"/>
</portlet:renderURL>

<portlet:actionURL name="/cerca" var="cercaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form id="ricercaServiziForm" action="${cercaURL}" method="post" >
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="soloServiziAttiviRicerca" class="form-check-input" label="solo-servizi-attivi"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="nomeRicerca" label="nome"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="codiceRicerca" label="codice-servizio"></aui:input>
				</div>
			</div>
		</div>	
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="cerca" />
			<aui:button type="button" value="reset" href="${homeURL}"/>
			<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
		</aui:button-row>
	</aui:form>
</div>