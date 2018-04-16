$(document).ready(function () {
    var currentPagepath=location.href;
    var pathName = window.document.location.pathname;
    var pos = currentPagepath.indexOf(pathName);
    var localhostPath = currentPagepath.substring(0,pos);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
    genurl = localhostPath+projectName;
});