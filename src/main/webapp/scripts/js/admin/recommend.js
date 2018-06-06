$(document).ready(function () {
    var recommendUrl = genurl+"/collegeplan/recommendCollegePlan.do";
    //判断是否是对比查询引起的翻页行为
    var flag = false;
    var array="";
    $('#recommend').click(function(){
        $(".navbar-search.pull-left.input-append").show();
        //清空查询框
        $("#searchInput").val("");
        $("#searchMajorInput").show();
        $("#searchMajorInput").val("");
        $("#recommendBar").show();
        url = recommendUrl;

        currentPage=1;
        collegeName="";

        item={};
        $(".form-group").show();
        $("#pageCount").show();
        $("#compareBtn").hide();
        getData(url,currentPage,collegeName,item);
    });

    //根据数据动态绘制html
    initRecommendHtml = function (page){
        $('#table_head').html("<h3 >志愿推荐<h3>");
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
            "<th style=\"\n" + " text-align:center;\n" + "\""+">录取概率</th>" +
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
            if(data[i].dislocation<=-5000){
                str = str+"<td><button class='licy-btn licy-btn-primary ' disabled='true' style='border-color:#78ba00;background-color: #78ba00' name='" + data[i].zsId + "'>推荐</button></td>" ;
            }
            else if(data[i].dislocation<=5000){
                str = str+"<td><button class='licy-btn licy-btn-primary ' disabled='true' style='border-color:#2192a8;background-color: #2192a8' name='" + data[i].zsId + "'>比较推荐</button></td>" ;
            }
            else if(data[i].dislocation<10000){
                str = str+"<td><button class='licy-btn licy-btn-primary ' disabled='true' style='border-color:#df8505;background-color: #df8505' name='" + data[i].zsId + "'>可以冲</button></td>" ;
            }
            else {
                str = str+"<td><button class='licy-btn licy-btn-primary ' disabled='true' style='border-color:#bd362f;background-color: #bd362f' name='" + data[i].zsId + "'>不推荐</button></td>" ;
            }
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
    $(document).on('click','#recommendBtn',function () {
        var xkkmScore1 = $("#xksubInput1").val();
        var xkkmScore2 = $("#xksubInput2").val();
        var xkkmScore3 = $("#xksubInput3").val();
        item.xkkmScore1 = xkkmScore1;
        item.xkkmScore2 = xkkmScore2;
        item.xkkmScore3 = xkkmScore3;
        var xkkm1 = $("#subSelect1").val();
        var xkkm2 = $("#subSelect2").val();
        var xkkm3 = $("#subSelect3").val();
        item.xkkm1 = xkkm1;
        item.xkkm2 = xkkm2;
        item.xkkm3 = xkkm3;
        var mathScore = $("#subInput1").val();
        var engScore = $("#subInput2").val();
        var cnScore = $("#subInput3").val();
        item.mathScore = mathScore;
        item.engScore = engScore;
        item.cnScore = cnScore;
        collegeName = $("#searchInput").val();
        var prior = $("#priorSelect").val();
        item.prior = prior;
        majorName = $("#searchMajorInput").val();
        item.majorName = majorName;
        getData(url,currentPage,collegeName,item);
    })
});





