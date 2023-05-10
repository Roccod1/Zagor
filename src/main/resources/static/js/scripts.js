	
		$(document).ready(function() {
			var $grid = $('.grid');
			var currentPage = 0;
			var maxItemsPerPage = 10;
			var maxPagesToShow = 10; // il numero massimo di pagine da mostrare nella paginazione alla volta
							
			function loadImages(page) {
				$.ajax({
					url: '/api/fumetti',
					data: { page: page },
					method: 'get',
					success: function (data) {
							        	
						// Aggiungi il codice per la paginazione dinamica qui
						var totalPages = Math.ceil(data.total / maxItemsPerPage);
						var paginationHtml = '';
						
						// Calcola il range di pagine da mostrare
						var startPage = Math.floor(page / maxPagesToShow) * maxPagesToShow;
						var endPage = Math.min(startPage + maxPagesToShow, totalPages);
				
						// Se non siamo alla prima pagina, mostra il pulsante per tornare indietro
						if (page > 0) {
							paginationHtml += '<li class="page-item"><a href="#" class="page-link" data-page="' + (page) + '">Prev</a></li>';
						}
	
						// Genera i numeri di pagina
						for (var i = startPage; i < endPage; i++) {
							paginationHtml += '<li class="page-item' + (i === page ? ' active' : '') + '"><a href="#" class="page-link" data-page="' + (i+1) + '">' + (i+1) + '</a></li>';
						}
				
						// Se non siamo all'ultima pagina, mostra il pulsante per andare avanti
						if (page < totalPages - 1) {
							paginationHtml += '<li class="page-item"><a href="#" class="page-link" data-page="' + (page + 2) + '">Next</a></li>';
						}
	
						$('.pagination').html(paginationHtml);
	
						// Rimuovi gli elementi griglia esistenti
						var $currentItems = $grid.find('.grid-item');
						$grid.empty();
										
						var $row = $('<div class="grid-row"></div>');
						for (var i = 0; i < data.data.length; i++) {
							var $item = $('<div class="grid-item"><img src="' + data.data[i].url + '" alt="" srcset="" titolo="' + data.data[i].titolo + '" numero="' + data.data[i].numero + '"></div>');
							$row.append($item);
							if ((i + 1) % 5 === 0 || i === data.data.length - 1) {
								$grid.append($row);
								$row = $('<div class="grid-row"></div>');
							}
						}
						showTitleOnMouseOver();
						attachDownloadOnClick();
					}
				});
			}
	
							
			// Listener per l'evento di invio del form di ricerca
			$("#searchForm").submit(function (event) {
				event.preventDefault();
				var searchNumero = $("#searchInput").val();
				var searchTitolo = $("#searchTitolo").val();
				if (searchNumero) {
					searchImageByNumero(searchNumero);
				}else if (searchTitolo) {
	        		searchImageByTitolo(searchTitolo);
	    		}
			});
	
			// dynamic version
	
			loadImages(currentPage)
			
			// Listener per i click sugli elementi della paginazione
			$(document).on('click', '.pagination a.page-link', function (e) {
				e.preventDefault();
				currentPage = $(this).data('page') - 1; // Aggiorna il valore di currentPage
				loadImages(currentPage);
			});	
							
		});
		
		
		
		function searchImageByNumero(numero) {
			  $.ajax({
			    url: "/api/fumetti/" + numero,
			    method: "get",
			    success: function (data) {
			      var $grid = $(".grid");
			      $grid.empty();
	
			      var $item = $(
			        '<div class="grid-item"><img src="' +
			          data.url +
			          '" alt="" srcset="" titolo="' +
			          data.titolo +
			          '" numero="' +
			          data.numero +
			          '"></div>'
			      );
			      $grid.append($item);
	
			      showTitleOnMouseOver();
			    },
			    error: function (jqXHR, textStatus, errorThrown) {
			      if (jqXHR.status === 404) {
			        alert("Fumetto non trovato");
			      } else {
			        alert("Errore nella ricerca del fumetto");
			      }
			    },
			  });
			}
			
			function searchImageByTitolo(titolo) {
	    	$.ajax({
	        	url: "/api/fumetti/bytitolo/" + titolo,
	        	method: "get",
	        	success: function (data) {
	            	var $grid = $(".grid");
	            	$grid.empty();
	
	            	var $row = $('<div class="grid-row"></div>');
	            	for (var i = 0; i < data.length; i++) {
	                	var $item = $('<div class="grid-item"><img src="' + data[i].url + '" alt="" srcset="" titolo="' + data[i].titolo + '" numero="' + data[i].numero + '"></div>');
	                	$row.append($item);
	                	if ((i + 1) % 5 === 0 || i === data.length - 1) {
	                    	$grid.append($row);
	                    	$row = $('<div class="grid-row"></div>');
	                	}
	            	}
	            	showTitleOnMouseOver();
	        	},
	        	error: function (jqXHR, textStatus, errorThrown) {
	            	if (jqXHR.status === 404) {
	                	alert("Nessun fumetto trovato con il titolo specificato");
	            	} else {
	                	alert("Errore nella ricerca del fumetto");
	            	}
	        	},
	    	});
		}
		
		// Aggiunta della funzione per gestire l'evento mouse-over per tooltip
		function showTitleOnMouseOver() {
			$(".grid-item img").mousemove(function(event) {
				var numero = "Numero ";
				numero += $(this).attr("numero");
				$(this).attr("title", numero);
			}).mouseout(function() {
				$(this).removeAttr("title");
			});
		}
		
		//Evento per scaricare le immagini con il click
		function attachDownloadOnClick() {
    		$(".grid-item img").click(function() {
        	var fileName = $(this).attr("titolo"); 
        window.location.href = "/api/fumetti/download/" + fileName;
    });
}
	
						