<%@page import="com.aaa.mvc.util.RandomCount"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加订单页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

		<script type="text/javascript">
		//通过收货人手机号查询方法
		  function doSearchByPhone(){
				$('#tt').datagrid('load',{
					accepter_phone: $('#accepter_phone').val()
				});
		 }
		 //通过订单号查询方法
		 function doSearchByMailnum(){
				$('#tt').datagrid('load',{
					order_mailnum: $('#order_mailnum').val()
				});
		 }
		 //弹出添加方法
		 <%!String codeNum = RandomCount.getOrderIdByTime(); %>
		 function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','添加订单');
			$('#fm').form('clear');
			$('#goodsStatus').val(2);
			$('#ol').textbox('setValue','<%=codeNum%>');
			$('#ol').textbox('textbox').attr('readonly',true);
			url = 'order/add.do';
			$.post(
 			//url
 			"order/getUserState.do",
 			//不携带参数
 			//回调函数
 			function(date){
 				//alert(date.store);
 				$('#stores').val(date.store);//获得当前门店   河南省郑州市
 			},
 			//数据类型
 			"json"
 		);
		}


	 //2三级联动2.1
  	$(function(){
		//alert("111");
		var str="";
       	$.post(
 			//url
 			"getArr/getP.do",//获得所有省
 			//不携带参数
 			//回调函数
 			function(data){
 				if(data!=''){
 					for(var i = 0;i<data.length;i++){
	 					str += "<option  value = '"+data[i].code+"'>"+data[i].name+"</option>";	
 					}
 					//$("#province").val(data[0].name);
 					//收货人地址   province2 发货人地址   province  目的地门店   province1
 					$("#province2").append(str);//在select里面拼接option
 				}
 			},
 			//数据类型
 			"json"
 		);
		
		
		getCitys2("100");//设置默认市	
		
		getArea2("1001");//设置默认市
					
		//给province添加一个change事件
	  	$("#province2").change(function(){
			var arr="";
	  		//获取province的值
	  		var provinceId = $("#province2").val();
			getCitys2(provinceId);  	
			arr = $("#province2").find("option:selected").text();
			$("#address2").val(arr);	
	  	});	
			
	
	 		//给city添加一个change事件
	  	$("#city2").change(function(){
	  		var arr="";
	  		//获取cityId的值
	  		var cityId = $("#city2").val();
	  		getArea2(cityId);
	  		arr =  $("#province2").find("option:selected").text()+$("#city2").find("option:selected").text();
			$("#address2").val(arr);	
	  	});
	  	
	  	//给area添加一个change事件
	  	$("#area2").change(function(){
	  		var arr="";
	  		arr =  $("#province2").find("option:selected").text()+$("#city2").find("option:selected").text()+$("#area2").find("option:selected").text();
			$("#address2").val(arr);	
	  	});
	  	
	});
  	
  //封装 	2.2
  	 function getCitys2(provinceId){
  	 	$.post(
  	  			//跳转servlet
  	  			"getArr/getC.do",//获取该省份下的所有市
  	  			//携带参数
  	  			{provinceId:provinceId},
  	  			//回调函数
  	  			function(data){
  			  		var str = "";
  	  				if(data!=''){
  	  					$("#city2").empty();//先将市清空
  	  					$("#area2").empty();//先将市清空
  	  					
  	  					for(var i = 0;i<data.length;i++){
  	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
  	  					}
  	  					$("#city2").append(str);//拼接市的option
  	  				}
  	  			},
  	  			//返回的数据类型
  	  			"json"
  	  		);
  	 }	
  	  		//2.3
  	 function getArea2(cityId){
  	 	$.post(
  	  			//跳转servlet
  	  			"getArr/getA.do",//根据市id获取该市下的所有县
  	  			//携带参数
  	  			{cityId:cityId},
  	  			//回调函数
  	  			function(data){
  			  		var str = "";
  	  				if(data!=''){
  	  					$("#area2").empty();//先清空县
  	  					for(var i = 0;i<data.length;i++){//拼接所有的县选项
  	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
  	  					}
  	  					$("#area2").append(str);
  	  					getArea2(data[0].name);//默认县为该市下的第一个县
  	  				}
  	  			},
  	  			//返回的数据类型
  	  			"json"
  	  		);
  	 } 
		//弹出更新方法
		function editUser(){
		   //获取选中行
		   var row = $('#tt').datagrid('getSelected');
			if (row){
			  // alert(row.id);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','更新用户');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load',row);
				url = 'order/update.do?id='+row.id;
			}else{
			     $.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: '请至少选中一行！！！'//提示信息
				 });
			}
		}
		//保存操作(添加和保存使用的一个方法)
		function saveUser(){
			$('#fm').form('submit',{//给form表单绑定submit事件
				url: url,//请求的url地址
				onSubmit: function(){//对form表单校验
					return $(this).form('validate');
				},
				success: function(result){//数据保存后的回调函数
					var result = eval('('+result+')');//eval把json字符串转换为json对象  {'errorMsg':'添加失败'}
					 //alert(result.errorMsg);
					//if (result.errorMsg){//判断，如果错误信息不为空  js非null 非0 即true
						$.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: result.showInfo//提示信息
						});
					//} else {
					   if(result.suc=='true'){
							$('#dlg').dialog('close');		// 关闭弹出框
							$('#tt').datagrid('reload');	// 刷新父窗口
						}
					//}
				}
			});
		}
		//删除数据
		function destroyUser(){
		    //获取选中行
			var row = $('#tt').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','确认删除吗?',function(r){
					if (r){
					   //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('order/delete.do',{id:row.id},function(result){
							if (result.suc=='true'){
							  //  alert(1111);
								$('#tt').datagrid('reload');	// 更新父窗口
								$.messager.show({	// show error message
									title: '信息提示',
									msg: result.showInfo
								});
							} else {
								$.messager.show({	// show error message
									title: '错误提示',
									msg: result.showInfo
								});
							}
						},'json');
					}
				});
			}else{
			   $.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: '请至少选中一行！！！'//提示信息
				 });
			}
		}
		//给单数字状态换成汉字状态
		function formatState(value,row,index){//val 当前列的值  row取当前行的值
	    	if (row.goods_status==1){
	    		return '<span style="color:red;">待审核</span>';
	    	} else if (row.goods_status==2){
	    		return '<span style="color:blue;">审核通过</span>';
	    	} else if (row.goods_status==3){
	    		return '<span style="color:blue;">入库</span>';
	    	} else if (row.goods_status==4){
	    		return '<span style="color:blue;">装配</span>';
	    	} else if (row.goods_status==5){
	    		return '<span style="color:blue;">出库</span>';
	    	} else if (row.goods_status==6){
	    		return '<span style="color:red;">目的地站</span>';
	    	} else if (row.goods_status==6){
	    		return '<span style="color:red;">已签收</span>';
	    	}  
  	 	 } 
  	 	 $('#cc').combo({    
		    required:true,    
		    multiple:true   
		});
		//添加序号列
		$(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('序号')
        })
  		
  		
  	</script>
