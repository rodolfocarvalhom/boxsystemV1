//Criação de controles por tela
appBoxSystem.controller("ufController",function($scope,$http){
	
	$scope.ufs = [];
	$scope.uf = {};
	
	$scope.carregarUf=function(){
		$http({method:'GET',url:'http://localhost:8080/admin/uf'})
		.then(function(response){

			$scope.ufs = response.data;
			
		},function(response){
			console.log(response.data);
			console.log(response.status);		
		});
	};	
	
	$scope.salvarUf = function(index){
		if($scope.frmUf.$valid){
			$http({method:'POST',url:'http://localhost:8080/admin/uf',headers:{'Content-Type': 'application/json'},data:$scope.uf})
			.then(function(response){

				$scope.uf = {};
				$scope.carregarUf();
				$scope.frmUf.$setPristine(true);
//				$scope.frmUf.$setDirty();
				$scope.frmUf.$setUntouched();
			},function(response){
				console.log(response.data);
				console.log(response.status);		
			});
		}else{
			window.alert("Dados Inválidos!")
		}
	}
	
	$scope.carregarUf();
	
});