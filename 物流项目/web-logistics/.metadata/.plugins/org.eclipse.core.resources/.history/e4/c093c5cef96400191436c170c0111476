<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/resource/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'assembleOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		.title{
			color: black;
			font-size: 25px;
		}
		table{
			text-align: center;
		}
		table th{
			text-align: center;
		}
		#append{
			width:550px;
			list-style:none;
  		}
  		#btnul{
  			padding-left:220px;
  		}
  </style>
  <script type="text/javascript">
	//通过车牌号查看该车的订单
	function inCarOrder(t){
		//alert(t);
		$.post(
 			//url
 			"autoOrder/inCarOrder.do",
 			//携带参数
 			{carNumber:t},
 			//数据类型
 			"json"
 		);
	}
	//判断订单数是否为空的车辆不能进入详情页面（在controller中控制）
	function checkOrderCount(t){
		if(t==0){
			alert("该车辆的订单数为空，不能查看详情！");
		}
	}
	//页面上的删除按钮
	function outAuto(cn,oc){
		//alert(oc);
		$.post(
 			//url
 			"autoOrder/delAutoSuccCar.do",
 			//携带参数
 			{carNumber:cn,orderCount:oc},
 			//回调函数
 			function(date){
 				//alert(date.msg);
 				if(date.msg=="1"){
 					alert("删除成功！");
 					window.location.reload();
 				} else {
 					alert("删除失败！");
 				}
 			},
 			//数据类型
 			"json"
 		);
	}
  </script>
  </head>
  
  <body>
   <div style="float:right;margin-right:20px;margin-top:10px" > 
		<a href="power/autoOrder.do">
			<button style="float:right" class="btn btn-primary btn-lg" >车辆装配</button>
		</a>
  </div>
  	<table class="table table-hover">
		<caption style="text-align: right;width: 53%" class="title">装配管理</caption>
		<thead>
			<tr>
			    <th>序号</th>
			    <th>车辆类型</th>
			    <th>车牌号</th>
			    <th>司机</th>
			    <th>下一站门店</th>
			    <th>订单数</th>
			    <th>预计出发时间</th>
			    <th>预计到达时间</th>
			    <th>状态</th>
			    <th>装配操作</th>
			 </tr>
		</thead>
		<tbody>
			<c:forEach items="${orderList}" var="order" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${order.type} </td>
					<td>${order.car_code}</td>
					<td>${order.driver}</td>
					<td>${order.next_store}</td>
					<td>${order.order_count}</td>
					<td>${order.depart_time}</td>
					<td>${order.arrive_time}</td>
					<td>${order.auto_status}</td>
					<td>
						<a href="autoOrder/inCarOrder.do?carNumber=${order.car_code}&orderCount=${order.order_count}"><input type="button" value="详情" onclick="checkOrderCount('${order.order_count}')"></a>
						<input type="button" value="删除" onclick="outAuto('${order.car_code}','${order.order_count}')">
					</td>
				</tr>
			</c:forEach>
			 <tr><td colspan="10">${pageString}</td></tr>
		</tbody>
	</table>
  </body>
</html>
