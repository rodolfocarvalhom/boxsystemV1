//Criação de controles por tela
appBoxSystem.controller("mainController",['$scope', '$log',function($scope,$http,$location,$route,$routeParams){
	$scope.$location = $location;
	$scope.$route = $route;
	$scope.$routeParams = $routeParams; 
}]);