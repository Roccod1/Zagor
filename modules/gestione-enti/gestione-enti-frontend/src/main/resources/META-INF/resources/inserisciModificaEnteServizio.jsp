<%@ include file="init.jsp" %>

<portlet:renderURL var="goBacklistaServiziUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.LISTA_SERVIZI_ENTE_RENDER_COMMAND %>" />
	<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${organizzazione.organizationId}"/>
</portlet:renderURL>	

<portlet:actionURL name="<%=GestioneEntiPortletKeys.SALVA_ACTION_COMMAND_NAME %>" var="salvaURL">
	<portlet:param name="mvcPath" value="<%=GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA %>"/>
	<portlet:param name="<%=GestioneEntiPortletKeys.INDIRIZZO_REDIRECT %>" value="${goBacklistaServiziUrl }"/>
</portlet:actionURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<div class="row justify-content-between">
		<div class="col">
			<h4>${organizzazione.name }</h4>
		</div>
	</div>

	<aui:form method="post" action="${salvaURL}">
		<aui:input type="hidden" name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${organizzazione.organizationId}"/>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<c:choose>
						<c:when test="${not empty servizioEnte.servizioId }">
							<aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ID %>" type="hidden" value="${servizioEnte.servizioId }"/>

							<c:forEach items="${listaServizi }" var="servizio">
								<c:if test="${servizio.servizioId eq servizioEnte.servizioId }">
									<c:set value="${servizio.nome }" var="nomeServizio"/>
								</c:if>
							</c:forEach>

					        <aui:input name="nomeServizio" label="nome" type="text" value="${nomeServizio}" disabled="true"/>

						</c:when>
						
						<c:when test="${empty listaServizi }">
							<div class="alert alert-warning" role="alert">
							  <liferay-ui:message key="nessun-uri-disponibile"/>
							</div>
						</c:when>
						
						<c:otherwise>
							<aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_ID %>" label="id-servizio">
								<aui:validator name="required"/>
								<aui:option value="" label="seleziona" disabled="true" selected="true"/>
								<c:forEach items="${listaServizi }" var="servizio">
									<aui:option value="${servizio.servizioId }" label="${servizio.nome }"/>
								</c:forEach>
							</aui:select>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
				
					<c:choose>
						<c:when test="${empty listaArticleCatalogoServizi }">
							<div class="alert alert-warning" role="alert">
							  <liferay-ui:message key="nessun-article-id-assegnabile"/>
							</div>
						</c:when>
						
						<c:otherwise>
							<aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_CATALOGO_SERVIZI_ARTICLE_ID %>" label="id-article-catalogo-servizi" value="${servizioEnte.catalogoServizioArticleId}">
					        	<aui:option value="" label="seleziona" selected="true"/>
					        	<c:forEach items="${listaArticleCatalogoServizi}" var="article">
					        		<aui:option value="${article.articleId }">${article.articleId } - ${article.title }</aui:option>
					        	</c:forEach>
					        </aui:select>
				       	 </c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="form-group">
					<c:choose>
						<c:when test="${empty listaUriPubblica }">'
							<div class="alert alert-warning" role="alert">
							  <liferay-ui:message key="nessun-uri-pubblica-disponibile"/>
							</div>
						</c:when>
						
						<c:otherwise>
					        <aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_PUBLIC_LAYOUT_ID %>" label="uri-pubblica" type="text" value="${servizioEnte.publicLayoutId}">
					        	<aui:option value="" label="seleziona" selected="selected"/>
					        	<c:forEach items="${listaUriPubblica }" var="uriPubblica">
					        		<aui:option value="${uriPubblica.layoutId}">${uriPubblica.name}</aui:option>
					        	</c:forEach>
				       	 	</aui:select>
				       	 </c:otherwise>
					</c:choose>		
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
					<c:choose>
						<c:when test="${empty listaUriPrivata }">
							<div class="alert alert-warning" role="alert">
							  <liferay-ui:message key="nessun-uri-privata-disponibile"/>
							</div>
						</c:when>
						
						<c:otherwise>
					        <aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_PRIVATE_LAYOUT_ID %>" label="uri-privata" type="text" value="${servizioEnte.privateLayoutId}">
					        	<aui:option value="" label="seleziona" selected="selected"/>
					        	<c:forEach items="${listaUriPrivata }" var="uriPrivata">
					        		<aui:option value="${uriPrivata.layoutId}">${uriPrivata.name}</aui:option>
					        	</c:forEach>
					        </aui:select>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_URI_ESTERNA%>" label="uri-esterna" type="text" value="${servizioEnte.uriEsterna }">
			        	<aui:validator name="url"/>
			        	<aui:validator name="maxLength">255</aui:validator>
			        </aui:input>
				</div>
			</div>

			<div class="col">
				<div class="form-group">
					<aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_SOTTO_ORGANIZZAZIONE_ID %>" label="sotto-organizzazione" type="text" value="${servizioEnte.subOrganizationId}">
			        	<aui:option value="" label="seleziona" selected="selected"/>
			        	<c:forEach items="${sottoOrganizzazioni}" var="sottoOrganizzazione">
			        		<aui:option value="${sottoOrganizzazione.organizationId}">${sottoOrganizzazione.name}</aui:option>
			        	</c:forEach>
			        </aui:select>
				</div>
			</div>
		</div>		
		
		<div class="row">
			<div class="col">
				<div class="form-group">
   					<fmt:formatDate value="${servizioEnte.dataInizioAttivazione}" pattern="yyyy-MM-dd'T'HH:mm" var="dataInizioAttivazioneFormattato"/>
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DATA_INIZIO_ATTIVAZIONE %>" label="data-inizio-attivazione" type="datetime-local" value="${dataInizioAttivazioneFormattato }"/>					
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
   					<fmt:formatDate value="${servizioEnte.dataFineAttivazione}" pattern="yyyy-MM-dd'T'HH:mm" var="dataFineAttivazioneFormattato"/>
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DATA_FINE_ATTIVAZIONE %>" label="data-fine-attivazione" type="datetime-local" value="${dataFineAttivazioneFormattato}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_AUTENTICAZIONE %>" label="autenticazione" type="checkbox" checked="${servizioEnte.autenticazione}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
					<aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_LIVELLO_AUTENTICAZIONE %>" label="livello-autenticazione" value="${servizioEnte.livelloAutenticazione}">
						<aui:option value="1">1</aui:option>
						<aui:option value="2">2</aui:option>
						<aui:option value="3">3</aui:option>
					</aui:select>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_CITTADINO %>" label="cittadino" type="checkbox" checked="${servizioEnte.cittadino}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_AZIENDA %>" label="azienda" type="checkbox" checked="${servizioEnte.azienda}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_CHATBOT %>" label="chatbot" type="checkbox" checked="${servizioEnte.chatbot}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_PRENOTABILE %>" label="prenotabile" type="checkbox" checked="${servizioEnte.prenotabile}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DELEGA %>" label="delega" type="checkbox" checked="${servizioEnte.delega}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_PRIVACY_DELEGA %>" label="privacy-servizio-delega" type="checkbox" checked="${servizioEnte.privacyDelega}"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ALLEGATO_DELEGA %>" label="allegato-delega-obbligatorio " type="checkbox" checked="${servizioEnte.allegatoDelega}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_TIMBRO_CERTIFICATO %>" label="timbro-certificato" type="checkbox" checked="${servizioEnte.timbroCertificato}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ISEE_INPS %>" label="isee-inps" type="checkbox" checked="${servizioEnte.iseeInps}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ATTIVO %>" label="attivo" type="checkbox" checked="${servizioEnte.attivo}"/>
				</div>
			</div>
		</div>		
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
			        <aui:input name="<%=GestioneEntiPortletKeys.RICHIESTA_FIRMA %>" label="documento-principale-firmato" type="checkbox" checked="${servizioEnte.richiestaFirma}"/>
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
			        <aui:select label="formato-firma-digitale" id="<%=GestioneEntiPortletKeys.FORMATI_FIRMA_DIGITALE %>" name="<%=GestioneEntiPortletKeys.FORMATI_FIRMA_DIGITALE %>" multiple="true" showEmptyOption="true">
						<aui:option value="PADES" label="pades"></aui:option>
						<aui:option value="CADES" label="cades"></aui:option>
					</aui:select>
				</div>
			</div>
		</div>	
		
		
		<aui:button-row cssClass="text-right">
			<c:set value="${empty listaServizi}" var="disabilitaSeNessunServizioAttivabile" />
			<aui:button type="submit" value="salva" disabled="${disabilitaSeNessunServizioAttivabile }"/>
			<aui:button type="cancel" value="annulla" href="${goBacklistaServiziUrl}"/>
		</aui:button-row>
	</aui:form>
</div>

<script type="text/javascript">

	var listaFormatiFirmaDigitale = ${listaFormatiFirmaDigitale};

	$(function(){
		impostaDataMinimaDataFine();
	});
	
	function impostaDataMinimaDataFine(){
		var dataInizioAttivazione = $("#<portlet:namespace/>dataInizioAttivazione");
		var dataFineAttivazione = $("#<portlet:namespace/>dataFineAttivazione");
		var dataInizio = new Date(dataInizioAttivazione.val());
		dataFineAttivazione.prop('min', dataInizio.toISOString().substr(0, 16));		
	}
	

	$("#<portlet:namespace/>dataInizioAttivazione").change(() => {
		impostaDataMinimaDataFine();
	});
	
	if (listaFormatiFirmaDigitale !== "listaVuota") {
		var arrayFormatiFirmaDigitale = JSON.stringify(listaFormatiFirmaDigitale);
		var jsonArray = JSON.parse(arrayFormatiFirmaDigitale);
		$('#<portlet:namespace />formatiFirmaDigitale').val(jsonArray);
	}

</script>