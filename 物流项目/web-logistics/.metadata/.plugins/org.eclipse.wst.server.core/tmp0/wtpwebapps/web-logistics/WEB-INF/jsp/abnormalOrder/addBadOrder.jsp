<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="${path}/resource/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="${path}/resource/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${path}/resource/css/bootstrap.css" type="text/css"></link>
  <script type="text/javascript" src="${path}/resource/js/laydate/laydate.js"></script>
  <script type="text/javascript" src="${path}/resource/js/layer/layer.js"></script>
  
  	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  
  <script type="text/javascript">
  	$(document).ready(function(){
  		 $("#subtn").click(function(){
  		 //保存操作
  			$('#form1').form('submit',{  //给form表单绑定submit事件
				url: "bad/saveBadOrder.do",//请求URL地址
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
					/* 	$('#dlg').dialog('close');		// 关闭弹出框
						$('#tt').datagrid('reload');	// 刷新父窗口 */
						//location.href="bad/toAdd.do";
						//function(){window.location.href="bad/toAdd.do";}
						$('#form1').form('clear');
						$('#badtype').val('0');
					}
				}
			});
		});
  		$("#haha").click(function(){
  /* 			window.location.href="${path}/bad_select1.action?mailnumber="+$("#mailnumber").val(); */
  			$('#form1').form('load',"bad/allOrder.do?order_mailnum="+$("#order_mailnum").val());
  			 if($('#goods_ifsupportvalue').val()=='1'){
  				$('#goods_ifsupportvalue').val('是');
  			}
  			if($('#goods_ifsupportvalue').val()=='2')	{
  				$('#goods_ifsupportvalue').val('否');
  			}  
  		});
  	});
  	//action="${path}/badorder_add.action" method="post"
  </script>
  <style>
  	#add{
  			background-color:#538EC4;
  			height:65px;
  			font-size:30px;
  			line-height:65px;
  			color:white;
  		}
  	table{
  			width:800px;
  		}
  	table tr{
  		height:60px;
  	}
  	table tr td{
  		text-align:center;
  	}
  </style>
  <body>
  <div id="add">异常单信息添加</div>
  <div class="container" style="margin-top:50px" >
  <div class="row clearfix">
  <div class="col-md-12 column">
  <fieldset class="fi1">
  <legend>添加新的异常单信息</legend>
    <form role="form" id="form1" method="post">
    	<table border="0">
    		<tr>
    			<td>邮寄单号</td>
    			<td><input class="form-control" type="text" name="order_mailnum" id="order_mailnum" /></td>
    			<td><input class="btn btn-success" type="button" value="查询"  id="haha"/></td>
    		</tr>
    		<tr>
    			<td>客户姓名</td>
    			<td><input class="form-control" type="text"  name="sender_name"/></td>
    		</tr>
    		<tr>
    			<td>货物总值</td>
    			<td><input class="form-control" type="text"  name="goods_value"/></td>
    		</tr>
    		<tr>
    			<td>是否保价</td>
    			<td>
    			<input class="form-control" type="text" name="goods_ifsupportvalue"  id="goods_ifsupportvalue"  
    			/>
    			
    			</td>
    		</tr>
    		<tr>
    			<td>保价金额</td>
    			<td><input class="form-control" type="text" name="goods_supportvalue"  id="goods_supportvalue" /></td>
    		</tr>
    		<tr>
    			<td>异常类型</td>
    			<td><select class="form-control" name="badtype" id="badtype">
    				<option value="0">货品破损</option>
    				<option value="1">货品丢失</option>
    				<option value="2">延期到达</option>
    				<option value="3">其他</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>赔付金额</td>
    			<td><input type="text" class="form-control" name="badpay" onkeyup="this.value=this.value.replace(/\D/gi,'')"/></td>
    		</tr>
    		<tr >
    			<td valign="top">异常信息</td>
    			<td>
    			<textarea class="form-control" rows="3" cols="50" name="badreason"></textarea>
    			<input class="form-control" name="order_time" type="hidden" >
    			<input class="form-control" name="sender_phone" type="hidden" >
    			<input class="form-control" name="sender_adr" type="hidden" >
    			<input class="form-control" name="accepter_name" type="hidden" >
    			<input class="form-control" name="accepter_phone" type="hidden" >
    			<input class="form-control" name="accepter_adr" type="hidden" >
    			<input class="form-control" name="goods_type" type="hidden" >
    			<input class="form-control" name="goods_cost" type="hidden" >
    			<input class="form-control" name="cost_type" type="hidden" >
    			<input class="form-control" name="id" type="hidden" >
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input class="btn btn-success"  type="button" value="提交" id="subtn" style="width:150px;height:40px" /></td>
    		</tr>
    		
    	</table>
    </form>
    </fieldset>
	</div>
	</div>
</div>
  </body>
</html>
