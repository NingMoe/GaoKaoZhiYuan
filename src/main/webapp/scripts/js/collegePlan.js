$(document).ready(function () {
    var planUrl=genurl+"/collegeplan/selectSuitCollegePlan.do";

    //判断是否是对比查询引起的翻页行为
    var flag = false;
    $('#planAll').click(function(){

        //清空查询框
        $("#searchInput").val("");
         url = planUrl;
         currentPage=1;
         collegeName="";
         item={};
        $(".form-group").show();
        $("#compareBtn").hide();
        getData(url,currentPage,collegeName,item);
    });

    //根据数据动态绘制html
    initPlanHtml = function (page){
        $('#table_head').html("<h3 >志愿填报<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">高校代码</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校名称</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校所在地</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">专业代码</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">专业名称</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">选考科目1</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">选考科目2</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">选考科目3</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";

        for (var i = 0;i<= data.length-1;i++) {
            str += "<tr>" +
                "<td>" + ((data[i].collegeId!=null)?data[i].collegeId:"") + "</td>" +
                "<td>" + ((data[i].collegeName!=null)?data[i].collegeName:"")+ "</td>" +
                "<td>" + ((data[i].sf!=null)?data[i].sf:"") + "</td>" +
                "<td>"+((data[i].majorId!=null)?data[i].majorId:"") +"</td>" +
                "<td>" + ((data[i].majorName!=null)?data[i].majorName:"") + "</td>" +
                "<td>" + ((data[i].xkkm1!=null)?data[i].xkkm1:"") + "</td>" +
                "<td>" + ((data[i].xkkm2!=null)?data[i].xkkm2:"") + "</td>" +
                "<td>" + ((data[i].xkkm3!=null)?data[i].xkkm3:"") + "</td>" +
                "</tr>";
        }
        $("tbody").html(str);
        var str2 = "";
        str2="<span>总记录数："+page.rowCount+"个  </span>"+ "<span>总页数："+page.pageCount+"页  </span>"+"<span>当前是第"+currentPage+"页  </span>";
        if(page.currentPage>1)
            str2=str2+ "<a id='previous'>上一页  </a>";
        else str2=str2+ "<span >上一页  </span>";
        if(page.currentPage<page.pageCount)
            str2=str2+ "<a id='next'>下一页  </a>";
        else str2=str2+ "<span >下一页  </span>";
        str2=str2+"<span>跳转到第<input id='pageJump'style=\"width:30px;\">页  </span>";
        $("#pageCount").html(str2);
    }
    //
    $(document).on('change','#rankSelect',function () {
        var type = $(this).val();
        item.type = type;
        collegeName = $("#searchInput").val();
        getData(url,currentPage,collegeName,item);
    })
});





