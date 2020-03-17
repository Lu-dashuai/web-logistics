<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色表</title>
    
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
     <table id="tt" class="easyui-datagrid"   title="员工信息列表列表" style="width:100%; "
			pagination="true" fitColumns="true" toolbar="#tb" iconCls="icon-more"  	data-options="singleSelect:true,collapsible:true,url:'emp/roleList.do',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'id',width:80,align:'center',sortable:true"  >序号</th>
					<th data-options="field:'role',width:100,align:'center'" sortable="true">名字</th>
					<th data-options="field:'description',width:80,align:'center'">性别</th>
				</tr>
			</thead>
		</table>
		<!--搜素，添加 ，删除，查询  -->
		<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="givePower()">授权</a>
			
			<br>
			<span>员工名:</span>
			<input id="ename" style="line-height:26px;border:1px solid #ccc">
			<span>用户名:</span>
			<input id="username" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
		</div>
		<!--更新，添加框  -->
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
			<div class="ftitle">员工信息</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>id:</label>
					<input name="id" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>角色:</label>
					<input name="role" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>角色描述:</label>
					<input name="description" class="easyui-validatebox">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		
		<!--...................................................  -->
		
		<div id="dlga" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px;top:50px;"
		closed="true"  buttons="#dlg-buttonsa">
			<form id="fma" method="post">
				<div class="fitem">
					<label>角色名:</label>
					<input name="role" class="easyui-validatebox" required="true">
					 <input name="id" type="hidden">
					 <input id="powerIds" name="powerIds" type="hidden">
				</div>
				<div class="fitem">
					<label>权限选择:</label>
				  <div class="easyui-panel" style="padding:5px">
					  <ul id="ttree" class="easyui-tree" data-options="method:'get',animate:true,checkbox:true"></ul>
				  </div>
				 
				</div>
				
			</form>
		</div>
		<div id="dlg-buttonsa">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRoleAndPowers()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlga').dialog('close')">取消</a>
		</div>
		
		
		<script>
		 //弹出授权框
		function givePower(){
		  var row = $('#tt').datagrid('getSelected');
		  
			if (row){
		          //动态给树添加url
				  $("#ttree").tree({
				      url:'power/checkedTree.do?roleId='+row.id
				     //url:'jsp/role/tree_data1.json'
				  });
			  
			 	$('#fma').form('clear');
			 		//$('#ttree').tree('clear');
			   	$('#dlga').dialog('open').dialog('setTitle','授权');
			   	$('#fma').form('load',row);
		   	}else{
		   	   $.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: '请至少选中一行！！！'//提示信息
				 });
		   	}
		 }
		 //保存授权
		 function saveRoleAndPowers(){
		        //获取选中的所有节点
			    var nodes = $('#ttree').tree('getChecked');
				var s = '';
				//循环每一个节点
				for(var i=0; i<nodes.length; i++){
					if (s != '') s += ',';
					s += nodes[i].id;
				}
				//赋值，目的向服务器传送数据
				$("#powerIds").val(s);
				//alert(s);
				//提交form表单
				$('#fma').form('submit',{//给form表单绑定submit事件
						url: "emp/saveRoleAndPower.do",//请求的url地址
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
									$('#dlga').dialog('close');		// 关闭弹出框
									$('#tt').datagrid('reload');	// 刷新父窗口
								}
							//}
						}
			    });
		 }
		 
		 /*.....................................  */
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					ename: $('#ename').val(),
					username: $('#username').val()
				});
		 }
		 //弹出添加方法
		 function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','添加用户');
			$('#fm').form('clear');
			url = 'emp/add.do';
		}
		//弹出更新方法
		function editUser(){
		   //获取选中行
		   var row = $('#tt').datagrid('getSelected');
			if (row){
			  //alert(row.ename);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','更新车辆');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				//alert("111");
				$('#fm').form('load',row);
				//alert("222");
				url = 'emp/update.do?id='+row.id;
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
						$.post('emp/delete.do',{id:row.id},function(result){
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
		</script>
  </body>
</html>
