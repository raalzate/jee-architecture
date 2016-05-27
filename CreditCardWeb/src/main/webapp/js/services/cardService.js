var module = angular.module("creditcard");

module.service("listService", function($http){

	this.getCards = function(cedula){
		return $http.get("/CreditCardWeb/rest/creditcard/cards/"+cedula);
	};
});