<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>门店权限菜单首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	 
  </head>
  
  <body class="easyui-layout">
  
  	
  
  <!-- 左边框 -->
	<div data-options="region:'west',split:true,title:'门店管理'" style="width:220px;padding:10px;">
		  <div class="easyui-panel" style="padding:5px">
				  <ul id="tt" class="easyui-tree" data-options="url:'power/storeTree1.do',method:'get',animate:true"></ul>
		  </div>
    </div>
    
    
    
    
    <!-- 主功能区 -->
	<div data-options="region:'center',title:'门店列表'">
	   <div id="ta" class="easyui-tabs" style="width:100%;height:100%;">
	        <iframe id="ifr" scrolling="auto" frameborder="0"  src="store/page.do" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
	
	
	
	
	
	
	<script type="text/javascript">
	   //给ID为tt的数绑定onClick事件
	   $('#tt').tree({
			onClick: function(node){
				//if(node.url!='null'&&node.url!=''&&node.url!=null){
				//  alert(node.text+",url地址："+node.url);  
				  //addTab(node.text, node.url);
				  $("#ifr").attr("src","store/page.do?node="+node.id);
				//}
			}
		});
	</script>
  </body>
</html>
