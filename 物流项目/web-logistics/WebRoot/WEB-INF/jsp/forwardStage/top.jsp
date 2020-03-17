<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style1.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />	
  </head>
  
  <body>
    <div class="index-top">
		</div>
		<nav class="navbar navbar-inverse site-navbar">
			<div class="about-nav-py">
				<div class="container">
					<div class="navbar-header">
						
						<button type="button" class="navbar-toggle collapsed jicheng" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		                    <span class="sr-only">Toggle navigation</span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		               </button>
		               <a class="navbar-brand" href=""><img alt="Brand" src="imgs/logo.png" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/logo.png"></a>
					</div>
					<div id="navbar" class="collapse navbar-collapse">
						<ul class="nav navbar-nav nav-top-quanju">
							<li>
								<a href="forward/index.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp">网站首页</a>
							</li>
							<li>
								<a href="forward/about.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/about.jsp" class="active-daohang">关于我们</a>
							</li>
							<li>
								<a href="forward/yewu.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu.jsp">业务范围</a>
							</li>
							
							<li>
								<a href="forward/xiadan.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/xiadan.jsp">网上下单</a>
							</li>
							<li>
								<a href="forward/dingdanchaxun.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/xiadan.jsp">订单查询</a>
							</li>
							<li>
								<a href="forward/history.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/xiadan.jsp">订单物流查询</a>
							</li>
							<li>
								<a href="forward/contact.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/contact.jsp">联系我们</a>
							</li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</nav>
		<div id="wrapper" class="about-page">
			<img src="imgs/7htc.jpg" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/7htc.jpg" class="about-page-img" />
		</div>
  </body>
</html>
