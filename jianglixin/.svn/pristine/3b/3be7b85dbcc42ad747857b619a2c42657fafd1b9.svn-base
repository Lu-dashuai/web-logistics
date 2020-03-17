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
    
    <title>My JSP 'showOneComego.jsp' starting page</title>
    
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
    <form action="/lightning3/Comego/updateComego.action" method="post">
    	<table class="table table table-striped table-hover,table table-condensed">
    		<input type="hidden" name="comego.comego_id" value="${rowComego[0] }">
    		<tr>
    			<td>订单编号</td>
    			<td>
    				<input type="text" name="comego.comego_indent" value="${rowComego[1] }">
    			</td>
    		</tr>
    		<tr>
    			<td>出入库状态</td>
    			<td>
    				<select name="comego.comego_situation">
    					<c:forEach items="${tabSituation }" var="situation"> <!--根据status查询的结果循环  -->   					
    						<option <c:if test="${rowComego[2] eq situation[0] }">selected</c:if> value="${situation[0] }">${situation[1] }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>出入库时间</td>
    			<td><input type="text" name="comego.comego_time" value="${rowComego[3] }"></td>
    		</tr>
    		<tr>
    			<td>所属网点</td>
    			<td>
    				<select name="comego.comego_station">
    					<c:forEach items="${tabStation }" var="station">  <!-- 根据station查询结果     -->  					
    						<option <c:if test="${rowComego[4] eq station[0] }">selected</c:if> value="${station[0] }">${station[2] }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>所属车辆</td>
    			<td>
    				<select name="comego.comego_car">
    					<c:forEach items="${tabCar }" var="car"><!-- 根据car的查询结果 -->
    						<option <c:if test="${rowComego[5] eq car[0] }">selected</c:if>  value="${car[0] }">${car[1] }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input class="btn btn-primary" type="submit" value="修改"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