<script type="text/javascript" src="js/zhengze.js"></script>
<script type="text/javascript">
 	 //0三级联动0.1
  	$(function(){
		//alert("111");
		var str="";
       	$.post(
 			//url
 			"getArr/getP.do",
 			//不携带参数
 			//回调函数
	 			function(data){
 				if(data!=''){
 					for(var i = 0;i<data.length;i++){
	 					str += "<option  value = '"+data[i].code+"'>"+data[i].name+"</option>";	
 					}
 					//$("#province").val(data[0].name);
 					$("#province").append(str);
 				}
 			},
 			//数据类型
 			"json"
 		);
		
		
		//getCitys("100");	
		
		//getArea("1001");
					
		//给province添加一个change事件
	  	$("#province").change(function(){
			var arr="";
	  		//获取province的值
	  		var provinceId = $("#province").val();
			getCitys(provinceId);  	
			arr = $("#province").find("option:selected").text();
			$("#address").val(arr);	
	  	});	
			
	
	 		//给city添加一个change事件
	  	$("#city").change(function(){
	  		var arr="";
	  		//获取cityId的值
	  		var cityId = $("#city").val();
	  		getArea(cityId);
	  		arr =  $("#province").find("option:selected").text()+$("#city").find("option:selected").text();
			$("#address").val(arr);	
	  	});
	  	
	  	//给area添加一个change事件
	  	$("#area").change(function(){
	  		var arr="";
	  		arr =  $("#province").find("option:selected").text()+$("#city").find("option:selected").text()+$("#area").find("option:selected").text();
			$("#address").val(arr);	
	  	});
	  	
	});
  //封装 	0.2
  	 function getCitys(provinceId){
  	 	$.post(
  	  			//跳转servlet
  	  			"getArr/getC.do",
  	  			//携带参数
  	  			{provinceId:provinceId},
  	  			//回调函数
  	  			function(data){
  			  		var str = "";
  	  				if(data!=''){
  	  					$("#city").empty();
  	  					for(var i = 0;i<data.length;i++){
  	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
  	  					}
  	  					$("#city").append(str);
  	  				}
  	  			},
  	  			//返回的数据类型
  	  			"json"
  	  		);
  	 }	
  	 //0.3	
  	 function getArea(cityId){
  	 	$.post(
  	  			//跳转servlet
  	  			"getArr/getA.do",
  	  			//携带参数
  	  			{cityId:cityId},
  	  			//回调函数
  	  			function(data){
  			  		var str = "";
  	  				if(data!=''){
  	  					$("#area").empty();
  	  					for(var i = 0;i<data.length;i++){
  	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
  	  					}
  	  					$("#area").append(str);
  	  					getArea(data[0].name);
  	  				}
  	  			},
  	  			//返回的数据类型
  	  			"json"
  	  		);
  	 } 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	  //1三级联动
   	$(function(){
 		//alert("111");
 		var str="";
        	$.post(
  			//url
  			"getArr/getP.do",
  			//不携带参数
  			//回调函数
  			function(data){
  				if(data!=''){
  					for(var i = 0;i<data.length;i++){
 	 					str += "<option  value = '"+data[i].code+"'>"+data[i].name+"</option>";	
  					}
  					//$("#province").val(data[0].name);
  					$("#province1").append(str);
  				}
  			},
  			//数据类型
  			"json"
  		);
 		
 		
 		getCitys1("100");	
 		
 		getArea1("1001");
 					
 		//给province添加一个change事件
 	  	$("#province1").change(function(){
 			var arr="";
 	  		//获取province的值
 	  		var provinceId = $("#province1").val();
 			getCitys1(provinceId);  	//找到该省下的所有市
 			arr = $("#province1").find("option:selected").text();//如果省变了  得到选中的省
 			$("#address1").val(arr);	//给总的地址进行拼接
 	  	});	
 			
 	
 	 		//给city添加一个change事件
 	  	$("#city1").change(function(){
 	  		var arr="";
 	  		//获取cityId的值
 	  		var cityId = $("#city1").val();
 	  		getArea1(cityId);//找到该市下的所有县
 	  		arr =  $("#province1").find("option:selected").text()+$("#city1").find("option:selected").text();//如果市变了  得到选中的省市
 			$("#address1").val(arr);	//拼接总地址
 	  	});
 	  	
 	  	//给area添加一个change事件
 	  	$("#area1").change(function(){
 	  		var arr="";
 	  		arr =  $("#province1").find("option:selected").text()+$("#city1").find("option:selected").text()+$("#area1").find("option:selected").text();//如果县变了 得到选中的省市县
 			$("#address1").val(arr);	//拼接到总的地址里
 	  	});
 	  	
 	});
   	
   //封装 	
   	 function getCitys1(provinceId){
   	 	$.post(
   	  			//跳转servlet
   	  			"getArr/getC.do",
   	  			//携带参数
   	  			{provinceId:provinceId},
   	  			//回调函数
   	  			function(data){
   			  		var str = "";
   	  				if(data!=''){
   	  					$("#city1").empty();
   	  					for(var i = 0;i<data.length;i++){
   	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
   	  					}
   	  					$("#city1").append(str);
   	  				}
   	  			},
   	  			//返回的数据类型
   	  			"json"
   	  		);
   	 }	
   	  		
   	 function getArea1(cityId){
   	 	$.post(
   	  			//跳转servlet
   	  			"getArr/getA.do",
   	  			//携带参数
   	  			{cityId:cityId},
   	  			//回调函数
   	  			function(data){
   			  		var str = "";
   	  				if(data!=''){
   	  					$("#area1").empty();
   	  					for(var i = 0;i<data.length;i++){
   	  						str += "<option value = '"+data[i].code+"'>"+data[i].name+"</option>";
   	  					}
   	  					$("#area1").append(str);
   	  					getArea1(data[0].name);
   	  				}
   	  			},
   	  			//返回的数据类型
   	  			"json"
   	  		);
   	 } 
 
