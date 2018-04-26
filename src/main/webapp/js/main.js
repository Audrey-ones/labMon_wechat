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
                console.log(data.length)
                //当房间没有设备时，显示提示
                if (data.length == 0){
                    $("#nothing").css("display","block");
                }else {
                    $("#nothing").css("display","none");
                }
                var dataHtml = "";
                for (var i=0; i<data.length; i++){
                    dataHtml += '<div class="equipment"><div>'
                        + '<span>设备名称：</span>'
                        + '<span>'+data[i].name+'</span>'
                        + '</div>'
                        + '<div>'
                        + '<span>参数：</span>'
                        + '<span>Ec6培养箱</span>'
                        + '</div></div>';
                }
                $(".equipment_tab").html(dataHtml);

            }
        })
    }

})
