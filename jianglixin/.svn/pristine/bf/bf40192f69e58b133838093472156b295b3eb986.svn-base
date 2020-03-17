<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
  </head>
  
  <body>
  
    <form action="Worker/updateWorker.action" method="post" name="myForm">
    <table class="table table-bordered table table-striped table-striped table-hover">
    <thead>
    <th>员工信息表</th><th>输入信息</th>
    </thead>
    <tr><td>员工账号：</td><td><input id="id" type="hidden" name="worker.worker_id" value="${rowWorker[0]}"><span id="idSpan"  isRight="0"></span></td>
    </tr>
    <tr> 
    <td>员工密码：</td><td><input id="password" type="text" name="worker.worker_password" value="${rowWorker[1]}"><span id="passwordSpan"  isRight="0"></span></td>
    </tr>
    <tr>
    	<td>员工名字：</td><td><input name="worker.worker_name"  value="${rowWorker[2]}"></td>
    </tr>
    <tr>
    	<td>员工身份证：</td><td><input type="hidden" name="worker.worker_idcard" value="${rowWorker[3]}"></td>
    </tr>
    <tr>
    	<td>员工性别：</td><td><input type="hidden" id="" name="worker.worker_sex" value="${rowWorker[4]}" ></td>
    </tr>
    <tr>
    	<td>员工手机号：</td><td><input name="worker.worker_phone" value="${rowWorker[5]}"></td>
    </tr>
    <tr>
    	<td>员工职位：</td><td><input type="hidden" id="postinp" value="${rowWorker[6]}">
    	<select id="post" name="worker.worker_post" ></select></td>
    </tr>
    <tr>
    	<td>员工所属网点：</td><td><input type="hidden" id="stationinp" value="${rowWorker[7]}">
    	<select id="station" name="worker.worker_station" }"></select></td>
    </tr>	
     <tr>
    	<td>员工状态：</td><td><input type="hidden" id="powerinp" value="${rowWorker[8]}">
    	<select id="status" name="worker.worker_status" }"></select></td><!-- <input id="status" name="worker.worker_status"> -->
    </tr>
     <tr>
    	<td>确定输入</td><td><input id="submit" type="submit" class="btn btn-primary"  value="提交"></td>
    	
    </tr>
	 	 </table>
    </form>
   </body>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
	$(function(){
		$.ajax({
			url:"Post/findPost.action",
			type:"post",
			dataType:"text",
			success:function(tab){
				$("#post").empty();
				var posts=eval("("+tab+")");
				for(var i=0;i<posts.length;i++){
					//var str="<option value='"+posts[i].post_id+"'>"+posts[i].post_name+"</option>"
					var str="<option value='"+posts[i].post_id+"'>"+posts[i].post_name+"</option>"
					$("#post").append(str);
					$("#post").val($("#postinp").val());
				}
			}
		})
	}); 
	$(function(){
		$.ajax({
			url:"Status/findStatus.action",
			type:"post",
			dataType:"text",
			success:function(tab1){
				$("#status").empty();
				var statuss=eval("("+tab1+")");
				for(var i=0;i<statuss.length;i++){
					var str="<option value='"+statuss[i][0]+"'>"+statuss[i][1]+"</option>"
					$("#status").append(str);
					$("#status").val($("#statusinp").val());
				}
			}
		})
	}); 
	
	$(function(){
		$.ajax({
			url:"Station/findStationWorker.action",
			type:"post",
			dataType:"text",
			success:function(tab1){
				$("#station").empty();
				var stations=eval("("+tab1+")");
				for(var i=0;i<stations.length;i++){
					var str="<option value='"+stations[i][0]+"'>"+stations[i][1]+"</option>"
					$("#station").append(str);
					$("#station").val($("#inp").val());
				}
			}
		})
	}); 

	
	
</script>
</html>


