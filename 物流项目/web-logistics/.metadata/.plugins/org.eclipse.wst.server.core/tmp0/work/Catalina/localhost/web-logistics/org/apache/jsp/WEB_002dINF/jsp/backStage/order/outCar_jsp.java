/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2019-05-23 07:24:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.backStage.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class outCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/resource/common.jsp", Long.valueOf(1540886756000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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
      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery-2.1.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/bootstrap.min.css\" type=\"text/css\"></link>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'assembleOrder.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.title{\r\n");
      out.write("\t\t\tcolor: black;\r\n");
      out.write("\t\t\tfont-size: 25px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttable{\r\n");
      out.write("\t\t\ttext-align: center;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttable th{\r\n");
      out.write("\t\t\ttext-align: center;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#append{\r\n");
      out.write("\t\t\twidth:550px;\r\n");
      out.write("\t\t\tlist-style:none;\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t\t#btnul{\r\n");
      out.write("  \t\t\tpadding-left:220px;\r\n");
      out.write("  \t\t}\r\n");
      out.write("  </style>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \t\t//出库按钮\r\n");
      out.write("\tfunction outKu(t,tt){\r\n");
      out.write("\t\tif(tt==0){\r\n");
      out.write("\t\t\talert(\"该车没有订单，不能出库！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//alert(t);\r\n");
      out.write("\t\t$.post(\r\n");
      out.write(" \t\t\t//url\r\n");
      out.write(" \t\t\t\"autoOrder/outKu.do\",\r\n");
      out.write(" \t\t\t//携带参数\r\n");
      out.write(" \t\t\t{carNumber:t},\r\n");
      out.write(" \t\t\t//回调函数\r\n");
      out.write(" \t\t\tfunction(date){\r\n");
      out.write(" \t\t\t\t//alert(date.msg);\r\n");
      out.write(" \t\t\t\tif(date.msg==\"1\"){\r\n");
      out.write(" \t\t\t\t\talert(\"出库成功！\");\r\n");
      out.write(" \t\t\t\t\twindow.location.reload();\r\n");
      out.write(" \t\t\t\t} else {\r\n");
      out.write(" \t\t\t\t\talert(\"出库失败！\");\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t},\r\n");
      out.write(" \t\t\t//数据类型\r\n");
      out.write(" \t\t\t\"json\"\r\n");
      out.write(" \t\t);\r\n");
      out.write("\t}\r\n");
      out.write("\t//通过车牌号查看该车的订单\r\n");
      out.write("\tfunction inCarOrder(t){\r\n");
      out.write("\t\t//alert(t);\r\n");
      out.write("\t\t$.post(\r\n");
      out.write(" \t\t\t//url\r\n");
      out.write(" \t\t\t\"autoOrder/inCarOrder.do\",\r\n");
      out.write(" \t\t\t//携带参数\r\n");
      out.write(" \t\t\t{carNumber:t},\r\n");
      out.write(" \t\t\t//数据类型\r\n");
      out.write(" \t\t\t\"json\"\r\n");
      out.write(" \t\t);\r\n");
      out.write("\t}\r\n");
      out.write("\t//判断订单数是否为空的车辆不能进入详情页面（在controller中控制）\r\n");
      out.write("\tfunction checkOrderCount(t){\r\n");
      out.write("\t\tif(t==0){\r\n");
      out.write("\t\t\talert(\"该车辆的订单数为空，不能查看详情！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//页面上的删除按钮\r\n");
      out.write("\tfunction outAuto(cn,oc){\r\n");
      out.write("\t\t//alert(oc);\r\n");
      out.write("\t\t$.post(\r\n");
      out.write(" \t\t\t//url\r\n");
      out.write(" \t\t\t\"autoOrder/delAutoSuccCar.do\",\r\n");
      out.write(" \t\t\t//携带参数\r\n");
      out.write(" \t\t\t{carNumber:cn,orderCount:oc},\r\n");
      out.write(" \t\t\t//回调函数\r\n");
      out.write(" \t\t\tfunction(date){\r\n");
      out.write(" \t\t\t\t//alert(date.msg);\r\n");
      out.write(" \t\t\t\tif(date.msg==\"1\"){\r\n");
      out.write(" \t\t\t\t\talert(\"删除成功！\");\r\n");
      out.write(" \t\t\t\t\twindow.location.reload();\r\n");
      out.write(" \t\t\t\t} else {\r\n");
      out.write(" \t\t\t\t\talert(\"删除失败！\");\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t},\r\n");
      out.write(" \t\t\t//数据类型\r\n");
      out.write(" \t\t\t\"json\"\r\n");
      out.write(" \t\t);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction overStoreOrder(cn,oc){\r\n");
      out.write("\t\t$.post(\r\n");
      out.write(" \t\t\t//url\r\n");
      out.write(" \t\t\t\"autoOrder/overStoreOrder.do\",\r\n");
      out.write(" \t\t\t//携带参数\r\n");
      out.write(" \t\t\t{carNumber:cn,orderCount:oc},\r\n");
      out.write(" \t\t\t//回调函数\r\n");
      out.write(" \t\t\tfunction(date){\r\n");
      out.write(" \t\t\t\t//alert(date.msg);\r\n");
      out.write(" \t\t\t\tif(date.msg==\"1\"){\r\n");
      out.write(" \t\t\t\t\talert(\"到达目的地！\");\r\n");
      out.write(" \t\t\t\t\twindow.location.reload();\r\n");
      out.write(" \t\t\t\t} else {\r\n");
      out.write(" \t\t\t\t\talert(\"确认失败！\");\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t},\r\n");
      out.write(" \t\t\t//数据类型\r\n");
      out.write(" \t\t\t\"json\"\r\n");
      out.write(" \t\t);\r\n");
      out.write("\t}\r\n");
      out.write("  </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  \t<table class=\"table table-hover\">\r\n");
      out.write("\t\t<caption style=\"text-align: right;width: 53%\" class=\"title\">装配管理</caption>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <th>序号</th>\r\n");
      out.write("\t\t\t    <th>车辆类型</th>\r\n");
      out.write("\t\t\t    <th>车牌号</th>\r\n");
      out.write("\t\t\t    <th>司机</th>\r\n");
      out.write("\t\t\t    <th>下一站门店</th>\r\n");
      out.write("\t\t\t    <th>订单数</th>\r\n");
      out.write("\t\t\t    <th>预计出发时间</th>\r\n");
      out.write("\t\t\t    <th>预计到达时间</th>\r\n");
      out.write("\t\t\t    <th>状态</th>\r\n");
      out.write("\t\t\t    <th>装配操作</th>\r\n");
      out.write("\t\t\t </tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t <tr><td colspan=\"10\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td></tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/jsp/backStage/order/outCar.jsp(147,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/backStage/order/outCar.jsp(147,3) '${orderList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${orderList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/backStage/order/outCar.jsp(147,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("order");
      // /WEB-INF/jsp/backStage/order/outCar.jsp(147,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("i");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t<tr>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write(" </td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.car_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.driver}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.next_store}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.depart_time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.arrive_time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.auto_status}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t<td>\r\n");
            out.write("\t\t\t\t\t\t<a href=\"autoOrder/inCarOrder.do?carNumber=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.car_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("&orderCount=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\"><input type=\"button\" value=\"详情\" onclick=\"checkOrderCount('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("')\"></a>\r\n");
            out.write("\t\t\t\t\t\t<input type=\"button\" value=\"出库\" onclick=\"outKu('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.car_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('\'');
            out.write(',');
            out.write('\'');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("')\" >\r\n");
            out.write("\t\t\t\t\t\t<input type=\"button\" value=\"删除\" onclick=\"outAuto('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.car_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('\'');
            out.write(',');
            out.write('\'');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("')\">\r\n");
            out.write("\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t</tr>\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
