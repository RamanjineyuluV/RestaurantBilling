/* global angular */
/* jshint -W097 */
'use strict';
/**
 * @ngdoc object
 * @name models.OrdersModel
 */
var OrdersModel = angular.module('models.OrdersModel', [
    'services.OrdersService'
]);

/**
 * @ngdoc object
 * @name models.OrdersModel
 * @description
 * Injectable model.
 *
 */
OrdersModel.factory('OrdersModel', ['$rootScope', 'OrdersService', '$q', '$location',
    function ($rootScope, OrdersService, $q, $location) {

        var model = {};
        
        model.orders = [];
        
        model.order = {"orderInput": {"arrangement" : "Standard"} };
       
        /**
         * @ngdoc function
         * @name models.OrdersModel#loadOrders
         *
         * @description
         * Loads the orders property.
         *
         * @methodOf models.OrdersModel
         */
        model.loadOrders = function () {
            return OrdersService.list().then(ordersLoadingResult, loadingFault);
        };

        var ordersLoadingResult = function (data) {
            var result = data.result, status = data.status;  
            model.orders = result;
            return data;
        };
        
        model.getCalcs = function () {
            return OrdersService.getCalcs(model.order.orderInput).then(oLoadingResult, loadingFault);
        };

        var oLoadingResult = function (data) {
            var result = data.result, status = data.status;  
            model.order = result;
            return data;
        };
        

        var loadingFault = function (fault) {
            var data = fault.data, status = fault.status;
            return fault;
        };
        
        model.createOrder = function () {
            return OrdersService.createOrder(model.order).then(orderLoadingResult, loadingFault);
        };
       
        var orderLoadingResult = function (data) {
            var result = data.result, status = data.status;  
            model.order = {};
            return data;
        };

        
        
    


        //---------------------------------------------------------------------
        //
        //  Initialize
        //
        //---------------------------------------------------------------------

        /**
         * @ngdoc function
         * @name models.OrdersModel#initialize
         *
         * @description
         * Initializes the model by setting necessary defaults.
         *
         * @methodOf models.OrdersModel
         */
        model.initialize = function () {

        };

        //when the model is ready
        //this calls the initialize
        //similar to some sort of
        //constructor
        model.initialize();
        return model;
    }]);