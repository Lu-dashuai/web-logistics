<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>前台订单</title>
    
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
	    	} else if (row.goods_status==66){
	    		return '<span style="color:red;">退单</span>';
	    	} 
  	 	 } 
  	 	 
  	 	 //弹出更新方法
		function overStoreOrder(){
			var row = $('#tt').datagrid('getSelected');
		   //获取选中行
			if (row){
			  	//alert(row.id);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','添加目的地门店');
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
	</script>
  <script type="text/javascript" src="js/sanjiliandong.js"></script></head>
  
  <body>
  	<!-- 订单审核页面 -->
    <table id="tt" class="easyui-datagrid" title="前台订单"
		style="width:100%;height:560px" pagination="true" toolbar="#tb"
		data-options="singleSelect:true,collapsible:true,url:'order/page.do?status1=1&overStore1=1',method:'get'">
		<thead>
			<tr>
				<!-- hidden:true隐藏字段 sortable:true可以排序-->
				<th data-options="field:'id',width:80,hidden:true" >订单id</th>
				<th data-options="field:'order_mailnum',width:80,align:'center'">订单号</th>
				<th data-options="field:'order_time',width:100,align:'center',sortable:true">订单时间</th>
				<th data-options="field:'sender_name',width:80,align:'center'">发货人姓名</th>
				<th data-options="field:'sender_phone',width:80,align:'center'">发货人电话</th>
				<th data-options="field:'sender_adr',width:85,align:'center'">发货人地址</th>
				<th data-options="field:'accepter_name',width:80,align:'center'">收货人姓名</th>
				<th data-options="field:'accepter_phone',width:80,align:'center'">收货人电话</th>
				<th data-options="field:'accepter_adr',width:85,align:'center'">收货人地址</th>
				<th data-options="field:'accepter_zipcode',width:50,align:'center'">邮编</th>
				<th data-options="field:'goods_name',width:80,align:'center'">物品名称</th>
				<th data-options="field:'goods_type',width:80,align:'center'">物品类型</th>
				<th data-options="field:'goods_weight',width:80,align:'center'">物品重量</th>
				<th data-options="field:'goods_remarks',width:80,align:'center'">备注</th>
				<th data-options="field:'goods_status',width:80,align:'center'" formatter="formatState">物品状态</th>
				<th data-options="field:'goods_value',width:80,align:'center'">物品价值</th>
				<th data-options="field:'goods_supportvalue',width:80,align:'center'">保价金额</th>
				<th data-options="field:'goods_ifsupportvalue',width:80,align:'center'">是否保价</th>
				<th data-options="field:'goods_cost',width:80,align:'center'">费用</th>
				<th data-options="field:'cost_type',width:80,align:'center'">支付方式</th>
				<th data-options="field:'order_now_store',width:80,align:'center'">所在门店</th>
				<th data-options="field:'over_store',width:80,align:'center'">目的地门店</th>
			</tr>
		</thead>
	</table>
	
	
	<!-- 通过退单操作 -->
	<div id="tb" style="padding:3px">
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="overStoreOrder()">添加目的地</a>
	</div>
	
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
						<input name="order_time" id="dd" type="text" readonly="readonly" class="easyui-datebox" required="required">
					</td>
					<td class="fitem">
						<label>订单号:</label><!-- class="easyui-validatebox" -->
						<input name="order_mailnum" id="ol" readonly="readonly" class="easyui-validatebox" style="width:180px;height:30px" validType="OrderNumber" required="required">
					</td>
					<td><span id="mailnumInfo"></span></td>
				</tr>
				<tr>
					<td class="fitem">
						<label>发货人姓名：</label>
						<input name="sender_name" readonly="readonly" required="required" class="easyui-textbox" >
					</td>
					<td class="fitem">
						<label>发货人电话：</label>
						<input name="sender_phone" readonly="readonly" required="required" class="easyui-textbox" validType="phone">
					</td>
				</tr>
				<tr><td>发货人地址:</td></tr>
				<tr>
					<td class="fitem">
						<input name="sender_adr" readonly="readonly" class="easyui-validatebox" style="width:180px;height:30px" required="required" >
					</td>
				</tr>
				<tr>					
					
					<td></td>
				</tr>
				<tr>
					<td class="fitem">
						<label>收货人姓名:</label>
						<input name="accepter_name" readonly="readonly" required="required" class="easyui-textbox"  >
					</td>
					<td class="fitem">
						<label>收货人电话:</label>
						<input name="accepter_phone" readonly="readonly"required="required" class="easyui-textbox" validType="phone">
					</td>
				</tr>
				<tr><td>收货人地址:</td></tr>
				<tr>
					<td class="fitem">
						<input type="text" name="accepter_adr" readonly="readonly" required="required"  class="easyui-validatebox" style="width:180px;height:30px">
					</td>
				</tr>
				<tr>
					<td class="fitem">
						<label>邮编:</label>
						<input name="accepter_zipcode" readonly="readonly" class="easyui-textbox" validType="zipcode">
					</td>
					<td class="fitem">
						<label>物品名称:</label>
						<input name="goods_name" readonly="readonly"class="easyui-textbox" >
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
					    <select id="cc" class="easyui-combobox"readonly="readonly" name="goods_type" style="width:150px;">
					        <option value="衣服">衣服</option>
					        <option>食品</option>
					        <option>数码</option>
					        <option>饰品</option>
					        <option>其他</option>
					    </select>
					</td>
					<td class="fitem">
						<label>物品重量（Kg）:</label>
						<input name="goods_weight" readonly="readonly"  class="easyui-textbox" validType="weight">
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
						<select id="cc" class="easyui-combobox" readonly="readonly" name="goods_remarks" style="width:150px;">
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
					<input name="goods_status" id="goodsStatus" readonly="readonly" class="easyui-validatebox" type="hidden">
					<td class="fitem">
						<label>物品价值（元）:</label>
						<input name="goods_value" readonly="readonly" class="easyui-textbox" validType="value">
					</td>
					<td class="fitem">
						<label>保价金额（元）:</label>
						<input name="goods_supportvalue" readonly="readonly" class="easyui-textbox" validType="supportvalue">
					</td>
					<td class="fitem">
						<label>是否保价:</label>
			                <input type="radio" readonly="readonly" name="goods_ifsupportvalue" value="0">否</input>
			                <input type="radio" readonly="readonly" name="goods_ifsupportvalue" value="1">是</input>          
			        </td>
				</tr>
				<tr>
					<td class="fitem">
						<label>费用（元）:</label>
						<input name="goods_cost" readonly="readonly" class="easyui-textbox" validType="cost">
					</td>
					<td class="fitem">
						<label>支付方式:</label>
						<select id="cc" class="easyui-combobox" readonly="readonly" name="cost_type" style="width:150px;">
					        <option value="网上付款">网上付款</option>
					        <option>现金支付</option>
					        <option>邮寄到付</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="fitem">
						<label>目的地门店:</label>
				</tr>
				<tr>
					<td><select id="province" style="width:150px;height:30px"></select></td> 
					<td><select id="city" style="width:150px;height:30px"></select></td>
					<td><select id="area" style="width:150px;height:30px"></select></td>
				</tr>
				<tr>
					<td>
						<input name="over_store" id="address" class="easyui-validatebox" style="width:180px;height:30px" required="required" >
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
  </body>
</html>
