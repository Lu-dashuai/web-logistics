<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'inkuOrder.jsp' starting page</title>
    
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
	    	}  else if (row.goods_status==66){
	    		return '<span style="color:red;">退单</span>';
	    	} 
  	 	 }
  	 	 	//目的地方法
		function overStoreOrder(){
				var row = $('#tt').datagrid('getChecked');//如果这一行被选中
				if (row){
				 var idsStr="";
				 for(var i=0;i<row.length;i++){
				     idsStr+=row[i].id+",";//拿到这一行想要传往前台的值，拼接为字符串，以逗号隔开
				 }
				// alert(order_ids);
				 $.messager.confirm('Confirm','确认到达目的地站吗?',function(r){
					if (r){
					   //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
					   //alert("111");
						$.post('order/overStoreOrder.do',{idsStr:idsStr},function(result){
							//alert(result);
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
  	 
	</script>
  </head>
  
  <body>
  	<!-- 订单审核页面 -->
    <table id="tt" class="easyui-datagrid" title="订单审核"
		style="width:100%;height:560px" pagination="true" toolbar="#tb"
		data-options="singleSelect:false,collapsible:true,url:'order/page.do?status2=2&overStore=1',method:'get'">
		<thead>
			<tr>
				<!-- hidden:true隐藏字段 sortable:true可以排序-->
				<th data-options="field:'ck',checkbox:true"></th>
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
			</tr>
		</thead>
	</table>
	
	
	<!-- 通过退单操作 -->
	<div id="tb" style="padding:3px">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="overStoreOrder()">目的地站</a>
	</div>
	

	
  </body>
</html>
