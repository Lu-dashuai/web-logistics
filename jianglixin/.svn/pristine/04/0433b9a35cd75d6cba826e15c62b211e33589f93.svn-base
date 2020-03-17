<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertIndent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<style>
		span{
			 position:absolute;
		}
		b{
			color:red;
		}
	</style>
	<script type="text/javascript">
		function checkForm(){
			var state=true;
			//收货人信息表单验证
			$(".receivername").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('收货人用户名不能为空');
					state=false;
				}
			});
			$(".receiverphone").each(function(){
				var id=this.id;
				var value=this.value;
				var reg=/^(13|15|18|17)\d{9}$/;
				if(reg.test(value)){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('收货人手机号码错误');
					state=false;
				}
			});
			$(".receiverpostcode").each(function(){
				var id=this.id;
				var value=this.value;
				var reg=/^\d{6}$/;
				if(reg.test(value)){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('收货人邮政编码错误');
					state=false;
				}
			});
			$(".receiveraddress").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('收货地址不能为空');
					state=false;
				}
			});
			//发货人信息表单验证
			$(".shippername").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('发货人用户名不能为空');
					state=false;
				}
			});
			$(".shipperphone").each(function(){
				var id=this.id;
				var value=this.value;
				var reg=/^(13|15|18|17)\d{9}$/;
				if(reg.test(value)){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('发货人手机号码错误');
					state=false;
				}
			});
			$(".shipperpostcode").each(function(){
				var id=this.id;
				var value=this.value;
				var reg=/^v$/;
				if(reg.test(value)){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('发货人邮政编码错误');
					state=false;
				}
			});
			$(".shipperaddress").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('发货地址不能为空');
					state=false;
				}
			});
			//货物信息表单验证
			$(".cargoweight").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('货物重量信息不能为空');
					state=false;
				}
			});
			$(".cargosize").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('货物大小信息不能为空');
					state=false;
				}
			});
			$(".cargoexplain").each(function(){
				var id=this.id;
				var value=this.value;
				if(value!=""){
					$("#"+id+"Error").html('');
				}else{
					$("#"+id+"Error").html('请填写货物说明');
					state=false;
				}
			});
			return state;
		}
		
	</script>
  </head>
  
  <body>
  	<form class="form-inline definewidth m20" action="/lightning3/Indent/insertIndent.action" method="post">
	  	<table class="table table table-striped table-hover,table table-condensed">
	    	<thead><th colspan="2">收货人信息（<em class="r-point">*</em> 代表必填项）</th></thead>
	    	<tr>
	    		<td><b>*</b>收货人姓名</td>
	    		<td><input type="text" id="receivername" class="receivername" onblur="checkForm()" name="indent.indent_receiver_name" class="form-control" required>
	    			<span id="receivernameError"></span>
	    		</td>	
	    		<td><b>*</b>联系方式</td>
	    		<td><input type="text" id="receiverphone" onblur="checkForm()" class="receiverphone" name="indent.indent_receiver_phone" class="form-control" required>
	    			<span id="receiverphoneError"></span>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><b>*</b>邮政编码</td>
	    		<td><input type="text" id="receiverpostcode" class="receiverpostcode" onblur="checkForm()" name="indent.indent_receiver_postcode" class="form-control" required>
	    			<span id="receiverpostcodeError"></span>
	    		</td>
	    		<td><b>*</b>收货地址</td>
	    		<td><input type="text" id="receiveraddress" class="receiveraddress" onblur="checkForm()" name="indent.indent_receiver_address" class="form-control" required>
	    			<span id="receiveraddressError"></span>
	    		</td>
	    	</tr>
	    </table>
	    <table class="table table table-striped table-hover,table table-condensed">
	    	<thead><th colspan="2">发货人信息（<em class="r-point">*</em> 代表必填项）</th></thead>
	    	<tr>
	    		<td><b>*</b>发货人姓名</td>
	    		<td><input type="text" id="shippername" class="shippername" onblur="checkForm()" name="indent.indent_shipper_name" class="form-control" required>
	    			<span id="shippernameError"></span>
	    		</td>
	    		<td><b>*</b>联系方式</td>
	    		<td><input type="text" id="shipperphone" class="shipperphone" onblur="checkForm()" name="indent.indent_shipper_phone" class="form-control" required>
	    			<span id="shipperphoneError"></span>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><b>*</b>邮政编码</td>
	    		<td><input type="text" id="shipperpostcode" class="shipperpostcode" onblur="checkForm()" name="indent.indent_shipper_postcode" class="form-control" required>
	    			<span id="shipperpostcodeError"></span>
	    		</td>
	    		<td><b>*</b>发货地址</td>
	    		<td><input type="text" id="shipperaddress" class="shipperaddress" onblur="checkForm()" name="indent.indent_shipper_address" class="form-control" required>
	    			<span id="shipperaddressError"></span>
	    		</td>
	    	</tr>
	    </table>
	    <table class="table table table-striped table-hover,table table-condensed">
	    	<thead><th colspan="2">货物信息（<em class="r-point">*</em> 代表必填项）</th></thead>
	    	<tr>
	    		<td><b>*</b>货物重量</td>
	    		<td><input type="text" id="cargoweight" class="cargoweight" onblur="checkForm()" name="cargo.cargo_weight" class="form-control" required>
	    			<span id="cargoweightError"></span>
	    		</td>
	    		<td><b>*</b>货物大小</td>
	    		<td><input type="text" id="cargosize" class="cargosize" onblur="checkForm()" name="cargo.cargo_size" class="form-control" required>
	    			<span id="cargosizeError"></span>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><b>*</b>货物类型</td>
	    		<td>
	    			<select id="type" name="cargo.cargo_type">
	    				<%-- <c:forEach items="${tabType }" var="type">
		    				<option value="${type[0] }">${type[1] }</option>
	    				</c:forEach> --%>
	    			</select>
	    		</td>
	    		<td>货物说明</td>
	    		<td><input type="textarea" id="cargoexplain" class="cargoexplain" name="cargo.cargo_explain" class="form-control"></td>
	    	</tr>
	    	<tr>
	    		<td><b>*</b>订单时间</td>
	    		<td><input type="text" disabled id="cargotype" class="cargotype" onblur="checkForm()" name="indent.indent_time"></td>
	    		<%-- <input type="text"  name="emp.empBirth"  value="${empmap.emp_birth }"onclick="WdatePicker({dateFmt:'yyyy:MM:dd HH:mm:ss'})"  placeholder="请输入该员工生日" /> --%>
	    		<td colspan="2"><input type="submit" value="增加" onclick="checkBtn()" class="btn btn-primary"></td>
	    	</tr>
	    </table>
	</form>
  
  </body>
