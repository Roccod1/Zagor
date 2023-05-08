
	$(document).ready(function() {
		var $grid = $('.grid');
		var currentPage = 0;
		var maxItemsPerPage = 10;
						
		function loadImages(page) {
			$.ajax({
				url: '/api/fumetti',
				data: { page: page },
				method: 'get',
				success: function (data) {
						        	
					// Aggiungi il codice per la paginazione dinamica qui
					var totalPages = Math.ceil(data.total / maxItemsPerPage);
					var paginationHtml = '';
					for (var i = 1; i <= totalPages; i++) {
						paginationHtml += '<li class="page-item' + (i === page + 1 ? ' active' : '') + '"><a href="#" class="page-link" data-page="' + i + '">' + i + '</a></li>';
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
				}
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
						
		// Listener per i click sugli elementi della paginazione
		$(document).on('click', '.pagination a.page-link', function (e) {
    		e.preventDefault();
    		currentPage = $(this).data('page') - 1; // Aggiorna il valore di currentPage
    		loadImages(currentPage);
		});
						
		// Listener per l'evento di invio del form di ricerca
		$("#searchForm").submit(function (event) {
			event.preventDefault();
			var searchNumero = $("#searchInput").val();
			if (searchNumero) {
				searchImageByNumero(searchNumero);
			}
		});

		// dynamic version

		loadImages(currentPage)
						
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
					