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
    
    <title>My JSP 'Show.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
  
    <form action="Worker/insertWorker.action" method="post" name="myForm">
    <table class="table table-bordered table table-striped table-striped table-hover">
    <thead>
    <th>员工信息表</th><th>注册信息</th>
    </thead>
    <tr> 
    	<td>员工账号：</td><td><input onblur="checkid(this.value)" id="workerid" class='match' required placeholder="账号6~10位，纯数字" type="text" name="worker.worker_id">
    			<span>账号长度6~11位</span>
    	</td>
    </tr>
    <tr> 
    <td>员工密码：</td><td><input onblur="checkpwd(this.value)" id="password" class='match' required placeholder="密码6~10位,纯数字" type="password" name="worker.worker_password"></td>
    </tr>
    <tr>
    	<td>员工名字：</td><td><input onblur="checkname(this.value)" id="name" required placeholder="输入文字" name="worker.worker_name"></td>
    </tr>
    <tr>
    	<td>员工身份证：</td><td><input onblur="checkidcard(this.value)" id="idcard" required placeholder="输入身份证号" name="worker.worker_idcard"></td>
    </tr>
    <tr>
<!--     	<td>员工性别：</td><td><input onblur="checkidsex(this.value)" id="sex" required placeholder="性别输入1为男-2为女" id="" name="worker.worker_sex"></td> -->
		<td>员工性别</td><td><input name="worker.worker_sex" checked type="radio" value="1">&nbsp男&nbsp&nbsp&nbsp
		<input name="worker.worker_sex" type="radio" value="2">&nbsp女</td>
    </tr>
    <tr>
    	<td>员工手机号：</td><td><input onblur="checkphone(this.value)" id="phone" required placeholder="输入您的手机号码" name="worker.worker_phone"></td>
    </tr>
    
     <tr> 
     	<td>员工职位：</td><td><select id="post" required name="worker.worker_post"></select></td>
     </tr>
    
<!-- 		<tr> -->
<!--      	<td>员工职位：</td><td id="post"></td> -->
<!--      </tr> -->
    
    <tr>
    	<td>员工所属网点：</td><td><select id="station" name="worker.worker_station"></select></td>
    </tr>	
     <tr>
    	<td>员工状态：</td><td><select id="status" name="worker.worker_status"></select></td><!-- <input id="status" name="worker.worker_status"> -->
    </tr>
     <tr>
    	<td>确定输入</td><td><input id="submit" type="submit" class="btn btn-primary" value="提交"></td>
    	
    </tr>
	 	 </table>
    </form>
   </body>
<!-- <script src="js/jquery-1.8.3.min.js"></script> -->

<script>
	 function checkid(obj){ 
		 var reg = /^[0-9]\d{5,11}$/;
		 var workerid=document.getElementById("workerid").value;
		 if(obj!=""&&!reg.test(obj)){ 
		 alert('只能输入6-11位数字！');
		 $("#workerid").val('');
		 //return false; 
		 }else{
			 $.ajax({
				 url:"Worker/checkWorker.action",
				 type:"post",
				 dataType:"text",
				 data:{"worker.worker_id":workerid},
				 success:function(str){
					 
					 if(str=="false"){
						 alert("此用户已存在");
						 $("#workerid").val('');
					};
				 }
			 });
		 }
	 }
		 function checkpwd(obj){ 
				var reg = /^[0-9]\d{5,11}$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入6-11位数字！');
				$("#password").val('');
				return false; 
				}
			} 
		 function checkname(obj){ 
				var reg = /^[\u0391-\uFFE5]+$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入中文！');
				$("#name").val('');
				return false; 
				}
			} 
		 function checkidcard(obj){ 
				var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入15位或者18位身份证号');
				$("#idcard").val('');
				return false; 
				}
			} 
		 function checksex(obj){ 
				var reg = /^[1,2]+\d{1}$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入1或者2,1为男2为女');
				$("#sex").val('');
				return false; 
				}
			} 
		 function checkphone(obj){ 
				var reg = /^[1][3-8]+\d{9}$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('首字符为1第二位3-8+后面九位数字');
				$("#phone").val('');
				return false; 
				}
			} 
// 	//正则表达式验证表单--------------------------------------------------------

	//正则表达式验证表单--------------------------------------------------------
// 	 	$(function(){
//  		$.ajax({
//  			url:"Post/findPost.action",
//  			type:"post",
// 			dataType:"text",
//  			success:function(tab){
//  				$("#post").empty();
//  				var posts=eval("("+tab+")");
//  				for(var i=0;i<posts.length;i++){
//  					var str="<input name='worker.worker_post' type='checkbox' value='"+posts[i][0]+"'>"+posts[i][1]
//  					$("#post").append(str);
// 				 }
//  			}
//  		})
//  	})
// //循环worker.worker_post  看那个被选中，将选中的值拿出来
//  	$(function check(){
//  		var lens=document.getElementsByName("worker.worker_post").length;
//  		for(var i=0;i<lens;i++){
//  			if(lens[i].checked==true){
//  				alert(document.getElementsByName[i].value);
//  			}else{
//  				alert("请选择");
//  			}
//  		}
//  	})
 	$(function(){
 		$.ajax({
 			url:"Post/findPost.action",
 			type:"post",
 			dataType:"text",
 			success:function(tab){
 				$("#post").empty();
 				var posts=eval("("+tab+")");
 				for(var i=0;i<posts.length;i++){
 					var str="<option value='"+posts[i].post_id+"'>"+posts[i].post_name+"</option>";
 					$("#post").append(str);
 				 }
 			}
 		});
 	//}); 

	//$(function(){
		$.ajax({
			url:"Status/findStatus.action",
			type:"post",
			dataType:"text",
			success:function(tab1){
				$("#status").empty();
				var statuss=eval("("+tab1+")");
				for(var i=0;i<statuss.length;i++){
					var str="<option value='"+statuss[i][0]+"'>"+statuss[i][1]+"</option>";
					$("#status").append(str);
				}
			}
		});
	//}); 
	
	//$(function(){
		$.ajax({
			url:"Station/findStationWorker.action",
			type:"post",
			dataType:"text",
			success:function(tab1){
				$("#station").empty();
				var stations=eval("("+tab1+")");
				for(var i=0;i<stations.length;i++){
					var str="<option value='"+stations[i][0]+"'>"+stations[i][1]+"</option>";
					$("#station").append(str);
				}
			}
		});
	}); 
</script>
</html>


