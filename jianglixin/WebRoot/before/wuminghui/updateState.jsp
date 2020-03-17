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
    <form action="State/updateState.action" method="post">
		 <table class="table table-bordered table table-striped table-striped table-hover">
			<thead>
				<th>车辆信息表</th>
				<th>输入信息</th>
			</thead>
			<tr>
				<td>车辆状态ID</td><td><input name="state.state_id" value="${rowState[0] }"></td>
			</tr>
			<tr>
				<td>车辆状态信息</td><td><input name="state.state_name" value="${rowState[1] }"></td>
			</tr>
			<tr>
				<td>确定输入</td><td><input type="submit" class="btn btn-primary" value="提交"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
	