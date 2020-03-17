<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>马六甲物流有限公司</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style1.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
	<body>
		<jsp:include page="top.jsp" flush = "true"></jsp:include>
		<div class="about-us">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="cebian">
							<img src="imgs/ww.png" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/ww.png"/>
							<div>
								<div></div>
								<h2>业务范围</h2>
								<p>BUSINESS</p>
							</div>
						</div>
						<div class="ab-cebian"></div>
						<div class="cebian-list">
							<ul>
								<li><a href="yewu.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu.html">轿车托运</a></li>
								<li><a href="yewu-2.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu-2.html">长途搬家</a></li>
								<li><a href="yewu-3.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu-3.html">航空运输</a></li>
								<li><a href="yewu-4.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu-4.html">公路运输</a></li>
							</ul>
						</div>
						<div class="ab-cebian"></div>
						<div class="cebian-lianxi">
							<div><strong>全国服务热线 :</strong></div>
							<div><span>0512-57995109</span></div>
							<div><strong>TEL:</strong>0512-57995109</div>
							<div><strong>QQ:</strong>1927732720</div>
						</div>
					</div>
					<div class="col-sm-10">
						<div class="bread-xie">
							<a href="index.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.html">首页</a>>><a href="yewu.html" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/yewu.html">业务范围</a>>>长途搬家
						</div>
						<div class="about-jianjie yewu clearfix">
							<div class="col-md-4">
								<img src="imgs/pr2.jpg" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/pr2.jpg"/>
								<!--<p><a href="">轿车托运</a></p>-->
							</div>
							<div class="col-md-4">
								<img src="imgs/pr3.jpg" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/pr3.jpg"/>
								<!--<p><a href="">轿车托运</a></p>-->
							</div>
							<div class="col-md-4">
								<img src="imgs/pr4.jpg" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/pr4.jpg"/>
								<!--<p><a href="">轿车托运</a></p>-->
							</div>
							<div class="col-md-4">
								<img src="imgs/pr5.jpg" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/pr5.jpg"/>
								<!--<p><a href="">轿车托运</a></p>-->
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="bottom.jsp" flush = "true"></jsp:include>
</html>
