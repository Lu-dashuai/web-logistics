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
    
    <title>My JSP 'insertCompany.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel ="stylesheet" href="${path}/css/bootstrap.css">
  </head>
  
  <body>
   <form action="Company/insertCompany.action" method="post">
   	<table class="table table table-striped table-hover">
   		<thead>
   			<th>公司的增加</th>
   		</thead>
   		<tr>
   			<td>
   				公司名称:
   			</td>
   			<td>
				<input name="company.company_name"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				公司的介绍:
   			</td>
   			<td>
				<input name="company.company_introduce"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				公司的电话:
   			</td>
   			<td>
				<input name="company.company_phone"><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				提交
   			</td>
   			<td>
				<input type="submit" value="提交">
   			</td>
   		</tr>
		</table>
	</form>
  </body>
</html>
