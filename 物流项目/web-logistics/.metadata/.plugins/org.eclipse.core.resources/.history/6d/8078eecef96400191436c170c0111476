<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>异常单添加</title>
    
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
	
  </head>
  <body>
  <!--样式  -->
   <style>
  .form-control{
  
  	width:400px;
  } 
  	#add{
  			background-color:#538EC4;
  			height:65px;
  			font-size:30px;
  			line-height:65px;
  			color:white;
  		}
 	table{
  			width:100%;
  		} 
  	table tr{
  		height:60px;
  	}
  	table tr td{
  		/* text-align:center; */
  		padding:10px;
  		text-align:right;
  	}
  	#baojia{
  		padding-left:320px;
  	}
  	.alignleft{
  		text-align:left;
  	}
  	tr>*:first-child{
  		width:600px;
  	}
  </style>
  <body>
  <%-- java表达式<%=basePath %> --%>
  <div id="add">异常单信息添加</div>
  <div class="container" style="margin-top:50px" >
  <div class="row clearfix">
  <div class="col-md-12 column">
  <fieldset class="fi1">
  <legend>添加新的异常单信息</legend>
    <form role="form" id="form1">
    	<table>
    		<tr>
    			<td>邮寄单号<input class="form-control" type="text" name="order_mailnum" id="order_mailnum"  value="${list[0].order_mailnum}"   onkeydown="return check(event)" /><input type="button" value="查询" id="haha" disabled="disabled" /></td><td width="600px" class="alignleft"><span id="chaxun"></span></td>
    		</tr>
    		<tr>
    			<td>客户姓名<input class="form-control" type="text"  name="sender_name" value="${list[0].sender_name}"/></td>
    		</tr>
    		<tr>
    			<td>货物总值<input class="form-control" type="text" id="goods_value"  name="goods_value" value="${list[0].goods_value}"  onkeydown="return check(event)"/></td>
    		</tr>
    		<tr>
    			<td class="alignleft" id="baojia">是否保价<input  type="radio"  name="goods_ifsupportvalue" value="1" ${list[0].goods_ifsupportvalue==1?'checked=checked':'' }/>是
    			<input  type="radio"  name="goods_ifsupportvalue" value="2" ${list[0].goods_ifsupportvalue==2?'checked=checked':'' }/>否
    			</td>
    		</tr>
    		<tr>
    			<td>保价金额<input class="form-control" type="text"  name="goods_supportvalue" id="goods_supportvalue" value="${list[0].goods_supportvalue}"  onkeydown="return check(event)"/></td>
    		</tr>
    		<tr>
    			<td>异常类型<select class="form-control" name="wrongorder_type" >
    				<option value="1" ${list[0].wrongorder_type==0?'selected=selected':'' }>货品破损</option>
    				<option value="2" ${list[0].wrongorder_type==1?'selected=selected':'' }>货品丢失</option>
    				<option value="3" ${list[0].wrongorder_type==2?'selected=selected':'' }>延期到达</option>
    				<option value="4" ${list[0].wrongorder_type==3?'selected=selected':'' }>其他</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>赔付金额<input type="text" class="form-control" name="badpay" onkeyup="this.value=this.value.replace(/\D/gi,'')"  onkeydown="return check(event)"/></td>
    		</tr>
    		<tr >
    			<td>异常信息<textarea class="form-control" rows="3" cols="50" name="badreason" value="${list[0].badreason}"></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input class="btn-success" type="button" value="提交" id="subtn" style="width:150px;height:40px"/></td>
    		</tr>
    	</table>
    </form>
    </fieldset>
	</div>
	</div>
</div>
<script type="text/javascript">
	 function check(event) { 
		 var eve=event?event:window.event;
		 var a = eve.keyCode;
		 if(a>=48&&a<=57||a>=96&&a<=105||a==110||a==190||a==8)return true;
		 return false;
    }   
	$(function(){
	/*点击按钮函数  */
			$("#subtn").click(function(){
  			$.ajax({
  			   url:"wrong/add.do",
               data:$("#form1").serialize(),
               type:"post",/* 出错了就会到error里面 */
               dataType:"json",
               success:function(data){
                  if(data.suc=='true'){
                    alert("添加成功");
  					
                  }else{
                  	alert("添加失败");
                  }
                  }
               })
  			})
  	
  		/* 给查询添加事件  他和失去焦点事件冲突了，先执行失去焦点事件*/
  		$("#haha").click(function(){
  			window.location.href="wrong/select.do?order_mailnum="+$("#order_mailnum").val();
  		});
  		//..................
  		
    
  		
  	//给order_mailnum绑定键盘事件
  	$("#order_mailnum").keyup(function(){//#不能少 按id查找
  		var tempOrder_mailnum=$.trim($("#order_mailnum").val());//val后忘加括号了,去空格
  		//$("#haha").removeAttr("disabled");//失去焦点后按钮可以点击了
  		//alert(tempOrder_mailnum);
  		if(tempOrder_mailnum==''){
  			$("#chaxun").html("快递单号不能为空").css("color","#ff0000");
  			$("#subtn").attr("disabled","disabled");
  			return;
  		} 
  		$.post(
  				"wrong/chaxun.do",//请求地址
  				{order_mailnum:tempOrder_mailnum},//携带的参数tempOrder_mailnum
  				function(data){//回调函数
  				if(data=='true'){//判断一定得是单引号
  					$("#chaxun").html("此门店快递单号可用").css("color","#00ff00");
  					$("#subtn").removeAttr("disabled");
  					$("#haha").removeAttr("disabled");
  				}else if(data=='trueOne'){
  					$("#chaxun").html("此快递单号已经为异常单了不需要再添加了").css("color","#00ff00");
  					$("#subtn").attr("disabled","disabled");
  				}else{
  					$("#chaxun").html("此门店下快递单号不存在").css("color","#ff0000");
  					$("#subtn").attr("disabled","disabled");
  				}
  				}
  		);
  	});
  });
  	
	</script>
  </body>
  
</html>
