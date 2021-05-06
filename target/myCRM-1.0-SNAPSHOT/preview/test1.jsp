<!--

@author DaiZheng
@email 543717592@qq.c


上午 10:11
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>
        $(function () {
            // $("#msg").html(123);
            $("#djbtn").click(function () {
                $.ajax({
                    url: "some1.do",//后台servlet地址
                    /*  data:{//为后台传递·的参数
                          "key1":"value1",
                          "key2":"value2"
                      },*/
                    type: "get",
                    dataType: "text",
                    async: true,//异步执行ajax请求【单独一个线程执行ajax】
                    success: function (data) {//
                        $("#msg").html(data);
                    }
                })
              alert(123455555);
            })
        })
    </script>
</head>
<body>
<button id="djbtn">点击</button>
<br>
<div id="msg" style="width: 200px;height: 200px;background-color: pink">

</div>
<br>
<div id="msg1" style="width: 200px;height: 200px;background-color: pink">
    abcdef
</div>

</body>
</html>
