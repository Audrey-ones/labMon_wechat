/**
 * Created by LuDan on 2018/5/10
 */
(function () {
    'use strict';
    angular.module('labApp',["ui.router"]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider',
        function ($stateProvider, $urlRouterProvider, $httpProvider) {
            $urlRouterProvider.otherwise('/homePage');
            $stateProvider
                .state('homePage',{
                    url: '/homePage',
                    templateUrl: 'page/homePage.html',
                    controller: "homePageCtrl"
                })
                .state('room',{
                    url : '/room',
                    templateUrl : 'page/room.html',
                    controller : "roomCtrl"
                })
                .state('equipment',{
                    url : '/equipment:roomId',
                    templateUrl : 'page/equipment.html',
                    controller : "equipmentCtrl"
                })

        }]);
})();

(function () {
    returnTop();
    //返回顶部方法
    function returnTop() {
        $("#go_top").hide();
        $(function () {
            //检测屏幕高度
            var height=$(window).height();
            //scroll() 方法为滚动事件
            $(window).scroll(function(){
                if ($(window).scrollTop()>height){
                    $("#go_top").fadeIn(500);
                }else{
                    $("#go_top").fadeOut(500);
                }
            });
            $("#go_top").click(function(){
                $('body,html').animate({scrollTop:0},500);
                return false;
            });
        });
    }
})();



