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
    
    <title>My JSP 'insertAccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"  href="${path}/css/bootstrap.css">
  </head>
  
  <body>
	<form action="Users/insertUsers.action" method="post">
	<table class="table table table-striped table-hover">
		<thead>
   			<th>用户的增加</th>
   		</thead>
   		<tr>
   			<td>
				用户的id：
   			</td>
   			<td>
   				<input name="users.users_id"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				用户的密码:
   			</td>
   			<td>
				<input name="users.users_password"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				用户的名字:
   			</td>
   			<td>
				<input name="users.users_name"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				用户的电话:
   			</td>
   			<td>
				<input name="users.users_phone"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				用户的身份证号:
   			</td>
   			<td>
				<input name="users.users_idcard"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				用户的邮编:
   			</td>
   			<td>
				<input name="users.users_postcode"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				确定完毕:
   			</td>
   			<td>
				<input type="submit">
   			</td>
   		</tr>
		</table>
	</form>

  </body>
</html>
