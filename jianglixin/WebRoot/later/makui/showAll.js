$(function() {
		InitMainTable();
		
		$("#updateBtn").on('click',function(){
			var  users_id;
		var rows = $('#table').bootstrapTable("getSelections");//获取选中行的所有是数据
		if(rows.length>0 && rows.length<2){
			for(var i=0;i<rows.length;i++){
				users_id=rows[i].users_id;
			}
		window.location.href="/lightning3/Users/findOneUsers.action?users.users_id="+users_id;
		}else{
			if(rows.length==0){
				alert("请选择一条数据进行修改");
			}else{
				alert("只能选一条数据进行修改");
			}
		}
	});
		
//		
//		$("#btnButton").click(function() {
//			if($("#worker_id").val()==""){
//				Common.alert({message:"职位名称不能为空。。。"});
//			}else{
//				
//				//调用成功后的回调函数，接受ajax执行结果。
//				 function showResponse(responseText, statusText)  { 
//	                   if(responseText=="ok"){
//	                	   $('#table').bootstrapTable("refresh");
//	                	   alert("添加成功")
//	                   } else{
//	                	  // alert(responseText);
//	                	   $('#table').bootstrapTable("refresh");
//	                	   alert("添加成功")
//	                   }
//	             }
//				 
//				 var options = { 
//	                        success:showResponse,  // 提交后 
//	                        dataType:'text',
//	                        //另外的一些属性: 
//	                        url:"/lightning3/Worker/insertWorker.action",         // 默认是form的action，如果写的话，会覆盖from的action. 
//	                        type: "post"        // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
//	                    }; 
//				 
//				$("#myForm").ajaxSubmit(options);
//			}
//			return false;
//		});

		$("#addBtn").on('click', function() {
			$('#table').bootstrapTable("refresh");
			$("#myModal").modal("show");
			
			
			

		});

//		$("#delMenusBtn").on('click', function() {
//			var rows = $('#table').bootstrapTable("getSelections");
//			if (rows.length <0 || rows.length >2) {
//				var ids = new Array();
//				for (var i = 0; i < rows.length; i++) {
//					ids.push(rows[i].worker_id);
//				}
//				$.post("/lightning3/Worker/deleteWorker.action", {
//					ids : ids.join(",")
//				}, function(data) {
//					if (data == 'ok') {
//						alert("删除成功");
//						$('#table').bootstrapTable("refresh");
//					} else {
//						alert(data);
//					}
//				});
//			} else {
//				alert("没有选中行");
//			}
//		});
		//-------------------------------------------------
//		$("#addBtn").on("click",function(){
//			$(function(){	
//	 			$.ajax({
//		 			url:"/lightning3/Post/findPost.action",
//		 			type:"post",
//		 			dataType:"text",
//		 			success:function(tab){
//		 				$("#post").empty();
//		 				var posts=eval("("+tab+")");
//		 				//alert(posts);
//		 				for(var i=0;i<posts.length;i++){
//		 					var str="<option value='"+posts[i].post_id+"'>"+posts[i].post_name+"</option>";
//		 					$("#post").append(str);
//		 				 }
//		 			}
//		 		})
//		 	}); 
//
//		$(function(){
//			$.ajax({
//				url:"/lightning3/Status/findStatus.action",
//				type:"post",
//				dataType:"text",
//				success:function(tab1){
//					$("#status").empty();
//					var statuss=eval("("+tab1+")");
//					for(var i=0;i<statuss.length;i++){
//						var str="<option value='"+statuss[i][0]+"'>"+statuss[i][1]+"</option>";
//						$("#status").append(str);
//					}
//				}
//			})
//		}); 
//		
//		$(function(){
//			$.ajax({
//				url:"/lightning3/Station/findStationWorker.action",
//				type:"post",
//				dataType:"text",
//				success:function(tab1){
//					$("#station").empty();
//					var stations=eval("("+tab1+")");
//					for(var i=0;i<stations.length;i++){
//						var str="<option value='"+stations[i][0]+"'>"+stations[i][1]+"</option>";
//						$("#station").append(str);
//					}
//				}
//			})
//		});
//		});
//---------------------------------------------------
	})


	function InitMainTable() {
		//记录页面bootstrap-table全局变量$table，方便应用
		var queryUrl = '/lightning3/Users/findUsers.action'
		$('#table').bootstrapTable({
			url : queryUrl, //请求后台的URL（*）
			treeView: true,
	        treeId: "users_id",
	        treeField: "users_password",
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
			uniqueId : "users_id", //每一行的唯一标识，一般为主键列
			//showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
			//cardView: false,                    //是否显示详细视图
			//detailView: false,                  //是否显示父子表
			//得到查询的参数
//			  queryParams : function (params) {
//			     //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
//			     var temp = {   
//			         rows: params.limit,                         //页面大小
//			         page: (params.offset / params.limit) + 1,   //页码
//			         sort: params.sort,      //排序列名  
//			         sortOrder: params.order //排位命令（desc，asc） 
//			     };
//			     return temp;
//			 }, 
			columns : [ [ {
				checkbox : true,
				visible : true
			//是否显示复选框  
			}, {
				field : 'users_id',
				title : 'ID',
				sortable : true,
				
			}, {
				field : 'users_password',
				title : '用户密码',
				sortable : true
				
			}, {
				field : 'users_name',
				title : '用户姓名',
				sortable : true
			} , {
				field : 'users_phone',
				title : '用户电话',
				sortable : true
			} , {
				field : 'users_idcard',
				title : '身份证号',
				sortable : true,
				//visible : false
			} , {
				field : 'users_postcode',
				title : '邮编',
				sortable : true
			} ] ],
		});
	};
//	<script src="js/jquery-1.8.3.min.js"></script>
//	<script>
//	 	 	$(function(){
//	  		$.ajax({
//	  			url:"Post/findPost.action",
//	  			type:"post",
//	 			dataType:"text",
//	  			success:function(tab){
//	  				$("#post").empty();
//	  				var posts=eval("("+tab+")");
//	  				for(var i=0;i<posts.length;i++){
//	  					var str="<input name='worker.worker_post' type='checkbox' value='"+posts[i][0]+"'>"+posts[i][1]
//	  					$("#post").append(str);
//	 				 }
//	  			}
//	  		})
//	  	})
	// //循环worker.worker_post  看那个被选中，将选中的值拿出来
//	  	$(function check(){
//	  		var lens=document.getElementsByName("worker.worker_post").length;
//	  		for(var i=0;i<lens;i++){
//	  			if(lens[i].checked==true){
//	  				alert(document.getElementsByName[i].value);
//	  			}else{
//	  				alert("请选择");
//	  			}
//	  		}
//	  	})

//		
//	</script>