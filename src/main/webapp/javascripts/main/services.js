"use strict";

/**
 * Task service to interact with the Task API
 */
startEndpointApp.service("Task", function ($http) {
    var ROOT = 'https://startendpoint.appspot.com/_ah/api/task/v1';

    return {

        fetch : function() {
            return $http.get(ROOT + '/tasks');
        },

        create : function(task) {
            return  $http.post(ROOT + '/insert', task);
        },

        delete : function(id) {
          return $http.delete(ROOT + '/delete/' + id);
        }
    };

});