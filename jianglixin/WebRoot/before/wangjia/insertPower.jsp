<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertPower.jsp' starting page</title>
    
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
    <form action="Power/insertPower.action" method="post">
    <table class="table table-hover table-border">
    <thead>
    	<th>>权限编号</th>  <th>权限类型</th>
    </thead>
    
    	<tr class="success"><td>权限ID:</td><td><input name="power.power_id"></td></tr>
    	<tr class="warning"><td>权限类型:</td><td><input name="power.power_type"></td></tr>
    	<tr class="danger"><td>确认录入:</td><td><input type="submit" value="提交"></td></tr>
   	</table>
    </form>
  </body>
</html>
