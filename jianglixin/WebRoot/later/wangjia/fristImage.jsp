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
<title>后台首页统计</title>
<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css">  
	<!-- <script src="/lightning3/js/jquery.min.js"></script> -->
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
	<script src="/lightning3/js/bootstrap.min.js"></script>
</head>
<body>

<table class="table">
   <thead>
      <tr>
         <th>名称</th>
         <th>统计数</th>
      </tr>
   </thead>
   <tbody id="jiajia">
      

     
     
   </tbody>
</table>


</body>
</html>
<script>
$(function() {
	count();
});
function count(){
		$.ajax({
 			url:"Status/countList.action",
 			type:"post",
			dataType:"json",
 			success:function(tab){
 				$("#jiajia").empty();
//  				for(var i=0;i<tab.length;i++){
//  					//var str="<input name='worker.worker_post' type='checkbox' value='"+posts[i][0]+"'>"+posts[i][1]
//  					//$("#post").append(str);
//  					var str="<tr><td>在职员工总数</td><td>"+tab[i].worker_id+"</td></tr>"
//  					$("#jiajia").append(str);
//  				}
				var str0="<tr><td>在职员工总数</td><td>"+tab[0].worker_id+"</td></tr>"
				var str1="<tr><td>网点总数</td><td>"+tab[1].station_id+"</td></tr>"
				var str2="<tr><td>用户数量</td><td>"+tab[2].users_id+"</td></tr>"
				var str3="<tr><td>汽车数量</td><td>"+tab[3].car_id+"</td></tr>"
  				$("#jiajia").append(str0);
				$("#jiajia").append(str1);
				$("#jiajia").append(str2);
				$("#jiajia").append(str3);
 			}
 		});
}
</script>