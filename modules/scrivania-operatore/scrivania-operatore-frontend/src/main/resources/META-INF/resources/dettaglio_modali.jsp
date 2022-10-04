<%@ include file="init.jsp" %>

<c:if test="${inCarico}">
	<c:forEach items="${azioni}" var="azione">
		<c:choose>
		
			<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_RESPONSABILE'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />assegnaResponsabileModal" style="display: none;">
					<portlet:actionURL var="assegnaResponsabileURL" name="/action/assegnaResponsabile">
					</portlet:actionURL>
					
					<aui:form action="${assegnaResponsabileURL}" name="assegnaResponsabileForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						<aui:input type="hidden" name="variableSet" value="${azione.variableSet}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="inoltra-a-responsabile" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>
											<liferay-ui:message key="selezione-responsabile" />
										</label>
										<select class="form-control" name="<portlet:namespace />responsabile">
											<option value=""><liferay-ui:message key="seleziona-un-responsabile" /></option>
											<c:forEach items="${responsabili}" var="responsabile">
												<option value="${responsabile.userId}">${responsabile.nome}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>
											<liferay-ui:message key="commento" />
										</label>
										<textarea class="form-control" name="<portlet:namespace />commento"></textarea>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-end">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">
										<liferay-ui:message key="annulla" />
									</button>
									<button type="submit" class="btn btn-primary ml-1">
										<liferay-ui:message key="conferma" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_ALTRO_RESPONSABILE'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />assegnaAltroResponsabileModal" style="display: none;">
					<portlet:actionURL var="assegnaAltroResponsabileURL" name="/action/assegnaAltroResponsabile">
					</portlet:actionURL>
					
					<aui:form action="${assegnaAltroResponsabileURL}" name="assegnaAltroResponsabileForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
					
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="inoltra-a-responsabile" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>
											<liferay-ui:message key="selezione-altro-responsabile" />
										</label>
										<select class="form-control" name="<portlet:namespace />responsabile">
											<option value=""><liferay-ui:message key="seleziona-un-responsabile" /></option>
											<c:forEach items="${altriResponsabili}" var="responsabile">
												<option value="${responsabile.userId}">${responsabile.nome}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>
											<liferay-ui:message key="commento" />
										</label>
										<textarea class="form-control" name="<portlet:namespace />commento"></textarea>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-end">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">
										<liferay-ui:message key="annulla" />
									</button>
									<button type="submit" class="btn btn-primary ml-1">
										<liferay-ui:message key="conferma" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_POSITIVO'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />chiudiEsitoPositivoModal" style="display: none;">
					<portlet:actionURL var="chiudiEsitoPositivoURL" name="/action/chiudiEsitoPositivo">
					</portlet:actionURL>
					
					<aui:form action="${chiudiEsitoPositivoURL}" name="chiudiEsitoPositivoForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="chiudi-pratica" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<span><liferay-ui:message key="chiudi-esito-message" /></span>
									<h5><liferay-ui:message key="seleziona-allegati-condividere" /></h5>
									<liferay-ui:search-container total="${allegatiOperatoreCount}"
											 					 emptyResultsMessage="non-sono-presenti-allegati"
				                             				     delta="10">
						     			<liferay-ui:search-container-results results="${allegatiOperatoreList}" />
						     			
										<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO" 
										                                 modelVar="elem">
		                                    <liferay-ui:search-container-column-text name="#">
												<div class="form-group form-check">
													<c:set var="checkedAttr" value="${elem.visibileAlCittadino ? 'checked' : '' }" />
													<input type="checkbox" class="form-check-input" value="${elem.id}" name="<portlet:namespace />selezionati" ${checkedAttr}>
												</div>
				                            </liferay-ui:search-container-column-text>
											<liferay-ui:search-container-column-text name="nome-file" value="${elem.nomeFile}" />
				    						<liferay-ui:search-container-column-text name="dimensione" value="${elem.dimensione}" />
				    						<liferay-ui:search-container-column-jsp name="azioni" path="/dettaglio_allegati_azioni.jsp" />
				   						</liferay-ui:search-container-row>
					
										<liferay-ui:search-iterator markupView="lexicon" />
									</liferay-ui:search-container>
									<div class="form-group">
										<label>
											<liferay-ui:message key="commento" />
										</label>
										<textarea class="form-control" name="<portlet:namespace />commento"></textarea>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-end">		
									<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="annulla" /></button>
									
									<button type="submit" class="btn btn-primary ml-1">
										<liferay-ui:message key="conferma" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_NEGATIVO'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />chiudiEsitoNegativoModal" style="display: none;">
					<portlet:actionURL var="chiudiEsitoNegativoURL" name="/action/chiudiEsitoNegativo">
					</portlet:actionURL>
					
					<aui:form action="${chiudiEsitoNegativoURL}" name="chiudiEsitoNegativoForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="chiudi-pratica" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<span><liferay-ui:message key="chiudi-esito-message" /></span>
									<h5><liferay-ui:message key="seleziona-allegati-condividere" /></h5>
									<liferay-ui:search-container total="${allegatiOperatoreCount}"
											 					 emptyResultsMessage="non-sono-presenti-allegati"
				                             				     delta="10">
						     			<liferay-ui:search-container-results results="${allegatiOperatoreList}" />
						     			
										<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO" 
										                                 modelVar="elem">
				                            <liferay-ui:search-container-column-text name="#">
												<div class="form-group form-check">
													<c:set var="checkedAttr" value="${elem.visibileAlCittadino ? 'checked' : '' }" />
													<input type="checkbox" class="form-check-input" value="${elem.id}" name="<portlet:namespace />selezionati" ${checkedAttr}>
												</div>
				                            </liferay-ui:search-container-column-text>
											<liferay-ui:search-container-column-text name="nome-file" value="${elem.nomeFile}" />
				    						<liferay-ui:search-container-column-text name="dimensione" value="${elem.dimensione}" />
				    						<liferay-ui:search-container-column-jsp name="azioni" path="/dettaglio_allegati_azioni.jsp" />
				   						</liferay-ui:search-container-row>
					
										<liferay-ui:search-iterator markupView="lexicon" />
									</liferay-ui:search-container>
									<div class="form-group">
										<label>
											<liferay-ui:message key="commento" />
										</label>
										<textarea class="form-control" name="<portlet:namespace />commento"></textarea>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-end">		
									<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="annulla" /></button>
									
									<button type="submit" class="btn btn-primary ml-1">
										<liferay-ui:message key="conferma" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'RILASCIA_TASK'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />rilasciaModal" style="display: none;">
					<portlet:actionURL var="rilasciaPraticaURL" name="/action/rilasciaPratica">
					</portlet:actionURL>
					
					<aui:form action="${rilasciaPraticaURL}">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="rilascia-pratica" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<span><liferay-ui:message key="rilascia-message" /></span>
								</div>
								<div class="modal-footer d-flex justify-content-end">		
									<button type="submit" class="btn btn-primary mr-1">
										<liferay-ui:message key="conferma" />
									</button>
									
									<button type="button" class="btn btn-secondary" data-dismiss="modal">
										<liferay-ui:message key="annulla" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'RICHIESTA_INTEGRAZIONE'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />richiediModificheModal" style="display: none;">
					<portlet:actionURL var="richiediIntegrazioneURL" name="/action/richiediIntegrazione">
					</portlet:actionURL>
				
					<aui:form action="${richiediIntegrazioneURL}" name="richiediModificheForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="richiedi-modifiche-integrazioni-richiedente" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<c:choose>
										<c:when test="${empty integrazioni}">
											<span><liferay-ui:message key="non-sono-previste-integrazioni" /></span>
										</c:when>
										<c:otherwise>
											<span><liferay-ui:message key="integrazioni-message" /></span>

											<div class="form-group">
												<label><liferay-ui:message key="note" /></label>
												<textarea class="form-control" name="<portlet:namespace />note"></textarea>
											</div>
											
											<h5><liferay-ui:message key="seleziona-documenti-integrazione" /></h5>											
											<liferay-ui:search-container total="${integrazioni.size()}">
												<liferay-ui:search-container-results results="${integrazioni}" />
												
												<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.IntegrazioneDTO" 
										                                 modelVar="elem">
													<liferay-ui:search-container-column-text name="#">
														<div class="form-group form-check">
															<input type="checkbox" class="form-check-input" value="${elem.id}" name="<portlet:namespace />integrazioni">
														</div>
													</liferay-ui:search-container-column-text>
													
						                            <liferay-ui:search-container-column-text name="integrazione" value="${elem.nome}" />     
		                                		</liferay-ui:search-container-row>
												
												<liferay-ui:search-iterator markupView="lexicon" />
											</liferay-ui:search-container>
											
											<h5><liferay-ui:message key="seleziona-allegati-condividere" /></h5>
											<liferay-ui:search-container total="${allegatiOperatoreCount}"
											 					 emptyResultsMessage="non-sono-presenti-allegati"
				                             				     delta="10">
								     			<liferay-ui:search-container-results results="${allegatiOperatoreList}" />
								     			
												<liferay-ui:search-container-row className="it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO" 
												                                 modelVar="elem">
				                                    <liferay-ui:search-container-column-text name="#">
														<div class="form-group form-check">
															<c:set var="checkedAttr" value="${elem.visibileAlCittadino ? 'checked' : '' }" />
															<input type="checkbox" class="form-check-input" value="${elem.idDocumentale}" name="<portlet:namespace />allegati" ${checkedAttr}>
														</div>
						                            </liferay-ui:search-container-column-text>
													<liferay-ui:search-container-column-text name="nome-file" value="${elem.nomeFile}" />
						    						<liferay-ui:search-container-column-text name="dimensione" value="${elem.dimensione}" />
						    						<liferay-ui:search-container-column-jsp name="azioni" path="/dettaglio_allegati_azioni.jsp" />
						   						</liferay-ui:search-container-row>
							
												<liferay-ui:search-iterator markupView="lexicon" />
											</liferay-ui:search-container>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="modal-footer d-flex justify-content-end">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">
										<liferay-ui:message key="annulla" />
									</button>
									<c:if test="${not empty integrazioni}">
										<button type="submit" class="btn btn-primary">
											<liferay-ui:message key="conferma" />
										</button>
									</c:if>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
			
			<c:when test="${azione.codiceAzioneUtente == 'RIMANDA_REFERENTE'}">
				<div class="modal fade" tabindex="-1" id="<portlet:namespace />rimandaAlReferenteModal" style="display: none;">
					<portlet:actionURL var="rimandaAlReferenteURL" name="/action/rimandaAlReferente">
					</portlet:actionURL>
					
					<aui:form action="${rimandaAlReferenteURL}" name="rimandaAlReferenteForm">
						<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
						<aui:input type="hidden" name="dettaglioTab" value="${dettaglioTab}" />
						<aui:input type="hidden" name="variabileSet" value="${azione.variableSet}" />
						<aui:input type="hidden" name="variabileVal" value="${azione.variableValue}" />
						
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title"><liferay-ui:message key="rimanda-al-referente" /></h5>
									<button type="button" class="close" data-dismiss="modal">
										&times;
									</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>
											<liferay-ui:message key="commento" />
										</label>
										<textarea class="form-control" name="<portlet:namespace />commento"></textarea>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-end">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">
										<liferay-ui:message key="annulla" />
									</button>
									<button type="submit" class="btn btn-primary ml-1">
										<liferay-ui:message key="conferma" />
									</button>
								</div>
							</div>
						</div>
					</aui:form>
				</div>
			</c:when>
				
		</c:choose>
	</c:forEach>
