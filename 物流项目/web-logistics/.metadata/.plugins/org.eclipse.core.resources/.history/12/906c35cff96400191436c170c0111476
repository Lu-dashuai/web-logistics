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
    <table id="tt"  class="easyui-datagrid" title="维修记录查询" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCar.do?state5=4',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'car_driver_papers',width:80,align:'center'">车牌号</th>
				<th data-options="field:'car_driver',width:80,align:'center'">司机</th>
				<th data-options="field:'service_address',width:150,align:'center'">损坏地址</th>
				<th data-options="field:'service_time',width:60,align:'center'">损坏时间</th>
				<th data-options="field:'service_cause',width:60,align:'center'">损坏原因</th>
				<th data-options="field:'operation',width:60,align:'center'" formatter="formatOperation">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
			<span>损坏地址</span>
			<input id="address" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	<div id="dlgg" class="easyui-dialog" style="width:700px;height:400px;padding:1px 10px"
		closed="true"  buttons="#dlgg-buttons">
			<table id="ll"  class="easyui-datagrid" title="" style="width:100%;height:100%"
		pagination="true" fitColumns="true"  rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCarHistory.do', method:'post'">
		<thead>
			<tr>
				<th data-options="field:'repair_history_repairman',width:60,align:'center'">维修员工</th>
				<th data-options="field:'repair_history_repairByWho',width:60,align:'center'" formatter="formatRepairByWho">维修方式</th>
				<th data-options="field:'repair_history_repairMoney',width:60,align:'center'">维修金额</th>
				<th data-options="field:'repair_history_details',width:60,align:'center'">维修详情</th>
			</tr>
		</thead>
	</table>
		</div>
		<div id="dlgg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgg').dialog('close')"> 关闭</a>
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
	//显示维修方式
	function formatRepairByWho(val,row){ //val 当前列的值 row去当前行的值
		if(val==0){
			return "公司内部维修";
		}else{
			return "自主维修";
		}
	}
	//操作中的修改 撤回 和删除 
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
		return '<input   type="button"  value="维修历史" onclick="history(\''+row.service_record_id+'\')">';
	}
	
	//给自动生成的序号列加标题
		 $(function () {
            $('#ll').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('序号');
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
		//查看历史
		function history(id){
			$('#dlgg').window('center');
			$('#dlgg').dialog('open').dialog('setTitle','维修历史');
			$('#ll').datagrid('load',{
				id:id,
				});
		}
		</script>
  </body>
</html>
