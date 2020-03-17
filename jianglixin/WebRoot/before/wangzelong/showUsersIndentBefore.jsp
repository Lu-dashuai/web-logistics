<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/before/front/top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


    <base href="<%=basePath%>">
    
    <title>个人订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<!-- 	<link rel="stylesheet" href="css/bootstrap.min.css" /> -->
	<link rel="stylesheet" href="css/bootstrap-table.css" />
<!-- 	<script src="js/jquery-3.2.1.min.js"></script> -->
<!-- 	<script src="js/bootstrap.min.js"></script> -->
	<script src="js/bootstrap-table.js"></script>
	<script src="js/bootstrap-table-zh-CN.js"></script>



<!-- <script src="/Repositorys/js/shen/jquery-3.2.1.min.js"></script> -->
<!-- <script src="/Repositorys/js/shen/bootstrap.min.js"></script> -->
<!-- <script src="/Repositorys/js/shen/bootstrap-table.js"></script> -->
<!-- <script src="/Repositorys/js/shen/bootstrap-table-zh-CN.js"></script> -->
<!-- <script src="/Repositorys/js/shen/jquery.form.min.js"></script> -->
<!-- <link rel="stylesheet" href="/Repositorys/css/shen/bootstrap.min.css" /> -->
<!-- <link rel="stylesheet" href="/Repositorys/css/shen/bootstrap-table.css" /> -->
	<style>
		body{
			height:100%;
		}
	</style>

  </head>
  
  <body>
<!--   	<div style="border:1px solid; height:100%; position:absolute;"> -->
	   
	   <div>	<table id="table"></table> </div>
	  	<div id="toolbar" style="margin-left:20px;">
		  	<button type="button" id="insertBills" class="btn btn-primary toolbar">付款按钮</button>
		  	<button type="button" id="deleteBills" class="btn btn-danger">删除按钮</button>
		  	<button type="button" id="doubleclick" class="btn btn-danger">双击条款或选中条款后点击此按钮，查看订单详情</button>
		</div>
	    
	    <div class="modal fade" id="showModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							订单详情
						</h4>
					</div>
					<div class="modal-body" style="max-height:500px;overflow:scroll;overflow-x:auto;">
						<table class="table" id="modal-table">
							<tr>
								<td>订单号：</td>
								<td id="modal-talbe-td1"></td>
							</tr>
							<tr>
								<td>发货时间：</td>
								<td id="modal-talbe-td2"></td>
							</tr>
							<tr>
								<td>发货人姓名：</td>
								<td id="modal-talbe-td3"></td>
							</tr>
							<tr>
								<td>发货人电话：</td>
								<td id="modal-talbe-td4"></td>
							</tr>
							<tr>
								<td>发货人邮编：</td>
								<td id="modal-talbe-td5"></td>
							</tr>
							<tr>
								<td>发货人地址：</td>
								<td id="modal-talbe-td6"></td>
							</tr>
							<tr>
								<td>收货人姓名：</td>
								<td id="modal-talbe-td7"></td>
							</tr>
							<tr>
								<td>收货人电话：</td>
								<td id="modal-talbe-td8"></td>
							</tr>
							<tr>
								<td>收货人邮编：</td>
								<td id="modal-talbe-td9"></td>
							</tr>
							<tr>
								<td>收货人地址：</td>
								<td id="modal-talbe-td10"></td>
							</tr>
							<tr>
								<td>货物名称：</td>
								<td id="modal-talbe-td11"></td>
							</tr>
							<tr>
								<td>货物重量：</td>
								<td id="modal-talbe-td12"></td>
							</tr>
							<tr>
								<td>货物大小：</td>
								<td id="modal-talbe-td13"></td>
							</tr>
							<tr>
								<td>货物类型：</td>
								<td id="modal-talbe-td14"></td>
							</tr>
							<tr>
								<td>费用信息：</td>
								<td id="modal-talbe-td15"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
<!--     </div> -->
  </body>
  <jsp:include page="/before/front/fooder.jsp"></jsp:include>
</html>


