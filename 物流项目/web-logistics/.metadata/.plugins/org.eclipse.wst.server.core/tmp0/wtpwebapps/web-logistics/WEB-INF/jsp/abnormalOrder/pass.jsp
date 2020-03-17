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
    <table id="tt"  class="easyui-datagrid" title="待复核订单信息" style="width:100%;height:100%"
		pagination="true" fitColumns="true" toolbar="#tb" rownumbers="true" data-options="singleSelect:true,collapsible:true,
		url:'bad/allBadOrder.do?state='+2,method:'post'">
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
				<th data-options="field:'badorder_reason',width:60,align:'center'" formatter="formatBadorder_reason">异常信息</th>
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
	<div id="dlg" class="easyui-dialog" style="width:400px;height:300px;left: 600px;top:300px"
		closed="true"  buttons="#dlg-buttons">
		<form id="ff" method="post">
				<div class="fitem">
					<label>异常信息:</label> 
					  <input  name="badorder_reason" class="easyui-validatebox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>初审意见:</label>
				 <input  name="back1_reason" class="easyui-validatebox" readonly="readonly"> 
				</div>
				<div class="fitem">
					<label>员工回执:</label>
				 <input  name="add2_reason" class="easyui-validatebox" readonly="readonly"> 
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a  class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	<div id="dlgg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 5px"
		closed="true"  buttons="#dlgg-buttons">
		<form id="fm" method="post">
				<div class="fitem">
					<label>建议金额:</label> <br>
					  <input  name="advise_money" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>原因:</label><br>
				 <textarea name="back2_reason" style="width:200px;height:80px;" class="easyui-validatebox" required="true"></textarea>
				</div>
			</form>
		</div>
		<div id="dlgg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgg').dialog('close')">取消</a>
		</div>
	<script type="text/javascript">
	
       //操作中的驳回与通过
	function formatOperation(val,row,index){
		 //var rows = JSON.stringify(row);
	
			return '<input id="bh"  type="button"  value="驳回" onclick="reject(\''+row.badorder_id+'\')">|<input  id="tg" type="button"  value="通过" onclick="pass(\''+row.badorder_id+'\')"></input>';
	
	}
	//查看详情
	function formatBadorder_reason(val,row,index){
		 //var rows = JSON.stringify(row);
	
		return '<input id="ckxq"  type="button"  value="查看详情" onclick="showDetails(\''+row.badorder_id+'\')">';
	
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
		 function showDetails(data){
		 	$('#ff').form('load',"bad/getAllBad.do?badorder_id="+data);
		 	$('#dlg').dialog('open').dialog('setTitle','通知信息');
		 }
		 //驳回
		 function reject(id){
			$('#dlgg').window('center');
			$('#dlgg').dialog('open').dialog('setTitle','复核意见');
			$('#fm').form('clear');
			url = "bad/update.do?badorder_id="+id+"&val="+0;
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
					if(result.msg=='提交成功') {
						$('#dlgg').dialog('close');		// 关闭弹出框
						$('#tt').datagrid('reload');	// 刷新父窗口

					}
				}
			});
		}
		//通过
		function pass(id){
				$.messager.confirm('Confirm','确定要通过吗?',function(r){
					if (r){
					 //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('bad/update.do',{badorder_id:id,val:3 },function(result){
							if (result.msg=="提交成功"){
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