</c:if>

<div class="modal fade" tabindex="-1" id="<portlet:namespace />aggiungiAllegatoModal" style="display: none;">
	<portlet:actionURL var="aggiungiAllegatoURL" name="/action/aggiungiAllegato">
	</portlet:actionURL>
	
	<aui:form action="${aggiungiAllegatoURL}" enctype="multipart/form-data" name="aggiungiAllegatoForm">
		<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
		
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"><liferay-ui:message key="aggiungi-modifica-allegato" /></h5>
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><liferay-ui:message key="titolo-documento" /></label>
						<input class="form-control" name="<portlet:namespace />titoloDocumento">
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"><liferay-ui:message key="visibile-al-cittadino" /></label>
						<input type="checkbox" class="form-check-input" name="<portlet:namespace />visibileAlCittadino">
					</div>
					
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label><liferay-ui:message key="seleziona-file" /></label>
								<input type="file" name="<portlet:namespace />allegato" class="form-control">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer d-flex justify-content-end">		
					<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="annulla" /></button>
					
					<button type="submit" class="btn btn-primary ml-1">
						<liferay-ui:message key="salva-allegato" />
						<i class="fas fa-upload"></i>
					</button>
				</div>
			</div>
		</div>
	</aui:form>
</div>

<div class="modal fade" tabindex="-1" id="<portlet:namespace />aggiungiCommentoModal" style="display: none;">
	<portlet:actionURL var="aggiungiCommentoURL" name="/action/aggiungiCommento">
	</portlet:actionURL>
	
	<aui:form action="${aggiungiCommentoURL}" name="aggiungiCommentoForm">
		<aui:input type="hidden" name="richiestaId" value="${richiesta.id}" />
				
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"><liferay-ui:message key="inserisci-modifica-commento" /></h5>
					<button type="button" class="close" data-dismiss="modal">
						&times;
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><liferay-ui:message key="testo" /></label>
						<textarea class="form-control" id="<portlet:namespace />testo" name="<portlet:namespace />testo"></textarea>
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"><liferay-ui:message key="visibile-al-cittadino" /></label>
						<input type="checkbox" class="form-check-input" name="<portlet:namespace />visibileAlCittadino">
					</div>
				</div>
				<div class="modal-footer d-flex justify-content-end">		
					<button type="submit" class="btn btn-primary mr-1">
						<liferay-ui:message key="salva-commento" />
					</button>
					
					<button type="button" class="btn btn-secondary" data-dismiss="modal">
						<liferay-ui:message key="annulla" />
					</button>
				</div>
			</div>
		</div>
	</aui:form>
</div>
