<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看车辆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

  </head>
  
  <body>
     <table id="tt" class="easyui-datagrid"   title="车辆分页列表" style="width:100%;height:100%;"
			pagination="true" fitColumns="true" toolbar="#tb" iconCls="icon-more"  	data-options="singleSelect:true,collapsible:true,url:'car/page.do',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'id',width:80,align:'center',sortable:true"  >序号</th>
					<th data-options="field:'store',width:100,align:'center'" sortable="true">所属门店</th>
					<th data-options="field:'driver',width:80,align:'center'">司机</th>
					<th data-options="field:'type',width:80,align:'center'" sortable="true">车型</th>
					<th data-options="field:'number',width:250,align:'center'">车牌号</th>
					<th data-options="field:'color',width:60,align:'center'">车辆颜色</th>
					<th data-options="field:'volume',width:60,align:'center'">车辆体积</th>
					<th data-options="field:'capacity',width:60,align:'center'">车辆载重</th>
					<th data-options="field:'state',width:60,align:'center'" formatter="caozuo">车辆状态</th>
				</tr>
			</thead>
		</table>
		<!--搜素，添加 ，删除，查询  -->
		<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
			<a   class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
			<a   class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			<br>
			<span>司机名:</span>
			<input id="driver" style="line-height:26px;border:1px solid #ccc">
			<span>车牌号:</span>
			<input id="number" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
		</div>
		<!--更新，添加框  -->
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
			<div class="ftitle">用户信息</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>id:</label>
					<input name="id" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>所属门店:</label>
					<input name="store" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>司机:</label>
					<input name="driver" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>车型:</label>
					<input name="type" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>车牌号:</label>
					<input name="number" class="easyui-validatebox"  >
				</div>
				<div class="fitem">
					<label>车辆颜色:</label>
					<input name="color" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>车辆体积:</label>
					<input name="volume" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>车辆载重:</label>
					<input name="capacity" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>车辆状态:</label>
					<select class="easyui-combobox" name="state" style="width:100px;">
						<option value="1">空闲</option>
						<option value="2">在途</option>
						<option value="3">损坏</option>
					</select>
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		<script>
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					driver: $('#driver').val(),
					number: $('#number').val()
				});
		 }
		 //弹出添加方法
		 function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','添加用户');
			$('#fm').form('clear');
			url = 'car/add.do';
		}
		//弹出更新方法
		function editUser(){
		   //获取选中行
		   var row = $('#tt').datagrid('getSelected');
			if (row){
			  // alert(row.id);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','更新车辆');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load',row);
				url = 'car/update.do?id='+row.id;
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
				onSubmit: function(){//对form表单校验。把数据传过去
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
						$.post('car/delete.do',{id:row.id},function(result){
							if (result.success){
							  //  alert(1111);
								$('#tt').datagrid('reload');	// 更新父窗口
							} else {
								$.messager.show({	// show error message
									title: '错误提示',
									msg: result.errorMsg
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
		function caozuo(val,row){
			if(val==1){
				return '<span style="color:green;">空闲</span>';
			}else if(val==2){
				return '<span style="color:red;">在途</span>';
			}
			else{
				return '<span style="color:yellow;">损坏</span>';
			}
		}
		</script>
  </body>
</html>
