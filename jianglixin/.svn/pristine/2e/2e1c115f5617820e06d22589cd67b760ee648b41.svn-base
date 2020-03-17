<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showWay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${path }/css/bootstrap.css"/>
  </head>
  
  <body>
    <form action="Way/findWay.action" method="post">
 		<table class="table" border=1>
 			<tr>
 				<td>车辆ID</td>
 				<td>运送到哪个网点</td>
 				<td>运输距离</td>
 			</tr>
 			<c:forEach items="${tabWay }" var="row">
 				<tr>
 					<c:forEach items="${row }" var="obj">
 						<td>${obj }</td>
 					</c:forEach>
 					<td><a href="Way/deleteWay.action?way.way_car=${row[0] }">删除</a></td>
 					<td><a href="Way/findOneWay.action?way.way_car=${row[0] }">修改</a></td>		
 				</tr>
 			</c:forEach>
 		</table>
    </form>
  </body>
</html>
