<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>马六甲物流有限公司</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.search_box{
				    width: 430px;
				    float: left;
					}
		.zi{
  					color:green;
  			}
  		.ziti{
  					color:blue;
  		}				
	</style>
	<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />	
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    	<jsp:include page="forward/top.do" flush = "true"></jsp:include>
  	<form action="qtorder/select.do" method="post">	
		<div class="about-us">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="cebian">
							<img src="imgs/ww.png" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/ww.png"/>
							<div>
								<div></div>
								<h2>订单查询</h2>
								<p>ORDERED</p>
							</div>
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
							<a href="forward/index.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp"><span class="ziti">首页</span></a>&nbsp;&nbsp;
							<a href="forward/xiadan.do">网上下单</a>&nbsp;&nbsp;
							<a href="forward/history.do">历史在线查询</a>
						</div>
						<div class="about-jianjie clearfix">
							<table width="600px;">
								<thead>
									<tr align="center">
										<th>订单号</th>
										<th>车车牌号</th>
										<th>订单现在地</th>
										<th>到达时间</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list}" var="order"  >
									<tr>
										<td>${order.history_order_number}</td>
										<td>${order.history_car_number}</td>
										<td>${order.history_store}</td>
										<td>${order.history_time}</td>
									</tr>
								</c:forEach>
								</tbody>							
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="forward/bottom.do" flush = "true"></jsp:include>
		</form>
  </body>
</html>
