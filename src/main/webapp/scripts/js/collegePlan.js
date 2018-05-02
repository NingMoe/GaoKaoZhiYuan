$(document).ready(function () {
    var planUrl=genurl+"/collegeplan/selectSuitCollegePlan.do";
    var addAppUrl = genurl+"/application/addApplication.do"
    var deleteAppUrl = genurl+"/application/deleteApplication.do"
    var getAppByUidUrl = genurl+"/application/getApplicatonByUid.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    var array="";
    $('#planAll').click(function(){
        $(".navbar-search.pull-left.input-append").show();
        //清空查询框
        $("#searchInput").val("");
         url = planUrl;
         currentPage=1;
         collegeName="";

         item={};
        $(".form-group").show();
        $("#pageCount").show();
        $("#compareBtn").hide();
        hasApplication();
        getData(url,currentPage,collegeName,item);
    });

    //根据数据动态绘制html
    initPlanHtml = function (page){
        $("#pageCount").show();
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
                "<td>" + ((data[i].majorName!=null)?data[i].majorName:"") + "</td>" +
                "<td>" + ((data[i].xkkm1!=null)?data[i].xkkm1:"") + "</td>" +
                "<td>" + ((data[i].xkkm2!=null)?data[i].xkkm2:"") + "</td>" +
                "<td>" + ((data[i].xkkm3!=null)?data[i].xkkm3:"") + "</td>" ;
             if(!compareArray(data[i].zsId)) {
                 str = str+"<td><button  class='addApplication' name='" + data[i].zsId + "'>+添加志愿</button></td>" ;
             }
             else str = str+"<td><button  class='addApplication' name='" + data[i].zsId + "'>-删除志愿</button></td>" ;
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
        getData(url,currentPage,collegeName,item);
    })

    addApplication = function (id,obj) {
        $.ajax({
            url:addAppUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'zsid':id},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
                if(data=="success"){
                    obj.html("-删除志愿");
                }
            },
            error:function(data){
            }
        })
    };
    compareArray = function(zsid){
        var compareArray = {};
        if(array!="") {
            if (array.substring(array.length - 1, array.length) == ",") {
                array.substring(0, array.length - 1);
            }
             compareArray = array.split(",");
            zsid = ""+zsid+"";
               if(compareArray.indexOf(zsid)>=0){
                   return true;
               }
        }
        return false;
    };
    hasApplication = function () {
        $.ajax({
            url:getAppByUidUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(appStr) {
                array = appStr;
            },
            error:function(data){
            }
        })
    };

    deleteApplication = function (id,obj) {
        $.ajax({
            url:deleteAppUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'zsid':id},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
              if(data=="success"){
                  obj.html("+添加志愿");
              }
            },
            error:function(data){
            }
        })
    };
    //添加志愿
    $(document).on('click','.addApplication',function () {
        var id = $(this).attr("name");
        var val = $(this).text();
        var obj = $(this);
        if(val=="+添加志愿") {
            array = array + id + ",";
            addApplication(id,obj);
            alert("添加成功");

        }
        else if(confirm("是否删除该志愿?")){
            array = array.replace(id+",","");
            deleteApplication(id,obj);
            alert("删除成功");
            }
    })
});





