$(document).ready(function () {
    var websocket = null;

    var uid = $("#userInfoId").text();
    $("#talkOnline").click(function () {
        $(".module").hide();
        $("#talkdiv").show();

        //判断当前浏览器是否支持WebSocket
        if ('WebSocket' in window) {
            //如果已经有连接，不允许新建连接
            if(websocket==null)
            websocket = new WebSocket("ws://localhost:8080/gaokao/websocket");
            //如果一条连接关闭，再次点击允许重开一条
            if(websocket.readyState==3)
                websocket = new WebSocket("ws://localhost:8080/gaokao/websocket");
        }
        else {
            alert('当前浏览器 Not support websocket')
        }

        //连接发生错误的回调方法
        websocket.onerror = function () {
            //setMessageInnerHTML("WebSocket连接发生错误");
        };

        //连接成功建立的回调方法
        websocket.onopen = function () {
          //  setMessageInnerHTML("WebSocket连接成功");
        }

        //接收到消息的回调方法
        websocket.onmessage = function (event) {

            var str = event.data;
            var obj = JSON.parse(str);
            var s = "";
            //发消息的左显示,接收方右显示
            if(obj.uid==uid) {
                s=s+ "<div><span style='clear: both;float: left'>"+"id:"+obj.uid+" say:"+"</span>";
                s = s + "<button class='licy-btn licy-btn-primary ' disabled='true'style='clear: both;float: left;word-break: break-all'>"+obj.message+"</button>";
            }
            else{
                s=s+ "<div><span style='clear: both;float: right'>"+"id:"+obj.uid+" say:"+"</span>";
                s=s+"<button class='licy-btn licy-btn-primary ' disabled='true' style='clear: both;float: right;word-break: break-all'>"+obj.message+"</button>";
            }
            s=s+"</div>";
            setMessageInnerHTML(s);
        }

        //连接关闭的回调方法
        websocket.onclose = function () {
            //setMessageInnerHTML("WebSocket连接关闭");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        }

        //将消息显示在网页上
        function setMessageInnerHTML(innerHTML) {
            if(innerHTML)
            document.getElementById('message').innerHTML += innerHTML+"<br>" ;
        }




    });
    //关闭WebSocket连接
    closeWebSocket = function () {
        websocket.close();
    }


    //发送消息
    send = function () {
        var message = document.getElementById('text').value;
        var messageObj = {'uid':uid,'message':message};
        var messageJson = JSON.stringify(messageObj);
        websocket.send(messageJson);
    }

});
