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
    <table id="tt"  class="easyui-datagrid" title="维修账单查询" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCarHistory.do',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'repair_history_repairCarNum',width:80,align:'center'">车牌号</th>
				<th data-options="field:'repair_history_repairman',width:50,align:'center'">维修员工</th>
				<th data-options="field:'repair_history_repairResult',width:50,align:'center'">维修结果</th>
				<th data-options="field:'repair_history_repairByWho',width:80,align:'center'" formatter="formatRepairByWho">维修方式</th>
				<th data-options="field:'repair_history_address',width:150,align:'center'">损坏地址</th>
				<th data-options="field:'repair_history_repairTime',width:60,align:'center'">损坏时间</th>
				<th data-options="field:'repair_history_repairCause',width:60,align:'center'">损坏原因</th>
				<th data-options="field:'repair_history_repairMoney',width:60,align:'center'">维修金额</th>
				<th data-options="field:'repair_history_bill_type',width:60,align:'center'" formatter="formatBill_type">结算结果</th>
				<th data-options="field:'operation',width:60,align:'center'" formatter="formatOperation">查看详情</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
			<span>损坏地址</span>
			<input id="address" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
						<label>维修详情:</label><br>
						<textarea name="repair_history_details" style="width:200px;height:80px;" class="easyui-validatebox" ></textarea>
			</div>
		</form>
	</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	
	<script type="text/javascript">
	//显示车辆维修状态
	function formatService_state(val,row){ //val 当前列的值 row去当前行的值
		if(val==0){
			return "未提交";
		}else if(val==1){
			return "待分配";
		}else if(val==2){
			return "维修中";
		}else if(val==3){
			return "待司机审核";
		}else if(val==4){
			return "维修结束";
		}else if(val==5){
			return "待取车";
		}else{
			return "自行维修中";
		}
	}
	//显示账单状态
	function formatBill_type(val,row){
		if(val==null||val==""){
			return "未结算";
		}else{
			return "已结算";
		}
	}
	//显示维修方式
	function formatRepairByWho(val,row){ //val 当前列的值 row去当前行的值
		if(val==0){
			return "公司内部维修";
		}else{
			return "自主维修";
		}
	}
	//操作中的按钮 
	function formatOperation(val,row,index){
		//alert(row.repair_history_bill_type);
		 //var rows = JSON.stringify(row);
		return '<input   type="button"  value="查看详情" onclick="view(\''+row.repair_history_id+'\')">';
	}
	
	//给自动生成的序号列加标题
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('序号')
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
					address: $('#address').val()
				});
		 }
		 //查看详情
		 function view(data){
			$('#fm').form('clear');
			$('#fm').form('load',"repair/selectHisById.do?repair_history_id="+data);
			$('#dlg').dialog('open').dialog('setTitle','维修历史');
			$('#dlg').window('center');
			
		}
		</script>
  </body>
</html>
