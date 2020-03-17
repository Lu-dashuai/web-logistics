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
    
    <title>My JSP 'showOneWarehose.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
    <form action="/lightning3/Warehose/updateWarehose.action" method="post">
    	<table class="table table table-striped table-hover,table table-condensed">
    		<tr>
    			<td>仓库类型</td>
    			<td>
    				<input type="hidden" name="warehose.warehose_id" value="${rowWarehose[0] }">
    				<select name="warehose.warehose_type">
    					<c:forEach items="${tabType }" var="type"><!-- 根据warehose的ID -->
    						<option <c:if test="${rowWarehose[1] eq type[0] }">selected</c:if> value="${type[0]}">${type[1]}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>所属网点</td>
    			<td>
    				<select name="warehose.warehose_station">
    					<c:forEach items="${tabStation }" var="station"><!-- 根据station的ID -->
    						<option <c:if test="${rowWarehose[2] eq station[0] }">selected</c:if> value="${station[0] }">${station[1] }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>仓库容量</td>
    			<td><input type="text" name="warehose.warehose_size" value="${rowWarehose[3] }"></td>
    		</tr>
    		<tr>
    			<td clospan="2"><input type="submit" value="修改" class="btn btn-primary"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
