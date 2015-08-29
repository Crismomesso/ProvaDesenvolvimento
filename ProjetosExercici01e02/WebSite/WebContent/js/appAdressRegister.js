var app = angular.module('app', ['ngCookies','ui.utils.masks','ui.mask','ui.grid', 'ui.grid.selection']);

app.factory('adressCtrlService',
        ['$http',
         function ($http) {
             var service = {};

             service.save = function (serviceUrl,entityId, successCallback, errorCallback) {
                 $http.post(serviceUrl, entityId)
                     .success(successCallback)
                     .error(errorCallback);
             };
             
             service.find = function (serviceUrl,entityId, successCallback, errorCallback) {
                 $http.post(serviceUrl, entityId)
                     .success(successCallback)
                     .error(errorCallback);
             };
             
             service.Delete = function (serviceUrl,entityId, successCallback, errorCallback) {
                 $http.post(serviceUrl, entityId)
                     .success(successCallback)
                     .error(errorCallback);
             };
         
             return service;
 }]);

app.controller('AdressController', ['$window', '$scope', '$location','adressCtrlService', '$cookies', function ($window, $scope, $location,adressCtrlService,$cookies) {
		
	var self = this;
	self.editMode = false;
	self.entityToEdit = {};
	self.data = [];
	self.valorTeste = {
    };
	
	 
	 self.gridOptions = {
            enableRowSelection: false,
            multiSelect: false,
            enableRowHeaderSelection: false,
            columnDefs: [{
                name: 'zip',
                displayName: 'zip',
                width: 150
            },
            {
                name: 'logradouro',
                displayName: 'logradouro',
                width: 400
              }, 
              {
                name: 'numerStreet',
                displayName: 'Número',
                width: 200
               }, 
               {
                name: 'city',
                displayName: 'Cidade',
                width: 200
  				},
	            {
                name: 'state',
                displayName: 'Estado',
                width: 100
  				 },
   				 {
                name: 'bairro',
                displayName: 'Bairro',
                width: 300
  				},
  				 {
                name: 'complemento',
                displayName: 'Complemento',
                width: 350
  	     		},
                {
                name: 'edit',
                field: 'id',
                displayName: '',
                enableSorting: false,
                width: 50,
                cellTemplate: '<div ><button type="button" class="btn btn-info btn-xs" ng-click="getExternalScopes().editGridItem(this)"><i class="fa fa-edit"></i> Editar </button> </div>'
            }, {
                name: 'exclude',
                field: 'id',
                displayName: '',
                enableSorting: false,
                width: 65,
                cellTemplate: '<div><button type="button" class="btn btn-danger btn-xs" ng-click="getExternalScopes().deleteGridItem(this)"><i class="fa fa-times-circle">Excluir</i></button></div>'
            }],
            data: self.data
        }	 
	
		  
		    this.initController = function() {
			
			  adressCtrlService.find('http://localhost:8080/Services/rest/zip/getAdress', $cookies.id, function(sucessData) {
                  angular.forEach(sucessData, function(value, key) {
                      value.index = key;
                      self.gridOptions.data.push(value);
                  });
                  self.renderPag = true;
              }, function(erro){
				  alert('erro ao buscar');
		      });

			};

			this.save = function() {
				self.entityToEdit.userId=$cookies.id;
				adressCtrlService.save('http://localhost:8080/Services/rest/zip/salvar',self.entityToEdit,
						  function(sucess){
							  alert('salvo');
							  self.refresh();
						  },function(erro){
							  alert('erro ao salvar');
			      });
			};
			
			self.findAdress = function(input){
				
				if(input.$valid){
					var json={};
					json.cep = self.entityToEdit.zip;
					adressCtrlService.find('http://localhost:8080/Services/rest/zip/searchZipCode',json,
						function(sucess){
						   self.entityToEdit.logradouro = sucess.logradouro;
						   self.entityToEdit.bairro = sucess.bairro;
						   self.entityToEdit.state = sucess.uf;
						   self.entityToEdit.city = sucess.localidade;
						},
						function(error){
							
						}
					);
				}
				
			};
			
			self.newItem= function() {
				//self.gridOptions.data.push(self.valorTeste);
				self.editMode = true;
			};
			
			 self.editGridItem = function(rowClick) {
                 ctrl = this;
                 self.editMode = true;
                 self.entityToEdit = ctrl.data[rowClick.row.index];
                 self.entityToEdit.numerStreet=parseInt(self.entityToEdit.numerStreet);
             };
             
             self.deleteGridItem = function(rowClick) {                
                 ctrl = this;
                 var indexToDel = ctrl.data[rowClick.row.index].id;              
    			adressCtrlService.Delete('http://localhost:8080/Services/rest/zip/deletar',indexToDel,
    					  function(sucess){
    						  self.data.splice(rowClick.row.index, 1);
                              self.refresh();    
    						  alert('Endereço deletado');
    					  },function(erro){
    						  alert('Erro ao deletar o endereço');
    			});
                 
             };
             
             self.refresh = function() {
                 $window.location.reload();
             };

} ]);
	
	
