package org.apache.jsp;

import cmc.com.ktnb.util.URLUTF8Encoder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _error extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _error( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/error/error.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    Throwable exception = (Throwable) request.getAttribute("javax.servlet.jsp.jspException");
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */
      /* ------  html:rewrite ------ */
      org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_0 = new org.apache.struts.taglib.html.RewriteTag();

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
        response.setContentType("text/html; charset=UTF-8");
        pageContext = _jspxFactory.getPageContext(this, request, response,
        			"", true, 8192, true);

        application = pageContext.getServletContext();
        config = pageContext.getServletConfig();
        session = pageContext.getSession();
        out = pageContext.getOut();

        /* Service Method Phase */

        // HTML // begin [file="/error/error.jsp";from=(0,31);to=(1,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/error/error.jsp";from=(1,68);to=(2,0)]
          out.write(" \r\n");

        // end
        // HTML // begin [file="/error/error.jsp";from=(2,58);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/error/error.jsp";from=(3,51);to=(6,0)]
          out.write("\r\n<html>\r\n<body>\r\n");

        // end
        // ##DEBUG## ##SCRIPTLET## "/error/error.jsp" 7,2-"/error/error.jsp" 11,0  LineMapIndex:1
          
            String errCode= URLUTF8Encoder.encode((String)  request.getAttribute("errCode")); 
            String errCodeCause = URLUTF8Encoder.encode((String)request.getAttribute("errCodeCause"));
            String errCodeAction = URLUTF8Encoder.encode((String)request.getAttribute("errCodeAction"));
        // end
        // HTML // begin [file="/error/error.jsp";from=(10,2);to=(12,28)]
          out.write("\r\n<script language=\"javascript\">\r\n    window.showModalDialog(\"");

        // end
        // ##DEBUG## ##TAGLIB## "/error/error.jsp" 13,28-"/error/error.jsp" 13,72  LineMapIndex:6
          _jspx_th_html_rewrite_0.setPageContext(pageContext);
          _jspx_th_html_rewrite_0.setParent(null);
          _jspx_th_html_rewrite_0.setPage("/error/show_error.jsp");
          _jspxTagObjects.push(_jspx_th_html_rewrite_0);
            int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
          // end
          // ##DEBUG## "/error/error.jsp" 13,28-"/error/error.jsp" 13,72  LineMapIndex:7
            if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/error/error.jsp";from=(12,72);to=(12,81)]
          out.write("?errCode=");

        // end
        // ##DEBUG## "/error/error.jsp" 13,84-"/error/error.jsp" 13,91  LineMapIndex:8
          out.print(errCode);
        // end
        // HTML // begin [file="/error/error.jsp";from=(12,93);to=(12,107)]
          out.write("&errCodeCause=");

        // end
        // ##DEBUG## "/error/error.jsp" 13,110-"/error/error.jsp" 13,122  LineMapIndex:9
          out.print(errCodeCause);
        // end
        // HTML // begin [file="/error/error.jsp";from=(12,124);to=(12,139)]
          out.write("&errCodeAction=");

        // end
        // ##DEBUG## "/error/error.jsp" 13,142-"/error/error.jsp" 13,155  LineMapIndex:10
          out.print(errCodeAction);
        // end
        // HTML // begin [file="/error/error.jsp";from=(12,157);to=(18,0)]
          out.write("\",\"\",\"dialogHeight:200px;dialogWidth:450 px;status:no;\");\r\n    history.back();\r\n</script>\r\n</body>\r\n</html>\r\n\r\n");

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
    "/error/error.jsp", 
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
    "0", 
    "0", 
    "0", 
    "0", 
    "0", 
    "0", 
    "0", 
    "0", 
    },
    {
    "1", 
    "7", 
    "8", 
    "9", 
    "10", 
    "11", 
    "13", 
    "13", 
    "13", 
    "13", 
    "13", 
    },
    };
  }
