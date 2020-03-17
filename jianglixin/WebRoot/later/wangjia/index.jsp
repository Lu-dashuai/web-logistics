<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>闪电物流后台管理系统</title>
		<link type="text/css" rel="stylesheet" href="/lightning3/later/wangjia/css/style.css" />
		<script type="text/javascript" src="/lightning3/later/wangjia/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/lightning3/later/wangjia/js/menu.js"></script>
	</head>

	<body>
		<div class="top"></div>
		<div id="header">
			<div class="logo">闪电物流后台管理系统</div>
			<div class="navigation">
				<ul>
					<li>欢迎您！</li>
					<li>
						${worker.worker_name}
					</li>
					<li>
						<a href="/lightning3/later/wangjia/laterdenglu/index.jsp">退出</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="content">
			<div class="left_menu">
				<ul id="nav_dot">
				</ul>
			</div>
			<div class="m-right">
				<div class="main" style="border:1px solid;">
					<iframe width="99%" height="99%" name="logistics" src="/lightning3/later/wangjia/fristImage.jsp">
					</iframe>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
		<div id="footer">
			<p>Copyright© 2015 版权所有 京ICP备05019125号-10 </p>
		</div>
		<script type="text/javascript">
			$(function(){
				showLi();
			});
			function showLi(){
				$.ajax({
					url:"/lightning3/Admin/showHavePower.action",//获取登陆者权限
					type:"post",
					dataType:"text",
					success:function(tab){
						var tabs=eval(tab);
						var arr=new Array();
						for(var i=0;i<tabs.length;i++){//将传来的权限先写出li
							if(tabs[i].power_parent==0){
								var li="<li><h4 class='M1'><span></span>"+tabs[i].power_type+"</h4>";
								li+="<div class='list-item none' id='admin"+tabs[i].power_id+"'></div>";
								li+="</li>";
								$("#nav_dot").append(li);
								arr.push(tabs[i].power_id);
							}                      
						}
						for(var m=0;m<arr.length;m++){//循环写a
							var a="";
							for(var j=0;j<tabs.length;j++){
								if(tabs[j].power_parent!=0){
									if(arr[m]==tabs[j].power_parent){
										a+="<a href='"+tabs[j].power_url+"' target='logistics'>"+tabs[j].power_type+"</a>";
									}
								}
							}
							$("#admin"+arr[m]).append(a);
						} 
						navList(12);//赋予动态下拉效果
					}
				});
			}
		</script>
	</body>

</html>
