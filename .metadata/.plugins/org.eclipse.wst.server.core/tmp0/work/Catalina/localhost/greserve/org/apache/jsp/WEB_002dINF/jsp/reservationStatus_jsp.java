/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2021-01-07 05:53:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Reservation;
import java.util.List;
import java.util.ArrayList;

public final class reservationStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.Reservation");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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

	List<Reservation> reservationList = (List<Reservation>) session.getAttribute("reservationList");
	String contextPath = request.getContextPath().toString();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>予約状況確認</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/head.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"adminscreen\">\r\n");
      out.write("<h1>予約状況確認</h1>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
 if(reservationList == null || reservationList.size() == 0) { 
      out.write("\r\n");
      out.write("<p class=\"notreserve text-center\">予約はありません</p>\r\n");
 } else { 
      out.write("\r\n");
      out.write("  <!--  <div class=\"reservation-status\">-->\r\n");
      out.write("  <div class=\"card-deck row mb-5\">\r\n");
      out.write("  ");
 for(Reservation reserve : reservationList) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div class=\"card col-6\">\r\n");
      out.write("    <img class=\"card-img-top mt-2\" src=\"");
      out.print(contextPath );
      out.write("/img/");
      out.print(reserve.getImgfileNm() );
      out.write("\" alt=\"\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <ul>\r\n");
      out.write("          <li class=\"card-title text-warning\"><u>購入者ID：");
      out.print( reserve.getUserId() );
      out.write("</u></li>\r\n");
      out.write("    \t  <li class=\"card-text\">型番：");
      out.print( reserve.getProductId() );
      out.write("</li>\r\n");
      out.write("    \t  <li class=\"card-text\">品名：");
      out.print( reserve.getProductNm() );
      out.write("</li>\r\n");
      out.write("    \t  <li class=\"card-text\">メーカー：");
      out.print( reserve.getMakerNm() );
      out.write("</li>\r\n");
      out.write("    \t  <li class=\"card-text\">価格：");
      out.print(String.format("%,d", reserve.getPrice()) );
      out.write(" 円</li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  ");
} 
      out.write("\r\n");
      out.write("  </div>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div class=\"buttons\">\r\n");
      out.write("    <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/ProductList\">商品一覧へ</a></p>\r\n");
      out.write("\t<p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/Admin\">管理画面トップへ</a></p>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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