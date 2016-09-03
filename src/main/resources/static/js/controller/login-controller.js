//Criação de controles por tela
appBoxSystem.controller("loginController",function($scope,$http){
	
	$scope.usuario = {};
	$scope.token = "";
	
	$scope.autenticar = function(){
		$http.post("http://localhost:8080/usuarios/autenticar",$scope.usuario).then(function(response){
			console.log("Sucesso" + response);
			$scope.token = response.data.token;
			localStorage.setItem("userToken",response.data.token);
			
		},function(response){
			console.log("Falha" + response);
		});
	}
	
});