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
    
    <title>My JSP 'findKeeper.jsp' starting page</title>
    
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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"> -->
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
				<button type="button" class="btn btn-primary" id="addBtn">增加</button>
				<button type="button" class="btn btn-info" id="updateBtn">修改</button>
				<!-- <button type="button" class="btn btn-default" id="delMenusBtn">删除</button> -->
			</div>
		</div>
  	</table>
  </body>
</html>
<script>
$(function() {
	InitMainTable();
});
function InitMainTable(){
	//记录页面bootstrap-table全局变量$table，方便应用
	var queryUrl = '/lightning3/Keeper/findKeeper.action'//action 地址
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
		strictSearch : false,
		showColumns : true, //是否显示所有的列（选择显示的列）
		showRefresh : true, //是否显示刷新按钮
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		//height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "keeper_worker", //每一行的唯一标识，一般为主键列
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
			checkbox : true,//true 代表显示复选框
			visible : true
		//是否显示复选框  
		}, {//显示行列
			field : 'keeper_worker',//数据库字段
			title : '员工编号',//定义的列名
			sortable : true,
			visible:false
		}, {
			field : 'worker_name',
			title : '仓库管理员姓名',
			sortable : true
		}, {
			field : 'type',
			title : '仓库名称',
			sortable : true
		}] ]/* ,
		onDblClickRow : function(row) {
			window.location.href="/lightning3/Keeper/showOneKeeper.action?keeper.keeper_worker="+row.keeper_worker;
		} */
	});
};
$("#addBtn").on('click', function() {
	window.location.href="/lightning3/Keeper/insertAllKeeper.action";
});

$("#updateBtn").on('click',function(){
	var  keeperworker;
var rows = $('#table').bootstrapTable("getSelections");
if(rows.length>0 && rows.length<2){
	for(var i=0;i<rows.length;i++){
		keeperworker=rows[i].keeper_worker;
	}
window.location.href="/lightning3/Keeper/showOneKeeper.action?keeper.keeper_worker="+keeperworker;
}else{
	if(rows.length==0){
		alert("请选择一条数据进行修改");
	}else{
		alert("只能选一条数据进行修改");
	}
}
});
</script>
