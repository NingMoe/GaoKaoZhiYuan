$(document).ready(function () {

    var userSelectUrl = genurl+"/user/getUserInfo.do";
    getUserInfoData = function (url){
        $.ajax({
            url:url,//请求地址
            async: false,
            type:'post',//请求类型
            data:{},//传入后台数据
            dataType:'json',//后台返回数据类型
            success : function(data) {
                $("tbody").html("");
                initUserInfoHtml(data);
            },
            error:function(data){
            }
        })
    }
    //根据数据动态绘制html
    initUserInfoHtml = function (data) {
        $('#table_head').html("<h3 >用户个人信息<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">真实姓名</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">住址</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">电话</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">性别</th>" +
            "</tr>");

        var str = "";

            str += "<tr>" +
                "<td>"+data.realName+"</td>" +
                "<td>"+data.address+"</td>" +
                "<td>"+data.phone+"</td>" +
                "<td>"+data.sex+"</td>" +
                "</tr>";

        $("tbody").html(str);

        $("#pageCount").hide();
    }
    getUserInfoData(userSelectUrl);
});
