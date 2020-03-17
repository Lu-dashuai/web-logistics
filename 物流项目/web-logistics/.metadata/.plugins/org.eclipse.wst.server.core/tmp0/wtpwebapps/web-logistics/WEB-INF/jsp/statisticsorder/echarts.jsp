<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>echarts示例演示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="js/echarts.min.js"></script>
  
  <script type="text/javascript" src="easyui/jquery.min.js"></script></head>
  <script type="text/javascript" src="js/sanjiliandong.js"></script>
  <body>
  <!-- <select id="year"><option>2018</option><option>2019</option><option>2017</option></select>
   <select id="month"><option>1</option><option>2</option><option>3</option></select> -->
   	省 <select id="province" value="河南省"style="width:150px;height:30px"></select> 
	市<select id="city" value="郑州市"style="width:150px;height:30px"></select>  
  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
    //js定义数组
     $(function(){
            //默认显示
            getData('河南省','郑州市');
            //月份变化时变化
            $("#province").change(function(){
                getData($("#province").find("option:selected").text(),$("#city").find("option:selected").text());
            });
            $("#city").change(function(){
                getData($("#province").find("option:selected").text(),$("#city").find("option:selected").text());
            });
          });
          function getData(province,city){
	         
          //使用ajax得到数据
	          $.ajax({
	             url:"orderstatistic/ordercharts.do",
	             type:"post",
	             data:{province:province,city:city},
	             dataType:"json",
	             async:false,//同步
	             success:function(data){
	                 var title = [];
	                  var ydata = [];
	                if(data!=''){
	                 for(var i=0;i<data.length;i++){
	                    title.push(data[i].order_now_store);
	                    //alert(title);
	                     ydata.push(data[i].cnt); 
	                    //alert(ydata);
	                 }
	                  showData(title,ydata);
	                }
	             }
	          });
         }
         function showData(title,ydata){
         // 基于准备好的dom，初始化echarts实例
		 var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
        var option = {
            title: {
                text: '门店订单统计'
            },
            tooltip: {},
            legend: {
                data:['门店订单']
            },
            xAxis: {
                data: title
            },
            yAxis: {},
            series: [{
                name: '门店订单',
                type: 'bar',
                data: ydata
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
     }   
    </script>
  </body>
</html>
