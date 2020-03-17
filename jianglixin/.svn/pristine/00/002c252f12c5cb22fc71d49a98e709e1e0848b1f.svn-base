<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%--     <% --%>
<!-- //        response.setHeader("Pragma","No-Cache"); -->
<!-- //        response.setHeader("Cache-Control","No-Cache"); -->
<!-- //        response.setDateHeader("Expires", 0); -->
<%-- <%-- %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
<link rel="stylesheet" href="/lightning3/css/bootstrap-table.css" />
<script type="text/javascript" src="/lightning3/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="/lightning3/js/jquery.treegrid.bootstrap3.js"></script>
<script type="text/javascript" src="/lightning3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/lightning3/js/bootstrap-table.js"></script>
<script type="text/javascript" src="/lightning3/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/lightning3/js/jquery.form.min.js"></script>
<script type="text/javascript" src="/lightning3/js/treeGrid.js"></script>

</head>
<body>
	
	<table id="table"></table>

	<div class="btn-group" id="toolbar">
		<button id="addpower" type="button" class="btn btn-default">确认分配</button>
		<button id="addBtn1" type="button" class="btn btn-default">增加</button>
		<button id="delBtn" type="button" class="btn btn-default">删除</button>
	</div>
	

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">角色管理</h3>
					</div>
					<div class="panel-body">
						<div class="btn-group">
						
						
							<button type="button" class="btn btn-default" id="addBtn">增加</button>
							
							
<!-- 							<button type="button" class="btn btn-default">修改</button> -->
<!-- 							<button type="button" class="btn btn-default">删除</button> -->


						</div>
						<div id="postsList"></div>
					</div>
				</div>
			</div>
			<div class="col-md-9 column">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">权限菜单</h3>
					</div>
					<div class="panel-body">
						<table id="tree_table"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<!-- 	模态框 -->
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
<!------------------------------------------------------------->
					<form action="/ligntning3/Post/insertPost.action" method="post" role="form" id="myForm"
						enctype="multipart/form-data">
						<table class="table account table-border table-hover" id="table">
					    	<thead>
					    		<th>职位编号</th><th>职位类型</th>
					    	</thead>
					    	<tr class="table-hover"><td>职位编号：</td> <td><input name="post.post_id"></td></tr>
					 		<tr class="table-hover" ><td>职位名字：</td> <td ><input id="post_name" name="post.post_name"></td></tr>
					    </table>
					</form>
<!------------------------------------------------------------->
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
<!--    模态框 -->


<!-- /增加权限/-------------------- -->

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
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
<!------------------------------------------------------------->
					<form action="Power/insertPower.action" method="post" id="myForm1">
    <table class="table table-hover table-border" id="table1">
    <thead>
    	<th>权限编号</th>  <th>权限类型</th>
    </thead>
    
    	<tr class="success"><td>权限ID:</td><td><input name="power.power_id"></td></tr>
    	<tr class="warning"><td>权限类型:</td><td><input name="power.power_type"></td></tr>
    	<tr class="success"><td>权限父节点:</td><td><input name="power.power_parent"></td></tr>
    	
   	</table>
    </form>
