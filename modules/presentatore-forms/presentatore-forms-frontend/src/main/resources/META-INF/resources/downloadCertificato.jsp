<%@ include file="./init.jsp" %>

<portlet:renderURL var="homeURL"></portlet:renderURL>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/pdf.js" /></script>

<liferay-ui:error key="<%=PresentatoreFormsPortletKeys.IMPOSSIBILE_RECUPERARE_PROCEDURA %>" message="error.generico" />

<div class="page-header">
		<b>${titoloPortletServizio}</b>
</div>

	<div class="alpaca-wizard">
				    <div class="alpaca-wizard-nav">
			            <nav class="navbar navbar-default" role="navigation">
			                <div class="container-fluid alpaca-wizard-back">
			                    <ul class="nav navbar-nav">
			                       
			                        <li data-alpaca-wizard-step-index="0" class="disabled">
			                            <div class="holder"><c:if test="${not empty allegato.documentiPersonali}"> style="display: none;"</c:if>
			                                <div class="title">...</div>
			                                <div class="description"></div>
			                            </div>
			                            <div class="chevron"></div>
			                        </li>
			                        <li class="active visited" data-alpaca-wizard-step-index="1">
			                            <div class="holder">
			                                <div class="title"><liferay-ui:message key="label.step.ultimoStep" /></div>
			                                <div class="description">Download</div>
			                            </div>
			                            <div class="chevron"></div>
			                        </li>
			                    </ul>
			                </div>
			            </nav>
			        </div>
				</div>
	
	<div class="form-actions text-center">
		<liferay-ui:message key="download.certificato" />
	</div>
	
	<div class="form-actions text-left">
		<liferay-ui:message key="label.certificato.ultimoStep.descrizione.downloadCertificato" />
	</div>

	<aui:row cssClass="mt-3">
		<div class="text-left">
	
		<portlet:resourceURL id="/downloadIstanza" var="downloadIstanzaUrl">
			<portlet:param name="destinazioneUsoId"value="${destinazioneUsoId}" />
			<portlet:param name="richiestaId"value="${richiestaId}" />
			<portlet:param name="codiceFiscaleComponente"value="${selectComponentiNucleoFamiliare}" />
		</portlet:resourceURL>
						
		<button class="btn btn-primary" type="button" onclick="window.open('${downloadIstanzaUrl}');">
				<i class="fa fa-download marginright10" aria-hidden="true"></i>
				<liferay-ui:message key="download.certificato" />
		</button>	

	</div>
	
	<div class="ml-auto">
		<button class="btn btn-primary" type="button">
				<liferay-ui:message key="button.valutaServizio" />
		</button>	
	</div>
	</aui:row>
	

