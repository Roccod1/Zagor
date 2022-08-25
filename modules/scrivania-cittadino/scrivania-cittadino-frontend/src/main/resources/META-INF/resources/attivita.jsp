<div class="accordion accordion-background-hover accordion-flush" id="accordionExampleHh">
<c:forEach items="${listaPratiche }" var="item">
  <div class="accordion-item">
    <h2 class="accordion-header " id="heading${item.protocollo }">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${item.protocollo }" aria-expanded="true" aria-controls="collapse${item.protocollo }">
      	${item.nome }
      </button>
    </h2>
   	
    <div class="accordion-body" style="padding: 12px 24px 24px;">
    
	<fmt:formatDate value="${item.data }" pattern="yyyy-MM-dd" var="data"/>
   	<p class="accordion-date title-xsmall-regular mb-0">${data }</p>  
    
    <div id="collapse${item.protocollo }" class="accordion-collapse collapse" data-bs-parent="#accordionExampleHh" role="region" aria-labelledby="heading${item.protocollo }">
    	<c:if test="${item.descrizione }">
              <p class="mb-3">${item.descrizione}</p>
    	</c:if>

        <p>Pratica: ${item.protocollo }</p>

<!--         {{#if item.import}} -->
<!--           <p>Metodo: <span class="label">PagoPA</span></p> -->
<!--           <p class="mb-2">Importo: <span class="label">44,00 €</span></p> -->
<!--         {{/if}} -->

        <a href="#"><span class="t-primary underline">Scheda servizio</span></a>
      </div>
    </div>
   </div>
</c:forEach>
</div>