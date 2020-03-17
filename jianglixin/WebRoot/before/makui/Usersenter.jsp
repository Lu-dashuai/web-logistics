<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		 <base href="<%=basePath%>">
		<meta charset="utf-8">
		<link href="/lightning3/before/css/styles.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<!--//webfonts-->
</head>
<body>
<!-- 注册页面 -->
	<div class="main">
		<div class="header" >
			<h1>登录或创建一个免费帐户！</h1>
		</div>
		<p>本页面输入的注册信息请不要告诉任何人！</p>
			<form id="myform" class="price-selection-tree" name="myform" action="/lightning3/Users/insertUsers.action">
				<ul class="left-form">
					<h2>注册一个新的账户:</h2>
					<li>
						<input type="text" class='username match' onblur="checkid(this.value)" id="user" name='users.users_id' placeholder="必须为字母的6~11位账号" required/>
						<span class="icon" ></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password" class='match' onblur="checkpwd(this.value)" id='pwd' name="users.users_password" placeholder="请输入您要注册的密码必须大于6位" required/>
						<span class="icon tip" ></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password" name='pwd2' onblur="checkpwds(this.value)" id="pwds" placeholder="请再次输入密码" />
						<span class="icon"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="name" name="users.users_name" onblur="checkname(this.value)" class='match' placeholder="请输入您的姓名" required/>
						<span class="icon"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text"  class='match' id="tel" onblur="checkphone(this.value)" name="users.users_phone" placeholder="请输入您的手机号" required/>
						<span class="icon"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" class='match' id="IDCard" onblur="checkidcard(this.value)" name="users.users_idcard"  placeholder="请输入您的身份证号" required/>
						<span class="icon"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" class='match' id="postcode" onblur="checkpostcode(this.value)" name="users.users_postcode" placeholder="请输入您的邮编" required/>
						<span class="icon"></span>
						<div class="clear"> </div>
					</li> 
					<li>
					<input type="submit" id="submit"  value="点击注册">
					<a href="/lightning3/before/front/index.jsp">已有账号，登录</a>
						<div class="clear"> </div>
					</li>
				</ul>
				<div class="clear"> </div>
			</form>
			
		</div>
			<!-----start-copyright---->
   					<div class="copy-right">
						<p>打造最专业的物流公司，一切为了顾客，为了顾客一切，为了一切顾客</p> 
					</div>
				<!-----//end-copyright---->
</body>
<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
<script language=javascript>
		 function checkid(obj){ 
				 var reg =  /^[a-zA-Z]\w{5,10}$/;
				 var usersid=document.getElementById("user").value;
				 if(obj!=""&&!reg.test(obj)){ 
				 alert('只能输入首位必须为字母的6-11位账号！');
				 $("#user").val('');
				 	//return false; 
				 }else{
					 $.ajax({
						 url:"Users/checkUser.action",
						 type:"post",
						 dataType:"text",
						 data:{"users.users_id":usersid},
						 success:function(str){
							 
							 if(str=="false"){
								 alert("此用户已存在");
								 $("#user").val('');
							};
						 }
					 });
				 }
			 }
		 function checkpwd(obj){ 
				var reg = /^[0-9A-Za-z]{6,11}$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('6-11位任意数字或字母！');
				$("#pwd").val('');
				return false; 
				}
				}
		 function checkpwds(obj){ 
				var reg = /^[0-9A-Za-z]{6,11}$/;
				var pwd1=document.getElementById("pwd").value;
				if(obj!="" && !reg.test(obj)){ 
					alert('输入格式有误');
					$("#pwds").val('');
				}else if(obj!=pwd1){
					alert("输入密码不一致");
				}
			}
		 function checkname(obj){ 
				var reg = /^[\u0391-\uFFE5]+$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入中文！');
				$("#name").val('');
					return false; 
				}
			} 
		 function checkphone(obj){ 
				var reg = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('请输入正确的手机号码');
				$("#tel").val('');
					return false; 
				}
			} 
		 function checkidcard(obj){ 
				var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('只能输入15位或者18位身份证号');
				$("#IDCard").val('');
					return false; 
				}
			} 
		 function checkpostcode(obj){ 
				var reg = /^[1-9]\d{5}(?!\d)/; 
				if(obj!=""&&!reg.test(obj)){ 
				alert('请输入正确格式');
				$("#postcode").val('');
					return false; 
				}
			} 
		
</script>




<script type="text/javascript">
表单验证正则表达式
var reg = {
	    user:/^[a-zA-Z]\w{4,9}$/,
	    //用来判断用户名，第一位不能为数字，也就是小写字母或者大写字母，后面的内容\w表示字符（数字字母下划线）
	    //要求是5-10位字符，所以出去第一位，还需要4-9位的\w
	    pwd:/^[a-zA-Z0-9]{6,18}$/,
	    //用来判断密码，html结构中要求是数字字符6到18位，\d表示数字
	    tel:/^1[34578]\d{9}$/,
	    //用来判断电话号码，通常手机号第一位为1，第二位只可能出现3.4.5.7.8，后面剩下的9位数字随机
	   	name:/^[\u4E00-\u9FA5A-Za-z]+$/,
	   	postcode:/^[1-9]\d{5}(?!\d)/,
	    IDCard:/^[1-9]\d{16}[\dxX]$/,
	    //用来判断身份证，通常第一位不为零，所以取1-9的数字，中间的16位数字随机，最后一位要么是数字要么是X
	  };
 	  var arr = [
	    document.getElementById('user'),
 	    document.getElementById('pwd'),
	    document.getElementById('tel'),
	    document.getElementById('IDCard'),
	    document.getElementById('name'),
	    document.getElementById('postcode')
 	  ];
	  for(var i=0;i<arr.length;i++){
	    arr[i].onblur = function(){
	      if(this.value){ 
	        if(reg[this.name].test(this.value)){
	          this.parentNode.className = 'right';  //判断正确的时候加的class
	        }else{
	          this.parentNode.className = 'wrong';  //判断错误的时候加的class
	          $(this).focus();
	        };
	      };
	    }; 
	  };
	  //验证密码与再次输入密码是否一致
	  var oTip = document.getElementById('tip');
	  var opwd = document.getElementsByName('pwd2')[0];
	  opwd.onfous = function(){
	    if(!arr[0].value){
	      arr[1].focus();
	      oTip.className = 'show';
	      setTimeout(function () {
	        oTip.className = '';
	      },1000);
	    };
	  };
	  opwd.onblur = function(){
	    if(this.value){
	      if(this.value != arr[0].value){
	        this.focus();
	        this.parentNode.className ='wrong';
	      }else{
	       this.parentNode.className ='right';
	      };
	    };
	  };
 </script>
</html>
