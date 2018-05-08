$(document).ready(function () {
    var planUrl=genurl+"/collegeplan/selectAllPlan.do";
    var addPlanUrl = genurl+"/collegeplan/addPlanInfo.do";
    var deletePlanUrl = genurl+"/collegeplan/deletePlan.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    var array="";
    $('#planAll').click(function(){
        $(".navbar-search.pull-left.input-append").show();
        //清空查询框
        $("#searchInput").val("");
        $("#searchMajorInput").show();
        $("#searchMajorInput").val("");
         url = planUrl;
        addUrl = addPlanUrl;
         currentPage=1;
         collegeName="";

         item={};
        $(".form-group").show();
        $("#pageCount").show();
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
            "<th style=\"\n" + " text-align:center;\n" + "\""+">计划招生人数</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">分数线</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">位次</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">操作</th>" +
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
                "<td class='majorTd'>" + ((data[i].majorName!=null)?data[i].majorName:"") + "</td>" +
                "<td>" + ((data[i].xkkm1!=null)?data[i].xkkm1:"") + "</td>" +
                "<td>" + ((data[i].xkkm2!=null)?data[i].xkkm2:"") + "</td>" +
                "<td>" + ((data[i].xkkm3!=null)?data[i].xkkm3:"") + "</td>"+
                "<td>" + ((data[i].jhzsrs!=null)?data[i].jhzsrs:"") + "</td>" +
                "<td>" + ((data[i].scoreLine!=null)?data[i].scoreLine:"") + "</td>" +
                "<td>" + ((data[i].num!=null)?data[i].num:"") + "</td>" ;
            str = str+"<td><button  class='deletePlan licy-btn licy-btn-primary'style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].zsId + "'style='width: 52px'>-删除</button>" +
                "<button class='updatePlan licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].zsId + "'>修改</button> </td>" ;
            str = str + "</tr>";
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
        var prior = $("#priorSelect").val();
        item.prior = prior;
        majorName = $("#searchMajorInput").val();
        item.majorName = majorName;
        getData(url,currentPage,collegeName,item);
    })
    $(document).on('change','#priorSelect',function () {
        var type = $("#rankSelect").val();
        item.type = type;
        collegeName = $("#searchInput").val();
        var prior = $(this).val();
        item.prior = prior;
        majorName = $("#searchMajorInput").val();
        item.majorName = majorName;
        getData(url,currentPage,collegeName,item);
    })
    addPlan = function (addUrl) {
        $("#addForm").show();
        $(".module").hide();
        str ="  <tr>\n" +
            "     <td>招生代码:</td>\n" +
            "     <td><input type=\"text\" name=\"zsId\">\n" +
            "     </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>高校代码:</td>\n" +
            "      <td><input  type=\"text\" name=\"collegeId\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>专业代码:</td>\n" +
            "      <td><input  type=\"text\" name=\"majorId\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>专业名称:</td>\n" +
            "      <td><input  type=\"text\" name=\"majorName\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目1:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkm1\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目2:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkm2\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目3:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkm3\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>分数线:</td>\n" +
            "      <td><input  type=\"text\" name=\"scoreLine\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>位次:</td>\n" +
            "      <td><input  type=\"text\" name=\"num\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>计划招生人数:</td>\n" +
            "      <td><input  type=\"text\" name=\"jhzsrs\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td colspan=\"2\">\n" +
            "      <input type='button'  onclick=\"addAjax()\" value=\"添加招生计划信息\"/>\n" +
            "      </td>\n" +
            "\n" +
            "   </tr>";
        $("#addTable").html(str);
    }
    $(document).on('click','.deletePlan',function () {
        var id = $(this).attr("name");
        deletePlan(id);
    })
    deletePlan = function (id) {
        $.ajax({
            url:deletePlanUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'id':id},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
                alert("删除成功");
                getData(url,currentPage,collegeName,item);

            },
            error:function(data){
            }
        })
    };
});





