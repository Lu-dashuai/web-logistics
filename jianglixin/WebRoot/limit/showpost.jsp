<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理.....</title>
<jsp:include page="/limit/common/include.jsp"></jsp:include>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.bootstrap3.js"></script>

<script type="text/javascript" src="/lightning3/limit/js/treeGrid.js"></script>
<script type="text/javascript" src="/lightning3/limit/js/menus.js"></script>

</head>
<body>
	<table id="table"></table>

	<div id="toolbar">
		<div class="btn-group">
			<button type="button" class="btn btn-primary" id="addBtn">增加</button>
<!-- 			<button type="button" class="btn btn-info">修改</button> -->
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
<!-- 					<h4 class="modal-title" id="myModalLabel"></h4>模态框（Modal）标题 -->
					<h4 class="modal-title" id="myModalLabel">权限添加</h4>
				</div>
				<div class="modal-body">
					
					<form action="/ligntning3/Post/findPost.action" method="post" role="form" id="myForm"
						enctype="multipart/form-data">
						<table class="table account table-border">
					    	<thead>
					    		<th>职位编号</th><th>职位类型</th>
					    	</thead>
					    	<tr class="success table-hover"><td>职位编号：</td> <td><input name="post.post_id"></td></tr>
					 		<tr class="warning table-hover" ><td>职位名字：</td> <td ><input id="post_name" name="post.post_name"></td></tr>
					    </table>
					</form>
					 
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btnButton">提交</button>
				</div>
			
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
