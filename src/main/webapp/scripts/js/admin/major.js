$(document).ready(function () {
    var majorUrl = genurl + "/major/selectAllMajor.do";
    var addMajorUrl = genurl+"/major/addMajorInfo.do";
    var deleteMajorUrl = genurl+"/major/deleteMajorInfo.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    $('#majorAll').click(function () {
        $(".navbar-search.pull-left.input-append").show();
        $("#searchMajorInput").hide();
        $("#searchInput").val("");
        url = majorUrl;
        addUrl = addMajorUrl;
        majorName = "";
        item={};
        currentPage = 1;
        $("#pageCount").show();
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
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">操作</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";

        for (var i = 0; i <= data.length - 1; i++) {
            str += "<tr>" +
                "<td>" + ((data[i].id != null) ? data[i].id : "") + "</td>" +
                "<td>" + ((data[i].name != null) ? data[i].name : "") + "</td>" ;
            str = str+"<td><button  class='deleteMajor licy-btn licy-btn-primary'style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].id + "'style='width: 52px'>-删除</button>" +
                "<button class='updateMajor licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].id + "'>修改</button> </td>" ;
            str =  str+ "</tr>";
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

    $(document).on('click','.deleteMajor',function () {
        var id = $(this).attr("name");
        deleteMajor(id);
    })
    deleteMajor = function (id) {
        $.ajax({
            url:deleteMajorUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'id':id},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
                alert("删除成功");
                getData(url,currentPage,majorName,item);

            },
            error:function(data){
            }
        })
    };
    addMajor = function (addUrl) {
        $("#addForm").show();
        $(".module").hide();
        str ="  <tr>\n" +
            "     <td>专业代码:</td>\n" +
            "     <td><input type=\"text\" name=\"id\">\n" +
            "     </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>专业名称:</td>\n" +
            "      <td><input  type=\"text\" name=\"name\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "      <td colspan=\"2\">\n" +
            "      <input type='button'  onclick=\"addAjax()\" value=\"添加专业信息\"/>\n" +
            "      </td>\n" +
            "\n" +
            "   </tr>";
        $("#addTable").html(str);
    }
});
   