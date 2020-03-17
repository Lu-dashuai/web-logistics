<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>马六甲物流公司后台登录</title>
	<!-- Custom Theme files -->
	<link href="css/style1.css" rel="stylesheet" type="text/css" media="all"/>
	<!-- Custom Theme files -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="keywords" content="后台登录" />
	
	
	 
	<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>


  </head>
  
  <body>
		<div class="login-form">
			<div class="top-login">
				<span><img src="images/group.png" alt=""/></span>
			</div>
			<h1>马六甲物流管理系统登陆</h1>
			<div class="login-top">
			<form action="admin/ifLogin.do" method="post">
				<div class="login-ic">
					<i ></i>
					<input type="text"  name="username" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'User name';}"/>
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password"  name="password" value="" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'password';}"/>
					<div class="clear"> </div>
				</div>
			
				<div class="log-bwn">
					<input type="submit"  value="登陆" >
				</div>
				</form>
			</div>
			<p class="copy">建议使用火狐浏览器登陆</p>
	</div>
  </body>
</html>