<script>

	$(function(){
		InitMainTable();
	});

	function InitMainTable() {
		//记录页面bootstrap-table全局变量$table，方便应用
		var queryUrl = '/lightning3/Bills/findBills.action';
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
				field : 'indent_id',
				title : '订单号',
				sortable : true
			}, {
				field : 'indent_time',
				title : '订单时间',
				sortable : true,
				formatter: function (value, row, index) {  
                    return changeDateFormat(value)  
                } 
			},{
				field : 'cargo_explain',
				title : '货物信息',
				sortable : true
			},{
				field : 'type',
				title : '货物类型',
				sortable : true
			},{
				field : 'account_money',
				title : '付款信息',
				sortable : true,
				formatter:function(value){
					if(value!="" && value!=undefined){
						return "已付款";
					}else{
						return "未付款";
					}
				}
			}] ],
			onDblClickRow : function(row) {
				show(row.indent_id);
			}
			 
		});
		
	}
	
	function show(id){//显示模态框
		$("#showModal").modal("show");
		$.ajax({
			url:'/lightning3/Bills/findOneBills.action',
			data:{"bills.bills_indent":id},
			type:"post",
			dataType:"text",
			success:function(tab){
				var indentMessage=eval("("+tab+")");
				$.ajax({//获得网点信息
		  			url:"Station/findStationWorker.action",
		  			type:"post",
		  			dateType:"text",
		  			success:function(station){
		  				var stations=eval("("+station+")");
						for(var i=0;i<indentMessage[0].length;i++){
							if(i==1){
								indentMessage[0][i]=changeDateFormat(indentMessage[0][i]);
							}
							if(i==5||i==9){
								for(var j=0;j<stations.length;j++){
									if(stations[j][0]==indentMessage[0][i]){
										indentMessage[0][i]=stations[j][2]
									}
								}
							}
							$("#modal-talbe-td"+(i+1)).text(indentMessage[0][i]);
							
							if(indentMessage[0][i]=="" || indentMessage[0][i]==null){
								$("#modal-talbe-td"+(i+1)).text("未付费");
							}
						}
		  			}
		  		});
			}
		});
	}
	
	$("#insertBills").on("click",function(){//点击后增加未付款的订单
		var rows = $('#table').bootstrapTable("getSelections");
		var count=0;
		if (rows.length > 0) {
			var menuids = new Array();
			for (var i = 0; i < rows.length; i++) {
				if(rows[i].account_money==undefined || rows[i].account_money==""){					
					menuids.push(rows[i].indent_id);
				}else{
					count++;
				}
			}
			if(count==0){
				$.ajax({
					url:"/lightning3/Cargo/findOneCargoAgain.action",
					dataType:"text",
					type:"post",
					data:{"params":menuids.join(",")},
					success:function(moneyAll){
						showMoney(moneyAll,menuids);
					}
				});
			}else{
				alert("选择错误，所选项拥有已付款，请重新选择");
			}
		}	
	});
	function showMoney(moneyAll,menuids){//显示未付费合计价格，并判断是否购买
		var money=eval("("+moneyAll+")");
		var moneys=0;
		for(var i=0;i<money.length;i++){
			moneys+=Number(money[i]);
		}
		if(confirm("确定付"+moneys+"元么？")){
			$.post(
				"/lightning3/Account/insertAccountAgain.action",
				{"params":money.join(","),"indent_ids":menuids.join(",")},
				function(result){
 					alert(result);
 					$(window).attr("location","/lightning3/before/wangzelong/showUsersIndentBefore.jsp");
 			});
		}
	}
	$("#deleteBills").on("click",function(){//删除判断删除操作
		var rows = $('#table').bootstrapTable("getSelections");
		if (rows.length > 0) {
			var menuids = new Array();
			for (var i = 0; i < rows.length; i++) {			
				menuids.push(rows[i].indent_id);
			}
			$.ajax({
				url:"/lightning3/Account/deleteAccountAgain.action",
				dataType:"text",
				type:"post",
				data:{"params":menuids.join(",")},
				success:function(message){
					alert(message);
					$(window).attr("location","/lightning3/before/wangzelong/showUsersIndentBefore.jsp");
				}
			});
		}
	});
	$("#doubleclick").on("click",function(){//单击按钮显示详情
		var rows = $('#table').bootstrapTable("getSelections");	
		if(rows.length==1){
			id=rows[0].indent_id;
			show(id);
		}else{
			alert("请选单条数据展示订单详情");
		}
	});
	function changeDateFormat(cellval) {//改变时间格式
		if (cellval != null) {  
		    var date = new Date(parseInt(cellval, 10));  
		    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;  
		    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();  
		    return date.getFullYear() + "-" + month + "-" + currentDate;  
		}  
	}  

</script>
