<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'waitRepairCar.jsp' starting page</title>
    
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
    <table id="tt"  class="easyui-datagrid" title="待审核订单信息" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'bad/allBadOrder.do?state='+5,method:'post'">
		<thead>
			<tr>
				<th data-options="field:'order_mailnum',width:80,align:'center'">邮寄单号</th>
				<th data-options="field:'order_time',width:80,align:'center'">订单时间</th>
				<th data-options="field:'order_name',width:80,align:'center'">货物类型</th>
				<th data-options="field:'badorder_insure',width:80,align:'center'" formatter="formatBadorder_insure">是否保价</th>
				<th data-options="field:'badorder_price',width:150,align:'center'">保价金额</th>
				<th data-options="field:'order_money',width:60,align:'center'">货物总值</th>
				<th data-options="field:'order_freight',width:60,align:'center'">运费金额</th>
				<th data-options="field:'badorder_pay',width:150,align:'center'">赔付金额</th>
				<th data-options="field:'badorder_type',width:60,align:'center'" formatter="formatBadorder_type">异常类型</th>
				<th data-options="field:'order_person',width:60,align:'center'">发件人</th>
				<th data-options="field:'order_person_phone',width:150,align:'center'">联系方式</th>
				<th data-options="field:'order_state',width:60,align:'center'" formatter="formatOrder_state">当前状态</th>
				<th data-options="field:'operation',width:80,align:'center'" formatter="formatOperation">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
			<span>订单号</span>
			<input id="order_mailnum" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:600px;height:300px;left: 600px;top:300px"
		closed="true"  buttons="#dlg-buttons">
		<form id="ff" method="post">
			初审核人：<input name="pass1_personname" type="text">
			初审时间：<input name="pass1T" type="text"><br>
			复审核人：<input name="pass2_personname" type="text">
			复审时间：<input name="pass2T" type="text"><br>
			异常信息：<input name="badorder_reason" type="text">
			历史回执：<input name="add2_reason" type="text"><br>
			初审意见：<input name="back1_reason" type="text">
			复审意见：<input name="back2_reason" type="text"><br>
			赔   付 人：<input name="payeeName" type="text">
			赔付金额：<input name="badorder_pay" type="text"><br>
			赔付方式：<input id="badorder_paytype" name="badorder_paytype" type="text" data-options="formatter:showType"   >
			赔付账号：<input name="payeeNo" type="text">
			</form>
		</div>
		<div id="dlg-buttons">
			<a  class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	
	<script type="text/javascript">
	
       //操作中的驳回与通过
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
	
		return '<input id="ckxq"  type="button"  value="查看详情" onclick="show(\''+row.badorder_id+'\')">';
	
	}
	//赔付方式
	function showType(val){
		if(val==0){
			return "现金";
		}else if(val==1){
			return "银行卡";
		}else if(val==2){
			return "手机支付";
		}else{
			return "其他";
		}
	}
	//显示订单是否保价
	function formatBadorder_insure(val,row){ //val 当前列的值 row去当前行的值
		if(val==0){
			return "否";
		}else {
			return "是";
		}
	}
	//显示异常类型
	function formatBadorder_type(val,row){//val 当前列的值 row去当前行的值
		if(val==0){
			return "货品破损";
		}else if(val==1){
			return "货品丢失";
		}else if(val==1){
			return "延期到达";
		}else{
			return "其他";
		}
	}
	//显示异常单状态
	function formatOrder_state(val,row){//val 当前列的值 row去当前行的值
		if(val==0){
			return "待审核";
		}else if(val==1){
			return "未通过";
		}else if(val==2){
			return "待复核";
		}else if(val==3){
			return "待赔付";
		}else{
			return "已赔付";
		}
	}
	//给自动生成的序号列加标题
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('编号');
        })
		/* //获取行号
		$.extend($.fn.datagrid.methods, {  
        getRowNum:function(jq){  
            var opts=$.data(jq[0],"datagrid").options;  
            var array = new Array();  
            opts.finder.getTr(jq[0],"","selected",1).each(function(){  
                array.push($(this).find("td.datagrid-td-rownumber").text());  
            });  
            return array.join(",");  
        }  
    });   */
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					order_mailnum: $('#order_mailnum').val()
				});
		 }
		 //查看详情
		 function show(data){
		 	$('#ff').form('load',"bad/getAllBad.do?badorder_id="+data);
		 	$('#dlg').dialog('open').dialog('setTitle','详细信息');
		 	if($('badorder_paytype').val()==0){
		 		$('badorder_paytype').val('0')
		 	}else if($('badorder_paytype').val()==1){
		 		$('badorder_paytype').val('1')
		 	}else if($('badorder_paytype').val()==2){
		 		$('badorder_paytype').val('2')
		 	}else{
		 		$('badorder_paytype').val('3')
		 	}
		 }
		
		</script>
  </body>
</html>
