<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>权限添加</title>

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
<body>
	<center>
	 
     <form action="power/add.do" method="post" >
		<table border="1" width="600px;">
			<tr align="center">
				<td>名称</td>
				<!--  id,name,parentid,state,iconcls,url  -->
				<td>
				
				<input type="text" name="name"></td>
			</tr>
			<tr align="center">
				<td>父节点</td>
				<td><input class="easyui-combotree"  name="parentid"  
				data-options="url:'power/tree.do',method:'get',required:true" 
				style="width:200px;"></td>
			</tr>
			 <tr align="center">
				<td>图标</td>
				<td><input type="text" name="iconcls" ></td>
			</tr>
			  <tr align="center">
				<td>url</td>
				<td><input type="text" name="url"></td>
			</tr>
			 <tr align="center">
				<td>状态</td>
				<td>
				<input name ="state"  type="radio" checked="checked"   value="open">打开 
				<input name ="state" type="radio"    value="closed">关闭
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="添加"></td>
			</tr>
		</table>
		
		</form>
	</center>
</body>
</html>
