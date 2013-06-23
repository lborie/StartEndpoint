"use strict";

/**
 * Controller of the home page
 */
startEndpointApp.controller("homeController" ,function ($scope) {

    $scope.project = 'Start Endpoints';

});

/**
 * Controller of the Task management page
 */
startEndpointApp.controller("taskController" ,function ($scope, Task) {
    $scope.s = "";

    Task.fetch().success(function(resp){
        $scope.tasks = resp.items;
        $scope.s = ($scope.tasks.length > 1)? "s" : "";
    });

    $scope.deleteTask = function(index) {
        var deleteTask = confirm('Are you sure ?');

        if (deleteTask) {
            Task.delete($scope.tasks[index].id)
                .success(function(){
                    $scope.tasks.splice(index, 1);
                });
        }



    }
});

/**
 * Sub Controller for the tasks management (modal window)
 */
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
            .success(function(myNewTask){
                $scope.tasks.push(myNewTask);
                $scope.task = {};
                $scope.showAlert = false;
                $scope.dismiss();
            });
        $scope.modalTask = false;
    };

});