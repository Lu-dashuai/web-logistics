<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

  </head>
  
  <body>
    <form action="Driver/updateDriver.action" method="post">
		<table>
			<thead>
				<th>司机表</th>
				<th>输入信息</th>
			</thead>
			<tr>
				<td>车辆编号</td><td><input name="driver.driver_worker" value="${rowDriver[0] }"></td>
			</tr>
			<tr>
				<td>车辆ID</td><td><input name="driver.driver_car" value="${rowDriver[1]}"></td>
			</tr>
			<tr>
				<td>确定输入</td><td><input type="submit" value="提交" class ="btn btn-primary"></td>
			</tr>
		</table>
	</form>
  </body>
</html>






