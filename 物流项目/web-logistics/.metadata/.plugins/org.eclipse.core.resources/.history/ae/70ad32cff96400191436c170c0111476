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
    <table id="tt"  class="easyui-datagrid" title="司机核实" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCar.do?state4=10',
		method:'post'">
		<thead>
			<tr>
				<th data-options="field:'car_driver',width:80,align:'center'">司机</th>
				<th data-options="field:'car_driver_papers',width:80,align:'center'">车牌号</th>
				<th data-options="field:'service_address',width:150,align:'center'">损坏地址</th>
				<th data-options="field:'service_time',width:60,align:'center'">损坏时间</th>
				<th data-options="field:'service_cause',width:60,align:'center'">损坏原因</th>
				<th data-options="field:'service_money',width:80,align:'center'">维修费用</th>
				<th data-options="field:'service_state',width:60,align:'center'" formatter="formatService_state">维修状态</th>
				<th data-options="field:'emp_name',width:80,align:'center'">维修人员</th>
				<th data-options="field:'operation',width:100,align:'center'" formatter="formatOperation">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCar()">添加</a>
			<br>
			<span>损坏地址</span>
			<input id="address" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
<!-- 			<div class="ftitle">添加维修车辆</div> -->
			<form id="fm" method="post">
				<div class="fitem">
					<label>维修人:</label><br>
					<input name="name" class="easyui-validatebox" required="true"><br>
					<label>维修金额:</label><br>
					<input name="money" class="easyui-validatebox" required="true">
					<input type="hidden" name="car_driver_papers" class="easyui-validatebox">
					<input type="hidden" name="service_address" class="easyui-validatebox">
					<input type="hidden" name="service_time" class="easyui-validatebox">
					<input type="hidden" name="service_cause" class="easyui-datebox">
					<input type="hidden" name="emp_name" class="easyui-validatebox">
					<input type="hidden" name="service_record_id" class="easyui-validatebox">
					<input type="hidden" name="car_id" class="easyui-validatebox">
					<input type="hidden" id="result" name="repairResult" class="easyui-validatebox">
					<input type="hidden" id="byWho" name="repairByWho" class="easyui-validatebox">
					<input type="hidden" name="bill_type"  class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>维修详情:</label><br>
					<textarea name="details" style="width:200px;height:80px;" class="easyui-validatebox" required="true"></textarea>
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	
	<script type="text/javascript">
	
       //操作中的修改 按钮
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
		if(row.service_state==3){
		return '<input   type="button"  value="没有问题" onclick="noPro(\''+row.service_record_id+'\')">|'+
		'<input  type="button"   value="存在其他问题" onclick="havePro(\''+row.service_record_id+'\')"></input>'
		}else{
		return '<input id="wxsb"  type="button"  value="上报维修记录" onclick="Report(\''+row.service_record_id+'\')">';
		}
	}
	//显示车辆维修状态
	function formatService_state(val,row){ //val 当前列的值 row去当前行的值
		if(val==0){
			return "未提交";
		}else if(val==1){
			$('#tj').val('撤回')
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
	//给自动生成的序号列加标题
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('序号');
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
    	//没有问题
    	function noPro(id){
    		$.messager.confirm('司机核实','确定提交吗?',function(r){
					if (r){
					 var val = "noPro";
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							if (result.msg=="提交成功"){
								//$('#tj1').val('提交');
								//$('#xg').removeAttr("disabled");
								//$('#sc').removeAttr("disabled");
								$('#tt').datagrid('reload');	// 更新父窗口
							}
								$.messager.show({	// show error message
									title: '提示信息',
									msg: result.msg
								});
						
						},'json');
					}
				});
    	}
    	//存在问题
    	function havePro(id){
    		$.messager.confirm('司机核实','确定提交吗?',function(r){
					if (r){
					 var val = "havePro";
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							if (result.msg=="提交成功"){
								//$('#tj1').val('提交');
								//$('#xg').removeAttr("disabled");
								//$('#sc').removeAttr("disabled");
								$('#tt').datagrid('reload');	// 更新父窗口
							}
								$.messager.show({	// show error message
									title: '提示信息',
									msg: result.msg
								});
						
						},'json');
					}
				});
    	}
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					address: $('#address').val()
				});
		 }
		 //上报维系信息
		 function Report(data){
		 	$('#fm').form('clear');
			$('#fm').form('load',"repair/selectById.do?service_record_id="+data);
			$('#dlg').dialog('open').dialog('setTitle','维修记录上报');
			$('#result').val("维修成功");
			$('#byWho').val(1);
			url = "repair/savehistory.do?val=99";		
		 }
			//保存操作
		function saveUser(){
			$('#fm').form('submit',{  //给form表单绑定submit事件
				url: url,//请求URL地址
				onSubmit: function(){//对form表单校验
					return $(this).form('validate');
				},
				success: function(result){//数据保存后的回调函数
					var result = eval('('+result+')');//eval把json字符串转换为json对象
					//alert(result.errorMsg);
					if (result.msg){//判断，如果错误信息不为空
						$.messager.show({//easyUI封装的浏览器右下角弹框
							title: '提示信息',//弹框标题
							msg: result.msg//提示信息
						});
					} 
					 if(result.msg=='保存成功') {
						$('#dlg').dialog('close');		// 关闭弹出框
						$('#tt').datagrid('reload');	// 刷新父窗口

					} 
				}
						
			});
		}
	
		</script>
  </body>
</html>
