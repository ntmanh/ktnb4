package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _right extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _right( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/system/right.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */

    try {

      if (_jspx_inited == false) {
        synchronized (this) {
          if (_jspx_inited == false) {
            _jspx_init();
            _jspx_inited = true;
          }
        }
      }

      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);

      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();

      /* Service Method Phase */

      // HTML // begin [file="/system/right.jsp";from=(0,0);to=(12,0)]
        out.write("\r\n<html>\r\n<body>\r\n<script>\r\n alert('B\\u1EA1n kh\\u00F4ng c\\u00F3 quy\\u1EC1n truy c\\u1EADp ch\\u1EE9c n\\u0103ng n\\u00E0y! Vui l\\u00F2ng li\\u00EAn h\\u1EC7 qu\\u1EA3n tr\\u1ECB h\\u1EC7 th\\u1ED1ng!'); \r\n //window.location='home.do';\r\n history.back();\r\n //history.go(-1);\r\n</script>\r\n</body>\r\n</html>\r\n\r\n");

      // end

    } catch (Throwable t) {
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      while (_jspxTagObjects.empty() == false){
        ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
      }
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);

      /* Service Finally Phase */
    }
  }
  public static String[][] _jspx_debug_FileMapping = {
  {
  "/system/right.jsp", 
  },
  {
  "0", 
  },
  };
  public static String[][] _jspx_debug_LineMapping = {
  {
  "0", 
  },
  {
  "1", 
  },
  };
}
