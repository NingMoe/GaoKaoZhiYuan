$(document).ready(function () {
    $('#collegeAll').click(function(){
        var collegeUrl=genurl+"/college/selectAllCollege.do";
        $.ajax({
            url:collegeUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{},//传入后台数据
            dataType:'json',//后台返回数据类型
            success : function(data) {
              $('#table_head').html("<h3>高校信息<h3>");
                $("thead").html("<tr>" +
                    "<th>高校代码</th>" +
                    "<th>高校名称</th>" +
                    "<th>所在地</th>" +
                    "<th>高校详情</th>" +
                    "<th>高校类别</th>" +
                    "</tr>");
                var str = "";
                for (var i = 0;i< data.length;i++) {
                    str += "<tr>" +
                        "<td>" + (data[i].id!=null)?data[i].id:"" + "</td>" +
                        "<td>" + (data[i].name!=null)?data[i].id:"" + "</td>" +
                        "<td>"+(data[i].sf!=null)?data[i].sf:""+"</td>" +
                        "<td>" + (data[i].cc!=null)?data[i].cc:"" + "</td>" +
                        "<td>" + (data[i].detail!=null)?data[i].detail:"" + "</td>" +
                        "</tr>";
                }
                $("tbody").html(str);
                if($('.datatable-1').length>0) {
                    $('.datatable-1').dataTable();
                }
            },
            error:function(data){
            }
        })
    });
});





