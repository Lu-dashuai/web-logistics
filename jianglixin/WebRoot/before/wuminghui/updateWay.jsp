<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showDriver.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
  </head>
  
  <body>
		<form action="Way/updateWay.action" method="post">
		<table class="table" border=1>
			<thead>
				<th>运输信息</th>
				<th>输入信息</th>
			</thead>
			<tr>
				<td>车辆ID</td><td><input name="way.way_car" value="${rowWay[0] }"></td>
			</tr>
			<tr>
				<td>送到哪个网点</td><td><input name="way.way_direction" value="${rowWay[1] }"></td>
			</tr>
			<tr>
				<td>运输距离</td><td><input name="way.way_km" value="${rowWay[2] }"></td>
			</tr>
			<tr>
				<td>确定输入</td>
				<td><input type="submit" class="btn btn-primary" value="提交" ></td>
			</tr>
		</table>
	</form>  
  </body>
</html>
