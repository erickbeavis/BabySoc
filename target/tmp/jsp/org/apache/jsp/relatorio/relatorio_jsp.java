/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.7.v20170914
 * Generated at: 2024-08-27 17:33:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.relatorio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relatorio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/Erick/.m2/repository/org/apache/struts/struts2-core/2.5.28.3/struts2-core-2.5.28.3.jar!/META-INF/struts-tags.tld", Long.valueOf(1640856644000L));
    _jspx_dependants.put("/relatorio/../../include/header.jsp", Long.valueOf(1724648459502L));
    _jspx_dependants.put("file:/C:/Users/Erick/.m2/repository/org/apache/struts/struts2-core/2.5.28.3/struts2-core-2.5.28.3.jar", Long.valueOf(1723960020197L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody;

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
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"ISO-8859-1\">\r\n");
      out.write("\t\t<title>");
      if (_jspx_meth_s_005ftext_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\t\t<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"bg-secondary\">\r\n");
      out.write("\t\t");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"/avaliacao/todosExames.action\">Exames</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"/avaliacao/todosFuncionarios.action\">Funcionarios</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"/avaliacao/todosExamesRealizados.action\">Exames Realizados</a>\r\n");
      out.write("      </li>\r\n");
      out.write("            <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"/avaliacao/visualizarRelatorio.action\">Relatorio de Exames Realizados</a>\r\n");
      out.write("      </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div class=\"card mt-5\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"card-title\">Relatorio Exames Realizados por Periodo</h5>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row align-items-center mt-1\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"id\" class=\"col-sm-2 col-form-label text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\tData inicial:\r\n");
      out.write("\t\t\t\t\t\t\t</label>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"data_inicio\" />\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row align-items-center mt-2\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row align-items-center mt-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"id\" class=\"col-sm-2 col-form-label text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\tData Final:\r\n");
      out.write("\t\t\t\t\t\t\t</label>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"data_final\" />\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row align-items-center mt-4\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"card-footer\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn btn-success col-sm-4 offset-sm-1 disabled\" id=\"download_xlsx\">Gerar em Excel</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn btn-primary col-sm-4 offset-sm-1 disabled\" id=\"tela_html\">Gerar em tela</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tconst dataInicio = document.querySelector(\"#data_inicio\");\r\n");
      out.write("\t\t\tconst dataFinal = document.querySelector(\"#data_final\");\r\n");
      out.write("\t\t\tconst linkDownload = document.querySelector(\"#download_xlsx\");\r\n");
      out.write("\t\t\tconst telaHtml = document.querySelector(\"#tela_html\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconst atualizarDataNoLink = () => {\r\n");
      out.write("\t\t\t\tconst dataInicioValor = dataInicio.value;\r\n");
      out.write("\t\t\t\tconst dataFinalValor = dataFinal.value;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tlinkDownload.href = \"/avaliacao/downloadRelatorio.action?relatorioVo.dataInicio=\" + dataInicioValor + \"&relatorioVo.dataFinal=\" + dataFinalValor;\r\n");
      out.write("\t\t\t\ttelaHtml.href = \"/avaliacao/visualizarRelatorio.action?relatorioVo.dataInicio=\" + dataInicioValor + \"&relatorioVo.dataFinal=\" + dataFinalValor;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif (dataInicioValor && dataFinalValor) {\r\n");
      out.write("\t\t\t\t\tlinkDownload.classList.remove(\"disabled\");\r\n");
      out.write("\t\t\t\t\ttelaHtml.classList.remove(\"disabled\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tlinkDownload.classList.add(\"disabled\");\r\n");
      out.write("\t\t\t\t\ttelaHtml.classList.add(\"disabled\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdataFinal.addEventListener(\"change\", atualizarDataNoLink);\r\n");
      out.write("\t\t\tdataInicio.addEventListener(\"change\", atualizarDataNoLink);\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script src=\"webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\t</body>\r\n");
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

  private boolean _jspx_meth_s_005ftext_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f0 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    try {
      _jspx_th_s_005ftext_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005ftext_005f0.setParent(null);
      // /relatorio/relatorio.jsp(7,9) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ftext_005f0.setName("label.titulo.pagina.cadastro");
      int _jspx_eval_s_005ftext_005f0 = _jspx_th_s_005ftext_005f0.doStartTag();
      if (_jspx_th_s_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f0);
    }
    return false;
  }
}
