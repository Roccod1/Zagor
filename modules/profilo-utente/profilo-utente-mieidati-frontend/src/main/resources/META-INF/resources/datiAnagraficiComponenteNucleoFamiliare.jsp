<%@ include file="init.jsp" %>

<div class="container pl-0 pr-0 mb-4 mt-4">

	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="codice-fiscale"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.codiceFiscale ? componenteNucleoFamiliare.codiceFiscale : \"-\"}"/>
			</div>
		</div>
		
		<div class="col">
			<div>				
				<label>
					<liferay-ui:message key="cognome"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.cognome ? componenteNucleoFamiliare.cognome : \"-\"}"/>				
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="nome"/>
				</label>				
			</div>
			<div>				
				<c:out value="${not empty componenteNucleoFamiliare.nome  ? componenteNucleoFamiliare.nome  : \"-\"}"/>
			</div>
		</div>		

		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="data-di-nascita"/>
				</label>
			</div>

			<fmt:formatDate type="date" value="${componenteNucleoFamiliare.dataNascita}" dateStyle="short" var="dataNascitaFormattato"/>
			<div>
				<c:out value="${dataNascitaFormattato}"/>
			</div>			
		</div>
		
	</div>
		
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="sesso"/>
				</label>
			</div>

			<div>
				<c:out value="${not empty componenteNucleoFamiliare.sesso ? componenteNucleoFamiliare.sesso : \"-\" }"/>							
			</div>			
		</div>
		
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="telefono"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.telefono ? componenteNucleoFamiliare.telefono : \"-\" }"/>
			</div>				
		</div>	
	</div>
		
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="stato-civile"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.statoCivile ? componenteNucleoFamiliare.statoCivile.descrizione : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="relazione-parentela"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.relazioneParentela ? componenteNucleoFamiliare.relazioneParentela.descrizione : \"-\" }"/>
			</div>
		</div>	
	</div>	
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="provincia-di-nascita"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty comuneNascita ? comuneNascita.provincia.denominazioneProvincia : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="comune-di-nascita"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty comuneNascita ? comuneNascita.denominazione : \"-\" }"/>
			</div>
		</div>	
	</div>	
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="provincia-di-residenza"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty comuneResidenza ? comuneResidenza.provincia.denominazioneProvincia : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="comune-di-residenza"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty comuneResidenza ? comuneResidenza.denominazione : \"-\" }"/>
			</div>
		</div>	
	</div>	
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="indirizzo-di-residenza"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.descrizioneVia ? componenteNucleoFamiliare.descrizioneVia : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="numero-civico"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.numeroCivico ? componenteNucleoFamiliare.numeroCivico : \"-\" }"/>
			</div>
		</div>	
	</div>	
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="cap-di-residenza"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty comuneReisdenza.codiceComune ? comuneResidenza.codiceComune : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="piano-residenza"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.piano ? componenteNucleoFamiliare.piano : \"-\" }"/>
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="scala-residenza"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.scala ? componenteNucleoFamiliare.scala : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="interno-residenza"/>
				</label>
			</div>
			
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.interno ? componenteNucleoFamiliare.interno : \"-\" }"/>
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="stato-estero-nascita"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty componenteNucleoFamiliare.descrizioneStatoEsteroNascita ? componenteNucleoFamiliare.descrizioneStatoEsteroNascita : \"-\" }"/>
			</div>				
		</div>	
		
		<div class="col">
			<div>			
				<label>
					<liferay-ui:message key="cittadinanza-italiana"/>
				</label>
			</div>
			
			<div>
				<c:choose>
					<c:when test="${componenteNucleoFamiliare.cittadinanzaItaliana eq true }">
						<i class="icon-ok"></i>
					</c:when>
					
					<c:when test="${componenteNucleoFamiliare.cittadinanzaItaliana eq false }">
						<i class="icon-remove"></i>
					</c:when>
					
					<c:otherwise>
						<c:out value="-"/>							
					</c:otherwise>
				</c:choose>
			</div>
		</div>	
	</div>
	
	<portlet:renderURL var="goBackURL">
		<portlet:param name="<%=ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA %>" value="<%=ProfiloUtenteMieiDatiPortletKeys.SEZIONE_NUCLEO_FAMILIARE %>"/>
	</portlet:renderURL>
	
	<aui:button-row cssClass="text-right">
		<aui:button type="cancel" value="torna-indietro" href="${goBackURL}"/>
	</aui:button-row>
</div>
