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
    
    <title>My JSP 'index.jsp' starting page</title>
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
		<form action="wangzelong_Account_insertAccount.action" method="post">
			<table class="table table table-striped table-hover">
			<thead>
				<th colspan="2">账目的增加</th>
			</thead>
			<tr>
				<td>
					订单id：
				</td>
				<td>
					<input name="account.account_indent">
				</td>
			</tr>
			<tr>
				<td>
					账单：
				</td>
				<td>
					<input name="account.account_money">
				</td>
			</tr>
			<tr>
				<td>确认提交：</td>
				<td colspan="2"><input class="btn btn-primary" type="submit"></td>
			</tr>
			</table>
		</form>
  </body>
</html>
