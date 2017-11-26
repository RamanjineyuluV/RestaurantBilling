/* global angular */
/* global document */
/* global navigator */
/* jshint -W097 */
'use strict';
/**
 * @ngdoc object
 * @name services.OrdersService
 */
var OrdersServiceModule = angular.module('services.OrdersService', []);

/**
 * @ngdoc object
 * @name services.OrdersService
 * @description
 * Injectable service to _.
 *
 */
OrdersServiceModule.factory('OrdersService', ['$rootScope', '$q', '$http', function ($rootScope, $q, $http) {

    var service = {};

    //---------------------------------------------------------------------
    //
    //  Methods
    //
    //---------------------------------------------------------------------
    /**
     * @ngdoc function
     * @name services.OrdersService:list
     *
     * @description
     * get orders list
     *
     *
     * @methodOf services.OrdersService
     */
    service.list = function () {
        var deferred = $q.defer();

        $http({method: 'GET', url: './orders'}).success(

            function (result, status, headers, config) {
                //good place for post processing
                deferred.resolve({"result": result, "status": status});
            }).error(
            function (data, status, headers, config) {
                if (data !== null && data.indexOf('|') > -1) {
                    var split = data.split('|');
                    status = split[0];
                    data = split[1];
                }
                deferred.reject({"data": data, "status": status});
            });
        return deferred.promise;
    };
    
    //---------------------------------------------------------------------
    /**
     * @ngdoc function
     * @name services.OrdersService:getCalcs
     *
     * @description
     * perform bill calcs
     *
     *
     * @methodOf services.OrdersService
     */
    service.getCalcs = function (data) {
        var deferred = $q.defer();

        $http({method: 'POST', url: './calcs', data: data}).success(
            function (result, status, headers, config) {
                //good place for post processing
                deferred.resolve({"result": result, "status": status});
            }).error(
            function (data, status, headers, config) {
                if (data !== null && data.indexOf('|') > -1) {
                    var split = data.split('|');
                    status = split[0];
                    data = split[1];
                }
                deferred.reject({"data": data, "status": status});
            });
        return deferred.promise;
    };
    
    //---------------------------------------------------------------------
    /**
     * @ngdoc function
     * @name services.OrdersService:createOrder
     *
     * @description
     * perform bill calcs
     *
     *
     * @methodOf services.OrdersService
     */
    service.createOrder = function (data) {
        var deferred = $q.defer();

        $http({method: 'POST', url: './orders', data: data}).success(
            function (result, status, headers, config) {
                //good place for post processing
                deferred.resolve({"result": result, "status": status});
            }).error(
            function (data, status, headers, config) {
                if (data !== null && data.indexOf('|') > -1) {
                    var split = data.split('|');
                    status = split[0];
                    data = split[1];
                }
                deferred.reject({"data": data, "status": status});
            });
        return deferred.promise;
    };
    //---------------------------------------------------------------------
    //
    //  Initialize
    //
    //---------------------------------------------------------------------
    var initialize = function () {

    };

    //like a cheap constructor
    initialize();
    return service;

}]);