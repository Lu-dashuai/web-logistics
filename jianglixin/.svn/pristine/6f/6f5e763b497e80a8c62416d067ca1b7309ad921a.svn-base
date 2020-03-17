<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<link href="/lightning3/before/css/styles.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<!--//webfonts-->
		<title>修改密码...</title>
</head>
<%-- 	<script src="${path }/statics/bootstrap/js/jQuery-2.1.4.min.js"></script> --%>
<%-- 	<script src="${path }/statics/bootstrap/js/bootstrap.js"></script> --%>
<%-- 	<script src="${path }/statics/bootstrap/js/bootstrap-theme.css"></script> --%>
<%-- 	<link rel="stylesheet" href="${path }/statics/bootstrap/css/bootstrap.css"> --%>
		<script type="text/javascript" src="/lightning3/before/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="/lightning3/before/js/bootstrap.js"></script>
		<script type="text/javascript" src="/lightning3/before/js/jquery-2.1.4.min.js"></script>
		<link href="/lightning3/before/css/bootstrap.css">
	<style>
	
		#updatepass{
			border:1px solid #E2E2E2;
			padding:30px;
			margin-left:10px;
		}
		input{
			margin-top:20px;
		}
		#top{
			color:red;
		}
		#niu{
			margin-top:10px;
		}
	</style>
	<script>
		//判断是否为登录
		$(function(){
			var password=$("#p1").attr("mima");
			if(password=="" || password=="undefined"){
				window.location.href="/lightning3/before/front/index.jsp"
			}
		})
		//修改密码验证是否一致
		function checkInput(obj){
			var state=true;
			var id=obj.id;
			var value=obj.value;
			var classname=$(obj).attr("class");
			var tishi=$(obj).attr("tishi");
			if(classname.indexOf("pwd")>-1){
				var password=$(obj).attr("mima");
				if(value!=password){
					$("#"+id+"wrong").html(tishi);
					state=false;
				}else{
					$("#"+id+"wrong").html("");
				}
			}
			if(classname.indexOf("pass")>-1){
				var pwdReg=/^\w{6,8}$/;
				if(!pwdReg.test(value)){
					$("#"+id+"wrong").html(tishi);
					state=false;
				}else{
					$("#"+id+"wrong").html("");
				}
			}
			if(classname.indexOf("quepass")>-1){
				var pass=$("#p2").val();
				if(value!=pass){
					$("#"+id+"wrong").html(tishi);
					state=false;
				}else{
					$("#"+id+"wrong").html("");
				}
			}
			
		}
		function checkForm(){
			var count = 0;
			var objs =$("input");
			objs.each(function(){
				var id = this.id;
				if(id!="submitButton" && id!="loginButton"){
					if($(this).val()!=""){
						if($("#"+id+"wrong").text()==""){
							count++;
						}
					}
				}
			});
			if(count==3){
				var pass=$("#p2").val();
				/* location.href="updatepass.action?pass="+pass; */
				$.post("/lightning3/Users/updatepass.action",{pass:pass},function(data){
					top.location="/lightning3/before/front/index.jsp";
					/* $("#su").submit(); */
				});
			}
		}
	</script>
<body>
	<div id="updatepass" class="input-group-lg  ">
		<form action="#" method="post" id="su">
				<legend id="top">修改密码..</legend>
			<div class=" form-group has-success has-feedback">
				<input type="password" class="pwd" class="form-control input-lg " id="p1" placeholder="请输入旧密码" tishi="密码错误" onblur="checkInput(this)" mima="${users.users_password }">
				<span class="glyphion glyphion-ok form-control-feedback" id="p1wrong" aria-hidden="true"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="password"  class="pass" class="form-control input-lg" id="p2" placeholder="请输入新密码" tishi="密码为6-8个字母或数字组成" onblur="checkInput(this)">
				<span class="glyphion glyphion-ok form-control-feedback" id="p2wrong" aria-hidden="true"></span>
			</div>              
			<div class="form-group has-success has-feedback">
				<input type="password"  class="quepass" class="form-control input-lg" id="p3" placeholder="请再次输入密码" tishi="两次输入密码不一样" onblur="checkInput(this)">
				<span class="glyphion glyphion-ok form-control-feedback" id="p3wrong" aria-hidden="true"></span>
			</div>
			<div id="niu">
				<button type="button" onclick="return checkForm()" class="btn btn-success btn-lg">修改</button>
			</div>
		</form>
	</div>
 </body>
</html>
