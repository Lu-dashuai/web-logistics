<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理.....</title>

<jsp:include page="/limit/common/include.jsp"></jsp:include>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.bootstrap3.js"></script>

<script type="text/javascript" src="/lightning3/limit/js/treeGrid.js"></script>
<script type="text/javascript" src="/lightning3/later/makui/showAll.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<!-- <script type="text/javascript" src="/lightning3/js/jquery-3.2.1.min.js"></script> -->

</head>
<body>
	<table id="table"></table>

	<div id="toolbar">
		<div class="btn-group">
<!-- 			<a href="http://localhost:8080/lightning3/later/makui/insertUsers.jsp"><button type="button" class="btn btn-primary" id="addBtn">增加</button></a>--> 
<!-- 			<button type="button" class="btn btn-info" id="updateBtn">修改</button> -->
<!-- 			<button type="button" class="btn btn-default" id="delMenusBtn">删除</button> -->
		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
<!-- 					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4> -->
					
					<h4 class="modal-title" id="myModalLabel">用户信息录入</h4>
					
				</div>
				<div class="modal-body">
<!-------------------------------------------------------添加用户--------------------------------------------------------- -->

<!-------------------------------------------------------添加用户--------------------------------------------------------- -->
				
	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btnButton">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
