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
		<link rel="stylesheet" type="text/css" href="css/style1.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />
		<style type="text/css">
			p{color:red;}
		</style>	
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
								<h2>关于我们</h2>
								<p>ABOUT US</p>
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
							<a href="forward/about.do">关于我们</a>
						</div>
						<div class="about-jianjie">
							<p>马六甲物流有限公司是一家经工商、交通、税务等有关部门审核通过签发《企业经营许可证》《道路运输许可证》《税务登记证》》《组织机构代码证》批准专业从事综合性的物流企业。公司凭着稳定、可靠、安全的运营网络、科学的资源整合、先进的管理技术，可为各类企业、个人、在校学生、提供全方位的物流服务，我们将一如既往地坚持“以客为本、服务领先” 的经营理念，为客户提供门对门、仓对仓的一站式服务。</p>
							<p>公司凭着稳定、可靠、安全的运营网络、科学的资源整合、先进的管理技术，可为各类企业、个人、在校学生、提供全方位的物流服务，我们将一如既往地坚持“以客为本、服务领先” 的经营理念，为客户提供门对门、仓对仓的一站式服务。</p>
							<p>马六甲物流有限公司是集代理、物流配送、航空速递、公路运输、铁路运输、仓储、城际配送于一体，跨区域、网络化、信息化、智能化、具有供应链管理能力的综合性物流公司、准点发车、准点到达、保证低价、全程高速，安全、快速、送货及时。</p>
							<p>多年来，公司在全体员工努力下，抢抓机遇、敢想敢为，艰苦创业、与时俱进，以果敢的胆识，通过启动社会资源，与不拘一格提拔人才，成功走出一条具有凯瑞通特色的发展之路。公司以“团结拼搏、做强做大做久”的企业精神；以“城际网络运输”的运作模式实现了从零起步的跨越式发展，创造了产值连年翻番、效益连年增长、服务连年优化、实力连年攀高的辉煌业绩，力争五年内成为国内具特色企业。</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="forward/bottom.do" flush = "true"></jsp:include>
  </body>
</html>
