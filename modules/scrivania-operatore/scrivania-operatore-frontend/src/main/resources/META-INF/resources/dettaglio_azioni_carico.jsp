<%@ include file="init.jsp" %>

<c:if test="${inCarico}">
	<div class="row mt-2 mb-2">
		<div class="col-12">
			<c:forEach items="${azioni}" var="azione">
				<c:choose>
					<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_ALTRO_RESPONSABILE'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />assegnaAltroResponsabileModal">
							<liferay-ui:message key="assegna-altro-responsabile" />
						</button>
					</c:when>
					
					<c:when test="${azione.codiceAzioneUtente == 'ASSEGNA_RESPONSABILE'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />assegnaResponsabileModal">
							<liferay-ui:message key="assegna-responsabile" />
						</button>
					</c:when>
							
					<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_POSITIVO'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />chiudiEsitoPositivoModal">
							<liferay-ui:message key="chiudi-esito-positivo" />
						</button>
					</c:when>
					
					<c:when test="${azione.codiceAzioneUtente == 'ESITO_PROCEDIMENTO_NEGATIVO'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />chiudiEsitoNegativoModal">
							<liferay-ui:message key="chiudi-esito-negativo" />
						</button>
					</c:when>
					
					<c:when test="${azione.codiceAzioneUtente == 'RICHIESTA_INTEGRAZIONE'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />richiediModificheModal">
							<liferay-ui:message key="richiedi-modifiche-integrazioni-richiedente" />
						</button>
					</c:when>
					
					<c:when test="${azione.codiceAzioneUtente == 'RILASCIA_TASK'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />rilasciaModal">
							<liferay-ui:message key="rilascia" />
						</button>
					</c:when>
					
					<c:when test="${azione.codiceAzioneUtente == 'RIMANDA_REFERENTE'}">
						<button class="btn btn-outline-primary mr-1 mt-1" data-toggle="modal" data-target="#<portlet:namespace />rimandaAlReferenteModal">
							<liferay-ui:message key="rimanda-al-referente" />
						</button>
					</c:when>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</c:if>
