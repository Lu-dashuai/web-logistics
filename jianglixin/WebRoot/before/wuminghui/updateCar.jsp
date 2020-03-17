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
    
    <title>My JSP 'showCar.jsp' starting page</title>
    
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
  	<form action="Car/updateCarAndWay.action" method="post">
	    <table class="table table-bordered table table-striped table-striped table-hover"> 
 	      	<thead> 
 	   			 <th>车辆信息表</th><th>输入信息</th> 
 	    	</thead> 
	    	<tr> 
 	    		<td>车辆编号：</td><td><input id="id" type="hidden" name="car.car_id" value="${rowCar[0]}"></td> 
 	    	</tr> 
 	    	<tr>  
 	    		<td>车牌号：</td><td><input  type="hidden" name="car.car_code" value="${rowCar[1]}"></td> 
 	    	</tr> 
 		    <tr> 
		    	<td>车辆类型：</td><td><input  type="hidden" name="car.car_type"  value="${rowCar[2]}"></td> 
		    </tr> 
 		    <tr> 
		    	<td>车辆载重：</td><td><input type="hidden" name="car.car_size" value="${rowCar[3]}"></td> 
 		    </tr> 
 		    <tr> 
 		    	<td>车辆状态：</td> 
		    	<td> 
 		    		<input type="hidden" id="stateval"  value="${rowCar[4]}"> 
 		    		<select  id="state" name="car.car_state" ></select> 
		    	</td> 
 		    </tr> 
 		    <tr> 
 		    	<td>出发网点编号：</td> 
 		    	<td> 
 		    		<input type="hidden" id="belong" value="${rowCar[5]}"> 
		    		<select id="station" name="car.car_belong_station"></select> 
 		    	</td> 
 		    </tr> 
 		    <tr>
		    	<td>到达网点编号：</td> 
 		    	<td> 
		    		<input type="hidden" id="direction" value="${rowWay[1]}"> 
		    		<select id="station1" name="way.way_direction"></select> 
		    	</td> 
		    </tr> 
 		    <tr>
 		    	<td>确定输入</td><td><input name="way.way_km" value="${rowWay[2]}"></td> 
 		    </tr>
		    <tr> 
		    	<td>确定输入</td><td><input type="submit" value="提交" class="btn btn-primary"></td>
		    </tr>
	 	</table>
<!-- 	<input type="submit"> -->
   </form>
</body>
<script src="${path }/js/jquery-1.8.3.min.js"></script>
<script>
//车辆状态下拉框
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
					$("#state").val($("#stateval").val());
				}
			}
		});
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
  					$("#station").val($("#belong").val());
  					$("#station1").append(str);
  					$("#station1").val($("#direction").val());
  				}
  			}
  		})
	});
</script>
</html>
   