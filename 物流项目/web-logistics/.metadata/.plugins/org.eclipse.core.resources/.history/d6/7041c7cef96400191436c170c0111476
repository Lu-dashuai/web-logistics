<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  //获取车辆车牌号
	$(function(){
		//alert("111");
		var str="";
       	$.post(
 			//url
 			"autoOrder/getCarMsg.do",
 			//不携带参数
 			//回调函数
 			function(data){
 				if(data!=''){
 					for(var i = 0;i<data.length;i++){
	 					str += "<option  value = '"+data[i].number+"'>"+data[i].number+"</option>";	
 					}
 					$("#number").append(str);
 				}
 			},
 			//数据类型
 			"json"
 		);

	});
	
  	//通过车辆车牌号获取车辆信息
    function changeNum(t){
    	var str1="";
    	 $.ajax({
           url:"autoOrder/getCarMsg.do",//请求地址
           data:{number:$(t).val()},//请求中携带的参数
           async:true,//是否是同步请求 ，如果不写，默认为true，默认异步的 ，如果为false，同步
           type:"post",//设置请求类型
           dataType:"json",//设置返回值的类型
           success:function(data){//成功后回调的函数
              //alert(data);
               if(data!=''&&data!=null){
               		//alert(data);
	        		//$("#type").val(data[0].type);
 					$("#type").val(data[0].type);
	        		$("#driver").val(data[0].driver);
	        		$("#capacity").val(data[0].capacity);
               }
           }
        });      
    }
    
    //获取目的地列表
	$(function(){
		//alert("111");
		var str="";
       	$.post(
 			//url
 			"autoOrder/getStore.do",
 			//不携带参数
 			//回调函数
 			function(data){
 			var str='';
 				if(data!=''){
 					for(var i = 0;i<data.length;i++){
	 					str += "<option  value = '"+data[i].store_name+"'>"+data[i].store_name+"</option>";	
 					}
 					$("#next_store").append(str);
 				}
 			},
 			//数据类型
 			"json"
 		);

	});
	//待装配列表
	$(function(){
  		$("#appendInfo")
  		$.post(
 			//url
 			"autoOrder/getWaitAuto.do",
 			//不携带参数
 			//{status3:3},
 			//回调函数
 			function(data){
 				var str = '';
 				if(data!=''){
 					for(var i = 0;i<data.length;i++){
	 					str +="<tr>";
						str +="<td ><input type='checkbox' name='order"+i+"' value='"+data[i].order_mailnum+"' id='id"+i+"'></td>"
						str +="<td ><input readonly='readonly' name='order_mailnum' id='order_mailnum' value="+data[i].order_mailnum+"></td>";
						str +="<td ><input readonly='readonly' name='accepter_name' id='accepter_name' value="+data[i].accepter_name+"></td>";	
						str +="<td ><input readonly='readonly' name='accepter_adr' id='accepter_adr'value="+data[i].accepter_adr+"></td>";
						str +="<td ><input readonly='readonly' name='order_time' id='order_time' value="+data[i].order_time+"></td>";
						str +="<td ><input readonly='readonly' name='goods_type' id='goods_type' value="+data[i].goods_type+"></td>";
						str +="<td ><input readonly='readonly' name='goods_weight' id='goods_weight' value="+data[i].goods_weight+"></td>";
						str +="<td ><input readonly='readonly' name='order_now_store' id='order_now_store' value="+data[i].order_now_store+"></td>";
						str +="<td ><input readonly='readonly' name='goods_remarks' id='goods_remarks' value="+data[i].goods_remarks+"></td>";
						str +="<td ><input readonly='readonly' name='auto_status' id='auto_status' value="+data[i].auto_status+"></td>";
						str +="<td ><input  id='del' onclick='delOrder("+data[i].order_mailnum+")' class='btn btn-primary' type='button' value='删除'></td>"
						str +="</tr>";
 					}
 					$("#appendInfo").append(str);
 				}
 			},
 			//数据类型
 			"json"
 		);
  	});
   	//全选全不选
  	$(function(){
	  	$("#all").click(function(){
		  	var asd=this.checked
			$("[name='order']").prop('checked',asd);
	  	});
  	}); 
  	//删除按钮
  	function delOrder(t){
  		$.post(
 			//url
 			"autoOrder/delOrderByOrderNum.do",
 			//携带参数
 			{orderNum:t},
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
	    	<tr style="height:50px;">
	    		<th style="width:10%;">车辆车牌号</th>
	    		<td>
	    			<select name="number" id="number" class="form-control" style="width:130px;display:inline;float:left;" onchange="changeNum(this)">
	    			</select>
	    		</td>
	    		<th style="width:10%;">车辆类型</th>
	    		<td>
	    			<input name="type" id="type" type="text"  readonly="readonly" style="height:30px;width:200px;"  class="form-control" >
	    		</td>
	    	</tr>
	    	<tr id="carDetails" style="height:50px;">
    			<th>司机</th>
    			<td><input type="text" id="driver" name="driver" readonly="readonly" style="height:30px;width:200px;"  class="form-control" ></td>
    			<th>载重</th>
    			<td><input type="text" id="capacity" name="capacity" readonly="readonly" style="height:30px;width:200px;"  class="form-control" ></td>
	    	</tr>
	    	<tr style="height:50px;">
	    		<th>预计出发时间</th>
	    		<td><input name="departTime" id="departTime" class="Wdate form-control" value="${assembleMap.depart_time}" readonly="readonly"  style="height:30px;width:200px;" type="text" onclick="WdatePicker({minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'arriveTime\',{d:0});}'})" /></td>
				<th>预计到达时间</th>
				<td><input name="arriveTime" id="arriveTime" class="Wdate form-control" value="${assembleMap.arrive_time}" readonly="readonly"  style="height:30px;width:200px;" type="text" onclick="WdatePicker({minDate:'#F{$dp.$D(\'departTime\',{d:0});}'})"/></td>
	    	</tr>
	    	<tr style="height:50px;">
	    		<th>下一站门店</th>
	    		<td >
	    			<select name="next_store"  id="next_store" class="form-control" style="width:300px;display:inline;float:left;">
	    				<option selected="selected"></option>
	    			</select>
	    		</td>
	    		<td colspan="4"><span id="hintId" style="color: red;"></span></td>
	    	</tr>
	    </tbody>
    </table> 
  </fieldset>
	<div class="panel-group" id="appendContainer" style="width:100%;">
	<hr/>
	<div align="center"><h3>待装配订单表</h3></div>
	<hr/>
		 <table  id="checkChange"  style="height:200px;width:100%;text-align: center;" >
			<thead>
				<tr>
					<th><input type="checkbox" id="all">全选</th>
					<th width='50px'>订单号</th>
				    <th width='60px'>收货人</th>
				    <th width='180px'>收货人地址</th>
				    <th width='100px'>下单时间</th>
				    <th width='50px'>物品类型</th>
				    <th width='50px'>物品重量</th>
				    <th width='180px'>所在仓库</th>
				    <th width='80px'>物品备注</th>
				    <th width='60px'>物品状态</th>
				    <th>订单操作</th>
				 </tr>
			</thead>
			<tbody id="appendInfo">
				
			</tbody>
		</table>
	</div>
<div align="center">
	<input type="submit" class="btn btn-primary" style="width:100px;height:40px;margin-right:80px;" value="提交" >
</div>
</form>




  </body>
</html>
