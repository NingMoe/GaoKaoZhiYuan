$(document).ready(function () {
    $('#majorAll').click(function(){
        var majorUrl=genurl+"/major/selectAllMajor.do";
        $.ajax({
            url:majorUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{},//传入后台数据
            dataType:'json',//后台返回数据类型
            success : function(data) {
                $('#table_head').html("<h3>专业信息<h3>");
                $("thead").html("<tr>" +
                    "<th>专业</th>" +
                    "<th>专业名称</th>" +
                    "</tr>");
                var str = "";
                for (var i = 0;i< data.length;i++) {
                    str += "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].name + "</td>" +
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





