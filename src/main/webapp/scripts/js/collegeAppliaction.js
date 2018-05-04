$(document).ready(function () {
    var selectAppUrl=genurl+"/application/getApplicationAllByUid.do";
    var updateAppRankUrl=genurl+"/application/updateApplicationRank.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    $('#applicationAll').click(function(){
        url = selectAppUrl;
        currentPage=1;
        collegeName="";
        item={};
        $(".form-group").show();
        $("#pageCount").show();
        $("#compareBtn").hide();
        $(".navbar-search.pull-left.input-append").hide();

        getData(url,currentPage,collegeName,item);
    });

    //根据数据动态绘制html
    initAppHtml = function (page){
        $("#pageCount").show();
        $('#table_head').html("<h3 >查看志愿<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">序号</th>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">高校代码</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校名称</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校所在地</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">专业代码</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">专业名称</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">操作</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";

        for (var i = 0;i<= data.length-1;i++) {
            str += "<tr>" +
                "<td>" + (i+1) + "</td>" +
                "<td>" + ((data[i].collegeId!=null)?data[i].collegeId:"") + "</td>" +
                "<td>" + ((data[i].collegeName!=null)?data[i].collegeName:"")+ "</td>" +
                "<td>" + ((data[i].sf!=null)?data[i].sf:"") + "</td>" +
                "<td>"+((data[i].majorId!=null)?data[i].majorId:"") +"</td>" +
                "<td>" + ((data[i].majorName!=null)?data[i].majorName:"") + "</td>" ;
           str = str+"<td><button  class='deleteApplication licy-btn licy-btn-primary'style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].zsid + "'style='width: 52px'>-删除志愿</button>" +
               "<button class='moveup licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].zsid + "'>上移</button> " +
               "<button class='movedown licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].zsid + "'>下移</button></td>" ;
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
    //添加志愿
    $(document).on('click','.deleteApplication',function () {
        var id = $(this).attr("name");
        var obj = $(this);
        if(confirm("是否删除该志愿?")){
            deleteApplication(id,obj);
            alert("删除成功");
        }
    })
    updateApplication = function(id,code){
        $.ajax({
            url:updateAppRankUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'zsid':id,'code':code},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
                if(data=="success"){
                   getData(url,currentPage,collegeName,item);
                }
                else alert("上/下移动失败，该志愿是第一志愿或最后志愿")
            },
            error:function(data){
            }
        })
    };
    $(document).on('click','.moveup',function () {
        var id = $(this).attr("name");
        var code = "moveup";
        var obj = $(this);
        if(confirm("是否上移该志愿?")){
            updateApplication(id,code);
            alert("上移成功");
        }
    })
    $(document).on('click','.movedown',function () {
        var id = $(this).attr("name");
        var code = "movedown";
        var obj = $(this);
        if(confirm("是否下移该志愿?")){
            updateApplication(id,code);
            alert("下移成功");
        }
    })
});





