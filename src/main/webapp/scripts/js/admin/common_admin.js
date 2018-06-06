$(document).ready(function () {
    var currentPagepath=location.href;
    var pathName = window.document.location.pathname;
    var pos = currentPagepath.indexOf(pathName);
    var localhostPath = currentPagepath.substring(0,pos);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
    genurl = localhostPath+projectName;
    var url;
    var currentPage;
    var pageCount;
    var collegeName;
    var item;
    getData = function (url,pageNum,name,item){
        $.ajax({
            url:url,//请求地址
            async: false,
            type:'post',//请求类型
            data:{'pageNum':pageNum,'name':name,'data':JSON.stringify(item)},//传入后台数据
            dataType:'json',//后台返回数据类型
            success : function(page) {
                $("tbody").html("");
                $("#pageCount").html("");
                if(url.indexOf("Plan")>0)
                    initPlanHtml(page);
                if(url.indexOf("selectAllCollege")>0)
                    initCollegeHtml(page);
                if(url.indexOf("selectAllMajor")>0)
                    initMajorHtml(page);
                if(url.indexOf("application")>0)
                    initAppHtml(page);
                if(url.indexOf("getAllUserInfo")>0)
                    initUserInfoHtml(page);
                if(url.indexOf("recommend")>0)
                    initRecommendHtml(page);
            },
            error:function(data){
            }
        })
    }

    $(document).on('click','#addBtn',function () {
        if(addUrl.indexOf("user")>0)
            addUser(addUrl);
        if(addUrl.indexOf("college")>0)
            addCollege(addUrl);
        if(addUrl.indexOf("major")>0)
            addMajor(addUrl);
        if(addUrl.indexOf("plan")>0)
            addPlan(addUrl);
    })


});