</script>
</head>

<body>
	<!-- 当页面加载时显示的页面 -->
	<table id="tt" class="easyui-datagrid" title="订单列表"
		style="width:100%;height:560px" pagination="true" toolbar="#tb"
		data-options="singleSelect:true,collapsible:true,url:'order/page.do?status2=2',method:'post'">
		<thead>
			<tr>
				<!-- hidden:true隐藏字段 sortable:true可以排序-->
				<th data-options="field:'id',width:80,hidden:true" >订单id</th>
				<th data-options="field:'order_mailnum',width:80,align:'center'">订单号</th>
				<th data-options="field:'order_time',width:100,align:'center',sortable:true">订单时间</th>
				<th data-options="field:'sender_name',width:80,align:'center'">发货人姓名</th>
				<th data-options="field:'sender_phone',width:80,align:'center'" >发货人电话</th>
				<th data-options="field:'sender_adr',width:85,align:'center'" >发货人地址</th>
				<th data-options="field:'accepter_name',width:80,align:'center'">收货人姓名</th>
				<th data-options="field:'accepter_phone',width:80,align:'center'">收货人电话</th>
				<th data-options="field:'accepter_adr',width:85,align:'center'" >收货人地址</th>
				<th data-options="field:'accepter_zipcode',width:50,align:'center'">邮编</th>
				<th data-options="field:'goods_name',width:80,align:'center'">物品名称</th>
				<th data-options="field:'goods_type',width:80,align:'center'">物品类型</th>
				<th data-options="field:'goods_weight',width:80,align:'center'">物品重量（Kg）</th>
				<th data-options="field:'goods_remarks',width:80,align:'center'">备注</th>
				<th data-options="field:'goods_status',width:80,align:'center'" formatter="formatState">物品状态</th>
				<th data-options="field:'goods_value',width:80,align:'center'">物品价值（元）</th>
				<th data-options="field:'goods_supportvalue',width:80,align:'center'">保价金额（元）</th>
				<th data-options="field:'goods_ifsupportvalue',width:80,align:'center'">是否保价</th>
				<th data-options="field:'goods_cost',width:80,align:'center'">运输费用（元）</th>
				<th data-options="field:'cost_type',width:80,align:'center'">支付方式</th>
				<th data-options="field:'order_now_store',width:80,align:'center'">所在门店</th>
				<th data-options="field:'over_store',width:80,align:'center'">目的地门店</th>
			</tr>
		</thead>
	</table>
	
	
	<!-- 页面增删改查功能 -->
	<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
			<a   class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
			<a   class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			<br>
			<table>
				<tr>
					<td>
						<span>收货人手机号:</span>
					</td>
					<td>
						<input id="accepter_phone" style="line-height:26px;border:1px solid #ccc">
						<a   class="easyui-linkbutton" plain="true" onclick="doSearchByPhone()">查询</a>
					</td>
				</tr>
				<tr>
					<td>
						<span>订单号:</span>
					</td>
					<td>
						<input id="order_mailnum" style="line-height:26px;border:1px solid #ccc">
						<a   class="easyui-linkbutton" plain="true" onclick="doSearchByMailnum()">查询</a>
					</td>
				</tr>
			</table>
	</div>
	
	
	
	    	<!-- 弹出添加更改页面 -->
	 	<!-- 弹出添加更改页面 -->
	<div id="dlg" class="easyui-dialog" style="width:800px;height:600px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<form id="fm" method="post">
			<table>
				<tr>
					<td class="fitem">
						<label>所在门店:</label>
						<input id='stores' name="order_now_store" readonly="readonly"  required="required"  >
					</td>
					
					<td class="fitem">
						<label>订单时间:</label>
						<input name="order_time" id="dd" type="text" class="easyui-datebox" required="required">
					</td>
					<td class="fitem">
						<label>订单号:</label><!-- class="easyui-validatebox" -->
						<%!String orderNum = RandomCount.getOrderIdByTime(); %>
						<input name="order_mailnum" id="ol" class="easyui-textbox" style="width:180px;height:30px" validType="OrderNumber" value="<%=orderNum%>">
					</td>
					<td><span id="mailnumInfo"></span></td>
				</tr>
				<tr>
					<td class="fitem">
						<label>发货人姓名：</label>
						<input name="sender_name" required="required" class="easyui-textbox" >
					</td>
					<td class="fitem">
						<label>发货人电话：</label>
						<input name="sender_phone" required="required" class="easyui-textbox" validType="phone">
					</td>
				</tr>
				<tr><td>发货人地址:</td></tr>
				<tr>
					<td><select id="province" style="width:150px;height:30px"></select></td> 
					<td><select id="city" style="width:150px;height:30px"></select></td>
					<td><select id="area" style="width:150px;height:30px"></select></td>
					<td class="fitem">
						<input name="sender_adr" id="address" class="easyui-validatebox" style="width:180px;height:30px" required="required" >
					</td>
				</tr>
				<tr>					
					
					<td></td>
				</tr>
				<tr>
					<td class="fitem">
						<label>收货人姓名:</label>
						<input name="accepter_name" required="required" class="easyui-textbox"  >
					</td>
					<td class="fitem">
						<label>收货人电话:</label>
						<input name="accepter_phone" required="required" class="easyui-textbox" validType="phone">
					</td>
				</tr>
				<!-- 收货人地址   province2 发货人地址   province  目的地门店   province1 -->
				<tr><td>收货人地址:</td></tr>
				<tr>
					<td><select id="province2" style="width:150px;height:30px"></select></td> 
					<td><select id="city2" style="width:150px;height:30px"></select></td>
					<td><select id="area2" style="width:150px;height:30px"></select></td>
					<td class="fitem">
						<input type="text" name="accepter_adr" required="required" id="address2" class="easyui-validatebox" style="width:180px;height:30px">
					</td>
				</tr>
				<tr>
					<td class="fitem">
						<label>邮编:</label>
						<input name="accepter_zipcode" class="easyui-textbox" validType="zipcode">
					</td>
					<td class="fitem">
						<label>物品名称:</label>
						<input name="goods_name" class="easyui-textbox" >
					</td>
					<td class="fitem">
						<label>物品类型:</label>
						<!-- <input name="goods_type" class="easyui-combobox" data-options="
							url:'order/adr.do',
							method:'get',
							valueField:'goods_type',
							textField:'goods_type',
							panelHeight:'auto'
						"> -->
					    <select id="cc" class="easyui-combobox" name="goods_type" style="width:150px;">
					        <option value="衣服">衣服</option>
					        <option>食品</option>
					        <option>数码</option>
					        <option>饰品</option>
					        <option>其他</option>
					    </select>
					</td>
					<td class="fitem">
						<label>物品重量（Kg）:</label>
						<input name="goods_weight" class="easyui-textbox" validType="weight">
					</td>
				</tr>
				<tr>
					<td class="fitem">
						<label>备注:</label>
						<!-- <input name="goods_remarks" class="easyui-combobox" data-options="
							url:'order/adr.do',
							method:'get',
							valueField:'goods_remarks',
							textField:'goods_remarks',
							panelHeight:'auto'
						"> -->
						<select id="cc" class="easyui-combobox" name="goods_remarks" style="width:150px;">
					        <option value="防压防挤">防压防挤</option>
					        <option>防水防潮</option>
					        <option>添加填充物</option>
					        <option>其他</option>
					    </select>
					</td>
					<!-- <td class="fitem">
						<label>物品状态:</label>
						<input name="goods_status" class="easyui-validatebox" >
					</td> -->
					<input name="goods_status" id="goodsStatus" class="easyui-validatebox" type="hidden">
					<td class="fitem">
						<label>物品价值（元）:</label>
						<input name="goods_value" class="easyui-textbox" validType="value">
					</td>
					<td class="fitem">
						<label>保价金额（元）:</label>
						<input name="goods_supportvalue" class="easyui-textbox" validType="supportvalue">
					</td>
					<td class="fitem">
						<label>是否保价:</label>
			                <input type="radio" name="goods_ifsupportvalue" value="0">否</input>
			                <input type="radio" name="goods_ifsupportvalue" value="1">是</input>          
			        </td>
				</tr>
				<tr>
					<td class="fitem">
						<label>费用（元）:</label>
						<input name="goods_cost" class="easyui-textbox" validType="cost">
					</td>
					<td class="fitem">
						<label>支付方式:</label>
						<select id="cc" class="easyui-combobox" name="cost_type" style="width:150px;">
					        <option value="网上付款">网上付款</option>
					        <option>现金支付</option>
					        <option>邮寄到付</option>
					    </select>
					</td>
					<tr>
						<td class="fitem">
							<label>目的地门店:</label>
					</tr>
					<tr>
						<td><select id="province1" style="width:150px;height:30px"></select></td> 
						<td><select id="city1" style="width:150px;height:30px"></select></td>
						<td><select id="area1" style="width:150px;height:30px"></select></td>
					</tr>
					<tr>
						<td>
							<input name="over_store" id="address1" class="easyui-validatebox" style="width:180px;height:30px" required="required" >
						</td>
					</tr>
			</table>
		</form>
	</div>
	<!-- 添加页面的保存按钮 -->	
	<!-- 添加页面的保存按钮 -->		
	<div id="dlg-buttons">
			<a  id="sbt" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</html>
