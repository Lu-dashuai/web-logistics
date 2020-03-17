<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findComego.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <link rel="stylesheet" href="css/bootstrap.min.css" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap-table.css" />
	<script src="js/bootstrap-table.js"></script>
	<script src="js/bootstrap-table-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery.treegrid.min.js"></script>
	<script type="text/javascript" src="js/jquery.treegrid.bootstrap3.js"></script>
	<script type="text/javascript" src="js/treeGrid.js"></script> -->
	<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/lightning3/css/bootstrap-table.css" />
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
	<script src="/lightning3/js/bootstrap.min.js"></script>
	<script src="/lightning3/js/bootstrap-table.js"></script>
	<script src="/lightning3/js/bootstrap-table-zh-CN.js"></script>
	
  </head>
  
  
  <body>
    <table id="table">
    	<div id="toolbar">
			<div class="btn-group">
				<button type="button" class="btn btn-primary" id="inWarehose">入库</button>
				<button type="button" class="btn btn-primary" id="goWarehose">出库</button>
				<button type="button" class="btn btn-info" id="updateBtn">修改</button>
				<button type="button" class="btn btn-default" id="busIndent">发车</button>
			</div>
		</div>
    </table>
    <!-- 模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">
					<form action="" method="post" role="form" id="myForm" enctype="multipart/form-data">
						<table class="table">
							<tbody>
								<tr>
									<th>选择车辆</th>
									<td>
										<input type="hidden" name="indent_id" id="indent">
										<input type="hidden" name="come.comego_time" id="time">
										<select id="Car" class="form-control" name="car. car_id">
											<!-- <option></option> -->
											<!-- <option>2</option> -->
									</select></td>
								</tr>
								<!-- <tr>
									<th>出发网点</th>
									<td>
										<select name="station.station_id" id="goStation"></select>
										<input type="text" class="form-control" name="menu.menuName" placeholder="请输入名称" id="menuName">
									</td>
								</tr>
								<tr>
									<th>到达网点</th>
									<td>
										<select name="station.station_id" id="arriveStation"></select>
										<input type="text" class="form-control" name="menu.menuUrl" placeholder="请输入地址">
									</td>
								</tr> -->
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btnButton">提交  </button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
		<!--  -->
		<!-- 模态框1 -->
		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">
					<form action="" method="post" role="form" id="myForm" enctype="multipart/form-data">
						<table class="table">
							<tbody>
								<tr>
									<th>选择车辆</th>
									<td>
										<input type="hidden" name="indent_id" id="indent1">
										<input type="hidden" name="come.comego_time" id="time1">
										<select id="Car1" class="form-control" name="car. car_id">
											<!-- <option></option> -->
											<!-- <option>2</option> -->
									</select></td>
								</tr>
								<!-- <tr>
									<th>出发网点</th>
									<td>
										<select name="station.station_id" id="goStation"></select>
										<input type="text" class="form-control" name="menu.menuName" placeholder="请输入名称" id="menuName">
									</td>
								</tr>
								<tr>
									<th>到达网点</th>
									<td>
										<select name="station.station_id" id="arriveStation"></select>
										<input type="text" class="form-control" name="menu.menuUrl" placeholder="请输入地址">
									</td>
								</tr> -->
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btnButton1">提交  </button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
		<!--  -->
  </body>
</html>
<script>
$(function() {
	InitMainTable();
});
function InitMainTable(){
	//记录页面bootstrap-table全局变量$table，方便应用
	var queryUrl = '/lightning3/Comego/findComego.action'//action 地址
	$('#table').bootstrapTable({
		url : queryUrl, //请求后台的URL（*）
		method : 'POST', //请求方式（*）
		toolbar: '#toolbar',              //工具按钮用哪个容器
		striped : true, //是否显示行间隔色
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : true, //是否启用排序
		pageNumber : 1, //初始化加载第一页，默认第一页,并记录
		pageSize : 5, //每页的记录行数（*）
		pageList : [5, 10, 25, 50, 100 ], //可供选择的每页的行数（*）
		search : true, //是否显示表格搜索
		strictSearch : false,//服务端分页 
		showColumns : true, //是否显示所有的列（选择显示的列）
		showRefresh : true, //是否显示刷新按钮
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		//height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "comego_id", //每一行的唯一标识，一般为主键列
		//showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
		//cardView: false,                    //是否显示详细视图
		//detailView: false,                  //是否显示父子表
		//得到查询的参数
		/*  queryParams : function (params) {
		     //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		     var temp = {   
		         rows: params.limit,                         //页面大小
		         page: (params.offset / params.limit) + 1,   //页码
		         sort: params.sort,      //排序列名  
		         sortOrder: params.order //排位命令（desc，asc） 
		     };
		     return temp;
		 }, *//* <td>出入库编号</td>
 		<td>订单编号</td>
		<td>出入库状态</td>
		<td>出入库时间</td>
		<td>所属网点</td>
		<td>所属车辆</td> */
		columns : [ [ {
			checkbox : true,
			visible : true,
		//是否显示复选框  
		}, {//显示行列
			field : 'comego_id',//数据库字段
			title : '出入库编号',//定义的列名
			sortable : true,
			visible:false
		}, {/* come.comego_id,come.comego_indent,sta.status_name,come.comego_time,stat.station_address,car.car_type */
			field : 'indent_id',
			title : '订单编号',
			sortable : true
		}, {
			field : 'situation_name',
			title : '出入库状态',
			sortable : true
		}, {
			field : 'comego_time',
			title : '出入库时间',
			sortable : true,
			formatter: function (value, row, index) {  
                return changeDateFormat(value)  
            }
		} /* , {
			field : 'station_name',
			title : '所属网点',
			sortable : true
		} */, {
			field : 'cartype_name',
			title : '所属车辆',
			sortable : true
		}] ]
		/* onDblClickRow : function(row) {
			window.location.href="/lightning3/Comego/showOneComego.action?comego.comego_id="+row.comego_id;
		} */ 
	});
};
/**
 * 点击入库按钮  增加入库信息 
 */
