<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- <jsp:include page="/before/front/top.jsp"></jsp:include> --%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${path }/css/bootstrap.css"/>

  </head>
  <body>
  
  
  <!--    模糊查询      --> 
  		<div class="conform" style=float:right>
			<form action="Car/findCarByCode.action" method="post">
				<div class="cfD">
					<input class="userinput" type="text" name="carName" value="${carName}" placeholder="请输入....">&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary btn-sm">查询</button>
				</div>
			</form>
		</div>
	<!--   模糊查询        -->
	
	
<div ass="container"  border=1px>
   	<form action="Car/findCar.action" method="post" >
   		<table class="table  table-striped table-hover" border=1 >
   			<tr>
   				<th style=font-size:20 >车辆编号</th>
   				<th style=font-size:20>车牌号</th>
   				<th style=font-size:20>车辆类型</th>
   				<th style=font-size:20>车辆载重</th>
   				<th style=font-size:20>车辆状态</th>
   				<th style=font-size:20>所属网点ID</th>
   				<th style=font-size:20 class="handle">操作</th>
<!--    				<td>到达网点ID</td> -->
   			</tr>
   			<c:forEach items="${tabCar}" var="row" >
   				<tr>
   					<c:forEach items="${row }" var="obj">
   						<td>${obj }</td>		
   					</c:forEach>
   					<td class="btn btn-success handle"><a href="Car/deleteCar.action?car.car_id=${row[0] }">删除</a></td>
   					<td class="btn btn-success handle"><a href="Car/findOneCar.action?car.car_id=${row[0] }">修改</a></td>
   					<td class="btn btn-success handle"><a href="http://localhost:8080/lightning3/before/wuminghui/insertCar.jsp">添加</a></td>
   				</tr>		
   			</c:forEach>
   		</table>
   		
   	</form>
   	</div>
   		<div>
			<span>共${pageutil.total}条记录</span>			
			显示<sapan>${page.max}<span>条
			共<span id="maxPage">${page.maxPage}</span>页
			<a href="javascript:void(0)" id="pageUp">上一页</a>
			当前第<span id="onPage">${page.currPage}</span>页
			<a href="javascript:void(0)" id="pageDown">下一页</a>
		</div>

  </body>
	<script src="/lightning3/js/jquery-1.8.3.min.js"></script>
	<script>
	  	$(function(){
			if($("#maxPage").text()==""||$("#maxPage").text()==undefined){
				window.location.href="/lightning3/Car/findCarCount.action";
				//location.reload();
			}
				//$(".handle").css("display","none");
		}); 
		$("#pageUp").on("click",function(){
			var onPageNum=Number($("#onPage").text())-1;
			if(onPageNum<1){
				onPageNum=Number($("#maxPage").text());
			}
			window.location.href="/lightning3/Car/findCarCount.action?page.currPage="+onPageNum;
		});
		$("#pageDown").on("click",function(){
			var onPageNum=Number($("#onPage").text())+1;
			var max=Number($("#maxPage").text());
			if(onPageNum>max){
				onPageNum=1;
			}
			window.location.href="/lightning3/Car/findCarCount.action?page.currPage="+onPageNum;
		});
	</script>
<%-- 	<jsp:include page="/before/front/fooder.jsp"></jsp:include> --%>
	
</html>





