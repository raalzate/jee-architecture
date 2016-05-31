var module = angular.module("creditcard");


module.controller("saveController", function($scope, cardService, $location){	
	$scope.guardarCard = function(){
		
		var dateCut = moment($scope.dateCut).format("YYYY-MM-DD");
		console.log($scope.dateCut);
		console.log(dateCut);

		var saveCard = cardService.saveCard(
				$scope.cedula, $scope.label, $scope.mount, dateCut);

		saveCard.success(function(data){
			alert("Se creo la tarjeta correctamente!.");
			$location.url("/");
		}).error(function(data, status, headers, config){
			alert("Error al guardar");
		});
	};
	
	$scope.regresar = function(){
		$location.url("/");
	};
});