<%@ include file="init.jsp" %>

<portlet:renderURL var="portletURL">
</portlet:renderURL>


<aui:form action="${portletURL}">
	<aui:input name="queryNome" label="cerca-servizio" value="${queryNome}" />
	<aui:button type="submit" value="cerca" />
</aui:form>

<c:choose>
	<c:when test="${empty listaServizi }">
		<div class="alert alert-warning" role="alert">
		  <liferay-ui:message key="nessun-servizio-disponibile-per-ente-attuale" arguments="${nomeEnte}"/>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="row">
			<c:forEach items="${listaServizi}" var="servizio">
				<!--start card-->
				<div class="col-12 col-sm-6 col-lg-4">
					<div class="card-wrapper card-space">
						<div class="card card-bg card-img rounded shadow">
							<div class="card-body p-4">
								<div class="category-top">
									<svg class="icon icon-sm">
									  <use href="/o/portale-istituzionale-theme/svg/sprite.svg#it-settings"></use>
									</svg>
									<span class="category">${not empty servizio.areaTematica ? servizio.areaTematica.nome : "" }</span>
								</div>
								<h3 class="card-title">${servizio.nome}</h3>
								<p class="card-text">${servizio.descrizione}</p>
								<c:forEach items="${servizio.listaTipologie}" var="tipologia">
									<div class="chip chip-simple chip-primary chip-no-link">
	                                	<span class="chip-label">${tipologia.nome}</span>
	                                </div>
								</c:forEach>
								<portlet:renderURL var="schedaServizioURL">
									<portlet:param name="mvcRenderCommandName" value="<%=CatalogoServiziPortletKeys.RENDER_SCHEDA_SERVIZIO_NAME %>" />
									<portlet:param name="<%=CatalogoServiziPortletKeys.SERVIZIO_ID %>" value="${servizio.servizioId}" />
								</portlet:renderURL>
								<a class="read-more" href="${schedaServizioURL}">
									<span class="text"><liferay-ui:message key="leggi-di-piu"/></span> 
									<svg class="icon">
										<use xlink:href="/o/portale-istituzionale-theme/svg/sprite.svg#it-arrow-right"></use>
									</svg>
								</a>
							</div>
						</div>
					</div>
				</div>
				<!--end card-->
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>
