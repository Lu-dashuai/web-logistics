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
    
    <title>My JSP 'findIndent.jsp' starting page</title>
    
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
				<button type="button" class="btn btn-primary" id="comegoindent">确认发车</button>
				<!-- <button type="button" class="btn btn-primary" id="goWarehose">出库</button>
				<button type="button" class="btn btn-info" id="updateBtn">修改</button>
				<button type="button" class="btn btn-default" id="busIndent">发车</button> -->
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
										<!-- <input type="hidden" name="indent_id" id="indent">
										<input type="hidden" name="come.comego_time" id="time"> -->
										<select id="car" class="form-control" name="car. car_id"></select>
									</td>
								</tr>
								<tr>
									<th>预计运输天数</th>
									<td>
										<select id="time"  class="form-control" name="time.time_date">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
										</select>
									</td>
								</tr>
								
								<!-- <tr>
									<th>司机姓名</th>
									<td>
										<select name="station.station_id" id="worker"></select>
										<input type="text" class="form-control" name="menu.menuName" placeholder="请输入名称" id="menuName">
									</td>
								</tr> -->
								<!-- <tr>
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
					<button type="button" class="btn btn-primary" id="btnButton">提交 </button>
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
var tabStations=new Array();
$(function() {
	var tabStations=new Array();
	InitMainTable();
});
function InitMainTable(){
	//记录页面bootstrap-table全局变量$table，方便应用
	var queryUrl = '/lightning3/Indent/comegoIndent.action'//action 地址
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
		uniqueId : "indent_id", //每一行的唯一标识，一般为主键列
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
		 }, */
		 columns : [ [ {
				checkbox : true,
				visible : true
			//是否显示复选框  
			}, {//显示行列
				field : 'indent_id',//数据库字段
				title : '订单编号',//定义的列名
				sortable : true,
				visible:false
			}, {
				field : 'indent_time',
				title : '下单时间',
				sortable : true,
				//——修改——获取日期列的值进行转换  
	            formatter: function (value, row, index) {  
	                return changeDateFormat(value)  
	            }
			}, {
				field : 'indent_receiver_name',
				title : '收货人姓名',
				sortable : true
			}, {
				field : 'indent_receiver_phone',
				title : '收货人联系方式',
				sortable : true
			} , {
				field : 'indent_receiver_postcode',
				title : '收货人邮政编码',
				sortable : true
			}, {
				field : 'indent_receiver_address',
				title : '收货人地址',
				sortable : true,
				formatter: function (value) {
 					for(var i=0;i<tabStations.length;i++){
 						if(value==tabStations[i][0]){
 							return tabStations[i][2];
 						}
 					} 
				}
			}, {
				field : 'indent_shipper_name',
				title : '发货人姓名',
				sortable : true
			},{
				field : 'indent_shipper_phone',
				title : '发货人联系方式',
				sortable : true
			},{
				field : 'indent_shipper_postcode',
				title : '发货人邮政编码',
				sortable : true
			},{
				field : 'indent_shipper_address',
				title : '发货人地址',
				sortable : true,
				formatter: function (value) {
 					for(var i=0;i<tabStations.length;i++){
 						if(value==tabStations[i][0]){
 							return tabStations[i][2];
 						}
 					} 
				}
			},{
				field : 'cargo_weight',
				title : '货物重量',
				sortable : true
			},{
				field : 'cargo_size',
				title : '货物大小',
				sortable : true
			},{
				field : 'type',
				title : '货物类型',
				sortable : true
			},{
				field : 'cargo_explain',
				title : '货物备注',
				sortable : true
			},{
				field : 'situation_name',
				title : '订单状态',
				sortable : true
			}] ]
		/* onDblClickRow : function(row) {
			window.location.href="/lightning3/Comego/showOneComego.action?comego.comego_id="+row.comego_id;
		} */ 
	});
};
/**
 * 提交未出库订单，状态改为未发车,同时选择车辆以及司机 
 */
$("#comegoindent").on('click', function() {
	var rows = $('#table').bootstrapTable("getSelections");
	if(rows.length>0){
		//var indentid=new Array();
		var indid=new Array();
		for(var i=0;i<rows.length;i++){
			//indentid.push(rows[i].indent_receiver_address);
			indid.push(rows[i].indent_id);
		}
		//var ind=indentid.join(",");
		var idid=indid.join(",");
		 $.ajax({
			url:"Indent/findCarGohomeWorker.action",
			type:"post",
			datatype:"json",
			data:{"idid":idid},
			success:function(data){
				var datas=eval("("+data+")");//转换对象
				var carlist=new Array();
				var workerlist=new Array();
				$("#myModal").modal("show");
				for(var i=0;i<datas.length;i++){
					carlist=datas[i].carlist;
					for(var j=0;j<carlist.length;j++){
						var str="<option value='"+carlist[j].car_id+"'>"+carlist[j].car_code+"</option>";
						$("#car").append(str);
					}
					workerlist=datas[i].workerlist;
					for(var k=0;k<workerlist.length;k++){
						var str="<option value='"+workerlist[k].worker_id+"'>"+workerlist[k].worker_name+"</option>";
						$("#worker").append(str);
					}
				}
				$("#btnButton").on('click',function(){
					var carvalue=$("#car").val();
					var timedate=$("#time").val();
					/* var workervalue=$("#worker").val(); */
					$.ajax({
						url:"Indent/insertGoHomeCarWorker.action",
						type:"post",
						datatype:"json",
						data:{/* "ind":ind, */"carvalue":carvalue,"idid":idid,"timedate":timedate/* ,"workervalue":workervalue */},
						success:function(str){
							alert(str);
							$(window).attr("location","/lightning3/before/yuhaiyang/comegoIndent.jsp");
						}
					});
				});
				/* alert(data);
				$(window).attr("location","/lightning3/before/yuhaiyang/comegoIndent.jsp");
				location.reload(); */
			}
		}); 
		//window.location.href="/lightning3/Indent/updateIndentSituation.action?ind="+ind;
	}else{
		alert("没有选中的订单,请选择订单");
	}
});
/**
 * 获取当前时间 
 */
function changeDateFormat(cellval) {  
    if (cellval != null) {  
        var date = new Date(parseInt(cellval, 10));  
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;  
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();  
        return date.getFullYear() + "-" + month + "-" + currentDate;  
    }    
}/**
 * 显示地址为中文 
 */
function showStation(){
	$.ajax({
		url:"/lightning3/Comein/ComeinStation.action",
		dataType:"text",
		type:"post",
		success:function(tabStation){
			tabStations=eval(tabStation);
		}
	})
}
</script>