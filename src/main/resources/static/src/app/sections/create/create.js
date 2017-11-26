/* global angular */
/* jshint -W097 */
'use strict';
/**
 * @ngdoc object
 * @name app.sections.create
 *
 * @description
 * View module.
 *
 * @requires ui.router
 */
var createModule = angular.module('app.sections.create', [
    'ui.router',
    'models.OrdersModel'
]);

/**
 * @ngdoc function
 * @name app.sections.create:config
 *
 * @description
 * - adds routing between ctrl and view template.
 *
 * @methodOf app.sections.create
 *
 * @requires $stateProvider
 */
createModule.config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('create', {
            url: '/create',
            views: {
                main: {
                    controller: 'createCtrl',
                    templateUrl: 'src/app/sections/create/create.tpl.html'
                }
            },
            data: { pageTitle: 'Create Order' }
        });
}]);

/**
 * @ngdoc object
 * @name app.sections.create:createCtrl
 *
 * @description
 * Controller.
 *
 * @requires $rootScope
 * @requires $scope
 * @requires $location
 *
 */
createModule.controller('createCtrl', ['$rootScope', '$scope', '$location', 'OrdersModel', 
							function ($rootScope, $scope, $location, OrdersModel) {
	
	$scope.doneCalcs=false;
	 /**
    * @ngdoc function
    * @name app.sections.create.createCtrl:add
    *
    * @description
    * responds to the submit action on the form.
    *
    * @methodOf app.sections.create:createCtrl
    */
   $scope.add = function () {
	   
	   OrdersModel.createOrder();
	   $scope.doneCalcs = false;
   }
   
   /**
    * @ngdoc function
    * @name app.sections.create.createCtrl:getCalcs
    *
    * @description
    * responds to the submit action on the form.
    *
    * @methodOf app.sections.create:createCtrl
    */
   $scope.getCalcs = function () {
	   
	   OrdersModel.getCalcs();
	   $scope.doneCalcs = true;
   }
   
    /**
     * @ngdoc function
     * @name app.sections.create.createCtrl:onRegister
     *
     * @description
     * Sets the view on view startup.
     * Binds models to $scope.
     * Adds listeners to $rootScope.
     *
     * @methodOf app.sections.create:createCtrl
     */
    var onRegister = function () {
        //add listeners

        //set binding
    	 //set binding
        $scope.OrdersModel = OrdersModel;
        //get state
        //set view
    };

    //called at view startup
    onRegister();
}]);