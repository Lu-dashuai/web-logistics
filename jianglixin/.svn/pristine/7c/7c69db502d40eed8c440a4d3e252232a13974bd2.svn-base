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
    
    <title>My JSP 'insertComego.jsp' starting page</title>
    
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

  
  	 <form action="/lightning3/Comego/insertComego.action" method="post">
	  	<table class="table table table-striped table-hover">
	    	<tr>
	    		<td>订单编号</td>
	    		<td>
	    			<select name="comego.comego_indent">
	    				<c:forEach items="${tabComego }" var="comego">
	    					<option value="${comego[0] }">${comego[0] }</option>
	    				</c:forEach>
	    			</select>
	    		</td>
	    	</tr>
	    	<tr>	
	    		<td>出入库状态</td>
	    		<td>
	    			<select name="comego.comego_situation">
	    				<c:forEach items="${tabSituation }" var="situation">
	    					<option value="${situation[0] }">${situation[1] }</option>
	    				</c:forEach>
	    			</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>操作时间</td>
	    		<td><input type="text" name="comego.comego_time" placeholder="" required></td>
	    	</tr>
	    	<tr>
	    		<td>所属网点</td>
	    		<td>
	    			<select name="comego.comego_station">
	    				<c:forEach items="${tabStation }" var="station">
	    					<option value="${station[0] }">${station[2]}</option>
	    				</c:forEach>
	    			</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>所属车辆</td>
	    		<td>
	    			<select name="comego.comego_car">
	    				<c:forEach items="${tabCar }" var="car">
	    					<option value="${car[0] }">${car[1] }</option>
	    				</c:forEach>
	    			</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td></td>
	    		<td><input type="submit" value="增加" class="btn btn-primary"></td>
	    	</tr>
	    </table>
	   </form>
  </body>
</html>
