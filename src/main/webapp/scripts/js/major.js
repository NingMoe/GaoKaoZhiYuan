$(document).ready(function () {
    var majorUrl = genurl + "/major/selectAllMajor.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    $('#majorAll').click(function () {

        $("#searchInput").val("");
        url = majorUrl;
        majorName = "";
        item={};
        currentPage = 1;
        $("#compareBtn").hide();
        $(".form-group").hide();
        getData(url,currentPage, majorName, item);
    });


    //根据数据动态绘制html
    initMajorHtml = function (page) {
        $('#table_head').html("<h3 >专业分类信息<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">专业</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">名称</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";

        for (var i = 0; i <= data.length - 1; i++) {
            str += "<tr>" +
                "<td>" + ((data[i].id != null) ? data[i].id : "") + "</td>" +
                "<td>" + ((data[i].name != null) ? data[i].name : "") + "</td>" +
                "</tr>";
        }
        $("tbody").html(str);
        var str2 = "";
        str2 = "<span>总记录数：" + page.rowCount + "个  </span>" + "<span>总页数：" + page.pageCount + "页  </span>" + "<span>当前是第" + currentPage + "页  </span>";
        if (page.currentPage > 1)
            str2 = str2 + "<a id='previous'>上一页  </a>";
        else str2 = str2 + "<span >上一页  </span>";
        if (page.currentPage < page.pageCount)
            str2 = str2 + "<a id='next'>下一页  </a>";
        else str2 = str2 + "<span >下一页  </span>";
        str2 = str2 + "<span>跳转到第<input id='pageJump'style=\"width:30px;\">页  </span>";
        $("#pageCount").html(str2);
    }
});
   