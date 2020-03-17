<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看所有门店</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

  <script type="text/javascript">
 //省市级联
 	 $(function(){
  				//使用AJAX  方法调用后台得到数据
  				$.post(
  					"getArr/getP1.do",		//请求地址
  					function(data){					//回调函数
  						//alert(data);  			//如果是字符串，可以使用eval  JSON.stringify
  					var tempStr="";
  					//判断是否为空
  					if(data!=''){
  						for(var i=0;i<data.length;i++){
  								tempStr +="<option value='"+data[i].code+"'>"+data[i].name+"</option>";
  							}
  							$("#province").append(tempStr);
  						}
  					},
  					"json"							//定义返回值格式
  				);
  			 //默认指定市
  				getCitys(110000);
       			//默认指定区县
  				getAreas(110100); 
  		//给省份绑定change事件
       $("#province").change(function(){
           var pId = $(this).val();
           getCitys(pId);
           var shengval=$("#province").find("option:selected").text();
           $("#caddress").val(shengval);
            });
       		
  				//给市绑定change事件
  				$("#city").change(function(){
  					var cId=$(this).val();
  					getAreas(cId);
  					var shengval=$("#province").find("option:selected").text();      
  					var shival=$("#city").find("option:selected").text();
  					$("#caddress").val(shengval+shival);
  					});
  			//给县绑定change事件
  			$("#area").change(function(){
         var shengval=$("#province").find("option:selected").text();
         var shival=$("#city").find("option:selected").text();
         var xianval=$("#area").find("option:selected").text();
         $("#caddress").val(shengval+shival+xianval);
         });
  		});
  			//第二种方法 封装
  		function getAreas(cId){
  			$.post(
  					 "getArr/getA1.do",			//请求地址
  					{cityId:cId},					//携带参数
  					function(data){					//回调函数
  						var tempStr="";
  						if(data!=''){
  							$("#area").empty();		//清空所有子元素
  							for(var i=0;i<data.length;i++){
  								tempStr +="<option value='"+data[i].code+"'>"+data[i].name+"</option>";
  							}
  							$("#area").append(tempStr);
  						}
  					},
  					"json"							//返回值格式
  				);
  		}	
  		function getCitys(pid){
  			 $.post(
  				"getArr/getC1.do",				//请求地址
  				{provinceId:pid},					//请求参数
  				function(data){						//回调函数
  					var tempStr="";
  					if(data!=''){
  						$("#city").empty();			//清空所有子元素
  						for(var i=0;i<data.length;i++){
  							tempStr +="<option value='"+data[i].code+"'>"+data[i].name+"</option>";
  						}
  						//市动态变化时,默认加载市下面的区县
  						getAreas(data[0].code);
  						$("#city").append(tempStr);
  					}
  				},
  				"json"								//返回值格式
  			); 
  		}
 	 
 	</script>
  </head>
  
  <body>
     <table id="tt" class="easyui-datagrid"   title="门店分页列表" style="width:100%;height:100%;"
			pagination="true" fitColumns="true" toolbar="#tb" iconCls="icon-more"  	data-options="singleSelect:true,collapsible:true,url:'store/list.do?node=${node}',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'id',width:80,align:'center',sortable:true" hidden="true" >序号</th>
					<th data-options="field:'store_name',width:100,align:'center'">门店名称</th>
					<th data-options="field:'store_master',width:80,align:'center'">门店负责人</th>
					<th data-options="field:'store_address',width:180,align:'center'"  >门店地址</th>
					<th data-options="field:'store_tel',width:100,align:'center'">门店联系电话</th>
					<th data-options="field:'store_addTime',width:60,align:'center'">门店添加时间</th>
				</tr>
			</thead>
		</table>
		<!--搜素，添加 ，删除，查询  -->
		<div id="tb" style="padding:3px">
			<a   class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
			<a   class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
			<a   class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			<br>
			<span>门店名称:</span>
			<input id="store_name" style="line-height:26px;border:1px solid #ccc">
			<span>门店负责人:</span>
			<input id="store_master" style="line-height:26px;border:1px solid #ccc">
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
		</div>
		<!--更新，添加框  -->
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
			<div class="ftitle">门店信息</div>
			<form id="fm" method="post">
				<div class="fitem">
					<!-- <label>id:</label> -->
					<label>父节点名称:</label>
					<input class="easyui-combotree"  name="store_parentid"  
					data-options="url:'power/storeTree1.do',method:'get'" 
					style="width:200px;">
					<input name="id" class="easyui-validatebox" hidden="true">
				</div>
				
				<div class="fitem">
					<label>门店名称:</label>
					<input name="store_name" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>门店负责人:</label>
					<input name="store_master" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>门店详细地址:</label>
					<!-- <input name="store_address" class="easyui-validatebox" > -->
					<select id="province" style="width:150px;height:30px"></select>
					<select id="city" style="width:150px;height:30px"></select>
					<select id="area" style="width:150px;height:30px"></select>
					<input name="sender_adr" id="caddress" class="easyui-validatebox" style="width:180px;height:30px" >
				</div>
				<div class="fitem">
					<label>门店电话:</label>
					<input name="store_tel" class="easyui-validatebox"  >
				</div>
				<div class="fitem">
					<label>添加时间:</label>
					<input name="store_addTime" class="easyui-datebox"  >
				</div>
				
			</form>
		</div>
		<div id="dlg-buttons">
			<a   class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()"> 保存</a>
			<a   class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		<script>
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					store_name: $('#store_name').val(),
					store_master: $('#store_master').val()
				});
		 }
		 //弹出添加方法
		 function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','添加门店');
			$('#fm').form('clear');
			url = 'store/add.do';
		}
		//弹出更新方法
		function editUser(){
		   //获取选中行
		   var row = $('#tt').datagrid('getSelected');
			if (row){
			  // alert(row.id);
			     //弹出框
				$('#dlg').dialog('open').dialog('setTitle','更新门店信息');
				//加载数据 根据datagrid里面的field的名称和form表单的名称必须一致
				$('#fm').form('load',row);
				url = 'store/update.do?id='+row.id;
			}else{
			     $.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: '请至少选中一行！！！'//提示信息
				 });
			}
		}
		//保存操作(添加和保存使用的一个方法)
		function saveUser(){
			$('#fm').form('submit',{//给form表单绑定submit事件
				url: url,//请求的url地址
				onSubmit: function(){//对form表单校验。把数据传过去
					return $(this).form('validate');
				}
			});
		}
		//删除数据
		function destroyUser(){
		    //获取选中行
			var row = $('#tt').datagrid('getSelected');
			if(confirm("确认要删除")){
				location.href="store/delete.do?id="+row.id;
			}
			/* if (row){
				$.messager.confirm('Confirm','确认删除吗?',function(r){
					if (r){
					   //jquery的ajax操作  $.get(地址，参数，回调函数，返回值类型)
					   //  $.post(地址，参数，回调函数，返回值类型)
						$.post('store/delete.do',{id:row.id});
					}
				});
			}else{
			   $.messager.show({//easyui封装的浏览器右下角弹框
							title: '信息提示',//弹框标题
							msg: '请至少选中一行！！！'//提示信息
				 });
			} */
		}
		//门店详细地址失焦事件
		$("#caddress").blur(function(){
		//alert("1");
			var province=$("#province").val();
			var city=$("#city").val();
			var area=$("#area").val();
			$.post(
				'store/insert.do',
				{province:province,city:city,area:area}
			);
		});
		</script>
  </body>
</html>
