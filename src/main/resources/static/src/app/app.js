/* global angular */
/* global window */
/* global location */
/* jshint -W097 */
'use strict';
/**
 * @ngdoc object
 * @name app
 * 
 * @description Main app module.
 * 
 */
var appModule = angular.module('app', [
    'ui.router',
    'ui.bootstrap',
    'app.sections.orders'
]);

/**
 * @ngdoc function
 * @name app:config
 * 
 * @description Adds listener for uncaught exceptions.
 * 
 * @methodOf app
 * 
 * @requires $stateProvider
 * @requires $urlRouterProvider
 * @requires $httpProvider
 * @requires $provide
 */
appModule.config(['$stateProvider', '$urlRouterProvider', '$httpProvider',
    function ($stateProvider, $urlRouterProvider, $httpProvider) {
        $urlRouterProvider.otherwise('create');
    }]);


/**
 * @ngdoc function
 * @name app:run
 *
 * @description
 * Startup method. Starts loading the modules.
 *
 * @methodOf app
 *
 */
appModule.run(['OrdersModel',
    //'$http',
    function run(OrdersModel
    ) {
       // OrdersModel.loadOrders();
    }]);

/**
 * @ngdoc object
 * @name app.main:appCtrl
 * 
 * @description Main app controller.
 * 
 * @requires $location
 * @requires $scope
 * 
 */
appModule.controller('appCtrl', ['$rootScope', '$scope',
    function ($rootScope, $scope) {
	
        /**
		 * @ngdoc function
		 * @name app.main.appCtrl:onStateChangeSuccessHandler
		 * 
		 * @description Sets the page title based on state changes.
		 * 
		 * @param {event}
		 *            event from $scope.
		 * @param {object}
		 *            toState from $scope.
		 * @param {object}
		 *            toParams from $scope.
		 * @param {object}
		 *            fromState from $scope.
		 * @param {object}
		 *            fromParams from $scope.
		 * 
		 * @methodOf app.main:appCtrl
		 */
        var onStateChangeSuccessHandler = function (event, toState, toParams, fromState, fromParams) {
            // title
            if (angular.isDefined(toState.data.pageTitle) && toState.data.pageTitle != null) {
                $scope.pageTitle = toState.data.pageTitle;
            } else {
                $scope.pageTitle = '';
            }
        };
        
        /**
		 * @ngdoc function
		 * @name app.main.appCtrl:onRegister
		 * 
		 * @description Sets the view on view startup. Binds models to $scope.
		 *              Adds listeners to $rootScope.
		 * 
		 * @methodOf app.main:appCtrl
		 */
        var onRegister = function () {
            // add listeners
            // set binding
            // get state
            // set view
           
        };

        onRegister();
    }]);