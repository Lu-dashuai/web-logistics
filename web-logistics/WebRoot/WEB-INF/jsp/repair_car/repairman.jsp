<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <table id="tt"  class="easyui-datagrid" title="维修人员选择" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCar.do?state2=1',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'service_address',width:150,align:'center'">损坏地址</th>
				<th data-options="field:'service_time',width:60,align:'center'">损坏时间</th>
				<th data-options="field:'service_cause',width:60,align:'center'">损坏原因</th>
				<th data-options="field:'service_state',width:60,align:'center'" formatter="formatService_state">维修状态</th>
				<th data-options="field:'car_type',width:50,align:'center'">车型</th>
				<th data-options="field:'emp_name',width:50,align:'center'">维修员工</th>
				<th data-options="field:'service_result',width:50,align:'center'">维修结果</th>
				<th data-options="field:'operation',width:200,align:'center'" formatter="formatOperation">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
			<span>损坏地址</span>
			<input id="address" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:350px;height:150px;padding:30px 20px"
		closed="true"  buttons="#dlg-buttons">
			<form id="fm" method="post">
				<input type="checkbox" id="aa" >全选<br/>
				<input type="hidden" id="ids" name="empids">
				<c:forEach	items="${list}" var="repairmanList" varStatus="i">
								<tr>
								<td>${i.count}<td>
								<td>
									<input type="checkbox" name="repairman" value="${repairmanList.emp_name}">
									<input type="hidden" name="empIds" value="${repairmanList.emp_id}">
									${repairmanList.emp_name}
								</td>
								</tr>
							</c:forEach>
			
				
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 确认</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	 <div id="dlgg" class="easyui-dialog" style="width:700px;height:400px;padding:1px 10px"
		closed="true"  buttons="#dlgg-buttons">
			<table id="ll"  class="easyui-datagrid" title="" style="width:100%;height:100%"
		pagination="true" fitColumns="true"  rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCarHistory.do', method:'post'">
		<thead>
			<tr>
				<th data-options="field:'repair_history_repairman',width:60,align:'center'">维修员工</th>
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
	//操作中的按钮
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
	if(row.emp_name==null||row.emp_name==""){
		return '<input   type="button"  value="维修人员选择" onclick="checkMan(\''+row.service_record_id+'\')">|'+
		'<input id="fp"   type="button" disabled="disabled"  value="分配" onclick="allocation(\''+row.service_record_id+'\')"></input>|'+
		'<input id="ch"  type="button"  value="撤回" onclick="subbCar('+row.service_record_id+')"></input>|'+
		'<input  id="zxwx" type="button"  value="自行维修" onclick="ownRepair(\''+row.service_record_id+'\')"></input>|'+
		'<input id="wxls"  type="button"  value="维修历史" onclick="history(\''+row.service_record_id+'\')"></input>';
		}else{
			return '<input   type="button"  value="维修人员选择" onclick="checkMan(\''+row.service_record_id+'\')">|'+
		'<input id="fp"  type="button"   value="分配" onclick="allocation(\''+row.service_record_id+'\')"></input>|'+
		'<input id="ch"  type="button"  value="撤回" onclick="subbCar('+row.service_record_id+')"></input>|'+
		'<input id="zxwx"  type="button" disabled="disabled" value="自行维修" onclick="ownRepair(\''+row.service_record_id+'\')"></input>|'+
		'<input  id="wxls" type="button"  value="维修历史" onclick="history(\''+row.service_record_id+'\')"></input>';
		}
	}
	
	//给自动生成的序号列加标题
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('序号');
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
	
		 //弹出选择页面
		 function checkMan(id){
		 	$('#dlg').window('center');
			$('#dlg').dialog('open').dialog('setTitle','选择维修人员');
			url = "repair/updateEmpid.do?id="+id;
		} 
		//全选
		$("#aa").click(function(){
				$("input[name='repairman']").prop("checked",$(this).get(0).checked);
			});	
		 //确定人员
		 function saveUser(){
		// alert( $("input[name='repairman']:checked").val());
		var name = "";
		  $("input[name='repairman']:checked").each(function (){
		name+=$(this).val()+",";
		});
		$("#ids").val(name);
		//alert(name);
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
						$('#dlg').dialog('close');		// 关闭弹出框
						$('#tt').datagrid('reload');	// 刷新父窗口
				}
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
		//分配
		function allocation(id){
			$.messager.confirm('建议查看维修历史再分配','确定要这样分配吗?',function(r){
					if (r){
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
					 var val = $('#fp').val();
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							if (result.msg=="分配成功"){
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
		//撤回
		function subbCar(id){
				$.messager.confirm('Confirm','确定要撤回吗?',function(r){
					if (r){
					 var val = $('#ch').val();
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							if (result.msg=="撤回成功"){
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
		//自行维修
		function ownRepair(id){
				$.messager.confirm('Confirm','确定要自行维修吗?',function(r){
					if (r){
					 var val = $('#zxwx').val();
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							if (result.msg=="自行维修提交成功"){
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
		</script>
  </body>
</html>
