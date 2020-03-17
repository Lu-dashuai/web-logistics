<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>取件派件信息</title>

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
	//取件。派件的按钮
	 function operation(val,row){
  	 	 	if(row.operation==1){
  	 	 		if(row.goods_status==6){
  	 	 		return '<input type="button" id="pick" disabled="disabled" value="取件" onclick="pick(\''+row.id+'\'")>丨<input type="button" value="派件" id="distribute" onclick="distribute(\''+row.id+'\')">丨<input type="button" value="拒件" id="refuse" onclick="refuse(\''+row.id+'\')">';
  	 	 		}else{
  	 	 		return '<input type="button" id="pick" value="取件" onclick="pick(\''+row.id+'\')">丨<input type="button" value="派件" disabled="disabled" id="distribute" onclick="distribute(\''+row.id+'\')">丨<input type="button" value="拒件" id="refuse" disabled="disabled" onclick="refuse(\''+row.id+'\')">';
  	 	 		}
  	 	 	}
  	 	 }
		//给单数字状态换成汉字状态
		function formatState(value,row,index){//val 当前列的值  row取当前行的值
	    	if (row.goods_status==20){
	    		return '<span style="color:red;">待取件</span>';
	    	} else{
	    		/* $("#pick").attr("disabled","disabled"); 这种不能把按钮变成失效的*/
	    		return '<span style="color:green;">待配送</span>';
	    	}
  	 	 }
  	 	 //取件按钮
		function pick(id){
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','取件人员选择');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load','distribute/get.do?id='+id);
				url = 'distribute/update.do?id='+id+'&operate=1';
		}
		//派件按钮
		function distribute(id){
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','派件人员选择');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load','distribute/get.do?id='+id);
				url = 'distribute/update.do?id='+id+'&operate=2';
		
		}
		 //拒件按钮
		function refuse(id){
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','拒件人员选择');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load','distribute/get.do?id='+id);
				url = 'distribute/update.do?id='+id+'&operate=3';
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
  	 	 //......................................
  	 	   //取件函数
  	 	/*  function pick(id){
  	 	   		//获取选中行
				var row = $('#tt').datagrid('getSelected');
  	 	  	$.messager.confirm('Confirm','确认取件吗?',function(r){
					if (r){
					//弹出框
					$('#dlg').dialog('open').dialog('setTitle','取件人员选择');
					//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
					$('#fm').form('load',row);
						$.post(
							'distribute/update.do',//地址
							{id:id,operate:1},//携带的参数
							function(result){
							if(result.suc=='true'){
								$("#pick").attr("disabled","disabled");//让取件按钮无效
								$('#tt').datagrid('reload');	// 更新父窗口
								$.messager.show({	// show error message
									title: '信息提示',
									msg: result.showInfo
									});
								}else {
								$.messager.show({	// show error message
									title: '错误提示',
									msg: result.showInfo
								});
							}
						},'json');
					}
  	 	  }
  	 	  }  */
  	 	   //派件按钮
  	 	  /*  function distribute(id){
  	 	   		 //获取选中行
				var row = $('#tt').datagrid('getSelected');
  	 	 	  
  	 	  	$.messager.confirm('Confirm','确认删除吗?',function(r){
					if (r){
						//弹出框
						$('#dlg').dialog('open').dialog('setTitle','派件人员选择');
						//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
						$('#fm').form('load',row);
						$.post(
							'distribute/update.do',//地址
							{id:id,operate:2},//携带的参数
							function(result){
							if(result.suc=='true'){
								$("#distribute").attr("disabled","disabled");//让取件按钮无效
								$('#tt').datagrid('reload');	// 更新父窗口
								$.messager.show({	// show error message
									title: '信息提示',
									msg: result.showInfo
									});
								}else {
								$.messager.show({	// show error message
									title: '错误提示',
									msg: result.showInfo
								});
							}
						},'json');
					}
  	 	  }
  	 	  }    */
		 //通过订单号查询方法
		 function doSearchByMailnum(){
		 //alert(1);
				$('#tt').datagrid('load',{
					order_mailnum: $('#order_mailnum').val()
				});
		 }  

	</script>
	</head>
	
	<body>
	<table id="tt" class="easyui-datagrid" title="配送订单列表"
		style="width:100%;height:560px" pagination="true" toolbar="#tb"
		data-options="singleSelect:true,collapsible:true,url:'distribute/page.do',method:'post'">
		<thead>
			<tr>
				<!-- hidden:true隐藏字段 sortable:true可以排序-->
				<th data-options="field:'id',width:80,hidden:true" >订单id</th>
				<th data-options="field:'order_mailnum',width:80,align:'center'">快递单号</th>
				<th data-options="field:'order_time',width:100,align:'center',sortable:true">订单时间</th>
				<th data-options="field:'accepter_name',width:80,align:'center'">收货人姓名</th>
				<th data-options="field:'accepter_phone',width:80,align:'center'">收货人电话</th>
				<th data-options="field:'accepter_adr',width:85,align:'center'">收货人地址</th>
				<th data-options="field:'goods_name',width:80,align:'center'">物品名称</th>
				<th data-options="field:'goods_type',width:80,align:'center'">物品类型</th>
				<th data-options="field:'goods_weight',width:80,align:'center'">物品重量</th>
				<th data-options="field:'goods_remarks',width:80,align:'center'">备注</th>
				<th data-options="field:'goods_status',width:80,align:'center'" formatter="formatState">物品状态</th>
				<th data-options="field:'operation',width:180,align:'center'" formatter="operation">操作</th>
			</tr>
		</thead>
	</table>
	
	<!-- 页面分状态查询功能 -->
	<div id="tb" style="padding:3px">
		<table>
				<tr>
					<td>
						<span>状态:</span>
					</td>
					<td>
						<select id="goods_status" style="line-height:26px;border:1px solid #ccc">
							<option value="待取件">待取件</option>
							<option value="待配送">待配送</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<span>快递单号:</span>
					</td>
					<td>
						<input id="order_mailnum" style="line-height:26px;border:1px solid #ccc">
						<a   class="easyui-linkbutton" plain="true" onclick="doSearchByMailnum()">查询</a>
					</td>
				</tr>
		</table>
	</div>
	
	     <!-- 弹出添加页面 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
		<div class="ftitle">人员选择</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>订单id：</label>
					<input name="id" id="dd" type="text"  class="easyui-validatebox">
				</div>
				<div class="fitem">
						<label>订单号:</label> 
						<input name="order_mailnum" id="ol" class="easyui-validatebox" required="required">
				</div>
				<div class="fitem">
						<label>物品名称:</label>
						<input name="goods_name" class="easyui-validatebox" >
				</div>
				 <div class="fitem">
					<label>人员选择:</label>
					<input class="easyui-combobox" name="ename" style="width:35%"
					data-options="
						url:'distribute/people.do',
						method:'get',
						valueField:'ename',
						textField:'ename',
						panelHeight:'auto'
					">
				</div>  
			</form>
	</div>
			<!-- 添加页面的保存按钮 -->	
	<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div> 
	<script type="text/javascript">
	 //查询下拉框
		// function doSearchByStatus(){ 
		$("#goods_status").change(function(){
			//获取option的值
			var s=$('#goods_status').val();
			if(s=='待取件'){
			 	$('#tt').datagrid('load',{
					goods_status: 6
				});
			}else if (s=='待配送'){
				$('#tt').datagrid('load',{
					goods_status: 20
				});
			}
			});
	</script>
	</body>
	</html>