<!------------------------------------------------------------->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btnButton1">提交</button>
				</div>
			
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
<script>
	var selectRoleid = 0;
	$(function(){
		showPost();
		showPower();
		$("#addpower").on("click",function(){
			allotAllow();
		});
	});
	
	function allotAllow(){
		var rows = $('#tree_table').bootstrapTable("getSelections");
		if (rows.length > 0) {
			var powerids = new Array();
			for (var i = 0; i < rows.length; i++) {
				powerids.push(rows[i].power_id);
			}
			var params = selectRoleid+","+powerids.join(",");
			
			$.post("/lightning3/Admin/allotAllow.action",{"params":params},function(result){
				alert(result);
			});
		}
	}

	function showPower(){
		$('#tree_table').bootstrapTable({
	        class: 'table table-hover table-bordered',
	        url:"/lightning3/Admin/showPower.action",
	        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
	        toolbar:"#toolbar",
	        striped: true, 
	        treeCollapseAll:false,
	        collapseIcon:"glyphicon glyphicon-triangle-right",
	        expandIcon: "glyphicon glyphicon-triangle-bottom",
	        clickToSelect:true,
	        treeView: true,
	        treeId: "power_id",//id列
	        treeField: "power_type",//决定由图标的列
	        columns: [[{checkbox : true,visible : true},
	       	 {field: 'power_id',title : "权力id",visible:false},
	       	 {field: 'power_type',title: '权力名称'}
	       	 //{field: 'menuUrl',title: '链接地址'}url连接地址
	        ]]
	    });
	}
	
	function showPost(){
		$.post("/lightning3/Admin/showPost.action",function(posts){
			if(posts.length>0){
				$.each(posts,function(i,post){
					$("#postsList").append("<a href='javascript:void(0)' class='list-group-item' id='"+post.post_id+"'> "+post.post_name+" </a>");
				});
				$("#postsList a").on("click",function(){//给角色的超链接加上click点击事件，角色id的值在这个超链接的id属性中存在，获取：$(this).attr("id")
					$('#tree_table').bootstrapTable("uncheckAll");//菜单原来如果有选中， 清空选中
					selectRoleid = $(this).attr("id");
					///baseData/limit/getAllMenusForRole.action:获取角色所对应的权限
					//需要传递参数：{roleid:$(this).attr("id")}  roleid：参数名称
					//data:角色对应的权限对象
					$.post("/lightning3/Admin/getAllPower.action",{"post.post_id":$(this).attr("id")},function(data){
						if(data.length>0){
							var rows = $('#tree_table').bootstrapTable("getData");//页面的[tree_table]中存在早已经查询出来的所有的权限对象,获取所有权限对象
							$.each(rows,function(i,row){//循环获取的所有权限对象，
								$.each(data,function(j,item){//循环角色对应的权限对象，如果外层对象与内层对象一致，则选中
									if(item.allow_power==row.power_id){//如果外层对象与内层对象一致，则选中
										$('#tree_table').bootstrapTable("check",i);
									}
								});
							})
						}
					},"json")
				})			
			}
		},"json");
	}
	//--------------------------------------删除------------权限------------------------
	
	
		$("#delBtn").on('click',function(){
			
			var  power_id;
		var rows = $('#tree_table').bootstrapTable("getSelections");//获取选中行的所有是数据
		if(rows.length>0 && rows.length<2){
				for(var i=0;i<rows.length;i++){
					power_id=rows[i].power_id;
					}
			//window.location.href="/lightning3/Power/deletePower.action?power.power_id="+power_id;
			$.ajax({
				url:"/lightning3/Power/deletePower.action",
				data:{"power.power_id":power_id},
				type:"post",
				dataType:"text",
				success:function(tab1){
					if(tab1==0){
						alert("无子节点，删除成功");
 					location.reload();
					}else{
						alert("有子节点，无法删除");
					}
				}
			})
		 
			
// 			$(window).attr("location","/lightning3/before/wangjia/admin.jsp");
			}
			else{
			if(rows.length==0){
				alert("请选择一条数据删除");
			}else{
				alert("只能选一条数据删除");
			}
		}
			
// 		if(count==0){
// 			alert("删除成功");
//  			//$(window).attr("location","/lightning3/before/wangjia/admin.jsp");
// 			location.reload();//只刷新数据  不刷新页面
// 		}
			
	});
	
	//--------------------------------------删除------------权限------------------------
	
	
	
	
	
// 	模态框js---------------------------------------------------
$("#btnButton").click(function() {
			if($("#post_name").val()==""){
				Common.alert({message:"职位名称不能为空。。。"});
			}else{
				
				//调用成功后的回调函数，接受ajax执行结果。
				 function showResponse(responseText, statusText)  { 
	                   if(responseText=="ok"){
 	                	   $('#table').bootstrapTable("refresh");
	                	   alert("添加成功")		
 						   $(window).attr("location","/lightning3/before/wangjia/admin.jsp");  //重新加载 
 	                	   //location.reload();只刷新数据  不刷新页面
	                   } else{
	                	   alert(responseText);
	                	  
	                   }
	                   
	             }
				 
				 var options = { 
	                        success:showResponse,  // 提交后 
	                        dataType:'text',
	                        //另外的一些属性: 
	                        url:"/lightning3/Post/insertPost.action",         // 默认是form的action，如果写的话，会覆盖from的action. 
	                        type: "post"        // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
	                    }; 
				 
				$("#myForm").ajaxSubmit(options);
			}
			return false;
		});
		
		
		$("#addBtn").on('click', function() {
			 $('#table').bootstrapTable("refresh");
			$("#myModal").modal("show");
		
		});
//-----------------------------------------------------------
	$("#btnButton1").click(function() {
			if($("#power_type").val()==""){
				Common.alert({message:"职位名称不能为空。。。"});
			}else{
				
				//调用成功后的回调函数，接受ajax执行结果。
				 function showResponse(responseText, statusText)  { 
	                   if(responseText=="ok"){
 	                	   $('#table1').bootstrapTable("refresh");
	                	   alert("添加成功")		
 						   $(window).attr("location","/lightning3/before/wangjia/admin.jsp");  //重新加载 
 	                	   //location.reload();只刷新数据  不刷新页面
	                   } else{
	                	   alert(responseText);
	                	  
	                   }
	             }
				 
				 var options = { 
	                        success:showResponse,  // 提交后 
	                        dataType:'text',
	                        //另外的一些属性: 
	                        url:"/lightning3/Power/insertPower.action",         // 默认是form的action，如果写的话，会覆盖from的action. 
	                        type: "post"        // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
	                    }; 
				 
				$("#myForm1").ajaxSubmit(options);
			}
			return false;
		});
		
		
		$("#addBtn1").on('click', function() {
			 $('#table1').bootstrapTable("refresh");
			$("#myModal1").modal("show");
		
		});
</script>