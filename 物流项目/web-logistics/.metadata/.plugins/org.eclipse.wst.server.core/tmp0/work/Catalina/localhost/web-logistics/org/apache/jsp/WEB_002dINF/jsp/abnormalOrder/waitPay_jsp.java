/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2019-05-23 07:25:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.abnormalOrder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class waitPay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'waitRepairCar.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"easyui/themes/default/easyui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"easyui/themes/icon.css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"easyui/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <table id=\"tt\"  class=\"easyui-datagrid\" title=\"待赔付订单信息\" style=\"width:100%;height:100%\"\r\n");
      out.write("\t\tpagination=\"true\" fitColumns=\"true\" toolbar=\"#tb\" rownumbers=\"true\" data-options=\"singleSelect:true,collapsible:true,\r\n");
      out.write("\t\turl:'bad/allBadOrder.do?state='+3,method:'post'\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_mailnum',width:80,align:'center'\">邮寄单号</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_time',width:80,align:'center'\">订单时间</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_name',width:80,align:'center'\">货物类型</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'badorder_insure',width:80,align:'center'\" formatter=\"formatBadorder_insure\">是否保价</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'badorder_price',width:150,align:'center'\">保价金额</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_money',width:60,align:'center'\">货物总值</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_freight',width:60,align:'center'\">运费金额</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'badorder_pay',width:150,align:'center'\">赔付金额</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'badorder_type',width:60,align:'center'\" formatter=\"formatBadorder_type\">异常类型</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'order_state',width:60,align:'center'\" formatter=\"formatOrder_state\">当前状态</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'operation',width:80,align:'center'\" formatter=\"formatOperation\">操作</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"tb\" style=\"padding:3px\">\r\n");
      out.write("\t\t\t<span>订单号</span>\r\n");
      out.write("\t\t\t<input id=\"order_mailnum\" style=\"line-height:26px;border:1px solid #ccc\">\r\n");
      out.write("\t\t\t<a   class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doSearch()\">查询</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"dlgg\" class=\"easyui-dialog\" style=\"width:400px;height:400px;padding:10px 5px\"\r\n");
      out.write("\t\tclosed=\"true\"  buttons=\"#dlgg-buttons\">\r\n");
      out.write("\t\t<form id=\"fm\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"fitem\">\r\n");
      out.write("\t\t\t\t\t<label>邮寄单号:</label> <br>\r\n");
      out.write("\t\t\t\t\t  <input  name=\"order_mailnum\" class=\"easyui-validatebox\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fitem\">\r\n");
      out.write("\t\t\t\t\t<label>赔付金额:</label><br>\r\n");
      out.write("\t\t\t\t\t<input  name=\"badorder_pay\" class=\"easyui-validatebox\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div >\r\n");
      out.write("\t\t\t\t\t<label>赔付方式:</label><br>\r\n");
      out.write("\t\t\t\t<!-- \t<input  name=\"badpay_type\" class=\"easyui-validatebox\" required=\"true\"> -->\r\n");
      out.write("\t\t\t\t\t<select  name=\"badpay_type\" class=\"easyui-combobox\" >\r\n");
      out.write("\t    \t\t\t\t<option value=\"0\" >现金</option>\r\n");
      out.write("\t    \t\t\t\t<option value=\"1\">银行卡</option>\r\n");
      out.write("\t    \t\t\t\t<option value=\"2\">手机支付</option>\r\n");
      out.write("\t    \t\t\t\t<option value=\"3\">其他</option>\r\n");
      out.write("    \t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fitem\">\r\n");
      out.write("\t\t\t\t\t<label>收款人:</label><br>\r\n");
      out.write("\t\t\t\t\t<input  name=\"payeeName\" class=\"easyui-validatebox\" required=\"true\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fitem\">\r\n");
      out.write("\t\t\t\t\t<label>收款账号:</label><br>\r\n");
      out.write("\t\t\t\t\t<input  name=\"payeeNo\" class=\"easyui-validatebox\" required=\"true\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"fitem\">\r\n");
      out.write("\t\t\t\t\t<label>备注</label><br>\r\n");
      out.write("\t\t\t\t\t\t<textarea name=\"remark\" style=\"width:200px;height:80px;\" class=\"easyui-validatebox\" ></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"dlgg-buttons\">\r\n");
      out.write("\t\t\t<a   class=\"easyui-linkbutton\" iconCls=\"icon-ok\" onclick=\"saveUser()\"> 提交</a>\r\n");
      out.write("\t\t\t<a   class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" onclick=\"javascript:$('#dlgg').dialog('close')\">取消</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("       //操作中的驳回与通过\r\n");
      out.write("\tfunction formatOperation(val,row,index){\r\n");
      out.write("\t\t //var rows = JSON.stringify(row);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\treturn '<input id=\"qrpf\"  type=\"button\"  value=\"确认赔付\" onclick=\"pay(\\''+row.badorder_id+'\\')\">';\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t//显示订单是否保价\r\n");
      out.write("\tfunction formatBadorder_insure(val,row){ //val 当前列的值 row去当前行的值\r\n");
      out.write("\t\tif(val==0){\r\n");
      out.write("\t\t\treturn \"否\";\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\treturn \"是\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//显示异常类型\r\n");
      out.write("\tfunction formatBadorder_type(val,row){//val 当前列的值 row去当前行的值\r\n");
      out.write("\t\tif(val==0){\r\n");
      out.write("\t\t\treturn \"货品破损\";\r\n");
      out.write("\t\t}else if(val==1){\r\n");
      out.write("\t\t\treturn \"货品丢失\";\r\n");
      out.write("\t\t}else if(val==1){\r\n");
      out.write("\t\t\treturn \"延期到达\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn \"其他\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//显示异常单状态\r\n");
      out.write("\tfunction formatOrder_state(val,row){//val 当前列的值 row去当前行的值\r\n");
      out.write("\t\tif(val==0){\r\n");
      out.write("\t\t\treturn \"待审核\";\r\n");
      out.write("\t\t}else if(val==1){\r\n");
      out.write("\t\t\treturn \"未通过\";\r\n");
      out.write("\t\t}else if(val==2){\r\n");
      out.write("\t\t\treturn \"待复核\";\r\n");
      out.write("\t\t}else if(val==3){\r\n");
      out.write("\t\t\treturn \"待赔付\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn \"已赔付\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//给自动生成的序号列加标题\r\n");
      out.write("\t\t $(function () {\r\n");
      out.write("            $('#tt').closest('div.datagrid-view').find('div.datagrid-header-rownumber').html('编号');\r\n");
      out.write("        })\r\n");
      out.write("\t\t/* //获取行号\r\n");
      out.write("\t\t$.extend($.fn.datagrid.methods, {  \r\n");
      out.write("        getRowNum:function(jq){  \r\n");
      out.write("            var opts=$.data(jq[0],\"datagrid\").options;  \r\n");
      out.write("            var array = new Array();  \r\n");
      out.write("            opts.finder.getTr(jq[0],\"\",\"selected\",1).each(function(){  \r\n");
      out.write("                array.push($(this).find(\"td.datagrid-td-rownumber\").text());  \r\n");
      out.write("            });  \r\n");
      out.write("            return array.join(\",\");  \r\n");
      out.write("        }  \r\n");
      out.write("    });   */\r\n");
      out.write("\t\t//查询方法\r\n");
      out.write("\t\t  function doSearch(){\r\n");
      out.write("\t\t\t\t$('#tt').datagrid('load',{\r\n");
      out.write("\t\t\t\t\torder_mailnum: $('#order_mailnum').val()\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t //确认赔付\r\n");
      out.write("\t\t function pay(id){\r\n");
      out.write("\t\t\t$('#dlgg').window('center');\r\n");
      out.write("\t\t\t$('#fm').form('load',\"bad/getAllBad.do?badorder_id=\"+id);\r\n");
      out.write("\t\t\t$('#dlgg').dialog('open').dialog('setTitle','赔付详情');\r\n");
      out.write("\t\t\t$('#fm').form('clear');\r\n");
      out.write("\t\t\turl = \"bad/update.do?badorder_id=\"+id+\"&val=\"+5;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\t//保存操作\r\n");
      out.write("\t\tfunction saveUser(){\r\n");
      out.write("\t\t\t$('#fm').form('submit',{  //给form表单绑定submit事件\r\n");
      out.write("\t\t\t\turl: url,//请求URL地址\r\n");
      out.write("\t\t\t\tonSubmit: function(){//对form表单校验\r\n");
      out.write("\t\t\t\t\treturn $(this).form('validate');\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(result){//数据保存后的回调函数\r\n");
      out.write("\t\t\t\t\tvar result = eval('('+result+')');//eval把json字符串转换为json对象\r\n");
      out.write("\t\t\t\t\t//alert(result.errorMsg);\r\n");
      out.write("\t\t\t\t\tif (result.msg){//判断，如果错误信息不为空\r\n");
      out.write("\t\t\t\t\t\t$.messager.show({//easyUI封装的浏览器右下角弹框\r\n");
      out.write("\t\t\t\t\t\t\ttitle: '提示信息',//弹框标题\r\n");
      out.write("\t\t\t\t\t\t\tmsg: result.msg//提示信息\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\tif(result.msg=='提交成功') {\r\n");
      out.write("\t\t\t\t\t\t$('#dlgg').dialog('close');\t\t// 关闭弹出框\r\n");
      out.write("\t\t\t\t\t\t$('#tt').datagrid('reload');\t// 刷新父窗口\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
