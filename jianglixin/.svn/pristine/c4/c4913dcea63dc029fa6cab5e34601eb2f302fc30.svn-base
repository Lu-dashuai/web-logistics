<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showStation.jsp' starting page</title>
    
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
     <form action="Station/updateStation.action" method="post">
    <table class="table table-bordered table table-striped table-striped table-hover">
      <thead>
    <th>网点信息表</th><th>输入信息</th>
    </thead>
    <tr><td>网点编号：</td><td><input id="id" type="hidden" name="station.station_id" value="${rowStation[0]}"></td>
    </tr>
    <tr> 
    <td>网店名字：</td><td><input  name="station.station_name" value="${rowStation[1]}"></td>
    </tr>
    <tr>
    	<td>网点具体地址：</td><td><input  name="station.station_address"  value="${rowStation[2]}"></td>
    </tr>
    <tr>
    	<td>网点经理</td>
    	<td>
    		<input type="hidden" id="adiminval" value="${rowStation[3] }">
    		<select id="admin" placeholder="真实姓名"  name="station.station_admin"></select>
    	</td>
    </tr>
     <tr>
    	<td>网点联系电话：</td><td><input name="station.station_phone" value="${rowStation[4]}"></td>
    </tr>
    <tr>
    	<td>确定输入</td><td><input id="submit" class="btn btn-primary" type="submit" value="提交"></td>
    </tr>
	 	 </table>
    </form>
  </body>
</html>
<script>
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
					$("#admin").val($("#adiminval").val());
				}
			}
		})
	});

</script>
