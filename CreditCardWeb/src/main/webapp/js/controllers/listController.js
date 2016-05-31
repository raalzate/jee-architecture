var module = angular.module("creditcard");

module.controller("listController", function($scope, cardService, $location) {

	hiddenTable();
	
    function hiddenTable(){
		document.getElementsByTagName("table")[0]
			.style.visibility = "hidden";
	};
	
	function showTable(){
		document.getElementsByTagName("table")[0]
		.style.visibility = "visible";
	};
	
	
	$scope.buscarCards = function() {
		$scope.result = "Cargando...";
		
		var cards = cardService.getCards($scope.cedula);
		cards.success(function(data) {
			
			$scope.listCards = data;
			
			if (data.length > 0) {
				$scope.result = "";	
				showTable();
			} else {
				hiddenTable();
				$scope.result = "No hay resultados";
				document.getElementsByTagName("table")[0].style.visibility = "hidden";

			}

		}).error(function(data, status, headers, config) {
			alert(headers("internalServerError"));
			$scope.result = "Error de la consulta";
			hiddenTable();
		});

	};

	$scope.eliminarCard = function(id) {
		if(confirm("Desea eliminar la tarjeta?")) {
			$scope.result = "Cargando...";
			var cardDelete = cardService.deleteCard(id);
			cardDelete.success(function(data){
				if(data) {
					$scope.result = "";
					alert("Se elimino la tarjeta");
					document.getElementById('tr-'+id).remove();
				}
			}).error(function(data, status, headers, config){
				alert(headers("internalServerError"));
				$scope.result = "Error de la consulta";
			});
		}
		
	};

	$scope.nuevoCard = function() {
		$location.url("/save");
	};
});