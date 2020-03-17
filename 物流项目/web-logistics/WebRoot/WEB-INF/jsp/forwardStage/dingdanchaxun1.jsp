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
	
	<meta charset="utf-8" />
		<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />	
	 <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		function checkTel(){
			 var tel=$("#sender_phone").val();
			 //alert(this.val(););
		 	 var num=0;
		     var str="";
		     $("input[name$='sender_phone']").each(function(n){
		          if($(this).val()=="")
		          {
		               num++;
		               str+=$(this).attr("msg");
		          }
		     });
		     if(num>0)
		     {
		          alert(str);
		      
		     }
		     else
		     {
		     	  location.href="qtorder/selecti.do?sender_phone="+tel;
		     }	 
		}
	</script>
	<script type="text/javascript">
		function check(){
			 var tel=$("#order_mailnum").val();
			 //alert("111");
			 //alert(this.val(););
		 	 var num=0;
		     var str="";
		     $("input[name$='order_mailnum']").each(function(n){
		          if($(this).val()=="")
		          {
		               num++;
		               str+=$(this).attr("msg");
		          }
		     });
		     if(num>0)
		     {
		          alert(str);
		          return false;
		     }
		     else
		     {
		     	  return true;
		     }	
		}
	</script>
	<script type="text/javascript">
		
	</script> 	
	<style type="text/css">
 		.phone{
 			color:yellow;
 		}
 		.ziti{
 			color:orange;
 		}
 	</style>	
  
  </head>
  <body>
   		<jsp:include page="top.jsp" flush = "true"></jsp:include>
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
							<a href="forward/index.do" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp"><span class="ziti">首页</span></a>>>
							<a href="forward/dingdanchaxun.do"><span class="ziti">订单查询</span></a>
						</div>
						<div class="about-jianjie clearfix">
							<div class="col-md-6">
								<div class="phone">发货人手机号查询<span>*</span></div>
								<input type="text" name="sender_phone" id="sender_phone" value=""  msg="请您填写手机号"/>
							</div>
							<div class="col-md-6">
								<div class="phone">订单信息查询<span id="mailnumInfo">*</span></div>
								<input type="text" name="order_mailnum" id="ol" value="" msg="请您填写订单号"/>
							</div>
							<div class="col-md-6">
								<input type="button" class="btn btn-primary" value="按手机号查询" onclick="checkTel()">
							</div>
							<div class="col-md-6">
								<input type="submit" class="btn btn-primary" id="submit" value=" 按订单号查询" onclick="return check()"/>
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
