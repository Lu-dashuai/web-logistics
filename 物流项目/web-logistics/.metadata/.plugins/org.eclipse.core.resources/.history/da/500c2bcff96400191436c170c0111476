<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限菜单首页</title>
    
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
  		<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
		%>
  	<div data-options="region:'north',border:false" style="height:80px;background:#B3DFDA;padding:2px" >
  		<div>
  			<table border="1px">
  				<tr>
  					<td>用户名：</td>
  					<td>${empList[0].username}</td>
  					<td>姓名：</td>
  					<td>${empList[0].ename}</td>
  				</tr>
  				
  				<tr>
  					<td>门店所在地：</td>
  					<td>${empList[0].store }</td>
  					<td>时间：</td>
  					<td><%=now %></td>
  				</tr>
  			</table>
  		</div>
  		<div>
  			<img src="" height="100%" width="100%"/>
  		</div>
  	</div>
  
  <!-- 左边框 -->
	<div data-options="region:'west',split:true,title:'功能菜单'" style="width:220px;padding:10px;">
		  <div class="easyui-panel" style="padding:5px">
				  <ul id="tt" class="easyui-tree" data-options="url:'power/tree.do',method:'get',animate:true"></ul>
		  </div>
    </div>
    
    
    
    
    <!-- 主功能区 -->
	<div data-options="region:'center',title:'主功能区'">
	   <div id="ta" class="easyui-tabs" style="width:100%;height:100%;">
	        <iframe id="ifr" scrolling="auto" frameborder="0"  src="power/forword.do" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
	
	
	
	
	
	
	<script type="text/javascript">
	   //给ID为tt的数绑定onClick事件
	   $('#tt').tree({
			onClick: function(node){
				//if(node.url!='null'&&node.url!=''&&node.url!=null){
				//  alert(node.text+",url地址："+node.url);  
				  //addTab(node.text, node.url);
				  $("#ifr").attr("src",node.url);
				//}
			}
		});
	</script>
  </body>
</html>
