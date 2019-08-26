<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jason交互测试</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
        //请求是json，输出是json
        function requestJson() {
            $.ajax({
                type:'post',
                url:'<%=request.getContextPath() %>/requestJson.action',
                contentType:'application/json;charset=UTF-8',
                //数据格式是json串
                data:'{"bname":"手机","price":"9999"}',
                success:function(data) {//返回json结果
                    alert(data.price);
               }
            });

        }
        //请求是key/value，输出是json
        function responseJson() {
            $.ajax({
                type:'post',
                url:'<%=request.getContextPath() %>/responseJson.action',
                //默认是key/value，不需要指定contentType
                //contentType:'application/json;charset=UTF-8',
                //数据格式是json串
                data:'bname=手机&price=9999',
                success:function(data) {//返回json结果
                    alert(data.bname);
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="requestJson()" value="请求是json，输出是json">
    <input type="button" onclick="responseJson()" value="请求是key/value，输出是json">
</body>
</html>
