<portlet:actionURL name="/ricerca" var="ricercaURL" />

<portlet:renderURL var="dettaglioNuovoURL">
		<portlet:param name="mvcRenderCommandName" value="/dettaglioNuovo" />
		<portlet:param name="urlTornaIndietro" value="<%=urlTornaIndietro %>" />
		<portlet:param name="idForm" value="0" />
</portlet:renderURL>
<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${ricercaURL}" id="form" name="fm">
	<div class="row">
	
			<div class="col-6">
				<div class="form-group">
					<aui:input label="nome" id="nome" name="nome" type="text"/>	
				</div>
			</div>
			

			<div class="col-3">
				<div class="form-group ">
					<aui:input label="data-inserimento-da" id="dataInserimentoDa" name="dataInserimentoDa" type="date"/>			
				</div>	
			</div>
				

			<div class="col-3">
				<div class="form-group ">
					<aui:input label="data-inserimento-a" id="dataInserimentoA" name="dataInserimentoA" type="date"/>	
				</div>
			</div>
			

	</div>
	

		<aui:button-row cssClass="text-right">
			<aui:button type="button" value="annulla" id="annulla"/>
			<aui:button type="submit" value="cerca" id="cerca"/>
			<aui:button value="nuova" id="nuova" href="${dettaglioNuovoURL}"/>
		</aui:button-row>

	</aui:form>	
</div>