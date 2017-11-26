/* global angular */
/* jshint -W097 */
'use strict';
/**
 * @ngdoc object
 * @name app.sections.orders
 *
 * @description
 * View module.
 *
 * @requires ui.router
 */
var ordersModule = angular.module('app.sections.orders', [
    'ui.router',
    'app.sections.create',
    'models.OrdersModel'
]);

/**
 * @ngdoc function
 * @name app.sections.orders:config
 *
 * @description
 * - adds routing between ctrl and view template.
 *
 * @methodOf app.sections.orders
 *
 * @requires $stateProvider
 */
ordersModule.config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('orders', {
            url: '/orders',
            views: {
                main: {
                    controller: 'ordersCtrl',
                    templateUrl: 'src/app/sections/orders/orders.tpl.html'
                }
            },
            data: { pageTitle: 'Restaurant Billing System' }
        });
}]);

/**
 * @ngdoc object
 * @name app.sections.orders:ordersCtrl
 *
 * @description
 * Controller.
 *
 * @requires $rootScope
 * @requires $scope
 * @requires $location
 *
 */
ordersModule.controller('ordersCtrl', ['$rootScope', '$scope', '$location', 'OrdersModel', 
							function ($rootScope, $scope, $location, OrdersModel) {
	
	 
	$scope.create = function() {
		$location.path("create");
	};
	
    /**
     * @ngdoc function
     * @name app.sections.orders.ordersCtrl:onRegister
     *
     * @description
     * Sets the view on view startup.
     * Binds models to $scope.
     * Adds listeners to $rootScope.
     *
     * @methodOf app.sections.orders:ordersCtrl
     */
    var onRegister = function () {
        //add listeners

    	 //set binding
    	OrdersModel.loadOrders();
        //get state
        $scope.OrdersModel = OrdersModel;

       
        
        
        //set view
    };

    //called at view startup
    onRegister();
}]);