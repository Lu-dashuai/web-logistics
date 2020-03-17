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

<title>异常单信息</title>

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
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					order_mailnum: $('#order_mailnum').val()
				});
		 }
		 //弹出添加方法
		 function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','添加异常订单');
			$('#fm').form('clear');
			url = 'wrong/add.do';
		}
		//弹出更新方法
		function editUser(){
		   //获取选中行
		   var row = $('#tt').datagrid('getSelected');
		   <%-- <% request.getAttribute("id");%> 可以放java代码--%>
			if (row){
			  // alert(row.id);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','更新异常订单');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load',row);
				url = 'wrong/update.do?id='+row.id;
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
						$.post('wrong/delete.do',{id:row.id},function(result){
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
		//格式化函数
	    function   caozuo(val,row){ //val 当前列的值  row取当前行的值可以用row.字段名得到值

	       if(val==1){
	         return '<input type="button" value="增加"><input type="button" value="修改"><input type="button" value="删除">';
	       }else{
	          return '<span style="color:red;">离职</span>';
	       }
	    }
	    //格式化异常类型
		 function   type(val,row){ //val 当前列的值  row取当前行的值可以用row.字段名得到值

	       if(val==1){
	         return '<span style="color:blue;">物品破损</span>';
	       }else if(val==2){
	          return '<span style="color:blue;">物品丢失</span>';
	       }else if(val==3){
	          return '<span style="color:blue;">延期到达</span>';
	       }else if(val==4){
	          return '<span style="color:blue;">其他</span>';
	       }
	    }
	    //格式化异常状态
	     function   satus(val,row){ //val 当前列的值  row取当前行的值可以用row.字段名得到值

	        if(val==1){
	         return '<span style="color:blue;">未审核</span>';
	       }else if(val==2){
	          return '<span style="color:blue;">待赔付</span>';
	       }else if(val==3){
	          return '<span style="color:blue;">已赔付</span>';
	       }else if(val==4){
	          return '<span style="color:blue;">未通过</span>';
	       }
	    }
	     //格式化是否保价
	     function   ifsupportvalue(val,row){ //val 当前列的值  row取当前行的值可以用row.字段名得到值

	        if(val==1){
	         return '<span style="color:blue;">是</span>';
	       }else if(val==2){
	          return '<span style="color:red;">否</span>';
	       }
	    }
	    //正则表达式
	    $.extend($.fn.validatebox.defaults.rules, { 
    onlyNum:{
        validator:function(value,param){
            var reg = /^\d+$/g;
            return reg.test(value);
        },
        message:  '只能输入数字！'
    }
});
	    
		</script>
</head>
<body>
	<table id="tt" class="easyui-datagrid" title="异常单列表" style="width:100%;height:100%;"
		 pagination="true" toolbar="#tb"
		data-options="singleSelect:true,collapsible:true,url:'wrong/page.do',method:'post'">
		<thead>
			<tr>
				<!-- hidden:true隐藏字段 sortable:true可以排序-->
				<th data-options="field:'id',width:80,hidden:true" >订单id</th>
				<th data-options="field:'order_time',width:100,align:'center',sortable:true">订单时间</th>
				<th data-options="field:'order_mailnum',width:100,align:'center',sortable:true">快递单号</th>
				<th data-options="field:'sender_name',width:80,align:'center'">发货人姓名</th>
				<th data-options="field:'sender_phone',width:150,align:'center'">发货人电话</th>
				<th data-options="field:'goods_name',width:150,align:'center'">物品名称</th>
				<th data-options="field:'goods_type',width:80,align:'center'">物品类型</th>
				<th data-options="field:'goods_ifsupportvalue',width:80,align:'center'" formatter="ifsupportvalue">是否保价</th>
				<th data-options="field:'goods_cost',width:80,align:'center'">运费总额</th>
				<th data-options="field:'goods_supportvalue',width:80,align:'center'">保价总额</th>
				<th data-options="field:'wrongorder_satus',width:80,align:'center'"formatter="satus">异常状态</th>
				<th data-options="field:'wrongorder_type',width:80,align:'center'"formatter="type">异常类型</th>
				<th data-options="field:'badpay',width:80,align:'center'">赔付金额</th>
				<th data-options="field:'operation',width:150,align:'center'" formatter="caozuo">操作</th>
			</tr>
		</thead>
	</table>
	
	
	<!-- 页面查询功能 -->
	<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
			<a   class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
			<a   class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			<br>
			<span>快递单号:</span>
			<input id="order_mailnum" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	
	
	
	    	<!-- 弹出添加页面 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
			<div class="ftitle">异常订单信息</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>订单时间：</label>
					<input name="order_time" id="dd" type="text" class="easyui-datebox" required="required">
				</div>
				<div class="fitem">
					<label>发货人姓名：</label>
					<input name="sender_name" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>发货人电话:</label>
					<input name="sender_phone" class="easyui-validatebox" required="true" validType="onlyNum">
				</div>
				<div class="fitem">
					<label>是否保价:</label>
					<input name="goods_ifsupportvalue" class="easyui-validatebox"type="radio" value="1">是
					<input name="goods_ifsupportvalue" class="easyui-validatebox"type="radio" value="2">否
				</div>
				<div class="fitem">
					<label>保价金额:</label>
					<input name="goods_supportvalue" class="easyui-validatebox" validType="onlyNum" >
				</div>
				<div class="fitem">
					<label>运费总额:</label>
					<input name="goods_cost" class="easyui-validatebox"  validType="onlyNum" >
				</div>
				<div class="fitem">
					<label>物品名称:</label>
					<input name="goods_name" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>物品类型:</label>
					<input name="goods_type" class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>快递费用:</label>
					<input name="goods_cost" class="easyui-validatebox" validType="onlyNum" >
				</div>
				<div class="fitem">
					<label>异常状态:</label>
					<input class="easyui-combobox" name="wrongorder_satus" style="width:30%"
					data-options="
						url:'wrong/page1.do?caocuo=1',
						method:'get',
						valueField:'id',
						textField:'wrongorder_satus',
						panelHeight:'auto'
					">
				</div>
				<div class="fitem">
					<label>异常类型:</label>
					<!-- 必须返回List类型的json  -->
					<input class="easyui-combobox" name="wrongorder_type" style="width:30%"
					data-options="
						url:'wrong/page1.do?page=1&rows=100',
						method:'get',
						valueField:'id',
						textField:'wrongorder_type',
						panelHeight:'auto'
					">
				</div>
				<div class="fitem">
					<label>赔付金额:</label>
					<input name="badpay" class="easyui-validatebox" validType="onlyNum" >
				</div>
			</form>
	</div>
	<!-- 添加页面的保存按钮 -->		
	<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</html>
