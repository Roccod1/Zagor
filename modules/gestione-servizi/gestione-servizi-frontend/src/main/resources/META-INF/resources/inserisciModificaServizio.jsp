<%@ include file="init.jsp" %>

<% 
	List<Tipologia> listaTipologieSelezionate = (List<Tipologia>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE_SELEZIONATE);
	List<Tipologia> listaTipologie = (List<Tipologia>) renderRequest.getAttribute(GestioneServiziPortletKeys.LISTA_TIPOLOGIE);
%>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:actionURL name="/salva" var="salvaURL">
	<portlet:param name="indirizzoPrecedente" value="${homeURL }"/>
</portlet:actionURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL}" id="inserisciModificaServizioForm">
		<aui:input type="hidden" name="servizioId" value="${servizio.servizioId}"/>
	
		<div class="row">
			<div class="col">
				<div class="form-group required">
					<aui:input type="text" name="nome" label="nome" value="${servizio.nome }">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
			<div class="col">
				<div class="form-group required">
					<aui:input type="text" name="codice" label="codice-servizio" value="${servizio.codice}">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="textarea" resizable="false" name="descrizione" label="descrizione" value="${servizio.descrizione}">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:select type="text" name="areaTematicaId" label="area-tematica" value="${servizio.areaTematicaId}">
						<aui:validator name="required"/>
						<aui:option value="" selected="true" label="seleziona" disabled="true"/>
						<c:forEach items="${listaAreaTematica}" var="areaTematica">
							<aui:option value="${areaTematica.areaTematicaId }" selected="${areaTematica.areaTematicaId eq servizio.areaTematicaId ? true : false }" label="${areaTematica.nome}"/>
						</c:forEach>
					</aui:select>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="textarea" resizable="false" name="descrizioneEstesa" label="descrizione-estesa" value="${servizio.descrizioneEstesa}"/>				
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uri" label="uri-privata" value="${servizio.uri}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uriGuest" label="uri-pubblica" value="${servizio.uriGuest}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uriScheda" label="uri-scheda" value="${servizio.uriScheda}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="autenticazione" label="autenticazione" value="${servizio.autenticazione}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="attivo" label="attivo" value="${servizio.attivo}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<fmt:formatDate value="${servizio.dataInizioAttivazione }" pattern="yyyy-MM-dd" var="dataInizioAttivazioneFormattato"/>
					<aui:input type="date" name="dataInizioAttivazione" label="data-inizio-attivazione" value="${dataInizioAttivazioneFormattato}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="cittadino" label="cittadino" value="${servizio.cittadino}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="azienda" label="azienda" value="${servizio.azienda}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<fmt:formatDate value="${servizio.dataFineAttivazione }" pattern="yyyy-MM-dd" var="dataFineAttivazioneFormattato"/>
					<aui:input type="date" name="dataFineAttivazione" label="data-fine-attivazione" value="${dataFineAttivazioneFormattato}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="delega" label="delega" value="${servizio.delega}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="allegatoDelega" label="allegato-delega-obbligatorio" value="${servizio.allegatoDelega}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="privacyDelega" label="privacy-servizio-delega" value="${servizio.privacyDelega}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="prenotabile" label="prenotabile" value="${servizio.prenotabile}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="chatbot" label="chatbot" value="${servizio.chatbot}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="gestioneBackoffice" label="gestibile-da-backoffice"  value="${servizio.gestioneBackoffice}"/>
				</div>
			</div>
		</div>

		<div class="row mt-4">
			<div class="col">
				<div class="mb-3">
					<h4><liferay-ui:message key="tipologia" /></h5>			
				</div>
				<c:choose>
					<c:when test="${not empty listaTipologie }">
						<% for(Tipologia tipologia : listaTipologie){ %>
							<div class="form-group form-check">
								<aui:input id='<%="tipologia"+ tipologia.getTipologiaId()%>' name="listaTipologieSelezionate" type="checkbox" value="<%=tipologia.getTipologiaId() %>" checked="<%=listaTipologieSelezionate.contains(tipologia) ? true : false %>" label="<%=tipologia.getNome() %>"/>		
							</div>
						<% }%>					
					</c:when>
					<c:otherwise>
						<div class="alert alert-warning" role="alert">
							<liferay-ui:message key="nessuna-tipologia-presente"/>
						</div>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="reset" value="reset" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>