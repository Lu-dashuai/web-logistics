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
    
    <title>My JSP 'showStatus.jsp' starting page</title>
    
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
   <form action="Cartype/insertCartype.action" method="post">
		<table class="table" border=1>
			<thead>
				<th>车辆编号</th>
				<th>车辆类型</th>
			</thead>
			<tr>
				<td>1.车辆编号</td>
				<td><input type="hidden" name="cartype.cartype_id"></td>
			</tr>
			<tr>
				<td>2.车辆类型</td>
				<td><input required id="type"  name="cartype.cartype_name" onblur="isChinese(this.value)" placeholder="请输入中文！"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="增加车辆类型" class=" btn btn-primary btn-lg btn-block"></td>
			</tr>
		</table>
	</form>
  </body>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script language="javascript">
  //正则表达式验证是否为中文
		function isChinese(obj){
			var reg=/^[\u0391-\uFFE5]+$/;
				if(obj!=""&&!reg.test(obj)){
				alert('必须输入中文！');
				$("#type").val("");
				return false;
	}
}

</script>
</html>















