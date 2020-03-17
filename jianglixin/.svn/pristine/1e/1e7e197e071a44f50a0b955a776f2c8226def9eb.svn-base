<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="iconfont/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/lightning3/js/jquery-3.2.1.min.js"></script>
<style>
	body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
	.wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*ææ´ä¸ªå±å¹çæ­£æå¼--èä¸è½èªå·±å®ç°å±ä¸­*/
	.main_content{background:url(images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
	.form-group{position:relative;}
	.login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
	.login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
	.icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
	.font16{font-size:16px;}
	
/*   	.mg-t20{margin-top:20px;} */ */
/*   	@media (min-width:200px){.pd-xs-20{padding:20px;}}  */
/*   	@media (min-width:768px){.pd-sm-50{padding:50px;}}  */

	#grad {
	  background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
	  background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
	  background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
	  background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* æ åçè¯­æ³ */
	}
</style>

</head>

<body style="background:url(images/bg.jpg) no-repeat;">
    
    <div class="container wrap1" style="height:450px;">
            <h2 class="mg-b20 text-center">闪电物流后台管理系统</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-center font16">管理员登录</p>
                <form action="/lightning3/Worker/workerlogin.action" method="post">
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input class="login_input" id="workerid" name="worker.worker_id" onblur="checkid(this.value)" placeholder="请输入用户名" /><!-- placeholder="请输入用户名" -->
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-lock icon_font"></i>
                        <input type="password" id="workerpwd" class="login_input" name="worker.worker_password" onblur="checkpwd(this.value)" placeholder="请输入密码" />
                    </div>
                    <div class="checkbox mg-b25">
                        <label>
<!--                             <input type="checkbox" /> -->
                        </label>
                    </div>
                    <button type="submit" class="login_btn" id="submit">登 录</button>
               </form>
<div style="text-align:center;">一生只做一件事，闪电物流，只为给你生活带来方便</div>      
</body>

<script language=javascript> 
//验证只能为数字 
function checkid(obj){ 
var reg = /^[0-9]\d{5,11}$/; 
if(obj!=""&&!reg.test(obj)){ 
alert('只能输入6-11位数字！');
$("#workerid").val('');
return false; 
}
} 
function checkpwd(obj){ 
	var reg = /^[0-9]\d{5,11}$/; 
	if(obj!=""&&!reg.test(obj)){ 
	alert('只能输入6-11位数字！');
	$("#workerpwd").val('');
	return false; 
	}
	} 

	
</script>



</html>
	



