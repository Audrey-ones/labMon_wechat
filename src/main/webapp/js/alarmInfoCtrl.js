(function () {
    'use strict';
    var app = angular.module('labApp');
    app.controller("alarmInfoCtrl",["$scope","alarmInfoService","$state",function ($scope,alarmInfoService,$state) {
        alarmInfoService.loadAlarmInfo(function (data) {
            if (data.length != 0){
                $(".alarmTip").css("display","block");
                $(".alarmTable").css("display","block");
                $("#nothing").css("display","none");
                $scope.alarmInfoList = data;
            }else {
                $("#nothing").css("display","block");
                $(".alarmTip").css("display","none");
                $(".alarmTable").css("display","none");
            }

        })
        $scope.reloadPage = function () {
            $state.reload();
        }

        $scope.setStyle = function (type) {
            if (type == 1){
                return "type1";
            }
            if (type == 2){
                return "type2";
            }
            if (type == 3){
                return "type3";
            }
            if (type == 4){
                return "type4";
            }
        }
    }]);

    app.service("alarmInfoService",["$http",function ($http) {
        this.loadAlarmInfo = function (callback) {
            $http({
                url : "/alarmInfos",
                method : "GET"
            }).then(function (data) {
                if (callback){
                    callback(data.data);
                }
            })
        }
    }])

})();