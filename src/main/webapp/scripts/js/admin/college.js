$(document).ready(function () {
    var collegeUrl=genurl+"/college/selectAllCollege.do";
    var addCollegeUrl = genurl+"/college/addCollegeInfo.do";
    var deleteCollegeUrl = genurl+"/college/deleteCollegeInfo.do";
//判断是否是对比查询引起的翻页行为
    var flag = false;
    var temp = {};
    $('#collegeAll').click(function(){
        $("#searchMajorInput").hide();
        $("#talkdiv").hide();
        $(".module").show();
        $(".navbar-search.pull-left.input-append").show();
        $("#pageCount").show();
        var array = "";
        $("#searchInput").val("");
         url = collegeUrl;
        addUrl = addCollegeUrl;
         currentPage=1;
         collegeName="";
         item={};
         $(".form-group").hide();
        $("#compareBtn").show();
        getData(url,currentPage,collegeName,item);
    });

    //根据数据动态绘制html
    initCollegeHtml = function (page){
        $('#table_head').html("<h3 >高校信息<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">高校代码</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校名称</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">所在地</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">高校详情</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">操作</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";

        for (var i = 0;i<= data.length-1;i++) {
            str += "<tr>" +
                "<td>" + ((data[i].id!=null)?data[i].id:"") + "</td>" +
                "<td>" + ((data[i].name!=null)?data[i].name:"")+ "</td>" +
                "<td>"+((data[i].sf!=null)?data[i].sf:"") +"</td>" +
                "<td>" + ((data[i].detail!=null)?data[i].detail:"") + "</td>" ;
            str = str+"<td><button  class='deleteCollege licy-btn licy-btn-primary'style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].id + "'style='width: 52px'>-删除</button>" +
                "<button class='updateCollege licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].id + "'>修改</button> </td>" ;
            str =  str+ "</tr>";
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

    $(document).on('click','.deleteCollege',function () {
        var id = $(this).attr("name");
        deleteCollege(id);
    })
    deleteCollege = function (id) {
        $.ajax({
            url:deleteCollegeUrl,//请求地址
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
    addCollege = function (addUrl) {
        $("#addForm").show();
        $(".module").hide();
        str ="  <tr>\n" +
            "     <td>高校代码:</td>\n" +
            "     <td><input type=\"text\" name=\"id\">\n" +
            "     </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>高校名称:</td>\n" +
            "      <td><input  type=\"text\" name=\"name\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>所在地:</td>\n" +
            "      <td><input  type=\"text\" name=\"sf\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>高校详情:</td>\n" +
            "      <td><input  type=\"text\" name=\"detail\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td colspan=\"2\">\n" +
            "      <input type='button'  onclick=\"addAjax()\" value=\"添加院校信息\"/>\n" +
            "      </td>\n" +
            "\n" +
            "   </tr>";
        $("#addTable").html(str);
    }

    //添加对比
    $(document).on('click','.compare',function () {
        var id = $(this).attr("name");
        var index = array.indexOf(id);
        if(index<0) {
            array = array + id + ",";
            item.ids = array;
            $(this).html("-已加入对比");
            alert("选择对比成功");
        }
        else {
            if(confirm("该院校已选入对比序列,是否取消该院校对比?")){
                array = array.replace(id+",","");
                item.ids = array;
                $(this).html("+加入对比");
            }
        }
    })
    //下一页
    $(document).on('click','#next',function () {
        var sInput = $("#searchInput").val();
        currentPage = currentPage+1;

            getData(url,currentPage,sInput,item);

    })
    //对比按钮
    $(document).on('click','#compareBtn',function () {
        if(array!=""){
            getData(url,1,"",item);
            flag=true;
        }
        else alert("没有选择对比");
    })
    //首页按钮
    $(document).on('click','#homeBtn',function () {
        flag = false;
        $("#searchInput").val("");
        $("#searchMajorInput").val("");
        $("#rankSelect").val("排名");
        $("#priorSelect").val("专业优先");
        getData(url,1,"",temp);

    })
    //上一页
    $(document).on('click','#previous',function () {
        var sInput = $("#searchInput").val();
        currentPage = currentPage-1;
            getData(url,currentPage,sInput,item);

    })
    //跳转页面
    $(document).bind('keydown','#pageJump',function (event) {
        var sInput = $("#searchInput").val();
        if(event.keyCode=="13"){
            var pj = $("#pageJump").val();
            if(pj<=pageCount&&pj!=""){
                    getData(url,pj,sInput,item);

            }
        }
    })
    //高校名异步模糊查询
    $(document).on('keyup','#searchInput',function () {
        flag = false;
        var sInput = $("#searchInput").val();
        if(sInput!=""){
            //第一次异步like请求
            getData(url,1,sInput,item);
        }

    })
    //专业名异步模糊查询
    $(document).on('keyup','#searchMajorInput',function () {
        flag = false;
        var majorName = $("#searchMajorInput").val();
        item.majorName = majorName;
        var sInput = $("#searchInput").val();
        if(majorName!=""){
            //第一次异步like请求
            getData(url,1,sInput,item);
        }

    })
    //监听退格键，如果输入框删完，应显示初始页面
    $(document).bind('keyup','#searchInput',function (event) {
        flag = false;
        var sInput = $("#searchInput").val();
        if(event.keyCode==8){
            sInput = $("#searchInput").val();
            if(sInput==""){
                getData(url,1,sInput,item);
            }
        }

    })
});





