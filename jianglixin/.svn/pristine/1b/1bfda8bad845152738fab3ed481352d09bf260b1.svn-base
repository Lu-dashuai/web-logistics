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
    
    <title>My JSP 'insertCar.jsp' starting page</title>
    
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
    <form action="Car/insertCar.action" method="post">
    <table class="table table-bordered table table-striiped table-striped table-hover">
    	<thead>
    		<th>车辆信息</th>
    		<th>输入信息</th>
    	</thead>
    	<tr>
    		<td>1.车辆编号</td><td><input type="hidden" placeholder="编号1-6位" name="car.car_id"></td>
    	</tr>
    	<tr>
    		<td>2.车牌号</td><td><input  required id="cheinp" onblur="che(this.value)" placeholder="请输入车牌号" name="car.car_code"></td>
    	</tr>
    	<tr>
    		<td>3.车辆类型</td><td><select  required  id="cartype" placeholder="详细填写" name="car.car_type"></select></td>
    	</tr>
    	<tr>
    		<td>4.车辆载重容量</td><td><input  required id="sizeinp" onblur="checkSizeNumber(this.value)" placeholder="容量大小" name="car.car_size"></td>
    	</tr>
    	<tr>
    		<td>5.车辆状态</td><td><select  required  id="state" name="car.car_state"></select></td>
    	</tr>
    	<tr>
    		<td>6.所属网点名称</td><td><select  required  id="station" name="car.car_belong_station"></select></td>
    	</tr>
    	<tr>
    		<td>7.送达网点名称</td><td><select  required  id="station1" name="way.way_direction"></select></td>
    	</tr>
    	<tr>
    		<td>7.路程距离</td><td><input id="roadinp" onblur="checkNumber(this.value)"  required  placeholder="路程" name="way.way_km"></td>
    	</tr>
    </table>
    <input type="submit" value="提交">
    </form>
      </body>
     <script src="js/jquery-1.8.3.min.js"></script>
  <script>
  //正则表达式验证车牌号
	function che(obj){
		var reg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		if(obj!=""&&!reg.test(obj)){
		alert('必须输入正确车牌号！');
		$("#cheinp").val("");
		return false;
	}
}
  //正则表达式验证是否为数字
	function checkSizeNumber(obj){
		var reg = /^[0-9]+$/;
		if(obj!=""&&!reg.test(obj)){
		alert('只能输入数字！');
		$("#sizeinp").val("");
		return false;
		}
}
	 //正则表达式验证是否为数字
	function checkNumber(obj){
		var reg = /^[0-9]+$/;
		if(obj!=""&&!reg.test(obj)){
		alert('只能输入数字！');
		$("#roadinp").val("");
		return false;
		}
		} 



  	
  //ajax传输数据
  	$(function(){
  		$.ajax({
  			url:"Car/findState.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab1){
  				$("#state").empty();
  				var states=eval("("+tab1+")");
  				for(var i=0;i<states.length;i++){
  					var str="<option value='"+states[i][0]+"'>"+states[i][1]+"</option>";
  					$("#state").append(str);
  					$("#state").val(2);
  				}
  			}
  		})
  	});
  
  //传输网点ID
		$(function(){
  		$.ajax({	
  			url:"Car/findStation.action",		
  			type:"post",
  			dataType:"text",
  			success:function(tab1){
  				$("#station").empty();
  				var stations=eval("("+tab1+")");
  				for(var i=0;i<stations.length;i++){
  					var str="<option value='"+stations[i][0]+"'>"+stations[i][1]+"</option>";
  					$("#station").append(str);
  					$("#station1").append(str);
  				}
  			}
  		})
  	});
  
  
  	
    //	传输车辆类型下拉框
	$(function(){
  		$.ajax({
  			url:"Car/findCartype.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab1){
  				$("#cartype").empty();
  				var cartypes=eval("("+tab1+")");
  				for(var i=0;i<cartypes.length;i++){
  					var str="<option value='"+cartypes[i][0]+"'>"+cartypes[i][1]+"</option>";
  					$("#cartype").append(str);
  				}
  			}
  		})
  	});
  </script>
 
</html>
