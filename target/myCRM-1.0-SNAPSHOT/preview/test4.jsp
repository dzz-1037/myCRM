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
                    url: "some3.do",//后台servlet地址
                    /*  data:{//为后台传递的参数
                          "key1":"value1",
                          "key2":"value2"
                      },*/
                    type: "get",
                    dataType: "json",
                    async: true,//异步执行ajax请求【单独一个线程执行ajax】
                    success: function (data) {//
                        $("#id1").html(data[0].id);
                        $("#name1").html(data[0].name);
                        $("#age1").html(data[0].age);

                        $("#id2").html(data[1].id);
                        $("#name2").html(data[1].name);
                        $("#age2").html(data[1].age);
                    }
                })
            })
        })
    </script>
</head>
<body>
<button id="djbtn">点击</button>
<br>
学员1：<br>
编号：<span id="id1"> </span><br>
姓名：<span id="name1"> </span><br>
年龄：<span id="age1"> </span><br>
<hr>
<br>
学员2：<br>
编号：<span id="id2"> </span><br>
姓名：<span id="name2"> </span><br>
年龄：<span id="age2"> </span><br>
<hr>
</body>
</html>
