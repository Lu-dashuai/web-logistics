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
    
    <title>My JSP 'insertWay.jsp' starting page</title>
    
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
   <form action="Way/insertWay.action" method="post">
   <table  class="table table-bordered table table-striiped table-striped table-hover">
   <thead><th>路线信息</th></thead>
   <tr>
   	<td>车辆id</td>
   	<td><select required id="way" name="way.way_car"></select></td>
   </tr>
    <tr>
   	<td>运送到那个网点</td>
   	<td><select required id="wayway" name="way.way_direction"></select></td>
   </tr>
   <tr>
   	<td>运输距离</td>
   	<td><input required id="km" onblur="checkNumber(this.value)"  name="way.way_km"></td>
   </tr>
   </table>
      	<input class="btn btn-primary btn-lg btn-block" type="submit" value="提交">
   </form>
  </body>
     <script src="js/jquery-1.8.3.min.js"></script>
  <script>
  //正则表达式验证是否为数字
  function checkNumber(obj){
		var reg = /^[0-9]+$/;
		if(obj!=""&&!reg.test(obj)){
		alert('只能输入数字！');
		$("#km").val("");
		return false;
		}
} 
  
  
  //车辆ID下拉框
  	$(function(){
  		$.ajax({
  			url:"Car/findCarcar.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab1){
  				$("#way").empty();
  				var ways=eval("("+tab1+")");
  				for(var i=0;i<ways.length;i++){
  					var str="<option value='"+ways[i][0]+"'>"+ways[i][0]+"</option>";
  					$("#way").append(str);
  				}
  			}
  		})
  	});
  	
  	//网点ID下拉框
	$(function(){ 
  		$.ajax({
  			url:"Car/findStation.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab1){
  				$("#wayway").empty();
  				var ways=eval("("+tab1+")");
  				for(var i=0;i<ways.length;i++){
  					var str="<option value='"+ways[i][0]+"'>"+ways[i][1]+"</option>";
  					$("#wayway").append(str);
  				}
  			}
  		})
  	});
  	</script>
</html>
