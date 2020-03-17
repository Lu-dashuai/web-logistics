<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCargo.jsp' starting page</title>
    
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
  	<form action="Cargo/findCargo.action" method="post">
  		<table border="1">
  			<tr>
  				<td>订单号:</td>
  				<td>订单时间:</td>
  				<td>发货人:</td>
  				<td>发货人手机:</td>
  				<td>发货人邮编:</td>
  				<td>发货人地址:</td>
  				<td>收货人:</td>
  				<td>收货人手机:</td>
  				<td>收货人邮编:</td>
  				<td>收货人地址:</td>
  				<td>货物说明：</td>
  				<td>货物重量：</td>
  				<td>货物大小：</td>
  				<td>货物类型：</td>
  			</tr>
  			<tr>
  				<td>${rowIndent[0]}</td>
  				<td>${rowIndent[1]}</td>
  				<td>${rowIndent[6]}</td>
  				<td>${rowIndent[7]}</td>
  				<td>${rowIndent[8]}</td>
  				<td>${rowIndent[9]}</td>
  				<td>${rowIndent[2]}</td>
  				<td>${rowIndent[3]}</td>
  				<td>${rowIndent[4]}</td>
  				<td>${rowIndent[5]}</td>
  				<td>${rowCargo[3]}</td>
  				<td>${rowCargo[0]}</td>
  				<td>${rowCargo[1]}</td>
  				<td>${rowCargo[2]}</td>
  			</tr>
  		</table>
    </form>
  </body>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script>
  
  </script>
</html>
