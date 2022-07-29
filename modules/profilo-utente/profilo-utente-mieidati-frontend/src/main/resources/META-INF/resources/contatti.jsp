<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=ProfiloUtenteMieiDatiPortletKeys.SALVA_EMAIL_ACTION_COMMAND_NAME %>" var="salvaEmailURL">
</portlet:actionURL>

<%
	User utente = (User) renderRequest.getAttribute(ProfiloUtenteMieiDatiPortletKeys.UTENTE);
	ExpandoBridge utenteExpandoBridge = utente.getExpandoBridge();
%>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="email"/>
				</label>
			</div>
			<div>
				<c:out value="${not empty utente.emailAddress ? utente.emailAddress : \"-\"}"/>
			</div>
		</div>
		
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="pec"/>
				</label>				
			</div>
			<div>				
				
				<c:out value="<%=utenteExpandoBridge.getAttribute(ProfiloUtenteMieiDatiPortletKeys.EXPANDO_USER_PEC) %>"/>
			</div>
		</div>	
		
		<div class="col">
			<aui:form method="post" action="${salvaEmailURL }">
				<div class="form-group">
					<aui:input type="text" name="<%=ProfiloUtenteMieiDatiPortletKeys.EMAIL_SECONDARIA %>" value="<%=utenteExpandoBridge.getAttribute(ProfiloUtenteMieiDatiPortletKeys.EXPANDO_USER_EMAIL_AGGIUNTIVA) %>" >
						<aui:validator name="email"></aui:validator>
					</aui:input>
				</div>
				<button type="submit" hidden="true" id="submitButton"></button>
				<button type="reset" hidden="true" id="resetButton"></button>
			</aui:form>			
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="telefono"/>
				</label>
			</div>

			<c:choose>
				<c:when test="${not empty utente.phones }">
					<c:forEach items="${utente.phones }" var="phone">
						<div>
							<c:out value="${phone.number}"/>
						</div>			
					</c:forEach>				
				</c:when>
				
				<c:otherwise>
					<c:out value="-"/>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="col">
			<div>
				<label>
					<liferay-ui:message key="cellulare"/>
				</label>
			</div>

			<div>
				<c:out value="-"/>
			</div>			
		</div>
	</div>
	
	<aui:button-row cssClass="text-right">
		<aui:button type="submit"  value="salva" id="submitFakeButton"/>
		<aui:button value="annulla" id="resetFakeButton"/>
	</aui:button-row>
</div>

<script type="text/javascript">
// 	function triggerEmailSubmit(){
// 	}
	$("#<portlet:namespace/>submitFakeButton").on('click', function(){
		$("#submitButton").trigger('click');		
	});
	
// 	function triggerEmailReset(){
// 	}

	$("#<portlet:namespace/>resetFakeButton").on('click', function(){
		$("#resetButton").trigger('click');
	});
</script>
