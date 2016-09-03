//Criação de controles por tela
appBoxSystem.controller("clienteDetalheController",function($scope,$http,$routeParams){
	$scope.cliente = {};
	$http.get("clientes/"+$routeParams.ClienteId).then(function(response){
		$scope.cliente = response.data;
	},function(response){
		console.log(response);
	});
	
});