<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不加的话不识别el表达式-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--

	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
	  <script type="text/javascript">
		  window.onload =function () {

		  }

		  function deleteBook() {
			  document.bookForm.action="<c:url value='/book/deleteBook.action'/>";
			  document.bookForm.submit();
		  }
		  function queryBook() {
			  document.bookForm.action="<c:url value='/book/queryItems.action'/>";
			  document.bookForm.submit();
		  }
	  </script>
  </head>
  当前用户：${username},
  <c:if test="${username!=null}">
	  <a href="<c:url value='/logout.action'/> ">退出</a>
  </c:if>

  <body>
  	<form name="bookForm" action="<c:url value='/book/queryItems.action'/>" method="post">
		商品名称：<input type="text" name="bookCustom.bname">
		<input type="button" value="查询" onclick="queryBook()">
		<br>
		<input type="button" value="批量删除" onclick="deleteBook()">
		<br>

		<c:forEach items="${bookList}" var="bl">
			<div class="icon">
				<input type="checkbox" name="book_id" value="${bl.bid}">
				<a href="javascript:;"><img src="<c:url value='/${bl.image}'/>" border="0"/></a>
				  <br/>
				<a href="${pageContext.request.contextPath}/book/editBook.action?bid=${bl.bid}">${bl.bname}</a>
				<br/>
				author:${bl.author}
			</div>
		</c:forEach>


	</form>
  </body>
 
</html>

