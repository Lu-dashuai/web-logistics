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
    
    <title>My JSP 'findIndent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <link rel="stylesheet" href="css/bootstrap.min.css" />
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap-table.css" />
	<script src="js/bootstrap-table.js"></script>
	<script src="js/bootstrap-table-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery.treegrid.min.js"></script>
	<script type="text/javascript" src="js/jquery.treegrid.bootstrap3.js"></script>
	<script type="text/javascript" src="js/treeGrid.js"></script> -->
	<link rel="stylesheet" href="/lightning3/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/lightning3/css/bootstrap-table.css" />
	<script src="/lightning3/js/jquery-3.2.1.min.js"></script>
	<script src="/lightning3/js/bootstrap.min.js"></script>
	<script src="/lightning3/js/bootstrap-table.js"></script>
	<script src="/lightning3/js/bootstrap-table-zh-CN.js"></script>
	 <script src="/lightning3/js/echarts.min.js"></script>
  </head>
<body>
	 <!-- <table   class="table table table-striped table-hover,table table-condensed">
	 	<thead>
	 		<th>订单数量</th>
	 		<th>日期</th>
	 	</thead>
	 	<tbody id="ind"></tbody>
	 	
	 </table> -->
	 <center><div id="main" style="width: 600px;height:400px;"></div></center>
</body>
</html>
<script type="text/javascript">
$(function() {
	photo();
	$.ajax({
		url:"Indent/findDateIndent.action",
		type:"post",
		datatype:"json",
		success:function(indents){
			var indent=eval("("+indents+")");
			for(var i=0;i<indent.length;i++){
				var inde=indent[i];
				for(var j=0;j<inde.length;j++){
					/* var time= testDate.format(inde[j].indent_time); */
					var str="<tr><td>"+inde[j].sum+"</td><td>"+inde[j].indent_time+"</td></tr>"; 
					$("#ind").append(str);
				}
			}
		}
	});
});
	
	function photo(){
	$.ajax({
		url:"Indent/findNowDateIndent.action",
		type:"post",
		datatype:"json",
		success:function(data){
			var datas=eval("("+data+")");
			var date;
			 for(var i=0;i<datas.length;i++){
             	date=datas[i].sum;
             }
			 var riqi=getNowFormatDate();
			 $.ajax({
				 url:"Indent/findBeforeDateIndent.action",
				 type:"post",
				datatype:"json",
				success:function(str){
					var strs=eval("("+str+")");
					var coun;
					for(var i=0;i<strs.length;i++){
		             	coun=strs[i].sum;
		             }
					var beforeriqi=getNowFormatDate1();
					$.ajax({
						url:"Indent/findBeforeIndent.action",
						 type:"post",
						datatype:"json",
						success:function(strr){
							var strrs=eval("("+strr+")");
							var counn;
							for(var i=0;i<strrs.length;i++){
				             	counn=strrs[i].sum;
				             }
							var beforer=getNowFormatDate2();
							// 基于准备好的dom，初始化echarts实例
					        var myChart = echarts.init(document.getElementById('main'));

					        // 指定图表的配置项和数据
					        var option = {
					            title: {
					                text: '三天内订单的数量'
					            },
					            tooltip: {},
					            legend: {
					                data:['销量']
					            },
					            xAxis: {
					                data: [""+beforer+"",""+beforeriqi+"",""+riqi+""/* ,"羊毛衫","雪纺衫","裤子","高跟鞋","袜子" */]
					            },
					            yAxis: {},
					            series: [{
					                name: '销量',
					                type: 'bar',
					               	data: [counn,coun,date]
					            }]
					        };
					     // 使用刚指定的配置项和数据显示图表。
					        myChart.setOption(option);
						}
					        
					});			        	
				}
			 });
		}
	});
}
	function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	}
	function getNowFormatDate1() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate()-1;
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	}
	function getNowFormatDate2() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate()-2;
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	}
    </script>