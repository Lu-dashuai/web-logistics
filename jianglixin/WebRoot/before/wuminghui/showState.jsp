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
    
    <title>My JSP 'showState.jsp' starting page</title>
    
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
    <form action="State/findState.action" method="post">
    	<table class="table" border=1>
    		<tr>
    			<td>车辆状态id</td>
    			<td>车辆状态信息</td>
    		</tr>
    		<c:forEach items="${tabState }" var="row">
    			<tr>
    				<c:forEach items="${row }" var="obj">
    					<td>${obj }</td>
    				</c:forEach>
    				<td class="btn btn-success"><a href="State/deleteState.action?state.state_id=${row[0] }">删除</a></td>
    				<td class="btn btn-success"><a href="State/findOneState.action?state.state_id=${row[0] }">修改</a></td>
    				<td class="btn btn-success"><a href="http://localhost:8080/lightning3/before/wuminghui/insertState.jsp">继续录入</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    </form>
  </body>
</html>
