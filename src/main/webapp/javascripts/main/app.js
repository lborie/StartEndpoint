"use strict";

var startEndpointApp = angular.module('startEndpointApp', ['ui.bootstrap']);

/**
 * Router
 */
startEndpointApp.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'views/home.html',
            controller : 'homeController'
        })
        .when('/taskmanagement',{
            templateUrl: 'views/taskmanagement.html',
            controller: 'taskController'
        })
        .otherwise({
            redirectTo: '/home'
        });
});