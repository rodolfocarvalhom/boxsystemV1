appBoxSystem.factory("tokenInterceptor",function($q,$location){
	return {
		'request': function(config){
			config.headers.Authorization = 'Bearer '+localStorage.getItem("userToken");
			return config;
		},
		'response': function(response){
			//Redireciona a URL para o caminho mapeado no Angular APP
			if(response.status==401){
				$location.path("/login")
			}
			return response;
		},
		'responseError': function(rejection){
			if(rejection.status==401){
				$location.path("/login")
			}			
			return $q.reject(rejection);
		}
	};
});