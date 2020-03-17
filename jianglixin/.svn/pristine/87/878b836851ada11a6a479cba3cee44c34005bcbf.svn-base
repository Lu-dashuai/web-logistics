<jsp:include page="/before/front/top.jsp"></jsp:include>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>付费确认</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>您的账单 </h1>
			</div>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>订单号</th>
						<th>所需里程/km</th>
						<th>公里/元</th>
						<th>货物吨数</th>
						<th>吨/元</th>
						<th>货物大小</th>
						<th>立方米/元</th>
						<th>燃油费</th>
						<th>总价</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td id="indent">${rowCargo[0]}</td>
						<td id="km">${rowDistance[0]}</td>
						<td id="pricekm"></td>
						<td id="ton">${rowCargo[1]}</td>
						<td id="priceton"></td>
						<td id="size">${rowCargo[2]}</td>
						<td id="sizePrice"></td>
						<td id="provinceprice"></td>
						<td id="account"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn-group btn-group-lg">
				<button type="button" class="btn btn-default" id="deleteAccount">删除此单</button>
				<button type="button" class="btn btn-default" id="insertAccount">立即付款</button>
			</div>
		</div>
	</div>
  </div>
  
  
  
  
  
<!--     	<table border="1"> -->
<!--     		<tr> -->
<%--     			<td id="indent">${rowCargo[0]}</td> --%>
<!--     			<td id="km">5</td> -->
<!--     			<td id="pricekm"></td> -->
<%--     			<td id="ton">${rowCargo[1]}</td> --%>
<!--     			<td id="priceton"></td> -->
<%--     			<td id="size">${rowCargo[2]}</td> --%>
<!--     			<td id="sizePrice"></td> -->
<!--     			<td>省内：</td> -->
<!--     			<td id="provinceprice"></td> -->
<!--     			<td id="account"></td> -->
<!--     		</tr> -->
<!--     		<tr> -->
<!--     			<td><input id="deleteAccount" type="button" value="删除"></td> -->
<!--     			<td><input id="insertAccount" type="button" value="立即付款"></td> -->
<!--     		</tr> -->
<!--     	</table> -->
  </body>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script>
   	$(function(){
  		$.ajax({
   			url:"Price/findOnePrice.action",
   			data:{"price.price_id":"1"},
  			type:"post",
  			dataType:"text",
  			success:function(tabPrice){
  				$("#account").empty();
  				var prices=eval("("+tabPrice+")");
  				var price=new Array();
  				for(var i=0;i<prices.length;i++){
  					for(var j=0;j<prices[i].length-1;j++){
  						price.push(prices[i][j]);
  					}
  				}
  				$("#pricekm").text(price[0]);
  				$("#priceton").text(price[1]);
  				$("#sizePrice").text(price[2]);
  				$("#provinceprice").text(price[3]);
  				$("#account").text(function(){
  		  			var km=Number($("#km").text())*Number(price[0]);
  		  			var ton=Number($("#ton").text())*Number(price[1]);
  		  			var size=Number($("#size").text())*Number(price[2]);
  		  			var pr=Number(price[3]);
  		  			var money=km+ton+size+pr;
  		  			return money.toFixed(2);
  		  		});
  			}
   		});
  		$("#insertAccount").on("click",function(){
  			$.ajax({
  				url:"Account/insertAccount.action",
  				data:{"account.account_indent":$("#indent").text(),"account.account_money":$("#account").text()},
  				dataType:"text",
  				type:"post",
  				success:function(){
  					$(window).attr("location","/lightning3/before/wangzelong/showUsersIndentBefore.jsp");
  				}
  			});
  		});
  		$("#deleteAccount").on("click",function(){
  			$.ajax({
  				url:"Account/deleteAccount.action",
  				data:{"account.account_indent":$("#indent").text()},
  				dataType:"text",
  				type:"post",
  				success:function(){
  					$(window).attr("location","/lightning3/before/wangzelong/insertIndentBefore.jsp");
  					//$(window).attr("location","later/wangzelong/insertIndentBefore.jsp");
  				}
  			});
  		});
   	}); 		
  </script>
</html>
<jsp:include page="/before/front/fooder.jsp"></jsp:include>