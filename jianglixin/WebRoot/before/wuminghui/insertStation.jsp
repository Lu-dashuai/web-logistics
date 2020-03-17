<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
 <base href="<%=basePath%>">

    <title>My JSP 'insertStation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${path }/css/bootstrap.css"/>
<link rel="stylesheet" href="${path }/before/css/bootstrap.min.css">
	<script src="${path }/before/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/before/js/bootstrap.js"></script>
  </head>
  
  <body>
   <form action="Station/insertStation.action" method="post">
   <table class="table table-bordered table table-striiped table-striped table-hover">
   <thead>
   		<th>网点信息</th>
   		<th>输入信息</th>
   	<!-- <tr>
   		<td>网点编号：</td>
   		<td> <input id="no" placeholder="必填" name="station.station_id"></td>
   	</tr> -->
   	<tr>
   		<td>网点名字</td>
   		<td><input required id="sta1" onblur="isChinese(this.value)" placeholder="请输入详细填写" name="station.station_name"></td>
   	</tr>
   	<tr>
   		<td>网点具体地址</td>
   		<td><input required id="sta2" onblur="isChinese(this.value)" placeholder="请详细地址" name="station.station_address"></td>
   	</tr>
   	<tr>
   		<td>网点经理</td>
   		<td><select required id="admin" placeholder="真实姓名"  name="station.station_admin"></select></td>
   	</tr>
   	
   	<tr>
   		<td>网点联系电话</td>
   		<td><input required id="num" onblur="checkNumber(this.value)" placeholder="" name="station.station_phone"></td>
   	</tr>
   	</table>
   	 	<input type="submit" value="提交" class="btn btn-primary btn-lg btn-block">
   </form>
</html>
<script src="js/jquery-1.8.3.min.js"></script>
<script language="javascript">
//正则表达式验证是否为中文
		function isChinese(obj){
			var reg=/^[\u0391-\uFFE5]+$/;
				if(obj!=""&&!reg.test(obj)){
				alert('必须输入中文！');
				$("#sta1").val("");
				return false;
	}
}
 //正则表达式验证是否为中文
		function isChinese(obj){
			var reg=/^[\u0391-\uFFE5]+$/;
				if(obj!=""&&!reg.test(obj)){
				alert('必须输入中文！');
				$("#sta2").val("");
				return false;
	}
}
		 //正则表达式验证是否为数字
		function checkNumber(obj){
			var reg = /^[0-9]+$/;
			if(obj!=""&&!reg.test(obj)){
			alert('只能输入数字！');
			$("#num").val("");
			return false;
			}
			} 
//网点经理下拉框
$(function(){
		$.ajax({
			url:"Station/findAdminStation.action",
			type:"post",
			dataType:"text",
			success:function(tab1){
				$("#admin").empty();
				var admins=eval("("+tab1+")");
				for(var i=0;i<admins.length;i++){
					var str="<option value='"+admins[i][0]+"'>"+admins[i][1]+"</option>";
					$("#admin").append(str);
				}
			}
		})
	});





/* 查询网点编号是否重复 */ 
	/* 	$("#no").blur(function(){
			var empno=document.getElementById("no").value;
	
			$.post("/lightning3/before/wuminghui.action",{'no':empno},function(data){
				if(data=="success"){
					alert("网点编号不能重复");
					document.getElementById("no").value="";
					$("#no").onfocus();	
				}
			})
		});
 */
</script>






