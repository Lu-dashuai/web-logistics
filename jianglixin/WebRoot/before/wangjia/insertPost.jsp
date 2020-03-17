<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showPost.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path}/css/bootstrap.css"/>
  </head>
  
  <body>
  	
    <form action="Post/insertPost.action" method="post">
    <table class="table account table-border">
    	<thead>
    		<th>职位编号</th><th>职位类型</th>
    	</thead>
    	<tr class="success table-hover"><td>职位编号：</td> <td><input name="post.post_id"></td></tr>
 		<tr class="warning table-hover"><td>职位名字：</td> <td><input name="post.post_name"></td></tr>
   		<tr class="danger table-hover"><td>确认提交</td><td>  <input  class="btn btn-primary" type="submit" value="提交"></td></tr>
    </table>
    	
    	
    	
    </form>
  </body>
</html>
