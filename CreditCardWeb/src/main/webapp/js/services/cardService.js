var module = angular.module("creditcard");

module.service("cardService", function($http){

	this.getCards = function(cedula){
		return $http.get("/CreditCardWeb/rest/creditcard/cards/"+cedula);
	};
	
	this.saveCard = function(cedula, label, mount,dateCut){
		var card = {"cedula":cedula, "label":label, "mount":mount, "dateCut":dateCut, "bonus":0, "status":0};
		return $http.put("/CreditCardWeb/rest/creditcard/card", card);
	};
	
	this.deleteCard = function(id){
		var card = {"id":id};
		return $http.post("/CreditCardWeb/rest/creditcard/card", card);
	};
});