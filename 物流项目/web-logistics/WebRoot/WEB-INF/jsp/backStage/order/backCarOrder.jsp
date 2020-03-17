<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/resource/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车辆调度</title>
    
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
	function backCarOrder(tt,t){
		//alert(tt);
		//alert(t);
		$.post(
			"autoOrder/backOrderCar.do",
			{carNum:tt,carStore:t},
			function(date){
				//alert(date.msg);
				if(date.msg=="1"){
 					alert("返程操作成功！");
 					window.location.reload();
 				} else {
 					alert("删除操作失败！");
 				}
			},
			"json"
		);
	}
  </script>
  </head>
  
  <body>
  	<table class="table table-hover">
		<caption style="text-align: right;width: 53%" class="title">车辆调度</caption>
		<thead>
			<tr>
			    <th>序号</th>
			    <th>车辆类型</th>
			    <th>车牌号</th>
			    <th>司机</th>
			    <th>所属门店</th>
			    <th>颜色</th>
			    <th>载重</th>
			    <th>状态</th>
			    <th>返程操作</th>
			 </tr>
		</thead>
		<tbody>
			<c:forEach items="${orderList}" var="order" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${order.type}</td>
					<td>${order.number}</td>
					<td>${order.driver}</td>
					<td>${order.store_name}</td>
					<td>${order.color}</td>
					<td>${order.capacity}</td>
					<td>空闲</td>
					<td>
						<input type="button" value="返程" onclick="backCarOrder('${order.number}','${order.store_name}')">
					</td>
				</tr>
			</c:forEach>
			 <tr><td colspan="10">${pageString}</td></tr>
		</tbody>
	</table>
  </body>
</html>
