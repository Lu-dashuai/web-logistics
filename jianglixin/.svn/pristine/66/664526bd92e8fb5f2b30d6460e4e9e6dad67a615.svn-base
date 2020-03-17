$(function() {
		InitMainTable();

		$("#btnButton").click(function() {
			if($("#post_name").val()==""){
				Common.alert({message:"职位名称不能为空。。。"});
			}else{
				
				//调用成功后的回调函数，接受ajax执行结果。
				 function showResponse(responseText, statusText)  { 
	                   if(responseText=="ok"){
	                	   $('#table').bootstrapTable("refresh");
	                	   alert("添加成功")
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
			$("#myModal").modal("show");

		});

		$("#delMenusBtn").on('click', function() {
			var rows = $('#table').bootstrapTable("getSelections");
			if (rows.length > 0) {
				var ids = new Array();
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].post_id);
				}
				$.post("/lightning3/Post/deletePost.action", {
					ids : ids.join(",")
				}, function(data) {
					if (data == 'ok') {
						alert("删除成功");
						$('#table').bootstrapTable("refresh");
					} else {
						alert(data);
					}
				});
			} else {
				alert("没有选中行");
			}

		});
	})
	function InitMainTable() {
		//记录页面bootstrap-table全局变量$table，方便应用
		var queryUrl = '/lightning3/Post/findAllPost.action'
		$('#table').bootstrapTable({
			url : queryUrl, //请求后台的URL（*）
			treeView: true,
	        treeId: "post_id",
	        treeField: "post_name",
			method : 'POST', //请求方式（*）
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : true, //是否启用排序
			pageNumber : 1, //初始化加载第一页，默认第一页,并记录
			pageSize : 10, //每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
			search : true, //是否显示表格搜索
			strictSearch : false,
			showColumns : true, //是否显示所有的列（选择显示的列）
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			//height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "post_id", //每一行的唯一标识，一般为主键列
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
			}, {
				field : 'post_id',
				title : 'id',
				sortable : true,
				visible : false
			}, {
				field : 'post_name',
				title : '菜单名称',
				sortable : true
			}, {
				field : 'menuUrl',
				title : '连接地址',
				sortable : true
			} ] ],
			onDblClickRow : function(row) {
				alert(row.menuName);
			}
		});
	};