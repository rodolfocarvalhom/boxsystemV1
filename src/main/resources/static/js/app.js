//Carregando pacote principal angular
var appBoxSystem = angular.module("appBoxSystem",['ngRoute']);

appBoxSystem.config(function($routeProvider,$locationProvider){

	$routeProvider
	.when("/login",{templateUrl:'view/login.html',controller:'loginController'})
	.when("/cliente",{templateUrl:'view/cliente.html',controller:'clienteController'})
	.when("/cliente/:ClienteId",{templateUrl:'view/cliente-detalhe.html',controller:'clienteDetalheController'})
	.when("/uf",{templateUrl:'view/uf.html',controller:'ufController'})
	.when("/cidade",{templateUrl:'view/cidade.html',controller:'cidadeController'})
	.otherwise({rediretTo:'/'});	
	
//	configuracao para retirar o # do link das rotas no browse
	$locationProvider.html5Mode(true);
	
});

appBoxSystem.config(function($httpProvider){
	$httpProvider.interceptors.push('tokenInterceptor');
});