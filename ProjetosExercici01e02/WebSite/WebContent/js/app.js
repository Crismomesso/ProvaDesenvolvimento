var app = angular.module('app', ['ngCookies']);

app.factory('loginCtrlService',
        ['$http',
         function ($http) {
             var service = {};

             service.login = function (serviceUrl,entityId, successCallback, errorCallback) {
                 $http.post(serviceUrl, entityId)
                     .success(successCallback)
                     .error(errorCallback);
             };
         
             return service;
 }]);

app.controller('Controller', ['$window', '$scope', '$location','loginCtrlService', '$cookies', function ($window, $scope, $location,loginCtrlService,$cookies) {

	var self = this;
	self.userAuth={};
	self.userAuth.user = '';
	self.userAuth.password = '';
	
		this.initController = function() {
	       
		};

	  self.login = function() {

		
		  loginCtrlService.login('http://localhost:8080/Services/rest/user/login',self.userAuth,
		  function(sucess){
			  $cookies.id = sucess;
			  $window.location.href = 'adressRegister.html';
		  },function(erro){
			  
		  });
      };
	
      
      

      
}]);
	
	
