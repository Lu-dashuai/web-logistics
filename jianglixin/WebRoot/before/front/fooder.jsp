<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--     -->
		<div class="clearfix"> </div>
		<footer>
			<div class="agileits-w3layouts-footer">
				<div class="container">
					<div class="col-md-4 w3-agile-grid">
						<h5>公司简介</h5>
						<p>成立于1996年，致力成为以客户为中心，覆盖快递、快运、整车、仓储与供应链、跨境等多元业务的综合性物流供应商。
							我们凭借坚实的网络基础、强大的人才储备、深刻的市场洞悉，为跨行业的客户创造多元、灵活、高效的物流选择，
							让物流赋予企业更大的商业价值，赋予消费者更卓越的体验。德邦始终紧随客户需求而持续创新，坚持自营门店与事业合伙人相结合的网络拓展模式
							，搭建优选线路，优化运力成本，为客户提供快速高效、便捷及时、安全可靠的服务。</p>
						
					</div>
					<div class="col-md-4 w3-agile-grid">
						<h5>地址</h5>
						<div class="w3-address">
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-phone" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>手机号</h6>
									<p>+0(374) 444 262 399</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-envelope" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>邮箱地址</h6>
									<p>邮箱 :
										<a href="mailto:example@email.com"> mail@example.com</a>
									</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-map-marker" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>地点</h6>
									<p> FOSS、PDA、CRM、官网平台、APP等系统，实现营运端到端的透明化管理，多样化智能侦测和手机实时查看。
									</p>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
					<div class="col-md-4 w3-agile-grid">
						<h5>我们的汽车</h5>
						<div class="w3ls-post-grids">
							<div class="w3ls-post-grid">
								<div class="w3ls-post-img">
									<a href="#"><img src="/lightning3/before/images/p1.jpg" alt="" /></a>
								</div>
								<div class="w3ls-post-info">
									<h6><a href="#" data-toggle="modal" data-target="#myModal">卡车4号</a></h6>
									<p>2017年11月</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="w3ls-post-grid">
								<div class="w3ls-post-img">
									<a href="#"><img src="/lightning3/before/images/p2.jpg" alt="" /></a>
								</div>
								<div class="w3ls-post-info">
									<h6><a href="#" data-toggle="modal" data-target="#myModal">卡车3号</a></h6>
									<p>2017年11月</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="w3ls-post-grid">
								<div class="w3ls-post-img">
									<a href="#"><img src="/lightning3/before/images/p3.jpg" alt="" /></a>
								</div>
								<div class="w3ls-post-info">
									<h6><a href="#" data-toggle="modal" data-target="#myModal">卡车2号</a></h6>
									<p>2017年11月</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="w3ls-post-grid">
								<div class="w3ls-post-img">
									<a href="#"><img src="/lightning3/before/images/p1.jpg" alt="" /></a>
								</div>
								<div class="w3ls-post-info">
									<h6><a href="#" data-toggle="modal" data-target="#myModal">卡车1号</a></h6>
									<p>2017年11月</p>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="copyright">
				<div class="container">
					<p>版权所有 &copy; 2018.最终解释权归QY77第三组所有
					</p>
				</div>
			</div>
	<!-- 模态框 -->
	 <div class="modal fade" id="showModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="position:relative;z-index:999;">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
					</h4>
				</div>
				<div class="modal-body">
					<form action="/lightning3/Users/userslogin.action" method="post">
						<ul class="right-form">
						<li style="border:none;font-size:1.5em;">登录</li>
						<div>
							<li style="border:none">账号：<input style="border:1px solid #EBEBEB;border-radius:0.3em;" type="text" placeholder="请输入您的账号" required name="users.users_id"/></li>
							<li style="border:none">密码：<input style="border:1px solid #EBEBEB;border-radius:0.3em;" type="password" placeholder="请输入您的密码" required name="users.users_password"/></li>
									<!-- <a href="/lightning3/before/makui/Usersenter.jsp">注册</a> -->
									<input onclick="goBeforeIndex()" type="button" value="注册">
									<input type="submit" value="登录">
						<!-- /lightning3/before/makui/Usersenter.jsp -->
						</div>
						<div class="clear"> </div>
						</ul>
						<div class="clear"> </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
	
		</footer>
<!-- 		//登录验证 -->
		<script type="text/javascript">
			$(function(){
				if($("#usersname").val()!=null && $("#usersname").val()!=""){
					var name=$("#usersname").val();
					$("#login").css("display","none");
					$("#usersLogin").css("display","block");
					$("#chinaWelcome").text("欢迎你，"+name);
					
				}else{
					$("#login").css("display","block");
					$("#usersLogin").css("display","none");
				}
			});
			function goBeforeIndex(){
				$(window).attr("location","/lightning3/before/makui/Usersenter.jsp");
			}
		</script>
		
		
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event) {
					event.preventDefault();
					$('html,body').animate({
						scrollTop: $(this.hash).offset().top
					}, 1000);
				});
			});
		</script>
		<script type="text/javascript">
			$(document).ready(function() {
				/*
					var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
					};
				*/
				$().UItoTop({
					easingType: 'easeOutQuart'
				});
			});
		</script>
		<script src="/lightning3/before/js/responsiveslides.min.js"></script>
		<script>
			$(function() {
				$("#slider").responsiveSlides({
					auto: true,
					pager: false,
					nav: true,
					speed: 1000,
					namespace: "callbacks",
					before: function() {
						$('.events').append("<li>before event fired.</li>");
					},
					after: function() {
						$('.events').append("<li>after event fired.</li>");
					}
				});
			});
		</script>
		<script src="/lightning3/before/js/simplePlayer.js"></script>
		<script>
			$("document").ready(function() {
				$("#video").simplePlayer();
			});
		</script>
		<script src="/lightning3/before/js/waypoints.min.js"></script>
		<script src="/lightning3/before/js/counterup.min.js"></script>
		<script>
			jQuery(document).ready(function($) {
				$('.counter').counterUp({
					delay: 100,
					time: 1000
				});
			});
		</script>
		<script defer src="/lightning3/before/js/jquery.flexslider.js"></script>
		<script type="text/javascript">
			
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation: "slide",
					start: function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
		
		
<!-- 		模态框 -->
		<script type="text/javascript">
			$(".onlick").on("click",function(){
				$("#showModal").modal("show")
			})
			
		</script>
		
		
