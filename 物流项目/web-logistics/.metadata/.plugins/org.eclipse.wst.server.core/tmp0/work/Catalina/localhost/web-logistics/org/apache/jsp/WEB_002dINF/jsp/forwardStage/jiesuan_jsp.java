/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2019-05-23 07:21:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.forwardStage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class jiesuan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

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
      out.write("    <title>马六甲物流有限公司</title>\r\n");
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
      out.write("\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=1200,user-scalable=yes\"><!--最大宽度1200px 允许用户缩放-->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\" tppabs=\"http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/bootstrap.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tf.css\" tppabs=\"http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/tf.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" tppabs=\"http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/css/style1.css\" />\t\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\">\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t</script>\r\n");
      out.write("  \t<style type=\"text/css\">\r\n");
      out.write("  \t\t.num{\r\n");
      out.write("  \t\t\tcolor:blue;\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t\t#zi{\r\n");
      out.write("  \t\t\tcolor:green;\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, true);
      out.write("\r\n");
      out.write("    <form action=\"forward/index.do\" method=\"post\">\t\t\r\n");
      out.write("\t\t<div class=\"about-us\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cebian\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"imgs/ww.png\" tppabs=\"http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/images/ww.png\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h2>结算界面</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>ORDERED</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ab-cebian\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cebian-lianxi\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><strong>全国服务热线 :</strong></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div><span>0512-57995109</span></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div><strong>TEL:</strong>0512-57995109</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div><strong>QQ:</strong>1927732720</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"bread-xie\" id=\"zi\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"forward/index.do\" tppabs=\"http://www.17sucai.com/preview/850167/2017-12-22/kunshanwuliu/index.jsp\">首页</a>>>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"forward/xiadan.do\">网上下单</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\t\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "bottom.jsp", out, true);
      out.write("\r\n");
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
      // /WEB-INF/jsp/forwardStage/jiesuan.jsp(71,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/forwardStage/jiesuan.jsp(71,5) '${orderList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${orderList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/forwardStage/jiesuan.jsp(71,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("order");
      // /WEB-INF/jsp/forwardStage/jiesuan.jsp(71,5) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("i");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t<div class=\"about-jianjie clearfix\">\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">订单号<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.order_mailnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">费用<span>亲！这个价格合情合理^_^</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.goods_cost}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">发货人姓名<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.sender_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">发货人手机号码<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.sender_phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">收货人姓名<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.accepter_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">收货人手机号码<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.accepter_phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"num\">收货详细地址<span>*</span></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"\" id=\"\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.accepter_adr}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div><span></span></div>\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\" style=\"text-align: center;\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"返回首页\"/>\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
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
