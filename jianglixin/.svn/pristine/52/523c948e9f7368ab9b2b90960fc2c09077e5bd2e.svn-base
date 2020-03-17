<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showPower.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
	</style>
  </head>
  <body>
     <form action="Power/findAllPower.action" method="post">
   		
    	<table border=1 class="table table-bordered table table-striped table-striped table-hover">
    		<tr>  
    		<td>权限ID</td> 
    		<td>权限类型</td>
    		<td>删除权限类型</td>
    		<td>修改权限类型</td>
    		<td>增加权限类型</td>
    		</tr>
    		<c:forEach items="${tabPower}" var="row">
    		
    		<tr>
    			<c:forEach items="${row}" var="obj">
    				<td>${obj}</td>
    			</c:forEach>
    			<td><a href="Power/deletePower.action?power.power_id=${row[0]}">删除</a></td>
    			<td><a href="Power/findOnePower.action?power.power_id=${row[0]}">修改</a></td>
    			<td><a href="/lightning3/before/wangjia/insertPower.jsp">增加</a></td>
    		</tr>
    		
    	</c:forEach>
    		
    	</table>
    </form>
  </body>
</html>