$("#inWarehose").on('click', function() {
	var rows = $('#table').bootstrapTable("getSelections");
	var count=0;
	if(rows.length>0){
		var indentid=new Array();
		for(var i=0;i<rows.length;i++){
			if(rows[i].situation_name=="入库"){
				count++;
			}else{
				indentid.push(rows[i].indent_id);
			}
		}
		if(count==0){
			$("#myModal").modal("show");
			$.ajax({
				url:"/lightning3/Comego/insertAllComego.action",
				dataType:"json",
				type:"post",
				/* data:{"indent_id":indentid.join(",")}, */
				success:function(data){
					var ind=indentid.join(",");
					$("#indent").val(ind);
					for(var i=0;i<data.length;i++){
						var str="<option value='"+data[i].car_id+"'>"+data[i].car_code+"</option>";
	 					$("#Car").append(str);
					}
				}
			});
		}else{
			alert("选中的订单中，有已经入库的，请重新选择");
		}
	}
});
/**
 * 
 */
 $("#goWarehose").on('click', function() {
		var rows = $('#table').bootstrapTable("getSelections");
		var count=0;
		if(rows.length>0){
			var indentid=new Array();
			for(var i=0;i<rows.length;i++){
				if(rows[i].situation_name=="出库"){
					count++;
				}else{
					indentid.push(rows[i].indent_id);
				}
			}
			if(count==0){
				$("#myModal1").modal("show");
				$.ajax({
					url:"/lightning3/Comego/insertAllComegogo.action",
					dataType:"json",
					type:"post",
					/* data:{"indent_id":indentid.join(",")}, */
					success:function(data){
						var ind=indentid.join(",");
						$("#indent1").val(ind);
						for(var i=0;i<data.length;i++){
							var str="<option value='"+data[i].car_id+"'>"+data[i].car_code+"</option>";
		 					$("#Car1").append(str);
						}
					}
				});
			}else{
				alert("选中的订单中，有已经出库的，请重新选择");
			}
		}
	});
/**
 * 修改出入库记录表 
 */
$("#updateBtn").on('click',function(){
		var  comegoid;
	var rows = $('#table').bootstrapTable("getSelections");//获取选中行的所有是数据
	if(rows.length>0 && rows.length<2){
		for(var i=0;i<rows.length;i++){
			comegoid=rows[i].comego_id;
		}
	window.location.href="/lightning3/Comego/showOneComego.action?comego.comego_id="+comegoid;
	}else{
		if(rows.length==0){
			alert("请选择一条数据进行修改");
		}else{
			alert("只能选择一条数据进行修改 ");
		}
	}
});
/**
 * 模态框中 点击提交按钮事件，增加入库信息
 */
$("#btnButton").on('click',function(){
	var dent=$("#indent").val();
	var car=$("#Car").val();
	showTime();
	var time=$("#time").val();
		window.location.href="/lightning3/Comego/insertComego.action?indentid="+dent+"&comego.comego_car="+car+"&comego.comego_time="+time;
});
/**
 * 模态框中 点击提交按钮事件，增加出库信息
 */
$("#btnButton1").on('click',function(){
	var dent=$("#indent1").val();
	var car=$("#Car1").val();
	showTime1();
	var time=$("#time1").val();
	window.location.href="/lightning3/Comego/insertComegogo.action?indentid="+dent+"&comego.comego_car="+car+"&comego.comego_time="+time;
});
//修改——转换日期格式(时间戳转换为datetime格式)  
function changeDateFormat(cellval) {  
    if (cellval != null) {  
        var date = new Date(parseInt(cellval, 10));  
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;  
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();  
        return date.getFullYear() + "-" + month + "-" + currentDate;  
    }    
}
      /* 模态框调用方法 */
      function showTime(){//直接获取系统时间
  		var year=new Date().getFullYear();
  		var month=new Date().getMonth()+1;
  		var day=new Date().getDate();
  		var time=year+"-"+month+"-"+day;
  		$("#time").val(time);
  	}
      function showTime1(){//直接获取系统时间
    		var year=new Date().getFullYear();
    		var month=new Date().getMonth()+1;
    		var day=new Date().getDate();
    		var time=year+"-"+month+"-"+day;
    		$("#time1").val(time);
    	}
</script>