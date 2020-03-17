

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
	
<!-- 	<link rel="stylesheet" type="text/css" href="styles.css"> -->
	 
 		<link rel="stylesheet" type="text/css" href="${path }/css/bootstrap.css"/>
<%-- 		<link rel="stylesheet" href="${path }/before/css/bootstrap.min.css"> --%>
<%--  			<script src="${path }/before/js/jquery-2.1.4.min.js"></script>  --%>
<%-- 			<script src="${path }/before/js/bootstrap.js"></script> --%>
  </head>
  <body>
	 
<!-- 			<div class="modal fade" id="myModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
<!-- 				<div class="modal-dialog"> -->
<!-- 					<div class="modal-content"> -->
<!-- 						<div class="modal-header">  -->

<!-- 							<h4 class="modal-title" id="myModalLabel"> -->
<!-- 								模态框（Modal）标题 -->
<!-- 							</h4> -->
<!-- 						</div> -->
<!-- 						<div class="modal-body"> -->
<!-- 							您好！您无权添加！ -->
<!-- 						</div> -->
<!-- 						<div class="modal-footer"> -->
<!-- 							<button type="button" class="btn btn-default" data-dismiss="modal">关闭 -->
<!-- 							</button> -->
<!-- 							<button type="button" class="btn btn-primary"> -->
<!-- 								提交更改 -->
<!-- 							</button> -->
<!-- 						</div> -->
<!-- 					</div>/.modal-content -->
<!-- 				</div>/.modal -->
<!-- 			</div> -->
  
   	<div class="container" style="min-height:500px;width:100%">
		<div class="row clearfix">
			<div class="col-md-12 column">
		    	<table class="table  table-striped table-hover" border=1px>
		    		<tr>
		    			<th style=font-size:30>网点编号</th >
		   				<th  style=font-size:30>网点名字</th >
		   				<th  style=font-size:30>网点具体地址</th>
		   				<th  style=font-size:30>网点经理</th >
		   				<th  style=font-size:30 >网点联系电话</th >
		   				<th  class="handle" style=font-size:30>操作</th >
		    		</tr>
		    		<c:forEach items="${tabStation }" var="row">
		   				<tr >
		   					<c:forEach items="${row }" var="obj">
		   						<td>${obj }</td>		
		   					</c:forEach>
		   					<td class="btn btn-success handle"><a href="Station/deleteStation.action?station.station_id=${row[0] }">删除</a></td>
		   					<td class="btn btn-success handle"><a href="Station/findOneStation.action?station.station_id=${row[0] }" >修改</a></td>
		   					<td class="btn btn-success handle"><a href=" http://localhost:8080/lightning3/before/wuminghui/insertStation.jsp" >继续添加</a></td>
		   				</tr>		
		   			</c:forEach>   			
		    	</table>										
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<span>共${pageutil.total}条记录</span>			
				显示<sapan>${page.max}<span>条
				共<span id="maxPage">${page.maxPage}</span>页
				<a href="javascript:void(0)" id="pageUp">上一页</a>
				当前第<span id="onPage">${page.currPage}</span>页
				<a href="javascript:void(0)" id="pageDown">下一页</a>
			</div>
		</div>
	</div>
   	

  </body>
<script src="/lightning3/js/jquery-1.8.3.min.js"></script>
	<script>
		$(function(){
			if($("#maxPage").text()==""||$("#maxPage").text()==undefined){
				window.location.href="/lightning3/Station/findStationCount.action";
			}
			//$(".handle").css("display","none");
		});
		$("#pageUp").on("click",function(){
			var onPageNum=Number($("#onPage").text())-1;
			if(onPageNum<1){
				onPageNum=Number($("#maxPage").text());
			}
			window.location.href="/lightning3/Station/findStationCount.action?page.currPage="+onPageNum;
		});
		$("#pageDown").on("click",function(){
			var onPageNum=Number($("#onPage").text())+1;
			var max=Number($("#maxPage").text());
			if(onPageNum>max){
				onPageNum=1;
			}
			window.location.href="/lightning3/Station/findStationCount.action?page.currPage="+onPageNum;
		});
		
	</script>
</html>
<%-- 	<jsp:include page="/before/front/fooder.jsp"></jsp:include> --%>


 