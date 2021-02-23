/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2021-01-07 06:26:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

      out.write(' ');
      out.write('\r');
      out.write('\n');

  String userId = (String) session.getAttribute("userId");
  String adminLoginId = (String) session.getAttribute("adminLoginId");
  String errMsg = (String) request.getAttribute("errMsg");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Greserveログインページ</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/head.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"bg-light\">\r\n");
      out.write("<h1>Greserve</h1>\r\n");
      out.write("<div class=\"slider-container\">\r\n");
      out.write("   <ul id=\"slider\" class=\"slider\">\r\n");
      out.write("   \t  <li class=\"slide\"><img src=\"/greserve/img//product_fender01.jpg\" alt=\"\"></li>\r\n");
      out.write("   \t  <li class=\"slide\"><img src=\"/greserve/img//product_rickenbacker01.jpg\" alt=\"\"></li>\r\n");
      out.write("   \t  <li class=\"slide\"><img src=\"/greserve/img//product_gibson01.jpg\" alt=\"\"></li>\r\n");
      out.write("   \t  <li class=\"slide\"><img src=\"/greserve/img//product_mosrite.jpg\" alt=\"\"></li>\r\n");
      out.write("   \t  <li class=\"slide\"><img src=\"/greserve/img//product_gretsch.jpg\" alt=\"\"></li>\r\n");
      out.write("   \t  <li id=\"last_clone\" class=\"slide\"><img src=\"/greserve/img//product_fender01.jpg\" alt=\"\"></li>\r\n");
      out.write("   </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\">\r\n");
 if(userId == null && adminLoginId == null) { 
      out.write("\r\n");
      out.write("<div class=\"form-wrapp\">\r\n");
      out.write("  <form class=\"my-3 form-login\" action= \"/greserve/LoginServlet\" method=\"post\">\r\n");
      out.write("    <div class=\"form-group row\">\r\n");
      out.write("      <label for=\"userId\" class=\"col-sm-3 col-form-label\">ユーザーID :</label>\r\n");
      out.write("      <div class=\"col-sm-9\">\r\n");
      out.write("     \t <input type=\"text\" id=\"userId\" class=\"form-control\" name=\"userId\">\r\n");
      out.write("      </div>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div class=\"form-group row\">\r\n");
      out.write("     <label for=\"password\" class=\"col-sm-3 col-form-label\" >パスワード :</label>\r\n");
      out.write("     <div class=\"col-sm-9\">\r\n");
      out.write("    \t<input type=\"password\" id=\"password\" class=\"form-control\" name=\"pass\">\r\n");
      out.write("     </div>\r\n");
      out.write("   </div>\r\n");
      out.write("    ");
 if(errMsg != null && errMsg.length() > 0 ) { 
      out.write("\r\n");
      out.write("    <p class=\"alert alert-danger in-login\">");
      out.print(errMsg );
      out.write("</p>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    <input class=\"btn btn-success d-block mt-4\" type=\"submit\" value=\"ログイン\">\r\n");
      out.write("  </form>\r\n");
      out.write(" </div>\r\n");
      out.write("  <div class=\"buttons\">\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/Register\">新規会員登録</a></p>\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/Admin\">管理者専用ページ</a></p>\r\n");
      out.write("  </div>\r\n");
}else if(adminLoginId != null && adminLoginId.length() > 0){/*管理者ログイン中*/ 
      out.write("\r\n");
      out.write(" <p class=\"alert alert-success in-login\">管理人：");
      out.print(adminLoginId );
      out.write("さんログイン中</p>\r\n");
      out.write("  <div class=\"buttons\">\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/ProductList\">商品一覧へ</a></p>\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/Admin\">管理者専用ページ</a></p>\r\n");
      out.write("  </div>\r\n");
} else { /*ユーザーログイン中*/
      out.write("\r\n");
      out.write("  <p class=\"alert alert-success in-login\">");
      out.print(userId );
      out.write("さんログイン中</p>\r\n");
      out.write("  <div class=\"buttons\">\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/ProductList\">商品一覧へ</a></p>\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/MemberInfo\">会員情報</a></p>\r\n");
      out.write("   <p><a class=\"btn btn-outline-success mx-auto\" href=\"/greserve/Logout\">ログアウト</a></p>\r\n");
      out.write("  </div>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("window.addEventListener('DOMContentLoaded', () => {\r\n");
      out.write("\tconst slider = document.getElementById('slider');\r\n");
      out.write("\tconst slide = document.querySelectorAll('.slide');\r\n");
      out.write("\tconsole.log(slide.length);\r\n");
      out.write("\r\n");
      out.write("\tlet slideCount = 0;\r\n");
      out.write("\tsetInterval(() => {\r\n");
      out.write("\t\tslideCount++;\r\n");
      out.write("\t\tslider.style.transition = \"transform .5s ease-in-out\";\r\n");
      out.write("\t\tslider.style.transform = \"translateX(-\" + 100 * slideCount + \"%)\";\r\n");
      out.write("\t}, 2000);\r\n");
      out.write("\r\n");
      out.write("\tslider.addEventListener('transitionend', () => {\r\n");
      out.write("\t\tif(slide[slideCount].id === \"last_clone\") {\r\n");
      out.write("\t\t\tslideCount = 0;\r\n");
      out.write("\t\t\tslider.style.transition = \"none\";\r\n");
      out.write("\t\t\tslider.style.transform = \"translateX(0%)\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
