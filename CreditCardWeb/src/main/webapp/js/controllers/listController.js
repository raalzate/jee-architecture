var module = angular.module("creditcard");

module.controller("listController", function($scope, cardService, $location) {

	document.getElementsByTagName("table")[0].style.visibility = "hidden";

	$scope.buscarCards = function() {

		var cards = cardService.getCards($scope.cedula);
		cards.success(function(data) {
			if (data) {
				$scope.listCards = data;
				document.getElementsByTagName("table")[0].style.visibility = "visible";
			} else {
				alert("No hay resultados");
			}

		}).error(function(data, status, headers, config) {
			alert(headers("internalServerError"));
		});

	};

	$scope.eliminarCard = function(id) {
		if(confirm("Desea eliminar la tarjeta?")) {
			var cardDelete = cardService.deleteCard(id);
			cardDelete.success(function(data){
				if(data) {
					alert("Se elimino la tarjeta");
					document.getElementById('tr-'+id).remove();
				}
			}).error(function(data, status, headers, config){
				alert(headers("internalServerError"));
			});
		}
		
	};

	$scope.nuevoCard = function() {
		$location.url("/save");
	};
});