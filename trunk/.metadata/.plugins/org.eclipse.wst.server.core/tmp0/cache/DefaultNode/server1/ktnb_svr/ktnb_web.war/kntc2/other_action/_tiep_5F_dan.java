package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _tiep_5F_dan extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _tiep_5F_dan( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/kntc2/other_action/tiep_dan.jsp";

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);

      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();

      /* Service Method Phase */

      // HTML // begin [file="/kntc2/other_action/tiep_dan.jsp";from=(0,31);to=(11,17)]
        out.write("\r\n<fieldset style=\"\"><legend>Xử lý phụ</legend>\r\n\t<table width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"50%\"><a href=\"kntc_tim_kiem.do?method=show&action=bosungHS\">Bổ sung hồ sơ, tài liệu</a></td>\r\n\t\t\t<td><a href=\"kntc_tim_kiem.do?method=show&action=suaHSTD\">Sửa sổ tiếp dân</a></td>\r\n\t\t</tr>\r\n\t</table>\r\n</fieldset>\r\n<script language=\"javascript\">\r\nfunction openBm2(link){\r\n\t\tlink = link + '");

      // end
      // ##DEBUG## "/kntc2/other_action/tiep_dan.jsp" 12,20-"/kntc2/other_action/tiep_dan.jsp" 12,46  LineMapIndex:1
        out.print(request.getParameter("id"));
      // end
      // HTML // begin [file="/kntc2/other_action/tiep_dan.jsp";from=(11,48);to=(12,11)]
        out.write("';\r\n\t\tvar r = '");

      // end
      // ##DEBUG## "/kntc2/other_action/tiep_dan.jsp" 13,14-"/kntc2/other_action/tiep_dan.jsp" 13,39  LineMapIndex:2
        out.print(request.getParameter("r"));
      // end
      // HTML // begin [file="/kntc2/other_action/tiep_dan.jsp";from=(12,41);to=(16,9)]
        out.write("';\r\n\t\tif(r=='rol') link = link +'&r=rol';\r\n\t\topenWindow(link,800,600,false);\r\n\t}\r\n</script>");

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
  "/kntc2/other_action/tiep_dan.jsp", 
  },
  {
  "0", 
  },
  };
  public static String[][] _jspx_debug_LineMapping = {
  {
  "0", 
  "0", 
  "0", 
  },
  {
  "1", 
  "12", 
  "13", 
  },
  };
}
