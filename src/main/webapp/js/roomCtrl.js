(function () {
    'use strict';
    var app = angular.module('labApp');
    app.controller("roomCtrl",['$scope','roomService','$state',function ($scope,roomService,$state) {
        roomService.loadRooms(function (data) {
            $scope.rooms = data;
            console.log(data)
        });

        $scope.clickRoom = function (roomId) {
            console.log(roomId)
            $state.go('equipment',{roomId: roomId})
        }
    }]);

    app.service("roomService",["$http",function ($http) {
        this.loadRooms = function (callback) {
            $http({
                url : '/rooms/equipments',
                method : 'GET'
            }).then(function (data) {
                if (callback){
                    callback(data.data);
                }
            })
        }
    }])
})();
