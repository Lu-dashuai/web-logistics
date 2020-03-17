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
	</style>
	<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />	
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  	<script type="text/javascript">
		//给但数字转化成汉字
		//给单数字状态换成汉字状态
		 $(function(){
		 	var status=$("#goods_status").val();
		 	if(status==1){
		 		$("#goods_status").val("待审核");
		 		$("#goods_status").css("color","red");
		 	}
		 	if(status==2){
		 		$("#goods_status").val("审核通过");
		 		$("#goods_status").css("color","blue");
		 	}
		 	if(status=='3'){
		 		$("#goods_status").val("入库");
		 		$("#goods_status").css("color","blue");
		 		
		 	}
		 	if(status==4){
		 		$("#goods_status").val("装配");
		 		$("#goods_status").css("color","blue");
		 	}
		 	if(status==5){
		 		$("#goods_status").val("已签收");
		 		$("#goods_status").css("color","green");
		 	}
		 });
	    	
	</script>
 	<script type="text/javascript">
 		function turn(){
			location.href="forward/dingdanchaxun.do"
 		};
 	</script>
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
							<a href="forward/index.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp">首页</a>&nbsp;&nbsp;
							<a href="forward/xiadan.do">网上下单</a>&nbsp;&nbsp;
							<a href="forward/dingdanchaxun.do">在线查询</a>
						</div>
						<div class="about-jianjie clearfix">
							<div class="col-md-6">
								<div class="zi">订单号<span>*</span></div>
								<input type="text" name="order_mailnum" id="" value="${list[0].order_mailnum}" />
							</div>
							<div class="col-md-6">
								<div class="zi">物品状态<span>*</span></div>
								<input type="text" name="goods_status" id="goods_status" value="${list[0].goods_status}" />
							</div>
							
							<div class="col-md-6">
								<div class="zi">货物名称<span>*</span></div>
								<input type="text" name="goods_name" id="" value="${list[0].goods_name}" />
							</div>
							<div class="col-md-6">
								<div class="zi">发货人姓名<span>*</span></div>
								<input type="text" name="sender_name" id="" value="${list[0].sender_name}" />
							</div>
							<div class="col-md-6">
								<div class="zi">发货人手机号码<span>*</span></div>
								<input type="text" name="sender_phone" id="" value="${list[0].sender_phone}" />
							</div>
							
							<div class="col-md-6">
								<div class="zi">发货详细地址<span>*</span></div>
								<input type="text" name="sender_adr" id="" value="${list[0].sender_adr}" />
							</div>
							<div class="col-md-6">
								<div class="zi">收货人姓名<span>*</span></div>
								<input type="text" name="accepter_name" id="" value="${list[0].accepter_name}" />
							</div>
							<div class="col-md-6">
								<div class="zi">收货人手机号<span>*</span></div>
								<input type="text" name="accepter_phone" id="" value="${list[0].accepter_phone}" />
							</div>
							
							<div class="col-md-6">
								<div class="zi">收货详细地址<span>*</span></div>
								<input type="text" name="accepter_adr" id="" value="${list[0].accepter_adr}" />
							</div>
							<div class="col-md-6">
								<div><span ></span></div>
							</div>
							<div class="col-md-6" style="text-align: center;">
								<input type="button" class="btn btn-primary" value="返回查询列表" onclick="return turn()" />
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="forward/bottom.do" flush = "true"></jsp:include>
		</form>
  </body>
</html>
