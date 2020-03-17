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
	
	<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />	
  		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  	<script type="text/javascript">
  		
  	</script>
  	<style type="text/css">
  		.num{
  			color:blue;
  		}
  		#zi{
  			color:green;
  		}
  	</style>
  </head>
  
  <body>
    	<jsp:include page="top.jsp" flush = "true"></jsp:include>
    <form action="forward/index.do" method="post">		
		<div class="about-us">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="cebian">
							<img src="imgs/ww.png" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/ww.png"/>
							<div>
								<div></div>
								<h2>结算界面</h2>
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
						<div class="bread-xie" id="zi">
							<a href="forward/index.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp">首页</a>>>
							<a href="forward/xiadan.do">网上下单</a>
						</div>
					<c:forEach items="${orderList}" var="order" varStatus="i">
						<div class="about-jianjie clearfix">
							<div class="col-md-6">
								<div class="num">订单号<span>*</span></div>
								<input type="text" name="" id="" value="${order.order_mailnum}" />
							</div>
							<div class="col-md-6">
								<div class="num">费用<span>亲！这个价格合情合理^_^</span></div>
								<input type="text" name="" id="" value="${order.goods_cost}" />
							</div>
							<div class="col-md-6">
								<div class="num">发货人姓名<span>*</span></div>
								<input type="text" name="" id="" value="${order.sender_name}" />
							</div>
							<div class="col-md-6">
								<div class="num">发货人手机号码<span>*</span></div>
								<input type="text" name="" id="" value="${order.sender_phone}" />
							</div>
							<div class="col-md-6">
								<div class="num">收货人姓名<span>*</span></div>
								<input type="text" name="" id="" value="${order.accepter_name}" />
							</div>
							<div class="col-md-6">
								<div class="num">收货人手机号码<span>*</span></div>
								<input type="text" name="" id="" value="${order.accepter_phone}" />
							</div>
							<div class="col-md-6">
								<div class="num">收货详细地址<span>*</span></div>
								<input type="text" name="" id="" value="${order.accepter_adr}" />
							</div>
							<div class="col-md-6">
								<div><span></span></div>
							</div>
							<div class="col-md-6" style="text-align: center;">
								<input type="submit" class="btn btn-primary" value="返回首页"/>
							</div>
						</div>
			</c:forEach>
				</div>
			</div>
		</div>
		</div>
	</form>	
		<jsp:include page="bottom.jsp" flush = "true"></jsp:include>
  </body>
</html>
