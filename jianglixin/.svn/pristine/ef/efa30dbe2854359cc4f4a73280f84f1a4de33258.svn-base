<jsp:include page="/before/front/top.jsp"></jsp:include>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertCargo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		span{
			position:absolute;
		}
	</style>
  </head>
  <body>
  	<input id="usersMessage" type="button" value="点以后获取填写默认信息">
  	<input type="hidden" id="usersname" value="${users.users_name}">
  	<input type="hidden" id="usersphone" value="${users.users_phone}">
  	<input type="hidden" id="userspostcode" value="${users.users_postcode}"> 
  	<form action="Cargo/insertCargo.action" method="post">
	    <div class="container" style="border:1px solid;">
	    	<div class="col-md-12" style="border:1px solid;">
	    		<table class="table">
	    			<thead>
	    				<th>发货人信息：</th>
	    			</thead>
		    		<tr>
		    			<td>发货人姓名：</td>
		    			<td>
		    				<input type="text" id="indentname" required name="indent.indent_shipper_name">
		    				<span class="span" id="iname"></span>
		    			</td>
		    			<td>联系方式：</td>
		    			<td>
		    				<input type="text" id="indentphone" required name="indent.indent_shipper_phone">
		    				<span class="span" id="iphone"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>邮政编码：</td>
		    			<td>
		    				<input type="text" id="indentpostcode" required name="indent.indent_shipper_postcode">
		    				<span class="span" id="icode"></span>
		    			</td>
		    			<td>发货地址：</td>
		    			<td>
		    				<select id="shipperAddress" required  name="indent.indent_shipper_address">
		    				</select>
		    			</td>
		    		</tr>
	    		</table>
    		</div>
    		<div class="col-md-12" style="border:1px solid;">
    		<table class="table">
	    			<thead>
	    				<th>收货人信息：</th>
	    			</thead>
		    		<tr>
		    			<td>收货人姓名：</td>
		    			<td>
		    				<input type="text" id="receivername" required name="indent.indent_receiver_name" >
		    				<span class="span" id="rname"></span>
		    			</td>
		    			<td>联系方式：</td>
		    			<td>
		    				<input type="text" id="receiverphone" required name="indent.indent_receiver_phone">
		    				<span class="span" id="rphone"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>邮政编码：</td>
		    			<td>
		    				<input type="text" id="receiverpostcode" required name="indent.indent_receiver_postcode">
		    				<span class="span" id="rcode"></span>
		    			</td>
		    			<td>收货地址：</td>
		    			<td><select id="receiverAddress" required name="indent.indent_receiver_address"></select></td>
		    		</tr>
	    		</table>
	    	</div>
	    	<div class="col-md-12" style="border:1px solid;">
	    		<table class="table">
	    			<thead>
	    				<th>货物信息</th>
	    			</thead>
	    			<tr>
	    				<td>货物重量</td>
	    				<td>
	    					<input id="cargoweight" required name="cargo.cargo_weight">吨
	    					<span class="span" id="cweight"></span>
	    				</td>
	    				<td>货物大小：</td>
						<td>
							<input id="cargosize" required name="cargo.cargo_size">m³
							<span class="span" id="csize"></span>
						</td>
	    			</tr>
					<tr>
						<td>货物类型：</td> 
						<td>
							<select id="cargotype" name="cargo.cargo_type"></select>
						</td>
						<td>订单时间：</td>
						<td>
							<input type="text" required id="time" readonly="readonly" name="indent.indent_time">
						</td>
					</tr>
					<tr>
						<td>货物说明：</td>
						<td>
							<input id="cargoname" name="cargo.cargo_explain" required>
						<td>
						<td><input type="submit" value="提交"></td>
					</tr>				
				</table>
			</div>
	    </div>
	</form>
  </body>
  </html>

  <script>
  	$(function(){
  		$.ajax({//获取并生成下拉框type
  			url:"Type/findType.action",
  			type:"post",
  			dataType:"text",
  			success:function(tab){
  				$("#type").empty();
  				var types=eval("("+tab+")");
  				for(var i=0;i<types.length;i++){
  					var str="<option value='"+types[i][0]+"'>"+types[i][1]+"</option>"
  					$("#cargotype").append(str);
  				}
  			}
  		});
  		$.ajax({//增加发货网点下拉框
  			url:"Station/findStationWorker.action",
  			type:"post",
  			dateType:"text",
  			success:function(station){
  				$("#shipperAddress").empty();
  				$("#receiverAddress").empty();
  				var stations=eval("("+station+")");
  				for(var i=0;i<stations.length;i++){
  					var str="<option value='"+stations[i][0]+"'>"+stations[i][2]+"</option>"
  					$("#shipperAddress").append(str);
  				}
  				for(var j=0;j<stations.length;j++){
  					var str="<option value='"+stations[j][0]+"'>"+stations[j][2]+"</option>"
  					$("#receiverAddress").append(str);
  					$("#receiverAddress").val(2);
  				}
  			}
  		});
  		showTime();
  	});
  	
  	function showTime(){//直接获取系统时间
  		var year=new Date().getFullYear();
  		var month=new Date().getMonth()+1;
  		var day=new Date().getDate();
  		$("#time").val(year+"-"+month+"-"+day);
  	}
  	
  	//判段是否登录，才能获取用户信息
  	$("#usersMessage").on("click",function(){
  		if($("#usersname").val()!=null && $("#usersname").val()!=""){
  			$("#indentname").val($("#usersname").val());
  			$("#indentphone").val($("#usersphone").val());
  			$("#indentpostcode").val($("#userspostcode").val());
  		}else{
  			alert("请登录");
  		}
  	});
  	
  	//表单验证发货人
  	$("#indentname").blur(function(){//判断姓名
        var username = /^[\u4E00-\u9FA5A-Za-z]+$/;
        if(!username.test($("#indentname").val())){
         $("#iname").text("只能输入中文和英文");
        }else{
         $("#iname").text("");
        }
    });
  	$("#indentphone").blur(function(){//判断电话
	  	var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
        if(!pattern.test($("#indentphone").val())){
         $("#iphone").text("手机格式不对");
        }else{
         $("#iphone").text("");
        }
    });
	$("#indentpostcode").blur(function(){//判断邮编
		 var code= /^[1-9][0-9]{5}$/
        if(!code.test($("#indentpostcode").val())){
         $("#icode").text("邮编错误");
        }else{
         $("#icode").text("");
        }
    });
	
	
	//表单验证收货人
	$("#receivername").blur(function(){//判断姓名
        var username = /^[\u4E00-\u9FA5A-Za-z]+$/;
        if(!username.test($("#receivername").val())){
         $("#rname").text("只能输入中文和英文");
        }else{
         $("#rname").text("");
        }
    });
  	$("#receiverphone").blur(function(){//判断电话
	  	var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
        if(!pattern.test($("#receiverphone").val())){
         $("#rphone").text("手机格式不对");
        }else{
         $("#rphone").text("");
        }
    });
	$("#receiverpostcode").blur(function(){//判断邮编
		 var code= /^[1-9][0-9]{5}$/
        if(!code.test($("#receiverpostcode").val())){
         $("#rcode").text("邮编错误");
        }else{
         $("#rcode").text("");
        }
    });
	
	
	//表单验证货物
	$("#cargoweight").blur(function(){//判断重量
        var username = /^((?:-?0)|(?:-?[1-9]\d{0,2}))(?:\.\d{1,2})?$/;
        if(!username.test($("#cargoweight").val())){
         $("#cweight").text("小数有效为两位，且小于1000顿");
        }else{
         $("#cweight").text("");
        }
    });
  	$("#cargosize").blur(function(){//判断大小
	  	var pattern = /^((?:-?0)|(?:-?[1-9]\d{0,1}))(?:\.\d{1,2})?$/;
        if(!pattern.test($("#cargosize").val())){
         $("#csize").text("小数有效为两位，且小于100m³");
        }else{
         $("#csize").text("");
        }
    });
	
  	//判断能否提交
  	$("form:first").submit(function(){
  		var count=0;
  		$(".span").each(function(i){
  			if($(this).text()==""){
  				count++;
  			}
  		});
  		if($("#shipperAddress").val()!=$("#receiverAddress").val()){
  			count++;
  		}else{
  			alert("所选网点不能一致");
  		}
  		if(count==9){
  			return true;
  		}else{
  			return false;
  		}
  	});
  </script>
<jsp:include page="/before/front/fooder.jsp"></jsp:include>