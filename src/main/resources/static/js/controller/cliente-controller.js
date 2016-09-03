//Criação de controles por tela
appBoxSystem.controller("clienteController",function($scope,$http){
	
	$scope.clientes 		= [];
	$scope.cliente 			= {};
	$scope.ufs 				= [];
	$scope.uf				= {}

	carregarClientes=function(){
		
		token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+ token;
		
		$http({method:'GET',url:'http://localhost:8080/admin/clientes'})
		.then(function(response){

			$scope.clientes = response.data;
			
		},function(response){
			console.log(response.data);
			console.log(response.status);		
		});
	};

	carregarUf=function(){
	
		$http({method:'GET',url:'http://localhost:8080/admin/uf'})
		.then(function(response){

			$scope.ufs = response.data;
			
		},function(response){
			console.log(response.data);
			console.log(response.status);		
		});
	};		
	
	$scope.salvarCliente = function(){
		if($scope.frmCliente.$valid){

			
//			$http.get("http://localhost:8080/admin/uf/"+$scope.cliente.uf_id).then(function(response){
//				$scope.cliente.uf_id = {};
//				$scope.cliente.uf_id = response.data;
//					
//			},function(response){
//				console.log(response);
//			});
			
			$http({method:'POST',url:'http://localhost:8080/admin/clientes',headers:{'Content-Type': 'application/json'},data:$scope.cliente})
			.then(function(response){

				$scope.cliente = {};
				//				Retornando o estado do formulario como novo (primitivo)
				carregarClientes();
				$scope.frmCliente.$setPristine(true);
//				$scope.frmCliente.$setDirty();
				$scope.frmCliente.$setUntouched();
			},function(response){
				console.log(response.data);
				console.log(response.status);		
			});
			
		}else{
			window.alert("Dados Inválidos!")
		}
	}

	$scope.excluirCliente = function(index,id){
		$http({method:'DELETE',url:'http://localhost:8080/admin/clientes/'+id})
		.then(function(response){

			$scope.clientes.splice(index,1);
			
		},function(response){
			console.log(response.data);
			console.log(response.status);		
		});		
	}	

	$scope.alterarCliente = function(index,cli){
		$scope.cliente = angular.copy(cli);
	}	

	$scope.cancelarAlterarCliente = function(){
		$scope.cliente = {};
	}
	
	carregarClientes();
	carregarUf();
});