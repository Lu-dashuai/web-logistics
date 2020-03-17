<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resource/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAssemble.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

  </head>
  <style>
	table th{
		text-align: center;
	}
	#checkChange input{
		border:0px;
		width:100%;
	}
  </style>
  <script type="text/javascript">
  	//全选全不选
  	$(function(){
	  	$("#all").click(function(){
		  	var asd=this.checked
			$("[name='order']").prop('checked',asd);
	  	});
  	});
  	//删除按钮
  	function del(t,tt){
  		//alert(tt);
  		$.post(
 			//url
 			"autoOrder/updateOrderByCarNum.do",
 			//携带参数
 			{carCode:t,orderCode:tt},
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
  	//为空不能提交表单
  	function check(){
		var departTime = $("#departTime").val();
		var arriveTime = $("#arriveTime").val();
		var next_store = $("#next_store").val();
		var number = $("#number").val();
		if(departTime == "" ){
		    alert("请将表单填写完整!");
		    return false;
		}
		if(next_store == ""){
		    alert("请将表单填写完整!");
		    return false;
		}
		if(number == ""){
		    alert("请将表单填写完整!");
		    return false;
		}
		if(arriveTime == ""){
		    alert("请将表单填写完整!");
		    return false;
		}
	}
	
  </script>
  <body>
   <ul class="pagination"  style="margin-top: 10px;">
		<li>
			<a class="btn" onClick="javascript :history.back(-1);">返回</a>
		</li>
  	</ul>
 <form style="width:70%;margin:0px auto;" action="autoOrder/inAuto.do" method="post"  onsubmit="return check()">
  <fieldset id="fiel">
  	<div align="center"><h3>装配管理</h3></div>
  	<hr/>
  	<table style="height:200px;width:100%;text-align: center;">
	    <tbody>
	    <c:forEach items="${orderList}" var="order" varStatus="i" begin="0" end="0">
	    	<tr style="height:50px;">
	    		<th style="width:10%;">车辆车牌号</th>
	    		<td>
	    			<input name="number" id="number" class="form-control" style="width:130px;display:inline;float:left;" value='${order.number}'>
	    		</td>
	    		<th style="width:10%;">车辆类型</th>
	    		<td>
	    			<input name="type" id="type" type="text" value='${order.type}' readonly="readonly" style="height:30px;width:200px;"  class="form-control" >
	    		</td>
	    	</tr>
	    	<tr id="carDetails" style="height:50px;">
    			<th>司机</th>
    			<td><input type="text" id="driver" value='${order.driver}' name="driver" readonly="readonly" style="height:30px;width:200px;"  class="form-control" ></td>
    			<th>载重</th>
    			<td><input type="text" id="capacity" value='${order.capacity}' name="capacity" readonly="readonly" style="height:30px;width:200px;"  class="form-control" ></td>
	    	</tr>
	    	<tr style="height:50px;">
	    		<th>预计出发时间</th>
	    		<td><input name="departTime" id="departTime" class="Wdate form-control"value='${order.depart_time}' readonly="readonly"  style="height:30px;width:200px;" type="text" onclick="WdatePicker({minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'arriveTime\',{d:0});}'})" /></td>
				<th>预计到达时间</th>
				<td><input name="arriveTime" id="arriveTime" class="Wdate form-control" value='${order.arrive_time}' readonly="readonly"  style="height:30px;width:200px;" type="text" onclick="WdatePicker({minDate:'#F{$dp.$D(\'departTime\',{d:0});}'})"/></td>
	    	</tr>
	    	<tr style="height:50px;">
	    		<th>下一站门店</th>
	    		<td >
	    			<input name="next_store"  id="next_store" value='${order.next_store}' class="form-control" style="width:300px;display:inline;float:left;">
	    		</td>
	    		<td colspan="4"><span id="hintId" style="color: red;"></span></td>
	    	</tr>
	    	</c:forEach>
	    </tbody>
    </table> 
  </fieldset>
	<div class="panel-group" id="appendContainer" style="width:100%;">
	<hr/>
	<div align="center"><h3>待装配订单表</h3></div>
	<hr/>
		 <table  id="checkChange"  style="height:200px;width:100%;text-align: center;"  border="1px">
			<thead>
				<tr>
					<th>序号</th>
					<th>订单号</th>
				    <th>收货人</th>
				    <th>收货人地址</th>
				    <th>下单时间</th>
				    <th>物品类型</th>
				    <th>物品重量</th>
				    <th>所在仓库</th>
				    <th>物品备注</th>
				    <th>物品状态</th>
				    <th>订单操作</th>
				 </tr>
			</thead>
			<tbody id="appendInfo">
			<c:forEach items="${orderList}" var="order" varStatus="i" >
				<tr>
					<td>${i.count}</td>
					<td>${order.order_mailnum}</td>
					<td>${order.accepter_name}</td>
					<td>${order.accepter_adr}</td>
					<td>${order.order_time}</td>
					<td>${order.goods_type}</td>
					<td>${order.goods_weight}</td>
					<td>${order.order_now_store}</td>
					<td>${order.goods_remarks}</td>
					<td>已装配</td>
					<td><input type="button" class="btn btn-primary" value="删除" onclick="del('${order.number}','${order.order_mailnum}')"></td>
				</tr>
			</c:forEach>
				<tr><td colspan="11">${pageString}</td></tr>
			</tbody>
		</table>
	</div>
<div align="center">
	<ul class="pagination"  >
		<li>
			<a class="btn btn-primary" style="width:100px;height:40px;margin-right:80px;" onClick="javascript :history.back(-1);">返回</a>
		</li>
  	</ul>
</div>
</form>




  </body>
</html>
