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
  <style>
	table th{
		text-align: center;
	}
	#checkChange input{
		border:0px;
		width:100%;
	}
	</style>
  <body>
  	<div align="center"><h3>门店订单统计</h3></div>
	   <table id="tt" class="easyui-datagrid"   style="width:100%;height:50%;"
			pagination="true" fitColumns="true" rownumbers="true" toolbar="#tb" iconCls="icon-more" data-options="singleSelect:true,collapsible:true,
			url:'finance/page.do',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'billtype',width:100,align:'center'" sortable="true">账单类型</th>
					<th data-options="field:'spendtype',width:80,align:'center'" formatter='formatState1'>支出类型</th>
					<th data-options="field:'remark',width:80,align:'center',sortable:true">支出备注</th>
					<th data-options="field:'addtime',width:80,align:'center'">账单时间</th>
					<th data-options="field:'money',width:80,align:'center',sortable:true">支出金额</th>
				</tr>
			</thead>
		</table>
		
		<div id="tb" style="padding:3px">
		<select id="cc" class="easyui-combobox" name="billtype"  style="width:200px;">   
		    <option value="">请选择账单类型</option>   
		    <option>异常金额</option>   
		    <option>维修金额</option>   
		    <option>订单金额</option>
		</select> 
		<select id="dd" class="easyui-combobox" name="spendtype"  style="width:200px;">   
		    <option value="">请选择支出类型</option>   
		    <option value="1">支出</option>   
		    <option value="2">收入</option>     
		</select> 
			<input name="begintime" id="d1" type="text" data-options="formatter:formatter,parser:parser"    class="easyui-datebox" >到
			<input name="endtime" id="d2" type="text" data-options="formatter:formatter,parser:parser"   class="easyui-datebox" >
			<a   class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
		</div>
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true"  buttons="#dlg-buttons">
		</div>
		
		
		
		<div align="center"><h3>收支总计</h3></div>
		<table id="tt" class="easyui-datagrid"   style="width:100%;height:50%;"
			pagination="true" fitColumns="true" rownumbers="true"  iconCls="icon-more" data-options="singleSelect:true,collapsible:true,
			url:'finance/list.do',method:'post'">
		
		<thead>
				<tr>
					<th data-options="field:'zzc',width:100,align:'center'" sortable="true">支出总金额</th>
					<th data-options="field:'zsr',width:80,align:'center'" >收入总金额</th>
					<th data-options="field:'zwx',width:80,align:'center',sortable:true">维修总金额</th>
					<th data-options="field:'zdd',width:80,align:'center'">订单总金额</th>
					<th data-options="field:'zyc',width:80,align:'center',sortable:true">异常总金额</th>
				</tr>
			</thead>
			<%-- <c:forEach items="${financeList}" var="finance">
	              <tr  align="center">
		              <td>${finance.zzc}</td>
		              <td>${finance.zsr}</td>
		              <td>${finance.zwx}</td>
		              <td>${finance.zdd}</td>
		              <td>${finance.zyc}</td>
	              </tr>
	          </c:forEach> --%>
		</table>
		<script type="text/javascript">
		//添加序号
		 $(function () {
            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html(' 序号 ');
        	}) 
		//查询方法
		  function doSearch(){
				$('#tt').datagrid('load',{
					billtype: $('#cc').val(),
					spendtype: $('#dd').val(),
					begintime: $('#d1').val(),
					endtime: $('#d2').val()	
				});
		 }
		//给单数字状态换成汉字状态1代表支出2代表收入
		function formatState1(value,row,index){//val 当前列的值  row取当前行的值
	    	if (row.spendtype==2){
	    		return '收入';
	    	} else if (row.spendtype==1){
	    		return '支出';
	    	}   
  	 	 }
		 
	 //修改日历框的显示格式 
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