</html>
<script>
  	$(function(){
  		$.ajax({
  			url:"Type/findType.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab){
  				$("#type").empty();
  				var types=eval("("+tab+")");
  				for(var i=0;i<types.length;i++){
  					var str="<option value='"+types[i][0]+"'>"+types[i][1]+"</option>"
  					$("#type").append(str);
  				}
  			}
  		})
  	});
  	function writeCurrentDate() {
  		          var now = new Date();
  		          var year = now.getFullYear(); //得到年份
  		          var month = now.getMonth();//得到月份
  		          var date = now.getDate();//得到日期
  		          /* var day = now.getDay();//得到周几
  		          var hour = now.getHours();//得到小时
  		          var minu = now.getMinutes();//得到分钟
  		          var sec = now.getSeconds();//得到秒
  		 　　    	  var MS = now.getMilliseconds();//获取毫秒
  		          var week; */
  		          month = month + 1;
  		          if (month < 10) month = "0" + month;
  		          if (date < 10) date = "0" + date;
  		          /* if (hour < 10) hour = "0" + hour;
  		          if (minu < 10) minu = "0" + minu;
  		          if (sec < 10) sec = "0" + sec;
  		          if （MS < 100）MS = "0" + MS; 
  		          var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
  		          week = arr_week[day];*/
  		          var time = "";
  		          time = year + "-" + month + "-" + date  ;
  		          //当前日期赋值给当前日期输入框中（jQuery easyUI）
  		          $("#cargotype").html(time);
  		          //设置得到当前日期的函数的执行间隔时间，每1000毫秒刷新一次。
  		          //var timer = setTimeout("writeCurrentDate()", 1000);
  		       }

  </script>