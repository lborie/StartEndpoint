"use strict";

startEndpointApp.controller("homeController" ,function ($scope) {

    $scope.project = 'Start Endpoints';

});

startEndpointApp.controller("taskController" ,function ($scope, Task) {
    $scope.s = "";

    Task.fetch().success(function(resp){
        $scope.tasks = resp.items;
        $scope.s = ($scope.tasks.length > 1)? "s" : "";
    });
});


startEndpointApp.controller("modalTaskController" ,function ($scope, Task) {
    $scope.open = function () {
        $scope.modalTask = true;
    };

    $scope.close = function () {
        $scope.closeMsg = 'I was closed at: ' + new Date();
        $scope.modalTask = false;
    };

    $scope.opts = {
        backdropFade: true,
        dialogFade:true
    };

    $scope.addTask = function(task){
        Task.create(task)
            .success(function(){
                var newTask = {};
                angular.copy(task, newTask);
                $scope.tasks.push(newTask);
                $scope.task = {};
                $scope.showAlert = false;
                $scope.dismiss();
            })
            .error(function(resp, statusCode){
                // Affichage d'un message d'erreur
                $scope.errorTitle = 'Erreur ' + statusCode ;
                $scope.errorMessage = resp.error;
                $scope.showAlert = true;
            });
        $scope.modalTask = false;
    };

});