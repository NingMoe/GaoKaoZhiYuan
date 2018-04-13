$(document).ready(function () {
var currentPagepath=location.href;
 var pathName = window.document.location.pathname;
 var pos = currentPagepath.indexOf(pathName);
 var localhostPath = currentPagepath.substring(0,pos);
 var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
 genurl = localhostPath+projectName;
var flag1 = false;
  $('#loginName').blur(function(){
                var a=$(this).val();
                var changUrl=genurl+"/register/check.do";
                $.ajax({
                          url:changUrl,//请求地址
                          async: false,
                          type:'post',//请求类型
                          data:{loginName:a},//传入后台数据
                          dataType:'text',//后台返回数据类型
                          success : function(data) {
                          if(data=='hasRegister'){
                          flag1 = false;
                　　　　　　　　　$("#userspan").html("<font color='red'>用户名已被注册</font>");
                                }
                          else {
                          $("#userspan").html("<font color='green'>用户名未被注册</font>");
                          flag1 = true;
                          }
                 　　　　　 },
                          error:function(data){
                          }
                　　　　})
            });

 $("#registerButton").click(function() {
               if (flag1) {
           $("#registerForm").submit();
            }
         return false;
        })
});





