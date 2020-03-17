<%@page import="com.aaa.mvc.util.RandomCount"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
	<script type="text/javascript" src="${path}/resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${path}/resource/css/bootstrap.css" type="text/css"></link>
	
	<meta charset="utf-8" />
	<meta name="viewport" content="width=1200,user-scalable=yes"><!--最大宽度1200px 允许用户缩放-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/tf.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css" />
  	

  
  	<script type="text/javascript"  src="resource/js/jquery-1.8.3.min.js"></script>
  	<script type="text/javascript">
  		window.onload = function(){
		function getDate(){
		debugger;
		var today = new Date();
		var date;
		date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate();
		return date;
		}
		window.setInterval(function(){
		document.getElementById("order_time").value=getDate();
		}, 1000);
		} 
	$(function(){
		
	});	
  	</script>
		
	
	<style type="text/css">
		.fhsf{
			height:68px;
			weight:100px;
		}
		#province{
			weight:200px;
			height:30px;
		}
		#city{
			weight:200px;
			height:30px;
		}
		#area{
			weight:200px;
			height:30px;
		}
		#province1{
			weight:200px;
			height:30px;
		}
		#city1{
			weight:200px;
			height:30px;
		}
		#area1{
			weight:200px;
			height:30px;
		}
		#province2{
			weight:200px;
			height:30px;
		}
		#city2{
			weight:200px;
			height:30px;
		}
		#area2{
			weight:200px;
			height:30px;
		}
	</style>
  	
  	<script type="text/javascript">
  	function verify(){
        //获取form标签元素
        var form=document.getElementById('form');
        //获取form下元素下所有input标签
        var inputArray=form.getElementsByTagName("input");
        var inputArrayLength=inputArray.length;
        //循环input元素数组
        for(var int=0;int<inputArrayLength;int++){
            //判断每个input元素的值是否为空
            if( inputArray[int].value==null || inputArray[int].value==''){
                alert('亲！*为必填项^_^');
                return false;
            }
        }
        //如果所有Input标签的值都不为空的话
        alert('下单成功');
        return true;
    }
  	
  	//所属门店
  		$(function(){
	  		$.post(
	 			//url
	 			"order/getStore.do",
	 			//不携带参数
	 			//{status3:3},
	 			//回调函数
	 			function(data){
					//alert(data);
	 				var str = '';
	 				if(data!=''){
	 					for(var i = 0;i<data.length;i++){
							str +="<option  value = '"+data[i].store_name+"'>"+data[i].store_name+"</option>"
	 					}
	 					$("#nowStore").append(str);
	 				}
	 			},
	 			//数据类型
	 			"json"
	 		);
  	});
  	//发货人手机号码校验
  	$(function(){
  		$("#phone").blur(function(){
  			var phone = $("#phone").val();
  			var phoneNum = /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/ ;
  			if(phoneNum.test(phone)){
  					$("#phoneSpan").html("手机号格式填写正确").css("color","green");
  			} else {
  				if(phone==''||phone==null||phone=='null'){
  					//alert(11);
  					$("#phoneSpan").html("手机号不可为空").css("color","red");
  				} else {
	  				$("#phoneSpan").html("手机号格式不正确,请填写正确的手机号格式!!").css("color","red");
  				}
  			}
  		});
  	});
  	//收货人手机号校验
  	$(function(){
  		$("#tel").blur(function(){
  			var tel = $("#tel").val();//blur失焦事件
  			var telPhone=/^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/;//手机号码正则表达式
  			if(telPhone.test(tel)){
  				$("#telSpan").html("手机号格式填写正确").css("color","green");
  			}else{
  				if(tel==''||tel==null||tel=='null'){
  					//alert(11);
  					$("#telSpan").html("手机号不可为空").css("color","red");
  				}else{
  					$("#telSpan").html("手机号格式不正确,请填写正确的手机号格式").css("color","red");
  				}
  			}
  		});
  	});
  	//邮编号码校验
  	$(function(){
  		$("#zidcode").blur(function(){
  			var postcode = $("#zidcode").val();
  			var code =/[1-9]{1}(\d+){5}/;
  			if(code.test(postcode)){
  				//alert(11)
  				$("#codeSpan").html("邮编格式正确").css("color","green");
  			}else{
  				if(postcode==''||postcode==null||postcode=='null'){//注意=不可为中文
 	 				$("#codeSpan").html("邮编号码不可为空").css("color","red");
  				}else{
  					$("#codeSpan").html("邮编格式不正确").css("color","red");
  				}
  			}
  		});
  	});
  	
  	
  	//货物重量校验
  	$(function(){
  		$("#weight").blur(function(){
  			var kg = $("#weight").val();
  			var zl =  /^\d+(\.\d+)?$/;
  			if(zl.test(kg)){
  				$("#zlSpan").html("").css("color","green");
  			}else{
  				if(kg==''||kg==null||kg=='null'){
  					$("#zlSpan").html("亲！货物重量还没填写").css("color","red");
  				}else{
  					$("#zlSpan").html("请输入数字").css("color","red");
  				}
  			}	
  		});
  	});
  	//物品价值校验
  	$(function(){
  		$("#money").blur(function(){
  			var kg = $("#money").val();
  			var zl =  /^\d+(\.\d+)?$/;
  			if(zl.test(kg)){
  				$("#jzSpan").html("").css("color","green");
  			}else{
  				if(kg==''||kg==null||kg=='null'){
  					$("#jzSpan").html("亲！物品价值还没填写").css("color","red");
  				}else{
  					$("#jzSpan").html("请输入数字").css("color","red");
  				}
  			}	
  		});
  	});
  	//报价金额校验
  	$(function(){
  		$("#quote").blur(function(){
  			var kg = $("#quote").val();
  			var zl =  /^\d+(\.\d+)?$/;
  			if(zl.test(kg)){
  				$("#quoteSpan").html("").css("color","green");
  			}else{
  				if(kg==''||kg==null||kg=='null'){
  					$("#quoteSpan").html("亲！报价金额还没填写").css("color","red");
  				}else{
  					$("#quoteSpan").html("请输入数字").css("color","red");
  				}
  			}	
  		});
  	});
  	
  	//发货人姓名不可为空
  	$(function(){
  		$("#fhname").blur(function(){
  			var phone = $("#fhname").val();

  			var phoneNum =  /^[\u4E00-\u9FA5]{2,4}$/;
  			if(phoneNum.test(phone)){
  				$("#nameSpan").html("").css("color","green");
  			} else {
  				if(phone==''||phone==null||phone=='null'){
  					//alert(11);
  					$("#nameSpan").html("亲！发货人姓名不可为空").css("color","red");
  				} else {
	  				$("#nameSpan").html("请填写正确的格式!!").css("color","red");
  				}
  			}
  		});
  	});
  	//收货人姓名不可为空
  	$(function(){
  		$("#shname").blur(function(){
  			var phone = $("#shname").val();

  			var phoneNum =/^[\u4E00-\u9FA5]{2,4}$/;
  			if(phoneNum.test(phone)){
  				$("#shSpan").html("").css("color","green");
  			} else {
  				if(phone==''||phone==null||phone=='null'){
  					//alert(11);
  					$("#shSpan").html("亲！收货人姓名不可为空").css("color","red");
  				} else {
	  				$("#shSpan").html("请填写正确的格式!!").css("color","red");
  				}
  			}
  		});
  	});
  	</script>
  	<script type="text/javascript" src="js/sanjiliandong.js"></script>
  	</head>
	<body>
	
		<jsp:include page="forward/top.do" flush = "true"></jsp:include>
		<form action="qtorder/add.do" method="post" onsubmit="return verify();" id="form">
		<div class="about-us">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="cebian">
							<img src="imgs/ww.png" tppabs="http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/ww.png"/>
							<div>
								<div></div>
								<h2>网上下单</h2>
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
							<a href="forward/xiadan.do">网上下单</a>
						</div>
						<div class="about-jianjie clearfix">
							<div class="col-md-6">所属门店<span >*</span>
								<div class="fhsf">
									<select name="province" id="province1"></select>
									<select name="city" id="city1"></select>
									<select name="area" id="area1"></select>
								</div>
							</div>
							
							<div class="col-md-6">
								<div>所属门店地址<span>*</span></div>
								<!-- <input type="text" name="sender_adr" id="address" value="" /> -->
								<input name="order_now_store" readonly="readonly" id="address1"  >
							</div>
							<div class="col-md-6"><span ></span>
								<div class="fhsf">
								</div>
							</div>
							<div class="col-md-6">
								<div>发货人姓名<span id="nameSpan">*</span></div>
								<input type="text" name="sender_name" id="fhname" value=""	 />
							</div>
							<div class="col-md-6">
								<div>发货人手机号码<span id="phoneSpan">*</span></div>
								<input type="text" name="sender_phone" id="phone" value="" />
							</div>
								
								<div class="col-md-6">发货省份<span >*</span>
									<div class="fhsf">
										<select name="province" id="province"></select>
										<select name="city" id="city"></select>
										<select name="area" id="area"></select>
									</div>
								</div>
							<div class="col-md-6">
								<div>发货详细地址<span>*</span></div>
								<!-- <input type="text" name="sender_adr" id="address" value="" /> -->
								<input name="sender_adr" id="address"  >
							</div>
							<div class="col-md-6"><span ></span>
									<div class="fhsf"></div>
								</div>
							<div class="col-md-6">
								<div>收货人姓名<span id="shSpan">*</span></div>
								<input type="text" name="accepter_name" id="shname" value="" msg="*为必填项"/>
							</div>
							<div class="col-md-6">
								<div>收货人手机号<span id="telSpan">*</span></div>
								<input type="text" name="accepter_phone" id="tel" value="" />
							</div>
							
							
							<div class="col-md-6">
								<div>收货城市<span>*</span></div>
								<div class="fhsf">
								<select name="province" id="province2"></select>
								<select name="city" id="city2"></select>
								<select name="area" id="area2"></select>
								</div>
							</div>
							<div class="col-md-6">
								<div>收货详细地址<span>*</span></div>
								<!-- <input type="text" name="accepter_adr" id="accepter_adr" value="" id="caddress1"/> -->
								<input name="accepter_adr" id="address2"  >
							</div>
							<div class="col-md-6"><span ></span>
									<div class="fhsf"></div>
							</div>
							<div class="col-md-6">
								<div>货物名称<span>*</span></div>
								<input type="text" name="goods_name" id="goods_name" value="" />
							</div>
							<div class="col-md-6">
								<div>货物重量(Kg)<span id="zlSpan">*</span></div>
								<input type="text" name="goods_weight" id="weight" value="" />
							</div>
							<div class="col-md-6">
								<div>备注<span>*</span></div>
								<input name="goods_remarks" type="text" />		
							</div>
							
							<div class="col-md-6">
								<div>付款方式<span>*</span></div>
								<select name="cost_type">
									<option value="--" selected="selected">--</option>
									<option value="现金">现金</option>
									<option value="到付">到付</option>
								</select>
							</div>
							<div class="col-md-6">
								<div>保价金额<span id="quoteSpan">*</span></div>
								<input name="goods_supportvalue" type="text" id="quote"/>		
							</div>
							<div class="col-md-6">
								<div>下单时间<span>*</span></div>
								<input type="text" name="order_time" readonly="readonly" id="order_time">
							</div>
							<div class="col-md-6">
								<div>是否保价<span>*</span></div>
								<select name="goods_ifsupportvalue">
									<option value="0" >否</option>	
									<option value="1" >是</option>	
								</select>
							</div>
							<div class="col-md-6">
								<div>邮编号码<span id="codeSpan">*</span></div>
								<input type="text" name="accepter_zipcode" id="zidcode" >
							</div>
							
							<div class="col-md-6">
								<div>物品类型<span>*</span></div>
								<select name="goods_type">
								<option value="服饰">服饰</option>
								<option value="视频">视频</option>
								<option value="文件">文件</option>
								<option value="日用品">日用品</option>
								<option value="家具">家具</option>
								<option value="家电">家电</option>
								<option value="数码">数码</option>
								<option value="食品">食品</option>
								<option value="其他">其他</option>
								</select>
							</div>
							<div class="col-md-6">
								<div>物品价值<span id="jzSpan">*</span></div>
								<input type="text" name="goods_value" id="money">
							</div>
							<%-- <div class="col-md-6">
								<div>订单号<span id="ddSpan">请您记住订单号</span></div>
								<%!String orderNum = RandomCount.getOrderIdByTime(); %>
								<input readonly="readonly" type="text" id="mailnum" name="order_mailnum" value="<%=orderNum%>">
							</div> --%>
							<div class="col-md-6">
								<div><span ></span></div>
							</div>
							<div class="col-md-6" style="text-align: center;">
								<input type="submit" class="btn btn-primary" value="提交"  />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
		<jsp:include page="forward/bottom.do" flush = "true"></jsp:include>
</html>
