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
   	 <form action="Cartype/findCartype.action" method="post">
 		<table class="table" border=1>
 			<tr>
 				<td>车辆ID</td>
 				<td>车辆类型</td>
 			</tr>
 			<c:forEach items="${tabcartype }" var="row">
 				<tr>
 					<c:forEach items="${row }" var="obj">
 						<td>${obj }</td>
 					</c:forEach>	
 				</tr>
 			</c:forEach>
 		</table>
    </form>
   	
  </body>
</html>
