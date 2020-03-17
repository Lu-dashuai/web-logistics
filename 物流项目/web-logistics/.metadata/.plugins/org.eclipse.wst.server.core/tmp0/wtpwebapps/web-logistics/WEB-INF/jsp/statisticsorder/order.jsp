<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户分页列表</title>
    
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
  		<div align="center"><h3>门店订单统计</h3></div>
	   <table id="tt" class="easyui-datagrid"   style="width:100%;height:100%;"
			pagination="true" fitColumns="true" rownumbers="true" toolbar="#tb" iconCls="icon-more"  	data-options="singleSelect:true,collapsible:true,
			url:'orderstatistic/page.do',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'order_now_store',width:100" sortable="true">门店名称</th>
					<th data-options="field:'cnt',width:80,align:'right'">总订单数</th>
					<th data-options="field:'ycnum',width:80,align:'right'">异常单</th>
					<th data-options="field:'yclnum',width:80,align:'right'">异常单/异常率</th>
					<th data-options="field:'badorder_pay',width:80,align:'right'">赔付金额</th>
					<th data-options="field:'cost',width:80,align:'right'" sortable="true">运费金额</th>
				</tr>
			</thead>
		</table>
		
		<div id="tb" style="padding:3px">
			<span>门店查询:</span>
			<input id="order_now_store" style="line-height:26px;border:1px solid #ccc">
			<input name="begintime" id="d1" type="text" data-options="formatter:formatter,parser:parser"    class="easyui-datebox" >到
			<input name="endtime" id="d2" type="text" data-options="formatter:formatter,parser:parser"   class="easyui-datebox" >
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
		</div>
		
		
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
		</div>
		<script type="text/javascript">
		//添加序号
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html(' 序号 ');
        	}) 
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					order_now_store: $('#order_now_store').val(),
					begintime: $('#d1').val(),
					endtime: $('#d2').val()	
				});
		 }
		 
	 //修改日历框的显示格式 
	/*  function formatter(date){
	  var year = date.getFullYear(); 
	  var month = date.getMonth() + 1; 
	  var day = date.getDate(); 
	  var hour = date.getHours();
	   month = month < 10 ? '0' + month : month; day = day < 10 ? '0' + day : day;
	    hour = hour < 10 ? '0' + hour : hour; 
	     alert(year);
	    return year + "-" + month + "-" + day + "    " + hour;
	     } 
	 function parser(s){ 
		  s = s.replace(/\s+/,' ');
		  var t = Date.parse(s); 
		  if (!isNaN(t)){ return new Date(t); }
	        else { return new Date(s + ":00:00"); }
         } */
  function formatter(date){  
        var y = date.getFullYear();  
        var m = date.getMonth()+1;  
        var d = date.getDate();  
        var h = date.getHours();  
        var str = y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
        return str;  
    }  
    function parser(s){  
        if (!s) return new Date();  
        var y = s.substring(0,4);  
        var m =s.substring(5,7);  
        var d = s.substring(8,10);  
        var h = s.substring(11,14);  
        var min = s.substring(15,17);  
        var sec = s.substring(18,20);  
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){  
            return new Date(y,m-1,d);  
        } else {  
            return new Date();  
        }  
    }  
		</script>
  </body>
</html>
