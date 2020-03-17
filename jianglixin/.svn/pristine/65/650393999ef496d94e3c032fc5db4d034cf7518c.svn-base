<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询价格</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
	<script src="/lightning3/js/bootstrap.min.js"></script>
  </head>
  
  <body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>价格id</th>
							<th>公里/元</th>
							<th>顿/元</th>
							<th>立方米/元</th>
							<th>价格说明</th>
							<th>价格说明/元</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td id="price0"></td>
							<td id="price1"></td>
							<td id="price2"></td>
							<td id="price3"></td>
							<td id="price5"></td>
							<td id="price4"></td>
							<td><button type="button" class="btn btn-default" id="updatePrice">修改价格</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-12 column">
				<button type="button" class="btn btn-default  btn-info" id="insertType">添加货物类型</button>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>价格id</th>
							<th>货物类型</th>
							<th>修改</th>
						</tr>
					</thead>
					<tbody id="cargoType">
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!-- 价格修改的模态框 -->
	<div class="modal fade" id="showModalPrice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						价格修改
					</h4>
				</div>
				<div class="modal-body" style="max-height:500px;overflow:scroll;overflow-x:auto;">
					<form action="Price/updatePrice.action" method="post" role="form">
						<div class="form-group">
							<label for="name">价格id：</label>
							<input type="text" class="form-control" name="price.price_id" id="up0">
						</div> 
						<div class="form-group">
							<label for="name">公里/元：</label>
							<input type="text" class="form-control" name="price.price_km" id="up1">
						</div> 
			 			<div class="form-group">
							<label for="name">顿/元：</label>
							<input type="text" class="form-control" name="price.price_ton" id="up2">
						</div>
			 			<div class="form-group">
							<label for="name">立方米/元：</label>
							<input type="text" class="form-control" name="price.price_piece" id="up3">
						</div>
						<div class="form-group">
							<label for="name">价格说明：</label>
							<input type="text" class="form-control" name="price.price_explain" id="up5">
						</div>
						<div class="form-group">
							<label for="name">价格说明/元：</label>
							<input type="text" class="form-control" name="price.price_province" id="up4">
						</div>
		 				<input type="submit" value="提交" class="btn btn-default"> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<!-- 修改货物类型的模态框 -->
	<div class="modal fade" id="showModalType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						货物类型修改
					</h4>
				</div>
				<div class="modal-body" style="max-height:500px;overflow:scroll;overflow-x:auto;">
					<form action="Type/updateType.action" method="post" role="form">
						<div class="form-group">
							<label for="name">货物类型id：</label>
							<input type="text" class="form-control" name="type.type_id" id="upty0">
						</div> 
						<div class="form-group">
							<label for="name">货物类型：</label>
							<input type="text" class="form-control" name="type.type" id="upty1">
						</div> 
		 				<input type="submit" value="提交" class="btn btn-default"> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<!-- 增加货物类型的模态框 -->
	<div class="modal fade" id="showModalInsertType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						货物类型修改
					</h4>
				</div>
				<div class="modal-body" style="max-height:500px;overflow:scroll;overflow-x:auto;">
					<form action="Type/inserType.action" method="post" role="form"> 
 						<div class="form-group">
 							<label for="name">货物类型：</label>
							<input type="text" class="form-control" name="type.type">
 						</div>  
		 				<input type="submit" value="提交" class="btn btn-default"> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
  </body>
  <script>
  	$(function(){
  		$.ajax({//获取价格并添加到模态框和表格中
   			url:"Price/findPrice.action",
  			type:"post",
  			dataType:"text",
  			success:function(tabPrice){
  				var prices=eval("("+tabPrice+")");
  				var price=new Array();
  				for(var i=0;i<prices.length;i++){
  					for(var j=0;j<prices[i].length;j++){
  						price.push(prices[i][j]);
  					}
  				}
  				for(var m=0;m<price.length;m++){
  					$("#price"+m).text(price[m]);
  					$("#up"+m).val(price[m]);
  				}
  		  	}
  		});
  		
 		//查询货物类型并自动生成表格 		
  		$.ajax({
  			url:"Type/findType.action",
  			type:"post",
  			dataType:"text",
  			success:function(tabType){
  				var arrId=new Array();
  				var arrName=new Array();
  				var types=eval("("+tabType+")");
  				var tr="";
  				for(var i=0;i<types.length;i++){
  					tr+="<tr>";
  					var td="";
  					for(var m=0;m<types[i].length;m++){
  						td+="<td>"+types[i][m]+"</td>";
  					}
					td+="<td><button type='button' class='btn btn-default' id='updateType"+types[i][0]+"' num='"+types[i][0]+"'>修改类型</button></td>";
					tr+=td;
  					tr+="</tr>";
  					arrId.push(types[i][0]);
  					arrName.push(types[i][1]);
  				}
  				$("#cargoType").append(tr);
  				show(arrId,arrName);
  			}
  		});
   	});
  	$("#updatePrice").on("click",function(){
  	  	$("#showModalPrice").modal("show");
  	});
  	$("#insertType").on("click",function(){
  	  	$("#showModalInsertType").modal("show");
  	});
  	function show(arrId,arrName){//货物类型模态框显现
  		for(var i=0;i<arrId.length;i++){
		  	$("#updateType"+arrId[i]).on("click",function(){
		  		var typeid=$(this).attr("num");
		  		$.ajax({
		  			url:"Type/findType.action",
		  			type:"post",
		  			dataType:"text",
		  			success:function(tabType){
		  				var types=eval("("+tabType+")");
		  				for(var i=0;i<types.length;i++){
		  					if(types[i][0]==typeid){
		  						$("#upty0").val(types[i][0]);
		  						$("#upty1").val(types[i][1]);
		  					}
		  				}
		  			}
		  		});
			  	$("#showModalType").modal("show");
			});
		}
  	}
  </script>
</html>
