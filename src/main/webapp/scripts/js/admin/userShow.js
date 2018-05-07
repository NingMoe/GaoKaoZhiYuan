$(document).ready(function () {

    var userSelectUrl = genurl+"/user/getAllUserInfo.do";
    var addUserUrl = genurl+"/user/addUserInfo.do";
    var deleteUserUrl = genurl+"/user/deleteUserInfo.do";
    var flag = false;
    //根据数据动态绘制html
    initUserInfoHtml = function (page) {
        $('#table_head').html("<h3 >用户信息<h3>");
        $("thead").html("<tr>" +
            "<th style=\"\n" + "width: 150px; text-align: center;\n" + "\">真实姓名</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">住址</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">电话</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\"" + ">性别</th>" +
            "<th style=\"\n" + " text-align:center;\n" + "\""+">操作</th>" +
            "</tr>");
        var data = page.row;
        currentPage = page.currentPage;
        pageCount = page.pageCount;
        var str = "";
        for (var i = 0;i<= data.length-1;i++) {
            str += "<tr>" +
                "<td>" +  ((data[i].realName != null) ? data[i].realName : "")  + "</td>" +
                "<td>" + ((data[i].address != null) ? data[i].address : "") + "</td>" +
                "<td>" + ((data[i].phone != null) ? data[i].phone : "") + "</td>" +
                "<td>" +((data[i].sex != null) ? data[i].sex : "") + "</td>" ;

            str = str+"<td><button  class='deleteUser licy-btn licy-btn-primary'style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].id + "'style='width: 52px'>-删除</button>" +
                "<button class='updateUser licy-btn licy-btn-primary'style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].id + "'>修改</button> </td>" ;
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
    $("#userAll").click(function () {
        url = userSelectUrl;
        addUrl = addUserUrl;
        username = "";
        item={};
        currentPage = 1;
        getData(url,currentPage,username,item);
    })
    $(document).on('click','.deleteUser',function () {
        var id = $(this).attr("name");
        deleteUser(id);
    })
    deleteUser = function (id) {
        $.ajax({
            url:deleteUserUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'id':id},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
                    alert("删除成功");
                    getData(url,currentPage,username,item);

            },
            error:function(data){
            }
        })
    };
    addUser = function (addUrl) {
        $("#addForm").show();
        $(".module").hide();
        str ="  <tr>\n" +
            "     <td>用户名:</td>\n" +
            "     <td><input type=\"text\" name=\"loginName\">\n" +
            "     </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>密码:</td>\n" +
            "      <td><input  type=\"password\" name=\"passwd\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>真实姓名:</td>\n" +
            "      <td><input  type=\"text\" name=\"realName\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>地址:</td>\n" +
            "      <td><input  type=\"text\" name=\"address\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>电话:</td>\n" +
            "      <td><input  type=\"text\" name=\"phone\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>数学成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"mathScore\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>语文成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"chineseScore\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>英语成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"englishScore\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目1名称:" +
            " <select class=\"selectpicker\"  name=\"rankSelect1\"\n" +
            "                                        data-width=\"100%\" style=\"width:  100px;margin-right:  50px\">\n" +
            "                                    <optgroup label=\"类别\">\n" +
            "                                        <option>物理</option>\n" +
            "                                        <option>化学</option>\n" +
            "                                        <option>生物</option>\n" +
            "                                        <option>技术</option>\n" +
            "                                        <option>政治</option>\n" +
            "                                        <option>历史</option>\n" +
            "                                        <option>地理</option>\n" +
            "                                    </optgroup>\n" +
            "                                </select></td>"+
            "      <td>选考科目1成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkmScore1\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目2名称:" +
            " <select class=\"selectpicker\"  name=\"rankSelect2\"\n" +
            "                                        data-width=\"100%\" style=\"width:  100px;margin-right:  50px\">\n" +
            "                                    <optgroup label=\"类别\">\n" +
            "                                        <option>物理</option>\n" +
            "                                        <option>化学</option>\n" +
            "                                        <option>生物</option>\n" +
            "                                        <option>技术</option>\n" +
            "                                        <option>政治</option>\n" +
            "                                        <option>历史</option>\n" +
            "                                        <option>地理</option>\n" +
            "                                    </optgroup>\n" +
            "                                </select></td>"+
            "      <td>选考科目2成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkmScore2\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td>选考科目3名称:" +
            " <select class=\"selectpicker\"  name=\"rankSelect3\"\n" +
            "                                        data-width=\"100%\" style=\"width:  100px;margin-right:  50px\">\n" +
            "                                    <optgroup label=\"类别\">\n" +
            "                                        <option>物理</option>\n" +
            "                                        <option>化学</option>\n" +
            "                                        <option>生物</option>\n" +
            "                                        <option>技术</option>\n" +
            "                                        <option>政治</option>\n" +
            "                                        <option>历史</option>\n" +
            "                                        <option>地理</option>\n" +
            "                                    </optgroup>\n" +
            "                                </select></td>"+
            "      <td>选考科目3成绩:</td>\n" +
            "      <td><input  type=\"text\" name=\"xkkmScore3\"/>\n" +
            "      </td>\n" +
            "   </tr>\n" +
            "   <tr>\n" +
            "      <td colspan=\"2\">\n" +
            "      <input type='button'  onclick=\"addAjax()\" value=\"添加用户\"/>\n" +
            "      </td>\n" +
            "\n" +
            "   </tr>";
        $("#addTable").html(str);
    }
    addAjax = function () {
        var param = $("#addForm").serializeArray();
        $.ajax({
            url:addUrl,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'data':JSON.stringify(param)},//传入后台数据
            dataType:'text',//后台返回数据类型
            success : function(data) {
               alert("添加成功");
               $("#addForm").hide();
                $(".module").show();
                getData(url,currentPage,username,item);

            },
            error:function(data){
            }
        })
    }
});
