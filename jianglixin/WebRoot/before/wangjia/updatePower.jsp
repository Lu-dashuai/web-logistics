<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
</head>
<body>
<form action="Power/updatePower.action" method="post">
    <table class="table table-hover table-border">
    <thead>
    	<th>>权限编号</th><th>权限类型</th>
    </thead>
    
    	<tr class="success"><td>权限ID:</td><td><input name="power.power_id" value="rowPower[0]"></td></tr>
    	<tr class="warning"><td>权限类型:</td><td><input name="power.power_type" value="rowPower[1]"></td></tr>
    	<tr class="danger"><td>确认录入:</td><td><input type="submit" value="提交"></td></tr>
   	</table>
    </form>
</body>
</html>