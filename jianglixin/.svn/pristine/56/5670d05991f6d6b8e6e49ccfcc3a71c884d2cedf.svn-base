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
    
    <title>My JSP 'updateIndent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  <body>
  	<form action="/lightning3/Indent/updateIndent.action" method="post">
  		<table class="table table table-striped table-hover,table table-condensed">
  			<tr>
  				<td>收货人姓名</td>
  				<td>
  					<input type="hidden" name="indent.indent_id" value="${rowIndent[0] }">
  					<input type="hidden" name="indent.indent_time" value="${rowIndent[1] }">
  					<input type="text" name="indent.indent_receiver_name" value="${rowIndent[2] }">
  				</td>
  			</tr>
  			<tr>
  				<td>收货人联系方式</td>
  				<td><input type="text" name="indent.indent_receiver_phone" value="${rowIndent[3] }"></td>
  			</tr>
  			<tr>
  				<td>收货人邮政编码</td>
  				<td><input type="text" name="indent.indent_receiver_postcode" value="${rowIndent[4] }"></td>
  			</tr>
  			<tr>
  				<td>收货人地址</td>
  				<td><input type="text" name="indent.indent_receiver_address" value="${rowIndent[5] }"></td>
  			</tr>
  			<tr>
  				<td>发货人姓名</td>
  				<td><input type="text" name="indent.indent_shipper_name" value="${rowIndent[6] }"></td>
  			</tr>
  			<tr>
  				<td>发货人手机号</td>
  				<td><input type="text" name="indent.indent_shipper_phone" value="${rowIndent[7] }"></td>
  			</tr>
  			<tr>
  				<td>发货人邮政编码</td>
  				<td><input type="text" name="indent.indent_shipper_postcode" value="${rowIndent[8] }"></td>
  			</tr>
  			<tr>
  				<td>发货人地址</td>
  				<td><input type="text" name="indent.indent_shipper_address" value="${rowIndent[9] }"></td>
  			</tr>
  		<!-- </table>
  		<table class="table table table-striped table-hover,table table-condensed"> -->
  			<tr>
  				<td>货物重量</td>
  				<td>
  					<input type="hidden" name="cargo.cargo_indent" value="${rowIndent[0] }">
  					<input type="text" name="cargo.cargo_weight" value="${rowIndent[11] }">
  				</td>
  			</tr>
  			<tr>
  				<td>货物大小</td>
  				<td><input type="text" name="cargo.cargo_size" value="${rowIndent[12] }"></td>
  			</tr>
  			<tr>
  				<td>货物类型</td>
  				<td>
  					<select name="cargo.cargo_type">
  						<c:forEach items="${tabType }" var="type">
  							<option <c:if test="${rowIndent[13] eq type[0] }">selected</c:if> value="${type[0] }">${type[1] }</option>
  						</c:forEach>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>货物备注</td>
  				<td><input type="text" name="cargo.cargo_explain" value="${rowIndent[14] }"></td>
  			</tr>
  			<tr>
  				<td clospan="2"><input type="submit" class="btn btn-primary" value="修改"></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
