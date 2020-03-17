<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
<script src="/lightning3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/lightning3/css/bootstrap-table.css" />
<script src="/lightning3/js/bootstrap-table.js"></script>
<script src="/lightning3/js/bootstrap-table-zh-CN.js"></script>
<script src="/lightning3/js/jquery.form.min.js"></script>
<!-- 弹出确认框 -->
<input type="hidden" id="common_alert_btn"
	class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#common_alert_model">
<div id="common_alert_model" class="modal" style="top:170px; z-index:100000">
	<div class="modal-dialog modal-lg" style="width:520px;">
		<div class="modal-content">
			<div class="modal-body small" >
				<div style="padding-top:30px; padding-bottom: 30px; overflow: hidden;">
					<div class="glyphicon glyphicon-warning-sign pull-left" style="font-size:38px;margin-left: 30px; width:40px;"></div>
					<div class="message pull-left" style="font-size:18px;margin-left: 10px;"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info ok" style="width:160px"
					data-dismiss="modal">确认</button>
			</div>
		</div>
	</div>
</div>

<script>
var Common = {
		confirm : function(params) {
			var model = $("#common_confirm_model");
			//model.find(".title").html(params.title)
			model.find(".message").html(params.message)

			$("#common_confirm_btn").click()
			// 每次都将监听先关闭，防止多次监听发生，确保只有一次监听
			model.find(".cancel").off("click")
			model.find(".ok").off("click")
			model.find(".ok").on("click", function() {
				params.operate(true)
			})
			model.find(".cancel").on("click", function() {
				params.operate(false)
			})
		},
		alert:function(params){
			var model = $("#common_alert_model");
			//model.find(".title").html(params.title)
			model.find(".message").html(params.message)
			$("#common_alert_btn").click()
			// 每次都将监听先关闭，防止多次监听发生，确保只有一次监听
			model.find(".ok").off("click")
			model.find(".ok").on("click", function() {
				params.operate(true)
			})
		}
	}
</script>