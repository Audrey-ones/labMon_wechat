layui.config({
	base : "js/"
}).use(['form','element','layer','laypage','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element(),
        laypage = layui.laypage,
		$ = layui.jquery;

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

	//返回顶部
    returnTop();

	//当select改变时，获取select的值并发送一次请求
	$("#select_room").change(function () {
	    console.log($("#select_room option:checked").text())
        getEquipments($(this).val())
    })

    //根据房间ID获取该房间的设备--请求
    function getEquipments(roomId) {
        $.ajax({
            url : "/equipments/"+roomId,
            type : "get",
            dataType : "json",
            success : function (data) {
                console.log(data)
                //当房间没有设备时，显示提示
                if (data.length == 0){
                    $("#nothing").css("display","block");
                }else {
                    $("#nothing").css("display","none");
                }
                var dataHtml = "";
                for (var i=0; i<data.length; i++){
                    dataHtml += '<div class="equipment"><div>'
                        + '<span class="label_name">设备名称：</span>'
                        + '<span>'+data[i].equipmentName+'</span>'
                        + '</div>'
                        + '<div style="margin-top: 7px">'
                        + '<span class="label_name">参数：</span>'
                        + '<span>'+data[i].parameter+'</span>'
                        + '</div>'
                        + '<div style="margin-top: 7px">'
                        + '<span class="label_name">采集时间：</span>'
                        + '<span>'+data[i].dataTime+'</span>'
                        + '</div></div>';
                }
                $(".equipment_tab").html(dataHtml);

            }
        })
    }

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
                $('body,html').animate({scrollTop:0},100);
                return false;
            });
        });
    }



})
