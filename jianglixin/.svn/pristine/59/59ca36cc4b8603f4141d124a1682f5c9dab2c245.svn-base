var selectRoleid = 0;
$(function(){
	showRoleList();
	showMenusList();
	$("#role_menu_addBtn").on("click",function(){
		distributionPower();
	});
})

function distributionPower(){
	var rows = $('#tree_table').bootstrapTable("getSelections");
	if (rows.length > 0) {
		var power_ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			power_ids.push(rows[i].power_id);
		}
		var params = selectPost_id+","+power_ids.join(",");
		
		$.post("/lightning3/limit/savePostAndPower.action",{"params":params},function(result){
			alert(result);
		});
		
	}
}



function showMenusList(){
	$('#tree_table').bootstrapTable({
        class: 'table table-hover table-bordered',
        url:"/lightning3/Power/findAllPower.action",
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        toolbar:"#toolbar",
        striped: true, 
        treeCollapseAll:false,
        collapseIcon:"glyphicon glyphicon-triangle-right",
        expandIcon: "glyphicon glyphicon-triangle-bottom",
        clickToSelect:true,
        treeView: true,
        treeId: "power_id",
        treeField: "power_type",
        columns: [[{checkbox : true,visible : true},
       	 {field: 'power_id',title : "权限ID",visible:false},
       	 {field: 'power_type',title: '权限类型'},
       	 {field: 'menuUrl',title: '链接地址'}
        ]]
    });
}

function showRoleList(){
	$.post("/lightning3/Post/findAllPost.action",function(posts){
		if(posts.length>0){
			$.each(posts,function(i,post){
				$("#rolesList").append("<a href='javascript:void(0)' class='list-group-item' id='"+post.post_id+"'> "+post.post_name+" </a>");
			});
			$("#rolesList a").on("click",function(){//给角色的超链接加上click点击事件，角色id的值在这个超链接的id属性中存在，获取：$(this).attr("id")
				$('#tree_table').bootstrapTable("uncheckAll");//菜单原来如果有选中， 清空选中
				selectRoleid = $(this).attr("id");
				///baseData/limit/getAllMenusForRole.action:获取角色所对应的权限
				//需要传递参数：{roleid:$(this).attr("id")}  roleid：参数名称
				//data:角色对应的权限对象
				$.post("/lightning3/limit/findAllPowerForPost.action",{roleid:$(this).attr("id")},function(data){
					if(data.length>0){
						var rows = $('#tree_table').bootstrapTable("getData");//页面的[tree_table]中存在早已经查询出来的所有的权限对象,获取所有权限对象
						$.each(rows,function(i,row){//循环获取的所有权限对象，
							$.each(data,function(j,item){//循环角色对应的权限对象，如果外层对象与内层对象一致，则选中
								if(item.menuid==row.menuid){//如果外层对象与内层对象一致，则选中
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