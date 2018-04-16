$(document).ready(function () {
    var collegeUrl=genurl+"/college/selectAllCollege.do";
    var currentPage=1;
    var pageCount;
    $('#collegeAll').click(function(){
            getData(currentPage);
    });

    function getData(pageNum){
        $.ajax({
            url:collegeUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'pageNum':pageNum},//传入后台数据
            dataType:'json',//后台返回数据类型
            success : function(page) {
                $('#table_head').html("<h3>高校信息<h3>");
                $("thead").html("<tr>" +
                    "<th>高校代码</th>" +
                    "<th>高校名称</th>" +
                    "<th>所在地</th>" +
                    "<th>高校详情</th>" +
                    "<th>高校类别</th>" +
                    "</tr>");
                var data = page.row;
                currentPage = page.currentPage;
                pageCount = page.pageCount;
                var str = "";
                for (var i = page.beginIndex;i<= page.endIndex;i++) {
                    str += "<tr>" +
                        "<td>" + ((data[i].id!=null)?data[i].id:"") + "</td>" +
                        "<td>" + ((data[i].name!=null)?data[i].name:"")+ "</td>" +
                        "<td>"+((data[i].sf!=null)?data[i].sf:"") +"</td>" +
                        "<td>" + ((data[i].cc!=null)?data[i].cc:"") + "</td>" +
                        "<td>" + ((data[i].detail!=null)?data[i].detail:"") + "</td>" +
                        "</tr>";
                }
                $("tbody").html(str);
                var str2 = "";
                str2="<span>总记录数："+page.rowCount+"条  </span>"+ "<span>总页数："+page.pageCount+"页  </span>"+"<span>当前是第"+currentPage+"页  </span>";
                if(page.currentPage>1)
                    str2=str2+ "<a id='previous'>上一页  </a>";
                else str2=str2+ "<span >上一页  </span>";
                if(page.currentPage<page.pageCount)
                    str2=str2+ "<a id='next'>下一页  </a>";
                else str2=str2+ "<span >下一页  </span>";
                str2=str2+"<span>跳转到第<input id='pageJump'style=\"width:30px;\">页  </span>";
                $("#pageCount").html(str2);

            },
            error:function(data){
            }
        })
    }

   $(document).on('click','#next',function () {
       currentPage = currentPage+1;
       getData(currentPage);
   })
    $(document).on('click','#previous',function () {
        currentPage = currentPage-1;
        getData(currentPage);
    })
    $(document).on('keydown','#pageJump',function () {
        var pj = $(this).val();
        if(pj<=pageCount){
            getData(pj);
        }

    })
});





