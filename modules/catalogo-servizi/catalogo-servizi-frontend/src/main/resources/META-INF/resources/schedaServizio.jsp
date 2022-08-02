<%@ include file="init.jsp" %>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<div class="row">
		<div class="col">
			<div class="chip chip-simple">
				<span class="chip-label">${servizio.areaTematica.nome }</span>
			</div>
			<h1 class="mt-4">${servizio.nome }</h1>
			<h2 class="mt-3"><liferay-ui:message key="cosa-e"/></h2>
			<p>
				${not empty servizio.descrizioneEstesa ? servizio.descrizioneEstesa : "-" }
			</p>
			<a class="mt-3" href="#" title="Vai al servizio"> 
				<strong>Vai</strong>
				<span class="fa fa-angle-double-right fa-lg marginleft5" aria-hidden="true"></span>
			</a>
		</div>
	</div>
</div>