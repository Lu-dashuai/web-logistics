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
    
    <title>My JSP 'showOneKeeper.jsp' starting page</title>
    
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
    <form action="/lightning3/Keeper/updateKeeper.action" method="post">
    	<table class="table table table-striped table-hover,table table-condensed">
    		<tr>
    			<td>员工姓名</td>
    			<td>
    				<select name="keeper.keeper_worker">
    					<c:forEach items="${tabWorker }" var="worker"><!-- 根据worker查询结果 -->
    						<option <c:if test="${rowKeeper[0] eq worker[0]}">selected</c:if> value="${rowKeeper[0] }">${worker[2] }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>仓库编号</td>
    			<td>
    				<select name="keeper.keeper_warehose">
    					<c:forEach items="${tabWarehose }" var="warehose"><!-- 根据warehose查询结果 -->
    						<option <c:if test="${rowKeeper[1] eq warehose.warehose_id}">selected</c:if> value="${warehose.warehose_id }">${warehose.type }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td clospan="2"><input type="submit" value="修改" class="btn btn-primary"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
