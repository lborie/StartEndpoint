"use strict";

startEndpointApp.service("Task", function ($http) {
    var ROOT = 'http://localhost:8000/_ah/api/task/v1';

    return {

        fetch : function() {
            return $http.get(ROOT + '/tasks');
        },

        create : function(task) {
            return  $http.post(ROOT + '/insert', task);
        }
    };

});