<%@ include file="init.jsp" %>

<div class="container pl-0 pr-0 mb-4 mt-4">

		<div class="row">
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="nome"/>
					</label>
				</div>
				<div>
					<c:out value="${not empty utente.firstName ? utente.firstName : \"-\"}"/>
				</div>
			</div>
			
			<div class="col">
				<div>				
					<label>
						<liferay-ui:message key="secondo-nome"/>
					</label>
				</div>
				
				<div>
					<c:out value="${not empty utente.middleName ? utente.middleName : \"-\"}"/>				
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="cognome"/>
					</label>				
				</div>
				<div>				
					<c:out value="${not empty utente.lastName  ? utente.lastName  : \"-\"}"/>
				</div>
			</div>		
		</div>
		
		<div class="row">
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="data-di-nascita"/>
					</label>
				</div>
	
				<fmt:formatDate type="date" value="${utente.birthday}" dateStyle="long" var="dataNascitaFormattato"/>
				<div>
					<c:out value="${dataNascitaFormattato}"/>
				</div>			
			</div>
			
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="sesso"/>
					</label>
				</div>
	
				<div>
					<c:choose >
						<c:when test="${utente.male eq true }">
							<c:out value="M"/>							
						</c:when>
						
						<c:when test="${utente.female eq true }">
							<c:out value="F"/>							
						</c:when>
						
						<c:otherwise>
							<c:out value="-"/>							
						</c:otherwise>
					</c:choose>
				</div>			
			</div>
		</div>
			
		<div class="row">
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="indirizzo-resizenza"/>
					</label>
				</div>
				<div>
					<c:out value="-"/>
				</div>				
			</div>	
			
			<div class="col">
				<div>			
					<label>
						<liferay-ui:message key="numero-civico"/>
					</label>
				</div>
				
				<div>
					<c:out value="-"/>
				</div>
			</div>	
		</div>	
</div>
