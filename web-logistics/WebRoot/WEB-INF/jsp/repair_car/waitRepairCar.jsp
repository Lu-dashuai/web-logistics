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
    <table id="tt"  class="easyui-datagrid" title="待维修车辆信息" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'repair/allCar.do',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'car_driver_papers',width:80,align:'center'">车牌号</th>
				<th data-options="field:'car_driver',width:80,align:'center'">司机</th>
				<th data-options="field:'car_type',width:80,align:'center'">车辆类型</th>
				<th data-options="field:'car_state',width:80,align:'center'" formatter="formatCar_state">车辆状态</th>
				<th data-options="field:'service_address',width:150,align:'center'">损坏地址</th>
				<th data-options="field:'service_time',width:60,align:'center'">损坏时间</th>
				<th data-options="field:'service_cause',width:60,align:'center'">损坏原因</th>
				<th data-options="field:'service_state',width:60,align:'center'" formatter="formatService_state">维修状态</th>
				<th data-options="field:'operation',width:80,align:'center'" formatter="formatOperation">操作</th>
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
					<label>维修车辆</label>
					<input id="aa" name="car_driver_papers" class="easyui-combobox" 
					data-options="url:'repair/allCarDetails.do',method:'get',
					valueField:'car_driver_papers',
					textField:'car_driver_papers',
					panelHeight:'auto'"
					style="width:200px;" required="true">
				</div>
				<div class="fitem">
					<label>车辆状态</label>
					<input id="cc" name="service_car_id" type="hidden" class="easyui-validatebox">
					<input id="bb" name="car_state" class="easyui-validatebox"  
					readonly="readonly">
				</div>
				<div class="fitem">
					<label>损坏地址</label>
					<input  name="service_address" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>损坏时间</label>
					<input  name="service_time" class="easyui-datebox" required="true">
				</div>
				<div class="fitem">
					<label>损坏原因</label>
					<input  name="service_cause" class="easyui-validatebox" required="true">
				</div>
					<input id="dd" name="service_state" type="hidden"  class="easyui-validatebox">
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	
	<script type="text/javascript">
	//选择车辆及车辆状态的级联
		 $(function () {
           $('#aa').combobox({
                onChange: function (newValue, oldValue) {
                	//alert(newValue);
			 	$.post('repair/getByNum.do',{car_driver_papers:newValue},function(result){
			 		//alert(result);
			 		var state = result.car.car_state;
			 		//alert(state);
			 			if(state==0){
							 state="空闲";
						}else if(state==1){
							 state="途中";
						}else{
							 state="已分配";
						}
						$('#bb').val(state);
						$('#cc').val(result.car.car_id)
					},'json');  
                }
            });
       });
       //操作中的修改 撤回 和删除 
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
	 if(row.service_state==0){
		return '<input id="xg"  type="button"  value="修改" onclick="editCar(\''+row.service_record_id+'\')">|<input  id="tj" type="button"  value="提交" onclick="subCar(\''+row.service_record_id+'\')"></input>|<input id="sc"  type="button"  value="删除" onclick="destroyUser('+row.service_record_id+')"></input>';
		}else if(row.service_state==1){
		return '<input id="xg"  type="button" disabled="disabled"  value="修改" onclick="editCar(\''+row.service_record_id+'\')">|<input  id="tj1" type="button"  value="撤回" onclick="subbCar(\''+row.service_record_id+'\')"></input>|<input id="sc"  type="button" disabled="disabled"  value="删除" onclick="destroyUser('+row.service_record_id+')"></input>';
		}else{
			return '<input id="xg"  type="button" disabled="disabled"  value="修改" onclick="editCar(\''+row.service_record_id+'\')">|<input  id="tj1" type="button" disabled="disabled" value="撤回" onclick="subbCar(\''+row.service_record_id+'\')"></input>|<input id="sc"  type="button" disabled="disabled"  value="删除" onclick="destroyUser('+row.service_record_id+')"></input>';
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
	//显示车辆的状态
	function formatCar_state(val,row){//val 当前列的值 row去当前行的值
		if(val==0){
			return "空闲";
		}else if(val==1){
			return "途中";
		}else{
			return "已分配";
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
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					address: $('#address').val()
				});
		 }
		 
		 //弹出添加方法
		 function newCar(){
			$('#dlg').dialog('open').dialog('setTitle','添加维修车辆');
			$('#fm').form('clear');
			$('#dd').val(0);
			url = "repair/add.do";
			$('#aa').combobox({readonly:false});
			$('#aa').combobox({value:'--请选择需要维修的车辆--'});
		} 
		//弹出更新方法
		function editCar(data){
				$('#aa').combobox('clear');
				$('#aa').combobox('readonly');
				$('#dlg').dialog('close');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load',"repair/selectById.do?service_record_id="+data);
					     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','修改维修车辆');
				
				//$('#aa').type('hidden');
				url = "repair/update.do?service_record_id="+data;
	
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
					if(result.msg=='添加成功'||result.msg=='修改成功') {
						$('#dlg').dialog('close');		// 关闭弹出框
						$('#tt').datagrid('reload');	// 刷新父窗口

					}
				}
			});
		}
		
		//提交
		function subCar(id){
			//alert(id);
			//alert($('#tj').val());
			$.messager.confirm('Confirm','确定要提交吗?',function(r){
					if (r){
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
					   var val = $('#tj').val();
					   //alert(val);
						$.post('repair/updateService_State.do',{service_record_id:id,val:val },function(result){
							//var result = eval('('+result+')');
							//alert(result.msg);
							if (result.msg=="提交成功"){
								//alert($('#tj').val());
								//$('#tj').val('撤回');
								//alert($('#xg').val());
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
		function subbCar(id){
				$.messager.confirm('Confirm','确定要撤回吗?',function(r){
					if (r){
					 var val = $('#tj1').val();
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
		//删除数据
		function destroyUser(id){
				$.messager.confirm('Confirm','确定要删除吗?',function(r){
					if (r){
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
					
						$.post('repair/delete.do',{id:id },function(result){
							if (result.msg=="删除成功"){
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
