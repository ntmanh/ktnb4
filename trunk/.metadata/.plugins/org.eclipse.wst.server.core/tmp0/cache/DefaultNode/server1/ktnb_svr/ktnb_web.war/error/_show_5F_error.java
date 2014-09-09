package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _show_5F_error extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _show_5F_error( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/error/show_error.jsp";

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

        // HTML // begin [file="/error/show_error.jsp";from=(0,31);to=(1,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/error/show_error.jsp";from=(1,50);to=(2,0)]
          out.write(" \r\n");

        // end
        // HTML // begin [file="/error/show_error.jsp";from=(2,58);to=(6,45)]
          out.write("\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n<LINK rel=\"stylesheet\" type=\"text/css\" HREF=\"");

        // end
        // ##DEBUG## ##TAGLIB## "/error/show_error.jsp" 7,45-"/error/show_error.jsp" 7,88  LineMapIndex:1
          _jspx_th_html_rewrite_0.setPageContext(pageContext);
          _jspx_th_html_rewrite_0.setParent(null);
          _jspx_th_html_rewrite_0.setPage("/stylesheet/ktnb.css");
          _jspxTagObjects.push(_jspx_th_html_rewrite_0);
            int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
          // end
          // ##DEBUG## "/error/show_error.jsp" 7,45-"/error/show_error.jsp" 7,88  LineMapIndex:2
            if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/error/show_error.jsp";from=(6,88);to=(8,0)]
          out.write("\">\r\n</head>\r\n");

        // end
        // ##DEBUG## ##SCRIPTLET## "/error/show_error.jsp" 9,2-"/error/show_error.jsp" 25,0  LineMapIndex:3
          
            String errCode=(String) request.getParameter("errCode"); 
            if(errCode==null ||(errCode!=null && errCode.equals("null")))
            {
            	errCode ="Có lỗi xảy ra trong quá trình thực hiện nghiệp vụ!";
            }
            String errCodeCause=(String) request.getParameter("errCodeCause"); 
            if(errCodeCause==null ||(errCodeCause!=null && errCodeCause.equals("null")))
            {
            	errCodeCause ="Kiểm tra dữ liệu đầu vào hoặc đường truyền dữ liệu.";
            }
            String errCodeAction=(String) request.getParameter("errCodeAction"); 
            if(errCodeAction==null ||(errCodeAction!=null && errCodeAction.equals("null")))
            {
            	errCodeAction ="Vui lòng thông báo cho quản trị hệ thống!";
            }
        // end
        // HTML // begin [file="/error/show_error.jsp";from=(24,2);to=(31,34)]
          out.write("\r\n<body bgcolor=\"#D4D0C8\">\r\n<center>\r\n<h3>Thông báo!</h3>\r\n<table align=\"center\" border=\"0\" cellpadding=\"3\" cellspacing=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\" width=\"30%\"><b>Vấn đề :</b></td>\r\n    <td align=\"left\"  width=\"70%\">");

        // end
        // ##DEBUG## "/error/show_error.jsp" 32,37-"/error/show_error.jsp" 32,44  LineMapIndex:20
          out.print(errCode);
        // end
        // HTML // begin [file="/error/show_error.jsp";from=(31,46);to=(35,34)]
          out.write(" </td>\r\n  </tr>  \r\n   <tr>\r\n    <td align=\"right\" width=\"30%\"><b>Giải pháp :</b></td>\r\n    <td align=\"left\"  width=\"70%\">");

        // end
        // ##DEBUG## "/error/show_error.jsp" 36,37-"/error/show_error.jsp" 36,50  LineMapIndex:21
          out.print(errCodeAction);
        // end
        // HTML // begin [file="/error/show_error.jsp";from=(35,52);to=(46,0)]
          out.write(" </td>\r\n  </tr> \r\n  <tr>\r\n      <td colspan=\"2\" align=\"center\">\r\n          <input type=\"button\" value=\"Quay lại\" onClick=\"javascript:window.close();\" class=\"button\">\r\n      </td>\r\n    </tr>\r\n </table>\r\n</center>\r\n</body>\r\n</html>\r\n");

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
    "/error/show_error.jsp", 
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
    "7", 
    "9", 
    "10", 
    "11", 
    "12", 
    "13", 
    "14", 
    "15", 
    "16", 
    "17", 
    "18", 
    "19", 
    "20", 
    "21", 
    "22", 
    "23", 
    "24", 
    "25", 
    "32", 
    "36", 
    },
    };
  }
