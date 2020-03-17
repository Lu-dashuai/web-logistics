<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertState.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${path }/css/bootstrap.css"/>
  </head>
  
  <body>
   <form action="State/insertState.action" method="post">
  	<table class="table">
  	<thead><th>车辆状态</th></thead>
  		<tr>
  			<td>车辆状态id</td>
  			<td><input name="state.state_id"  type="hidden"></td>
  		</tr>
  		<tr>
  			<td>车辆状态信息</td>
  			<td>
  			  <input required  name="state.state_name" id="state1" type="text"  onblur="isChinese(this.value)" placeholder="请输入中文！" />
  			 </td>
  		</tr>
  	</table>
    <input type="submit" id="submit" value="增加一条状态信息" class="btn btn-primary btn-lg btn-block">
    </form>
  </body>
   <script src="js/jquery-1.8.3.min.js"></script>
	<script language="javascript">
	 //正则表达式验证是否为中文
		function isChinese(obj){
			var reg=/^[\u0391-\uFFE5]+$/;
				if(obj!=""&&!reg.test(obj)){
				alert('必须输入中文！');
				$("#state1").val("");
				return false;
	}
}

</script>
</html>

