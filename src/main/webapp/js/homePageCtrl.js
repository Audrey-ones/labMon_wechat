(function () {
    'use strict';
    var app = angular.module('labApp');
    app.controller("homePageCtrl",["$scope","homePageService",function ($scope,homePageService) {

        //获取所有的房间，并添加在select中
        $.get("/rooms",function (data) {
            console.log(data)
            var dataHtml = "";
            for (var i=0; i<data.length; i++){
                if (i == 0){
                    dataHtml += '<option value="'+data[i].roomId+'">'+data[i].name+'</option>';
                    getEquipments(data[i].roomId);

                }else {
                    dataHtml += '<option value="'+data[i].roomId+'">'+data[i].name+'</option>';
                }

            }
            $("#select_room").html(dataHtml);
        });

        //当select改变时，获取select的值并发送一次请求
        $("#select_room").change(function () {
            console.log($("#select_room option:checked").text())
            getEquipments($(this).val())
        })

        function getEquipments(roomId) {
            homePageService.loadEquipment(roomId,function (data) {
                if (data.length == 0){
                    $("#nothing").css("display","block");
                }else {
                    $("#nothing").css("display","none");
                }
                $scope.equipments = data;
                console.log($scope.equipments)
            })
        }


    }]);

    app.service("homePageService",["$http",function ($http) {
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
    }]);

})();
