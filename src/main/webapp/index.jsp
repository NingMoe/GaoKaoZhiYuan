<html>
<body>
<script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
<script>
    var currentPagepath=location.href;
    var pathName = window.document.location.pathname;
    var pos = currentPagepath.indexOf(pathName);
    var localhostPath = currentPagepath.substring(0,pos);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
    genurl = localhostPath+projectName;
    window.location.href=genurl+"/login/index.do";
</script>
</body>
</html>
