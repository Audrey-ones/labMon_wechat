(function () {
    'use strict';
    var app = angular.module('labApp');
    app.controller("equipmentCtrl",["$scope","equipmentService","$state","$stateParams",function ($scope,equipmentService,$state,$stateParams) {
        var roomId = $stateParams.roomId;
        equipmentService.loadRoom(roomId,function (data) {
            console.log(data)
            $scope.room = data;
        })
        equipmentService.loadEquipment(roomId,function (data) {
            if (data.length == 0){
                $("#nothing").css("display","block");
            }else {
                $("#nothing").css("display","none");
            }
            console.log(data);
            $scope.equipments_ = data;
        })
    }]);

    app.service("equipmentService",["$http",function ($http) {
        this.loadRoom = function (roomId,callback) {
            $http({
                url : "/rooms/"+roomId,
                method : 'GET'
            }).then(function (data) {
                if (callback){
                    callback(data.data);
                }
            })
        }

        this.loadEquipment = function (roomId,callback) {
            $http({
                url : "/equipments/"+roomId,
                method : 'GET'
            }).then(function (data) {
                if (callback){
                    callback(data.data);
                }
            })
        }

    }])
})();