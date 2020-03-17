<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/lightning3/css/bootstrap-table.css" />
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
	<script src="/lightning3/js/bootstrap.min.js"></script>
	<script src="/lightning3/js/bootstrap-table.js"></script>
	<script src="/lightning3/js/bootstrap-table-zh-CN.js"></script>
</head>
<body>
	<table id="table"></table>
	<div id="toolbar" style="margin-left:20px;">
	  	<button type="button" id="comein" class="btn btn-primary toolbar">入库</button>
	</div>
</body>
	<script>
	var tabStations=new Array();
	var tabState=new Array();
	$(function(){
		showStation();
		showState();
		InitMainTable();
	});
	function InitMainTable() {
		//记录页面bootstrap-table全局变量$table，方便应用
		var queryUrl = "/lightning3/Comein/findComeinCar.action";
		$('#table').bootstrapTable({
			url : queryUrl, //请求后台的URL（*）
			method : 'get', //请求方式（*）
			toolbar: '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			//sidePagination: "server",//服务器端分页
			sortable : true, //是否启用排序
			pageNumber : 1, //初始化加载第一页，默认第一页,并记录
			pageSize : 10, //每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
			search : true, //是否显示表格搜索
			strictSearch : false,
			showColumns : true, //是否显示所有的列（选择显示的列）
			showRefresh : false, //是否显示刷新按钮
			minimumCountColumns : 1, //最少允许的列数
			clickToSelect : false, //是否启用点击选中行
			//height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "indent_id", //每一行的唯一标识，一般为主键列
			showToggle: false,                   //是否显示详细视图和列表视图的切换按钮
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
			 }, */ 
			columns : [ [ {
				checkbox : true,
				visible : true
			//是否显示复选框  
			}, {
				field : 'car_id',
				title : '货车编号',
				sortable : true
			}, {
				field : 'car_code',
				title : '货车车牌',
				sortable : true
			},{
				field : 'car_belong_station',
				title : '所属网点',
				sortable : true,
				formatter: function (value) {
					for(var i=0;i<tabStations.length;i++){//循环所有的网店id进行判断
						if(value==tabStations[i][0]){
							return tabStations[i][1];
						}
					} 
                } 
			},{
				field : 'car_state',
				title : '货车状态',
				sortable : true,
				formatter: function (value) {  
					for(var i=0;i<tabStates.length;i++){//循环所有的typeid进行判断
						if(value==tabStates[i][0]){
							return tabStates[i][1];
						}
					} 
                } 
			}] ],
		});
	}
	function showStation(){//搜索所有的station
		$.ajax({
			url:"/lightning3/Comein/ComeinStation.action",
			dataType:"text",
			type:"post",
			success:function(tabStation){
				tabStations=eval(tabStation);
			}
		})
	}
	function showState(){//搜索所有的车辆状态
		$.ajax({
			url:"/lightning3/Comein/ComeinState.action",
			dataType:"text",
			type:"post",
			success:function(tabState){
				tabStates=eval(tabState);
			}
		})
	}
	$("#comein").on("click",function(){//点击是获取id，将id传入后台
		var rows = $('#table').bootstrapTable("getSelections");
		if (rows.length > 0) {
			var menuids = new Array();
			for (var i = 0; i < rows.length; i++) {			
				menuids.push(rows[i].car_id);
			}
			$.ajax({
				url:"/lightning3/Comein/comeinInsert.action",
				dataType:"text",
				type:"post",
				data:{"params":menuids.join(",")},
				success:function(message){
					alert(message);
					$(window).attr("location","/lightning3/before/wangzelong/comein.jsp");
				}
			});
		}
	});
	</script>
</html>